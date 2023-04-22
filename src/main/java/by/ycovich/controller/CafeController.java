package by.ycovich.controller;

import by.ycovich.dto.NoteDTO;
import by.ycovich.dto.WaiterDTO;
import by.ycovich.entity.Note;
import by.ycovich.entity.Waiter;
import by.ycovich.repository.NoteRepository;
import by.ycovich.repository.WaiterRepository;
import by.ycovich.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;
    private final WaiterRepository waiterRepository;
    private final NoteRepository noteRepository;
    @Autowired
    public CafeController(CafeService cafeService, WaiterRepository waiterRepository, NoteRepository noteRepository) {
        this.cafeService = cafeService;
        this.waiterRepository = waiterRepository;
        this.noteRepository = noteRepository;
    }

    @GetMapping()
    public ResponseEntity getCafe() {
        try {
            return ResponseEntity.ok("server started");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("shit happens");
        }
    }

    @GetMapping("/waiters")
    public ResponseEntity displayWaiters() {
        try {
            return ResponseEntity.ok(cafeService.getWaiters());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("shit happens");
        }
    }

    @GetMapping("/notes")
    public ResponseEntity displayNotes() {
        try {
            return ResponseEntity.ok(cafeService.getNotes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("shit happens");
        }
    }

    @PostMapping("/hire")
    public Waiter hire(@RequestBody WaiterDTO waiterDTO){
        Waiter waiter = new Waiter();
        waiter.setName((waiterDTO.getName()));
        waiter.setTotalTableCount(waiterDTO.getTable_count());
        waiter.setSalary(waiterDTO.getSalary());
        return waiterRepository.save(waiter);
    }

    @DeleteMapping("/fire/{id}")
    public ResponseEntity fire(@PathVariable int id) {
        String name = waiterRepository.findById(id).get().getName();
        try {
            cafeService.fire(id);
            return ResponseEntity.ok(name+" fucked up and was fired");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("shit happens");
        }
    }

    @PostMapping("/addNote")
    public Note addNote(@RequestBody NoteDTO noteDTO){
        Note note = new Note();
        note.setWaiter_id(noteDTO.getWaiter_id());
        note.setTableCount(noteDTO.getTable_count());
        note.setDate(noteDTO.getDate());
        return noteRepository.save(note);
    }

    @GetMapping("/displayHistory")
    public ResponseEntity<List> displayHistory(){
        try {
            return ResponseEntity.ok(cafeService.getHistory());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("shit happens"));
        }
    }

    @GetMapping("/displaySalaries")
    public ResponseEntity<List> displaySalaries(){
        try {
            return ResponseEntity.ok(cafeService.getSalaries());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("shit happens"));
        }
    }
    
    @GetMapping("/displayProfit")
    public ResponseEntity<List> displayProfit(){
        try {
            return ResponseEntity.ok(cafeService.getProfit());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("shit happens"));
        }
    }
}

