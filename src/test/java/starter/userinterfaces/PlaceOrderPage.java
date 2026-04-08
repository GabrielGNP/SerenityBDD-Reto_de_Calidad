package starter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Modal de Place Order y confirmación de compra
 * Elementos: modal_orden, campos del formulario, boton_purchase, mensaje_confirmacion, boton_ok
 */
public class PlaceOrderPage {
    public static final Target ORDER_MODAL = Target.the("modal de orden")
        .locatedBy("#orderModal");

    public static final Target FIELD_NAME = Target.the("campo nombre")
        .locatedBy("#name");

    public static final Target FIELD_COUNTRY = Target.the("campo país")
        .locatedBy("#country");

    public static final Target FIELD_CITY = Target.the("campo ciudad")
        .locatedBy("#city");

    public static final Target FIELD_CARD = Target.the("campo tarjeta")
        .locatedBy("#card");

    public static final Target FIELD_MONTH = Target.the("campo mes")
        .locatedBy("#month");

    public static final Target FIELD_YEAR = Target.the("campo año")
        .locatedBy("#year");

    public static final Target BUTTON_PURCHASE = Target.the("botón Purchase")
        .locatedBy("//button[text()='Purchase']");

    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación")
        .locatedBy("//h2[text()='Thank you for your purchase!']");

    public static final Target BUTTON_OK = Target.the("botón OK de confirmación")
        .locatedBy("//button[text()='OK']");
}
