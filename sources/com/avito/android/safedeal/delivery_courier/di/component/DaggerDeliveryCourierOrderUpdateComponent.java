package com.avito.android.safedeal.delivery_courier.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
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
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideAdapterPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideDataAwareAdapterPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideDiffCalculator$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemBluePrint$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideInputItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideItemBinder$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideListUpdateCallback$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideRecyclerAdapter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideSelectItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideCategoryParametersElementConverter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideDeliveryCourierOrderUpdateViewModel$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideDeliveryRdsSummaryViewModelFactory$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideLocalPretendInteractor$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideLocalPretendInteractorResourceProvider$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierOrderUpdateModule_ProvideParametersValidator$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTrackerImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment_MembersInjector;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractor;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractorImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractorImpl_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProviderImpl_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModelFactory;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierContentsComparator;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverterImpl;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverterImpl_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.select.SelectItemPresenter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemBlueprint;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemPresenter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory;
import com.avito.android.util.SchedulersFactory;
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
public final class DaggerDeliveryCourierOrderUpdateComponent implements DeliveryCourierOrderUpdateComponent {
    public Provider<DeliveryCourierOrderUpdateAnalyticsTracker> A;
    public Provider<AccountStateProvider> B;
    public Provider<ScreenTrackerFactory> C;
    public Provider<String> D = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory.create());
    public Provider<ScreenDiInjectTracker> E = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory.create(this.C, TimerFactory_Factory.create(), this.D));
    public Provider<ScreenInitTracker> F = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenInitTrackerFactory.create(this.C, TimerFactory_Factory.create(), this.D));
    public Provider<ScreenFlowTrackerProvider> G;
    public Provider<BaseScreenPerformanceTrackerImpl> H;
    public Provider<BaseScreenPerformanceTracker> I;
    public Provider<DeliveryCourierOrderUpdateViewModelFactory> J;
    public Provider<DeliveryCourierOrderUpdateViewModel> K;
    public Provider<InputItemPresenter> L;
    public Provider<AttributedTextFormatter> M;
    public Provider<InputItemBlueprint> N;
    public Provider<SelectItemPresenter> O;
    public Provider<SelectItemBlueprint> P;
    public Provider<TextItemPresenter> Q;
    public Provider<TextItemBlueprint> R;
    public Provider<HeaderItemPresenter> S;
    public Provider<HeaderItemBlueprint> T;
    public Provider<ItemBinder> U;
    public Provider<AdapterPresenter> V;
    public Provider<SimpleRecyclerAdapter> W;
    public Provider<ListUpdateCallback> X;
    public Provider<DeliveryCourierContentsComparator> Y;
    public Provider<DiffCalculator> Z;
    public final DeliveryCourierOrderUpdateDependencies a;
    public Provider<DataAwareAdapterPresenter> a0;
    public Provider<Fragment> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<DeliveryApi> e;
    public Provider<SchedulersFactory> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<Resources> h;
    public Provider<ParametersValidatorResourceProvider> i;
    public Provider<Features> j;
    public Provider<HtmlRenderer> k;
    public Provider<HtmlCleaner> l;
    public Provider<ParametersValidator> m;
    public Provider<LocalPretendInteractor> n;
    public Provider<DeliveryCourierOrderUpdateInteractorImpl> o;
    public Provider<DeliveryCourierOrderUpdateInteractor> p;
    public Provider<TimeSource> q;
    public Provider<Locale> r;
    public Provider<HtmlNodeFactory> s;
    public Provider<CategoryParametersElementConverter> t;
    public Provider<DeliveryCourierItemsConverterImpl> u;
    public Provider<DeliveryCourierItemsConverter> v;
    public Provider<DeliveryCourierOrderUpdateResourceProviderImpl> w;
    public Provider<DeliveryCourierOrderUpdateResourceProvider> x;
    public Provider<Analytics> y;
    public Provider<DeliveryCourierOrderUpdateAnalyticsTrackerImpl> z;

    public static final class b implements DeliveryCourierOrderUpdateComponent.Builder {
        public Activity a;
        public Resources b;
        public Fragment c;
        public String d;
        public String e;
        public DeliveryCourierOrderUpdateDependencies f;

        public b(a aVar) {
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder activity(Activity activity) {
            this.a = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Activity.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, DeliveryCourierOrderUpdateDependencies.class);
            return new DaggerDeliveryCourierOrderUpdateComponent(this.f, this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder deliveryCourierOrderUpdateDependencies(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.f = (DeliveryCourierOrderUpdateDependencies) Preconditions.checkNotNull(deliveryCourierOrderUpdateDependencies);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder orderID(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder source(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent.Builder
        public DeliveryCourierOrderUpdateComponent.Builder viewModelFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public c(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public d(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeliveryApi> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public e(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class f implements Provider<Features> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public f(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<HtmlCleaner> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public g(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class h implements Provider<HtmlNodeFactory> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public h(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class i implements Provider<HtmlRenderer> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public i(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class j implements Provider<Locale> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public j(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public k(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<ScreenTrackerFactory> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public l(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class m implements Provider<TimeSource> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public m(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class n implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryCourierOrderUpdateDependencies a;

        public n(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies) {
            this.a = deliveryCourierOrderUpdateDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryCourierOrderUpdateComponent(DeliveryCourierOrderUpdateDependencies deliveryCourierOrderUpdateDependencies, Activity activity, Resources resources, Fragment fragment, String str, String str2, a aVar) {
        this.a = deliveryCourierOrderUpdateDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = InstanceFactory.create(str);
        this.d = InstanceFactory.create(str2);
        this.e = new e(deliveryCourierOrderUpdateDependencies);
        this.f = new k(deliveryCourierOrderUpdateDependencies);
        this.g = new n(deliveryCourierOrderUpdateDependencies);
        Factory create = InstanceFactory.create(resources);
        this.h = create;
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideLocalPretendInteractorResourceProvider$safedeal_releaseFactory.create(create));
        this.i = provider;
        f fVar = new f(deliveryCourierOrderUpdateDependencies);
        this.j = fVar;
        i iVar = new i(deliveryCourierOrderUpdateDependencies);
        this.k = iVar;
        g gVar = new g(deliveryCourierOrderUpdateDependencies);
        this.l = gVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideParametersValidator$safedeal_releaseFactory.create(provider, fVar, iVar, gVar));
        this.m = provider2;
        Provider<LocalPretendInteractor> provider3 = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideLocalPretendInteractor$safedeal_releaseFactory.create(provider2));
        this.n = provider3;
        DeliveryCourierOrderUpdateInteractorImpl_Factory create2 = DeliveryCourierOrderUpdateInteractorImpl_Factory.create(this.e, this.f, this.g, provider3, this.j);
        this.o = create2;
        this.p = DoubleCheck.provider(create2);
        this.q = new m(deliveryCourierOrderUpdateDependencies);
        this.r = new j(deliveryCourierOrderUpdateDependencies);
        this.s = new h(deliveryCourierOrderUpdateDependencies);
        Provider<CategoryParametersElementConverter> provider4 = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideCategoryParametersElementConverter$safedeal_releaseFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.q, this.r, this.h, this.j, this.l, this.s));
        this.t = provider4;
        DeliveryCourierItemsConverterImpl_Factory create3 = DeliveryCourierItemsConverterImpl_Factory.create(provider4);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
        DeliveryCourierOrderUpdateResourceProviderImpl_Factory create4 = DeliveryCourierOrderUpdateResourceProviderImpl_Factory.create(this.h);
        this.w = create4;
        this.x = DoubleCheck.provider(create4);
        d dVar = new d(deliveryCourierOrderUpdateDependencies);
        this.y = dVar;
        DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory create5 = DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory.create(dVar);
        this.z = create5;
        this.A = DoubleCheck.provider(create5);
        this.B = new c(deliveryCourierOrderUpdateDependencies);
        this.C = new l(deliveryCourierOrderUpdateDependencies);
        Provider<ScreenFlowTrackerProvider> provider5 = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.C, TimerFactory_Factory.create()));
        this.G = provider5;
        BaseScreenPerformanceTrackerImpl_Factory create6 = BaseScreenPerformanceTrackerImpl_Factory.create(this.E, this.F, provider5, this.D);
        this.H = create6;
        Provider<BaseScreenPerformanceTracker> provider6 = DoubleCheck.provider(create6);
        this.I = provider6;
        Provider<DeliveryCourierOrderUpdateViewModelFactory> provider7 = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideDeliveryRdsSummaryViewModelFactory$safedeal_releaseFactory.create(this.c, this.d, this.p, this.f, this.v, this.x, this.A, this.B, provider6));
        this.J = provider7;
        Provider<DeliveryCourierOrderUpdateViewModel> provider8 = DoubleCheck.provider(DeliveryCourierOrderUpdateModule_ProvideDeliveryCourierOrderUpdateViewModel$safedeal_releaseFactory.create(this.b, provider7));
        this.K = provider8;
        this.L = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideInputItemPresenter$safedeal_releaseFactory.create(provider8));
        Provider<AttributedTextFormatter> provider9 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.M = provider9;
        this.N = InputItemBlueprint_Factory.create(this.L, provider9);
        Provider<SelectItemPresenter> provider10 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideSelectItemPresenter$safedeal_releaseFactory.create(this.K));
        this.O = provider10;
        this.P = SelectItemBlueprint_Factory.create(provider10, this.M);
        Provider<TextItemPresenter> provider11 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory.create());
        this.Q = provider11;
        this.R = TextItemBlueprint_Factory.create(provider11);
        Provider<HeaderItemPresenter> provider12 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory.create());
        this.S = provider12;
        Provider<HeaderItemBlueprint> provider13 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemBluePrint$safedeal_releaseFactory.create(provider12));
        this.T = provider13;
        Provider<ItemBinder> provider14 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideItemBinder$safedeal_releaseFactory.create(this.N, this.P, this.R, provider13));
        this.U = provider14;
        Provider<AdapterPresenter> provider15 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideAdapterPresenter$safedeal_releaseFactory.create(provider14));
        this.V = provider15;
        Provider<SimpleRecyclerAdapter> provider16 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideRecyclerAdapter$safedeal_releaseFactory.create(provider15, this.U));
        this.W = provider16;
        this.X = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideListUpdateCallback$safedeal_releaseFactory.create(provider16));
        Provider<DeliveryCourierContentsComparator> provider17 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory.create());
        this.Y = provider17;
        Provider<DiffCalculator> provider18 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideDiffCalculator$safedeal_releaseFactory.create(provider17));
        this.Z = provider18;
        this.a0 = DoubleCheck.provider(DeliveryCourierOrderUpdateBlueprintsModule_ProvideDataAwareAdapterPresenter$safedeal_releaseFactory.create(this.X, this.V, provider18));
    }

    public static DeliveryCourierOrderUpdateComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateComponent
    public void inject(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectAnalytics(deliveryCourierOrderUpdateFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectViewModel(deliveryCourierOrderUpdateFragment, this.K.get());
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectRecyclerAdapter(deliveryCourierOrderUpdateFragment, this.W.get());
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectAdapterPresenter(deliveryCourierOrderUpdateFragment, this.a0.get());
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectDeepLinkIntentFactory(deliveryCourierOrderUpdateFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectActivityIntentFactory(deliveryCourierOrderUpdateFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectDeepLinkFactory(deliveryCourierOrderUpdateFragment, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory()));
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectResourceProvider(deliveryCourierOrderUpdateFragment, this.x.get());
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectTracker(deliveryCourierOrderUpdateFragment, this.A.get());
        DeliveryCourierOrderUpdateFragment_MembersInjector.injectPerformanceTracker(deliveryCourierOrderUpdateFragment, this.I.get());
    }
}
