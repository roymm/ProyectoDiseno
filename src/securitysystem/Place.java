/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package securitysystem;


import securitysystem.decorators.AccessLevel;

public class Place {
    private final AccessLevel accessLevel;
    public String name;

    public Place(AccessLevel accessLevel, String name) {
        this.accessLevel = accessLevel;
        this.name = name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
