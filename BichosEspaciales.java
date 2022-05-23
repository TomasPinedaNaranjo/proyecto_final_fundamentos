public class BichosEspaciales extends Bichos
{
    public BichosEspaciales(){
        super(30);
    }
    
    @Override
    public String toString(){
        return "BE-" + this.getSalud();
    }
}
