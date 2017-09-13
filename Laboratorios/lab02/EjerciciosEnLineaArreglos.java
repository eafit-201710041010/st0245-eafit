public class EjerciciosEnLineaArreglos
{
    /**Array-2*/
    /**sum13*/
    public int sum13(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int s = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 13){
                s += nums[i];
            } else {
                i ++;
            }
        }
        return s;
    }
    
    /**has22*/
    public boolean has22(int[] nums) {
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] == 2 && nums[i+1] == 2){
                return true;
            }

        }
        return false;
    }
    
    /**sum28*/
    public boolean sum28(int[] nums) {
        int doss = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 2){
                doss += 2;
            }
        }

        if (doss == 8){
            return true;
        }
        return false;
    }
    
    /**fizzArray*/
    public int[] fizzArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i;
        }
        return a;
    }
    
    /**haveThree*/
    public boolean haveThree(int[] nums) {
        int tres = 0;

        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] == 3 && nums[i+1] != 3){
                tres++;
            } else if (nums[i] == 3 && nums[i+1] == 3){
                return false;
            }
        }

        if (nums.length > 2){
            if (nums[nums.length-1] == 3 && nums[nums.length-2] != 3){
                tres++;
            }
        }

        if (tres == 3){
            return true;
        }
        return false;
    }
    
    /**Array-3*/
    /**maxSpan*/

    public int maxSpan(int[] nums) {
        int maxS = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = nums.length - 1; j > i; j--){
                if (nums[j]==nums[i]){
                    if (j - i + 1 > maxS){
                        maxS = j-i + 1;
                    }
                }
            }
        }
        if (maxS == 0 && nums.length != 0){
            return 1;
        }
        return maxS;
    }
    
    /**fix45*/
    public int[] fix45(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == 5) {
                        if (j > 0 && nums[j-1] != 4) {
                            temp = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = temp;
                        } 
                        else if (j == 0) {
                            temp = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }
    
    /**linearIn*/
    public boolean linearIn(int[] outer, int[] inner) {
        int numsR = 0;
        for (int i = 0; i < inner.length; i++){
            for (int j = 0; j < outer.length; j++){
                if (inner[i] == outer[j]){
                    numsR++;
                    break;
                }
            } 
        }
        if (numsR == inner.length){
            return true;
        } else {
            return false;
        }
    }
    
    /**seriesUp*/
    public int[] seriesUp(int n) {
        int[] nums = new int [n*(n + 1)/2];
        int a = 0;
        for (int i = 0; i <= n; i++){
            for (int j = 1; j <= i; j++){
                nums[a] = j;
                a++;
            }
        }
        return nums;
    }
    
    /**countClumps*/
    public int countClumps(int[] nums) {
        int c = 0;
        for (int i = 1; i < nums.length-1; i++){
            if (nums[i-1] == nums[i]){

            } else if (nums[i+1] == nums[i]) {
                c++;
            }
        }
        if (nums.length == 0) return 0;
        if (nums[0] == nums [1]){
            c++;
        }
        return c;
    }
}