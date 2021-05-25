package com.avito.android.user_advert.di;

import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.user_advert.di.MyDraftDetailsComponent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertDeliveryBlockDataObservableFactory implements Factory<PublishRelay<AdvertDeliveryC2C>> {

    public static final class a {
        public static final MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertDeliveryBlockDataObservableFactory a = new MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertDeliveryBlockDataObservableFactory();
    }

    public static MyDraftDetailsComponent_DraftDetailsModule_ProvideAdvertDeliveryBlockDataObservableFactory create() {
        return a.a;
    }

    public static PublishRelay<AdvertDeliveryC2C> provideAdvertDeliveryBlockDataObservable() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(MyDraftDetailsComponent.DraftDetailsModule.INSTANCE.provideAdvertDeliveryBlockDataObservable());
    }

    @Override // javax.inject.Provider
    public PublishRelay<AdvertDeliveryC2C> get() {
        return provideAdvertDeliveryBlockDataObservable();
    }
}
