package com.suglob.transport.entity;

public abstract class Train {
    private long id;
    private String direction;
    public Train(long id, String direction) {
        this.id = id;
        this.direction = direction;
    }
    public long getId() {
        return id;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
