package solutions.pack5_Postfix;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN 
{
    private static Pattern pattern = Pattern.compile("-?\\d++(\\.\\d++)?");
    public static boolean isNumeric(String strNum)
    {
        if(strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn)
    {
        MyStackA stack = new MyStackA();
        StringTokenizer st = new StringTokenizer(rpn);
        while(st.hasMoreTokens())
        {
            String t = st.nextToken();
            if(isNumeric(t))
                stack.push(Double.parseDouble(t));
            else
            {
                double b = stack.pop();
                double a = stack.pop();
                switch(t)
                {
                    case "+" :
                        stack.push(a + b);
                        break;

                    case "-" :
                        stack.push(a - b);
                        break;

                    case "*" :
                        stack.push(a * b);
                        break;

                    case "/" :
                        stack.push(a / b);
                        break;

                    default :
                        break;
                }
            }
        }
        return stack.top();
    }
}
