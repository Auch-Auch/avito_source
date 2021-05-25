package com.avito.android.advert_core.di.module;

import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory implements Factory<PublishRelay<AdvertSellerShortTermRent>> {

    public static final class a {
        public static final AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory a = new AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory();
    }

    public static AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory create() {
        return a.a;
    }

    public static PublishRelay<AdvertSellerShortTermRent> provideSellerShortTermRentObservable() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(AdvertStrBlockModule.provideSellerShortTermRentObservable());
    }

    @Override // javax.inject.Provider
    public PublishRelay<AdvertSellerShortTermRent> get() {
        return provideSellerShortTermRentObservable();
    }
}
