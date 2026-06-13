// Kosta Lekos
// June 12th, 2026
// Translation Dictionary between two languages using Bidirectional Hash Maps
import java.util.Iterator;

public class Language {

    public String name;
    HashBiMap<String, String> translationDictionary = new HashBiMap<>();

    public Language(String name) {
        this.name = name;
    }

    // Adds a translation for a word in the lingua franca
    // Example: word = "hello", translation = "hola"
    public void addTranslation(String word, String translation) {
        translationDictionary.put(word, translation);
    }

    // Will add multiple translations for words in the lingua franca by matching up indices of each array
    // words[] and translations[] must have equal length
    public void addTranslations(String[] words, String[] translations) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            translationDictionary.put(words[i], translations[i]);
        }
    }


    // Replaces a translation for a word in the lingua franca; won't do anything if translation does not already exist
    public void replaceTranslation(String word, String translation) {
        translationDictionary.replace(word, translation);
    }

    // Will replace multiple translations for words in the lingua franca by matching up indices of each array
    // Items will be skipped if they do not already exist
    // words[] and translations[] must have equal length
    public void replaceTranslations(String[] words, String[] translations) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            translationDictionary.replace(words[i], translations[i]);
        }
    }


    // Removes a translation of a word in the lingua franca
    // Example removeTranslation("hello") will remove the translation "hello"="hola"
    public void removeTranslation(String word) {
        translationDictionary.removeByKey(word);
    }

    // Removes translations for multiple words in the lingua franca
    public void removeTranslations(String[] words) {
        for (int i = 0; i < words.length; i++) {
            translationDictionary.removeByKey(words[i]);
        }
    }


    // Translates a word from the lingua franca
    // Example, translate("hello") returns "hola"
    public String translate(String word) {
        return translationDictionary.getValueByKey(word);
    }

    // Translates multiple words from the lingua franca
    public String[] translate(String[] words) {
        String[] translations = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            translationDictionary.getValueByKey(words[i]);
        }
        return translations;
    }

    // Will print a table of all the translations between the lingua franca and itself
    public void printAllTranslations() {
        Iterator<String> words = translationDictionary.getAllKeys().iterator();

        String currentWord;
        while (words.hasNext()) {
            currentWord = words.next();
            System.out.println(currentWord + "\t\t= " + translationDictionary.getValueByKey(currentWord));
        }
        System.out.println();
    }


    // Translates a word into the lingua franca
    public String backwardTranslate(String translation) {
        return translationDictionary.getKeyByValue(translation);
    }

    // Translates multiple words into the lingua franca
    public String[] backwardTranslate(String[] translations) {
        String[] words = new String[translations.length];

        for (int i = 0; i < translations.length; i++) {
            translationDictionary.getKeyByValue(translations[i]);
        }
        return words;
    }

    // Will print a table of all the translations between itself and the lingua franca
    public void printAllTranslationsBackward() {
        Iterator<String> translations = translationDictionary.getAllValues().iterator();

        String currentTranslation;
        while (translations.hasNext()) {
            currentTranslation = translations.next();
            System.out.println(currentTranslation + "\t\t= " + translationDictionary.getKeyByValue(currentTranslation));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // These languages are only examples
        // Translations may not be accurate as I only have beginner knowledge of each (other than English of course)
        // In this example the lingua franca is English, but it could work as a different language
        /*
        HashBiMap<String, String> spanish = new HashBiMap<>();
        HashBiMap<String, String> greek = new HashBiMap<>();
        HashBiMap<String, String> japanese = new HashBiMap<>();

        String[] enWords = {"hi", "bye", "cat", "dog", 
                            "person", "rice", "black", "tomorrow", 
                            "yesterday", "today", "yes", "no"};

        String[] spWords = {"hola", "adios", "gata", "perro", 
                            "persona", "arroz", "negro", "mañana", 
                            "ayer", "hoy", "si", "no"};

        String[] grWords = {"γεια", "αντιο", "γατα", "σκυλο", 
                            "προσωπο", "ρυζι", "μαυρος", "αυριο", 
                            "εχθες", "σημερα", "ναι", "οχι"};

        String[] jaWords = {"こんにちは", "さよなら", "猫", "犬", 
                            "人", "御飯", "黒", "明日", 
                            "昨日", "今日", "はい", "いいえ"};

        addTranslations(enWords, spWords, spanish);
        addTranslations(enWords, grWords, greek);
        addTranslations(enWords, jaWords, japanese);

        System.out.println("English \tto Spanish:");
        printAllTranslations(spanish);
        
        System.out.println("English \tto Greek:");
        printAllTranslations(greek);

        System.out.println("English \tto Japanese:");
        printAllTranslations(japanese);
        */
    }
}