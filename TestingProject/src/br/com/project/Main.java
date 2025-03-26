package br.com.project;

import java.util.Random;

public class Main {

	/*
	 * STEP1: Your primary goal is to develop a basic task queue system that
	 * processes strings. For now processing can be just printing the string The
	 * queue tasks must be continuously consumed The system should be in-memory and
	 * within a single process The tasks should be processed in FIFO order
	 * 
	 * STEP2: Extend the functionality by implementing a priority system for tasks.
	 * only process P1 events if no P0 events are left to process P0 > P1 > P2 > Pn
	 * Assume first 3 priority levels If two tasks in the system have the same
	 * priority, the system should process them in FIFO order -
	 */
	public static void main(String[] args) {
		QueueManager queueManager = new QueueManager();

		System.out.println(" ------- Adding messages to queueManager...");

		addMesagesToQueue(queueManager);

		System.out.println(" ------- QueueManager content...");

		queueManager.printMemoryQueue();

		System.out.println(" ------- Consuming queue with client...");

		QueueClient queueClient = new QueueClient(queueManager);
		queueClient.start();
	}

	private static void addMesagesToQueue(QueueManager queueManager) {
		Random r = new Random();
		for (int i = 0; i <= 10; i++) {
			int priorotyLevel = r.nextInt(0, QueueData.MAX_PRIORITY_SIZE);
			QueueData message = new QueueData(String.format("Testing message %d", i), priorotyLevel);
			queueManager.addMessage(message);
		}
	}
}
