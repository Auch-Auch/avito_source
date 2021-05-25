package com.avito.android.profile.sessions.list;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SessionsListFragment_MembersInjector implements MembersInjector<SessionsListFragment> {
    public final Provider<SessionsListPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Analytics> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<CompositeSnackbarPresenter> f;

    public SessionsListFragment_MembersInjector(Provider<SessionsListPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<ActivityIntentFactory> provider5, Provider<CompositeSnackbarPresenter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<SessionsListFragment> create(Provider<SessionsListPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<ActivityIntentFactory> provider5, Provider<CompositeSnackbarPresenter> provider6) {
        return new SessionsListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SessionsListFragment sessionsListFragment, ActivityIntentFactory activityIntentFactory) {
        sessionsListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.adapterPresenter")
    public static void injectAdapterPresenter(SessionsListFragment sessionsListFragment, AdapterPresenter adapterPresenter) {
        sessionsListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.analytics")
    public static void injectAnalytics(SessionsListFragment sessionsListFragment, Analytics analytics) {
        sessionsListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.itemBinder")
    public static void injectItemBinder(SessionsListFragment sessionsListFragment, ItemBinder itemBinder) {
        sessionsListFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.presenter")
    public static void injectPresenter(SessionsListFragment sessionsListFragment, SessionsListPresenter sessionsListPresenter) {
        sessionsListFragment.presenter = sessionsListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.list.SessionsListFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(SessionsListFragment sessionsListFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        sessionsListFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    public void injectMembers(SessionsListFragment sessionsListFragment) {
        injectPresenter(sessionsListFragment, this.a.get());
        injectAdapterPresenter(sessionsListFragment, this.b.get());
        injectItemBinder(sessionsListFragment, this.c.get());
        injectAnalytics(sessionsListFragment, this.d.get());
        injectActivityIntentFactory(sessionsListFragment, this.e.get());
        injectSnackbarPresenter(sessionsListFragment, this.f.get());
    }
}
