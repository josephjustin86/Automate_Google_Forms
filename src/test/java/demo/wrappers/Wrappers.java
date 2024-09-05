package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    ChromeDriver driver;

    public Wrappers(ChromeDriver driver) {
        this.driver = driver;
    }

    public void navigateToGoogleForms() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("forms"));
        System.out.println("Successfully navigated to Google Forms");
    }

    public void inputName() throws InterruptedException {
        WebElement nameElement = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
        nameElement.sendKeys("Crio Learner");
        Thread.sleep(1000);
    }

    public void whyAutomation() throws InterruptedException {
        WebElement textElement = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        long epochTime = System.currentTimeMillis()/1000;
        System.out.println("Text:" + "I want to be the best QA Engineer! " + epochTime);
        textElement.sendKeys("I want to be the best QA Engineer! " + epochTime);
        Thread.sleep(1000);
    }

    public void experience() throws InterruptedException {
        WebElement experienceElement = driver.findElement(By.id("i16"));
        experienceElement.click();
        Thread.sleep(1000);
    }

    public void toolsLearned() throws InterruptedException {
        WebElement javaElement = driver.findElement(By.id("i30"));
        javaElement.click();
        WebElement seleniumElement = driver.findElement(By.id("i33"));
        seleniumElement.click();
        WebElement testNgElement = driver.findElement(By.id("i39"));
        testNgElement.click();
        Thread.sleep(1000);
    }

    public void addressed() throws InterruptedException {
        WebElement optionElement = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));
        optionElement.click();
        Thread.sleep(1000);
        WebElement mrElement = driver.findElement(By.xpath("(//div[@class='MocG8c HZ3kWc mhLiyf OIC90c LMgvRb' and @data-value='Mr'])[2]"));
        mrElement.click();
        Thread.sleep(1000);
    }

    public void navigateDate() throws InterruptedException {
        WebElement dateElement = driver.findElement(By.xpath("//input[@type='date']"));
        LocalDate date = LocalDate.now();
        LocalDate updatedDate = date.minusDays(7);
        DateTimeFormatter formattedDateObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = updatedDate.format(formattedDateObj);
        dateElement.sendKeys(formattedDate);  
        Thread.sleep(1000);
    }

    public void navigateTime() throws InterruptedException {
        WebElement hourElement = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
        WebElement minutesElement = driver.findElement(By.xpath("(//input[@type='number'])[2]"));
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter formatMin = DateTimeFormatter.ofPattern("mm");
        String updatedHour = dateTime.format(formatHour);
        String updatedMin = dateTime.format(formatMin);
        hourElement.sendKeys(updatedHour);
        minutesElement.sendKeys(updatedMin);
        Thread.sleep(1000);
    }

    public void submitForm() throws InterruptedException {
        WebElement submitElement = driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac' and text()='Submit']"));
        submitElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("formResponse"));
        WebElement successElement = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println(successElement.getText());
        Thread.sleep(1000);
    }

}
