package by.ycovich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteDTO {
    @JsonProperty("waiter_id")
    private int waiter_id;
    @JsonProperty("table_count")
    private int table_count;
    @JsonProperty("date")
    private String date;

    public int getWaiter_id() {return waiter_id;}
    public int getTable_count() {return table_count;}
    public String getDate() {return date;}
}
