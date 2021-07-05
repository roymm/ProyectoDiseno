package Security_System;

import javax.swing.text.Position;

public interface SecurityComponent {
    void changePosition(Position position);
    SecurityComponent identifyUser(int id);
}
