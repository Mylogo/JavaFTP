package me.mylogo.javaftp.remote;

import me.mylogo.javaftp.util.SimpleFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class RemoteSimpleFile extends SimpleFile {

    private RemoteFileLocation fileLocation;

    public RemoteSimpleFile(RemoteFileLocation fileLocation, String name, String path, boolean isDirectory) {
        super(fileLocation, name, path, isDirectory);
        this.fileLocation = fileLocation;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public OutputStream getFileOutputStream() throws Exception {
        return fileLocation.getClient().getFTPClient().storeFileStream(getPath() + getName());
    }

    @Override
    public InputStream getFileInputStream() throws Exception {
        return fileLocation.getClient().getFTPClient().retrieveFileStream(getPath() + getName());
    }

    @Override
    public void pasteMeInto(OutputStream output) {
        super.pasteMeInto(output);
        try {
            fileLocation.getClient().getFTPClient().completePendingCommand();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
