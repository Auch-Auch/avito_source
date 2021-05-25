package com.avito.android.express_cv.di;

import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ExpressCvModule_ProvideTabsDataProviderFactory implements Factory<TabsDataProvider<CvTabItem>> {
    public final ExpressCvModule a;

    public ExpressCvModule_ProvideTabsDataProviderFactory(ExpressCvModule expressCvModule) {
        this.a = expressCvModule;
    }

    public static ExpressCvModule_ProvideTabsDataProviderFactory create(ExpressCvModule expressCvModule) {
        return new ExpressCvModule_ProvideTabsDataProviderFactory(expressCvModule);
    }

    public static TabsDataProvider<CvTabItem> provideTabsDataProvider(ExpressCvModule expressCvModule) {
        return (TabsDataProvider) Preconditions.checkNotNullFromProvides(expressCvModule.provideTabsDataProvider());
    }

    @Override // javax.inject.Provider
    public TabsDataProvider<CvTabItem> get() {
        return provideTabsDataProvider(this.a);
    }
}
