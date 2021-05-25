package com.avito.android.advert.item.consultation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsConsultationBlueprint_Factory implements Factory<AdvertDetailsConsultationBlueprint> {
    public final Provider<AdvertDetailsConsultationPresenter> a;

    public AdvertDetailsConsultationBlueprint_Factory(Provider<AdvertDetailsConsultationPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsConsultationBlueprint_Factory create(Provider<AdvertDetailsConsultationPresenter> provider) {
        return new AdvertDetailsConsultationBlueprint_Factory(provider);
    }

    public static AdvertDetailsConsultationBlueprint newInstance(AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter) {
        return new AdvertDetailsConsultationBlueprint(advertDetailsConsultationPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsConsultationBlueprint get() {
        return newInstance(this.a.get());
    }
}
