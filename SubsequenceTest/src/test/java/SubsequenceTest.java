import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubsequenceTest {

    @Test
    public void find() {
        Subsequence s = new Subsequence();
        String [] first = {"1", "12", "3", "4", "C"};
        String [] second = {"11", "2", "A", "0", "B", "12", "C", "7"};
        Assert.assertFalse(s.find(first, second));
    }

}