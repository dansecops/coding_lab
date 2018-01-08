package sumfinder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StringSumFinder extends NumberSumFinder {
    //TODO: Test this class


    public int find_sums(String sum, String [] arr) {
        Set <Pair> seenPairs = new HashSet();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                Pair pair = new Pair(arr[i], arr[j]);
                if(!(seenPairs.contains(pair))){
                    if((arr[i]+arr[j]).equals(sum)){
                        seenPairs.add(pair);
                        result++;
                    }
                }

            }

        }

        return result;

        // "mama [ma]
    }


    private class Pair {

        private String key;
        private String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(key, pair.key) &&
                    Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, value);
        }
    }
}
