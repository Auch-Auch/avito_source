package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterSegmentedItemBlueprintImpl_Factory implements Factory<VerticalSearchFilterSegmentedItemBlueprintImpl> {
    public final Provider<VerticalSearchFilterSegmentedItemPresenter> a;

    public VerticalSearchFilterSegmentedItemBlueprintImpl_Factory(Provider<VerticalSearchFilterSegmentedItemPresenter> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterSegmentedItemBlueprintImpl_Factory create(Provider<VerticalSearchFilterSegmentedItemPresenter> provider) {
        return new VerticalSearchFilterSegmentedItemBlueprintImpl_Factory(provider);
    }

    public static VerticalSearchFilterSegmentedItemBlueprintImpl newInstance(VerticalSearchFilterSegmentedItemPresenter verticalSearchFilterSegmentedItemPresenter) {
        return new VerticalSearchFilterSegmentedItemBlueprintImpl(verticalSearchFilterSegmentedItemPresenter);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterSegmentedItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
