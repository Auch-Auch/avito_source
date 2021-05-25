package com.avito.android.search.map.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PinAdvertsListModule_ProvidePinAdvertsAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<BuildInfo> c;
    public final Provider<Analytics> d;

    public PinAdvertsListModule_ProvidePinAdvertsAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PinAdvertsListModule_ProvidePinAdvertsAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        return new PinAdvertsListModule_ProvidePinAdvertsAdapterFactory(provider, provider2, provider3, provider4);
    }

    public static SimpleRecyclerAdapter providePinAdvertsAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder, BuildInfo buildInfo, Analytics analytics) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(PinAdvertsListModule.providePinAdvertsAdapter(adapterPresenter, itemBinder, buildInfo, analytics));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return providePinAdvertsAdapter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
