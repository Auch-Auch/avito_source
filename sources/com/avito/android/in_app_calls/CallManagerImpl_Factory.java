package com.avito.android.in_app_calls;

import android.content.Context;
import com.avito.android.ab_tests.groups.CallsEarlyBeepsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.in_app_calls.analytics.CallPushHandlingTracker;
import com.avito.android.in_app_calls.service.SystemCallStateProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallManagerImpl_Factory implements Factory<CallManagerImpl> {
    public final Provider<Context> a;
    public final Provider<IncomingCallHandler> b;
    public final Provider<AvitoCallClient> c;
    public final Provider<CallRegistry> d;
    public final Provider<TimeSource> e;
    public final Provider<CallQualityIssueListener> f;
    public final Provider<CallPushHandlingTracker> g;
    public final Provider<SystemCallStateProvider> h;
    public final Provider<CallEventTracker> i;
    public final Provider<SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup>> j;
    public final Provider<SchedulersFactory> k;

    public CallManagerImpl_Factory(Provider<Context> provider, Provider<IncomingCallHandler> provider2, Provider<AvitoCallClient> provider3, Provider<CallRegistry> provider4, Provider<TimeSource> provider5, Provider<CallQualityIssueListener> provider6, Provider<CallPushHandlingTracker> provider7, Provider<SystemCallStateProvider> provider8, Provider<CallEventTracker> provider9, Provider<SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup>> provider10, Provider<SchedulersFactory> provider11) {
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

    public static CallManagerImpl_Factory create(Provider<Context> provider, Provider<IncomingCallHandler> provider2, Provider<AvitoCallClient> provider3, Provider<CallRegistry> provider4, Provider<TimeSource> provider5, Provider<CallQualityIssueListener> provider6, Provider<CallPushHandlingTracker> provider7, Provider<SystemCallStateProvider> provider8, Provider<CallEventTracker> provider9, Provider<SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup>> provider10, Provider<SchedulersFactory> provider11) {
        return new CallManagerImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static CallManagerImpl newInstance(Context context, IncomingCallHandler incomingCallHandler, AvitoCallClient avitoCallClient, CallRegistry callRegistry, TimeSource timeSource, CallQualityIssueListener callQualityIssueListener, CallPushHandlingTracker callPushHandlingTracker, SystemCallStateProvider systemCallStateProvider, CallEventTracker callEventTracker, SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> singleManuallyExposedAbTestGroup, SchedulersFactory schedulersFactory) {
        return new CallManagerImpl(context, incomingCallHandler, avitoCallClient, callRegistry, timeSource, callQualityIssueListener, callPushHandlingTracker, systemCallStateProvider, callEventTracker, singleManuallyExposedAbTestGroup, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallManagerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
