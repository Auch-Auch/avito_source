package com.avito.android.search.map.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PinAdvertsListModule_ProvidePinAdvertsAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public PinAdvertsListModule_ProvidePinAdvertsAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static PinAdvertsListModule_ProvidePinAdvertsAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new PinAdvertsListModule_ProvidePinAdvertsAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter providePinAdvertsAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(PinAdvertsListModule.INSTANCE.providePinAdvertsAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return providePinAdvertsAdapterPresenter(this.a.get());
    }
}
