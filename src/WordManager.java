import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class WordManager {
    private ArrayList<Word> availableWords = new ArrayList<>();



    public void AddWord(String value) {
        Word word = new Word(value);

        if (!availableWords.contains(word)) {
            availableWords.add(word);
        }

    }


    public void DeleteWord(String value) {

        Word word = new Word(value);
        if (availableWords.contains(word)) {
            availableWords.remove(word);
        }

    }

    public String GetRandomWord(int lenght) {
        ArrayList<Word> words = new ArrayList<>();
        for (Word w : availableWords) {
            if (w.getValue().length() < lenght) {
                words.add(w);
            }
        }
        if (!words.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(words.size());
            return String.valueOf(words.get(randomIndex));
        } else {
            return null;
        }

    }


}


