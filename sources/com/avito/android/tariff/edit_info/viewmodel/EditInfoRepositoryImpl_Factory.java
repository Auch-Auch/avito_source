package com.avito.android.tariff.edit_info.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditInfoRepositoryImpl_Factory implements Factory<EditInfoRepositoryImpl> {
    public final Provider<TariffApi> a;
    public final Provider<SchedulersFactory> b;

    public EditInfoRepositoryImpl_Factory(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditInfoRepositoryImpl_Factory create(Provider<TariffApi> provider, Provider<SchedulersFactory> provider2) {
        return new EditInfoRepositoryImpl_Factory(provider, provider2);
    }

    public static EditInfoRepositoryImpl newInstance(TariffApi tariffApi, SchedulersFactory schedulersFactory) {
        return new EditInfoRepositoryImpl(tariffApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public EditInfoRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
