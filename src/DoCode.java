import jdk.internal.icu.text.UnicodeSet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoCode {

    private static List<Integer> s1 = new ArrayList<Integer>();

    public static List<Integer> getS1() {
        return s1;
    }

    private static List<Integer> s2 = new ArrayList<Integer>();
    public static List<Integer> getS2() {
        return s2;
    }




    public DoCode(String Arg)
    {
        try
        {
            FileInputStream reader = new FileInputStream(Arg);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(reader));
            String c;
            while ( ( c = bufferedReader.readLine()) != null )
            {
                s1.add((int)c.charAt(0));
                s2.add((int)c.charAt(2));
            }
        } catch(IOException ex)
        {
            System.out.print("Err");
        }
    }
    public static byte[] Fix(byte[]buf )
    {

            for(int i = 0 ; i < buf.length ; i++) {

                for(int j = 0 ; j < s1.size() ; j++) {

                    if (buf[i] == s1.get(j)) {
                        buf[i] = s2.get(j).byteValue();

                    }
                }

            }





        return buf;



    }
}