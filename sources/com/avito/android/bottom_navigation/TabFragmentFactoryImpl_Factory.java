package com.avito.android.bottom_navigation;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class TabFragmentFactoryImpl_Factory implements Factory<TabFragmentFactoryImpl> {
    public final Provider<Set<NavigationTabFragmentFactory>> a;
    public final Provider<Set<DataTabFragmentFactory>> b;

    public TabFragmentFactoryImpl_Factory(Provider<Set<NavigationTabFragmentFactory>> provider, Provider<Set<DataTabFragmentFactory>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TabFragmentFactoryImpl_Factory create(Provider<Set<NavigationTabFragmentFactory>> provider, Provider<Set<DataTabFragmentFactory>> provider2) {
        return new TabFragmentFactoryImpl_Factory(provider, provider2);
    }

    public static TabFragmentFactoryImpl newInstance(Set<NavigationTabFragmentFactory> set, Set<DataTabFragmentFactory> set2) {
        return new TabFragmentFactoryImpl(set, set2);
    }

    @Override // javax.inject.Provider
    public TabFragmentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
