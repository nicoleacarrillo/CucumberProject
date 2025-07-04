package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before

    //defines my precondition
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        //scenario class holds the complete information about the execution

        byte [] pic;

        if (scenario.isFailed()){
            pic=takeScreenshot("failed/"+scenario.getName());
        }else {
            pic=takeScreenshot("passed/"+scenario.getName());
        }

        //attach the screenshot in a report
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }
}
