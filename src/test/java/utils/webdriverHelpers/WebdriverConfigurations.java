package utils.webdriverHelpers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public  class WebdriverConfigurations {

    public static enum Browser{
        Chrome,Firefox;

        @Override
        public String toString() {
            return this.name();
        }
    }
    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
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
}
