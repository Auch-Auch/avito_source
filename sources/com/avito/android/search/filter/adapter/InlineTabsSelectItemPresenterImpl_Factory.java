package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineTabsSelectItemPresenterImpl_Factory implements Factory<InlineTabsSelectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public InlineTabsSelectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static InlineTabsSelectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new InlineTabsSelectItemPresenterImpl_Factory(provider);
    }

    public static InlineTabsSelectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new InlineTabsSelectItemPresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public InlineTabsSelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
