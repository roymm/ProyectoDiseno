/**
 * @author Carlos Espinoza B92786
 *            Fabiola Jimenez B23452
 *            Sebastián Montero B95016
 *            Kendall Lara B43707
 *            Roy Muñoz B54911
 *            Maria Jesús B98243
 */
package securitysystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProxyFirewall  implements INetworkController{
    private Logger logger;
    private List<String> blockedWebsites;
    private NetworkController browser;
    private HashMap<Integer, Integer> visitorsList;

    ProxyFirewall()
    {
        logger = new Logger();
        blockedWebsites = new ArrayList<>();
        browser = new NetworkController();
        visitorsList = new HashMap<>();
    }

    /**
     * Proxy that verifies blocked websites.
     * @param url is the url to be checked.
     */
    public void addBlockedWebsite(String url)
    {
        blockedWebsites.add(url);
    }

    public void deleteBlockedWebsite(String url)
    {
        blockedWebsites.remove(url);
    }

    private boolean verifyPermittedWebsite(String url)
    {
        return !blockedWebsites.contains(url);
    }


    /**
     * Proxy verifies if a visitor already access 100 websites
     * @param id is the id of the visitor.
     */
    private boolean verifyVisitedSites(int id)
    {
        int counter = 0;
        if (visitorsList.get(id) == null)
        {
            visitorsList.put(id, counter+1);
            return true;
        }else {
            if (visitorsList.get(id) < 100) {
                visitorsList.put(id, visitorsList.get(id) + 1);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Connects to the website if the visitor request passes the verifications
     * @param url is the url to be accesed.
     * @param idNumber is the id of the visitor.
     */
    public boolean connect (String url, int idNumber) throws IOException {
        if(verifyPermittedWebsite(url))
        {
            if(verifyVisitedSites(idNumber))
            {
                logger.add(idNumber, url);
                return this.browser.connect(url,idNumber);
            }

        }
        return false;
    }

}
