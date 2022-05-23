public class BichosNormales extends Bichos
{
    public BichosNormales() {
        super(10);
    }
    
    @Override
    public String toString(){
        return "BN-" + this.getSalud();
    }
}