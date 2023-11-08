import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game;

        Scanner sc = new Scanner(System.in);
        int level;

        int gameOption;

        do {
            System.out.println("1- Elegir Nivel\n" +
                    "2- Jugar\n" +
                    "3- Salir");

            try{
                gameOption = sc.nextInt();
                sc.nextInt();

                switch (gameOption){

                    case 1:


                        game = new Game(2);
                        break;
                    case 2:
                        game = new Game();
                        break;
                    case 3:

                        break;

                }


            }catch(java.util.InputMismatchException e){
                System.out.println("Error: Ingresa un número válido.");
                sc.nextLine();
                gameOption = -1;
            }


        }while(gameOption != 0);

    }
}