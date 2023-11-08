import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Scanner sc = new Scanner(System.in);
        int level;

        int gameOption;


        System.out.println("1- Elegir Nivel\n" +
                "2- Jugar\n");

        try{
            gameOption = sc.nextInt();


            switch (gameOption){

                case 1:
                    System.out.println("introducir nivel\n" +
                            "1- facil\n" +
                            "2- normal\n" +
                            "3- dificil");
                    level = sc.nextInt();
                    game = new Game(level);
                    break;
                case 2:

                    break;

            }


        }catch(java.util.InputMismatchException e){
            System.out.println("Error: Ingresa un número válido.");


        }
        game.play();




    }
}