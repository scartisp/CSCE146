//Simion Cartis
public class Sheep implements Comparable<Sheep> {
	public String name;
	public int sTime;
	public int aTime;
	public int sTimeLeft;

	public Sheep() {
		this.name = "none";
		this.sTime = 1;
		this.aTime = 0;
		sTimeLeft = sTime;
	}

	public Sheep(String aN, int aS, int aA) {
		this.setName(aN);
		this.setsTime(aS);
		this.setaTime(aA);
		sTimeLeft = sTime;
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

	public int getsTime() {
		return sTime;
	}

	public void setsTime(int aS) {
		if (aS >= 1)
			this.sTime = aS;
		else
			this.sTime = 1;
	}

	public int getaTime() {
		return aTime;
	}

	public void setaTime(int aA) {
		if (aA >= 0)
			this.aTime = aA;
		else
			this.aTime = 0;
	}

	public int getsTimeLeft() {
		return sTimeLeft;
	}

	public String toString() {
		return "Name: " + this.name + ", Sheer Time Left: " + this.sTimeLeft + ", Arrival Time: " + this.aTime;
	}

	public int compareTo(Sheep aS) {
		if (aS == null)
			return -1;
		if (sTime < aS.sTime)
			return -1;
		else if (sTime > aS.sTime)
			return 1;
		else
			return name.compareTo(aS.name);
	}

	public void sheerForOneMinute() {
		sTimeLeft--;
	}
}
