package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para seleccionar un producto en la página principal
 */
public class SelectProduct implements Task {
    private final Target productLink;
    private final String productName;

    public SelectProduct(Target productLink, String productName) {
        this.productLink = productLink;
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(productLink, isVisible()).forNoMoreThan(15).seconds(),
            Click.on(productLink)
        );
    }

    public static SelectProduct named(String productName, Target productLink) {
        return new SelectProduct(productLink, productName);
    }
}
