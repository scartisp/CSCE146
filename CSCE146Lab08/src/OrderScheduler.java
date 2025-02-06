//Simion Cartis
public class OrderScheduler {
	MinHeap<Order> Orders = new MinHeap<Order>();
	Order currentO;
	int currentM = 0;
	int totalO = 0;
	double summedWaitingT = 0;

	public void addOrder(Order aO) {
		if (currentO == null) {
			currentO = aO;
			currentO.setArrivalT(currentM);// have to get arrival time of first object
		} else {
			Orders.add(aO);
			aO.setArrivalT(currentM); // AND the arrival time of all following objects in heap
		}
		totalO++;
	}

	public void advanceOneMinute() {
		currentM++;
		currentO.cookForOneMinute();
		if (currentO.getCookingTLeft() <= 0) {
			summedWaitingT += currentM - currentO.getArrivalTime();
			currentO = Orders.remove();// the remove method returns the root, since root is always
		}// smallest element, we want to place that into the currentO object.
	}

	public boolean isDone() {
		if (currentO == null)
			return true;
		else
			return false;
	}

	public double getAverageWaitingTime() {
		return summedWaitingT / totalO;
	}

	public Order getCurrentOrder() {
		return currentO;
	}

}
