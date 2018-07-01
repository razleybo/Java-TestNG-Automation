package utils.webdriverHelpers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class meant to aggregate and simplify a web driver execution configurations
 */
public  class WebdriverConfigurations {

    public enum Browser{
        Chrome,Firefox;

    }
    public enum Execution {
        Local,Remote
    }
    /***
     * This method generate the desired capability for selenium execution ,
     * this assuming we only have Firefox and Chrome
     * @param browser required browser , Chrome or Firefox
     * @return Desired Capabilities, Chrome is default (typos will return Chrome )
     */
    public static DesiredCapabilities generateCapabilities (String browser){

        DesiredCapabilities dc = new DesiredCapabilities();

        if (browser.equalsIgnoreCase(Browser.Firefox.name())){
            FirefoxProfile ffProfile  =  new FirefoxProfile();
            dc.setCapability(FirefoxDriver.PROFILE,ffProfile);
        }
        else {
            dc.setCapability(ChromeOptions.CAPABILITY,
                    getChromeOptions());
        }
        return dc;
    }
    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}
