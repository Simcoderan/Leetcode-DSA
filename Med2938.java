// Seperate black and white Balls

class Med2938 {
    public long minimumSteps(String s) {
        //1010101101-input
        //wp
        //i
        long totalSwaps=0;
         int wp=0;
        for (int i=0;i<s.length();i++){
             if(s.charAt(i)=='0'){
                totalSwaps=totalSwaps+(i-wp);
                wp=wp+1;
             }
          }
          //T:0(n)
          //S:0(1)
       
        return totalSwaps;
        
    }
}
