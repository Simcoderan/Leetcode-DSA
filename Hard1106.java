import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


    class Hard1106{
    public char evalExpr(char op, List<Character> list){
        if (op =='!'){
            return list.get(0)=='t'?'f':'t';

        }
        else if (op == '&'){
            for (char c: list){
                if(c=='f'){
                    return 'f';
                }
            }
            return 't';
        } else if (op =='|'){
              for (char c: list){
                if(c=='t'){
                    return 't';
                }
              }
              return 'f';
        }
        return 'f';

    }
    public boolean parseBoolExpr(String expression) {
        //"!(&(f,t))"
        Stack<Character> stack = new Stack<>();

        for (char c:expression.toCharArray()){
            if (c == ')'){
                List<Character>list=new ArrayList<>();
            while (stack.peek() != '('){
                list.add(stack.pop());

            }
            stack.pop();
            char op=stack.pop();
            char res= evalExpr(op,list);
            stack.push(res);

            } else if (c !=','){
                stack.push(c);

            }

        }
        return stack.peek() == 't'? true : false;

        
    }
}
    

