package com.udacity.SuperDuperDriver.SuperDuperDriver.tests;

import com.udacity.SuperDuperDriver.SuperDuperDriver.CloudStorageApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondCriteriaTest {

    @FindBy(id="nav-notes-tab")
    public WebElement noteTab;

    @FindBy(id = "addNote")
    public WebElement addNoteButton;

    @FindBy(id = "btnEditNote")
    public WebElement editNoteButton;

    @FindBy(id = "deleteNote")
    public WebElement deleteNoteButton;

    @FindBy(id = "note-title")
    public WebElement noteTitle;

    @FindBy(id = "note-description")
    public WebElement noteDescription;

    @FindBy(id = "submitNote")
    public WebElement noteSubmitButton;
    public SecondCriteriaTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void notesTab() {
       noteTab.click();
    }

    public void AddNoteButton() {
        addNoteButton.click();
    }

    public void editNoteButton() {
        editNoteButton.click();
    }

    public void setNoteTitle(String noteTit) {
        noteTitle.sendKeys(noteTit);
    }

    public void setNoteDescription(String noteDes) {
        noteDescription.sendKeys(noteDes);
    }

    public void NoteSubmitButton() {
        noteSubmitButton.click();
    }

    public void setNoteForm(String noteTitle, String noteDescription) {
        setNoteTitle(noteTitle);
        setNoteDescription(noteDescription);
    }
    public void resetNoteForm() {
        noteDescription.clear();
        noteTitle.clear();
    }

    public void createNewNote(String noteTitle, String noteDescription) {
        notesTab();
        AddNoteButton();
        setNoteForm(noteTitle, noteDescription);
        NoteSubmitButton();
    }

    public void editNote(String noteTitle, String noteDescription) {
        notesTab();
        editNoteButton();
        resetNoteForm();
        setNoteForm(noteTitle, noteDescription);
        NoteSubmitButton();

    }
    public void deleteNote() {
        notesTab();
        deleteNoteButton.click();
    }
}
class SecondCriteriaTests extends CloudStorageApplicationTests {
    @Test
    public void testAddNote() {
        SecondCriteriaTest secondCriteriaTests = new SecondCriteriaTest(driver);
        signupLogin(firstname , lastname,"duc",password);
        secondCriteriaTests.createNewNote("noteTitleExample", "noteDescriptionExample");
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertEquals("Note successfully uploaded",message.getText());
    }
    @Test
    public void testEditNote() {
        SecondCriteriaTest secondCriteriaTests = new SecondCriteriaTest(driver);
        signupLogin(firstname , lastname,"duc1",password);
        secondCriteriaTests.createNewNote("noteTitleExample", "noteDescriptionExample");
        secondCriteriaTests.editNote("hey", "hey");
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertNotEquals("Something went wrong",message.getText());
    }
    @Test
    public void testDeleteNote() {
        SecondCriteriaTest secondCriteriaTests = new SecondCriteriaTest(driver);
        signupLogin(firstname , lastname,"duc2",password);
        secondCriteriaTests.createNewNote("noteTitleExample", "noteDescriptionExample");
        secondCriteriaTests.deleteNote();
        WebElement message = driver.findElement(By.id(messageId));
        Assertions.assertEquals("Note successfully deleted",message.getText());
    }
}