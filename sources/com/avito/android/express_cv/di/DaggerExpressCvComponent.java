package com.avito.android.express_cv.di;

import android.app.Activity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.epress_cv.remote.ExpressCvApi;
import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.express_cv.ExpressCvActivity_MembersInjector;
import com.avito.android.express_cv.ExpressCvDataConverter;
import com.avito.android.express_cv.ExpressCvRepository;
import com.avito.android.express_cv.ExpressCvResourceProvider;
import com.avito.android.express_cv.ExpressCvViewModel;
import com.avito.android.express_cv.ExpressCvViewModelFactory;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import com.avito.android.express_cv.NewCvDataProvider;
import com.avito.android.express_cv.ParametersConverter;
import com.avito.android.express_cv.di.ExpressCvComponent;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonPresenter;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemPresenter;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.CvTabLayoutAdapter;
import com.avito.android.express_cv.tabs.TabPagerAdapter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerExpressCvComponent implements ExpressCvComponent {
    public Provider<ExistedCvDataProvider> A;
    public Provider<TextItemPresenter> B;
    public Provider<TextItemBlueprint> C;
    public Provider<OnDeepLinkClickListener> D;
    public Provider<DisclaimerItemPresenter> E;
    public Provider<AttributedTextFormatter> F;
    public Provider<DisclaimerBlueprint> G;
    public Provider<ButtonItemPresenter.Listener> H;
    public Provider<FlatButtonPresenter> I;
    public Provider<FlatButtonBlueprint> J;
    public Provider<CvItemClickListener> K;
    public Provider<ExpressCvViewModel> L;
    public Provider<TabsDataProvider<CvTabItem>> M;
    public Provider<DeviceMetrics> N;
    public Provider<CvTabLayoutAdapter> O;
    public Provider<TabPagerAdapter> P;
    public Provider<DialogRouter> Q = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.h));
    public final ExpressCvDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<ExpressCvApi> c;
    public Provider<AvitoMessengerApi> d;
    public Provider<ExpressCvRepository> e;
    public Provider<TimeSource> f;
    public Provider<Locale> g;
    public Provider<Activity> h;
    public Provider<Features> i;
    public Provider<HtmlCleaner> j;
    public Provider<HtmlNodeFactory> k;
    public Provider<CategoryParametersElementConverter> l;
    public Provider<ExpressCvDataConverter> m;
    public Provider<ParametersValidatorResourceProvider> n;
    public Provider<HtmlRenderer> o;
    public Provider<ParametersValidator> p;
    public Provider<LocalPretendInteractor> q;
    public Provider<ParametersConverter> r;
    public Provider<DeepLinkIntentFactory> s;
    public Provider<ActivityIntentFactory> t;
    public Provider<ExpressCvResourceProvider> u;
    public Provider<ExpressCvViewModelFactory> v;
    public Provider<ExpressCvViewModelImpl> w;
    public Provider<NewCvDataProvider> x;
    public Provider<SelectItemPresenter.ClickListener> y;
    public Provider<PrimaryParametersListener> z;

    public static final class b implements ExpressCvComponent.Builder {
        public ExpressCvDependencies a;
        public ExpressCvModule b;
        public Activity c;

        public b(a aVar) {
        }

        @Override // com.avito.android.express_cv.di.ExpressCvComponent.Builder
        public ExpressCvComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ExpressCvDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ExpressCvModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerExpressCvComponent(this.b, this.a, this.c, null);
        }

        @Override // com.avito.android.express_cv.di.ExpressCvComponent.Builder
        public ExpressCvComponent.Builder dependencies(ExpressCvDependencies expressCvDependencies) {
            this.a = (ExpressCvDependencies) Preconditions.checkNotNull(expressCvDependencies);
            return this;
        }

        @Override // com.avito.android.express_cv.di.ExpressCvComponent.Builder
        public ExpressCvComponent.Builder expressCvModule(ExpressCvModule expressCvModule) {
            this.b = (ExpressCvModule) Preconditions.checkNotNull(expressCvModule);
            return this;
        }

        @Override // com.avito.android.express_cv.di.ExpressCvComponent.Builder
        public ExpressCvComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<ActivityIntentFactory> {
        public final ExpressCvDependencies a;

        public c(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class d implements Provider<DeepLinkIntentFactory> {
        public final ExpressCvDependencies a;

        public d(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class e implements Provider<DeviceMetrics> {
        public final ExpressCvDependencies a;

        public e(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class f implements Provider<ExpressCvApi> {
        public final ExpressCvDependencies a;

        public f(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExpressCvApi get() {
            return (ExpressCvApi) Preconditions.checkNotNullFromComponent(this.a.expressCvApi());
        }
    }

    public static class g implements Provider<Features> {
        public final ExpressCvDependencies a;

        public g(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<HtmlCleaner> {
        public final ExpressCvDependencies a;

        public h(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class i implements Provider<HtmlNodeFactory> {
        public final ExpressCvDependencies a;

        public i(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class j implements Provider<HtmlRenderer> {
        public final ExpressCvDependencies a;

        public j(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class k implements Provider<Locale> {
        public final ExpressCvDependencies a;

        public k(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class l implements Provider<AvitoMessengerApi> {
        public final ExpressCvDependencies a;

        public l(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AvitoMessengerApi get() {
            return (AvitoMessengerApi) Preconditions.checkNotNullFromComponent(this.a.messengerApi());
        }
    }

    public static class m implements Provider<SchedulersFactory> {
        public final ExpressCvDependencies a;

        public m(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class n implements Provider<TimeSource> {
        public final ExpressCvDependencies a;

        public n(ExpressCvDependencies expressCvDependencies) {
            this.a = expressCvDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerExpressCvComponent(ExpressCvModule expressCvModule, ExpressCvDependencies expressCvDependencies, Activity activity, a aVar) {
        this.a = expressCvDependencies;
        m mVar = new m(expressCvDependencies);
        this.b = mVar;
        f fVar = new f(expressCvDependencies);
        this.c = fVar;
        l lVar = new l(expressCvDependencies);
        this.d = lVar;
        this.e = DoubleCheck.provider(ExpressCvModule_ProvideRepositoryFactory.create(expressCvModule, fVar, mVar, lVar));
        this.f = new n(expressCvDependencies);
        this.g = new k(expressCvDependencies);
        this.h = InstanceFactory.create(activity);
        this.i = new g(expressCvDependencies);
        this.j = new h(expressCvDependencies);
        this.k = new i(expressCvDependencies);
        Provider<CategoryParametersElementConverter> provider = DoubleCheck.provider(ExpressCvModule_ProvideElementConverterFactory.create(expressCvModule, PhoneNumberFormatterModule_ProvideNationalPhoneNumberFormatterWithCountryCodeFactory.create(), this.f, this.g, this.h, this.i, this.j, this.k));
        this.l = provider;
        this.m = DoubleCheck.provider(ExpressCvModule_ProvideExpressCvDataConverterFactory.create(expressCvModule, provider, this.i));
        Provider<ParametersValidatorResourceProvider> provider2 = DoubleCheck.provider(ExpressCvModule_ProvideLocalPretendInteractorResourceProviderFactory.create(expressCvModule, this.h));
        this.n = provider2;
        j jVar = new j(expressCvDependencies);
        this.o = jVar;
        Provider<ParametersValidator> provider3 = DoubleCheck.provider(ExpressCvModule_ProvideParametersValidatorFactory.create(expressCvModule, provider2, this.i, jVar, this.j));
        this.p = provider3;
        this.q = DoubleCheck.provider(ExpressCvModule_ProvideLocalPretendInteractorFactory.create(expressCvModule, provider3));
        this.r = DoubleCheck.provider(ExpressCvModule_ProvideCategoryParametersConverter$express_cv_releaseFactory.create(expressCvModule));
        this.s = new d(expressCvDependencies);
        this.t = new c(expressCvDependencies);
        Provider<ExpressCvResourceProvider> provider4 = DoubleCheck.provider(ExpressCvModule_ProvideExpressCvResourceProviderImplFactory.create(expressCvModule, this.h));
        this.u = provider4;
        Provider<ExpressCvViewModelFactory> provider5 = DoubleCheck.provider(ExpressCvModule_ProviderViewModelFactoryFactory.create(expressCvModule, this.b, this.e, this.m, this.q, this.r, this.s, this.t, provider4, this.i));
        this.v = provider5;
        Provider<ExpressCvViewModelImpl> provider6 = DoubleCheck.provider(ExpressCvModule_ProvideViewModelImplFactory.create(expressCvModule, provider5, this.h));
        this.w = provider6;
        this.x = DoubleCheck.provider(ExpressCvModule_ProvideNewCvDataProviderFactory.create(expressCvModule, provider6));
        this.y = DoubleCheck.provider(ExpressCvModule_ProvideSelectItemPresenterListenerFactory.create(expressCvModule, this.w));
        this.z = DoubleCheck.provider(ExpressCvModule_ProvidePrimaryParametersListenerFactory.create(expressCvModule, this.w));
        this.A = DoubleCheck.provider(ExpressCvModule_ProvideCvDataFactory.create(expressCvModule, this.w));
        Provider<TextItemPresenter> provider7 = DoubleCheck.provider(ExpressCvModule_ProvideTextItemPresenter$express_cv_releaseFactory.create(expressCvModule));
        this.B = provider7;
        this.C = DoubleCheck.provider(ExpressCvModule_ProvideTextItemBlueprint$express_cv_releaseFactory.create(expressCvModule, provider7));
        Provider<OnDeepLinkClickListener> provider8 = DoubleCheck.provider(ExpressCvModule_ProvideDeepLinkClickListenerFactory.create(expressCvModule, this.w));
        this.D = provider8;
        this.E = DoubleCheck.provider(ExpressCvModule_ProvideDisclaimerItemPresenter$express_cv_releaseFactory.create(expressCvModule, provider8));
        Provider<AttributedTextFormatter> provider9 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.F = provider9;
        this.G = DoubleCheck.provider(ExpressCvModule_ProvideDisclaimerBlueprint$express_cv_releaseFactory.create(expressCvModule, this.E, provider9));
        Provider<ButtonItemPresenter.Listener> provider10 = DoubleCheck.provider(ExpressCvModule_ProviveButtonItemPresenterListenerFactory.create(expressCvModule, this.w));
        this.H = provider10;
        Provider<FlatButtonPresenter> provider11 = DoubleCheck.provider(ExpressCvModule_ProvideFlatButtonPresenterFactory.create(expressCvModule, provider10));
        this.I = provider11;
        this.J = DoubleCheck.provider(ExpressCvModule_ProvideFlatButtonBlueprintFactory.create(expressCvModule, provider11));
        this.K = DoubleCheck.provider(ExpressCvModule_ProvideCvItemClickListenerFactory.create(expressCvModule, this.w));
        this.L = DoubleCheck.provider(ExpressCvModule_ProvideViewModelFactory.create(expressCvModule, this.w));
        Provider<TabsDataProvider<CvTabItem>> provider12 = DoubleCheck.provider(ExpressCvModule_ProvideTabsDataProviderFactory.create(expressCvModule));
        this.M = provider12;
        e eVar = new e(expressCvDependencies);
        this.N = eVar;
        this.O = DoubleCheck.provider(ExpressCvModule_ProvideTabLayoutAdapterProviderFactory.create(expressCvModule, provider12, eVar, this.h));
        this.P = DoubleCheck.provider(ExpressCvModule_ProvideTabPagerAdapterProviderFactory.create(expressCvModule, this.M, this.h));
    }

    public static ExpressCvComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies, com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public ButtonItemPresenter.Listener buttonItemPresenterListener() {
        return this.H.get();
    }

    @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public CvItemClickListener cvItemClickListener() {
        return this.K.get();
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies, com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public DeviceMetrics deviceMetrics() {
        return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies, com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public DisclaimerBlueprint disclaimerBlueprint() {
        return this.G.get();
    }

    @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public ExistedCvDataProvider existedCvDataProvider() {
        return this.A.get();
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies, com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public FlatButtonBlueprint flatButtonBlueprint() {
        return this.J.get();
    }

    @Override // com.avito.android.express_cv.di.ExpressCvComponent
    public void inject(ExpressCvActivity expressCvActivity) {
        ExpressCvActivity_MembersInjector.injectViewModel(expressCvActivity, this.L.get());
        ExpressCvActivity_MembersInjector.injectAnalytics(expressCvActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ExpressCvActivity_MembersInjector.injectTabsDataProvider(expressCvActivity, this.M.get());
        ExpressCvActivity_MembersInjector.injectLayoutAdapter(expressCvActivity, this.O.get());
        ExpressCvActivity_MembersInjector.injectPagerAdapter(expressCvActivity, this.P.get());
        ExpressCvActivity_MembersInjector.injectDialogRouter(expressCvActivity, this.Q.get());
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies
    public NewCvDataProvider newCvDataProvider() {
        return this.x.get();
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies
    public PrimaryParametersListener primaryParametersListener() {
        return this.z.get();
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies
    public SelectItemPresenter.ClickListener selectItemPresenter() {
        return this.y.get();
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies, com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies
    public TextItemBlueprint textItemBlueprint() {
        return this.C.get();
    }
}
