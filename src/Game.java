import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame{
    String gameWord;
    ArrayList<Character> guessedChars = new ArrayList<>();
    ArrayList<Character> failedChars = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    WordManager wm = new WordManager();
    private int level;
    private int attempts;
    private JTextField inputField;
    private JLabel wordLabel;
    private JLabel resultLabel;



    public Game(){
        this.level = 0;
    }
    public Game(int level ){
        this.level = level;
    }


    public void ShowWord(){
        System.out.print("La palabra es: " + gameWord);
    }

    public void CheckChar() {

        String guess = inputField.getText().toUpperCase();
        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            resultLabel.setText("Ingresa una letra válida.");
            CheckChar();
        } else {
            char letter = guess.charAt(0);
            if (guessedChars.contains(letter) | failedChars.contains(letter)){
                resultLabel.setText("Ya has usado esa letra, ingresa otra.");
                CheckChar();
            }
            else if (gameWord.contains(String.valueOf(letter))) {
                guessedChars.add(letter);
                resultLabel.setText("¡Letra correcta!");

            } else {
                failedChars.add(letter);
                attempts++;
                resultLabel.setText("¡Letra incorrecta! Intentos restantes: " + (4 - attempts));
            }
        }
        inputField.setText("");

    }
    public String ShowGuessedChars(){
        String word = "";
        for (int i = 0; i < gameWord.length(); i++){
            char c = gameWord.charAt(i);

            if (guessedChars.contains(c)){
                word = word.concat(String.valueOf(c));
            }else {
                word = word.concat("_ ");
            }
        }
        return word;

    }
    public void gameStatus(int attempts){

        if (attempts==4){
            resultLabel.setText("Has perdido, la palabra era: " + gameWord);

        } else{
            resultLabel.setText("¡Felicidades! Has ganado.");
        }
    }
    public void mostrarJuego() {
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));

        initRound();
    }
    private void initRound() { //Hay que añadir un menu con las diferentes opciones del juego( adivinar palabra y rendirse)
        gameWord = wm.GetRandomWord(level);
        attempts = 0;
        guessedChars.clear();
        failedChars.clear();

        wordLabel = new JLabel(ShowGuessedChars());
        add(wordLabel);

        inputField = new JTextField();
        add(inputField);

        JButton guessButton = new JButton("Adivinar");
        JButton surrenderButton = new JButton("Rendirte");

        //los guessButtons hacen la funcion del menu de opciones
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckChar();
            }
        });
        surrenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attempts = 4;
                gameStatus(attempts);
            }
        });
        add(guessButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        gameStatus(attempts);

        //cuando se acabe la ronda ( wm.DeleteWord(gameWord))
        wm.DeleteWord(gameWord);
    }

}
