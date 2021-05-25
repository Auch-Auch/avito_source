package com.avito.android.user_stats.navigation;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsIntentFactoryImpl_Factory implements Factory<UserStatsIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public UserStatsIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static UserStatsIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new UserStatsIntentFactoryImpl_Factory(provider);
    }

    public static UserStatsIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new UserStatsIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public UserStatsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
