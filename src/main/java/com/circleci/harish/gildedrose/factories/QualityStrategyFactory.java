package com.circleci.harish.gildedrose.factories;

import com.circleci.harish.gildedrose.strategies.QualityStrategy;

/**
 * pattern Factory
 */
public interface QualityStrategyFactory {
    QualityStrategy getQualityStrategy(String name);
}
