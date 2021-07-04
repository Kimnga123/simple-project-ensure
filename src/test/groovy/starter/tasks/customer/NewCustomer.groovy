package starter.tasks.customer

import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.annotations.Subject
import starter.pages.customer.NewCustomerPage
import starter.utils.Random

import static net.serenitybdd.screenplay.Tasks.instrumented

class NewCustomer implements Performable {
    private String customerName
    private String DOB
    private String address
    private String city
    private String state
    private String pin
    private String phone
    private String email
    private String pass

    NewCustomerPage page

    NewCustomer(String customerName) {
        this.customerName = customerName
    }

    static NewCustomer withCustomerName(String customerName) {
        return instrumented(NewCustomer.class, customerName)
    }

    NewCustomer DOB(String DOB) {
        this.DOB = DOB
        return this
    }

    NewCustomer Address(String address) {
        this.address = address
        return this
    }

    NewCustomer City(String city) {
        this.city = city
        return this
    }

    NewCustomer State(String state) {
        this.state = state
        return this
    }

    NewCustomer Pin(String pin) {
        this.pin = pin
        return this
    }

    NewCustomer Phone(String phone) {
        this.phone = phone
        return this
    }

    NewCustomer Email(String email) {
        this.email = email
        return this
    }

    NewCustomer Pass(String pass) {
        this.pass = pass
        return this
    }

    @Subject()
    @Override
    <T extends Actor> void performAs(T actor) {
        String emailRandom = Random.randomestring() + "@gmail.com"
        Serenity.setSessionVariable("email").to(emailRandom)
        page.IP_DOB.sendKeys(DOB)
        actor.attemptsTo(
                Enter.theValue(customerName).into(page.IP_NAME),
                Enter.theValue(address).into(page.IP_ADDRESS),
                Enter.theValue(city).into(page.IP_CITY),
                Enter.theValue(state).into(page.IP_STATE),
                Enter.theValue(phone).into(page.IP_PHONE),
                Enter.theValue(emailRandom).into(page.IP_EMAIL),
                Enter.theValue(pin).into(page.IP_PIN),
                Enter.theValue(pass).into(page.IP_PASS),
                Click.on(page.BT_SUB)
        )
    }
}
