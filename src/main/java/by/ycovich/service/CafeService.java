package by.ycovich.service;

import by.ycovich.entity.Note;
import by.ycovich.entity.TableValue;
import by.ycovich.entity.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class CafeService {

    private final WaiterService waiterService;
    private final NoteService noteService;
    List<String> salaries = new ArrayList<>();
    List<String> profit = new ArrayList<>();

    @Autowired
    public CafeService(WaiterService waiterService, NoteService noteService) {
        this.waiterService = waiterService;
        this.noteService = noteService;
    }

    public void hire(String name){waiterService.hire(name);}

    public void fire(int id){waiterService.fire(id);}

    public List<Waiter> getWaiters(){
        return waiterService.findAll();
    }

    public List<Note> getNotes(){
        return noteService.findAll();
    }

    public void addNote(int id, int tableCount, String date){
        if (waiterService.find(id).isPresent()){
            noteService.addNote(new Note(id,tableCount, date));
            waiterService.setTableCount(id,tableCount);
        }else {
            System.out.println("\nwaiter not found\n");
        }
    }

    public void displayHistory(){
        noteService.displayHistory(waiterService);
    }

    public void calculateSalaries(){
        TableService.getValues();
        Random random = new Random();

        for (Waiter waiter:waiterService.findAll()){
            int salary = TableValue.SALARY;
            int bonus = TableValue.BONUS;
            int fine = TableValue.FINE;
            int id = waiter.getWaiter_id();
            int totalTip = 0;
            int totalTableCount = waiterService.getTotalTableCount(id);

            for (int i=0;i<totalTableCount;i++){
                int tip = random.nextInt((6-2+1)+2);
                totalTip += tip;
            }
            salary += (totalTip/2);

            waiterService.setTotalTip(id,0);
            waiterService.setTotalTip(id,totalTip);

            if (totalTableCount > 100) {
                int extraTables = totalTableCount-100;
                for (int i=0;i<extraTables;i++){
                    salary += bonus;
                    bonus++;
                }
                waiterService.setSalary(id, salary);
            }else if (totalTableCount<100){
                waiterService.setSalary(id,
                        salary- fine*(100-totalTableCount));
                if (waiterService.getSalary(id)<500){
                    waiterService.setSalary(id, 500);
                }
            }else waiterService.setSalary(id, salary);
        }
    }

    public void calculateProfit(){
        TableService.getValues();

        int totalTableCount=0;
        int totalPaychecks=0;
        int totalTips = 0;
        for (Waiter waiter: waiterService.findAll()){
            totalTableCount += waiterService.getTotalTableCount(waiter.getWaiter_id());
            totalPaychecks += waiterService.getSalary(waiter.getWaiter_id());
            totalTips += waiterService.getTotalTip(waiter.getWaiter_id());
        }

        profit.add("total tables served: "+totalTableCount);
        profit.add("total revenue: "+(totalTableCount * TableValue.CHECK + totalTips));
        profit.add("total paychecks: "+totalPaychecks);
        profit.add("total profit: "+(totalTableCount * TableValue.CHECK +totalTips - totalPaychecks));

        System.out.println();
        System.out.println("total tables served: "+totalTableCount);
        System.out.println("total revenue: "+(totalTableCount * TableValue.CHECK + totalTips));
        System.out.println("total paychecks: "+totalPaychecks);
        System.out.println("total profit: "+(totalTableCount * TableValue.CHECK +totalTips - totalPaychecks));
        System.out.println();
    }

    public void displaySalaries(){
        calculateSalaries();

        String formatLeft = "%-20.22s";
        String formatRight = "%25.23s";
        String format = formatLeft + " " + formatLeft + " " + formatRight;
        String[] info = {"waiter:", "tables [total]:", "salary:"};
        System.out.println();
        System.out.format(format, info[0], info[1], info[2]);
        System.out.println();

        List<Waiter> waiters = waiterService.findAll();
        waiters.sort(Comparator.comparing(Waiter::getTotalTableCount).reversed());

        for(Waiter waiter: waiters){
            String temp=
                            "[waiter: "+waiter.getName()+"]"
                            +"[total tables: "+waiter.getTotalTableCount()+"]"
                            +"[salary: "+waiter.getSalary()+"]";
            salaries.add(temp);
            System.out.format(format, waiter.getName(),waiter.getTotalTableCount(),waiter.getSalary());
            System.out.println();
        }
    }
    public List<String> getHistory(){
        return noteService.getHistory();
    }
    public List<String> getSalaries(){
        return salaries;
    }
    public List<String> getProfit(){
        return profit;
    }
}

