package starter.pages.login

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.DefaultUrl
import net.thucydides.core.annotations.NamedUrl
import net.thucydides.core.annotations.NamedUrls
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

@DefaultUrl("http://www.demo.guru99.com/")
@NamedUrls([
        @NamedUrl(name = "info", url = "/{1}/index.php")
]
)
class GuruPage extends PageObject {
    public GuruPage(WebDriver webDriver) {
        super(webDriver)
    }

    @FindBy(name = 'emailid')
    WebElementFacade IP_EMAIL

    @FindBy(name = 'btnLogin')
    WebElementFacade BT_SUBMIT

    @FindBy(xpath = '//td[contains(text(),\'User ID :\')]/following-sibling::td')
    WebElementFacade GET_USERNAME

    @FindBy(xpath = '//td[contains(text(),\'Password :\')]/following-sibling::td')
    WebElementFacade GET_PASSWORD

    @FindBy(xpath = "//td[contains(text(),'UserID')]/following-sibling::td/input")
    WebElementFacade IP_USERID

    @FindBy(xpath = "//input[@name = 'password']")
    WebElementFacade IP_PASS

    @FindBy(xpath = "//input[@name = 'btnLogin']")
    WebElementFacade BT_LOGIN

    @FindBy(xpath = "//input[@name = 'btnReset']")
    WebElementFacade BT_RESET

}

