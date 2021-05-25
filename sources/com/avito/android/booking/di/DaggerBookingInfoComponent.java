package com.avito.android.booking.di;

import android.content.Context;
import com.avito.android.booking.di.BookingInfoComponent;
import com.avito.android.booking.di.module.BookingInfoModule_ProvideAdapterFactory;
import com.avito.android.booking.di.module.BookingInfoModule_ProvideAdapterPresenterFactory;
import com.avito.android.booking.di.module.BookingInfoModule_ProvideItemBinderFactory;
import com.avito.android.booking.info.BookingInfoFragment;
import com.avito.android.booking.info.BookingInfoFragment_MembersInjector;
import com.avito.android.booking.info.BookingInfoInteractor;
import com.avito.android.booking.info.BookingInfoInteractorImpl;
import com.avito.android.booking.info.BookingInfoInteractorImpl_Factory;
import com.avito.android.booking.info.BookingInfoViewModelFactory;
import com.avito.android.booking.item.description.DescriptionItemBlueprint;
import com.avito.android.booking.item.description.DescriptionItemBlueprint_Factory;
import com.avito.android.booking.item.description.DescriptionItemPresenter_Factory;
import com.avito.android.booking.item.padding.PaddingItemBlueprint;
import com.avito.android.booking.item.padding.PaddingItemBlueprint_Factory;
import com.avito.android.booking.item.padding.PaddingItemPresenter_Factory;
import com.avito.android.booking.item.picture.PictureItemBlueprint;
import com.avito.android.booking.item.picture.PictureItemBlueprint_Factory;
import com.avito.android.booking.item.picture.PictureItemPresenter_Factory;
import com.avito.android.booking.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.booking.item.subtitle.SubtitleItemBlueprint_Factory;
import com.avito.android.booking.item.subtitle.SubtitleItemPresenter_Factory;
import com.avito.android.booking.item.title.TitleItemBlueprint;
import com.avito.android.booking.item.title.TitleItemBlueprint_Factory;
import com.avito.android.booking.item.title.TitleItemPresenter_Factory;
import com.avito.android.booking.remote.BookingApi;
import com.avito.android.booking.remote.converter.BookingInfoActionConverter;
import com.avito.android.booking.remote.converter.BookingInfoActionConverterImpl;
import com.avito.android.booking.remote.converter.BookingInfoActionConverterImpl_Factory;
import com.avito.android.booking.remote.converter.BookingInfoItemConverter;
import com.avito.android.booking.remote.converter.BookingInfoItemConverterImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerBookingInfoComponent implements BookingInfoComponent {
    public final BookingInfoDependencies a;
    public final String b;
    public final String c;
    public Provider<BookingApi> d;
    public Provider<BookingInfoInteractorImpl> e;
    public Provider<BookingInfoInteractor> f;
    public Provider<BookingInfoItemConverter> g = DoubleCheck.provider(BookingInfoItemConverterImpl_Factory.create());
    public Provider<Context> h;
    public Provider<BookingInfoActionConverterImpl> i;
    public Provider<BookingInfoActionConverter> j;
    public Provider<PictureItemBlueprint> k;
    public Provider<TitleItemBlueprint> l;
    public Provider<SubtitleItemBlueprint> m;
    public Provider<DescriptionItemBlueprint> n;
    public Provider<PaddingItemBlueprint> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;
    public Provider<SimpleRecyclerAdapter> r;

    public static final class b implements BookingInfoComponent.Builder {
        public BookingInfoDependencies a;
        public String b;
        public String c;

        public b(a aVar) {
        }

        @Override // com.avito.android.booking.di.BookingInfoComponent.Builder
        public BookingInfoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BookingInfoDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            return new DaggerBookingInfoComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.booking.di.BookingInfoComponent.Builder
        public BookingInfoComponent.Builder dependencies(BookingInfoDependencies bookingInfoDependencies) {
            this.a = (BookingInfoDependencies) Preconditions.checkNotNull(bookingInfoDependencies);
            return this;
        }

        @Override // com.avito.android.booking.di.BookingInfoComponent.Builder
        public BookingInfoComponent.Builder withFromBlock(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.booking.di.BookingInfoComponent.Builder
        public BookingInfoComponent.Builder withItemId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<BookingApi> {
        public final BookingInfoDependencies a;

        public c(BookingInfoDependencies bookingInfoDependencies) {
            this.a = bookingInfoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BookingApi get() {
            return (BookingApi) Preconditions.checkNotNullFromComponent(this.a.bookingApi());
        }
    }

    public static class d implements Provider<Context> {
        public final BookingInfoDependencies a;

        public d(BookingInfoDependencies bookingInfoDependencies) {
            this.a = bookingInfoDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public DaggerBookingInfoComponent(BookingInfoDependencies bookingInfoDependencies, String str, String str2, a aVar) {
        this.a = bookingInfoDependencies;
        this.b = str;
        this.c = str2;
        c cVar = new c(bookingInfoDependencies);
        this.d = cVar;
        BookingInfoInteractorImpl_Factory create = BookingInfoInteractorImpl_Factory.create(cVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        d dVar = new d(bookingInfoDependencies);
        this.h = dVar;
        BookingInfoActionConverterImpl_Factory create2 = BookingInfoActionConverterImpl_Factory.create(dVar);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
        this.k = PictureItemBlueprint_Factory.create(PictureItemPresenter_Factory.create());
        this.l = TitleItemBlueprint_Factory.create(TitleItemPresenter_Factory.create());
        this.m = SubtitleItemBlueprint_Factory.create(SubtitleItemPresenter_Factory.create());
        this.n = DescriptionItemBlueprint_Factory.create(DescriptionItemPresenter_Factory.create());
        PaddingItemBlueprint_Factory create3 = PaddingItemBlueprint_Factory.create(PaddingItemPresenter_Factory.create());
        this.o = create3;
        Provider<ItemBinder> provider = DoubleCheck.provider(BookingInfoModule_ProvideItemBinderFactory.create(this.k, this.l, this.m, this.n, create3));
        this.p = provider;
        Provider<AdapterPresenter> provider2 = DoubleCheck.provider(BookingInfoModule_ProvideAdapterPresenterFactory.create(provider));
        this.q = provider2;
        this.r = DoubleCheck.provider(BookingInfoModule_ProvideAdapterFactory.create(provider2, this.p));
    }

    public static BookingInfoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.booking.di.BookingInfoComponent
    public void inject(BookingInfoFragment bookingInfoFragment) {
        BookingInfoFragment_MembersInjector.injectViewModelFactory(bookingInfoFragment, new BookingInfoViewModelFactory((DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()), this.f.get(), this.g.get(), this.j.get(), this.q.get(), (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.b, this.c));
        BookingInfoFragment_MembersInjector.injectRecyclerAdapter(bookingInfoFragment, this.r.get());
    }
}
