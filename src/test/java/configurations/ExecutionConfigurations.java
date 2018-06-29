package configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecutionConfigurations {

    private static Logger logger = LogManager.getLogger(ExecutionConfigurations.class);
    private static ExecutionConfigurations configurations = null;

    private String hubUrl;
    private String browser;
    private String execution;

    private ExecutionConfigurations(){
        setupConfigurations();
        configurations=this;
    }
    public static ExecutionConfigurations getConfigurations(){
        if (configurations == null)
            configurations= new ExecutionConfigurations();

        return configurations;
    }

    public final String getBrowser() {
        return browser;
    }
    public final String getExecution() {
        return execution;
    }
    public final String getHubUrl() {
        return hubUrl;
    }

    private void setupConfigurations(){

        //loading configurations from file would be more close to changes
        hubUrl = System.getProperty("selenium.hub.url");
        logger.debug("loading Configuration selenium.hub.url = "+hubUrl);

        browser = System.getProperty("selenium.browser","Chrome");
        logger.debug("loading Configuration selenium.browser = "+browser);

        execution = System.getProperty("selenium.execution","Local");
        logger.debug("loading Configuration selenium.execution = "+execution);
    }
}
