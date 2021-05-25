package com.avito.android.advert_core.contactbar;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertContactsInteractorImpl_Factory implements Factory<AdvertContactsInteractorImpl> {
    public final Provider<AsyncPhoneApi> a;
    public final Provider<CallsApi> b;
    public final Provider<NetworkTypeProvider> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<Formatter<String>> e;
    public final Provider<CallUuidProvider> f;
    public final Provider<AppCallsUsageTracker> g;
    public final Provider<Features> h;
    public final Provider<SchedulersFactory3> i;

    public AdvertContactsInteractorImpl_Factory(Provider<AsyncPhoneApi> provider, Provider<CallsApi> provider2, Provider<NetworkTypeProvider> provider3, Provider<AccountStateProvider> provider4, Provider<Formatter<String>> provider5, Provider<CallUuidProvider> provider6, Provider<AppCallsUsageTracker> provider7, Provider<Features> provider8, Provider<SchedulersFactory3> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static AdvertContactsInteractorImpl_Factory create(Provider<AsyncPhoneApi> provider, Provider<CallsApi> provider2, Provider<NetworkTypeProvider> provider3, Provider<AccountStateProvider> provider4, Provider<Formatter<String>> provider5, Provider<CallUuidProvider> provider6, Provider<AppCallsUsageTracker> provider7, Provider<Features> provider8, Provider<SchedulersFactory3> provider9) {
        return new AdvertContactsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static AdvertContactsInteractorImpl newInstance(AsyncPhoneApi asyncPhoneApi, CallsApi callsApi, NetworkTypeProvider networkTypeProvider, AccountStateProvider accountStateProvider, Formatter<String> formatter, CallUuidProvider callUuidProvider, AppCallsUsageTracker appCallsUsageTracker, Features features, SchedulersFactory3 schedulersFactory3) {
        return new AdvertContactsInteractorImpl(asyncPhoneApi, callsApi, networkTypeProvider, accountStateProvider, formatter, callUuidProvider, appCallsUsageTracker, features, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertContactsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
