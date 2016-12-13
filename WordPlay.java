import java.util.Scanner;

/**
 * Created by chen.anidam on 12-Dec-16.
 */
public class WordPlay {

    private Character[] vowel = new Character[10];
    private Character ch;


    public boolean isVowel(Character c)
    {
        for (int i=0; i < vowel.length; i++) {
            if (vowel[i] == c) return true;
        }
        return false;
    }


    public String replaceVowels(String s, Character c) {
        StringBuilder ret = new StringBuilder();
        for (int i=0; i < s.length(); i++)
        {
            if (isVowel(s.charAt(i))) {
                ret.append(c);
            }

            else ret.append(s.charAt(i));
        }

        return ret.toString();
    }

    public String emphasize(String pharse, char c) {
        String s = "";
        char cu = Character.toUpperCase(c);

        for (int i=0; i < pharse.length(); i++)
        {
            if ((pharse.charAt(i) == c) || (pharse.charAt(i) == cu)) {
                if ((i+1) % 2 == 0)
                    s = s + '*';
                else
                    s = s + '+';
            }

            else
                s = s + pharse.charAt(i);
        }

        return s;
    }


    public static void main(String[] args) {
        // init vowels
        WordPlay wp = new WordPlay();

        wp.vowel[0] = 'a';
        wp.vowel[1] = 'A';
        wp.vowel[2] = 'e';
        wp.vowel[3] = 'E';
        wp.vowel[4] = 'i';
        wp.vowel[5] = 'I';
        wp.vowel[6] = 'o';
        wp.vowel[7] = 'O';
        wp.vowel[8] = 'u';
        wp.vowel[9] = 'U';

        Scanner sc = new Scanner(System.in);
        System.out.println("enter string:");
        String phrase = sc.nextLine();

        System.out.println("enter char to replace vowels:");
        String ch = sc.nextLine();

        System.out.println(wp.replaceVowels(phrase, ch.charAt(0)));

        System.out.println(wp.emphasize("Mary Bella Abracadabra", 'a'));
    }

}
