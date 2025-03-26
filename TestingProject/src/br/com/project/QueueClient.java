package br.com.project;

class QueueClient extends Thread {
	private QueueManager queueManager;
	private int sleepDuration = 100;
	private boolean debug = false;

	public QueueClient(QueueManager queueManager) {
		super();
		this.queueManager = queueManager;
	}

	@Override
	public void run() {
		while (true) {
			QueueData queueData = queueManager.getMessage();
			if (queueData != null)
			System.out.println(String.format("Message read %s", queueData));

			try {
				if (debug) System.out.println("sleeping for " + sleepDuration);
				Thread.sleep(sleepDuration);
				if (debug) System.out.println("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}