
// The super class for all of the Objects

public class Prisim 
{
    protected double scale;
    protected Line[] edges;
    protected Point[] points;

    public Prisim(double size)
    {
        scale = size;
    }

    public void CreatePerspective(Point camera, Point cameraAngle) //Calculates the position for every point in 3D based on input rotation or camera movement
    {
        for (Point point : points)
        {
            ThreeTwo.CalcPerspective(point, camera, cameraAngle);
        }
    }

    public void ConvertTo2D(double focalLength) //Projects the 3D points onto the 2D screen
    {
        
        for (Point point : points)
        {
            ThreeTwo.To2DPoint(point, focalLength);
        }
    }

    public void create3dPoints() //Defines all of the points
    {
    }

    public void createLines() //Defines all of the edges
    {
    }

    public Line[] getLines()
    {
        return(edges);
    }

    public Point[] getPoints()
    {
        return(points);
    }

    public double getSize()
    {
        return scale;
    }

    public void setSize(double size)
    {
        scale = size;
    }

    public int getCode() //Gives the code of the object so draw class can tell what it is
    {
        return -1;
    }
}
