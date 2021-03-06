package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io;

import java.io.File;

public class SimpleDirectoryFilter
        implements java.io.FileFilter {
    /**
     * ********************************************************************
     */
    public SimpleDirectoryFilter() {
    }

    /**
     * *******************************************************************
     */

    public boolean accept(File pathname) {
        String name = pathname.getName().toLowerCase();
        boolean accept;
        accept = !(name.equals(".") || name.equals("..")) && pathname.isDirectory();
        return accept;
    }
    /************************************************************************/
    /************************************************************************/
}