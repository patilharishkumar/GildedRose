package com.circleci.harish.gildedrose;

import com.circleci.harish.gildedrose.factories.DefaultQualityStrategyFactory;
import com.circleci.harish.gildedrose.factories.QualityStrategyFactory;
import com.circleci.harish.gildedrose.strategies.QualityStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class GildedRose implements GildedRoseInterface {
    private final List<Item> items;
    private final QualityStrategyFactory factory;

    GildedRose(Item[] items, QualityStrategyFactory factory) {
        this.items = Arrays.asList(items);
        this.factory = factory;
    }

    GildedRose(Item[] items) {
         this(items, new DefaultQualityStrategyFactory());
    }

    @Override
    /**
     * Update quality all items in system for one day
     *
     * for more info, see GildedRoseRequirements.txt
     */
    public void updateQuality() {
        items.stream()
                .filter(item -> !Objects.equals(item.name, Constants.SULFURAS))
                .forEach(item -> updateItemQuality(item, factory)
        );
    }

    private static void updateItemQuality(Item item, QualityStrategyFactory factory) {
        item.sellIn--;
        QualityStrategy strategy = factory.getQualityStrategy(item.name);
        item.quality = strategy.getQualityInCorrectRange(
                strategy.getQuality(item.quality, item.sellIn)
        );
    }
}
