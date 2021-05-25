package com.avito.android.booking.info;

import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BookingInfoFragment_MembersInjector implements MembersInjector<BookingInfoFragment> {
    public final Provider<BookingInfoViewModelFactory> a;
    public final Provider<SimpleRecyclerAdapter> b;

    public BookingInfoFragment_MembersInjector(Provider<BookingInfoViewModelFactory> provider, Provider<SimpleRecyclerAdapter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<BookingInfoFragment> create(Provider<BookingInfoViewModelFactory> provider, Provider<SimpleRecyclerAdapter> provider2) {
        return new BookingInfoFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.booking.info.BookingInfoFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(BookingInfoFragment bookingInfoFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        bookingInfoFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.booking.info.BookingInfoFragment.viewModelFactory")
    public static void injectViewModelFactory(BookingInfoFragment bookingInfoFragment, BookingInfoViewModelFactory bookingInfoViewModelFactory) {
        bookingInfoFragment.viewModelFactory = bookingInfoViewModelFactory;
    }

    public void injectMembers(BookingInfoFragment bookingInfoFragment) {
        injectViewModelFactory(bookingInfoFragment, this.a.get());
        injectRecyclerAdapter(bookingInfoFragment, this.b.get());
    }
}
