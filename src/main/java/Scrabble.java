import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Scrabble {

    private String word;
    private boolean doubleWord;
    private boolean tripleWord;
    private final ArrayList<Character> doubleLetters = new ArrayList<>();
    private final ArrayList<Character> tripleLetters = new ArrayList<>();
    private final HashMap<Character, Integer> alphabet = new HashMap<>();

    public Scrabble(String word) {
        this.word = word;
        setAlphabet();
    }

    public Scrabble(String word, Character [] doubleLetters, Character [] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.setAlphabet();
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.doubleLetters.addAll(Arrays.asList(doubleLetters));
        this.tripleLetters.addAll(Arrays.asList(tripleLetters));
    }

    public int score() {
        if (word == null) {
            this.word = "";
        }
        int score = points(this.word);
        score = doubleWord(score);
        score = tripleWord(score);
        score = doubleLetter(doubleLetters, score);
        score = tripleLetter(tripleLetters, score);
        return score;
    }

    private int points(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += getLetterScore(word.charAt(i));
        }
        return score;
    }

    private int getLetterScore(Character letter) {
        return alphabet.get(Character.toUpperCase(letter));
    }

    private int doubleWord(int score) {
        if (this.doubleWord) {
            score *= 2;
        }
        return score;
    }

    private int tripleWord(int score) {
        if (this.tripleWord) {
            score *= 3;
        }
        return score;
    }

    private int doubleLetter(ArrayList<Character> letters, int score) {
        for (Character letter: letters) {
            score += getLetterScore(letter);
        }
        return score;
    }

    private int tripleLetter(ArrayList<Character> letters, int score) {
        for (Character letter: letters) {
            score += (2 * getLetterScore(letter));
        }
        return score;
    }

    private void setAlphabet() {
        this.alphabet.put('A', 1);
        this.alphabet.put('B', 3);
        this.alphabet.put('C', 3);
        this.alphabet.put('D', 2);
        this.alphabet.put('E', 1);
        this.alphabet.put('F', 4);
        this.alphabet.put('G', 2);
        this.alphabet.put('H', 4);
        this.alphabet.put('I', 1);
        this.alphabet.put('J', 8);
        this.alphabet.put('K', 5);
        this.alphabet.put('L', 1);
        this.alphabet.put('M', 3);
        this.alphabet.put('N', 1);
        this.alphabet.put('O', 1);
        this.alphabet.put('P', 3);
        this.alphabet.put('Q', 10);
        this.alphabet.put('R', 1);
        this.alphabet.put('S', 1);
        this.alphabet.put('T', 1);
        this.alphabet.put('U', 1);
        this.alphabet.put('V', 4);
        this.alphabet.put('W', 4);
        this.alphabet.put('X', 8);
        this.alphabet.put('Y', 4);
        this.alphabet.put('Z', 10);
    }
}
