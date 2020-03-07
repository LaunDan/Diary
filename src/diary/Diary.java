package diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Diary {
    public static final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("d'.'M'.'y H:mm");
    public static final DateTimeFormatter FORMAT_DATA_WITHOUT_TIME = DateTimeFormatter.ofPattern("d'.'M'.'y");

    private Database database;
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public Diary() {
        database = new Database();
    }

    private LocalDateTime findOutDateTime() {
        System.out.println("Enter date and time in format [dd.mm.yyyy hh:mm]:");
        while (true) {
            try {
                return LocalDateTime.parse(sc.nextLine(), FORMAT_DATA);
            } catch (Exception ex) {
                System.out.println("Wrong entered, please enter again");
            }
        }
    }

    private LocalDateTime findOutDate() {
        System.out.println("Enter date in format [dd.mm.yyyy]:");
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine(), FORMAT_DATA_WITHOUT_TIME).atStartOfDay();
            } catch (Exception ex) {
                System.out.println("Wrong entered, please enter again");
            }
        }
    }

    publicc

    void printRecords(LocalDateTime day) {
        ArrayList<Record> records = database.findRecords(day, false);
        for (Record z : records) {
            System.out.println(z);
        }
    }

    public void findRecords() {
        LocalDateTime dateTime = findOutDate();
        ArrayList<Record> records = database.findRecords(dateTime, false);
        if (records.size() > 0) {
            System.out.println("Found records: ");
            for (Record z : records) {
                System.out.println(z);
            }
        } else {
            System.out.println("Wasn't found any records.");
        }
    }

    public void deleteRecords() {
        System.out.println("Delete records in date and time");
        LocalDateTime dateTime = findOutDateTime();
        database.deleteRecords(dateTime);
    }

    public void printMainScreen() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome in diary!");
        LocalDateTime today = LocalDateTime.now();
        System.out.printf("Today is: %s\n", FORMAT_DATA.format(today));
        System.out.println();
        System.out.println("Today: \n-----");
        printRecords(today);
        System.out.println();
        System.out.println("Tomorrow: \n-----");
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        printRecords(tomorrow);
        System.out.println();
    }
}