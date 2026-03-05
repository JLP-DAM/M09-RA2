import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int index;

    private ReentrantLock bloqueig = new ReentrantLock(true);

    public void agafa(Filosof filosof) {
        bloqueig.lock();
    }


    public void deixar() {        
        if (!bloqueig.isHeldByCurrentThread()){return;}
            
        bloqueig.unlock();
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