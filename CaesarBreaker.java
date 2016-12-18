/**
 * Created by chen.anidam on 15-Dec-16.
 */
public class CaesarBreaker {

    CaesarCipher cc;
    WordLengths wl = new WordLengths();

    public String decrypt(String msg, int key) {
        String message = cc.encrypt(msg);
        return message;
    }

    public void countLetters() {
        wl.countWordsLength();
    }

    public int intOfMax() {
        int max = wl.indexOfMax(wl.counts);
        return max;
    }


    public static void main(String[] args) {

        CaesarBreaker breaker = new CaesarBreaker();

        //String msg = breaker.cc.encrypt("eeeeeeeeeeeeeeeees", 4);
        //System.out.println("Encrypting message: eeeeeeeeeeeeeeeees " + msg + "\n");
        //System.out.println(breaker.decrypt("iiiiiiiiiiiiiiiiiw", 4));

    }
}
