class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String st: strs) {
            sb.append(st.length()).append('#').append(st);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] chArray = str.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            StringBuilder sb = new StringBuilder();
            while (chArray[i] != '#') {
                sb.append(chArray[i++]);
            }
            i++;

            int start = Integer.valueOf(sb.toString());
            int end = i + start;
            sb = new StringBuilder();
            while(i < end) {
                sb.append(chArray[i++]);
            }
            i--;

            result.add(sb.toString());
        }
        return result;
    }
}
