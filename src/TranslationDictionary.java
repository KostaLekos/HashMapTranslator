// Kosta Lekos
// June 12th, 2026
// One Way Translation Dictionary using Hash Map
// (English to any language, but not any language to English)
import java.util.HashMap;

public class TranslationDictionary {

    // Adds a translation for a word in source language (ex. English) in target language specified below
    // Example: word = "hello", translation = "hola", language = spanish
    public void addTranslation(String word, String translation, HashMap<String, String> language) {

    }

    // Replaces a translation for a language; won't do anything if translation does not already exist
    public void replaceTranslation(String word, String translation, HashMap<String, String> language) {

    }

    // Removes a language's translation for a word
    // Example removeTranslation("hello", spanish) will remove the translation "hello"="hola"
    public void removeTranslation(String word, HashMap<String, String> language) {

    }

    // Will add multiple translations to a language by matching up indices of each array
    // words[] and translations[] must have equal length
    public void addTranslations(String[] words, String[] translations, HashMap<String, String> language) {

    }

    // Will replace multiple translations to a language by matching up indices of each array
    // Items will be skipped if they do not already exist
    // words[] and translations[] must have equal length
    public void replaceTranslations(String words, String translations, HashMap<String, String> language) {

    }

    // Removes a language's translation for multiple words
    public void removeTranslations(String words, HashMap<String, String> language) {

    }

    // Translates a word in specified target language
    // Example, translate("hello", spanish) returns "hola"
    public String translate(String word, HashMap<String, String> language) {

        return null;
    }


    public static void main(String[] args) {

    }
}