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
        for (Point point : points)
        {
            ThreeTwo.CalcPerspective(point, camera, cameraAngle);
        }
    }
    public void ConvertTo2D(Point focalLength)
    {
        for (Point point : points)
        {
            ThreeTwo.To2DPoint(point, focalLength);
        }
    }
    public Point[] create3dPoints(int midX, int midY)
    {
        return points;
    }
    public Line[] createLines()
    {
        return edges;
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
