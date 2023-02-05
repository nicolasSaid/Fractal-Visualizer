import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class FractalCanvas extends Canvas{
    private int fractalIterations;
    private Color drawingColor;
    private Color backgroundColor;

    public FractalCanvas(int i, Color col, Color colBack){
        fractalIterations = i;
        drawingColor = col;
        backgroundColor = colBack;
    }

    public void paint(Graphics g){
        setForeground(drawingColor);
        setBackground(backgroundColor);
        Sierpinski outputSierpinski = new Sierpinski(fractalIterations);
        outputSierpinski.drawFractal(g);
        //g.drawLine(0,0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }
}