package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.userinterfaces.PlaceOrderPage;

/**
 * Question para verificar si el mensaje de confirmación de compra es visible
 */
public class PurchaseConfirmationIsDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(PlaceOrderPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }

    public static PurchaseConfirmationIsDisplayed now() {
        return new PurchaseConfirmationIsDisplayed();
    }
}
