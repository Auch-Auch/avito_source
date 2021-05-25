package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsNoCallFeedbackTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsNoCallFeedbackTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsNoCallFeedbackTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsNoCallFeedbackTestGroupFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> provideAdvertDetailsNoCallFeedbackTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsNoCallFeedbackTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> get() {
        return provideAdvertDetailsNoCallFeedbackTestGroup(this.a, this.b.get());
    }
}
