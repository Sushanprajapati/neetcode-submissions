class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] chArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();

            while (chArray[i] != '#') {
                sb.append(chArray[i++]);
            }
            i++;

            int frequency = Integer.valueOf(sb.toString());
            int end = i + frequency;
            
            sb = new StringBuilder();
            while (i < end) {
                sb.append(chArray[i++]);
            }
            i--;

            res.add(sb.toString());
        }

        return res;
    }
}
