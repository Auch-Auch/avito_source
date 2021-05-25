package com.avito.android.str_calendar.seller.calendar;

import com.avito.android.analytics.Analytics;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SellerCalendarFragment_MembersInjector implements MembersInjector<SellerCalendarFragment> {
    public final Provider<SellerCalendarViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<SellerCalendarResourceProvider> e;
    public final Provider<SellerCalendarRouter> f;

    public SellerCalendarFragment_MembersInjector(Provider<SellerCalendarViewModel> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SellerCalendarResourceProvider> provider5, Provider<SellerCalendarRouter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<SellerCalendarFragment> create(Provider<SellerCalendarViewModel> provider, Provider<Analytics> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SellerCalendarResourceProvider> provider5, Provider<SellerCalendarRouter> provider6) {
        return new SellerCalendarFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.adapterPresenter")
    public static void injectAdapterPresenter(SellerCalendarFragment sellerCalendarFragment, AdapterPresenter adapterPresenter) {
        sellerCalendarFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.analytics")
    public static void injectAnalytics(SellerCalendarFragment sellerCalendarFragment, Analytics analytics) {
        sellerCalendarFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.itemBinder")
    public static void injectItemBinder(SellerCalendarFragment sellerCalendarFragment, ItemBinder itemBinder) {
        sellerCalendarFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.resourceProvider")
    public static void injectResourceProvider(SellerCalendarFragment sellerCalendarFragment, SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        sellerCalendarFragment.resourceProvider = sellerCalendarResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.router")
    public static void injectRouter(SellerCalendarFragment sellerCalendarFragment, SellerCalendarRouter sellerCalendarRouter) {
        sellerCalendarFragment.router = sellerCalendarRouter;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment.viewModel")
    public static void injectViewModel(SellerCalendarFragment sellerCalendarFragment, SellerCalendarViewModel sellerCalendarViewModel) {
        sellerCalendarFragment.viewModel = sellerCalendarViewModel;
    }

    public void injectMembers(SellerCalendarFragment sellerCalendarFragment) {
        injectViewModel(sellerCalendarFragment, this.a.get());
        injectAnalytics(sellerCalendarFragment, this.b.get());
        injectAdapterPresenter(sellerCalendarFragment, this.c.get());
        injectItemBinder(sellerCalendarFragment, this.d.get());
        injectResourceProvider(sellerCalendarFragment, this.e.get());
        injectRouter(sellerCalendarFragment, this.f.get());
    }
}
