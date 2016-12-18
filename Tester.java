/**
 * This is a tester run class, to test other classes
 * Created by chen.anidam on 18-Dec-16.
 */
public class Tester {

    public static void main(String[] args) {

        CodonCount cd = new CodonCount();
        cd.buildCodonMap(0, "CGTTCAAGTTCAA");
        cd.printOut();

    }
}
