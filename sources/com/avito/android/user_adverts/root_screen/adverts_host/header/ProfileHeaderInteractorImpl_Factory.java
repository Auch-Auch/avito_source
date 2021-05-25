package com.avito.android.user_adverts.root_screen.adverts_host.header;

import com.avito.android.server_time.TimeSource;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileHeaderInteractorImpl_Factory implements Factory<ProfileHeaderInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Formatter<String>> c;
    public final Provider<SoaPopupSessionStorage> d;
    public final Provider<ProfileHeaderResourceProvider> e;
    public final Provider<SmbStatsTooltipSessionStorage> f;
    public final Provider<TimeSource> g;

    public ProfileHeaderInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<Formatter<String>> provider3, Provider<SoaPopupSessionStorage> provider4, Provider<ProfileHeaderResourceProvider> provider5, Provider<SmbStatsTooltipSessionStorage> provider6, Provider<TimeSource> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ProfileHeaderInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<Formatter<String>> provider3, Provider<SoaPopupSessionStorage> provider4, Provider<ProfileHeaderResourceProvider> provider5, Provider<SmbStatsTooltipSessionStorage> provider6, Provider<TimeSource> provider7) {
        return new ProfileHeaderInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ProfileHeaderInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, SchedulersFactory schedulersFactory, Formatter<String> formatter, SoaPopupSessionStorage soaPopupSessionStorage, ProfileHeaderResourceProvider profileHeaderResourceProvider, SmbStatsTooltipSessionStorage smbStatsTooltipSessionStorage, TimeSource timeSource) {
        return new ProfileHeaderInteractorImpl(userAdvertsApi, schedulersFactory, formatter, soaPopupSessionStorage, profileHeaderResourceProvider, smbStatsTooltipSessionStorage, timeSource);
    }

    @Override // javax.inject.Provider
    public ProfileHeaderInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
