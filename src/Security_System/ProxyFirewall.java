package Security_System;

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
        visitorsList = new HashMap<Integer, Integer>();
    }

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
        if(blockedWebsites.contains(url))
            return false;
        return true;
    }

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
