public class Cube extends Prisim
{
    public Cube(double scale)
    {
        super(scale);
        points = new Point[8];
        edges = new Line[12];
    }
    public void create3dPoints(int midX, int midY)
    {
        points[0] = new Point(0,0,0); 
        points[1] = new Point(0,0,scale); 
        points[2] = new Point(scale,0,0); 
        points[3] = new Point(scale,0,scale); 
        points[4] = new Point(scale,scale,0); 
        points[5] = new Point(scale,scale,scale); 
        points[6] = new Point(0,scale,scale); 
        points[7] = new Point(0,scale,0);
        for (Point point: points)
        {
            point.setX3(point.getX3() + midX);
            point.+
        } 
    }
}