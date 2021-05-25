package com.avito.android.advert_core.analytics;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.abuse.AbuseClickTreeEvent;
import com.avito.android.advert_core.analytics.additional_seller.AdditionalSellerPhoneButtonClick;
import com.avito.android.advert_core.analytics.address.AddressClickTreeEvent;
import com.avito.android.advert_core.analytics.address.AddressLongClickTreeEvent;
import com.avito.android.advert_core.analytics.address.GeoFromBlock;
import com.avito.android.advert_core.analytics.apartment_feature.AdvertDetailsApartmentFeatureEvent;
import com.avito.android.advert_core.analytics.autoteka.AdvertDetailsAutotekaClickTreeEvent;
import com.avito.android.advert_core.analytics.autoteka.ClickAutoDealTreeEvent;
import com.avito.android.advert_core.analytics.badge_bar.AdvertBadgeBarExpandClickEvent;
import com.avito.android.advert_core.analytics.badge_bar.AdvertBadgeClickEvent;
import com.avito.android.advert_core.analytics.broker.BankData;
import com.avito.android.advert_core.analytics.broker.CalculatorType;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.analytics.cart.MarketplaceBuyButtonClickEvent;
import com.avito.android.advert_core.analytics.checked_by_avito.AdvertDetailsCheckedByAvitoEvent;
import com.avito.android.advert_core.analytics.closed_advert.AdvertDetailsLoadEvent;
import com.avito.android.advert_core.analytics.closed_advert.AdvertDetailsLoadEventKt;
import com.avito.android.advert_core.analytics.closed_advert.AdvertSimilarsClickEvent;
import com.avito.android.advert_core.analytics.closed_advert.ClosedAdvertShowDescriptionEvent;
import com.avito.android.advert_core.analytics.consultation_form.ConsultationItemButtonClickEvent;
import com.avito.android.advert_core.analytics.contactbar.WriteToSellerDisabledEvent;
import com.avito.android.advert_core.analytics.creditinfo.ClickCreditBannerInfoTreeEvent;
import com.avito.android.advert_core.analytics.delivery.DeliveryButtonItemClickTreeEvent;
import com.avito.android.advert_core.analytics.delivery.DeliveryInfoClickTreeEvent;
import com.avito.android.advert_core.analytics.delivery.SafeDealBuyButtonClickEvent;
import com.avito.android.advert_core.analytics.description.DescriptionCopyTextTreeEvent;
import com.avito.android.advert_core.analytics.description.DescriptionExpandExistTreeEvent;
import com.avito.android.advert_core.analytics.description.ExpandDescriptionTreeEvent;
import com.avito.android.advert_core.analytics.domoteka_teaser.DomotekaFlatNumberRequestEvent;
import com.avito.android.advert_core.analytics.domoteka_teaser.DomotekaStubButtonClickEvent;
import com.avito.android.advert_core.analytics.domoteka_teaser.DomotekaTeaserButtonClickEvent;
import com.avito.android.advert_core.analytics.flats_groups.DevelopmentsCatalogClickEvent;
import com.avito.android.advert_core.analytics.flats_groups.FlatsClickTreeEvent;
import com.avito.android.advert_core.analytics.flats_groups.GroupsClickTreeEvent;
import com.avito.android.advert_core.analytics.gallery.GalleryEmbeddedSwipeEvent;
import com.avito.android.advert_core.analytics.gallery.GalleryShowFullscreenEvent;
import com.avito.android.advert_core.analytics.gallery.GalleryVideoEvent;
import com.avito.android.advert_core.analytics.geo_market_report.BuyGeoReportClicked;
import com.avito.android.advert_core.analytics.geo_market_report.ShowExampleClicked;
import com.avito.android.advert_core.analytics.guide.AdvertDetailsGuideClickEvent;
import com.avito.android.advert_core.analytics.guide.FromGuideBlock;
import com.avito.android.advert_core.analytics.icebreakers.ClickIcebreakersEvent;
import com.avito.android.advert_core.analytics.icebreakers.ShowIcebreakersEvent;
import com.avito.android.advert_core.analytics.marketplace.ChangeDeliveryLocationClickEvent;
import com.avito.android.advert_core.analytics.marketplace.FAQButtonClickEvent;
import com.avito.android.advert_core.analytics.marketplace.InStockInfoClickEvent;
import com.avito.android.advert_core.analytics.marketplace.InfoBannerClickEvent;
import com.avito.android.advert_core.analytics.modelspecs.ClickModelSpecificationsButton;
import com.avito.android.advert_core.analytics.modelspecs.ClickModelSpecificationsButtonTreeEvent;
import com.avito.android.advert_core.analytics.modelspecs.ShowModelSpecificationsButton;
import com.avito.android.advert_core.analytics.modelspecs.ShowModelSpecificationsButtonTreeEvent;
import com.avito.android.advert_core.analytics.price_subscription.SubscribePriceChangesClickEvent;
import com.avito.android.advert_core.analytics.price_subscription.TurnOnNotificationsClickEvent;
import com.avito.android.advert_core.analytics.price_subscription.UnsubscribePriceChangesClickEvent;
import com.avito.android.advert_core.analytics.questionnaire.AnswerClickEvent;
import com.avito.android.advert_core.analytics.questionnaire.QuestionCloseEvent;
import com.avito.android.advert_core.analytics.questionnaire.QuestionRenderEvent;
import com.avito.android.advert_core.analytics.safeshow.SafeShowDialogContactsButtonClickedEvent;
import com.avito.android.advert_core.analytics.safeshow.SafeShowItemClickedEvent;
import com.avito.android.advert_core.analytics.sellerprofile.CallDeveloperButtonClickEvent;
import com.avito.android.advert_core.analytics.sellerprofile.ShowDeveloperPageEvent;
import com.avito.android.advert_core.analytics.sellerprofile.ShowSellersProfileTreeEvent;
import com.avito.android.advert_core.analytics.shorttermrent.StrSafedealBookingButtonTreeEvent;
import com.avito.android.advert_core.analytics.similars.ClickSimilarItemFavoritesAction;
import com.avito.android.advert_core.analytics.similars.ClickSimilarItemFavoritesTreeEvent;
import com.avito.android.advert_core.analytics.similars.ClickSimilarItemTreeEvent;
import com.avito.android.advert_core.analytics.similars.ShowSimilarsTreeEvent;
import com.avito.android.advert_core.analytics.similars.SimilarsShowMoreEvent;
import com.avito.android.advert_core.analytics.toolbar.ActionWithNoteTreeEvent;
import com.avito.android.advert_core.analytics.toolbar.AdvertDetailsShowScreenEvent;
import com.avito.android.advert_core.analytics.toolbar.BackFromPage;
import com.avito.android.advert_core.analytics.toolbar.BackPressAdvertTreeEvent;
import com.avito.android.advert_core.analytics.toolbar.ClickNoteTreeEvent;
import com.avito.android.advert_core.analytics.toolbar.NoteAction;
import com.avito.android.advert_core.analytics.toolbar.ShowAdvertTreeEvent;
import com.avito.android.advert_core.contactbar.SourceScreen;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerClickStreamEvent;
import com.avito.android.analytics.event.WriteToSellerTreeEvent;
import com.avito.android.analytics.event.cart.OpenCartEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.autoteka_details.core.analytics.event.AutotekaDetailsGetReportClickTreeEvent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdjustParameters;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import com.avito.android.util.Kundle;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.UUIDRandomKeyProvider;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BS\b\u0007\u0012\b\u0010ü\u0001\u001a\u00030ù\u0001\u0012\u0007\u0010\u0002\u001a\u00020\u0002\u0012\u0007\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010Þ\u0001\u001a\u00030Û\u0001\u0012\b\u0010ë\u0001\u001a\u00030è\u0001\u0012\f\b\u0001\u0010á\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010ö\u0001\u001a\u00030ó\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ'\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\bJ\u001f\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J1\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\bJ\u0017\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\bJ\u001f\u00101\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010\u0012J'\u00103\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0019H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\bJ\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\bJ\u0017\u00107\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\bJ\u0017\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b8\u0010\bJ)\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b<\u0010=J)\u0010@\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\bJ\u001f\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\bJ\u001f\u0010I\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\tH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bK\u0010\bJ\u001f\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bO\u0010\bJ\u0017\u0010P\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bP\u0010\fJ\u001f\u0010R\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010Q\u001a\u00020>H\u0016¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\tH\u0016¢\u0006\u0004\bU\u0010JJ'\u0010W\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u00020V2\u0006\u0010T\u001a\u00020\tH\u0016¢\u0006\u0004\bW\u0010XJ!\u0010Z\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bZ\u0010\u0012J7\u0010]\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u0019H\u0016¢\u0006\u0004\b]\u0010^JK\u0010a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u00192\b\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010`\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\ba\u0010bJ+\u0010c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bc\u0010dJ+\u0010e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\be\u0010dJ\u0017\u0010f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bf\u0010\fJ\u0017\u0010g\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bg\u0010\fJ\u0017\u0010h\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bh\u0010\fJ\u0017\u0010i\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bi\u0010\bJ\u001f\u0010l\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bl\u0010mJ)\u0010o\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010n\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\bo\u0010pJ\u001f\u0010q\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bq\u0010mJ\u0017\u0010r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\br\u0010\bJ\u001f\u0010s\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\bs\u0010\u0012J\u0017\u0010t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bt\u0010\fJ\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010u\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bu\u0010\fJ\u0017\u0010v\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bv\u0010\fJ\u0017\u0010w\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bw\u0010\fJ\u0017\u0010x\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\bx\u0010\fJ=\u0010z\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bz\u0010{J\u001f\u0010}\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010|\u001a\u00020\u0019H\u0016¢\u0006\u0004\b}\u0010\u001cJ\u0017\u0010~\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b~\u0010\fJ\u0017\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\fJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u000eJ\"\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010JJ\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010\fJ4\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020>2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J-\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020>H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0016\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010\fJ\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0005\b\u0001\u0010\fJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u000eJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u000eJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u000eJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\u000eJ#\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020>2\u0006\u0010+\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020>2\u0006\u0010+\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010 \u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020>2\u0006\u0010+\u001a\u00020\tH\u0016¢\u0006\u0006\b \u0001\u0010\u0001J$\u0010¢\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0005\b¢\u0001\u0010\u0012J\u0019\u0010£\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0005\b£\u0001\u0010\fJ\u0019\u0010¤\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0005\b¤\u0001\u0010\fJ#\u0010¥\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\b\u0010y\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0005\b¥\u0001\u0010\u0012J:\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t2\t\u0010#\u001a\u0005\u0018\u00010¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010>2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001c\u0010¬\u0001\u001a\u00020\u00062\b\u0010«\u0001\u001a\u00030ª\u0001H\u0016¢\u0006\u0006\b¬\u0001\u0010­\u0001J\u0012\u0010®\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\b®\u0001\u0010\u000eJP\u0010²\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0007\u0010¯\u0001\u001a\u00020\u00192\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b²\u0001\u0010³\u0001Ja\u0010¶\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001JO\u0010¸\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\u0006\u0010?\u001a\u00020>2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b¸\u0001\u0010¹\u0001J'\u0010º\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\bº\u0001\u0010»\u0001J'\u0010¼\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b¼\u0001\u0010»\u0001J'\u0010½\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b½\u0001\u0010»\u0001J\u0012\u0010¾\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\b¾\u0001\u0010\u000eJ$\u0010Á\u0001\u001a\u00020\u00062\u000f\u0010À\u0001\u001a\n\u0012\u0005\u0012\u00030¿\u00010\u0001H\u0001¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u0012\u0010Ã\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÃ\u0001\u0010\u000eJ\u0012\u0010Ä\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÄ\u0001\u0010\u000eJ\u0012\u0010Å\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÅ\u0001\u0010\u000eJ4\u0010È\u0001\u001a\u00020\u00062\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¿\u00012\b\u0010#\u001a\u0004\u0018\u00010\t2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u001f\u0010Ê\u0001\u001a\u00020\u00062\n\u0010Æ\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0001¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u0014\u0010Í\u0001\u001a\u00030Ì\u0001H\u0001¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0012\u0010Ï\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÏ\u0001\u0010\u000eJ\u0012\u0010Ð\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÐ\u0001\u0010\u000eJ.\u0010Ô\u0001\u001a\u00020\u00062\u0007\u0010Ñ\u0001\u001a\u00020>2\u0007\u0010Ò\u0001\u001a\u00020>2\u0007\u0010Ó\u0001\u001a\u00020>H\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0012\u0010Ö\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\bÖ\u0001\u0010\u000eJ\u0012\u0010×\u0001\u001a\u00020\u0006H\u0001¢\u0006\u0005\b×\u0001\u0010\u000eR\u001b\u0010Ú\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u001a\u0010Þ\u0001\u001a\u00030Û\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u001c\u0010á\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0018\u0010ã\u0001\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010\u001eR\u001a\u0010ç\u0001\u001a\u00030ä\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010ï\u0001\u001a\u00030ì\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u0019\u0010ò\u0001\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001a\u0010ö\u0001\u001a\u00030ó\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u0018\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001a\u0010ü\u0001\u001a\u00030ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R$\u0010\u0002\u001a\u0005\u0018\u00010ý\u00018\u0016@\u0016X\u000f¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0002\u0010\u0002¨\u0006\u0002"}, d2 = {"Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractorImpl;", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "setAdvertDetails", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", "context", "setSearchContext", "(Ljava/lang/String;)V", "sendEnterScreen", "()V", BookingInfoActivity.EXTRA_ITEM_ID, "itemAppearanceUuid", "sendShowScreenEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "sendLoadAdvertEvent", "url", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "sendAutotekaTeaserButtonClick", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "", "isBlocked", "sendLoadAdvertErrorEvent", "(Ljava/lang/String;Z)V", "getRequestId", "()Ljava/lang/String;", "sendShowAdvert", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "Lcom/avito/android/advert_core/contactbar/SourceScreen;", "source", "sendClickCall", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Lcom/avito/android/advert_core/contactbar/SourceScreen;)V", "disabled", "sendClickWrite", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;ZLcom/avito/android/advert_core/contactbar/SourceScreen;Ljava/lang/String;)V", "fromActionBar", "Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "fromPage", "sendBackClick", "(Ljava/lang/String;ZLcom/avito/android/advert_core/analytics/toolbar/BackFromPage;)V", "sendDescriptionExpand", "sendDescriptionCopyText", "pageType", "sendShowModelSpecificationButton", "isMarketplace", "sendModelSpecificationsClick", "(Ljava/lang/String;Ljava/lang/String;Z)V", "sendGalleryEmbeddedSwipe", "sendGalleryShowFullscreen", "sendVideoClick", "sendClickNote", "Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;", "action", "noteText", "sendNoteAction", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;Ljava/lang/String;)V", "", VKApiConst.POSITION, "sendShowSimilars", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;I)V", "sendDescriptionExpandExist", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "geoFromBlock", "sendAddressClick", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;)V", "sendAddressLongClick", "itemName", "sendFlatsClick", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;)V", "sendGroupsClick", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "sendShowSellersProfile", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;)V", "sendShowAbuse", "sendBadgeBarExpandButtonClicked", "badgeId", "sendBadgeClicked", "(Ljava/lang/String;I)V", "targetItemId", "sendClickSimilarItem", "Lcom/avito/android/advert_core/analytics/similars/ClickSimilarItemFavoritesAction;", "sendClickSimilarFavorites", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/similars/ClickSimilarItemFavoritesAction;Ljava/lang/String;)V", "categoryId", "sendDeliveryInfoClick", ChannelContext.Item.USER_ID, "isUserAuth", "sendDeliveryButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "safeDealServices", "searchContext", "sendSafeDealBuyButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "sendMarketplaceBuyButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendCartBuyButtonClick", "sendInfoBannerClick", "sendFAQButtonClick", "sendInStockInfoClick", "sendAutoDealClick", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "sendCreditBannerLoaded", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/remote/model/AdvertDetails;)V", CommonKt.TAG_ERROR_CODE, "sendCreditBannerLoadingFailed", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/Integer;)V", "sendCreditBannerClick", "sendCreditBannerInfoClick", "sendShortTermRentButtonClick", "sendAutotekaButtonClick", "sendSafeShowItemClicked", "sendSafeShowDialogContactsButtonClicked", "sendSimilarsButtonClick", "sendClosedAdvertShowDescription", "locationId", "sendCommercialBannerClick", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "subscribe", "sendClickToPriceSubscription", "sendClickToEnableNotifications", "sendClickToConsultationItemButton", "sendClickToCallDeveloper", "developmentsId", "sendDevelopmentsCatalogClick", "sendAdditionalSellerPhoneButtonClick", "title", "pos", "", "icebreakerIds", "sendShowIcebreakersBlock", "(Ljava/lang/String;ILjava/util/List;)V", "icebreakerId", "sendClickOnIcebreaker", "(Ljava/lang/String;II)V", "iid", "Lcom/avito/android/advert_core/analytics/guide/FromGuideBlock;", "sendClickGuide", "(Ljava/lang/String;Lcom/avito/android/advert_core/analytics/guide/FromGuideBlock;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "sendClickAdditionalInfoFromCheckedByAvito", "sendClickAdditionalInfoFromApartmentFeature", "sendSimilarsShowMoreClick", "sendDomotekaFlatNumberRequestClick", "sendDomotekaTeaserButtonClick", "sendDomotekaStubButtonClick", "questionId", "sendQuestionAppear", "(ILjava/lang/String;)V", "answerId", "sendAnswerClick", "(IILjava/lang/String;)V", "sendQuestionClose", "developerId", "sendShowDeveloperPage", "trackBuyGeoReportEvent", "trackShowGeoReportExampleEvent", "trackDeliveryLocationChanged", "Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "cartItemsQuantity", "sendOpenCartEvent", "(Ljava/lang/String;Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/ParametrizedEvent;", "event", "sendParametrizedEvent", "(Lcom/avito/android/remote/model/ParametrizedEvent;)V", "returnToScreen", "samplingEnabled", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "bannerType", "sendBannerLoaded", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/serp/analytics/BannerEvent$Type;)V", "", "throwable", "sendBannerLoadingFailed", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerPassback", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerRequested", "sendBannerView", "onChatOpened", "Lcom/avito/android/advert_core/analytics/broker/BankData;", "banksData", "onCreditComplete", "(Ljava/util/List;)V", "onFormCreditData", "onFormPassport", "onFormWork", "bankData", "requestId", "onOfferAccept", "(Lcom/avito/android/advert_core/analytics/broker/BankData;Ljava/lang/String;Ljava/lang/String;)V", "onOfferClick", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "sendCreditCalculatorLinkClick", "sendCreditCalculatorRender", "amount", "payment", FirebaseAnalytics.Param.TERM, "sendCreditCalculatorSubmit", "(III)V", "sendCreditCalculatorValueChanged", "sendCreditCalculatorView", "c", "Ljava/lang/String;", "requestUuid", "Lcom/avito/android/account/AccountStateProvider;", g.a, "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "i", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "getSession", SessionContract.SESSION, "", AuthSource.SEND_ABUSE, "J", "stateId", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "h", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/util/UUIDRandomKeyProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/UUIDRandomKeyProvider;", "uuidProvider", "d", "Z", "isDescriptionExpandExistAlreadySent", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "getCalculatorType", "()Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "setCalculatorType", "(Lcom/avito/android/advert_core/analytics/broker/CalculatorType;)V", "calculatorType", "commercialsAnalyticsInteractor", "creditBrokerAnalyticsInteractor", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/Features;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAnalyticsInteractorImpl implements AdvertDetailsAnalyticsInteractor, CommercialBannersAnalyticsInteractor, CreditBrokerAnalyticsInteractor {
    public long a;
    public final UUIDRandomKeyProvider b = new UUIDRandomKeyProvider();
    public String c;
    public boolean d;
    public AdvertDetails e;
    public final Analytics f;
    public final AccountStateProvider g;
    public final TreeStateIdGenerator h;
    public TreeClickStreamParent i;
    public final Features j;
    public final /* synthetic */ CommercialBannersAnalyticsInteractor k;
    public final /* synthetic */ CreditBrokerAnalyticsInteractor l;

    @Inject
    public AdvertDetailsAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @NotNull CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull TreeStateIdGenerator treeStateIdGenerator, @InitialTreeParent @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(creditBrokerAnalyticsInteractor, "creditBrokerAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        this.k = commercialBannersAnalyticsInteractor;
        this.l = creditBrokerAnalyticsInteractor;
        this.f = analytics;
        this.g = accountStateProvider;
        this.h = treeStateIdGenerator;
        this.i = treeClickStreamParent;
        this.j = features;
        this.a = treeStateIdGenerator.nextStateId();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @Nullable
    public CalculatorType getCalculatorType() {
        return this.l.getCalculatorType();
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.a, ScreenIdField.ADVERT_DETAILS.name(), null, null);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    @Nullable
    public String getRequestId() {
        return this.c;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider
    @NotNull
    public String getSession() {
        return this.l.getSession();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onChatOpened() {
        this.l.onChatOpened();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onCreditComplete(@NotNull List<BankData> list) {
        Intrinsics.checkNotNullParameter(list, "banksData");
        this.l.onCreditComplete(list);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormCreditData() {
        this.l.onFormCreditData();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormPassport() {
        this.l.onFormPassport();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormWork() {
        this.l.onFormWork();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferAccept(@Nullable BankData bankData, @Nullable String str, @Nullable String str2) {
        this.l.onOfferAccept(bankData, str, str2);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferClick(@Nullable BankData bankData) {
        this.l.onOfferClick(bankData);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @NotNull
    public Kundle onSaveState() {
        return this.l.onSaveState();
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void returnToScreen() {
        this.k.returnToScreen();
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAdditionalSellerPhoneButtonClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdditionalSellerPhoneButtonClick(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAddressClick(@NotNull AdvertDetails advertDetails, @NotNull GeoFromBlock geoFromBlock) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(geoFromBlock, "geoFromBlock");
        if (this.j.getAdvertDetailsAddressClickClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AddressClickTreeEvent(this.i, advertDetails, geoFromBlock));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAddressLongClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AddressLongClickTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAnswerClick(int i2, int i3, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fromPage");
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String categoryId = advertDetails.getCategoryId();
        AdvertDetails advertDetails2 = this.e;
        if (advertDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String locationId = advertDetails2.getLocationId();
        AdvertDetails advertDetails3 = this.e;
        if (advertDetails3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new AnswerClickEvent(i2, i3, categoryId, locationId, advertDetails3.getId(), str, this.h.nextStateId(), getParent()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAutoDealClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickAutoDealTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAutotekaButtonClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AdvertDetailsAutotekaClickTreeEvent(this.i, str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAutotekaTeaserButtonClick(@NotNull String str, @NotNull String str2, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AutotekaDetailsGetReportClickTreeEvent(this.i, str, str2, fromBlock));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendBackClick(@NotNull String str, boolean z, @NotNull BackFromPage backFromPage) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(backFromPage, "fromPage");
        this.f.track(new BackPressAdvertTreeEvent(this.h.nextStateId(), this.i, str, z, backFromPage));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendBadgeBarExpandButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertBadgeBarExpandClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendBadgeClicked(@NotNull String str, int i2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertBadgeClickEvent(str, i2));
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerLoaded(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerLoaded(bannerInfo, str, str2, str3, z, type);
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerLoadingFailed(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable Throwable th, @Nullable String str3, @Nullable Integer num, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerLoadingFailed(bannerInfo, str, str2, th, str3, num, type);
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerOpened(@NotNull BannerInfo bannerInfo, int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerOpened(bannerInfo, i2, str, str2, str3, type);
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerPassback(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerPassback(bannerInfo, type);
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerRequested(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerRequested(bannerInfo, type);
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerView(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        this.k.sendBannerView(bannerInfo, type);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCartBuyButtonClick(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new MarketplaceBuyButtonClickEvent(str, this.g.getCurrentUserId(), str2, "item", Boolean.valueOf(this.g.isAuthorized()), AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE, str3, null, true));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickAdditionalInfoFromApartmentFeature(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertDetailsApartmentFeatureEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickAdditionalInfoFromCheckedByAvito(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertDetailsCheckedByAvitoEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickCall(@NotNull ContactBarData contactBarData, @NotNull SourceScreen sourceScreen) {
        Intrinsics.checkNotNullParameter(contactBarData, "data");
        Intrinsics.checkNotNullParameter(sourceScreen, "source");
        this.f.track(CallToSellerClickStreamEvent.Companion.createTreeEvent(this.i, contactBarData.getAdvertId(), contactBarData.getCategoryId(), contactBarData.isFromCompany(), contactBarData.getMetroId(), contactBarData.getUserHashId(), contactBarData.getLocationId(), contactBarData.getShopId(), sourceScreen.getValue()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickGuide(@NotNull String str, @NotNull FromGuideBlock fromGuideBlock) {
        Intrinsics.checkNotNullParameter(str, "iid");
        Intrinsics.checkNotNullParameter(fromGuideBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.f.track(new AdvertDetailsGuideClickEvent(str, fromGuideBlock));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickNote(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickNoteTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickOnIcebreaker(@NotNull String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String id = advertDetails.getId();
        AdvertDetails advertDetails2 = this.e;
        if (advertDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String categoryId = advertDetails2.getCategoryId();
        AdvertDetails advertDetails3 = this.e;
        if (advertDetails3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        AdjustParameters adjustParameters = advertDetails3.getAdjustParameters();
        analytics.track(new ClickIcebreakersEvent(id, categoryId, adjustParameters != null ? adjustParameters.getMicroCategoryId() : null, str, i2, i3));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickSimilarFavorites(@NotNull AdvertDetails advertDetails, @NotNull ClickSimilarItemFavoritesAction clickSimilarItemFavoritesAction, @NotNull String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(clickSimilarItemFavoritesAction, "action");
        Intrinsics.checkNotNullParameter(str, "targetItemId");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickSimilarItemFavoritesTreeEvent(this.i, advertDetails, clickSimilarItemFavoritesAction, str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickSimilarItem(@NotNull AdvertDetails advertDetails, @NotNull String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(str, "targetItemId");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickSimilarItemTreeEvent(this.i, advertDetails, str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickToCallDeveloper() {
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new CallDeveloperButtonClickEvent(advertDetails.getId()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickToConsultationItemButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new ConsultationItemButtonClickEvent(str, null, 2, null));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickToEnableNotifications(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new TurnOnNotificationsClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickToPriceSubscription(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (z) {
            this.f.track(new SubscribePriceChangesClickEvent(str));
        } else {
            this.f.track(new UnsubscribePriceChangesClickEvent(str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClickWrite(@NotNull ContactBarData contactBarData, boolean z, @NotNull SourceScreen sourceScreen, @Nullable String str) {
        Intrinsics.checkNotNullParameter(contactBarData, "data");
        Intrinsics.checkNotNullParameter(sourceScreen, "source");
        if (z) {
            this.f.track(new WriteToSellerDisabledEvent(contactBarData.getAdvertId()));
        } else {
            this.f.track(new WriteToSellerTreeEvent(this.h.nextStateId(), this.i, contactBarData.getAdvertId(), contactBarData.getCategoryId(), contactBarData.isFromCompany(), contactBarData.getMetroId(), contactBarData.getUserHashId(), contactBarData.getLocationId(), contactBarData.getShopId(), contactBarData.getSource(), sourceScreen.getValue(), str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendClosedAdvertShowDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new ClosedAdvertShowDescriptionEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCommercialBannerClick(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, int i2) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        sendBannerOpened(bannerInfo, i2, str2, str3, str, BannerEvent.Type.DEFAULT);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCreditBannerClick(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        sendBannerOpened(bannerInfo, 0, advertDetails.getCategoryId(), advertDetails.getLocationId(), advertDetails.getId(), BannerEvent.Type.CREDIT);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCreditBannerInfoClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickCreditBannerInfoTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCreditBannerLoaded(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        sendBannerLoaded(bannerInfo, advertDetails.getCategoryId(), advertDetails.getLocationId(), advertDetails.getId(), false, BannerEvent.Type.CREDIT);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendCreditBannerLoadingFailed(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerLoadingFailed$default(this, bannerInfo, advertDetails.getCategoryId(), advertDetails.getLocationId(), null, advertDetails.getId(), num, BannerEvent.Type.CREDIT, 8, null);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorLinkClick() {
        this.l.sendCreditCalculatorLinkClick();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorRender() {
        this.l.sendCreditCalculatorRender();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorSubmit(int i2, int i3, int i4) {
        this.l.sendCreditCalculatorSubmit(i2, i3, i4);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorValueChanged() {
        this.l.sendCreditCalculatorValueChanged();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorView() {
        this.l.sendCreditCalculatorView();
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDeliveryButtonClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        a.b1(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, ChannelContext.Item.USER_ID, str3, "categoryId", str4, "source");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new DeliveryButtonItemClickTreeEvent(this.i, str, str2, str3, str4, z));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDeliveryInfoClick(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new DeliveryInfoClickTreeEvent(this.i, str, str2));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDescriptionCopyText(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new DescriptionCopyTextTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDescriptionExpand(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ExpandDescriptionTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDescriptionExpandExist(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue() && (!this.d)) {
            this.d = true;
            this.f.track(new DescriptionExpandExistTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDevelopmentsCatalogClick(@NotNull AdvertDetails advertDetails, @NotNull String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(str, "developmentsId");
        this.f.track(new DevelopmentsCatalogClickEvent(advertDetails, str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDomotekaFlatNumberRequestClick() {
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new DomotekaFlatNumberRequestEvent(advertDetails.getId()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDomotekaStubButtonClick() {
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new DomotekaStubButtonClickEvent(advertDetails.getId()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendDomotekaTeaserButtonClick() {
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new DomotekaTeaserButtonClickEvent(advertDetails.getId()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendEnterScreen() {
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.c = this.b.generateKey();
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendFAQButtonClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new FAQButtonClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendFlatsClick(@NotNull AdvertDetails advertDetails, @NotNull String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(str, "itemName");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new FlatsClickTreeEvent(this.i, advertDetails, str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendGalleryEmbeddedSwipe(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new GalleryEmbeddedSwipeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendGalleryShowFullscreen(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new GalleryShowFullscreenEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendGroupsClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new GroupsClickTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendInStockInfoClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new InStockInfoClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendInfoBannerClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new InfoBannerClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendLoadAdvertErrorEvent(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertDetailsLoadEvent(str, z ? "success" : AdvertDetailsLoadEventKt.NETWORK_ERROR, z ? "blocked" : null));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendLoadAdvertEvent(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.f.track(new AdvertDetailsLoadEvent(advertDetails.getId(), "success", advertDetails.isActive() ? "active" : "closed"));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendMarketplaceBuyButtonClick(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new MarketplaceBuyButtonClickEvent(str, this.g.getCurrentUserId(), str2, "item", Boolean.valueOf(this.g.isAuthorized()), AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE, str3, Boolean.TRUE, false));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendModelSpecificationsClick(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "pageType");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ClickModelSpecificationsButtonTreeEvent(this.i, str, str2, z));
        } else {
            this.f.track(new ClickModelSpecificationsButton(str, str2, z));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendNoteAction(@NotNull AdvertDetails advertDetails, @NotNull NoteAction noteAction, @Nullable String str) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(noteAction, "action");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ActionWithNoteTreeEvent(this.i, advertDetails, noteAction, str));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendOpenCartEvent(@NotNull String str, @Nullable OpenCartEvent.Source source, @Nullable Integer num, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new OpenCartEvent(str, source, num, new SearchContextWrapper(str2)));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendParametrizedEvent(@NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(parametrizedEvent, "event");
        Analytics analytics = this.f;
        int id = parametrizedEvent.getId();
        int version = parametrizedEvent.getVersion();
        Map<String, String> parameters = parametrizedEvent.getParameters();
        if (parameters == null) {
            parameters = r.emptyMap();
        }
        analytics.track(new ParametrizedClickStreamEvent(id, version, parameters, null, 8, null));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendQuestionAppear(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fromPage");
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String categoryId = advertDetails.getCategoryId();
        AdvertDetails advertDetails2 = this.e;
        if (advertDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String locationId = advertDetails2.getLocationId();
        AdvertDetails advertDetails3 = this.e;
        if (advertDetails3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new QuestionRenderEvent(i2, categoryId, locationId, advertDetails3.getId(), str, this.h.nextStateId(), getParent()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendQuestionClose(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fromPage");
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String categoryId = advertDetails.getCategoryId();
        AdvertDetails advertDetails2 = this.e;
        if (advertDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String locationId = advertDetails2.getLocationId();
        AdvertDetails advertDetails3 = this.e;
        if (advertDetails3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new QuestionCloseEvent(i2, categoryId, locationId, advertDetails3.getId(), str, this.h.nextStateId(), getParent()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendSafeDealBuyButtonClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable String str5, @Nullable String str6) {
        a.b1(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, ChannelContext.Item.USER_ID, str3, "categoryId", str4, "source");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new SafeDealBuyButtonClickEvent(str, str2, str3, str4, z, str5, str6, false));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendSafeShowDialogContactsButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new SafeShowDialogContactsButtonClickedEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendSafeShowItemClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new SafeShowItemClickedEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShortTermRentButtonClick(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new StrSafedealBookingButtonTreeEvent(this.i, str, str2));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowAbuse(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AbuseClickTreeEvent(this.i, advertDetails));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowAdvert(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.a = this.h.nextStateId();
        if (advertDetails.isActive()) {
            this.f.track(new ShowAdvertTreeEvent(this.a, this.i, advertDetails));
        }
        this.i = getParent();
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowDeveloperPage(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new ShowDeveloperPageEvent(str, str2));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowIcebreakersBlock(@NotNull String str, int i2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "icebreakerIds");
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String id = advertDetails.getId();
        AdvertDetails advertDetails2 = this.e;
        if (advertDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        String categoryId = advertDetails2.getCategoryId();
        AdvertDetails advertDetails3 = this.e;
        if (advertDetails3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        AdjustParameters adjustParameters = advertDetails3.getAdjustParameters();
        analytics.track(new ShowIcebreakersEvent(id, categoryId, adjustParameters != null ? adjustParameters.getMicroCategoryId() : null, str, i2, list));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowModelSpecificationButton(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "pageType");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ShowModelSpecificationsButtonTreeEvent(this.i, str, str2));
        } else {
            this.f.track(new ShowModelSpecificationsButton(str, str2));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowScreenEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "itemAppearanceUuid");
        if (this.j.getNewShowScreenClickstreamEvents().invoke().booleanValue()) {
            this.f.track(new AdvertDetailsShowScreenEvent(str, str2));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowSellersProfile(@NotNull AdvertDetails advertDetails, @NotNull ShowSellersProfileSource showSellersProfileSource) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(showSellersProfileSource, "source");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ShowSellersProfileTreeEvent(this.i, advertDetails, showSellersProfileSource));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendShowSimilars(@NotNull AdvertDetails advertDetails, @Nullable String str, int i2) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new ShowSimilarsTreeEvent(this.i, advertDetails, str, i2));
        }
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendSimilarsButtonClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new AdvertSimilarsClickEvent(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendSimilarsShowMoreClick() {
        Analytics analytics = this.f;
        AdvertDetails advertDetails = this.e;
        if (advertDetails == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advert");
        }
        analytics.track(new SimilarsShowMoreEvent(advertDetails.getId()));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendVideoClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.f.track(new GalleryVideoEvent(this.i, advertDetails.getId(), false));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void setAdvertDetails(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.e = advertDetails;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void setCalculatorType(@Nullable CalculatorType calculatorType) {
        this.l.setCalculatorType(calculatorType);
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void setSearchContext(@Nullable String str) {
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void trackBuyGeoReportEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new BuyGeoReportClicked(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void trackDeliveryLocationChanged(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new ChangeDeliveryLocationClickEvent(str, str2));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void trackShowGeoReportExampleEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.f.track(new ShowExampleClicked(str));
    }

    @Override // com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor
    public void sendAutotekaTeaserButtonClick(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "url");
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.f.track(new AutotekaDetailsGetReportClickTreeEvent(this.i, str, str2, FromBlock.OLD_TEASER));
        }
    }
}
