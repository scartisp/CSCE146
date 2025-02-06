//Simion Cartis
public class GameItems {
	private String name;
	private String console;

	public GameItems() {
		this.name = "none";
		this.console = "none";
	}

	public GameItems(String aN, String aC) {
		this.setName(aN);
		this.setConsole(aC);
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

	public String getConsole() {
		return console;
	}

	public void setConsole(String aC) {
		if (aC != null)
			this.console = aC;
		else
			this.console = "none";
	}

	public String toString() {
		return this.name + " " + this.console;
	}
}
