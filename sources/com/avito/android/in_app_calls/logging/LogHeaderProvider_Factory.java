package com.avito.android.in_app_calls.logging;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LogHeaderProvider_Factory implements Factory<LogHeaderProvider> {
    public final Provider<AccountStateProvider> a;
    public final Provider<DeviceIdProvider> b;
    public final Provider<BuildInfo> c;
    public final Provider<Features> d;

    public LogHeaderProvider_Factory(Provider<AccountStateProvider> provider, Provider<DeviceIdProvider> provider2, Provider<BuildInfo> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static LogHeaderProvider_Factory create(Provider<AccountStateProvider> provider, Provider<DeviceIdProvider> provider2, Provider<BuildInfo> provider3, Provider<Features> provider4) {
        return new LogHeaderProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static LogHeaderProvider newInstance(AccountStateProvider accountStateProvider, DeviceIdProvider deviceIdProvider, BuildInfo buildInfo, Features features) {
        return new LogHeaderProvider(accountStateProvider, deviceIdProvider, buildInfo, features);
    }

    @Override // javax.inject.Provider
    public LogHeaderProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
