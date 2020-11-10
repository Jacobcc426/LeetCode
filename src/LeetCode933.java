import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode933 {
}


class LeetCode933RecentCounter {

    List<Integer> counter;
    public LeetCode933RecentCounter() {
        counter = new ArrayList<>();
    }

    public int ping(int t) {
        counter.add(t);
        while(counter.get(0)<t-3000)
            counter.remove(0);
        return counter.size();
    }
}
