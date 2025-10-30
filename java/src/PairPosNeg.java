public static List<Integer> posNegPair(int[] arr) {

    Map<Integer, Integer> countMap = new HashMap<>();
    for (int j : arr) {
        int absNum = Math.abs(j);
        countMap.put(absNum, countMap.getOrDefault(absNum, 0) + 1);
    }

    Map<Integer, Integer> negCountMap = new HashMap<>();
    Map<Integer, Integer> posCountMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    for (int j : arr) {
        if (j < 0) {
            int absNum = Math.abs(j);
            negCountMap.put(absNum, negCountMap.getOrDefault(absNum, 0) + 1);
        }
        if (j > 0) {
            posCountMap.put(j, posCountMap.getOrDefault(j, 0) + 1);
        }
    }

    List<Integer> keys = new ArrayList<>(countMap.keySet());
    Collections.sort(keys);
    IO.println(keys);

    for (int key : keys) {
        if (posCountMap.containsKey(key) && negCountMap.containsKey(key)) {
            int count = Math.min(posCountMap.get(key), negCountMap.get(key));
            for (int i = 0; i < count; i++) {
                list.add(-1 * key);
                list.add(key);
            }
        }
    }


    return list;
}

void main() {

    int[] arr = {26, 15, -33, 12, 49, -29, 38, 49, -44, -44, 32, 23, -41, 19, 15, -16, 11, 41, -12, 11, -35, 40, -40, -49, -40, -40, 50};
    IO.println(posNegPair(arr));

}
