package s0051;

/*
56. Merge Intervals
Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


 */
import sutil.*;
import java.util.*;

public class ST0056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size()==0) {
            return intervals;
        }
        Collections.sort(intervals, (a, b) -> a.start==b.start?a.end-b.end:a.start-b.start);
        List<Interval> list = new ArrayList<>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > pre.end) {
                list.add(pre);
                pre = cur;
                continue;
            }
            if (cur.end <= pre.end) {
                //pre contains cur
                continue;
            }
            //overlap
            pre.end = cur.end;
        }
        list.add(pre); //don't forget this
        return list;
    }
}
