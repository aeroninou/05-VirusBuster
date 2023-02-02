package com.virusbuster.model;

import java.util.List;

//Class for NPC & User
public class Character {
    private User user;
    private NPC1 npc1;
    private NPC2 npc2;
    private NPC3 npc3;
    private NPC4 npc4;
    private NPC5 npc5;

    //Getter and setters for Characters
    public User getPlayer() {
        return user;
    }

    public void setPlayer(User player) {
        this.user = player;
    }

    public NPC1 getNpc1() {
        return npc1;
    }

    public void setNpc1(NPC1 npc1) {
        this.npc1 = npc1;
    }

    public NPC2 getNpc2() {
        return npc2;
    }

    public void setNpc2(NPC2 npc2) {
        this.npc2 = npc2;
    }

    public NPC3 getNpc3() {
        return npc3;
    }

    public void setNpc3(NPC3 npc3) {
        this.npc3 = npc3;
    }

    public NPC4 getNpc4() {
        return npc4;
    }

    public void setNpc4(NPC4 npc4) {
        this.npc4 = npc4;
    }

    public NPC5 getNpc5() {
        return npc5;
    }

    public void setNpc5(NPC5 npc5) {
        this.npc5 = npc5;
    }



    //class to get the key and values from Json
    public static class CharacterLayout {
        private String name;
        private List<String> quotes;
        private String location;

        public CharacterLayout() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<String> getQuote() {
            return quotes;
        }

        public void setQuotes(List<String> quotes) {
            this.quotes = quotes;
        }

    }

    //extends class to utilize the getter and setter
    public static class User extends CharacterLayout {
        public User() {
        }
    }

    public static class NPC1 extends CharacterLayout {
        public NPC1() {
        }
    }

    public static class NPC2 extends CharacterLayout {
        public NPC2() {
        }
    }

    public static class NPC3 extends CharacterLayout {
        public NPC3() {
        }
    }

    public static class NPC4 extends CharacterLayout {
        public NPC4() {
        }
    }

    public static class NPC5 extends CharacterLayout {
        public NPC5() {
        }
    }
}

