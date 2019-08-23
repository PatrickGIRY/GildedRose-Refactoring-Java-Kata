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

}
