package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.userinterfaces.CartPage;
import starter.userinterfaces.PlaceOrderPage;

/**
 * Tarea para hacer clic en Place Order
 */
public class PlaceOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CartPage.BUTTON_PLACE_ORDER)
        );
    }

    public static PlaceOrder now() {
        return new PlaceOrder();
    }
}
