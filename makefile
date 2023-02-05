all: fractalDraw


fractalDraw : fractalDraw.class
	java fractalDraw

fractalDraw.class : fractalDraw.java Fractal.java FractalCanvas.class Sierpinski.class
	javac fractalDraw.java

FractalCanvas.class : FractalCanvas.java Sierpinski.class
	javac FractalCanvas.java

Sierpinski.class: Sierpinski.java Fractal.java Triangle.class Point.class
	javac Sierpinski.java

Triangle.class: Triangle.java Point.class
	javac Triangle.java

Point.class: Point.java
	javac Point.java

clean:
	rm -f *.class 