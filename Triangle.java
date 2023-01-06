public class Triangle{
    private int sideLength;
    private Point[] corners;
    private int startx;
    private int starty;
    private double height;
    public boolean upwards;

    public Triangle(int startx, int starty, int sideLength, boolean upwards){
        this.startx = startx;
        this.starty = starty;
        this.sideLength = sideLength;
        this.height = Math.sqrt(3/2) * sideLength;
        this.upwards = upwards;
        corners = new Point[3];
        initializePoints();
    }

    private void initializePoints(){
        corners[0] = new Point(startx, starty);
        corners[1] = new Point(startx + sideLength, starty);
        if(upwards){
            corners[2] = new Point(startx + (sideLength/2), starty - (int)(height));
        } else {
            corners[2] = new Point(startx + (sideLength/2), starty + (int)(height));
        }
    }

    public void changeStart(int x, int y){
        this.startx = x;
        this.starty = y;
        initializePoints();
    }

    public void changeIsUpward(boolean upwards){
        this.upwards = upwards;
        initializePoints();
    }
    public void setSideLength(int length){
        this.sideLength = length;
        initializePoints();
    }

    public Point[] getPoints(){
        return corners;
    }

    public double getHeight(){
        return height;
    }


}