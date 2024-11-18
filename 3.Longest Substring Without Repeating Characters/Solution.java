class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        int left=0;
        int right=0;
        int ans=0;

        HashSet<Character> set=new HashSet<>();

        while(right<s.length()){
            //to find the value of the particular index
            char c =  s.charAt(right);

           //if the value exists in hashset or not
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
         }
         set.add(c);
         ans=Math.max(ans,right-left+1);
         right++;


        }

        return ans;
        
    }
}
