package com.avito.android.advert_stats.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlotItemPresenterImpl_Factory implements Factory<PlotItemPresenterImpl> {
    public final Provider<PlotDimensionsProvider> a;

    public PlotItemPresenterImpl_Factory(Provider<PlotDimensionsProvider> provider) {
        this.a = provider;
    }

    public static PlotItemPresenterImpl_Factory create(Provider<PlotDimensionsProvider> provider) {
        return new PlotItemPresenterImpl_Factory(provider);
    }

    public static PlotItemPresenterImpl newInstance(PlotDimensionsProvider plotDimensionsProvider) {
        return new PlotItemPresenterImpl(plotDimensionsProvider);
    }

    @Override // javax.inject.Provider
    public PlotItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
