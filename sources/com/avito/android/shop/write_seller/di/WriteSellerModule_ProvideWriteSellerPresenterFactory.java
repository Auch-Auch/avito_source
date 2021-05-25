package com.avito.android.shop.write_seller.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.shop.write_seller.WriteSellerInteractor;
import com.avito.android.shop.write_seller.WriteSellerPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WriteSellerModule_ProvideWriteSellerPresenterFactory implements Factory<WriteSellerPresenter> {
    public final WriteSellerModule a;
    public final Provider<WriteSellerInteractor> b;
    public final Provider<AccountStorageInteractor> c;
    public final Provider<SchedulersFactory3> d;

    public WriteSellerModule_ProvideWriteSellerPresenterFactory(WriteSellerModule writeSellerModule, Provider<WriteSellerInteractor> provider, Provider<AccountStorageInteractor> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = writeSellerModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static WriteSellerModule_ProvideWriteSellerPresenterFactory create(WriteSellerModule writeSellerModule, Provider<WriteSellerInteractor> provider, Provider<AccountStorageInteractor> provider2, Provider<SchedulersFactory3> provider3) {
        return new WriteSellerModule_ProvideWriteSellerPresenterFactory(writeSellerModule, provider, provider2, provider3);
    }

    public static WriteSellerPresenter provideWriteSellerPresenter(WriteSellerModule writeSellerModule, WriteSellerInteractor writeSellerInteractor, AccountStorageInteractor accountStorageInteractor, SchedulersFactory3 schedulersFactory3) {
        return (WriteSellerPresenter) Preconditions.checkNotNullFromProvides(writeSellerModule.provideWriteSellerPresenter(writeSellerInteractor, accountStorageInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public WriteSellerPresenter get() {
        return provideWriteSellerPresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
