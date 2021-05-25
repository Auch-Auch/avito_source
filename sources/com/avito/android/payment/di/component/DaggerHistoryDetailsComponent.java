package com.avito.android.payment.di.component;

import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.payment.di.component.HistoryDetailsComponent;
import com.avito.android.payment.di.module.HistoryDetailsModule;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideAdapterPresenterFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideAdvertItemBlueprintFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideBaseItemBlueprintFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideButtonItemBlueprintFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideButtonItemPresenterFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideItemBinderFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideSimpleItemBlueprintFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProvideSimpleItemPresenterFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProviderAdvertItemPresenterFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProviderBaseItemPresenterFactory;
import com.avito.android.payment.di.module.HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment;
import com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment_MembersInjector;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsInteractor;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsViewModelFactory;
import com.avito.android.payment.wallet.history.details.item.AdvertItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.AdvertItemPresenter;
import com.avito.android.payment.wallet.history.details.item.BaseItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.BaseItemPresenter;
import com.avito.android.payment.wallet.history.details.item.ButtonItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.ButtonItemPresenter;
import com.avito.android.payment.wallet.history.details.item.SimpleItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.SimpleItemPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerHistoryDetailsComponent implements HistoryDetailsComponent {
    public final PaymentDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<PaymentApi> c;
    public Provider<PaymentHistoryDetailsInteractor> d;
    public Provider<PaymentHistoryDetailsViewModelFactory> e;
    public Provider<AdvertItemPresenter> f;
    public Provider<AdvertItemBlueprint> g;
    public Provider<BaseItemPresenter> h;
    public Provider<BaseItemBlueprint> i;
    public Provider<SimpleItemPresenter> j;
    public Provider<SimpleItemBlueprint> k;
    public Provider<ButtonItemPresenter> l;
    public Provider<ButtonItemBlueprint> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<SimpleRecyclerAdapter> p;

    public static final class b implements HistoryDetailsComponent.Builder {
        public PaymentDependencies a;
        public HistoryDetailsModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.HistoryDetailsComponent.Builder
        public HistoryDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            if (this.b == null) {
                this.b = new HistoryDetailsModule();
            }
            return new DaggerHistoryDetailsComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.payment.di.component.HistoryDetailsComponent.Builder
        public HistoryDetailsComponent.Builder historyDetailsModule(HistoryDetailsModule historyDetailsModule) {
            this.b = (HistoryDetailsModule) Preconditions.checkNotNull(historyDetailsModule);
            return this;
        }

        @Override // com.avito.android.payment.di.component.HistoryDetailsComponent.Builder
        public HistoryDetailsComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }
    }

    public static class c implements Provider<PaymentApi> {
        public final PaymentDependencies a;

        public c(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public d(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerHistoryDetailsComponent(HistoryDetailsModule historyDetailsModule, PaymentDependencies paymentDependencies, a aVar) {
        this.a = paymentDependencies;
        this.b = new d(paymentDependencies);
        c cVar = new c(paymentDependencies);
        this.c = cVar;
        Provider<PaymentHistoryDetailsInteractor> provider = DoubleCheck.provider(HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory.create(historyDetailsModule, cVar));
        this.d = provider;
        this.e = DoubleCheck.provider(HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory.create(historyDetailsModule, this.b, provider));
        Provider<AdvertItemPresenter> provider2 = DoubleCheck.provider(HistoryDetailsModule_ProviderAdvertItemPresenterFactory.create(historyDetailsModule));
        this.f = provider2;
        this.g = DoubleCheck.provider(HistoryDetailsModule_ProvideAdvertItemBlueprintFactory.create(historyDetailsModule, provider2));
        Provider<BaseItemPresenter> provider3 = DoubleCheck.provider(HistoryDetailsModule_ProviderBaseItemPresenterFactory.create(historyDetailsModule));
        this.h = provider3;
        this.i = DoubleCheck.provider(HistoryDetailsModule_ProvideBaseItemBlueprintFactory.create(historyDetailsModule, provider3));
        Provider<SimpleItemPresenter> provider4 = DoubleCheck.provider(HistoryDetailsModule_ProvideSimpleItemPresenterFactory.create(historyDetailsModule));
        this.j = provider4;
        this.k = DoubleCheck.provider(HistoryDetailsModule_ProvideSimpleItemBlueprintFactory.create(historyDetailsModule, provider4));
        Provider<ButtonItemPresenter> provider5 = DoubleCheck.provider(HistoryDetailsModule_ProvideButtonItemPresenterFactory.create(historyDetailsModule));
        this.l = provider5;
        Provider<ButtonItemBlueprint> provider6 = DoubleCheck.provider(HistoryDetailsModule_ProvideButtonItemBlueprintFactory.create(historyDetailsModule, provider5));
        this.m = provider6;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(HistoryDetailsModule_ProvideItemBinderFactory.create(historyDetailsModule, this.g, this.i, this.k, provider6));
        this.n = provider7;
        Provider<AdapterPresenter> provider8 = DoubleCheck.provider(HistoryDetailsModule_ProvideAdapterPresenterFactory.create(historyDetailsModule, provider7));
        this.o = provider8;
        this.p = DoubleCheck.provider(HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory.create(historyDetailsModule, provider8, this.n));
    }

    public static HistoryDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.HistoryDetailsComponent
    public void inject(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment) {
        HistoryDetailsBottomSheetDialogFragment_MembersInjector.injectPaymentHistoryDetailsViewModelFactory(historyDetailsBottomSheetDialogFragment, this.e.get());
        HistoryDetailsBottomSheetDialogFragment_MembersInjector.injectAdapter(historyDetailsBottomSheetDialogFragment, this.p.get());
        HistoryDetailsBottomSheetDialogFragment_MembersInjector.injectAdapterPresenter(historyDetailsBottomSheetDialogFragment, this.o.get());
        HistoryDetailsBottomSheetDialogFragment_MembersInjector.injectFeatures(historyDetailsBottomSheetDialogFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        HistoryDetailsBottomSheetDialogFragment_MembersInjector.injectApplicationInfoProvider(historyDetailsBottomSheetDialogFragment, (ApplicationInfoProvider) Preconditions.checkNotNullFromComponent(this.a.applicationInfoProvider()));
    }
}
