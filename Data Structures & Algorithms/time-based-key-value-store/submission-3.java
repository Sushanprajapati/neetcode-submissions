class TimeMap {
    Map<String, ArrayList<TimeStampValue>> tempMap;

    public TimeMap() {
        tempMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!tempMap.containsKey(key)) {
            tempMap.put(key, new ArrayList<>());
        }
        ArrayList<TimeStampValue> currentValue = tempMap.get(key);
        currentValue.add(new TimeStampValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!tempMap.containsKey(key)) return "";

        ArrayList<TimeStampValue> currentTimeStampValue = tempMap.get(key);
        Optional<TimeStampValue> fromBinarySearch = performBinarySearch(currentTimeStampValue, timestamp);

        if (fromBinarySearch.isEmpty()) return "";

        return fromBinarySearch.get().value;
    }

    public Optional<TimeStampValue> performBinarySearch(ArrayList<TimeStampValue> timeStampArray, int timestamp) {
        int left = 0, right = timeStampArray.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            TimeStampValue currentTimeStampValue = timeStampArray.get(mid);
            
            if (currentTimeStampValue.time <= timestamp) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (resultIndex == -1) return Optional.empty();

        return Optional.of(timeStampArray.get(resultIndex));
    }
}

public class TimeStampValue {
    public String value;
    public int time;

    public TimeStampValue(String value, int time) {
        this.value = value;
        this.time = time;
    }
}
