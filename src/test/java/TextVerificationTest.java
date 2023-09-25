import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextVerificationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testerautomatyzujacy.dev");
    }

    @Test
    public void verifyTextOnPage() {
        // Pobierz tekst z wszystkich elementów na stronie za pomocą metody findElements i strumienia stream
        List<WebElement> elements = driver.findElements(By.xpath(".//*[starts-with(@id,'menu')]"));
        List<String> elementTexts = elements.stream().map(WebElement::getText).collect(Collectors.toList());

        // Porównaj pobrany tekst z listą oczekiwanych wartości
        List<String> expectedTexts = Arrays.asList("HOME", "O MNIE", "BLOG", "KONTAKT");
        Assert.assertEquals(elementTexts, expectedTexts);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

