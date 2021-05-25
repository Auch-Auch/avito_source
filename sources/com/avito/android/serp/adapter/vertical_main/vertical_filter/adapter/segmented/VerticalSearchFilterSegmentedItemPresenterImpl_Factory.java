package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterSegmentedItemPresenterImpl_Factory implements Factory<VerticalSearchFilterSegmentedItemPresenterImpl> {
    public final Provider<VerticalFilterPresenter> a;

    public VerticalSearchFilterSegmentedItemPresenterImpl_Factory(Provider<VerticalFilterPresenter> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterSegmentedItemPresenterImpl_Factory create(Provider<VerticalFilterPresenter> provider) {
        return new VerticalSearchFilterSegmentedItemPresenterImpl_Factory(provider);
    }

    public static VerticalSearchFilterSegmentedItemPresenterImpl newInstance(VerticalFilterPresenter verticalFilterPresenter) {
        return new VerticalSearchFilterSegmentedItemPresenterImpl(verticalFilterPresenter);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterSegmentedItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
