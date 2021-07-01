package Security_System;

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
