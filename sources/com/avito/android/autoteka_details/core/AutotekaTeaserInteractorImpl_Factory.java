package com.avito.android.autoteka_details.core;

import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaTeaserInteractorImpl_Factory implements Factory<AutotekaTeaserInteractorImpl> {
    public final Provider<AutotekaApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<Kundle> d;

    public AutotekaTeaserInteractorImpl_Factory(Provider<AutotekaApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AutotekaTeaserInteractorImpl_Factory create(Provider<AutotekaApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Kundle> provider4) {
        return new AutotekaTeaserInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AutotekaTeaserInteractorImpl newInstance(AutotekaApi autotekaApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, Kundle kundle) {
        return new AutotekaTeaserInteractorImpl(autotekaApi, schedulersFactory, typedErrorThrowableConverter, kundle);
    }

    @Override // javax.inject.Provider
    public AutotekaTeaserInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
