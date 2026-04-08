package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.userinterfaces.CartPage;

/**
 * Question para obtener el total del carrito
 */
public class TheCartTotal implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CartPage.CART_TOTAL).answeredBy(actor);
    }

    public static TheCartTotal displayed() {
        return new TheCartTotal();
    }
}
