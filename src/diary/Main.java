package diary;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Diary diary = new Diary();
        String choose = "";
        while (!choose.equals("5")) {
            System.out.println();
            System.out.println("Choose action:\n1 - Add record\n2 - Find record\n3 - Delete record\n4 - Print plan\n5 - End");
            choose = sc.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    diary.addRecord();
                    break;
                case "2":
                    diary.findRecords();
                    break;
                case "3":
                    diary.deleteRecords();
                    break;
                case "4":
                    diary.printMainScreen();
                case "5":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Wrong choose, please repeat choose with any key.");
            }
        }
    }
}
