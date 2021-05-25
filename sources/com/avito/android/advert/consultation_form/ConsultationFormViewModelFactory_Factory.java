package com.avito.android.advert.consultation_form;

import com.avito.android.advert.consultation_form.data.ConsultationFormRepository;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ConsultationFormViewModelFactory_Factory implements Factory<ConsultationFormViewModelFactory> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<ConsultationFormRepository> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<Analytics> e;
    public final Provider<ConsultationFormData> f;

    public ConsultationFormViewModelFactory_Factory(Provider<String> provider, Provider<String> provider2, Provider<ConsultationFormRepository> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<ConsultationFormData> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ConsultationFormViewModelFactory_Factory create(Provider<String> provider, Provider<String> provider2, Provider<ConsultationFormRepository> provider3, Provider<SchedulersFactory3> provider4, Provider<Analytics> provider5, Provider<ConsultationFormData> provider6) {
        return new ConsultationFormViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ConsultationFormViewModelFactory newInstance(String str, String str2, ConsultationFormRepository consultationFormRepository, SchedulersFactory3 schedulersFactory3, Analytics analytics, ConsultationFormData consultationFormData) {
        return new ConsultationFormViewModelFactory(str, str2, consultationFormRepository, schedulersFactory3, analytics, consultationFormData);
    }

    @Override // javax.inject.Provider
    public ConsultationFormViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
