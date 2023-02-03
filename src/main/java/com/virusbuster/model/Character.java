package com.virusbuster.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Character {
    private String name;
    private List<String> quotes;
    private String location;

    public Character(String name, List<String> quotes, String location) {
        this.name = name;
        this.quotes = quotes;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", quotes=" + quotes +
                ", location='" + location + '\'' +
                '}';
    }
    public static Map<String, Character> loadCharacter(String jsonPath) {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(Character.class.getClassLoader().
                getResourceAsStream(jsonPath)))) {
            Type characterType = new TypeToken<List<Character>>() {}.getType();
            List<Character> characters = gson.fromJson(reader, characterType);
            return characters.stream().collect(Collectors.
                    toMap(character -> character.getLocation(), character -> character ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
