//Simion Cartis
public class Order implements Comparable<Order> {
	private String customer;
	private String foodO;
	private int cookingT;
	private int arrivalT;
	private int cookingTLeft;

	public Order() {
		customer = "none";
		foodO = "none";
		cookingT = 1;
		arrivalT = 0;
		cookingTLeft = cookingT;
	}

	public Order(String aC, String aF, int cT, int aT) {
		this.setCustomer(aC);
		this.setFoodO(aF);
		this.setCookingT(cT);
		this.setArrivalT(aT);
		this.setCookingTLeft();// still need to set cooking time so that it can have access to the
	}// cookingT instance variable

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String aC) {
		if (aC != null)
			this.customer = aC;
		else
			this.customer = "none";
	}

	public String getFoodO() {
		return foodO;
	}

	public void setFoodO(String aF) {
		if (aF != null)
			this.foodO = aF;
		else
			this.foodO = "none";
	}

	public int getCookingT() {
		return cookingT;
	}

	public void setCookingT(int cT) {
		if (cT >= 1)
			this.cookingT = cT;
		else
			this.cookingT = 1;
	}

	public int getArrivalTime() {
		return arrivalT;
	}

	public void setArrivalT(int aT) {
		if (aT >= 0)
			this.arrivalT = aT;
		else
			this.arrivalT = 0;
	}

	public int getCookingTLeft() {
		return cookingTLeft;
	}

	public void setCookingTLeft() {
		cookingTLeft = cookingT;// unless you cookForOneMinute, cooking time left must always be equal to
								// cookingT
	}

	public int compareTo(Order aO) {
		if (aO == null)
			return -1;
		if (cookingT < aO.cookingT)
			return -1;
		if (cookingT > aO.cookingT)
			return 1;
		else
			return customer.compareTo(aO.customer);
	}

	public void cookForOneMinute() {
		cookingTLeft--;
	}

	public boolean isDone() {
		if (cookingT == 0)
			return true;
		else
			return false;
	}

	public String toString() {
		return "Customer: " + this.customer + ", Order: " + this.foodO + ", Cooking time left: " + this.cookingTLeft;
	}

}
