package com.avito.android.brandspace.di;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BrandspaceFragmentModule_ProvideTreeParent$brandspace_releaseFactory implements Factory<TreeClickStreamParent> {
    public final Provider<BrandspaceAnalyticsInteractor> a;

    public BrandspaceFragmentModule_ProvideTreeParent$brandspace_releaseFactory(Provider<BrandspaceAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static BrandspaceFragmentModule_ProvideTreeParent$brandspace_releaseFactory create(Provider<BrandspaceAnalyticsInteractor> provider) {
        return new BrandspaceFragmentModule_ProvideTreeParent$brandspace_releaseFactory(provider);
    }

    public static TreeClickStreamParent provideTreeParent$brandspace_release(BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return (TreeClickStreamParent) Preconditions.checkNotNullFromProvides(BrandspaceFragmentModule.INSTANCE.provideTreeParent$brandspace_release(brandspaceAnalyticsInteractor));
    }

    @Override // javax.inject.Provider
    public TreeClickStreamParent get() {
        return provideTreeParent$brandspace_release(this.a.get());
    }
}
