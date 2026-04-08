@smoke @carrito @positivo
Feature: Flujo completo de compra en Demoblaze
  Como cliente de Demoblaze
  Quiero agregar productos al carrito y completar una compra
  Para adquirir los productos que necesito

  @positivo @regresion
  Scenario: Compra completa - agregar dos productos, verificar carrito y finalizar orden
    # Caso 1: Agregar primer producto
    Given el usuario está en la página principal de Demoblaze
    When el usuario hace clic en el producto "Samsung galaxy s6"
    Then el usuario ve la página de detalle del producto
    When el usuario hace clic en el botón "Add to cart"
    Then el usuario ve una alerta con el mensaje "Product added"
    And el usuario acepta la alerta

    # Caso 2: Agregar segundo producto
    When el usuario navega a la página principal
    And el usuario hace clic en el producto "Nokia lumia 1520"
    Then el usuario ve la página de detalle del producto
    When el usuario hace clic en el botón "Add to cart"
    Then el usuario ve una alerta con el mensaje "Product added"
    And el usuario acepta la alerta

    # Caso 3: Verificar carrito
    When el usuario hace clic en el enlace "Cart" del menú
    Then el usuario ve el producto "Samsung galaxy s6" en el carrito
    And el usuario ve el producto "Nokia lumia 1520" en el carrito
    And el usuario ve que el total del carrito es "1180"

    # Caso 4: Completar la compra
    When el usuario hace clic en el botón "Place Order"
    And el usuario completa el formulario de compra con los datos:
      | nombre | pais     | ciudad | tarjeta              | mes | anio |
      | Juan Perez | Colombia | Bogotá | 4580 1234 5678 9012 | 12  | 2027 |
    And el usuario hace clic en el botón "Purchase"
    Then el usuario ve el mensaje de confirmación "Thank you for your purchase!"
    When el usuario hace clic en el botón "OK"
