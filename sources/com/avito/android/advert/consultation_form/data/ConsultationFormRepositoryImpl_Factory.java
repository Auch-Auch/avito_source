package com.avito.android.advert.consultation_form.data;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.model.ConsultationFormData;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ConsultationFormRepositoryImpl_Factory implements Factory<ConsultationFormRepositoryImpl> {
    public final Provider<AdvertDetailsApi> a;
    public final Provider<ConsultationFormData> b;
    public final Provider<ShortTermRentApi> c;

    public ConsultationFormRepositoryImpl_Factory(Provider<AdvertDetailsApi> provider, Provider<ConsultationFormData> provider2, Provider<ShortTermRentApi> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ConsultationFormRepositoryImpl_Factory create(Provider<AdvertDetailsApi> provider, Provider<ConsultationFormData> provider2, Provider<ShortTermRentApi> provider3) {
        return new ConsultationFormRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static ConsultationFormRepositoryImpl newInstance(AdvertDetailsApi advertDetailsApi, ConsultationFormData consultationFormData, ShortTermRentApi shortTermRentApi) {
        return new ConsultationFormRepositoryImpl(advertDetailsApi, consultationFormData, shortTermRentApi);
    }

    @Override // javax.inject.Provider
    public ConsultationFormRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
