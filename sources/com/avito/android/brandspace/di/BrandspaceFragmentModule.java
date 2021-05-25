package com.avito.android.brandspace.di;

import a2.b.a.a.a;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.brandspace.data.AdvertRepository;
import com.avito.android.brandspace.data.BrandspaceAdvertRepositoryImpl;
import com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl;
import com.avito.android.brandspace.data.SearchAdvertRepositoryImpl;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractorImpl;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopFilter;
import com.avito.android.brandspace.interactor.BrandspaceBlockViewAtTopOrBottomFilter;
import com.avito.android.brandspace.interactor.BrandspaceInteractor;
import com.avito.android.brandspace.interactor.BrandspaceInteractorImpl;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.adverts.AdvertItemBlueprint;
import com.avito.android.brandspace.items.adverts.AdvertItemPresenter;
import com.avito.android.brandspace.items.adverts.AdvertItemPresenterImpl;
import com.avito.android.brandspace.items.button.ButtonBlueprint;
import com.avito.android.brandspace.items.button.ButtonPresenter;
import com.avito.android.brandspace.items.button.ButtonPresenterImpl;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.items.carousel.CarouselPresenterImpl;
import com.avito.android.brandspace.items.categories.CategoriesBlueprint;
import com.avito.android.brandspace.items.categories.CategoriesPresenter;
import com.avito.android.brandspace.items.categories.CategoriesPresenterImpl;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItem;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemBlueprint;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemMeasurer;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemPresenter;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemPresenterImpl;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemView;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemViewImpl;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemsBlueprint;
import com.avito.android.brandspace.items.image.ImageBlueprint;
import com.avito.android.brandspace.items.image.ImagePresenter;
import com.avito.android.brandspace.items.image.ImagePresenterImpl;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryBlueprint;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemBlueprint;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemPresenter;
import com.avito.android.brandspace.items.imagegallery.ImageGalleryItemPresenterImpl;
import com.avito.android.brandspace.items.legal.LegalBlueprint;
import com.avito.android.brandspace.items.legal.LegalPresenter;
import com.avito.android.brandspace.items.legal.LegalPresenterImpl;
import com.avito.android.brandspace.items.loading.LoadingBlueprint;
import com.avito.android.brandspace.items.loading.LoadingPresenter;
import com.avito.android.brandspace.items.loading.LoadingPresenterImpl;
import com.avito.android.brandspace.items.mainbanner.MainBannerBlueprint;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemBlueprint;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenter;
import com.avito.android.brandspace.items.mainbanner.MainBannerItemPresenterImpl;
import com.avito.android.brandspace.items.marketplace.UniversalCarouselItemsBlueprints;
import com.avito.android.brandspace.items.marketplace.UniversalCarouselsBlueprint;
import com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselItemsBlueprints;
import com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselsBlueprint;
import com.avito.android.brandspace.items.marketplace.banner.BannerBlueprint;
import com.avito.android.brandspace.items.marketplace.banner.BannerPresenter;
import com.avito.android.brandspace.items.marketplace.banner.BannerPresenterImpl;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderBlueprint;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenter;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenterImpl;
import com.avito.android.brandspace.items.marketplace.categories.CategoryBlueprint;
import com.avito.android.brandspace.items.marketplace.categories.CategoryPresenter;
import com.avito.android.brandspace.items.marketplace.categories.CategoryPresenterImpl;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonBlueprint;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonItem;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonPresenter;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonPresenterImpl;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetBlueprint;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetCarouselBlueprint;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetPresenter;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetPresenterImpl;
import com.avito.android.brandspace.items.marketplace.snippets.SnippetLoadingPresenter;
import com.avito.android.brandspace.items.marketplace.snippets.SnippetLoadingPresenterImpl;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabBlueprint;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenter;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenterImpl;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonItem;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonPresenter;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonPresenterImpl;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenterImpl;
import com.avito.android.brandspace.items.news.NewsBlueprint;
import com.avito.android.brandspace.items.news.NewsItem;
import com.avito.android.brandspace.items.news.NewsItemBlueprint;
import com.avito.android.brandspace.items.news.NewsItemMeasurer;
import com.avito.android.brandspace.items.news.NewsItemPresenter;
import com.avito.android.brandspace.items.news.NewsItemPresenterImpl;
import com.avito.android.brandspace.items.news.NewsItemView;
import com.avito.android.brandspace.items.news.NewsItemViewImpl;
import com.avito.android.brandspace.items.paragraph.ParagraphBlueprint;
import com.avito.android.brandspace.items.paragraph.ParagraphItemPresenter;
import com.avito.android.brandspace.items.paragraph.ParagraphItemPresenterImpl;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonBlueprint;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItem;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemBlueprint;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemMeasurer;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPresenter;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPresenterImpl;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemProperty;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemPropertyMeasurer;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemViewImpl;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonPropertyMeasurer;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonPropertyMeasurerImpl;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionBlueprint;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItem;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemBlueprint;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionItemMeasurer;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionPresenter;
import com.avito.android.brandspace.items.productdescriptions.ProductDescriptionPresenterImpl;
import com.avito.android.brandspace.items.text.TextBlueprint;
import com.avito.android.brandspace.items.text.TextPresenter;
import com.avito.android.brandspace.items.text.TextPresenterImpl;
import com.avito.android.brandspace.items.text_with_image.TextWithImageBlueprint;
import com.avito.android.brandspace.items.text_with_image.TextWithImagePresenter;
import com.avito.android.brandspace.items.text_with_image.TextWithImagePresenterImpl;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoBlueprint;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenter;
import com.avito.android.brandspace.items.text_with_video.TextWithVideoPresenterImpl;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurer;
import com.avito.android.brandspace.items.textmeasurement.ItemsMeasurerImpl;
import com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurerImpl;
import com.avito.android.brandspace.items.videogallery.VideoGalleryBlueprint;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItem;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemBlueprint;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemMeasurer;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemViewImpl;
import com.avito.android.brandspace.items.videogallery.VideoGalleryPresenter;
import com.avito.android.brandspace.items.videogallery.VideoGalleryPresenterImpl;
import com.avito.android.brandspace.items.wideabout.WideAboutBlueprint;
import com.avito.android.brandspace.items.wideabout.WideAboutItemPresenter;
import com.avito.android.brandspace.items.wideabout.WideAboutItemPresenterImpl;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessorImpl;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilder;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProviderImpl;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessorImpl;
import com.avito.android.brandspace.presenter.mappers.BrandspaceElementMapper;
import com.avito.android.brandspace.presenter.mappers.MarketplaceTabsModuleMapper;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTrackerImpl;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.brandspace.view.BrandpaceSpanProvider;
import com.avito.android.brandspace.view.BrandpaceSpanProviderImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertItemPresenterModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.CallAdapterFactoryResourceProviderImpl;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpAdvertConverterImpl;
import com.avito.android.serp.adapter.SimpleAdvertSpanCountProvider;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002¼\u0001B\u000b\b\u0002¢\u0006\u0006\bº\u0001\u0010»\u0001J+\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012Jç\u0001\u0010L\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0004\bJ\u0010KJ\u001f\u0010R\u001a\u00020O2\u0006\u0010N\u001a\u00020M2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\bP\u0010QJ\u000f\u0010V\u001a\u00020SH\u0001¢\u0006\u0004\bT\u0010UJ\u0017\u0010[\u001a\u00020X2\u0006\u0010W\u001a\u00020IH\u0001¢\u0006\u0004\bY\u0010ZJ\u001f\u0010b\u001a\u00020_2\u0006\u0010\\\u001a\u00020X2\u0006\u0010^\u001a\u00020]H\u0001¢\u0006\u0004\b`\u0010aJ\u0017\u0010e\u001a\u00020]2\u0006\u0010W\u001a\u00020IH\u0001¢\u0006\u0004\bc\u0010dJ\u0017\u0010j\u001a\u00020I2\u0006\u0010g\u001a\u00020fH\u0001¢\u0006\u0004\bh\u0010iJ\u0017\u0010o\u001a\u00020I2\u0006\u0010l\u001a\u00020kH\u0001¢\u0006\u0004\bm\u0010nJ\u0017\u0010t\u001a\u00020I2\u0006\u0010q\u001a\u00020pH\u0001¢\u0006\u0004\br\u0010sJ\u0017\u0010y\u001a\u00020I2\u0006\u0010v\u001a\u00020uH\u0001¢\u0006\u0004\bw\u0010xJ\u0017\u0010~\u001a\u00020I2\u0006\u0010{\u001a\u00020zH\u0001¢\u0006\u0004\b|\u0010}J\u001b\u0010\u0001\u001a\u00020I2\u0007\u0010\u0001\u001a\u00020H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020I2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J)\u0010\u0001\u001a\u00030\u00012\n\b\u0001\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010£\u0001\u001a\u00030 \u00012\n\b\u0001\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\r\u001a\u00030\u0001H\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J)\u0010§\u0001\u001a\u00030¤\u00012\n\b\u0001\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J)\u0010«\u0001\u001a\u00030¨\u00012\n\b\u0001\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b©\u0001\u0010ª\u0001J)\u0010¯\u0001\u001a\u00030¬\u00012\n\b\u0001\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b­\u0001\u0010®\u0001J\u001d\u0010µ\u0001\u001a\u00030²\u00012\b\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001d\u0010¹\u0001\u001a\u00030¶\u00012\b\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b·\u0001\u0010¸\u0001¨\u0006½\u0001"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceFragmentModule;", "", "Lcom/avito/android/brandspace/interactor/BrandspaceBlockViewAtTopFilter;", "brandspaceBlockViewAtTopFilter", "Lcom/avito/android/brandspace/interactor/BrandspaceBlockViewAtTopOrBottomFilter;", "bannerBlockViewAtTopOrBottomFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$brandspace_release", "(Lcom/avito/android/brandspace/interactor/BrandspaceBlockViewAtTopFilter;Lcom/avito/android/brandspace/interactor/BrandspaceBlockViewAtTopOrBottomFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "provideAdvertConverter", "(Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "Lcom/avito/android/brandspace/items/image/ImageBlueprint;", "imageBlueprint", "Lcom/avito/android/brandspace/items/categories/CategoriesBlueprint;", "brandspaceCategoriesBlueprint", "Lcom/avito/android/brandspace/items/text/TextBlueprint;", "textBlueprint", "Lcom/avito/android/brandspace/items/button/ButtonBlueprint;", "buttonBlueprint", "Lcom/avito/android/brandspace/items/loading/LoadingBlueprint;", "loadingBlueprint", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabBlueprint;", "marketplaceTabBlueprint", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemsBlueprint;", "categoryItemsBlueprint", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryBlueprint;", "videoGalleryBlueprint", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonBlueprint;", "skeletonBlueprint", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderBlueprint;", "carouselLoaderBlueprint", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderBlueprint;", "tabLoaderBlueprint", "Lcom/avito/android/brandspace/items/adverts/AdvertItemBlueprint;", "advertItemBlueprint", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetBlueprint;", "marketplaceItemSnippetBlueprint", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetCarouselBlueprint;", "marketplaceSnippetCarouselsBlueprint", "Lcom/avito/android/brandspace/items/news/NewsBlueprint;", "newsBlueprint", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryBlueprint;", "imageGalleryBlueprint", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonBlueprint;", "productComparisonBlueprint", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerBlueprint;", "mainBannerBlueprint", "Lcom/avito/android/brandspace/items/text_with_image/TextWithImageBlueprint;", "textWithImageBlueprint", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoBlueprint;", "textWithVideoBlueprint", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionBlueprint;", "productDescriptionsBlueprint", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerBlueprint;", "bannerBlueprint", "Lcom/avito/android/brandspace/items/paragraph/ParagraphBlueprint;", "paragraphBlueprint", "Lcom/avito/android/brandspace/items/wideabout/WideAboutBlueprint;", "wideParagraphBlueprint", "Lcom/avito/android/brandspace/items/legal/LegalBlueprint;", "legalBlueprint", "Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselsBlueprint;", "universalCarouselsBlueprint", "Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselsBlueprint;", "wrapUniversalCarouselsBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/image/ImageBlueprint;Lcom/avito/android/brandspace/items/categories/CategoriesBlueprint;Lcom/avito/android/brandspace/items/text/TextBlueprint;Lcom/avito/android/brandspace/items/button/ButtonBlueprint;Lcom/avito/android/brandspace/items/loading/LoadingBlueprint;Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabBlueprint;Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemsBlueprint;Lcom/avito/android/brandspace/items/videogallery/VideoGalleryBlueprint;Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonBlueprint;Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderBlueprint;Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderBlueprint;Lcom/avito/android/brandspace/items/adverts/AdvertItemBlueprint;Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetBlueprint;Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetCarouselBlueprint;Lcom/avito/android/brandspace/items/news/NewsBlueprint;Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryBlueprint;Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonBlueprint;Lcom/avito/android/brandspace/items/mainbanner/MainBannerBlueprint;Lcom/avito/android/brandspace/items/text_with_image/TextWithImageBlueprint;Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoBlueprint;Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionBlueprint;Lcom/avito/android/brandspace/items/marketplace/banner/BannerBlueprint;Lcom/avito/android/brandspace/items/paragraph/ParagraphBlueprint;Lcom/avito/android/brandspace/items/wideabout/WideAboutBlueprint;Lcom/avito/android/brandspace/items/legal/LegalBlueprint;Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselsBlueprint;Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselsBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryBlueprint;", "categoryBlueprint", "Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;", "provideWrapableUniversalCarouselBlueprints$brandspace_release", "(Lcom/avito/android/brandspace/items/marketplace/categories/CategoryBlueprint;Lcom/avito/android/brandspace/items/adverts/AdvertItemBlueprint;)Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;", "provideWrapableUniversalCarouselBlueprints", "Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselItemsBlueprints;", "provideUniversalCarouselBlueprints$brandspace_release", "()Lcom/avito/android/brandspace/items/marketplace/UniversalCarouselItemsBlueprints;", "provideUniversalCarouselBlueprints", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$brandspace_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "presenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "holderBuilder", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "provideListRecyclerAdapter$brandspace_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "provideListRecyclerAdapter", "provideDestroyableViewHolderBuilder$brandspace_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemBlueprint;", "categoryItemBlueprint", "provideCategoriesItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideCategoriesItemBinder", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemBlueprint;", "videoGalleryItemBlueprint", "provideVideoGalleryItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideVideoGalleryItemBinder", "Lcom/avito/android/brandspace/items/news/NewsItemBlueprint;", "newsItemBlueprint", "provideNewsItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/news/NewsItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideNewsItemBinder", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItemBlueprint;", "productDesriptionItemBlueprint", "provideProductDescriptionItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideProductDescriptionItemBinder", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemBlueprint;", "imageGalleryItemBlueprint", "provideImageGalleryItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideImageGalleryItemBinder", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemBlueprint;", "productComparisonItemBlueprint", "provideProductComparisonItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideProductComparisonItemBinder", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemBlueprint;", "mainBannerItemBlueprint", "provideMainBannerItemBinder$brandspace_release", "(Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideMainBannerItemBinder", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "brandspaceAnalyticsInteractor", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent$brandspace_release", "(Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "provideCallAdapterResourceProvider$brandspace_release", "(Landroid/app/Application;)Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "provideCallAdapterResourceProvider", "Landroid/content/Context;", "context", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "textMeasurer", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Measurer;", "categoryItemMeasurer$brandspace_release", "(Landroid/content/Context;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Measurer;", "categoryItemMeasurer", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;", "videoPreviewMeasurer$brandspace_release", "(Landroid/content/Context;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;", "videoPreviewMeasurer", "Lcom/avito/android/brandspace/items/news/NewsItemView$Measurer;", "newsItemPreviewMeasurer$brandspace_release", "(Landroid/content/Context;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)Lcom/avito/android/brandspace/items/news/NewsItemView$Measurer;", "newsItemPreviewMeasurer", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Measurer;", "productComparisonMeasurer$brandspace_release", "(Landroid/content/Context;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Measurer;", "productComparisonMeasurer", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyMeasurer;", "productComparisonTextMeasurer$brandspace_release", "(Landroid/content/Context;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyMeasurer;", "productComparisonTextMeasurer", "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonItem;", "provideSkeletonItem$brandspace_release", "(Lcom/avito/android/IdProvider;)Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonItem;", "provideSkeletonItem", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonItem;", "provideTabSkeletonItem$brandspace_release", "(Lcom/avito/android/IdProvider;)Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonItem;", "provideTabSkeletonItem", "<init>", "()V", "Declarations", "brandspace_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AdvertItemPresenterModule.class, FavoriteAdvertsPresenterModule.class, FavoriteItemModule.class})
public final class BrandspaceFragmentModule {
    @NotNull
    public static final BrandspaceFragmentModule INSTANCE = new BrandspaceFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010!\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010!\u001a\u00020-H'¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u0002022\u0006\u0010!\u001a\u000201H'¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u0002062\u0006\u0010!\u001a\u000205H'¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020:2\u0006\u0010!\u001a\u000209H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020>2\u0006\u0010!\u001a\u00020=H'¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020B2\u0006\u0010!\u001a\u00020AH'¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020F2\u0006\u0010!\u001a\u00020EH'¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020J2\u0006\u0010!\u001a\u00020IH'¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020N2\u0006\u0010!\u001a\u00020MH'¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020R2\u0006\u0010!\u001a\u00020QH'¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020V2\u0006\u0010!\u001a\u00020UH'¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020Z2\u0006\u0010!\u001a\u00020YH'¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020^2\u0006\u0010!\u001a\u00020]H'¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020b2\u0006\u0010!\u001a\u00020aH'¢\u0006\u0004\bc\u0010dJ\u0017\u0010g\u001a\u00020f2\u0006\u0010!\u001a\u00020eH'¢\u0006\u0004\bg\u0010hJ\u0017\u0010k\u001a\u00020j2\u0006\u0010!\u001a\u00020iH'¢\u0006\u0004\bk\u0010lJ\u0017\u0010o\u001a\u00020n2\u0006\u0010!\u001a\u00020mH'¢\u0006\u0004\bo\u0010pJ\u0017\u0010s\u001a\u00020r2\u0006\u0010!\u001a\u00020qH'¢\u0006\u0004\bs\u0010tJ\u0017\u0010w\u001a\u00020v2\u0006\u0010!\u001a\u00020uH'¢\u0006\u0004\bw\u0010xJ\u0017\u0010{\u001a\u00020z2\u0006\u0010!\u001a\u00020yH'¢\u0006\u0004\b{\u0010|J\u0018\u0010\u001a\u00020~2\u0006\u0010!\u001a\u00020}H'¢\u0006\u0005\b\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010!\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010!\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010!\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010!\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010!\u001a\u00020\tH'¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010 \u0001J!\u0010¢\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030¡\u0001H'¢\u0006\u0006\b¢\u0001\u0010£\u0001J!\u0010¥\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030¤\u0001H'¢\u0006\u0006\b¥\u0001\u0010¦\u0001J!\u0010¨\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030§\u0001H'¢\u0006\u0006\b¨\u0001\u0010©\u0001J!\u0010«\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\u0001\u001a\u00030ª\u0001H'¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001d\u0010°\u0001\u001a\u00030¯\u00012\b\u0010®\u0001\u001a\u00030­\u0001H'¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001d\u0010µ\u0001\u001a\u00030´\u00012\b\u0010³\u0001\u001a\u00030²\u0001H'¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001d\u0010º\u0001\u001a\u00030¹\u00012\b\u0010¸\u0001\u001a\u00030·\u0001H'¢\u0006\u0006\bº\u0001\u0010»\u0001J\u001d\u0010¿\u0001\u001a\u00030¾\u00012\b\u0010½\u0001\u001a\u00030¼\u0001H'¢\u0006\u0006\b¿\u0001\u0010À\u0001J$\u0010Å\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010Ã\u00012\b\u0010Â\u0001\u001a\u00030Á\u0001H'¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J$\u0010É\u0001\u001a\n\u0012\u0005\u0012\u00030È\u00010Ã\u00012\b\u0010Â\u0001\u001a\u00030Ç\u0001H'¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J$\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Ì\u00010Ã\u00012\b\u0010Â\u0001\u001a\u00030Ë\u0001H'¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u001d\u0010Ñ\u0001\u001a\u00030Ð\u00012\b\u0010½\u0001\u001a\u00030Ï\u0001H'¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J$\u0010Ö\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010Ô\u00012\b\u0010Â\u0001\u001a\u00030Ó\u0001H'¢\u0006\u0006\bÖ\u0001\u0010×\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceFragmentModule$Declarations;", "", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurerImpl;", "textMeasurer", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "provideTextMeasurer", "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurerImpl;)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "Lcom/avito/android/brandspace/presenter/BrandspacePresenterImpl;", "brandspacePresenter", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "bindsBrandspacePresenter", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenterImpl;)Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "Lcom/avito/android/brandspace/interactor/BrandspaceInteractorImpl;", "brandspaceInteractor", "Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "bindsBrandspaceInteractor", "(Lcom/avito/android/brandspace/interactor/BrandspaceInteractorImpl;)Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "bindBrandspaceAnalyticsInteractor", "(Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractorImpl;)Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProviderImpl;", "resourceProvider", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "bindBrandspaceResourceProvider", "(Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProviderImpl;)Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTrackerImpl;", "tracker", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "bindBrandspaceTracker", "(Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTrackerImpl;)Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPresenterImpl;", "presenter", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPresenter;", "bindProductComparisonPresenter", "(Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPresenterImpl;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPresenter;", "Lcom/avito/android/brandspace/items/image/ImagePresenterImpl;", "Lcom/avito/android/brandspace/items/image/ImagePresenter;", "bindImagePresenter", "(Lcom/avito/android/brandspace/items/image/ImagePresenterImpl;)Lcom/avito/android/brandspace/items/image/ImagePresenter;", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenter;", "bindBannerPresenter", "(Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/banner/BannerPresenter;", "Lcom/avito/android/brandspace/items/categories/CategoriesPresenterImpl;", "Lcom/avito/android/brandspace/items/categories/CategoriesPresenter;", "bindCategoriesPresenter", "(Lcom/avito/android/brandspace/items/categories/CategoriesPresenterImpl;)Lcom/avito/android/brandspace/items/categories/CategoriesPresenter;", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenter;", "bindMarketplaceTabPresenter", "(Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenter;", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenter;", "bindCategoryPresenter", "(Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenter;", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetPresenter;", "bindMarketplaceItemSnippetPresenter", "(Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetPresenter;", "Lcom/avito/android/brandspace/items/text/TextPresenterImpl;", "Lcom/avito/android/brandspace/items/text/TextPresenter;", "bindTextPresenter", "(Lcom/avito/android/brandspace/items/text/TextPresenterImpl;)Lcom/avito/android/brandspace/items/text/TextPresenter;", "Lcom/avito/android/brandspace/items/button/ButtonPresenterImpl;", "Lcom/avito/android/brandspace/items/button/ButtonPresenter;", "bindButtonPresenter", "(Lcom/avito/android/brandspace/items/button/ButtonPresenterImpl;)Lcom/avito/android/brandspace/items/button/ButtonPresenter;", "Lcom/avito/android/brandspace/items/loading/LoadingPresenterImpl;", "Lcom/avito/android/brandspace/items/loading/LoadingPresenter;", "bindLoadingPresenter", "(Lcom/avito/android/brandspace/items/loading/LoadingPresenterImpl;)Lcom/avito/android/brandspace/items/loading/LoadingPresenter;", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonPresenter;", "bindSkeletonPresenter", "(Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonPresenter;", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonPresenter;", "bindTabSkeletonPresenter", "(Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonPresenter;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "bindCarouselLoaderPresenter", "(Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "bindTabLoaderPresenter", "(Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "Lcom/avito/android/brandspace/items/marketplace/snippets/SnippetLoadingPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/snippets/SnippetLoadingPresenter;", "bindSnippetLoadingPresenter", "(Lcom/avito/android/brandspace/items/marketplace/snippets/SnippetLoadingPresenterImpl;)Lcom/avito/android/brandspace/items/marketplace/snippets/SnippetLoadingPresenter;", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenterImpl;", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "bindCarouselPresenter", "(Lcom/avito/android/brandspace/items/carousel/CarouselPresenterImpl;)Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemPresenterImpl;", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemPresenter;", "bindCategoryItemPresenter", "(Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemPresenterImpl;)Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemPresenter;", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenterImpl;", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenter;", "bindProductDescriptionPresenter", "(Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenterImpl;)Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenter;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenterImpl;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenter;", "bindVideoGalleryPresenter", "(Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenterImpl;)Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenter;", "Lcom/avito/android/brandspace/items/news/NewsItemPresenterImpl;", "Lcom/avito/android/brandspace/items/news/NewsItemPresenter;", "bindNewsItemPresenter", "(Lcom/avito/android/brandspace/items/news/NewsItemPresenterImpl;)Lcom/avito/android/brandspace/items/news/NewsItemPresenter;", "Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenterImpl;", "Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", "bindAdvertItemPresenter", "(Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenterImpl;)Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenterImpl;", "Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenter;", "bindImageGalleryItemPresenter", "(Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenterImpl;)Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItemPresenter;", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenterImpl;", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenter;", "bindMainBannerItemPresenter", "(Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenterImpl;)Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemPresenter;", "Lcom/avito/android/brandspace/items/text_with_image/TextWithImagePresenterImpl;", "Lcom/avito/android/brandspace/items/text_with_image/TextWithImagePresenter;", "bindTextWithImageItemPresenter", "(Lcom/avito/android/brandspace/items/text_with_image/TextWithImagePresenterImpl;)Lcom/avito/android/brandspace/items/text_with_image/TextWithImagePresenter;", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenterImpl;", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenter;", "bindTextWithVideoPresenter", "(Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenterImpl;)Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoPresenter;", "Lcom/avito/android/brandspace/items/paragraph/ParagraphItemPresenterImpl;", "Lcom/avito/android/brandspace/items/paragraph/ParagraphItemPresenter;", "bindParagraphItemPresenter", "(Lcom/avito/android/brandspace/items/paragraph/ParagraphItemPresenterImpl;)Lcom/avito/android/brandspace/items/paragraph/ParagraphItemPresenter;", "Lcom/avito/android/brandspace/items/wideabout/WideAboutItemPresenterImpl;", "Lcom/avito/android/brandspace/items/wideabout/WideAboutItemPresenter;", "bindWideAboutItemPresenter", "(Lcom/avito/android/brandspace/items/wideabout/WideAboutItemPresenterImpl;)Lcom/avito/android/brandspace/items/wideabout/WideAboutItemPresenter;", "Lcom/avito/android/brandspace/items/legal/LegalPresenterImpl;", "Lcom/avito/android/brandspace/items/legal/LegalPresenter;", "bindLegalPresenter", "(Lcom/avito/android/brandspace/items/legal/LegalPresenterImpl;)Lcom/avito/android/brandspace/items/legal/LegalPresenter;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilderImpl;", "builder", "Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "buildBrandspaceScreenBuilder", "(Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilderImpl;)Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemMeasurer;", "measurer", "Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "provideCategoryItemMeasurer", "(Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemMeasurer;", "provideVideoGalleryItemMeasurer", "(Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/news/NewsItemMeasurer;", "provideNewsItemMeasurer", "(Lcom/avito/android/brandspace/items/news/NewsItemMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItemMeasurer;", "provideProductDescriptionItemMeasurer", "(Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItemMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemMeasurer;", "provideProductComparisonItemMeasurer", "(Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPropertyMeasurer;", "provideProductComparisonItemPropertyMeasurer", "(Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemPropertyMeasurer;)Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurerImpl;", "itemMeasurer", "Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "provideItemsMeasurer", "(Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurerImpl;)Lcom/avito/android/brandspace/items/textmeasurement/ItemsMeasurer;", "Lcom/avito/android/brandspace/view/BrandpaceSpanProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "provideBrandpaceSpanProvider", "(Lcom/avito/android/brandspace/view/BrandpaceSpanProviderImpl;)Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;", "statusResolver", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "provideFavoriteStatusResolver", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;)Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessorImpl;", "processor", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "brandspaceAdvertItemProcessor", "(Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessorImpl;)Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "Lcom/avito/android/brandspace/data/BrandspaceAdvertRepositoryImpl;", "repository", "Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", "brandspaceBrandspaceAdvertRepository", "(Lcom/avito/android/brandspace/data/BrandspaceAdvertRepositoryImpl;)Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/data/SearchAdvertRepositoryImpl;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "brandspaceSearchAdvertRepository", "(Lcom/avito/android/brandspace/data/SearchAdvertRepositoryImpl;)Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/data/BrandspaceTabsRepositoryImpl;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "brandspaceTabsAdvertRepository", "(Lcom/avito/android/brandspace/data/BrandspaceTabsRepositoryImpl;)Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessorImpl;", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "brandspaceMarketplaceItemsProcessor", "(Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessorImpl;)Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "Lcom/avito/android/brandspace/presenter/mappers/MarketplaceTabsModuleMapper;", "Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;", "brandspaceMarketplaceTabsModuleMapper", "(Lcom/avito/android/brandspace/presenter/mappers/MarketplaceTabsModuleMapper;)Lcom/avito/android/brandspace/presenter/mappers/BrandspaceElementMapper;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull BrandspacePresenter brandspacePresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemPresenter bindAdvertItemPresenter(@NotNull AdvertItemPresenterImpl advertItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        BannerPresenter bindBannerPresenter(@NotNull BannerPresenterImpl bannerPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceAnalyticsInteractor bindBrandspaceAnalyticsInteractor(@NotNull BrandspaceAnalyticsInteractorImpl brandspaceAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceResourcesProvider bindBrandspaceResourceProvider(@NotNull BrandspaceResourcesProviderImpl brandspaceResourcesProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceTracker bindBrandspaceTracker(@NotNull BrandspaceTrackerImpl brandspaceTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ButtonPresenter bindButtonPresenter(@NotNull ButtonPresenterImpl buttonPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CarouselLoaderPresenter bindCarouselLoaderPresenter(@NotNull CarouselLoaderPresenterImpl carouselLoaderPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CarouselPresenter bindCarouselPresenter(@NotNull CarouselPresenterImpl carouselPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CategoriesPresenter bindCategoriesPresenter(@NotNull CategoriesPresenterImpl categoriesPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CategoryItemPresenter bindCategoryItemPresenter(@NotNull CategoryItemPresenterImpl categoryItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CategoryPresenter bindCategoryPresenter(@NotNull CategoryPresenterImpl categoryPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ImageGalleryItemPresenter bindImageGalleryItemPresenter(@NotNull ImageGalleryItemPresenterImpl imageGalleryItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ImagePresenter bindImagePresenter(@NotNull ImagePresenterImpl imagePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        LegalPresenter bindLegalPresenter(@NotNull LegalPresenterImpl legalPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        LoadingPresenter bindLoadingPresenter(@NotNull LoadingPresenterImpl loadingPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MainBannerItemPresenter bindMainBannerItemPresenter(@NotNull MainBannerItemPresenterImpl mainBannerItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceSnippetPresenter bindMarketplaceItemSnippetPresenter(@NotNull MarketplaceSnippetPresenterImpl marketplaceSnippetPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceTabPresenter bindMarketplaceTabPresenter(@NotNull MarketplaceTabPresenterImpl marketplaceTabPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        NewsItemPresenter bindNewsItemPresenter(@NotNull NewsItemPresenterImpl newsItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ParagraphItemPresenter bindParagraphItemPresenter(@NotNull ParagraphItemPresenterImpl paragraphItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ProductComparisonItemPresenter bindProductComparisonPresenter(@NotNull ProductComparisonItemPresenterImpl productComparisonItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ProductDescriptionPresenter bindProductDescriptionPresenter(@NotNull ProductDescriptionPresenterImpl productDescriptionPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SkeletonPresenter bindSkeletonPresenter(@NotNull SkeletonPresenterImpl skeletonPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetLoadingPresenter bindSnippetLoadingPresenter(@NotNull SnippetLoadingPresenterImpl snippetLoadingPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TabLoaderPresenter bindTabLoaderPresenter(@NotNull TabLoaderPresenterImpl tabLoaderPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TabSkeletonPresenter bindTabSkeletonPresenter(@NotNull TabSkeletonPresenterImpl tabSkeletonPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TextPresenter bindTextPresenter(@NotNull TextPresenterImpl textPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TextWithImagePresenter bindTextWithImageItemPresenter(@NotNull TextWithImagePresenterImpl textWithImagePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TextWithVideoPresenter bindTextWithVideoPresenter(@NotNull TextWithVideoPresenterImpl textWithVideoPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        VideoGalleryPresenter bindVideoGalleryPresenter(@NotNull VideoGalleryPresenterImpl videoGalleryPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        WideAboutItemPresenter bindWideAboutItemPresenter(@NotNull WideAboutItemPresenterImpl wideAboutItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceInteractor bindsBrandspaceInteractor(@NotNull BrandspaceInteractorImpl brandspaceInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspacePresenter bindsBrandspacePresenter(@NotNull BrandspacePresenterImpl brandspacePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceAdvertItemProcessor brandspaceAdvertItemProcessor(@NotNull BrandspaceAdvertItemProcessorImpl brandspaceAdvertItemProcessorImpl);

        @Binds
        @NotNull
        @BrandspaceAdvertRepository
        @PerFragment
        AdvertRepository<AdvertSource.LinkSource> brandspaceBrandspaceAdvertRepository(@NotNull BrandspaceAdvertRepositoryImpl brandspaceAdvertRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceItemsProcessor brandspaceMarketplaceItemsProcessor(@NotNull MarketplaceItemsProcessorImpl marketplaceItemsProcessorImpl);

        @Binds
        @MarketplaceTabsMapper
        @NotNull
        @PerFragment
        BrandspaceElementMapper<MarketplaceTabsModule> brandspaceMarketplaceTabsModuleMapper(@NotNull MarketplaceTabsModuleMapper marketplaceTabsModuleMapper);

        @SearchAdvertRepository
        @Binds
        @NotNull
        @PerFragment
        AdvertRepository<AdvertSource.ParametersSource> brandspaceSearchAdvertRepository(@NotNull SearchAdvertRepositoryImpl searchAdvertRepositoryImpl);

        @TabsAdvertRepository
        @Binds
        @NotNull
        @PerFragment
        AdvertRepository<AdvertSource.TabsSource> brandspaceTabsAdvertRepository(@NotNull BrandspaceTabsRepositoryImpl brandspaceTabsRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandspaceItemBuilder buildBrandspaceScreenBuilder(@NotNull BrandspaceItemBuilderImpl brandspaceItemBuilderImpl);

        @PerFragment
        @Binds
        @NotNull
        BrandpaceSpanProvider provideBrandpaceSpanProvider(@NotNull BrandpaceSpanProviderImpl brandpaceSpanProviderImpl);

        @Binds
        @NotNull
        @ClassKey(CategoryItem.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideCategoryItemMeasurer(@NotNull CategoryItemMeasurer categoryItemMeasurer);

        @PerFragment
        @Binds
        @NotNull
        FavoriteStatusResolver provideFavoriteStatusResolver(@NotNull FavoriteStatusResolverImpl favoriteStatusResolverImpl);

        @PerFragment
        @Binds
        @NotNull
        ItemsMeasurer provideItemsMeasurer(@NotNull ItemsMeasurerImpl itemsMeasurerImpl);

        @Binds
        @NotNull
        @ClassKey(NewsItem.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideNewsItemMeasurer(@NotNull NewsItemMeasurer newsItemMeasurer);

        @Binds
        @NotNull
        @ClassKey(ProductComparisonItem.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideProductComparisonItemMeasurer(@NotNull ProductComparisonItemMeasurer productComparisonItemMeasurer);

        @Binds
        @NotNull
        @ClassKey(ProductComparisonItemProperty.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideProductComparisonItemPropertyMeasurer(@NotNull ProductComparisonItemPropertyMeasurer productComparisonItemPropertyMeasurer);

        @Binds
        @NotNull
        @ClassKey(ProductDescriptionItem.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideProductDescriptionItemMeasurer(@NotNull ProductDescriptionItemMeasurer productDescriptionItemMeasurer);

        @PerFragment
        @Binds
        @NotNull
        TextMeasurer provideTextMeasurer(@NotNull TextMeasurerImpl textMeasurerImpl);

        @Binds
        @NotNull
        @ClassKey(VideoGalleryItem.class)
        @PerFragment
        @IntoMap
        TextItemMeasurer<?> provideVideoGalleryItemMeasurer(@NotNull VideoGalleryItemMeasurer videoGalleryItemMeasurer);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpAdvertConverter provideAdvertConverter(@NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        SimpleAdvertSpanCountProvider simpleAdvertSpanCountProvider = new SimpleAdvertSpanCountProvider(1);
        return new SerpAdvertConverterImpl(simpleAdvertSpanCountProvider, simpleAdvertSpanCountProvider, resources.getBoolean(R.bool.is_tablet), features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemVisibilityTracker provideItemVisibilityTracker$brandspace_release(@NotNull BrandspaceBlockViewAtTopFilter brandspaceBlockViewAtTopFilter, @NotNull BrandspaceBlockViewAtTopOrBottomFilter brandspaceBlockViewAtTopOrBottomFilter, @BrandspaceItemVisibilityTrackerState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(brandspaceBlockViewAtTopFilter, "brandspaceBlockViewAtTopFilter");
        Intrinsics.checkNotNullParameter(brandspaceBlockViewAtTopOrBottomFilter, "bannerBlockViewAtTopOrBottomFilter");
        return new ItemVisibilityTrackerImpl.Builder(true, bundle).addFilter(brandspaceBlockViewAtTopFilter).addFilter(brandspaceBlockViewAtTopOrBottomFilter).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final CategoryItemView.Measurer categoryItemMeasurer$brandspace_release(@ViewContext @NotNull Context context, @NotNull TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        LayoutInflater from = LayoutInflater.from(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View inflate = from.inflate(com.avito.android.brandspace.R.layout.brandspace_item_categoryitem, (ViewGroup) frameLayout, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CategoryItemViewImpl.MeasurerImpl(inflate, textMeasurer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NewsItemView.Measurer newsItemPreviewMeasurer$brandspace_release(@ViewContext @NotNull Context context, @NotNull TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        LayoutInflater from = LayoutInflater.from(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View inflate = from.inflate(com.avito.android.brandspace.R.layout.brandspace_item_newsitem, (ViewGroup) frameLayout, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new NewsItemViewImpl.MeasurerImpl(inflate, textMeasurer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ProductComparisonItemView.Measurer productComparisonMeasurer$brandspace_release(@ViewContext @NotNull Context context, @NotNull TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        LayoutInflater from = LayoutInflater.from(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View inflate = from.inflate(com.avito.android.brandspace.R.layout.brandspace_item_productcomparison, (ViewGroup) frameLayout, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ProductComparisonItemViewImpl.MeasurerImpl(inflate, textMeasurer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ProductComparisonPropertyMeasurer productComparisonTextMeasurer$brandspace_release(@ViewContext @NotNull Context context, @NotNull TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        LayoutInflater from = LayoutInflater.from(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View inflate = from.inflate(com.avito.android.brandspace.R.layout.brandspace_item_productcomparison_property, (ViewGroup) frameLayout, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        return new ProductComparisonPropertyMeasurerImpl((TextView) inflate, textMeasurer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$brandspace_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CallAdapterFactoryResourceProvider provideCallAdapterResourceProvider$brandspace_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return new CallAdapterFactoryResourceProviderImpl(resources);
    }

    @Provides
    @NotNull
    @CategoriesItemBinder
    @PerFragment
    public final ItemBinder provideCategoriesItemBinder$brandspace_release(@NotNull CategoryItemBlueprint categoryItemBlueprint) {
        Intrinsics.checkNotNullParameter(categoryItemBlueprint, "categoryItemBlueprint");
        return new ItemBinder.Builder().registerItem(categoryItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$brandspace_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @NotNull
    @ImageGalleryItemBinder
    @PerFragment
    public final ItemBinder provideImageGalleryItemBinder$brandspace_release(@NotNull ImageGalleryItemBlueprint imageGalleryItemBlueprint) {
        Intrinsics.checkNotNullParameter(imageGalleryItemBlueprint, "imageGalleryItemBlueprint");
        return new ItemBinder.Builder().registerItem(imageGalleryItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$brandspace_release(@NotNull ImageBlueprint imageBlueprint, @NotNull CategoriesBlueprint categoriesBlueprint, @NotNull TextBlueprint textBlueprint, @NotNull ButtonBlueprint buttonBlueprint, @NotNull LoadingBlueprint loadingBlueprint, @NotNull MarketplaceTabBlueprint marketplaceTabBlueprint, @NotNull CategoryItemsBlueprint categoryItemsBlueprint, @NotNull VideoGalleryBlueprint videoGalleryBlueprint, @NotNull SkeletonBlueprint skeletonBlueprint, @NotNull CarouselLoaderBlueprint carouselLoaderBlueprint, @NotNull TabLoaderBlueprint tabLoaderBlueprint, @NotNull AdvertItemBlueprint advertItemBlueprint, @NotNull MarketplaceSnippetBlueprint marketplaceSnippetBlueprint, @NotNull MarketplaceSnippetCarouselBlueprint marketplaceSnippetCarouselBlueprint, @NotNull NewsBlueprint newsBlueprint, @NotNull ImageGalleryBlueprint imageGalleryBlueprint, @NotNull ProductComparisonBlueprint productComparisonBlueprint, @NotNull MainBannerBlueprint mainBannerBlueprint, @NotNull TextWithImageBlueprint textWithImageBlueprint, @NotNull TextWithVideoBlueprint textWithVideoBlueprint, @NotNull ProductDescriptionBlueprint productDescriptionBlueprint, @NotNull BannerBlueprint bannerBlueprint, @NotNull ParagraphBlueprint paragraphBlueprint, @NotNull WideAboutBlueprint wideAboutBlueprint, @NotNull LegalBlueprint legalBlueprint, @NotNull UniversalCarouselsBlueprint universalCarouselsBlueprint, @NotNull WrapUniversalCarouselsBlueprint wrapUniversalCarouselsBlueprint) {
        Intrinsics.checkNotNullParameter(imageBlueprint, "imageBlueprint");
        Intrinsics.checkNotNullParameter(categoriesBlueprint, "brandspaceCategoriesBlueprint");
        Intrinsics.checkNotNullParameter(textBlueprint, "textBlueprint");
        Intrinsics.checkNotNullParameter(buttonBlueprint, "buttonBlueprint");
        Intrinsics.checkNotNullParameter(loadingBlueprint, "loadingBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceTabBlueprint, "marketplaceTabBlueprint");
        Intrinsics.checkNotNullParameter(categoryItemsBlueprint, "categoryItemsBlueprint");
        Intrinsics.checkNotNullParameter(videoGalleryBlueprint, "videoGalleryBlueprint");
        Intrinsics.checkNotNullParameter(skeletonBlueprint, "skeletonBlueprint");
        Intrinsics.checkNotNullParameter(carouselLoaderBlueprint, "carouselLoaderBlueprint");
        Intrinsics.checkNotNullParameter(tabLoaderBlueprint, "tabLoaderBlueprint");
        Intrinsics.checkNotNullParameter(advertItemBlueprint, "advertItemBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceSnippetBlueprint, "marketplaceItemSnippetBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceSnippetCarouselBlueprint, "marketplaceSnippetCarouselsBlueprint");
        Intrinsics.checkNotNullParameter(newsBlueprint, "newsBlueprint");
        Intrinsics.checkNotNullParameter(imageGalleryBlueprint, "imageGalleryBlueprint");
        Intrinsics.checkNotNullParameter(productComparisonBlueprint, "productComparisonBlueprint");
        Intrinsics.checkNotNullParameter(mainBannerBlueprint, "mainBannerBlueprint");
        Intrinsics.checkNotNullParameter(textWithImageBlueprint, "textWithImageBlueprint");
        Intrinsics.checkNotNullParameter(textWithVideoBlueprint, "textWithVideoBlueprint");
        Intrinsics.checkNotNullParameter(productDescriptionBlueprint, "productDescriptionsBlueprint");
        Intrinsics.checkNotNullParameter(bannerBlueprint, "bannerBlueprint");
        Intrinsics.checkNotNullParameter(paragraphBlueprint, "paragraphBlueprint");
        Intrinsics.checkNotNullParameter(wideAboutBlueprint, "wideParagraphBlueprint");
        Intrinsics.checkNotNullParameter(legalBlueprint, "legalBlueprint");
        Intrinsics.checkNotNullParameter(universalCarouselsBlueprint, "universalCarouselsBlueprint");
        Intrinsics.checkNotNullParameter(wrapUniversalCarouselsBlueprint, "wrapUniversalCarouselsBlueprint");
        return new ItemBinder.Builder().registerItem(imageBlueprint).registerItem(categoriesBlueprint).registerItem(textBlueprint).registerItem(buttonBlueprint).registerItem(loadingBlueprint).registerItem(marketplaceTabBlueprint).registerItem(skeletonBlueprint).registerItem(carouselLoaderBlueprint).registerItem(tabLoaderBlueprint).registerItem(categoryItemsBlueprint).registerItem(videoGalleryBlueprint).registerItem(advertItemBlueprint).registerItem(marketplaceSnippetBlueprint).registerItem(marketplaceSnippetCarouselBlueprint).registerItem(newsBlueprint).registerItem(imageGalleryBlueprint).registerItem(productComparisonBlueprint).registerItem(mainBannerBlueprint).registerItem(textWithImageBlueprint).registerItem(textWithVideoBlueprint).registerItem(productDescriptionBlueprint).registerItem(paragraphBlueprint).registerItem(wideAboutBlueprint).registerItem(legalBlueprint).registerItem(universalCarouselsBlueprint).registerItem(wrapUniversalCarouselsBlueprint).registerItem(bannerBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ListRecyclerAdapter provideListRecyclerAdapter$brandspace_release(@NotNull AdapterPresenter adapterPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "holderBuilder");
        return new ListRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, null, 4, null);
    }

    @Provides
    @NotNull
    @MainBannerItemBinder
    @PerFragment
    public final ItemBinder provideMainBannerItemBinder$brandspace_release(@NotNull MainBannerItemBlueprint mainBannerItemBlueprint) {
        Intrinsics.checkNotNullParameter(mainBannerItemBlueprint, "mainBannerItemBlueprint");
        return new ItemBinder.Builder().registerItem(mainBannerItemBlueprint).build();
    }

    @NewsItemBinder
    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideNewsItemBinder$brandspace_release(@NotNull NewsItemBlueprint newsItemBlueprint) {
        Intrinsics.checkNotNullParameter(newsItemBlueprint, "newsItemBlueprint");
        return new ItemBinder.Builder().registerItem(newsItemBlueprint).build();
    }

    @ProductComparisonItemBinder
    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideProductComparisonItemBinder$brandspace_release(@NotNull ProductComparisonItemBlueprint productComparisonItemBlueprint) {
        Intrinsics.checkNotNullParameter(productComparisonItemBlueprint, "productComparisonItemBlueprint");
        return new ItemBinder.Builder().registerItem(productComparisonItemBlueprint).build();
    }

    @ProductDescriptionItemBinder
    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideProductDescriptionItemBinder$brandspace_release(@NotNull ProductDescriptionItemBlueprint productDescriptionItemBlueprint) {
        Intrinsics.checkNotNullParameter(productDescriptionItemBlueprint, "productDesriptionItemBlueprint");
        return new ItemBinder.Builder().registerItem(productDescriptionItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SkeletonItem provideSkeletonItem$brandspace_release(@NotNull IdProvider idProvider) {
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        return new SkeletonItem(idProvider.generateId(), BlockType.MARKETPLACE_SNIPPET_LOADER);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TabSkeletonItem provideTabSkeletonItem$brandspace_release(@NotNull IdProvider idProvider) {
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        return new TabSkeletonItem(idProvider.generateId(), BlockType.MARKETPLACE_SNIPPET_LOADER);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TreeClickStreamParent provideTreeParent$brandspace_release(@NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "brandspaceAnalyticsInteractor");
        return brandspaceAnalyticsInteractor.getParent();
    }

    @Provides
    @PerFragment
    @NotNull
    public final UniversalCarouselItemsBlueprints provideUniversalCarouselBlueprints$brandspace_release() {
        return new UniversalCarouselItemsBlueprints(CollectionsKt__CollectionsKt.emptyList());
    }

    @VideoGalleryItemBinder
    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideVideoGalleryItemBinder$brandspace_release(@NotNull VideoGalleryItemBlueprint videoGalleryItemBlueprint) {
        Intrinsics.checkNotNullParameter(videoGalleryItemBlueprint, "videoGalleryItemBlueprint");
        return new ItemBinder.Builder().registerItem(videoGalleryItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final WrapUniversalCarouselItemsBlueprints provideWrapableUniversalCarouselBlueprints$brandspace_release(@NotNull CategoryBlueprint categoryBlueprint, @NotNull AdvertItemBlueprint advertItemBlueprint) {
        Intrinsics.checkNotNullParameter(categoryBlueprint, "categoryBlueprint");
        Intrinsics.checkNotNullParameter(advertItemBlueprint, "advertItemBlueprint");
        return new WrapUniversalCarouselItemsBlueprints(CollectionsKt__CollectionsKt.listOf((Object[]) new ItemBlueprint[]{categoryBlueprint, advertItemBlueprint}));
    }

    @Provides
    @PerFragment
    @NotNull
    public final VideoGalleryItemView.Measurer videoPreviewMeasurer$brandspace_release(@ViewContext @NotNull Context context, @NotNull TextMeasurer textMeasurer, @NotNull DeviceMetrics deviceMetrics, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "resources");
        LayoutInflater from = LayoutInflater.from(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View inflate = from.inflate(com.avito.android.brandspace.R.layout.brandspace_item_videoreview, (ViewGroup) frameLayout, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new VideoGalleryItemViewImpl.MeasurerImpl(inflate, textMeasurer, deviceMetrics, brandspaceResourcesProvider);
    }
}
