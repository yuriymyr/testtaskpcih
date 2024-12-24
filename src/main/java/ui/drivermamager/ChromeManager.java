package ui.drivermamager;

import com.microsoft.playwright.*;

public class ChromeManager {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;

    public static Page getPage() {
        if (page == null) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            browserContext = browser.newContext();
            page = browserContext.newPage();
        }
        return page;
    }

    public static void close() {
        if (page != null) {
            page.close();
            browserContext.close();
            browser.close();
            playwright.close();
            page = null;
        }
    }
}