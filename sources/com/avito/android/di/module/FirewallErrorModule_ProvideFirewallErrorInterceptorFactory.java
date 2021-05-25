package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.interceptors.FirewallErrorInterceptor;
import com.avito.android.remote.interceptors.FirewallErrorRouter;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FirewallErrorModule_ProvideFirewallErrorInterceptorFactory implements Factory<FirewallErrorInterceptor> {
    public final Provider<Gson> a;
    public final Provider<FirewallErrorRouter> b;
    public final Provider<Analytics> c;

    public FirewallErrorModule_ProvideFirewallErrorInterceptorFactory(Provider<Gson> provider, Provider<FirewallErrorRouter> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FirewallErrorModule_ProvideFirewallErrorInterceptorFactory create(Provider<Gson> provider, Provider<FirewallErrorRouter> provider2, Provider<Analytics> provider3) {
        return new FirewallErrorModule_ProvideFirewallErrorInterceptorFactory(provider, provider2, provider3);
    }

    public static FirewallErrorInterceptor provideFirewallErrorInterceptor(Gson gson, FirewallErrorRouter firewallErrorRouter, Analytics analytics) {
        return (FirewallErrorInterceptor) Preconditions.checkNotNullFromProvides(FirewallErrorModule.provideFirewallErrorInterceptor(gson, firewallErrorRouter, analytics));
    }

    @Override // javax.inject.Provider
    public FirewallErrorInterceptor get() {
        return provideFirewallErrorInterceptor(this.a.get(), this.b.get(), this.c.get());
    }
}
