//Simion Cartis
public class SheepScheduler {
	MinHeap<Sheep> SheepsToSheer = new MinHeap<Sheep>();
	Sheep currentS;
	int currentTime = 0;

	public void addSheep(Sheep aS) {
		if (currentS == null) {
			currentS = aS;
			currentS.setaTime(currentTime);
		} else {
			SheepsToSheer.add(aS);
			aS.setaTime(currentTime);
		}
	}

	public void advanceOneMin() {
		currentTime++;
		currentS.sheerForOneMinute();
		if (currentS.getsTimeLeft() <= 0) {
			currentS = SheepsToSheer.remove();// will remove the first element in the heap.
		}//sheep can only be sheered if they already arrived
	}

	public boolean isDone() {
		if (currentS == null)
			return true;
		else
			return false;
	}

	public Sheep getCurrentSheep() {
		return currentS;
	}
}
