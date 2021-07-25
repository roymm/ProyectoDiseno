package securitysystem;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public class Person {
    private int idNumber;
    private IAccessCard card;

    public Person(int idNumber) {
        this.idNumber = idNumber;
    }

    public Person(int idNumber, IAccessCard card) {
        this.idNumber = idNumber;
        this.card = card;
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public IAccessCard getAccesCard()
    {
        return this.card;
    }
}
