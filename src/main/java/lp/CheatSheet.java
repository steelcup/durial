package lp;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CheatSheet {
    @Test
    public void test() {
        int[]a = {1,2,3};  int aLen = a.length;
        int[][]aa = {{1,2,3},
                {4,5,6}};
        Arrays.toString(a);  Arrays.equals(a, new int[]{1,2,3});  Arrays.deepEquals(aa, null);
        int[]bb = a.clone();
        int[][] matrix = new int[3][3];

        List<Integer> list = Arrays.asList(1,2,3);  int listLen = list.size();  Object[]b = list.toArray();
        Integer[] c = new Integer[list.size()];  Integer[] ia = list.toArray(c);
        list.addAll(new ArrayList<>());

        System.out.println(Arrays.toString(a));  System.out.println(list.toString());

        String s = "abcd";  int sLen = s.length();  char[] cs = s.toCharArray(); s.indexOf('c', 1);//from 1
        char ch = s.charAt(1);  s.substring(0, 2);

        Set<Integer> set = new HashSet<>();  set.add(2);  set.clear();  set.contains(2); set.remove(2);
        Object[] sa = set.toArray();

        Integer.toString(5);  int ip = Integer.parseInt("10");
        Stack<Integer> stack = new Stack();	 stack.push(3);  int i = stack.peek(); stack.pop();
        stack.isEmpty();

        PriorityQueue<Integer> q = new PriorityQueue<>();  q.add(3); i = q.peek(); i = q.remove(); q.size();
        q = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }});
        q = new PriorityQueue<Integer>((Integer i1 , Integer i2)->i1-i2);
        q = new PriorityQueue<Integer>(Collections.reverseOrder());
        Character.isDigit('3');  Character.isLetterOrDigit('c');

        AtomicInteger target = new AtomicInteger(-1);  target.incrementAndGet();  target.getAndIncrement();
        target.get();
        target.set(3);

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(1, x->new ArrayList<>()).add(2);
        System.out.println(map.get(1).toString());
    }

    @Test
    public void testBits() {
        //check if right first bit is one
        int i = 5;
        System.out.println(i&1);
        //count how many ones
        int count = 0;
        while (i != 0) { //cannot check i > 0,  i could be negative
            count += i&1;
            i = i >>> 1;
        }
        System.out.println("contains ones "+count);
        //get rid of the right most bit
        //can use it to check if power of two,  zero result means it is
        //or use it in a loop to count how many bits in an int
        i = 5;
        System.out.println(i&(i-1));
        count=0;
        while (i != 0) {
            count++;
            i = i&(i-1);
        }
        System.out.println("num of bits is " + count);
        //keep the right most one, and rest 0
        System.out.println(5&-5); //0101 -> 0100
        System.out.println(3&-3); //0011 -> 0001
        System.out.println(4&-4); //0100 -> 0100
    }
}
class Abc implements Comparable<Abc> {
    @Override
    public int compareTo(Abc o) {
        return 0;
    }
}
