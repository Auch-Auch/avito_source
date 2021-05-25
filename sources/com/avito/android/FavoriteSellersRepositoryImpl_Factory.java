package com.avito.android;

import com.avito.android.common.CounterInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersRepositoryImpl_Factory implements Factory<FavoriteSellersRepositoryImpl> {
    public final Provider<CounterInteractor> a;

    public FavoriteSellersRepositoryImpl_Factory(Provider<CounterInteractor> provider) {
        this.a = provider;
    }

    public static FavoriteSellersRepositoryImpl_Factory create(Provider<CounterInteractor> provider) {
        return new FavoriteSellersRepositoryImpl_Factory(provider);
    }

    public static FavoriteSellersRepositoryImpl newInstance(CounterInteractor counterInteractor) {
        return new FavoriteSellersRepositoryImpl(counterInteractor);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersRepositoryImpl get() {
        return newInstance(this.a.get());
    }
}
