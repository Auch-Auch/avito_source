package com.avito.android.authorization.complete_registration;

import com.avito.android.Features;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CompleteRegistrationPresenterImpl_Factory implements Factory<CompleteRegistrationPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<CompleteRegistrationInteractor> c;
    public final Provider<SmartLockSaver> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<Features> f;
    public final Provider<Kundle> g;

    public CompleteRegistrationPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<CompleteRegistrationInteractor> provider3, Provider<SmartLockSaver> provider4, Provider<SchedulersFactory> provider5, Provider<Features> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static CompleteRegistrationPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<CompleteRegistrationInteractor> provider3, Provider<SmartLockSaver> provider4, Provider<SchedulersFactory> provider5, Provider<Features> provider6, Provider<Kundle> provider7) {
        return new CompleteRegistrationPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CompleteRegistrationPresenterImpl newInstance(String str, String str2, CompleteRegistrationInteractor completeRegistrationInteractor, SmartLockSaver smartLockSaver, SchedulersFactory schedulersFactory, Features features, Kundle kundle) {
        return new CompleteRegistrationPresenterImpl(str, str2, completeRegistrationInteractor, smartLockSaver, schedulersFactory, features, kundle);
    }

    @Override // javax.inject.Provider
    public CompleteRegistrationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
