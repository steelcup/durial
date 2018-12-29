package s0151;
/*
158. Read N Characters Given Read4 II - Call multiple times
Hard

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Example 1:

Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""

Example 2:

Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""
 */
public class ST0158 {
    char[] cs = new char[4];
    int csCount;
    int csIdx;//current available idx
    public int read(char[] buf, int n) {
        int count = 0;
        while (n > count) {
            if (csIdx == csCount) {//has read up to the end, no avaliable
                csIdx = 0;
                csCount = read4(cs);
            }
            //read from internal cs first
            while (csIdx < csCount && count < n) {
                buf[count++] = cs[csIdx++];
            }
            if (csCount < 4) {
                break;
            }
        }
        return count;
    }
    //given func
    int read4(char[] buf) {
        return 0;
    }
}
