package com.avito.android.profile.di;

import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.UserProfileInteractor;
import com.avito.android.profile.UserProfileItemConverter;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.social.Logoutable;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvidePresenterFactory implements Factory<UserProfilePresenter> {
    public final UserProfileModule a;
    public final Provider<UserProfileInteractor> b;
    public final Provider<UserProfileItemConverter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<UserProfileResourceProvider> f;
    public final Provider<AccountInteractor> g;
    public final Provider<AccountStorageInteractor> h;
    public final Provider<Logoutable> i;
    public final Provider<Analytics> j;
    public final Provider<Features> k;
    public final Provider<DialogPresenter> l;
    public final Provider<ErrorHelper> m;
    public final Provider<RxTimer> n;
    public final Provider<PublishRelay<DeepLink>> o;
    public final Provider<PublishRelay<CardItem.TfaSettingsCardItem>> p;
    public final Provider<UserProfileTracker> q;
    public final Provider<ProfileHeaderPresenter> r;

    public UserProfileModule_ProvidePresenterFactory(UserProfileModule userProfileModule, Provider<UserProfileInteractor> provider, Provider<UserProfileItemConverter> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<UserProfileResourceProvider> provider5, Provider<AccountInteractor> provider6, Provider<AccountStorageInteractor> provider7, Provider<Logoutable> provider8, Provider<Analytics> provider9, Provider<Features> provider10, Provider<DialogPresenter> provider11, Provider<ErrorHelper> provider12, Provider<RxTimer> provider13, Provider<PublishRelay<DeepLink>> provider14, Provider<PublishRelay<CardItem.TfaSettingsCardItem>> provider15, Provider<UserProfileTracker> provider16, Provider<ProfileHeaderPresenter> provider17) {
        this.a = userProfileModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
    }

    public static UserProfileModule_ProvidePresenterFactory create(UserProfileModule userProfileModule, Provider<UserProfileInteractor> provider, Provider<UserProfileItemConverter> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<UserProfileResourceProvider> provider5, Provider<AccountInteractor> provider6, Provider<AccountStorageInteractor> provider7, Provider<Logoutable> provider8, Provider<Analytics> provider9, Provider<Features> provider10, Provider<DialogPresenter> provider11, Provider<ErrorHelper> provider12, Provider<RxTimer> provider13, Provider<PublishRelay<DeepLink>> provider14, Provider<PublishRelay<CardItem.TfaSettingsCardItem>> provider15, Provider<UserProfileTracker> provider16, Provider<ProfileHeaderPresenter> provider17) {
        return new UserProfileModule_ProvidePresenterFactory(userProfileModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static UserProfilePresenter providePresenter(UserProfileModule userProfileModule, UserProfileInteractor userProfileInteractor, UserProfileItemConverter userProfileItemConverter, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, UserProfileResourceProvider userProfileResourceProvider, AccountInteractor accountInteractor, AccountStorageInteractor accountStorageInteractor, Logoutable logoutable, Analytics analytics, Features features, DialogPresenter dialogPresenter, ErrorHelper errorHelper, RxTimer rxTimer, PublishRelay<DeepLink> publishRelay, PublishRelay<CardItem.TfaSettingsCardItem> publishRelay2, UserProfileTracker userProfileTracker, ProfileHeaderPresenter profileHeaderPresenter) {
        return (UserProfilePresenter) Preconditions.checkNotNullFromProvides(userProfileModule.providePresenter(userProfileInteractor, userProfileItemConverter, schedulersFactory, adapterPresenter, userProfileResourceProvider, accountInteractor, accountStorageInteractor, logoutable, analytics, features, dialogPresenter, errorHelper, rxTimer, publishRelay, publishRelay2, userProfileTracker, profileHeaderPresenter));
    }

    @Override // javax.inject.Provider
    public UserProfilePresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get());
    }
}
