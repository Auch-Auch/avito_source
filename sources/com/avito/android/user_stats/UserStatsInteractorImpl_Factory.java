package com.avito.android.user_stats;

import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.UserStatsApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsInteractorImpl_Factory implements Factory<UserStatsInteractorImpl> {
    public final Provider<UserStatsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<SmbStatsTooltipSessionStorage> c;

    public UserStatsInteractorImpl_Factory(Provider<UserStatsApi> provider, Provider<SchedulersFactory3> provider2, Provider<SmbStatsTooltipSessionStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserStatsInteractorImpl_Factory create(Provider<UserStatsApi> provider, Provider<SchedulersFactory3> provider2, Provider<SmbStatsTooltipSessionStorage> provider3) {
        return new UserStatsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UserStatsInteractorImpl newInstance(UserStatsApi userStatsApi, SchedulersFactory3 schedulersFactory3, SmbStatsTooltipSessionStorage smbStatsTooltipSessionStorage) {
        return new UserStatsInteractorImpl(userStatsApi, schedulersFactory3, smbStatsTooltipSessionStorage);
    }

    @Override // javax.inject.Provider
    public UserStatsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
