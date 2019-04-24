//class Solution {
//    public Solution(){}
//
//    public static void main(String[] args) {
//        System.out.println(addTwoNumbers(new ListNode(2),new ListNode(8)).val);
//    }
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = null;
//        int c = 0;
//        while(l1 != null && l2 != null){
//            c = l1.val + l2.val + c;
//            if(result != null)
//                result.next = new ListNode(c % 10);
//            else
//                result = new ListNode(c % 10);
//            c = c>=10 ? 1:0;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return result;
//    }
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int x){
//            this.val = x;
//        }
//
//    }
//}

//public class Solution {
//    /**
//     * @param A: An integer array
//     * @return: An integer
//     */
//
//    public static void main(String[] args) {
//        int[] A = new int[] {1,1,2,2,3,4,4};
//        System.out.println(singleNumber(A));
//    }
//
//    public static int singleNumber(int[] A) {
//        // write your code here
//        int count= 0;
//        int[] tem = new int[A.length];
//        for(int i = 0;i<A.length;i++){
//            int flag = -1;
//            if((flag = judge(tem, count, i)) != -1)
//                tem[flag] = tem[i] = -1;
//            else{
//                tem[count++] = A[i];
//            }
//        }
//
//        for(int i = 0;i<tem.length;i++){
//            if(tem[i] != -1)
//                return tem[i];
//
//        }
//
//        return -1;
//    }
//
//    public static int judge(int[] A, int n, int num){
//
//        for(int i = 0;i<=n;i++){
//            if(A[i] == num)
//                return i;
//
//        }
//
//        return -1;
//    }
//}

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List words = new ArrayList<>();
        words.add("cats");
        words.add("dog");
        words.add("sand");
        words.add("and");
        words.add("cat");
        System.out.printf(wordBreak("catsandog", words).toString());
    }

    public static Boolean wordBreak(String s, List<String> wordDict) {
        return dydiv(s,wordDict, 0, s.length());
    }

    static boolean dydiv(String s, List<String> wordDict, int low, int high){
        if(high - low <= 0)
            return true;

        for(int i = low+1;i<=high;i++){
            if(dydiv(s,wordDict, low, i) && dydiv(s,wordDict, i+1, high))
                return true;
        }

        return false;
    }
}