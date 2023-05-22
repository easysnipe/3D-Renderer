public class Hexagonal extends Prisim
{
    public Hexagonal(double scale)
    {
        super(scale);
        points = new Point[12];
        edges = new Line[18];
    }
    public void create3dPoints()
    {
        points[0] = new Point(scale,scale, scale * -0);//
        points[1] = new Point(scale * -0,scale, scale);//
        points[2] = new Point(scale * -1,scale, scale);//
        points[3] = new Point(scale * -2,scale, scale * -0);//
        points[4] = new Point(scale * -2,scale * -1, scale * -0);
        points[5] = new Point(scale * -1,scale * -1, scale);
        points[6] = new Point(scale * -0,scale * -1, scale);
        points[7] = new Point(scale,scale * -1, scale * -0);
        points[8] = new Point(scale * -0,scale * -1, scale * -1);
        points[9] = new Point(scale * -1,scale * -1, scale * -1);
        points[10] = new Point(scale * -1,scale, scale * -1);
        points[11] = new Point(scale * -0,scale, scale * -1);
    }
    public void createLines()
    {
        edges[0] = new Line(points[0], points[1]);
        edges[1] = new Line(points[0], points[7]);
        edges[2] = new Line(points[0], points[11]);
        edges[3] = new Line(points[1], points[2]);
        edges[4] = new Line(points[1], points[6]);
        edges[5] = new Line(points[2], points[5]);
        edges[6] = new Line(points[2], points[3]);
        edges[7] = new Line(points[3], points[4]);
        edges[8] = new Line(points[3], points[10]);
        edges[9] = new Line(points[4], points[5]);
        edges[10] = new Line(points[4], points[9]);
        edges[11] = new Line(points[5], points[6]);
        edges[12] = new Line(points[6], points[7]);
        edges[13] = new Line(points[7], points[8]);
        edges[14] = new Line(points[8], points[9]);
        edges[15] = new Line(points[8], points[11]);
        edges[16] = new Line(points[9], points[10]);
        edges[17] = new Line(points[10], points[11]);

    }
}
