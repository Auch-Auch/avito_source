package com.avito.android.in_app_calls.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.OneTimeLoginCredentialsProvider;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.push.provider.GcmPushTokenProvider;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideVoxCallClientFactory implements Factory<AvitoCallClient> {
    public final InAppCallsModule a;
    public final Provider<Context> b;
    public final Provider<CredentialsStorage> c;
    public final Provider<CallStorage> d;
    public final Provider<OneTimeLoginCredentialsProvider> e;
    public final Provider<UsernameProvider> f;
    public final Provider<CallAnalyticsTracker> g;
    public final Provider<GcmPushTokenProvider> h;
    public final Provider<CallClientAvailabilityNotifier> i;
    public final Provider<BuildInfo> j;
    public final Provider<Features> k;

    public InAppCallsModule_ProvideVoxCallClientFactory(InAppCallsModule inAppCallsModule, Provider<Context> provider, Provider<CredentialsStorage> provider2, Provider<CallStorage> provider3, Provider<OneTimeLoginCredentialsProvider> provider4, Provider<UsernameProvider> provider5, Provider<CallAnalyticsTracker> provider6, Provider<GcmPushTokenProvider> provider7, Provider<CallClientAvailabilityNotifier> provider8, Provider<BuildInfo> provider9, Provider<Features> provider10) {
        this.a = inAppCallsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
    }

    public static InAppCallsModule_ProvideVoxCallClientFactory create(InAppCallsModule inAppCallsModule, Provider<Context> provider, Provider<CredentialsStorage> provider2, Provider<CallStorage> provider3, Provider<OneTimeLoginCredentialsProvider> provider4, Provider<UsernameProvider> provider5, Provider<CallAnalyticsTracker> provider6, Provider<GcmPushTokenProvider> provider7, Provider<CallClientAvailabilityNotifier> provider8, Provider<BuildInfo> provider9, Provider<Features> provider10) {
        return new InAppCallsModule_ProvideVoxCallClientFactory(inAppCallsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AvitoCallClient provideVoxCallClient(InAppCallsModule inAppCallsModule, Context context, CredentialsStorage credentialsStorage, CallStorage callStorage, OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider, UsernameProvider usernameProvider, CallAnalyticsTracker callAnalyticsTracker, GcmPushTokenProvider gcmPushTokenProvider, CallClientAvailabilityNotifier callClientAvailabilityNotifier, BuildInfo buildInfo, Features features) {
        return (AvitoCallClient) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideVoxCallClient(context, credentialsStorage, callStorage, oneTimeLoginCredentialsProvider, usernameProvider, callAnalyticsTracker, gcmPushTokenProvider, callClientAvailabilityNotifier, buildInfo, features));
    }

    @Override // javax.inject.Provider
    public AvitoCallClient get() {
        return provideVoxCallClient(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
