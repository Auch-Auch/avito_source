package com.avito.android.advert.item.guide.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDetailsGuideModule_ProvideSectionsAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public AdvertDetailsGuideModule_ProvideSectionsAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsGuideModule_ProvideSectionsAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new AdvertDetailsGuideModule_ProvideSectionsAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideSectionsAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(AdvertDetailsGuideModule.INSTANCE.provideSectionsAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideSectionsAdapter(this.a.get(), this.b.get());
    }
}
