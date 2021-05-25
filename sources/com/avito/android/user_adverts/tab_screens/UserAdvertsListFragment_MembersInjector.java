package com.avito.android.user_adverts.tab_screens;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.user_adverts.tracker.UserAdvertsListTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserAdvertsListFragment_MembersInjector implements MembersInjector<UserAdvertsListFragment> {
    public final Provider<UserAdvertsListPresenter> a;
    public final Provider<UserAdvertsListInteractor> b;
    public final Provider<FloatingViewsPresenter> c;
    public final Provider<ResponsiveAdapterPresenter> d;
    public final Provider<DestroyableViewHolderBuilder> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<Analytics> h;
    public final Provider<UserAdvertsListTracker> i;
    public final Provider<Features> j;

    public UserAdvertsListFragment_MembersInjector(Provider<UserAdvertsListPresenter> provider, Provider<UserAdvertsListInteractor> provider2, Provider<FloatingViewsPresenter> provider3, Provider<ResponsiveAdapterPresenter> provider4, Provider<DestroyableViewHolderBuilder> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<Analytics> provider8, Provider<UserAdvertsListTracker> provider9, Provider<Features> provider10) {
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

    public static MembersInjector<UserAdvertsListFragment> create(Provider<UserAdvertsListPresenter> provider, Provider<UserAdvertsListInteractor> provider2, Provider<FloatingViewsPresenter> provider3, Provider<ResponsiveAdapterPresenter> provider4, Provider<DestroyableViewHolderBuilder> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<Analytics> provider8, Provider<UserAdvertsListTracker> provider9, Provider<Features> provider10) {
        return new UserAdvertsListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.adapterPresenter")
    public static void injectAdapterPresenter(UserAdvertsListFragment userAdvertsListFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        userAdvertsListFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.analytics")
    public static void injectAnalytics(UserAdvertsListFragment userAdvertsListFragment, Analytics analytics) {
        userAdvertsListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserAdvertsListFragment userAdvertsListFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        userAdvertsListFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.features")
    public static void injectFeatures(UserAdvertsListFragment userAdvertsListFragment, Features features) {
        userAdvertsListFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.floatingViewsPresenter")
    public static void injectFloatingViewsPresenter(UserAdvertsListFragment userAdvertsListFragment, FloatingViewsPresenter floatingViewsPresenter) {
        userAdvertsListFragment.floatingViewsPresenter = floatingViewsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.intentFactory")
    public static void injectIntentFactory(UserAdvertsListFragment userAdvertsListFragment, ActivityIntentFactory activityIntentFactory) {
        userAdvertsListFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.interactor")
    public static void injectInteractor(UserAdvertsListFragment userAdvertsListFragment, UserAdvertsListInteractor userAdvertsListInteractor) {
        userAdvertsListFragment.interactor = userAdvertsListInteractor;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.presenter")
    public static void injectPresenter(UserAdvertsListFragment userAdvertsListFragment, UserAdvertsListPresenter userAdvertsListPresenter) {
        userAdvertsListFragment.presenter = userAdvertsListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.tracker")
    public static void injectTracker(UserAdvertsListFragment userAdvertsListFragment, UserAdvertsListTracker userAdvertsListTracker) {
        userAdvertsListFragment.tracker = userAdvertsListTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment.viewHolderBuilder")
    public static void injectViewHolderBuilder(UserAdvertsListFragment userAdvertsListFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        userAdvertsListFragment.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    public void injectMembers(UserAdvertsListFragment userAdvertsListFragment) {
        injectPresenter(userAdvertsListFragment, this.a.get());
        injectInteractor(userAdvertsListFragment, this.b.get());
        injectFloatingViewsPresenter(userAdvertsListFragment, this.c.get());
        injectAdapterPresenter(userAdvertsListFragment, this.d.get());
        injectViewHolderBuilder(userAdvertsListFragment, this.e.get());
        injectIntentFactory(userAdvertsListFragment, this.f.get());
        injectDeepLinkIntentFactory(userAdvertsListFragment, this.g.get());
        injectAnalytics(userAdvertsListFragment, this.h.get());
        injectTracker(userAdvertsListFragment, this.i.get());
        injectFeatures(userAdvertsListFragment, this.j.get());
    }
}
