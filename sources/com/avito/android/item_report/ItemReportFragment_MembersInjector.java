package com.avito.android.item_report;

import com.avito.android.analytics.Analytics;
import com.avito.android.item_report.remote.ItemReportApi;
import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ItemReportFragment_MembersInjector implements MembersInjector<ItemReportFragment> {
    public final Provider<ItemReportApi> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory> c;

    public ItemReportFragment_MembersInjector(Provider<ItemReportApi> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<ItemReportFragment> create(Provider<ItemReportApi> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3) {
        return new ItemReportFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.item_report.ItemReportFragment.analytics")
    public static void injectAnalytics(ItemReportFragment itemReportFragment, Analytics analytics) {
        itemReportFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.item_report.ItemReportFragment.api")
    public static void injectApi(ItemReportFragment itemReportFragment, ItemReportApi itemReportApi) {
        itemReportFragment.api = itemReportApi;
    }

    @InjectedFieldSignature("com.avito.android.item_report.ItemReportFragment.schedulersFactory")
    public static void injectSchedulersFactory(ItemReportFragment itemReportFragment, SchedulersFactory schedulersFactory) {
        itemReportFragment.schedulersFactory = schedulersFactory;
    }

    public void injectMembers(ItemReportFragment itemReportFragment) {
        injectApi(itemReportFragment, this.a.get());
        injectAnalytics(itemReportFragment, this.b.get());
        injectSchedulersFactory(itemReportFragment, this.c.get());
    }
}
