package by.ycovich.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WaiterDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("table_count")
    private int table_count;
    @JsonProperty("salary")
    private int salary;

    public String getName() {return name;}
    public int getTable_count() {return 0;}
    public int getSalary() {return 0;}
}
