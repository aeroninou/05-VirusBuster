package com.virusbuster.model;

import java.util.ArrayList;
import java.util.List;

class GameItems {

    private ZippoLighter zippolighter;
    private BubbleGum bubblegum;
    private JackDaniels jackdaniels;
    private IceContainer icecontainer;
    private RainCoat raincoat;
    private GoldRolexWatch goldrolexwatch;

    public List<ItemInformation> loadAllItems(){
        List<GameItems.ItemInformation> itemList = new ArrayList<>();
        itemList.add(zippolighter);
        itemList.add(bubblegum);
        itemList.add(jackdaniels);
        itemList.add(icecontainer);
        itemList.add(raincoat);
        itemList.add(goldrolexwatch);
        return itemList;
    }

    public ItemInformation getItemInformation(String item){
        if(item == null){
            return null;
        }
        switch(item){
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
            default:
                return null;
        }
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

    public static class ItemInformation {

        private String name;
        private String description;

        public ItemInformation(){}

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


    private static class ZippoLighter extends ItemInformation {
        public ZippoLighter(){}
    }
    private static class BubbleGum extends ItemInformation {
        public BubbleGum(){}
    }
    private static class JackDaniels extends ItemInformation {
        public JackDaniels(){}
    }
    private static class IceContainer extends ItemInformation {
        public IceContainer(){}
    }
    private static class RainCoat extends ItemInformation {
        public RainCoat(){}
    }
    private static class GoldRolexWatch extends ItemInformation {
        public GoldRolexWatch(){}
    }


}