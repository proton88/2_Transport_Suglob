package com.suglob.transport.entity;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public abstract class Carriage {
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    private static final int DEFAULT_ID=1000_000;
    private static final int MIN_ID=1000_000;
    private static final int MAX_ID=9_999_999;
    private static final int DEFAULT_LENGTH=10000;
    private static final int MIN_LENGTH=10000;
    private static final int MAX_LENGTH=40000;
    private static final int DEFAULT_WIDTH=3000;
    private static final int MIN_WIDTH=2500;
    private static final int MAX_WIDTH=4000;
    private static final int DEFAULT_HEIGTH=3000;
    private static final int MIN_HEIGTH=1000;
    private static final int MAX_HEIGTH=4200;
    private static final int DEFAULT_WEIGTH=10000;
    private static final int MIN_WEIGTH=10000;
    private static final int MAX_WEIGTH=20000;
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(Carriage.class);
    private long id;
    private int length;
    private int width;
    private int height;
    private int weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id<MIN_ID||id>MAX_ID){
            logger.warn("id of carriage: "+id+" replaced by a default value: "+DEFAULT_ID);
            this.id = DEFAULT_ID;
        }else{
            this.id = id;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length<MIN_LENGTH||length>MAX_LENGTH){
            logger.warn("length of carriage: "+length+ " replaced by a default value: "+DEFAULT_LENGTH);
            this.length = DEFAULT_LENGTH;
        }else{
            this.length=length;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width<MIN_WIDTH||width>MAX_WIDTH){
            logger.warn("width of carriage: "+width+" replaced by a default value:"+DEFAULT_WIDTH);
            this.width = DEFAULT_WIDTH;
        }else{
            this.width=width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height<MIN_HEIGTH||height>MAX_HEIGTH){
            logger.warn("height of carriage: "+height+" replaced by a default value: "+DEFAULT_HEIGTH);
            this.height = DEFAULT_HEIGTH;
        }else{
            this.height=height;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight<MIN_WEIGTH||weight>MAX_WEIGTH){
            logger.warn("weight of carriage: "+weight+" replaced by a default value:"+DEFAULT_WEIGTH);
            this.weight = DEFAULT_WEIGTH;
        }else{
            this.weight=weight;
        }
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
