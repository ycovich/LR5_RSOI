package by.ycovich;

import by.ycovich.service.CafeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class,args);
        CafeService cafeService = context.getBean(CafeService.class);
        /*
        cafeService.hire("Sean");
        cafeService.hire("Paul");
        cafeService.hire("Max");
        cafeService.hire("Larry");
        cafeService.addNote(1,27,"01.04");
        cafeService.addNote(1,20,"02.04");
        cafeService.addNote(1,6,"03.04");
        cafeService.addNote(1,5,"04.04");
        cafeService.addNote(1,6,"05.04");
        cafeService.addNote(1,7,"06.04");
        cafeService.addNote(1,8,"07.04");

        cafeService.addNote(2,40,"01.04");
        cafeService.addNote(2,50,"02.04");
        cafeService.addNote(2,30,"03.04");

        cafeService.addNote(3,1,"01.04");
        cafeService.addNote(3,2,"02.04");
        cafeService.addNote(3,4,"03.04");

        cafeService.addNote(4,4,"01.04");
        cafeService.addNote(4,4,"02.04");
        cafeService.addNote(4,5,"03.04");
         */

        /*
        cafeService.hire("John");
        cafeService.addNote(1,2,"02.04");
        cafeService.addNote(1,3,"03.04");
        cafeService.addNote(1,5,"04.04");
        cafeService.addNote(1,3,"05.04");
        cafeService.addNote(1,4,"06.04");
        cafeService.addNote(1,4,"07.04");
        cafeService.addNote(1,3,"08.04");
        cafeService.addNote(1,2,"09.04");
        cafeService.addNote(1,5,"10.04");
        cafeService.addNote(1,6,"11.04");
        cafeService.addNote(1,7,"12.04");
        cafeService.addNote(1,4,"13.04");
        cafeService.addNote(1,3,"14.04");
        cafeService.addNote(1,5,"15.04");
        cafeService.addNote(1,5,"16.04");
        cafeService.addNote(1,4,"17.04");
        cafeService.addNote(1,3,"18.04");
        cafeService.addNote(1,3,"19.04");
        cafeService.addNote(1,3,"20.04");
        cafeService.addNote(1,4,"21.04");
        cafeService.addNote(1,2,"22.04");
        cafeService.addNote(1,5,"23.04");
        cafeService.addNote(1,6,"24.04");
        cafeService.addNote(1,5,"25.04");
        cafeService.addNote(1,6,"26.04");

         */



        cafeService.displayHistory();
        cafeService.displaySalaries();
        cafeService.calculateProfit();
    }
}

