import java.util.ArrayList;

public class Sierpinski implements Fractal{
    ArrayList<ArrayList<Triangle>> layers;
    private int iterations;
    private double zoom;

    public Sierpinski(int iterations){
        this.iterations = iterations;
        layers = new ArrayList<>();
    }

    public void setIterations(int iterations){
        this.iterations = iterations;
    }

    public int getIterations(){
        return iterations;
    }

    public void drawFractal(){

    }
    
    public void setZoom(double zoom){
        this.zoom = zoom;
    }

    public double getZoom(){
        return zoom;
    }
}