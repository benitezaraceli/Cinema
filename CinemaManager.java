import java.util.Scanner;

public class CinemaManager {
	private Cinema myCinema;
	private Hall myHall;
	private Scanner keyboard = new Scanner(System.in);

	public CinemaManager(String cinemaName, int seatsAmount){
		myCinema = new Cinema();
		myHall = new Hall(cinemaName, seatsAmount);
	}

	public void Menu(){
		
		int option = 0;

		do{
			System.out.println();
			System.out.println("Menu Principal");
			System.out.println("===== ========= ===");
			System.out.println("1) Ver precio de la entrada");
			System.out.println("2) Listar salas, películas en emición y estado");
			System.out.println("3) Opciones de salas");
			System.out.println("0) Salir");
			System.out.println();
			System.out.println("Ingrese opcion: ");
			option = keyboard.nextInt();

			switch (option){
				case 1:
					System.out.println("El precio es de " + myCinema.getprice());

					break;
				case 2:
					myCinema.listHalls();
					break;

				case 3:
					hallMenu();	
					break;

				case 0:
					break;

				default:
					System.out.print("Opcion invalida");
					break;
			}
		}while (option != 0);			
	}

	public void hallMenu(){
		
		char optionHall = 's';
		int option = 0;
		int nroHall;

		do{
			System.out.println();
			System.out.println("Ingrese la sala: ");
			nroHall = keyboard.nextInt();

			if( nroHall < myCinema.gethallsAmount() && nroHall > 0 ) {
				
				System.out.println();
				System.out.println("Menú de las salas");
				System.out.println("==== == === =====");
				System.out.println("1) Vender ticket");
				System.out.println("2) Cambiar estado de la película");
				System.out.println("0) Volver al menú anterior");
				System.out.println();
				System.out.println("Ingresar opcion: ");
				
				option = keyboard.nextInt();

					switch (option) {
						case 1:
							myCinema.SellTicket(1);
							break;

						case 2:
							System.out.print("La película ya comenzó? s/n: ");
							optionHall = keyboard.next().charAt(0);

							if(optionHall == 's'){

								myCinema.ChangeStatusTrue(nroHall);
								System.out.println("La película ya comenzó");

							}else{

								myCinema.ChangeStatusFalse(nroHall);
								System.out.println("La película no ha comenzado");

							}
							
							break;

						case 0:
							Menu();

							break;

						default:
							System.out.print("Opcion incorrecta");
							break;
					}
				}
			

		}while (option != 0);
	}
}
