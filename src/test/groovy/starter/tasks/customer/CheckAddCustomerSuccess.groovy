package starter.tasks.customer

import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.Ensure
import starter.pages.customer.NewCustomerPage

import static net.serenitybdd.screenplay.Tasks.instrumented

class CheckAddCustomerSuccess implements Performable {
    private String customerName
    private String DOB
    private String address
    private String city
    private String state
    private String pin
    private String phone
    private String email

    NewCustomerPage page

    CheckAddCustomerSuccess(String customerName) {
        this.customerName = customerName
    }

    static CheckAddCustomerSuccess withCustomerName(String customerName) {
        return instrumented(CheckAddCustomerSuccess.class, customerName)
    }

    CheckAddCustomerSuccess DOB(String DOB) {
        this.DOB = DOB
        return this
    }

    CheckAddCustomerSuccess Address(String address) {
        this.address = address
        return this
    }

    CheckAddCustomerSuccess City(String city) {
        this.city = city
        return this
    }

    CheckAddCustomerSuccess State(String state) {
        this.state = state
        return this
    }

    CheckAddCustomerSuccess Pin(String pin) {
        this.pin = pin
        return this
    }

    CheckAddCustomerSuccess Phone(String phone) {
        this.phone = phone
        return this
    }

    CheckAddCustomerSuccess Email(String email) {
        this.email = email
        return this
    }


    @Subject("Check AddCustomerSuccess")
    @Override
    <T extends Actor> void performAs(T actor) {
        String emailRandom = Serenity.sessionVariableCalled("email")
        actor.attemptsTo(
                Ensure.that(page.GET_NAME.getText()).contains(customerName),
                Ensure.that(page.GET_ADDRESS.getText()).contains(address),
                Ensure.that(page.GET_CITY.getText()).contains(city),
                Ensure.that(page.GET_DOB.getText()).contains(DOB),
                Ensure.that(page.GET_PHONE.getText()).contains(phone),
                Ensure.that(page.GET_PIN.getText()).contains(pin),
                Ensure.that(page.GET_STATE.getText()).contains(state),
                Ensure.that(page.GET_EMAIL.getText()).contains(emailRandom))
    }
}
