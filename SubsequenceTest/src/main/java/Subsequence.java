
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequence {


    public boolean find(String [] seqX, String [] seqY){
        boolean found = false;
        List<String> arrayX = Arrays.asList(seqX);
        List<String> arrayY = Arrays.asList(seqY);

        for (int x = 0; x < arrayX.size(); x++) {
            for (int y = 0; y < arrayY.size(); y++) {
                if(arrayX.get(x).equals(arrayY.get(y))){
                    found = true;
                    break;
                } else found = false ;
            }
            if (!found) break;
        }
        return found;
    }

    public static void main(String[] args) {

        Subsequence s = new Subsequence();
        String [] x = {"A", "B", "T", "Q", "1", "3"};
        String [] y = {"BD", "A", "ABC", "B", "M", "D", "V", "C", "T", "Q", "1", "2", "3"};
        boolean b = s.find(x,y);
        System.out.println(b);
    }

}
