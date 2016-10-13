package com.suglob.transport.parser;

import com.suglob.transport.entity.PassengerCarriage;
import com.suglob.transport.exception.NotSuchComfortLevelException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarriageTxtParser {
    private static final String DELIMETER="[,;\\s]+";
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(CarriageTxtParser.class);
    public static List<PassengerCarriage> parsePassengerTxt(String filename) {
        List<PassengerCarriage> listCarriages = new ArrayList<>();
        try {
            Scanner fin = new Scanner(new FileReader(filename));
            String[] line;
            int counter = 0;
            while (fin.hasNextLine()) {
                counter++;
                line = fin.nextLine().split(DELIMETER);
                if (line.length != 7) {
                    logger.error("Wrong count of values of carriage in string: " + counter + ". This line will not be considered!");
                    continue;
                }
                PassengerCarriage passengerCarriage = new PassengerCarriage();

                try {
                    passengerCarriage.createPassengerCarriage(Long.parseLong(line[0]), Integer.valueOf(line[1]),
                            Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]),
                            Integer.parseInt(line[5]), line[6]);
                } catch (NumberFormatException e) {
                    logger.error("Wrong value of carriage in string: " + counter+ ". This line will not be considered!", e);
                    passengerCarriage = null;
                    continue;
                } catch (NotSuchComfortLevelException e) {
                    logger.error("Wrong comfort level of carriage in string: " + counter+ ". This line will not be considered!", e);
                    passengerCarriage = null;
                    continue;
                }
                listCarriages.add(passengerCarriage);
            }
        } catch (FileNotFoundException e) {
            logger.fatal("Fail " + filename + " is failed", e);
            throw new RuntimeException("Fail failed");
        }
        return listCarriages;
    }
}
