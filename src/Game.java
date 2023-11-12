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
        Init();

    }




    public void CheckChar() {
        String guess = inputField.getText().toUpperCase(); // Convert the input to uppercase

        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            resultLabel.setText("Ingresa una letra válida.");
            CheckChar();
        } else {
            char letter = guess.charAt(0);
            letter = Character.toUpperCase(letter); // Ensure the comparison is case-insensitive

            if (guessedChars.contains(letter) || failedChars.contains(letter)) {
                resultLabel.setText("Ya has usado esa letra, ingresa otra.");
                CheckChar();
            } else if (gameWord.toUpperCase().contains(String.valueOf(letter))) {
                guessedChars.add(letter);
                resultLabel.setText("¡Letra correcta!");
            } else {
                failedChars.add(letter);
                attempts++;
                resultLabel.setText("¡Letra incorrecta! Intentos restantes: " + (4 - attempts));
            }
        }

        UpdateWordLabel();
        inputField.setText("");

    }

    private void UpdateWordLabel() {
        wordLabel.setText(ShowGuessedChars());
        revalidate();
        repaint();
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
    public boolean RoundIsEnded() {
        if (attempts == 4) {
            return true;
        } else {
            // Check if all letters of the word are guessed
            boolean allLettersGuessed = true;
            for (int i = 0; i < gameWord.length(); i++) {
                char c = gameWord.charAt(i);
                if (!guessedChars.contains(c)) {
                    allLettersGuessed = false;
                    break; // Break out of the loop as soon as a non-guessed letter is found
                }
            }
            return allLettersGuessed;
        }
    }

    public void EndRound(Boolean failedRound){

        if (failedRound){

        }

    }
    public void Init() {
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));
        InitRound();
        setVisible(true);

    }
    private void InitRound() { //Hay que añadir un menu con las diferentes opciones del juego( adivinar palabra y rendirse)
        level++;
        gameWord = wm.GetRandomWord(level);
        attempts = 0;
        guessedChars.clear();
        failedChars.clear();

        wordLabel = new JLabel(ShowGuessedChars());
        JButton guessButton = new JButton("Adivinar");
        JButton surrenderButton = new JButton("Rendirte");
        add(wordLabel);

        inputField = new JTextField();
        add(inputField);



        //los guessButtons hacen la funcion del menu de opciones
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckChar();
                UpdateWordLabel();
                if(RoundIsEnded()){
                    DisplayRoundResult();
                    wm.DeleteWord(gameWord);
                    InitRound();
                }
            }
        });
        surrenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attempts = 4;
                DisplayRoundResult();
                wm.DeleteWord(gameWord);
                InitRound();

            }
        });
        add(guessButton);
        add(surrenderButton);

        resultLabel = new JLabel("");
        add(resultLabel);


    }

    private void DisplayRoundResult() {
        if (attempts == 4) {
            resultLabel.setText("Has perdido esta ronda. La palabra era: " + gameWord);
        } else {
            resultLabel.setText("¡Felicidades! Has adivinado la palabra: " + gameWord);
        }
    }

}