package com.suglob.transport.factory;

import com.suglob.transport.action.ActionCargoTrain;

/**
 * Created by User on 10.10.2016.
 */
public class ActionCargoTrainFactory extends ActionAbstractTrainFactory {
    @Override
    public ActionCargoTrain createActionTrain() {
        return new ActionCargoTrain();
    }
}
