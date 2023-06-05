//Stores the x, y and z of a 3D point along with the converted x and y of a 2D point

public class Point
{
    private double x3; //3D x,y and z values 
    private double y3;
    private double z3;

    private int x2; //2D x and y values that the 3D values will be projected to
    private int y2;
    public Point(double xVal, double yVal, double zVal)
    {
        x3 = xVal;
        y3 = yVal;
        z3 = zVal;
    }
    //Getters, setters:
    public double getX3()
    {
        return(x3);
    }
    public void setX3(double xVal)
    {
        x3 = xVal;
    }
    public double getY3()
    {
        return(y3);
    }
    public void setY3(double yVal)
    {
        y3 = yVal;
    }
    public double getZ3()
    {
        return(z3);
    }
    public void setZ3(double zVal)
    {
        z3 = zVal;
    }

    public double getX2()
    {
        return(x2);
    }
    public void setX2(int xVal)
    {
        x2 = xVal;
    }
    public double getY2()
    {
        return(y2);
    }
    public void setY2(int yVal)
    {
        y2 = yVal;
    }

    
}