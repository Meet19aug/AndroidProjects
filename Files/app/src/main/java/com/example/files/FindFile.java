package com.example.files;
import java.io.*;

public class FindFile implements FilenameFilter{
    String initials;

    // constructor to initialize object
    public FindFile(String initials)
    {
        this.initials = initials;
    }

    // overriding the accept method of FilenameFilter
    // interface
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}
