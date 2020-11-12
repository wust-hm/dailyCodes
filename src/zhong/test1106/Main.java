package zhong.test1106;

import java.util.*;

/**
 * @description
 * @author zhong
 * @date 2020/11/6 16:41
 * @motto talk is cheap, show me your code!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "3+2*(4/2)";
        transfer(str);
        int total = calcRevPolishNotation(str);
        System.out.println(total);
    }

    public static int calcRevPolishNotation(String express){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <express.length() ;i++) {
            // 普通数值的处理
            if ((express.charAt(i) + "").matches("\\d")){
                stack.push(express.charAt(i) + "");
                // + - * / 运算符的处理
            }else if ((express.charAt(i) + "").matches("[\\+\\-\\*\\/]")){
                String k1 = stack.pop();
                String k2 = stack.pop();
                // 计算结果
                int res = calcValue(k1, k2, (express.charAt(i) + ""));
                stack.push(res+"");
            }

        }
        return Integer.valueOf(stack.pop());
    }

    private static int calcValue(String k1, String k2, String c) {
        switch(c){
            case "+":
                return Integer.valueOf(k1)+Integer.valueOf(k2);
            case "-":
                return Integer.valueOf(k2)-Integer.valueOf(k1);
            case "*":
                return Integer.valueOf(k1)*Integer.valueOf(k2);
            case "/":
                return Integer.valueOf(k2)/Integer.valueOf(k1);
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }

    /**
     * 将中缀表达式转换为后缀表达式（逆波兰表达式）
     * @param express
     * @return
     */
    public static String transfer(String express){
        Stack<String> stack = new Stack<>();
        List<String> list= new ArrayList<>();
        for (int i=0;i<express.length();i++){
            String s = express.charAt(i) + "";
            if ((express.charAt(i)+"").matches("\\d")){
                list.add(express.charAt(i)+"");
            }else if((express.charAt(i)+"").matches("[\\+\\-\\*\\/]")){
                //如果stack为空
                if (stack.isEmpty()){
                    stack.push(express.charAt(i)+"");
                    continue;
                }
                //不为空

                //上一个元素不为（，且当前运算符优先级小于上一个元素则，将比这个运算符优先级大的元素全部加入到队列中
                //栈非空 && 上一个元素不是( && 当前元素s的优先级 <= 栈顶元素的优先级
                while (!stack.isEmpty()&&!stack.lastElement().equals("(")&&!comparePriority(express.charAt(i)+"",stack.lastElement())){
                    list.add(stack.pop());
                }
                stack.push(express.charAt(i)+"");
            }else if(express.charAt(i)=='('){
                //遇到左小括号无条件加入
                stack.push(express.charAt(i) + "");
            }else if(express.charAt(i)==')'){
                //遇到右小括号，则寻找上一堆小括号，然后把中间的值全部放入队列中
                while(!("(").equals(stack.lastElement())){
                    list.add(stack.pop());
                }
                //上述循环停止，这栈顶元素必为"("
                stack.pop();
            }
        }
        //将栈中剩余元素加入到队列中
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        StringBuffer stringBuffer = new StringBuffer();
        //变成字符串
        for (String s : list) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    /**
     * 比较运算符的优先级
     * @param o1
     * @param o2
     * @return
     */
    public static boolean comparePriority(String o1,String o2){
        return getPriorityValue(o1)>getPriorityValue(o2);
    }

    /**
     * 获得运算符的优先级
     * @param str
     * @return
     */
    private static int getPriorityValue(String str) {
        switch(str){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }

}
