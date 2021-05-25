package com.avito.android.in_app_calls.workers;

import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CallAvailabilityWorker_MembersInjector implements MembersInjector<CallAvailabilityWorker> {
    public final Provider<CallAvailabilityUpdater> a;
    public final Provider<Analytics> b;

    public CallAvailabilityWorker_MembersInjector(Provider<CallAvailabilityUpdater> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<CallAvailabilityWorker> create(Provider<CallAvailabilityUpdater> provider, Provider<Analytics> provider2) {
        return new CallAvailabilityWorker_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.workers.CallAvailabilityWorker.analytics")
    public static void injectAnalytics(CallAvailabilityWorker callAvailabilityWorker, Analytics analytics) {
        callAvailabilityWorker.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.workers.CallAvailabilityWorker.callAvailabilityUpdater")
    public static void injectCallAvailabilityUpdater(CallAvailabilityWorker callAvailabilityWorker, CallAvailabilityUpdater callAvailabilityUpdater) {
        callAvailabilityWorker.callAvailabilityUpdater = callAvailabilityUpdater;
    }

    public void injectMembers(CallAvailabilityWorker callAvailabilityWorker) {
        injectCallAvailabilityUpdater(callAvailabilityWorker, this.a.get());
        injectAnalytics(callAvailabilityWorker, this.b.get());
    }
}
