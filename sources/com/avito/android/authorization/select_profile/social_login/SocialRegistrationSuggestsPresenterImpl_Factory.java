package com.avito.android.authorization.select_profile.social_login;

import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class SocialRegistrationSuggestsPresenterImpl_Factory implements Factory<SocialRegistrationSuggestsPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<AccountInteractor> d;
    public final Provider<List<RegisteredProfile>> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<PublishRelay<SelectProfileField>> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<SocialRegistrationSuggestsResourceProvider> i;
    public final Provider<ErrorHelper> j;
    public final Provider<Analytics> k;

    public SocialRegistrationSuggestsPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<AccountInteractor> provider4, Provider<List<RegisteredProfile>> provider5, Provider<AdapterPresenter> provider6, Provider<PublishRelay<SelectProfileField>> provider7, Provider<SchedulersFactory3> provider8, Provider<SocialRegistrationSuggestsResourceProvider> provider9, Provider<ErrorHelper> provider10, Provider<Analytics> provider11) {
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
        this.k = provider11;
    }

    public static SocialRegistrationSuggestsPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<AccountInteractor> provider4, Provider<List<RegisteredProfile>> provider5, Provider<AdapterPresenter> provider6, Provider<PublishRelay<SelectProfileField>> provider7, Provider<SchedulersFactory3> provider8, Provider<SocialRegistrationSuggestsResourceProvider> provider9, Provider<ErrorHelper> provider10, Provider<Analytics> provider11) {
        return new SocialRegistrationSuggestsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SocialRegistrationSuggestsPresenterImpl newInstance(String str, String str2, String str3, AccountInteractor accountInteractor, List<RegisteredProfile> list, AdapterPresenter adapterPresenter, PublishRelay<SelectProfileField> publishRelay, SchedulersFactory3 schedulersFactory3, SocialRegistrationSuggestsResourceProvider socialRegistrationSuggestsResourceProvider, ErrorHelper errorHelper, Analytics analytics) {
        return new SocialRegistrationSuggestsPresenterImpl(str, str2, str3, accountInteractor, list, adapterPresenter, publishRelay, schedulersFactory3, socialRegistrationSuggestsResourceProvider, errorHelper, analytics);
    }

    @Override // javax.inject.Provider
    public SocialRegistrationSuggestsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
