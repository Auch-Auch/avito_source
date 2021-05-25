package com.avito.android.user_advert.di;

import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.user_advert.di.MyDraftDetailsComponent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MyDraftDetailsComponent_DraftDetailsModule_ProvideSellerShortTermRentObservableFactory implements Factory<PublishRelay<AdvertSellerShortTermRent>> {

    public static final class a {
        public static final MyDraftDetailsComponent_DraftDetailsModule_ProvideSellerShortTermRentObservableFactory a = new MyDraftDetailsComponent_DraftDetailsModule_ProvideSellerShortTermRentObservableFactory();
    }

    public static MyDraftDetailsComponent_DraftDetailsModule_ProvideSellerShortTermRentObservableFactory create() {
        return a.a;
    }

    public static PublishRelay<AdvertSellerShortTermRent> provideSellerShortTermRentObservable() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(MyDraftDetailsComponent.DraftDetailsModule.INSTANCE.provideSellerShortTermRentObservable());
    }

    @Override // javax.inject.Provider
    public PublishRelay<AdvertSellerShortTermRent> get() {
        return provideSellerShortTermRentObservable();
    }
}
