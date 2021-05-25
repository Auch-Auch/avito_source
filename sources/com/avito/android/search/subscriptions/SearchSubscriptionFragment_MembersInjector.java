package com.avito.android.search.subscriptions;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.tracker.SearchSubscriptionsTracker;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SearchSubscriptionFragment_MembersInjector implements MembersInjector<SearchSubscriptionFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<SearchSubscriptionPresenter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<Features> e;
    public final Provider<Analytics> f;
    public final Provider<SearchSubscriptionsTracker> g;
    public final Provider<ImplicitIntentFactory> h;
    public final Provider<NotificationManagerProvider> i;
    public final Provider<DeepLinkIntentFactory> j;
    public final Provider<SavedSearchesPresenter> k;

    public SearchSubscriptionFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<SearchSubscriptionPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<Features> provider5, Provider<Analytics> provider6, Provider<SearchSubscriptionsTracker> provider7, Provider<ImplicitIntentFactory> provider8, Provider<NotificationManagerProvider> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<SavedSearchesPresenter> provider11) {
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

    public static MembersInjector<SearchSubscriptionFragment> create(Provider<ActivityIntentFactory> provider, Provider<SearchSubscriptionPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<Features> provider5, Provider<Analytics> provider6, Provider<SearchSubscriptionsTracker> provider7, Provider<ImplicitIntentFactory> provider8, Provider<NotificationManagerProvider> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<SavedSearchesPresenter> provider11) {
        return new SearchSubscriptionFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SearchSubscriptionFragment searchSubscriptionFragment, ActivityIntentFactory activityIntentFactory) {
        searchSubscriptionFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.adapterPresenter")
    public static void injectAdapterPresenter(SearchSubscriptionFragment searchSubscriptionFragment, AdapterPresenter adapterPresenter) {
        searchSubscriptionFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.analytics")
    public static void injectAnalytics(SearchSubscriptionFragment searchSubscriptionFragment, Analytics analytics) {
        searchSubscriptionFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SearchSubscriptionFragment searchSubscriptionFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        searchSubscriptionFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.features")
    public static void injectFeatures(SearchSubscriptionFragment searchSubscriptionFragment, Features features) {
        searchSubscriptionFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(SearchSubscriptionFragment searchSubscriptionFragment, ImplicitIntentFactory implicitIntentFactory) {
        searchSubscriptionFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.itemBinder")
    public static void injectItemBinder(SearchSubscriptionFragment searchSubscriptionFragment, ItemBinder itemBinder) {
        searchSubscriptionFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.notificationManagerProvider")
    public static void injectNotificationManagerProvider(SearchSubscriptionFragment searchSubscriptionFragment, NotificationManagerProvider notificationManagerProvider) {
        searchSubscriptionFragment.notificationManagerProvider = notificationManagerProvider;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.presenter")
    public static void injectPresenter(SearchSubscriptionFragment searchSubscriptionFragment, SearchSubscriptionPresenter searchSubscriptionPresenter) {
        searchSubscriptionFragment.presenter = searchSubscriptionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.savedSearchPresenter")
    public static void injectSavedSearchPresenter(SearchSubscriptionFragment searchSubscriptionFragment, SavedSearchesPresenter savedSearchesPresenter) {
        searchSubscriptionFragment.savedSearchPresenter = savedSearchesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionFragment.tracker")
    public static void injectTracker(SearchSubscriptionFragment searchSubscriptionFragment, SearchSubscriptionsTracker searchSubscriptionsTracker) {
        searchSubscriptionFragment.tracker = searchSubscriptionsTracker;
    }

    public void injectMembers(SearchSubscriptionFragment searchSubscriptionFragment) {
        injectActivityIntentFactory(searchSubscriptionFragment, this.a.get());
        injectPresenter(searchSubscriptionFragment, this.b.get());
        injectAdapterPresenter(searchSubscriptionFragment, this.c.get());
        injectItemBinder(searchSubscriptionFragment, this.d.get());
        injectFeatures(searchSubscriptionFragment, this.e.get());
        injectAnalytics(searchSubscriptionFragment, this.f.get());
        injectTracker(searchSubscriptionFragment, this.g.get());
        injectImplicitIntentFactory(searchSubscriptionFragment, this.h.get());
        injectNotificationManagerProvider(searchSubscriptionFragment, this.i.get());
        injectDeepLinkIntentFactory(searchSubscriptionFragment, this.j.get());
        injectSavedSearchPresenter(searchSubscriptionFragment, this.k.get());
    }
}
