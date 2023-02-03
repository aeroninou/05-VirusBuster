package com.virusbuster.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class GameItem implements Serializable{

    private ZippoLighter zippolighter;
    private BubbleGum bubblegum;
    private JackDaniels jackdaniels;
    private IceContainer icecontainer;
    private RainCoat raincoat;
    private GoldRolexWatch goldrolexwatch;
    private CamuCamu camucamu;
    private CamelMilk camelmilk;
    private Sumalak sumalak;
    private GlacierMagicalPlant glaciermagicalplant;


    public List<ItemInformation> loadAllItems() {
        List<GameItem.ItemInformation> itemList = new ArrayList<>();
        itemList.add(zippolighter);
        itemList.add(bubblegum);
        itemList.add(jackdaniels);
        itemList.add(icecontainer);
        itemList.add(raincoat);
        itemList.add(goldrolexwatch);
        itemList.add(camucamu);
        itemList.add(camelmilk);
        itemList.add(sumalak);
        itemList.add(glaciermagicalplant);

        return itemList;
    }

    public ItemInformation getItemInformation(String item) {
        if (item == null) {
            return null;
        }
        switch (item) {
            case "zippo lighter":
                return zippolighter;
            case "bubble gum":
                return bubblegum;
            case "jack daniels":
                return jackdaniels;
            case "ice container":
                return icecontainer;
            case "raincoat":
                return raincoat;
            case "gold rolex watch":
                return goldrolexwatch;
            case "camu camu":
                return camucamu;
            case "sumalak":
                return sumalak;
            case "camel milk":
                return camelmilk;
            case "glacier magical plant":
                return glaciermagicalplant;
            default:
                return null;
        }
    }

    public CamuCamu getCamucamu() {
        return camucamu;
    }

    public void setCamucamu(CamuCamu camucamu) {
        this.camucamu = camucamu;
    }

    public CamelMilk getCamelmilk() {
        return camelmilk;
    }

    public void setCamelmilk(CamelMilk camelmilk) {
        this.camelmilk = camelmilk;
    }

    public Sumalak getSumalak() {
        return sumalak;
    }

    public void setSumalak(Sumalak sumalak) {
        this.sumalak = sumalak;
    }

    public GlacierMagicalPlant getGlaciermagicalplant() {
        return glaciermagicalplant;
    }

    public void setGlaciermagicalplant(GlacierMagicalPlant glaciermagicalplant) {
        this.glaciermagicalplant = glaciermagicalplant;
    }

    public ZippoLighter getZippolighter() {
        return zippolighter;
    }

    public void setZippolighter(ZippoLighter zippolighter) {
        this.zippolighter = zippolighter;
    }

    public BubbleGum getBubblegum() {
        return bubblegum;
    }

    public void setBubblegum(BubbleGum bubblegum) {
        this.bubblegum = bubblegum;
    }

    public JackDaniels getJackdaniels() {
        return jackdaniels;
    }

    public void setJackdaniels(JackDaniels jackdaniels) {
        this.jackdaniels = jackdaniels;
    }

    public IceContainer getIcecontainer() {
        return icecontainer;
    }

    public void setIcecontainer(IceContainer icecontainer) {
        this.icecontainer = icecontainer;
    }

    public RainCoat getRaincoat() {
        return raincoat;
    }

    public void setRaincoat(RainCoat raincoat) {
        this.raincoat = raincoat;
    }

    public GoldRolexWatch getGoldrolexwatch() {
        return goldrolexwatch;
    }

    public void setGoldrolexwatch(GoldRolexWatch goldrolexwatch) {
        this.goldrolexwatch = goldrolexwatch;
    }

    public static class ItemInformation implements Serializable  {

        private String name;
        private String description;

        public ItemInformation() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


    private static class ZippoLighter extends ItemInformation{
        public ZippoLighter() {
        }
    }

    private static class BubbleGum extends ItemInformation {
        public BubbleGum() {
        }
    }

    private static class JackDaniels extends ItemInformation {
        public JackDaniels() {
        }
    }

    private static class IceContainer extends ItemInformation {
        public IceContainer() {
        }
    }

    private static class RainCoat extends ItemInformation {
        public RainCoat() {
        }
    }

    private static class GoldRolexWatch extends ItemInformation {
        public GoldRolexWatch() {
        }
    }

    private static class CamuCamu extends ItemInformation {
        public CamuCamu() {}


    }

    private static class CamelMilk extends ItemInformation {
        public CamelMilk() {
        }

    }
        private static class Sumalak extends ItemInformation {
            public Sumalak() {
            }
        }

        private static class GlacierMagicalPlant extends ItemInformation {
            public GlacierMagicalPlant() {
            }

        }
    }