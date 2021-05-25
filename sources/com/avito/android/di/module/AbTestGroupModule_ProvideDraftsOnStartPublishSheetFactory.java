package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideDraftsOnStartPublishSheetFactory implements Factory<ManuallyExposedAbTestGroup<SimpleTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideDraftsOnStartPublishSheetFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideDraftsOnStartPublishSheetFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideDraftsOnStartPublishSheetFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<SimpleTestGroup> provideDraftsOnStartPublishSheet(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideDraftsOnStartPublishSheet(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<SimpleTestGroup> get() {
        return provideDraftsOnStartPublishSheet(this.a, this.b.get());
    }
}
