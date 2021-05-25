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
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryComponent;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideAdapterPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideButtonItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideCourierServicesRadioGroupItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideDataAwareAdapterPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideDiffCalculator$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideExtraItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideInputItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideListUpdateCallback$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideSelectItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryBlueprintsModule_ProvideSingleCourierServiceItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule_ProvideCategoryParametersElementConverter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule_ProvideDeliveryRdsSummaryViewModel$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule_ProvideLocalPretendInteractor$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule_ProvideLocalPretendInteractorResourceProvider$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryModule_ProvideParametersValidator$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierSummaryTrackerModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment_MembersInjector;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractor;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractorImpl;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractorImpl_Factory;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryResourceProvider;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryResourceProviderImpl_Factory;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelFactory;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelFactory_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryContentsComparator_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverterImpl_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServicesRadioGroupItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServicesRadioGroupItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItemPresenter_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemPresenter_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemPresenter_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItemPresenter_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemPresenter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItemBlueprint_Factory;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItemPresenter_Factory;
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
public final class DaggerDeliveryCourierSummaryComponent implements DeliveryCourierSummaryComponent {
    public Provider<DeliveryCourierSummaryKonveyorResourceProviderImpl> A;
    public Provider<DeliveryCourierSummaryKonveyorResourceProvider> B;
    public Provider<DeliveryCourierSummaryItemsConverterImpl> C;
    public Provider<DeliveryCourierSummaryItemsConverter> D;
    public Provider<DeliveryCourierSummaryResourceProviderImpl> E;
    public Provider<DeliveryCourierSummaryResourceProvider> F;
    public Provider<AccountStateProvider> G;
    public Provider<ScreenTrackerFactory> H;
    public Provider<String> I;
    public Provider<ScreenDiInjectTracker> J;
    public Provider<ScreenInitTracker> K;
    public Provider<ScreenFlowTrackerProvider> L;
    public Provider<BaseScreenPerformanceTrackerImpl> M;
    public Provider<BaseScreenPerformanceTracker> N;
    public Provider<DeliveryCourierSummaryViewModelFactory> O;
    public Provider<DeliveryCourierSummaryViewModel> P;
    public Provider<InputItemPresenter> Q;
    public Provider<InputItemBlueprint> R;
    public Provider<SelectItemPresenter> S;
    public Provider<SelectItemBlueprint> T;
    public Provider<DividerItemBlueprint> U;
    public Provider<ButtonItemPresenter> V;
    public Provider<ButtonItemBlueprint> W;
    public Provider<ExtraItemPresenter> X;
    public Provider<ExtraItemBlueprint> Y;
    public Provider<RadioGroupItemPresenter> Z;
    public final DeliveryCourierSummaryDependencies a;
    public Provider<CourierServicesRadioGroupItemBlueprint> a0;
    public Provider<ImageItemBlueprint> b = ImageItemBlueprint_Factory.create(ImageItemPresenter_Factory.create());
    public Provider<SingleCourierServiceItemPresenter> b0;
    public Provider<TextItemBlueprint> c = TextItemBlueprint_Factory.create(TextItemPresenter_Factory.create());
    public Provider<SingleCourierServiceBlueprint> c0;
    public Provider<HeaderItemBlueprint> d = HeaderItemBlueprint_Factory.create(HeaderItemPresenter_Factory.create());
    public Provider<ItemBinder> d0;
    public Provider<LinkItemBlueprint> e = LinkItemBlueprint_Factory.create(LinkItemPresenter_Factory.create());
    public Provider<AdapterPresenter> e0;
    public Provider<Fragment> f;
    public Provider<SimpleRecyclerAdapter> f0;
    public Provider<Analytics> g;
    public Provider<ListUpdateCallback> g0;
    public Provider<DeliveryApi> h;
    public Provider<DiffCalculator> h0;
    public Provider<SchedulersFactory> i;
    public Provider<DataAwareAdapterPresenter> i0;
    public Provider<TypedErrorThrowableConverter> j;
    public Provider<Resources> k;
    public Provider<ParametersValidatorResourceProvider> l;
    public Provider<Features> m;
    public Provider<HtmlRenderer> n;
    public Provider<HtmlCleaner> o;
    public Provider<ParametersValidator> p;
    public Provider<LocalPretendInteractor> q;
    public Provider<DeliveryCourierSummaryInteractorImpl> r;
    public Provider<DeliveryCourierSummaryInteractor> s;
    public Provider<String> t;
    public Provider<String> u;
    public Provider<TimeSource> v;
    public Provider<Locale> w;
    public Provider<HtmlNodeFactory> x;
    public Provider<CategoryParametersElementConverter> y;
    public Provider<AttributedTextFormatter> z;

    public static final class b implements DeliveryCourierSummaryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryComponent.Factory
        public DeliveryCourierSummaryComponent create(Activity activity, Resources resources, Fragment fragment, String str, String str2, DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(deliveryCourierSummaryDependencies);
            return new DaggerDeliveryCourierSummaryComponent(deliveryCourierSummaryDependencies, activity, resources, fragment, str, str2, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final DeliveryCourierSummaryDependencies a;

        public c(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final DeliveryCourierSummaryDependencies a;

        public d(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeliveryApi> {
        public final DeliveryCourierSummaryDependencies a;

        public e(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class f implements Provider<Features> {
        public final DeliveryCourierSummaryDependencies a;

        public f(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<HtmlCleaner> {
        public final DeliveryCourierSummaryDependencies a;

        public g(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class h implements Provider<HtmlNodeFactory> {
        public final DeliveryCourierSummaryDependencies a;

        public h(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class i implements Provider<HtmlRenderer> {
        public final DeliveryCourierSummaryDependencies a;

        public i(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class j implements Provider<Locale> {
        public final DeliveryCourierSummaryDependencies a;

        public j(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final DeliveryCourierSummaryDependencies a;

        public k(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<ScreenTrackerFactory> {
        public final DeliveryCourierSummaryDependencies a;

        public l(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class m implements Provider<TimeSource> {
        public final DeliveryCourierSummaryDependencies a;

        public m(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class n implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryCourierSummaryDependencies a;

        public n(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies) {
            this.a = deliveryCourierSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryCourierSummaryComponent(DeliveryCourierSummaryDependencies deliveryCourierSummaryDependencies, Activity activity, Resources resources, Fragment fragment, String str, String str2, a aVar) {
        this.a = deliveryCourierSummaryDependencies;
        this.f = InstanceFactory.create(fragment);
        this.g = new d(deliveryCourierSummaryDependencies);
        this.h = new e(deliveryCourierSummaryDependencies);
        this.i = new k(deliveryCourierSummaryDependencies);
        this.j = new n(deliveryCourierSummaryDependencies);
        Factory create = InstanceFactory.create(resources);
        this.k = create;
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(DeliveryCourierSummaryModule_ProvideLocalPretendInteractorResourceProvider$safedeal_releaseFactory.create(create));
        this.l = provider;
        f fVar = new f(deliveryCourierSummaryDependencies);
        this.m = fVar;
        i iVar = new i(deliveryCourierSummaryDependencies);
        this.n = iVar;
        g gVar = new g(deliveryCourierSummaryDependencies);
        this.o = gVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(DeliveryCourierSummaryModule_ProvideParametersValidator$safedeal_releaseFactory.create(provider, fVar, iVar, gVar));
        this.p = provider2;
        Provider<LocalPretendInteractor> provider3 = DoubleCheck.provider(DeliveryCourierSummaryModule_ProvideLocalPretendInteractor$safedeal_releaseFactory.create(provider2));
        this.q = provider3;
        DeliveryCourierSummaryInteractorImpl_Factory create2 = DeliveryCourierSummaryInteractorImpl_Factory.create(this.h, this.i, this.j, provider3, this.m);
        this.r = create2;
        this.s = DoubleCheck.provider(create2);
        this.t = InstanceFactory.createNullable(str);
        this.u = InstanceFactory.createNullable(str2);
        this.v = new m(deliveryCourierSummaryDependencies);
        this.w = new j(deliveryCourierSummaryDependencies);
        this.x = new h(deliveryCourierSummaryDependencies);
        this.y = DoubleCheck.provider(DeliveryCourierSummaryModule_ProvideCategoryParametersElementConverter$safedeal_releaseFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.v, this.w, this.k, this.m, this.o, this.x));
        this.z = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory create3 = DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory.create(this.k);
        this.A = create3;
        Provider<DeliveryCourierSummaryKonveyorResourceProvider> provider4 = DoubleCheck.provider(create3);
        this.B = provider4;
        DeliveryCourierSummaryItemsConverterImpl_Factory create4 = DeliveryCourierSummaryItemsConverterImpl_Factory.create(this.y, this.z, provider4);
        this.C = create4;
        this.D = DoubleCheck.provider(create4);
        DeliveryCourierSummaryResourceProviderImpl_Factory create5 = DeliveryCourierSummaryResourceProviderImpl_Factory.create(this.k);
        this.E = create5;
        this.F = DoubleCheck.provider(create5);
        this.G = new c(deliveryCourierSummaryDependencies);
        this.H = new l(deliveryCourierSummaryDependencies);
        this.I = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenContentTypeFactory.create());
        this.J = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory.create(this.H, TimerFactory_Factory.create(), this.I));
        this.K = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenInitTrackerFactory.create(this.H, TimerFactory_Factory.create(), this.I));
        Provider<ScreenFlowTrackerProvider> provider5 = DoubleCheck.provider(DeliveryCourierSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.H, TimerFactory_Factory.create()));
        this.L = provider5;
        BaseScreenPerformanceTrackerImpl_Factory create6 = BaseScreenPerformanceTrackerImpl_Factory.create(this.J, this.K, provider5, this.I);
        this.M = create6;
        Provider<BaseScreenPerformanceTracker> provider6 = DoubleCheck.provider(create6);
        this.N = provider6;
        Provider<DeliveryCourierSummaryViewModelFactory> provider7 = DoubleCheck.provider(DeliveryCourierSummaryViewModelFactory_Factory.create(this.g, this.s, this.i, this.t, this.u, this.D, this.F, this.G, provider6));
        this.O = provider7;
        Provider<DeliveryCourierSummaryViewModel> provider8 = DoubleCheck.provider(DeliveryCourierSummaryModule_ProvideDeliveryRdsSummaryViewModel$safedeal_releaseFactory.create(this.f, provider7));
        this.P = provider8;
        Provider<InputItemPresenter> provider9 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideInputItemPresenter$safedeal_releaseFactory.create(provider8));
        this.Q = provider9;
        this.R = InputItemBlueprint_Factory.create(provider9, this.z);
        Provider<SelectItemPresenter> provider10 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideSelectItemPresenter$safedeal_releaseFactory.create(this.P));
        this.S = provider10;
        this.T = SelectItemBlueprint_Factory.create(provider10, this.z);
        this.U = DividerItemBlueprint_Factory.create(DividerItemPresenter_Factory.create());
        Provider<ButtonItemPresenter> provider11 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideButtonItemPresenter$safedeal_releaseFactory.create(this.P));
        this.V = provider11;
        this.W = ButtonItemBlueprint_Factory.create(provider11);
        Provider<ExtraItemPresenter> provider12 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideExtraItemPresenter$safedeal_releaseFactory.create(this.P));
        this.X = provider12;
        this.Y = ExtraItemBlueprint_Factory.create(provider12);
        Provider<RadioGroupItemPresenter> provider13 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideCourierServicesRadioGroupItemPresenter$safedeal_releaseFactory.create(this.P));
        this.Z = provider13;
        this.a0 = CourierServicesRadioGroupItemBlueprint_Factory.create(provider13);
        Provider<SingleCourierServiceItemPresenter> provider14 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideSingleCourierServiceItemPresenter$safedeal_releaseFactory.create(this.P));
        this.b0 = provider14;
        SingleCourierServiceBlueprint_Factory create7 = SingleCourierServiceBlueprint_Factory.create(provider14);
        this.c0 = create7;
        Provider<ItemBinder> provider15 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory.create(this.b, this.c, this.d, this.e, this.R, this.T, this.U, this.W, this.Y, this.a0, create7));
        this.d0 = provider15;
        Provider<AdapterPresenter> provider16 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideAdapterPresenter$safedeal_releaseFactory.create(provider15));
        this.e0 = provider16;
        Provider<SimpleRecyclerAdapter> provider17 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider16, this.d0));
        this.f0 = provider17;
        this.g0 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideListUpdateCallback$safedeal_releaseFactory.create(provider17));
        Provider<DiffCalculator> provider18 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideDiffCalculator$safedeal_releaseFactory.create(DeliveryCourierSummaryContentsComparator_Factory.create()));
        this.h0 = provider18;
        this.i0 = DoubleCheck.provider(DeliveryCourierSummaryBlueprintsModule_ProvideDataAwareAdapterPresenter$safedeal_releaseFactory.create(this.g0, this.e0, provider18));
    }

    public static DeliveryCourierSummaryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryComponent
    public void inject(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
        DeliveryCourierSummaryFragment_MembersInjector.injectIntentFactory(deliveryCourierSummaryFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DeliveryCourierSummaryFragment_MembersInjector.injectDeepLinkIntentFactory(deliveryCourierSummaryFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DeliveryCourierSummaryFragment_MembersInjector.injectAnalytics(deliveryCourierSummaryFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryCourierSummaryFragment_MembersInjector.injectRecyclerAdapter(deliveryCourierSummaryFragment, this.f0.get());
        DeliveryCourierSummaryFragment_MembersInjector.injectAdapterPresenter(deliveryCourierSummaryFragment, this.i0.get());
        DeliveryCourierSummaryFragment_MembersInjector.injectDeepLinkFactory(deliveryCourierSummaryFragment, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory()));
        DeliveryCourierSummaryFragment_MembersInjector.injectResourceProvider(deliveryCourierSummaryFragment, this.F.get());
        DeliveryCourierSummaryFragment_MembersInjector.injectViewModel(deliveryCourierSummaryFragment, this.P.get());
        DeliveryCourierSummaryFragment_MembersInjector.injectTracker(deliveryCourierSummaryFragment, this.N.get());
    }
}
