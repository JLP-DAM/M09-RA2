public class Forquilla {
    private final int LLIURE = -1;
    private int index;
    private int propietari = LLIURE;

    synchronized public void agafa() {
        
    }

    public Forquilla(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public int getPropietari() {
        return index;
    }

    public void setPropietari(int index) {
        this.index = index;
    }
}
