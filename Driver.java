/**
 areaABCD = (1/2 * AC * BE) + (1/2 * AC * DF)
 = areaABD + area BDC

 s1 = (AB+BD+AD)/2
 A1 = sqrt[s(s-AB)(s-BD)(s-AD)]
 s2 = (BC+CD+BD)/2
 A2 = sqrt[s(s-BC)(s-CD)(s-BD)]
 */
public class Driver {
    public static void main(String []args){

        //Trapezoid
        Points p = new Points(3, 10, 5, 10, 10, 4, 1, 4);
        //Parallelogram
        Points p1 = new Points(-3, 10, 5, 10, 2, 0, -6, 0);
        //Rectangle
        Points p2 = new Points(0, 5, 15, 5, 15, 0, 0, 0);
        //Square
        Points p3 = new Points(0, 5, 5, 5, 5, 0, 0, 0);

        Quadrilateral a = new Quadrilateral();
        Trapezoid b = new Trapezoid();
        Parallelogram c = new Parallelogram();
        Rectangle d = new Rectangle();
        Square e = new Square();

        /*Exception output for fun*/
        Quadrilateral f = new Square();

        a.output(p);
        b.output(p);
        c.output(p1);
        d.output(p2);
        e.output(p3);

        /*Exception output for fun*/
        f.output(p);
    }
}
