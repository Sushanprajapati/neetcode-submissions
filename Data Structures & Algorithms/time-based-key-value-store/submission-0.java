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

        ArrayList<TimeStampValue> currentList = tempMap.get(key);
        Optional<TimeStampValue> fromBinarySearch = performBinarySearch(timestamp, currentList);

        if (fromBinarySearch.isEmpty()) return "";

        return fromBinarySearch.get().value;

    }

    public Optional<TimeStampValue> performBinarySearch(int timeStamp, ArrayList<TimeStampValue> currentList) {
        int left = 0, right = currentList.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            TimeStampValue currentValue = currentList.get(mid); 

            if (currentValue.timeStamp <= timeStamp) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (resultIndex == -1) return Optional.empty();

        return Optional.of(currentList.get(resultIndex));
    }
}

public class TimeStampValue {
    public String value;
    public int timeStamp;

    public TimeStampValue(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}
