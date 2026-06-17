// Kosta Lekos
// June 12th, 2026
// This is the main file to run
// Enter 'quick test' to quickly add languages and word
// To see what was added, use the list languages and list translations options
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Translator {

    // Helper functions:
    private static String capitalizeFirst(String s) { // aAaaAA -> Aaaaaa
        if (s == null || s.isEmpty()) return s;
        s = s.toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static Language selectLanguage(ArrayList<Language> languages, Scanner s) { // Returns a language from language list (lingua franca is not and option)
        int length = languages.size();

        System.out.println("Pick a language by number (1-" + (length) + "):");

        for (int i = 1; i <= length; i++) {
            System.out.println(i + ". " + languages.get(i - 1).name);
        }

        int chosenLanguage = -1;
        while (true) {
            try {
                System.out.print("> ");
                chosenLanguage = Integer.valueOf(s.nextLine()) - 1;
                System.out.println(chosenLanguage + 1); //temp
                System.out.println();
                if (chosenLanguage >= 0 && chosenLanguage < length) {
                    break;
                } else {
                    System.out.println("Answer is not a valid language, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Answer is not a number, please try again.");
            }
        }
        return languages.get(chosenLanguage);
    }

    private static Language selectLanguage(String linguaFranca, ArrayList<Language> languages, Scanner s, boolean isSource) { // Also includes lingua franca as option
        int length = languages.size();
        System.out.println("Pick a " + ((isSource) ? ("source ") : ("target ")) + "language by number (1-" + (length + 1) + "):");

        System.out.println("1. " + linguaFranca);
        for (int i = 2; i <= length + 1; i++) {
            System.out.println(i + ". " + languages.get(i - 2).name);
        }

        int chosenLanguage = -1;
        while (true) {
            try {
                System.out.print("> ");
                chosenLanguage = Integer.valueOf(s.nextLine()) - 2;
                System.out.println(chosenLanguage + 2); //temp
                System.out.println();
                if (chosenLanguage >= -1 && chosenLanguage < length) {
                    break;
                } else {
                    System.out.println("Answer is not a valid language, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Answer is not a number, please try again.");
            }
        }
        if (chosenLanguage <= -1) return null; // null = lingua franca, outside function will interpret this result as so
        return languages.get(chosenLanguage);
    }

    private static Language getLanguage(String languageName, ArrayList<Language> languages) { // Get language from language name
        for (Language l : languages) {
            if (l.name.equals(languageName)) return l;
        }
        return null;
    }


    // Action functions:
    public static void printMainMenu() {
        System.out.println("Action Choices: ");
        System.out.println("0. View this menu again");
        System.out.println("1. Translate a word (default)");
        System.out.println("2. Add a translation");
        System.out.println("3. Replace a translation");
        System.out.println("4. Remove a translation");
        System.out.println("5. View all translations");
        System.out.println("6. Add a language");
        System.out.println("7. Rename a language");
        System.out.println("8. Remove a language");
        System.out.println("9. View all languages");
        System.out.println("10. Exit");
    }


    public static void translate(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        Language source = selectLanguage(linguaFranca, languages, s, true);
        Language target = selectLanguage(linguaFranca, languages, s, false);
        String sourceName = (source == null) ? (linguaFranca) : (source.name);
        String targetName = (target == null) ? (linguaFranca) : (target.name);

        System.out.print("Enter word in " + sourceName + ": ");
        String word = s.nextLine().toLowerCase();
        String translation = "ERROR";
        System.out.println();
        
        if (word.trim().equals("")) {
            System.out.println("\"" + word + "\" is not a word.");
            return;
        }

        if (sourceName.equals(targetName)) { // No two languages can have the same name
            translation = word;
        } else {
            if (sourceName.equals(linguaFranca)) {
                translation = target.translate(word);
            } else if (targetName.equals(linguaFranca)) {
                translation = source.reverseTranslate(word);
            } else {
                String temp = source.reverseTranslate(word);
                translation = target.translate(temp);
            }
        }

        if (translation == null) {
            System.out.println("No translation for \"" + word + "\" currently exists in " + targetName);
        } else {
            System.out.println("\"" + word + "\" in " + sourceName + " is equal to \"" + translation + "\" in " + targetName + ".");
        }
    }

    public static void addTranslation(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        Language l = selectLanguage(languages, s);

        System.out.print("Enter word in " + linguaFranca + ": ");
        String word = s.nextLine().toLowerCase();
        System.out.println();

        if (word.trim().equals("")) {
            System.out.println("\"" + word + "\" is not a word.");
            return;
        }

        System.out.print("Enter translation in " + l.name + ": ");
        String translation = s.nextLine().toLowerCase();
        System.out.println();

        if (translation.trim().equals("")) {
            System.out.println("\"" + translation + "\" is not a word.");
            return;
        }

        l.addTranslation(word, translation);
        System.out.println("Added \"" + word + " = " + translation + "\" to " + l.name + " dictionary.");
    }

    public static void replaceTranslation(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        Language l = selectLanguage(languages, s);

        System.out.print("Enter word in " + linguaFranca + ": ");
        String word = s.nextLine().toLowerCase();
        System.out.println();

        if (word.trim().equals("")) {
            System.out.println("\"" + word + "\" is not a word.");
            return;
        }

        System.out.print("Enter new translation in " + l.name + ": ");
        String newTranslation = s.nextLine().toLowerCase();
        System.out.println();

        if (newTranslation.trim().equals("")) {
            System.out.println("\"" + newTranslation + "\" is not a word.");
            return;
        }

        String oldTranslation = l.translate(word);
        boolean isReplaced = l.replaceTranslation(word, newTranslation);

        if (isReplaced) {
            System.out.println("Replaced \"" + word + " = " + oldTranslation + "\" with \"" + word + " = " + newTranslation + "\".");
        } else {
            System.out.println("\"" + word + "\" does not currently exist in " + l.name + " dictionary.");
        }
    }

    public static void removeTranslation(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        Language l = selectLanguage(languages, s);

        System.out.print("Enter word in " + linguaFranca + " to remove: ");
        String word = s.nextLine().toLowerCase();
        System.out.println();

        l.removeTranslation(word);
        System.out.println("Removed \"" + word + "\" from " + l.name + " dictionary.");
    }

    public static void printAllTranslations(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        Language source = selectLanguage(linguaFranca, languages, s, true);
        Language target = selectLanguage(linguaFranca, languages, s, false);
        String sourceName = (source == null) ? (linguaFranca) : (source.name);
        String targetName = (target == null) ? (linguaFranca) : (target.name);

        if (target != null && target.isEmpty()) {
            System.out.println(targetName + " does not have any translations.");
            return;
        } else if (source != null && source.isEmpty()) {
            System.out.println(sourceName + " does not have any translations.");
            return;
        }

        System.out.println(sourceName + "\t\tto " + targetName);
        if (sourceName.equals(targetName)) { // No two languages can have the same name
            if (source == null) {
                System.out.println("The lingua franca does not store words of its own. Try comparing it to another language.");
            } else {
                Iterator<String> words = source.getBiMap().getAllValues().iterator();
    
                String currentWord;
                while (words.hasNext()) {
                    currentWord = words.next();
                    System.out.println(currentWord + "\t\t= " + currentWord);
                }
            }
        } else {
            if (sourceName.equals(linguaFranca)) {
                target.printAllTranslations();
            } else if (targetName.equals(linguaFranca)) {
                source.printAllReverseTranslations();
            } else {
                Iterator<String> words = source.getBiMap().getAllValues().iterator();

                String currentWord;
                String temp;
                String currentTranslation;
                while (words.hasNext()) {
                    currentWord = words.next();
                    temp = source.reverseTranslate(currentWord);
                    currentTranslation = target.translate(temp);
                    System.out.println(currentWord + "\t\t= " + currentTranslation);
                }
            }
        }
    }

    public static void addLanguage(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        System.out.print("Enter name of new language: ");
        String languageName = capitalizeFirst(s.nextLine());
        System.out.println();
        if (!languageName.equals(linguaFranca) && getLanguage(languageName, languages) == null) {
            languages.add(new Language(languageName));
            System.out.println("Added " + languageName + " language.");
        } else {
            System.out.println(languageName + " already exists!");
        }
    }

    public static String renameLanguage(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        System.out.print("Enter old name of language: ");
        String oldName = capitalizeFirst(s.nextLine());
        System.out.println();

        System.out.print("Enter new name of language: ");
        String newName = capitalizeFirst(s.nextLine());
        System.out.println();

        if (oldName.equals(linguaFranca)) {
            linguaFranca = newName;
            return linguaFranca;
        }

        Language l = getLanguage(oldName, languages);
        if (l == null) {
            System.out.println(oldName + " does not currently exist. You may want to add " + newName + " instead.");
        } else {
            l.name = newName;
            System.out.println("Renamed " + oldName + " language to " + newName + ".");
        }
        return null;
    }

    public static void removeLanguage(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        if (languages.isEmpty()) {
            System.out.println("Not enough languages to preform this action. Try adding a language first.");
            return;
        }

        System.out.print("Enter name of language to remove: ");
        String languageName = capitalizeFirst(s.nextLine());
        System.out.println();

        if (languageName.equalsIgnoreCase(linguaFranca)) {
            System.out.println("Cannot remove the lingua franca. You may rename it and replace all its translations instead if you wish.\n" + 
            "Alternatively, a simplier solution would be to run a new instance of the program with a new lingua franca.");
            return;
        }

        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).name.equals(languageName))
                languages.remove(i);
                System.out.println("Removed " + languageName + " language.");
                return;
        }
        System.out.println(languageName + " does not exist.");
    }

    public static void printAllLanguages(String linguaFranca, ArrayList<Language> languages) {
        System.out.println(linguaFranca + " (lingua franca)");

        for (Language l : languages) {
            System.out.println(l.name);
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputString;
        int inputInt;
        boolean testRan = false; // Whether or not quick test has been run

        String linguaFranca = "English";
        if (args.length > 0) {
            linguaFranca = args[0];
        }
        ArrayList<Language> languages = new ArrayList<>();

        System.out.println();
        printMainMenu();
        while (true) {
            System.out.println();
            System.out.print("Pick your action (0-10): ");
            inputString = s.nextLine();
            System.out.print(inputString);
            System.out.println();
            try {
                inputInt = Integer.valueOf(inputString);
            } catch (Exception e) {
                inputInt = -1;
            }

            if (inputInt == 0 || inputString.toLowerCase().equals("help")) {
                printMainMenu();
            } else if (inputInt == 1 || inputString.equals("")) {
                translate(linguaFranca, languages, s);
            } else if (inputInt == 2) {
                addTranslation(linguaFranca, languages, s);
            } else if (inputInt == 3) {
                replaceTranslation(linguaFranca, languages, s);
            } else if (inputInt == 4) {
                removeTranslation(linguaFranca, languages, s);
            } else if (inputInt == 5) {
                printAllTranslations(linguaFranca, languages, s);
            } else if (inputInt == 6) {
                addLanguage(linguaFranca, languages, s);
            } else if (inputInt == 7) {
                renameLanguage(linguaFranca, languages, s);
            } else if (inputInt == 8) {
                removeLanguage(linguaFranca, languages, s);
            } else if (inputInt == 9) {
                printAllLanguages(linguaFranca, languages);
            } else if (inputInt == 10 || inputString.toLowerCase().equals("exit")) {
                break;
            } else if (inputString.length() > 9 && inputString.toLowerCase().substring(0, 10).equals("quick test")) {
                if (testRan && !inputString.toLowerCase().equals("quick test force")) {
                    System.out.println("Quick test has already been run.");
                } else if (linguaFranca.equals("English")) {
                    languages.add(new Language("Spanish"));
                    languages.add(new Language("Greek"));
                    languages.add(new Language("Japanese"));

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
            
                    getLanguage("Spanish", languages).addTranslations(enWords, spWords);
                    getLanguage("Greek", languages).addTranslations(enWords, grWords);
                    getLanguage("Japanese", languages).addTranslations(enWords, jaWords);                    

                    System.out.println("Quick test ran. You can view what was added with options 5 and 9.");
                    testRan = true;
                } else {
                    System.out.println("Quick test requires lingua franca to be English. It is currently " + linguaFranca + ".");
                }

            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
        s.close();
    }
}
