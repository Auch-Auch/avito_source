package com.avito.android.str_calendar.seller.edit;

import com.avito.android.analytics.Analytics;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SellerCalendarParametersFragment_MembersInjector implements MembersInjector<SellerCalendarParametersFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<SellerCalendarParametersViewModel> c;
    public final Provider<Analytics> d;
    public final Provider<SellerCalendarParamsResourceProvider> e;
    public final Provider<SellerCalendarRouter> f;

    public SellerCalendarParametersFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<SellerCalendarParametersViewModel> provider3, Provider<Analytics> provider4, Provider<SellerCalendarParamsResourceProvider> provider5, Provider<SellerCalendarRouter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<SellerCalendarParametersFragment> create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<SellerCalendarParametersViewModel> provider3, Provider<Analytics> provider4, Provider<SellerCalendarParamsResourceProvider> provider5, Provider<SellerCalendarRouter> provider6) {
        return new SellerCalendarParametersFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.adapterPresenter")
    public static void injectAdapterPresenter(SellerCalendarParametersFragment sellerCalendarParametersFragment, AdapterPresenter adapterPresenter) {
        sellerCalendarParametersFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.analytics")
    public static void injectAnalytics(SellerCalendarParametersFragment sellerCalendarParametersFragment, Analytics analytics) {
        sellerCalendarParametersFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.itemBinder")
    public static void injectItemBinder(SellerCalendarParametersFragment sellerCalendarParametersFragment, ItemBinder itemBinder) {
        sellerCalendarParametersFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.resourceProvider")
    public static void injectResourceProvider(SellerCalendarParametersFragment sellerCalendarParametersFragment, SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider) {
        sellerCalendarParametersFragment.resourceProvider = sellerCalendarParamsResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.router")
    public static void injectRouter(SellerCalendarParametersFragment sellerCalendarParametersFragment, SellerCalendarRouter sellerCalendarRouter) {
        sellerCalendarParametersFragment.router = sellerCalendarRouter;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment.viewModel")
    public static void injectViewModel(SellerCalendarParametersFragment sellerCalendarParametersFragment, SellerCalendarParametersViewModel sellerCalendarParametersViewModel) {
        sellerCalendarParametersFragment.viewModel = sellerCalendarParametersViewModel;
    }

    public void injectMembers(SellerCalendarParametersFragment sellerCalendarParametersFragment) {
        injectAdapterPresenter(sellerCalendarParametersFragment, this.a.get());
        injectItemBinder(sellerCalendarParametersFragment, this.b.get());
        injectViewModel(sellerCalendarParametersFragment, this.c.get());
        injectAnalytics(sellerCalendarParametersFragment, this.d.get());
        injectResourceProvider(sellerCalendarParametersFragment, this.e.get());
        injectRouter(sellerCalendarParametersFragment, this.f.get());
    }
}
