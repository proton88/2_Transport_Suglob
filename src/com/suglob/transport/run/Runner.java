package com.suglob.transport.run;

import com.suglob.transport.action.ActionPassengerTrain;
import com.suglob.transport.entity.PassengerCarriage;
import com.suglob.transport.entity.PassengerTrain;
import com.suglob.transport.factory.ActionAbstractTrainFactory;
import com.suglob.transport.factory.ActionPassengerTrainFactory;

import java.util.ArrayList;
import java.util.List;


public class Runner {
    private static final String DIRECTION="Minsk-Gomel";
    private static final String FILE_FOR_CARRIAGES="file/passenger_carriages.txt";
    private static final int MIN_COUNT_PASSENGERS=20;
    private static final int MAX_COUNT_PASSENGERS=40;
    private static final int NUMBER_TRAIN=7460442;
    public static void main(String[] args) {
        PassengerTrain train=new PassengerTrain(NUMBER_TRAIN,DIRECTION);
        ActionPassengerTrain actionPassengerTrain=new ActionPassengerTrain();
        actionPassengerTrain.createCarriages(train, FILE_FOR_CARRIAGES);
        ActionAbstractTrainFactory trainFactory=new ActionPassengerTrainFactory();
        trainFactory.createActionTrain().goIn(train);
        System.out.println("Train before sort:\n" + train);
        actionPassengerTrain.sortByComfort(train);
        System.out.println("Train after sort:\n"+train);
        List<PassengerCarriage> listCarriages=new ArrayList<>();
        listCarriages=actionPassengerTrain.findCarriagesByCountPassengers(train,MIN_COUNT_PASSENGERS,MAX_COUNT_PASSENGERS);
        System.out.println("Carriages where passengers count between "+MIN_COUNT_PASSENGERS+" and "+
                MAX_COUNT_PASSENGERS+": \n"+listCarriages);

    }
}
