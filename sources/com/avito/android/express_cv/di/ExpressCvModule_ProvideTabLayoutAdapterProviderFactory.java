package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.CvTabLayoutAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideTabLayoutAdapterProviderFactory implements Factory<CvTabLayoutAdapter> {
    public final ExpressCvModule a;
    public final Provider<TabsDataProvider<CvTabItem>> b;
    public final Provider<DeviceMetrics> c;
    public final Provider<Activity> d;

    public ExpressCvModule_ProvideTabLayoutAdapterProviderFactory(ExpressCvModule expressCvModule, Provider<TabsDataProvider<CvTabItem>> provider, Provider<DeviceMetrics> provider2, Provider<Activity> provider3) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ExpressCvModule_ProvideTabLayoutAdapterProviderFactory create(ExpressCvModule expressCvModule, Provider<TabsDataProvider<CvTabItem>> provider, Provider<DeviceMetrics> provider2, Provider<Activity> provider3) {
        return new ExpressCvModule_ProvideTabLayoutAdapterProviderFactory(expressCvModule, provider, provider2, provider3);
    }

    public static CvTabLayoutAdapter provideTabLayoutAdapterProvider(ExpressCvModule expressCvModule, TabsDataProvider<CvTabItem> tabsDataProvider, DeviceMetrics deviceMetrics, Activity activity) {
        return (CvTabLayoutAdapter) Preconditions.checkNotNullFromProvides(expressCvModule.provideTabLayoutAdapterProvider(tabsDataProvider, deviceMetrics, activity));
    }

    @Override // javax.inject.Provider
    public CvTabLayoutAdapter get() {
        return provideTabLayoutAdapterProvider(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
