package me.mylogo.javaftp.util;

import me.mylogo.javaftp.interfaces.IFileLocation;
import me.mylogo.javaftp.interfaces.ISimpleFile;
import me.mylogo.javaftp.util.Util;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public abstract class SimpleFile implements ISimpleFile {

    private IFileLocation fileLocation;
    private String name;
    private String path;
    private boolean isDirectory;

    public SimpleFile(IFileLocation fileLocation, String name, String path, boolean isDirectory) {
        this.fileLocation = fileLocation;
        this.name = name;
        this.path = path;
        this.isDirectory = isDirectory;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void pasteMeInto(OutputStream output) {
        try {
            System.out.println("Starting");
            Util.copyStream(getFileInputStream(), output);
            System.out.println("Ending");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillMeFrom(InputStream input) {
        try {
            Util.copyStream(input, getFileOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IFileLocation getFileLocation() {
        return fileLocation;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

}
