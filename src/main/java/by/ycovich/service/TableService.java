package by.ycovich.service;

import by.ycovich.entity.TableValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TableService {
    public static void getValues(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("table.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                if (values.length == 2) {
                    String variableName = values[0];
                    int variableValue = Integer.parseInt(values[1]);
                    switch (variableName) {
                        case "CHECK" -> TableValue.CHECK = variableValue;
                        case "FINE" -> TableValue.FINE = variableValue;
                        case "BONUS" -> TableValue.BONUS = variableValue;
                        case "SALARY" -> TableValue.SALARY = variableValue;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
