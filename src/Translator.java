// Kosta Lekos
// June 12th, 2026
import java.util.Scanner;
import java.util.ArrayList;

public class Translator {

    // Helper functions:
    private static String capitalizeFirst(String s) {
        if (s == null || s.isEmpty()) return s;
        s = s.toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static Language selectLanguage(ArrayList<Language> languages, Scanner s) {
        int length = languages.size();
        System.out.println("Pick a language by number (0-" + (length - 1) + ")");

        for (int i = 0; i < length; i++) {
            System.out.println(i + ". " + languages.get(i).name);
        }

        int chosenLanguage = -1;
        while (true) {
            try {
                chosenLanguage = Integer.valueOf(s.nextLine());
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

    private static Language getLanguage(ArrayList<Language> languages, String languageName) {
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
        Language l = selectLanguage(languages, s);
        // Not yet implemented
    }

    public static void addTranslation(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        Language l = selectLanguage(languages, s);

        System.out.print("Enter word in " + linguaFranca + ": ");
        String word = s.nextLine().toLowerCase();
        System.out.println();

        System.out.print("Enter translation in " + l.name + ": ");
        String translation = s.nextLine().toLowerCase();
        System.out.println();

        l.addTranslation(word, translation);
    }

    public static void replaceTranslation(ArrayList<Language> languages, Scanner s) {
        Language l = selectLanguage(languages, s);
        // Not yet implemented
    }

    public static void removeTranslation(ArrayList<Language> languages, Scanner s) {
        Language l = selectLanguage(languages, s);
        // Not yet implemented
    }

    public static void printAllTranslations(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        Language l = selectLanguage(languages, s);
        // Not yet implemented
    }

    public static void addLanguage(ArrayList<Language> languages, Scanner s) {
        System.out.print("Enter name of new language: ");
        String languageName = capitalizeFirst(s.nextLine());
        System.out.println();
        languages.add(new Language(languageName));
    }

    public static void renameLanguage(String linguaFranca, ArrayList<Language> languages, Scanner s) {
        System.out.print("Enter old name of language: ");
        String oldName = capitalizeFirst(s.nextLine());
        System.out.println();

        System.out.print("Enter new name of language: ");
        String newName = capitalizeFirst(s.nextLine());
        System.out.println();

        getLanguage(languages, oldName).name = newName;
    }

    public static void removeLanguage(ArrayList<Language> languages, Scanner s) {
        System.out.print("Enter name of language to remove: ");
        String languageName = capitalizeFirst(s.nextLine());
        System.out.println();

        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).name.equals(languageName))
                languages.remove(i);
        }
    }

    public static void printAllLanguages(String linguaFranca, ArrayList<Language> languages) {
        System.out.println(linguaFranca + " (lingua franca)");

        for (Language l : languages) {
            System.out.println(l.name);
        }
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;

        String linguaFranca = "English";
        if (args.length > 0) {
            linguaFranca = args[0];
        }
        ArrayList<Language> languages = new ArrayList<>();

        printMainMenu();
        while (true) {
            System.out.println();
            System.out.print("Pick your action (0-10): ");
            input = s.nextLine();

            // Not yet implemented
            if (input == "0" || input.toLowerCase() == "help") {
                printMainMenu();
            } else if (input == "1" || input == "") {
                
            } else if (input == "2") {
                
            } else if (input == "3") {
                
            } else if (input == "4") {
                
            } else if (input == "5") {
                
            } else if (input == "6") {
                
            } else if (input == "7") {
                
            } else if (input == "8") {
                
            } else if (input == "9") {
                
            } else if (input == "10" || input.toLowerCase() == "exit") {
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        s.close();
    }
}
