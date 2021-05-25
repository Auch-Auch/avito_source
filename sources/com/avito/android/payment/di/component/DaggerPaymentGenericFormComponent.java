package com.avito.android.payment.di.component;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemBlueprint;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.di.component.PaymentGenericFormComponent;
import com.avito.android.payment.di.module.PaymentGenericFormModule;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideAdapterPresenterFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideContentsComparatorFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideDataAwareAdapterPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideDelegateItemConverter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideDiffCalculator$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideInfoLabelBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideInfoLabelItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideItemBinder$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideItemConverter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideListUpdateListenerFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideLocalPretendInteractorFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideParametersValidatorFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePaymentGenericFormInteractor$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePaymentGenericFormPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePaymentInfoTextBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePaymentStatusProcessingPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePhoneInputItemBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvidePhoneInputItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideRecyclerAdapterFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentGenericFormModule_ProvideTextItemPresenter$payment_releaseFactory;
import com.avito.android.payment.form.DelegateItemConverter;
import com.avito.android.payment.form.PaymentGenericFormActivity;
import com.avito.android.payment.form.PaymentGenericFormActivity_MembersInjector;
import com.avito.android.payment.form.PaymentGenericFormInteractor;
import com.avito.android.payment.form.PaymentGenericFormItemConverter;
import com.avito.android.payment.form.PaymentGenericFormItemsComparator;
import com.avito.android.payment.form.PaymentGenericFormPresenter;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.payment.items.PaymentInfoTextBlueprint;
import com.avito.android.payment.items.TextItemPresenter;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
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
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
import ru.avito.component.button.ButtonItemPresenter;
import ru.avito.component.info_label.InfoLabelBlueprint;
import ru.avito.component.info_label.InfoLabelItemPresenter;
public final class DaggerPaymentGenericFormComponent implements PaymentGenericFormComponent {
    public Provider<TextItemPresenter> A;
    public Provider<PaymentInfoTextBlueprint> B;
    public Provider<ItemBinder> C;
    public Provider<SimpleRecyclerAdapter> D;
    public Provider<ListUpdateCallback> E;
    public Provider<AdapterPresenter> F;
    public Provider<PaymentGenericFormItemsComparator> G;
    public Provider<DiffCalculator> H;
    public Provider<PaymentStatusProcessingPresenter> I;
    public final PaymentDependencies a;
    public Provider<PaymentApi> b;
    public Provider<ParametersValidatorResourceProvider> c;
    public Provider<Features> d;
    public Provider<HtmlRenderer> e;
    public Provider<HtmlCleaner> f;
    public Provider<ParametersValidator> g;
    public Provider<LocalPretendInteractor> h;
    public Provider<SchedulersFactory> i;
    public Provider<PaymentSessionTypeMarker> j;
    public Provider<PaymentGenericFormInteractor> k;
    public Provider<TimeSource> l;
    public Provider<Locale> m;
    public Provider<HtmlNodeFactory> n;
    public Provider<CategoryParametersElementConverter> o;
    public Provider<DelegateItemConverter> p;
    public Provider<AttributedTextFormatter> q;
    public Provider<PaymentGenericFormItemConverter> r;
    public Provider<DataAwareAdapterPresenter> s = new DelegateFactory();
    public Provider<PaymentGenericFormPresenter> t;
    public Provider<ButtonItemPresenter> u;
    public Provider<SubmitButtonBlueprint> v;
    public Provider<PhoneInputItemPresenter> w;
    public Provider<PhoneInputItemBlueprint> x;
    public Provider<InfoLabelItemPresenter> y;
    public Provider<InfoLabelBlueprint> z;

    public static final class b implements PaymentGenericFormComponent.Builder {
        public PaymentDependencies a;
        public PaymentGenericFormModule b;
        public PaymentSessionTypeMarker c;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.PaymentGenericFormComponent.Builder
        public PaymentGenericFormComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PaymentGenericFormModule.class);
            Preconditions.checkBuilderRequirement(this.c, PaymentSessionTypeMarker.class);
            return new DaggerPaymentGenericFormComponent(this.b, this.a, this.c, null);
        }

        @Override // com.avito.android.payment.di.component.PaymentGenericFormComponent.Builder
        public PaymentGenericFormComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentGenericFormComponent.Builder
        public PaymentGenericFormComponent.Builder paymentGenericFormModule(PaymentGenericFormModule paymentGenericFormModule) {
            this.b = (PaymentGenericFormModule) Preconditions.checkNotNull(paymentGenericFormModule);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentGenericFormComponent.Builder
        public PaymentGenericFormComponent.Builder paymentSessionTypeMarker(PaymentSessionTypeMarker paymentSessionTypeMarker) {
            this.c = (PaymentSessionTypeMarker) Preconditions.checkNotNull(paymentSessionTypeMarker);
            return this;
        }
    }

    public static class c implements Provider<Features> {
        public final PaymentDependencies a;

        public c(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<HtmlCleaner> {
        public final PaymentDependencies a;

        public d(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class e implements Provider<HtmlNodeFactory> {
        public final PaymentDependencies a;

        public e(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class f implements Provider<HtmlRenderer> {
        public final PaymentDependencies a;

        public f(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class g implements Provider<PaymentApi> {
        public final PaymentDependencies a;

        public g(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class h implements Provider<Locale> {
        public final PaymentDependencies a;

        public h(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.provideLocale());
        }
    }

    public static class i implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public i(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class j implements Provider<TimeSource> {
        public final PaymentDependencies a;

        public j(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerPaymentGenericFormComponent(PaymentGenericFormModule paymentGenericFormModule, PaymentDependencies paymentDependencies, PaymentSessionTypeMarker paymentSessionTypeMarker, a aVar) {
        this.a = paymentDependencies;
        this.b = new g(paymentDependencies);
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory.create(paymentGenericFormModule));
        this.c = provider;
        c cVar = new c(paymentDependencies);
        this.d = cVar;
        f fVar = new f(paymentDependencies);
        this.e = fVar;
        d dVar = new d(paymentDependencies);
        this.f = dVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(PaymentGenericFormModule_ProvideParametersValidatorFactory.create(paymentGenericFormModule, provider, cVar, fVar, dVar));
        this.g = provider2;
        this.h = DoubleCheck.provider(PaymentGenericFormModule_ProvideLocalPretendInteractorFactory.create(paymentGenericFormModule, provider2));
        this.i = new i(paymentDependencies);
        Factory create = InstanceFactory.create(paymentSessionTypeMarker);
        this.j = create;
        this.k = DoubleCheck.provider(PaymentGenericFormModule_ProvidePaymentGenericFormInteractor$payment_releaseFactory.create(paymentGenericFormModule, this.b, this.h, this.i, create, this.d));
        this.l = new j(paymentDependencies);
        this.m = new h(paymentDependencies);
        this.n = new e(paymentDependencies);
        Provider<CategoryParametersElementConverter> provider3 = DoubleCheck.provider(PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory.create(paymentGenericFormModule, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.l, this.m, this.d, this.f, this.n));
        this.o = provider3;
        this.p = DoubleCheck.provider(PaymentGenericFormModule_ProvideDelegateItemConverter$payment_releaseFactory.create(paymentGenericFormModule, provider3));
        Provider<AttributedTextFormatter> provider4 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.q = provider4;
        this.r = DoubleCheck.provider(PaymentGenericFormModule_ProvideItemConverter$payment_releaseFactory.create(paymentGenericFormModule, this.p, provider4));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.t = delegateFactory;
        Provider<ButtonItemPresenter> provider5 = DoubleCheck.provider(PaymentGenericFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory.create(paymentGenericFormModule, delegateFactory));
        this.u = provider5;
        this.v = DoubleCheck.provider(PaymentGenericFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory.create(paymentGenericFormModule, provider5));
        Provider<PhoneInputItemPresenter> provider6 = DoubleCheck.provider(PaymentGenericFormModule_ProvidePhoneInputItemPresenter$payment_releaseFactory.create(paymentGenericFormModule, this.t));
        this.w = provider6;
        this.x = DoubleCheck.provider(PaymentGenericFormModule_ProvidePhoneInputItemBlueprint$payment_releaseFactory.create(paymentGenericFormModule, provider6));
        Provider<InfoLabelItemPresenter> provider7 = DoubleCheck.provider(PaymentGenericFormModule_ProvideInfoLabelItemPresenter$payment_releaseFactory.create(paymentGenericFormModule));
        this.y = provider7;
        this.z = DoubleCheck.provider(PaymentGenericFormModule_ProvideInfoLabelBlueprint$payment_releaseFactory.create(paymentGenericFormModule, provider7));
        Provider<TextItemPresenter> provider8 = DoubleCheck.provider(PaymentGenericFormModule_ProvideTextItemPresenter$payment_releaseFactory.create(paymentGenericFormModule));
        this.A = provider8;
        Provider<PaymentInfoTextBlueprint> provider9 = DoubleCheck.provider(PaymentGenericFormModule_ProvidePaymentInfoTextBlueprint$payment_releaseFactory.create(paymentGenericFormModule, provider8));
        this.B = provider9;
        Provider<ItemBinder> provider10 = DoubleCheck.provider(PaymentGenericFormModule_ProvideItemBinder$payment_releaseFactory.create(paymentGenericFormModule, this.v, this.x, this.z, provider9));
        this.C = provider10;
        Provider<SimpleRecyclerAdapter> provider11 = DoubleCheck.provider(PaymentGenericFormModule_ProvideRecyclerAdapterFactory.create(paymentGenericFormModule, this.s, provider10));
        this.D = provider11;
        this.E = DoubleCheck.provider(PaymentGenericFormModule_ProvideListUpdateListenerFactory.create(paymentGenericFormModule, provider11));
        this.F = DoubleCheck.provider(PaymentGenericFormModule_ProvideAdapterPresenterFactory.create(paymentGenericFormModule, this.C));
        Provider<PaymentGenericFormItemsComparator> provider12 = DoubleCheck.provider(PaymentGenericFormModule_ProvideContentsComparatorFactory.create(paymentGenericFormModule));
        this.G = provider12;
        Provider<DiffCalculator> provider13 = DoubleCheck.provider(PaymentGenericFormModule_ProvideDiffCalculator$payment_releaseFactory.create(paymentGenericFormModule, provider12));
        this.H = provider13;
        DelegateFactory.setDelegate(this.s, DoubleCheck.provider(PaymentGenericFormModule_ProvideDataAwareAdapterPresenter$payment_releaseFactory.create(paymentGenericFormModule, this.E, this.F, provider13)));
        DelegateFactory.setDelegate(this.t, DoubleCheck.provider(PaymentGenericFormModule_ProvidePaymentGenericFormPresenter$payment_releaseFactory.create(paymentGenericFormModule, this.k, this.i, this.r, this.s)));
        this.I = DoubleCheck.provider(PaymentGenericFormModule_ProvidePaymentStatusProcessingPresenter$payment_releaseFactory.create(paymentGenericFormModule));
    }

    public static PaymentGenericFormComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.PaymentGenericFormComponent
    public void inject(PaymentGenericFormActivity paymentGenericFormActivity) {
        PaymentGenericFormActivity_MembersInjector.injectPresenter(paymentGenericFormActivity, this.t.get());
        PaymentGenericFormActivity_MembersInjector.injectProcessingPresenter(paymentGenericFormActivity, this.I.get());
        PaymentGenericFormActivity_MembersInjector.injectInteractor(paymentGenericFormActivity, this.k.get());
        PaymentGenericFormActivity_MembersInjector.injectItemBinder(paymentGenericFormActivity, this.C.get());
        PaymentGenericFormActivity_MembersInjector.injectAdapter(paymentGenericFormActivity, this.D.get());
        PaymentGenericFormActivity_MembersInjector.injectDeepLinkIntentFactory(paymentGenericFormActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        PaymentGenericFormActivity_MembersInjector.injectIntentFactory(paymentGenericFormActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PaymentGenericFormActivity_MembersInjector.injectAnalytics(paymentGenericFormActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
