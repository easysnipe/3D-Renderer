public class Tesobj extends Prisim
{
    public Tesobj(double scale)
    {
        super(scale);
        points = new Point[5];
        edges = new Line[8];
    }
    public void create3dPoints()
    {
        // points[0] = new Point(scale ,0,scale);
        // points[1] = new Point(scale * -1, 0,scale);
        // points[2] = new Point(scale * -1,0,scale * -1);
        // points[3] = new Point(scale, 0, scale * -1);
        // points[4] = new Point(0, scale * -2, 0);
        points[0] = new Point(0 ,0,0);
        points[1] = new Point(scale * -1, 0,0);
        points[2] = new Point(scale * -1,0,scale * -1);
        points[3] = new Point(0, 0, scale * -1);
        points[4] = new Point(0, scale * -2, 0);
    }
    public void createLines()
    {
        edges[0] = new Line(points[0], points[1]);
        edges[1] = new Line(points[0], points[3]);
        edges[2] = new Line(points[0], points[4]);
        edges[3] = new Line(points[1], points[2]);
        edges[4] = new Line(points[1], points[4]);
        edges[5] = new Line(points[2], points[3]);
        edges[6] = new Line(points[2], points[4]);
        edges[7] = new Line(points[3], points[4]);
    }
    public int getCode()
    {
        return 5;
    }
}