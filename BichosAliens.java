public class BichosAliens extends Bichos
{
    
    public BichosAliens(){
        super(20);
    }
    
    @Override
    public String toString(){
        return "BA-" + this.getSalud();
    }
    
    
}
