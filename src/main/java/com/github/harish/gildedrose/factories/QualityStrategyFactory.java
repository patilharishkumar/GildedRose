package com.github.harish.gildedrose.factories;

import com.github.harish.gildedrose.strategies.QualityStrategy;

/**
 * pattern Factory
 */
public interface QualityStrategyFactory {
    QualityStrategy getQualityStrategy(String name);
}
