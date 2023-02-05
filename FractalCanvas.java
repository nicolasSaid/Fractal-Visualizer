import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class FractalCanvas extends Canvas{
    private int fractalIterations;

    public FractalCanvas(int i){
        fractalIterations = i;
    }

    public void paint(Graphics g){
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        Sierpinski outputSierpinski = new Sierpinski(fractalIterations);
        outputSierpinski.drawFractal(g);
        //g.drawLine(0,0,Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    }
}