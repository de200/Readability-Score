package pl.readabilityscore;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Readability {

    public final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public Readability() {
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.DOWN);
    }

    public int countSentences(String text) {
        return text.split("[.?!]+ *").length;
    }

    public int countWords(String text) {
        return text.split("\\s+").length;
    }

    public int countCharacters(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    private String[] splitTextIntoWords(String text) {
        String s1 = text.toLowerCase().replaceAll("[^a-zA-Z- \n]", "");
        return s1.split("\\s+");
    }

    public int countSyllablesInText(String text) {

        String[] words = splitTextIntoWords(text);
        int syllablesCounter = 0;

        for (String word : words) {
            int syllables = countSyllablesInWord(word);
            syllablesCounter += syllables;
            System.out.println(word + " " + syllables);
        }
        return syllablesCounter;
    }

    public int countPolysyllables(String text) {

        String[] words = splitTextIntoWords(text);
        int polysyllables = 0;

        for (String word : words) {
            if (countSyllablesInWord(word) > 2) {
                polysyllables++;
            }
        }
        return polysyllables;
    }

    private int countSyllablesInWord(String word) {
        int counter = 0;

        String regex = "[bcdfghjklmnpqrstvwxz]*[aeiouy]+[bcdfghjklmnpqrstvwxz]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            counter++;
        }


        if (word.length() > 2 && word.charAt(word.length() - 1) == 'e' && word.charAt(word.length() - 2) != 'l' && word.charAt(word.length() - 2) != 'e' && !word.equals("the")) {
            return counter - 1;
        }
        return counter;
    }


    public String countAutomatedReadabilityIndex(int characters, int words, int sentences) {
        double result = 4.71 * characters / words + 0.5 * words / sentences - 21.43;

        return DECIMAL_FORMAT.format(result);
    }


    public String countFleschKincaidTest(int words, int sentences, int syllables) {
        double result = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;

        return DECIMAL_FORMAT.format(result);
    }


    public String countSmogIndex(int polysyllables, int sentences) {
        double result = 1.043 * Math.sqrt((double) polysyllables * 30 / sentences) + 3.1291;

        return DECIMAL_FORMAT.format(result);
    }

    public String countColemanLiauIndex(int characters, int words, int sentences) {
        double l = (double) characters /  words * 100;
        double s = (double) sentences /  words * 100;
        double result = 0.0588 * l - 0.296 * s -15.8;

        return DECIMAL_FORMAT.format(result);
    }
}
