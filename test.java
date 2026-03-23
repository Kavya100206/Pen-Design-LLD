interface Pen{
    void write(String str);
    void refill(String colour);
    void start();
    void stop();
}

interface RefillStrategy{
    void refill(String colour);
}

class inkRefillStrategy implements RefillStrategy{
    public void refill(String colour){
        System.out.println("Refilled with " + colour);
    }
}

class CartridgeRefillStrategy implements RefillStrategy{
    public void refill(String colour){
        System.out.println("Cartridge refilled with " + colour);
    }
}

interface OpenCloseStrategy{
    void open();
    void close();
}

class ClickOpenCloseStrategy implements OpenCloseStrategy{
    public void open(){
        System.out.println("Pen opened with click");
    }

    public void close(){
        System.out.println("Pen closed with click");
    }
}

class CapOpenCloseStrategy implements OpenCloseStrategy{
    public void open(){
        System.out.println("Pen opened with cap");
    }

    public void close(){
        System.out.println("Pen closed with cap");
    }
}

abstract class BasePen implements Pen{
    protected RefillStrategy refillStrategy;
    protected OpenCloseStrategy openCloseStrategy;

    public BasePen(RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy){
        this.refillStrategy = refillStrategy;
        this.openCloseStrategy = openCloseStrategy;
    }

    public void write(String str){
        System.out.println("Writing: " + str);
    }

    public void refill(String colour){
        refillStrategy.refill(colour);
    }

    public void start(){
        openCloseStrategy.open();
    }

    public void stop(){
        openCloseStrategy.close();
    }
}

class BallPen extends BasePen{
    public BallPen(RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy){
        super(refillStrategy, openCloseStrategy);
    }
    public void write(String str){
        System.out.println("BallPen writing: " + str);
    }
}

class FountainPen extends BasePen{
    public FountainPen(RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy){
        super(refillStrategy, openCloseStrategy);
    }
    public void write(String str){
        System.out.println("FountainPen writing: " + str);
    }
}

public class test{
    public static void main(String[] args) {
        Pen pen = new BallPen(new inkRefillStrategy(), new ClickOpenCloseStrategy());
        pen.start();
        pen.write("Hello World");
        pen.refill("Blue");
        pen.stop();
    }
}