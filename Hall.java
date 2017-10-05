public class Hall {

	private int seatsAmount;
	private String movieName;
	private boolean movieStatus;
	
	public Hall(String movieName, int seatsAmount) {
		this.seatsAmount = seatsAmount;
		this.movieName = movieName;
		this.movieStatus = false;
	}

	public void sellTicket() {
		if (seatsAmount >= 0) {
			seatsAmount = seatsAmount - 1;
		}
	}

	public int getseatsAmount(){
		return seatsAmount;
	}

	public String getmovieName(){
		return movieName;
	}
}
