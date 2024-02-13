import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsPageTests extends BaseTest {
    @Test(enabled = true, priority = 2, description = "Playing the first song from all songs")
    public void playFirstSongFromAllSongs(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.loginWithValidCredentials();
        homePage.goToAllSongs();
        allSongsPage.playFirstSong();
        Assert.assertTrue(allSongsPage.getVisualizer().isDisplayed());
    }

    @Test(enabled = true, priority = 2, description = "Playing the last song from all songs")
    public void playLastSongFromAllSongs() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.loginWithValidCredentials();
        homePage.goToAllSongs();
        allSongsPage.playLastSong();
        Assert.assertTrue(allSongsPage.getVisualizer().isDisplayed());
    }
}
