package Array.SDE_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals 
{
    public int[][] merge(int[][] intervals) 
    {
        if(intervals.length<=1) return intervals;

        //sorting the interval according to the start time
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
         
        // iterating over the sorted intervals
        for(int[] interval:intervals)
        {
            int[] last = result.getLast();

            // overlapping + extending case  as complete ocerlapping case can be ignored
            if(interval[0]<=last[1] && interval[1]>last[1])
                last[1] = interval[1];
            
            // pussing into result the no intersection case
            else if(interval[0]>last[1])
                result.add(interval);
        }
        return result.toArray(new int[result.size()][2]);
    }   
}
