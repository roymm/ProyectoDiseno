package Security_System;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */

public class Camera extends ISecurityDevice{
    private List<Person> identifiedPeople = new LinkedList<>();

    public Camera(int id) {
        super(id);
    }

    Camera(int id, List<Person> identifiedPeople) {
        super(id);
        this.identifiedPeople = identifiedPeople;
    }

    public void setIdentifiedPeople(List<Person> identifiedPeople) {
        this.identifiedPeople = identifiedPeople;
    }

    public void addIdentifiedPerson(Person person){
        identifiedPeople.add(person);
    }

    @Override
    public SecurityComponent identifyUser(int searchedId) {
        for (Person identifiedPerson : identifiedPeople) {
            if(identifiedPerson.getIdNumber() == searchedId){
                return this;
            }
        }
        return null;
    }
}
