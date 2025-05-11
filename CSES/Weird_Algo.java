package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Weird_Algo
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long val = sc.nextInt();

        while(true)
        {
            System.out.print(val+" ");

            if(val==1) break;
            if(val%2 == 0) val /= 2;
            else val = (val*3)+1;
        }
    }
}


//In Java, you should compare the result with 1 to get a boolean value, because Java does not treat 
//non-zero integers as true in conditions (unlike C/C++).
class Weird_Algo2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long val = sc.nextLong();
        StringBuilder sb = new StringBuilder();

        while (true) 
        {
            sb.append(val).append(" ");
            if (val == 1) break;
            if ((val & 1) == 1) val = val * 3 + 1;
            else val /= 2;
        }
        System.out.println(sb.toString().trim());
    }
}


class Weird 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder s = new StringBuilder();
        s.append(n).append(" ");
        while (n!=1)
        {
            if(n%2==0) n=n/2;
            else n=3*n+1;
            s.append(n).append(" ");
 
        }
        System.out.println(s);
    }
}
