package com.virusbuster.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class Item {

    private String name;
    private String description;

    //ctor
    public Item (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void displayItemDescription(String item) {
        JsonParser parser = new JsonParser();
        String filePath = "src/main/resources/data/location.json";
        Object items = null;
        items = parser.parse(new InputStreamReader(Item.class.getClassLoader().getResourceAsStream(filePath)));
        JsonObject jsonObject = (JsonObject) items;
        //auto lowercase user input
        String parsingItem = item.toLowerCase();
        Map roomList = (Map) jsonObject.get(parsingItem);

        Iterator<Map.Entry> itr1 = roomList.entrySet().iterator();

        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();

            if (pair.getKey().equals("description")) {
                System.out.println(pair.getValue());
                String description = pair.getValue().toString();

                System.out.println(description);
            }
        }
    }
}