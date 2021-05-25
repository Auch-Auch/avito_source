package com.avito.android.notification_center.landing.unified.advert;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class UnifiedAdvertBlueprint_Factory implements Factory<UnifiedAdvertBlueprint> {
    public final Provider<UnifiedAdvertPresenter> a;
    public final Provider<Locale> b;
    public final Provider<TimeSource> c;
    public final Provider<ConnectivityProvider> d;

    public UnifiedAdvertBlueprint_Factory(Provider<UnifiedAdvertPresenter> provider, Provider<Locale> provider2, Provider<TimeSource> provider3, Provider<ConnectivityProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UnifiedAdvertBlueprint_Factory create(Provider<UnifiedAdvertPresenter> provider, Provider<Locale> provider2, Provider<TimeSource> provider3, Provider<ConnectivityProvider> provider4) {
        return new UnifiedAdvertBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static UnifiedAdvertBlueprint newInstance(UnifiedAdvertPresenter unifiedAdvertPresenter, Locale locale, TimeSource timeSource, ConnectivityProvider connectivityProvider) {
        return new UnifiedAdvertBlueprint(unifiedAdvertPresenter, locale, timeSource, connectivityProvider);
    }

    @Override // javax.inject.Provider
    public UnifiedAdvertBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
