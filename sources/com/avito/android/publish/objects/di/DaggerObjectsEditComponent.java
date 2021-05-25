package com.avito.android.publish.objects.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PublishValidationLogger;
import com.avito.android.analytics.PublishValidationLogger_Factory;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint_Factory;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint_Factory;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenterImpl;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenterImpl_Factory;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandlerImpl_Factory;
import com.avito.android.item_legacy.details.SelectItemBaseFragment_MembersInjector;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.item_legacy.details.SelectParameterClickListenerImpl;
import com.avito.android.item_legacy.details.SelectParameterClickListenerImpl_Factory;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint_Factory;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenterImpl_Factory;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.objects.FillObjectsFragment;
import com.avito.android.publish.objects.FillObjectsFragment_MembersInjector;
import com.avito.android.publish.objects.ObjectsEditInteractor;
import com.avito.android.publish.objects.ObjectsEditInteractorImpl;
import com.avito.android.publish.objects.ObjectsEditInteractorImpl_Factory;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonBlueprint;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonBlueprint_Factory;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenter;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenterImpl_Factory;
import com.avito.android.publish.objects.di.ObjectsEditComponent;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.BasicParameterClickListenerImpl;
import com.avito.android.publish.view.BasicParameterClickListenerImpl_Factory;
import com.avito.android.publish.view.LocationParameterClickListener;
import com.avito.android.publish.view.LocationParameterClickListenerImpl_Factory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ParametersListRdsContentsComparator;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import com.avito.android.validation.CategoryParameterStringValueConverter;
import com.avito.android.validation.ParametersListInteractor;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListModule_ProvideAdapterPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideCategoryParameterStringValueConverterFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsMultiselectItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsSelectItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsSelectItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideContentsComparatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideDataAwareAdapterFactory;
import com.avito.android.validation.ParametersListModule_ProvideDiffCalculatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideHtmlRenderOptionsFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideListUpdateListenerFactory;
import com.avito.android.validation.ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListInteractorFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersValidatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory;
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
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerObjectsEditComponent implements ObjectsEditComponent {
    public Provider<AttributedTextFormatter> A;
    public Provider<MultiStateSelectItemPresenterImpl> B;
    public Provider<MultiStateSelectItemPresenter> C;
    public Provider<MultiStateSelectItemBlueprint> D;
    public Provider<ItemBlueprint<?, ?>> E;
    public Provider<Set<ItemBlueprint<?, ?>>> F;
    public Provider<MultiStateSwitcherItemPresenter> G;
    public Provider<MultiStateSwitcherItemBlueprint> H;
    public Provider<HtmlRenderOptions> I;
    public Provider<HtmlEditorViewModel> J;
    public Provider<MultiStateInputItemPresenter> K;
    public Provider<MultiStateInputItemBlueprint> L;
    public Provider<ChipsSelectItemPresenter> M;
    public Provider<ChipsSelectItemBlueprint> N;
    public Provider<ChipsMultiselectItemPresenter> O;
    public Provider<ChipsMultiselectItemBlueprint> P;
    public Provider<RadioGroupSelectItemPresenter> Q;
    public Provider<RadioGroupSelectItemBlueprint> R;
    public Provider<ItemBinder> S;
    public Provider<SimpleRecyclerAdapter> T;
    public Provider<ListUpdateCallback> U;
    public Provider<AdapterPresenter> V;
    public Provider<ParametersListRdsContentsComparator> W;
    public Provider<DiffCalculator> X;
    public Provider<ParametersValidatorResourceProvider> Y;
    public Provider<HtmlRenderer> Z;
    public final PublishDependencies a;
    public Provider<HtmlCleaner> a0;
    public Provider<ItemDetailsSelectResultHandler> b = DoubleCheck.provider(ItemDetailsSelectResultHandlerImpl_Factory.create());
    public Provider<ParametersValidator> b0;
    public Provider<Resources> c;
    public Provider<SchedulersFactory> c0;
    public Provider<ObjectsParameter> d;
    public Provider<Analytics> d0;
    public Provider<ValidateAdvertApi> e;
    public Provider<PublishValidationLogger> e0;
    public Provider<PublishAnalyticsDataProvider> f;
    public Provider<ValidationLogger> f0;
    public Provider<Navigation> g;
    public Provider<Locale> g0;
    public Provider<Integer> h;
    public Provider<CategoryParameterStringValueConverter> h0;
    public Provider<Bundle> i;
    public Provider<BuildInfo> i0;
    public Provider<ObjectsEditInteractorImpl> j;
    public Provider<ParametersListInteractor> j0;
    public Provider<ObjectsEditInteractor> k;
    public Provider<Set<ItemPresenter<?, ?>>> k0;
    public Provider<LocationParameterClickListener> l;
    public Provider<ParametersListPresenter> l0;
    public Provider<Integer> m;
    public Provider<TimeSource> m0;
    public Provider<Features> n;
    public Provider<HtmlNodeFactory> n0;
    public Provider<SelectParameterClickListenerImpl> o;
    public Provider<CategoryParametersElementConverter> o0;
    public Provider<SelectParameterClickListener> p;
    public Provider<ObjectsEditPresenter> p0;
    public Provider<DeepLinkFactory> q;
    public Provider<RecyclerView.Adapter<?>> q0;
    public Provider<BasicParameterClickListenerImpl> r;
    public Provider<Activity> r0;
    public Provider<BasicParameterClickListener> s;
    public Provider<DialogRouter> s0;
    public Provider<DataAwareAdapterPresenter> t;
    public Provider<DeleteObjectButtonItemPresenter> u;
    public Provider<DeleteObjectButtonBlueprint> v;
    public Provider<ItemBlueprint<?, ?>> w;
    public Provider<DateIntervalItemPresenter> x;
    public Provider<DateIntervalItemBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements ObjectsEditComponent.Builder {
        public Resources a;
        public Activity b;
        public Navigation c;
        public ObjectsParameter d;
        public Integer e;
        public Integer f;
        public Bundle g;
        public PublishDependencies h;
        public ParametersListModule i;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Navigation.class);
            Preconditions.checkBuilderRequirement(this.d, ObjectsParameter.class);
            Preconditions.checkBuilderRequirement(this.f, Integer.class);
            Preconditions.checkBuilderRequirement(this.h, PublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.i, ParametersListModule.class);
            return new DaggerObjectsEditComponent(this.i, this.h, this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder parametersListModule(ParametersListModule parametersListModule) {
            this.i = (ParametersListModule) Preconditions.checkNotNull(parametersListModule);
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder publishDependencies(PublishDependencies publishDependencies) {
            this.h = (PublishDependencies) Preconditions.checkNotNull(publishDependencies);
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withInteractorState(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withMinValuesForSearch(int i2) {
            this.f = (Integer) Preconditions.checkNotNull(Integer.valueOf(i2));
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withNavigation(Navigation navigation) {
            this.c = (Navigation) Preconditions.checkNotNull(navigation);
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withObjectsIndex(Integer num) {
            this.e = num;
            return this;
        }

        @Override // com.avito.android.publish.objects.di.ObjectsEditComponent.Builder
        public ObjectsEditComponent.Builder withParameter(ObjectsParameter objectsParameter) {
            this.d = (ObjectsParameter) Preconditions.checkNotNull(objectsParameter);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishDependencies a;

        public c(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final PublishDependencies a;

        public d(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<DeepLinkFactory> {
        public final PublishDependencies a;

        public e(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class f implements Provider<Features> {
        public final PublishDependencies a;

        public f(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<HtmlCleaner> {
        public final PublishDependencies a;

        public g(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class h implements Provider<HtmlNodeFactory> {
        public final PublishDependencies a;

        public h(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class i implements Provider<HtmlRenderer> {
        public final PublishDependencies a;

        public i(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class j implements Provider<Locale> {
        public final PublishDependencies a;

        public j(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class k implements Provider<PublishAnalyticsDataProvider> {
        public final PublishDependencies a;

        public k(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class l implements Provider<SchedulersFactory> {
        public final PublishDependencies a;

        public l(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class m implements Provider<TimeSource> {
        public final PublishDependencies a;

        public m(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class n implements Provider<ValidateAdvertApi> {
        public final PublishDependencies a;

        public n(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ValidateAdvertApi get() {
            return (ValidateAdvertApi) Preconditions.checkNotNullFromComponent(this.a.validateAdvertApi());
        }
    }

    public DaggerObjectsEditComponent(ParametersListModule parametersListModule, PublishDependencies publishDependencies, Resources resources, Activity activity, Navigation navigation, ObjectsParameter objectsParameter, Integer num, Integer num2, Bundle bundle, a aVar) {
        this.a = publishDependencies;
        this.c = InstanceFactory.create(resources);
        this.d = InstanceFactory.create(objectsParameter);
        this.e = new n(publishDependencies);
        this.f = new k(publishDependencies);
        this.g = InstanceFactory.create(navigation);
        this.h = InstanceFactory.createNullable(num);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.i = createNullable;
        ObjectsEditInteractorImpl_Factory create = ObjectsEditInteractorImpl_Factory.create(this.e, this.f, this.g, this.d, this.h, createNullable);
        this.j = create;
        this.k = DoubleCheck.provider(create);
        this.l = DoubleCheck.provider(LocationParameterClickListenerImpl_Factory.create());
        Factory create2 = InstanceFactory.create(num2);
        this.m = create2;
        f fVar = new f(publishDependencies);
        this.n = fVar;
        SelectParameterClickListenerImpl_Factory create3 = SelectParameterClickListenerImpl_Factory.create(create2, fVar);
        this.o = create3;
        Provider<SelectParameterClickListener> provider = DoubleCheck.provider(create3);
        this.p = provider;
        e eVar = new e(publishDependencies);
        this.q = eVar;
        BasicParameterClickListenerImpl_Factory create4 = BasicParameterClickListenerImpl_Factory.create(this.l, provider, eVar);
        this.r = create4;
        this.s = DoubleCheck.provider(create4);
        this.t = new DelegateFactory();
        Provider<DeleteObjectButtonItemPresenter> provider2 = DoubleCheck.provider(DeleteObjectButtonItemPresenterImpl_Factory.create());
        this.u = provider2;
        DeleteObjectButtonBlueprint_Factory create5 = DeleteObjectButtonBlueprint_Factory.create(provider2);
        this.v = create5;
        this.w = DoubleCheck.provider(create5);
        Provider<DateIntervalItemPresenter> provider3 = DoubleCheck.provider(DateIntervalItemPresenterImpl_Factory.create());
        this.x = provider3;
        DateIntervalItemBlueprint_Factory create6 = DateIntervalItemBlueprint_Factory.create(provider3);
        this.y = create6;
        this.z = DoubleCheck.provider(create6);
        Provider<AttributedTextFormatter> provider4 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.A = provider4;
        MultiStateSelectItemPresenterImpl_Factory create7 = MultiStateSelectItemPresenterImpl_Factory.create(provider4);
        this.B = create7;
        Provider<MultiStateSelectItemPresenter> provider5 = DoubleCheck.provider(create7);
        this.C = provider5;
        MultiStateSelectItemBlueprint_Factory create8 = MultiStateSelectItemBlueprint_Factory.create(provider5);
        this.D = create8;
        this.E = DoubleCheck.provider(create8);
        this.F = SetFactory.builder(3, 0).addProvider(this.w).addProvider(this.z).addProvider(this.E).build();
        Provider<MultiStateSwitcherItemPresenter> provider6 = DoubleCheck.provider(ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory.create(parametersListModule, this.A));
        this.G = provider6;
        this.H = DoubleCheck.provider(ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory.create(parametersListModule, provider6));
        this.I = DoubleCheck.provider(ParametersListModule_ProvideHtmlRenderOptionsFactory.create(parametersListModule, this.c));
        Provider<HtmlEditorViewModel> provider7 = DoubleCheck.provider(ObjectsEditModule_ProvideHtmlEditorViewModelFactory.create());
        this.J = provider7;
        Provider<MultiStateInputItemPresenter> provider8 = DoubleCheck.provider(ParametersListModule_ProvideInputItemPresenterFactory.create(parametersListModule, this.A, this.I, provider7));
        this.K = provider8;
        this.L = DoubleCheck.provider(ParametersListModule_ProvideInputItemBlueprintFactory.create(parametersListModule, provider8));
        Provider<ChipsSelectItemPresenter> provider9 = DoubleCheck.provider(ParametersListModule_ProvideChipsSelectItemPresenterFactory.create(parametersListModule));
        this.M = provider9;
        this.N = DoubleCheck.provider(ParametersListModule_ProvideChipsSelectItemBlueprintFactory.create(parametersListModule, provider9, this.A));
        Provider<ChipsMultiselectItemPresenter> provider10 = DoubleCheck.provider(ParametersListModule_ProvideChipsMultiselectItemPresenterFactory.create(parametersListModule));
        this.O = provider10;
        this.P = ChipsMultiselectItemBlueprint_Factory.create(provider10, this.A);
        Provider<RadioGroupSelectItemPresenter> provider11 = DoubleCheck.provider(ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory.create(parametersListModule));
        this.Q = provider11;
        Provider<RadioGroupSelectItemBlueprint> provider12 = DoubleCheck.provider(ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory.create(parametersListModule, provider11));
        this.R = provider12;
        Provider<ItemBinder> provider13 = DoubleCheck.provider(ObjectsEditModule_ProvideItemBinderFactory.create(this.F, this.H, this.L, this.N, this.P, provider12));
        this.S = provider13;
        Provider<SimpleRecyclerAdapter> provider14 = DoubleCheck.provider(ParametersListModule_ProvideRecyclerAdapterFactory.create(parametersListModule, this.t, provider13));
        this.T = provider14;
        this.U = DoubleCheck.provider(ParametersListModule_ProvideListUpdateListenerFactory.create(parametersListModule, provider14));
        this.V = DoubleCheck.provider(ParametersListModule_ProvideAdapterPresenterFactory.create(parametersListModule, this.S));
        Provider<ParametersListRdsContentsComparator> provider15 = DoubleCheck.provider(ParametersListModule_ProvideContentsComparatorFactory.create(parametersListModule));
        this.W = provider15;
        Provider<DiffCalculator> provider16 = DoubleCheck.provider(ParametersListModule_ProvideDiffCalculatorFactory.create(parametersListModule, provider15));
        this.X = provider16;
        DelegateFactory.setDelegate(this.t, DoubleCheck.provider(ParametersListModule_ProvideDataAwareAdapterFactory.create(parametersListModule, this.U, this.V, provider16)));
        Provider<ParametersValidatorResourceProvider> provider17 = DoubleCheck.provider(ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory.create(parametersListModule));
        this.Y = provider17;
        i iVar = new i(publishDependencies);
        this.Z = iVar;
        g gVar = new g(publishDependencies);
        this.a0 = gVar;
        this.b0 = DoubleCheck.provider(ParametersListModule_ProvideParametersValidatorFactory.create(parametersListModule, provider17, this.n, iVar, gVar));
        this.c0 = new l(publishDependencies);
        c cVar = new c(publishDependencies);
        this.d0 = cVar;
        PublishValidationLogger_Factory create9 = PublishValidationLogger_Factory.create(cVar, this.f);
        this.e0 = create9;
        this.f0 = DoubleCheck.provider(create9);
        j jVar = new j(publishDependencies);
        this.g0 = jVar;
        this.h0 = DoubleCheck.provider(ParametersListModule_ProvideCategoryParameterStringValueConverterFactory.create(parametersListModule, jVar, this.c, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create()));
        this.i0 = new d(publishDependencies);
        this.j0 = DoubleCheck.provider(ParametersListModule_ProvideParametersListInteractorFactory.create(parametersListModule, this.b0, this.c0, this.f0, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.h0, this.i0));
        Provider<Set<ItemPresenter<?, ?>>> provider18 = DoubleCheck.provider(ObjectsEditModule_ProvideItemPresentersSet$publish_releaseFactory.create(this.C, this.M, this.O, this.Q, this.K, this.u, this.x));
        this.k0 = provider18;
        this.l0 = DoubleCheck.provider(ParametersListModule_ProvideParametersListPresenterFactory.create(parametersListModule, this.j0, this.t, provider18, this.c0, this.n));
        this.m0 = new m(publishDependencies);
        this.n0 = new h(publishDependencies);
        Provider<CategoryParametersElementConverter> provider19 = DoubleCheck.provider(ObjectsEditModule_ProvideCategoryParametersElementConverterFactory.create(this.c, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.m0, this.n, this.g0, this.a0, this.n0));
        this.o0 = provider19;
        this.p0 = DoubleCheck.provider(ObjectsEditModule_ProvidePresenterFactory.create(this.c, this.d, this.k, this.s, this.t, this.l0, this.b, provider19, this.c0, this.g0, this.k0));
        this.q0 = DoubleCheck.provider(ObjectsEditModule_ProvideAdapterFactory.create(this.T));
        Factory create10 = InstanceFactory.create(activity);
        this.r0 = create10;
        this.s0 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create10));
    }

    public static ObjectsEditComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.objects.di.ObjectsEditComponent
    public void inject(FillObjectsFragment fillObjectsFragment) {
        SelectItemBaseFragment_MembersInjector.injectResultHandler(fillObjectsFragment, this.b.get());
        FillObjectsFragment_MembersInjector.injectDeepLinkIntentFactory(fillObjectsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        FillObjectsFragment_MembersInjector.injectActivityIntentFactory(fillObjectsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        FillObjectsFragment_MembersInjector.injectAnalytics(fillObjectsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FillObjectsFragment_MembersInjector.injectPresenter(fillObjectsFragment, this.p0.get());
        FillObjectsFragment_MembersInjector.injectInteractor(fillObjectsFragment, this.k.get());
        FillObjectsFragment_MembersInjector.injectValidationPresenter(fillObjectsFragment, this.l0.get());
        FillObjectsFragment_MembersInjector.injectAdapter(fillObjectsFragment, this.q0.get());
        FillObjectsFragment_MembersInjector.injectFeatures(fillObjectsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FillObjectsFragment_MembersInjector.injectDialogRouter(fillObjectsFragment, this.s0.get());
    }
}
