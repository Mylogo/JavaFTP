package me.mylogo.javaftp.interfaces;

import java.util.List;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public interface IFileLocation {

    String getCurrentDirectory();
    void setCurrentDirectory(String path);
    String getRootDirectory();
    void setRootDirectory(String path);
    List<ISimpleFile> getFilesOfDirectory(String path);
    default List<ISimpleFile> getFilesOfCurrentDirectory() {
        return getFilesOfDirectory(getRootDirectory() + getCurrentDirectory());
    }

}
