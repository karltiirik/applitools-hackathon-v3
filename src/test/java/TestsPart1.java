import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.model.IRenderingBrowserInfo;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.MainPage.Color;

public class TestsPart1 {

    public String url = "http://demo.applitools.com/tlcHackathonMasterV1.html";
    public IRenderingBrowserInfo[] browserList = {
            new DesktopBrowserInfo(1200, 800, BrowserType.CHROME)
    };
    static Eyes eyes;
    static Configuration config;
    static WebDriver webDriver;
    static VisualGridRunner runner;
    public static BatchInfo batchInfo;
    private MainPage mainPage = new MainPage();


    @BeforeClass
    public static void setUp() {
        // Get WebDriver instance from Selenide
        webDriver = WebDriverRunner.getAndCheckWebDriver();

        // Initialize the Runner for the test.
        runner = new VisualGridRunner(10);

        // Create Eyes object with the runner
        eyes = new Eyes(runner);

        // Set batch info
        batchInfo = new BatchInfo("Holiday Shopping");
    }


    public void configureEyes() {
        if (config == null) {
            config = new Configuration();
            config
                    .setApiKey(System.getenv("APPLITOOLS_API_KEY"))
                    .setBatch(batchInfo)
                    .setViewportSize(new RectangleSize(1200, 800))
                    .addBrowsers(browserList);
            eyes.setConfiguration(config);
        }
    }

    @Before
    public void openUrl() {
        configureEyes();
        webDriver.get(url);
    }

    public void openEyes(String testName) {
        eyes.open(webDriver,
                "AppliFashion",
                testName);
    }

    @Test
    public void test1() {
        openEyes("Test 1");
        eyes.checkWindow("main page");
    }

    @Test
    public void test2() {
        openEyes("Test 2");
        mainPage.selectColor(Color.BLACK)
                .filter();
        eyes.checkRegion(mainPage.productGrid, "filter by color");
    }

    @Test
    public void test3() {
        openEyes("Test 3");
        mainPage.selectProduct("Appli Air x Night");
        eyes.checkWindow("product details");
    }

    @After
    public void afterEachTest() {
        eyes.closeAsync();
    }

    @AfterClass
    public static void tearDown() {
        // we pass false to this method to suppress the exception that is thrown if we
        // find visual differences
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
        Selenide.closeWebDriver();
    }
}
