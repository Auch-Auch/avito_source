package com.avito.android.public_profile.di;

import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublicProfileFragmentModule_ProvideTabsDataProviderFactory implements Factory<TabsDataProvider<BaseTabItem>> {

    public static final class a {
        public static final PublicProfileFragmentModule_ProvideTabsDataProviderFactory a = new PublicProfileFragmentModule_ProvideTabsDataProviderFactory();
    }

    public static PublicProfileFragmentModule_ProvideTabsDataProviderFactory create() {
        return a.a;
    }

    public static TabsDataProvider<BaseTabItem> provideTabsDataProvider() {
        return (TabsDataProvider) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.provideTabsDataProvider());
    }

    @Override // javax.inject.Provider
    public TabsDataProvider<BaseTabItem> get() {
        return provideTabsDataProvider();
    }
}
