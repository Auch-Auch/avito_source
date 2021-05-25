package com.avito.android.search.map.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpListModule_ProvideSerpListAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public SerpListModule_ProvideSerpListAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static SerpListModule_ProvideSerpListAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new SerpListModule_ProvideSerpListAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideSerpListAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(SerpListModule.provideSerpListAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideSerpListAdapterPresenter(this.a.get());
    }
}
