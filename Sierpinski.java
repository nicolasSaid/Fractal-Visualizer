import java.util.ArrayList;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.awt.Graphics;
//import java.lang.Thread;

public class Sierpinski implements Fractal{
    ArrayList<Triangle> layers;
    private int iterations;
    private double zoom;

    public Sierpinski(int iterations){
        this.iterations = iterations;
        layers = new ArrayList<>();
        calcTriangles();
    }

    public void setIterations(int iterations){
        this.iterations = iterations;
    }

    public int getIterations(){
        return iterations;
    }

    public void drawFractal(Graphics g){
        for(int i = 0; i < layers.size(); i++){
            g.drawLine(layers.get(i).getPoints()[0].getX(), layers.get(i).getPoints()[0].getY(), layers.get(i).getPoints()[1].getX(), layers.get(i).getPoints()[1].getY());
            g.drawLine(layers.get(i).getPoints()[0].getX(), layers.get(i).getPoints()[0].getY(), layers.get(i).getPoints()[2].getX(), layers.get(i).getPoints()[2].getY());
            g.drawLine(layers.get(i).getPoints()[2].getX(), layers.get(i).getPoints()[2].getY(), layers.get(i).getPoints()[1].getX(), layers.get(i).getPoints()[1].getY());
            /*if(i%3 == 0){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                }
            }*/
        }
    }
    
    public void setZoom(double zoom){
        this.zoom = zoom;
    }

    public double getZoom(){
        return zoom;
    }

    private void recursiveCalcTriangles(int x, int y, int length, int n, int occ){
        if(n == 0){
            return;
        }
        occ++;
        Triangle temp = new Triangle(x,y,length,false);
        layers.add(temp);
        //to account for left drift from truncating decimals
        if(occ >= 3 && occ%3 == 0){
            x++;
        }
        recursiveCalcTriangles(x + length/4 , y - (int)(temp.getHeight()/2), length/2, n - 1, occ);
        recursiveCalcTriangles(x - length/4, y + (int)(temp.getHeight()/2), length/2, n - 1, occ);
        recursiveCalcTriangles(x + (3*length)/4, y + (int)(temp.getHeight()/2), length/2, n - 1, occ);
    }

    public void calcTriangles(){
        /* REIMPLEMENT WHEN RECENTERING THE TRIANGLE
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int startCorner = (int)((screenSize.getWidth() - screenSize.getHeight())/2);
        */


        //layers.add(new Triangle(startCorner,(int)(screenSize.getHeight()), (int)(screenSize.getHeight()), true));
        //recursiveCalcTriangles((int)(screenSize.getHeight()/4),(int)(screenSize.getHeight()/2),(int)(screenSize.getHeight()/2),iterations);

        Triangle temp = new Triangle(250,750, 525, true); //eventually use non hard-coded values
        layers.add(temp);
        recursiveCalcTriangles((int)(250 + 525/4),(int)(750 - (int)(temp.getHeight()/2)),(int)(525/2),iterations,0);
        
        return;
    }
}