package starter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Página de detalle del producto
 * Elementos: nombre_producto_detalle, precio_producto_detalle, boton_add_to_cart
 */
public class ProductDetailPage {
    public static final Target PRODUCT_NAME = Target.the("nombre del producto")
        .locatedBy("#tbodyid h2.name");

    public static final Target PRODUCT_PRICE = Target.the("precio del producto")
        .locatedBy("#tbodyid h3.price-container");

    public static final Target BUTTON_ADD_TO_CART = Target.the("botón Add to cart")
        .locatedBy("//a[text()='Add to cart']");
}
