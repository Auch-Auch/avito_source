package com.avito.android.user_adverts.items_search;

import com.avito.android.analytics.Analytics;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileItemsSearchViewModelFactory_Factory implements Factory<ProfileItemsSearchViewModelFactory> {
    public final Provider<ProfileItemsSearchInteractor> a;
    public final Provider<ProfileItemsSearchTracker> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<UserSearchItemConverter> d;
    public final Provider<SuggestsItemConverter> e;
    public final Provider<Analytics> f;
    public final Provider<String> g;

    public ProfileItemsSearchViewModelFactory_Factory(Provider<ProfileItemsSearchInteractor> provider, Provider<ProfileItemsSearchTracker> provider2, Provider<SchedulersFactory> provider3, Provider<UserSearchItemConverter> provider4, Provider<SuggestsItemConverter> provider5, Provider<Analytics> provider6, Provider<String> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ProfileItemsSearchViewModelFactory_Factory create(Provider<ProfileItemsSearchInteractor> provider, Provider<ProfileItemsSearchTracker> provider2, Provider<SchedulersFactory> provider3, Provider<UserSearchItemConverter> provider4, Provider<SuggestsItemConverter> provider5, Provider<Analytics> provider6, Provider<String> provider7) {
        return new ProfileItemsSearchViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ProfileItemsSearchViewModelFactory newInstance(ProfileItemsSearchInteractor profileItemsSearchInteractor, ProfileItemsSearchTracker profileItemsSearchTracker, SchedulersFactory schedulersFactory, UserSearchItemConverter userSearchItemConverter, SuggestsItemConverter suggestsItemConverter, Analytics analytics, String str) {
        return new ProfileItemsSearchViewModelFactory(profileItemsSearchInteractor, profileItemsSearchTracker, schedulersFactory, userSearchItemConverter, suggestsItemConverter, analytics, str);
    }

    @Override // javax.inject.Provider
    public ProfileItemsSearchViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
