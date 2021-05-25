package com.avito.android.public_profile;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublicProfileFragment_MembersInjector implements MembersInjector<PublicProfileFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<PublicProfilePresenter> d;
    public final Provider<SubscriptionsPresenter> e;
    public final Provider<CompositeSnackbarPresenter> f;
    public final Provider<TabsDataProvider<BaseTabItem>> g;
    public final Provider<TabLayoutAdapter<BaseTabItem>> h;
    public final Provider<TabPagerAdapter> i;
    public final Provider<Analytics> j;
    public final Provider<PublicProfileTracker> k;
    public final Provider<Features> l;

    public PublicProfileFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<PublicProfilePresenter> provider4, Provider<SubscriptionsPresenter> provider5, Provider<CompositeSnackbarPresenter> provider6, Provider<TabsDataProvider<BaseTabItem>> provider7, Provider<TabLayoutAdapter<BaseTabItem>> provider8, Provider<TabPagerAdapter> provider9, Provider<Analytics> provider10, Provider<PublicProfileTracker> provider11, Provider<Features> provider12) {
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
    }

    public static MembersInjector<PublicProfileFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<PublicProfilePresenter> provider4, Provider<SubscriptionsPresenter> provider5, Provider<CompositeSnackbarPresenter> provider6, Provider<TabsDataProvider<BaseTabItem>> provider7, Provider<TabLayoutAdapter<BaseTabItem>> provider8, Provider<TabPagerAdapter> provider9, Provider<Analytics> provider10, Provider<PublicProfileTracker> provider11, Provider<Features> provider12) {
        return new PublicProfileFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PublicProfileFragment publicProfileFragment, ActivityIntentFactory activityIntentFactory) {
        publicProfileFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.analytics")
    public static void injectAnalytics(PublicProfileFragment publicProfileFragment, Analytics analytics) {
        publicProfileFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PublicProfileFragment publicProfileFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        publicProfileFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.features")
    public static void injectFeatures(PublicProfileFragment publicProfileFragment, Features features) {
        publicProfileFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(PublicProfileFragment publicProfileFragment, ImplicitIntentFactory implicitIntentFactory) {
        publicProfileFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.pagerAdapter")
    public static void injectPagerAdapter(PublicProfileFragment publicProfileFragment, TabPagerAdapter tabPagerAdapter) {
        publicProfileFragment.pagerAdapter = tabPagerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.publicProfilePresenter")
    public static void injectPublicProfilePresenter(PublicProfileFragment publicProfileFragment, PublicProfilePresenter publicProfilePresenter) {
        publicProfileFragment.publicProfilePresenter = publicProfilePresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(PublicProfileFragment publicProfileFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        publicProfileFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.subscriptionsPresenter")
    public static void injectSubscriptionsPresenter(PublicProfileFragment publicProfileFragment, SubscriptionsPresenter subscriptionsPresenter) {
        publicProfileFragment.subscriptionsPresenter = subscriptionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.tabLayoutAdapter")
    public static void injectTabLayoutAdapter(PublicProfileFragment publicProfileFragment, TabLayoutAdapter<BaseTabItem> tabLayoutAdapter) {
        publicProfileFragment.tabLayoutAdapter = tabLayoutAdapter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.tabsDataProvider")
    public static void injectTabsDataProvider(PublicProfileFragment publicProfileFragment, TabsDataProvider<BaseTabItem> tabsDataProvider) {
        publicProfileFragment.tabsDataProvider = tabsDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.PublicProfileFragment.tracker")
    public static void injectTracker(PublicProfileFragment publicProfileFragment, PublicProfileTracker publicProfileTracker) {
        publicProfileFragment.tracker = publicProfileTracker;
    }

    public void injectMembers(PublicProfileFragment publicProfileFragment) {
        injectDeepLinkIntentFactory(publicProfileFragment, this.a.get());
        injectActivityIntentFactory(publicProfileFragment, this.b.get());
        injectImplicitIntentFactory(publicProfileFragment, this.c.get());
        injectPublicProfilePresenter(publicProfileFragment, this.d.get());
        injectSubscriptionsPresenter(publicProfileFragment, this.e.get());
        injectSnackbarPresenter(publicProfileFragment, this.f.get());
        injectTabsDataProvider(publicProfileFragment, this.g.get());
        injectTabLayoutAdapter(publicProfileFragment, this.h.get());
        injectPagerAdapter(publicProfileFragment, this.i.get());
        injectAnalytics(publicProfileFragment, this.j.get());
        injectTracker(publicProfileFragment, this.k.get());
        injectFeatures(publicProfileFragment, this.l.get());
    }
}
