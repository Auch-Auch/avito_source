package com.avito.android.safedeal.delivery_type.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.delivery_type.DeliveryTypeData;
import com.avito.android.safedeal.delivery_type.DeliveryTypeFragment;
import com.avito.android.safedeal.delivery_type.DeliveryTypeFragment_MembersInjector;
import com.avito.android.safedeal.delivery_type.DeliveryTypeInteractor;
import com.avito.android.safedeal.delivery_type.DeliveryTypeInteractorImpl;
import com.avito.android.safedeal.delivery_type.DeliveryTypeInteractorImpl_Factory;
import com.avito.android.safedeal.delivery_type.DeliveryTypePresenter;
import com.avito.android.safedeal.delivery_type.DeliveryTypePresenterImpl;
import com.avito.android.safedeal.delivery_type.DeliveryTypePresenterImpl_Factory;
import com.avito.android.safedeal.delivery_type.di.DeliveryTypeComponent;
import com.avito.android.safedeal.delivery_type.items.button.ButtonBlueprint;
import com.avito.android.safedeal.delivery_type.items.button.ButtonBlueprint_Factory;
import com.avito.android.safedeal.delivery_type.items.button.ButtonPresenter;
import com.avito.android.safedeal.delivery_type.items.button.ButtonPresenterImpl;
import com.avito.android.safedeal.delivery_type.items.button.ButtonPresenterImpl_Factory;
import com.avito.android.safedeal.delivery_type.items.skeleton.SkeletonBlueprint;
import com.avito.android.safedeal.delivery_type.items.skeleton.SkeletonBlueprint_Factory;
import com.avito.android.safedeal.delivery_type.items.skeleton.SkeletonPresenter;
import com.avito.android.safedeal.delivery_type.items.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitleBlueprint;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitleBlueprint_Factory;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitlePresenter;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitlePresenterImpl;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitlePresenterImpl_Factory;
import com.avito.android.safedeal.delivery_type.items.title.TitleBlueprint;
import com.avito.android.safedeal.delivery_type.items.title.TitleBlueprint_Factory;
import com.avito.android.safedeal.delivery_type.items.title.TitlePresenter;
import com.avito.android.safedeal.delivery_type.items.title.TitlePresenterImpl;
import com.avito.android.safedeal.delivery_type.items.title.TitlePresenterImpl_Factory;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerDeliveryTypeComponent implements DeliveryTypeComponent {
    public Provider<ButtonPresenterImpl> A;
    public Provider<ButtonPresenter> B;
    public Provider<ButtonBlueprint> C;
    public Provider<ItemBlueprint<?, ?>> D;
    public Provider<Set<ItemBlueprint<?, ?>>> E;
    public Provider<ItemBinder> F;
    public Provider<AdapterPresenter> G;
    public Provider<DestroyableViewHolderBuilder> H;
    public Provider<BuildInfo> I;
    public Provider<SafeRecyclerAdapter> J;
    public final DeliveryTypeDependencies a;
    public Provider<DeliveryTypeData> b;
    public Provider<SafeDealApi> c;
    public Provider<SchedulersFactory3> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<DeliveryTypeInteractorImpl> f;
    public Provider<DeliveryTypeInteractor> g;
    public Provider<IdProvider> h;
    public Provider<AccountStateProvider> i;
    public Provider<Analytics> j;
    public Provider<Features> k;
    public Provider<DeliveryTypePresenterImpl> l;
    public Provider<DeliveryTypePresenter> m;
    public Provider<SkeletonPresenter> n;
    public Provider<SkeletonBlueprint> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<Context> q;
    public Provider<AttributedTextFormatter> r;
    public Provider<TitlePresenterImpl> s;
    public Provider<TitlePresenter> t;
    public Provider<TitleBlueprint> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<SubTitlePresenterImpl> w;
    public Provider<SubTitlePresenter> x;
    public Provider<SubTitleBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements DeliveryTypeComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.safedeal.delivery_type.di.DeliveryTypeComponent.Factory
        public DeliveryTypeComponent create(DeliveryTypeDependencies deliveryTypeDependencies, DeliveryTypeData deliveryTypeData, Resources resources) {
            Preconditions.checkNotNull(deliveryTypeDependencies);
            Preconditions.checkNotNull(deliveryTypeData);
            Preconditions.checkNotNull(resources);
            return new DaggerDeliveryTypeComponent(deliveryTypeDependencies, deliveryTypeData, resources, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final DeliveryTypeDependencies a;

        public c(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final DeliveryTypeDependencies a;

        public d(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final DeliveryTypeDependencies a;

        public e(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<Context> {
        public final DeliveryTypeDependencies a;

        public f(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class g implements Provider<Features> {
        public final DeliveryTypeDependencies a;

        public g(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<IdProvider> {
        public final DeliveryTypeDependencies a;

        public h(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public IdProvider get() {
            return (IdProvider) Preconditions.checkNotNullFromComponent(this.a.idProvider());
        }
    }

    public static class i implements Provider<SafeDealApi> {
        public final DeliveryTypeDependencies a;

        public i(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SafeDealApi get() {
            return (SafeDealApi) Preconditions.checkNotNullFromComponent(this.a.safeDealApi());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final DeliveryTypeDependencies a;

        public j(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class k implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryTypeDependencies a;

        public k(DeliveryTypeDependencies deliveryTypeDependencies) {
            this.a = deliveryTypeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryTypeComponent(DeliveryTypeDependencies deliveryTypeDependencies, DeliveryTypeData deliveryTypeData, Resources resources, a aVar) {
        this.a = deliveryTypeDependencies;
        Factory create = InstanceFactory.create(deliveryTypeData);
        this.b = create;
        i iVar = new i(deliveryTypeDependencies);
        this.c = iVar;
        j jVar = new j(deliveryTypeDependencies);
        this.d = jVar;
        k kVar = new k(deliveryTypeDependencies);
        this.e = kVar;
        DeliveryTypeInteractorImpl_Factory create2 = DeliveryTypeInteractorImpl_Factory.create(create, iVar, jVar, kVar);
        this.f = create2;
        Provider<DeliveryTypeInteractor> provider = DoubleCheck.provider(create2);
        this.g = provider;
        h hVar = new h(deliveryTypeDependencies);
        this.h = hVar;
        c cVar = new c(deliveryTypeDependencies);
        this.i = cVar;
        d dVar = new d(deliveryTypeDependencies);
        this.j = dVar;
        g gVar = new g(deliveryTypeDependencies);
        this.k = gVar;
        DeliveryTypePresenterImpl_Factory create3 = DeliveryTypePresenterImpl_Factory.create(provider, hVar, this.d, cVar, this.b, dVar, gVar);
        this.l = create3;
        this.m = DoubleCheck.provider(create3);
        Provider<SkeletonPresenter> provider2 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.n = provider2;
        SkeletonBlueprint_Factory create4 = SkeletonBlueprint_Factory.create(provider2);
        this.o = create4;
        this.p = DoubleCheck.provider(create4);
        this.q = new f(deliveryTypeDependencies);
        Provider<AttributedTextFormatter> provider3 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.r = provider3;
        TitlePresenterImpl_Factory create5 = TitlePresenterImpl_Factory.create(this.q, provider3);
        this.s = create5;
        Provider<TitlePresenter> provider4 = DoubleCheck.provider(create5);
        this.t = provider4;
        TitleBlueprint_Factory create6 = TitleBlueprint_Factory.create(provider4);
        this.u = create6;
        this.v = DoubleCheck.provider(create6);
        SubTitlePresenterImpl_Factory create7 = SubTitlePresenterImpl_Factory.create(this.q, this.r);
        this.w = create7;
        Provider<SubTitlePresenter> provider5 = DoubleCheck.provider(create7);
        this.x = provider5;
        SubTitleBlueprint_Factory create8 = SubTitleBlueprint_Factory.create(provider5);
        this.y = create8;
        this.z = DoubleCheck.provider(create8);
        ButtonPresenterImpl_Factory create9 = ButtonPresenterImpl_Factory.create(this.m, this.r);
        this.A = create9;
        Provider<ButtonPresenter> provider6 = DoubleCheck.provider(create9);
        this.B = provider6;
        ButtonBlueprint_Factory create10 = ButtonBlueprint_Factory.create(provider6);
        this.C = create10;
        this.D = DoubleCheck.provider(create10);
        SetFactory build = SetFactory.builder(4, 0).addProvider(this.p).addProvider(this.v).addProvider(this.z).addProvider(this.D).build();
        this.E = build;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(DeliveryTypeModule_ProvideItemBinderFactory.create(build));
        this.F = provider7;
        this.G = DoubleCheck.provider(DeliveryTypeModule_ProvideAdapterPresenter$safedeal_releaseFactory.create(provider7));
        Provider<DestroyableViewHolderBuilder> provider8 = DoubleCheck.provider(DeliveryTypeModule_ProvideDestroyableViewHolderBuilder$safedeal_releaseFactory.create(this.F));
        this.H = provider8;
        e eVar = new e(deliveryTypeDependencies);
        this.I = eVar;
        this.J = DoubleCheck.provider(DeliveryTypeModule_ProvideSafeRecyclerAdapter$safedeal_releaseFactory.create(this.G, provider8, eVar, this.j));
    }

    public static DeliveryTypeComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.safedeal.delivery_type.di.DeliveryTypeComponent
    public void inject(DeliveryTypeFragment deliveryTypeFragment) {
        DeliveryTypeFragment_MembersInjector.injectDeepLinkIntentFactory(deliveryTypeFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DeliveryTypeFragment_MembersInjector.injectImplicitIntentFactory(deliveryTypeFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        DeliveryTypeFragment_MembersInjector.injectActivityIntentFactory(deliveryTypeFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DeliveryTypeFragment_MembersInjector.injectPresenter(deliveryTypeFragment, this.m.get());
        DeliveryTypeFragment_MembersInjector.injectAdapterPresenter(deliveryTypeFragment, this.G.get());
        DeliveryTypeFragment_MembersInjector.injectRecyclerAdapter(deliveryTypeFragment, this.J.get());
        DeliveryTypeFragment_MembersInjector.injectDestroyableViewHolderBuilder(deliveryTypeFragment, this.H.get());
        DeliveryTypeFragment_MembersInjector.injectAttributedTextFormatter(deliveryTypeFragment, this.r.get());
    }
}
