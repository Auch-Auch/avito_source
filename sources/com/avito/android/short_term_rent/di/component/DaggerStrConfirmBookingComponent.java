package com.avito.android.short_term_rent.di.component;

import android.content.res.Resources;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.conveyor_shared_item.notification.NotificationItemBlueprint;
import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTrackerImpl;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTrackerImpl_Factory;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTrackerImpl;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTrackerImpl_Factory;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingFragment_MembersInjector;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractorImpl;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractorImpl_Factory;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelFactory;
import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemBlueprint;
import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemPresenter;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingContentsComparator;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProviderImpl;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProviderImpl_Factory;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverter;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverterImpl_Factory;
import com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideLinkItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideSummaryItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideAdapterPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideCategoryParametersElementConverterFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideDataAwareAdapterPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideDiffCalculator$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideListUpdateCallback$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideLocalPretendInteractorFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideParametersValidatorFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideRecyclerAdapterFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideStrConfirmBookingViewModel$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrConfirmBookingModule_ProvideStrConfirmBookingViewModelFactory$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
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
public final class DaggerStrConfirmBookingComponent implements StrConfirmBookingComponent {
    public Provider<StrConfirmBookingResourceProviderImpl> A;
    public Provider<StrConfirmBookingResourceProvider> B;
    public Provider<StrContactsTreeConverter> C;
    public Provider<NonFatalAnalyticsTrackerImpl> D;
    public Provider<NonFatalAnalyticsTracker> E;
    public Provider<StrConfirmBookingViewModelFactory> F;
    public Provider<StrConfirmBookingViewModel> G;
    public Provider<TextWatcher> H;
    public Provider<InputItemFormatterProvider> I;
    public Provider<InputItemPresenter> J;
    public Provider<InputItemBlueprint> K;
    public Provider<NotificationItemPresenter> L;
    public Provider<NotificationItemBlueprint> M;
    public Provider<ButtonItemPresenter> N;
    public Provider<ButtonItemBlueprint> O;
    public Provider<SummaryItemPresenter> P;
    public Provider<SummaryItemBlueprint> Q;
    public Provider<LinkItemPresenter> R;
    public Provider<LinkItemBlueprint> S;
    public Provider<DisclaimerItemPresenter> T;
    public Provider<DisclaimerItemBlueprint> U;
    public Provider<ItemBinder> V;
    public Provider<AdapterPresenter> W;
    public Provider<SimpleRecyclerAdapter> X;
    public Provider<ListUpdateCallback> Y;
    public Provider<StrConfirmBookingContentsComparator> Z;
    public final StrBookingCommonDependencies a;
    public Provider<DiffCalculator> a0;
    public Provider<Fragment> b;
    public Provider<DataAwareAdapterPresenter> b0;
    public Provider<ShortTermRentApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<Resources> f;
    public Provider<ParametersValidatorResourceProvider> g;
    public Provider<Features> h;
    public Provider<HtmlRenderer> i;
    public Provider<HtmlCleaner> j;
    public Provider<ParametersValidator> k;
    public Provider<LocalPretendInteractor> l;
    public Provider<String> m;
    public Provider<StrConfirmBookingInteractorImpl> n;
    public Provider<String> o;
    public Provider<String> p;
    public Provider<String> q;
    public Provider<Integer> r;
    public Provider<Analytics> s;
    public Provider<StrAnalyticsTrackerImpl> t;
    public Provider<StrAnalyticsTracker> u;
    public Provider<TimeSource> v;
    public Provider<Locale> w;
    public Provider<HtmlNodeFactory> x;
    public Provider<CategoryParametersElementConverter> y = DoubleCheck.provider(StrConfirmBookingModule_ProvideCategoryParametersElementConverterFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.v, this.f, this.w, this.h, this.j, this.x));
    public Provider<AttributedTextFormatter> z = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());

    public static final class b implements StrConfirmBookingComponent.Builder {
        public Resources a;
        public Fragment b;
        public String c;
        public String d;
        public String e;
        public Integer f;
        public String g;
        public StrBookingCommonDependencies h;

        public b(a aVar) {
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder advertId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, Integer.class);
            Preconditions.checkBuilderRequirement(this.h, StrBookingCommonDependencies.class);
            return new DaggerStrConfirmBookingComponent(this.h, this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder checkInDate(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder checkOutDate(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder confirmBookingDependencies(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.h = (StrBookingCommonDependencies) Preconditions.checkNotNull(strBookingCommonDependencies);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder guestsCount(int i) {
            this.f = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder viewModelFragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent.Builder
        public StrConfirmBookingComponent.Builder workflow(String str) {
            this.g = str;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final StrBookingCommonDependencies a;

        public c(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final StrBookingCommonDependencies a;

        public d(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<HtmlCleaner> {
        public final StrBookingCommonDependencies a;

        public e(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class f implements Provider<HtmlNodeFactory> {
        public final StrBookingCommonDependencies a;

        public f(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class g implements Provider<HtmlRenderer> {
        public final StrBookingCommonDependencies a;

        public g(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class h implements Provider<Locale> {
        public final StrBookingCommonDependencies a;

        public h(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class i implements Provider<SchedulersFactory> {
        public final StrBookingCommonDependencies a;

        public i(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class j implements Provider<ShortTermRentApi> {
        public final StrBookingCommonDependencies a;

        public j(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class k implements Provider<TimeSource> {
        public final StrBookingCommonDependencies a;

        public k(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class l implements Provider<TypedErrorThrowableConverter> {
        public final StrBookingCommonDependencies a;

        public l(StrBookingCommonDependencies strBookingCommonDependencies) {
            this.a = strBookingCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStrConfirmBookingComponent(StrBookingCommonDependencies strBookingCommonDependencies, Resources resources, Fragment fragment, String str, String str2, String str3, Integer num, String str4, a aVar) {
        this.a = strBookingCommonDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = new j(strBookingCommonDependencies);
        this.d = new i(strBookingCommonDependencies);
        this.e = new l(strBookingCommonDependencies);
        Factory create = InstanceFactory.create(resources);
        this.f = create;
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory.create(create));
        this.g = provider;
        d dVar = new d(strBookingCommonDependencies);
        this.h = dVar;
        g gVar = new g(strBookingCommonDependencies);
        this.i = gVar;
        e eVar = new e(strBookingCommonDependencies);
        this.j = eVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(StrConfirmBookingModule_ProvideParametersValidatorFactory.create(provider, dVar, gVar, eVar));
        this.k = provider2;
        this.l = DoubleCheck.provider(StrConfirmBookingModule_ProvideLocalPretendInteractorFactory.create(provider2));
        Factory createNullable = InstanceFactory.createNullable(str4);
        this.m = createNullable;
        this.n = StrConfirmBookingInteractorImpl_Factory.create(this.c, this.d, this.e, this.l, createNullable);
        this.o = InstanceFactory.create(str);
        this.p = InstanceFactory.create(str2);
        this.q = InstanceFactory.create(str3);
        this.r = InstanceFactory.create(num);
        c cVar = new c(strBookingCommonDependencies);
        this.s = cVar;
        StrAnalyticsTrackerImpl_Factory create2 = StrAnalyticsTrackerImpl_Factory.create(this.o, cVar);
        this.t = create2;
        this.u = DoubleCheck.provider(create2);
        this.v = new k(strBookingCommonDependencies);
        this.w = new h(strBookingCommonDependencies);
        this.x = new f(strBookingCommonDependencies);
        StrConfirmBookingResourceProviderImpl_Factory create3 = StrConfirmBookingResourceProviderImpl_Factory.create(this.f, this.m);
        this.A = create3;
        this.B = DoubleCheck.provider(create3);
        this.C = DoubleCheck.provider(StrContactsTreeConverterImpl_Factory.create());
        NonFatalAnalyticsTrackerImpl_Factory create4 = NonFatalAnalyticsTrackerImpl_Factory.create(this.s);
        this.D = create4;
        Provider<NonFatalAnalyticsTracker> provider3 = DoubleCheck.provider(create4);
        this.E = provider3;
        Provider<StrConfirmBookingViewModelFactory> provider4 = DoubleCheck.provider(StrConfirmBookingModule_ProvideStrConfirmBookingViewModelFactory$short_term_rent_releaseFactory.create(this.n, this.d, this.o, this.p, this.q, this.r, this.u, this.y, this.z, this.B, this.C, provider3));
        this.F = provider4;
        this.G = DoubleCheck.provider(StrConfirmBookingModule_ProvideStrConfirmBookingViewModel$short_term_rent_releaseFactory.create(this.b, provider4));
        this.H = PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create());
        Provider<InputItemFormatterProvider> provider5 = SingleCheck.provider(InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory.create());
        this.I = provider5;
        Provider<InputItemPresenter> provider6 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory.create(this.G, this.H, provider5));
        this.J = provider6;
        this.K = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideInputItemBluePrintFactory.create(provider6));
        Provider<NotificationItemPresenter> provider7 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideNotificationItemPresenterFactory.create());
        this.L = provider7;
        this.M = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideNotificationItemBlueprintFactory.create(provider7));
        Provider<ButtonItemPresenter> provider8 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory.create(this.G));
        this.N = provider8;
        this.O = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideButtonBlueprintFactory.create(provider8));
        Provider<SummaryItemPresenter> provider9 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory.create());
        this.P = provider9;
        this.Q = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideSummaryItemBlueprint$short_term_rent_releaseFactory.create(provider9));
        Provider<LinkItemPresenter> provider10 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory.create());
        this.R = provider10;
        this.S = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideLinkItemBlueprint$short_term_rent_releaseFactory.create(provider10));
        Provider<DisclaimerItemPresenter> provider11 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory.create());
        this.T = provider11;
        Provider<DisclaimerItemBlueprint> provider12 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemBlueprint$short_term_rent_releaseFactory.create(provider11));
        this.U = provider12;
        Provider<ItemBinder> provider13 = DoubleCheck.provider(StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory.create(this.K, this.M, this.O, this.Q, this.S, provider12));
        this.V = provider13;
        Provider<AdapterPresenter> provider14 = DoubleCheck.provider(StrConfirmBookingModule_ProvideAdapterPresenter$short_term_rent_releaseFactory.create(provider13));
        this.W = provider14;
        Provider<SimpleRecyclerAdapter> provider15 = DoubleCheck.provider(StrConfirmBookingModule_ProvideRecyclerAdapterFactory.create(provider14, this.V));
        this.X = provider15;
        this.Y = DoubleCheck.provider(StrConfirmBookingModule_ProvideListUpdateCallback$short_term_rent_releaseFactory.create(provider15));
        Provider<StrConfirmBookingContentsComparator> provider16 = DoubleCheck.provider(StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory.create());
        this.Z = provider16;
        Provider<DiffCalculator> provider17 = DoubleCheck.provider(StrConfirmBookingModule_ProvideDiffCalculator$short_term_rent_releaseFactory.create(provider16));
        this.a0 = provider17;
        this.b0 = DoubleCheck.provider(StrConfirmBookingModule_ProvideDataAwareAdapterPresenter$short_term_rent_releaseFactory.create(this.Y, this.W, provider17));
    }

    public static StrConfirmBookingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent
    public void inject(StrConfirmBookingFragment strConfirmBookingFragment) {
        StrConfirmBookingFragment_MembersInjector.injectAnalytics(strConfirmBookingFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        StrConfirmBookingFragment_MembersInjector.injectViewModel(strConfirmBookingFragment, this.G.get());
        StrConfirmBookingFragment_MembersInjector.injectRecyclerAdapter(strConfirmBookingFragment, this.X.get());
        StrConfirmBookingFragment_MembersInjector.injectAdapterPresenter(strConfirmBookingFragment, this.b0.get());
        StrConfirmBookingFragment_MembersInjector.injectItemBinder(strConfirmBookingFragment, this.V.get());
        StrConfirmBookingFragment_MembersInjector.injectIntentFactory(strConfirmBookingFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        StrConfirmBookingFragment_MembersInjector.injectDeepLinkIntentFactory(strConfirmBookingFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
