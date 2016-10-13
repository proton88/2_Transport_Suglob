package test.com.suglob.transport.action;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Created by User on 10.10.2016.
 */
public class TrainTestRunListener extends RunListener {
    private static final String PROPERTY_FILE_LOG4J="property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(TrainTestRunListener.class);
    @Override
    public void testStarted(Description description) throws Exception{
        logger.info("test is started: "+description.getMethodName());
    }

    @Override
    public void testFinished(Description description) throws Exception{
        logger.info("test is finished: " + description.getMethodName() + "\n-----------------------------");
    }

    @Override
    public void testFailure(Failure failure) throws Exception{
        logger.info("test is failed:" + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception{
        logger.info("test was ignored: " + description.getMethodName() + "\n--------------------------");
    }

    @Override
    public void testRunFinished(Result result) throws Exception{
        logger.info("result of tests:");
        logger.info("time execute: " + result.getRunTime() + " millis");
        logger.info("Count of tests: " + result.getRunCount());
        logger.info("tests was failed: " + result.getFailureCount());
        logger.info("tests was ignored: " + result.getIgnoreCount());
        logger.info("all tests were successfully:"+ result.wasSuccessful());
    }
}
