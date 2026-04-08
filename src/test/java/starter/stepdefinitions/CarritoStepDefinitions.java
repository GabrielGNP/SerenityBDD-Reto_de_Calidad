package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.tasks.*;
import starter.questions.*;
import starter.userinterfaces.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Step Definitions para el flujo completo de compra en Demoblaze
 */
public class CarritoStepDefinitions {

    Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("usuario");
    }

    // --- Caso 1 & 2: Navegación y selección de productos ---

    @Given("el usuario está en la página principal de Demoblaze")
    public void elUsuarioEstaEnLaPaginaPrincipal() {
        actor.attemptsTo(
            NavigateToHomePage.ofDemoblaze()
        );
    }

    @When("el usuario navega a la página principal")
    public void elUsuarioNavegaALaPaginaPrincipal() {
        actor.attemptsTo(
            NavigateToHome.page()
        );
    }

    @When("el usuario hace clic en el producto {string}")
    public void elUsuarioHaceClicEnProducto(String productName) {
        if (productName.contains("Samsung")) {
            actor.attemptsTo(
                SelectProduct.named(productName, HomePage.LINK_SAMSUNG_GALAXY_S6)
            );
        } else if (productName.contains("Nokia")) {
            actor.attemptsTo(
                SelectProduct.named(productName, HomePage.LINK_NOKIA_LUMIA_1520)
            );
        }
    }

    @Then("el usuario ve la página de detalle del producto")
    public void elUsuarioVeLaPaginaDeDetalle() {
        actor.attemptsTo(
            WaitUntil.the(ProductDetailPage.PRODUCT_NAME, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @When("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnBoton(String botonName) {
        switch (botonName) {
            case "Add to cart":
                actor.attemptsTo(AddProductToCart.fromDetailPage());
                break;
            case "Place Order":
                actor.attemptsTo(PlaceOrder.now());
                break;
            case "Purchase":
                actor.attemptsTo(ConfirmPurchase.now());
                break;
            case "OK":
                actor.attemptsTo(CloseConfirmation.now());
                break;
        }
    }

    @Then("el usuario ve una alerta con el mensaje {string}")
    public void elUsuarioVeUnaAlerta(String expectedMessage) {
        String alertText = actor.asksFor(AlertMessageIs.displayed());
        if (!alertText.contains(expectedMessage)) {
            throw new AssertionError("Alerta esperada: " + expectedMessage + ", pero se encontró: " + alertText);
        }
    }

    @Then("el usuario acepta la alerta")
    public void elUsuarioAceptaLaAlerta() {
        actor.attemptsTo(
            AcceptAlert.displayed()
        );
    }

    // --- Caso 3: Verificar carrito ---

    @When("el usuario hace clic en el enlace {string} del menú")
    public void elUsuarioHaceClicEnEnlaceDelMenu(String enlace) {
        if (enlace.equals("Cart")) {
            actor.attemptsTo(GoToCart.fromNavMenu());
        }
    }

    @Then("el usuario ve el producto {string} en el carrito")
    public void elUsuarioVeElProductoEnElCarrito(String productName) {
        actor.attemptsTo(
            WaitUntil.the(CartPage.CART_TABLE_BODY, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(
            seeThat(CartContainsProduct.named(productName), is(true))
        );
    }

    @Then("el usuario ve que el total del carrito es {string}")
    public void elUsuarioVeQueElTotalEs(String expectedTotal) {
        actor.attemptsTo(
            WaitUntil.the(CartPage.CART_TOTAL, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(
            seeThat(TheCartTotal.displayed(), equalTo(expectedTotal))
        );
    }

    // --- Caso 4: Formulario de compra ---

    @When("el usuario completa el formulario de compra con los datos:")
    public void elUsuarioCompletaElFormulario(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        actor.attemptsTo(
            FillOrderForm.withData(
                data.get("nombre"),
                data.get("pais"),
                data.get("ciudad"),
                data.get("tarjeta"),
                data.get("mes"),
                data.get("anio")
            )
        );
    }

    @Then("el usuario ve el mensaje de confirmación {string}")
    public void elUsuarioVeElMensajeDeConfirmacion(String expectedMessage) {
        actor.attemptsTo(
            WaitUntil.the(PlaceOrderPage.CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        actor.should(
            seeThat(PurchaseConfirmationIsDisplayed.now(), is(true))
        );
    }
}
