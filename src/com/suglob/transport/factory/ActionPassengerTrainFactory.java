package com.suglob.transport.factory;

import com.suglob.transport.action.ActionPassengerTrain;

public class ActionPassengerTrainFactory extends ActionAbstractTrainFactory {
    @Override
    public ActionPassengerTrain createActionTrain() {
        return new ActionPassengerTrain();
    }
}
