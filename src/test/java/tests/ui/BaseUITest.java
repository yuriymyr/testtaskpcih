package tests.ui;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.drivermamager.ChromeManager;


public abstract class BaseUITest {
    protected Page page;

    @BeforeClass
    public void setupUI() {
        page = ChromeManager.getPage();
    }

    @AfterClass
    public void teardownUI() {
        ChromeManager.close();
    }
}
