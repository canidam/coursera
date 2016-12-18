import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chen.anidam on 17-Dec-16.
 */
public class CharactersInPlay {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("words.txt").getFile());
    ArrayList<String> character;
    ArrayList<Integer> freqs;

    public CharactersInPlay() {
        character = new ArrayList<>();
        freqs = new ArrayList<>();
    }

    public void countCharacters() throws FileNotFoundException {

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext())
            {
                String line = scan.nextLine();
                String[] names = line.split("\\.");

                for (String s : names)
                {
                    if (s.length() >= 1) {
                        int idx = character.indexOf(s);
                        if (idx != -1) {
                            int val = freqs.get(idx);
                            freqs.set(idx, val + 1);
                        }
                        else {
                            character.add(s);
                            freqs.add(1);
                        }
                    }

                }
            }
        }
    }

    public void countArrays() {
        for (int k = 0; k < character.size(); k++) {
            if (freqs.get(k) >= 10 && freqs.get(k) < 15) {
                System.out.println(character.get(k) + " " + freqs.get(k));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        CharactersInPlay cn = new CharactersInPlay();
        cn.countCharacters();
        cn.countArrays();
    }
}
