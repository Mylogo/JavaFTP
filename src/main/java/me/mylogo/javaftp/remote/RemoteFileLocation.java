package me.mylogo.javaftp.remote;

import me.mylogo.javaftp.util.FTPClientWrapper;
import me.mylogo.javaftp.util.FileLocation;
import me.mylogo.javaftp.interfaces.ISimpleFile;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class RemoteFileLocation extends FileLocation {

    public FTPClientWrapper clientWrapper;

    public RemoteFileLocation(FTPClientWrapper client, String rootDirectory, String currentDirectory) {
        super(rootDirectory, currentDirectory);
        this.clientWrapper = client;
    }

    @Override
    public List<ISimpleFile> getFilesOfDirectory(String path) {
        try {
            FTPFile[] files = clientWrapper.getFTPClient().listFiles(getRootDirectory() + path);
            List<ISimpleFile> result = new ArrayList<>(files.length);
            for (FTPFile file : files) {
                String name = file.getName();
                RemoteSimpleFile remoteFile = new RemoteSimpleFile(this, name, path, file.isDirectory());
                result.add(remoteFile);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EMPTY;
    }

    @Override
    public List<ISimpleFile> getFilesOfCurrentDirectory() {
        return null;
    }

    public FTPClientWrapper getClient() {
        return clientWrapper;
    }

}
