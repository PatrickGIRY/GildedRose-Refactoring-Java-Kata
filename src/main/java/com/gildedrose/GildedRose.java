package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isStandardItem(item)) {
                handleStandardItem(item);
                continue;
            }
            if (isNotMaxQuality(item)) {
                increaseQuality(item);
                descreaseSellIn(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        increaseQualityIfPossible(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityIfPossible(item);
                    }
                }
            }
        }
    }

    private void handleStandardItem(Item item) {
        descreaseQualityIfPossible(item);
        descreaseSellIn(item);
        if (item.sellIn < 0) {
            increaseQualityIfPossible(item);
        }
    }

    private void descreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isStandardItem(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void increaseQualityIfPossible(Item item) {
        if (isNotMaxQuality(item)) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private boolean isNotMaxQuality(Item item) {
        return item.quality < 50;
    }

    private void descreaseQualityIfPossible(Item item) {
        if (isPositiveQuality(item)) {
            item.quality--;
        }
    }

    private boolean isPositiveQuality(Item item) {
        return item.quality > 0;
    }
}