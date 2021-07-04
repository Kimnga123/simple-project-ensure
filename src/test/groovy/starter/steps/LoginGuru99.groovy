package starter.steps

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable
import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import starter.pages.customer.NewCustomerPage
import starter.pages.login.GuruPage
import starter.tasks.customer.CheckAddCustomerSuccess
import starter.tasks.customer.NewCustomer
import starter.tasks.login.LoginGuru

class LoginGuru99 {
    Actor actor = Actor.named("Nga")
    GuruPage guru99
    NewCustomerPage newCustomerPage

    @Given("I login into system with info")
    public void iLoginIntoSystemWithInfo(DataTable dataTable) {
        guru99.open()
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class)
        list.each {
            actor.attemptsTo(Enter.theValue(it.'email').into(guru99.IP_EMAIL))
            actor.attemptsTo(Click.on(guru99.BT_SUBMIT))
            Serenity.setSessionVariable("user").to(getGuru99().GET_USERNAME.getText())
            Serenity.setSessionVariable("pass").to(getGuru99().GET_PASSWORD.getText())
        }
    }

    @And("I login to page with info")
    public void iLoginToPageWithInfo(DataTable dataTable) {
        guru99.open("info", "V4")
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class)
        list.each {
            String user = Serenity.sessionVariableCalled("user")
            String pass = Serenity.sessionVariableCalled("pass")
            actor.attemptsTo(LoginGuru.withUser(user).Password(pass))
        }
    }

    @When("I create a New Customer with info")
    public void iCreateANewCustomerWithInfo(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class)
        list.each {
            actor.attemptsTo(Click.on(newCustomerPage.BT_NEW_CUSTOMER))
            actor.attemptsTo(NewCustomer.withCustomerName(it.'Customer Name')
                    .DOB(it.'Date of Birth')
                    .Address(it.'Address')
                    .City(it.'City')
                    .State(it.'State')
                    .Pin(it.'PIN')
                    .Phone(it.'Mobile Number')
                    .Email(it.'E-mail')
                    .Pass(it.'Password'))
        }
    }

    @Then("I see the account creation is successful and showing with info")
    public void iSeeTheAccountCreationIsSuccessfulAndShowingWithInfo(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class)
        list.each {
            actor.attemptsTo(CheckAddCustomerSuccess.withCustomerName(it.'Customer Name')
                    .DOB(it.'Birthdate')
                    .Address(it.'Address')
                    .City(it.'City')
                    .State(it.'State')
                    .Pin(it.'Pin')
                    .Phone(it.'Mobile No.')
                    .Email(it.'E-mail'))
        }
    }
}

