package me.mylogo.javaftp.local;

import me.mylogo.javaftp.util.SimpleFile;

import java.io.*;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class LocalSimpleFile extends SimpleFile {

    private File file;

    public LocalSimpleFile(LocalFileLocation fileLocation, File file) {
        super(fileLocation, file.getName(), file.getParentFile().getAbsolutePath(), file.isDirectory());
        System.out.println("ABSOLUTE:" + file.getAbsolutePath()); //Temporary debug messages
        System.out.println("PARENT:" + file.getParentFile().getAbsolutePath());
        System.out.println("NAME:" + getName());
        this.file = file;
    }

    @Override
    public long getSize() {
        return file.length();
    }

    @Override
    public OutputStream getFileOutputStream() throws FileNotFoundException {
        File file = getFile();
        try {
            System.out.println("Creating:" + file.getAbsolutePath() + "|" + file.getName());
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileOutputStream(getFile());
    }

    @Override
    public InputStream getFileInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file);
    }

    public File getFile() {
        return this.file;
    }

    @Override
    public String toString() {
        return getName();
    }
}
