public class EjerciciosEnLíneaRecursion2
{
    /** groupSum5 */
    public boolean groupSum5(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;
        }

        if(nums[start] % 5 == 0){
            if(start + 2 <= nums.length && nums[start + 1] == 1){
                nums[start+1] = 0;
            }
            return groupSum5(start + 1, nums, target - nums[start]);

        } else {
            return groupSum5(start + 1, nums, target - nums[start]) ||
            groupSum5(start + 1, nums, target);
        }
    }
    /** groupSum6 */
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;
        }

        if(nums[start] % 6 == 0){
            return groupSum6(start + 1, nums, target - nums[start]);

        } else {
            return groupSum6(start + 1, nums, target - nums[start]) ||
            groupSum6(start + 1, nums, target);
        }
    }
    /** groupNoAdj */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;
        }

        return groupNoAdj(start + 2, nums, target - nums[start]) ||
        groupNoAdj(start + 1, nums, target);
    }
    /** groupSumClump */
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target == 0;
        }

        int i;
        int sum = 0;
        for (i = start; i < nums.length && nums[i] == nums[start]; i++){
            sum += nums[i];
        }
        nums[start] = sum;

        return groupSumClump(i, nums, target - nums[start]) || 
        groupSumClump(i, nums, target);
    }
    /** splitArray */
    public boolean splitArray(int[] nums) {
        return splitArray2(0, nums, 0, 0);
    }
    public boolean splitArray2(int start, int[] nums, int g1,  int g2) {
        if(start >= nums.length){
            return g1 == g2;
        }

        return splitArray2(start+1, nums, g1 + nums[start], g2) ||
        splitArray2(start+1, nums, g1, g2 + nums[start]);
    }
}
