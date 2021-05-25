package com.avito.android.authorization.start_registration;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StartRegistrationPresenterImpl_Factory implements Factory<StartRegistrationPresenterImpl> {
    public final Provider<StartRegistrationInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Kundle> c;

    public StartRegistrationPresenterImpl_Factory(Provider<StartRegistrationInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static StartRegistrationPresenterImpl_Factory create(Provider<StartRegistrationInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Kundle> provider3) {
        return new StartRegistrationPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static StartRegistrationPresenterImpl newInstance(StartRegistrationInteractor startRegistrationInteractor, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new StartRegistrationPresenterImpl(startRegistrationInteractor, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public StartRegistrationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
