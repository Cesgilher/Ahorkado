import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<String> gameWord = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    public void menu(){

        int option;


            do {
                System.out.println("1- Jugar\n" +
                                    "2- Salir");
                try{


                    option = sc.nextInt();
                    sc.nextLine();

                    if (option == 1){

                        gameMenu();

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

    public void gameMenu(){
        int gameOption;

        do {
            System.out.println("1- Elegir Nivel\n" +
                    "2- Salir");

            try{
                gameOption = sc.nextInt();
                sc.nextInt();


            }catch(java.util.InputMismatchException e){
                System.out.println("Error: Ingresa un número válido.");
                sc.nextLine();
                gameOption = -1;
            }


        }while(gameOption != 0);

    }

}
