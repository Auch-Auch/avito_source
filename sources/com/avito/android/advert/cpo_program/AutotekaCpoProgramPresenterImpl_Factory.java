package com.avito.android.advert.cpo_program;

import com.avito.android.remote.model.CpoDescription;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaCpoProgramPresenterImpl_Factory implements Factory<AutotekaCpoProgramPresenterImpl> {
    public final Provider<CpoDescription> a;
    public final Provider<SchedulersFactory3> b;

    public AutotekaCpoProgramPresenterImpl_Factory(Provider<CpoDescription> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutotekaCpoProgramPresenterImpl_Factory create(Provider<CpoDescription> provider, Provider<SchedulersFactory3> provider2) {
        return new AutotekaCpoProgramPresenterImpl_Factory(provider, provider2);
    }

    public static AutotekaCpoProgramPresenterImpl newInstance(CpoDescription cpoDescription, SchedulersFactory3 schedulersFactory3) {
        return new AutotekaCpoProgramPresenterImpl(cpoDescription, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AutotekaCpoProgramPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
