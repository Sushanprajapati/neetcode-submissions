class TimeMap {
    // Our HashMap will contain the value as ArrayList of value and timestamp.
    Map<String, ArrayList<TimeStampValue>> tempMap;

    public TimeMap() {
        tempMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Check if the key exists in our hashmap
        // if not, insert the key and initialize an empty arraylist as value. 
        if (!tempMap.containsKey(key)) {
            tempMap.put(key, new ArrayList<>());
        }

        // Get the value for particular key and then add the incoming (timeStamp and value) to the key 
        ArrayList<TimeStampValue> currentValue = tempMap.get(key);
        currentValue.add(new TimeStampValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // return empty if keydoesot exists in our map
        if (!tempMap.containsKey(key)) return "";

        // Since we have an ArrayList as value, we can apply binarySearch to find the target timeStamp.
        // First get the respective value for given key. The value would be of type (value, timeStamp) that we 
        // defined in our helper class. 
        // Then call a helper method for performing binarySearch.
        // Remember to make it Optional to make it null safety.
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
            // Get the (value, timeStamp) for value at position (mid) in our ArrayList.
            TimeStampValue currentValue = currentList.get(mid); 

            // Compare the timeStamp value at mid and the target TimeStamp.
            // If TimeStamp value at (mid <= target TimeStamp), then we know the value is in right portion of array.
            // So, shrink the array to right (i.e. left = mid + 1)
            // Remember to store the mid value to somewhere, it will be our answer. 
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

// We'll construct a separate helper class to instanstiate a composite structure for our problem
// This is the structure,which we'll be adding to our hashmap as a value. Key will be the "key" specified in the ques
public class TimeStampValue {
    public String value;
    public int timeStamp;

    public TimeStampValue(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}
