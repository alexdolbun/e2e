package top-domen-name.company-domen-name.common;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * BasePage class
 *
 * Extends from this class! ^^ 
 * Example:
 * public class LoginPage extends BasePage<LoginPage> { // Greetings, my friend! Implement the methods that you need here! }
 * <br/>
 */

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public abstract class BasePage<Page> extends SelenidePageFactory {

    protected WebDriver driver;

    protected BasePage() {
        this.page(WebDriverRunner.driver(), this);
        this.driver = WebDriverRunner.getWebDriver();
    }

    public Page screenshotEntryPage() {
        this.screenshot();
        return (Page) this;
    }

    @Attachment(type = "image/png")
    private byte[] screenshot() {
        File file = Screenshots.takeScreenShotAsFile();
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream arrayOs = new ByteArrayOutputStream();
            BufferedOutputStream os = new BufferedOutputStream(arrayOs);
            image.flush();
            ImageIO.write(image, "png", os);
            return arrayOs.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
