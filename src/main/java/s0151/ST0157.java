package s0151;
/*
157. Read N Characters Given Read4
Easy

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Example 1:

Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".

Example 2:

Input: buf = "abcde", n = 5
Output: "abcde"
 */
public class ST0157 {
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int count = 0, byteRead;
        while (count < n) {
            byteRead = read4(tmp);
            int bcopy = count+byteRead > n ? n-count : byteRead;
            System.arraycopy(tmp, 0, buf, count, bcopy);
            count += bcopy;
            if (bcopy < 4) {
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
