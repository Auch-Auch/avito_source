package com.avito.android.profile.sessions.list;

import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class SessionsListPresenterImpl_Factory implements Factory<SessionsListPresenterImpl> {
    public final Provider<SessionsListInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<CompositeSnackbarPresenter> c;
    public final Provider<ErrorHelper> d;
    public final Provider<Observable<SessionsItemAction>> e;
    public final Provider<SessionsListResourceProvider> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<Kundle> h;
    public final Provider<Analytics> i;
    public final Provider<String> j;

    public SessionsListPresenterImpl_Factory(Provider<SessionsListInteractor> provider, Provider<AdapterPresenter> provider2, Provider<CompositeSnackbarPresenter> provider3, Provider<ErrorHelper> provider4, Provider<Observable<SessionsItemAction>> provider5, Provider<SessionsListResourceProvider> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8, Provider<Analytics> provider9, Provider<String> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static SessionsListPresenterImpl_Factory create(Provider<SessionsListInteractor> provider, Provider<AdapterPresenter> provider2, Provider<CompositeSnackbarPresenter> provider3, Provider<ErrorHelper> provider4, Provider<Observable<SessionsItemAction>> provider5, Provider<SessionsListResourceProvider> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8, Provider<Analytics> provider9, Provider<String> provider10) {
        return new SessionsListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SessionsListPresenterImpl newInstance(SessionsListInteractor sessionsListInteractor, AdapterPresenter adapterPresenter, CompositeSnackbarPresenter compositeSnackbarPresenter, ErrorHelper errorHelper, Observable<SessionsItemAction> observable, SessionsListResourceProvider sessionsListResourceProvider, SchedulersFactory3 schedulersFactory3, Kundle kundle, Analytics analytics, String str) {
        return new SessionsListPresenterImpl(sessionsListInteractor, adapterPresenter, compositeSnackbarPresenter, errorHelper, observable, sessionsListResourceProvider, schedulersFactory3, kundle, analytics, str);
    }

    @Override // javax.inject.Provider
    public SessionsListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
