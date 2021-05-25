package com.avito.android.profile;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserProfileFragment_MembersInjector implements MembersInjector<UserProfileFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<UserProfilePresenter> d;
    public final Provider<UserProfileInteractor> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<ItemBinder> g;
    public final Provider<Features> h;
    public final Provider<Analytics> i;
    public final Provider<UserProfileTracker> j;
    public final Provider<CartFabViewModel> k;
    public final Provider<CartQuantityChangesHandler> l;
    public final Provider<UserAdvertsTabTestGroup> m;

    public UserProfileFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<UserProfilePresenter> provider4, Provider<UserProfileInteractor> provider5, Provider<AdapterPresenter> provider6, Provider<ItemBinder> provider7, Provider<Features> provider8, Provider<Analytics> provider9, Provider<UserProfileTracker> provider10, Provider<CartFabViewModel> provider11, Provider<CartQuantityChangesHandler> provider12, Provider<UserAdvertsTabTestGroup> provider13) {
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
    }

    public static MembersInjector<UserProfileFragment> create(Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<UserProfilePresenter> provider4, Provider<UserProfileInteractor> provider5, Provider<AdapterPresenter> provider6, Provider<ItemBinder> provider7, Provider<Features> provider8, Provider<Analytics> provider9, Provider<UserProfileTracker> provider10, Provider<CartFabViewModel> provider11, Provider<CartQuantityChangesHandler> provider12, Provider<UserAdvertsTabTestGroup> provider13) {
        return new UserProfileFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(UserProfileFragment userProfileFragment, ActivityIntentFactory activityIntentFactory) {
        userProfileFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.adapterPresenter")
    public static void injectAdapterPresenter(UserProfileFragment userProfileFragment, AdapterPresenter adapterPresenter) {
        userProfileFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.analytics")
    public static void injectAnalytics(UserProfileFragment userProfileFragment, Analytics analytics) {
        userProfileFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.cartFabViewModel")
    public static void injectCartFabViewModel(UserProfileFragment userProfileFragment, CartFabViewModel cartFabViewModel) {
        userProfileFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.cartQuantityHandler")
    public static void injectCartQuantityHandler(UserProfileFragment userProfileFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        userProfileFragment.cartQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserProfileFragment userProfileFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        userProfileFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.features")
    public static void injectFeatures(UserProfileFragment userProfileFragment, Features features) {
        userProfileFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(UserProfileFragment userProfileFragment, ImplicitIntentFactory implicitIntentFactory) {
        userProfileFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.interactor")
    public static void injectInteractor(UserProfileFragment userProfileFragment, UserProfileInteractor userProfileInteractor) {
        userProfileFragment.interactor = userProfileInteractor;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.itemBinder")
    public static void injectItemBinder(UserProfileFragment userProfileFragment, ItemBinder itemBinder) {
        userProfileFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.presenter")
    public static void injectPresenter(UserProfileFragment userProfileFragment, UserProfilePresenter userProfilePresenter) {
        userProfileFragment.presenter = userProfilePresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.tabTestGroup")
    public static void injectTabTestGroup(UserProfileFragment userProfileFragment, UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        userProfileFragment.tabTestGroup = userAdvertsTabTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.profile.UserProfileFragment.tracker")
    public static void injectTracker(UserProfileFragment userProfileFragment, UserProfileTracker userProfileTracker) {
        userProfileFragment.tracker = userProfileTracker;
    }

    public void injectMembers(UserProfileFragment userProfileFragment) {
        injectActivityIntentFactory(userProfileFragment, this.a.get());
        injectImplicitIntentFactory(userProfileFragment, this.b.get());
        injectDeepLinkIntentFactory(userProfileFragment, this.c.get());
        injectPresenter(userProfileFragment, this.d.get());
        injectInteractor(userProfileFragment, this.e.get());
        injectAdapterPresenter(userProfileFragment, this.f.get());
        injectItemBinder(userProfileFragment, this.g.get());
        injectFeatures(userProfileFragment, this.h.get());
        injectAnalytics(userProfileFragment, this.i.get());
        injectTracker(userProfileFragment, this.j.get());
        injectCartFabViewModel(userProfileFragment, this.k.get());
        injectCartQuantityHandler(userProfileFragment, this.l.get());
        injectTabTestGroup(userProfileFragment, this.m.get());
    }
}
