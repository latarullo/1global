package br.com.project;

public class QueueData {
	private String data;
	private int priorityLevel;
	public static int MAX_PRIORITY_SIZE = 3;

	public QueueData(String data, int priorityLevel) {
		super();
		this.data = data;
		this.priorityLevel = priorityLevel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	@Override
	public String toString() {
		return "QueueData [data=" + data + ", priorityLevel=" + priorityLevel + "]";
	}
}
