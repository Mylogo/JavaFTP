package me.mylogo.javaftp.local;

import me.mylogo.javaftp.util.FileLocation;
import me.mylogo.javaftp.interfaces.ISimpleFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class LocalFileLocation extends FileLocation {

    public LocalFileLocation(String rootDirectory, String currentDirectory) {
        super(rootDirectory, currentDirectory);
    }

    @Override
    public List<ISimpleFile> getFilesOfDirectory(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null)
            return EMPTY;
        List<ISimpleFile> list = new ArrayList<>(files.length);
        for (File f : files) {
            list.add(new LocalSimpleFile(this, f));
        }
        return list;
    }

}
