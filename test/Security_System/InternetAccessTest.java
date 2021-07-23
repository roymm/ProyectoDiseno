package Security_System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class InternetAccessTest {
    private ProxyFirewall proxy = new ProxyFirewall();
    private Person ilegalVisitor = new Person(1452);
    private Person legalVisitor = new Person(1520);

    @BeforeEach
    void init()
    {
        proxy.addBlockedWebsite("www.juegos.com");
        proxy.addBlockedWebsite("www.facebook.com");
    }

    @Test
    void verifyPermittedWebsite() throws IOException {
        assertFalse(proxy.connect("www.juegos.com", ilegalVisitor.getIdNumber()));
        assertTrue(proxy.connect("www.google.com", legalVisitor.getIdNumber()));
        assertTrue(proxy.connect("www.instagram.com", legalVisitor.getIdNumber()));
    }

    //Assumes theres a device for each visitor
    @Test
    void connect100WebSites() throws IOException {
        for (int i = 0; i < 100; i++) {
            proxy.connect("www.ecci.ucr.ac.cr",ilegalVisitor.getIdNumber());
        }
        assertFalse(proxy.connect("www.ucr.ac.cr",ilegalVisitor.getIdNumber()));
    }

}