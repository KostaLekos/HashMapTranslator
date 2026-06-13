// Kosta Lekos
// June 12th, 2026
import java.util.Scanner;
import java.util.ArrayList;

public class Translator {
    int test;

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

    public static void translate(String linguaFranca, ArrayList<Language> languages) {

    }

    public static void addTranslation(ArrayList<Language> languages) {

    }

    public static void replaceTranslation(ArrayList<Language> languages) {

    }

    public static void removeTranslation(ArrayList<Language> languages) {

    }

    public static void printAllTranslations(String linguaFranca, ArrayList<Language> languages) {

    }

    public static void addLanguage(ArrayList<Language> languages) {

    }

    public static void renameLanguage(String linguaFranca, ArrayList<Language> languages) {

    }

    public static void removeLanguage(ArrayList<Language> languages) {

    }

    public static void printAllLanguages(String linguaFranca, ArrayList<Language> languages) {

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
