package starter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Página principal de Demoblaze
 * Elementos: link_producto_1, link_home
 */
public class HomePage {
    public static final Target LINK_SAMSUNG_GALAXY_S6 = Target.the("enlace Samsung galaxy s6")
        .locatedBy("//a[text()='Samsung galaxy s6']");

    public static final Target LINK_NOKIA_LUMIA_1520 = Target.the("enlace Nokia lumia 1520")
        .locatedBy("//a[text()='Nokia lumia 1520']");

    public static final Target LINK_HOME = Target.the("enlace Home")
        .locatedBy("//a[text()='Home ']");
}
