package com.avito.android.autoteka_details.core;

import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaDetailsInteractorImpl_Factory implements Factory<AutotekaDetailsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<AutotekaApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<Kundle> e;
    public final Provider<AutotekaDetailsResponse> f;

    public AutotekaDetailsInteractorImpl_Factory(Provider<String> provider, Provider<AutotekaApi> provider2, Provider<SchedulersFactory> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<Kundle> provider5, Provider<AutotekaDetailsResponse> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AutotekaDetailsInteractorImpl_Factory create(Provider<String> provider, Provider<AutotekaApi> provider2, Provider<SchedulersFactory> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<Kundle> provider5, Provider<AutotekaDetailsResponse> provider6) {
        return new AutotekaDetailsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AutotekaDetailsInteractorImpl newInstance(String str, AutotekaApi autotekaApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, Kundle kundle, AutotekaDetailsResponse autotekaDetailsResponse) {
        return new AutotekaDetailsInteractorImpl(str, autotekaApi, schedulersFactory, typedErrorThrowableConverter, kundle, autotekaDetailsResponse);
    }

    @Override // javax.inject.Provider
    public AutotekaDetailsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
