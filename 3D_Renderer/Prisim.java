public class Prisim 
{
    protected double scale;
    protected Line[] edges;
    protected Point[] points;
    public Prisim(double size)
    {
        scale = size;
    }
    public void CreatePerspective(Point camera, Point cameraAngle)
    {
        System.out.println(points.length);
        if (points[0].equals(null))
        {
            System.out.println("NULL");
        }
        for (Point point : points)
        {
            ThreeTwo.CalcPerspective(point, camera, cameraAngle);
        }
    }
    public void ConvertTo2D(double focalLength, int midX, int midY)
    {
        
        for (Point point : points)
        {
            ThreeTwo.To2DPointSimple(point, focalLength);
            point.setX3(point.getY3() + midX);
            point.setY3(point.getY3() + midY);
        }
    }
    public void create3dPoints()
    {
    }
    public void createLines()
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
}
