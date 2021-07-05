package Security_System;

public class Person {
    private int idNumber;
    private IAccessCard card;

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
