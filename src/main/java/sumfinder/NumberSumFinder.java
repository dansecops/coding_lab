package sumfinder;

public class NumberSumFinder {

    public < E extends Number> int find_sums(E sum, E arr[]) {
        int result = 0;
        boolean halfValueChecked = false;
        long halfSum = sum.longValue() / 2;

        for (int i = 0; i < arr.length; i++) {
            if(halfValueChecked && halfSum == arr[i].longValue()){
                continue;
            } else {
                if (halfSum == arr[i].longValue()) {
                    halfValueChecked = true;
                    result++;
                    continue;
                } else {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i].longValue() + arr[j].longValue() == sum.longValue()) {
                            result++;
                            if (arr[i] != arr[j]) {
                                result++;
                            }
                        }

                    }
                }
            }

        }
        return result;
    }


}
