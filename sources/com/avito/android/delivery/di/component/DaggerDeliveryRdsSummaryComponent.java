package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.SummaryState;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.delivery.di.component.DeliveryRdsSummaryComponent;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideButtonItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideHeaderItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideItemBinder$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule_ProvideCategoryParametersElementConverter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule_ProvideDeliveryRdsSummaryViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule_ProvideLocalPretendInteractor$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule_ProvideLocalPretendInteractorResourceProvider$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryModule_ProvideParametersValidator$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryTrackerModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.delivery.di.module.DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment_MembersInjector;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractorImpl;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractorImpl_Factory;
import com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProvider;
import com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProviderImpl;
import com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProviderImpl_Factory;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelFactory;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelFactory_Factory;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl_Factory;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterImpl_Factory;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProvider;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProviderImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory;
import com.avito.android.delivery.summary.konveyor.DeliverySummaryContentsComparator_Factory;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.button.ButtonItemPresenter;
import com.avito.android.delivery.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.delivery.summary.konveyor.divider.DividerItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.divider.DividerItemPresenter_Factory;
import com.avito.android.delivery.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.delivery.summary.konveyor.header.HeaderItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.header.HeaderItemPresenter;
import com.avito.android.delivery.summary.konveyor.image.ImageItemBlueprint;
import com.avito.android.delivery.summary.konveyor.image.ImageItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.image.ImageItemPresenter_Factory;
import com.avito.android.delivery.summary.konveyor.input.InputItemBlueprint;
import com.avito.android.delivery.summary.konveyor.input.InputItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.input.InputItemPresenter;
import com.avito.android.delivery.summary.konveyor.link.LinkItemBlueprint;
import com.avito.android.delivery.summary.konveyor.link.LinkItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.link.LinkItemPresenter_Factory;
import com.avito.android.delivery.summary.konveyor.price.PriceItemBlueprint;
import com.avito.android.delivery.summary.konveyor.price.PriceItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.price.PriceItemPresenter_Factory;
import com.avito.android.delivery.summary.konveyor.shipment.ShipmentItemBlueprint;
import com.avito.android.delivery.summary.konveyor.shipment.ShipmentItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.shipment.ShipmentItemPresenter_Factory;
import com.avito.android.delivery.summary.konveyor.text.TextItemBlueprint;
import com.avito.android.delivery.summary.konveyor.text.TextItemBlueprint_Factory;
import com.avito.android.delivery.summary.konveyor.text.TextItemPresenter_Factory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.DeliveryApi;
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
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerDeliveryRdsSummaryComponent implements DeliveryRdsSummaryComponent {
    public Provider<ParametersValidatorResourceProvider> A;
    public Provider<HtmlRenderer> B;
    public Provider<ParametersValidator> C;
    public Provider<LocalPretendInteractor> D;
    public Provider<DeliveryRdsContactsFieldsInteractorImpl> E;
    public Provider<DeliveryRdsContactsFieldsInteractor> F;
    public Provider<SummaryState> G;
    public Provider<Boolean> H;
    public Provider<ScreenTrackerFactory> I;
    public Provider<String> J;
    public Provider<ScreenDiInjectTracker> K;
    public Provider<ScreenInitTracker> L;
    public Provider<ScreenFlowTrackerProvider> M;
    public Provider<BaseScreenPerformanceTrackerImpl> N;
    public Provider<BaseScreenPerformanceTracker> O;
    public Provider<DeliveryRdsSummaryViewModelFactory> P;
    public Provider<DeliveryRdsSummaryViewModel> Q;
    public Provider<HeaderItemPresenter> R;
    public Provider<HeaderItemBlueprint> S;
    public Provider<LinkItemBlueprint> T;
    public Provider<InputItemPresenter> U;
    public Provider<InputItemBlueprint> V;
    public Provider<DividerItemBlueprint> W;
    public Provider<ButtonItemPresenter> X;
    public Provider<ButtonItemBlueprint> Y;
    public Provider<PriceItemBlueprint> Z;
    public final DeliverySummaryDependencies a;
    public Provider<ShipmentItemBlueprint> a0;
    public Provider<AttributedTextFormatter> b = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<ItemBinder> b0;
    public Provider<ImageItemBlueprint> c = DoubleCheck.provider(ImageItemBlueprint_Factory.create(ImageItemPresenter_Factory.create(), this.b));
    public Provider<AdapterPresenter> c0;
    public Provider<TextItemBlueprint> d = DoubleCheck.provider(TextItemBlueprint_Factory.create(TextItemPresenter_Factory.create(), this.b));
    public Provider<SimpleRecyclerAdapter> d0;
    public Provider<Fragment> e;
    public Provider<ContentsComparator> e0;
    public Provider<Analytics> f;
    public Provider<DiffCalculator> f0;
    public Provider<Features> g;
    public Provider<DataAwareAdapterPresenter> g0;
    public Provider<DeliveryApi> h;
    public Provider<SchedulersFactory3> i;
    public Provider<TypedErrorThrowableConverter> j;
    public Provider<String> k;
    public Provider<DeliveryRdsSummaryInteractorImpl> l;
    public Provider<DeliveryRdsSummaryInteractor> m;
    public Provider<String> n;
    public Provider<TimeSource> o;
    public Provider<Locale> p;
    public Provider<Resources> q;
    public Provider<HtmlCleaner> r;
    public Provider<HtmlNodeFactory> s;
    public Provider<CategoryParametersElementConverter> t;
    public Provider<DeliveryRdsSummaryKonveyorResourceProviderImpl> u;
    public Provider<DeliveryRdsSummaryKonveyorResourceProvider> v;
    public Provider<DeliveryRdsSummaryItemsConverterImpl> w;
    public Provider<DeliveryRdsSummaryItemsConverter> x;
    public Provider<DeliveryRdsSummaryResourceProviderImpl> y;
    public Provider<DeliveryRdsSummaryResourceProvider> z;

    public static final class b implements DeliveryRdsSummaryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.DeliveryRdsSummaryComponent.Factory
        public DeliveryRdsSummaryComponent create(Activity activity, Resources resources, Fragment fragment, String str, String str2, SummaryState summaryState, boolean z, DeliverySummaryDependencies deliverySummaryDependencies) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(deliverySummaryDependencies);
            return new DaggerDeliveryRdsSummaryComponent(deliverySummaryDependencies, activity, resources, fragment, str, str2, summaryState, Boolean.valueOf(z), null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final DeliverySummaryDependencies a;

        public c(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeliveryApi> {
        public final DeliverySummaryDependencies a;

        public d(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class e implements Provider<Features> {
        public final DeliverySummaryDependencies a;

        public e(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<HtmlCleaner> {
        public final DeliverySummaryDependencies a;

        public f(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class g implements Provider<HtmlNodeFactory> {
        public final DeliverySummaryDependencies a;

        public g(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class h implements Provider<HtmlRenderer> {
        public final DeliverySummaryDependencies a;

        public h(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class i implements Provider<Locale> {
        public final DeliverySummaryDependencies a;

        public i(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final DeliverySummaryDependencies a;

        public j(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class k implements Provider<ScreenTrackerFactory> {
        public final DeliverySummaryDependencies a;

        public k(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class l implements Provider<TimeSource> {
        public final DeliverySummaryDependencies a;

        public l(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class m implements Provider<TypedErrorThrowableConverter> {
        public final DeliverySummaryDependencies a;

        public m(DeliverySummaryDependencies deliverySummaryDependencies) {
            this.a = deliverySummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryRdsSummaryComponent(DeliverySummaryDependencies deliverySummaryDependencies, Activity activity, Resources resources, Fragment fragment, String str, String str2, SummaryState summaryState, Boolean bool, a aVar) {
        this.a = deliverySummaryDependencies;
        this.e = InstanceFactory.create(fragment);
        this.f = new c(deliverySummaryDependencies);
        this.g = new e(deliverySummaryDependencies);
        this.h = new d(deliverySummaryDependencies);
        this.i = new j(deliverySummaryDependencies);
        this.j = new m(deliverySummaryDependencies);
        Factory createNullable = InstanceFactory.createNullable(str);
        this.k = createNullable;
        DeliveryRdsSummaryInteractorImpl_Factory create = DeliveryRdsSummaryInteractorImpl_Factory.create(this.h, this.i, this.j, createNullable);
        this.l = create;
        this.m = DoubleCheck.provider(create);
        this.n = InstanceFactory.createNullable(str2);
        this.o = new l(deliverySummaryDependencies);
        this.p = new i(deliverySummaryDependencies);
        this.q = InstanceFactory.create(resources);
        this.r = new f(deliverySummaryDependencies);
        this.s = new g(deliverySummaryDependencies);
        this.t = DoubleCheck.provider(DeliveryRdsSummaryModule_ProvideCategoryParametersElementConverter$delivery_releaseFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.o, this.p, this.q, this.g, this.r, this.s));
        DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory create2 = DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory.create(this.q);
        this.u = create2;
        Provider<DeliveryRdsSummaryKonveyorResourceProvider> provider = DoubleCheck.provider(create2);
        this.v = provider;
        DeliveryRdsSummaryItemsConverterImpl_Factory create3 = DeliveryRdsSummaryItemsConverterImpl_Factory.create(this.t, provider);
        this.w = create3;
        this.x = DoubleCheck.provider(create3);
        DeliveryRdsSummaryResourceProviderImpl_Factory create4 = DeliveryRdsSummaryResourceProviderImpl_Factory.create(this.q);
        this.y = create4;
        this.z = DoubleCheck.provider(create4);
        Provider<ParametersValidatorResourceProvider> provider2 = DoubleCheck.provider(DeliveryRdsSummaryModule_ProvideLocalPretendInteractorResourceProvider$delivery_releaseFactory.create(this.q));
        this.A = provider2;
        h hVar = new h(deliverySummaryDependencies);
        this.B = hVar;
        Provider<ParametersValidator> provider3 = DoubleCheck.provider(DeliveryRdsSummaryModule_ProvideParametersValidator$delivery_releaseFactory.create(provider2, this.g, hVar, this.r));
        this.C = provider3;
        Provider<LocalPretendInteractor> provider4 = DoubleCheck.provider(DeliveryRdsSummaryModule_ProvideLocalPretendInteractor$delivery_releaseFactory.create(provider3));
        this.D = provider4;
        DeliveryRdsContactsFieldsInteractorImpl_Factory create5 = DeliveryRdsContactsFieldsInteractorImpl_Factory.create(this.j, provider4);
        this.E = create5;
        this.F = DoubleCheck.provider(create5);
        this.G = InstanceFactory.createNullable(summaryState);
        this.H = InstanceFactory.create(bool);
        this.I = new k(deliverySummaryDependencies);
        this.J = DoubleCheck.provider(DeliveryRdsSummaryTrackerModule_ProvidesScreenContentTypeFactory.create());
        this.K = DoubleCheck.provider(DeliveryRdsSummaryTrackerModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory.create(this.I, TimerFactory_Factory.create(), this.J));
        this.L = DoubleCheck.provider(DeliveryRdsSummaryTrackerModule_ProvidesScreenInitTrackerFactory.create(this.I, TimerFactory_Factory.create(), this.J));
        Provider<ScreenFlowTrackerProvider> provider5 = DoubleCheck.provider(DeliveryRdsSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.I, TimerFactory_Factory.create()));
        this.M = provider5;
        BaseScreenPerformanceTrackerImpl_Factory create6 = BaseScreenPerformanceTrackerImpl_Factory.create(this.K, this.L, provider5, this.J);
        this.N = create6;
        Provider<BaseScreenPerformanceTracker> provider6 = DoubleCheck.provider(create6);
        this.O = provider6;
        DeliveryRdsSummaryViewModelFactory_Factory create7 = DeliveryRdsSummaryViewModelFactory_Factory.create(this.f, this.g, this.m, this.i, this.n, this.x, this.z, this.F, this.G, this.H, provider6);
        this.P = create7;
        Provider<DeliveryRdsSummaryViewModel> provider7 = DoubleCheck.provider(DeliveryRdsSummaryModule_ProvideDeliveryRdsSummaryViewModel$delivery_releaseFactory.create(this.e, create7));
        this.Q = provider7;
        Provider<HeaderItemPresenter> provider8 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideHeaderItemPresenter$delivery_releaseFactory.create(provider7));
        this.R = provider8;
        this.S = HeaderItemBlueprint_Factory.create(provider8);
        this.T = DoubleCheck.provider(LinkItemBlueprint_Factory.create(LinkItemPresenter_Factory.create(), this.b));
        Provider<InputItemPresenter> provider9 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory.create(this.Q));
        this.U = provider9;
        this.V = InputItemBlueprint_Factory.create(provider9, this.b);
        this.W = DividerItemBlueprint_Factory.create(DividerItemPresenter_Factory.create());
        Provider<ButtonItemPresenter> provider10 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideButtonItemPresenter$delivery_releaseFactory.create(this.Q));
        this.X = provider10;
        this.Y = ButtonItemBlueprint_Factory.create(provider10);
        this.Z = PriceItemBlueprint_Factory.create(PriceItemPresenter_Factory.create(), this.b);
        ShipmentItemBlueprint_Factory create8 = ShipmentItemBlueprint_Factory.create(ShipmentItemPresenter_Factory.create(), this.b);
        this.a0 = create8;
        Provider<ItemBinder> provider11 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideItemBinder$delivery_releaseFactory.create(this.c, this.d, this.S, this.T, this.V, this.W, this.Y, this.Z, create8));
        this.b0 = provider11;
        Provider<AdapterPresenter> provider12 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider11));
        this.c0 = provider12;
        this.d0 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider12, this.b0));
        Provider<ContentsComparator> provider13 = DoubleCheck.provider(DeliverySummaryContentsComparator_Factory.create());
        this.e0 = provider13;
        Provider<DiffCalculator> provider14 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory.create(provider13));
        this.f0 = provider14;
        this.g0 = DoubleCheck.provider(DeliveryRdsSummaryBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory.create(this.d0, this.c0, provider14));
    }

    public static DeliveryRdsSummaryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.DeliveryRdsSummaryComponent
    public void inject(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
        DeliveryRdsSummaryFragment_MembersInjector.injectIntentFactory(deliveryRdsSummaryFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DeliveryRdsSummaryFragment_MembersInjector.injectDeepLinkIntentFactory(deliveryRdsSummaryFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DeliveryRdsSummaryFragment_MembersInjector.injectAnalytics(deliveryRdsSummaryFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryRdsSummaryFragment_MembersInjector.injectRecyclerAdapter(deliveryRdsSummaryFragment, this.d0.get());
        DeliveryRdsSummaryFragment_MembersInjector.injectAdapterPresenter(deliveryRdsSummaryFragment, this.g0.get());
        DeliveryRdsSummaryFragment_MembersInjector.injectViewModel(deliveryRdsSummaryFragment, this.Q.get());
        DeliveryRdsSummaryFragment_MembersInjector.injectAttributedTextFormatter(deliveryRdsSummaryFragment, this.b.get());
        DeliveryRdsSummaryFragment_MembersInjector.injectTracker(deliveryRdsSummaryFragment, this.O.get());
    }
}
