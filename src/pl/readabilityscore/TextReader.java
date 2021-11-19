package pl.readabilityscore;


public class TextReader {

    private final String text;
    private final int sentences;
    private final int words;
    private final int characters;
    private final int syllables;
    private final int polysyllables;

    private final String automatedReadAbilityIndex;
    private final String fleschKincaidIndex;
    private final String smogIndex;
    private final String colemanLiauIndex;


    public TextReader(String text) {
        Readability readability = new Readability();

        this.text = text;
        this.sentences = readability.countSentences(text);
        this.words = readability.countWords(text);
        this.characters = readability.countCharacters(text);
        this.syllables = readability.countSyllablesInText(text);
        this.polysyllables = readability.countPolysyllables(text);

        this.automatedReadAbilityIndex = readability.countAutomatedReadabilityIndex(characters, words, sentences);
        this.fleschKincaidIndex = readability.countFleschKincaidTest(words, sentences,syllables);
        this.smogIndex = readability.countSmogIndex(polysyllables, sentences);
        this.colemanLiauIndex = readability.countColemanLiauIndex(characters, words, sentences);
    }


    public String getText() {
        return text;
    }


    public int getSentences() {
        return sentences;
    }


    public int getWords() {
        return words;
    }


    public int getCharacters() {
        return characters;
    }


    public int getSyllables() {
        return syllables;
    }


    public int getPolysyllables() {
        return polysyllables;
    }


    public String getAutomatedReadAbilityIndex() {
        return automatedReadAbilityIndex;
    }


    public String getFleschKincaidIndex() {
        return fleschKincaidIndex;
    }


    public String getSmogIndex() {
        return smogIndex;
    }


    public String getColemanLiauIndex() {
        return colemanLiauIndex;
    }

}
