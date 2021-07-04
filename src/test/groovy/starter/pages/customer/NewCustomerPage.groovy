package starter.pages.customer

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class NewCustomerPage extends PageObject {
    public NewCustomerPage(WebDriver webDriver) {
        super(webDriver)
    }

    /**
     * Create Customer
     */

    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    WebElementFacade BT_NEW_CUSTOMER

    @FindBy(xpath = "//input[@name='name']")
    WebElementFacade IP_NAME

    @FindBy(xpath = "//input[@name='dob']")
    WebElementFacade IP_DOB

    @FindBy(xpath = "//textarea[@name='addr']")
    WebElementFacade IP_ADDRESS

    @FindBy(xpath = "//input[@name='city']")
    WebElementFacade IP_CITY

    @FindBy(xpath = "//input[@name='state']")
    WebElementFacade IP_STATE

    @FindBy(xpath = "//input[@name='pinno']")
    WebElementFacade IP_PIN

    @FindBy(xpath = "//input[@name='emailid']")
    WebElementFacade IP_EMAIL

    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElementFacade IP_PHONE

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade IP_PASS

    @FindBy(xpath = "//input[@name='sub']")
    WebElementFacade BT_SUB

    /**
     * Info Customer
     */
    @FindBy(xpath = "//td[contains(text(),'Customer Name')]//following-sibling::td")
    WebElementFacade GET_NAME

    @FindBy(xpath = "//td[contains(text(),'Birthdate')]//following-sibling::td")
    WebElementFacade GET_DOB

    @FindBy(xpath = "//td[contains(text(),'Address')]//following-sibling::td")
    WebElementFacade GET_ADDRESS

    @FindBy(xpath = "//td[contains(text(),'City')]//following-sibling::td")
    WebElementFacade GET_CITY

    @FindBy(xpath = "//td[contains(text(),'State')]//following-sibling::td")
    WebElementFacade GET_STATE

    @FindBy(xpath = "//td[contains(text(),'Pin')]//following-sibling::td")
    WebElementFacade GET_PIN

    @FindBy(xpath = "//td[contains(text(),'Email')]//following-sibling::td")
    WebElementFacade GET_EMAIL

    @FindBy(xpath = "//td[contains(text(),'Mobile No.')]//following-sibling::td")
    WebElementFacade GET_PHONE

}
