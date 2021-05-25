package com.avito.android.payment.lib.di;

import android.app.Activity;
import androidx.recyclerview.widget.ListUpdateCallback;
import arrow.core.Function1;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.PaymentMethodsContentsComparator;
import com.avito.android.payment.di.module.NativePaymentMethodsModule;
import com.avito.android.payment.di.module.NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.avito.android.payment.lib.PaymentActivity;
import com.avito.android.payment.lib.PaymentActivity_MembersInjector;
import com.avito.android.payment.lib.PaymentGenericInteractor;
import com.avito.android.payment.lib.PaymentMethodsViewModel;
import com.avito.android.payment.lib.PaymentMethodsViewModelFactory;
import com.avito.android.payment.lib.PaymentSessionInteractor;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.lib.di.PaymentMethodsComponent;
import com.avito.android.payment.processing.PaymentStatusPollingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.wallet.PaymentsClient;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import kotlin.Unit;
import ru.avito.component.payments.method.list.material.HorizontalMaterialPaymentMethodBlueprint;
import ru.avito.component.payments.method.list.material.MaterialPaymentMethodItemPresenter;
import ru.avito.component.payments.method.list.material.PaymentMethodWidthProvider;
public final class DaggerPaymentMethodsComponent implements PaymentMethodsComponent {
    public Provider<PaymentMethodsContentsComparator> A;
    public Provider<DiffCalculator> B;
    public Provider<DataAwareAdapterPresenter> C;
    public Provider<DialogRouter> D;
    public final PaymentLibraryDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<PaymentApi> c;
    public Provider<Features> d;
    public Provider<PaymentSessionInteractor> e;
    public Provider<ApplicationInfoProvider> f;
    public Provider<PaymentsClient> g;
    public Provider<GooglePayRequestBuilder> h;
    public Provider<NativeMethodsInteractor> i;
    public Provider<GooglePayInteractor> j;
    public Provider<PaymentGenericInteractor> k = DoubleCheck.provider(PaymentMethodsModule_Declarations_ProvidePaymentGenericInteractorFactory.create(this.c, this.d));
    public Provider<PaymentStatusPollingInteractor> l = DoubleCheck.provider(PaymentMethodsModule_Declarations_ProvidePaymentStatusInteractorFactory.create(this.c));
    public Provider<PaymentSessionType> m;
    public Provider<TypedErrorThrowableConverter> n;
    public Provider<DeepLinkFactory> o;
    public Provider<PaymentMethodsViewModelFactory> p;
    public Provider<Activity> q;
    public Provider<PaymentMethodsViewModel> r;
    public Provider<PaymentMethodWidthProvider> s;
    public Provider<Function1<Integer, Unit>> t;
    public Provider<MaterialPaymentMethodItemPresenter> u;
    public Provider<HorizontalMaterialPaymentMethodBlueprint> v;
    public Provider<ItemBinder> w;
    public Provider<AdapterPresenter> x;
    public Provider<SimpleRecyclerAdapter> y;
    public Provider<ListUpdateCallback> z;

    public static final class b implements PaymentMethodsComponent.Builder {
        public PaymentLibraryDependencies a;
        public Activity b;
        public PaymentSessionType c;
        public Function1<Integer, Unit> d;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        public PaymentMethodsComponent.Builder activity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        public PaymentMethodsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentLibraryDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, PaymentSessionType.class);
            Preconditions.checkBuilderRequirement(this.d, Function1.class);
            return new DaggerPaymentMethodsComponent(new NativePaymentMethodsModule(), this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        public PaymentMethodsComponent.Builder dependencies(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = (PaymentLibraryDependencies) Preconditions.checkNotNull(paymentLibraryDependencies);
            return this;
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        @Deprecated
        public PaymentMethodsComponent.Builder module(PaymentMethodsModule paymentMethodsModule) {
            Preconditions.checkNotNull(paymentMethodsModule);
            return this;
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        public PaymentMethodsComponent.Builder onPaymentMethodClickListener(Function1 function1) {
            this.d = (Function1) Preconditions.checkNotNull(function1);
            return this;
        }

        @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent.Builder
        public PaymentMethodsComponent.Builder paymentSessionType(PaymentSessionType paymentSessionType) {
            this.c = (PaymentSessionType) Preconditions.checkNotNull(paymentSessionType);
            return this;
        }
    }

    public static class c implements Provider<ApplicationInfoProvider> {
        public final PaymentLibraryDependencies a;

        public c(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ApplicationInfoProvider get() {
            return (ApplicationInfoProvider) Preconditions.checkNotNullFromComponent(this.a.appInfoProvider());
        }
    }

    public static class d implements Provider<DeepLinkFactory> {
        public final PaymentLibraryDependencies a;

        public d(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class e implements Provider<Features> {
        public final PaymentLibraryDependencies a;

        public e(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<GooglePayInteractor> {
        public final PaymentLibraryDependencies a;

        public f(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GooglePayInteractor get() {
            return (GooglePayInteractor) Preconditions.checkNotNullFromComponent(this.a.googlePayInteractor());
        }
    }

    public static class g implements Provider<GooglePayRequestBuilder> {
        public final PaymentLibraryDependencies a;

        public g(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GooglePayRequestBuilder get() {
            return (GooglePayRequestBuilder) Preconditions.checkNotNullFromComponent(this.a.googlePayRequest());
        }
    }

    public static class h implements Provider<PaymentApi> {
        public final PaymentLibraryDependencies a;

        public h(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class i implements Provider<PaymentsClient> {
        public final PaymentLibraryDependencies a;

        public i(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentsClient get() {
            return (PaymentsClient) Preconditions.checkNotNullFromComponent(this.a.paymentsClient());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final PaymentLibraryDependencies a;

        public j(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class k implements Provider<TypedErrorThrowableConverter> {
        public final PaymentLibraryDependencies a;

        public k(PaymentLibraryDependencies paymentLibraryDependencies) {
            this.a = paymentLibraryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerPaymentMethodsComponent(NativePaymentMethodsModule nativePaymentMethodsModule, PaymentLibraryDependencies paymentLibraryDependencies, Activity activity, PaymentSessionType paymentSessionType, Function1 function1, a aVar) {
        this.a = paymentLibraryDependencies;
        this.b = new j(paymentLibraryDependencies);
        h hVar = new h(paymentLibraryDependencies);
        this.c = hVar;
        e eVar = new e(paymentLibraryDependencies);
        this.d = eVar;
        this.e = DoubleCheck.provider(PaymentMethodsModule_Declarations_ProvidePaymentMethodsInteractorFactory.create(hVar, eVar));
        c cVar = new c(paymentLibraryDependencies);
        this.f = cVar;
        i iVar = new i(paymentLibraryDependencies);
        this.g = iVar;
        g gVar = new g(paymentLibraryDependencies);
        this.h = gVar;
        this.i = NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory.create(nativePaymentMethodsModule, cVar, iVar, gVar, this.d);
        this.j = new f(paymentLibraryDependencies);
        Factory create = InstanceFactory.create(paymentSessionType);
        this.m = create;
        k kVar = new k(paymentLibraryDependencies);
        this.n = kVar;
        d dVar = new d(paymentLibraryDependencies);
        this.o = dVar;
        this.p = DoubleCheck.provider(PaymentMethodsModule_Declarations_BindViewModuleFactoryFactory.create(this.b, this.e, this.i, this.j, this.k, this.l, create, kVar, dVar));
        Factory create2 = InstanceFactory.create(activity);
        this.q = create2;
        this.r = DoubleCheck.provider(PaymentMethodsModule_ProvideViewModelFactory.create(this.p, create2));
        this.s = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvidePaymentMethodWidthProvider$payment_lib_releaseFactory.create(this.q));
        Factory create3 = InstanceFactory.create(function1);
        this.t = create3;
        Provider<MaterialPaymentMethodItemPresenter> provider = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideMaterialPaymentMethodItemPresenter$payment_lib_releaseFactory.create(create3));
        this.u = provider;
        Provider<HorizontalMaterialPaymentMethodBlueprint> provider2 = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideHorizontalMaterialPaymentMethodBlueprint$payment_lib_releaseFactory.create(this.s, provider));
        this.v = provider2;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideItemBinder$payment_lib_releaseFactory.create(provider2));
        this.w = provider3;
        this.x = DoubleCheck.provider(PaymentMethodsModule_ProvideAdapterPresenterFactory.create(provider3));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.y = delegateFactory;
        this.z = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideListUpdateListenerFactory.create(delegateFactory));
        Provider<PaymentMethodsContentsComparator> provider4 = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideContentsComparatorFactory.create());
        this.A = provider4;
        Provider<DiffCalculator> provider5 = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideDiffCalculator$payment_lib_releaseFactory.create(provider4));
        this.B = provider5;
        Provider<DataAwareAdapterPresenter> provider6 = DoubleCheck.provider(PaymentMethodsModule_RecyclerViewDeclarations_ProvideDataAwareAdapterPresenter$payment_lib_releaseFactory.create(this.z, this.x, provider5));
        this.C = provider6;
        DelegateFactory.setDelegate(this.y, DoubleCheck.provider(PaymentMethodsModule_ProvideRecyclerAdapterFactory.create(provider6, this.w)));
        this.D = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.q));
    }

    public static PaymentMethodsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.lib.di.PaymentMethodsComponent
    public void inject(PaymentActivity paymentActivity) {
        PaymentActivity_MembersInjector.injectPaymentMethodsViewModel(paymentActivity, this.r.get());
        PaymentActivity_MembersInjector.injectAdapterPresenter(paymentActivity, this.x.get());
        PaymentActivity_MembersInjector.injectSimpleRecyclerViewAdapter(paymentActivity, this.y.get());
        PaymentActivity_MembersInjector.injectIntentFactory(paymentActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PaymentActivity_MembersInjector.injectDeepLinkIntentFactory(paymentActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        PaymentActivity_MembersInjector.injectDialogRouter(paymentActivity, this.D.get());
    }
}
