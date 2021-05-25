package com.avito.android.advert.item;

import a2.g.r.g;
import android.os.Bundle;
import android.text.SpannableString;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.abuse.AdvertDetailsAbuseItem;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerItem;
import com.avito.android.advert.item.address.AdvertDetailsAddressItem;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberItem;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberItem;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogItem;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealItem;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaItem;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserItem;
import com.avito.android.advert.item.booking.AdvertBookingItem;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryItem;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationItem;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarItem;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserItem;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsItem;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoItem;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionItem;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoItem;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkItem;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerItem;
import com.avito.android.advert.item.disclaimer.DisclaimerData;
import com.avito.android.advert.item.divider.AdvertDetailsDividerItem;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserItem;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsItem;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceItem;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsItem;
import com.avito.android.advert.item.guide.AdvertDetailsGuideItem;
import com.avito.android.advert.item.header.AdvertDetailsHeaderItem;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersItem;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarItem;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarItem;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqItem;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoItem;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityItem;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsItem;
import com.avito.android.advert.item.note.AdvertDetailsNoteItem;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryItem;
import com.avito.android.advert.item.price.AdvertDetailsPriceItem;
import com.avito.android.advert.item.price_discount.PriceWithDiscountItem;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceItem;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionItem;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishItem;
import com.avito.android.advert.item.safe_show.SafeShowItem;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonItem;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonItem;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoItem;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelItem;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesItem;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsItem;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfileItem;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionItem;
import com.avito.android.advert.item.sellersubscription.SellerNotificationsState;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionState;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentItem;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionItem;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapItem;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.similars.ComplementarySection;
import com.avito.android.advert.item.similars.SimilarsLoaderItem;
import com.avito.android.advert.item.similars.SimilarsStartMarkerItem;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonItem;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonItem;
import com.avito.android.advert.item.spare_parts.SparePartsItem;
import com.avito.android.advert.item.spare_parts.SparePartsItemType;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonItem;
import com.avito.android.advert.item.title.AdvertDetailsTitleItem;
import com.avito.android.advert.item.verification.AdvertVerificationItem;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItem;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItem;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartItem;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionItem;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.advert_core.gap.AdvertDetailsGapItem;
import com.avito.android.advert_core.utils.AdvertDetailsUtilsKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.marketplace.AdvertMarketPlace;
import com.avito.android.remote.marketplace.AdvertQuantity;
import com.avito.android.remote.marketplace.Delivery;
import com.avito.android.remote.marketplace.FAQ;
import com.avito.android.remote.marketplace.InfoBanner;
import com.avito.android.remote.model.AdditionalSeller;
import com.avito.android.remote.model.AdjustParameters;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertDisclaimer;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.AdvertShortTermRent;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.AutoDeal;
import com.avito.android.remote.model.Booking;
import com.avito.android.remote.model.CREGeoReportTeaser;
import com.avito.android.remote.model.CarMarketPrice;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.PriceDescription;
import com.avito.android.remote.model.PriceRanges;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.remote.model.SellerSubscriptionInfo;
import com.avito.android.remote.model.SimpleAdvertAction;
import com.avito.android.remote.model.SparePartsParameters;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadge;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeBar;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeBarParams;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeStyle;
import com.avito.android.remote.model.advert_badge_bar.BadgeBarOrientation;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.feature_teaser.AdvertDetailsFeaturesTeasers;
import com.avito.android.remote.model.feature_teaser.CreReportTeaser;
import com.avito.android.remote.model.feature_teaser.SafeShow;
import com.avito.android.remote.model.guide.Guide;
import com.avito.android.remote.model.guide.GuideSection;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonItem;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.promo_card.PromoCardItem;
import com.avito.android.util.AvitoTextUtils;
import com.avito.android.util.Bundles;
import com.avito.android.util.Collections;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.n.e;
import t6.n.h;
import t6.n.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0002\b\u0007\u0012\u000b\b\u0001\u0010í\u0003\u001a\u0004\u0018\u00010*\u0012\t\b\u0001\u0010ø\u0001\u001a\u00020*\u0012\u0007\u0010ü\u0002\u001a\u000203\u0012\b\u0010ã\u0002\u001a\u00030à\u0002\u0012\b\u0010Õ\u0003\u001a\u00030Ò\u0003\u0012\b\u0010\u0004\u001a\u00030\u0004\u0012\u0011\b\u0001\u0010ë\u0002\u001a\n\u0012\u0005\u0012\u00030è\u00020ç\u0002\u0012\u0011\b\u0001\u0010£\u0003\u001a\n\u0012\u0005\u0012\u00030è\u00020ç\u0002\u0012\b\u0010Ã\u0003\u001a\u00030À\u0003\u0012\b\u0010Ñ\u0003\u001a\u00030Î\u0003\u0012\b\u0010ñ\u0002\u001a\u00030î\u0002\u0012\b\u0010\u0003\u001a\u00030\u0003\u0012\b\u0010Û\u0003\u001a\u00030Ø\u0003\u0012\b\u0010þ\u0003\u001a\u00030û\u0003\u0012\b\u0010ß\u0003\u001a\u00030Ü\u0003\u0012\b\u0010Ç\u0003\u001a\u00030Ä\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000f\u0010Û\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020×\u0002\u0012\b\u0010\u0004\u001a\u00030\u0004\u0012\u0007\u0010¼\u0002\u001a\u00020.\u0012\b\u0010\u0003\u001a\u00030\u0003\u0012\u000f\u0010\u0003\u001a\n\u0012\u0005\u0012\u00030\u00030×\u0002\u0012\u000f\u0010\u0003\u001a\n\u0012\u0005\u0012\u00030\u00030\u0003¢\u0006\u0006\b\u0004\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\bJ\u0017\u00104\u001a\u0002032\u0006\u00102\u001a\u00020$H\u0016¢\u0006\u0004\b4\u00105J-\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\b\b\u0000\u00106*\u00020$2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020;H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010D\u001a\u00020\u00042\u0006\u0010A\u001a\u0002032\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020.H\u0016¢\u0006\u0004\bF\u00100J\u0019\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bH\u0010IJ\u0019\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bQ\u0010RJ\u001b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\bT\u0010UJ\u001b\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\bW\u0010XJ\u001b\u0010Z\u001a\u0004\u0018\u00010Y2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\bZ\u0010[J3\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b^\u0010_J\u001b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\ba\u0010bJ\u0019\u0010d\u001a\u0004\u0018\u00010c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bd\u0010eJ\u0019\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bg\u0010hJ\u0019\u0010j\u001a\u0002032\b\b\u0002\u0010i\u001a\u00020.H\u0002¢\u0006\u0004\bj\u0010kJ+\u0010o\u001a\u00020\u00042\u0006\u0010l\u001a\u0002032\b\u0010m\u001a\u0004\u0018\u0001032\b\u0010n\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\bo\u0010pJ\u0019\u0010r\u001a\u0004\u0018\u00010q2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\br\u0010sJ\u0019\u0010u\u001a\u0004\u0018\u00010t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bu\u0010vJ\u0019\u0010x\u001a\u0004\u0018\u00010w2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bx\u0010yJ\u0019\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b{\u0010|J\u0019\u0010~\u001a\u0004\u0018\u00010}2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b~\u0010J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010 \u0001J\u0013\u0010¢\u0001\u001a\u00030¡\u0001H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001e\u0010¦\u0001\u001a\u00030¥\u00012\t\b\u0002\u0010¤\u0001\u001a\u00020.H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001d\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001d\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b¬\u0001\u0010­\u0001J!\u0010±\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001H\u0002¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0013\u0010´\u0001\u001a\u00030³\u0001H\u0002¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u0013\u0010·\u0001\u001a\u00030¶\u0001H\u0002¢\u0006\u0006\b·\u0001\u0010¸\u0001J<\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00012\u0010\u0010º\u0001\u001a\u000b\u0012\u0005\u0012\u00030¹\u0001\u0018\u00010#2\u0007\u0010»\u0001\u001a\u00020.2\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0002¢\u0006\u0006\b¿\u0001\u0010À\u0001J'\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00012\u0010\u0010Â\u0001\u001a\u000b\u0012\u0005\u0012\u00030Á\u0001\u0018\u00010#H\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001d\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u001d\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J#\u0010Í\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J@\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00012\t\u0010Ï\u0001\u001a\u0004\u0018\u00010*2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010»\u0001\u001a\u00020.H\u0002¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J*\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00012\u0007\u0010Ö\u0001\u001a\u00020*2\n\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u0001H\u0002¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J!\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u00012\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0002¢\u0006\u0006\bß\u0001\u0010à\u0001J\u0013\u0010â\u0001\u001a\u00030á\u0001H\u0002¢\u0006\u0006\bâ\u0001\u0010ã\u0001J%\u0010ä\u0001\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001d2\u0007\u0010»\u0001\u001a\u00020.H\u0002¢\u0006\u0006\bä\u0001\u0010å\u0001J.\u00106\u001a\u0005\u0018\u00010è\u00012\u0007\u0010æ\u0001\u001a\u00020*2\u0007\u0010ç\u0001\u001a\u00020*2\u0007\u0010»\u0001\u001a\u00020.H\u0002¢\u0006\u0005\b6\u0010é\u0001J\u001d\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u001d\u0010î\u0001\u001a\u0005\u0018\u00010í\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\bî\u0001\u0010ï\u0001J%\u0010ò\u0001\u001a\u00030ñ\u00012\u0007\u0010ð\u0001\u001a\u00020*2\u0007\u0010»\u0001\u001a\u00020.H\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001JW\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u00012\u0010\u0010õ\u0001\u001a\u000b\u0012\u0005\u0012\u00030ô\u0001\u0018\u00010#2\f\b\u0002\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u00012\u0007\u0010ø\u0001\u001a\u00020*2\t\b\u0002\u0010ù\u0001\u001a\u0002032\f\b\u0002\u0010û\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0002¢\u0006\u0006\bý\u0001\u0010þ\u0001JN\u0010\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0010\u0010õ\u0001\u001a\u000b\u0012\u0005\u0012\u00030ô\u0001\u0018\u00010#2\f\b\u0002\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u00012\t\b\u0002\u0010ù\u0001\u001a\u0002032\f\b\u0002\u0010û\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J\u0015\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J \u0010\u0002\u001a\u0005\u0018\u00010\u00022\t\u0010\u0002\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J!\u0010\u0002\u001a\u0005\u0018\u00010\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J\u001d\u0010\u0002\u001a\u0005\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0002\u0010\u0002J\u0011\u0010\u0002\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0002\u0010\bJ#\u0010\u0002\u001a\u00020\u0004*\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J#\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u0002\u001a\u000203H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J&\u0010\u0002\u001a\u0004\u0018\u00010$2\u0010\u0010\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010$0\u0002H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J&\u0010\u0002\u001a\u0004\u0018\u00010$2\u0010\u0010\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010$0\u0002H\u0002¢\u0006\u0006\b\u0002\u0010\u0002J(\u0010 \u0002\u001a\u00020\u00042\t\b\u0002\u0010\u0002\u001a\u0002032\t\b\u0002\u0010\u0002\u001a\u000203H\u0002¢\u0006\u0006\b \u0002\u0010¡\u0002J\u001e\u0010¤\u0002\u001a\u00030£\u00022\t\b\u0002\u0010¢\u0002\u001a\u000203H\u0002¢\u0006\u0006\b¤\u0002\u0010¥\u0002J3\u0010©\u0002\u001a\u0005\u0018\u00010¨\u00022\n\u0010º\u0001\u001a\u0005\u0018\u00010¦\u00022\u0007\u00108\u001a\u00030§\u00022\u0007\u0010»\u0001\u001a\u00020.H\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u001f\u0010¬\u0002\u001a\u0005\u0018\u00010«\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0006\b¬\u0002\u0010­\u0002J\u001f\u0010¯\u0002\u001a\u0005\u0018\u00010®\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0006\b¯\u0002\u0010°\u0002J\u001f\u0010²\u0002\u001a\u0005\u0018\u00010±\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0006\b²\u0002\u0010³\u0002R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0002\u0010µ\u0002R\u001b\u0010·\u0002\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010¶\u0002R\u001c\u0010º\u0002\u001a\u0005\u0018\u00010¸\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0001\u0010¹\u0002R\u0019\u0010¼\u0002\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b»\u0002\u0010\u0001R!\u0010¾\u0002\u001a\u000b\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bg\u0010½\u0002R\u001b\u0010À\u0002\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b{\u0010¿\u0002R\u001b\u0010Â\u0002\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Á\u0002R\u001c\u0010Ä\u0002\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bý\u0001\u0010Ã\u0002R\u001b\u0010Æ\u0002\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Å\u0002R\u001a\u0010m\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R\u001f\u0010Ê\u0002\u001a\t\u0012\u0004\u0012\u00020$0É\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bj\u0010½\u0002R\u001b\u0010Ì\u0002\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Ë\u0002R\u001b\u0010Î\u0002\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b^\u0010Í\u0002R\u001c\u0010Ð\u0002\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ï\u0002R\u001a\u0010Ò\u0002\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\br\u0010Ñ\u0002R\u001a\u0010Ô\u0002\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bT\u0010Ó\u0002R\u001c\u0010Ö\u0002\u001a\u0005\u0018\u00010±\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010Õ\u0002R!\u0010Û\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020×\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÙ\u0002\u0010Ú\u0002R\u001b\u0010Ý\u0002\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Ü\u0002R\u001c\u0010ß\u0002\u001a\u0005\u0018\u00010®\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Þ\u0002R\u001a\u0010ã\u0002\u001a\u00030à\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bá\u0002\u0010â\u0002R!\u0010æ\u0002\u001a\u00020.8B@\u0002X\u0002¢\u0006\u000f\n\u0006\bä\u0002\u0010å\u0002\u001a\u0005\bæ\u0002\u00100R!\u0010ë\u0002\u001a\n\u0012\u0005\u0012\u00030è\u00020ç\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0002\u0010ê\u0002R\u001b\u0010í\u0002\u001a\u0005\u0018\u00010¨\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bu\u0010ì\u0002R\u001a\u0010ñ\u0002\u001a\u00030î\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bï\u0002\u0010ð\u0002R\u001b\u0010ó\u0002\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0002\u0010ò\u0002R\u001c\u0010ö\u0002\u001a\u0005\u0018\u00010ô\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010õ\u0002R\u001b\u0010ø\u0002\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bH\u0010÷\u0002R\u0019\u0010ú\u0002\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bù\u0002\u0010Ú\u0001R\u0019\u0010ü\u0002\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bû\u0002\u0010Ú\u0001R\u001b\u0010þ\u0002\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010ý\u0002R\u001b\u0010\u0003\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b6\u0010ÿ\u0002R\u001a\u0010\u0003\u001a\u00030\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010\u0003R\u001a\u0010\u0003\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bZ\u0010\u0003R\u001c\u0010\u0003\u001a\u0005\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0003R\u001b\u0010\u0003\u001a\u0005\u0018\u00010«\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bQ\u0010\u0003R!\u0010\u0003\u001a\n\u0012\u0005\u0012\u00030\u00030×\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010Ú\u0002R\u001a\u0010\u0003\u001a\u00030\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010\u0003R\u001a\u0010\u0003\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\ba\u0010\u0003R\u001b\u0010\u0003\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0003R\u001c\u0010\u0003\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bò\u0001\u0010\u0003R!\u0010\u0003\u001a\n\u0012\u0005\u0012\u00030\u00030\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010\u0003R\u001b\u0010\u0003\u001a\u0005\u0018\u00010Ù\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bd\u0010\u0003R\u001c\u0010¡\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010 \u0003R!\u0010£\u0003\u001a\n\u0012\u0005\u0012\u00030è\u00020ç\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0003\u0010ê\u0002R\u001c\u0010¥\u0003\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010¤\u0003R\u001b\u0010§\u0003\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bN\u0010¦\u0003R\u001b\u0010©\u0003\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010¨\u0003R\u001b\u0010«\u0003\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010ª\u0003R\u001c\u0010­\u0003\u001a\u0005\u0018\u00010ü\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010¬\u0003R\u001c\u0010°\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b®\u0003\u0010¯\u0003R\u001a\u0010²\u0003\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bW\u0010±\u0003R\u001c\u0010´\u0003\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010³\u0003R\u001c\u0010¶\u0003\u001a\u0005\u0018\u00010¨\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bµ\u0003\u0010ì\u0002R\u001c\u0010¹\u0003\u001a\u0005\u0018\u00010·\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010¸\u0003R\u001c\u0010»\u0003\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010º\u0003R\u001a\u0010¿\u0003\u001a\u00030¼\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0003\u0010¾\u0003R\u001a\u0010Ã\u0003\u001a\u00030À\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0003\u0010Â\u0003R\u001a\u0010Ç\u0003\u001a\u00030Ä\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0003\u0010Æ\u0003R\u001c\u0010É\u0003\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010È\u0003R\u001b\u0010Ë\u0003\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bx\u0010Ê\u0003R\u001c\u0010Í\u0003\u001a\u0005\u0018\u00010ñ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b´\u0001\u0010Ì\u0003R\u001a\u0010Ñ\u0003\u001a\u00030Î\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÏ\u0003\u0010Ð\u0003R\u001a\u0010Õ\u0003\u001a\u00030Ò\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0003\u0010Ô\u0003R\u001c\u0010×\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010Ö\u0003R\u001a\u0010Û\u0003\u001a\u00030Ø\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÙ\u0003\u0010Ú\u0003R\u001a\u0010ß\u0003\u001a\u00030Ü\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÝ\u0003\u0010Þ\u0003R\u001c\u0010â\u0003\u001a\u0005\u0018\u00010à\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bë\u0001\u0010á\u0003R\u001b\u0010ã\u0003\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ó\u0002R\u0019\u0010ä\u0003\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Ú\u0001R\u001c\u0010æ\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010å\u0003R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b \u0002\u0010ç\u0003R\u001c\u0010é\u0003\u001a\u0005\u0018\u00010ê\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010è\u0003R\u001f\u0010ê\u0003\u001a\t\u0012\u0004\u0012\u00020$0É\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bo\u0010½\u0002R\u001b\u0010í\u0003\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bë\u0003\u0010ì\u0003R\u0019\u0010ø\u0001\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bî\u0003\u0010ì\u0003R\u001c\u0010ð\u0003\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0003R\u001b\u0010ò\u0003\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010ñ\u0003R\u001c\u0010õ\u0003\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bó\u0003\u0010ô\u0003R\u001c\u0010÷\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010ö\u0003R\u001c\u0010ù\u0003\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0002\u0010ø\u0003R\u0019\u0010ú\u0003\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0001R\u001a\u0010þ\u0003\u001a\u00030û\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bü\u0003\u0010ý\u0003R\u001c\u0010\u0004\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0001\u0010ÿ\u0003R\u001c\u0010\u0004\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bä\u0001\u0010\u0004R\u001c\u0010\u0004\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010\u0004R\u001a\u0010n\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0004\u0010È\u0002R\u001a\u0010\u0004\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b~\u0010\u0004R\u001a\u0010\u0004\u001a\u00030\u00048\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0004\u0010\u0004R\u001c\u0010\u0004\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u0004R\u001c\u0010\u0004\u001a\u0005\u0018\u00010ÿ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u0004R\u001c\u0010\u0004\u001a\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0004R\u001a\u0010\u0004\u001a\u00030\u00048\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0004\u0010\u0004R\u001c\u0010\u0004\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0004R\u001b\u0010\u0004\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bK\u0010\u0004R!\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010½\u0002R\u0019\u0010\u0004\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0001¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsItemsPresenterImpl;", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "detachView", "()V", "clearItems", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "fastOpenParams", "bindFastAdvertData", "(Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;)V", "refreshAdvertData", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "advertWithMeta", "bindAdvertData", "(Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;)V", "Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE, "Lcom/avito/android/remote/model/DeliveryInfoResponse;", CommonKt.EXTRA_RESPONSE, "updateMarketplaceDeliveryInfoItem", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;Lcom/avito/android/remote/model/DeliveryInfoResponse;)V", "Lcom/avito/android/remote/model/Location;", "location", "updateSelectedLocation", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "Lcom/avito/android/advert/item/similars/ComplementarySection;", "complementarySection", "bindComplementarySection", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert/item/similars/ComplementarySection;)V", "", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "similarsItems", "legacyBindComplementaryItems", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/util/List;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "linkType", "", "monthlyPayment", "bindCreditBrokerLink", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;Ljava/lang/String;)V", "", "hasComplementaryItems", "()Z", "onSectionsExpandClicked", "item", "", "getItemPosition", "(Lcom/avito/android/serp/adapter/PersistableSpannedItem;)I", "T", "Ljava/lang/Class;", "type", "getItemsWithType", "(Ljava/lang/Class;)Ljava/util/List;", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "bundle", "restoreState", "(Landroid/os/Bundle;)V", VKApiConst.POSITION, "", "stateId", "onPageSelected", "(IJ)V", "isComplementaryLoaded", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;", VKApiConst.VERSION, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "B", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "r", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "g0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;", "K", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "Q", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "O", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "locationTo", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "M", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;Lcom/avito/android/remote/model/DeliveryInfoResponse;Lcom/avito/android/remote/model/Location;)Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;", "N", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;", "Lcom/avito/android/advert/item/booking/AdvertBookingItem;", AuthSource.OPEN_CHANNEL_LIST, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/booking/AdvertBookingItem;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionItem;", "o", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionItem;", "isComplementaryLoaderNeeded", "c", "(Z)I", "similarItemsPos", "topCommercialPosition", "bottomCommercialPosition", AuthSource.BOOKING_ORDER, "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;", "d0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationItem;", "t", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationItem;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "x", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsItem;", "y", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsItem;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoItem;", "X", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoItem;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;", "Z", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;", ExifInterface.LONGITUDE_WEST, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;", "Y", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsItem;", "a0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsItem;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseItem;", "d", "()Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseItem;", "Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberItem;", g.a, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberItem;", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberItem;", "h", "(Lcom/avito/android/remote/model/AnonymousNumber;)Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberItem;", "Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileItem;", "b0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileItem;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "c0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "Lcom/avito/android/remote/model/AdditionalSeller;", "additionalSeller", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerItem;", "e", "(Lcom/avito/android/remote/model/AdditionalSeller;)Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerItem;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "w", "()Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "isTitle", "Lcom/avito/android/advert/item/skeleton/AdvertDetailsSkeletonItem;", "j0", "(Z)Lcom/avito/android/advert/item/skeleton/AdvertDetailsSkeletonItem;", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;", "R", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", ExifInterface.LATITUDE_SOUTH, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", "Lcom/avito/android/remote/model/AutoDeal;", "autoDeal", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealItem;", "i", "(Lcom/avito/android/remote/model/AutoDeal;)Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealItem;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "j", "()Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;", "k", "()Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "closedAdvert", "Lcom/avito/android/remote/model/text/AttributedText;", "flatsTitle", "Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsItem;", "C", "(Ljava/util/List;ZLcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsItem;", "Lcom/avito/android/remote/model/AdvertParameters$Group;", "groups", "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsItem;", "H", "(Ljava/util/List;)Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsItem;", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem;", "f", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "f0", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferenceItem;", "G", "(Lcom/avito/android/remote/model/AdvertDetails;)Ljava/util/List;", "description", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "formattedDescription", "categoryName", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "z", "(Ljava/lang/String;Lcom/avito/android/html_formatter/HtmlCharSequence;Ljava/lang/String;Z)Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "iid", "Lcom/avito/android/remote/model/guide/Guide;", "guide", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "I", "(Ljava/lang/String;Lcom/avito/android/remote/model/guide/Guide;)Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "Lcom/avito/android/remote/model/AdvertDisclaimer;", "disclaimer", "Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerItem;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/avito/android/remote/model/AdvertDisclaimer;)Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerItem;", "Lcom/avito/android/advert/item/similars/SimilarsLoaderItem;", "i0", "()Lcom/avito/android/advert/item/similars/SimilarsLoaderItem;", "U", "(Lcom/avito/android/remote/model/AdvertDetails;Z)Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "price", "oldPrice", "Lcom/avito/android/advert/item/price/AdvertDetailsPriceItem;", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/advert/item/price/AdvertDetailsPriceItem;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "l", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "advertTitle", "Lcom/avito/android/advert/item/title/AdvertDetailsTitleItem;", "l0", "(Ljava/lang/String;Z)Lcom/avito/android/advert/item/title/AdvertDetailsTitleItem;", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", BookingInfoActivity.EXTRA_ITEM_ID, "imagePosition", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "D", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;Ljava/lang/String;ILcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "p", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;ILcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionItem;", "e0", "()Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionItem;", "reason", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "s", "(Ljava/lang/String;)Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "similarsAction", "Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;", "h0", "(Lcom/avito/android/remote/model/SimpleAdvertAction;)Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartItem;", "n", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartItem;", "n0", "Lcom/avito/android/serp/adapter/SpannedItem;", "bottomCommercial", "m0", "(Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;Lcom/avito/android/serp/adapter/SpannedItem;)V", "galleryPosition", "o0", "(Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;I)V", "Lkotlin/Function0;", "fallback", "q0", "(Lkotlin/jvm/functions/Function0;)Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "p0", "marginTop", "marginBottom", AuthSource.SEND_ABUSE, "(II)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/advert_core/gap/AdvertDetailsGapItem;", "F", "(I)Lcom/avito/android/advert_core/gap/AdvertDetailsGapItem;", "Lcom/avito/android/remote/model/SparePartsParameters;", "Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;", "Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "k0", "(Lcom/avito/android/remote/model/SparePartsParameters;Lcom/avito/android/advert/item/spare_parts/SparePartsItemType;Z)Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarItem;", "J", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarItem;", "Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityItem;", "P", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityItem;", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarItem;", "L", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;)Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarItem;", "M0", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoItem;", "safedealInfoItem", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarItem;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarItem;", "contactBarItem", "P0", "isMarketPlaceFastFlag", "Ljava/util/List;", "geoReferenceItems", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealItem;", "autodealItem", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;", "marketplaceBriefSpecsItem", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "sellerSubscriptionItem", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "marketplaceSpecsItem", "s0", "Ljava/lang/Integer;", "", "complementaryItems", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;", "geoMarketReportV2", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsItem;", "safedealTrustFactorsItem", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteItem;", "noteItem", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "marketplaceInfoItem", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "safedealButtonItem", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarItem;", "marketplaceContactBarItem", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "N0", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "advertDetailsPriceSubscription", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "findOfficeOfferItem", "Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityItem;", "marketplaceQuantityItem", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "z0", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "advertContactsPresenter", "v0", "Lkotlin/Lazy;", "isMarketplaceImprovingTest", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "C0", "Lcom/avito/android/util/Formatter;", "priceFormatter", "Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "partReplacementsItem", "Lcom/avito/android/IdProvider;", "G0", "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionItem;", "carMarketPriceDescriptionItem", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "iceBreakersItem", "Lcom/avito/android/advert/item/similars/SimilarsLoaderItem;", "similarsLoaderItem", "r0", "prevColumns", "y0", "initialGalleryImagePosition", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "checkedByAvitoItem", "Lcom/avito/android/advert/item/status_badge/AdvertDetailsClosingReasonItem;", "closingReasonItem", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "H0", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "deliveryInfoItem", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserItem;", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserItem;", "domotekaTeaserItem", "Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarItem;", "marketplaceBadgeBarItem", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceBadgeBarItemTestGroup;", "R0", "marketplaceBadgeBarItemTestGroup", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "Q0", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "imvBadgeItemConverter", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsItem;", "deliveryActionsItem", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "marketplaceDeliveryItem", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartItem;", "carMarketPriceChartItem", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceImprovingContentItemsTestGroup;", "S0", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "marketplaceImprovingContentItemsTestGroup", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "guideItem", "Lcom/avito/android/advert/item/advertnumber/AdvertDetailsAdvertNumberItem;", "advertNumberItem", "D0", "oldPriceFormatter", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "autotekaItem", "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsItem;", "groupsItem", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationItem;", "consultationItem", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;", "marketplaceFaqItem", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "galleryItem", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerItem;", "additionalSellerItem", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;", "shortTermRentItem", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "badgeBarItem", "u", "partCompatibilitiesItem", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;", "imvBadgeItem", "Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsItem;", "flatsItem", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "u0", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/text/AttributedTextFormatter;", "E0", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/account/AccountStateProvider;", "L0", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/advert/item/show_description_button/AdvertDetailsShowDescriptionItem;", "showDescriptionItem", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;", "autotekaTeaserItem", "Lcom/avito/android/advert/item/title/AdvertDetailsTitleItem;", "titleItem", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "F0", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "resourceProvider", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "A0", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "advertComplementaryPresenter", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;", "safedealServicesItem", "Lcom/avito/android/Features;", "I0", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "K0", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishItem;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishItem;", "ratingPublishItem", "priceItem", "similarsStartPosition", "Lcom/avito/android/advert/item/anonymousnumber/AdvertDetailsAnonymousNumberItem;", "anonymousNumberItem", "Lcom/avito/android/advert/item/AdvertDetailsView;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", "priceSubscriptionItem", "advertItems", "w0", "Ljava/lang/String;", "context", "x0", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "descriptionItem", "Lcom/avito/android/advert/item/booking/AdvertBookingItem;", "bookingItem", VKApiConst.Q, "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "showOnMapItem", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseItem;", "abuseItem", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;", "safedealLabelItem", "isMarketplace", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "J0", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "sellerSubscriptionPresenter", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogItem;", "modelSpecsItem", "Lcom/avito/android/advert/item/similars_button/AdvertDetailsSimilarsButtonItem;", "similarsButtonItem", "Lcom/avito/android/advert/item/sellerprofile/AdvertDetailsSellerProfileItem;", "sellerProfileItem", "t0", "Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "safeShowItem", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "B0", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "similarAdvertResources", "Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerItem;", "disclaimerItem", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "galleryCarouselItem", "Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "Lcom/avito/android/advert/item/verification/AdvertVerificationItem;", "verificationItem", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "O0", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "teasersAdapter", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressItem;", "addressItem", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "creditInfoItem", "apartmentFeatureItems", "isAlreadyBoundItems", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/advert/AdvertDetailsResourcesProvider;Lcom/avito/android/IdProvider;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/Features;Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;ZLcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsItemsPresenterImpl implements AdvertDetailsItemsPresenter {
    public AdvertDetailsAutoCatalogItem A;
    public final AdvertComplementaryPresenter A0;
    public AdvertDetailsCreditInfoItem B;
    public final AdvertSimilarPresenterResourceProvider B0;
    public AdvertDetailsSellerProfileItem C;
    public final Formatter<AdvertPrice> C0;
    public AdvertDetailsSellerSubscriptionItem D;
    public final Formatter<AdvertPrice> D0;
    public AdditionalSellerItem E;
    public final AttributedTextFormatter E0;
    public AdvertDetailsAnonymousNumberItem F;
    public final AdvertDetailsResourcesProvider F0;
    public AdvertDetailsAdvertNumberItem G;
    public final IdProvider G0;
    public AdvertDetailsAbuseItem H;
    public final AdvertDetailsAnalyticsInteractor H0;
    public AdvertDetailsSafeDealInfoItem I;
    public final Features I0;
    public AdvertDetailsSafeDealServicesItem J;
    public final SellerSubscriptionPresenter J0;
    public PersistableSpannedItem K;
    public final NotificationManagerProvider K0;
    public AdvertDetailsSafeDealLabelItem L;
    public final AccountStateProvider L0;
    public AdvertDetailsSafeDealTrustFactorsItem M;
    public final AdvertDetailsFastOpenParams M0;
    public AdvertDetailsDeliveryActionsItem N;
    public final ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> N0;
    public AdvertDetailsDeliveryInfoItem O;
    public final AdvertDetailsFeatureTeaserItemsAdapter O0;
    public AdvertDetailsConsultationItem P;
    public final boolean P0;
    public AdvertDetailsShortTermRentItem Q;
    public final AdvertDetailsImvBadgeItemConverter Q0;
    public AdvertDetailsContactBarItem R;
    public final ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> R0;
    public AdvertDetailsShowDescriptionItem S;
    public final ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> S0;
    public AdvertDetailsClosingReasonItem T;
    public AdvertDetailsSimilarsButtonItem U;
    public AdvertDetailsRatingPublishItem V;
    public AdvertDetailsDomotekaTeaserItem W;
    public SafeShowItem X;
    public AdvertDetailsIceBreakersItem Y;
    public AdvertDetailsFeatureTeaserItem Z;
    public AdvertDetailsView a;
    public List<AdvertDetailsFeatureTeaserItem> a0;
    public List<PersistableSpannedItem> b = new ArrayList();
    public MarketplaceSpecsItem b0;
    public List<PersistableSpannedItem> c = new ArrayList();
    public MarketplaceBriefSpecsItem c0;
    public PersistableSpannedItem d;
    public MarketplaceInfoItem d0;
    public AdvertDetailsPriceSubscriptionItem e;
    public MarketplaceDeliveryItem e0;
    public AdvertDetailsImvBadgeItem f;
    public MarketplaceFaqItem f0;
    public AdvertBadgeBarItem g;
    public MarketplaceBadgeBarItem g0;
    public AdvertDetailsGalleryItem h;
    public MarketplaceQuantityItem h0;
    public CarouselPhotoGalleryItem i;
    public MarketplaceContactBarItem i0;
    public AdvertDetailsTitleItem j;
    public AdvertBookingItem j0;
    public AdvertDetailsDisclaimerItem k;
    public CarMarketPriceDescriptionItem k0;
    public AdvertDetailsDescriptionItem l;
    public CarMarketPriceChartItem l0;
    public AdvertDetailsGuideItem m;
    public PromoCardItem m0;
    public AdvertVerificationItem n;
    public AdvertDetailsGeoReportTeaserItem n0;
    public List<AdvertDetailsGeoReferenceItem> o;
    public boolean o0;
    public AdvertDetailsAddressItem p;
    public boolean p0;
    public AdvertDetailsShowOnMapItem q;
    public int q0 = -1;
    public AdvertDetailsGroupsItem r;
    public int r0;
    public AdvertDetailsFlatsItem s;
    public Integer s0;
    public SparePartsItem t;
    public Integer t0;
    public SparePartsItem u;
    public final CompositeDisposable u0 = new CompositeDisposable();
    public SimilarsLoaderItem v;
    public final Lazy v0 = t6.c.lazy(new a(this));
    public AdvertDetailsAutotekaItem w;
    public final String w0;
    public AdvertDetailsAutotekaTeaserItem x;
    public final String x0;
    public AdvertDetailsAutodealItem y;
    public final int y0;
    public AdvertDetailsNoteItem z;
    public final AdvertContactsPresenter z0;

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ AdvertDetailsItemsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl) {
            super(0);
            this.a = advertDetailsItemsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(((AdvertDetailsMarketplaceImprovingContentItemsTestGroup) this.a.S0.getTestGroup()).isTest());
        }
    }

    public static final class b extends Lambda implements Function1<PersistableSpannedItem, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(PersistableSpannedItem persistableSpannedItem) {
            PersistableSpannedItem persistableSpannedItem2 = persistableSpannedItem;
            Intrinsics.checkNotNullParameter(persistableSpannedItem2, "it");
            return Boolean.valueOf(persistableSpannedItem2 instanceof SimilarsStartMarkerItem);
        }
    }

    public static final class c extends Lambda implements Function0<PersistableSpannedItem> {
        public final /* synthetic */ AdvertDetailsItemsPresenterImpl a;
        public final /* synthetic */ AdvertDetails b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, AdvertDetails advertDetails) {
            super(0);
            this.a = advertDetailsItemsPresenterImpl;
            this.b = advertDetails;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PersistableSpannedItem invoke() {
            return this.a.W(this.b);
        }
    }

    public static final class d extends Lambda implements Function0<PersistableSpannedItem> {
        public final /* synthetic */ AdvertDetailsItemsPresenterImpl a;
        public final /* synthetic */ AdvertDetails b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, AdvertDetails advertDetails, boolean z) {
            super(0);
            this.a = advertDetailsItemsPresenterImpl;
            this.b = advertDetails;
            this.c = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PersistableSpannedItem invoke() {
            return this.a.U(this.b, !this.c);
        }
    }

    @Inject
    public AdvertDetailsItemsPresenterImpl(@AdvertFragmentModule.SearchContext @Nullable String str, @AdvertId @NotNull String str2, int i2, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull AdvertComplementaryPresenter advertComplementaryPresenter, @NotNull AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, @AdvertFragmentModule.CurrentPrice @NotNull Formatter<AdvertPrice> formatter, @AdvertFragmentModule.OldPrice @NotNull Formatter<AdvertPrice> formatter2, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull AdvertDetailsResourcesProvider advertDetailsResourcesProvider, @NotNull IdProvider idProvider, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull Features features, @NotNull SellerSubscriptionPresenter sellerSubscriptionPresenter, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull AccountStateProvider accountStateProvider, @Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> manuallyExposedAbTestGroup, @NotNull AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter, boolean z2, @NotNull AdvertDetailsImvBadgeItemConverter advertDetailsImvBadgeItemConverter, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> manuallyExposedAbTestGroup2, @NotNull ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> exposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "advertContactsPresenter");
        Intrinsics.checkNotNullParameter(advertComplementaryPresenter, "advertComplementaryPresenter");
        Intrinsics.checkNotNullParameter(advertSimilarPresenterResourceProvider, "similarAdvertResources");
        Intrinsics.checkNotNullParameter(formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(formatter2, "oldPriceFormatter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(advertDetailsResourcesProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(sellerSubscriptionPresenter, "sellerSubscriptionPresenter");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "advertDetailsPriceSubscription");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItemsAdapter, "teasersAdapter");
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgeItemConverter, "imvBadgeItemConverter");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup2, "marketplaceBadgeBarItemTestGroup");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "marketplaceImprovingContentItemsTestGroup");
        this.w0 = str;
        this.x0 = str2;
        this.y0 = i2;
        this.z0 = advertContactsPresenter;
        this.A0 = advertComplementaryPresenter;
        this.B0 = advertSimilarPresenterResourceProvider;
        this.C0 = formatter;
        this.D0 = formatter2;
        this.E0 = attributedTextFormatter;
        this.F0 = advertDetailsResourcesProvider;
        this.G0 = idProvider;
        this.H0 = advertDetailsAnalyticsInteractor;
        this.I0 = features;
        this.J0 = sellerSubscriptionPresenter;
        this.K0 = notificationManagerProvider;
        this.L0 = accountStateProvider;
        this.M0 = advertDetailsFastOpenParams;
        this.N0 = manuallyExposedAbTestGroup;
        this.O0 = advertDetailsFeatureTeaserItemsAdapter;
        this.P0 = z2;
        this.Q0 = advertDetailsImvBadgeItemConverter;
        this.R0 = manuallyExposedAbTestGroup2;
        this.S0 = exposedAbTestGroup;
    }

    public static /* synthetic */ AdvertDetailsGalleryItem E(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, List list, Video video, String str, int i2, ForegroundImage foregroundImage, int i3) {
        if ((i3 & 2) != 0) {
            video = null;
        }
        int i4 = i3 & 16;
        return advertDetailsItemsPresenterImpl.D(list, video, str, (i3 & 8) != 0 ? 0 : i2, null);
    }

    public static /* synthetic */ CarouselPhotoGalleryItem q(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, List list, Video video, int i2, ForegroundImage foregroundImage, int i3) {
        if ((i3 & 2) != 0) {
            video = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        int i4 = i3 & 8;
        return advertDetailsItemsPresenterImpl.p(list, video, i2, null);
    }

    public static AdvertDetailsContactBarItem u(AdvertDetailsItemsPresenterImpl advertDetailsItemsPresenterImpl, AdvertDetails advertDetails, long j2, int i2) {
        long j3 = (i2 & 2) != 0 ? (long) 30 : j2;
        List<ContactBar.Action> actions = advertDetailsItemsPresenterImpl.z0.getActions();
        if (!(!actions.isEmpty()) || !advertDetails.isActive()) {
            return null;
        }
        return new AdvertDetailsContactBarItem(j3, null, actions, AdvertDetailsUtilsKt.toContactBarData$default(advertDetails, null, 1, null), advertDetails.getPrice(), advertDetailsItemsPresenterImpl.B0.getSimilarColumns(), null, null, 194, null);
    }

    public final AdvertDetailsDisclaimerItem A(AdvertDisclaimer advertDisclaimer) {
        CharSequence charSequence = null;
        if (advertDisclaimer == null) {
            return null;
        }
        AttributedText header = advertDisclaimer.getHeader();
        CharSequence format = header != null ? this.E0.format(header) : null;
        AttributedText body = advertDisclaimer.getBody();
        if (body != null) {
            charSequence = this.E0.format(body);
        }
        return new AdvertDetailsDisclaimerItem(0, null, new DisclaimerData(format, charSequence), this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final PromoCardItem B(AdvertDetails advertDetails) {
        AdvertDetailsFeaturesTeasers teasers;
        CreReportTeaser findOfficeOffer;
        String title;
        UniversalColor backgroundColor;
        if (!this.I0.getFindOfficeOffer().invoke().booleanValue() || (teasers = advertDetails.getTeasers()) == null || (findOfficeOffer = teasers.getFindOfficeOffer()) == null || (title = findOfficeOffer.getTitle()) == null || (backgroundColor = findOfficeOffer.getBackgroundColor()) == null) {
            return null;
        }
        return new PromoCardItem(false, null, this.B0.getSimilarColumns(), String.valueOf(70), backgroundColor, backgroundColor, title, null, findOfficeOffer.toConsultationFormDeepLink(this.x0), findOfficeOffer.getSubtitle(), findOfficeOffer.getShowDescriptionTitle(), this.x0, false, 4227, null);
    }

    public final AdvertDetailsFlatsItem C(List<AdvertParameters.Parameter> list, boolean z2, AttributedText attributedText) {
        if (list != null) {
            return new AdvertDetailsFlatsItem(0, null, list, z2, attributedText, this.B0.getSimilarColumns(), null, null, 195, null);
        }
        return null;
    }

    public final AdvertDetailsGalleryItem D(List<Image> list, Video video, String str, int i2, ForegroundImage foregroundImage) {
        if (Collections.isNullOrEmpty(list) && video == null && foregroundImage == null) {
            return null;
        }
        return new AdvertDetailsGalleryItem(0, null, list, video, null, i2, this.G0.generateId(), str, foregroundImage, this.B0.getSimilarColumns(), null, null, null, 7187, null);
    }

    public final AdvertDetailsGapItem F(int i2) {
        return new AdvertDetailsGapItem((long) 33, null, i2, this.B0.getSimilarColumns(), null, null, 50, null);
    }

    public final List<AdvertDetailsGeoReferenceItem> G(AdvertDetails advertDetails) {
        ArrayList arrayList = new ArrayList();
        List<GeoReference> geoReferences = advertDetails.getGeoReferences();
        if (geoReferences != null) {
            for (Iterator<T> it = geoReferences.iterator(); it.hasNext(); it = it) {
                T next = it.next();
                String content = next.getContent();
                String after = next.getAfter();
                List<String> colors = next.getColors();
                String addressParam = advertDetails.getAddressParam();
                if (addressParam == null) {
                    addressParam = "";
                }
                arrayList.add(new AdvertDetailsGeoReferenceItem(0, null, content, after, colors, addressParam, advertDetails.advertCoordinates(), advertDetails.advertTitle(), this.B0.getSimilarColumns(), 3, null));
            }
        }
        return arrayList;
    }

    public final AdvertDetailsGroupsItem H(List<AdvertParameters.Group> list) {
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        return new AdvertDetailsGroupsItem(0, null, list, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final AdvertDetailsGuideItem I(String str, Guide guide) {
        if (guide == null) {
            return null;
        }
        List<GuideSection> sections = guide.getSections();
        if (sections == null) {
            return null;
        }
        if (sections.isEmpty()) {
            return null;
        }
        return new AdvertDetailsGuideItem(0, null, str, guide.getTitle(), sections, guide.getLink(), false, this.B0.getSimilarColumns(), null, null, 835, null);
    }

    public final MarketplaceBadgeBarItem J(AdvertMarketPlace advertMarketPlace) {
        AdvertBadgeBar badgeBar;
        List<AdvertBadge> badges;
        if (advertMarketPlace == null || (badgeBar = advertMarketPlace.getBadgeBar()) == null || (badges = badgeBar.getBadges()) == null || !(!badges.isEmpty())) {
            return null;
        }
        return new MarketplaceBadgeBarItem(0, null, badges, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if ((r14 != null ? r14.getInStockTexts() : null) != null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem K(com.avito.android.remote.marketplace.AdvertMarketPlace r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x0008
            java.util.List r1 = r14.getMainSpecifications()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r1 != 0) goto L_0x0015
            if (r14 == 0) goto L_0x0012
            com.avito.android.remote.marketplace.InStock r1 = r14.getInStockTexts()
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r1 == 0) goto L_0x001b
        L_0x0015:
            com.avito.android.remote.model.advert_badge_bar.AdvertBadgeBar r1 = r14.getBadgeBar()
            if (r1 == 0) goto L_0x001c
        L_0x001b:
            return r0
        L_0x001c:
            com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem r0 = new com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem
            r3 = 0
            r5 = 0
            java.util.List r1 = r14.getMainSpecifications()
            if (r1 == 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x002c:
            r6 = r1
            com.avito.android.remote.marketplace.InStock r7 = r14.getInStockTexts()
            com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider r14 = r13.B0
            int r8 = r14.getSimilarColumns()
            r9 = 0
            r10 = 0
            r11 = 99
            r12 = 0
            r2 = r0
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl.K(com.avito.android.remote.marketplace.AdvertMarketPlace):com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem");
    }

    public final MarketplaceContactBarItem L(AdvertMarketPlace advertMarketPlace) {
        AdvertAction.Messenger chatAction;
        DeepLink deepLink;
        if (advertMarketPlace == null || (chatAction = advertMarketPlace.getChatAction()) == null || (deepLink = chatAction.getDeepLink()) == null) {
            return null;
        }
        return new MarketplaceContactBarItem(0, null, chatAction.getTitle(), deepLink, this.B0.getSimilarColumns(), null, null, 99, null);
    }

    public final MarketplaceDeliveryItem M(AdvertMarketPlace advertMarketPlace, DeliveryInfoResponse deliveryInfoResponse, Location location) {
        Delivery delivery;
        SimpleAdvertAction simpleAdvertAction = null;
        if (advertMarketPlace == null || (delivery = advertMarketPlace.getDelivery()) == null) {
            return null;
        }
        String text = deliveryInfoResponse != null ? deliveryInfoResponse.getText() : null;
        if (deliveryInfoResponse != null) {
            simpleAdvertAction = deliveryInfoResponse.getAction();
        }
        return new MarketplaceDeliveryItem(0, null, delivery, location, text, simpleAdvertAction, this.B0.getSimilarColumns(), null, null, 387, null);
    }

    public final MarketplaceFaqItem N(AdvertMarketPlace advertMarketPlace) {
        FAQ faq;
        if (advertMarketPlace == null || (faq = advertMarketPlace.getFaq()) == null) {
            return null;
        }
        return new MarketplaceFaqItem(0, null, faq, false, this.B0.getSimilarColumns(), null, null, 107, null);
    }

    public final MarketplaceInfoItem O(AdvertMarketPlace advertMarketPlace) {
        InfoBanner infoBanner;
        if (advertMarketPlace == null || (infoBanner = advertMarketPlace.getInfoBanner()) == null) {
            return null;
        }
        return new MarketplaceInfoItem(0, null, infoBanner, false, this.B0.getSimilarColumns(), null, null, 107, null);
    }

    public final MarketplaceQuantityItem P(AdvertMarketPlace advertMarketPlace) {
        AdvertQuantity quantity;
        if (advertMarketPlace == null || (quantity = advertMarketPlace.getQuantity()) == null) {
            return null;
        }
        return new MarketplaceQuantityItem(0, null, quantity, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final MarketplaceSpecsItem Q(AdvertMarketPlace advertMarketPlace) {
        ModelSpecifications specifications;
        Pair pair;
        if (advertMarketPlace == null || (specifications = advertMarketPlace.getSpecifications()) == null) {
            return null;
        }
        List<ModelSpecifications.Block> blocks = specifications.getBlocks();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = blocks.iterator();
        while (it.hasNext()) {
            h.addAll(arrayList, it.next().getParams());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (Intrinsics.areEqual(((ModelSpecifications.Parameter) next).getImportant(), Boolean.TRUE)) {
                arrayList2.add(next);
            }
        }
        if (((Boolean) this.v0.getValue()).booleanValue()) {
            int size = arrayList2.size() <= 11 ? arrayList2.size() : 10;
            List take = CollectionsKt___CollectionsKt.take(arrayList2, size);
            List<ModelSpecifications.Block> blocks2 = specifications.getBlocks();
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it3 = blocks2.iterator();
            while (it3.hasNext()) {
                h.addAll(arrayList3, it3.next().getParams());
            }
            pair = TuplesKt.to(take, Boolean.valueOf(size != arrayList3.size()));
        } else {
            pair = TuplesKt.to(arrayList2, Boolean.TRUE);
        }
        return new MarketplaceSpecsItem(0, null, this.F0.getMarketplaceSpecsTitle(), specifications, (List) pair.component1(), this.F0.getMarketplaceSpecsButtonTitle(), false, ((Boolean) pair.component2()).booleanValue(), this.B0.getSimilarColumns(), null, null, 1603, null);
    }

    public final AdvertDetailsAutoCatalogItem R(AdvertDetails advertDetails) {
        String str = null;
        if (advertDetails.getAutoCatalogAction() == null) {
            return null;
        }
        String id = advertDetails.getId();
        String str2 = this.w0;
        AdjustParameters adjustParameters = advertDetails.getAdjustParameters();
        if (adjustParameters != null) {
            str = adjustParameters.getMicroCategoryId();
        }
        return new AdvertDetailsAutoCatalogItem(0, null, id, str2, str, advertDetails.getLocationId(), advertDetails.getAutoCatalogAction(), this.B0.getSimilarColumns(), null, null, 771, null);
    }

    public final AdvertDetailsNoteItem S(AdvertDetails advertDetails) {
        return new AdvertDetailsNoteItem(0, null, advertDetails.getNote(), this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final AdvertDetailsPriceItem T(String str, String str2, boolean z2) {
        boolean z3 = true;
        if (str.length() == 0) {
            if (str2.length() != 0) {
                z3 = false;
            }
            if (z3) {
                return null;
            }
        }
        return new AdvertDetailsPriceItem(0, null, str, str2, z2, this.B0.getSimilarColumns(), null, null, 195, null);
    }

    public final PersistableSpannedItem U(AdvertDetails advertDetails, boolean z2) {
        ContactBarData contactBarData;
        Boolean hideDiscountPercent;
        AdvertPrice price = advertDetails.getPrice();
        List<ContactBar.Action> list = null;
        if (price == null) {
            return null;
        }
        if (advertDetails.isMarketplace()) {
            String format = this.C0.format(price);
            String format2 = this.D0.format(price);
            String discountPercentage = price.getDiscountPercentage();
            if (discountPercentage == null) {
                discountPercentage = "";
            }
            AdvertMarketPlace marketplaceData = advertDetails.getMarketplaceData();
            return new AdvertDetailsPriceMarketplaceItem(0, null, format, format2, discountPercentage, z2, (marketplaceData == null || (hideDiscountPercent = marketplaceData.getHideDiscountPercent()) == null) ? false : hideDiscountPercent.booleanValue(), this.B0.getSimilarColumns(), null, null, 771, null);
        } else if (!this.I0.getAdvertPriceWithDiscount().invoke().booleanValue() || price.getValueSigned() == null || price.getValueSignedWithoutDiscount() == null) {
            return T(this.C0.format(price), this.D0.format(price), z2);
        } else {
            String valueSigned = price.getValueSigned();
            Intrinsics.checkNotNull(valueSigned);
            String valueSignedWithoutDiscount = price.getValueSignedWithoutDiscount();
            AdvertDiscounts discounts = advertDetails.getDiscounts();
            if (advertDetails.isActive()) {
                list = this.z0.getActions();
                contactBarData = AdvertDetailsUtilsKt.toContactBarData(advertDetails, "d");
            } else {
                contactBarData = null;
            }
            int similarColumns = this.B0.getSimilarColumns();
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return new PriceWithDiscountItem(0, null, valueSigned, valueSignedWithoutDiscount, discounts, z2, list, contactBarData, similarColumns, null, null, 1539, null);
        }
    }

    public final AdvertDetailsPriceSubscriptionItem V(AdvertDetails advertDetails) {
        boolean z2 = true;
        boolean z3 = this.I0.getPriceSubscriptionInfo().invoke().booleanValue() && CollectionsKt___CollectionsKt.contains(CollectionsKt__CollectionsKt.listOf(new String[]{"4", "23", "24", "25", "26", RoomMasterTable.DEFAULT_ID, "85", "86"}), advertDetails.getCategoryId()) && this.L0.isAuthorized();
        if (z3) {
            this.N0.expose();
        }
        if (!z3 || !this.N0.getTestGroup().isListItem()) {
            z2 = false;
        }
        if (z2) {
            return new AdvertDetailsPriceSubscriptionItem(String.valueOf(3), advertDetails.isFavorite(), this.K0.getAreNotificationsEnabled(), this.B0.getSimilarColumns(), null, null, 48, null);
        }
        return null;
    }

    public final PersistableSpannedItem W(AdvertDetails advertDetails) {
        SafeDeal.Actions actions;
        SafeDeal safeDeal = advertDetails.getSafeDeal();
        boolean z2 = true;
        String str = null;
        if (this.I0.getDeliveryTrustFactorsOnAdvert().invoke().booleanValue()) {
            if (safeDeal == null) {
                return null;
            }
            if (safeDeal.getButton() == null) {
                z2 = false;
            }
            if ((z2 ? safeDeal : null) == null) {
                return null;
            }
            String categoryId = advertDetails.getCategoryId();
            AdvertSeller seller = advertDetails.getSeller();
            return new AdvertDetailsSafeDealButtonItem(0, null, categoryId, seller != null ? seller.getUserHashId() : null, safeDeal, this.p0, this.B0.getSimilarColumns(), null, null, 387, null);
        } else if (safeDeal == null || (actions = safeDeal.getActions()) == null) {
            return null;
        } else {
            if (actions.getBuyButton() == null) {
                z2 = false;
            }
            SafeDeal.Actions actions2 = z2 ? actions : null;
            if (actions2 == null) {
                return null;
            }
            String categoryId2 = advertDetails.getCategoryId();
            AdvertSeller seller2 = advertDetails.getSeller();
            if (seller2 != null) {
                str = seller2.getUserHashId();
            }
            return new AdvertDetailsSafeDealLegacyButtonItem(0, null, categoryId2, str, actions2, this.p0, this.B0.getSimilarColumns(), null, null, 387, null);
        }
    }

    public final AdvertDetailsSafeDealInfoItem X(AdvertDetails advertDetails) {
        SafeDeal safeDeal = advertDetails.getSafeDeal();
        SafeDeal.Info info = safeDeal != null ? safeDeal.getInfo() : null;
        if (info != null) {
            return new AdvertDetailsSafeDealInfoItem(0, null, info, this.B0.getSimilarColumns(), null, null, 51, null);
        }
        return null;
    }

    public final AdvertDetailsSafeDealLabelItem Y(AdvertDetails advertDetails) {
        SafeDeal.Actions actions;
        SafeDeal safeDeal = advertDetails.getSafeDeal();
        if (safeDeal == null || (actions = safeDeal.getActions()) == null) {
            return null;
        }
        SafeDeal.Actions actions2 = !this.I0.getDeliveryTrustFactorsOnAdvert().invoke().booleanValue() && actions.getAboutLabel() != null ? actions : null;
        if (actions2 != null) {
            return new AdvertDetailsSafeDealLabelItem(0, null, advertDetails.getCategoryId(), actions2, this.B0.getSimilarColumns(), null, null, 99, null);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesItem Z(com.avito.android.remote.model.AdvertDetails r13) {
        /*
            r12 = this;
            com.avito.android.remote.model.SafeDeal r13 = r13.getSafeDeal()
            r0 = 0
            if (r13 == 0) goto L_0x0026
            java.util.List r1 = r13.getServices()
            if (r1 == 0) goto L_0x0021
            com.avito.android.Features r1 = r12.I0
            com.avito.android.toggle.Feature r1 = r1.getSellerAdvertCourierAndSafeDealSwitchers()
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r1 == 0) goto L_0x0026
            r6 = r13
            goto L_0x0027
        L_0x0026:
            r6 = r0
        L_0x0027:
            if (r6 == 0) goto L_0x003d
            com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesItem r0 = new com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesItem
            r3 = 0
            r5 = 0
            com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider r13 = r12.B0
            int r7 = r13.getSimilarColumns()
            r8 = 0
            r9 = 0
            r10 = 51
            r11 = 0
            r2 = r0
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11)
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl.Z(com.avito.android.remote.model.AdvertDetails):com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesItem");
    }

    public final void a(int i2, int i3) {
        this.b.add(new AdvertDetailsDividerItem(0, null, i2, i3, this.B0.getSimilarColumns(), null, null, null, 227, null));
    }

    public final AdvertDetailsSafeDealTrustFactorsItem a0(AdvertDetails advertDetails) {
        SafeDeal safeDeal = advertDetails.getSafeDeal();
        if (safeDeal == null) {
            return null;
        }
        SafeDeal safeDeal2 = this.I0.getDeliveryTrustFactorsOnAdvert().invoke().booleanValue() && safeDeal.getAbout() != null ? safeDeal : null;
        if (safeDeal2 != null) {
            return new AdvertDetailsSafeDealTrustFactorsItem(0, null, advertDetails.getCategoryId(), safeDeal2, this.B0.getSimilarColumns(), null, null, 99, null);
        }
        return null;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void attachView(@Nullable AdvertDetailsView advertDetailsView) {
        this.a = advertDetailsView;
    }

    public final void b(int i2, Integer num, Integer num2) {
        List<SpannedItem> list;
        this.o0 = true;
        if (this.I0.getCommercialsOnAdvertisement().invoke().booleanValue()) {
            list = this.A0.convertCommercialBanners(this.b);
        } else {
            list = this.b;
        }
        if (num != null) {
            this.s0 = num;
        }
        if (num2 != null) {
            this.t0 = num2;
        }
        AdvertDetailsView advertDetailsView = this.a;
        if (advertDetailsView != null) {
            advertDetailsView.bindItemsList(list, i2, this.s0, this.t0);
        }
    }

    public final AdvertDetailsSellerProfileItem b0(AdvertDetails advertDetails) {
        if (advertDetails.getSeller() != null) {
            return new AdvertDetailsSellerProfileItem(0, null, this.B0.getSimilarColumns(), null, null, 27, null);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:424:0x082a  */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x083c  */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x085c  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x08fa  */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0838 A[SYNTHETIC] */
    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindAdvertData(@org.jetbrains.annotations.NotNull com.avito.android.advert.AdvertDetailsInteractor.AdvertDetailsWithMeta r38) {
        /*
        // Method dump skipped, instructions count: 2311
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl.bindAdvertData(com.avito.android.advert.AdvertDetailsInteractor$AdvertDetailsWithMeta):void");
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void bindComplementarySection(@NotNull AdvertDetails advertDetails, @NotNull ComplementarySection complementarySection) {
        Integer num;
        T t2;
        int i2;
        PersistableSerpItem bottomCommercial;
        PersistableSerpItem topCommercial;
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(complementarySection, "complementarySection");
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        if ((!this.p0) && (topCommercial = complementarySection.getTopCommercial()) != null) {
            arrayList.add(topCommercial);
        }
        arrayList.addAll(complementarySection.getSimilarItems());
        if ((!this.p0) && (bottomCommercial = complementarySection.getBottomCommercial()) != null) {
            arrayList.add(bottomCommercial);
        }
        Iterator<T> it = this.b.iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof SimilarsLoaderItem) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null) {
            this.c = arrayList;
            i2 = this.b.indexOf(t3);
        } else {
            n0();
            Iterator<PersistableSpannedItem> it2 = this.b.iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                } else if (it2.next() instanceof SimilarsStartMarkerItem) {
                    break;
                } else {
                    i4++;
                }
            }
            this.c = arrayList;
            i2 = i4;
        }
        if (i2 > -1) {
            this.b.remove(i2);
            this.b.addAll(i2, this.c);
            AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem = this.U;
            if (advertDetailsSimilarsButtonItem != null) {
                advertDetailsSimilarsButtonItem.setWithBigTopOffset(complementarySection.getSimilarItems().isEmpty());
            }
            AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem2 = this.U;
            if (advertDetailsSimilarsButtonItem2 != null) {
                m0(advertDetailsSimilarsButtonItem2, complementarySection.getBottomCommercial());
            }
        }
        if (this.o0) {
            if (complementarySection.getTopCommercial() == null) {
                i3 = 0;
            }
            int i5 = i2 + i3;
            PersistableSerpItem topCommercial2 = complementarySection.getTopCommercial();
            Integer valueOf = topCommercial2 != null ? Integer.valueOf(this.b.indexOf(topCommercial2)) : null;
            PersistableSerpItem bottomCommercial2 = complementarySection.getBottomCommercial();
            if (bottomCommercial2 != null) {
                num = Integer.valueOf(this.b.indexOf(bottomCommercial2));
            }
            b(i5, valueOf, num);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void bindCreditBrokerLink(@NotNull DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(calculatorLinkType, "linkType");
        Intrinsics.checkNotNullParameter(str, "monthlyPayment");
        PersistableSpannedItem persistableSpannedItem = this.d;
        if (persistableSpannedItem != null && CollectionsKt___CollectionsKt.contains(this.b, persistableSpannedItem)) {
            int indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends PersistableSpannedItem>) this.b, this.d) + 1;
            if (!(CollectionsKt___CollectionsKt.getOrNull(this.b, indexOf) instanceof CreditBrokerLinkItem)) {
                this.b.add(indexOf, new CreditBrokerLinkItem(calculatorLinkType, str, 0, null, this.B0.getSimilarColumns(), null, null, 108, null));
                b(this.q0, null, null);
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void bindFastAdvertData(@Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams) {
        String str;
        AdvertDetailsGalleryItem E2;
        ArrayList arrayList = new ArrayList();
        if (!((advertDetailsFastOpenParams != null ? advertDetailsFastOpenParams.getImage() : null) == null || (E2 = E(this, t6.n.d.listOf(advertDetailsFastOpenParams.getImage()), null, this.x0, 0, null, 26)) == null)) {
            arrayList.add(E2);
        }
        arrayList.add(F(16));
        if (this.P0) {
            this.R0.expose();
            if (this.R0.getTestGroup().isTest()) {
                arrayList.add(j0(true));
            }
        }
        String str2 = "";
        if (advertDetailsFastOpenParams == null || (str = advertDetailsFastOpenParams.getTitle()) == null) {
            str = str2;
        }
        arrayList.add(l0(str, false));
        if ((advertDetailsFastOpenParams != null ? advertDetailsFastOpenParams.getPrice() : null) != null) {
            String price = advertDetailsFastOpenParams.getPrice();
            String oldPrice = advertDetailsFastOpenParams.getOldPrice();
            if (oldPrice != null) {
                str2 = oldPrice;
            }
            AdvertDetailsPriceItem T2 = T(price, str2, false);
            if (T2 != null) {
                arrayList.add(T2);
            }
        }
        arrayList.add(j0(false));
        AdvertDetailsView advertDetailsView = this.a;
        if (advertDetailsView != null) {
            advertDetailsView.bindItemsList(arrayList, -1, null, null);
        }
    }

    public final int c(boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        SimilarsLoaderItem similarsLoaderItem;
        AdditionalSeller seller;
        AdvertDetailsDomotekaTeaserItem advertDetailsDomotekaTeaserItem;
        AdvertDetailsDescriptionItem advertDetailsDescriptionItem;
        AdvertDetailsDomotekaTeaserItem advertDetailsDomotekaTeaserItem2;
        AdditionalSeller seller2;
        PersistableSpannedItem persistableSpannedItem;
        boolean z5;
        SimilarsLoaderItem similarsLoaderItem2;
        boolean z7 = true;
        if (!this.p0 || !this.I0.getAdvertDetailsMarketplace().invoke().booleanValue()) {
            this.b.clear();
            AdvertDetailsGalleryItem advertDetailsGalleryItem = this.h;
            if (advertDetailsGalleryItem != null) {
                this.b.add(advertDetailsGalleryItem);
            }
            CarouselPhotoGalleryItem carouselPhotoGalleryItem = this.i;
            if (carouselPhotoGalleryItem != null) {
                this.b.add(carouselPhotoGalleryItem);
            }
            this.b.add(F(16));
            AdvertDetailsClosingReasonItem advertDetailsClosingReasonItem = this.T;
            if (advertDetailsClosingReasonItem != null) {
                this.b.add(advertDetailsClosingReasonItem);
            }
            AdvertDetailsTitleItem advertDetailsTitleItem = this.j;
            if (advertDetailsTitleItem != null) {
                this.b.add(advertDetailsTitleItem);
            }
            AdvertDetailsShowDescriptionItem advertDetailsShowDescriptionItem = this.S;
            if (advertDetailsShowDescriptionItem == null || advertDetailsShowDescriptionItem.getDescriptionShown()) {
                z3 = true;
            } else {
                this.b.add(advertDetailsShowDescriptionItem);
                z3 = false;
            }
            if (z3 && (persistableSpannedItem = this.d) != null) {
                this.b.add(persistableSpannedItem);
            }
            AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem = this.e;
            if (advertDetailsPriceSubscriptionItem != null) {
                this.b.add(advertDetailsPriceSubscriptionItem);
            }
            this.b.add(F(10));
            List<AdvertDetailsGeoReferenceItem> list = this.o;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.b.add(it.next());
                }
            }
            AdvertDetailsAddressItem advertDetailsAddressItem = this.p;
            if (advertDetailsAddressItem != null) {
                this.b.add(advertDetailsAddressItem);
            }
            AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem = this.q;
            if (advertDetailsShowOnMapItem != null) {
                this.b.add(advertDetailsShowOnMapItem);
            }
            AdvertBookingItem advertBookingItem = this.j0;
            if (advertBookingItem != null) {
                this.b.add(F(24));
                this.b.add(advertBookingItem);
            }
            SafeShowItem safeShowItem = this.X;
            if (safeShowItem != null) {
                this.b.add(safeShowItem);
                this.b.add(F(16));
            }
            AdvertDetailsSafeDealInfoItem advertDetailsSafeDealInfoItem = this.I;
            if (advertDetailsSafeDealInfoItem != null) {
                this.b.add(advertDetailsSafeDealInfoItem);
            }
            AdvertDetailsDeliveryInfoItem advertDetailsDeliveryInfoItem = this.O;
            if (advertDetailsDeliveryInfoItem != null) {
                this.b.add(advertDetailsDeliveryInfoItem);
            }
            AdvertDetailsSafeDealServicesItem advertDetailsSafeDealServicesItem = this.J;
            if (advertDetailsSafeDealServicesItem != null) {
                this.b.add(advertDetailsSafeDealServicesItem);
                a(0, 0);
            }
            PromoCardItem promoCardItem = this.m0;
            if (promoCardItem != null) {
                a(22, 24);
                this.b.add(promoCardItem);
            }
            AdvertDetailsGeoReportTeaserItem advertDetailsGeoReportTeaserItem = this.n0;
            if (advertDetailsGeoReportTeaserItem != null) {
                this.b.add(advertDetailsGeoReportTeaserItem);
            }
            PersistableSpannedItem persistableSpannedItem2 = this.K;
            if (persistableSpannedItem2 != null) {
                this.b.add(persistableSpannedItem2);
            }
            AdvertDetailsSafeDealLabelItem advertDetailsSafeDealLabelItem = this.L;
            if (advertDetailsSafeDealLabelItem != null) {
                this.b.add(advertDetailsSafeDealLabelItem);
                this.b.add(F(10));
            }
            AdvertDetailsSafeDealTrustFactorsItem advertDetailsSafeDealTrustFactorsItem = this.M;
            if (advertDetailsSafeDealTrustFactorsItem != null) {
                this.b.add(advertDetailsSafeDealTrustFactorsItem);
                this.b.add(F(10));
            }
            AdvertDetailsDeliveryActionsItem advertDetailsDeliveryActionsItem = this.N;
            if (advertDetailsDeliveryActionsItem != null) {
                this.b.add(advertDetailsDeliveryActionsItem);
                this.b.add(F(10));
            }
            AdvertDetailsShortTermRentItem advertDetailsShortTermRentItem = this.Q;
            if (advertDetailsShortTermRentItem != null) {
                this.b.add(advertDetailsShortTermRentItem);
                this.b.add(F(10));
            }
            if (!(this.g == null && this.n == null && this.f == null)) {
                this.b.add(F(this.Q == null ? 24 : 10));
            }
            AdvertBadgeBarItem advertBadgeBarItem = this.g;
            if (advertBadgeBarItem != null) {
                this.b.add(advertBadgeBarItem);
                this.b.add(F(10));
            }
            AdvertVerificationItem advertVerificationItem = this.n;
            if (advertVerificationItem != null) {
                this.b.add(advertVerificationItem);
                this.b.add(F(10));
            }
            AdvertDetailsImvBadgeItem advertDetailsImvBadgeItem = this.f;
            if (advertDetailsImvBadgeItem != null) {
                this.b.add(advertDetailsImvBadgeItem);
                this.b.add(F(10));
            }
            AdvertDetailsNoteItem advertDetailsNoteItem = this.z;
            if (advertDetailsNoteItem != null) {
                this.b.add(advertDetailsNoteItem);
            }
            if (z3) {
                AdvertDetailsFlatsItem advertDetailsFlatsItem = this.s;
                if (advertDetailsFlatsItem != null) {
                    if (advertDetailsFlatsItem.getFlatsTitle() != null && this.X == null) {
                        this.b.add(F(16));
                    }
                    this.b.add(advertDetailsFlatsItem);
                }
                AdvertDetailsAutoCatalogItem advertDetailsAutoCatalogItem = this.A;
                if (advertDetailsAutoCatalogItem != null) {
                    this.b.add(advertDetailsAutoCatalogItem);
                }
                SparePartsItem sparePartsItem = this.t;
                if (sparePartsItem != null && this.I0.getAdvertPartReplacements().invoke().booleanValue()) {
                    this.b.add(sparePartsItem);
                }
                SparePartsItem sparePartsItem2 = this.u;
                if (sparePartsItem2 != null && this.I0.getAdvertCompatibleCars().invoke().booleanValue()) {
                    this.b.add(sparePartsItem2);
                }
            }
            List<AdvertDetailsFeatureTeaserItem> list2 = this.a0;
            if (list2 != null) {
                int i3 = 0;
                for (T t2 : list2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t3 = t2;
                    if (i3 == 0) {
                        a(22, 22);
                    }
                    this.b.add(t3);
                    a(22, 22);
                    i3 = i4;
                }
            }
            AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem = this.Z;
            if (advertDetailsFeatureTeaserItem != null) {
                if (Collections.isNullOrEmpty(this.a0)) {
                    a(22, 22);
                }
                this.b.add(advertDetailsFeatureTeaserItem);
                a(22, 22);
            }
            AdvertDetailsGroupsItem advertDetailsGroupsItem = this.r;
            if (advertDetailsGroupsItem != null) {
                this.b.add(advertDetailsGroupsItem);
            }
            CarMarketPriceChartItem carMarketPriceChartItem = this.l0;
            if (carMarketPriceChartItem != null) {
                a(22, 22);
                this.b.add(carMarketPriceChartItem);
                if (this.k0 == null) {
                    a(22, 22);
                }
                z4 = true;
            } else {
                z4 = false;
            }
            CarMarketPriceDescriptionItem carMarketPriceDescriptionItem = this.k0;
            if (carMarketPriceDescriptionItem != null) {
                if (this.l0 == null) {
                    a(22, 22);
                } else {
                    this.b.add(F(24));
                }
                this.b.add(carMarketPriceDescriptionItem);
                a(22, 22);
                z4 = true;
            }
            AdvertDetailsAutotekaItem advertDetailsAutotekaItem = this.w;
            if (advertDetailsAutotekaItem != null) {
                advertDetailsAutotekaItem.setNeedToShowTopDivider(!z4);
                this.b.add(advertDetailsAutotekaItem);
            }
            AdvertDetailsAutotekaTeaserItem advertDetailsAutotekaTeaserItem = this.x;
            if (advertDetailsAutotekaTeaserItem != null) {
                advertDetailsAutotekaTeaserItem.setNeedToShowTopDivider(!z4);
                this.b.add(advertDetailsAutotekaTeaserItem);
            }
            AdvertDetailsAutodealItem advertDetailsAutodealItem = this.y;
            if (advertDetailsAutodealItem != null) {
                this.b.add(advertDetailsAutodealItem);
            }
            AdditionalSellerItem additionalSellerItem = this.E;
            if (!(additionalSellerItem == null || (seller2 = additionalSellerItem.getSeller()) == null || seller2.getShowAfterDescription())) {
                List<PersistableSpannedItem> list3 = this.b;
                AdditionalSellerItem additionalSellerItem2 = this.E;
                Intrinsics.checkNotNull(additionalSellerItem2);
                list3.add(additionalSellerItem2);
                a(24, 0);
                this.b.add(F(4));
            }
            AdvertDetailsFlatsItem advertDetailsFlatsItem2 = this.s;
            AttributedText attributedText = null;
            if (!((advertDetailsFlatsItem2 != null ? advertDetailsFlatsItem2.getFlatsTitle() : null) == null || (advertDetailsDomotekaTeaserItem2 = this.W) == null)) {
                this.b.add(F(10));
                this.b.add(advertDetailsDomotekaTeaserItem2);
            }
            boolean z8 = (this.y == null && this.w == null) ? false : true;
            if (z3 && (advertDetailsDescriptionItem = this.l) != null) {
                advertDetailsDescriptionItem.setShowDivider(z8);
                this.b.add(advertDetailsDescriptionItem);
            }
            AdvertDetailsFlatsItem advertDetailsFlatsItem3 = this.s;
            if (advertDetailsFlatsItem3 != null) {
                attributedText = advertDetailsFlatsItem3.getFlatsTitle();
            }
            if (attributedText == null && (advertDetailsDomotekaTeaserItem = this.W) != null) {
                this.b.add(advertDetailsDomotekaTeaserItem);
            }
            AdditionalSellerItem additionalSellerItem3 = this.E;
            if (!(additionalSellerItem3 == null || (seller = additionalSellerItem3.getSeller()) == null || !seller.getShowAfterDescription())) {
                this.b.add(F(24));
                List<PersistableSpannedItem> list4 = this.b;
                AdditionalSellerItem additionalSellerItem4 = this.E;
                Intrinsics.checkNotNull(additionalSellerItem4);
                list4.add(additionalSellerItem4);
            }
            AdvertDetailsIceBreakersItem advertDetailsIceBreakersItem = this.Y;
            if (advertDetailsIceBreakersItem != null) {
                if (CollectionsKt___CollectionsKt.last((List<? extends Object>) this.b) instanceof AdditionalSellerItem) {
                    a(24, 0);
                }
                this.b.add(advertDetailsIceBreakersItem);
            }
            AdvertDetailsCreditInfoItem advertDetailsCreditInfoItem = this.B;
            if (advertDetailsCreditInfoItem != null) {
                this.b.add(advertDetailsCreditInfoItem);
            }
            AdvertDetailsGuideItem advertDetailsGuideItem = this.m;
            if (advertDetailsGuideItem != null) {
                this.b.add(advertDetailsGuideItem);
            }
            AdvertDetailsSellerProfileItem advertDetailsSellerProfileItem = this.C;
            if (advertDetailsSellerProfileItem != null) {
                this.b.add(F(24));
                this.b.add(advertDetailsSellerProfileItem);
            }
            AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem = this.D;
            if (advertDetailsSellerSubscriptionItem != null) {
                this.b.add(F(10));
                this.b.add(advertDetailsSellerSubscriptionItem);
            }
            AdvertDetailsRatingPublishItem advertDetailsRatingPublishItem = this.V;
            if (advertDetailsRatingPublishItem != null) {
                this.b.add(F(10));
                this.b.add(advertDetailsRatingPublishItem);
            }
            AdvertDetailsContactBarItem advertDetailsContactBarItem = this.R;
            if (advertDetailsContactBarItem != null) {
                this.b.add(F(24));
                this.b.add(advertDetailsContactBarItem);
                if (!advertDetailsContactBarItem.isNotContactAccess() || advertDetailsContactBarItem.isEmptyOfflineStatus()) {
                    this.b.add(F(8));
                } else {
                    a(24, 4);
                }
            }
            AdvertDetailsDisclaimerItem advertDetailsDisclaimerItem = this.k;
            if (advertDetailsDisclaimerItem != null) {
                this.b.add(advertDetailsDisclaimerItem);
            }
            AdvertDetailsAnonymousNumberItem advertDetailsAnonymousNumberItem = this.F;
            if (advertDetailsAnonymousNumberItem != null) {
                this.b.add(F(24));
                this.b.add(advertDetailsAnonymousNumberItem);
            }
            AdvertDetailsConsultationItem advertDetailsConsultationItem = this.P;
            if (advertDetailsConsultationItem != null) {
                this.b.add(F(24));
                this.b.add(advertDetailsConsultationItem);
            }
            i2 = this.b.size();
            if (z2 && (similarsLoaderItem = this.v) != null) {
                this.b.add(similarsLoaderItem);
            }
            AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem = this.U;
            if (advertDetailsSimilarsButtonItem != null) {
                this.b.add(advertDetailsSimilarsButtonItem);
            }
            AdvertDetailsAbuseItem advertDetailsAbuseItem = this.H;
            if (advertDetailsAbuseItem != null) {
                this.b.add(advertDetailsAbuseItem);
            }
            AdvertDetailsAdvertNumberItem advertDetailsAdvertNumberItem = this.G;
            if (advertDetailsAdvertNumberItem != null) {
                this.b.add(advertDetailsAdvertNumberItem);
            }
            this.b.add(F(16));
        } else {
            this.b.clear();
            AdvertDetailsGalleryItem advertDetailsGalleryItem2 = this.h;
            if (advertDetailsGalleryItem2 != null) {
                this.b.add(advertDetailsGalleryItem2);
            }
            this.b.add(F(16));
            MarketplaceBadgeBarItem marketplaceBadgeBarItem = this.g0;
            if (marketplaceBadgeBarItem != null) {
                this.b.add(marketplaceBadgeBarItem);
            }
            AdvertDetailsTitleItem advertDetailsTitleItem2 = this.j;
            if (advertDetailsTitleItem2 != null) {
                this.b.add(advertDetailsTitleItem2);
            }
            PersistableSpannedItem persistableSpannedItem3 = this.d;
            if (persistableSpannedItem3 != null) {
                this.b.add(persistableSpannedItem3);
            }
            MarketplaceBriefSpecsItem marketplaceBriefSpecsItem = this.c0;
            if (marketplaceBriefSpecsItem != null) {
                this.b.add(marketplaceBriefSpecsItem);
            }
            MarketplaceQuantityItem marketplaceQuantityItem = this.h0;
            if (marketplaceQuantityItem != null) {
                a(16, 16);
                this.b.add(marketplaceQuantityItem);
            }
            AdvertDetailsShowDescriptionItem advertDetailsShowDescriptionItem2 = this.S;
            if (advertDetailsShowDescriptionItem2 == null || advertDetailsShowDescriptionItem2.getDescriptionShown()) {
                z5 = true;
            } else {
                this.b.add(F(10));
                this.b.add(advertDetailsShowDescriptionItem2);
                z5 = false;
            }
            if (z5) {
                MarketplaceDeliveryItem marketplaceDeliveryItem = this.e0;
                if (marketplaceDeliveryItem != null) {
                    this.b.add(marketplaceDeliveryItem);
                }
                AdvertDetailsNoteItem advertDetailsNoteItem2 = this.z;
                if (advertDetailsNoteItem2 != null) {
                    this.b.add(F(8));
                    this.b.add(advertDetailsNoteItem2);
                }
                MarketplaceInfoItem marketplaceInfoItem = this.d0;
                if (marketplaceInfoItem != null) {
                    this.b.add(marketplaceInfoItem);
                }
                MarketplaceSpecsItem marketplaceSpecsItem = this.b0;
                if (marketplaceSpecsItem != null) {
                    this.b.add(marketplaceSpecsItem);
                }
                this.b.add(F(11));
                if (this.u == null || !this.I0.getAdvertCompatibleCars().invoke().booleanValue()) {
                    z7 = false;
                }
                AdvertDetailsDescriptionItem advertDetailsDescriptionItem2 = this.l;
                if (advertDetailsDescriptionItem2 != null) {
                    if (((Boolean) this.v0.getValue()).booleanValue()) {
                        this.b.add(F(10));
                        this.b.add(new AdvertDetailsHeaderItem(this.G0.generateId(), null, this.F0.getDescriptionTitle(), this.B0.getSimilarColumns(), null, null, 50, null));
                    }
                    this.b.add(advertDetailsDescriptionItem2);
                    if (!z7) {
                        a(22, 0);
                    }
                }
                SparePartsItem sparePartsItem3 = this.u;
                if (sparePartsItem3 != null && this.I0.getAdvertCompatibleCars().invoke().booleanValue()) {
                    this.b.add(sparePartsItem3);
                    a(8, 0);
                }
                MarketplaceFaqItem marketplaceFaqItem = this.f0;
                if (marketplaceFaqItem != null) {
                    this.b.add(marketplaceFaqItem);
                }
                AdvertDetailsSellerProfileItem advertDetailsSellerProfileItem2 = this.C;
                if (advertDetailsSellerProfileItem2 != null) {
                    this.b.add(F(32));
                    this.b.add(advertDetailsSellerProfileItem2);
                }
                MarketplaceContactBarItem marketplaceContactBarItem = this.i0;
                if (marketplaceContactBarItem != null) {
                    this.b.add(F(10));
                    this.b.add(marketplaceContactBarItem);
                }
                AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem2 = this.D;
                if (advertDetailsSellerSubscriptionItem2 != null) {
                    this.b.add(F(10));
                    this.b.add(advertDetailsSellerSubscriptionItem2);
                }
                AdvertDetailsContactBarItem advertDetailsContactBarItem2 = this.R;
                if (advertDetailsContactBarItem2 != null) {
                    this.b.add(F(24));
                    this.b.add(advertDetailsContactBarItem2);
                    this.b.add(F(8));
                }
            }
            i2 = this.b.size();
            if (z2 && (similarsLoaderItem2 = this.v) != null) {
                this.b.add(similarsLoaderItem2);
            }
            AdvertDetailsAbuseItem advertDetailsAbuseItem2 = this.H;
            if (advertDetailsAbuseItem2 != null) {
                this.b.add(advertDetailsAbuseItem2);
            }
            AdvertDetailsAdvertNumberItem advertDetailsAdvertNumberItem2 = this.G;
            if (advertDetailsAdvertNumberItem2 != null) {
                this.b.add(advertDetailsAdvertNumberItem2);
            }
            this.b.add(F(16));
        }
        return i2;
    }

    public final AdvertDetailsSellerSubscriptionItem c0(AdvertDetails advertDetails) {
        String userKey;
        SellerSubscriptionInfo subscriptionInfo;
        SellerSubscriptionState sellerSubscriptionState;
        AdvertSeller seller = advertDetails.getSeller();
        SellerNotificationsState sellerNotificationsState = null;
        if (seller == null || (userKey = seller.getUserKey()) == null || (subscriptionInfo = seller.getSubscriptionInfo()) == null) {
            return null;
        }
        int similarColumns = this.B0.getSimilarColumns();
        Boolean isSubscribed = subscriptionInfo.isSubscribed();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(isSubscribed, bool)) {
            sellerSubscriptionState = SellerSubscriptionState.UNSUBSCRIBED;
        } else {
            sellerSubscriptionState = SellerSubscriptionState.SUBSCRIBED;
        }
        Boolean isNotificationsActivated = subscriptionInfo.isNotificationsActivated();
        if (isNotificationsActivated != null) {
            if (Intrinsics.areEqual(isNotificationsActivated, Boolean.TRUE)) {
                sellerNotificationsState = SellerNotificationsState.ACTIVATED;
            } else if (Intrinsics.areEqual(isNotificationsActivated, bool)) {
                sellerNotificationsState = SellerNotificationsState.DEACTIVATED;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new AdvertDetailsSellerSubscriptionItem(similarColumns, userKey, sellerSubscriptionState, sellerNotificationsState);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void clearItems() {
        this.b.clear();
        this.c.clear();
        this.o0 = false;
    }

    public final AdvertDetailsAbuseItem d() {
        return new AdvertDetailsAbuseItem(0, null, this.B0.getSimilarColumns(), null, null, 27, null);
    }

    public final AdvertDetailsShortTermRentItem d0(AdvertDetails advertDetails) {
        AdvertShortTermRent shortTermRent = advertDetails.getShortTermRent();
        if ((shortTermRent != null ? shortTermRent.getActions() : null) != null) {
            return new AdvertDetailsShortTermRentItem(0, null, shortTermRent, this.B0.getSimilarColumns(), null, null, 51, null);
        }
        return null;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void detachView() {
        n0();
        this.u0.clear();
        this.a = null;
    }

    public final AdditionalSellerItem e(AdditionalSeller additionalSeller) {
        if (!this.I0.getAdditionalSellerItemSupport().invoke().booleanValue() || additionalSeller == null) {
            return null;
        }
        return new AdditionalSellerItem(0, null, this.B0.getSimilarColumns(), null, null, additionalSeller, 27, null);
    }

    public final AdvertDetailsShowDescriptionItem e0() {
        return new AdvertDetailsShowDescriptionItem(false, this.p0, 0, null, this.B0.getSimilarColumns(), null, null, 109, null);
    }

    public final AdvertDetailsAddressItem f(AdvertDetails advertDetails) {
        String addressParam = advertDetails.getAddressParam();
        if (addressParam == null) {
            addressParam = "";
        }
        if (advertDetails.hasCoordinates()) {
            if (addressParam.length() > 0) {
                return new AdvertDetailsAddressItem(0, null, addressParam, advertDetails.advertCoordinates(), advertDetails.advertTitle(), !Collections.isNullOrEmpty(advertDetails.getGeoReferences()), advertDetails.getShouldShowMapPreview(), this.B0.getSimilarColumns(), null, null, 771, null);
            }
        }
        return null;
    }

    public final AdvertDetailsShowOnMapItem f0(AdvertDetails advertDetails) {
        String addressParam = advertDetails.getAddressParam();
        if (addressParam == null) {
            addressParam = "";
        }
        if (advertDetails.hasCoordinates()) {
            String addressParam2 = advertDetails.getAddressParam();
            boolean z2 = false;
            if (addressParam2 != null) {
                if (addressParam2.length() > 0) {
                    z2 = true;
                }
            }
            if (z2 && advertDetails.getShouldShowMapPreview()) {
                return new AdvertDetailsShowOnMapItem(String.valueOf(7), advertDetails.advertTitle(), advertDetails.advertCoordinates(), addressParam, this.B0.getSimilarColumns(), null, null, 96, null);
            }
        }
        return null;
    }

    public final AdvertDetailsAdvertNumberItem g(AdvertDetails advertDetails) {
        String str;
        AdvertStats stats = advertDetails.getStats();
        if (stats == null || !stats.hasCounters()) {
            str = null;
        } else {
            Integer total = stats.getTotal();
            Intrinsics.checkNotNull(total);
            str = this.F0.getAdvertStatsPlurals(total.intValue());
        }
        return new AdvertDetailsAdvertNumberItem(0, null, this.F0.getAdvertNumberFormatted(advertDetails.getId(), Long.valueOf(advertDetails.getTime())), str, this.B0.getSimilarColumns(), null, null, 99, null);
    }

    public final SafeShowItem g0(AdvertDetails advertDetails) {
        SafeShow safeShow;
        AdvertDetailsFeaturesTeasers teasers = advertDetails.getTeasers();
        if (teasers == null || (safeShow = teasers.getSafeShow()) == null) {
            return null;
        }
        return new SafeShowItem(0, null, null, null, this.B0.getSimilarColumns(), this.x0, safeShow.getTeaserTitle(), safeShow.getBottomSheetInfo().getText(), safeShow.getBottomSheetInfo().getTitle(), this.z0.getActions(), AdvertDetailsUtilsKt.toContactBarData(advertDetails, "o"), safeShow.getBottomSheetInfo().getContactButtonText(), 15, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsHolder
    public int getItemPosition(@NotNull PersistableSpannedItem persistableSpannedItem) {
        Intrinsics.checkNotNullParameter(persistableSpannedItem, "item");
        return this.b.indexOf(persistableSpannedItem);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsHolder
    @NotNull
    public <T extends PersistableSpannedItem> List<T> getItemsWithType(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return j.filterIsInstance(this.b, cls);
    }

    public final AdvertDetailsAnonymousNumberItem h(AnonymousNumber anonymousNumber) {
        if (anonymousNumber == null || !anonymousNumber.isValidContent()) {
            return null;
        }
        return new AdvertDetailsAnonymousNumberItem(0, null, anonymousNumber, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final AdvertDetailsSimilarsButtonItem h0(SimpleAdvertAction simpleAdvertAction) {
        if (simpleAdvertAction == null) {
            return null;
        }
        return new AdvertDetailsSimilarsButtonItem(simpleAdvertAction.getTitle(), simpleAdvertAction.getDeepLink(), false, 0, null, this.B0.getSimilarColumns(), null, null, 220, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public boolean hasComplementaryItems() {
        return this.A0.isComplementaryValid();
    }

    public final AdvertDetailsAutodealItem i(AutoDeal autoDeal) {
        if (autoDeal != null) {
            return new AdvertDetailsAutodealItem(0, null, autoDeal, this.B0.getSimilarColumns(), null, null, 51, null);
        }
        return null;
    }

    public final SimilarsLoaderItem i0() {
        return new SimilarsLoaderItem(0, null, this.B0.getSimilarColumns(), null, null, 27, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public boolean isComplementaryLoaded() {
        return this.A0.isSimilarsLoaded() && this.A0.isCommercialsLoaded();
    }

    public final AdvertDetailsAutotekaItem j() {
        return new AdvertDetailsAutotekaItem(0, null, this.B0.getSimilarColumns(), null, null, false, 59, null);
    }

    public final AdvertDetailsSkeletonItem j0(boolean z2) {
        return new AdvertDetailsSkeletonItem(0, null, z2, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final AdvertDetailsAutotekaTeaserItem k() {
        return new AdvertDetailsAutotekaTeaserItem(0, null, this.B0.getSimilarColumns(), null, null, false, 59, null);
    }

    public final SparePartsItem k0(SparePartsParameters sparePartsParameters, SparePartsItemType sparePartsItemType, boolean z2) {
        if (z2 || sparePartsParameters == null) {
            return null;
        }
        return new SparePartsItem(0, null, sparePartsItemType, sparePartsParameters, this.B0.getSimilarColumns(), null, null, 99, null);
    }

    public final AdvertBadgeBarItem l(AdvertDetails advertDetails) {
        BadgeBarOrientation badgeBarOrientation;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        AdvertBadgeBarParams view;
        AdvertBadgeBarParams view2;
        String str2;
        UniversalImage icon;
        AdvertBadgeBarParams view3;
        AdvertBadgeBar badgeBar = advertDetails.getBadgeBar();
        String str3 = null;
        List<AdvertBadge> badges = badgeBar != null ? badgeBar.getBadges() : null;
        if (!this.I0.getBadgeBarOnAdvert().invoke().booleanValue() || Collections.isNullOrEmpty(badges)) {
            return null;
        }
        AdvertBadgeBar badgeBar2 = advertDetails.getBadgeBar();
        if (badgeBar2 == null || (view3 = badgeBar2.getView()) == null || (badgeBarOrientation = view3.getDisplay()) == null) {
            badgeBarOrientation = BadgeBarOrientation.VERTICAL;
        }
        boolean z2 = badgeBarOrientation == BadgeBarOrientation.VERTICAL;
        if (badges != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(badges, 10));
            for (T t2 : badges) {
                String valueOf = String.valueOf(t2.getId());
                int id = t2.getId();
                String title = t2.getTitle();
                String description = t2.getDescription();
                if (description != null) {
                    str2 = description;
                } else {
                    str2 = "";
                }
                AdvertBadgeStyle style = t2.getStyle();
                UniversalColor backgroundColor = style != null ? style.getBackgroundColor() : null;
                AdvertBadgeStyle style2 = t2.getStyle();
                UniversalColor backgroundPressedColor = style2 != null ? style2.getBackgroundPressedColor() : null;
                AdvertBadgeStyle style3 = t2.getStyle();
                UniversalColor fontColor = style3 != null ? style3.getFontColor() : null;
                AdvertBadgeStyle style4 = t2.getStyle();
                arrayList.add(new BadgeItem(valueOf, id, title, str2, backgroundColor, backgroundPressedColor, fontColor, z2 ? Integer.MAX_VALUE : 1, z2 ? Integer.MAX_VALUE : 1, (style4 == null || (icon = style4.getIcon()) == null) ? null : icon.getImage(), t2.getUri()));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            arrayList2 = arrayList;
        } else {
            arrayList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        String id2 = advertDetails.getId();
        AdvertBadgeBar badgeBar3 = advertDetails.getBadgeBar();
        Integer preloadCount = (badgeBar3 == null || (view2 = badgeBar3.getView()) == null) ? null : view2.getPreloadCount();
        if (!z2) {
            preloadCount = null;
        }
        int intValue = preloadCount != null ? preloadCount.intValue() : arrayList2.size();
        AdvertBadgeBar badgeBar4 = advertDetails.getBadgeBar();
        if (!(badgeBar4 == null || (view = badgeBar4.getView()) == null)) {
            str3 = view.getShowMoreTitle();
        }
        if (str3 != null) {
            str = str3;
        } else {
            str = "";
        }
        return new AdvertBadgeBarItem(0, null, id2, arrayList2, badgeBarOrientation, intValue, str, false, this.B0.getSimilarColumns(), null, null, 1667, null);
    }

    public final AdvertDetailsTitleItem l0(String str, boolean z2) {
        return new AdvertDetailsTitleItem(0, null, str, z2, this.B0.getSimilarColumns(), null, null, 99, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void legacyBindComplementaryItems(@NotNull AdvertDetails advertDetails, @NotNull List<? extends PersistableSpannedItem> list) {
        T t2;
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(list, "similarsItems");
        if (this.c.isEmpty()) {
            this.c = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            Iterator<T> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2 instanceof SimilarsLoaderItem) {
                    break;
                }
            }
            T t3 = t2;
            if (t3 != null) {
                int indexOf = this.b.indexOf(t3);
                if (indexOf > -1) {
                    this.b.remove(indexOf);
                }
                AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem = this.U;
                if (advertDetailsSimilarsButtonItem != null) {
                    advertDetailsSimilarsButtonItem.setWithBigTopOffset(list.isEmpty());
                }
                if (!list.isEmpty()) {
                    this.b.addAll(indexOf, list);
                }
                if (this.o0) {
                    b(indexOf, null, null);
                }
            }
        }
    }

    public final AdvertBookingItem m(AdvertDetails advertDetails) {
        Booking booking = advertDetails.getBooking();
        if (booking == null) {
            return null;
        }
        if (!Intrinsics.areEqual(advertDetails.getCategoryId(), AdvertDetailsPresenterKt.AUTO_CATEGORY_ID) || !(!this.I0.getAdvertAutoBookingBlock().invoke().booleanValue())) {
            return new AdvertBookingItem(0, null, booking, this.B0.getSimilarColumns(), null, null, 51, null);
        }
        return null;
    }

    public final void m0(AdvertDetailsSimilarsButtonItem advertDetailsSimilarsButtonItem, SpannedItem spannedItem) {
        if (spannedItem != null && CollectionsKt___CollectionsKt.contains(this.b, spannedItem)) {
            this.b.remove(advertDetailsSimilarsButtonItem);
            this.b.add(CollectionsKt___CollectionsKt.indexOf((List<? extends SpannedItem>) this.b, spannedItem), advertDetailsSimilarsButtonItem);
        }
    }

    public final CarMarketPriceChartItem n(AdvertDetails advertDetails) {
        PriceRanges priceRanges;
        CarMarketPrice carMarketPrice = advertDetails.getCarMarketPrice();
        if (carMarketPrice == null || (priceRanges = carMarketPrice.getPriceRanges()) == null || (!this.I0.getMarketPriceRangesChartBlock().invoke().booleanValue())) {
            return null;
        }
        return new CarMarketPriceChartItem(0, null, priceRanges, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final void n0() {
        if (this.I0.getCommercialsOnAdvertisement().invoke().booleanValue() || (!this.c.isEmpty())) {
            h.removeAll((List) this.b, (Function1) b.a);
            Iterator<T> it = this.c.iterator();
            while (it.hasNext()) {
                this.b.remove(it.next());
            }
            int size = this.b.size();
            int i2 = this.q0;
            if (i2 >= 0 && size > i2) {
                this.b.add(i2, new SimilarsStartMarkerItem(0, null, 0, 7, null));
            }
        }
    }

    public final CarMarketPriceDescriptionItem o(AdvertDetails advertDetails) {
        PriceDescription priceDescription;
        CarMarketPrice carMarketPrice = advertDetails.getCarMarketPrice();
        if (carMarketPrice == null || (priceDescription = carMarketPrice.getPriceDescription()) == null || (!this.I0.getMarketPriceDescriptionBlock().invoke().booleanValue())) {
            return null;
        }
        return new CarMarketPriceDescriptionItem(0, null, priceDescription, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:933:0x09bf */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v175 */
    /* JADX WARN: Type inference failed for: r15v176 */
    /* JADX WARN: Type inference failed for: r15v177, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o0(com.avito.android.advert.AdvertDetailsInteractor.AdvertDetailsWithMeta r14, int r15) {
        /*
        // Method dump skipped, instructions count: 2513
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl.o0(com.avito.android.advert.AdvertDetailsInteractor$AdvertDetailsWithMeta, int):void");
    }

    @Override // com.avito.android.photo_gallery.common.GalleryPageListener
    public void onPageSelected(int i2, long j2) {
        T t2;
        T t3;
        boolean z2;
        AdvertDetailsGalleryItem advertDetailsGalleryItem = this.h;
        if (advertDetailsGalleryItem != null) {
            advertDetailsGalleryItem.setCurrentPosition(i2);
        }
        CarouselPhotoGalleryItem carouselPhotoGalleryItem = this.i;
        if (carouselPhotoGalleryItem != null) {
            carouselPhotoGalleryItem.setCurrentPosition(i2);
        }
        Iterator<T> it = this.b.iterator();
        while (true) {
            t2 = null;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            T t4 = t3;
            if (!(t4 instanceof AdvertDetailsGalleryItem) || t4.getStateId() != j2) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t3 instanceof AdvertDetailsGalleryItem) {
            t2 = t3;
        }
        T t5 = t2;
        if (t5 != null) {
            t5.setCurrentPosition(i2);
        }
    }

    @Override // com.avito.android.section.expand_sections_button.ExpandComplementarySectionsListener
    public void onSectionsExpandClicked() {
        T t2;
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof ExpandSectionsButtonItem) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null) {
            int indexOf = this.b.indexOf(t3);
            this.b.remove(t3);
            this.b.addAll(indexOf, t3.getCollapsedSections());
            this.c.remove(t3);
            this.c.addAll(t3.getCollapsedSections());
            this.A0.expandSections();
            this.H0.sendSimilarsShowMoreClick();
            b(this.q0, null, null);
        }
    }

    public final CarouselPhotoGalleryItem p(List<Image> list, Video video, int i2, ForegroundImage foregroundImage) {
        if (Collections.isNullOrEmpty(list) && video == null && foregroundImage == null) {
            return null;
        }
        return new CarouselPhotoGalleryItem(0, null, list, video, i2, this.G0.generateId(), foregroundImage, this.B0.getSimilarColumns(), null, null, 771, null);
    }

    public final PersistableSpannedItem p0(Function0<? extends PersistableSpannedItem> function0) {
        T t2;
        T t3;
        T t4;
        Iterator<T> it = this.b.iterator();
        while (true) {
            t2 = null;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (t3 instanceof AdvertDetailsPriceItem) {
                break;
            }
        }
        T t5 = t3;
        if (t5 != null) {
            return t5;
        }
        Iterator<T> it2 = this.b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t4 = null;
                break;
            }
            t4 = it2.next();
            if (t4 instanceof PriceWithDiscountItem) {
                break;
            }
        }
        T t7 = t4;
        if (t7 != null) {
            return t7;
        }
        Iterator<T> it3 = this.b.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            T next = it3.next();
            if (next instanceof AdvertDetailsPriceMarketplaceItem) {
                t2 = next;
                break;
            }
        }
        T t8 = t2;
        if (t8 != null) {
            return t8;
        }
        return (PersistableSpannedItem) function0.invoke();
    }

    public final PersistableSpannedItem q0(Function0<? extends PersistableSpannedItem> function0) {
        T t2;
        T t3;
        Iterator<T> it = this.b.iterator();
        while (true) {
            t2 = null;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (t3 instanceof AdvertDetailsSafeDealLegacyButtonItem) {
                break;
            }
        }
        T t4 = t3;
        if (t4 != null) {
            return t4;
        }
        Iterator<T> it2 = this.b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (next instanceof AdvertDetailsSafeDealButtonItem) {
                t2 = next;
                break;
            }
        }
        T t5 = t2;
        if (t5 != null) {
            return t5;
        }
        return (PersistableSpannedItem) ((c) function0).invoke();
    }

    public final AdvertDetailsFeatureTeaserItem r(AdvertDetails advertDetails) {
        AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter = this.O0;
        AdvertDetailsFeaturesTeasers teasers = advertDetails.getTeasers();
        return advertDetailsFeatureTeaserItemsAdapter.createItem(teasers != null ? teasers.getCheckedByAvito() : null, this.B0.getSimilarColumns(), (long) 47);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void refreshAdvertData() {
        int c2 = c(false);
        this.q0 = c2;
        b(c2, null, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void restoreState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.o0 = false;
        List parcelableList = Bundles.getParcelableList(bundle, "advertItems");
        if (parcelableList != null) {
            this.b = CollectionsKt___CollectionsKt.toMutableList((Collection) parcelableList);
        }
        Kundle kundle = Bundles.getKundle(bundle, "complementaryItems");
        if (kundle != null) {
            this.A0.onRestoreState(kundle);
        }
        Kundle kundle2 = Bundles.getKundle(bundle, "sellerSubscriptionPresenter");
        if (kundle2 != null) {
            this.J0.onRestoreState(kundle2);
        }
        this.G0.restore(bundle.getLong("idProvider"));
        this.r0 = bundle.getInt("prevColumns", 0);
    }

    public final AdvertDetailsClosingReasonItem s(String str) {
        if (str == null) {
            return null;
        }
        return new AdvertDetailsClosingReasonItem(str, 0, null, this.B0.getSimilarColumns(), null, null, 54, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    @NotNull
    public Bundle saveState() {
        n0();
        Bundle bundle = new Bundle();
        Bundles.putParcelableList(bundle, "advertItems", this.b);
        Bundles.putKundle(bundle, "complementaryItems", this.A0.onSaveState());
        bundle.putLong("idProvider", this.G0.generateId());
        bundle.putInt("prevColumns", this.r0);
        Bundles.putKundle(bundle, "sellerSubscriptionPresenter", this.J0.onSaveState());
        return bundle;
    }

    public final AdvertDetailsConsultationItem t(AdvertDetails advertDetails) {
        if (!this.I0.getConsultationBlockOnItem().invoke().booleanValue() || !advertDetails.getShouldShowDevelopmentsAdvice()) {
            return null;
        }
        return new AdvertDetailsConsultationItem(0, null, this.B0.getSimilarColumns(), null, null, 27, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void updateMarketplaceDeliveryInfoItem(@Nullable AdvertMarketPlace advertMarketPlace, @Nullable DeliveryInfoResponse deliveryInfoResponse) {
        MarketplaceDeliveryItem marketplaceDeliveryItem;
        int indexOf;
        if (advertMarketPlace != null && (marketplaceDeliveryItem = this.e0) != null && (indexOf = this.b.indexOf(marketplaceDeliveryItem)) >= 0) {
            PersistableSpannedItem remove = this.b.remove(indexOf);
            Objects.requireNonNull(remove, "null cannot be cast to non-null type com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem");
            MarketplaceDeliveryItem M2 = M(advertMarketPlace, deliveryInfoResponse, ((MarketplaceDeliveryItem) remove).getLocationTo());
            if (M2 != null) {
                this.e0 = M2;
                this.b.add(indexOf, M2);
                AdvertDetailsView advertDetailsView = this.a;
                if (advertDetailsView != null) {
                    advertDetailsView.updateMarketplaceDeliveryInfoItem(M2);
                }
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsItemsPresenter
    public void updateSelectedLocation(@Nullable Location location) {
        MarketplaceDeliveryItem marketplaceDeliveryItem;
        int indexOf;
        if (location != null && (marketplaceDeliveryItem = this.e0) != null && (indexOf = this.b.indexOf(marketplaceDeliveryItem)) >= 0) {
            MarketplaceDeliveryItem marketplaceDeliveryItem2 = this.e0;
            if (!Intrinsics.areEqual(location, marketplaceDeliveryItem2 != null ? marketplaceDeliveryItem2.getLocationTo() : null)) {
                this.H0.trackDeliveryLocationChanged(this.x0, location.getId());
            }
            MarketplaceDeliveryItem marketplaceDeliveryItem3 = this.e0;
            if (marketplaceDeliveryItem3 != null) {
                marketplaceDeliveryItem3.setLocationTo(location);
            }
            PersistableSpannedItem persistableSpannedItem = this.b.get(indexOf);
            Objects.requireNonNull(persistableSpannedItem, "null cannot be cast to non-null type com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem");
            ((MarketplaceDeliveryItem) persistableSpannedItem).setLocationTo(location);
        }
    }

    public final AdvertDetailsGeoReportTeaserItem v(AdvertDetails advertDetails) {
        CREGeoReportTeaser geoReportTeaser;
        if (this.I0.getGeoMarketReportInAdvertDetailsV2().invoke().booleanValue() && (geoReportTeaser = advertDetails.getGeoReportTeaser()) != null) {
            return new AdvertDetailsGeoReportTeaserItem(null, null, String.valueOf(71), this.B0.getSimilarColumns(), this.x0, geoReportTeaser.getTitle(), geoReportTeaser.getInsights(), geoReportTeaser.getActions(), 3, null);
        }
        return null;
    }

    public final AdvertDetailsCreditInfoItem w() {
        return new AdvertDetailsCreditInfoItem(0, null, false, this.B0.getSimilarColumns(), null, null, 55, null);
    }

    public final AdvertDetailsDeliveryInfoItem x(AdvertDetails advertDetails) {
        AdvertDeliveryC2C delivery = advertDetails.getDelivery();
        if ((delivery != null ? delivery.getInfo() : null) == null) {
            if ((delivery != null ? delivery.getSwitcher() : null) == null) {
                return null;
            }
        }
        return new AdvertDetailsDeliveryInfoItem(0, null, delivery, this.B0.getSimilarColumns(), null, null, 51, null);
    }

    public final AdvertDetailsDeliveryActionsItem y(AdvertDetails advertDetails) {
        AdvertDeliveryC2C delivery = advertDetails.getDelivery();
        if ((delivery != null ? delivery.getActions() : null) != null) {
            return new AdvertDetailsDeliveryActionsItem(0, null, advertDetails.getCategoryId(), delivery, this.B0.getSimilarColumns(), null, null, 99, null);
        }
        return null;
    }

    public final AdvertDetailsDescriptionItem z(String str, HtmlCharSequence htmlCharSequence, String str2, boolean z2) {
        HtmlCharSequence htmlCharSequence2;
        if (AvitoTextUtils.isNullOrEmpty(str)) {
            if (AvitoTextUtils.isNullOrEmpty(htmlCharSequence != null ? htmlCharSequence.toString() : null)) {
                return null;
            }
        }
        if (htmlCharSequence != null) {
            htmlCharSequence2 = htmlCharSequence;
        } else {
            htmlCharSequence2 = str != null ? new HtmlCharSequence(new SpannableString(str)) : null;
        }
        return new AdvertDetailsDescriptionItem(0, null, str2, htmlCharSequence2, false, null, 0, z2, this.B0.getSimilarColumns(), null, null, 1651, null);
    }
}
