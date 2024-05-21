package com.udacity.SuperDuperDriver.SuperDuperDriver.tests;

import com.udacity.SuperDuperDriver.SuperDuperDriver.CloudStorageApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstCriteriaTests extends CloudStorageApplicationTests {

    @Test
    public void unauthorizedUserAccessibleRoutes(){
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("Login", driver.getTitle());

        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        driver.get("http://localhost:" + this.port + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());
    }

    @Test
    public void SignupLoginAccessHomeLogout(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        signupLogin(firstname,lastname,"a1",password);
        Assertions.assertEquals("Home" ,driver.getTitle() );

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutbtn")));
        WebElement logoutButton = driver.findElement(By.id("logoutbtn"));
        logoutButton.click();


        moveTo("/home");
        Assertions.assertNotEquals("Home" ,driver.getTitle() );

    }
}
