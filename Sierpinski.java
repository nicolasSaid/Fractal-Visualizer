import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Sierpinski implements Fractal{
    ArrayList<Triangle> layers;
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

    private void recursiveCalcTriangles(int x, int y, int length, int n){
        if(n == 0){
            return;
        }
        layers.add(new Triangle(x,y,length,false));

        recursiveCalcTriangles(x + x/2, y/2, length/2, n - 1);
        recursiveCalcTriangles(x/2, y + y/2, length/2, n - 1);
        recursiveCalcTriangles(2*x + x/2, y + y/2, length/2, n - 1);
    }

    public void calcTriangles(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int startCorner = (int)((screenSize.getWidth() - screenSize.getHeight())/2);
        layers.add(new Triangle(startCorner,(int)(screenSize.getHeight()), (int)(screenSize.getHeight()), true));
        recursiveCalcTriangles((int)(screenSize.getHeight()/4),(int)(screenSize.getHeight()/2),(int)(screenSize.getHeight()/2),iterations);
        return;
    }
}