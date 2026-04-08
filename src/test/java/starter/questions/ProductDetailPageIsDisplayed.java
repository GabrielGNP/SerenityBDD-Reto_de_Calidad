package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.userinterfaces.ProductDetailPage;

/**
 * Question para verificar que la página de detalle del producto es visible
 */
public class ProductDetailPageIsDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ProductDetailPage.PRODUCT_NAME).answeredBy(actor);
    }

    public static ProductDetailPageIsDisplayed now() {
        return new ProductDetailPageIsDisplayed();
    }
}
