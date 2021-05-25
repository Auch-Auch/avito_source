package com.avito.android.publish.input_vin.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PublishValidationLogger;
import com.avito.android.analytics.PublishValidationLogger_Factory;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl_Factory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishInputAnalyticsModule;
import com.avito.android.publish.di.PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.di.PublishParametersModule_ProvidePublishParametersInteractorFactory;
import com.avito.android.publish.di.PublishParametersModule_ProvideUploadConverterFactory;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.publish.input_vin.InputVinFragment_MembersInjector;
import com.avito.android.publish.input_vin.InputVinResourceProvider;
import com.avito.android.publish.input_vin.InputVinResourceProvider_Factory;
import com.avito.android.publish.input_vin.InputVinViewModelFactory;
import com.avito.android.publish.input_vin.di.InputVinComponent;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextBlueprint;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextBlueprint_Factory;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextPresenter;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextPresenterImpl_Factory;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonBlueprint;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonBlueprint_Factory;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenter;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenterImpl_Factory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ParametersListRdsContentsComparator;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.validation.CategoryParameterStringValueConverter;
import com.avito.android.validation.ParametersListInteractor;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListModule_ProvideAdapterPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideCategoryParameterStringValueConverterFactory;
import com.avito.android.validation.ParametersListModule_ProvideContentsComparatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideDataAwareAdapterFactory;
import com.avito.android.validation.ParametersListModule_ProvideDiffCalculatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideHtmlRenderOptionsFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideListUpdateListenerFactory;
import com.avito.android.validation.ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListInteractorFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersValidatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideRecyclerAdapterFactory;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ValidationLogger;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerInputVinComponent implements InputVinComponent {
    public Provider<HtmlRenderer> A;
    public Provider<ParametersValidator> B;
    public Provider<PublishValidationLogger> C;
    public Provider<ValidationLogger> D;
    public Provider<CategoryParameterStringValueConverter> E;
    public Provider<BuildInfo> F;
    public Provider<ParametersListInteractor> G;
    public Provider<DataAwareAdapterPresenter> H;
    public Provider<AttributedTextFormatter> I;
    public Provider<HtmlRenderOptions> J;
    public Provider<HtmlEditorViewModel> K;
    public Provider<MultiStateInputItemPresenter> L;
    public Provider<MultiStateInputItemBlueprint> M;
    public Provider<ScanVinButtonItemPresenter> N;
    public Provider<ScanVinButtonBlueprint> O;
    public Provider<DividerWithTextPresenter> P;
    public Provider<DividerWithTextBlueprint> Q;
    public Provider<Set<ItemBlueprint<?, ?>>> R;
    public Provider<ItemBinder> S;
    public Provider<SimpleRecyclerAdapter> T;
    public Provider<ListUpdateCallback> U;
    public Provider<AdapterPresenter> V;
    public Provider<ParametersListRdsContentsComparator> W;
    public Provider<DiffCalculator> X;
    public Provider<Set<ItemPresenter<?, ?>>> Y;
    public Provider<ParametersListPresenter> Z;
    public final PublishComponent a;
    public Provider<PublishInputsAnalyticTracker> a0;
    public Provider<PublishApi> b;
    public Provider<PublishAnalyticsDataProvider> c;
    public Provider<PublishDraftRepository> d;
    public Provider<Context> e;
    public Provider<Analytics> f;
    public Provider<UploadConverter> g;
    public Provider<CategoryParametersConverter> h;
    public Provider<AttributesTreeConverter> i;
    public Provider<PublishDraftWiper> j;
    public Provider<Features> k;
    public Provider<PublishParametersInteractor> l;
    public Provider<TimeSource> m;
    public Provider<Resources> n;
    public Provider<Locale> o;
    public Provider<HtmlCleaner> p;
    public Provider<HtmlNodeFactory> q;
    public Provider<CategoryParametersElementConverter> r = DoubleCheck.provider(InputVinModule_ProvideCategoryParametersElementConverterFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.m, this.n, this.o, this.k, this.p, this.q));
    public Provider<PublishEventTracker> s;
    public Provider<SchedulersFactory> t;
    public Provider<InputVinResourceProvider> u;
    public Provider<InputVinViewModelFactory> v;
    public Provider<ProgressDialogRouter> w;
    public Provider<LoadingProgressOverlayImpl> x;
    public Provider<LoadingProgressOverlay> y;
    public Provider<ParametersValidatorResourceProvider> z;

    public static final class b implements InputVinComponent.Builder {
        public PublishComponent a;
        public Resources b;
        public ParametersListModule c;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.input_vin.di.InputVinComponent.Builder
        public InputVinComponent.Builder bindResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.publish.input_vin.di.InputVinComponent.Builder
        public InputVinComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, ParametersListModule.class);
            return new DaggerInputVinComponent(new PublishParametersModule(), this.c, new PublishInputAnalyticsModule(), this.a, this.b, null);
        }

        @Override // com.avito.android.publish.input_vin.di.InputVinComponent.Builder
        public InputVinComponent.Builder parametersListModule(ParametersListModule parametersListModule) {
            this.c = (ParametersListModule) Preconditions.checkNotNull(parametersListModule);
            return this;
        }

        @Override // com.avito.android.publish.input_vin.di.InputVinComponent.Builder
        public InputVinComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<AttributesTreeConverter> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributesTreeConverter get() {
            return (AttributesTreeConverter) Preconditions.checkNotNullFromComponent(this.a.attributesConverter());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class g implements Provider<Context> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class h implements Provider<Features> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<HtmlCleaner> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class j implements Provider<HtmlNodeFactory> {
        public final PublishComponent a;

        public j(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class k implements Provider<HtmlRenderer> {
        public final PublishComponent a;

        public k(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class l implements Provider<Locale> {
        public final PublishComponent a;

        public l(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class m implements Provider<ProgressDialogRouter> {
        public final PublishComponent a;

        public m(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProgressDialogRouter get() {
            return (ProgressDialogRouter) Preconditions.checkNotNullFromComponent(this.a.progressDialogRouter());
        }
    }

    public static class n implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public n(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class o implements Provider<PublishApi> {
        public final PublishComponent a;

        public o(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class p implements Provider<PublishDraftRepository> {
        public final PublishComponent a;

        public p(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftRepository get() {
            return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
        }
    }

    public static class q implements Provider<PublishDraftWiper> {
        public final PublishComponent a;

        public q(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class r implements Provider<PublishEventTracker> {
        public final PublishComponent a;

        public r(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishEventTracker get() {
            return (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker());
        }
    }

    public static class s implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public s(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class t implements Provider<TimeSource> {
        public final PublishComponent a;

        public t(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerInputVinComponent(PublishParametersModule publishParametersModule, ParametersListModule parametersListModule, PublishInputAnalyticsModule publishInputAnalyticsModule, PublishComponent publishComponent, Resources resources, a aVar) {
        this.a = publishComponent;
        this.b = new o(publishComponent);
        this.c = new n(publishComponent);
        this.d = new p(publishComponent);
        g gVar = new g(publishComponent);
        this.e = gVar;
        c cVar = new c(publishComponent);
        this.f = cVar;
        Provider<UploadConverter> provider = SingleCheck.provider(PublishParametersModule_ProvideUploadConverterFactory.create(publishParametersModule, gVar, cVar));
        this.g = provider;
        f fVar = new f(publishComponent);
        this.h = fVar;
        d dVar = new d(publishComponent);
        this.i = dVar;
        q qVar = new q(publishComponent);
        this.j = qVar;
        h hVar = new h(publishComponent);
        this.k = hVar;
        this.l = SingleCheck.provider(PublishParametersModule_ProvidePublishParametersInteractorFactory.create(publishParametersModule, this.b, this.c, this.d, provider, fVar, dVar, qVar, hVar));
        this.m = new t(publishComponent);
        this.n = InstanceFactory.create(resources);
        this.o = new l(publishComponent);
        this.p = new i(publishComponent);
        this.q = new j(publishComponent);
        this.s = new r(publishComponent);
        this.t = new s(publishComponent);
        InputVinResourceProvider_Factory create = InputVinResourceProvider_Factory.create(this.n);
        this.u = create;
        this.v = DoubleCheck.provider(InputVinModule_ProvideInputVinViewModelFactoryFactory.create(this.l, this.r, this.s, this.t, create));
        m mVar = new m(publishComponent);
        this.w = mVar;
        LoadingProgressOverlayImpl_Factory create2 = LoadingProgressOverlayImpl_Factory.create(this.f, mVar);
        this.x = create2;
        this.y = DoubleCheck.provider(create2);
        Provider<ParametersValidatorResourceProvider> provider2 = DoubleCheck.provider(ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory.create(parametersListModule));
        this.z = provider2;
        k kVar = new k(publishComponent);
        this.A = kVar;
        this.B = DoubleCheck.provider(ParametersListModule_ProvideParametersValidatorFactory.create(parametersListModule, provider2, this.k, kVar, this.p));
        PublishValidationLogger_Factory create3 = PublishValidationLogger_Factory.create(this.f, this.c);
        this.C = create3;
        this.D = DoubleCheck.provider(create3);
        this.E = DoubleCheck.provider(ParametersListModule_ProvideCategoryParameterStringValueConverterFactory.create(parametersListModule, this.o, this.n, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create()));
        this.F = new e(publishComponent);
        this.G = DoubleCheck.provider(ParametersListModule_ProvideParametersListInteractorFactory.create(parametersListModule, this.B, this.t, this.D, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.E, this.F));
        this.H = new DelegateFactory();
        this.I = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.J = DoubleCheck.provider(ParametersListModule_ProvideHtmlRenderOptionsFactory.create(parametersListModule, this.n));
        Provider<HtmlEditorViewModel> provider3 = DoubleCheck.provider(InputVinModule_ProvideHtmlEditorViewModelFactory.create());
        this.K = provider3;
        Provider<MultiStateInputItemPresenter> provider4 = DoubleCheck.provider(ParametersListModule_ProvideInputItemPresenterFactory.create(parametersListModule, this.I, this.J, provider3));
        this.L = provider4;
        this.M = DoubleCheck.provider(ParametersListModule_ProvideInputItemBlueprintFactory.create(parametersListModule, provider4));
        Provider<ScanVinButtonItemPresenter> provider5 = DoubleCheck.provider(ScanVinButtonItemPresenterImpl_Factory.create());
        this.N = provider5;
        this.O = ScanVinButtonBlueprint_Factory.create(provider5);
        Provider<DividerWithTextPresenter> provider6 = DoubleCheck.provider(DividerWithTextPresenterImpl_Factory.create());
        this.P = provider6;
        this.Q = DividerWithTextBlueprint_Factory.create(provider6);
        SetFactory build = SetFactory.builder(3, 0).addProvider(this.M).addProvider(this.O).addProvider(this.Q).build();
        this.R = build;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(InputVinModule_ProvideItemBinderFactory.create(build));
        this.S = provider7;
        Provider<SimpleRecyclerAdapter> provider8 = DoubleCheck.provider(ParametersListModule_ProvideRecyclerAdapterFactory.create(parametersListModule, this.H, provider7));
        this.T = provider8;
        this.U = DoubleCheck.provider(ParametersListModule_ProvideListUpdateListenerFactory.create(parametersListModule, provider8));
        this.V = DoubleCheck.provider(ParametersListModule_ProvideAdapterPresenterFactory.create(parametersListModule, this.S));
        Provider<ParametersListRdsContentsComparator> provider9 = DoubleCheck.provider(ParametersListModule_ProvideContentsComparatorFactory.create(parametersListModule));
        this.W = provider9;
        Provider<DiffCalculator> provider10 = DoubleCheck.provider(ParametersListModule_ProvideDiffCalculatorFactory.create(parametersListModule, provider9));
        this.X = provider10;
        DelegateFactory.setDelegate(this.H, DoubleCheck.provider(ParametersListModule_ProvideDataAwareAdapterFactory.create(parametersListModule, this.U, this.V, provider10)));
        Provider<Set<ItemPresenter<?, ?>>> provider11 = DoubleCheck.provider(InputVinModule_ProvideItemPresentersSetFactory.create(this.N, this.L));
        this.Y = provider11;
        this.Z = DoubleCheck.provider(ParametersListModule_ProvideParametersListPresenterFactory.create(parametersListModule, this.G, this.H, provider11, this.t, this.k));
        this.a0 = DoubleCheck.provider(PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory.create(publishInputAnalyticsModule, this.s, this.Y));
    }

    public static InputVinComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinComponent
    public void inject(InputVinFragment inputVinFragment) {
        InputVinFragment_MembersInjector.injectViewModelFactory(inputVinFragment, this.v.get());
        InputVinFragment_MembersInjector.injectLoadingProgress(inputVinFragment, this.y.get());
        InputVinFragment_MembersInjector.injectParamsPresenter(inputVinFragment, this.Z.get());
        InputVinFragment_MembersInjector.injectImplicitIntent(inputVinFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        InputVinFragment_MembersInjector.injectAdapter(inputVinFragment, this.T.get());
        InputVinFragment_MembersInjector.injectInputsAnalyticTracker(inputVinFragment, this.a0.get());
        InputVinFragment_MembersInjector.injectItemPresenterSet(inputVinFragment, this.Y.get());
    }
}
