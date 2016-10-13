package com.suglob.transport.entity;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

public class CargoTrain extends Train{
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(CargoTrain.class);

    private List<CargoCarriage> listCarriages;
    public CargoTrain(long id, String direction) {
        super(id, direction);
        logger.info("Cargo train was created: id= "+id+", direction= "+direction);
    }
    public List<CargoCarriage> getListCarriages() {
        return listCarriages;
    }

    public void setListCarriages(List<CargoCarriage> listCarriages) {
        this.listCarriages = listCarriages;
    }
}
