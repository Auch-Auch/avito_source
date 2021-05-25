package com.avito.android.user_stats;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsResourcesProviderImpl_Factory implements Factory<UserStatsResourcesProviderImpl> {
    public final Provider<Resources> a;

    public UserStatsResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static UserStatsResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new UserStatsResourcesProviderImpl_Factory(provider);
    }

    public static UserStatsResourcesProviderImpl newInstance(Resources resources) {
        return new UserStatsResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public UserStatsResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
