package starter.tasks.login


import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.annotations.Subject
import starter.pages.login.GuruPage

import static net.serenitybdd.screenplay.Tasks.instrumented

class LoginGuru implements Performable {
    private String user
    private String pass
    GuruPage guruPage

    LoginGuru(String user) {
        this.user = user
    }

    static LoginGuru withUser(String user) {
        return instrumented(LoginGuru.class, user)
    }

    LoginGuru Password(String pass) {
        this.pass = pass
        return this
    }

    @Subject()
    @Override
    <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(user).into(guruPage.IP_USERID))
        actor.attemptsTo(Enter.theValue(pass).into(guruPage.IP_PASS))
        actor.attemptsTo(Click.on(guruPage.BT_LOGIN))
    }
}
