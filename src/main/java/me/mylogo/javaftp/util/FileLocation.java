package me.mylogo.javaftp.util;

import com.sun.javafx.UnmodifiableArrayList;
import me.mylogo.javaftp.interfaces.IFileLocation;
import me.mylogo.javaftp.interfaces.ISimpleFile;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public abstract class FileLocation implements IFileLocation {

    protected static UnmodifiableArrayList<ISimpleFile> EMPTY = new UnmodifiableArrayList<>(null, 0);
    private String currentDirectory;
    private String rootDirectory;

    public FileLocation(String rootDirectory, String currentDirectory) {
        this.rootDirectory = rootDirectory;
        this.currentDirectory = currentDirectory;
    }

    @Override
    public String getCurrentDirectory() {
        return currentDirectory;
    }

    @Override
    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public String getRootDirectory() {
        return rootDirectory;
    }

    @Override
    public void setRootDirectory(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }
}
