/**
 * @author Carlos Espinoza B92786
 * Fabiola Jimenez B23452
 * Sebastián Montero B95016
 * Kendall Lara B43707
 * Roy Muñoz B54911
 * Maria Jesús B98243
 */
package securitysystem.proxies;

import java.io.IOException;


public interface INetworkController {

    boolean connect(String url, int idNumber) throws IOException;

}
