package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideSellerInfoInRichSnippetTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideSellerInfoInRichSnippetTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideSellerInfoInRichSnippetTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideSellerInfoInRichSnippetTestGroupFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> provideSellerInfoInRichSnippetTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideSellerInfoInRichSnippetTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> get() {
        return provideSellerInfoInRichSnippetTestGroup(this.a, this.b.get());
    }
}
