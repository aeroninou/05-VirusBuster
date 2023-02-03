package com.virusbuster.model;

public enum Command {
    GO("go"),
    GET("get"),
    TALK("talk"),
    LOOK("look"),
    DROP("drop"),
    TRADE("trade"),
    BAG("bag"),
    ENTER("enter"),
    QUIT("quit"),
    HELP("help"),
    GRAB("grab"),
    PICKUP("pickup"),
    TAKE("take"),
    SAVE("save"),
    LOAD("load");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}