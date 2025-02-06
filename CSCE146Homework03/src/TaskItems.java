//Simion Cartis
public class TaskItems {
	private String name;
	private int priority;

	public TaskItems() {
		this.name = "none";
		this.priority = 4;
	}

	public TaskItems(int aP, String aN) {
		this.setPriority(aP);
		this.setName(aN);
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int aP) {
		if (priority >= 0 && priority <= 4)
			this.priority = aP;
		else
			priority = 4;
	}

	public String toString() {
		return "Priority: " + this.priority + " Task name: " + this.name;
	}

	public boolean equals(TaskItems aT) {
		return aT != null && this.priority == aT.getPriority() && this.name.equals(aT.getName());
	}

}
