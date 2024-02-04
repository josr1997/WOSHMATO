package nl.scalda.woshmato.models;

public class SchoolYear {

	private int StartDate;
	private int EndDate;
	
	public SchoolYear(int StartDate, int EndDate) {
		this.StartDate = StartDate;
		this.EndDate = EndDate;
	}
	
	public SchoolYear() {
		
	}
	
	public int getStartDate() {
		return StartDate;
	}

	public void setStartDate(int startDate) {
		StartDate = startDate;
	}

	public int getEndDate() {
		return EndDate;
	}

	public void setEndDate(int endDate) {
		EndDate = endDate;
	}
	
}
