import java.util.Scanner;

public class Cinema {
	Hall myHall = new Hall("Hoola", 654);
	static final int hallsAmount = 5;
	Scanner keyboard = new Scanner(System.in);

	private int price;
	private float totalRevenue;
	private char MovieState;
	private String Message;
	private boolean MoviesState[] = new boolean[hallsAmount];

	private Hall cinemaHall[] = new Hall[hallsAmount];

	public Cinema (){
		totalRevenue = 0;
	
		for(int i = 1; i < hallsAmount; i++) {
			Scanner keyboard = new Scanner(System.in);

			System.out.print("Ingrese película en sala " + i + " : ");
			String movieName = keyboard.next();

			System.out.print("Ingresar cantidad de butacas en sala " + i + " : ");
			int seatsAmount = keyboard.nextInt();
			
			System.out.print("Ingrese estado de la película (s/n): ");
			char MovieState = keyboard.next().charAt(0);
			if(MovieState == 's'){
				MoviesState[i] = true;
			}else{
				MoviesState[i] = false;
			}
		
			cinemaHall[i] = new Hall(movieName, seatsAmount);

		}

		System.out.println("Ingresar valor de la entrada: ");
		int price1 = keyboard.nextInt();
		price = price1;
	}

	public void ChangeStatusTrue(int position){
		MoviesState[position] = true;
	}

	public void ChangeStatusFalse(int position){
		MoviesState[position] = false;
	}

	public void SellTicket(int position){
		if(MoviesState[position] == false){
			System.out.println("No se puede vender, la película ya ha comenzado!");
		}else{
			myHall.sellTicket();
			System.out.println("Vendido!!!!");
		}
	}

	public int getprice(){
		return price;
	}

	public int gethallsAmount(){
		return hallsAmount;
	}

	public float gettotalRevenue(){
		return totalRevenue;
	}

	public void listHalls(){
		for (int i = 1; i < hallsAmount; i++){

			if(MoviesState[i] == true){
				Message = "La película comenzó";
			}else{
				Message = "La película no comenzó";
			}
			System.out.println("En la sala " + i + " se emite " + cinemaHall[i].getmovieName() + ", el estado de la película es: " + Message);
		}

	}
}
