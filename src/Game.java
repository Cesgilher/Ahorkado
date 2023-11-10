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
        /*for (char character : gameWord) {
            System.out.print(character);
        }
        System.out.println();*/
    }

    public void CheckChar() {

        String guess = inputField.getText().toUpperCase();
        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            resultLabel.setText("Ingresa una letra válida.");
        } else {
            char letter = guess.charAt(0);
            if (gameWord.contains(String.valueOf(letter))) {
                guessedChars.add(letter);
                wordLabel.setText(ShowGuessedChars());
                if (!ShowGuessedChars().contains("_")) {
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
                    resultLabel.setText("¡Letra incorrecta! Intentos restantes: " + (4 - attempts));
                }
            }
        }
        inputField.setText("");
        /*if (gameWord.contains(String.valueOf(value))){
            guessedChars.add(value);
        }else {
            failedChars.add(value);
            attempts++;
        }*/
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



    public void gameOver(){
        System.out.println("Has perdido");
    }

    /*public void Play() {
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
    }*/

    //swing
   /* public void mostrarJuego(){
        JFrame ventana = new JFrame("Ahorcado");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 250);

        JPanel panel = new JPanel();
        ventana.add(panel);

        JButton jugarButton = new JButton(("Jugar") + ("BorderLayout.SOUTH") + BorderLayout.SOUTH);
        JButton nivelButton = new JButton("Elegir Nivel");

        panel.add(jugarButton);
        panel.add(nivelButton);

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agrega aquí la lógica para "Jugar"
                JOptionPane.showMessageDialog(null, "Has seleccionado Jugar");
            }
        });

        nivelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Has seleccionado Elegir Nivel");
            }
        });


        ventana.setVisible(true);
    }*/


    public void mostrarJuego() {
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));

        initGame();
    }

    private void initGame() {
        gameWord = wm.GetRandomWord(level);
        attempts = 0;
        guessedChars.clear();
        failedChars.clear();

        wordLabel = new JLabel(ShowGuessedChars());
        add(wordLabel);

        inputField = new JTextField();
        add(inputField);

        JButton guessButton = new JButton("Adivinar");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckChar();
            }
        });
        add(guessButton);

        resultLabel = new JLabel("");
        add(resultLabel);
    }

}
