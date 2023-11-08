import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<String> gameWord = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int level;

    public void gameMenu(){
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
                        selectLevel();
                        break;
                    case 2:
                        play();
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

    private void play() {
    }

    private void selectLevel() {
    }


}
