package com.suglob.transport.entity;


public class CargoCarriage extends Carriage {
    private int capacity;
    private int bearingCapacity;
    private TypeCarriage typeCarriage;

    private enum TypeCarriage{
        COVERED, GONDOLA, PLATFORM, HOPPER, DUMP_CAR, TANK;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBearingCapacity() {
        return bearingCapacity;
    }

    public void setBearingCapacity(int bearingCapacity) {
        this.bearingCapacity = bearingCapacity;
    }

    public TypeCarriage getTypeCarriage() {
        return typeCarriage;
    }

    public void setTypeCarriage(TypeCarriage typeCarriage) {
        this.typeCarriage = typeCarriage;
    }
}
