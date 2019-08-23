package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item)) {
                continue;
            }
            if (isAgedBrie(item)) {
                handleAgedBrie(item);
                continue;
            }
            if (isBackstage(item)) {
                handleBackstage(item);
                continue;
            }
            handleStandardItem(item);
        }
    }

    private void handleBackstage(Item item) {
        increaseQuality(item);
        descreaseSellIn(item);
        if (item.sellIn < 11) {
            increaseQualityIfPossible(item);
        }

        if (item.sellIn < 6) {
            increaseQualityIfPossible(item);
        }
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void handleAgedBrie(Item item) {
        descreaseSellIn(item);
        increaseQuality(item);
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
        return !isAgedBrie(item)
                && !isBackstage(item)
                && !isSulfuras(item);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
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