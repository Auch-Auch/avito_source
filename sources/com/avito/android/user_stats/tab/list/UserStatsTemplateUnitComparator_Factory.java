package com.avito.android.user_stats.tab.list;

import dagger.internal.Factory;
public final class UserStatsTemplateUnitComparator_Factory implements Factory<UserStatsTemplateUnitComparator> {

    public static final class a {
        public static final UserStatsTemplateUnitComparator_Factory a = new UserStatsTemplateUnitComparator_Factory();
    }

    public static UserStatsTemplateUnitComparator_Factory create() {
        return a.a;
    }

    public static UserStatsTemplateUnitComparator newInstance() {
        return new UserStatsTemplateUnitComparator();
    }

    @Override // javax.inject.Provider
    public UserStatsTemplateUnitComparator get() {
        return newInstance();
    }
}
