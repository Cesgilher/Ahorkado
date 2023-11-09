import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    String gameWord;
    ArrayList<Character> guessedChars = new ArrayList<>();
    ArrayList<Character> failedChars = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    WordManager wm = new WordManager();
    int level;
    int attempts;




    public Game(){
        this.level = 0;
    }
    public Game(int level ){
        this.level = level;
    }


    public void ShowWord(){
        System.out.print("La palabra es: " + gameWord);
        /*for (char character : gameWord) {
            System.out.print(character);
        }
        System.out.println();*/
    }

    public void CheckChar(char value) {

        if (gameWord.contains(String.valueOf(value))){
            guessedChars.add(value);
        }else {
            failedChars.add(value);
            attempts++;
        }
    }

    public void ShowGuessedChars(){
        String word = "";
        for (int i = 0; i < gameWord.length(); i++){
            char c = gameWord.charAt(i);

            if (guessedChars.contains(c)){
                word = word.concat(String.valueOf(c));
            }else {
                word = word.concat("_");
            }
        }
        System.out.println(word);

    }



    public void gameOver(){
        System.out.println("Has perdido");
    }

    public void Play() {
        level++;
        attempts = 0;
        guessedChars.clear();
        failedChars.clear();
        int option = 0;
        boolean comprobation = true;
        char  value;
        wm.GetRandomWord(level);

        do{

            System.out.println("1- Introducir letra\n" +
                    "2- Rendirse");

            try {
                option = sc.nextInt();

                switch (option){
                    case 1:
                        System.out.println("Introduzca una letra");
                        value = sc.next().charAt(0);
                        CheckChar(value);
                        ShowGuessedChars();

                        break;
                    case 2:
                        gameOver();
                        ShowWord();
                        break;
                }

            }catch (java.util.InputMismatchException e){
                System.out.println("Error: Ingresa un número válido.");

            }

        }while(option != 2 || attempts != 4);
    }




}
