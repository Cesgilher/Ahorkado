import java.util.ArrayList;

public class WordManager {
    private ArrayList<Word> availableWords = new ArrayList<>();


    public void AddWord(String value){
        Word word = new Word(value);

        if (!availableWords.contains(word)) {
            availableWords.add(word);
        }

    }

    public void DeleteWord(String value){

        Word word = new Word(value);
        if (availableWords.contains(word)) {
            availableWords.remove(word);
        }

    }
}
