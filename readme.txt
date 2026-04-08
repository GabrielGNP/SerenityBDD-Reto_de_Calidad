========================================================
  SERENITY BDD - PRUEBAS E2E - DEMOBLAZE
========================================================

DESCRIPCION
-----------
Proyecto de pruebas automatizadas E2E sobre la tienda
https://www.demoblaze.com usando Serenity BDD con el
patron Screenplay y Cucumber.

El escenario principal realiza una compra completa:
agregar dos productos al carrito, verificar el carrito
y finalizar la orden de compra.


REQUISITOS PREVIOS
------------------
1. Java JDK 8 o superior
2. Apache Maven 3.8 o superior
3. Google Chrome
   - El WebDriver se descarga automaticamente via Serenity


VERSIONES DE DEPENDENCIAS
--------------------------
- Serenity BDD:                   5.3.8
- Cucumber:                       7.34.2
- JUnit Platform Suite:           6.0.3
- Maven Surefire/Failsafe Plugin: 3.1.2
- Logback:                        1.2.10
- AssertJ:                        3.23.1
- JNA Platform:                   5.18.1
- Maven Compiler:                 Source/Target 1.8


ESTRUCTURA DEL PROYECTO
-----------------------
src/test/java/starter/
  |-- runners/
  |     |-- CarritoTestRunner.java      (Runner con tag @carrito)
  |
  |-- stepdefinitions/
  |     |-- CarritoStepDefinitions.java (Definiciones de pasos)
  |
  |-- tasks/
  |     |-- NavigateToHomePage.java     (Navegar a la pagina principal)
  |     |-- SelectProduct.java         (Seleccionar un producto)
  |     |-- AddProductToCart.java       (Agregar producto al carrito)
  |     |-- AcceptAlert.java           (Aceptar alerta del navegador)
  |     |-- NavigateToHome.java        (Volver al inicio)
  |     |-- GoToCart.java              (Ir al carrito)
  |     |-- PlaceOrder.java            (Iniciar orden de compra)
  |     |-- FillOrderForm.java         (Completar formulario)
  |     |-- ConfirmPurchase.java       (Confirmar compra)
  |     |-- CloseConfirmation.java     (Cerrar confirmacion)
  |
  |-- questions/
  |     |-- AlertMessageIs.java        (Verificar mensaje de alerta)
  |
  |-- userinterfaces/
        |-- HomePage.java              (Elementos de la pagina principal)
        |-- ProductDetailPage.java     (Elementos del detalle de producto)
        |-- CartPage.java              (Elementos del carrito)
        |-- PlaceOrderPage.java        (Elementos del formulario de orden)

src/test/resources/
  |-- features/carrito/
  |     |-- agregar-producto.feature   (Escenario de compra completa)
  |
  |-- serenity.conf                    (Configuracion del WebDriver)
  |-- logback-test.xml                 (Configuracion de logs)


INSTRUCCIONES DE EJECUCION
---------------------------

1. Abrir una terminal en la carpeta del proyecto:
```bash
cd serenity-e2e-tests
```

2. Ejecutar todas las pruebas:
```bash
mvn clean verify
```
3. Ver el reporte generado:
   - Abrir en el navegador:
     `target/site/serenity/index.html`

   - Reporte de una sola pagina:
     `target/site/serenity/serenity-summary.html`


CONFIGURACION
-------------

Archivo: src/test/resources/serenity.conf

- headless.mode = false    -> Muestra el navegador durante la ejecucion
- headless.mode = true     -> Ejecuta sin interfaz grafica (para CI/CD)

- serenity.take.screenshots = FOR_FAILURES  -> Capturas solo en fallos
- serenity.take.screenshots = AFTER_EACH_STEP -> Captura en cada paso

