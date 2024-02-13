package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".home")
    private WebElement home;
    @FindBy(css = ".queue.active")
    private WebElement currentQueue;
    @FindBy(xpath = "//a[@class='songs']")
    private WebElement allSongs;
    @FindBy(css = ".albums.active")
    private WebElement albums;
    @FindBy(css = ".artists.active")
    private WebElement artists;
    @FindBy(css = ".playlist.favorites")
    private WebElement favorites;
    @FindBy(css = ".playlist.recently-played")
    private WebElement recentlyPlayed;
    @FindBy(css = "[title='iew/edit user profile']")
    private WebElement userProfile;
    @FindBy(css = "#searchForm input")
    private WebElement aboutKoel;
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    private WebElement createNewPlaylistBtn;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistContextMenu;
    @FindBy(css = "[name='create-simple-playlist-form'] input")
    private WebElement playlistNameInputField;
    @FindBy(css = ".success.show")
    private WebElement playlistCreatedPopUp;

    public void createNewPlaylist (String playlistName) {
        createNewPlaylistBtn();
        //findElementByLocator(createNewPlaylistBtn).click();
        findElementByLocator(newPlaylistContextMenu).click();
        WebElement playlistNameInput = findElementByLocator(playlistNameInputField);
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.RETURN);
    }

    public void goToAllSongs () {
        findElementByLocator(allSongs).click();
    }

    public WebElement getPlaylistCreatedPopUp () {
        return playlistCreatedPopUp;
    }

    public void createNewPlaylistBtn() {
        findElementByLocator(createNewPlaylistBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocator(createNewPlaylistBtn).click();
    }
}
