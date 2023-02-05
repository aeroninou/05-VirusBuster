package com.virusbuster.model;

public enum Command {
    GO("go"),
    GET("get"),
    TALK("talk"),
    LOOK("look"),
    DROP("drop"),
    TRADE("trade"),
    QUIT("quit"),
    HELP("help"),
    GRAB("grab"),
    PICKUP("pickup"),
    TAKE("take"),
    //TODO:verify with team if we need this?
//    SAVE("save"),
//    LOAD("load"),
    MAP("map");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}