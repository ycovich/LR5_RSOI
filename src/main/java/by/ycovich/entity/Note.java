package by.ycovich.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int note_id;
    @Column(name = "waiter_id")
    private int waiter_id;
    @Column(name = "table_count")
    private int tableCount;
    @Column(name = "date")
    private String date;


    public Note(int waiter_id, int tableCount, String date) {
        this.waiter_id = waiter_id;
        this.tableCount = tableCount;
        this.date = date;
    }

    public Note() {}

    public int getWaiter_id() {return waiter_id;}
    public int getTableCount() {return tableCount;}
    public String getDate() {return date;}

    public void setWaiter_id(int waiter_id) {this.waiter_id = waiter_id;}
    public void setTableCount(int tableCount) {this.tableCount = tableCount;}
    public void setDate(String date) {this.date = date;}
}
