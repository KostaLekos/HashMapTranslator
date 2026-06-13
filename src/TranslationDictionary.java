// Kosta Lekos
// June 12th, 2026
// Translation Dictionary between two languages using Bidirectional Hash Maps
import java.util.Iterator;

public class TranslationDictionary {

    // Adds a translation for a word in English into a specified language
    // Example: word = "hello", translation = "hola", language = spanish
    public static void addTranslation(String word, String translation, HashBiMap<String, String> language) {
        language.put(word, translation);
    }

    // Will add multiple translations from English into a specified language by matching up indices of each array
    // words[] and translations[] must have equal length
    public static void addTranslations(String[] words, String[] translations, HashBiMap<String, String> language) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            language.put(words[i], translations[i]);
        }
    }


    // Replaces a translation between English and a specified language; won't do anything if translation does not already exist
    public static void replaceTranslation(String word, String translation, HashBiMap<String, String> language) {
        language.replace(word, translation);
    }

    // Will replace multiple translations between English and a specified language by matching up indices of each array
    // Items will be skipped if they do not already exist
    // words[] and translations[] must have equal length
    public static void replaceTranslations(String[] words, String[] translations, HashBiMap<String, String> language) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            language.replace(words[i], translations[i]);
        }
    }


    // Removes a translation of an English word from a specified language
    // Example removeTranslation("hello", spanish) will remove the translation "hello"="hola"
    public static void removeTranslation(String word, HashBiMap<String, String> language) {
        language.removeByKey(word);
    }

    // Removes translations for multiple English words from a specified language
    public static void removeTranslations(String[] words, HashBiMap<String, String> language) {
        for (int i = 0; i < words.length; i++) {
            language.removeByKey(words[i]);
        }
    }


    // Translates an English word into a specified language
    // Example, translate("hello", spanish) returns "hola"
    public static String translate(String word, HashBiMap<String, String> language) {
        return language.getValueByKey(word);
    }

    // Translates multiple English words into a specified language
    public static String[] translate(String[] words, HashBiMap<String, String> language) {
        String[] translations = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            language.getValueByKey(words[i]);
        }
        return translations;
    }

    // Will print a table of all the translations between English and a specified language
    public static void printAllTranslations(HashBiMap<String, String> language) {
        Iterator<String> words = language.getAllKeys().iterator();

        String currentWord;
        while (words.hasNext()) {
            currentWord = words.next();
            System.out.println(currentWord + "\t\t= " + language.getValueByKey(currentWord));
        }
        System.out.println();
    }


    // Translates a word in a specified language into English
    public static String backwardTranslate(String translation, HashBiMap<String, String> language) {
        return language.getKeyByValue(translation);
    }

    // Translates multiple words in a specified language into English
    public static String[] backwardTranslate(String[] translations, HashBiMap<String, String> language) {
        String[] words = new String[translations.length];

        for (int i = 0; i < translations.length; i++) {
            language.getKeyByValue(translations[i]);
        }
        return words;
    }

    // Will print a table of all the translations between a specified language and English
    public static void printAllTranslationsBackward(HashBiMap<String, String> language) {
        Iterator<String> translations = language.getAllValues().iterator();

        String currentTranslation;
        while (translations.hasNext()) {
            currentTranslation = translations.next();
            System.out.println(currentTranslation + "\t\t= " + language.getKeyByValue(currentTranslation));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // These languages are only examples
        // Translations may not be accurate as I only have beginner knowledge of each (other than English of course)
        // In this example the lingua franca is English, but it could work as a different language
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
    }
}