all: fractalDraw.java


fractalDraw.java : Fractal.java Point.java Triangle.java Sierpinski.java
	java fractalDraw.java

clean:
	rm -f *.class 