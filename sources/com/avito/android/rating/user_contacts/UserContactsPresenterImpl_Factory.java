package com.avito.android.rating.user_contacts;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class UserContactsPresenterImpl_Factory implements Factory<UserContactsPresenterImpl> {
    public final Provider<UserContactsInteractor> a;
    public final Provider<UserContactsConverter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Observable<UserContactAction>> d;
    public final Provider<ErrorHelper> e;
    public final Provider<UserContactsSpanProvider> f;
    public final Provider<Observable<LoadingItemNextPageAction>> g;
    public final Provider<Kundle> h;

    public UserContactsPresenterImpl_Factory(Provider<UserContactsInteractor> provider, Provider<UserContactsConverter> provider2, Provider<SchedulersFactory3> provider3, Provider<Observable<UserContactAction>> provider4, Provider<ErrorHelper> provider5, Provider<UserContactsSpanProvider> provider6, Provider<Observable<LoadingItemNextPageAction>> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static UserContactsPresenterImpl_Factory create(Provider<UserContactsInteractor> provider, Provider<UserContactsConverter> provider2, Provider<SchedulersFactory3> provider3, Provider<Observable<UserContactAction>> provider4, Provider<ErrorHelper> provider5, Provider<UserContactsSpanProvider> provider6, Provider<Observable<LoadingItemNextPageAction>> provider7, Provider<Kundle> provider8) {
        return new UserContactsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static UserContactsPresenterImpl newInstance(UserContactsInteractor userContactsInteractor, UserContactsConverter userContactsConverter, SchedulersFactory3 schedulersFactory3, Observable<UserContactAction> observable, ErrorHelper errorHelper, UserContactsSpanProvider userContactsSpanProvider, Observable<LoadingItemNextPageAction> observable2, Kundle kundle) {
        return new UserContactsPresenterImpl(userContactsInteractor, userContactsConverter, schedulersFactory3, observable, errorHelper, userContactsSpanProvider, observable2, kundle);
    }

    @Override // javax.inject.Provider
    public UserContactsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
