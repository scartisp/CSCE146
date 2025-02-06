//Simion Cartis
public class Process {
	private String name;
	private double completionTime;

	public Process() {
		this.name = "none";
		this.completionTime = 0.0;
	}

	public Process(String aN, double aC) {
		this.setname(aN);
		this.setCompletionTime(aC);
	}

	public String getname() {
		return name;
	}

	public void setname(String aN) {
		if (aN != null)
			this.name = aN;
		else
			this.name = "none";
	}

	public double getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(double aC) {
		if (aC >= 0)
			this.completionTime = aC;
		else
			this.completionTime = 0.0;
	}

	public String toString() {
		return "Process name: " + this.name + " Completion time: " + this.completionTime;
	}

}
