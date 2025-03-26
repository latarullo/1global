package br.com.project;

import java.util.LinkedList;
import java.util.Optional;

public class QueueManager {
	
	private LinkedList<QueueData> memoryQueue = new LinkedList<QueueData>();
	
	public QueueData getMessage(){
		int priority = 0;
		return getMessage(priority);
	}
	
    public QueueData getMessage(int priority){
    	if (memoryQueue.isEmpty()){
    		return null;
    	}

    	QueueData returnValue = null;
    	
    	Optional<QueueData> optional = memoryQueue.stream().filter(queueData -> queueData.getPriorityLevel() == priority).findFirst();
    	
    	if (optional.isPresent()) {
    		returnValue = optional.get();
    		memoryQueue.remove(returnValue);
    	}
    	else {
    		returnValue = getMessage(nextPriorityLevel(priority));
    	}
    	return returnValue;
    }

	private int nextPriorityLevel(int priority) {
		return (priority + 1) % QueueData.MAX_PRIORITY_SIZE;
	}
    
	public void addMessage(QueueData queueData) {
    	memoryQueue.add(queueData);
	}
	
	public void printMemoryQueue() {
		System.out.println(String.format("QueueManager - memoryQueue content: %s", memoryQueue));
	}
}
