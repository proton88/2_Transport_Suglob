package com.suglob.transport.entity;

import com.suglob.transport.exception.NotSuchComfortLevelException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PassengerCarriage extends Carriage{
    private static final String COMMON="common";
    private static final String RESERVED_SEAT="reserved_seat";
    private static final String COMPARTMENT="compartment";
    private static final String SLEEPING="sleeping";
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";

    private static final int DEFAULT_MAX_BAGGAGE_CAPACITY=1000;
    private static final int MIN_BAGGAGE_CAPACITY=1000;
    private static final int MAX_BAGGAGE_CAPACITY=3500;

    private int maxBaggageCapacity;
    private ComfortLevel comfortLevel;

    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(PassengerCarriage.class);
    public enum ComfortLevel{
        COMMON(68),RESERVED_SEAT(54),COMPARTMENT(36),SLEEPING(18);
        private int numberPassengers;
        ComfortLevel(int numberPassengers){
            this.numberPassengers=numberPassengers;
        }

        public int getNumberPassengers() {
            return numberPassengers;
        }
    }


    public int getMaxBaggageCapacity() {
        return maxBaggageCapacity;
    }

    public void setMaxBaggageCapacity(int maxBaggageCapacity) {
        if (maxBaggageCapacity<MIN_BAGGAGE_CAPACITY||maxBaggageCapacity>MAX_BAGGAGE_CAPACITY){
            logger.warn("maxBaggageCapacity of carriage: "+maxBaggageCapacity+" " +
                    "replaced by a default value: "+DEFAULT_MAX_BAGGAGE_CAPACITY);
            this.maxBaggageCapacity = DEFAULT_MAX_BAGGAGE_CAPACITY;
        }else{
            this.maxBaggageCapacity=maxBaggageCapacity;
        }
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(String comfortLevel) throws NotSuchComfortLevelException {
        switch (comfortLevel){
            case COMMON:
                this.comfortLevel=ComfortLevel.COMMON;
                break;
            case RESERVED_SEAT:
                this.comfortLevel=ComfortLevel.RESERVED_SEAT;
                break;
            case COMPARTMENT:
                this.comfortLevel=ComfortLevel.COMPARTMENT;
                break;
            case SLEEPING:
                this.comfortLevel=ComfortLevel.SLEEPING;
                break;
            default:
                throw new NotSuchComfortLevelException("There isn't such level of comfort of the carriage");
        }
    }

    public void createPassengerCarriage(long id, int length, int width, int height, int weight,
                                        int maxBaggageCapacity, String comfortLevel) throws NotSuchComfortLevelException {
        setId(id);
        setLength(length);
        setWidth(width);
        setHeight(height);
        setWeight(weight);
        setMaxBaggageCapacity(maxBaggageCapacity);
        setComfortLevel(comfortLevel);
        logger.info("Passenger carriage was created: id= "+id);

    }

    @Override
    public String toString() {
        return "PassengerCarriage{" +
                "id=" + getId() +
                ", length=" + getLength() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", weight=" + getWeight() +
                ", maxBaggageCapacity=" + maxBaggageCapacity +
                ", comfortLevel=" + comfortLevel +
                '}'+"\n";
    }
}
