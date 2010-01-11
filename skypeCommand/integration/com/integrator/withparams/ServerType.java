package com.integrator.withparams;

public enum ServerType {

    JBOSS("jboss.home", "run.bat"),
    TOMCAT("tomcat.home", "Tomcat6.0");

    private String homeDir;
    private String execFile;

    private ServerType(String homeDir, String execFile) {
        this.homeDir = homeDir;
        this.execFile = execFile;
    }

    public String getHomeDir() {
        return homeDir;
    }

    public String getExecFile() {
        return execFile;
    }
}
