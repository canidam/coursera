import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chen.anidam on 13-Dec-16.
 */
public class WordLengths {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("words.txt").getFile());
    ArrayList<String> myWords;
    ArrayList<Integer> myFreqs;
    int[] counts = new int[31];

    public WordLengths() {
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public void findUnique() {
        myFreqs.clear();
        myWords.clear();

        try (Scanner scan = new Scanner(file)) {

            while (scan.hasNext()) {

                String word = scan.next().toLowerCase();
                int idx = myWords.indexOf(word);

                if (idx != -1) {
                    int times = myFreqs.get(idx);
                    myFreqs.set(idx, times + 1);
                }
                else {
                    myWords.add(word);
                    myFreqs.add(1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countWordsLength()
    {

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                // add myWords to arraylist and rip punctuations
                myWords.add(scan.next().replaceAll("[^a-zA-Z0-9-]", ""));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // loop over the arraylist and count chars per word
        for (String w : myWords) {
            int index = w.length();
            if (index >= 30) {
                counts[30] += 1;
                continue;
            }
            counts[index] += 1;
        }
    }

    public void tester() {
        findUnique();
        int i = 0;
        for (String s : myWords) {
            System.out.println(s + " appears " + myFreqs.get(i));
            i++;
        }
    }

    int indexOfMax(int[] array) {
        int max = 0, index = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    int findIndexOfMax() {
        int idx = 0;
        int val = 0;
        for (int k=0; k < myFreqs.size(); k++) {
            if (myFreqs.get(k) > val) {
                idx = k;
                val = myFreqs.get(k);
            }

        }
        return idx;
    }

    public static void main(String[] args) {
        /** WordLengths wl = new WordLengths();
        wl.countWordsLength();

        for (int i=0; i < wl.counts.length; i++) {
            System.out.println("length: " + i + "\t" + wl.counts[i]);
        }
        System.out.println("largest element length: " + wl.indexOfMax(wl.counts)); */

        WordLengths wl = new WordLengths();
        wl.tester();
        System.out.println("size is " + wl.myFreqs.size());
        int max = wl.findIndexOfMax();
        System.out.println(max + " word is " + wl.myWords.get(max));
    }

}
