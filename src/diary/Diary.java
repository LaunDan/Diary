package diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Diary {
    public static  final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("d'.'M'.'y H:mm");
    public static  final DateTimeFormatter FORMAT_DATA_WITHOUT_TIME = DateTimeFormatter.ofPattern("d'.'M'.'y");

    private Database database;
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public Diary() {
        database = new Database();
    }

    private LocalDateTime findOutDateTime(){
        System.out.println("Enter date and time in format [dd.mm.yyyy hh:mm]:");
        while (true){
            try {
                return LocalDateTime.parse(sc.nextLine(), FORMAT_DATA);
            } catch (Exception ex){
                System.out.println("Wrong entered, please enter again");
            }
        }
    }
    private LocalDateTime findOutDate(){
        System.out.println("Enter date in format [dd.mm.yyyy]:");
        while (true){
            try {
                return LocalDate.parse(sc.nextLine(), FORMAT_DATA_WITHOUT_TIME).atStartOfDay();
            } catch (Exception ex){
                System.out.println("Wrong entered, please enter again");
            }
        }
    }
}