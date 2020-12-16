import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.visualgrid.model.*;

public class TestsPart3 extends TestsPart1 {

    public TestsPart3() {
        super.url = "https://demo.applitools.com/tlcHackathonMasterV2.html";
        super.browserList = new IRenderingBrowserInfo[]{
                new DesktopBrowserInfo(1200, 800, BrowserType.CHROME),
                new DesktopBrowserInfo(1200, 800, BrowserType.FIREFOX),
                new DesktopBrowserInfo(1200, 800, BrowserType.EDGE_CHROMIUM),
                new DesktopBrowserInfo(1200, 800, BrowserType.SAFARI),
                new IosDeviceInfo(IosDeviceName.iPhone_X, ScreenOrientation.PORTRAIT)
        };
    }
}