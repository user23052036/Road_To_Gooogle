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
            if ((val & 1) == 1) val = val * 3 + 1;  //faster
            else val /= 2;
        }
        System.out.println(sb.toString().trim());
    }
}


class Weird_Algo3
{
    public static void main(String[] args) throws IOException 
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



/*

BufferedReader.readLine() always reads an entire line of input as a String, including all characters up 
to (but not including) the newline character. After reading, the newline is consumed and not left in 
the buffer.

--------------------------------------------------------------------------------------------------

Which is Faster?
StringTokenizer is generally faster than split("\\s+") 
because:
It does not use regular expressions (which are relatively expensive).
It processes tokens one at a time, avoiding the creation of an intermediate array of strings.

split("\s+") is a bit slower due to:
The overhead of regex processing.
Allocating an array for all tokens at once.

-----------------------------------------------------------------------------------------------------

1. split("\\s+") Approach

String line = br.readLine();
String[] parts = line.split("\\s+");
for (String part : parts) 
{
    int num = Integer.parseInt(part);
    // process num
}

How it works:
Splits the entire line into a String array using a regular expression.
Then parses each string to an integer.
Time Complexity:
Splitting: O(N) for N tokens, but with some overhead due to regex processing.
Parsing: O(N).
Total: O(N), but with higher constant overhead due to regex.

----------------------------------------------------------------------------------------------------

2. StringTokenizer Approach

String line = br.readLine();
StringTokenizer st = new StringTokenizer(line);
while (st.hasMoreTokens()) 
{
    int num = Integer.parseInt(st.nextToken());
    // process num
}
How it works:
Iterates over tokens in the line one by one, splitting on whitespace by default.
Parses each token to integer as you go.
Time Complexity:
Tokenizing: O(N), but with lower constant overhead (no regex).
Parsing: O(N).
Total: O(N), with lower constant overhead.

-----------------------------------------------------------------------------------------------------

A large buffer size in BufferedReader (8KB) allows it to read and store a bigger chunk of input data 
in memory at once, compared to Scanner (1KB). This reduces the number of read operations required from 
the underlying input stream, which are relatively slow because each read operation interacts with the 
operating system or hardware.

1. Input Flow Architecture
Keyboard input → System.in (raw byte stream) → InputStreamReader (byte-to-character converter) → 
BufferedReader (buffered storage).

2. Buffering Stages
a. System.in (Operating System Buffer) Your typed data is first stored in the OS input buffer 
(a low-level byte buffer managed by the operating system).This buffer temporarily holds bytes until 
the Java program reads them.

b. InputStreamReader Converts bytes from System.in into characters using the default/system charset 
(e.g., UTF-8).Acts as a bridge between byte streams and character streams but does no buffering itself.

c. BufferedReader's Internal Buffer The BufferedReader defaults to an 8KB (8192-character) 
internal buffer .
When you call read() or readLine(), the BufferedReader:
Fills its buffer: Reads up to 8KB of characters from the InputStreamReader in a single OS-level read 
operation.
Stores the data: The 10KB input is split into:
First chunk: 8KB (fills the buffer completely).
Second chunk: 2KB (remaining data).
Serves subsequent reads from its buffer until empty, then repeats step 1.

3. Example: Reading 10KB Input
First read()/readLine() call:
BufferedReader reads 8KB from InputStreamReader → stores in its internal buffer.
The OS buffer is now reduced to 2KB of unread data.
Buffer exhaustion:
After processing the first 8KB, the BufferedReader’s buffer is empty.
Second read()/readLine() call:
BufferedReader reads the remaining 2KB from InputStreamReader → refills its buffer.
The OS buffer is now empty.

4. Key Points
Reduced OS interactions: Only 2 read operations are needed for 10KB input (vs. 10,000+ operations 
without buffering) .
Efficiency: The 8KB buffer minimizes costly OS/hardware interactions by fetching data in large chunks .

Data storage locations:
Short-term: OS buffer (before Java reads it).
Medium-term: BufferedReader’s internal 8KB buffer (after conversion to characters).
Long-term: Your Java variables/objects (e.g., String objects created via readLine()).

BufferedReader:
When you call readLine(), BufferedReader first checks if its internal buffer has enough data. If not, 
it reads a large block (8KB) from the input stream into memory. Subsequent reads are served from this 
buffer, which is much faster than accessing the input stream repeatedly.

Scanner:
With a smaller buffer (1KB), Scanner needs to refill its buffer more frequently. Each refill requires 
a new read operation from the input stream, which is slower.
 
Even though you parse manually with BufferedReader, the parsing (Integer.parseInt(), 
Double.parseDouble(), etc.) is much more lightweight than the complex, regex-based parsing Scanner does.
Combined with more efficient reading, this makes BufferedReader + manual parsing faster than Scanner.

In short:
BufferedReader: Fast reading + simple parsing = High speed
Scanner: Slower reading + complex parsing = Lower speed
If you want both speed and convenience, use BufferedReader for input and manual parsing for data 
conversion!


readLine():
Reads an entire line of text from the input (up to the newline character) and returns it as a String.
You can then convert this String to an integer using Integer.parseInt().
This is the standard and recommended way to read an integer from user input with BufferedReader.

read():
Reads a single character from the input and returns its Unicode (ASCII) integer value.
If you use read() and the user enters "123" and presses Enter, read() will only read the first character
 ('1') and return its ASCII code (49), not the integer 123.
This is not suitable for reading multi-digit numbers or full user input lines.


A newline character left in the buffer does not affect the behavior of nextInt(), nextDouble(), or 
next() themselves. These methods are designed to skip over any whitespace (including spaces, tabs, and 
newlines) before reading the next token, so they will simply ignore any leftover newline and proceed to
read the next valid input.

However, the issue arises only when you call nextLine() after using nextInt(), nextDouble(), or next().
In that case, nextLine() will immediately read and consume the leftover newline character, resulting in
an empty string being returned and skipping the intended user input.

 */
