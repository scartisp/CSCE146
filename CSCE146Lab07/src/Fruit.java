//Simion Cartis
public class Fruit implements Comparable<Fruit> {
	public String type;
	public double weight;

	public Fruit() {
		this.type = "apple";
		this.weight = 1.0;
	}

	public Fruit(String aT, double aW) {
		this.setType(aT);
		this.setWeight(aW);
	}

	public String getType() {
		return type;
	}

	public void setType(String aT) {
		if (aT != null)
			this.type = aT;
		else
			this.type = "apple";
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double aW) {
		if (aW > 0)
			this.weight = aW;
		else
			this.weight = 1.0;
	}

	public String toString() {
		return "Type: "+this.type + " Weight: " + this.weight;
	}

	public int compareTo(Fruit aF) {
		if (aF == null)
			return -1;
		if (weight < aF.weight)
			return -1;
		else if (weight > aF.weight)
			return 1;
		else
			return type.compareTo(aF.type);
	}

}
