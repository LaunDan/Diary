package diary;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Class presents database of diary
 */
public class Database {
    private ArrayList<Record> records;

    /**
     * Create ArrayList records
     */
    public Database() {
        records = new ArrayList<>();
    }

    /**
     * add record to the records
     *
     * @param dateTime date and time of records
     * @param text     the text of record
     */
    public void addRecord(LocalDateTime dateTime, String text) {
        records.add(new Record(dateTime, text));
    }

    /**
     * Find record in records and return found records
     *
     * @param date   date of record
     * @param byTime True/False for finding by time
     * @return found records
     */
    public ArrayList<Record> findRecords(LocalDateTime date, boolean byTime) {
        ArrayList<Record> found = new ArrayList<>();
        for (Record z : records) {
            if ((byTime && z.getDateTime().equals(date)) || (!byTime && z.getDateTime().toLocalDate().equals(date.toLocalDate()))) {
                found.add(z);
            }
        }
        return found;
    }

    /**
     * delete record by date
     *
     * @param date date of record which will be deleted
     */
    public void deleteRecords(LocalDateTime date) {
        ArrayList<Record> foundd = findRecords(date, true);
        for (Record z : foundd) {
            records.remove(z);
        }
    }
}
