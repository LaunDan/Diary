package diary;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Database {
    private ArrayList<Record> records;
    public Database(){
        records = new ArrayList<>();
    }
    public void addRecord(LocalDateTime dateTime, String text){
        records.add(new Record(dateTime, text));
    }

    public ArrayList<Record> findRecords(LocalDateTime date, boolean byTime){
        ArrayList<Record> found = new ArrayList<>();
        for (Record z : records){
            if ((byTime && z.getDateTime().equals(date)) || (!byTime && z.getDateTime().toLocalDate().equals(date.toLocalDate()))){
                found.add(z);
            }
        }
        return found;
    }
    public void deleteRecords(LocalDateTime date){
        ArrayList<Record> foundd = findRecords(date, true);
        for (Record z : foundd){
            records.remove(z);
        }
    }
}
