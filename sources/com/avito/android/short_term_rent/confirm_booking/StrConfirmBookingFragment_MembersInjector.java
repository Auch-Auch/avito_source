package com.avito.android.short_term_rent.confirm_booking;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StrConfirmBookingFragment_MembersInjector implements MembersInjector<StrConfirmBookingFragment> {
    public final Provider<Analytics> a;
    public final Provider<StrConfirmBookingViewModel> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<DataAwareAdapterPresenter> d;
    public final Provider<ItemBinder> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<DeepLinkIntentFactory> g;

    public StrConfirmBookingFragment_MembersInjector(Provider<Analytics> provider, Provider<StrConfirmBookingViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkIntentFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<StrConfirmBookingFragment> create(Provider<Analytics> provider, Provider<StrConfirmBookingViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkIntentFactory> provider7) {
        return new StrConfirmBookingFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.adapterPresenter")
    public static void injectAdapterPresenter(StrConfirmBookingFragment strConfirmBookingFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        strConfirmBookingFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.analytics")
    public static void injectAnalytics(StrConfirmBookingFragment strConfirmBookingFragment, Analytics analytics) {
        strConfirmBookingFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(StrConfirmBookingFragment strConfirmBookingFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        strConfirmBookingFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.intentFactory")
    public static void injectIntentFactory(StrConfirmBookingFragment strConfirmBookingFragment, ActivityIntentFactory activityIntentFactory) {
        strConfirmBookingFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.itemBinder")
    public static void injectItemBinder(StrConfirmBookingFragment strConfirmBookingFragment, ItemBinder itemBinder) {
        strConfirmBookingFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(StrConfirmBookingFragment strConfirmBookingFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        strConfirmBookingFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment.viewModel")
    public static void injectViewModel(StrConfirmBookingFragment strConfirmBookingFragment, StrConfirmBookingViewModel strConfirmBookingViewModel) {
        strConfirmBookingFragment.viewModel = strConfirmBookingViewModel;
    }

    public void injectMembers(StrConfirmBookingFragment strConfirmBookingFragment) {
        injectAnalytics(strConfirmBookingFragment, this.a.get());
        injectViewModel(strConfirmBookingFragment, this.b.get());
        injectRecyclerAdapter(strConfirmBookingFragment, this.c.get());
        injectAdapterPresenter(strConfirmBookingFragment, this.d.get());
        injectItemBinder(strConfirmBookingFragment, this.e.get());
        injectIntentFactory(strConfirmBookingFragment, this.f.get());
        injectDeepLinkIntentFactory(strConfirmBookingFragment, this.g.get());
    }
}
