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
        //System.out.println("\n");
        for (Point point : points)
        {
            ThreeTwo.CalcPerspective(point, camera, cameraAngle);
        }
        for (Point point : points)
        {
            // System.out.print("3D X value: " + point.getX3());
            // System.out.print(" 3D Y value: " + point.getY3());
            // System.out.print(" 3D Z value: " + point.getZ3());
            // System.out.println("");
        }
    }
    public void ConvertTo2D(Point focalLength, int midX, int midY)
    {
        
        for (Point point : points)
        {
            ThreeTwo.To2DPoint(point, focalLength);
            point.setX3(point.getY3() + midX);
            point.setY3(point.getY3() + midY);
        }
    }
    public void create3dPoints(int xAdd)
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
