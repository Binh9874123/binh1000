import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        ReadConfig readConfig = new ReadConfig(args[0]);



        if(args.length == 1 && readConfig.Read(args[0]))
        {
            FileInputStream fileInputStream = new FileInputStream(readConfig.GetInput());
            FileOutputStream fileOutputStream = new FileOutputStream(readConfig.GetOutput());
            DoCode doCode = new DoCode(readConfig.GetTable());
            byte[] buf = new byte[readConfig.GetBuffer()];
            int chars_read;
            while ((chars_read = fileInputStream.read(buf) )!= -1)
            {
                fileOutputStream.write(doCode.Fix(buf));
            }
            fileInputStream.close();
            fileOutputStream.close();
        }



    }
}
