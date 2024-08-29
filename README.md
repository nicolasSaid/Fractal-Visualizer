# Fractal-Visualizer

Adding new information!

Visualizes fractals of n iterations using Java Swing

Class Structure:

    Point.java - class for a x-y coordinate point representing a location to draw in the panel

    Triangle.java - class that represents an equilateral triangle made from three points given a size and a direction

    Fractal.java - inteface for all classes that implement various fractals

    Sierpinski.java - class that implements Fractal.java used to represent the Sierpinski's triangle fractal

    fractalDraw.java - class made to create the graphical output of the fractals and used to handle user input

    FractalCanvas.java - class that extends canvas to draw output to the screen


<h1>HOW TO COMPILE AND EXECUTE</h1>

<I>makefile commands</I>
<ol>
    <li> make - compiles relevant files and executes program </li>
    <li> make clean - deletes object files and executable and leaves source files </li>
</ol>

<h3>IMPLEMENTING FURTHER IMPLEMENTATIONS</h3>

<p> To implement further fractal implementations, create a class that implements the <I>Fractal</I> interface and its methods and update Fractal Canvas to encorperate a method for the new class</p>
<ul>
    <li> Also create a new window in <I>fractalDraw.java</I> to have an interface to invoke the new fractal class
</ul>
