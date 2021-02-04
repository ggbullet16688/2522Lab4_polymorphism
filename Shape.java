/**
 S = Sabc + Sadc
 = 1/2 * AC * BD * sin(COD)
 COD = cos^-1 (- CD^2 + CO^2 + DO^2 /2*CO*DO

 s1 = (AB+BD+AD)/2
 A1 = sqrt[s(s-AB)(s-BD)(s-AD)]
 s2 = (BC+CD+BD)/2
 A2 = sqrt[s(s-BC)(s-CD)(s-BD)]
 */
interface calculateArea {
    default void area(Points p) {

        double[] coordinateArray;
        coordinateArray = p.getPoints();

        /* Calculate 4 sides and BD(conner-line): AB, BD, AD, BC, CD*/
        double ab = Math.sqrt(Math.pow((coordinateArray[2] - coordinateArray[0]), 2) +
                Math.pow((coordinateArray[3] - coordinateArray[1]), 2));
        double ad = Math.sqrt(Math.pow((coordinateArray[6] - coordinateArray[0]), 2) +
                Math.pow((coordinateArray[7] - coordinateArray[1]), 2));
        double bd = Math.sqrt(Math.pow((coordinateArray[6] - coordinateArray[2]), 2) +
                Math.pow((coordinateArray[7] - coordinateArray[3]), 2));
        double bc = Math.sqrt(Math.pow((coordinateArray[4] - coordinateArray[2]), 2) +
                Math.pow((coordinateArray[5] - coordinateArray[3]), 2));
        double cd = Math.sqrt(Math.pow((coordinateArray[6] - coordinateArray[4]), 2) +
                Math.pow((coordinateArray[7] - coordinateArray[5]), 2));

        double s1 = (ab + bd + ad) / 2;
        double A1 = Math.sqrt(s1 * (s1 - ab) * (s1 - bd) * (s1 - ad));
        double s2 = (bc + cd + bd) / 2;
        double A2 = Math.sqrt(s2 * (s2 - bc) * (s2 - cd) * (s2 - bd));
        double area = A1 + A2;
        System.out.printf("Area: %f",area );
        System.out.println("\n");

    }
}

class Quadrilateral implements calculateArea{
    public void output(Points p) {

        /*The sum of any three sides has to be larger than the last side*/
        double[] coord;
        coord = p.getPoints();
        double ab = Math.sqrt(Math.pow((coord[2] - coord[0]), 2) +
                Math.pow((coord[3] - coord[1]), 2));
        double ad = Math.sqrt(Math.pow((coord[6] - coord[0]), 2) +
                Math.pow((coord[7] - coord[1]), 2));
        double bc = Math.sqrt(Math.pow((coord[4] - coord[2]), 2) +
                Math.pow((coord[5] - coord[3]), 2));
        double cd = Math.sqrt(Math.pow((coord[6] - coord[4]), 2) +
                Math.pow((coord[7] - coord[5]), 2));

        boolean c1 = ab + bc + cd > ad;
        boolean c2 = ad + bc + cd > ab;
        boolean c3 = ab + ad + cd > bc;
        boolean c4 = ab + bc + ad > cd;

        if ((c1 && c2) && (c3 && c4)) {
            System.out.println("Quadrilateral " );
        } else {
            throw new IllegalArgumentException(
                    "ERROR: Four sides are not connected without " +
                            "crossing to each other.");
        }
    }
}

class Trapezoid extends Quadrilateral {
    public void output(Points p) {

        double[] coord;
        coord = p.getPoints();

        /*At least one pair of Opposite sides are parallel */
        /*Math.abs(a-b) <= 0.01*/
        boolean c1 = (Math.abs(coord[1] - coord[3]) <= 0.01);
        boolean c2 = (Math.abs(coord[5] - coord[7]) <= 0.01);
        boolean c3 = (Math.abs(coord[0] - coord[6]) <= 0.01);
        boolean c4 = (Math.abs(coord[2] - coord[4]) <= 0.01);

        if ((c1 && c2) || (c3 && c4)) {
            System.out.println("Trapezoid " );
            area(p);
        } else {
            throw new IllegalArgumentException(
                    "ERROR: Need at least a pair of sides parallel.");
        }
    }
}

class Parallelogram extends Quadrilateral {
    public void output(Points p) {

        double[] coord;
        coord = p.getPoints();

        /*One pair of Opposite sides are parallel and equal */
        /*Math.abs(a-b) <= 0.01*/
        boolean c1 = (Math.abs(coord[1] - coord[3]) <= 0.01);
        boolean c2 = (Math.abs(coord[5] - coord[7]) <= 0.01);
        boolean c3 = ((Math.abs(coord[2] - coord[0]) - Math.abs(coord[2] - coord[0]))<= 0.01);

        if (c1 && c2 && c3) {
            System.out.println("Parallelogram " );
            area(p);
        } else {
            throw new IllegalArgumentException(
                    "ERROR: One pair of Opposite sides are not parallel and equal.");
        }
    }
}
class Rectangle extends Parallelogram {
    public void output(Points p) {

        // AC = BD, Quadrilateral diagonal are equal.
        double[] coord;
        coord = p.getPoints();
        double bd = Math.sqrt(Math.pow((coord[6] - coord[2]), 2) +
                Math.pow((coord[7] - coord[3]), 2));
        double ac = Math.sqrt(Math.pow((coord[4] - coord[0]), 2) +
                Math.pow((coord[5] - coord[1]), 2));

        boolean c1 = (Math.abs(bd - ac) <= 0.01);
        if (c1) {
            System.out.println("Rectangle" );
            area(p);
        } else {
            throw new IllegalArgumentException(
                    "ERROR: Quadrilateral diagonal are not equal.");
        }
    }
}
class Square extends Rectangle {
    public void output(Points p) {

        // Four sides are equal
        double[] coord;
        coord = p.getPoints();
        double ab = Math.sqrt(Math.pow((coord[2] - coord[0]), 2) +
                Math.pow((coord[3] - coord[1]), 2));
        double ad = Math.sqrt(Math.pow((coord[6] - coord[0]), 2) +
                Math.pow((coord[7] - coord[1]), 2));
        double bc = Math.sqrt(Math.pow((coord[4] - coord[2]), 2) +
                Math.pow((coord[5] - coord[3]), 2));
        double cd = Math.sqrt(Math.pow((coord[6] - coord[4]), 2) +
                Math.pow((coord[7] - coord[5]), 2));

        boolean c1 = (Math.abs(ab - ad) <= 0.01);
        boolean c2 = (Math.abs(ab - bc) <= 0.01);
        boolean c3 = (Math.abs(ab - cd) <= 0.01);

        if (c1 && c2 && c3) {
            System.out.println("Square " );
            area(p);
        } else {
            throw new IllegalArgumentException(
                    "ERROR: Four sides are not equal.");
        }
    }
}
