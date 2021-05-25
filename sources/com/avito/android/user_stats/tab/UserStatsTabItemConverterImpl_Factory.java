package com.avito.android.user_stats.tab;

import dagger.internal.Factory;
public final class UserStatsTabItemConverterImpl_Factory implements Factory<UserStatsTabItemConverterImpl> {

    public static final class a {
        public static final UserStatsTabItemConverterImpl_Factory a = new UserStatsTabItemConverterImpl_Factory();
    }

    public static UserStatsTabItemConverterImpl_Factory create() {
        return a.a;
    }

    public static UserStatsTabItemConverterImpl newInstance() {
        return new UserStatsTabItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public UserStatsTabItemConverterImpl get() {
        return newInstance();
    }
}
