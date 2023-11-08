import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        int option;


        do {
            System.out.println("1- Jugar\n" +
                    "2- Salir");
            try{


                option = sc.nextInt();
                sc.nextLine();

                if (option == 1){

                    game.gameMenu();

                }else{
                    System.out.println("Adios");
                }
            }catch(java.util.InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                sc.nextLine();
                option = -1;
            }

        }while (option != 0);

    }
}