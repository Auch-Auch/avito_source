package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.delivery.di.component.DeliveryRdsEditContactsComponent;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideButtonItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule_ProvideCategoryParametersElementConverter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule_ProvideDeliveryRdsEditContactsViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule_ProvideLocalPretendInteractor$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule_ProvideLocalPretendInteractorResourceProvider$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsEditContactsModule_ProvideParametersValidator$delivery_releaseFactory;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog_MembersInjector;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsKonveyorResourceProviderImpl;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsResourceProvider;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsResourceProviderImpl;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsResourceProviderImpl_Factory;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModel;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModelFactory;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModelFactory_Factory;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl_Factory;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterImpl_Factory;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProvider;
import com.avito.android.delivery.summary.konveyor.DeliverySummaryContentsComparator_Factory;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemPresenter;
import com.avito.android.delivery.summary.konveyor.input.InputItemBlueprint;
import com.avito.android.delivery.summary.konveyor.input.InputItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.input.InputItemPresenter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerDeliveryRdsEditContactsComponent implements DeliveryRdsEditContactsComponent {
    public Provider<InputItemBlueprint> A;
    public Provider<ButtonItemPresenter> B;
    public Provider<ButtonItemBlueprint> C;
    public Provider<ItemBinder> D;
    public Provider<AdapterPresenter> E;
    public Provider<SimpleRecyclerAdapter> F;
    public Provider<ContentsComparator> G;
    public Provider<DiffCalculator> H;
    public Provider<DataAwareAdapterPresenter> I;
    public Provider<Fragment> a;
    public Provider<SchedulersFactory3> b;
    public Provider<TimeSource> c;
    public Provider<Locale> d;
    public Provider<Resources> e;
    public Provider<Features> f;
    public Provider<HtmlCleaner> g;
    public Provider<HtmlNodeFactory> h;
    public Provider<CategoryParametersElementConverter> i = DoubleCheck.provider(DeliveryRdsEditContactsModule_ProvideCategoryParametersElementConverter$delivery_releaseFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.c, this.d, this.e, this.f, this.g, this.h));
    public Provider<DeliveryRdsEditContactsKonveyorResourceProviderImpl> j;
    public Provider<DeliveryRdsSummaryKonveyorResourceProvider> k;
    public Provider<DeliveryRdsSummaryItemsConverterImpl> l;
    public Provider<DeliveryRdsSummaryItemsConverter> m;
    public Provider<DeliveryRdsEditContactsResourceProviderImpl> n;
    public Provider<DeliveryRdsEditContactsResourceProvider> o;
    public Provider<TypedErrorThrowableConverter> p;
    public Provider<ParametersValidatorResourceProvider> q;
    public Provider<HtmlRenderer> r;
    public Provider<ParametersValidator> s;
    public Provider<LocalPretendInteractor> t;
    public Provider<DeliveryRdsContactsFieldsInteractorImpl> u;
    public Provider<DeliveryRdsContactsFieldsInteractor> v;
    public Provider<DeliveryRdsEditContactsViewModelFactory> w;
    public Provider<DeliveryRdsEditContactsViewModel> x;
    public Provider<InputItemPresenter> y;
    public Provider<AttributedTextFormatter> z;

    public static final class b implements DeliveryRdsEditContactsComponent.Builder {
        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.DeliveryRdsEditContactsComponent.Builder
        public DeliveryRdsEditContactsComponent create(DeliverySummaryDependencies deliverySummaryDependencies, Resources resources, Fragment fragment) {
            Preconditions.checkNotNull(deliverySummaryDependencies);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            return new DaggerDeliveryRdsEditContactsComponent(deliverySummaryDependencies, resources, fragment, null);
        }
    }

    public static class c implements Provider<Features> {
        public final DeliverySummaryDependencies a;

        public c(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<HtmlCleaner> {
        public final DeliverySummaryDependencies a;

        public d(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class e implements Provider<HtmlNodeFactory> {
        public final DeliverySummaryDependencies a;

        public e(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class f implements Provider<HtmlRenderer> {
        public final DeliverySummaryDependencies a;

        public f(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class g implements Provider<Locale> {
        public final DeliverySummaryDependencies a;

        public g(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final DeliverySummaryDependencies a;

        public h(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class i implements Provider<TimeSource> {
        public final DeliverySummaryDependencies a;

        public i(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class j implements Provider<TypedErrorThrowableConverter> {
        public final DeliverySummaryDependencies a;

        public j(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryRdsEditContactsComponent(DeliverySummaryDependencies deliverySummaryDependencies, Resources resources, Fragment fragment, a aVar) {
        this.a = InstanceFactory.create(fragment);
        this.b = new h(deliverySummaryDependencies);
        this.c = new i(deliverySummaryDependencies);
        this.d = new g(deliverySummaryDependencies);
        this.e = InstanceFactory.create(resources);
        this.f = new c(deliverySummaryDependencies);
        this.g = new d(deliverySummaryDependencies);
        this.h = new e(deliverySummaryDependencies);
        DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory create = DeliveryRdsEditContactsKonveyorResourceProviderImpl_Factory.create(this.e);
        this.j = create;
        Provider<DeliveryRdsSummaryKonveyorResourceProvider> provider = DoubleCheck.provider(create);
        this.k = provider;
        DeliveryRdsSummaryItemsConverterImpl_Factory create2 = DeliveryRdsSummaryItemsConverterImpl_Factory.create(this.i, provider);
        this.l = create2;
        this.m = DoubleCheck.provider(create2);
        DeliveryRdsEditContactsResourceProviderImpl_Factory create3 = DeliveryRdsEditContactsResourceProviderImpl_Factory.create(this.e);
        this.n = create3;
        this.o = DoubleCheck.provider(create3);
        this.p = new j(deliverySummaryDependencies);
        Provider<ParametersValidatorResourceProvider> provider2 = DoubleCheck.provider(DeliveryRdsEditContactsModule_ProvideLocalPretendInteractorResourceProvider$delivery_releaseFactory.create(this.e));
        this.q = provider2;
        f fVar = new f(deliverySummaryDependencies);
        this.r = fVar;
        Provider<ParametersValidator> provider3 = DoubleCheck.provider(DeliveryRdsEditContactsModule_ProvideParametersValidator$delivery_releaseFactory.create(provider2, this.f, fVar, this.g));
        this.s = provider3;
        Provider<LocalPretendInteractor> provider4 = DoubleCheck.provider(DeliveryRdsEditContactsModule_ProvideLocalPretendInteractor$delivery_releaseFactory.create(provider3));
        this.t = provider4;
        DeliveryRdsContactsFieldsInteractorImpl_Factory create4 = DeliveryRdsContactsFieldsInteractorImpl_Factory.create(this.p, provider4);
        this.u = create4;
        Provider<DeliveryRdsContactsFieldsInteractor> provider5 = DoubleCheck.provider(create4);
        this.v = provider5;
        DeliveryRdsEditContactsViewModelFactory_Factory create5 = DeliveryRdsEditContactsViewModelFactory_Factory.create(this.b, this.m, this.o, provider5);
        this.w = create5;
        Provider<DeliveryRdsEditContactsViewModel> provider6 = DoubleCheck.provider(DeliveryRdsEditContactsModule_ProvideDeliveryRdsEditContactsViewModel$delivery_releaseFactory.create(this.a, create5));
        this.x = provider6;
        this.y = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory.create(provider6));
        Provider<AttributedTextFormatter> provider7 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.z = provider7;
        this.A = InputItemBlueprint_Factory.create(this.y, provider7);
        Provider<ButtonItemPresenter> provider8 = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideButtonItemPresenter$delivery_releaseFactory.create(this.x));
        this.B = provider8;
        ButtonItemBlueprint_Factory create6 = ButtonItemBlueprint_Factory.create(provider8);
        this.C = create6;
        Provider<ItemBinder> provider9 = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory.create(this.A, create6));
        this.D = provider9;
        Provider<AdapterPresenter> provider10 = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider9));
        this.E = provider10;
        this.F = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider10, this.D));
        Provider<ContentsComparator> provider11 = DoubleCheck.provider(DeliverySummaryContentsComparator_Factory.create());
        this.G = provider11;
        Provider<DiffCalculator> provider12 = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory.create(provider11));
        this.H = provider12;
        this.I = DoubleCheck.provider(DeliveryRdsEditContactsBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory.create(this.F, this.E, provider12));
    }

    public static DeliveryRdsEditContactsComponent.Builder factory() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.DeliveryRdsEditContactsComponent
    public void inject(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog) {
        DeliveryRdsEditContactsDialog_MembersInjector.injectRecyclerAdapter(deliveryRdsEditContactsDialog, this.F.get());
        DeliveryRdsEditContactsDialog_MembersInjector.injectAdapterPresenter(deliveryRdsEditContactsDialog, this.I.get());
        DeliveryRdsEditContactsDialog_MembersInjector.injectViewModel(deliveryRdsEditContactsDialog, this.x.get());
    }
}
