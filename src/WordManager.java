import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class WordManager {
    private ArrayList<Word> availableWords = new ArrayList<>();



    public void AddWord(String value, int level) {
        Word word = new Word(value, level);

        if (!availableWords.contains(word)) {
            availableWords.add(word);
        }

    }


    public void DeleteWord(String value) {
        availableWords.removeIf(word -> word.getValue().equals(value));
    }


    public String GetRandomWord(int level) {
        ArrayList<Word> words = new ArrayList<>();
        for (Word w : availableWords) {
            if (w.getLevel() == level) {
                words.add(w);
            }
        }
        if (!words.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(words.size());
            return words.get(randomIndex).getValue();
        } else {
            return null;
        }

    }


}


