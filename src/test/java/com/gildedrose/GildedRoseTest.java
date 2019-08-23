package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_decrease_selin_and_quality_by_one_day_given_standard_item() {
        Item[] items = new Item[] { new Item("milk", 4, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("milk", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void should_decrease_quality_by_two_when_the_sellin_passed() {
        Item[] items = new Item[] { new Item("milk", -1, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("milk", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void should_not_make_quality_negative() {
        Item[] items = new Item[] { new Item("milk", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("milk", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }


    @Test
    public void should_increase_quality_when_product_is_aged_brie() {
        Item[] items = new Item[] { new Item("Aged Brie", 42, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(41, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void should_keep_quality_below_fifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 42, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(41, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void should_not_change_quality_and_sellin_for_sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 24, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(24, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void should_increase_quality_when_sellin_above_or_equal_10_for_backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 24, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(23, app.items[0].sellIn);
        assertEquals(43, app.items[0].quality);
    }

    @Test
    public void should_increase_by_2_quality_when_sellin_between_5_and_10_for_backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(44, app.items[0].quality);
    }

    @Test
    public void should_increase_by_3_quality_when_sellin_between_0_and_5_for_backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(45, app.items[0].quality);
    }

}
