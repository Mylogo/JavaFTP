package me.mylogo.javaftp.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class Util {

    //Taken from http://stackoverflow.com/questions/1574837/connecting-an-input-stream-to-an-outputstream
    public static void copyStream(InputStream input, OutputStream output)
            throws IOException
    {
        byte[] buffer = new byte[1024]; // Adjust if you want
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
        output.flush();
//        input.close();
//        output.close();
    }

}
