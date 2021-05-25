package com.avito.android.public_profile.di;

import androidx.fragment.app.FragmentManager;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublicProfileFragmentModule_ProvideTabPagerAdapterProviderFactory implements Factory<TabPagerAdapter> {
    public final Provider<FragmentManager> a;
    public final Provider<TabsDataProvider<BaseTabItem>> b;
    public final Provider<Set<TabBlueprint<? extends BaseTabItem>>> c;

    public PublicProfileFragmentModule_ProvideTabPagerAdapterProviderFactory(Provider<FragmentManager> provider, Provider<TabsDataProvider<BaseTabItem>> provider2, Provider<Set<TabBlueprint<? extends BaseTabItem>>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublicProfileFragmentModule_ProvideTabPagerAdapterProviderFactory create(Provider<FragmentManager> provider, Provider<TabsDataProvider<BaseTabItem>> provider2, Provider<Set<TabBlueprint<? extends BaseTabItem>>> provider3) {
        return new PublicProfileFragmentModule_ProvideTabPagerAdapterProviderFactory(provider, provider2, provider3);
    }

    public static TabPagerAdapter provideTabPagerAdapterProvider(FragmentManager fragmentManager, TabsDataProvider<BaseTabItem> tabsDataProvider, Set<TabBlueprint<? extends BaseTabItem>> set) {
        return (TabPagerAdapter) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.provideTabPagerAdapterProvider(fragmentManager, tabsDataProvider, set));
    }

    @Override // javax.inject.Provider
    public TabPagerAdapter get() {
        return provideTabPagerAdapterProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
