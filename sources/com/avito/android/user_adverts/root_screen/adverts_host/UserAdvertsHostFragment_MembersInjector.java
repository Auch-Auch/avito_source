package com.avito.android.user_adverts.root_screen.adverts_host;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModelFactory;
import com.avito.android.user_adverts.tracker.UserAdvertsTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserAdvertsHostFragment_MembersInjector implements MembersInjector<UserAdvertsHostFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<UserAdvertsHostPresenter> c;
    public final Provider<UserAdvertsInteractor> d;
    public final Provider<TabsDataProvider<TabItem>> e;
    public final Provider<Analytics> f;
    public final Provider<UserAdvertsInfoUpdateRunner> g;
    public final Provider<UserAdvertsTracker> h;
    public final Provider<ProfileHeaderViewModelFactory> i;
    public final Provider<UserAdvertsHostViewModelFactory> j;
    public final Provider<Features> k;
    public final Provider<UserAdvertsTabTestGroup> l;
    public final Provider<CartFabViewModel> m;
    public final Provider<CartQuantityChangesHandler> n;

    public UserAdvertsHostFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<UserAdvertsHostPresenter> provider3, Provider<UserAdvertsInteractor> provider4, Provider<TabsDataProvider<TabItem>> provider5, Provider<Analytics> provider6, Provider<UserAdvertsInfoUpdateRunner> provider7, Provider<UserAdvertsTracker> provider8, Provider<ProfileHeaderViewModelFactory> provider9, Provider<UserAdvertsHostViewModelFactory> provider10, Provider<Features> provider11, Provider<UserAdvertsTabTestGroup> provider12, Provider<CartFabViewModel> provider13, Provider<CartQuantityChangesHandler> provider14) {
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
    }

    public static MembersInjector<UserAdvertsHostFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<UserAdvertsHostPresenter> provider3, Provider<UserAdvertsInteractor> provider4, Provider<TabsDataProvider<TabItem>> provider5, Provider<Analytics> provider6, Provider<UserAdvertsInfoUpdateRunner> provider7, Provider<UserAdvertsTracker> provider8, Provider<ProfileHeaderViewModelFactory> provider9, Provider<UserAdvertsHostViewModelFactory> provider10, Provider<Features> provider11, Provider<UserAdvertsTabTestGroup> provider12, Provider<CartFabViewModel> provider13, Provider<CartQuantityChangesHandler> provider14) {
        return new UserAdvertsHostFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(UserAdvertsHostFragment userAdvertsHostFragment, ActivityIntentFactory activityIntentFactory) {
        userAdvertsHostFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.analytics")
    public static void injectAnalytics(UserAdvertsHostFragment userAdvertsHostFragment, Analytics analytics) {
        userAdvertsHostFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.cartFabViewModel")
    public static void injectCartFabViewModel(UserAdvertsHostFragment userAdvertsHostFragment, CartFabViewModel cartFabViewModel) {
        userAdvertsHostFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.cartQuantityHandler")
    public static void injectCartQuantityHandler(UserAdvertsHostFragment userAdvertsHostFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        userAdvertsHostFragment.cartQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserAdvertsHostFragment userAdvertsHostFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        userAdvertsHostFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.features")
    public static void injectFeatures(UserAdvertsHostFragment userAdvertsHostFragment, Features features) {
        userAdvertsHostFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.interactor")
    public static void injectInteractor(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsInteractor userAdvertsInteractor) {
        userAdvertsHostFragment.interactor = userAdvertsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.presenter")
    public static void injectPresenter(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsHostPresenter userAdvertsHostPresenter) {
        userAdvertsHostFragment.presenter = userAdvertsHostPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.profileHeaderViewModelFactory")
    public static void injectProfileHeaderViewModelFactory(UserAdvertsHostFragment userAdvertsHostFragment, ProfileHeaderViewModelFactory profileHeaderViewModelFactory) {
        userAdvertsHostFragment.profileHeaderViewModelFactory = profileHeaderViewModelFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.tabTestGroup")
    public static void injectTabTestGroup(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        userAdvertsHostFragment.tabTestGroup = userAdvertsTabTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.tabsDataProvider")
    public static void injectTabsDataProvider(UserAdvertsHostFragment userAdvertsHostFragment, TabsDataProvider<TabItem> tabsDataProvider) {
        userAdvertsHostFragment.tabsDataProvider = tabsDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.tracker")
    public static void injectTracker(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsTracker userAdvertsTracker) {
        userAdvertsHostFragment.tracker = userAdvertsTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.userAdvertsInfoUpdateRunner")
    public static void injectUserAdvertsInfoUpdateRunner(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner) {
        userAdvertsHostFragment.userAdvertsInfoUpdateRunner = userAdvertsInfoUpdateRunner;
    }

    @InjectedFieldSignature("com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment.viewModelFactory")
    public static void injectViewModelFactory(UserAdvertsHostFragment userAdvertsHostFragment, UserAdvertsHostViewModelFactory userAdvertsHostViewModelFactory) {
        userAdvertsHostFragment.viewModelFactory = userAdvertsHostViewModelFactory;
    }

    public void injectMembers(UserAdvertsHostFragment userAdvertsHostFragment) {
        injectActivityIntentFactory(userAdvertsHostFragment, this.a.get());
        injectDeepLinkIntentFactory(userAdvertsHostFragment, this.b.get());
        injectPresenter(userAdvertsHostFragment, this.c.get());
        injectInteractor(userAdvertsHostFragment, this.d.get());
        injectTabsDataProvider(userAdvertsHostFragment, this.e.get());
        injectAnalytics(userAdvertsHostFragment, this.f.get());
        injectUserAdvertsInfoUpdateRunner(userAdvertsHostFragment, this.g.get());
        injectTracker(userAdvertsHostFragment, this.h.get());
        injectProfileHeaderViewModelFactory(userAdvertsHostFragment, this.i.get());
        injectViewModelFactory(userAdvertsHostFragment, this.j.get());
        injectFeatures(userAdvertsHostFragment, this.k.get());
        injectTabTestGroup(userAdvertsHostFragment, this.l.get());
        injectCartFabViewModel(userAdvertsHostFragment, this.m.get());
        injectCartQuantityHandler(userAdvertsHostFragment, this.n.get());
    }
}
