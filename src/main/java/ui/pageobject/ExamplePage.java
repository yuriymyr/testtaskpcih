package ui.pageobject;

import com.microsoft.playwright.Page;
import util.ConfigManager;
import util.LoggerUtil;

public class ExamplePage {
    private final Page page;
    private final String url;

    private ExamplePage(Page page) {
        this.page = page;
        this.url = ConfigManager.get("example.url");
        LoggerUtil.info("ExamplePage initialized with URL: " + url);
    }

    public static ExamplePage create(Page page) {
        return new ExamplePage(page);
    }

    public void open() {
        LoggerUtil.info("Navigating to: " + url);
        page.navigate(url);
        LoggerUtil.info("Navigation to " + url + " completed.");
    }

    public String getTitle() {
        LoggerUtil.info("Fetching the page title...");
        String title = page.title();
        LoggerUtil.info("Page title fetched: " + title);
        return title;
    }
}
