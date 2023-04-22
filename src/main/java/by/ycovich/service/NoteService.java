package by.ycovich.service;

import by.ycovich.entity.Note;
import by.ycovich.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    List<String> history = new ArrayList<>();

    public List<String> getHistory() {return history;}

    public void addNote(Note note){
        noteRepository.save(note);
    }

    public void displayHistory(WaiterService waiterService){
        List<Note> notes = noteRepository.findAll();
        String formatLeft = "%-20.20s";
        String formatRight = "%25.25s";
        String format = formatLeft + " " + formatLeft + " " + formatRight;
        String[] info = {"waiter:", "date:", "tables served:"};
        System.out.println();
        System.out.format(format, info[0], info[1], info[2]);
        System.out.println();

        for (Note note:notes){
            String temp =
                            "[waiter: "+waiterService.getWaitersName(note.getWaiter_id())+"]"
                            +"[date: "+note.getDate()+"]"
                            +"[tables served: "+note.getTableCount()+"]";
            System.out.format(format,waiterService.getWaitersName(note.getWaiter_id()),note.getDate(),note.getTableCount());
            System.out.println();
            history.add(temp);
        }
    }

    public List<Note> findAll(){
        return noteRepository.findAll();
    }
}
