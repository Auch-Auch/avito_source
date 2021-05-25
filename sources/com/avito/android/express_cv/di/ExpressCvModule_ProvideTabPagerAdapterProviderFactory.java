package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.TabPagerAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideTabPagerAdapterProviderFactory implements Factory<TabPagerAdapter> {
    public final ExpressCvModule a;
    public final Provider<TabsDataProvider<CvTabItem>> b;
    public final Provider<Activity> c;

    public ExpressCvModule_ProvideTabPagerAdapterProviderFactory(ExpressCvModule expressCvModule, Provider<TabsDataProvider<CvTabItem>> provider, Provider<Activity> provider2) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ExpressCvModule_ProvideTabPagerAdapterProviderFactory create(ExpressCvModule expressCvModule, Provider<TabsDataProvider<CvTabItem>> provider, Provider<Activity> provider2) {
        return new ExpressCvModule_ProvideTabPagerAdapterProviderFactory(expressCvModule, provider, provider2);
    }

    public static TabPagerAdapter provideTabPagerAdapterProvider(ExpressCvModule expressCvModule, TabsDataProvider<CvTabItem> tabsDataProvider, Activity activity) {
        return (TabPagerAdapter) Preconditions.checkNotNullFromProvides(expressCvModule.provideTabPagerAdapterProvider(tabsDataProvider, activity));
    }

    @Override // javax.inject.Provider
    public TabPagerAdapter get() {
        return provideTabPagerAdapterProvider(this.a, this.b.get(), this.c.get());
    }
}
