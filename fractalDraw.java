import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class fractalDraw{

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new fractalDraw().createAndShowGUI();
			}
		});
    }

    public void createAndShowGUI(){
        fractalPrompt(null);
    }

    public void addMenuBar(JFrame framePassed){
        JMenuBar menuBars = new JMenuBar();

        JMenu options = new JMenu("Options");
        

        JMenuItem fractalPrompt = new JMenuItem("Fractal");
        fractalPrompt.setMnemonic(KeyEvent.VK_F);
        fractalPrompt.addActionListener(new MenuItemActionListener(fractalPrompt, framePassed));

        JMenuItem drawPanel = new JMenuItem("Paint");
        drawPanel.setMnemonic(KeyEvent.VK_P);
        drawPanel.addActionListener(new MenuItemActionListener(drawPanel, framePassed));

        JMenuItem colorPanel = new JMenuItem("Color");
        colorPanel.setMnemonic(KeyEvent.VK_C);
        colorPanel.addActionListener(new MenuItemActionListener(colorPanel, framePassed));

        JMenuItem creditPanel = new JMenuItem("About Me");
        creditPanel.setMnemonic(KeyEvent.VK_A);
        creditPanel.addActionListener(new MenuItemActionListener(creditPanel, framePassed));

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.addActionListener(new MenuItemActionListener(exit, framePassed));


        menuBars.add(options);

        options.add(fractalPrompt);
        options.add(drawPanel);
        options.add(colorPanel);
        options.add(creditPanel);
        options.add(exit);

        framePassed.setJMenuBar(menuBars);

    }

    public void fractalPrompt(JFrame prev){
        JFrame frame = new JFrame();
        addMenuBar(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel layoutPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
        layoutPanel.setLayout(boxLayout);
        layoutPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        layoutPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel labelPanel = new JPanel();
        JLabel prompt = new JLabel("Enter the number of iterations for Sierpinski's Triangle (1-8)", SwingConstants.CENTER);
        //Dimension promptsize = new Dimension(50, 200);
        //prompt.setPreferredSize(promptsize);
        prompt.setFont(new Font("Verdana", Font.BOLD, 32));

        Border border = prompt.getBorder();
        Border margin = new EmptyBorder(100,100,100,100);
        prompt.setBorder(new CompoundBorder(border, margin));

        labelPanel.add(prompt);


        JPanel textPanel = new JPanel();
        JTextField field = new JTextField(10);
        textPanel.add(field);


        JPanel buttonPanel = new JPanel();
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ButtonActionListener(field, frame));
        submit.setEnabled(true);
        buttonPanel.add(submit);

        layoutPanel.add(labelPanel);
        layoutPanel.add(textPanel);
        layoutPanel.add(buttonPanel);


        frame.setContentPane(layoutPanel);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        if(prev != null){
            prev.dispose();
        }
    }

    public void showFractal(int i, JFrame prev){
        JFrame frame = new JFrame();
        FractalCanvas f = new FractalCanvas(i);
        addMenuBar(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(f);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        prev.dispose();
    }

    public void showAboutMe(JFrame prev){
        JFrame frame = new JFrame();
        addMenuBar(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //GRIDBADCONSTRAINTS
        //GridBagConstraints header = new GridBagConstraints();
        //header.insets = new Insets(20,0,20,0);
        //

        JPanel layoutPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
        layoutPanel.setLayout(boxLayout);
        layoutPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        layoutPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //JPanel promptPanel = new JPanel();
        JLabel prompt = new JLabel("<html>TEMP</html>");
        //promptPanel.setPreferredSize(new Dimension(50,10));
        prompt.setVerticalAlignment(JLabel.TOP);
        prompt.setHorizontalAlignment(JLabel.CENTER);
        prompt.setFont(new Font("Verdana", Font.BOLD, 36));
        prompt.setBorder(new EmptyBorder(50,0,20,0));
        /*Border border = prompt.getBorder();
        Border margin = new EmptyBorder(100,100,0,100);
        prompt.setBorder(new CompoundBorder(border, margin));*/
        layoutPanel.add(prompt);

        //JPanel descPanel = new JPanel();
        JLabel desc = new JLabel("<html>TEMP DESC<br>TEMP DESC<br>TEMP DESC<br>TEMP DESC<br>TEMP DESC<br>TEMP DESC</html>");
     
        desc.setVerticalAlignment(JLabel.TOP);
        desc.setHorizontalAlignment(JLabel.CENTER);
        desc.setFont(new Font("Verdana", Font.PLAIN, 14));
        desc.setBorder(new EmptyBorder(0,0,475,0));

        layoutPanel.add(desc);


        JLabel link = new JLabel("<html>link placeholder</html>");
        link.setVerticalAlignment(JLabel.BOTTOM);
        link.setHorizontalAlignment(JLabel.CENTER);
        link.setFont(new Font("Verdana", Font.PLAIN, 10));

        layoutPanel.add(link);


        

        frame.setContentPane(layoutPanel);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        prev.dispose();
    }


    class ButtonActionListener implements ActionListener {
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private JTextField input;
        private JFrame previous;
		
		ButtonActionListener(JTextField b, JFrame prev){
			input = b;
            previous = prev;
		}
		
		public void actionPerformed(ActionEvent e) {
			try{
                int iter = Integer.parseInt(input.getText());
                if(iter >= 0 && iter <= 8){
                    showFractal(iter, previous);
                }else{
                    JOptionPane.showMessageDialog(null, "Integer must be from 0 to 8");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Please input an Integer");
            }
		}
	}

    class MenuItemActionListener implements ActionListener {
		private JMenuItem mi;
        private JFrame current;
		
		MenuItemActionListener(JMenuItem m, JFrame currentFrame)	{
			this.mi = m;
            this.current = currentFrame;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(mi.getText().toLowerCase().equals("fractal")) {
                fractalPrompt(current);
			}
            else if(mi.getText().toLowerCase().equals("exit")) {
                current.dispatchEvent(new WindowEvent(current, WindowEvent.WINDOW_CLOSING));
			}
            else if(mi.getText().toLowerCase().equals("about me")) {
                showAboutMe(current);
			}
		}
	}
}