package Security_System;

import java.util.LinkedList;
import java.util.List;

public class SecurityCenter {
    private List<SecurityComponent> subscribers;

    public SecurityCenter() {
        this.subscribers = new LinkedList<>();
    }

    public List<SecurityComponent> getSubscribers() {
        return subscribers;
    }

    public void registerComponent(SecurityComponent component){
        subscribers.add(component);
    }

    public void deleteComponent(SecurityComponent component){
        subscribers.remove(component);
    }

    public SecurityComponent identifyPerson(int idNumber){
        for (SecurityComponent subscriber :
                subscribers) {

            SecurityComponent componentSeeingPerson = subscriber.identifyUser(idNumber);

            if(componentSeeingPerson != null){
                return componentSeeingPerson;
            }
        }
        return null;
    }

    public void changePosition(Position position, int id){
        for (SecurityComponent subscriber: subscribers) {
            subscriber.changePosition(id,position);
        }
    }
}