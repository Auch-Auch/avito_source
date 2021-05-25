package com.avito.android.booking.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BookingInfoModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public BookingInfoModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static BookingInfoModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new BookingInfoModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(BookingInfoModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
