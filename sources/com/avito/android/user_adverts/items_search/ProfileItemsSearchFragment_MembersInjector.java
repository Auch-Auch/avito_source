package com.avito.android.user_adverts.items_search;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class ProfileItemsSearchFragment_MembersInjector implements MembersInjector<ProfileItemsSearchFragment> {
    public final Provider<ProfileItemsSearchTracker> a;
    public final Provider<ProfileItemsSearchViewModel> b;
    public final Provider<ResponsiveAdapterPresenter> c;
    public final Provider<DestroyableViewHolderBuilder> d;
    public final Provider<Analytics> e;
    public final Provider<DeepLinkIntentFactory> f;
    public final Provider<Observable<UserAdvertItemAction>> g;

    public ProfileItemsSearchFragment_MembersInjector(Provider<ProfileItemsSearchTracker> provider, Provider<ProfileItemsSearchViewModel> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<DestroyableViewHolderBuilder> provider4, Provider<Analytics> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<Observable<UserAdvertItemAction>> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<ProfileItemsSearchFragment> create(Provider<ProfileItemsSearchTracker> provider, Provider<ProfileItemsSearchViewModel> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<DestroyableViewHolderBuilder> provider4, Provider<Analytics> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<Observable<UserAdvertItemAction>> provider7) {
        return new ProfileItemsSearchFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.adapterPresenter")
    public static void injectAdapterPresenter(ProfileItemsSearchFragment profileItemsSearchFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        profileItemsSearchFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.analytics")
    public static void injectAnalytics(ProfileItemsSearchFragment profileItemsSearchFragment, Analytics analytics) {
        profileItemsSearchFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ProfileItemsSearchFragment profileItemsSearchFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        profileItemsSearchFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.itemActions")
    public static void injectItemActions(ProfileItemsSearchFragment profileItemsSearchFragment, Observable<UserAdvertItemAction> observable) {
        profileItemsSearchFragment.itemActions = observable;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.profileItemsViewModel")
    public static void injectProfileItemsViewModel(ProfileItemsSearchFragment profileItemsSearchFragment, ProfileItemsSearchViewModel profileItemsSearchViewModel) {
        profileItemsSearchFragment.profileItemsViewModel = profileItemsSearchViewModel;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.tracker")
    public static void injectTracker(ProfileItemsSearchFragment profileItemsSearchFragment, ProfileItemsSearchTracker profileItemsSearchTracker) {
        profileItemsSearchFragment.tracker = profileItemsSearchTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment.viewHolderBuilder")
    public static void injectViewHolderBuilder(ProfileItemsSearchFragment profileItemsSearchFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        profileItemsSearchFragment.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    public void injectMembers(ProfileItemsSearchFragment profileItemsSearchFragment) {
        injectTracker(profileItemsSearchFragment, this.a.get());
        injectProfileItemsViewModel(profileItemsSearchFragment, this.b.get());
        injectAdapterPresenter(profileItemsSearchFragment, this.c.get());
        injectViewHolderBuilder(profileItemsSearchFragment, this.d.get());
        injectAnalytics(profileItemsSearchFragment, this.e.get());
        injectDeepLinkIntentFactory(profileItemsSearchFragment, this.f.get());
        injectItemActions(profileItemsSearchFragment, this.g.get());
    }
}
