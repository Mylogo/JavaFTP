package me.mylogo.javaftp.interfaces;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public interface ISimpleFile {

    IFileLocation getFileLocation();
    boolean isDirectory();
    String getPath();
    String getName();
    default String getFullPath(){
        return getPath() + "/" + getName();
    }
    long getSize();
    OutputStream getFileOutputStream() throws Exception;
    InputStream getFileInputStream() throws Exception;
    void pasteMeInto(OutputStream output);
    void fillMeFrom(InputStream input);

}
