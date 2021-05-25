package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisplayTypeSelectPresenter_Factory implements Factory<DisplayTypeSelectPresenter> {
    public final Provider<FiltersChangeProvider> a;

    public DisplayTypeSelectPresenter_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static DisplayTypeSelectPresenter_Factory create(Provider<FiltersChangeProvider> provider) {
        return new DisplayTypeSelectPresenter_Factory(provider);
    }

    public static DisplayTypeSelectPresenter newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new DisplayTypeSelectPresenter(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public DisplayTypeSelectPresenter get() {
        return newInstance(this.a.get());
    }
}
