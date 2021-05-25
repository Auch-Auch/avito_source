package com.avito.android.brandspace.router;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.ui.fragments.TabBaseFragment;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceRouterImpl_Factory implements Factory<BrandspaceRouterImpl> {
    public final Provider<TabBaseFragment> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;

    public BrandspaceRouterImpl_Factory(Provider<TabBaseFragment> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BrandspaceRouterImpl_Factory create(Provider<TabBaseFragment> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new BrandspaceRouterImpl_Factory(provider, provider2, provider3);
    }

    public static BrandspaceRouterImpl newInstance(TabBaseFragment tabBaseFragment, ActivityIntentFactory activityIntentFactory, DeepLinkIntentFactory deepLinkIntentFactory) {
        return new BrandspaceRouterImpl(tabBaseFragment, activityIntentFactory, deepLinkIntentFactory);
    }

    @Override // javax.inject.Provider
    public BrandspaceRouterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
