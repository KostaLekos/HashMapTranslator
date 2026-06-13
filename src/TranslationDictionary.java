// Kosta Lekos
// June 12th, 2026
// Translation Dictionary between two languages using Bidirectional Hash Maps

public class TranslationDictionary {

    // Adds a translation for a word in English into a specified language
    // Example: word = "hello", translation = "hola", language = spanish
    public void addTranslation(String word, String translation, HashBiMap<String, String> language) {

    }

    // Will add multiple translations from English into a specified language by matching up indices of each array
    // words[] and translations[] must have equal length
    public void addTranslations(String[] words, String[] translations, HashBiMap<String, String> language) {

    }


    // Replaces a translation between English and a specified language; won't do anything if translation does not already exist
    public void replaceTranslation(String word, String translation, HashBiMap<String, String> language) {

    }

    // Will replace multiple translations between English and a specified language by matching up indices of each array
    // Items will be skipped if they do not already exist
    // words[] and translations[] must have equal length
    public void replaceTranslations(String words, String translations, HashBiMap<String, String> language) {

    }


    // Removes a translation of word between English and a specified language
    // Example removeTranslation("hello", spanish) will remove the translation "hello"="hola"
    public void removeTranslation(String word, HashBiMap<String, String> language) {

    }

    // Removes translations for multiple words between English and a specified language
    public void removeTranslations(String words, HashBiMap<String, String> language) {

    }


    // Translates an English word into a specified language
    // Example, translate("hello", spanish) returns "hola"
    public String translate(String word, HashBiMap<String, String> language) {

        return null;
    }

    // Translates multiple English words into a specified language
    public String[] translate(String[] word, HashBiMap<String, String> language) {

        return null;
    }

    // Will print a table of all the translations between English and a specified language
    public void printAllTranslations(HashBiMap<String, String> language) {

    }


    // Translates a word in a specified language into English
    public String backwardTranslate(String word, HashBiMap<String, String> language) {

        return null;
    }

    // Translates multiple words in a specified language into English
    public String[] backwardTranslate(String[] word, HashBiMap<String, String> language) {

        return null;
    }

    // Will print a table of all the translations between a specified language and English
    public void printAllTranslationsBackward(HashBiMap<String, String> language) {

    }


    public static void main(String[] args) {

    }
}