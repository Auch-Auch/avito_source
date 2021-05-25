package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_AdvertAutotekaTeaserInGalleryTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_AdvertAutotekaTeaserInGalleryTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> advertAutotekaTeaserInGalleryTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.advertAutotekaTeaserInGalleryTestGroup(abTestsConfigProvider));
    }

    public static AbTestGroupModule_AdvertAutotekaTeaserInGalleryTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_AdvertAutotekaTeaserInGalleryTestGroupFactory(abTestGroupModule, provider);
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> get() {
        return advertAutotekaTeaserInGalleryTestGroup(this.a, this.b.get());
    }
}
