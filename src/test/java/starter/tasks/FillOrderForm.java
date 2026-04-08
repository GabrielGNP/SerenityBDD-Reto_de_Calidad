package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.userinterfaces.PlaceOrderPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para completar el formulario de Place Order
 */
public class FillOrderForm implements Task {
    private final String nombre;
    private final String pais;
    private final String ciudad;
    private final String tarjeta;
    private final String mes;
    private final String anio;

    public FillOrderForm(String nombre, String pais, String ciudad, String tarjeta, String mes, String anio) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.anio = anio;
    }

    public static FillOrderForm withData(String nombre, String pais, String ciudad, String tarjeta, String mes, String anio) {
        return new FillOrderForm(nombre, pais, ciudad, tarjeta, mes, anio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(PlaceOrderPage.FIELD_NAME, isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(nombre).into(PlaceOrderPage.FIELD_NAME),
            Enter.theValue(pais).into(PlaceOrderPage.FIELD_COUNTRY),
            Enter.theValue(ciudad).into(PlaceOrderPage.FIELD_CITY),
            Enter.theValue(tarjeta).into(PlaceOrderPage.FIELD_CARD),
            Enter.theValue(mes).into(PlaceOrderPage.FIELD_MONTH),
            Enter.theValue(anio).into(PlaceOrderPage.FIELD_YEAR)
        );
    }
}
