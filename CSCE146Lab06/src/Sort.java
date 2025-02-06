//Simion Cartis
public class Sort {
	private String sort;

	public Sort() {
		sort = "none";
		
	}

	public Sort(String aS) {
		this.setSort(aS);
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String aS) {
		if (aS != null)
			this.sort = aS;
		else
			this.sort = "none";
	}
	public String toString() {
		return this.sort;
	}
	public boolean equals(String aS) {
		return aS != null && this.sort.equalsIgnoreCase(aS);
	}
	public int numOfSort() {
		int count = 0;
		String lowerCaseS = this.sort.toLowerCase();
		int index = 0;
		
		while((index = lowerCaseS.indexOf("sort", index)) != -1) {//.indexOf allows you to go through the string
			count++;//and check to see if it contains a specified substring
			index +=4;
		}
		return count;
	}

}
