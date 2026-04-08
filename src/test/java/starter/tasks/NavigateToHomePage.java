package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Tarea reutilizable para navegar a la página principal
 */
public class NavigateToHomePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url("https://www.demoblaze.com")
        );
    }

    public static NavigateToHomePage ofDemoblaze() {
        return new NavigateToHomePage();
    }
}
