import java.util.*;
import java.util.regex.Pattern;

public class A2042 {
    public boolean areNumbersAscending1(String s) {
        String[] strs = s.split(" ");
        String regex = "[0-9]+[\\.]?[0-9]*";
        Integer tmp = 0;
        for(String str : strs){
            if(Pattern.matches(regex, str)) {
                if(Integer.parseInt(str) <= tmp) return false;
                tmp = Integer.parseInt(str);
            }
        }
        return true;
    }

    public char firstUniqChar(String s) {
        if(s.length() == 0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(Character character : s.toCharArray()){
           map.put(character, map.getOrDefault(character, 0)+1);
        }
        for(Character character : s.toCharArray()){
           if (map.get(character) == 1) return character;
        }
        return ' ';
    }

    public boolean areNumbersAscending(String s){
        String[] strs = s.split(" ");
        Integer tmp = 0;
        for(String str : strs){
            if(str.matches("^[0-9]*$")){
                if(Integer.parseInt(str) <= tmp) return false;
                tmp = Integer.parseInt(str);
            }
        }
        return true;
    }

    public int[] levelOrder(TreeNode root) {
        int[] arr = new int[1000];
        int index = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arr[index] = node.val;
            index ++;
            if(node.left != null) queue.add(root.left);
            if(node.right != null) queue.add(root.right);
        }
        return Arrays.copyOf(arr, index);
    }

}
