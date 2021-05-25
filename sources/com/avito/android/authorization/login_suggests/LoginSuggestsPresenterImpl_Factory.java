package com.avito.android.authorization.login_suggests;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginSuggestsPresenterImpl_Factory implements Factory<LoginSuggestsPresenterImpl> {
    public final Provider<LoginSuggestsInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<PublishRelay<LoginSuggestsItem>> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<Analytics> e;
    public final Provider<ScreenTracker> f;
    public final Provider<ContentTracker> g;
    public final Provider<Kundle> h;

    public LoginSuggestsPresenterImpl_Factory(Provider<LoginSuggestsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<PublishRelay<LoginSuggestsItem>> provider3, Provider<SchedulersFactory> provider4, Provider<Analytics> provider5, Provider<ScreenTracker> provider6, Provider<ContentTracker> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static LoginSuggestsPresenterImpl_Factory create(Provider<LoginSuggestsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<PublishRelay<LoginSuggestsItem>> provider3, Provider<SchedulersFactory> provider4, Provider<Analytics> provider5, Provider<ScreenTracker> provider6, Provider<ContentTracker> provider7, Provider<Kundle> provider8) {
        return new LoginSuggestsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static LoginSuggestsPresenterImpl newInstance(LoginSuggestsInteractor loginSuggestsInteractor, AdapterPresenter adapterPresenter, PublishRelay<LoginSuggestsItem> publishRelay, SchedulersFactory schedulersFactory, Analytics analytics, ScreenTracker screenTracker, ContentTracker contentTracker, Kundle kundle) {
        return new LoginSuggestsPresenterImpl(loginSuggestsInteractor, adapterPresenter, publishRelay, schedulersFactory, analytics, screenTracker, contentTracker, kundle);
    }

    @Override // javax.inject.Provider
    public LoginSuggestsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
