package com.avito.android.booking.info;

import com.avito.android.booking.remote.converter.BookingInfoActionConverter;
import com.avito.android.booking.remote.converter.BookingInfoItemConverter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingInfoViewModelFactory_Factory implements Factory<BookingInfoViewModelFactory> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<BookingInfoInteractor> b;
    public final Provider<BookingInfoItemConverter> c;
    public final Provider<BookingInfoActionConverter> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<TypedErrorThrowableConverter> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<String> h;
    public final Provider<String> i;

    public BookingInfoViewModelFactory_Factory(Provider<DeepLinkIntentFactory> provider, Provider<BookingInfoInteractor> provider2, Provider<BookingInfoItemConverter> provider3, Provider<BookingInfoActionConverter> provider4, Provider<AdapterPresenter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<SchedulersFactory3> provider7, Provider<String> provider8, Provider<String> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static BookingInfoViewModelFactory_Factory create(Provider<DeepLinkIntentFactory> provider, Provider<BookingInfoInteractor> provider2, Provider<BookingInfoItemConverter> provider3, Provider<BookingInfoActionConverter> provider4, Provider<AdapterPresenter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<SchedulersFactory3> provider7, Provider<String> provider8, Provider<String> provider9) {
        return new BookingInfoViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static BookingInfoViewModelFactory newInstance(DeepLinkIntentFactory deepLinkIntentFactory, BookingInfoInteractor bookingInfoInteractor, BookingInfoItemConverter bookingInfoItemConverter, BookingInfoActionConverter bookingInfoActionConverter, AdapterPresenter adapterPresenter, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3, String str, String str2) {
        return new BookingInfoViewModelFactory(deepLinkIntentFactory, bookingInfoInteractor, bookingInfoItemConverter, bookingInfoActionConverter, adapterPresenter, typedErrorThrowableConverter, schedulersFactory3, str, str2);
    }

    @Override // javax.inject.Provider
    public BookingInfoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
