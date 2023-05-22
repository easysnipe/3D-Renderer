public class Pyramid extends Cube
{
    public Pyramid(double scale)
    {
        super(scale);
        points = new Point[5];
        edges = new Line[8];
    }
    public void create3dPoints()
    {
        points[0] = new Point(scale,scale,scale);
        points[1] = new Point(scale * -1,scale,scale);
        points[2] = new Point(scale,scale,scale * -1);
        points[3] = new Point(scale * -1,scale,scale * -1);
        points[4] = new Point(scale * -0,scale * -2,scale * -0);
    }
    public void createLines()
    {
        edges[0] = new Line(points[0], points[1]);
        edges[1] = new Line(points[0], points[2]);
        edges[2] = new Line(points[0], points[4]);
        edges[3] = new Line(points[1], points[3]);
        edges[4] = new Line(points[1], points[4]);
        edges[5] = new Line(points[2], points[3]);
        edges[6] = new Line(points[2], points[4]);
        edges[7] = new Line(points[3], points[4]);
    }
    public int getCode()
    {
        return 1;
    }
}
