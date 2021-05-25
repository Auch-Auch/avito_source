package com.avito.android.payment.di.component;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.di.component.TopUpFormComponent;
import com.avito.android.payment.di.module.TopUpFormModule;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideAdapterPresenterFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideBubbleItemBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideBubbleItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideContentsComparatorFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideDataAwareAdapterPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideDiffCalculator$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideInfoLabelBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideInfoLabelItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideItemBinder$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideListUpdateListenerFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideLocalPretendInteractorFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideParametersValidatorFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvidePaymentGenericFormPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideRecommendationSectionItemBinder$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideRecyclerAdapterFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideShortcutSectionAdapterPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideShortcutSectionBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideShortcutSectionPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideSimpleRecyclerAdapter$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideTopUpFormInteractor$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideTopUpFormItemConverterFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideTopUpFormResourceProviderFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideTopUpInputItemBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.TopUpFormModule_ProvideTopUpInputItemPresenter$payment_releaseFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.top_up.form.TopUpFormActivity;
import com.avito.android.payment.top_up.form.TopUpFormActivity_MembersInjector;
import com.avito.android.payment.top_up.form.TopUpFormInteractor;
import com.avito.android.payment.top_up.form.TopUpFormItemConverter;
import com.avito.android.payment.top_up.form.TopUpFormPresenter;
import com.avito.android.payment.top_up.form.TopUpFormResourceProvider;
import com.avito.android.payment.top_up.form.items.TopUpFormItemsComparator;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemBlueprint;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemPresenter;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItemBlueprint;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItemPresenter;
import com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionBlueprint;
import com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.button.ButtonItemPresenter;
import ru.avito.component.info_label.InfoLabelBlueprint;
import ru.avito.component.info_label.InfoLabelItemPresenter;
public final class DaggerTopUpFormComponent implements TopUpFormComponent {
    public Provider<InfoLabelBlueprint> A;
    public Provider<ItemBinder> B;
    public Provider<SimpleRecyclerAdapter> C;
    public Provider<ListUpdateCallback> D;
    public Provider<AdapterPresenter> E;
    public Provider<TopUpFormItemsComparator> F;
    public Provider<DiffCalculator> G;
    public final PaymentDependencies a;
    public Provider<PaymentApi> b;
    public Provider<ParametersValidatorResourceProvider> c;
    public Provider<Features> d;
    public Provider<HtmlRenderer> e;
    public Provider<HtmlCleaner> f;
    public Provider<ParametersValidator> g;
    public Provider<LocalPretendInteractor> h;
    public Provider<SchedulersFactory> i;
    public Provider<TopUpFormInteractor> j;
    public Provider<TopUpFormResourceProvider> k;
    public Provider<TopUpFormItemConverter> l;
    public Provider<DataAwareAdapterPresenter> m = new DelegateFactory();
    public Provider<TopUpFormPresenter> n;
    public Provider<ButtonItemPresenter> o;
    public Provider<SubmitButtonBlueprint> p;
    public Provider<TopUpInputItemPresenter> q;
    public Provider<TopUpInputItemBlueprint> r;
    public Provider<BubbleItemPresenter> s;
    public Provider<BubbleItemBlueprint> t;
    public Provider<ItemBinder> u;
    public Provider<AdapterPresenter> v;
    public Provider<ShortcutSectionPresenter> w;
    public Provider<SimpleRecyclerAdapter> x;
    public Provider<ShortcutSectionBlueprint> y;
    public Provider<InfoLabelItemPresenter> z;

    public static final class b implements TopUpFormComponent.Builder {
        public PaymentDependencies a;
        public TopUpFormModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.TopUpFormComponent.Builder
        public TopUpFormComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, TopUpFormModule.class);
            return new DaggerTopUpFormComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.payment.di.component.TopUpFormComponent.Builder
        public TopUpFormComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.TopUpFormComponent.Builder
        public TopUpFormComponent.Builder topUpFormModule(TopUpFormModule topUpFormModule) {
            this.b = (TopUpFormModule) Preconditions.checkNotNull(topUpFormModule);
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

    public static class e implements Provider<HtmlRenderer> {
        public final PaymentDependencies a;

        public e(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class f implements Provider<PaymentApi> {
        public final PaymentDependencies a;

        public f(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public g(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerTopUpFormComponent(TopUpFormModule topUpFormModule, PaymentDependencies paymentDependencies, a aVar) {
        this.a = paymentDependencies;
        this.b = new f(paymentDependencies);
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory.create(topUpFormModule));
        this.c = provider;
        c cVar = new c(paymentDependencies);
        this.d = cVar;
        e eVar = new e(paymentDependencies);
        this.e = eVar;
        d dVar = new d(paymentDependencies);
        this.f = dVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(TopUpFormModule_ProvideParametersValidatorFactory.create(topUpFormModule, provider, cVar, eVar, dVar));
        this.g = provider2;
        Provider<LocalPretendInteractor> provider3 = DoubleCheck.provider(TopUpFormModule_ProvideLocalPretendInteractorFactory.create(topUpFormModule, provider2));
        this.h = provider3;
        g gVar = new g(paymentDependencies);
        this.i = gVar;
        this.j = DoubleCheck.provider(TopUpFormModule_ProvideTopUpFormInteractor$payment_releaseFactory.create(topUpFormModule, this.b, provider3, gVar));
        Provider<TopUpFormResourceProvider> provider4 = DoubleCheck.provider(TopUpFormModule_ProvideTopUpFormResourceProviderFactory.create(topUpFormModule));
        this.k = provider4;
        this.l = DoubleCheck.provider(TopUpFormModule_ProvideTopUpFormItemConverterFactory.create(topUpFormModule, provider4));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.n = delegateFactory;
        Provider<ButtonItemPresenter> provider5 = DoubleCheck.provider(TopUpFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory.create(topUpFormModule, delegateFactory));
        this.o = provider5;
        this.p = DoubleCheck.provider(TopUpFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory.create(topUpFormModule, provider5));
        Provider<TopUpInputItemPresenter> provider6 = DoubleCheck.provider(TopUpFormModule_ProvideTopUpInputItemPresenter$payment_releaseFactory.create(topUpFormModule, this.n));
        this.q = provider6;
        this.r = DoubleCheck.provider(TopUpFormModule_ProvideTopUpInputItemBlueprint$payment_releaseFactory.create(topUpFormModule, provider6));
        Provider<BubbleItemPresenter> provider7 = DoubleCheck.provider(TopUpFormModule_ProvideBubbleItemPresenter$payment_releaseFactory.create(topUpFormModule, this.n));
        this.s = provider7;
        Provider<BubbleItemBlueprint> provider8 = DoubleCheck.provider(TopUpFormModule_ProvideBubbleItemBlueprint$payment_releaseFactory.create(topUpFormModule, provider7));
        this.t = provider8;
        Provider<ItemBinder> provider9 = DoubleCheck.provider(TopUpFormModule_ProvideRecommendationSectionItemBinder$payment_releaseFactory.create(topUpFormModule, provider8));
        this.u = provider9;
        Provider<AdapterPresenter> provider10 = DoubleCheck.provider(TopUpFormModule_ProvideShortcutSectionAdapterPresenter$payment_releaseFactory.create(topUpFormModule, provider9));
        this.v = provider10;
        this.w = DoubleCheck.provider(TopUpFormModule_ProvideShortcutSectionPresenter$payment_releaseFactory.create(topUpFormModule, provider10));
        Provider<SimpleRecyclerAdapter> provider11 = DoubleCheck.provider(TopUpFormModule_ProvideSimpleRecyclerAdapter$payment_releaseFactory.create(topUpFormModule, this.v, this.u));
        this.x = provider11;
        this.y = DoubleCheck.provider(TopUpFormModule_ProvideShortcutSectionBlueprint$payment_releaseFactory.create(topUpFormModule, this.w, provider11));
        Provider<InfoLabelItemPresenter> provider12 = DoubleCheck.provider(TopUpFormModule_ProvideInfoLabelItemPresenter$payment_releaseFactory.create(topUpFormModule));
        this.z = provider12;
        Provider<InfoLabelBlueprint> provider13 = DoubleCheck.provider(TopUpFormModule_ProvideInfoLabelBlueprint$payment_releaseFactory.create(topUpFormModule, provider12));
        this.A = provider13;
        Provider<ItemBinder> provider14 = DoubleCheck.provider(TopUpFormModule_ProvideItemBinder$payment_releaseFactory.create(topUpFormModule, this.p, this.r, this.y, provider13));
        this.B = provider14;
        Provider<SimpleRecyclerAdapter> provider15 = DoubleCheck.provider(TopUpFormModule_ProvideRecyclerAdapterFactory.create(topUpFormModule, this.m, provider14));
        this.C = provider15;
        this.D = DoubleCheck.provider(TopUpFormModule_ProvideListUpdateListenerFactory.create(topUpFormModule, provider15));
        this.E = DoubleCheck.provider(TopUpFormModule_ProvideAdapterPresenterFactory.create(topUpFormModule, this.B));
        Provider<TopUpFormItemsComparator> provider16 = DoubleCheck.provider(TopUpFormModule_ProvideContentsComparatorFactory.create(topUpFormModule));
        this.F = provider16;
        Provider<DiffCalculator> provider17 = DoubleCheck.provider(TopUpFormModule_ProvideDiffCalculator$payment_releaseFactory.create(topUpFormModule, this.i, provider16));
        this.G = provider17;
        DelegateFactory.setDelegate(this.m, DoubleCheck.provider(TopUpFormModule_ProvideDataAwareAdapterPresenter$payment_releaseFactory.create(topUpFormModule, this.D, this.E, provider17)));
        DelegateFactory.setDelegate(this.n, DoubleCheck.provider(TopUpFormModule_ProvidePaymentGenericFormPresenter$payment_releaseFactory.create(topUpFormModule, this.j, this.i, this.l, this.m)));
    }

    public static TopUpFormComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.TopUpFormComponent
    public void inject(TopUpFormActivity topUpFormActivity) {
        TopUpFormActivity_MembersInjector.injectPresenter(topUpFormActivity, this.n.get());
        TopUpFormActivity_MembersInjector.injectInteractor(topUpFormActivity, this.j.get());
        TopUpFormActivity_MembersInjector.injectAdapter(topUpFormActivity, this.C.get());
        TopUpFormActivity_MembersInjector.injectIntentFactory(topUpFormActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
