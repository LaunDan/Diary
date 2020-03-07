package diary;

import java.time.LocalDateTime;

/**
 * Class present record of diary
 */
public class Record {
    private LocalDateTime dateTime;
    private String text;

    /**
     * class presents record of diary
     *
     * @param dateTime date and time
     * @param text     text of record
     */
    public Record(LocalDateTime dateTime, String text) {
        this.dateTime = dateTime;
        this.text = text;
    }

    /**
     * @return date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the date time to set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return Diary.FORMAT_DATA.format(dateTime) + " " + text;
    }
}
