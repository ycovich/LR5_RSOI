package by.ycovich.service;

import by.ycovich.entity.Waiter;
import by.ycovich.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterService {
    private final WaiterRepository waiterRepository;
    @Autowired
    public WaiterService(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    public void hire(String name){
        Waiter waiter = new Waiter();
        waiter.setName(name);
        waiterRepository.save(waiter);
    }

    public void fire(int id){
        waiterRepository.deleteById(id);
    }

    public Optional<Waiter> find(int id){
        return waiterRepository.findById(id);
    }

    public List<Waiter> findAll(){
        return waiterRepository.findAll();
    }

    public String getWaitersName(int id){
        return waiterRepository.findById(id).get().getName();
    }

    public void setTableCount(int id, int tableCount){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        waiter.get().setTotalTableCount(waiter.get().getTotalTableCount()+tableCount);
        waiterRepository.save(waiter.get());
    }

    public int getTotalTableCount(int id){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        return waiter.get().getTotalTableCount();
    }

    public void setTotalTip(int id, int tip){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        waiter.get().setTotalTip(waiter.get().getTotalTip()+tip);
        waiterRepository.save(waiter.get());
    }

    public int getTotalTip(int id){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        return waiter.get().getTotalTip();
    }

    public void setSalary(int id, int salary){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        waiter.get().setSalary(salary);
        waiterRepository.save(waiter.get());
    }

    public int getSalary(int id) {
        Optional<Waiter> waiter = waiterRepository.findById(id);
        return waiter.get().getSalary();
    }

}
