/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package securitysystem.controlcenter;

/**
 * Super class that individual security components and collections from the Composite pattern extends
 */
public abstract class SecurityComponent {
    private final int id;

    public int getId() {
        return id;
    }

    SecurityComponent(int id){
        this.id = id;
    }

    abstract void changePosition(int id, Position position);
    abstract SecurityComponent identifyUser(int id);
}
