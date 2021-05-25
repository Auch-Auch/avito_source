package com.avito.android.delivery.map.common.marker.calculator;

import dagger.internal.Factory;
public final class LowRarityClusterRadiusCalculator_Factory implements Factory<LowRarityClusterRadiusCalculator> {

    public static final class a {
        public static final LowRarityClusterRadiusCalculator_Factory a = new LowRarityClusterRadiusCalculator_Factory();
    }

    public static LowRarityClusterRadiusCalculator_Factory create() {
        return a.a;
    }

    public static LowRarityClusterRadiusCalculator newInstance() {
        return new LowRarityClusterRadiusCalculator();
    }

    @Override // javax.inject.Provider
    public LowRarityClusterRadiusCalculator get() {
        return newInstance();
    }
}
