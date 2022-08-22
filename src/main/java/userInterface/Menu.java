package userInterface;

import files.FilesCommander;

import java.util.Scanner;

public class Menu {

    public static void mainMenu(){
        System.out.println("WELCOME TO FILE COMMANDER 1.0.0");
        System.out.println("1 - Add prefix to all files in a folder");
        System.out.println("2 - Add suffix to all files in a folder");
        System.out.println("3 - Replace substring to all files in a folder");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1: prefixAdder();
            case 2: suffixAdder();
            case 3: substringReplacer();
            default: mainMenu();
        }
    }

    public static void prefixAdder(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter folder path");
            String path = scanner.nextLine();
            System.out.println("Enter prefix you want to add");
            String prefix = scanner.nextLine();
            System.out.println("Press X continue or anything else to cancel");
            String decision = scanner.nextLine();
            if(decision.equalsIgnoreCase("X")) {
                FilesCommander.addPrefix(path, prefix);
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        mainMenu();
    }

    public static void suffixAdder(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter folder path");
            String path = scanner.nextLine();
            System.out.println("Enter suffix you want to add");
            String suffix = scanner.nextLine();
            System.out.println("Press X continue or anything else to cancel");
            String decision = scanner.nextLine();
            if(decision.equalsIgnoreCase("X")) {
                FilesCommander.addSuffix(path, suffix);
                System.out.println("SUCCESSFUL");
            }
            mainMenu();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void substringReplacer(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter folder path");
            String path = scanner.nextLine();
            System.out.println("Enter substring you want to replace");
            String startSubstring = scanner.nextLine();
            System.out.println("Enter substring you want to be replaced with");
            String endSubstring = scanner.nextLine();
            System.out.println("Press X continue or anything else to cancel");
            String decision = scanner.nextLine();
            if(decision.equalsIgnoreCase("X")) {
                FilesCommander.replaceSubstring(path, startSubstring, endSubstring);
                System.out.println("SUCCESSFUL");
            }
            mainMenu();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
