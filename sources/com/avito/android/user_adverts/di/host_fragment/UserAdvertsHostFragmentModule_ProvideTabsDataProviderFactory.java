package com.avito.android.user_adverts.di.host_fragment;

import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_adverts.root_screen.adverts_host.TabItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsHostFragmentModule_ProvideTabsDataProviderFactory implements Factory<TabsDataProvider<TabItem>> {

    public static final class a {
        public static final UserAdvertsHostFragmentModule_ProvideTabsDataProviderFactory a = new UserAdvertsHostFragmentModule_ProvideTabsDataProviderFactory();
    }

    public static UserAdvertsHostFragmentModule_ProvideTabsDataProviderFactory create() {
        return a.a;
    }

    public static TabsDataProvider<TabItem> provideTabsDataProvider() {
        return (TabsDataProvider) Preconditions.checkNotNullFromProvides(UserAdvertsHostFragmentModule.provideTabsDataProvider());
    }

    @Override // javax.inject.Provider
    public TabsDataProvider<TabItem> get() {
        return provideTabsDataProvider();
    }
}
