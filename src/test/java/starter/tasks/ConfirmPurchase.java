package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.userinterfaces.PlaceOrderPage;

/**
 * Tarea para confirmar la compra haciendo clic en Purchase
 */
public class ConfirmPurchase implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(PlaceOrderPage.BUTTON_PURCHASE)
        );
    }

    public static ConfirmPurchase now() {
        return new ConfirmPurchase();
    }
}
