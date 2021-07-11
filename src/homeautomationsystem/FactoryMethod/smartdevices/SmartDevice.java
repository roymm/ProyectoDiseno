package homeautomationsystem.FactoryMethod.smartdevices;

public abstract class SmartDevice  {

    protected boolean tieneTambor;
    protected boolean tieneMandos;
    protected String  tipoCarga;

    public void ponerTambor() {
        tieneTambor = true;
    }

    public boolean ponerMandos() {
        tieneMandos = true;
        return tieneMandos;
    }

}
