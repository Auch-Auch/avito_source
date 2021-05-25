package com.avito.android.developments_catalog.di;

import android.app.Activity;
import android.content.Context;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.advert_core.aler_banner.AlertBannerBlueprint;
import com.avito.android.advert_core.aler_banner.AlertBannerBlueprint_Factory;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenter;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenterImpl_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenter;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenterImpl_Factory;
import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.advert_core.map.MapPresenterImpl_Factory;
import com.avito.android.advert_core.map.di.MapModule_ProvideMapBlueprintFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragment;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragment_MembersInjector;
import com.avito.android.developments_catalog.DevelopmentsCatalogInteractor;
import com.avito.android.developments_catalog.DevelopmentsCatalogInteractorImpl;
import com.avito.android.developments_catalog.DevelopmentsCatalogInteractorImpl_Factory;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl_Factory;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractorImpl;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractorImpl_Factory;
import com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent;
import com.avito.android.developments_catalog.items.address.AddressBlueprint;
import com.avito.android.developments_catalog.items.address.AddressBlueprint_Factory;
import com.avito.android.developments_catalog.items.address.AddressPresenter;
import com.avito.android.developments_catalog.items.address.AddressPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersBlueprint;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersBlueprint_Factory;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersPresenter;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersPresenterImpl;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOffersPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressBlueprint;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressBlueprint_Factory;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenter;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.consultation.ConsultationBlueprint;
import com.avito.android.developments_catalog.items.consultation.ConsultationBlueprint_Factory;
import com.avito.android.developments_catalog.items.consultation.ConsultationPresenter;
import com.avito.android.developments_catalog.items.consultation.ConsultationPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.contactbar.ContactsBlueprint;
import com.avito.android.developments_catalog.items.contactbar.ContactsBlueprint_Factory;
import com.avito.android.developments_catalog.items.contactbar.ContactsPresenter;
import com.avito.android.developments_catalog.items.contactbar.ContactsPresenterImpl;
import com.avito.android.developments_catalog.items.contactbar.ContactsPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.description.DescriptionBlueprint;
import com.avito.android.developments_catalog.items.description.DescriptionBlueprint_Factory;
import com.avito.android.developments_catalog.items.description.DescriptionPresenter;
import com.avito.android.developments_catalog.items.description.DescriptionPresenterImpl;
import com.avito.android.developments_catalog.items.description.DescriptionPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerBlueprint;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerBlueprint_Factory;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerPresenter;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerPresenterImpl;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.divider.DividerBlueprint;
import com.avito.android.developments_catalog.items.divider.DividerBlueprint_Factory;
import com.avito.android.developments_catalog.items.divider.DividerPresenter;
import com.avito.android.developments_catalog.items.divider.DividerPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.infoParams.InfoParamsBlueprint;
import com.avito.android.developments_catalog.items.infoParams.InfoParamsBlueprint_Factory;
import com.avito.android.developments_catalog.items.infoParams.InfoParamsPresenter;
import com.avito.android.developments_catalog.items.infoParams.InfoParamsPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.metro.MetroBlueprint;
import com.avito.android.developments_catalog.items.metro.MetroBlueprint_Factory;
import com.avito.android.developments_catalog.items.metro.MetroPresenter;
import com.avito.android.developments_catalog.items.metro.MetroPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.params.ParamsBlueprint;
import com.avito.android.developments_catalog.items.params.ParamsBlueprint_Factory;
import com.avito.android.developments_catalog.items.params.ParamsPresenter;
import com.avito.android.developments_catalog.items.params.ParamsPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryBlueprint;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryBlueprint_Factory;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenter;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenterImpl;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.skeleton.SkeletonBlueprint;
import com.avito.android.developments_catalog.items.skeleton.SkeletonBlueprint_Factory;
import com.avito.android.developments_catalog.items.skeleton.SkeletonPresenter;
import com.avito.android.developments_catalog.items.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.developments_catalog.items.title.TitleBlueprint;
import com.avito.android.developments_catalog.items.title.TitleBlueprint_Factory;
import com.avito.android.developments_catalog.items.title.TitlePresenter;
import com.avito.android.developments_catalog.items.title.TitlePresenterImpl_Factory;
import com.avito.android.developments_catalog.remote.DevelopmentsCatalogApi;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTracker;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTrackerImpl;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTrackerImpl_Factory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory3;
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
public final class DaggerDevelopmentsCatalogComponent implements DevelopmentsCatalogComponent {
    public Provider<DevelopmentsCatalogFragmentManagerDelegate> A;
    public Provider<ItemBinder> A0;
    public Provider<PhotoGalleryPresenterImpl> B;
    public Provider<AdapterPresenter> B0;
    public Provider<PhotoGalleryPresenter> C;
    public Provider<DestroyableViewHolderBuilder> C0;
    public Provider<ImplicitIntentFactory> D;
    public Provider<BuildInfo> D0;
    public Provider<PhotoGalleryBlueprint> E;
    public Provider<SafeRecyclerAdapter> E0;
    public Provider<ItemBlueprint<?, ?>> F;
    public Provider<Formatter<String>> F0;
    public Provider<ContactsPresenterImpl> G;
    public Provider<Activity> G0;
    public Provider<ContactsPresenter> H;
    public Provider<DialogRouter> H0;
    public Provider<ContactsBlueprint> I;
    public Provider<ScreenTrackerFactory> I0;
    public Provider<ItemBlueprint<?, ?>> J;
    public Provider<TimerFactory> J0;
    public Provider<MetroPresenter> K;
    public Provider<DevelopmentsCatalogTrackerImpl> K0;
    public Provider<MetroBlueprint> L;
    public Provider<DevelopmentsCatalogTracker> L0;
    public Provider<ItemBlueprint<?, ?>> M;
    public Provider<AddressPresenter> N;
    public Provider<AddressBlueprint> O;
    public Provider<ItemBlueprint<?, ?>> P;
    public Provider<AvitoOffersPresenterImpl> Q;
    public Provider<AvitoOffersPresenter> R;
    public Provider<AvitoOffersBlueprint> S;
    public Provider<ItemBlueprint<?, ?>> T;
    public Provider<ParamsPresenter> U;
    public Provider<ParamsBlueprint> V;
    public Provider<ItemBlueprint<?, ?>> W;
    public Provider<DescriptionPresenterImpl> X;
    public Provider<DescriptionPresenter> Y;
    public Provider<DescriptionBlueprint> Z;
    public final DevelopmentsCatalogDependencies a;
    public Provider<ItemBlueprint<?, ?>> a0;
    public Provider<String> b;
    public Provider<AdvertDetailsGapPresenter> b0;
    public Provider<String> c;
    public Provider<AdvertDetailsGapBlueprint> c0;
    public Provider<String> d;
    public Provider<ItemBlueprint<?, ?>> d0;
    public Provider<String> e;
    public Provider<DividerPresenter> e0;
    public Provider<DevelopmentsCatalogApi> f;
    public Provider<DividerBlueprint> f0;
    public Provider<SchedulersFactory3> g;
    public Provider<ItemBlueprint<?, ?>> g0;
    public Provider<TypedErrorThrowableConverter> h;
    public Provider<DisclaimerPresenterImpl> h0;
    public Provider<Features> i;
    public Provider<DisclaimerPresenter> i0;
    public Provider<DevelopmentsCatalogInteractorImpl> j;
    public Provider<DisclaimerBlueprint> j0;
    public Provider<DevelopmentsCatalogInteractor> k;
    public Provider<ItemBlueprint<?, ?>> k0;
    public Provider<Analytics> l;
    public Provider<BuildingProgressPresenter> l0;
    public Provider<DevelopmentsCatalogAnalyticsInteractorImpl> m;
    public Provider<BuildingProgressBlueprint> m0;
    public Provider<DevelopmentsCatalogAnalyticsInteractor> n;
    public Provider<ItemBlueprint<?, ?>> n0;
    public Provider<IdProvider> o;
    public Provider<AlertBannerPresenter> o0;
    public Provider<DevelopmentsCatalogPresenterImpl> p;
    public Provider<AlertBannerBlueprint> p0;
    public Provider<DevelopmentsCatalogPresenter> q;
    public Provider<ItemBlueprint<?, ?>> q0;
    public Provider<SkeletonPresenter> r;
    public Provider<ConsultationPresenter> r0;
    public Provider<SkeletonBlueprint> s;
    public Provider<ConsultationBlueprint> s0;
    public Provider<ItemBlueprint<?, ?>> t;
    public Provider<ItemBlueprint<?, ?>> t0;
    public Provider<TitlePresenter> u;
    public Provider<Set<ItemBlueprint<?, ?>>> u0 = SetFactory.builder(16, 0).addProvider(this.t).addProvider(this.w).addProvider(this.z).addProvider(this.F).addProvider(this.J).addProvider(this.M).addProvider(this.P).addProvider(this.T).addProvider(this.W).addProvider(this.a0).addProvider(this.d0).addProvider(this.g0).addProvider(this.k0).addProvider(this.n0).addProvider(this.q0).addProvider(this.t0).build();
    public Provider<TitleBlueprint> v;
    public Provider<MapPresenter> v0 = DoubleCheck.provider(MapPresenterImpl_Factory.create());
    public Provider<ItemBlueprint<?, ?>> w;
    public Provider<Context> w0;
    public Provider<InfoParamsPresenter> x;
    public Provider<AmenityMarkerIconFactoryImpl> x0;
    public Provider<InfoParamsBlueprint> y;
    public Provider<AmenityMarkerIconFactory> y0;
    public Provider<ItemBlueprint<?, ?>> z;
    public Provider<MapBlueprint> z0;

    public static final class b implements DevelopmentsCatalogComponent.Builder {
        public DevelopmentsCatalogDependencies a;
        public Activity b;
        public String c;
        public String d;
        public String e;
        public String f;
        public DevelopmentsCatalogFragmentManagerDelegate g;

        public b(a aVar) {
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DevelopmentsCatalogDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, DevelopmentsCatalogFragmentManagerDelegate.class);
            return new DaggerDevelopmentsCatalogComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder developmentsCatalogDependencies(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = (DevelopmentsCatalogDependencies) Preconditions.checkNotNull(developmentsCatalogDependencies);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withDevelopmentsId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withDevelopmentsTitle(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withFragmentManagerDelegate(DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate) {
            this.g = (DevelopmentsCatalogFragmentManagerDelegate) Preconditions.checkNotNull(developmentsCatalogFragmentManagerDelegate);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withFromPage(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent.Builder
        public DevelopmentsCatalogComponent.Builder withSearchContext(String str) {
            this.e = str;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final DevelopmentsCatalogDependencies a;

        public c(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final DevelopmentsCatalogDependencies a;

        public d(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<Context> {
        public final DevelopmentsCatalogDependencies a;

        public e(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class f implements Provider<DevelopmentsCatalogApi> {
        public final DevelopmentsCatalogDependencies a;

        public f(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DevelopmentsCatalogApi get() {
            return (DevelopmentsCatalogApi) Preconditions.checkNotNullFromComponent(this.a.developmentsCatalogApi());
        }
    }

    public static class g implements Provider<Features> {
        public final DevelopmentsCatalogDependencies a;

        public g(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<IdProvider> {
        public final DevelopmentsCatalogDependencies a;

        public h(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public IdProvider get() {
            return (IdProvider) Preconditions.checkNotNullFromComponent(this.a.idProvider());
        }
    }

    public static class i implements Provider<ImplicitIntentFactory> {
        public final DevelopmentsCatalogDependencies a;

        public i(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ImplicitIntentFactory get() {
            return (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final DevelopmentsCatalogDependencies a;

        public j(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class k implements Provider<ScreenTrackerFactory> {
        public final DevelopmentsCatalogDependencies a;

        public k(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class l implements Provider<TimerFactory> {
        public final DevelopmentsCatalogDependencies a;

        public l(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class m implements Provider<TypedErrorThrowableConverter> {
        public final DevelopmentsCatalogDependencies a;

        public m(DevelopmentsCatalogDependencies developmentsCatalogDependencies) {
            this.a = developmentsCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDevelopmentsCatalogComponent(DevelopmentsCatalogDependencies developmentsCatalogDependencies, Activity activity, String str, String str2, String str3, String str4, DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, a aVar) {
        this.a = developmentsCatalogDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(str2);
        this.d = InstanceFactory.createNullable(str3);
        this.e = InstanceFactory.create(str4);
        f fVar = new f(developmentsCatalogDependencies);
        this.f = fVar;
        j jVar = new j(developmentsCatalogDependencies);
        this.g = jVar;
        m mVar = new m(developmentsCatalogDependencies);
        this.h = mVar;
        g gVar = new g(developmentsCatalogDependencies);
        this.i = gVar;
        DevelopmentsCatalogInteractorImpl_Factory create = DevelopmentsCatalogInteractorImpl_Factory.create(fVar, jVar, mVar, gVar);
        this.j = create;
        this.k = DoubleCheck.provider(create);
        c cVar = new c(developmentsCatalogDependencies);
        this.l = cVar;
        DevelopmentsCatalogAnalyticsInteractorImpl_Factory create2 = DevelopmentsCatalogAnalyticsInteractorImpl_Factory.create(cVar);
        this.m = create2;
        Provider<DevelopmentsCatalogAnalyticsInteractor> provider = DoubleCheck.provider(create2);
        this.n = provider;
        h hVar = new h(developmentsCatalogDependencies);
        this.o = hVar;
        DevelopmentsCatalogPresenterImpl_Factory create3 = DevelopmentsCatalogPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, this.k, provider, hVar, this.g, this.i);
        this.p = create3;
        this.q = DoubleCheck.provider(create3);
        Provider<SkeletonPresenter> provider2 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.r = provider2;
        SkeletonBlueprint_Factory create4 = SkeletonBlueprint_Factory.create(provider2);
        this.s = create4;
        this.t = DoubleCheck.provider(create4);
        Provider<TitlePresenter> provider3 = DoubleCheck.provider(TitlePresenterImpl_Factory.create());
        this.u = provider3;
        TitleBlueprint_Factory create5 = TitleBlueprint_Factory.create(provider3);
        this.v = create5;
        this.w = DoubleCheck.provider(create5);
        Provider<InfoParamsPresenter> provider4 = DoubleCheck.provider(InfoParamsPresenterImpl_Factory.create());
        this.x = provider4;
        InfoParamsBlueprint_Factory create6 = InfoParamsBlueprint_Factory.create(provider4);
        this.y = create6;
        this.z = DoubleCheck.provider(create6);
        Factory create7 = InstanceFactory.create(developmentsCatalogFragmentManagerDelegate);
        this.A = create7;
        PhotoGalleryPresenterImpl_Factory create8 = PhotoGalleryPresenterImpl_Factory.create(this.d, create7, this.q);
        this.B = create8;
        Provider<PhotoGalleryPresenter> provider5 = DoubleCheck.provider(create8);
        this.C = provider5;
        i iVar = new i(developmentsCatalogDependencies);
        this.D = iVar;
        PhotoGalleryBlueprint_Factory create9 = PhotoGalleryBlueprint_Factory.create(provider5, iVar, this.l);
        this.E = create9;
        this.F = DoubleCheck.provider(create9);
        ContactsPresenterImpl_Factory create10 = ContactsPresenterImpl_Factory.create(this.q);
        this.G = create10;
        Provider<ContactsPresenter> provider6 = DoubleCheck.provider(create10);
        this.H = provider6;
        ContactsBlueprint_Factory create11 = ContactsBlueprint_Factory.create(provider6);
        this.I = create11;
        this.J = DoubleCheck.provider(create11);
        Provider<MetroPresenter> provider7 = DoubleCheck.provider(MetroPresenterImpl_Factory.create());
        this.K = provider7;
        MetroBlueprint_Factory create12 = MetroBlueprint_Factory.create(provider7);
        this.L = create12;
        this.M = DoubleCheck.provider(create12);
        Provider<AddressPresenter> provider8 = DoubleCheck.provider(AddressPresenterImpl_Factory.create());
        this.N = provider8;
        AddressBlueprint_Factory create13 = AddressBlueprint_Factory.create(provider8);
        this.O = create13;
        this.P = DoubleCheck.provider(create13);
        AvitoOffersPresenterImpl_Factory create14 = AvitoOffersPresenterImpl_Factory.create(this.q);
        this.Q = create14;
        Provider<AvitoOffersPresenter> provider9 = DoubleCheck.provider(create14);
        this.R = provider9;
        AvitoOffersBlueprint_Factory create15 = AvitoOffersBlueprint_Factory.create(provider9);
        this.S = create15;
        this.T = DoubleCheck.provider(create15);
        Provider<ParamsPresenter> provider10 = DoubleCheck.provider(ParamsPresenterImpl_Factory.create());
        this.U = provider10;
        ParamsBlueprint_Factory create16 = ParamsBlueprint_Factory.create(provider10);
        this.V = create16;
        this.W = DoubleCheck.provider(create16);
        DescriptionPresenterImpl_Factory create17 = DescriptionPresenterImpl_Factory.create(this.q);
        this.X = create17;
        Provider<DescriptionPresenter> provider11 = DoubleCheck.provider(create17);
        this.Y = provider11;
        DescriptionBlueprint_Factory create18 = DescriptionBlueprint_Factory.create(provider11);
        this.Z = create18;
        this.a0 = DoubleCheck.provider(create18);
        Provider<AdvertDetailsGapPresenter> provider12 = DoubleCheck.provider(AdvertDetailsGapPresenterImpl_Factory.create());
        this.b0 = provider12;
        AdvertDetailsGapBlueprint_Factory create19 = AdvertDetailsGapBlueprint_Factory.create(provider12);
        this.c0 = create19;
        this.d0 = DoubleCheck.provider(create19);
        Provider<DividerPresenter> provider13 = DoubleCheck.provider(DividerPresenterImpl_Factory.create());
        this.e0 = provider13;
        DividerBlueprint_Factory create20 = DividerBlueprint_Factory.create(provider13);
        this.f0 = create20;
        this.g0 = DoubleCheck.provider(create20);
        DisclaimerPresenterImpl_Factory create21 = DisclaimerPresenterImpl_Factory.create(this.q);
        this.h0 = create21;
        Provider<DisclaimerPresenter> provider14 = DoubleCheck.provider(create21);
        this.i0 = provider14;
        DisclaimerBlueprint_Factory create22 = DisclaimerBlueprint_Factory.create(provider14);
        this.j0 = create22;
        this.k0 = DoubleCheck.provider(create22);
        Provider<BuildingProgressPresenter> provider15 = DoubleCheck.provider(BuildingProgressPresenterImpl_Factory.create());
        this.l0 = provider15;
        BuildingProgressBlueprint_Factory create23 = BuildingProgressBlueprint_Factory.create(provider15);
        this.m0 = create23;
        this.n0 = DoubleCheck.provider(create23);
        Provider<AlertBannerPresenter> provider16 = DoubleCheck.provider(AlertBannerPresenterImpl_Factory.create());
        this.o0 = provider16;
        AlertBannerBlueprint_Factory create24 = AlertBannerBlueprint_Factory.create(provider16);
        this.p0 = create24;
        this.q0 = DoubleCheck.provider(create24);
        Provider<ConsultationPresenter> provider17 = DoubleCheck.provider(ConsultationPresenterImpl_Factory.create());
        this.r0 = provider17;
        ConsultationBlueprint_Factory create25 = ConsultationBlueprint_Factory.create(provider17);
        this.s0 = create25;
        this.t0 = DoubleCheck.provider(create25);
        e eVar = new e(developmentsCatalogDependencies);
        this.w0 = eVar;
        AmenityMarkerIconFactoryImpl_Factory create26 = AmenityMarkerIconFactoryImpl_Factory.create(eVar);
        this.x0 = create26;
        Provider<AmenityMarkerIconFactory> provider18 = DoubleCheck.provider(create26);
        this.y0 = provider18;
        Provider<MapBlueprint> provider19 = DoubleCheck.provider(MapModule_ProvideMapBlueprintFactory.create(this.v0, this.i, provider18));
        this.z0 = provider19;
        Provider<ItemBinder> provider20 = DoubleCheck.provider(DevelopmentsCatalogModule_ProvideItemBinderFactory.create(this.u0, provider19));
        this.A0 = provider20;
        this.B0 = DoubleCheck.provider(DevelopmentsCatalogModule_ProvideAdapterPresenter$developments_catalog_releaseFactory.create(provider20));
        Provider<DestroyableViewHolderBuilder> provider21 = DoubleCheck.provider(DevelopmentsCatalogModule_ProvideDestroyableViewHolderBuilder$developments_catalog_releaseFactory.create(this.A0));
        this.C0 = provider21;
        d dVar = new d(developmentsCatalogDependencies);
        this.D0 = dVar;
        this.E0 = DoubleCheck.provider(DevelopmentsCatalogModule_ProvideSafeRecyclerAdapter$developments_catalog_releaseFactory.create(this.B0, provider21, dVar, this.l));
        this.F0 = DoubleCheck.provider(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create());
        Factory create27 = InstanceFactory.create(activity);
        this.G0 = create27;
        this.H0 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create27));
        k kVar = new k(developmentsCatalogDependencies);
        this.I0 = kVar;
        l lVar = new l(developmentsCatalogDependencies);
        this.J0 = lVar;
        DevelopmentsCatalogTrackerImpl_Factory create28 = DevelopmentsCatalogTrackerImpl_Factory.create(kVar, lVar);
        this.K0 = create28;
        this.L0 = DoubleCheck.provider(create28);
    }

    public static DevelopmentsCatalogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent
    public void inject(DevelopmentsCatalogFragment developmentsCatalogFragment) {
        DevelopmentsCatalogFragment_MembersInjector.injectDeepLinkIntentFactory(developmentsCatalogFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DevelopmentsCatalogFragment_MembersInjector.injectImplicitIntentFactory(developmentsCatalogFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        DevelopmentsCatalogFragment_MembersInjector.injectActivityIntentFactory(developmentsCatalogFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DevelopmentsCatalogFragment_MembersInjector.injectFeatures(developmentsCatalogFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        DevelopmentsCatalogFragment_MembersInjector.injectPresenter(developmentsCatalogFragment, this.q.get());
        DevelopmentsCatalogFragment_MembersInjector.injectAdapterPresenter(developmentsCatalogFragment, this.B0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectRecyclerAdapter(developmentsCatalogFragment, this.E0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectDestroyableViewHolderBuilder(developmentsCatalogFragment, this.C0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectPhotoGalleryPresenter(developmentsCatalogFragment, this.C.get());
        DevelopmentsCatalogFragment_MembersInjector.injectConsultationFormPreseter(developmentsCatalogFragment, this.r0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectBuildingProgressPresenter(developmentsCatalogFragment, this.l0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectGooglMapPresenter(developmentsCatalogFragment, this.v0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectPhoneNumberFormatter(developmentsCatalogFragment, this.F0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectDialogRouter(developmentsCatalogFragment, this.H0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectTracker(developmentsCatalogFragment, this.L0.get());
        DevelopmentsCatalogFragment_MembersInjector.injectAnalyticsInteractor(developmentsCatalogFragment, this.n.get());
    }
}
