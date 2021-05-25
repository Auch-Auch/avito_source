package com.avito.android.authorization.select_profile;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectProfilePresenterImpl_Factory implements Factory<SelectProfilePresenterImpl> {
    public final Provider<SelectProfileInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ErrorFormatter> d;
    public final Provider<PublishRelay<SelectProfileField>> e;
    public final Provider<Analytics> f;
    public final Provider<Kundle> g;

    public SelectProfilePresenterImpl_Factory(Provider<SelectProfileInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorFormatter> provider4, Provider<PublishRelay<SelectProfileField>> provider5, Provider<Analytics> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static SelectProfilePresenterImpl_Factory create(Provider<SelectProfileInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorFormatter> provider4, Provider<PublishRelay<SelectProfileField>> provider5, Provider<Analytics> provider6, Provider<Kundle> provider7) {
        return new SelectProfilePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SelectProfilePresenterImpl newInstance(SelectProfileInteractor selectProfileInteractor, AdapterPresenter adapterPresenter, SchedulersFactory3 schedulersFactory3, ErrorFormatter errorFormatter, PublishRelay<SelectProfileField> publishRelay, Analytics analytics, Kundle kundle) {
        return new SelectProfilePresenterImpl(selectProfileInteractor, adapterPresenter, schedulersFactory3, errorFormatter, publishRelay, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public SelectProfilePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
