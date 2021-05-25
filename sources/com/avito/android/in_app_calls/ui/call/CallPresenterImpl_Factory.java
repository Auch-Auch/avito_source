package com.avito.android.in_app_calls.ui.call;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.in_app_calls.ui.CallInteractor;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallPresenterImpl_Factory implements Factory<CallPresenterImpl> {
    public final Provider<CallInteractor> a;
    public final Provider<Resources> b;
    public final Provider<Analytics> c;
    public final Provider<CallAnalyticsTracker> d;
    public final Provider<CallPermissionsManager> e;
    public final Provider<CallStorage> f;
    public final Provider<Features> g;
    public final Provider<TimeSource> h;
    public final Provider<CallEventTracker> i;
    public final Provider<ErrorTracker> j;
    public final Provider<AccountStateProvider> k;
    public final Provider<PermissionChecker> l;
    public final Provider<SchedulersFactory> m;

    public CallPresenterImpl_Factory(Provider<CallInteractor> provider, Provider<Resources> provider2, Provider<Analytics> provider3, Provider<CallAnalyticsTracker> provider4, Provider<CallPermissionsManager> provider5, Provider<CallStorage> provider6, Provider<Features> provider7, Provider<TimeSource> provider8, Provider<CallEventTracker> provider9, Provider<ErrorTracker> provider10, Provider<AccountStateProvider> provider11, Provider<PermissionChecker> provider12, Provider<SchedulersFactory> provider13) {
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

    public static CallPresenterImpl_Factory create(Provider<CallInteractor> provider, Provider<Resources> provider2, Provider<Analytics> provider3, Provider<CallAnalyticsTracker> provider4, Provider<CallPermissionsManager> provider5, Provider<CallStorage> provider6, Provider<Features> provider7, Provider<TimeSource> provider8, Provider<CallEventTracker> provider9, Provider<ErrorTracker> provider10, Provider<AccountStateProvider> provider11, Provider<PermissionChecker> provider12, Provider<SchedulersFactory> provider13) {
        return new CallPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static CallPresenterImpl newInstance(CallInteractor callInteractor, Resources resources, Analytics analytics, CallAnalyticsTracker callAnalyticsTracker, CallPermissionsManager callPermissionsManager, CallStorage callStorage, Features features, TimeSource timeSource, CallEventTracker callEventTracker, ErrorTracker errorTracker, AccountStateProvider accountStateProvider, PermissionChecker permissionChecker, SchedulersFactory schedulersFactory) {
        return new CallPresenterImpl(callInteractor, resources, analytics, callAnalyticsTracker, callPermissionsManager, callStorage, features, timeSource, callEventTracker, errorTracker, accountStateProvider, permissionChecker, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
