package com.avito.android.di.module;

import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_UserAdvertsTabTestGroupFactory implements Factory<UserAdvertsTabTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> b;

    public AbTestGroupModule_UserAdvertsTabTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_UserAdvertsTabTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> provider) {
        return new AbTestGroupModule_UserAdvertsTabTestGroupFactory(abTestGroupModule, provider);
    }

    public static UserAdvertsTabTestGroup userAdvertsTabTestGroup(AbTestGroupModule abTestGroupModule, SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> singleManuallyExposedAbTestGroup) {
        return (UserAdvertsTabTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.userAdvertsTabTestGroup(singleManuallyExposedAbTestGroup));
    }

    @Override // javax.inject.Provider
    public UserAdvertsTabTestGroup get() {
        return userAdvertsTabTestGroup(this.a, this.b.get());
    }
}
