class Solution {

    public String encode(List<String> strs) {
        StringBuilder tempString = new StringBuilder("");

        for (String str: strs) {
            tempString.append(str.length()).append('#').append(str);
        }

        return tempString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            StringBuilder sb = new StringBuilder();

            while (charArray[i] != '#') {
                sb.append(charArray[i]);
                i++;
            }
            i++;

            int length = Integer.valueOf(sb.toString());
            int end = i + length;
            sb = new StringBuilder();

            while (i < end) {
                sb.append(charArray[i]);
                i++;
            }
            i--;

            result.add(sb.toString());
        }

        return result;
    }
}
