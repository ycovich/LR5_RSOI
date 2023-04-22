package by.ycovich.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "waiter")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int waiter_id;
    @Column(name = "name")
    private String name;
    @Column(name = "table_count")
    public int totalTableCount;
    @Column(name = "salary")
    private int salary;
    @Column(name = "total_tip")
    private int totalTip;

    public Waiter() {}

    public void setWaiter_id(int id) {this.waiter_id = id;}
    public void setName(String name) {this.name = name;}
    public void setTotalTableCount(int totalTableCount) {this.totalTableCount = totalTableCount;}
    public void setSalary(int salary) {this.salary = salary;}
    public void setTotalTip(int totalTip) {this.totalTip = totalTip;}

    public int getWaiter_id() {return waiter_id;}
    public String getName() {return name;}
    public int getTotalTableCount() {return totalTableCount;}
    public int getSalary() {return salary;}
    public int getTotalTip() {return totalTip;}


}
