/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new intervalComparator());
        for(int i = 0; i < intervals.size(); i++){
            Interval currInter = intervals.get(i);
            if(res.isEmpty()) res.add(currInter);
            else{
                Interval lastAdded = res.get(res.size() - 1);
                if(lastAdded.end >= currInter.start){
                    lastAdded.end = Math.max(lastAdded.end, currInter.end);
                }else{
                    res.add(currInter);
                }
            }
        }
        return res;
    }
}

class intervalComparator implements Comparator<Interval>{
    public int compare(Interval I1, Interval I2){
        if(I1.start < I2.start) return -1;
        else if(I1.start > I2.start) return 1;
        else if(I1.end < I2.end) return -1;
        else if(I1.end > I2.end) return 1;
        else return 0;
    }
}
