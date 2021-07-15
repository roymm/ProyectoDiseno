package Security_System;

import java.io.IOException;

public interface INetworkController {

    boolean connect(String url, int idNumber) throws IOException;

}
