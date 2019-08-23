package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    if (isPositiveQuality(items[i])) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
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
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            descreaseQualityIfPossible(items[i]);
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    increaseQualityIfPossible(items[i]);
                }
            }
        }
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