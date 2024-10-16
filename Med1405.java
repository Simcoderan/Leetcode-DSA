//Longest Happy String
import java.util.PriorityQueue;
class CountCharacter {
    int count;
    char c;

    public CountCharacter(int ct,char c){
        this.count=ct;
        this.c=c;
    }
}

    class Med1405{
    public String longestDiverseString(int a, int b, int c) {
        //max heap
        //3:c
        PriorityQueue<CountCharacter> pq= new PriorityQueue<>((c1,c2)-> c2.count-c1.count);

        if (a>0){
            pq.add(new CountCharacter(a,'a'));
          }

          if (b>0){
            pq.add(new CountCharacter(b,'b'));
          }

          if (c>0){
            pq.add(new CountCharacter(c,'c'));
          }
          //Input : a=1,b=1,c=7
          //output: "ccaccbcc"
          //{7:c,b:1,a:1}
          StringBuilder sB= new StringBuilder();
          while(!pq.isEmpty()){
            CountCharacter ele = pq.poll();

            int count = ele.count;
            char c1=ele.c;
//three character rule will happen if we add c
            if (sB.length()>=2 && sB.charAt(sB.length()-1)==c1 && sB.charAt(sB.length()-2)==c1){
                if (pq.isEmpty()){
                    break;
                }
                CountCharacter ele2=pq.poll();
                int count2=ele2.count;
                char c2=ele2.c;

                count2=count2-1;
                 sB.append(c2);

                 if (count2>0){
                    pq.add(new CountCharacter(count2,c2));
                 }
       

            }
             else {
                count =count-1;
                 sB.append(c1);

            }

            if (count>0){
                pq.add(new CountCharacter(count,c1));
            }

          }
          return sB.toString();
    }
}