package com.avito.android.bundles.vas_union.item.performance.tabs;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PerformanceTabsItemBlueprint_Factory implements Factory<PerformanceTabsItemBlueprint> {
    public final Provider<PerformanceTabsItemPresenter> a;

    public PerformanceTabsItemBlueprint_Factory(Provider<PerformanceTabsItemPresenter> provider) {
        this.a = provider;
    }

    public static PerformanceTabsItemBlueprint_Factory create(Provider<PerformanceTabsItemPresenter> provider) {
        return new PerformanceTabsItemBlueprint_Factory(provider);
    }

    public static PerformanceTabsItemBlueprint newInstance(PerformanceTabsItemPresenter performanceTabsItemPresenter) {
        return new PerformanceTabsItemBlueprint(performanceTabsItemPresenter);
    }

    @Override // javax.inject.Provider
    public PerformanceTabsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
