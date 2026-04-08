package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.userinterfaces.CartPage;

/**
 * Tarea para navegar al carrito desde el menú de navegación
 */
public class GoToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CartPage.LINK_CART_NAV)
        );
    }

    public static GoToCart fromNavMenu() {
        return new GoToCart();
    }
}
