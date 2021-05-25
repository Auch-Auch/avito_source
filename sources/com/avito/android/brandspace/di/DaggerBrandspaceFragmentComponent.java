package com.avito.android.brandspace.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.brandspace.data.AdvertRepository;
import com.avito.android.brandspace.data.BrandspaceAdvertRepositoryImpl;
import com.avito.android.brandspace.data.BrandspaceAdvertRepositoryImpl_Factory;
import com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl;
import com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl_Factory;
import com.avito.android.brandspace.data.SearchAdvertRepositoryImpl;
import com.avito.android.brandspace.data.SearchAdvertRepositoryImpl_Factory;
import com.avito.android.brandspace.di.BrandspaceFragmentComponent;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractorImpl;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractorImpl_Factory;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopFilter;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopFilter_Factory;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopOrBottomFilter;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopOrBottomFilter_Factory;
import com.avito.android.brandspace.interactor.BrandspaceInteractor;
import com.avito.android.brandspace.interactor.BrandspaceInteractorImpl;
import com.avito.android.brandspace.interactor.BrandspaceInteractorImpl_Factory;
import com.avito.android.brandspace.items.adverts.AdvertItemBlueprint;
import com.avito.android.brandspace.items.adverts.AdvertItemBlueprint_Factory;
import com.avito.android.brandspace.items.adverts.AdvertItemPresenter;
import com.avito.android.brandspace.items.adverts.AdvertItemPresenterImpl;
import com.avito.android.brandspace.items.adverts.AdvertItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.button.ButtonBlueprint;
import com.avito.android.brandspace.items.button.ButtonBlueprint_Factory;
import com.avito.android.brandspace.items.button.ButtonPresenter;
import com.avito.android.brandspace.items.button.ButtonPresenterImpl;
import com.avito.android.brandspace.items.button.ButtonPresenterImpl_Factory;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.items.carousel.CarouselPresenterImpl;
import com.avito.android.brandspace.items.carousel.CarouselPresenterImpl_Factory;
import com.avito.android.brandspace.items.categories.CategoriesBlueprint;
import com.avito.android.brandspace.items.categories.CategoriesBlueprint_Factory;
import com.avito.android.brandspace.items.categories.CategoriesPresenter;
import com.avito.android.brandspace.items.categories.CategoriesPresenterImpl;
import com.avito.android.brandspace.items.categories.CategoriesPresenterImpl_Factory;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItem;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemBlueprint;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemBlueprint_Factory;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemMeasurer;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemMeasurer_Factory;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemPresenter;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemPresenterImpl;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemView;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemsBlueprint;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemsBlueprint_Factory;
import com.avito.android.brandspace.items.image.ImageBlueprint;
import com.avito.android.brandspace.items.image.ImageBlueprint_Factory;
import com.avito.android.brandspace.items.image.ImagePresenter;
import com.avito.android.brandspace.items.image.ImagePresenterImpl_Factory;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryBlueprint;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryBlueprint_Factory;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemBlueprint;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemBlueprint_Factory;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemPresenter;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemPresenterImpl;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.legal.LegalBlueprint;
import com.avito.android.brandspace.items.legal.LegalBlueprint_Factory;
import com.avito.android.brandspace.items.legal.LegalPresenter;
import com.avito.android.brandspace.items.legal.LegalPresenterImpl_Factory;
import com.avito.android.brandspace.items.loading.LoadingBlueprint;
import com.avito.android.brandspace.items.loading.LoadingBlueprint_Factory;
import com.avito.android.brandspace.items.loading.LoadingPresenter;
import com.avito.android.brandspace.items.loading.LoadingPresenterImpl_Factory;
import com.avito.android.brandspace.items.mainbanner.MainBannerBlueprint;
import com.avito.android.brandspace.items.mainbanner.MainBannerBlueprint_Factory;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemBlueprint;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemBlueprint_Factory;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenter;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.UniversalCarouselItemsBlueprints;
import com.avito.android.brandspace.items.marketplace.UniversalCarouselsBlueprint;
import com.avito.android.brandspace.items.marketplace.UniversalCarouselsBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselItemsBlueprints;
import com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselsBlueprint;
import com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselsBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.banner.BannerBlueprint;
import com.avito.android.brandspace.items.marketplace.banner.BannerBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.banner.BannerPresenter;
import com.avito.android.brandspace.items.marketplace.banner.BannerPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderBlueprint;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenter;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenterImpl;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.categories.CategoryBlueprint;
import com.avito.android.brandspace.items.marketplace.categories.CategoryBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.categories.CategoryPresenter;
import com.avito.android.brandspace.items.marketplace.categories.CategoryPresenterImpl;
import com.avito.android.brandspace.items.marketplace.categories.CategoryPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonBlueprint;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonItem;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonPresenter;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetBlueprint;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetCarouselBlueprint;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetCarouselBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetPresenter;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetPresenterImpl;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabBlueprint;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenter;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenterImpl;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonBlueprint;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonItem;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonPresenter;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonPresenterImpl_Factory;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint_Factory;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenterImpl;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenterImpl_Factory;
import com.avito.android.brandspace.items.news.NewsBlueprint;
import com.avito.android.brandspace.items.news.NewsBlueprint_Factory;
import com.avito.android.brandspace.items.news.NewsItem;
import com.avito.android.brandspace.items.news.NewsItemBlueprint;
import com.avito.android.brandspace.items.news.NewsItemBlueprint_Factory;
import com.avito.android.brandspace.items.news.NewsItemMeasurer;
import com.avito.android.brandspace.items.news.NewsItemMeasurer_Factory;
import com.avito.android.brandspace.items.news.NewsItemPresenter;
import com.avito.android.brandspace.items.news.NewsItemPresenterImpl;
import com.avito.android.brandspace.items.news.NewsItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.news.NewsItemView;
import com.avito.android.brandspace.items.paragraph.ParagraphBlueprint;
import com.avito.android.brandspace.items.paragraph.ParagraphBlueprint_Factory;
import com.avito.android.brandspace.items.paragraph.ParagraphItemPresenter;
import com.avito.android.brandspace.items.paragraph.ParagraphItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonBlueprint;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonBlueprint_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItem;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemBlueprint;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemBlueprint_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemMeasurer;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemMeasurer_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPresenter;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPresenterImpl;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPresenterImpl_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemProperty;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPropertyMeasurer;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPropertyMeasurer_Factory;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonPropertyMeasurer;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionBlueprint;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionBlueprint_Factory;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItem;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemBlueprint;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemBlueprint_Factory;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemMeasurer;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemMeasurer_Factory;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionPresenter;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionPresenterImpl;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionPresenterImpl_Factory;
import com.avito.android.brandspace.items.text.TextBlueprint;
import com.avito.android.brandspace.items.text.TextBlueprint_Factory;
import com.avito.android.brandspace.items.text.TextPresenter;
import com.avito.android.brandspace.items.text.TextPresenterImpl_Factory;
import com.avito.android.brandspace.items.text_with_image.TextWithImageBlueprint;
import com.avito.android.brandspace.items.text_with_image.TextWithImageBlueprint_Factory;
import com.avito.android.brandspace.items.text_with_image.TextWithImagePresenter;
import com.avito.android.brandspace.items.text_with_image.TextWithImagePresenterImpl;
import com.avito.android.brandspace.items.text_with_image.TextWithImagePresenterImpl_Factory;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoBlueprint;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoBlueprint_Factory;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenter;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl_Factory;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurerImpl;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurerImpl_Factory;
import com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurerImpl_Factory;
import com.avito.android.brandspace.items.videogallery.VideoGalleryBlueprint;
import com.avito.android.brandspace.items.videogallery.VideoGalleryBlueprint_Factory;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItem;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemBlueprint;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemBlueprint_Factory;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemMeasurer;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemMeasurer_Factory;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import com.avito.android.brandspace.items.videogallery.VideoGalleryPresenter;
import com.avito.android.brandspace.items.videogallery.VideoGalleryPresenterImpl;
import com.avito.android.brandspace.items.videogallery.VideoGalleryPresenterImpl_Factory;
import com.avito.android.brandspace.items.wideabout.WideAboutBlueprint;
import com.avito.android.brandspace.items.wideabout.WideAboutBlueprint_Factory;
import com.avito.android.brandspace.items.wideabout.WideAboutItemPresenter;
import com.avito.android.brandspace.items.wideabout.WideAboutItemPresenterImpl_Factory;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessorImpl;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessorImpl_Factory;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilder;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl_Factory;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl_Factory;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProviderImpl;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProviderImpl_Factory;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessorImpl_Factory;
import com.avito.android.brandspace.presenter.mappers.BrandspaceElementMapper;
import com.avito.android.brandspace.presenter.mappers.MarketplaceTabsModuleMapper;
import com.avito.android.brandspace.presenter.mappers.MarketplaceTabsModuleMapper_Factory;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTrackerImpl;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTrackerImpl_Factory;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.brandspace.view.BrandpaceSpanProvider;
import com.avito.android.brandspace.view.BrandpaceSpanProviderImpl;
import com.avito.android.brandspace.view.BrandpaceSpanProviderImpl_Factory;
import com.avito.android.brandspace.view.BrandspaceFragment;
import com.avito.android.brandspace.view.BrandspaceFragment_MembersInjector;
import com.avito.android.brandspace.view.FragmentDelegate;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl_Factory;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Map;
import javax.inject.Provider;
public final class DaggerBrandspaceFragmentComponent implements BrandspaceFragmentComponent {
    public Provider<TextItemMeasurer<?>> A;
    public Provider<BrandspaceBlockViewAtTopOrBottomFilter> A0 = BrandspaceBlockViewAtTopOrBottomFilter_Factory.create(this.w0);
    public Provider<MarketplaceSnippetBlueprint> A1;
    public Provider<BrandpaceSpanProviderImpl> A2;
    public Provider<Map<Class<?>, Provider<TextItemMeasurer<?>>>> B;
    public Provider<Bundle> B0;
    public Provider<MarketplaceSnippetCarouselBlueprint> B1;
    public Provider<BrandpaceSpanProvider> B2;
    public Provider<SchedulersFactory3> C;
    public Provider<ItemVisibilityTracker> C0;
    public Provider<NewsItemPresenterImpl> C1;
    public Provider<ItemsMeasurerImpl> D;
    public Provider<ImagePresenter> D0;
    public Provider<NewsItemPresenter> D1;
    public Provider<ItemsMeasurer> E;
    public Provider<ImageBlueprint> E0;
    public Provider<NewsItemBlueprint> E1;
    public Provider<FavoritesSyncDao> F;
    public Provider<CategoriesPresenterImpl> F0;
    public Provider<ItemBinder> F1;
    public Provider<FavoriteAdvertsUploadInteractor> G;
    public Provider<CategoriesPresenter> G0;
    public Provider<NewsBlueprint> G1;
    public Provider<FavoriteAdvertsEventInteractor> H;
    public Provider<CategoriesBlueprint> H0;
    public Provider<ImageGalleryItemPresenterImpl> H1;
    public Provider<Analytics> I;
    public Provider<TextPresenter> I0;
    public Provider<ImageGalleryItemPresenter> I1;
    public Provider<AccountStateProvider> J;
    public Provider<TextBlueprint> J0;
    public Provider<ImageGalleryItemBlueprint> J1;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> K;
    public Provider<ButtonPresenterImpl> K0;
    public Provider<ItemBinder> K1;
    public Provider<FavoriteAdvertsInteractorImpl> L;
    public Provider<ButtonPresenter> L0;
    public Provider<ImageGalleryBlueprint> L1;
    public Provider<FavoriteStatusResolverImpl> M;
    public Provider<ButtonBlueprint> M0;
    public Provider<ProductComparisonItemPresenterImpl> M1;
    public Provider<FavoriteStatusResolver> N;
    public Provider<LoadingPresenter> N0;
    public Provider<ProductComparisonItemPresenter> N1;
    public Provider<MarketplaceTabsModuleMapper> O;
    public Provider<LoadingBlueprint> O0;
    public Provider<ProductComparisonItemBlueprint> O1;
    public Provider<BrandspaceElementMapper<MarketplaceTabsModule>> P;
    public Provider<MarketplaceTabPresenterImpl> P0;
    public Provider<ItemBinder> P1;
    public Provider<BrandspaceItemBuilderImpl> Q;
    public Provider<MarketplaceTabPresenter> Q0;
    public Provider<ProductComparisonBlueprint> Q1;
    public Provider<BrandspaceItemBuilder> R;
    public Provider<MarketplaceTabBlueprint> R0;
    public Provider<MainBannerItemPresenterImpl> R1;
    public Provider<String> S;
    public Provider<CategoryItemPresenterImpl> S0;
    public Provider<MainBannerItemPresenter> S1;
    public Provider<BrandspaceApi> T;
    public Provider<CategoryItemPresenter> T0;
    public Provider<MainBannerItemBlueprint> T1;
    public Provider<MarketplaceItemsProcessor> U;
    public Provider<CategoryItemBlueprint> U0;
    public Provider<ItemBinder> U1;
    public Provider<BuildInfo> V;
    public Provider<ItemBinder> V0;
    public Provider<MainBannerBlueprint> V1;
    public Provider<BrandspaceAdvertRepositoryImpl> W;
    public Provider<CategoryItemsBlueprint> W0;
    public Provider<TextWithImagePresenterImpl> W1;
    public Provider<AdvertRepository<AdvertSource.LinkSource>> X;
    public Provider<VideoGalleryPresenterImpl> X0;
    public Provider<TextWithImagePresenter> X1;
    public Provider<SearchApi> Y;
    public Provider<VideoGalleryPresenter> Y0;
    public Provider<TextWithImageBlueprint> Y1;
    public Provider<Features> Z;
    public Provider<VideoGalleryItemBlueprint> Z0;
    public Provider<TextWithVideoPresenterImpl> Z1;
    public final BrandspaceFragmentDependencies a;
    public Provider<SerpAdvertConverter> a0;
    public Provider<ItemBinder> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<TextWithVideoPresenter> f34a2;
    public Provider<IdProvider> b;
    public Provider<BrandspaceAdvertItemProcessorImpl> b0;
    public Provider<VideoGalleryBlueprint> b1;
    public Provider<TextWithVideoBlueprint> b2;
    public Provider<Context> c;
    public Provider<BrandspaceAdvertItemProcessor> c0;
    public Provider<SkeletonPresenter> c1;
    public Provider<ProductDescriptionPresenterImpl> c2;
    public Provider<TextMeasurer> d;
    public Provider<SearchAdvertRepositoryImpl> d0;
    public Provider<SkeletonBlueprint> d1;
    public Provider<ProductDescriptionPresenter> d2;
    public Provider<CategoryItemView.Measurer> e;
    public Provider<AdvertRepository<AdvertSource.ParametersSource>> e0;
    public Provider<SkeletonItem> e1;
    public Provider<ProductDescriptionItemBlueprint> e2;
    public Provider<CategoryItemMeasurer> f;
    public Provider<BrandspaceTabsRepositoryImpl> f0;
    public Provider<CarouselLoaderPresenterImpl> f1;
    public Provider<ItemBinder> f2;
    public Provider<TextItemMeasurer<?>> g;
    public Provider<AdvertRepository<AdvertSource.TabsSource>> g0;
    public Provider<CarouselLoaderPresenter> g1;
    public Provider<ProductDescriptionBlueprint> g2;
    public Provider<DeviceMetrics> h;
    public Provider<BrandspaceInteractorImpl> h0;
    public Provider<CarouselLoaderBlueprint> h1;
    public Provider<BannerPresenter> h2;
    public Provider<Resources> i;
    public Provider<BrandspaceInteractor> i0;
    public Provider<TabSkeletonItem> i1;
    public Provider<BannerBlueprint> i2;
    public Provider<Application> j;
    public Provider<String> j0;
    public Provider<TabLoaderPresenterImpl> j1;
    public Provider<ParagraphItemPresenter> j2;
    public Provider<CallAdapterFactoryResourceProvider> k;
    public Provider<TreeStateIdGenerator> k0;
    public Provider<TabLoaderPresenter> k1;
    public Provider<ParagraphBlueprint> k2;
    public Provider<BrandspaceResourcesProviderImpl> l;
    public Provider<TreeClickStreamParent> l0;
    public Provider<TabSkeletonPresenter> l1;
    public Provider<WideAboutItemPresenter> l2;
    public Provider<BrandspaceResourcesProvider> m;
    public Provider<BrandspaceAnalyticsInteractorImpl> m0;
    public Provider<TabSkeletonBlueprint> m1;
    public Provider<WideAboutBlueprint> m2;
    public Provider<VideoGalleryItemView.Measurer> n;
    public Provider<BrandspaceAnalyticsInteractor> n0;
    public Provider<TabLoaderBlueprint> n1;
    public Provider<LegalPresenter> n2;
    public Provider<VideoGalleryItemMeasurer> o;
    public Provider<ScreenTrackerFactory> o0;
    public Provider<RdsAdvertItemPresenter> o1;
    public Provider<LegalBlueprint> o2;
    public Provider<TextItemMeasurer<?>> p;
    public Provider<TimerFactory> p0;
    public Provider<AdvertItemPresenterImpl> p1;
    public Provider<UniversalCarouselItemsBlueprints> p2;
    public Provider<NewsItemView.Measurer> q;
    public Provider<BrandspaceTrackerImpl> q0;
    public Provider<AdvertItemPresenter> q1;
    public Provider<UniversalCarouselsBlueprint> q2;
    public Provider<NewsItemMeasurer> r;
    public Provider<BrandspaceTracker> r0;
    public Provider<TimeSource> r1;
    public Provider<CategoryPresenterImpl> r2;
    public Provider<TextItemMeasurer<?>> s;
    public Provider<FavoriteAdvertsResourceProvider> s0;
    public Provider<Locale> s1;
    public Provider<CategoryPresenter> s2;
    public Provider<ProductDescriptionItemMeasurer> t;
    public Provider<FavoriteAdvertsPresenter> t0;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> t1;
    public Provider<CategoryBlueprint> t2;
    public Provider<TextItemMeasurer<?>> u;
    public Provider<TypedErrorThrowableConverter> u0;
    public Provider<SerpItemsPrefetchTestGroup> u1;
    public Provider<WrapUniversalCarouselItemsBlueprints> u2;
    public Provider<ProductComparisonItemView.Measurer> v;
    public Provider<BrandspacePresenterImpl> v0;
    public Provider<SerpItemAbViewConfig> v1;
    public Provider<WrapUniversalCarouselsBlueprint> v2;
    public Provider<ProductComparisonItemMeasurer> w;
    public Provider<BrandspacePresenter> w0;
    public Provider<ConnectivityProvider> w1;
    public Provider<ItemBinder> w2;
    public Provider<TextItemMeasurer<?>> x;
    public Provider<CarouselPresenterImpl> x0;
    public Provider<AdvertItemBlueprint> x1;
    public Provider<AdapterPresenter> x2;
    public Provider<ProductComparisonPropertyMeasurer> y;
    public Provider<CarouselPresenter> y0;
    public Provider<MarketplaceSnippetPresenterImpl> y1;
    public Provider<DestroyableViewHolderBuilder> y2;
    public Provider<ProductComparisonItemPropertyMeasurer> z;
    public Provider<BrandspaceBlockViewAtTopFilter> z0 = BrandspaceBlockViewAtTopFilter_Factory.create(this.w0);
    public Provider<MarketplaceSnippetPresenter> z1;
    public Provider<ListRecyclerAdapter> z2;

    public static final class b implements BrandspaceFragmentComponent.Builder {
        public BrandspaceFragmentDependencies a;
        public ScreenAnalyticsDependencies b;
        public Context c;
        public Screen d;
        public String e;
        public String f;
        public Resources g;
        public FragmentDelegate h;
        public TreeClickStreamParent i;
        public Bundle j;

        public b(a aVar) {
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BrandspaceFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Context.class);
            Preconditions.checkBuilderRequirement(this.d, Screen.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.g, Resources.class);
            Preconditions.checkBuilderRequirement(this.h, FragmentDelegate.class);
            return new DaggerBrandspaceFragmentComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withBrandspaceDependencies(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = (BrandspaceFragmentDependencies) Preconditions.checkNotNull(brandspaceFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withBrandspaceId(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withBrandspaceSource(String str) {
            this.f = str;
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withFragmentDelegate(FragmentDelegate fragmentDelegate) {
            this.h = (FragmentDelegate) Preconditions.checkNotNull(fragmentDelegate);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withInitialTreeParent(TreeClickStreamParent treeClickStreamParent) {
            this.i = treeClickStreamParent;
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withItemVisibilityTrackerState(Bundle bundle) {
            this.j = bundle;
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withResources(Resources resources) {
            this.g = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withScreen(Screen screen) {
            this.d = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withScreenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent.Builder
        public BrandspaceFragmentComponent.Builder withViewContext(Context context) {
            this.c = (Context) Preconditions.checkNotNull(context);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final BrandspaceFragmentDependencies a;

        public c(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final BrandspaceFragmentDependencies a;

        public d(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Application> {
        public final BrandspaceFragmentDependencies a;

        public e(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class f implements Provider<BrandspaceApi> {
        public final BrandspaceFragmentDependencies a;

        public f(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BrandspaceApi get() {
            return (BrandspaceApi) Preconditions.checkNotNullFromComponent(this.a.brandspaceApi());
        }
    }

    public static class g implements Provider<BuildInfo> {
        public final BrandspaceFragmentDependencies a;

        public g(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class h implements Provider<ConnectivityProvider> {
        public final BrandspaceFragmentDependencies a;

        public h(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class i implements Provider<DeviceMetrics> {
        public final BrandspaceFragmentDependencies a;

        public i(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class j implements Provider<FavoriteAdvertsEventInteractor> {
        public final BrandspaceFragmentDependencies a;

        public j(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class k implements Provider<FavoriteAdvertsUploadInteractor> {
        public final BrandspaceFragmentDependencies a;

        public k(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class l implements Provider<FavoritesSyncDao> {
        public final BrandspaceFragmentDependencies a;

        public l(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class m implements Provider<Features> {
        public final BrandspaceFragmentDependencies a;

        public m(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class n implements Provider<IdProvider> {
        public final BrandspaceFragmentDependencies a;

        public n(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public IdProvider get() {
            return (IdProvider) Preconditions.checkNotNullFromComponent(this.a.idGenerator());
        }
    }

    public static class o implements Provider<Locale> {
        public final BrandspaceFragmentDependencies a;

        public o(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class p implements Provider<SerpItemsPrefetchTestGroup> {
        public final BrandspaceFragmentDependencies a;

        public p(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class q implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final BrandspaceFragmentDependencies a;

        public q(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class r implements Provider<SchedulersFactory3> {
        public final BrandspaceFragmentDependencies a;

        public r(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class s implements Provider<SearchApi> {
        public final BrandspaceFragmentDependencies a;

        public s(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class t implements Provider<TimeSource> {
        public final BrandspaceFragmentDependencies a;

        public t(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class u implements Provider<TreeStateIdGenerator> {
        public final BrandspaceFragmentDependencies a;

        public u(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class v implements Provider<TypedErrorThrowableConverter> {
        public final BrandspaceFragmentDependencies a;

        public v(BrandspaceFragmentDependencies brandspaceFragmentDependencies) {
            this.a = brandspaceFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class w implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public w(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class x implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public x(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerBrandspaceFragmentComponent(BrandspaceFragmentDependencies brandspaceFragmentDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Context context, Screen screen, String str, String str2, Resources resources, FragmentDelegate fragmentDelegate, TreeClickStreamParent treeClickStreamParent, Bundle bundle, a aVar) {
        this.a = brandspaceFragmentDependencies;
        this.b = new n(brandspaceFragmentDependencies);
        this.c = InstanceFactory.create(context);
        Provider<TextMeasurer> provider = DoubleCheck.provider(TextMeasurerImpl_Factory.create());
        this.d = provider;
        Provider<CategoryItemView.Measurer> provider2 = DoubleCheck.provider(BrandspaceFragmentModule_CategoryItemMeasurer$brandspace_releaseFactory.create(this.c, provider));
        this.e = provider2;
        CategoryItemMeasurer_Factory create = CategoryItemMeasurer_Factory.create(provider2);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new i(brandspaceFragmentDependencies);
        this.i = InstanceFactory.create(resources);
        e eVar = new e(brandspaceFragmentDependencies);
        this.j = eVar;
        Provider<CallAdapterFactoryResourceProvider> provider3 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideCallAdapterResourceProvider$brandspace_releaseFactory.create(eVar));
        this.k = provider3;
        BrandspaceResourcesProviderImpl_Factory create2 = BrandspaceResourcesProviderImpl_Factory.create(this.i, provider3);
        this.l = create2;
        Provider<BrandspaceResourcesProvider> provider4 = DoubleCheck.provider(create2);
        this.m = provider4;
        Provider<VideoGalleryItemView.Measurer> provider5 = DoubleCheck.provider(BrandspaceFragmentModule_VideoPreviewMeasurer$brandspace_releaseFactory.create(this.c, this.d, this.h, provider4));
        this.n = provider5;
        VideoGalleryItemMeasurer_Factory create3 = VideoGalleryItemMeasurer_Factory.create(provider5);
        this.o = create3;
        this.p = DoubleCheck.provider(create3);
        Provider<NewsItemView.Measurer> provider6 = DoubleCheck.provider(BrandspaceFragmentModule_NewsItemPreviewMeasurer$brandspace_releaseFactory.create(this.c, this.d));
        this.q = provider6;
        NewsItemMeasurer_Factory create4 = NewsItemMeasurer_Factory.create(provider6);
        this.r = create4;
        this.s = DoubleCheck.provider(create4);
        ProductDescriptionItemMeasurer_Factory create5 = ProductDescriptionItemMeasurer_Factory.create(this.q);
        this.t = create5;
        this.u = DoubleCheck.provider(create5);
        Provider<ProductComparisonItemView.Measurer> provider7 = DoubleCheck.provider(BrandspaceFragmentModule_ProductComparisonMeasurer$brandspace_releaseFactory.create(this.c, this.d));
        this.v = provider7;
        ProductComparisonItemMeasurer_Factory create6 = ProductComparisonItemMeasurer_Factory.create(provider7);
        this.w = create6;
        this.x = DoubleCheck.provider(create6);
        Provider<ProductComparisonPropertyMeasurer> provider8 = DoubleCheck.provider(BrandspaceFragmentModule_ProductComparisonTextMeasurer$brandspace_releaseFactory.create(this.c, this.d));
        this.y = provider8;
        ProductComparisonItemPropertyMeasurer_Factory create7 = ProductComparisonItemPropertyMeasurer_Factory.create(provider8);
        this.z = create7;
        this.A = DoubleCheck.provider(create7);
        MapProviderFactory build = MapProviderFactory.builder(6).put((MapProviderFactory.Builder) CategoryItem.class, (Provider) this.g).put((MapProviderFactory.Builder) VideoGalleryItem.class, (Provider) this.p).put((MapProviderFactory.Builder) NewsItem.class, (Provider) this.s).put((MapProviderFactory.Builder) ProductDescriptionItem.class, (Provider) this.u).put((MapProviderFactory.Builder) ProductComparisonItem.class, (Provider) this.x).put((MapProviderFactory.Builder) ProductComparisonItemProperty.class, (Provider) this.A).build();
        this.B = build;
        r rVar = new r(brandspaceFragmentDependencies);
        this.C = rVar;
        ItemsMeasurerImpl_Factory create8 = ItemsMeasurerImpl_Factory.create(build, rVar);
        this.D = create8;
        this.E = DoubleCheck.provider(create8);
        this.F = new l(brandspaceFragmentDependencies);
        this.G = new k(brandspaceFragmentDependencies);
        this.H = new j(brandspaceFragmentDependencies);
        d dVar = new d(brandspaceFragmentDependencies);
        this.I = dVar;
        c cVar = new c(brandspaceFragmentDependencies);
        this.J = cVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create9 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(dVar, cVar);
        this.K = create9;
        FavoriteAdvertsInteractorImpl_Factory create10 = FavoriteAdvertsInteractorImpl_Factory.create(this.F, this.G, this.H, create9, this.C);
        this.L = create10;
        FavoriteStatusResolverImpl_Factory create11 = FavoriteStatusResolverImpl_Factory.create(create10);
        this.M = create11;
        this.N = DoubleCheck.provider(create11);
        MarketplaceTabsModuleMapper_Factory create12 = MarketplaceTabsModuleMapper_Factory.create(this.b);
        this.O = create12;
        Provider<BrandspaceElementMapper<MarketplaceTabsModule>> provider9 = DoubleCheck.provider(create12);
        this.P = provider9;
        BrandspaceItemBuilderImpl_Factory create13 = BrandspaceItemBuilderImpl_Factory.create(this.b, this.E, this.N, this.m, this.C, provider9);
        this.Q = create13;
        this.R = DoubleCheck.provider(create13);
        this.S = InstanceFactory.create(str);
        this.T = new f(brandspaceFragmentDependencies);
        Provider<MarketplaceItemsProcessor> provider10 = DoubleCheck.provider(MarketplaceItemsProcessorImpl_Factory.create());
        this.U = provider10;
        g gVar = new g(brandspaceFragmentDependencies);
        this.V = gVar;
        BrandspaceAdvertRepositoryImpl_Factory create14 = BrandspaceAdvertRepositoryImpl_Factory.create(this.T, this.C, provider10, gVar);
        this.W = create14;
        this.X = DoubleCheck.provider(create14);
        this.Y = new s(brandspaceFragmentDependencies);
        m mVar = new m(brandspaceFragmentDependencies);
        this.Z = mVar;
        Provider<SerpAdvertConverter> provider11 = SingleCheck.provider(BrandspaceFragmentModule_ProvideAdvertConverterFactory.create(this.i, mVar));
        this.a0 = provider11;
        BrandspaceAdvertItemProcessorImpl_Factory create15 = BrandspaceAdvertItemProcessorImpl_Factory.create(this.b, provider11);
        this.b0 = create15;
        Provider<BrandspaceAdvertItemProcessor> provider12 = DoubleCheck.provider(create15);
        this.c0 = provider12;
        SearchAdvertRepositoryImpl_Factory create16 = SearchAdvertRepositoryImpl_Factory.create(this.Y, this.C, provider12);
        this.d0 = create16;
        this.e0 = DoubleCheck.provider(create16);
        BrandspaceTabsRepositoryImpl_Factory create17 = BrandspaceTabsRepositoryImpl_Factory.create(this.T, this.C, this.U, this.b, this.V);
        this.f0 = create17;
        Provider<AdvertRepository<AdvertSource.TabsSource>> provider13 = DoubleCheck.provider(create17);
        this.g0 = provider13;
        BrandspaceInteractorImpl_Factory create18 = BrandspaceInteractorImpl_Factory.create(this.S, this.X, this.e0, provider13, this.T, this.Y, this.C, this.c0);
        this.h0 = create18;
        this.i0 = DoubleCheck.provider(create18);
        this.j0 = InstanceFactory.createNullable(str2);
        this.k0 = new u(brandspaceFragmentDependencies);
        Factory createNullable = InstanceFactory.createNullable(treeClickStreamParent);
        this.l0 = createNullable;
        BrandspaceAnalyticsInteractorImpl_Factory create19 = BrandspaceAnalyticsInteractorImpl_Factory.create(this.S, this.j0, this.I, this.k0, createNullable, this.C);
        this.m0 = create19;
        this.n0 = DoubleCheck.provider(create19);
        w wVar = new w(screenAnalyticsDependencies);
        this.o0 = wVar;
        x xVar = new x(screenAnalyticsDependencies);
        this.p0 = xVar;
        BrandspaceTrackerImpl_Factory create20 = BrandspaceTrackerImpl_Factory.create(wVar, xVar);
        this.q0 = create20;
        this.r0 = DoubleCheck.provider(create20);
        Provider<FavoriteAdvertsResourceProvider> provider14 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.i));
        this.s0 = provider14;
        Provider<FavoriteAdvertsPresenter> provider15 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.L, this.C, provider14));
        this.t0 = provider15;
        v vVar = new v(brandspaceFragmentDependencies);
        this.u0 = vVar;
        BrandspacePresenterImpl_Factory create21 = BrandspacePresenterImpl_Factory.create(this.R, this.i0, this.n0, this.r0, provider15, vVar, this.m, this.C);
        this.v0 = create21;
        Provider<BrandspacePresenter> provider16 = DoubleCheck.provider(create21);
        this.w0 = provider16;
        CarouselPresenterImpl_Factory create22 = CarouselPresenterImpl_Factory.create(provider16, this.C);
        this.x0 = create22;
        this.y0 = DoubleCheck.provider(create22);
        Factory createNullable2 = InstanceFactory.createNullable(bundle);
        this.B0 = createNullable2;
        this.C0 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideItemVisibilityTracker$brandspace_releaseFactory.create(this.z0, this.A0, createNullable2));
        Provider<ImagePresenter> provider17 = DoubleCheck.provider(ImagePresenterImpl_Factory.create());
        this.D0 = provider17;
        this.E0 = ImageBlueprint_Factory.create(provider17);
        CategoriesPresenterImpl_Factory create23 = CategoriesPresenterImpl_Factory.create(this.w0);
        this.F0 = create23;
        Provider<CategoriesPresenter> provider18 = DoubleCheck.provider(create23);
        this.G0 = provider18;
        this.H0 = CategoriesBlueprint_Factory.create(provider18);
        Provider<TextPresenter> provider19 = DoubleCheck.provider(TextPresenterImpl_Factory.create());
        this.I0 = provider19;
        this.J0 = TextBlueprint_Factory.create(provider19);
        ButtonPresenterImpl_Factory create24 = ButtonPresenterImpl_Factory.create(this.w0, this.n0);
        this.K0 = create24;
        Provider<ButtonPresenter> provider20 = DoubleCheck.provider(create24);
        this.L0 = provider20;
        this.M0 = ButtonBlueprint_Factory.create(provider20);
        Provider<LoadingPresenter> provider21 = DoubleCheck.provider(LoadingPresenterImpl_Factory.create());
        this.N0 = provider21;
        this.O0 = LoadingBlueprint_Factory.create(provider21);
        MarketplaceTabPresenterImpl_Factory create25 = MarketplaceTabPresenterImpl_Factory.create(this.w0);
        this.P0 = create25;
        Provider<MarketplaceTabPresenter> provider22 = DoubleCheck.provider(create25);
        this.Q0 = provider22;
        this.R0 = MarketplaceTabBlueprint_Factory.create(provider22);
        CategoryItemPresenterImpl_Factory create26 = CategoryItemPresenterImpl_Factory.create(this.w0, this.n0);
        this.S0 = create26;
        Provider<CategoryItemPresenter> provider23 = DoubleCheck.provider(create26);
        this.T0 = provider23;
        CategoryItemBlueprint_Factory create27 = CategoryItemBlueprint_Factory.create(provider23);
        this.U0 = create27;
        Provider<ItemBinder> provider24 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideCategoriesItemBinder$brandspace_releaseFactory.create(create27));
        this.V0 = provider24;
        this.W0 = CategoryItemsBlueprint_Factory.create(this.y0, provider24);
        VideoGalleryPresenterImpl_Factory create28 = VideoGalleryPresenterImpl_Factory.create(this.w0, this.n0, this.n);
        this.X0 = create28;
        Provider<VideoGalleryPresenter> provider25 = DoubleCheck.provider(create28);
        this.Y0 = provider25;
        VideoGalleryItemBlueprint_Factory create29 = VideoGalleryItemBlueprint_Factory.create(provider25);
        this.Z0 = create29;
        Provider<ItemBinder> provider26 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideVideoGalleryItemBinder$brandspace_releaseFactory.create(create29));
        this.a1 = provider26;
        this.b1 = VideoGalleryBlueprint_Factory.create(this.y0, provider26);
        Provider<SkeletonPresenter> provider27 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.c1 = provider27;
        this.d1 = SkeletonBlueprint_Factory.create(provider27);
        Provider<SkeletonItem> provider28 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideSkeletonItem$brandspace_releaseFactory.create(this.b));
        this.e1 = provider28;
        CarouselLoaderPresenterImpl_Factory create30 = CarouselLoaderPresenterImpl_Factory.create(this.m, provider28);
        this.f1 = create30;
        Provider<CarouselLoaderPresenter> provider29 = DoubleCheck.provider(create30);
        this.g1 = provider29;
        this.h1 = CarouselLoaderBlueprint_Factory.create(provider29, this.d1);
        Provider<TabSkeletonItem> provider30 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideTabSkeletonItem$brandspace_releaseFactory.create(this.b));
        this.i1 = provider30;
        TabLoaderPresenterImpl_Factory create31 = TabLoaderPresenterImpl_Factory.create(provider30, this.m);
        this.j1 = create31;
        this.k1 = DoubleCheck.provider(create31);
        Provider<TabSkeletonPresenter> provider31 = DoubleCheck.provider(TabSkeletonPresenterImpl_Factory.create());
        this.l1 = provider31;
        TabSkeletonBlueprint_Factory create32 = TabSkeletonBlueprint_Factory.create(provider31);
        this.m1 = create32;
        this.n1 = TabLoaderBlueprint_Factory.create(this.k1, create32);
        Provider<RdsAdvertItemPresenter> provider32 = SingleCheck.provider(AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory.create(this.w0, this.I, this.Z));
        this.o1 = provider32;
        AdvertItemPresenterImpl_Factory create33 = AdvertItemPresenterImpl_Factory.create(provider32);
        this.p1 = create33;
        this.q1 = DoubleCheck.provider(create33);
        this.r1 = new t(brandspaceFragmentDependencies);
        this.s1 = new o(brandspaceFragmentDependencies);
        q qVar = new q(brandspaceFragmentDependencies);
        this.t1 = qVar;
        p pVar = new p(brandspaceFragmentDependencies);
        this.u1 = pVar;
        SerpItemAbViewConfig_Factory create34 = SerpItemAbViewConfig_Factory.create(qVar, pVar);
        this.v1 = create34;
        h hVar = new h(brandspaceFragmentDependencies);
        this.w1 = hVar;
        this.x1 = AdvertItemBlueprint_Factory.create(this.q1, this.r1, this.s1, create34, hVar);
        MarketplaceSnippetPresenterImpl_Factory create35 = MarketplaceSnippetPresenterImpl_Factory.create(this.w0, this.n0);
        this.y1 = create35;
        Provider<MarketplaceSnippetPresenter> provider33 = DoubleCheck.provider(create35);
        this.z1 = provider33;
        MarketplaceSnippetBlueprint_Factory create36 = MarketplaceSnippetBlueprint_Factory.create(provider33);
        this.A1 = create36;
        this.B1 = MarketplaceSnippetCarouselBlueprint_Factory.create(this.y0, create36);
        NewsItemPresenterImpl_Factory create37 = NewsItemPresenterImpl_Factory.create(this.w0, this.n0);
        this.C1 = create37;
        Provider<NewsItemPresenter> provider34 = DoubleCheck.provider(create37);
        this.D1 = provider34;
        NewsItemBlueprint_Factory create38 = NewsItemBlueprint_Factory.create(provider34);
        this.E1 = create38;
        Provider<ItemBinder> provider35 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideNewsItemBinder$brandspace_releaseFactory.create(create38));
        this.F1 = provider35;
        this.G1 = NewsBlueprint_Factory.create(this.y0, provider35);
        ImageGalleryItemPresenterImpl_Factory create39 = ImageGalleryItemPresenterImpl_Factory.create(this.h, this.m);
        this.H1 = create39;
        Provider<ImageGalleryItemPresenter> provider36 = DoubleCheck.provider(create39);
        this.I1 = provider36;
        ImageGalleryItemBlueprint_Factory create40 = ImageGalleryItemBlueprint_Factory.create(provider36);
        this.J1 = create40;
        Provider<ItemBinder> provider37 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideImageGalleryItemBinder$brandspace_releaseFactory.create(create40));
        this.K1 = provider37;
        this.L1 = ImageGalleryBlueprint_Factory.create(this.y0, provider37);
        ProductComparisonItemPresenterImpl_Factory create41 = ProductComparisonItemPresenterImpl_Factory.create(this.w0);
        this.M1 = create41;
        Provider<ProductComparisonItemPresenter> provider38 = DoubleCheck.provider(create41);
        this.N1 = provider38;
        ProductComparisonItemBlueprint_Factory create42 = ProductComparisonItemBlueprint_Factory.create(provider38);
        this.O1 = create42;
        Provider<ItemBinder> provider39 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideProductComparisonItemBinder$brandspace_releaseFactory.create(create42));
        this.P1 = provider39;
        this.Q1 = ProductComparisonBlueprint_Factory.create(this.y0, provider39);
        MainBannerItemPresenterImpl_Factory create43 = MainBannerItemPresenterImpl_Factory.create(this.w0, this.n0);
        this.R1 = create43;
        Provider<MainBannerItemPresenter> provider40 = DoubleCheck.provider(create43);
        this.S1 = provider40;
        MainBannerItemBlueprint_Factory create44 = MainBannerItemBlueprint_Factory.create(provider40);
        this.T1 = create44;
        Provider<ItemBinder> provider41 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideMainBannerItemBinder$brandspace_releaseFactory.create(create44));
        this.U1 = provider41;
        this.V1 = MainBannerBlueprint_Factory.create(this.y0, provider41);
        TextWithImagePresenterImpl_Factory create45 = TextWithImagePresenterImpl_Factory.create(this.w0, this.n0);
        this.W1 = create45;
        Provider<TextWithImagePresenter> provider42 = DoubleCheck.provider(create45);
        this.X1 = provider42;
        this.Y1 = TextWithImageBlueprint_Factory.create(provider42);
        TextWithVideoPresenterImpl_Factory create46 = TextWithVideoPresenterImpl_Factory.create(this.w0, this.n0);
        this.Z1 = create46;
        Provider<TextWithVideoPresenter> provider43 = DoubleCheck.provider(create46);
        this.f34a2 = provider43;
        this.b2 = TextWithVideoBlueprint_Factory.create(provider43);
        ProductDescriptionPresenterImpl_Factory create47 = ProductDescriptionPresenterImpl_Factory.create(this.w0, this.n0);
        this.c2 = create47;
        Provider<ProductDescriptionPresenter> provider44 = DoubleCheck.provider(create47);
        this.d2 = provider44;
        ProductDescriptionItemBlueprint_Factory create48 = ProductDescriptionItemBlueprint_Factory.create(provider44);
        this.e2 = create48;
        Provider<ItemBinder> provider45 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideProductDescriptionItemBinder$brandspace_releaseFactory.create(create48));
        this.f2 = provider45;
        this.g2 = ProductDescriptionBlueprint_Factory.create(this.y0, provider45);
        Provider<BannerPresenter> provider46 = DoubleCheck.provider(BannerPresenterImpl_Factory.create());
        this.h2 = provider46;
        this.i2 = BannerBlueprint_Factory.create(provider46);
        Provider<ParagraphItemPresenter> provider47 = DoubleCheck.provider(ParagraphItemPresenterImpl_Factory.create());
        this.j2 = provider47;
        this.k2 = ParagraphBlueprint_Factory.create(provider47);
        Provider<WideAboutItemPresenter> provider48 = DoubleCheck.provider(WideAboutItemPresenterImpl_Factory.create());
        this.l2 = provider48;
        this.m2 = WideAboutBlueprint_Factory.create(provider48);
        Provider<LegalPresenter> provider49 = DoubleCheck.provider(LegalPresenterImpl_Factory.create());
        this.n2 = provider49;
        this.o2 = LegalBlueprint_Factory.create(provider49);
        Provider<UniversalCarouselItemsBlueprints> provider50 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideUniversalCarouselBlueprints$brandspace_releaseFactory.create());
        this.p2 = provider50;
        this.q2 = UniversalCarouselsBlueprint_Factory.create(this.y0, provider50);
        CategoryPresenterImpl_Factory create49 = CategoryPresenterImpl_Factory.create(this.w0, this.n0);
        this.r2 = create49;
        Provider<CategoryPresenter> provider51 = DoubleCheck.provider(create49);
        this.s2 = provider51;
        CategoryBlueprint_Factory create50 = CategoryBlueprint_Factory.create(provider51);
        this.t2 = create50;
        Provider<WrapUniversalCarouselItemsBlueprints> provider52 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideWrapableUniversalCarouselBlueprints$brandspace_releaseFactory.create(create50, this.x1));
        this.u2 = provider52;
        WrapUniversalCarouselsBlueprint_Factory create51 = WrapUniversalCarouselsBlueprint_Factory.create(this.y0, provider52);
        this.v2 = create51;
        Provider<ItemBinder> provider53 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideItemBinder$brandspace_releaseFactory.create(this.E0, this.H0, this.J0, this.M0, this.O0, this.R0, this.W0, this.b1, this.d1, this.h1, this.n1, this.x1, this.A1, this.B1, this.G1, this.L1, this.Q1, this.V1, this.Y1, this.b2, this.g2, this.i2, this.k2, this.m2, this.o2, this.q2, create51));
        this.w2 = provider53;
        this.x2 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideAdapterPresenter$brandspace_releaseFactory.create(provider53));
        Provider<DestroyableViewHolderBuilder> provider54 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideDestroyableViewHolderBuilder$brandspace_releaseFactory.create(this.w2));
        this.y2 = provider54;
        this.z2 = DoubleCheck.provider(BrandspaceFragmentModule_ProvideListRecyclerAdapter$brandspace_releaseFactory.create(this.x2, provider54));
        BrandpaceSpanProviderImpl_Factory create52 = BrandpaceSpanProviderImpl_Factory.create(this.m);
        this.A2 = create52;
        this.B2 = DoubleCheck.provider(create52);
    }

    public static BrandspaceFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentComponent
    public void inject(BrandspaceFragment brandspaceFragment) {
        BrandspaceFragment_MembersInjector.injectPresenter(brandspaceFragment, this.w0.get());
        BrandspaceFragment_MembersInjector.injectCarouselPresenter(brandspaceFragment, this.y0.get());
        BrandspaceFragment_MembersInjector.injectActivityIntentFactory(brandspaceFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        BrandspaceFragment_MembersInjector.injectDeepLinkIntentFactory(brandspaceFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        BrandspaceFragment_MembersInjector.injectTracker(brandspaceFragment, this.r0.get());
        BrandspaceFragment_MembersInjector.injectItemVisibilityTracker(brandspaceFragment, this.C0.get());
        BrandspaceFragment_MembersInjector.injectAnalytics(brandspaceFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        BrandspaceFragment_MembersInjector.injectAdapter(brandspaceFragment, this.z2.get());
        BrandspaceFragment_MembersInjector.injectSpanProvider(brandspaceFragment, this.B2.get());
        BrandspaceFragment_MembersInjector.injectDestroyableViewHolderBuilder(brandspaceFragment, this.y2.get());
        BrandspaceFragment_MembersInjector.injectBrandspaceResources(brandspaceFragment, this.m.get());
        BrandspaceFragment_MembersInjector.injectDeviceMetrics(brandspaceFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
    }
}
