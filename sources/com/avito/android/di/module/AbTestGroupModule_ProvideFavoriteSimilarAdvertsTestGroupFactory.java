package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideFavoriteSimilarAdvertsTestGroupFactory implements Factory<ExposedAbTestGroup<SimpleTestGroupWithNone>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideFavoriteSimilarAdvertsTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideFavoriteSimilarAdvertsTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideFavoriteSimilarAdvertsTestGroupFactory(abTestGroupModule, provider);
    }

    public static ExposedAbTestGroup<SimpleTestGroupWithNone> provideFavoriteSimilarAdvertsTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideFavoriteSimilarAdvertsTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<SimpleTestGroupWithNone> get() {
        return provideFavoriteSimilarAdvertsTestGroup(this.a, this.b.get());
    }
}
