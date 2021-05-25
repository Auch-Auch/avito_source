package com.avito.android.developments_catalog.items.consultation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ConsultationBlueprint_Factory implements Factory<ConsultationBlueprint> {
    public final Provider<ConsultationPresenter> a;

    public ConsultationBlueprint_Factory(Provider<ConsultationPresenter> provider) {
        this.a = provider;
    }

    public static ConsultationBlueprint_Factory create(Provider<ConsultationPresenter> provider) {
        return new ConsultationBlueprint_Factory(provider);
    }

    public static ConsultationBlueprint newInstance(ConsultationPresenter consultationPresenter) {
        return new ConsultationBlueprint(consultationPresenter);
    }

    @Override // javax.inject.Provider
    public ConsultationBlueprint get() {
        return newInstance(this.a.get());
    }
}
