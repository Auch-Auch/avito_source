package com.avito.android.developments_catalog;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenter;
import com.avito.android.developments_catalog.items.consultation.ConsultationPresenter;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenter;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DevelopmentsCatalogFragment_MembersInjector implements MembersInjector<DevelopmentsCatalogFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Features> d;
    public final Provider<DevelopmentsCatalogPresenter> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<SafeRecyclerAdapter> g;
    public final Provider<DestroyableViewHolderBuilder> h;
    public final Provider<PhotoGalleryPresenter> i;
    public final Provider<ConsultationPresenter> j;
    public final Provider<BuildingProgressPresenter> k;
    public final Provider<MapPresenter> l;
    public final Provider<Formatter<String>> m;
    public final Provider<DialogRouter> n;
    public final Provider<DevelopmentsCatalogTracker> o;
    public final Provider<DevelopmentsCatalogAnalyticsInteractor> p;

    public DevelopmentsCatalogFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<DevelopmentsCatalogPresenter> provider5, Provider<AdapterPresenter> provider6, Provider<SafeRecyclerAdapter> provider7, Provider<DestroyableViewHolderBuilder> provider8, Provider<PhotoGalleryPresenter> provider9, Provider<ConsultationPresenter> provider10, Provider<BuildingProgressPresenter> provider11, Provider<MapPresenter> provider12, Provider<Formatter<String>> provider13, Provider<DialogRouter> provider14, Provider<DevelopmentsCatalogTracker> provider15, Provider<DevelopmentsCatalogAnalyticsInteractor> provider16) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
    }

    public static MembersInjector<DevelopmentsCatalogFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<DevelopmentsCatalogPresenter> provider5, Provider<AdapterPresenter> provider6, Provider<SafeRecyclerAdapter> provider7, Provider<DestroyableViewHolderBuilder> provider8, Provider<PhotoGalleryPresenter> provider9, Provider<ConsultationPresenter> provider10, Provider<BuildingProgressPresenter> provider11, Provider<MapPresenter> provider12, Provider<Formatter<String>> provider13, Provider<DialogRouter> provider14, Provider<DevelopmentsCatalogTracker> provider15, Provider<DevelopmentsCatalogAnalyticsInteractor> provider16) {
        return new DevelopmentsCatalogFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(DevelopmentsCatalogFragment developmentsCatalogFragment, ActivityIntentFactory activityIntentFactory) {
        developmentsCatalogFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.adapterPresenter")
    public static void injectAdapterPresenter(DevelopmentsCatalogFragment developmentsCatalogFragment, AdapterPresenter adapterPresenter) {
        developmentsCatalogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.analyticsInteractor")
    public static void injectAnalyticsInteractor(DevelopmentsCatalogFragment developmentsCatalogFragment, DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor) {
        developmentsCatalogFragment.analyticsInteractor = developmentsCatalogAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.buildingProgressPresenter")
    public static void injectBuildingProgressPresenter(DevelopmentsCatalogFragment developmentsCatalogFragment, BuildingProgressPresenter buildingProgressPresenter) {
        developmentsCatalogFragment.buildingProgressPresenter = buildingProgressPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.consultationFormPreseter")
    public static void injectConsultationFormPreseter(DevelopmentsCatalogFragment developmentsCatalogFragment, ConsultationPresenter consultationPresenter) {
        developmentsCatalogFragment.consultationFormPreseter = consultationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DevelopmentsCatalogFragment developmentsCatalogFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        developmentsCatalogFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(DevelopmentsCatalogFragment developmentsCatalogFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        developmentsCatalogFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.dialogRouter")
    public static void injectDialogRouter(DevelopmentsCatalogFragment developmentsCatalogFragment, DialogRouter dialogRouter) {
        developmentsCatalogFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.features")
    public static void injectFeatures(DevelopmentsCatalogFragment developmentsCatalogFragment, Features features) {
        developmentsCatalogFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.googlMapPresenter")
    public static void injectGooglMapPresenter(DevelopmentsCatalogFragment developmentsCatalogFragment, MapPresenter mapPresenter) {
        developmentsCatalogFragment.googlMapPresenter = mapPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(DevelopmentsCatalogFragment developmentsCatalogFragment, ImplicitIntentFactory implicitIntentFactory) {
        developmentsCatalogFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.phoneNumberFormatter")
    public static void injectPhoneNumberFormatter(DevelopmentsCatalogFragment developmentsCatalogFragment, Formatter<String> formatter) {
        developmentsCatalogFragment.phoneNumberFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.photoGalleryPresenter")
    public static void injectPhotoGalleryPresenter(DevelopmentsCatalogFragment developmentsCatalogFragment, PhotoGalleryPresenter photoGalleryPresenter) {
        developmentsCatalogFragment.photoGalleryPresenter = photoGalleryPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.presenter")
    public static void injectPresenter(DevelopmentsCatalogFragment developmentsCatalogFragment, DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        developmentsCatalogFragment.presenter = developmentsCatalogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(DevelopmentsCatalogFragment developmentsCatalogFragment, SafeRecyclerAdapter safeRecyclerAdapter) {
        developmentsCatalogFragment.recyclerAdapter = safeRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.developments_catalog.DevelopmentsCatalogFragment.tracker")
    public static void injectTracker(DevelopmentsCatalogFragment developmentsCatalogFragment, DevelopmentsCatalogTracker developmentsCatalogTracker) {
        developmentsCatalogFragment.tracker = developmentsCatalogTracker;
    }

    public void injectMembers(DevelopmentsCatalogFragment developmentsCatalogFragment) {
        injectDeepLinkIntentFactory(developmentsCatalogFragment, this.a.get());
        injectImplicitIntentFactory(developmentsCatalogFragment, this.b.get());
        injectActivityIntentFactory(developmentsCatalogFragment, this.c.get());
        injectFeatures(developmentsCatalogFragment, this.d.get());
        injectPresenter(developmentsCatalogFragment, this.e.get());
        injectAdapterPresenter(developmentsCatalogFragment, this.f.get());
        injectRecyclerAdapter(developmentsCatalogFragment, this.g.get());
        injectDestroyableViewHolderBuilder(developmentsCatalogFragment, this.h.get());
        injectPhotoGalleryPresenter(developmentsCatalogFragment, this.i.get());
        injectConsultationFormPreseter(developmentsCatalogFragment, this.j.get());
        injectBuildingProgressPresenter(developmentsCatalogFragment, this.k.get());
        injectGooglMapPresenter(developmentsCatalogFragment, this.l.get());
        injectPhoneNumberFormatter(developmentsCatalogFragment, this.m.get());
        injectDialogRouter(developmentsCatalogFragment, this.n.get());
        injectTracker(developmentsCatalogFragment, this.o.get());
        injectAnalyticsInteractor(developmentsCatalogFragment, this.p.get());
    }
}
