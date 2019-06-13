import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(0);
        initListNode(head, 1, 9);
        System.out.println("反转前：");
        System.out.println(head);
        ListNode listNode = main.reverseList(head);
        System.out.println("反转后：");
        if (listNode != null) {
            System.out.println(listNode);
        }
    }

    private static void initListNode(ListNode head, int num , int size) {
        if (size < 0) {
            return;
        }
        ListNode node = new ListNode(num);
        head.setNext(node);
        initListNode(node, ++num , --size);
    }

    public String getHint(String secret, String guess) {
        Map<Character, Integer> maps = new HashMap<>();
        List<Character> listg = new ArrayList<>();
        int a = 0, b = 0;
        String res;
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            }else{
                if (!maps.containsKey(secret.charAt(i))) {
                    maps.put(secret.charAt(i), 1);
                }else {
                    Integer integer = maps.get(secret.charAt(i));
                    integer++;
                    maps.put(secret.charAt(i), integer);
                }
                listg.add(guess.charAt(i));
            }
        }
        for (Character character : listg) {
            if (maps.containsKey(character) && maps.size() > 0) {
                b++;
                if (maps.get(character) <= 0) {
                    maps.remove(character);
                } else {
                    Integer integer = maps.get(character);
                    integer--;
                    maps.put(character, integer);
                }
            }
        }
        res = a + "A" + b + "B";
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        List<Integer> resList = new ArrayList<>();
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            resList.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                Integer integer = resList.get(resList.size() - 1);
                if (integer < nums[j]) {
                    resList.add(nums[j]);
                } else if (integer > nums[j] && resList.size() >= 2 && resList.get(resList.size() - 2) < nums[j]) {
                    resList.remove(resList.size() - 1);
                    resList.add(nums[j]);
                }
            }
            if (resList.size() >= res) res = resList.size();
            resList.clear();
        }
        return res;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
