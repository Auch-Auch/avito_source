package com.avito.android.extended_profile;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileViewModelFactory_Factory implements Factory<ExtendedProfileViewModelFactory> {
    public final Provider<String> a;
    public final Provider<ExtendedPublicUserProfile> b;
    public final Provider<String> c;
    public final Provider<ExtendedProfileInteractor> d;
    public final Provider<ExtendedProfileContactsInteractor> e;
    public final Provider<FavoriteAdvertsInteractor> f;
    public final Provider<FavoriteSellersRepository> g;
    public final Provider<ViewedAdvertsEventInteractor> h;
    public final Provider<AccountStateProvider> i;
    public final Provider<ExtendedProfileResourceProvider> j;
    public final Provider<SchedulersFactory3> k;
    public final Provider<ErrorHelper> l;
    public final Provider<AdvertActionIconFactory> m;
    public final Provider<ExtendedProfileTracker> n;
    public final Provider<Analytics> o;

    public ExtendedProfileViewModelFactory_Factory(Provider<String> provider, Provider<ExtendedPublicUserProfile> provider2, Provider<String> provider3, Provider<ExtendedProfileInteractor> provider4, Provider<ExtendedProfileContactsInteractor> provider5, Provider<FavoriteAdvertsInteractor> provider6, Provider<FavoriteSellersRepository> provider7, Provider<ViewedAdvertsEventInteractor> provider8, Provider<AccountStateProvider> provider9, Provider<ExtendedProfileResourceProvider> provider10, Provider<SchedulersFactory3> provider11, Provider<ErrorHelper> provider12, Provider<AdvertActionIconFactory> provider13, Provider<ExtendedProfileTracker> provider14, Provider<Analytics> provider15) {
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
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
    }

    public static ExtendedProfileViewModelFactory_Factory create(Provider<String> provider, Provider<ExtendedPublicUserProfile> provider2, Provider<String> provider3, Provider<ExtendedProfileInteractor> provider4, Provider<ExtendedProfileContactsInteractor> provider5, Provider<FavoriteAdvertsInteractor> provider6, Provider<FavoriteSellersRepository> provider7, Provider<ViewedAdvertsEventInteractor> provider8, Provider<AccountStateProvider> provider9, Provider<ExtendedProfileResourceProvider> provider10, Provider<SchedulersFactory3> provider11, Provider<ErrorHelper> provider12, Provider<AdvertActionIconFactory> provider13, Provider<ExtendedProfileTracker> provider14, Provider<Analytics> provider15) {
        return new ExtendedProfileViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static ExtendedProfileViewModelFactory newInstance(String str, ExtendedPublicUserProfile extendedPublicUserProfile, String str2, ExtendedProfileInteractor extendedProfileInteractor, ExtendedProfileContactsInteractor extendedProfileContactsInteractor, FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteSellersRepository favoriteSellersRepository, ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, AccountStateProvider accountStateProvider, ExtendedProfileResourceProvider extendedProfileResourceProvider, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper, AdvertActionIconFactory advertActionIconFactory, ExtendedProfileTracker extendedProfileTracker, Analytics analytics) {
        return new ExtendedProfileViewModelFactory(str, extendedPublicUserProfile, str2, extendedProfileInteractor, extendedProfileContactsInteractor, favoriteAdvertsInteractor, favoriteSellersRepository, viewedAdvertsEventInteractor, accountStateProvider, extendedProfileResourceProvider, schedulersFactory3, errorHelper, advertActionIconFactory, extendedProfileTracker, analytics);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get());
    }
}
