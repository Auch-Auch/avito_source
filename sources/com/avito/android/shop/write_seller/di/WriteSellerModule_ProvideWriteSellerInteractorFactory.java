package com.avito.android.shop.write_seller.di;

import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.shop.write_seller.WriteSellerInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WriteSellerModule_ProvideWriteSellerInteractorFactory implements Factory<WriteSellerInteractor> {
    public final WriteSellerModule a;
    public final Provider<ShopsApi> b;

    public WriteSellerModule_ProvideWriteSellerInteractorFactory(WriteSellerModule writeSellerModule, Provider<ShopsApi> provider) {
        this.a = writeSellerModule;
        this.b = provider;
    }

    public static WriteSellerModule_ProvideWriteSellerInteractorFactory create(WriteSellerModule writeSellerModule, Provider<ShopsApi> provider) {
        return new WriteSellerModule_ProvideWriteSellerInteractorFactory(writeSellerModule, provider);
    }

    public static WriteSellerInteractor provideWriteSellerInteractor(WriteSellerModule writeSellerModule, ShopsApi shopsApi) {
        return (WriteSellerInteractor) Preconditions.checkNotNullFromProvides(writeSellerModule.provideWriteSellerInteractor(shopsApi));
    }

    @Override // javax.inject.Provider
    public WriteSellerInteractor get() {
        return provideWriteSellerInteractor(this.a, this.b.get());
    }
}
