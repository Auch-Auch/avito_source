package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalFilterItemBlueprint_Factory implements Factory<VerticalFilterItemBlueprint> {
    public final Provider<VerticalFilterItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SafeRecyclerAdapter> c;
    public final Provider<VerticalSearchFilterResourceProvider> d;

    public VerticalFilterItemBlueprint_Factory(Provider<VerticalFilterItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<SafeRecyclerAdapter> provider3, Provider<VerticalSearchFilterResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VerticalFilterItemBlueprint_Factory create(Provider<VerticalFilterItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<SafeRecyclerAdapter> provider3, Provider<VerticalSearchFilterResourceProvider> provider4) {
        return new VerticalFilterItemBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static VerticalFilterItemBlueprint newInstance(VerticalFilterItemPresenter verticalFilterItemPresenter, AdapterPresenter adapterPresenter, SafeRecyclerAdapter safeRecyclerAdapter, VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider) {
        return new VerticalFilterItemBlueprint(verticalFilterItemPresenter, adapterPresenter, safeRecyclerAdapter, verticalSearchFilterResourceProvider);
    }

    @Override // javax.inject.Provider
    public VerticalFilterItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
