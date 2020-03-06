package diary;

import java.time.LocalDateTime;

public class Record {
    private LocalDateTime dateTime;
    private String text;

    public Record(LocalDateTime dateTime, String text){
        this.dateTime = dateTime;
        this.text = text;
    }
    /**
     *
     */
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime){
         this.dateTime = dateTime;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    @Override
    public String toString(){
        return dateTime + " " + text;
    }
}
