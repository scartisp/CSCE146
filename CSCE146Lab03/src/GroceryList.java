//Simion Cartis

public class GroceryList {
	private class ListNode { //this class basically constructs the linked list
		GroceryItem data; //which can then be used in the broader class
		ListNode link;

		public ListNode() {
			this.data = null;
			this.link = null;
		}

		public ListNode(GroceryItem aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode Head;
	private ListNode Current;
	private ListNode Previous;

	public GroceryList() {
		Head = null;
		Head = Current;
		Head = Previous;
	}

	public void gotoNext() {
		if (Current == null)
			return;
		Previous = Current; //this checks if the current is null first, it puts current back one
		Current = Current.link; //(where previous is) and then moves current to the next element
	}

	public GroceryItem getCurrent() {
		if (Current == null)
			return null;
		else
			return Current.data;
	}

	public void setCurrent(GroceryItem aData) {
		if (Current == null)
			return;
		Current.data = aData;
	}

	public void addItem(GroceryItem aData) {
		ListNode newNode = new ListNode(aData, null);//this basically creates a new
		if (Head == null) { //spot in the linked list, moves that spot until it finds an empty space
			Head = Current = Previous = newNode; //and then inserts new data
			return;
		}
		ListNode temp = Head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}

	public void addItemAfterCurrent(GroceryItem aData) {
		if (Current == null)
			return;
		ListNode newNode = new ListNode(aData, Current.link);
		Current.link = newNode;
	}

	public void removeCurrent() {
		if (Current == Head) {
			Head = Head.link;
			Current = Head; //this literally just moves
		} else { //the head of the list past a given point making java forget the data
			Previous.link = Current.link;// move all references to a node past it, making java forget it
			Current = Current.link; // we are pointing to the next node with current.link and calling it current
		}
	}

	public void showList() {
		ListNode temp = Head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	public boolean contains(GroceryItem aData) {
		ListNode temp = Head;
		while (temp != null) {
			if (temp.data.equals(aData))
				return true;
			temp = temp.link;
		}
		return false;
	}

	public double totalCost() {
		double total = 0;
		ListNode temp = Head;
		while (temp != null) {
			total += temp.data.getPrice(); //this uses the .getPrice method in the GroceryItem class
			temp = temp.link; //which already does the job of retrieving the intended double value and
		} //then adds that double to the total (the numbers are turned into double values from the .txt
		return total; //by the provided code
	}
}
