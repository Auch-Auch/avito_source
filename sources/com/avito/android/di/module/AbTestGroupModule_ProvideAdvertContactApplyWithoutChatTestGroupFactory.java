package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertContactApplyWithoutChatTestGroupFactory implements Factory<ExposedAbTestGroup<SimpleTestGroupWithNone>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertContactApplyWithoutChatTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertContactApplyWithoutChatTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertContactApplyWithoutChatTestGroupFactory(abTestGroupModule, provider);
    }

    public static ExposedAbTestGroup<SimpleTestGroupWithNone> provideAdvertContactApplyWithoutChatTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertContactApplyWithoutChatTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<SimpleTestGroupWithNone> get() {
        return provideAdvertContactApplyWithoutChatTestGroup(this.a, this.b.get());
    }
}
