package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAntifraudStartupBannerTestGroupFactory implements Factory<AntifraudStartupBannerTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAntifraudStartupBannerTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAntifraudStartupBannerTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAntifraudStartupBannerTestGroupFactory(abTestGroupModule, provider);
    }

    public static AntifraudStartupBannerTestGroup provideAntifraudStartupBannerTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (AntifraudStartupBannerTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAntifraudStartupBannerTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public AntifraudStartupBannerTestGroup get() {
        return provideAntifraudStartupBannerTestGroup(this.a, this.b.get());
    }
}
