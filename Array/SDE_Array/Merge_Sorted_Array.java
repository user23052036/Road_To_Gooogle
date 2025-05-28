package Array.SDE_Array;

//refer notes for explanation
//using two pointer approach
//tc-> O(M+N)
//sc->O(1)
public class Merge_Sorted_Array 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int pnt1=m-1,pnt2=n-1;
        int indx=m+n-1;

        while(pnt1>=0 && pnt2>=0)
        {
            if(nums1[pnt1] >= nums2[pnt2])
                nums1[indx--]=nums1[pnt1--];
            else
                nums1[indx--]=nums2[pnt2--];
        }
        while(pnt2>=0)
            nums1[indx--]=nums2[pnt2--];
    }
}
