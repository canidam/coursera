import java.util.Scanner;

/**
 * Created by chen.anidam on 12-Dec-16.
 */
public class CaesarCipher {

    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlpha = "";
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
        shiftedAlpha = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);

    }


    public String encrypt(String input)
    {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i=0; i < input.length(); i++)
        {
            // orig char
            Character ch = input.charAt(i);

            // is upper case and index
            boolean isUpper = Character.isUpperCase(ch);
            int idx = alphabetUpper.indexOf(Character.toUpperCase(ch));


            if (idx == -1)
                encryptedMessage.append(input.charAt(i));
            else
            {
                if (isUpper)
                    encryptedMessage.append(shiftedAlpha.charAt(idx));
                else
                    encryptedMessage.append(Character.toLowerCase(shiftedAlpha.charAt(idx)));
            }
        }

        return encryptedMessage.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2)
    {
        String encrypt1 = alphabetUpper.substring(key1) + alphabetUpper.substring(0, key1);
        String encrypt2 = alphabetUpper.substring(key2) + alphabetUpper.substring(0, key2);
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i=0; i < input.length(); i++)
        {
            Character ch = input.charAt(i);
            boolean isUpper = Character.isUpperCase(ch);
            int idx = alphabetUpper.indexOf(Character.toUpperCase(ch));

            if (idx != -1)
            {
                if (i % 2 == 0) {
                    if (isUpper)
                        encryptedMessage.append(encrypt1.charAt(idx));
                    else
                        encryptedMessage.append(Character.toLowerCase(encrypt1.charAt(idx)));
                }
                else {
                    if (isUpper)
                        encryptedMessage.append(encrypt2.charAt(idx));
                    else
                        encryptedMessage.append(Character.toLowerCase(encrypt2.charAt(idx)));
                }
            }
            else
                encryptedMessage.append(input.charAt(i));
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String msg) {
        String res = "";

        CaesarCipher breaker = new CaesarCipher(26 - key);
        res = breaker.encrypt(msg);

        return res;
    }


    public static void main(String[] args) {

        CaesarCipher cc = new CaesarCipher(5);
        System.out.println("encrypt msg: " + cc.encryptTwoKeys("Chen is awesome", 4, 5));
        System.out.println("decrypted msg: " + cc.decrypt("Hmjs nx fbjxtrj"));


    }
}


