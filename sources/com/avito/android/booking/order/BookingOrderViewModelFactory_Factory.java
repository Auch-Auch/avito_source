package com.avito.android.booking.order;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingOrderViewModelFactory_Factory implements Factory<BookingOrderViewModelFactory> {
    public final Provider<BookingOrderInteractor> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<BookingOrderInputValidator> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<BookingOrderResourceProvider> g;
    public final Provider<String> h;

    public BookingOrderViewModelFactory_Factory(Provider<BookingOrderInteractor> provider, Provider<AccountStateProvider> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4, Provider<BookingOrderInputValidator> provider5, Provider<SchedulersFactory3> provider6, Provider<BookingOrderResourceProvider> provider7, Provider<String> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static BookingOrderViewModelFactory_Factory create(Provider<BookingOrderInteractor> provider, Provider<AccountStateProvider> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4, Provider<BookingOrderInputValidator> provider5, Provider<SchedulersFactory3> provider6, Provider<BookingOrderResourceProvider> provider7, Provider<String> provider8) {
        return new BookingOrderViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static BookingOrderViewModelFactory newInstance(BookingOrderInteractor bookingOrderInteractor, AccountStateProvider accountStateProvider, DeepLinkIntentFactory deepLinkIntentFactory, ActivityIntentFactory activityIntentFactory, BookingOrderInputValidator bookingOrderInputValidator, SchedulersFactory3 schedulersFactory3, BookingOrderResourceProvider bookingOrderResourceProvider, String str) {
        return new BookingOrderViewModelFactory(bookingOrderInteractor, accountStateProvider, deepLinkIntentFactory, activityIntentFactory, bookingOrderInputValidator, schedulersFactory3, bookingOrderResourceProvider, str);
    }

    @Override // javax.inject.Provider
    public BookingOrderViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
