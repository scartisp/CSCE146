//Simion Cartis
public class ProcessScheduler {
	QueueI<Process> processes;
	Process currentP;

	public ProcessScheduler() {
		processes = new LLQueue<>();
		currentP = null;
	}

	public Process getCurrentProcess() {
		return currentP;
	}

	public void addProcess(Process aP) {
		if (currentP == null) { // if the current process is null, it knows that this point needs
			currentP = aP;// to be changed with the next input
		} else
			processes.enqueue(aP);
	}

	public void runNextProcess() {
		if (currentP.getCompletionTime() == 0)// when this method is called, it checks to see if the current item,
			currentP = processes.dequeue();// has time 0. If it does, it moves that first item out of the queue and puts it
	}// into currentP

	public void cancelCurrentProcess() {
		if (currentP != null)
			currentP = processes.dequeue();
	}

	public void printProcessQueue() {
		processes.print();
	}
}
