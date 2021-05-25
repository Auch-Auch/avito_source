package com.avito.android.bundles.vas_union.item.performance.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PerformanceDescriptionBlueprint_Factory implements Factory<PerformanceDescriptionBlueprint> {
    public final Provider<PerformanceDescriptionPresenter> a;

    public PerformanceDescriptionBlueprint_Factory(Provider<PerformanceDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static PerformanceDescriptionBlueprint_Factory create(Provider<PerformanceDescriptionPresenter> provider) {
        return new PerformanceDescriptionBlueprint_Factory(provider);
    }

    public static PerformanceDescriptionBlueprint newInstance(PerformanceDescriptionPresenter performanceDescriptionPresenter) {
        return new PerformanceDescriptionBlueprint(performanceDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public PerformanceDescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
