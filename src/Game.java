import java.util.ArrayList;
import java.util.Scanner;


public class Game {

    ArrayList<String> gameWord = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    WordManager wm = new WordManager();
    int level;

    public Game(){
        this.level = 1;
    }
    public Game(int level ){
        this.level = level;
    }

    public void play() {
        int Attempts = 0;
        int option = 0;
        boolean comprobation = true;
        char  value;

        gameWord.add(wm.GetRandomWordChars());

        do{

            System.out.println("1- Introducir letra\n" +
                                "2- Rendirse");

            try {
                option = sc.nextInt();

                switch (option){
                    case 1:
                        System.out.println("Introduzca una letra");
                        value = sc.next().charAt(0);
                        checkCaracter(value, gameWord);
                        if (comprobation == true){
                            showCharacter();
                        }else{
                            Attempts = + 1;
                        }
                        break;
                    case 2:
                            gameOver();
                            showWord(gameWord);
                        break;
                }

            }catch (java.util.InputMismatchException e){
                System.out.println("Error: Ingresa un número válido.");

            }

        }while(option != 2 || Attempts != 4);
    }

    public void showWord(ArrayList<String> gameWord){
        System.out.println("La palabra es: " + gameWord.toString());
    }

    public void showCharacter(){}

    //este no se me ocurre como pasarle el parametro value
    public boolean checkCaracter(char value, ArrayList<String> gameWord){

        for (char value : gameWord) {
            if (gameWord.contains(value)) {
                return true;
            }
        }
        return false;

    }
    public void gameOver(){
        System.out.println("Has perdido");
    }


}
