package test.com.suglob.transport.action;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


public class TrainTestRunner extends BlockJUnit4ClassRunner {
    private TrainTestRunListener trainTestRunListener;
    public TrainTestRunner(Class<TrainTestRunListener> klass) throws InitializationError {
        super(klass);
        trainTestRunListener=new TrainTestRunListener();
    }

    public void run(RunNotifier notifier){
        notifier.addListener(trainTestRunListener);
        super.run(notifier);
    }
}