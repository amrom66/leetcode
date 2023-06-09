import java.util.HashMap;
import java.util.Map;

public class C76 {
    public String minWindow(String s, String t) {
        String res = "";
        if (t.length() > s.length()) {
            return res;
        }
        Map<Character, Integer> need = new HashMap<>(); // 记录target每个元素出现的次数
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0; // 左右边界
        int valid = 0; // window中满足need的个数 valid==need.size时候right不再右移
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++; // 如果出现次数相等，valid+1
            }
            // 覆盖字串，开始左侧收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left; // 当前字串长度
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
