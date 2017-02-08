package me.mylogo.javaftp.interfaces;

import java.util.List;

/**
 * Created by dennisheckmann on 29.01.17.
 */
public interface IProject {

    String getRoot();
    IFileLocation getOrigin();
    IFileLocation getDestination();

}
