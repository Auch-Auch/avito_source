package com.avito.android.search.map.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpListModule_ProvideSerpListAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<DestroyableViewHolderBuilder> b;
    public final Provider<BuildInfo> c;
    public final Provider<Analytics> d;

    public SerpListModule_ProvideSerpListAdapterFactory(Provider<AdapterPresenter> provider, Provider<DestroyableViewHolderBuilder> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SerpListModule_ProvideSerpListAdapterFactory create(Provider<AdapterPresenter> provider, Provider<DestroyableViewHolderBuilder> provider2, Provider<BuildInfo> provider3, Provider<Analytics> provider4) {
        return new SerpListModule_ProvideSerpListAdapterFactory(provider, provider2, provider3, provider4);
    }

    public static SimpleRecyclerAdapter provideSerpListAdapter(AdapterPresenter adapterPresenter, DestroyableViewHolderBuilder destroyableViewHolderBuilder, BuildInfo buildInfo, Analytics analytics) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(SerpListModule.provideSerpListAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideSerpListAdapter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
