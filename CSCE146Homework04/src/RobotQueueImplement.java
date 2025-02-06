//Simion Cartis
public class RobotQueueImplement {
	QueueI<Moves> moveSet;
	Moves currentMove;

	public RobotQueueImplement() {
		moveSet = new LLQueue<>();
		currentMove = null;
	}

	public void addMove(Moves aM) {
			moveSet.enqueue(aM);
	}
	public void runNext() {
		currentMove = moveSet.dequeue();
	}
	public Moves getCurrentM() {
		return currentMove;
	}
	public void printList() {
		moveSet.print();
	}
	public Moves showFirst() {
		return moveSet.peek();
	}
	public void clear() {
		moveSet.clear();
	}
}
