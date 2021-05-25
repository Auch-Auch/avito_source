package com.avito.android.booking.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.di.BookingOrderComponent;
import com.avito.android.booking.order.BookingOrderFragment;
import com.avito.android.booking.order.BookingOrderFragment_MembersInjector;
import com.avito.android.booking.order.BookingOrderInputValidator;
import com.avito.android.booking.order.BookingOrderInputValidatorImpl_Factory;
import com.avito.android.booking.order.BookingOrderInteractor;
import com.avito.android.booking.order.BookingOrderInteractorImpl;
import com.avito.android.booking.order.BookingOrderInteractorImpl_Factory;
import com.avito.android.booking.order.BookingOrderPresenter;
import com.avito.android.booking.order.BookingOrderPresenterImpl;
import com.avito.android.booking.order.BookingOrderPresenterImpl_Factory;
import com.avito.android.booking.order.BookingOrderResourceProvider;
import com.avito.android.booking.order.BookingOrderResourceProviderImpl;
import com.avito.android.booking.order.BookingOrderResourceProviderImpl_Factory;
import com.avito.android.booking.order.BookingOrderViewModelFactory;
import com.avito.android.booking.remote.BookingApi;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerBookingOrderComponent implements BookingOrderComponent {
    public final BookingOrderDependencies a;
    public final String b;
    public Provider<BookingApi> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<BookingOrderInteractorImpl> e;
    public Provider<BookingOrderInteractor> f;
    public Provider<BookingOrderInputValidator> g = DoubleCheck.provider(BookingOrderInputValidatorImpl_Factory.create());
    public Provider<Resources> h;
    public Provider<BookingOrderResourceProviderImpl> i;
    public Provider<BookingOrderResourceProvider> j;
    public Provider<BookingOrderPresenterImpl> k;
    public Provider<BookingOrderPresenter> l;
    public Provider<AttributedTextFormatter> m;

    public static final class b implements BookingOrderComponent.Builder {
        public String a;
        public Resources b;
        public BookingOrderDependencies c;

        public b(a aVar) {
        }

        @Override // com.avito.android.booking.di.BookingOrderComponent.Builder
        public BookingOrderComponent build() {
            Preconditions.checkBuilderRequirement(this.a, String.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, BookingOrderDependencies.class);
            return new DaggerBookingOrderComponent(this.c, this.a, this.b, null);
        }

        @Override // com.avito.android.booking.di.BookingOrderComponent.Builder
        public BookingOrderComponent.Builder dependencies(BookingOrderDependencies bookingOrderDependencies) {
            this.c = (BookingOrderDependencies) Preconditions.checkNotNull(bookingOrderDependencies);
            return this;
        }

        @Override // com.avito.android.booking.di.BookingOrderComponent.Builder
        public BookingOrderComponent.Builder withItemId(String str) {
            this.a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.booking.di.BookingOrderComponent.Builder
        public BookingOrderComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<BookingApi> {
        public final BookingOrderDependencies a;

        public c(BookingOrderDependencies bookingOrderDependencies) {
            this.a = bookingOrderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BookingApi get() {
            return (BookingApi) Preconditions.checkNotNullFromComponent(this.a.bookingApi());
        }
    }

    public static class d implements Provider<TypedErrorThrowableConverter> {
        public final BookingOrderDependencies a;

        public d(BookingOrderDependencies bookingOrderDependencies) {
            this.a = bookingOrderDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerBookingOrderComponent(BookingOrderDependencies bookingOrderDependencies, String str, Resources resources, a aVar) {
        this.a = bookingOrderDependencies;
        this.b = str;
        c cVar = new c(bookingOrderDependencies);
        this.c = cVar;
        d dVar = new d(bookingOrderDependencies);
        this.d = dVar;
        BookingOrderInteractorImpl_Factory create = BookingOrderInteractorImpl_Factory.create(cVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        BookingOrderResourceProviderImpl_Factory create3 = BookingOrderResourceProviderImpl_Factory.create(create2);
        this.i = create3;
        Provider<BookingOrderResourceProvider> provider = DoubleCheck.provider(create3);
        this.j = provider;
        BookingOrderPresenterImpl_Factory create4 = BookingOrderPresenterImpl_Factory.create(provider);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
        this.m = DoubleCheck.provider(AttributedTextFormatterImpl_Factory.create());
    }

    public static BookingOrderComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.booking.di.BookingOrderComponent
    public void inject(BookingOrderFragment bookingOrderFragment) {
        BookingOrderFragment_MembersInjector.injectViewModelFactory(bookingOrderFragment, new BookingOrderViewModelFactory(this.f.get(), (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()), (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()), (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()), this.g.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.j.get(), this.b));
        BookingOrderFragment_MembersInjector.injectPresenter(bookingOrderFragment, this.l.get());
        BookingOrderFragment_MembersInjector.injectActivityIntentFactory(bookingOrderFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        BookingOrderFragment_MembersInjector.injectAttributedTextFormatter(bookingOrderFragment, this.m.get());
    }
}
