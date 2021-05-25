package com.avito.android.advert.item.domoteka;

import com.avito.android.Features;
import com.avito.android.domteka.DomotekaApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DomotekaTeaserInteractorImpl_Factory implements Factory<DomotekaTeaserInteractorImpl> {
    public final Provider<DomotekaApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<Features> c;
    public final Provider<Kundle> d;

    public DomotekaTeaserInteractorImpl_Factory(Provider<DomotekaApi> provider, Provider<SchedulersFactory3> provider2, Provider<Features> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DomotekaTeaserInteractorImpl_Factory create(Provider<DomotekaApi> provider, Provider<SchedulersFactory3> provider2, Provider<Features> provider3, Provider<Kundle> provider4) {
        return new DomotekaTeaserInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DomotekaTeaserInteractorImpl newInstance(DomotekaApi domotekaApi, SchedulersFactory3 schedulersFactory3, Features features, Kundle kundle) {
        return new DomotekaTeaserInteractorImpl(domotekaApi, schedulersFactory3, features, kundle);
    }

    @Override // javax.inject.Provider
    public DomotekaTeaserInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
