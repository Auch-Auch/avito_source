package com.avito.android.user_stats.tab;

import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.model.UserStatsTabData;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsTabInteractorImpl_Factory implements Factory<UserStatsTabInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<UserStatsTabData> b;
    public final Provider<UserStatsTemplateItemConverter> c;

    public UserStatsTabInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<UserStatsTabData> provider2, Provider<UserStatsTemplateItemConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserStatsTabInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<UserStatsTabData> provider2, Provider<UserStatsTemplateItemConverter> provider3) {
        return new UserStatsTabInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UserStatsTabInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, UserStatsTabData userStatsTabData, UserStatsTemplateItemConverter userStatsTemplateItemConverter) {
        return new UserStatsTabInteractorImpl(schedulersFactory3, userStatsTabData, userStatsTemplateItemConverter);
    }

    @Override // javax.inject.Provider
    public UserStatsTabInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
