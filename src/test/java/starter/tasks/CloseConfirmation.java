package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.userinterfaces.PlaceOrderPage;

/**
 * Tarea para cerrar el modal de confirmación haciendo clic en OK
 */
public class CloseConfirmation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(PlaceOrderPage.BUTTON_OK)
        );
    }

    public static CloseConfirmation now() {
        return new CloseConfirmation();
    }
}
