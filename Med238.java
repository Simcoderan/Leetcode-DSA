import java.util.Arrays;

          
    class Med238 {
    public int[] productExceptSelf(int[] nums) {
       //array creation
        int[] result = new int [nums.length];
        //by default setting values 1
         Arrays.fill(result,1);

         int pre=1,post=1;
         for(int i=0;i<nums.length;i++){
            result[i]=pre;
            pre =nums[i]*pre;

         }
         for(int i=nums.length-1;i>=0;i--){
            result[i]= result[i]*post;
            post=post*nums[i];
         }
         return result;

        
    }
}
    

