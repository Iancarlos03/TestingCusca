package tasks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

public class Hooks {

    private static ChromeDriver driver;
    public static ResourceBundle rb = ResourceBundle.getBundle("urlBrowser");

    @Before
    public void setUp() throws IOException {

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/urlBrowser.properties");
        properties.load(inputStream);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.get(properties.getProperty("URL"));
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.get(rb.getString("URL"));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }

}