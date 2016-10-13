package com.suglob.transport.entity;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;



public class PassengerTrain extends Train{
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(PassengerTrain.class);

    private List<PassengerCarriage> listCarriages;

    public PassengerTrain(long id, String direction) {
        super(id, direction);
        logger.info("Passenger train was created: id= "+id+", direction= "+direction);
    }

    public List<PassengerCarriage> getListCarriages() {
        return listCarriages;
    }

    public void setListCarriages(List<PassengerCarriage> listCarriages) {
        this.listCarriages = listCarriages;
    }

    @Override
    public String toString() {
        return "PassengerTrain:" +"\n"+
                listCarriages;
    }
}
