package com.avito.android.authorization.select_social;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectSocialPresenterImpl_Factory implements Factory<SelectSocialPresenterImpl> {
    public final Provider<SelectSocialInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorFormatter> d;
    public final Provider<PublishRelay<SelectSocialField>> e;
    public final Provider<SelectSocialResourceProvider> f;
    public final Provider<Analytics> g;
    public final Provider<String> h;
    public final Provider<Kundle> i;

    public SelectSocialPresenterImpl_Factory(Provider<SelectSocialInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorFormatter> provider4, Provider<PublishRelay<SelectSocialField>> provider5, Provider<SelectSocialResourceProvider> provider6, Provider<Analytics> provider7, Provider<String> provider8, Provider<Kundle> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static SelectSocialPresenterImpl_Factory create(Provider<SelectSocialInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorFormatter> provider4, Provider<PublishRelay<SelectSocialField>> provider5, Provider<SelectSocialResourceProvider> provider6, Provider<Analytics> provider7, Provider<String> provider8, Provider<Kundle> provider9) {
        return new SelectSocialPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SelectSocialPresenterImpl newInstance(SelectSocialInteractor selectSocialInteractor, AdapterPresenter adapterPresenter, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter, PublishRelay<SelectSocialField> publishRelay, SelectSocialResourceProvider selectSocialResourceProvider, Analytics analytics, String str, Kundle kundle) {
        return new SelectSocialPresenterImpl(selectSocialInteractor, adapterPresenter, schedulersFactory, errorFormatter, publishRelay, selectSocialResourceProvider, analytics, str, kundle);
    }

    @Override // javax.inject.Provider
    public SelectSocialPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
