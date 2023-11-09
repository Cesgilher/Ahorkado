import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.wm.AddWord("taza",1);
        game.wm.AddWord("reptil",1);
        game.wm.AddWord("taladro",3);
        game.wm.AddWord("impresionar",3);
        game.wm.AddWord("ramo",2);
        Scanner sc = new Scanner(System.in);
        int level;

        int gameOption;


        System.out.println("1- Elegir Nivel\n" +
                "2- Jugar\n");

        try{
            gameOption = sc.nextInt();


            switch (gameOption) {

                case 1:
                    System.out.println("introducir nivel\n" +
                            "1- facil\n" +
                            "2- normal\n" +
                            "3- dificil");
                    level = sc.nextInt();
                    //game.level = level;

                    break;
                case 2:
                    game.mostrarJuego();
                    break;

            }
        }catch(java.util.InputMismatchException e){
            System.out.println("Error: Ingresa un número válido.");


        }

        //game.Play();






    }
}