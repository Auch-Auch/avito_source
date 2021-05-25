package com.avito.android.item_report.di;

import com.avito.android.item_report.remote.ItemReportApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ItemReportApiModule_ProvideItemReportApiFactory implements Factory<ItemReportApi> {
    public final Provider<RetrofitFactory> a;

    public ItemReportApiModule_ProvideItemReportApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ItemReportApiModule_ProvideItemReportApiFactory create(Provider<RetrofitFactory> provider) {
        return new ItemReportApiModule_ProvideItemReportApiFactory(provider);
    }

    public static ItemReportApi provideItemReportApi(RetrofitFactory retrofitFactory) {
        return (ItemReportApi) Preconditions.checkNotNullFromProvides(ItemReportApiModule.INSTANCE.provideItemReportApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ItemReportApi get() {
        return provideItemReportApi(this.a.get());
    }
}
