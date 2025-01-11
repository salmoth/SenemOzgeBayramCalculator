package testCases;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Locators;
import locators.Locators.ActionBuilderPageLocators;
import org.junit.experimental.theories.Theories;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Test sırasını belirlemek için
public class CalculatorTestCases {

    public static final Logger logger = LoggerFactory.getLogger(CalculatorTestCases.class);
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allowed-ips=192.168.1.1,10.0.0.1");

        if (this.driver == null) {
            this.driver = new ChromeDriver();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        logger.info("Hesap Makinesi Uygulama Adresi Açıldı.");
        String username = ConfigReader.getProperty("username");
        logger.info("Kullanıcı Adı Config Dosyasından Alındı.");
        String password = ConfigReader.getProperty("password");
        logger.info("Şifre Config Dosyasından Alındı.");

        sleep(1000);

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/input"));
        logger.info("Kullanıcı Adı Alanı Bulundu.");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[3]/div/input"));
        logger.info("Şifre Alanı Bulundu.");

        usernameField.sendKeys(username);
        logger.info("Kullanıcı Adı Girildi.");

        passwordField.sendKeys(password);
        logger.info("Şifre Girildi.");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[4]/div"));
        logger.info("Oturum Aç Buton Bulundu.");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loginButton);
        logger.info("Oturum Aç Butonuna Basıldı.");

        sleep(1000);

        WebElement openCalculator = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[2]"));
        logger.info("Open Calculator Butonu Bulundu.");
        jsExecutor.executeScript("arguments[0].click();", openCalculator);
        logger.info("Open Calculator Butonuna Basıldı.");

    }

    @Test
    @Order(1)
    @DisplayName("Senaryo 1: Yatırım Hesaplaması - " +
            "%5 faiz ile 100 TL'nin 1 yıl sonraki değeri hesaplanacaktır. " +
            "Formül: A=100×(1+(0.05×1))=100×1.05=105")
    public void testInvestmentCalculation() throws InterruptedException {
        logger.info("Test: Yatırım Hesaplaması - %5 Faiz ile 100 TL başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAdd));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: + Bulundu.");
        WebElement buttonFive = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFive));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonMultiply = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonMultiply));
        logger.info("Buton: * Bulundu.");
        WebElement buttonDot = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonDot));
        logger.info("Buton: . Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));;
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        // A=100×(1+(0.05×1))=100×1.05=105 işlemini yapılıyor. Önce parantez içi yapılacak.
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonDot.click();
        logger.info(". Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonAdd.click();
        logger.info("+ Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Beklenen Sonuç: 105, Gerçekleşen Sonuç: {}", AreaResult);
        assertEquals("= 105", AreaResult, "Yatırım Hesaplaması Hatalı!");

        logger.info("Test: Yatırım Hesaplaması İşlemi Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(2)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 1: Gelir 1000 TL, Gider 800 TL, Beklenen Sonuç 200 TL\n")
    public void testMonthlyBudgetCalculationCase1() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 1: 1000-800=200 Hesaplaması Başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonEight = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEight));
        logger.info("Buton: 8 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));;
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 1000 TL, Gider 800 TL, Beklenen Sonuç 200 TL Hesaplaması Başlatılıyor.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonEight.click();
        logger.info("8 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: 200, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= 200", actualText, "Test: Aylık Bütçe Hesaplaması Veri 1: 1000-800=200 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 1: 1000-800=200 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(3)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 2: Gelir 1000 TL, Gider 1000 TL, Beklenen Sonuç 0 TL\n")
    public void testMonthlyBudgetCalculationCase2() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 2: 1000-1000=0 Hesaplaması Başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 1000 TL, Gider 1000 TL, Beklenen Sonuç 0 TL Hesaplaması Başlatılıyor.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: 0, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= 0", actualText, "Test: Aylık Bütçe Hesaplaması Veri 2: 1000-1000=0 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 2: 1000-1000=0 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(4)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 3: Gelir 1000 TL, Gider 1200 TL, Beklenen Sonuç -200 TL\n")
    public void testMonthlyBudgetCalculationCase3() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 3: 1000-1200=-200 Hesaplaması Başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonTwo = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonTwo));
        logger.info("Buton: 2 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 1000 TL, Gider 1200 TL, Beklenen Sonuç -200 TL Hesaplaması Başlatılıyor.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonTwo.click();
        logger.info("2 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: -200, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= -200", actualText, "Test: Aylık Bütçe Hesaplaması Veri 3: 1000-1200=-200 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 3: 1000-1200=-200 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }


    @Test
    @Order(5)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 4: Gelir 2000 TL, Gider 1000 TL, Beklenen Sonuç 1000 TL\n")
    public void testMonthlyBudgetCalculationCase4() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 4: 2000-1000=-1000 Hesaplaması Başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonTwo = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonTwo));
        logger.info("Buton: 2 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 2000 TL, Gider 1000 TL, Beklenen Sonuç 1000 TL Hesaplaması Başlatılıyor.");
        buttonTwo.click();
        logger.info("2 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: 1000, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= 1000", actualText, "Test: Aylık Bütçe Hesaplaması Veri 4: 2000-1000=-1000 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 4: 2000-1000=-1000 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(6)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 5: Gelir 1500 TL, Gider 500 TL, Beklenen Sonuç 1000 TL\n")
    public void testMonthlyBudgetCalculationCase5() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 5: 1500-500=1000 Hesaplaması Başlatıldı.");

        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonFive = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFive));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 1500 TL, Gider 500 TL, Beklenen Sonuç 500 TL Hesaplaması Başlatılıyor.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: 1000, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= 1000", actualText, "Test: Aylık Bütçe Hesaplaması Veri 5: 1500-500=1000 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 5: 1500-500=1000 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(7)
    @DisplayName("Senaryo 2: Aylık Bütçe Hesaplaması -\n " +
            "Veri 6: Gelir 500 TL, Gider 500 TL, Beklenen Sonuç 0 TL\n")
    public void testMonthlyBudgetCalculationCase6() throws InterruptedException {

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 6: 500-500=0 Hesaplaması Başlatıldı.");

        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonFive = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFive));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonSubstract = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonSubstract));
        logger.info("Buton: - Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        logger.info("Gelir 500 TL, Gider 500 TL, Beklenen Sonuç 0 TL Hesaplaması Başlatılıyor.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonSubstract.click();
        logger.info("- Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Girilen İşlem: {}", AreaResult);

        sleep(1000);

        WebElement actualResults = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.actualResults));
        String actualText = actualResults.getText();
        logger.info("İşlem Sonucu Bulundu.");
        logger.info("Beklenen Sonuç: 1000, Gerçekleşen Sonuç: {}", actualText);
        assertEquals("= 0", actualText, "Test: Aylık Bütçe Hesaplaması Veri 6: 500-500=0 Hesaplaması Hatalı!");

        logger.info("Test: Aylık Bütçe Hesaplaması Veri 6: 500-500=0 Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(8)
    @DisplayName("Senaryo 4: Kısa Vadeli Yatırım Hesaplaması - " +
            "%3 Faiz ile 500 TL'lik Yatırımın 6 Ay Sonraki Değeri Hesaplanacaktır." +
            "Formül: ￼A = 500×(1+(0.03×0.5))=507.5")
    public void testShortTermInvestment() throws InterruptedException {

        logger.info("Test: Kısa Vadeli Yatırım Hesaplaması Başlatıldı.");

        WebElement buttonFive = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFive));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAdd));
        logger.info("Buton: + Bulundu.");
        WebElement buttonThree = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonThree));
        logger.info("Buton: 3 Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement buttonMultiply = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonMultiply));
        logger.info("Buton: * Bulundu.");
        WebElement buttonDot = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonDot));
        logger.info("Buton: . Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonDot.click();
        logger.info(". Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonThree.click();
        logger.info("3 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonDot.click();
        logger.info(". Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonAdd.click();
        logger.info("Artı Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Beklenen Sonuç: 507.5, Gerçekleşen Sonuç: {}", AreaResult);
        assertEquals("= 507.5", AreaResult, "Kısa vadeli Yatırım Hesaplaması Hatalı!");

        logger.info("Test: Kısa Vadeli Yatırım Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(9)
    @DisplayName("Senaryo 5: Günlük Gider Takibi\n - " +
            "Giderler: 20 TL yemek, 10 TL ulaşım, 5 TL kahve.\n" +
            "Hesaplama: 20+10+5=35")
    public void testDailyExpenseTracking() throws InterruptedException {

        logger.info("Test: Günlük Gider Takibi Hesaplaması Başlatıldı.");

        WebElement buttonFive = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFive));
        logger.info("Buton: 5 Bulundu.");
        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAdd));
        logger.info("Buton: + Bulundu.");
        WebElement buttonTwo = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonTwo));
        logger.info("Buton: 2 Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        buttonTwo.click();
        logger.info("2 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonAdd.click();
        logger.info("+ Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonAdd.click();
        logger.info("+ Butonuna Tıklandı.");
        buttonFive.click();
        logger.info("5 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Beklenen Sonuç: 35, Gerçekleşen Sonuç: {}", AreaResult);
        assertEquals("= 35", AreaResult, "Günlük Gider Takibi Hesaplaması Hatalı!");

        logger.info("Test: Günlük Gider Takibi Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @Test
    @Order(10)
    @DisplayName("Senaryo 6: Yıllık Yatırım Hesaplaması\n - " +
            "%4 Faiz Oranı ile 200 TL'lik Bir Yatırımın 1 Yıl Sonraki Değeri Hesaplanacaktır.\n" +
            "Formül: A=200×(1+(0.04×1))=208\n")
    public void testAnnualInvestmentCalculation() throws InterruptedException {

        logger.info("Test: Yıllık Yatırım Hesaplaması Başlatıldı.");

        WebElement buttonFour = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonFour));
        logger.info("Buton: 4 Bulundu.");
        WebElement buttonOne = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonOne));
        logger.info("Buton: 1 Bulundu.");
        WebElement buttonZero = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonZero));
        logger.info("Buton: 0 Bulundu.");
        WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAdd));
        logger.info("Buton: + Bulundu.");
        WebElement buttonTwo = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonTwo));
        logger.info("Buton: 2 Bulundu.");
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonEqual));
        logger.info("Buton: = Bulundu.");
        WebElement buttonMultiply = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonMultiply));
        logger.info("Buton: * Bulundu.");
        WebElement buttonDot = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonDot));
        logger.info("Buton: . Bulundu.");
        WebElement areaResult = wait.until(ExpectedConditions.visibilityOfElementLocated(ActionBuilderPageLocators.areaResults));
        logger.info("Sonuç Alanı Bulundu.");
        WebElement buttonAC = wait.until(ExpectedConditions.elementToBeClickable(ActionBuilderPageLocators.buttonAC));
        logger.info("Buton: AC Bulundu.");

        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonDot.click();
        logger.info(". Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonFour.click();
        logger.info("4 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonDot.click();
        logger.info(". Butonuna Tıklandı.");
        buttonAdd.click();
        logger.info("Artı Butonuna Tıklandı.");
        buttonOne.click();
        logger.info("1 Butonuna Tıklandı.");
        buttonMultiply.click();
        logger.info("* Butonuna Tıklandı.");
        buttonTwo.click();
        logger.info("2 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonZero.click();
        logger.info("0 Butonuna Tıklandı.");
        buttonEqual.click();
        logger.info("= Butonuna Tıklandı.");
        sleep(1000);

        String AreaResult = areaResult.getText();
        logger.info("Beklenen Sonuç: 208, Gerçekleşen Sonuç: {}", AreaResult);
        assertEquals("= 208", AreaResult, "Yıllık Yatırım Hesaplaması Hatalı!");

        logger.info("Test: Yıllık Yatırım Hesaplaması Başarıyla Tamamlandı.");

        buttonAC.click();
        logger.info("Sonuç Ekranı Temizlendi.");
    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }
}
