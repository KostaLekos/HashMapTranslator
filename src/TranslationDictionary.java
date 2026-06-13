// Kosta Lekos
// June 12th, 2026
// Translation Dictionary between two languages using Bidirectional Hash Maps
import java.util.Iterator;

public class TranslationDictionary {

    // Adds a translation for a word in English into a specified language
    // Example: word = "hello", translation = "hola", language = spanish
    public void addTranslation(String word, String translation, HashBiMap<String, String> language) {
        language.put(word, translation);
    }

    // Will add multiple translations from English into a specified language by matching up indices of each array
    // words[] and translations[] must have equal length
    public void addTranslations(String[] words, String[] translations, HashBiMap<String, String> language) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            language.put(words[i], translations[i]);
        }
    }


    // Replaces a translation between English and a specified language; won't do anything if translation does not already exist
    public void replaceTranslation(String word, String translation, HashBiMap<String, String> language) {
        language.replace(word, translation);
    }

    // Will replace multiple translations between English and a specified language by matching up indices of each array
    // Items will be skipped if they do not already exist
    // words[] and translations[] must have equal length
    public void replaceTranslations(String[] words, String[] translations, HashBiMap<String, String> language) {
        if (words.length != translations.length) {
            throw new IllegalArgumentException("words and translations must have equal length");
        }

        for (int i = 0; i < words.length; i++) {
            language.replace(words[i], translations[i]);
        }
    }


    // Removes a translation of an English word from a specified language
    // Example removeTranslation("hello", spanish) will remove the translation "hello"="hola"
    public void removeTranslation(String word, HashBiMap<String, String> language) {
        language.removeByKey(word);
    }

    // Removes translations for multiple English words from a specified language
    public void removeTranslations(String[] words, HashBiMap<String, String> language) {
        for (int i = 0; i < words.length; i++) {
            language.removeByKey(words[i]);
        }
    }


    // Translates an English word into a specified language
    // Example, translate("hello", spanish) returns "hola"
    public String translate(String word, HashBiMap<String, String> language) {
        return language.getValueByKey(word);
    }

    // Translates multiple English words into a specified language
    public String[] translate(String[] words, HashBiMap<String, String> language) {
        String[] translations = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            language.getValueByKey(words[i]);
        }
        return translations;
    }

    // Will print a table of all the translations between English and a specified language
    public void printAllTranslations(HashBiMap<String, String> language) {
        Iterator<String> words = language.getAllKeys().iterator();
        Iterator<String> translations = language.getAllValues().iterator();

        while (words.hasNext()) {
            System.out.println(words.next() + "\t= " + translations.next());
        }
    }


    // Translates a word in a specified language into English
    public String backwardTranslate(String translation, HashBiMap<String, String> language) {
        return language.getKeyByValue(translation);
    }

    // Translates multiple words in a specified language into English
    public String[] backwardTranslate(String[] translations, HashBiMap<String, String> language) {
        String[] words = new String[translations.length];

        for (int i = 0; i < translations.length; i++) {
            language.getKeyByValue(translations[i]);
        }
        return words;
    }

    // Will print a table of all the translations between a specified language and English
    public void printAllTranslationsBackward(HashBiMap<String, String> language) {
        Iterator<String> translations = language.getAllValues().iterator();
        Iterator<String> words = language.getAllKeys().iterator();

        while (translations.hasNext()) {
            System.out.println(translations.next() + "\t= " + words.next());
        }
    }


    public static void main(String[] args) {

    }
}