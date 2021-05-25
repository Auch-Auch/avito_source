package com.avito.android.booking.order;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BookingOrderFragment_MembersInjector implements MembersInjector<BookingOrderFragment> {
    public final Provider<BookingOrderViewModelFactory> a;
    public final Provider<BookingOrderPresenter> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<AttributedTextFormatter> d;

    public BookingOrderFragment_MembersInjector(Provider<BookingOrderViewModelFactory> provider, Provider<BookingOrderPresenter> provider2, Provider<ActivityIntentFactory> provider3, Provider<AttributedTextFormatter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<BookingOrderFragment> create(Provider<BookingOrderViewModelFactory> provider, Provider<BookingOrderPresenter> provider2, Provider<ActivityIntentFactory> provider3, Provider<AttributedTextFormatter> provider4) {
        return new BookingOrderFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.booking.order.BookingOrderFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(BookingOrderFragment bookingOrderFragment, ActivityIntentFactory activityIntentFactory) {
        bookingOrderFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.booking.order.BookingOrderFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(BookingOrderFragment bookingOrderFragment, AttributedTextFormatter attributedTextFormatter) {
        bookingOrderFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.booking.order.BookingOrderFragment.presenter")
    public static void injectPresenter(BookingOrderFragment bookingOrderFragment, BookingOrderPresenter bookingOrderPresenter) {
        bookingOrderFragment.presenter = bookingOrderPresenter;
    }

    @InjectedFieldSignature("com.avito.android.booking.order.BookingOrderFragment.viewModelFactory")
    public static void injectViewModelFactory(BookingOrderFragment bookingOrderFragment, BookingOrderViewModelFactory bookingOrderViewModelFactory) {
        bookingOrderFragment.viewModelFactory = bookingOrderViewModelFactory;
    }

    public void injectMembers(BookingOrderFragment bookingOrderFragment) {
        injectViewModelFactory(bookingOrderFragment, this.a.get());
        injectPresenter(bookingOrderFragment, this.b.get());
        injectActivityIntentFactory(bookingOrderFragment, this.c.get());
        injectAttributedTextFormatter(bookingOrderFragment, this.d.get());
    }
}
