package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.userinterfaces.ProductDetailPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para agregar un producto al carrito
 */
public class AddProductToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(ProductDetailPage.BUTTON_ADD_TO_CART, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(ProductDetailPage.BUTTON_ADD_TO_CART)
        );
    }

    public static AddProductToCart fromDetailPage() {
        return new AddProductToCart();
    }
}
