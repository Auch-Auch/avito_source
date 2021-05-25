package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter_Factory;
import com.avito.android.delivery.di.component.ReasonDetailsComponent;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideItemBinder$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideRadioGroupItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.ReasonDetailsBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.delivery.di.module.ReasonDetailsModule_ProvideReasonDetailsViewModel$delivery_releaseFactory;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl_Factory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl_Factory;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsFragment_MembersInjector;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverter;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverterImpl_Factory;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelFactory;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelFactory_Factory;
import com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemBlueprint;
import com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemBlueprint_Factory;
import com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemPresenter;
import com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemBlueprint;
import com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemBlueprint_Factory;
import com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemPresenter;
import com.avito.android.delivery.order_cancellation.details.konveyor.title.TitleItemBlueprint;
import com.avito.android.delivery.order_cancellation.details.konveyor.title.TitleItemBlueprint_Factory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerReasonDetailsComponent implements ReasonDetailsComponent {
    public Provider<Fragment> a;
    public Provider<Analytics> b;
    public Provider<DeliveryApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<RdsOrderCancellationInteractorImpl> f;
    public Provider<RdsOrderCancellationInteractor> g;
    public Provider<AccountStateProvider> h;
    public Provider<ReasonDetailsItemsConverter> i = DoubleCheck.provider(ReasonDetailsItemsConverterImpl_Factory.create());
    public Provider<Resources> j;
    public Provider<OrderCancellationResourceProviderImpl> k;
    public Provider<OrderCancellationResourceProvider> l;
    public Provider<ReasonRds> m;
    public Provider<String> n;
    public Provider<ReasonDetailsViewModelFactory> o;
    public Provider<ReasonDetailsViewModel> p;
    public Provider<TitleItemBlueprint> q;
    public Provider<RadioGroupItemPresenter> r;
    public Provider<RadioGroupItemBlueprint> s;
    public Provider<InputItemPresenter> t;
    public Provider<InputItemBlueprint> u;
    public Provider<ItemBinder> v;
    public Provider<AdapterPresenter> w;
    public Provider<SimpleRecyclerAdapter> x;
    public Provider<DiffCalculator> y;
    public Provider<DataAwareAdapterPresenter> z;

    public static final class b implements ReasonDetailsComponent.Builder {
        public Fragment a;
        public Resources b;
        public ReasonRds c;
        public String d;
        public DeliveryDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, ReasonRds.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, DeliveryDependencies.class);
            return new DaggerReasonDetailsComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent.Builder deliveryDependencies(DeliveryDependencies deliveryDependencies) {
            this.e = (DeliveryDependencies) Preconditions.checkNotNull(deliveryDependencies);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent.Builder orderId(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent.Builder reason(ReasonRds reasonRds) {
            this.c = (ReasonRds) Preconditions.checkNotNull(reasonRds);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent.Builder
        public ReasonDetailsComponent.Builder viewModelFragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final DeliveryDependencies a;

        public c(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final DeliveryDependencies a;

        public d(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeliveryApi> {
        public final DeliveryDependencies a;

        public e(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final DeliveryDependencies a;

        public f(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryDependencies a;

        public g(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerReasonDetailsComponent(DeliveryDependencies deliveryDependencies, Fragment fragment, Resources resources, ReasonRds reasonRds, String str, a aVar) {
        this.a = InstanceFactory.create(fragment);
        this.b = new d(deliveryDependencies);
        e eVar = new e(deliveryDependencies);
        this.c = eVar;
        f fVar = new f(deliveryDependencies);
        this.d = fVar;
        g gVar = new g(deliveryDependencies);
        this.e = gVar;
        RdsOrderCancellationInteractorImpl_Factory create = RdsOrderCancellationInteractorImpl_Factory.create(eVar, fVar, gVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new c(deliveryDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.j = create2;
        OrderCancellationResourceProviderImpl_Factory create3 = OrderCancellationResourceProviderImpl_Factory.create(create2);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        this.m = InstanceFactory.create(reasonRds);
        Factory create4 = InstanceFactory.create(str);
        this.n = create4;
        ReasonDetailsViewModelFactory_Factory create5 = ReasonDetailsViewModelFactory_Factory.create(this.b, this.g, this.h, this.i, this.d, this.l, this.m, create4);
        this.o = create5;
        this.p = DoubleCheck.provider(ReasonDetailsModule_ProvideReasonDetailsViewModel$delivery_releaseFactory.create(this.a, create5));
        this.q = TitleItemBlueprint_Factory.create(TitlePresenter_Factory.create());
        Provider<RadioGroupItemPresenter> provider = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideRadioGroupItemPresenter$delivery_releaseFactory.create(this.p));
        this.r = provider;
        this.s = RadioGroupItemBlueprint_Factory.create(provider);
        Provider<InputItemPresenter> provider2 = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideInputItemPresenter$delivery_releaseFactory.create(this.p));
        this.t = provider2;
        InputItemBlueprint_Factory create6 = InputItemBlueprint_Factory.create(provider2);
        this.u = create6;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideItemBinder$delivery_releaseFactory.create(this.q, this.s, create6));
        this.v = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider3));
        this.w = provider4;
        this.x = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider4, this.v));
        Provider<DiffCalculator> provider5 = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory.create());
        this.y = provider5;
        this.z = DoubleCheck.provider(ReasonDetailsBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory.create(this.x, this.w, provider5));
    }

    public static ReasonDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.ReasonDetailsComponent
    public void inject(ReasonDetailsFragment reasonDetailsFragment) {
        ReasonDetailsFragment_MembersInjector.injectViewModel(reasonDetailsFragment, this.p.get());
        ReasonDetailsFragment_MembersInjector.injectRecyclerAdapter(reasonDetailsFragment, this.x.get());
        ReasonDetailsFragment_MembersInjector.injectAdapterPresenter(reasonDetailsFragment, this.z.get());
        ReasonDetailsFragment_MembersInjector.injectResourceProvider(reasonDetailsFragment, this.l.get());
    }
}
