package tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path)
    {
        StringBuilder builder=new StringBuilder();//StringBuilder basically allows characters to add to a string easily.
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null)
            {
                builder.append(line+"\n");
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return builder.toString();
    }
    
    public static int parseInt(String number)//This method converts the string to the integer value.
    {
        try
        {
            return Integer.parseInt(number);
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
}
