package com.avito.android.brandspace_entry_point.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory implements Factory<BrandspaceEntryPointAnalyticsInteractor> {
    public final BrandspaceEntryPointInteractorModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory(BrandspaceEntryPointInteractorModule brandspaceEntryPointInteractorModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = brandspaceEntryPointInteractorModule;
        this.b = provider;
        this.c = provider2;
    }

    public static BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory create(BrandspaceEntryPointInteractorModule brandspaceEntryPointInteractorModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory(brandspaceEntryPointInteractorModule, provider, provider2);
    }

    public static BrandspaceEntryPointAnalyticsInteractor provideBrandspaceEntryPointAnalyticsInteractor(BrandspaceEntryPointInteractorModule brandspaceEntryPointInteractorModule, Analytics analytics, Features features) {
        return (BrandspaceEntryPointAnalyticsInteractor) Preconditions.checkNotNullFromProvides(brandspaceEntryPointInteractorModule.provideBrandspaceEntryPointAnalyticsInteractor(analytics, features));
    }

    @Override // javax.inject.Provider
    public BrandspaceEntryPointAnalyticsInteractor get() {
        return provideBrandspaceEntryPointAnalyticsInteractor(this.a, this.b.get(), this.c.get());
    }
}
