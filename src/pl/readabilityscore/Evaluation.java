package pl.readabilityscore;

public class Evaluation {

    private final TextReader reader;

    public Evaluation(TextReader reader) {
        this.reader = reader;
        printResult();
    }

    private String getAge(String index) {

        int score = (int) Math.ceil(Double.parseDouble(index));

        switch (score) {
            case 1:
                return "6";
            case 2:
                return "7";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "11";
            case 6:
                return "12";
            case 7:
                return "13";
            case 8:
                return "14";
            case 9:
                return "15";
            case 10:
                return "16";
            case 11:
                return "17";
            case 12:
                return "18";
            case 13:
                return "24";
            case 14:
                return "24+";
            default:
                return "Unknown";
        }
    }

    public void printResult() {

        String automatedReadAbilityIndex = reader.getAutomatedReadAbilityIndex();
        String fleschKincaidIndex = reader.getFleschKincaidIndex();
        String smogIndex = reader.getSmogIndex();
        String coleamnLiauIndex = reader.getColemanLiauIndex();

        System.out.println("The text is:\n" + reader.getText() + "\n" +
                "Words: " + reader.getWords() + "\n" +
                "Sentences: " + reader.getSentences() + "\n" +
                "Characters: " + reader.getCharacters() + "\n" +
                "Syllables: " + reader.getSyllables() + "\n" +
                "Polysyllables: " + reader.getPolysyllables() + "\n" +
                "\n" +
                "Automated Readability Index: " + automatedReadAbilityIndex + " (about " + getAge(automatedReadAbilityIndex) + "-year-olds).\n" +
                "Flesch–Kincaid readability tests: " + fleschKincaidIndex + " (about " + getAge(fleschKincaidIndex) + "-year-olds).\n" +
                "Simple Measure of Gobbledygook: " + smogIndex + " (about " + getAge(smogIndex) + "-year-olds).\n" +
                "Coleman–Liau index: " + coleamnLiauIndex + " (about " + getAge(coleamnLiauIndex) + "-year-olds).\n" +
                "\n");

    }

}
