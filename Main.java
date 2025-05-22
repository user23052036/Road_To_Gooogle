import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(sb.readLine());
        long sum = (long) limit * (limit + 1) / 2L;

        String inputs = sb.readLine();
        StringTokenizer token = new StringTokenizer(inputs);
        while(token.hasMoreTokens())
            sum -= Long.parseLong(token.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(sum));
        bw.newLine();
        bw.flush();
    }
}

