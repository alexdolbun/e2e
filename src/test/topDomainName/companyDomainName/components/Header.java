package topDomainName.companyDomenName.components;

import com.codeborne.selenide.Selenide;
import topDomainName.companyDomainName.common.BasePage;
import topDomainName.companyDomainName.pages.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Header class
 * <br/>
 */

public abstract class Header<Page> extends BasePage<Page> {

    @Step("Logout and go back LoginPage")
    public LoginPage logout() {
        // User navigation
        $("").click();
        $("").click();
        this.screenshotEntryPage();
        return Selenide.page(LoginPage.class);
    }
}