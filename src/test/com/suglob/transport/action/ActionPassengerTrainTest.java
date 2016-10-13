package test.com.suglob.transport.action;


import com.suglob.transport.action.ActionPassengerTrain;
import com.suglob.transport.entity.PassengerCarriage;
import com.suglob.transport.entity.PassengerTrain;
import com.suglob.transport.exception.NotSuchComfortLevelException;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(TrainTestRunner.class)
public class ActionPassengerTrainTest {
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(ActionPassengerTrainTest.class);
    private static final String DIRECTION="Minsk-Gomel";
    private static final String COMMON="common";
    private static final String SLEEPING="sleeping";
    private static final String FILE_FOR_CARRIAGES="file/passenger_carriages.txt";

    private static ActionPassengerTrain action;
    private static PassengerTrain train;

    @BeforeClass
    public static void initActionPassengerTrain(){
        action=new ActionPassengerTrain();
        train=new PassengerTrain(7460442,DIRECTION);
        PassengerCarriage carriage1=new PassengerCarriage();
        PassengerCarriage carriage2=new PassengerCarriage();
        try {
            carriage1.createPassengerCarriage(3520814, 15000, 3500, 3000, 12000, 2000, COMMON);
            carriage2.createPassengerCarriage(3520815,15000,3500,3000,12000,1200,SLEEPING);
        } catch (NotSuchComfortLevelException e) {
            logger.error("Wrong comfort level of carriage",e);
        }
        action.createCarriages(train, carriage1, carriage2);

    }


    @Test
    public void checkMaxNumberPassengersOfTrainTest(){
        int actual=action.maxNumberPassengersOfTrain(train);
        int expected=86;
        Assert.assertEquals("Wrong number passengers. Test failed",actual, expected);
    }

    @Test
    public void checkCommonMaxBaggageCapacityTest(){
        int actual=action.commonMaxBaggageCapacity(train);
        int expected=3200;
        Assert.assertEquals("Wrong max baggage capacity. Test failed",actual,expected);
    }

}
