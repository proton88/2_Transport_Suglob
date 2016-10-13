package com.suglob.transport.action;

import com.suglob.transport.comparator.CarriageByComfortComparator;
import com.suglob.transport.entity.PassengerCarriage;
import com.suglob.transport.entity.PassengerTrain;
import com.suglob.transport.entity.Train;
import com.suglob.transport.parser.CarriageTxtParser;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.List;


public class ActionPassengerTrain extends ActionAbstractTrain{
    private static final String DELIMETER="-";
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(ActionPassengerTrain.class);

    public void createCarriages(PassengerTrain passengerTrain, String filename){
        List<PassengerCarriage> listCarriages=CarriageTxtParser.parsePassengerTxt(filename);
        passengerTrain.setListCarriages(listCarriages);
        logger.info("Passenger' carriages was created");
    }

    public void createCarriages(PassengerTrain passengerTrain, PassengerCarriage ...carriages){
        List<PassengerCarriage> listCarriages=new ArrayList<>();
        for (PassengerCarriage carriage:carriages){
            listCarriages.add(carriage);
        }
        passengerTrain.setListCarriages(listCarriages);
        logger.info("Passenger' carriages was created");
    }

    public int maxNumberPassengersOfTrain(PassengerTrain passengerTrain){
        int numberPassengers=0;
        for (PassengerCarriage carriage:passengerTrain.getListCarriages()){
            numberPassengers+=carriage.getComfortLevel().getNumberPassengers();
        }
        logger.info("Max number passengers of train was counted:" +numberPassengers);
        return numberPassengers;
    }

    public int commonMaxBaggageCapacity(PassengerTrain passengerTrain){
        int baggageCapacity=0;
        for (PassengerCarriage carriage:passengerTrain.getListCarriages()){
            baggageCapacity+=carriage.getMaxBaggageCapacity();
        }
        logger.info("Max baggage capacity of train was counted:" +baggageCapacity);
        return baggageCapacity;
    }

    public void sortByComfort(PassengerTrain passengerTrain){
        passengerTrain.getListCarriages().sort(new CarriageByComfortComparator());
        logger.info("Sort by comfort level of train was executed");
    }

    public List<PassengerCarriage> findCarriagesByCountPassengers(PassengerTrain passengerTrain,
                                                                  int minCountPassengers, int maxCountPassengers){
        List<PassengerCarriage> carriageList=new ArrayList<>();
        for (PassengerCarriage carriage:passengerTrain.getListCarriages()){
            int countPassengers=carriage.getComfortLevel().getNumberPassengers();
            if (countPassengers<=maxCountPassengers&&countPassengers>=minCountPassengers){
                carriageList.add(carriage);
            }
        }
        return carriageList;
    }

    @Override
    public void goIn(Train train) {
        String[] cities=train.getDirection().split(DELIMETER);
        System.out.println("The passenger train goes in "+cities[1]);
    }
}
