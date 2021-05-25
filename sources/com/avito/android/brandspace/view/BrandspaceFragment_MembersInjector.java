package com.avito.android.brandspace.view;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BrandspaceFragment_MembersInjector implements MembersInjector<BrandspaceFragment> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<CarouselPresenter> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<BrandspaceTracker> e;
    public final Provider<ItemVisibilityTracker> f;
    public final Provider<Analytics> g;
    public final Provider<ListRecyclerAdapter> h;
    public final Provider<BrandpaceSpanProvider> i;
    public final Provider<DestroyableViewHolderBuilder> j;
    public final Provider<BrandspaceResourcesProvider> k;
    public final Provider<DeviceMetrics> l;

    public BrandspaceFragment_MembersInjector(Provider<BrandspacePresenter> provider, Provider<CarouselPresenter> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<BrandspaceTracker> provider5, Provider<ItemVisibilityTracker> provider6, Provider<Analytics> provider7, Provider<ListRecyclerAdapter> provider8, Provider<BrandpaceSpanProvider> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<BrandspaceResourcesProvider> provider11, Provider<DeviceMetrics> provider12) {
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
    }

    public static MembersInjector<BrandspaceFragment> create(Provider<BrandspacePresenter> provider, Provider<CarouselPresenter> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<BrandspaceTracker> provider5, Provider<ItemVisibilityTracker> provider6, Provider<Analytics> provider7, Provider<ListRecyclerAdapter> provider8, Provider<BrandpaceSpanProvider> provider9, Provider<DestroyableViewHolderBuilder> provider10, Provider<BrandspaceResourcesProvider> provider11, Provider<DeviceMetrics> provider12) {
        return new BrandspaceFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(BrandspaceFragment brandspaceFragment, ActivityIntentFactory activityIntentFactory) {
        brandspaceFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.adapter")
    public static void injectAdapter(BrandspaceFragment brandspaceFragment, ListRecyclerAdapter listRecyclerAdapter) {
        brandspaceFragment.adapter = listRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.analytics")
    public static void injectAnalytics(BrandspaceFragment brandspaceFragment, Analytics analytics) {
        brandspaceFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.brandspaceResources")
    public static void injectBrandspaceResources(BrandspaceFragment brandspaceFragment, BrandspaceResourcesProvider brandspaceResourcesProvider) {
        brandspaceFragment.brandspaceResources = brandspaceResourcesProvider;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.carouselPresenter")
    public static void injectCarouselPresenter(BrandspaceFragment brandspaceFragment, CarouselPresenter carouselPresenter) {
        brandspaceFragment.carouselPresenter = carouselPresenter;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(BrandspaceFragment brandspaceFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        brandspaceFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(BrandspaceFragment brandspaceFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        brandspaceFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.deviceMetrics")
    public static void injectDeviceMetrics(BrandspaceFragment brandspaceFragment, DeviceMetrics deviceMetrics) {
        brandspaceFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.itemVisibilityTracker")
    public static void injectItemVisibilityTracker(BrandspaceFragment brandspaceFragment, ItemVisibilityTracker itemVisibilityTracker) {
        brandspaceFragment.itemVisibilityTracker = itemVisibilityTracker;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.presenter")
    public static void injectPresenter(BrandspaceFragment brandspaceFragment, BrandspacePresenter brandspacePresenter) {
        brandspaceFragment.presenter = brandspacePresenter;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.spanProvider")
    public static void injectSpanProvider(BrandspaceFragment brandspaceFragment, BrandpaceSpanProvider brandpaceSpanProvider) {
        brandspaceFragment.spanProvider = brandpaceSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.brandspace.view.BrandspaceFragment.tracker")
    public static void injectTracker(BrandspaceFragment brandspaceFragment, BrandspaceTracker brandspaceTracker) {
        brandspaceFragment.tracker = brandspaceTracker;
    }

    public void injectMembers(BrandspaceFragment brandspaceFragment) {
        injectPresenter(brandspaceFragment, this.a.get());
        injectCarouselPresenter(brandspaceFragment, this.b.get());
        injectActivityIntentFactory(brandspaceFragment, this.c.get());
        injectDeepLinkIntentFactory(brandspaceFragment, this.d.get());
        injectTracker(brandspaceFragment, this.e.get());
        injectItemVisibilityTracker(brandspaceFragment, this.f.get());
        injectAnalytics(brandspaceFragment, this.g.get());
        injectAdapter(brandspaceFragment, this.h.get());
        injectSpanProvider(brandspaceFragment, this.i.get());
        injectDestroyableViewHolderBuilder(brandspaceFragment, this.j.get());
        injectBrandspaceResources(brandspaceFragment, this.k.get());
        injectDeviceMetrics(brandspaceFragment, this.l.get());
    }
}
