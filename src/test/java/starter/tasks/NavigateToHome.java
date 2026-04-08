package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.userinterfaces.HomePage;

/**
 * Tarea para navegar de vuelta a la página principal usando el enlace Home
 */
public class NavigateToHome implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePage.LINK_HOME)
        );
    }

    public static NavigateToHome page() {
        return new NavigateToHome();
    }
}
