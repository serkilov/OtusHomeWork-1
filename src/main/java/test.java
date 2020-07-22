import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class test {
    private Logger log = LogManager.getLogger(test.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        log.info("Открыта страница отус");
        String title = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        //driver.getTitle();
        log.info("Проверка title");
        assertEquals(title, driver.getTitle());
    }

    @After
    public void setDown() {
        if (driver != null) {
            log.info("Драйвер закрыт");
            driver.quit();
        }
    }
}
