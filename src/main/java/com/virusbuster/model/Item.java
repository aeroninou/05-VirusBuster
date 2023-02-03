package com.virusbuster.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Objects;


class Item {

    private final String name;
    private final String description;

    public Item (String name, String description){
        this.name = name;
        this.description = description;
    }


    public static Map<String, String> loadItems(String filePath) {

        try (Reader reader = new InputStreamReader(Objects.requireNonNull(Item.class.getClassLoader().getResourceAsStream(filePath)))) {
            Type itemListType = new TypeToken<List<Item>>(){}.getType();
            Gson gson = new Gson();
            List<Item> itemList = gson.fromJson(reader, itemListType);

            return itemList.stream().collect(Collectors.toMap(Item::getName, Item::getDescription));

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public String getName() {
        return name.toLowerCase();
    }

    public String getDescription() {
        return description.toLowerCase();
    }
}