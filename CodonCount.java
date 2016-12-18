import java.util.HashMap;

/**
 * Created by chen.anidam on 18-Dec-16.
 */
public class CodonCount {

    private HashMap<String, Integer> mapDna;

    public CodonCount() {
        mapDna = new HashMap<>();
    }

    public void buildCodonMap(int start, String dna) {
        String codon = dna.substring(start, start + 3);
        if (mapDna.containsKey(codon)) {
            int k = mapDna.get(codon);
            mapDna.put(codon, k+1);
        }
        else {
            mapDna.put(codon, 1);
        }
    }

    public String getMostCommonCodons() {
        int max = 0;
        String res = "";
        for (String s : mapDna.keySet()) {
            if (mapDna.get(s) > max) {
                max = mapDna.get(s);
                res = s;
            }
        }
        return res;
    }

    public void printCodonCounts(int start, int end) {
        for (String s : mapDna.keySet()) {
//            System.out.println(s +"\t"+ mapDna.get(s));
            int count = mapDna.get(s);
            if (count > start && count < end)
                System.out.println(s +"\t"+ count);
        }
    }

    public void tester(String dna) {
        for (int i=0; i < dna.length(); i++)
    }
}
