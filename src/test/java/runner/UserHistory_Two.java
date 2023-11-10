package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/UserHistory_2.feature",
        glue = {"tasks", "stepDefinitions"},
        plugin = {"json:test/report/cucumber_report.json"})

public class UserHistory_Two {
    @AfterClass
    public static void reporte(){
        try {
            System.out.println("Generando reporte");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte generado con exito");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
