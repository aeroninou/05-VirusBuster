package com.virusbuster.model;

public enum Commands {
    GO("go"),
    GET("get"),
    TALK("talk"),
    LOOK("look"),
    TRADE("trade"),
    BAG("bag"),
    ENTER("enter"),
    QUIT("quit"),
    HELP("help");

    private final String value;

    Commands (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}