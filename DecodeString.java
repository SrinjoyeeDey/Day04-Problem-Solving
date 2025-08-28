import java.util.Stack;

public class SimplifyPath {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack=new Stack<>();
        Stack<Integer> countStack=new Stack<>();

        StringBuilder curr=new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10+(ch-'0');
            }
            else if(ch=='['){
                countStack.push(k);
                stringStack.push(curr);
                k=0;
                curr=new StringBuilder();
            }
            else if(ch==']'){
                int repeat=countStack.pop();
                StringBuilder decoded=stringStack.pop();
                while(repeat>0){
                    decoded.append(curr);
                    repeat--;
                }
                curr=decoded;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();

    }
}
