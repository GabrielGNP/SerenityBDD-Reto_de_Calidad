package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.userinterfaces.CartPage;

/**
 * Question para verificar si un producto está visible en el carrito
 */
public class CartContainsProduct implements Question<Boolean> {
    private final String productName;

    public CartContainsProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(CartPage.productInCart(productName)).answeredBy(actor);
    }

    public static CartContainsProduct named(String productName) {
        return new CartContainsProduct(productName);
    }
}
