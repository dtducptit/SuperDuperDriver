package com.udacity.SuperDuperDriver.SuperDuperDriver.tests;

import com.udacity.SuperDuperDriver.SuperDuperDriver.CloudStorageApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdCriteriaTest {
        @FindBy(id = "nav-credentials-tab")
        public WebElement credentialsTab;

        @FindBy(id = "addCredential")
        public WebElement addCredentialButton;

        @FindBy(id = "editCredential")
        public WebElement editCredentialButton;

        @FindBy(id = "deleteCredential")
        public WebElement deleteCredentialButton;

        @FindBy(id = "credential-url")
        public WebElement credentialUrl;

        @FindBy(id = "credential-username")
        public WebElement credentialUsername;

        @FindBy(id = "credential-password")
        public WebElement credentialPassword;

        @FindBy(id = "submitCredential")
        public WebElement credentialSubmitButton;



        public ThirdCriteriaTest(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void credentialsTab() {
            credentialsTab.click();
        }

        public void addCredentialButton() {
            addCredentialButton.click();
        }

        public void editCredentialButton() {
            editCredentialButton.click();
        }


        public void setCredentialUrl(String creUrl) {
            credentialUrl.sendKeys(creUrl);
        }

        public void setCredentialUsername(String creUsername) {
            credentialUsername.sendKeys(creUsername);
        }

        public void setCredentialPassword(String crePassword) {
            credentialPassword.sendKeys(crePassword);
        }

        public void credentialSubmitButton() {
            credentialSubmitButton.click();
        }

        public void setCredentialForm(String creUrl, String creUsername, String crePassword) {
            setCredentialUrl(creUrl);
            setCredentialUsername(creUsername);
            setCredentialPassword(crePassword);
        }

        public void createNewCredential(String credentialUrl, String credentialUsername, String credentialPassword) {
            credentialsTab();
            addCredentialButton();
            setCredentialForm(credentialUrl, credentialUsername, credentialPassword);
            credentialSubmitButton();
        }

        public void editCredential(String credentialUrl, String credentialUsername, String credentialPassword) {
            credentialsTab();
            editCredentialButton();
            resetCredentialForm();
            setCredentialForm(credentialUrl, credentialUsername, credentialPassword);
            credentialSubmitButton();
        }
        public void resetCredentialForm() {
            credentialUrl.clear();
            credentialUsername.clear();
            credentialPassword.clear();
        }
        public void deleteCredential() {
            credentialsTab();
            deleteCredentialButton.click();
        }


}
class ThirdCriteriaTests extends CloudStorageApplicationTests{
    private String url = "www.udacity.com";
    private String username = "duc";
    private String password = "a1";
    @Test
    public void testAddCredential() {
        ThirdCriteriaTest thirdCriteriaTest = new ThirdCriteriaTest(driver);
        signupLogin(firstname , lastname,"a1",password);
        thirdCriteriaTest.createNewCredential(url,username,password );
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertEquals("Credential successfully added",message.getText());
    }
    @Test
    public void testEditCredential() {
        ThirdCriteriaTest thirdCriteriaTest = new ThirdCriteriaTest(driver);
        signupLogin(firstname , lastname,"a2",password);
        thirdCriteriaTest.createNewCredential(url,username,password );
        thirdCriteriaTest.editCredential("www.google.com","maa" ,"123");
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertNotEquals("Something went wrong",message.getText());
    }
    @Test
    public void testDeleteCredential() {
        ThirdCriteriaTest thirdCriteriaTest = new ThirdCriteriaTest(driver);
        signupLogin(firstname , lastname,"a3",password);
        thirdCriteriaTest.createNewCredential(url,username,password );
        thirdCriteriaTest.deleteCredential();
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertEquals("Credential successfully deleted",message.getText());
    }



}