package com.suglob.transport.action;

import com.suglob.transport.entity.Train;

public class ActionCargoTrain extends ActionAbstractTrain {
    private static String DELIMETER="-";
    @Override
    public void goIn(Train train) {
        String[] cities=train.getDirection().split(DELIMETER);
        System.out.println("The cargo train goes in "+cities[1]);
    }
}
