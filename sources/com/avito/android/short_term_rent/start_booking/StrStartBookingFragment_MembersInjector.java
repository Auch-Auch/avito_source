package com.avito.android.short_term_rent.start_booking;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StrStartBookingFragment_MembersInjector implements MembersInjector<StrStartBookingFragment> {
    public final Provider<StrStartBookingViewModel> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<ActivityIntentFactory> e;

    public StrStartBookingFragment_MembersInjector(Provider<StrStartBookingViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<ActivityIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<StrStartBookingFragment> create(Provider<StrStartBookingViewModel> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<ActivityIntentFactory> provider5) {
        return new StrStartBookingFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.start_booking.StrStartBookingFragment.adapterPresenter")
    public static void injectAdapterPresenter(StrStartBookingFragment strStartBookingFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        strStartBookingFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.start_booking.StrStartBookingFragment.intentFactory")
    public static void injectIntentFactory(StrStartBookingFragment strStartBookingFragment, ActivityIntentFactory activityIntentFactory) {
        strStartBookingFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.start_booking.StrStartBookingFragment.itemBinder")
    public static void injectItemBinder(StrStartBookingFragment strStartBookingFragment, ItemBinder itemBinder) {
        strStartBookingFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.start_booking.StrStartBookingFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(StrStartBookingFragment strStartBookingFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        strStartBookingFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.start_booking.StrStartBookingFragment.viewModel")
    public static void injectViewModel(StrStartBookingFragment strStartBookingFragment, StrStartBookingViewModel strStartBookingViewModel) {
        strStartBookingFragment.viewModel = strStartBookingViewModel;
    }

    public void injectMembers(StrStartBookingFragment strStartBookingFragment) {
        injectViewModel(strStartBookingFragment, this.a.get());
        injectRecyclerAdapter(strStartBookingFragment, this.b.get());
        injectAdapterPresenter(strStartBookingFragment, this.c.get());
        injectItemBinder(strStartBookingFragment, this.d.get());
        injectIntentFactory(strStartBookingFragment, this.e.get());
    }
}
