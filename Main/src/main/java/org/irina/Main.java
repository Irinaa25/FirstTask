package org.irina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
            FileReader fileReader = new FileReader();

            University university = new University();
            university.createUniversity(fileReader.readFromFile(args[0]));

            Set<String> faculty = university.getFacultiesOfStudent("АаааааА");

            log.info("Факультеты на которых учатся студент : {}", faculty.toString());


            university.transferToAnotherFaulty("Аааааав", "ПММ", "МОИАИС", "11");

            faculty = university.getFacultiesOfStudent("Аааааав");


            log.info("Факультеты на которых учатся студент после перевода : {}", faculty.toString());

    }
}
