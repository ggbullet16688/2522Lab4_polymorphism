public class Points {
    private double pAx, pAy;
    private double pBx, pBy;
    private double pCx, pCy;
    private double pDx, pDy;
    private double[] pointABCD;

    public Points() {

    }

    public Points(double ax, double ay, double bx, double by, double cx,
        double cy, double dx, double dy) {
        pointABCD = new double[]{ax, ay, bx, by, cx, cy, dx, dy};

        this.pAx = ax;
        this.pAy = ay;
        this.pBx = bx;
        this.pBy = by;
        this.pCx = cx;
        this.pCy = cy;
        this.pDx = dx;
        this.pDy = dy;
    }

    public double[] getPoints() {
        return this.pointABCD;
    }

    public void setPointA(double x, double y) {
        this.pAx = x;
        this.pAy = y;
    }
    public void setPointB(double x, double y) {
        this.pBx = x;
        this.pBy = y;
    }
    public void setPointC(double x, double y) {
        this.pCx = x;
        this.pCy = y;
    }
    public void setPointD(double x, double y) {
        this.pDx = x;
        this.pDy = y;
    }
}