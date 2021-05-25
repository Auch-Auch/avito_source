package com.avito.android.user_stats.tab.list.items;

import dagger.internal.Factory;
public final class UserStatsTemplateUnitPayloadCreator_Factory implements Factory<UserStatsTemplateUnitPayloadCreator> {

    public static final class a {
        public static final UserStatsTemplateUnitPayloadCreator_Factory a = new UserStatsTemplateUnitPayloadCreator_Factory();
    }

    public static UserStatsTemplateUnitPayloadCreator_Factory create() {
        return a.a;
    }

    public static UserStatsTemplateUnitPayloadCreator newInstance() {
        return new UserStatsTemplateUnitPayloadCreator();
    }

    @Override // javax.inject.Provider
    public UserStatsTemplateUnitPayloadCreator get() {
        return newInstance();
    }
}
