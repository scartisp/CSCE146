//Simion Cartis
public class GroceryItem {
	private String name;
	private double price;

	public GroceryItem() {
		this.name = "none";
		this.price = 0;
	}

	public GroceryItem(String aN, double aP) {
		this.setName(aN);
		this.setPrice(aP);
	}

	public String getName() {
		return name;
	}

	public void setName(String aN) {
		if (aN != null)
			this.name = aN;
		else
			this.name = "none";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double aP) {
		if (aP >= 0)
			this.price = aP;
		else
			this.price = 0;
	}

	public String toString() {
		return "Ggtgtgrtgrtgr item name: " + this.name + " Value: " + this.price;
	}

	public boolean equals(GroceryItem aG) {
		return aG != null && this.name.equals(aG.getName()) && this.price == aG.getPrice();
	}

}
