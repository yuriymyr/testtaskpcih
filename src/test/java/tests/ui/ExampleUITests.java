package tests.ui;

import org.testng.annotations.Test;
import ui.pageobject.ExamplePage;

import static org.testng.Assert.assertEquals;

public class ExampleUITests extends BaseUITest {

    @Test(description = "Verify that the title of Example.com is 'Example Domain'")
    public void testExamplePageTitle() {
        var examplePage = ExamplePage.create(page);
        examplePage.open();

        assertEquals(examplePage.getTitle(), "Example Domain", "Page title does not match!");
    }
}
