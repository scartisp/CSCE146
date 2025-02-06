//Simion Cartis
public class Moves {
	private String move;

	public Moves() {
		move = "none";
	}

	public Moves(String aM) {
		this.setMove(aM);
	}

	public String getMove() {
		return move;
	}

	public void setMove(String aM) {
		if (aM != null)
			this.move = aM;
		else
			this.move = "none";
	}
	public String toString() {
		return this.move;
	}
}