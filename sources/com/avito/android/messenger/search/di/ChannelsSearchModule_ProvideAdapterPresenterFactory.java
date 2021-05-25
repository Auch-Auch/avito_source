package com.avito.android.messenger.search.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsSearchModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public ChannelsSearchModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static ChannelsSearchModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new ChannelsSearchModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
