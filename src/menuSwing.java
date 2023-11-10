import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class menuSwing extends JFrame {
    private String gameWord;
    private ArrayList<Character> guessedChars = new ArrayList<>();
    private ArrayList<Character> failedChars = new ArrayList<>();
    private int attempts;
    private int level;
    private JTextField inputField;
    private JLabel wordLabel;
    private JLabel resultLabel;

    //crear la pantalla
    public menuSwing() {
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));

        level = 1;
        initGame();
    }

    //inicializar partida
    private void initGame() {
        gameWord = generateRandomWord();
        attempts = 0;
        guessedChars.clear();
        failedChars.clear();

        wordLabel = new JLabel(getMaskedWord());
        add(wordLabel);

        inputField = new JTextField();
        add(inputField);

        JButton guessButton = new JButton("Adivinar");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        add(guessButton);

        resultLabel = new JLabel("");
        add(resultLabel);
    }

    //generar la palabra aleatoriamente
    private String generateRandomWord() {
        // Aquí puedes personalizar cómo se generan las palabras aleatorias para el juego.
        // En este ejemplo, se usa una lista predefinida de palabras.
        String[] words = {"JAVA", "PYTHON", "SWING", "PROGRAMMING", "COMPUTER"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    //donete
    private String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : gameWord.toCharArray()) {
            if (guessedChars.contains(c)) {
                maskedWord.append(c);
            } else {
                maskedWord.append("_ ");
            }
        }
        return maskedWord.toString();
    }
    //donete
    private void checkGuess() {
        String guess = inputField.getText().toUpperCase();
        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            resultLabel.setText("Ingresa una letra válida.");
        } else {
            char letter = guess.charAt(0);
            if (gameWord.contains(String.valueOf(letter))) {
                guessedChars.add(letter);
                wordLabel.setText(getMaskedWord());
                if (!getMaskedWord().contains("_")) {
                    resultLabel.setText("¡Felicidades! Has ganado.");
                } else {
                    resultLabel.setText("¡Letra correcta!");
                }
            } else {
                failedChars.add(letter);
                attempts++;
                if (attempts >= 6) {
                    resultLabel.setText("Has perdido. La palabra era: " + gameWord);
                } else {
                    resultLabel.setText("¡Letra incorrecta! Intentos restantes: " + (6 - attempts));
                }
            }
        }
        inputField.setText("");
    }
}