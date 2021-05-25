package com.avito.android.brandspace.router;

import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.navigation.NavigationTabProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceIntentFactoryImpl_Factory implements Factory<BrandspaceIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;
    public final Provider<NavigationTabProvider> b;

    public BrandspaceIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider, Provider<NavigationTabProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BrandspaceIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider, Provider<NavigationTabProvider> provider2) {
        return new BrandspaceIntentFactoryImpl_Factory(provider, provider2);
    }

    public static BrandspaceIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory, NavigationTabProvider navigationTabProvider) {
        return new BrandspaceIntentFactoryImpl(coreActivityIntentFactory, navigationTabProvider);
    }

    @Override // javax.inject.Provider
    public BrandspaceIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
