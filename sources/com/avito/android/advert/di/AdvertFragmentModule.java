package com.avito.android.advert.di;

import a2.b.a.a.a;
import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.IdProvider;
import com.avito.android.IdProviderImpl;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.AdvertDetailsInteractorImpl;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert.AdvertDetailsResourcesProviderImpl;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl;
import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.advert.item.abuse.AdvertDetailsAbuseBlueprint;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter;
import com.avito.android.advert.item.abuse.di.AdvertDetailsAbuseModule;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerBlueprint;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerView;
import com.avito.android.advert.item.additionalSeller.di.AdditionalSellerModule;
import com.avito.android.advert.item.address.AdvertDetailsAddressBlueprint;
import com.avito.android.advert.item.address.di.AdvertDetailsAddressModule;
import com.avito.android.advert.item.advert_badge_bar.di.AdvertDetailsBadgeBarItemModule;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberBlueprint;
import com.avito.android.advert.item.advertnumber.di.AdvertDetailsAdvertNumberModule;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberBlueprint;
import com.avito.android.advert.item.anonymousnumber.di.AdvertDetailsAnonymousNumberModule;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogBlueprint;
import com.avito.android.advert.item.auto_catalog.di.AdvertDetailsAutoCatalogModule;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealBlueprint;
import com.avito.android.advert.item.autodeal.di.AdvertDetailsAutoDealModule;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaBlueprint;
import com.avito.android.advert.item.autoteka.di.AdvertDetailsAutotekaModule;
import com.avito.android.advert.item.autoteka.di.AdvertDetailsAutotekaTeaserModule;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserBlueprint;
import com.avito.android.advert.item.booking.AdvertBookingBlueprint;
import com.avito.android.advert.item.booking.di.AdvertBookingModule;
import com.avito.android.advert.item.car_market_price.badge.di.AdvertDetailsImvBadgeItemModule;
import com.avito.android.advert.item.car_market_price.price_chart.CarMarketPriceChartBlueprint;
import com.avito.android.advert.item.car_market_price.price_description.CarMarketPriceDescriptionBlueprint;
import com.avito.android.advert.item.carousel_photogallery.di.CarouselPhotoGalleryModule;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverter;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverterImpl;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationBlueprint;
import com.avito.android.advert.item.consultation.di.AdvertDetailsConsultationModule;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarBlueprint;
import com.avito.android.advert.item.contactbar.di.AdvertDetailsContactBarModule;
import com.avito.android.advert.item.cre_geo_report.di.AdvertDetailsGeoReportTeaserModule;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsBlueprint;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoBlueprint;
import com.avito.android.advert.item.delivery.di.AdvertDetailsDeliveryModule;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionBlueprint;
import com.avito.android.advert.item.description.di.AdvertDetailsDescriptionModule;
import com.avito.android.advert.item.dfpcreditinfo.CreditBannerFilter;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoaderImpl;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactory;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactoryImpl;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import com.avito.android.advert.item.dfpcreditinfo.di.AdvertDetailsCreditInfoModule;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerBlueprint;
import com.avito.android.advert.item.disclaimer.di.AdvertDetailsDisclaimerModule;
import com.avito.android.advert.item.divider.AdvertDetailsDividerBlueprint;
import com.avito.android.advert.item.divider.di.AdvertDetailsDividerModule;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractorImpl;
import com.avito.android.advert.item.domoteka.di.AdvertDetailsDomotekaTeaserModule;
import com.avito.android.advert.item.features_teaser.di.AdvertDetailsFeatureTeaserModule;
import com.avito.android.advert.item.features_teaser.di.PromoCardModule;
import com.avito.android.advert.item.features_teaser.items.AdvertDetailsFeatureTeaserBlueprint;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsBlueprint;
import com.avito.android.advert.item.flats.di.AdvertDetailsFlatsModule;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceBlueprint;
import com.avito.android.advert.item.georeference.di.AdvertDetailsGeoReferenceModule;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsBlueprint;
import com.avito.android.advert.item.groups.di.AdvertDetailsGroupsModule;
import com.avito.android.advert.item.guide.di.AdvertDetailsGuideModule;
import com.avito.android.advert.item.header.AdvertDetailsHeaderBlueprint;
import com.avito.android.advert.item.header.di.AdvertDetailsHeaderModule;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersBlueprint;
import com.avito.android.advert.item.icebreakers.di.AdvertDetailsIceBreakersModule;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarBlueprint;
import com.avito.android.advert.item.maketplace_badge_bar.di.MarketplaceBadgeBarModule;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsBlueprint;
import com.avito.android.advert.item.marketplace_brief_specs.di.MarketplaceBriefSpecsModule;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarBlueprint;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenter;
import com.avito.android.advert.item.marketplace_contactbar.di.MarketplaceContactBarModule;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryBlueprint;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.marketplace_delivery.di.MarketplaceDeliveryModule;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqBlueprint;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter;
import com.avito.android.advert.item.marketplace_faq.di.MarketplaceFaqModule;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoBlueprint;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenter;
import com.avito.android.advert.item.marketplace_info.di.MarketplaceInfoModule;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityBlueprint;
import com.avito.android.advert.item.marketplace_quantity.di.MarketplaceQuantityModule;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsBlueprint;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import com.avito.android.advert.item.marketplace_specs.di.MarketplaceSpecsModule;
import com.avito.android.advert.item.note.AdvertDetailsNoteBlueprint;
import com.avito.android.advert.item.note.di.AdvertDetailsNotesModule;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryBlueprint;
import com.avito.android.advert.item.photogallery.di.AdvertDetailsPhotoGalleryModule;
import com.avito.android.advert.item.price.AdvertDetailsPriceBlueprint;
import com.avito.android.advert.item.price.di.AdvertDetailsPriceModule;
import com.avito.android.advert.item.price_discount.PriceWithDiscountBlueprint;
import com.avito.android.advert.item.price_discount.di.AdvertDetailsPriceWithDiscountModule;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceBlueprint;
import com.avito.android.advert.item.price_marketplace.di.AdvertDetailsPriceMarketplaceModule;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionBlueprint;
import com.avito.android.advert.item.price_subscription.di.AdvertDetailsPriceSubscriptionModule;
import com.avito.android.advert.item.questionnaire.di.QuestionnaireModule;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishBlueprint;
import com.avito.android.advert.item.rating_publish.di.AdvertDetailsRatingPublishModule;
import com.avito.android.advert.item.safe_show.SafeShowItemBlueprint;
import com.avito.android.advert.item.safe_show.SafeShowItemPresenter;
import com.avito.android.advert.item.safe_show.SafeShowItemPresenterImpl;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl;
import com.avito.android.advert.item.safedeal.di.AdvertDetailsSafeDealModule;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfileBlueprint;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenterImpl;
import com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenterImpl;
import com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractor;
import com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractorImpl;
import com.avito.android.advert.item.sellerprofile.SellerStatusProvider;
import com.avito.android.advert.item.sellerprofile.SellerStatusProviderImpl;
import com.avito.android.advert.item.sellerprofile.di.AdvertDetailsSellerProfileModule;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionBlueprint;
import com.avito.android.advert.item.sellersubscription.di.AdvertDetailsSellerSubscriptionModule;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentBlueprint;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView;
import com.avito.android.advert.item.shorttermrent.di.AdvertDetailsShortTermRentModule;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionBlueprint;
import com.avito.android.advert.item.show_description_button.ShowDescriptionClickListener;
import com.avito.android.advert.item.show_description_button.di.AdvertDetailsShowDescriptionModule;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapBlueprint;
import com.avito.android.advert.item.show_on_map.di.AdvertDetailsShowOnMapModule;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenterImpl;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProviderImpl;
import com.avito.android.advert.item.similars.SimilarsLoaderItemBlueprint;
import com.avito.android.advert.item.similars.di.AdvertDetailsSimilarsModule;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonBlueprint;
import com.avito.android.advert.item.similars_button.SimilarsButtonClickListener;
import com.avito.android.advert.item.similars_button.di.AdvertDetailsSimilarsButtonModule;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonBlueprint;
import com.avito.android.advert.item.skeleton.AdvertDetailsTitleSkeletonBlueprint;
import com.avito.android.advert.item.skeleton.di.AdvertDetailsSkeletonModule;
import com.avito.android.advert.item.spare_parts.SparePartsCompatibilitiesBlueprint;
import com.avito.android.advert.item.spare_parts.SparePartsReplacementsBlueprint;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonBlueprint;
import com.avito.android.advert.item.status_badge.di.AdvertDetailsClosingReasonModule;
import com.avito.android.advert.item.title.AdvertDetailsTitleBlueprint;
import com.avito.android.advert.item.title.di.AdvertDetailsTitleModule;
import com.avito.android.advert.item.verification.AdvertVerificationPresenter;
import com.avito.android.advert.item.verification.di.AdvertVerificationModule;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert.tracker.AdvertDetailsTrackerImpl;
import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import com.avito.android.advert_core.advert.AdvertDetailsGroupsListener;
import com.avito.android.advert_core.advert.CartInteractor;
import com.avito.android.advert_core.advert.CartInteractorImpl;
import com.avito.android.advert_core.aler_banner.AlertBannerBlueprint;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenter;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenterImpl;
import com.avito.android.advert_core.analytics.AdvertAnalyticsModule;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger;
import com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider;
import com.avito.android.advert_core.analytics.broker.SravniEventTracker;
import com.avito.android.advert_core.analytics.broker.SravniEventTrackerImpl;
import com.avito.android.advert_core.car_market_price.price_chart.di.CarMarketPriceChartModule;
import com.avito.android.advert_core.car_market_price.price_description.di.CarMarketPriceDescriptionModule;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactoryImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProvider;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl;
import com.avito.android.advert_core.contactbar.SourceScreen;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractorImpl;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.advert_core.gap.di.AdvertDetailsGapModule;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenterImpl;
import com.avito.android.advert_core.marketplace.MarketplaceResourceProvider;
import com.avito.android.advert_core.marketplace.MarketplaceResourceProviderImpl;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule;
import com.avito.android.advert_core.sellerprofile.SellerProfileClickSource;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractorImpl;
import com.avito.android.brandspace_entry_point.di.BrandspaceEntryPointInteractorModule;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdsItemModule;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.DfpDebugModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.AdvertDetailsRecommendationItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.di.AdvertDetailsRecommendationItemModule;
import com.avito.android.home.HomeAdapterListener;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.module.serp.adapter.ad.adfox.RdsAdfoxBigBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpContentBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpUnifiedBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetContentBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.RdsYandexAppInstallBigBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.RdsYandexContentBigBlueprint;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.section.complementary.ComplementarySectionBlueprint;
import com.avito.android.section.complementary.ComplementaryTitleWithActionBlueprint;
import com.avito.android.section.di.SectionAdvertItemsModule;
import com.avito.android.section.di.SectionModule;
import com.avito.android.section.expand_sections_button.ComplementaryExpandSectionsButtonBlueprint;
import com.avito.android.section.expand_sections_button.ExpandComplementarySectionsListener;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.RdsAdResourceProviderImpl;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverterImpl;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SimpleAdvertSpanCountProvider;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.adstub.RdsEmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.RdsNotLoadAdStubBlueprint;
import com.avito.android.ui_components.R;
import com.avito.android.util.AdvertOldPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.di.ClipboardModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0012ú\u0001û\u0001ü\u0001ý\u0001þ\u0001ÿ\u0001\u0002\u0002\u0002B\u000b\b\u0002¢\u0006\u0006\bø\u0001\u0010ù\u0001J+\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0011\u001a\u00020\u000e2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0005\u0010µ\u0001\u001a\u00030²\u00012\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020r2\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020v2\u0006\u0010y\u001a\u00020x2\u0006\u0010{\u001a\u00020z2\u0006\u0010}\u001a\u00020|2\u0006\u0010\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u001f\b\u0001\u0010\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001¢\u0006\u0003\b\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010¡\u0001\u001a\u00030 \u00012\b\u0010£\u0001\u001a\u00030¢\u00012\b\u0010¥\u0001\u001a\u00030¤\u00012\b\u0010§\u0001\u001a\u00030¦\u00012\b\u0010©\u0001\u001a\u00030¨\u00012\b\u0010«\u0001\u001a\u00030ª\u00012\b\u0010­\u0001\u001a\u00030¬\u00012\b\u0010¯\u0001\u001a\u00030®\u00012\b\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001d\u0010º\u0001\u001a\u00030·\u00012\b\u0010¶\u0001\u001a\u00030²\u0001H\u0001¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u001d\u0010¾\u0001\u001a\u00030»\u00012\b\u0010¶\u0001\u001a\u00030²\u0001H\u0001¢\u0006\u0006\b¼\u0001\u0010½\u0001J'\u0010Ã\u0001\u001a\u00030À\u00012\b\u0010¿\u0001\u001a\u00030»\u00012\b\u0010¶\u0001\u001a\u00030²\u0001H\u0001¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J;\u0010Ì\u0001\u001a\u00030É\u00012\b\u0010¿\u0001\u001a\u00030»\u00012\b\u0010Ä\u0001\u001a\u00030·\u00012\b\u0010Æ\u0001\u001a\u00030Å\u00012\b\u0010È\u0001\u001a\u00030Ç\u0001H\u0001¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001d\u0010Ò\u0001\u001a\u00030Ï\u00012\b\u0010Î\u0001\u001a\u00030Í\u0001H\u0001¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001d\u0010Ø\u0001\u001a\u00030Õ\u00012\b\u0010Ô\u0001\u001a\u00030Ó\u0001H\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u001d\u0010Þ\u0001\u001a\u00030Û\u00012\b\u0010Ú\u0001\u001a\u00030Ù\u0001H\u0001¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u001d\u0010ä\u0001\u001a\u00030á\u00012\b\u0010à\u0001\u001a\u00030ß\u0001H\u0001¢\u0006\u0006\bâ\u0001\u0010ã\u0001J'\u0010è\u0001\u001a\u00030ß\u00012\b\u0010å\u0001\u001a\u00030Û\u00012\b\u0010Ú\u0001\u001a\u00030Ù\u0001H\u0001¢\u0006\u0006\bæ\u0001\u0010ç\u0001J1\u0010í\u0001\u001a\u00030ì\u00012\b\u0010Ú\u0001\u001a\u00030Ù\u00012\b\u0010ê\u0001\u001a\u00030é\u00012\b\u0010à\u0001\u001a\u00030ë\u0001H\u0007¢\u0006\u0006\bí\u0001\u0010î\u0001J\u001c\u0010ó\u0001\u001a\u00030ð\u00012\u0007\u0010ï\u0001\u001a\u00020\u001aH\u0001¢\u0006\u0006\bñ\u0001\u0010ò\u0001J\u001d\u0010÷\u0001\u001a\u00030ô\u00012\b\u0010Ú\u0001\u001a\u00030Ù\u0001H\u0001¢\u0006\u0006\bõ\u0001\u0010ö\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule;", "", "Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "bannerViewFilter", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditBannerFilter;", "creditBannerFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$advert_details_release", "(Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;Lcom/avito/android/advert/item/dfpcreditinfo/CreditBannerFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "", "searchContext", "Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper$advert_details_release", "(Ljava/lang/String;)Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper", "Lcom/avito/android/advert_core/contactbar/SourceScreen;", "provideSourceScreen$advert_details_release", "()Lcom/avito/android/advert_core/contactbar/SourceScreen;", "provideSourceScreen", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "profilePresenter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "advertContactsPresenter", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "provideAdvertSellerPresenter$advert_details_release", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "provideAdvertSellerPresenter", "Lcom/avito/android/section/complementary/ComplementarySectionBlueprint;", "complementarySectionBlueprint", "Lcom/avito/android/section/complementary/ComplementaryTitleWithActionBlueprint;", "complementaryTitleWithActionBlueprint", "Lcom/avito/android/section/expand_sections_button/ComplementaryExpandSectionsButtonBlueprint;", "complementaryExpandSectionBlueprint", "Lcom/avito/android/serp/adapter/adstub/RdsNotLoadAdStubBlueprint;", "notLoadAdStubBlueprint", "Lcom/avito/android/serp/adapter/adstub/RdsEmptyAdStubItemBlueprint;", "rdsEmptyAdStubItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/RdsYandexContentBigBlueprint;", "yandexContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/RdsYandexAppInstallBigBlueprint;", "yandexAppInstallBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/RdsAdfoxBigBlueprint;", "adfoxContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpUnifiedBlueprint;", "dfpUnifiedBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpContentBlueprint;", "dfpContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpAppInstallBlueprint;", "dfpAppInstallBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/RdsMyTargetContentBlueprint;", "myTargetContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/RdsMyTargetAppInstallBlueprint;", "myTargetAppInstallBlueprint", "Lcom/avito/android/advert/item/title/AdvertDetailsTitleBlueprint;", "advertDetailsTitleBlueprint", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryBlueprint;", "advertDetailsGalleryBlueprint", "Lcom/avito/android/advert/item/price/AdvertDetailsPriceBlueprint;", "advertDetailsPriceBlueprint", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountBlueprint;", "priceWithDiscountBlueprint", "Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceBlueprint;", "advertDetailsPriceMarketplaceBlueprint", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionBlueprint;", "advertDetailsPriceSubscriptionBlueprint", "Lcom/avito/android/advert/item/similars/SimilarsLoaderItemBlueprint;", "similarsLoaderBlueprint", "Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;", "rdsAdvertGridItemBlueprint", "Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerBlueprint;", "advertDetailsDisclaimerBlueprint", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionBlueprint;", "advertDetailsDescriptionBlueprint", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressBlueprint;", "advertDetailsAddressBlueprint", "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsBlueprint;", "advertDetailsGroupsBlueprint", "Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsBlueprint;", "advertDetailsFlatsBlueprint", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaBlueprint;", "advertDetailsAutotekaBlueprint", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserBlueprint;", "advertDetailsAutotekaTeaserBlueprint", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealBlueprint;", "advertDetailsAutodealBlueprint", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteBlueprint;", "advertDetailsNoteBlueprint", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogBlueprint;", "advertDetailsAutoCatalogBlueprint", "Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileBlueprint;", "advertDetailsSellerProfileBlueprint", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionBlueprint;", "advertDetailsSellerSubscriptionBlueprint", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerBlueprint;", "advertDetailsAdditionalSellerBlueprint", "Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberBlueprint;", "advertDetailsAnonymousNumberBlueprint", "Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberBlueprint;", "advertDetailsAdvertNumberBlueprint", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseBlueprint;", "advertDetailsAbuseBlueprint", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsBlueprint;", "advertDetailsDeliveryActionsBlueprint", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoBlueprint;", "advertDetailsDeliveryInfoBlueprint", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationBlueprint;", "advertDetailsConsultationBlueprint", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentBlueprint;", "advertDetailsShortTermRentRentBlueprint", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarBlueprint;", "advertDetailsContactBarBlueprint", "Lcom/avito/android/advert_core/gap/AdvertDetailsGapBlueprint;", "advertDetailsGapBlueprint", "Lcom/avito/android/advert/item/divider/AdvertDetailsDividerBlueprint;", "advertDetailsDividerBlueprint", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceBlueprint;", "advertDetailsGeoReferenceBlueprint", "Lcom/avito/android/advert/item/skeleton/AdvertDetailsSkeletonBlueprint;", "advertDetailsSkeletonBlueprint", "Lcom/avito/android/advert/item/skeleton/AdvertDetailsTitleSkeletonBlueprint;", "advertDetailsTitleSkeletonBlueprint", "Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonBlueprint;", "advertDetailsSimilarsButtonBlueprint", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonBlueprint;", "advertDetailsStatusBadgeBlueprint", "Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionBlueprint;", "advertDetailsShowDescriptionBlueprint", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapBlueprint;", "advertDetailsShowOnMapBlueprint", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishBlueprint;", "advertDetailsRatingPublishBlueprint", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/AdvertDetailsRecommendationItemBlueprint;", "advertDetailsRecommendedSellers", "Lcom/avito/android/advert/item/safe_show/SafeShowItemBlueprint;", "advertDetailsSafeShowBlueprint", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersBlueprint;", "advertDetailsIceBreakersBlueprint", "Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserBlueprint;", "advertDetailsFeatureTeaser", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsBlueprint;", "marketplaceSpecsBlueprint", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsBlueprint;", "marketplaceBriefSpecsBlueprint", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoBlueprint;", "marketplaceInfoBlueprint", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryBlueprint;", "marketplaceDeliveryBlueprint", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqBlueprint;", "marketplaceFaqBlueprint", "Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarBlueprint;", "marketplaceBadgeBarBlueprint", "Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityBlueprint;", "marketplaceQuantityBlueprint", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarBlueprint;", "marketplaceContactBarBlueprint", "Lcom/avito/android/advert_core/aler_banner/AlertBannerBlueprint;", "alertBannerItem", "Lcom/avito/android/advert/item/spare_parts/SparePartsReplacementsBlueprint;", "replacementsBlueprint", "Lcom/avito/android/advert/item/spare_parts/SparePartsCompatibilitiesBlueprint;", "compatibilitiesBlueprint", "Lcom/avito/android/advert/item/booking/AdvertBookingBlueprint;", "bookingBlueprint", "Lcom/avito/android/advert/item/car_market_price/price_description/CarMarketPriceDescriptionBlueprint;", "carMarketPriceDescriptionBlueprint", "Lcom/avito/android/advert/item/car_market_price/price_chart/CarMarketPriceChartBlueprint;", "carMarketPriceChartBlueprint", "Lcom/avito/android/advert/item/header/AdvertDetailsHeaderBlueprint;", "advertDetailsHeaderBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$advert_details_release", "(Lcom/avito/android/section/complementary/ComplementarySectionBlueprint;Lcom/avito/android/section/complementary/ComplementaryTitleWithActionBlueprint;Lcom/avito/android/section/expand_sections_button/ComplementaryExpandSectionsButtonBlueprint;Lcom/avito/android/serp/adapter/adstub/RdsNotLoadAdStubBlueprint;Lcom/avito/android/serp/adapter/adstub/RdsEmptyAdStubItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/RdsYandexContentBigBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/RdsYandexAppInstallBigBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/RdsAdfoxBigBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpUnifiedBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpContentBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/RdsDfpAppInstallBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/RdsMyTargetContentBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/RdsMyTargetAppInstallBlueprint;Lcom/avito/android/advert/item/title/AdvertDetailsTitleBlueprint;Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryBlueprint;Lcom/avito/android/advert/item/price/AdvertDetailsPriceBlueprint;Lcom/avito/android/advert/item/price_discount/PriceWithDiscountBlueprint;Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceBlueprint;Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionBlueprint;Lcom/avito/android/advert/item/similars/SimilarsLoaderItemBlueprint;Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerBlueprint;Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionBlueprint;Lcom/avito/android/advert/item/address/AdvertDetailsAddressBlueprint;Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsBlueprint;Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsBlueprint;Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaBlueprint;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserBlueprint;Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealBlueprint;Lcom/avito/android/advert/item/note/AdvertDetailsNoteBlueprint;Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogBlueprint;Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileBlueprint;Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionBlueprint;Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerBlueprint;Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberBlueprint;Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberBlueprint;Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseBlueprint;Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsBlueprint;Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoBlueprint;Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationBlueprint;Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentBlueprint;Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarBlueprint;Lcom/avito/android/advert_core/gap/AdvertDetailsGapBlueprint;Lcom/avito/android/advert/item/divider/AdvertDetailsDividerBlueprint;Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceBlueprint;Lcom/avito/android/advert/item/skeleton/AdvertDetailsSkeletonBlueprint;Lcom/avito/android/advert/item/skeleton/AdvertDetailsTitleSkeletonBlueprint;Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonBlueprint;Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonBlueprint;Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionBlueprint;Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapBlueprint;Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishBlueprint;Ljava/util/Set;Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/AdvertDetailsRecommendationItemBlueprint;Lcom/avito/android/advert/item/safe_show/SafeShowItemBlueprint;Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersBlueprint;Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserBlueprint;Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsBlueprint;Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsBlueprint;Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoBlueprint;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryBlueprint;Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqBlueprint;Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarBlueprint;Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityBlueprint;Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarBlueprint;Lcom/avito/android/advert_core/aler_banner/AlertBannerBlueprint;Lcom/avito/android/advert/item/spare_parts/SparePartsReplacementsBlueprint;Lcom/avito/android/advert/item/spare_parts/SparePartsCompatibilitiesBlueprint;Lcom/avito/android/advert/item/booking/AdvertBookingBlueprint;Lcom/avito/android/advert/item/car_market_price/price_description/CarMarketPriceDescriptionBlueprint;Lcom/avito/android/advert/item/car_market_price/price_chart/CarMarketPriceChartBlueprint;Lcom/avito/android/advert/item/header/AdvertDetailsHeaderBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$advert_details_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$advert_details_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "presenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter$advert_details_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "destroyableViewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter$advert_details_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "provideAdvertActionIconFactory$advert_details_release", "(Landroid/app/Application;)Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "provideAdvertActionIconFactory", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "fragmentDelegate", "Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper$advert_details_release", "(Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;)Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider$advert_details_release", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$advert_details_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "gridPositionProvider", "provideSpanProvider$advert_details_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", "Lcom/avito/android/serp/ad/AdResourceProvider;", "adResourceProvider", "Lcom/avito/android/util/RandomKeyProvider;", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "provideCommercialConverter", "(Landroid/content/res/Resources;Lcom/avito/android/serp/ad/AdResourceProvider;Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "advertDetailsAnalyticsInteractor", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent$advert_details_release", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent", "", "provideIsTablet$advert_details_release", "(Landroid/content/res/Resources;)Z", "provideIsTablet", "<init>", "()V", "AdvertBlueprints", "AdvertDetailsItemVisibilityTrackerState", "AdvertSerpCommercialBannerConverter", "CurrentPrice", "Declarations", "IsTablet", "OldPrice", "SearchContext", "ToolbarPresenterSavedState", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdditionalSellerModule.class, AdsItemModule.class, AdvertAnalyticsModule.class, AdvertDeliveryBlockModule.class, AdvertDetailsAbuseModule.class, AdvertDetailsAddressModule.class, AdvertDetailsAdvertNumberModule.class, AdvertDetailsBadgeBarItemModule.class, AdvertDetailsAnonymousNumberModule.class, AdvertDetailsAutoCatalogModule.class, AdvertDetailsAutoDealModule.class, AdvertDetailsAutotekaModule.class, AdvertDetailsAutotekaTeaserModule.class, AdvertDetailsClosingReasonModule.class, AdvertDetailsConsultationModule.class, AdvertDetailsContactBarModule.class, AdvertDetailsCreditInfoModule.class, AdvertDetailsDeliveryModule.class, AdvertDetailsDescriptionModule.class, AdvertDetailsDisclaimerModule.class, AdvertDetailsDividerModule.class, AdvertDetailsDomotekaTeaserModule.class, AdvertDetailsFeatureTeaserModule.class, AdvertDetailsFlatsModule.class, AdvertDetailsGapModule.class, AdvertDetailsGeoReferenceModule.class, AdvertDetailsGroupsModule.class, AdvertDetailsGuideModule.class, AdvertDetailsIceBreakersModule.class, AdvertDetailsImvBadgeItemModule.class, AdvertDetailsNotesModule.class, AdvertDetailsPhotoGalleryModule.class, AdvertDetailsPriceModule.class, AdvertDetailsPriceSubscriptionModule.class, AdvertDetailsPriceWithDiscountModule.class, AdvertDetailsPriceMarketplaceModule.class, AdvertDetailsRatingPublishModule.class, AdvertDetailsRecommendationItemModule.class, AdvertDetailsSafeDealModule.class, AdvertDetailsSellerProfileModule.class, AdvertDetailsSellerSubscriptionModule.class, AdvertDetailsShortTermRentModule.class, AdvertDetailsShowDescriptionModule.class, AdvertDetailsShowOnMapModule.class, AdvertDetailsSimilarsButtonModule.class, AdvertDetailsSimilarsModule.class, AdvertDetailsSkeletonModule.class, AdvertDetailsTitleModule.class, Declarations.class, AdvertItemModule.class, AdvertVerificationModule.class, AttributedTextFormatterModule.class, CarouselPhotoGalleryModule.class, ClipboardModule.class, CommercialBannersInteractorModule.class, DateTimeFormatterModule.class, DfpDebugModule.class, DialogRouterModule.class, FavoriteAdvertsPresenterModule.class, MarketplaceBriefSpecsModule.class, MarketplaceDeliveryModule.class, MarketplaceFaqModule.class, MarketplaceInfoModule.class, MarketplaceSpecsModule.class, MarketplaceBadgeBarModule.class, MarketplaceQuantityModule.class, MarketplaceContactBarModule.class, MyAdvertSafeDealServicesModule.class, PhoneNumberFormatterModule.class, SectionAdvertItemsModule.class, SectionModule.class, SerpItemConverterModule.class, SparePartsModule.class, AdvertBookingModule.class, QuestionnaireModule.class, CarMarketPriceDescriptionModule.class, CarMarketPriceChartModule.class, PromoCardModule.class, AdvertDetailsGeoReportTeaserModule.class, CartFabModule.class, BrandspaceEntryPointInteractorModule.class, AdvertDetailsHeaderModule.class})
public final class AdvertFragmentModule {
    @NotNull
    public static final AdvertFragmentModule INSTANCE = new AdvertFragmentModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$AdvertBlueprints;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface AdvertBlueprints {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$AdvertDetailsItemVisibilityTrackerState;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertDetailsItemVisibilityTrackerState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$AdvertSerpCommercialBannerConverter;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertSerpCommercialBannerConverter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$CurrentPrice;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface CurrentPrice {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000î\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H'¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u0002032\u0006\u0010.\u001a\u000202H'¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u0002062\u0006\u0010.\u001a\u000202H'¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020:2\u0006\u0010.\u001a\u000209H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020>2\u0006\u0010.\u001a\u00020=H'¢\u0006\u0004\b?\u0010@J\u0017\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020AH'¢\u0006\u0004\bD\u0010EJ\u0017\u0010I\u001a\u00020H2\u0006\u0010G\u001a\u00020FH'¢\u0006\u0004\bI\u0010JJ\u0017\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020KH'¢\u0006\u0004\bN\u0010OJ\u0017\u0010S\u001a\u00020R2\u0006\u0010Q\u001a\u00020PH'¢\u0006\u0004\bS\u0010TJ\u0017\u0010X\u001a\u00020W2\u0006\u0010V\u001a\u00020UH'¢\u0006\u0004\bX\u0010YJ\u0017\u0010]\u001a\u00020\\2\u0006\u0010[\u001a\u00020ZH'¢\u0006\u0004\b]\u0010^J\u0017\u0010b\u001a\u00020a2\u0006\u0010`\u001a\u00020_H'¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020e2\u0006\u0010`\u001a\u00020dH'¢\u0006\u0004\bf\u0010gJ\u0017\u0010k\u001a\u00020j2\u0006\u0010i\u001a\u00020hH'¢\u0006\u0004\bk\u0010lJ\u0017\u0010p\u001a\u00020o2\u0006\u0010n\u001a\u00020mH'¢\u0006\u0004\bp\u0010qJ\u0017\u0010u\u001a\u00020t2\u0006\u0010s\u001a\u00020rH'¢\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001a\u00020x2\u0006\u0010i\u001a\u00020wH'¢\u0006\u0004\by\u0010zJ\u0017\u0010~\u001a\u00020}2\u0006\u0010|\u001a\u00020{H'¢\u0006\u0004\b~\u0010J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b\u0001\u0010 \u0001J\u001d\u0010¤\u0001\u001a\u00030£\u00012\b\u0010¢\u0001\u001a\u00030¡\u0001H'¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001d\u0010©\u0001\u001a\u00030¨\u00012\b\u0010§\u0001\u001a\u00030¦\u0001H'¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001c\u0010¬\u0001\u001a\u00030«\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b¬\u0001\u0010­\u0001J\u001c\u0010¯\u0001\u001a\u00030®\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001c\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001c\u0010µ\u0001\u001a\u00030´\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001c\u0010¸\u0001\u001a\u00030·\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u001c\u0010»\u0001\u001a\u00030º\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u001c\u0010¾\u0001\u001a\u00030½\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001c\u0010Á\u0001\u001a\u00030À\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u001c\u0010Ä\u0001\u001a\u00030Ã\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001c\u0010Ç\u0001\u001a\u00030Æ\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u001c\u0010Ê\u0001\u001a\u00030É\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001c\u0010Í\u0001\u001a\u00030Ì\u00012\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u001c\u0010Ñ\u0001\u001a\u00030Ð\u00012\u0007\u0010.\u001a\u00030Ï\u0001H'¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u001c\u0010Õ\u0001\u001a\u00030Ô\u00012\u0007\u0010`\u001a\u00030Ó\u0001H'¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u001f\u0010×\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010`\u001a\u00020\u0002H'¢\u0006\u0005\b×\u0001\u0010\u0007J+\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Û\u00012\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Ø\u0001H'¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J+\u0010ß\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Þ\u00012\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Ø\u0001H'¢\u0006\u0006\bß\u0001\u0010à\u0001J\u001d\u0010ã\u0001\u001a\u00030â\u00012\b\u0010\u0001\u001a\u00030á\u0001H'¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u001d\u0010è\u0001\u001a\u00030ç\u00012\b\u0010æ\u0001\u001a\u00030å\u0001H'¢\u0006\u0006\bè\u0001\u0010é\u0001J\u001c\u0010ì\u0001\u001a\u00030ë\u00012\u0007\u0010.\u001a\u00030ê\u0001H'¢\u0006\u0006\bì\u0001\u0010í\u0001J\u001c\u0010ð\u0001\u001a\u00030ï\u00012\u0007\u0010)\u001a\u00030î\u0001H'¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u001b\u0010ó\u0001\u001a\u00030ò\u00012\u0006\u0010.\u001a\u000203H'¢\u0006\u0006\bó\u0001\u0010ô\u0001J\u001b\u0010ö\u0001\u001a\u00030õ\u00012\u0006\u0010V\u001a\u00020WH'¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u001c\u0010ú\u0001\u001a\u00030ù\u00012\u0007\u0010.\u001a\u00030ø\u0001H'¢\u0006\u0006\bú\u0001\u0010û\u0001J\u001d\u0010þ\u0001\u001a\u00030ý\u00012\b\u0010§\u0001\u001a\u00030ü\u0001H'¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001J\u001d\u0010\u0002\u001a\u00030\u00022\b\u0010\u0001\u001a\u00030\u0002H'¢\u0006\u0006\b\u0002\u0010\u0002J\u001c\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0001\u001a\u00020\u0011H'¢\u0006\u0006\b\u0002\u0010\u0002J\u001c\u0010\u0002\u001a\u00030\u00022\u0007\u0010.\u001a\u00030\u0002H'¢\u0006\u0006\b\u0002\u0010\u0002¨\u0006\u0002"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$Declarations;", "", "Lcom/avito/android/util/AdvertPriceFormatter;", "formatter", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "bindAdvertPriceFormatter", "(Lcom/avito/android/util/AdvertPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/util/AdvertOldPriceFormatter;", "bindAdvertOldPriceFormatter", "(Lcom/avito/android/util/AdvertOldPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/advert/item/AdvertDetailsPresenterImpl;", "advertDetailsPresenter", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "bindsAdvertDetailsPresenter", "(Lcom/avito/android/advert/item/AdvertDetailsPresenterImpl;)Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "Lcom/avito/android/advert/AdvertDetailsInteractorImpl;", "advertDetailsInteractor", "Lcom/avito/android/advert/AdvertDetailsInteractor;", "bindsAdvertDetailsInteractor", "(Lcom/avito/android/advert/AdvertDetailsInteractorImpl;)Lcom/avito/android/advert/AdvertDetailsInteractor;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenterImpl;", "advertDeliveryPresenter", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "bindsAdvertDeliveryPresenter", "(Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenterImpl;)Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenterImpl;", "advertSafeDealPresenter", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "bindsAdvertSafeDealPresenter", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenterImpl;)Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoaderImpl;", "loader", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "bindsDfpCreditLoader", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoaderImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "Lcom/avito/android/advert/tracker/AdvertDetailsTrackerImpl;", "tracker", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "bindAdvertDetailsTracker", "(Lcom/avito/android/advert/tracker/AdvertDetailsTrackerImpl;)Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "bindAdvertDetailsAnalyticsInteractor", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractorImpl;)Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "bindBrokerAnalyticsInteractor", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;)Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "bindBrokerSessionProvider", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;)Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractorImpl;", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "bindAutotekaTeaserInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractorImpl;)Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractorImpl;", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "bindAutotekaDetailsInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractorImpl;)Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProviderImpl;", "similarResourceProvider", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "bindAdvertSimilarPresenterResourceProvider", "(Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProviderImpl;)Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "Lcom/avito/android/advert/AdvertDetailsResourcesProviderImpl;", "resourceProvider", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "bindAdvertDetailsResourcesProvider", "(Lcom/avito/android/advert/AdvertDetailsResourcesProviderImpl;)Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenterImpl;", "advertSellerProfilePresenter", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "bindAdvertSellerProfilePresenter", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenterImpl;)Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenterImpl;", "advertDetailsToolbarPresenter", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "bindAdvertDetailsToolbarPresenter", "(Lcom/avito/android/advert/AdvertDetailsToolbarPresenterImpl;)Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenterImpl;", "advertDetailsItemsPresenter", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "bindAdvertDetailsItemsPresenter", "(Lcom/avito/android/advert/item/AdvertDetailsItemsPresenterImpl;)Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "Lcom/avito/android/IdProviderImpl;", "IdProvider", "Lcom/avito/android/IdProvider;", "bindIdProvider", "(Lcom/avito/android/IdProviderImpl;)Lcom/avito/android/IdProvider;", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferencesImpl;", "impl", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "bindAntiFraudPreferences", "(Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferencesImpl;)Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "Lcom/avito/android/advert_core/feedback/FeedbackPreferencesImpl;", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "bindFeedbackPreferences", "(Lcom/avito/android/advert_core/feedback/FeedbackPreferencesImpl;)Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenterImpl;", "advertContactsPresenter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "bindContactsPresenter", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenterImpl;)Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProviderImpl;", "contactsResourceProvider", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "bindContactsResourceProvider", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProviderImpl;)Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractorImpl;", "advertContactsInteractor", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "bindAdvertContactsInteractor", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractorImpl;)Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenterImpl;", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "bindAdvertComplementaryPresenter", "(Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenterImpl;)Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractorImpl;", "advertMessengerInteractor", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "bindAdvertMessengerInteractor", "(Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractorImpl;)Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractorImpl;", "advertDetailsFavoriteInteractor", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "bindAdvertDetailsFavoriteInteractor", "(Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractorImpl;)Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "Lcom/avito/android/advert/item/sellerprofile/SellerStatusProviderImpl;", "sellerStatusProvider", "Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "bindSellerStatusProvider", "(Lcom/avito/android/advert/item/sellerprofile/SellerStatusProviderImpl;)Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractorImpl;", "advertSellerStatusInteractor", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;", "bindAdvertSellerStatusInteractor", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractorImpl;)Lcom/avito/android/advert/item/sellerprofile/AdvertSellerStatusInteractor;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactoryImpl;", "dfpCreditViewModelFactory", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "bindDfpCreditViewModelFactory", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactoryImpl;)Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "presenter", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "bindAdvertDetailsShortTermRentViewListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "Lcom/avito/android/home/HomeAdapterListener;", "bindHomeAdapterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/home/HomeAdapterListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "bindAdBannerEventListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverterImpl;", "converter", "Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "bindAdvertCommercialsConverter", "(Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverterImpl;)Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "Lcom/avito/android/serp/ad/RdsAdResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/RdsAdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/avito/android/advert/item/similars_button/SimilarsButtonClickListener;", "bindAdvertSimilarsButtonListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/similars_button/SimilarsButtonClickListener;", "Lcom/avito/android/advert/item/show_description_button/ShowDescriptionClickListener;", "bindAdvertClosedShowDescriptionListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/show_description_button/ShowDescriptionClickListener;", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", "bindAdvertDetailsGroupsListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "bindAdvertDetailsFlatsListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "bindAdvertDetailsAdditionalSellerListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", "bindMarketplaceSpecsPresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoPresenter$Listener;", "bindMarketplaceInfoPresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", "bindMarketplaceDeliveryPresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqPresenter$Listener;", "bindMarketplaceFaqPresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqPresenter$Listener;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;", "bindAdvertDetailsAbusePresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;", "Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;", "bindOnHelpCenterClickedListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;", "bindCreditBrokerLinkListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractorImpl;", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "bindDomotekaTeaserInteractor", "(Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractorImpl;)Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "Lcom/avito/android/advert/item/safe_show/SafeShowItemPresenterImpl;", "Lcom/avito/android/advert/item/safe_show/SafeShowItemPresenter;", "bindSafeShowPresenter", "(Lcom/avito/android/advert/item/safe_show/SafeShowItemPresenterImpl;)Lcom/avito/android/advert/item/safe_show/SafeShowItemPresenter;", "bindPriceFormatter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/advert_core/aler_banner/AlertBannerPresenterImpl;", "Lcom/avito/android/advert_core/aler_banner/AlertBannerPresenter;", "bindAlertBannerPresenter", "(Lcom/avito/android/advert_core/aler_banner/AlertBannerPresenterImpl;)Lcom/avito/android/advert_core/aler_banner/AlertBannerPresenter;", "Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;", "handler", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "bindClickStreamLinkHandler", "(Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;)Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractorImpl;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "bindFeedbackInteractor", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractorImpl;)Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "Lcom/avito/android/advert_core/analytics/broker/SravniEventTrackerImpl;", "Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;", "bindSravniEventTracker", "(Lcom/avito/android/advert_core/analytics/broker/SravniEventTrackerImpl;)Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "bindCreditBrokerFlowTracker", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;)Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;", "bindExpandComplementarySectionsListener", "(Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;)Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;", "Lcom/avito/android/advert_core/advert/CartInteractorImpl;", "Lcom/avito/android/advert_core/advert/CartInteractor;", "bindCartInteractor", "(Lcom/avito/android/advert_core/advert/CartInteractorImpl;)Lcom/avito/android/advert_core/advert/CartInteractor;", "Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProviderImpl;", "Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProvider;", "bindMarketplaceResourceProvider", "(Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProviderImpl;)Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProvider;", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenterImpl;", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "bindMarketplacePresenter", "(Lcom/avito/android/advert_core/marketplace/MarketplacePresenterImpl;)Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarPresenter$Listener;", "bindMarketplaceContactBarPresenterListener", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarPresenter$Listener;", "Lcom/avito/android/advert_core/job/AdvertJobInteractorImpl;", "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "bindAdvertJobInteractor", "(Lcom/avito/android/advert_core/job/AdvertJobInteractorImpl;)Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdBannerEventListener bindAdBannerEventListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull RdsAdResourceProviderImpl rdsAdResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ShowDescriptionClickListener bindAdvertClosedShowDescriptionListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertCommercialsConverter bindAdvertCommercialsConverter(@NotNull AdvertCommercialsConverterImpl advertCommercialsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertComplementaryPresenter bindAdvertComplementaryPresenter(@NotNull AdvertComplementaryPresenterImpl advertComplementaryPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertContactsInteractor bindAdvertContactsInteractor(@NotNull AdvertContactsInteractorImpl advertContactsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsAbusePresenter.Listener bindAdvertDetailsAbusePresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdditionalSellerView.Listener bindAdvertDetailsAdditionalSellerListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsAnalyticsInteractor bindAdvertDetailsAnalyticsInteractor(@NotNull AdvertDetailsAnalyticsInteractorImpl advertDetailsAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsFavoriteInteractor bindAdvertDetailsFavoriteInteractor(@NotNull AdvertDetailsFavoriteInteractorImpl advertDetailsFavoriteInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsFlatsListener bindAdvertDetailsFlatsListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsGroupsListener bindAdvertDetailsGroupsListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsItemsPresenter bindAdvertDetailsItemsPresenter(@NotNull AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsResourcesProvider bindAdvertDetailsResourcesProvider(@NotNull AdvertDetailsResourcesProviderImpl advertDetailsResourcesProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsShortTermRentView.Listener bindAdvertDetailsShortTermRentViewListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsToolbarPresenter bindAdvertDetailsToolbarPresenter(@NotNull AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsTracker bindAdvertDetailsTracker(@NotNull AdvertDetailsTrackerImpl advertDetailsTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AdvertJobInteractor bindAdvertJobInteractor(@NotNull AdvertJobInteractorImpl advertJobInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertMessengerInteractor bindAdvertMessengerInteractor(@NotNull AdvertMessengerInteractorImpl advertMessengerInteractorImpl);

        @Binds
        @NotNull
        @OldPrice
        @PerFragment
        Formatter<AdvertPrice> bindAdvertOldPriceFormatter(@NotNull AdvertOldPriceFormatter advertOldPriceFormatter);

        @CurrentPrice
        @Binds
        @NotNull
        @PerFragment
        Formatter<AdvertPrice> bindAdvertPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);

        @PerFragment
        @Binds
        @NotNull
        AdvertSellerProfilePresenter bindAdvertSellerProfilePresenter(@NotNull AdvertSellerProfilePresenterImpl advertSellerProfilePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertSellerStatusInteractor bindAdvertSellerStatusInteractor(@NotNull AdvertSellerStatusInteractorImpl advertSellerStatusInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertSimilarPresenterResourceProvider bindAdvertSimilarPresenterResourceProvider(@NotNull AdvertSimilarPresenterResourceProviderImpl advertSimilarPresenterResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SimilarsButtonClickListener bindAdvertSimilarsButtonListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AlertBannerPresenter bindAlertBannerPresenter(@NotNull AlertBannerPresenterImpl alertBannerPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AntiFraudPreferences bindAntiFraudPreferences(@NotNull AntiFraudPreferencesImpl antiFraudPreferencesImpl);

        @PerFragment
        @Binds
        @NotNull
        AutotekaDetailsInteractor bindAutotekaDetailsInteractor(@NotNull AutotekaDetailsInteractorImpl autotekaDetailsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AutotekaTeaserInteractor bindAutotekaTeaserInteractor(@NotNull AutotekaTeaserInteractorImpl autotekaTeaserInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        CreditBrokerAnalyticsInteractor bindBrokerAnalyticsInteractor(@NotNull CreditBrokerAnalyticsInteractorImpl creditBrokerAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        CreditBrokerSessionProvider bindBrokerSessionProvider(@NotNull CreditBrokerAnalyticsInteractorImpl creditBrokerAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        CartInteractor bindCartInteractor(@NotNull CartInteractorImpl cartInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ClickStreamLinkHandler bindClickStreamLinkHandler(@NotNull SimpleClickStreamLinkHandler simpleClickStreamLinkHandler);

        @Binds
        @NotNull
        @PerFragment
        Consumer<FavoriteSellersItemAction> bindConsumer(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        AdvertContactsPresenter bindContactsPresenter(@NotNull AdvertContactsPresenterImpl advertContactsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertContactsResourceProvider bindContactsResourceProvider(@NotNull AdvertContactsResourceProviderImpl advertContactsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        CreditBrokerFlowEventLogger bindCreditBrokerFlowTracker(@NotNull CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor);

        @PerFragment
        @Binds
        @NotNull
        CreditBrokerLinkPresenter.Listener bindCreditBrokerLinkListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        DfpCreditViewModelFactory bindDfpCreditViewModelFactory(@NotNull DfpCreditViewModelFactoryImpl dfpCreditViewModelFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        DomotekaTeaserInteractor bindDomotekaTeaserInteractor(@NotNull DomotekaTeaserInteractorImpl domotekaTeaserInteractorImpl);

        @Binds
        @NotNull
        @PerFragment
        Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        ExpandComplementarySectionsListener bindExpandComplementarySectionsListener(@NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter);

        @PerFragment
        @Binds
        @NotNull
        FeedbackInteractor bindFeedbackInteractor(@NotNull FeedbackInteractorImpl feedbackInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FeedbackPreferences bindFeedbackPreferences(@NotNull FeedbackPreferencesImpl feedbackPreferencesImpl);

        @PerFragment
        @Binds
        @NotNull
        HomeAdapterListener bindHomeAdapterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        IdProvider bindIdProvider(@NotNull IdProviderImpl idProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceContactBarPresenter.Listener bindMarketplaceContactBarPresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceDeliveryPresenter.Listener bindMarketplaceDeliveryPresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceFaqPresenter.Listener bindMarketplaceFaqPresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceInfoPresenter.Listener bindMarketplaceInfoPresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @PerFragment
        @Binds
        @NotNull
        MarketplacePresenter bindMarketplacePresenter(@NotNull MarketplacePresenterImpl marketplacePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceResourceProvider bindMarketplaceResourceProvider(@NotNull MarketplaceResourceProviderImpl marketplaceResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketplaceSpecsPresenter.Listener bindMarketplaceSpecsPresenterListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @Binds
        @NotNull
        @PerFragment
        Observable<FavoriteSellersItemAction> bindObservable(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        AdvertVerificationPresenter.OnHelpCenterClickedListener bindOnHelpCenterClickedListener(@NotNull AdvertDetailsPresenter advertDetailsPresenter);

        @Binds
        @NotNull
        @PerFragment
        Formatter<AdvertPrice> bindPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);

        @PerFragment
        @Binds
        @NotNull
        SafeShowItemPresenter bindSafeShowPresenter(@NotNull SafeShowItemPresenterImpl safeShowItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerStatusProvider bindSellerStatusProvider(@NotNull SellerStatusProviderImpl sellerStatusProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SravniEventTracker bindSravniEventTracker(@NotNull SravniEventTrackerImpl sravniEventTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDeliveryPresenter bindsAdvertDeliveryPresenter(@NotNull AdvertDeliveryPresenterImpl advertDeliveryPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsInteractor bindsAdvertDetailsInteractor(@NotNull AdvertDetailsInteractorImpl advertDetailsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsPresenter bindsAdvertDetailsPresenter(@NotNull AdvertDetailsPresenterImpl advertDetailsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertSafeDealPresenter bindsAdvertSafeDealPresenter(@NotNull AdvertSafeDealPresenterImpl advertSafeDealPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        DfpCreditBannerLoader bindsDfpCreditLoader(@NotNull DfpCreditBannerLoaderImpl dfpCreditBannerLoaderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$IsTablet;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface IsTablet {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$OldPrice;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface OldPrice {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$SearchContext;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SearchContext {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentModule$ToolbarPresenterSavedState;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ToolbarPresenterSavedState {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemVisibilityTracker provideItemVisibilityTracker$advert_details_release(@NotNull BannerViewFilter bannerViewFilter, @NotNull CreditBannerFilter creditBannerFilter, @AdvertDetailsItemVisibilityTrackerState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bannerViewFilter, "bannerViewFilter");
        Intrinsics.checkNotNullParameter(creditBannerFilter, "creditBannerFilter");
        return new ItemVisibilityTrackerImpl.Builder(false, bundle).addFilter(bannerViewFilter).addFilter(creditBannerFilter).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$advert_details_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertActionIconFactory provideAdvertActionIconFactory$advert_details_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new AdvertActionIconFactoryImpl(application, false, 2, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertSellerPresenter provideAdvertSellerPresenter$advert_details_release(@NotNull AdvertSellerProfilePresenter advertSellerProfilePresenter, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertSellerProfilePresenter, "profilePresenter");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "advertContactsPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        return new AdvertSellerPresenterImpl(advertSellerProfilePresenter, advertContactsPresenter, CollectionsKt__CollectionsKt.listOf((Object[]) new SellerProfileClickSource[]{advertSellerProfilePresenter, advertContactsPresenter}), advertDetailsAnalyticsInteractor);
    }

    @Provides
    @AdvertSerpCommercialBannerConverter
    @NotNull
    @PerFragment
    public final SerpCommercialBannerConverter provideCommercialConverter(@NotNull Resources resources, @NotNull AdResourceProvider adResourceProvider, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(adResourceProvider, "adResourceProvider");
        Intrinsics.checkNotNullParameter(randomKeyProvider, GeoContract.PROVIDER);
        SimpleAdvertSpanCountProvider simpleAdvertSpanCountProvider = new SimpleAdvertSpanCountProvider(resources.getInteger(R.integer.serp_big_item_span_count));
        return new SerpCommercialBannerConverterImpl(simpleAdvertSpanCountProvider, simpleAdvertSpanCountProvider, adResourceProvider, randomKeyProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$advert_details_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpannedGridPositionProvider provideGridPositionProvider$advert_details_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new GridPositionProviderImpl(resources.getInteger(R.integer.similar_adverts_columns));
    }

    @IsTablet
    @Provides
    @PerFragment
    public final boolean provideIsTablet$advert_details_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getBoolean(R.bool.is_tablet);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder$advert_details_release(@NotNull ComplementarySectionBlueprint complementarySectionBlueprint, @NotNull ComplementaryTitleWithActionBlueprint complementaryTitleWithActionBlueprint, @NotNull ComplementaryExpandSectionsButtonBlueprint complementaryExpandSectionsButtonBlueprint, @NotNull RdsNotLoadAdStubBlueprint rdsNotLoadAdStubBlueprint, @NotNull RdsEmptyAdStubItemBlueprint rdsEmptyAdStubItemBlueprint, @NotNull RdsYandexContentBigBlueprint rdsYandexContentBigBlueprint, @NotNull RdsYandexAppInstallBigBlueprint rdsYandexAppInstallBigBlueprint, @NotNull RdsAdfoxBigBlueprint rdsAdfoxBigBlueprint, @NotNull RdsDfpUnifiedBlueprint rdsDfpUnifiedBlueprint, @NotNull RdsDfpContentBlueprint rdsDfpContentBlueprint, @NotNull RdsDfpAppInstallBlueprint rdsDfpAppInstallBlueprint, @NotNull RdsMyTargetContentBlueprint rdsMyTargetContentBlueprint, @NotNull RdsMyTargetAppInstallBlueprint rdsMyTargetAppInstallBlueprint, @NotNull AdvertDetailsTitleBlueprint advertDetailsTitleBlueprint, @NotNull AdvertDetailsGalleryBlueprint advertDetailsGalleryBlueprint, @NotNull AdvertDetailsPriceBlueprint advertDetailsPriceBlueprint, @NotNull PriceWithDiscountBlueprint priceWithDiscountBlueprint, @NotNull AdvertDetailsPriceMarketplaceBlueprint advertDetailsPriceMarketplaceBlueprint, @NotNull AdvertDetailsPriceSubscriptionBlueprint advertDetailsPriceSubscriptionBlueprint, @NotNull SimilarsLoaderItemBlueprint similarsLoaderItemBlueprint, @NotNull RdsAdvertGridItemBlueprint rdsAdvertGridItemBlueprint, @NotNull AdvertDetailsDisclaimerBlueprint advertDetailsDisclaimerBlueprint, @NotNull AdvertDetailsDescriptionBlueprint advertDetailsDescriptionBlueprint, @NotNull AdvertDetailsAddressBlueprint advertDetailsAddressBlueprint, @NotNull AdvertDetailsGroupsBlueprint advertDetailsGroupsBlueprint, @NotNull AdvertDetailsFlatsBlueprint advertDetailsFlatsBlueprint, @NotNull AdvertDetailsAutotekaBlueprint advertDetailsAutotekaBlueprint, @NotNull AdvertDetailsAutotekaTeaserBlueprint advertDetailsAutotekaTeaserBlueprint, @NotNull AdvertDetailsAutodealBlueprint advertDetailsAutodealBlueprint, @NotNull AdvertDetailsNoteBlueprint advertDetailsNoteBlueprint, @NotNull AdvertDetailsAutoCatalogBlueprint advertDetailsAutoCatalogBlueprint, @NotNull AdvertDetailsSellerProfileBlueprint advertDetailsSellerProfileBlueprint, @NotNull AdvertDetailsSellerSubscriptionBlueprint advertDetailsSellerSubscriptionBlueprint, @NotNull AdditionalSellerBlueprint additionalSellerBlueprint, @NotNull AdvertDetailsAnonymousNumberBlueprint advertDetailsAnonymousNumberBlueprint, @NotNull AdvertDetailsAdvertNumberBlueprint advertDetailsAdvertNumberBlueprint, @NotNull AdvertDetailsAbuseBlueprint advertDetailsAbuseBlueprint, @NotNull AdvertDetailsDeliveryActionsBlueprint advertDetailsDeliveryActionsBlueprint, @NotNull AdvertDetailsDeliveryInfoBlueprint advertDetailsDeliveryInfoBlueprint, @NotNull AdvertDetailsConsultationBlueprint advertDetailsConsultationBlueprint, @NotNull AdvertDetailsShortTermRentBlueprint advertDetailsShortTermRentBlueprint, @NotNull AdvertDetailsContactBarBlueprint advertDetailsContactBarBlueprint, @NotNull AdvertDetailsGapBlueprint advertDetailsGapBlueprint, @NotNull AdvertDetailsDividerBlueprint advertDetailsDividerBlueprint, @NotNull AdvertDetailsGeoReferenceBlueprint advertDetailsGeoReferenceBlueprint, @NotNull AdvertDetailsSkeletonBlueprint advertDetailsSkeletonBlueprint, @NotNull AdvertDetailsTitleSkeletonBlueprint advertDetailsTitleSkeletonBlueprint, @NotNull AdvertDetailsSimilarsButtonBlueprint advertDetailsSimilarsButtonBlueprint, @NotNull AdvertDetailsClosingReasonBlueprint advertDetailsClosingReasonBlueprint, @NotNull AdvertDetailsShowDescriptionBlueprint advertDetailsShowDescriptionBlueprint, @NotNull AdvertDetailsShowOnMapBlueprint advertDetailsShowOnMapBlueprint, @NotNull AdvertDetailsRatingPublishBlueprint advertDetailsRatingPublishBlueprint, @AdvertBlueprints @NotNull Set<ItemBlueprint<?, ?>> set, @NotNull AdvertDetailsRecommendationItemBlueprint advertDetailsRecommendationItemBlueprint, @NotNull SafeShowItemBlueprint safeShowItemBlueprint, @NotNull AdvertDetailsIceBreakersBlueprint advertDetailsIceBreakersBlueprint, @NotNull AdvertDetailsFeatureTeaserBlueprint advertDetailsFeatureTeaserBlueprint, @NotNull MarketplaceSpecsBlueprint marketplaceSpecsBlueprint, @NotNull MarketplaceBriefSpecsBlueprint marketplaceBriefSpecsBlueprint, @NotNull MarketplaceInfoBlueprint marketplaceInfoBlueprint, @NotNull MarketplaceDeliveryBlueprint marketplaceDeliveryBlueprint, @NotNull MarketplaceFaqBlueprint marketplaceFaqBlueprint, @NotNull MarketplaceBadgeBarBlueprint marketplaceBadgeBarBlueprint, @NotNull MarketplaceQuantityBlueprint marketplaceQuantityBlueprint, @NotNull MarketplaceContactBarBlueprint marketplaceContactBarBlueprint, @NotNull AlertBannerBlueprint alertBannerBlueprint, @NotNull SparePartsReplacementsBlueprint sparePartsReplacementsBlueprint, @NotNull SparePartsCompatibilitiesBlueprint sparePartsCompatibilitiesBlueprint, @NotNull AdvertBookingBlueprint advertBookingBlueprint, @NotNull CarMarketPriceDescriptionBlueprint carMarketPriceDescriptionBlueprint, @NotNull CarMarketPriceChartBlueprint carMarketPriceChartBlueprint, @NotNull AdvertDetailsHeaderBlueprint advertDetailsHeaderBlueprint) {
        Intrinsics.checkNotNullParameter(complementarySectionBlueprint, "complementarySectionBlueprint");
        Intrinsics.checkNotNullParameter(complementaryTitleWithActionBlueprint, "complementaryTitleWithActionBlueprint");
        Intrinsics.checkNotNullParameter(complementaryExpandSectionsButtonBlueprint, "complementaryExpandSectionBlueprint");
        Intrinsics.checkNotNullParameter(rdsNotLoadAdStubBlueprint, "notLoadAdStubBlueprint");
        Intrinsics.checkNotNullParameter(rdsEmptyAdStubItemBlueprint, "rdsEmptyAdStubItemBlueprint");
        Intrinsics.checkNotNullParameter(rdsYandexContentBigBlueprint, "yandexContentBlueprint");
        Intrinsics.checkNotNullParameter(rdsYandexAppInstallBigBlueprint, "yandexAppInstallBlueprint");
        Intrinsics.checkNotNullParameter(rdsAdfoxBigBlueprint, "adfoxContentBlueprint");
        Intrinsics.checkNotNullParameter(rdsDfpUnifiedBlueprint, "dfpUnifiedBlueprint");
        Intrinsics.checkNotNullParameter(rdsDfpContentBlueprint, "dfpContentBlueprint");
        Intrinsics.checkNotNullParameter(rdsDfpAppInstallBlueprint, "dfpAppInstallBlueprint");
        Intrinsics.checkNotNullParameter(rdsMyTargetContentBlueprint, "myTargetContentBlueprint");
        Intrinsics.checkNotNullParameter(rdsMyTargetAppInstallBlueprint, "myTargetAppInstallBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsTitleBlueprint, "advertDetailsTitleBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsGalleryBlueprint, "advertDetailsGalleryBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsPriceBlueprint, "advertDetailsPriceBlueprint");
        Intrinsics.checkNotNullParameter(priceWithDiscountBlueprint, "priceWithDiscountBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsPriceMarketplaceBlueprint, "advertDetailsPriceMarketplaceBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsPriceSubscriptionBlueprint, "advertDetailsPriceSubscriptionBlueprint");
        Intrinsics.checkNotNullParameter(similarsLoaderItemBlueprint, "similarsLoaderBlueprint");
        Intrinsics.checkNotNullParameter(rdsAdvertGridItemBlueprint, "rdsAdvertGridItemBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsDisclaimerBlueprint, "advertDetailsDisclaimerBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsDescriptionBlueprint, "advertDetailsDescriptionBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAddressBlueprint, "advertDetailsAddressBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsGroupsBlueprint, "advertDetailsGroupsBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsFlatsBlueprint, "advertDetailsFlatsBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaBlueprint, "advertDetailsAutotekaBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserBlueprint, "advertDetailsAutotekaTeaserBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAutodealBlueprint, "advertDetailsAutodealBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsNoteBlueprint, "advertDetailsNoteBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAutoCatalogBlueprint, "advertDetailsAutoCatalogBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsSellerProfileBlueprint, "advertDetailsSellerProfileBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsSellerSubscriptionBlueprint, "advertDetailsSellerSubscriptionBlueprint");
        Intrinsics.checkNotNullParameter(additionalSellerBlueprint, "advertDetailsAdditionalSellerBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAnonymousNumberBlueprint, "advertDetailsAnonymousNumberBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAdvertNumberBlueprint, "advertDetailsAdvertNumberBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsAbuseBlueprint, "advertDetailsAbuseBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsDeliveryActionsBlueprint, "advertDetailsDeliveryActionsBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsDeliveryInfoBlueprint, "advertDetailsDeliveryInfoBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsConsultationBlueprint, "advertDetailsConsultationBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsShortTermRentBlueprint, "advertDetailsShortTermRentRentBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsContactBarBlueprint, "advertDetailsContactBarBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsGapBlueprint, "advertDetailsGapBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsDividerBlueprint, "advertDetailsDividerBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsGeoReferenceBlueprint, "advertDetailsGeoReferenceBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsSkeletonBlueprint, "advertDetailsSkeletonBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsTitleSkeletonBlueprint, "advertDetailsTitleSkeletonBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsSimilarsButtonBlueprint, "advertDetailsSimilarsButtonBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsClosingReasonBlueprint, "advertDetailsStatusBadgeBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsShowDescriptionBlueprint, "advertDetailsShowDescriptionBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapBlueprint, "advertDetailsShowOnMapBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsRatingPublishBlueprint, "advertDetailsRatingPublishBlueprint");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        Intrinsics.checkNotNullParameter(advertDetailsRecommendationItemBlueprint, "advertDetailsRecommendedSellers");
        Intrinsics.checkNotNullParameter(safeShowItemBlueprint, "advertDetailsSafeShowBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsIceBreakersBlueprint, "advertDetailsIceBreakersBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserBlueprint, "advertDetailsFeatureTeaser");
        Intrinsics.checkNotNullParameter(marketplaceSpecsBlueprint, "marketplaceSpecsBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceBriefSpecsBlueprint, "marketplaceBriefSpecsBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceInfoBlueprint, "marketplaceInfoBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceDeliveryBlueprint, "marketplaceDeliveryBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceFaqBlueprint, "marketplaceFaqBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceBadgeBarBlueprint, "marketplaceBadgeBarBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceQuantityBlueprint, "marketplaceQuantityBlueprint");
        Intrinsics.checkNotNullParameter(marketplaceContactBarBlueprint, "marketplaceContactBarBlueprint");
        Intrinsics.checkNotNullParameter(alertBannerBlueprint, "alertBannerItem");
        Intrinsics.checkNotNullParameter(sparePartsReplacementsBlueprint, "replacementsBlueprint");
        Intrinsics.checkNotNullParameter(sparePartsCompatibilitiesBlueprint, "compatibilitiesBlueprint");
        Intrinsics.checkNotNullParameter(advertBookingBlueprint, "bookingBlueprint");
        Intrinsics.checkNotNullParameter(carMarketPriceDescriptionBlueprint, "carMarketPriceDescriptionBlueprint");
        Intrinsics.checkNotNullParameter(carMarketPriceChartBlueprint, "carMarketPriceChartBlueprint");
        Intrinsics.checkNotNullParameter(advertDetailsHeaderBlueprint, "advertDetailsHeaderBlueprint");
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(rdsAdvertGridItemBlueprint).registerItem(complementarySectionBlueprint).registerItem(complementaryTitleWithActionBlueprint).registerItem(complementaryExpandSectionsButtonBlueprint).registerItem(rdsNotLoadAdStubBlueprint).registerItem(rdsYandexContentBigBlueprint).registerItem(rdsYandexAppInstallBigBlueprint).registerItem(rdsAdfoxBigBlueprint).registerItem(rdsDfpUnifiedBlueprint).registerItem(rdsDfpContentBlueprint).registerItem(rdsDfpAppInstallBlueprint).registerItem(rdsMyTargetContentBlueprint).registerItem(rdsMyTargetAppInstallBlueprint).registerItem(rdsEmptyAdStubItemBlueprint).registerItem(advertDetailsTitleBlueprint).registerItem(advertDetailsGalleryBlueprint).registerItem(advertDetailsPriceBlueprint).registerItem(priceWithDiscountBlueprint).registerItem(advertDetailsPriceMarketplaceBlueprint).registerItem(advertDetailsPriceSubscriptionBlueprint).registerItem(similarsLoaderItemBlueprint).registerItem(advertDetailsDisclaimerBlueprint).registerItem(advertDetailsDescriptionBlueprint).registerItem(advertDetailsAddressBlueprint).registerItem(advertDetailsGroupsBlueprint).registerItem(advertDetailsFlatsBlueprint).registerItem(advertDetailsAutotekaBlueprint).registerItem(advertDetailsAutotekaTeaserBlueprint).registerItem(advertDetailsAutodealBlueprint).registerItem(advertDetailsNoteBlueprint).registerItem(advertDetailsAutoCatalogBlueprint).registerItem(advertDetailsSellerProfileBlueprint).registerItem(advertDetailsSellerSubscriptionBlueprint).registerItem(additionalSellerBlueprint).registerItem(advertDetailsAnonymousNumberBlueprint).registerItem(advertDetailsAdvertNumberBlueprint).registerItem(advertDetailsAbuseBlueprint).registerItem(advertDetailsDeliveryActionsBlueprint).registerItem(advertDetailsDeliveryInfoBlueprint).registerItem(advertDetailsConsultationBlueprint).registerItem(advertDetailsShortTermRentBlueprint).registerItem(advertDetailsContactBarBlueprint).registerItem(advertDetailsGapBlueprint).registerItem(advertDetailsDividerBlueprint).registerItem(advertDetailsGeoReferenceBlueprint).registerItem(advertDetailsSkeletonBlueprint).registerItem(advertDetailsTitleSkeletonBlueprint).registerItem(advertDetailsSimilarsButtonBlueprint).registerItem(advertDetailsClosingReasonBlueprint).registerItem(advertDetailsShowDescriptionBlueprint).registerItem(advertDetailsShowOnMapBlueprint).registerItem(advertDetailsRatingPublishBlueprint).registerItem(advertDetailsRecommendationItemBlueprint).registerItem(safeShowItemBlueprint).registerItem(advertDetailsIceBreakersBlueprint).registerItem(advertDetailsFeatureTeaserBlueprint).registerItem(marketplaceSpecsBlueprint).registerItem(marketplaceBriefSpecsBlueprint).registerItem(marketplaceInfoBlueprint).registerItem(marketplaceDeliveryBlueprint).registerItem(marketplaceFaqBlueprint).registerItem(marketplaceBadgeBarBlueprint).registerItem(marketplaceQuantityBlueprint).registerItem(marketplaceContactBarBlueprint).registerItem(alertBannerBlueprint).registerItem(sparePartsReplacementsBlueprint).registerItem(sparePartsCompatibilitiesBlueprint).registerItem(advertBookingBlueprint).registerItem(carMarketPriceDescriptionBlueprint).registerItem(carMarketPriceChartBlueprint).registerItem(advertDetailsHeaderBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            registerItem.registerItem(it.next());
        }
        Unit unit = Unit.INSTANCE;
        return registerItem.build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final PermissionHelper providePermissionHelper$advert_details_release(@NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate) {
        Intrinsics.checkNotNullParameter(advertDetailsFragmentDelegate, "fragmentDelegate");
        return new FragmentPermissionHelper(advertDetailsFragmentDelegate.fragment());
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter$advert_details_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "presenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SafeRecyclerAdapter provideSafeRecyclerAdapter$advert_details_release(@NotNull AdapterPresenter adapterPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }

    @Provides
    @NotNull
    public final SearchContextWrapper provideSearchContextWrapper$advert_details_release(@SearchContext @Nullable String str) {
        return new SearchContextWrapper(str);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SourceScreen provideSourceScreen$advert_details_release() {
        return SourceScreen.ADVERT_DETAILS;
    }

    @Provides
    @PerFragment
    @NotNull
    public final GridLayoutManager.SpanSizeLookup provideSpanLookup$advert_details_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SerpSpanProvider provideSpanProvider$advert_details_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SerpSpanProviderImpl(resources.getInteger(R.integer.similar_adverts_columns), spannedGridPositionProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TreeClickStreamParent provideTreeParent$advert_details_release(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "advertDetailsAnalyticsInteractor");
        return advertDetailsAnalyticsInteractor.getParent();
    }
}
