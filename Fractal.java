import java.awt.Graphics;

interface Fractal{
    public void drawFractal(Graphics g);
    public void setIterations(int interations);
    public int getIterations();
    public void setZoom(double zoom);
    public double getZoom();
}