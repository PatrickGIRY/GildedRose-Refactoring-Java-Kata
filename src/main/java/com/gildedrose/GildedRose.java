package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isStandardItem(items[i])) {
                handleStandardItem(items[i]);
                continue;
            }
            if (isNotMaxQuality(items[i])) {
                increaseQuality(items[i]);

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        increaseQualityIfPossible(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQualityIfPossible(items[i]);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                descreaseSellIn(items[i]);
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