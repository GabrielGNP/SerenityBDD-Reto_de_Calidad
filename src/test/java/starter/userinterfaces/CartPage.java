package starter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Página del carrito de compras
 * Elementos: link_carrito_nav, tabla_carrito_body, filas_carrito, total_carrito, boton_place_order
 */
public class CartPage {
    public static final Target LINK_CART_NAV = Target.the("enlace Cart en navegación")
        .locatedBy("#cartur");

    public static final Target CART_TABLE_BODY = Target.the("cuerpo de tabla del carrito")
        .locatedBy("#tbodyid");

    public static final Target CART_ROWS = Target.the("filas del carrito")
        .locatedBy("#tbodyid tr");

    public static final Target CART_TOTAL = Target.the("total del carrito")
        .locatedBy("#totalp");

    public static final Target BUTTON_PLACE_ORDER = Target.the("botón Place Order")
        .locatedBy("//button[text()='Place Order']");

    public static Target productInCart(String productName) {
        return Target.the("producto " + productName + " en el carrito")
            .locatedBy("//td[text()='" + productName + "']");
    }
}
