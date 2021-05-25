package com.avito.android.autoteka_details;

import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaDetailsPresenterImpl_Factory implements Factory<AutotekaDetailsPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<AutotekaDetailsInteractor> c;
    public final Provider<AutotekaDetailsConverter> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<Analytics> f;
    public final Provider<Boolean> g;

    public AutotekaDetailsPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<AutotekaDetailsInteractor> provider3, Provider<AutotekaDetailsConverter> provider4, Provider<SchedulersFactory> provider5, Provider<Analytics> provider6, Provider<Boolean> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AutotekaDetailsPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<AutotekaDetailsInteractor> provider3, Provider<AutotekaDetailsConverter> provider4, Provider<SchedulersFactory> provider5, Provider<Analytics> provider6, Provider<Boolean> provider7) {
        return new AutotekaDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AutotekaDetailsPresenterImpl newInstance(String str, String str2, AutotekaDetailsInteractor autotekaDetailsInteractor, AutotekaDetailsConverter autotekaDetailsConverter, SchedulersFactory schedulersFactory, Analytics analytics, boolean z) {
        return new AutotekaDetailsPresenterImpl(str, str2, autotekaDetailsInteractor, autotekaDetailsConverter, schedulersFactory, analytics, z);
    }

    @Override // javax.inject.Provider
    public AutotekaDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get().booleanValue());
    }
}
