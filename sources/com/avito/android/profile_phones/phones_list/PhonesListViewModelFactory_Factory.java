package com.avito.android.profile_phones.phones_list;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhonesListViewModelFactory_Factory implements Factory<PhonesListViewModelFactory> {
    public final Provider<PhonesListInteractor> a;
    public final Provider<Analytics> b;

    public PhonesListViewModelFactory_Factory(Provider<PhonesListInteractor> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhonesListViewModelFactory_Factory create(Provider<PhonesListInteractor> provider, Provider<Analytics> provider2) {
        return new PhonesListViewModelFactory_Factory(provider, provider2);
    }

    public static PhonesListViewModelFactory newInstance(PhonesListInteractor phonesListInteractor, Analytics analytics) {
        return new PhonesListViewModelFactory(phonesListInteractor, analytics);
    }

    @Override // javax.inject.Provider
    public PhonesListViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
