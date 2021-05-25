package com.avito.android.advert.item;

import a2.a.a.f.x.m;
import a2.a.a.f.x.n;
import android.content.ClipboardManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.ab_tests.AdvertSpeedUpTest;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.item.AdvertDeeplinkRouter;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.advert.item.AdvertDetailsViewScroller;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoItem;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionItem;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellerprofile.SellerStatusProvider;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapItem;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.advert_core.analytics.address.GeoFromBlock;
import com.avito.android.advert_core.analytics.similars.ClickSimilarItemFavoritesAction;
import com.avito.android.advert_core.contactbar.AddToCartData;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.advert_core.utils.AdvertDetailsUtilsKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.deep_linking.links.DevelopmentsCatalogLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.ShopLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.action.DeepLinkAction;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.marketplace.AdvertMarketPlace;
import com.avito.android.remote.marketplace.Delivery;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.AutotekaTeaserResponseKt;
import com.avito.android.remote.model.AutotekaTeaserResult;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
import com.avito.android.remote.model.recommended_sellers.RecommendedSeller;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellerElement;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellersCarousel;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.preferences.Preferences;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.jakewharton.rxrelay3.ReplayRelay;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0003\b\u0007\u0012\b\u0010»\u0001\u001a\u00030¸\u0001\u0012\b\u0010§\u0002\u001a\u00030¤\u0002\u0012\b\u0010µ\u0001\u001a\u00030²\u0001\u0012\b\u0010Ô\u0002\u001a\u00030Ñ\u0002\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010»\u0002\u001a\u00030¸\u0002\u0012\b\u0010©\u0001\u001a\u00030¦\u0001\u0012\b\u0010·\u0002\u001a\u00030´\u0002\u0012\b\u0010í\u0001\u001a\u00030ê\u0001\u0012\t\b\u0001\u0010þ\u0001\u001a\u00020\f\u0012\u000b\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\f\u0012\n\u0010­\u0001\u001a\u0005\u0018\u00010ª\u0001\u0012\t\b\u0002\u0010\u0002\u001a\u00020f\u0012\b\u0010ü\u0001\u001a\u00030ù\u0001\u0012\b\u0010£\u0002\u001a\u00030 \u0002\u0012\b\u0010¿\u0002\u001a\u00030¼\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010ñ\u0001\u001a\u00030î\u0001\u0012\b\u0010¿\u0001\u001a\u00030¼\u0001\u0012\b\u0010Ð\u0002\u001a\u00030Í\u0002\u0012\b\u0010Ã\u0002\u001a\u00030À\u0002\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010ã\u0001\u001a\u00030à\u0001\u0012\b\u0010­\u0002\u001a\u00030ª\u0002\u0012\b\u0010¥\u0001\u001a\u00030¢\u0001\u0012\b\u0010Ö\u0001\u001a\u00030Ó\u0001\u0012\b\u0010Ç\u0002\u001a\u00030Ä\u0002\u0012\u000e\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020\u0002\u0012\b\u0010±\u0001\u001a\u00030®\u0001\u0012\u0011\b\u0001\u0010Ì\u0002\u001a\n\u0012\u0005\u0012\u00030É\u00020È\u0002\u0012\b\u0010÷\u0001\u001a\u00030õ\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010±\u0002\u001a\u00030®\u0002\u0012\u000f\u0010Û\u0001\u001a\n\u0012\u0005\u0012\u00030Ø\u00010×\u0001¢\u0006\u0006\bÕ\u0002\u0010Ö\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0019\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u0019\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b%\u0010\u000fJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\bJ'\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010-J/\u00100\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b2\u0010\u000fJ\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010>\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\fH\u0016¢\u0006\u0004\bA\u0010\u000fJ\u0017\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u0019\u0010H\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010\bJ\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\bJ\u0017\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bM\u0010\u000fJ\u000f\u0010N\u001a\u00020\u0006H\u0016¢\u0006\u0004\bN\u0010\bJ\u000f\u0010O\u001a\u00020\u0006H\u0016¢\u0006\u0004\bO\u0010\bJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\bJ\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010\bJ\u000f\u0010R\u001a\u00020\u0006H\u0016¢\u0006\u0004\bR\u0010\bJ\u000f\u0010S\u001a\u00020\u0006H\u0016¢\u0006\u0004\bS\u0010\bJ\u000f\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001a\u00020\u00062\b\u0010W\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J)\u0010b\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u0010=\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0006H\u0016¢\u0006\u0004\bd\u0010\bJ!\u0010h\u001a\u00020\u00062\u0006\u0010e\u001a\u00020<2\b\u0010g\u001a\u0004\u0018\u00010fH\u0016¢\u0006\u0004\bh\u0010iJ!\u0010j\u001a\u00020\u00062\u0006\u0010e\u001a\u00020<2\b\u0010g\u001a\u0004\u0018\u00010fH\u0016¢\u0006\u0004\bj\u0010iJ\u0017\u0010k\u001a\u00020\u00062\u0006\u0010e\u001a\u00020<H\u0016¢\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\fH\u0016¢\u0006\u0004\bn\u0010\u000fJ\u0017\u0010q\u001a\u00020\u00062\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020\u00062\u0006\u0010t\u001a\u00020sH\u0016¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\u0006H\u0016¢\u0006\u0004\bw\u0010\bJ\u0017\u0010x\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bx\u0010EJ\u0017\u0010{\u001a\u00020\u00062\u0006\u0010z\u001a\u00020yH\u0016¢\u0006\u0004\b{\u0010|J*\u0010\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\f2\u0006\u0010~\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0005\b\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bJ\u0019\u0010\u0001\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0005\b\u0001\u0010EJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bJ\u001c\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0005\b\u0001\u0010EJ\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u0001\u0010\u0014J\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b\u0001\u0010\u000fJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bJ\u001c\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0005\b\u0001\u0010EJ\u001a\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0005\b\u0001\u0010EJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bJ\u001c\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0005\b\u0001\u0010EJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bJ\u0011\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0001\u0010\bR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\n\u0010 \u0001R\u001a\u0010¥\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010­\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u00030®\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010µ\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001a\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¿\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001Rn\u0010Ê\u0001\u001aW\u0012\u001d\u0012\u001b\u0012\u0005\u0012\u00030Å\u0001 Æ\u0001*\f\u0012\u0005\u0012\u00030Å\u0001\u0018\u00010Ä\u00010Ä\u0001 Æ\u0001**\u0012\u001d\u0012\u001b\u0012\u0005\u0012\u00030Å\u0001 Æ\u0001*\f\u0012\u0005\u0012\u00030Å\u0001\u0018\u00010Ä\u00010Ä\u0001\u0018\u00010Ã\u0001¢\u0006\u0003\bÇ\u00010Ã\u0001¢\u0006\u0003\bÇ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Í\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010Ì\u0001R!\u0010Ð\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ò\u0001\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Á\u0001R\u001a\u0010Ö\u0001\u001a\u00030Ó\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R!\u0010Û\u0001\u001a\n\u0012\u0005\u0012\u00030Ø\u00010×\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001b\u0010Ü\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0007\u0010Ì\u0001R\u0019\u0010ß\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010ã\u0001\u001a\u00030à\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u001a\u0010å\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bä\u0001\u0010 \u0001R\u001c\u0010é\u0001\u001a\u0005\u0018\u00010æ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u001a\u0010í\u0001\u001a\u00030ê\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001a\u0010ñ\u0001\u001a\u00030î\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u0019\u0010ó\u0001\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bò\u0001\u0010Á\u0001R\u001b\u0010ô\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010Ì\u0001R\u001a\u0010÷\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010ö\u0001R\u001b\u0010ø\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010Ì\u0001R\u001a\u0010ü\u0001\u001a\u00030ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0019\u0010þ\u0001\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bý\u0001\u0010Þ\u0001R\u0019\u0010\u0002\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001b\u0010\u0002\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0004\u0010Ì\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R \u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010Ï\u0001R\u0019\u0010\u0002\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Á\u0001R\u001b\u0010\u0002\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010Þ\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010£\u0002\u001a\u00030 \u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R\u001a\u0010§\u0002\u001a\u00030¤\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0002\u0010¦\u0002R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001a\u0010­\u0002\u001a\u00030ª\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002R\u001a\u0010±\u0002\u001a\u00030®\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010°\u0002R\u001b\u0010_\u001a\u0005\u0018\u00010²\u00028B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010³\u0002R\u001a\u0010·\u0002\u001a\u00030´\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001a\u0010»\u0002\u001a\u00030¸\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u001a\u0010¿\u0002\u001a\u00030¼\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001a\u0010Ã\u0002\u001a\u00030À\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001a\u0010Ç\u0002\u001a\u00030Ä\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R!\u0010Ì\u0002\u001a\n\u0012\u0005\u0012\u00030É\u00020È\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÊ\u0002\u0010Ë\u0002R\u001a\u0010Ð\u0002\u001a\u00030Í\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002R\u001a\u0010Ô\u0002\u001a\u00030Ñ\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002¨\u0006×\u0002"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsPresenterImpl;", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "d", "()Lio/reactivex/rxjava3/core/Observable;", "", a2.g.r.g.a, "()V", "advertItemWithMeta", AuthSource.SEND_ABUSE, "(Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;)V", "", "locationIdTo", "e", "(Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "", "isNeedResetComplementary", "f", "(Z)V", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "detachView", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "router", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDetailsRouter;)V", "detachRouter", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "dfpCreditViewModel", "attachDfpCreditViewModel", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;)V", "detachDfpCreditViewModel", "category", "onDescriptionExpanded", "onDescriptionExpandExist", "onDescriptionCopy", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "onOpenMap", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "from", "onAddressClick", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;)V", "onAddressLongClick", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "item", "onShowOnMapClick", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;)V", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", "onPriceSubscriptionClick", "(Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", VKApiConst.POSITION, "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "itemId", "onItemClose", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/remote/model/delivery/DeliveryFlowResult;", "result", "handleDeliveryResults", "(Lcom/avito/android/remote/model/delivery/DeliveryFlowResult;)V", "handleExpressCvOkResult", "showLoadingIndicatorAfterOnActivityResult", "message", "handleMessageResult", "trackEnableNotificationClick", "refresh", Tracker.Events.CREATIVE_START, "updateContacts", "stop", "onResume", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "onAbuseButtonClick", "currentPosition", "", "stateId", "handleGalleryClick", "(ILjava/lang/Long;)V", "handleVideoGalleryClick", "handleGalleryChangePosition", "(I)V", ShareConstants.MEDIA_URI, "handleAutoDealClick", "Lcom/avito/android/remote/model/Location;", "location", "handleLocationUpdate", "(Lcom/avito/android/remote/model/Location;)V", "Landroid/net/Uri;", "actionUri", "onClickShortTermRent", "(Landroid/net/Uri;)V", "onSubmitConsultationRequestClick", "onAdditionalSellerClicks", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", ErrorBundle.DETAIL_ENTRY, "onOpenCallBottomSheet", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;)V", "itemName", "itemValue", "onFlatsClick", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "onGroupsClick", "followSectionDeepLink", "handleUpdateAuthAddNoteResult", "Lcom/avito/android/advert_core/contactbar/AddToCartData;", "data", "handleOnCartActionAuthSuccess", "(Lcom/avito/android/advert_core/contactbar/AddToCartData;)V", "onSimilarsButtonClicked", "isMarketplace", "onShowDescriptionClicked", "helpCenterLink", "onVerificationHelpCenterClicked", "onMarketplaceSpecsClick", "link", "onMarketplaceInfoClick", "onMarketplaceWriteButtonClick", "onMarketplaceDeliveryChangeCity", "onMarketplaceDeliveryMapClick", "onMarketplaceFaqClick", "onCreditBrokerLinkClick", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "P", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "shortTermRentPresenter", "h", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "x", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "marketplacePresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/analytics/Analytics;", "T", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "z", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "advertComplementaryPresenter", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "fastOpenParams", "Lcom/avito/android/FavoriteSellersRepository;", "X", "Lcom/avito/android/FavoriteSellersRepository;", "sellerRepository", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", VKApiConst.VERSION, "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safeDealPresenter", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "Lcom/avito/android/advert/AdvertDetailsInteractor;", "t", "Lcom/avito/android/advert/AdvertDetailsInteractor;", "interactor", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "M", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "autotekaPresenter", "i", "Z", "opened", "Lcom/jakewharton/rxrelay3/ReplayRelay;", "Lcom/avito/android/util/LoadingState;", "", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "l", "Lcom/jakewharton/rxrelay3/ReplayRelay;", "loadingRelay", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "advertDisposable", "c", "Lio/reactivex/rxjava3/core/Observable;", "advertObservable", "s", "shouldUpdateCartAction", "Lcom/avito/android/util/preferences/Preferences;", "U", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "d0", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "teaserTestGroup", "deliveryInfoDisposable", "r", "Ljava/lang/String;", "itemAppearanceUuid", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "R", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "k", "sellerDisposables", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "o", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "teaser", "Lcom/avito/android/account/AccountStateProvider;", "B", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "L", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "j", "contactsUpdated", "complementaryItemsDisposable", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "questionnairePresenter", "autotekaTeaserDisposable", "Lcom/avito/android/profile/ProfileInfoStorage;", "G", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "C", BookingInfoActivity.EXTRA_ITEM_ID, "F", "J", "clickTime", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "Q", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "favoriteInteractor", "sellerStatusPollingDisposable", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "K", "Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "sellerStatusProvider", "n", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "advertWithMeta", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", ExifInterface.LONGITUDE_WEST, "favoriteActionClicks", "p", "clickTimeLogged", "D", "context", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "a0", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "locationStorage", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "b0", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Landroid/content/ClipboardManager;", "H", "Landroid/content/ClipboardManager;", "clipboardManager", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "u", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactsPresenter", VKApiConst.Q, "Lcom/avito/android/advert/item/AdvertDetailsView;", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "tracker", "Lcom/avito/android/Features;", "c0", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/model/AdvertDetails;", "()Lcom/avito/android/remote/model/AdvertDetails;", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "advertDetailsItemsPresenter", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "y", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "advertDetailsToolbarPresenter", "Lcom/avito/android/util/ClipDataFactory;", "I", "Lcom/avito/android/util/ClipDataFactory;", "clipboardFactory", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "O", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "notePresenter", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNoneControl2;", "Y", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "advertSpeedUpTestGroup", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "N", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "autotekaTeaserPresenter", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "w", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "sellerPresenter", "<init>", "(Lcom/avito/android/advert/AdvertDetailsInteractor;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;Lcom/avito/android/account/AccountStateProvider;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;JLcom/avito/android/profile/ProfileInfoStorage;Landroid/content/ClipboardManager;Lcom/avito/android/util/ClipDataFactory;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert/tracker/AdvertDetailsTracker;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPresenterImpl implements AdvertDetailsPresenter {
    public final AdvertDetailsItemsPresenter A;
    public final AccountStateProvider B;
    public final String C;
    public final String D;
    public final AdvertDetailsFastOpenParams E;
    public final long F;
    public final ProfileInfoStorage G;
    public final ClipboardManager H;
    public final ClipDataFactory I;
    public final SchedulersFactory3 J;
    public final SellerStatusProvider K;
    public final FavoriteAdvertsPresenter L;
    public final AdvertDetailsAutotekaPresenter M;
    public final AdvertDetailsAutotekaTeaserPresenter N;
    public final AdvertDetailsNotePresenter O;
    public final AdvertDetailsShortTermRentPresenter P;
    public final AdvertDetailsFavoriteInteractor Q;
    public final AdvertDetailsAnalyticsInteractor R;
    public final AdvertDetailsTracker S;
    public final Analytics T;
    public final Preferences U;
    public final NotificationManagerProvider V;
    public final Observable<FavoriteSellersItemAction> W;
    public final FavoriteSellersRepository X;
    public final AbTestGroup<SimpleTestGroupWithNoneControl2> Y;
    public final QuestionnairePresenter Z;
    public final CompositeDisposable a;
    public final MarketplaceDeliveryStorage a0;
    public Disposable b;
    public final CompositeSnackbarPresenter b0;
    public Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> c;
    public Features c0;
    public Disposable d;
    public final ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> d0;
    public Disposable e;
    public Disposable f;
    public Disposable g;
    public AdvertDetailsRouter h;
    public boolean i;
    public boolean j;
    public CompositeDisposable k;
    public ReplayRelay<LoadingState<Object>> l;
    public DfpCreditViewModel m;
    public AdvertDetailsInteractor.AdvertDetailsWithMeta n;
    public AutotekaTeaserResult o;
    public boolean p;
    public AdvertDetailsView q;
    public String r;
    public boolean s;
    public final AdvertDetailsInteractor t;
    public final AdvertContactsPresenter u;
    public final AdvertSafeDealPresenter v;
    public final AdvertSellerPresenter w;
    public final MarketplacePresenter x;
    public final AdvertDetailsToolbarPresenter y;
    public final AdvertComplementaryPresenter z;

    public static final class a<T> implements Consumer<AdvertDetailsInteractor.AdvertDetailsWithMeta> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta) {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("AdvertDetailsPresenter", "Error advertObservable", th);
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public c(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            AdvertDetailsPresenterImpl.access$syncSellersState(this.a);
        }
    }

    public static final class d<T> implements Consumer<FavoriteSellersItemAction> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public d(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(FavoriteSellersItemAction favoriteSellersItemAction) {
            AdvertDetailsRouter advertDetailsRouter;
            FavoriteSellersItemAction favoriteSellersItemAction2 = favoriteSellersItemAction;
            if ((favoriteSellersItemAction2 instanceof DeepLinkAction) && (advertDetailsRouter = this.a.h) != null) {
                advertDetailsRouter.followDeepLink(((DeepLinkAction) favoriteSellersItemAction2).getDeepLink());
            }
        }
    }

    public static final class e<T> implements Consumer<DeliveryInfoResponse> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public e(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeliveryInfoResponse deliveryInfoResponse) {
            DeliveryInfoResponse deliveryInfoResponse2 = deliveryInfoResponse;
            AdvertDetailsItemsPresenter advertDetailsItemsPresenter = this.a.A;
            AdvertDetails c = this.a.c();
            advertDetailsItemsPresenter.updateMarketplaceDeliveryInfoItem(c != null ? c.getMarketplaceData() : null, deliveryInfoResponse2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public f(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AdvertDetailsItemsPresenter advertDetailsItemsPresenter = this.a.A;
            AdvertDetails c = this.a.c();
            advertDetailsItemsPresenter.updateMarketplaceDeliveryInfoItem(c != null ? c.getMarketplaceData() : null, null);
            Logs.error(th2);
        }
    }

    public static final class g<T> implements Consumer<Boolean> {
        public final /* synthetic */ AdvertDetails a;
        public final /* synthetic */ AdvertDetailsPresenterImpl b;
        public final /* synthetic */ AdvertDetailsPriceSubscriptionItem c;

        public g(AdvertDetails advertDetails, AdvertDetailsPresenterImpl advertDetailsPresenterImpl, AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem) {
            this.a = advertDetails;
            this.b = advertDetailsPresenterImpl;
            this.c = advertDetailsPriceSubscriptionItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem = this.c;
            Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
            advertDetailsPriceSubscriptionItem.setFavorite(bool2.booleanValue());
            AdvertDetailsView advertDetailsView = this.b.q;
            if (advertDetailsView != null) {
                advertDetailsView.refreshList();
            }
            this.b.y.updateFavoriteState(this.a);
            if (bool2.booleanValue()) {
                AdvertDetailsPresenterImpl.access$showInfoOrWarningIfNeeded(this.b);
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class i<T> implements Consumer<AdvertDetailsInteractor.AdvertDetailsWithMeta> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public i(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta) {
            AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta2 = advertDetailsWithMeta;
            AdvertDetailsPresenterImpl advertDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertDetailsWithMeta2, "it");
            advertDetailsPresenterImpl.a(advertDetailsWithMeta2);
            AdvertDetailsView advertDetailsView = this.a.q;
            if (advertDetailsView != null) {
                advertDetailsView.smoothScrollToStart();
            }
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertDetailsPresenterImpl a;

        public j(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
            this.a = advertDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AdvertDetailsPresenterImpl advertDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            AdvertDetailsPresenterImpl.access$advertDataError(advertDetailsPresenterImpl, th2);
        }
    }

    @Inject
    public AdvertDetailsPresenterImpl(@NotNull AdvertDetailsInteractor advertDetailsInteractor, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull AdvertSafeDealPresenter advertSafeDealPresenter, @NotNull AdvertSellerPresenter advertSellerPresenter, @Nullable MarketplacePresenter marketplacePresenter, @NotNull AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, @NotNull AdvertComplementaryPresenter advertComplementaryPresenter, @NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter, @NotNull AccountStateProvider accountStateProvider, @AdvertId @NotNull String str, @AdvertFragmentModule.SearchContext @Nullable String str2, @Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams, long j2, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull ClipboardManager clipboardManager, @NotNull ClipDataFactory clipDataFactory, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SellerStatusProvider sellerStatusProvider, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter, @NotNull AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter, @NotNull AdvertDetailsNotePresenter advertDetailsNotePresenter, @NotNull AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter, @NotNull AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull AdvertDetailsTracker advertDetailsTracker, @NotNull Analytics analytics, @NotNull Preferences preferences, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull Observable<FavoriteSellersItemAction> observable, @NotNull FavoriteSellersRepository favoriteSellersRepository, @AdvertSpeedUpTest @NotNull AbTestGroup<SimpleTestGroupWithNoneControl2> abTestGroup, @NotNull QuestionnairePresenter questionnairePresenter, @NotNull MarketplaceDeliveryStorage marketplaceDeliveryStorage, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features, @NotNull ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(advertDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "safeDealPresenter");
        Intrinsics.checkNotNullParameter(advertSellerPresenter, "sellerPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsToolbarPresenter, "advertDetailsToolbarPresenter");
        Intrinsics.checkNotNullParameter(advertComplementaryPresenter, "advertComplementaryPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsItemsPresenter, "advertDetailsItemsPresenter");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(clipboardManager, "clipboardManager");
        Intrinsics.checkNotNullParameter(clipDataFactory, "clipboardFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(sellerStatusProvider, "sellerStatusProvider");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaPresenter, "autotekaPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserPresenter, "autotekaTeaserPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsNotePresenter, "notePresenter");
        Intrinsics.checkNotNullParameter(advertDetailsShortTermRentPresenter, "shortTermRentPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsFavoriteInteractor, "favoriteInteractor");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(advertDetailsTracker, "tracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(observable, "favoriteActionClicks");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "sellerRepository");
        Intrinsics.checkNotNullParameter(abTestGroup, "advertSpeedUpTestGroup");
        Intrinsics.checkNotNullParameter(questionnairePresenter, "questionnairePresenter");
        Intrinsics.checkNotNullParameter(marketplaceDeliveryStorage, "locationStorage");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "teaserTestGroup");
        this.t = advertDetailsInteractor;
        this.u = advertContactsPresenter;
        this.v = advertSafeDealPresenter;
        this.w = advertSellerPresenter;
        this.x = marketplacePresenter;
        this.y = advertDetailsToolbarPresenter;
        this.z = advertComplementaryPresenter;
        this.A = advertDetailsItemsPresenter;
        this.B = accountStateProvider;
        this.C = str;
        this.D = str2;
        this.E = advertDetailsFastOpenParams;
        this.F = j2;
        this.G = profileInfoStorage;
        this.H = clipboardManager;
        this.I = clipDataFactory;
        this.J = schedulersFactory3;
        this.K = sellerStatusProvider;
        this.L = favoriteAdvertsPresenter;
        this.M = advertDetailsAutotekaPresenter;
        this.N = advertDetailsAutotekaTeaserPresenter;
        this.O = advertDetailsNotePresenter;
        this.P = advertDetailsShortTermRentPresenter;
        this.Q = advertDetailsFavoriteInteractor;
        this.R = advertDetailsAnalyticsInteractor;
        this.S = advertDetailsTracker;
        this.T = analytics;
        this.U = preferences;
        this.V = notificationManagerProvider;
        this.W = observable;
        this.X = favoriteSellersRepository;
        this.Y = abTestGroup;
        this.Z = questionnairePresenter;
        this.a0 = marketplaceDeliveryStorage;
        this.b0 = compositeSnackbarPresenter;
        this.c0 = features;
        this.d0 = manuallyExposedAbTestGroup;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        this.k = new CompositeDisposable();
        this.l = ReplayRelay.createWithSize(1);
        this.r = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
        Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> autoConnect = abTestGroup.getTestGroup().isTest() ? d().observeOn(schedulersFactory3.mainThread()).replay(1).autoConnect() : null;
        this.c = autoConnect;
        if (autoConnect != null) {
            Disposable subscribe = autoConnect.subscribe(a.a, b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "it.subscribe({}, {\n     …able\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final void access$advertDataError(AdvertDetailsPresenterImpl advertDetailsPresenterImpl, Throwable th) {
        advertDetailsPresenterImpl.c = null;
        advertDetailsPresenterImpl.S.trackAdvertLoadError();
        boolean isNotFoundError = Throwables.isNotFoundError(th);
        advertDetailsPresenterImpl.S.trackAdvertErrorPrepare();
        if (isNotFoundError) {
            AdvertDetailsView advertDetailsView = advertDetailsPresenterImpl.q;
            if (advertDetailsView != null) {
                advertDetailsView.showInactiveItem(advertDetailsPresenterImpl.C);
            }
            AdvertDetailsView advertDetailsView2 = advertDetailsPresenterImpl.q;
            if (advertDetailsView2 != null) {
                advertDetailsView2.onLoadFailed();
            }
            advertDetailsPresenterImpl.l.accept(new LoadingState.Error(new ErrorWithMessage.NetworkError("onLoadFailed")));
            advertDetailsPresenterImpl.R.sendLoadAdvertErrorEvent(advertDetailsPresenterImpl.C, true);
        } else {
            AdvertDetailsView advertDetailsView3 = advertDetailsPresenterImpl.q;
            if (advertDetailsView3 != null) {
                advertDetailsView3.onDataSourceUnavailable();
            }
            advertDetailsPresenterImpl.l.accept(new LoadingState.Error(new ErrorWithMessage.NetworkError("onNetworkProblem")));
            advertDetailsPresenterImpl.R.sendLoadAdvertErrorEvent(advertDetailsPresenterImpl.C, false);
        }
        advertDetailsPresenterImpl.S.trackAdvertErrorDraw();
    }

    public static final void access$onOnlineStatusChanged(AdvertDetailsPresenterImpl advertDetailsPresenterImpl, AdvertDetails advertDetails, boolean z2) {
        Objects.requireNonNull(advertDetailsPresenterImpl);
        AdvertSeller seller = advertDetails.getSeller();
        advertDetails.setSeller(seller != null ? AdvertSeller.copy$default(seller, null, null, null, null, null, null, null, null, null, z2, null, null, null, null, null, null, null, 130559, null) : null);
        advertDetailsPresenterImpl.w.updateOnlineStatus(z2);
    }

    public static final void access$showInfoOrWarningIfNeeded(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        if (!advertDetailsPresenterImpl.V.getAreNotificationsEnabled()) {
            AdvertDetailsView advertDetailsView = advertDetailsPresenterImpl.q;
            if (advertDetailsView != null) {
                advertDetailsView.showNotificationsEnableWarning();
            }
        } else if (!advertDetailsPresenterImpl.U.getBoolean(AdvertDetailsPresenterKt.PREF_KEY_PRICE_SUBSCRIPTION_BOTTOM_SHEET_SHOWED, false)) {
            AdvertDetailsView advertDetailsView2 = advertDetailsPresenterImpl.q;
            if (advertDetailsView2 != null) {
                advertDetailsView2.showPriceSubscriptionInfo();
            }
            advertDetailsPresenterImpl.U.putBoolean(AdvertDetailsPresenterKt.PREF_KEY_PRICE_SUBSCRIPTION_BOTTOM_SHEET_SHOWED, true);
        }
    }

    public static final void access$syncSellersState(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        CompositeDisposable compositeDisposable = advertDetailsPresenterImpl.k;
        Disposable subscribe = advertDetailsPresenterImpl.X.getSellers().subscribe(new m(advertDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sellerRepository.getSell…Similars())\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$updateFavoriteSellersState(AdvertDetailsPresenterImpl advertDetailsPresenterImpl, Set set, List list) {
        Objects.requireNonNull(advertDetailsPresenterImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(set, 10)), 16));
        for (Object obj : set) {
            linkedHashMap.put(((FavoriteSeller) obj).getUserKey(), obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof RecommendedSellersCarousel) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List<RecommendedSellerElement> items = ((RecommendedSellersCarousel) it.next()).getItems();
            if (items != null) {
                ArrayList arrayList2 = new ArrayList();
                for (T t2 : items) {
                    if (t2 instanceof RecommendedSeller) {
                        arrayList2.add(t2);
                    }
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    RecommendedSeller recommendedSeller = (RecommendedSeller) it2.next();
                    FavoriteSeller favoriteSeller = (FavoriteSeller) linkedHashMap.get(recommendedSeller.getUserKey());
                    if (favoriteSeller != null) {
                        recommendedSeller.setSubscribed(favoriteSeller.isSubscribed());
                        recommendedSeller.setNotificationsActivated(favoriteSeller.isNotificationsActivated());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r3 != null) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.avito.android.advert.AdvertDetailsInteractor.AdvertDetailsWithMeta r12) {
        /*
        // Method dump skipped, instructions count: 632
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.AdvertDetailsPresenterImpl.a(com.avito.android.advert.AdvertDetailsInteractor$AdvertDetailsWithMeta):void");
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void attachDfpCreditViewModel(@NotNull DfpCreditViewModel dfpCreditViewModel) {
        Intrinsics.checkNotNullParameter(dfpCreditViewModel, "dfpCreditViewModel");
        this.m = dfpCreditViewModel;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void attachRouter(@NotNull AdvertDetailsRouter advertDetailsRouter) {
        Intrinsics.checkNotNullParameter(advertDetailsRouter, "router");
        this.h = advertDetailsRouter;
        CompositeDisposable compositeDisposable = this.k;
        Disposable subscribe = this.X.updates().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sellerRepository.updates…cSellersState()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void attachView(@NotNull AdvertDetailsView advertDetailsView) {
        Intrinsics.checkNotNullParameter(advertDetailsView, "view");
        this.q = advertDetailsView;
        this.u.notifySellerAboutCallIfNeeded();
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.W.subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteActionClicks.sub…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void b() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            int i2 = 0;
            for (T t2 : this.z.getAnalyticsParams()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                this.R.sendShowSimilars(c2, t2, i3);
                i2 = i3;
            }
            this.z.bindComplementaryBlock(this.A);
        }
    }

    public final AdvertDetails c() {
        AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta = this.n;
        if (advertDetailsWithMeta != null) {
            return advertDetailsWithMeta.getAdvert();
        }
        return null;
    }

    public final Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> d() {
        String str;
        Location location = this.a0.location();
        if (location == null || (str = location.getId()) == null) {
            str = AdvertDetailsItemsPresenterKt.LOCATION_MOSCOW;
        }
        return a2.b.a.a.a.b2(this.J, this.t.getAdvertDetails(this.D, this.R.getRequestId(), str), "interactor\n            .…(schedulers.mainThread())");
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void detachDfpCreditViewModel() {
        this.m = null;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void detachRouter() {
        this.k.clear();
        this.h = null;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void detachView() {
        this.a.clear();
        this.q = null;
    }

    public final void e(String str) {
        if (this.g == null) {
            AdvertDetails c2 = c();
            this.g = this.t.getDeliveryInfo(this.D, c2 != null ? c2.getLocationId() : null, str).observeOn(this.J.mainThread()).subscribe(new e(this), new f(this));
        }
    }

    public final void f(boolean z2) {
        this.n = null;
        this.l = ReplayRelay.createWithSize(1);
        this.A.clearItems();
        if (z2) {
            this.z.clearItems();
        }
    }

    @Override // com.avito.android.section.SectionRouter
    public void followSectionDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ShopLink) {
            this.w.sendAnalyticsShowProfile(ShowSellersProfileSource.SIMILARS, deepLink);
        }
        AdvertDetailsRouter advertDetailsRouter = this.h;
        if (advertDetailsRouter != null) {
            advertDetailsRouter.followDeeplinkWithTreeParent(deepLink, this.R.getParent());
        }
    }

    public final void g() {
        AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta = this.n;
        if (advertDetailsWithMeta == null) {
            Disposable disposable = this.b;
            if (disposable == null || disposable.isDisposed()) {
                this.A.bindFastAdvertData(this.E);
                this.S.startLoadingAdvert();
                this.R.sendEnterScreen();
                AdvertDetailsView advertDetailsView = this.q;
                if (advertDetailsView != null) {
                    advertDetailsView.onLoadingStart();
                }
                Observable<AdvertDetailsInteractor.AdvertDetailsWithMeta> observable = this.c;
                if (observable == null) {
                    observable = d();
                }
                this.b = observable.subscribe(new i(this), new j(this));
                return;
            }
            return;
        }
        a(advertDetailsWithMeta);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleAutoDealClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.MEDIA_URI);
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendAutoDealClick(c2);
        }
        AdvertDetailsRouter advertDetailsRouter = this.h;
        if (advertDetailsRouter != null) {
            advertDetailsRouter.openAutoDeal(str);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleDeliveryResults(@Nullable DeliveryFlowResult deliveryFlowResult) {
        if (deliveryFlowResult != null && deliveryFlowResult.getShouldReload()) {
            refresh();
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleExpressCvOkResult() {
        refresh();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleGalleryChangePosition(int i2) {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendGalleryEmbeddedSwipe(c2);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleGalleryClick(int i2, @Nullable Long l2) {
        AutotekaTeaserResult autotekaTeaserResult;
        AdvertDetails c2 = c();
        if (c2 != null) {
            AdvertDetailsRouter advertDetailsRouter = this.h;
            if (advertDetailsRouter != null) {
                advertDetailsRouter.showGalleryFullscreen(i2, c2.getVideo(), c2.getImages(), this.R.getParent(), c2.getCategoryId(), (!c2.isMarketplace() && !CollectionsKt___CollectionsKt.contains(AdvertDetailsPresenterKt.access$getPhotoGalleryExcludeCategories$p(), c2.getCategoryId())) ? c2.getAdvertActions() : null, AdvertDetailsUtilsKt.toContactBarData$default(c2, null, 1, null), l2, this.D, c2.getInfoImage(), (this.d0.getTestGroup().isTest() && (autotekaTeaserResult = this.o) != null) ? AutotekaTeaserResponseKt.toAutotekaTeaserGalleryModel(autotekaTeaserResult) : null);
            }
            this.d0.expose();
            this.R.sendGalleryShowFullscreen(c2);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleLocationUpdate(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = null;
        e(location.getId());
        this.A.updateSelectedLocation(location);
        this.u.userSelectedLocationId(location.getId());
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleMessageResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.b0, str, 0, null, 0, null, 0, null, null, 254, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleOnCartActionAuthSuccess(@NotNull AddToCartData addToCartData) {
        Intrinsics.checkNotNullParameter(addToCartData, "data");
        this.s = true;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleUpdateAuthAddNoteResult() {
        AdvertDetailsRouter advertDetailsRouter;
        AdvertDetails c2 = c();
        if (c2 != null && (advertDetailsRouter = this.h) != null) {
            advertDetailsRouter.openEditNote(c2);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void handleVideoGalleryClick(int i2, @Nullable Long l2) {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendVideoClick(c2);
        }
    }

    @Override // com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter.Listener
    public void onAbuseButtonClick() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendShowAbuse(c2);
            AdvertDetailsRouter advertDetailsRouter = this.h;
            if (advertDetailsRouter != null) {
                advertDetailsRouter.showAbuseCategoryScreen(c2.getId());
            }
        }
    }

    @Override // com.avito.android.serp.adapter.AdBannerEventListener
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i2) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        if (this.z.needTrackCommercialOpened(bannerInfo.getId())) {
            this.z.onCommercialOpened(bannerInfo.getId());
            AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.R;
            AdvertDetails c2 = c();
            String id = c2 != null ? c2.getId() : null;
            AdvertDetails c3 = c();
            String categoryId = c3 != null ? c3.getCategoryId() : null;
            AdvertDetails c4 = c();
            advertDetailsAnalyticsInteractor.sendCommercialBannerClick(bannerInfo, id, categoryId, c4 != null ? c4.getLocationId() : null, i2);
        }
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView.Listener
    public void onAdditionalSellerClicks(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        AdvertDetails c2 = c();
        if (c2 != null) {
            if (deepLink instanceof PhoneLink) {
                this.R.sendClickToCallDeveloper();
            } else if (deepLink instanceof DevelopmentsCatalogLink) {
                this.R.sendDevelopmentsCatalogClick(c2, ((DevelopmentsCatalogLink) deepLink).getItemId());
            }
            AdvertDetailsRouter advertDetailsRouter = this.h;
            if (advertDetailsRouter != null) {
                AdvertDeeplinkRouter.DefaultImpls.followDeeplinkWithTreeParent$default(advertDetailsRouter, deepLink, null, 2, null);
            }
        }
    }

    @Override // com.avito.android.advert.item.address.AdvertDetailsAddressView.Listener
    public void onAddressClick(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2, @NotNull GeoFromBlock geoFromBlock) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(geoFromBlock, "from");
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            AdvertDetails c2 = c();
            List<GeoReference> list = null;
            String id = c2 != null ? c2.getId() : null;
            AdvertDetails c3 = c();
            if (c3 != null) {
                list = c3.getGeoReferences();
            }
            advertDetailsView.showAddressOnMap(id, str, coordinates, str2, list);
        }
        AdvertDetails c4 = c();
        if (c4 != null) {
            this.R.sendAddressClick(c4, geoFromBlock);
        }
    }

    @Override // com.avito.android.advert.item.address.AdvertDetailsAddressView.Listener
    public void onAddressLongClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        this.H.setPrimaryClip(this.I.plainText(str));
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            advertDetailsView.showAddressCopied();
        }
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendAddressLongClick(c2);
        }
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        AdvertDetailsRouter advertDetailsRouter;
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendClickSimilarItem(c2, advertItem.getStringId());
        }
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null && (advertDetailsRouter = this.h) != null) {
            advertDetailsRouter.openAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, advertItem.isMarketplace(), this.R.getParent());
        }
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView.Listener
    public void onClickShortTermRent(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "actionUri");
        this.P.followUri(uri);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter.Listener
    public void onCreditBrokerLinkClick() {
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            AdvertDetailsViewScroller.DefaultImpls.smoothScrollToItem$default(advertDetailsView, AdvertDetailsCreditInfoItem.class, 0, 0, true, 6, null);
        }
        this.R.sendCreditCalculatorLinkClick();
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionCopy() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendDescriptionCopyText(c2);
        }
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpandExist() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendDescriptionExpandExist(c2);
        }
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpanded(@Nullable String str) {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendDescriptionExpand(c2);
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendClickSimilarFavorites(c2, favorableItem.isFavorite() ? ClickSimilarItemFavoritesAction.REMOVE : ClickSimilarItemFavoritesAction.ADD, favorableItem.getStringId());
        }
        this.L.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsFlatsListener
    public void onFlatsClick(@NotNull String str, @NotNull String str2, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "itemName");
        Intrinsics.checkNotNullParameter(str2, "itemValue");
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendFlatsClick(c2, str);
            if (deepLink != null) {
                if (deepLink instanceof DevelopmentsCatalogLink) {
                    this.R.sendDevelopmentsCatalogClick(c2, ((DevelopmentsCatalogLink) deepLink).getItemId());
                }
                AdvertDetailsRouter advertDetailsRouter = this.h;
                if (advertDetailsRouter != null) {
                    advertDetailsRouter.followDeepLink(deepLink);
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsGroupsListener
    public void onGroupsClick() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendGroupsClick(c2);
        }
    }

    @Override // com.avito.android.serp.adapter.OnCloseItemListener
    public void onItemClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter.Listener
    public void onMarketplaceDeliveryChangeCity() {
        AdvertMarketPlace marketplaceData;
        Delivery delivery;
        AdvertDetailsRouter advertDetailsRouter = this.h;
        if (advertDetailsRouter != null) {
            AdvertDetails c2 = c();
            String str = null;
            String locationIdTo = (c2 == null || (marketplaceData = c2.getMarketplaceData()) == null || (delivery = marketplaceData.getDelivery()) == null) ? null : delivery.getLocationIdTo();
            AdvertDetails c3 = c();
            if (c3 != null) {
                str = c3.getCategoryId();
            }
            advertDetailsRouter.openSuggestLocation(locationIdTo, str);
        }
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter.Listener
    public void onMarketplaceDeliveryMapClick(@Nullable DeepLink deepLink) {
        AdvertDetailsRouter advertDetailsRouter;
        if (!(deepLink == null || (advertDetailsRouter = this.h) == null)) {
            advertDetailsRouter.followDeepLink(deepLink);
        }
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendMarketplaceBuyButtonClick(c2.getId(), c2.getCategoryId(), this.D);
        }
    }

    @Override // com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter.Listener
    public void onMarketplaceFaqClick() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendFAQButtonClick(c2.getId());
        }
    }

    @Override // com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenter.Listener
    public void onMarketplaceInfoClick(@Nullable DeepLink deepLink) {
        AdvertDetailsRouter advertDetailsRouter;
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendInfoBannerClick(c2.getId());
        }
        if (deepLink != null && (advertDetailsRouter = this.h) != null) {
            advertDetailsRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter.Listener
    public void onMarketplaceSpecsClick() {
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendModelSpecificationsClick(c2.getId(), AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_TTX, true);
        }
    }

    @Override // com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenter.Listener
    public void onMarketplaceWriteButtonClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        this.u.onMarketplaceWriteClick(deepLink);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        AdvertDetailsPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView.Listener
    public void onOpenCallBottomSheet(@NotNull DetailsSheetLinkBody detailsSheetLinkBody) {
        Intrinsics.checkNotNullParameter(detailsSheetLinkBody, ErrorBundle.DETAIL_ENTRY);
        this.R.sendAdditionalSellerPhoneButtonClick(this.C);
        AdvertDetailsRouter advertDetailsRouter = this.h;
        if (advertDetailsRouter != null) {
            advertDetailsRouter.openBottomSheet(detailsSheetLinkBody, new ParametrizedClickStreamEvent(4600, 0, q.mapOf(TuplesKt.to("iid", this.C)), null, 8, null));
        }
    }

    @Override // com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter.OpenMapListener
    public void onOpenMap(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str2, "title");
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            AdvertDetails c2 = c();
            List<GeoReference> list = null;
            String id = c2 != null ? c2.getId() : null;
            AdvertDetails c3 = c();
            if (c3 != null) {
                list = c3.getGeoReferences();
            }
            advertDetailsView.showAddressOnMap(id, str, coordinates, str2, list);
        }
        AdvertDetails c4 = c();
        if (c4 != null) {
            this.R.sendAddressClick(c4, GeoFromBlock.GEO_REFERENCE);
        }
    }

    @Override // com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionView.Listener
    public void onPriceSubscriptionClick(@NotNull AdvertDetailsPriceSubscriptionItem advertDetailsPriceSubscriptionItem) {
        Intrinsics.checkNotNullParameter(advertDetailsPriceSubscriptionItem, "item");
        AdvertDetails c2 = c();
        if (c2 != null) {
            this.R.sendClickToPriceSubscription(this.C, !advertDetailsPriceSubscriptionItem.isFavorite() || !this.V.getAreNotificationsEnabled());
            if (!advertDetailsPriceSubscriptionItem.isFavorite() || this.V.getAreNotificationsEnabled()) {
                Single<R> map = this.Q.toggleFavoriteStatus(c2, this.D).map(new n(c2.isFavorite()));
                Intrinsics.checkNotNullExpressionValue(map, "favoriteInteractor.toggl…ntext).map { isFavorite }");
                map.observeOn(this.J.mainThread()).subscribe(new g(c2, this, advertDetailsPriceSubscriptionItem), h.a);
                return;
            }
            AdvertDetailsView advertDetailsView = this.q;
            if (advertDetailsView != null) {
                advertDetailsView.showNotificationsEnableWarning();
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta = (AdvertDetailsInteractor.AdvertDetailsWithMeta) bundle.getParcelable("advertItem");
            if (advertDetailsWithMeta != null) {
                this.n = advertDetailsWithMeta;
                this.z.setAdvert(advertDetailsWithMeta.getAdvert());
            }
            this.o = (AutotekaTeaserResult) bundle.getParcelable("teaserItem");
            this.i = bundle.getBoolean("key_opened");
            this.p = bundle.getBoolean("key_click_time_loggged");
            this.j = bundle.getBoolean("contacts_updated");
            Bundle bundle2 = bundle.getBundle("advertItemsState");
            if (bundle2 != null) {
                AdvertDetailsItemsPresenter advertDetailsItemsPresenter = this.A;
                Intrinsics.checkNotNullExpressionValue(bundle2, "itemsState");
                advertDetailsItemsPresenter.restoreState(bundle2);
            }
            this.u.restoreState(bundle.getBundle("contactsState"));
            this.v.restoreState(bundle.getBundle("safeDealState"));
            MarketplacePresenter marketplacePresenter = this.x;
            if (marketplacePresenter != null) {
                marketplacePresenter.restoreState(bundle.getBundle(MarketplacePresenterKt.KEY_MARKETPLACE_STATE));
            }
            String string = bundle.getString("itemAppearanceUuid");
            if (string == null) {
                string = "initial_appearance";
            }
            this.r = string;
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void onResume() {
        this.R.sendShowScreenEvent(this.C, this.r);
        this.R.returnToScreen();
        this.u.showAntiFraudCheckList();
        this.u.onResume();
        this.v.showNoPurchaseFeedbackIfNeeded();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("advertItem", this.n);
        bundle.putParcelable("teaserItem", this.o);
        bundle.putBoolean("key_opened", this.i);
        bundle.putBoolean("key_click_time_loggged", this.p);
        bundle.putBoolean("contacts_updated", this.j);
        bundle.putBundle("contactsState", this.u.saveState());
        bundle.putBundle("safeDealState", this.v.saveState());
        bundle.putString("itemAppearanceUuid", this.r);
        if (c() != null) {
            bundle.putBundle("advertItemsState", this.A.saveState());
        }
        MarketplacePresenter marketplacePresenter = this.x;
        bundle.putBundle(MarketplacePresenterKt.KEY_MARKETPLACE_STATE, marketplacePresenter != null ? marketplacePresenter.saveState() : null);
        return bundle;
    }

    @Override // com.avito.android.advert.item.show_description_button.ShowDescriptionClickListener
    public void onShowDescriptionClicked(boolean z2) {
        this.A.refreshAdvertData();
        this.z.bindComplementaryBlock(this.A);
        if (!z2) {
            this.R.sendClosedAdvertShowDescription(this.C);
        }
    }

    @Override // com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapView.Listener
    public void onShowOnMapClick(@NotNull AdvertDetailsShowOnMapItem advertDetailsShowOnMapItem) {
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapItem, "item");
        onAddressClick(advertDetailsShowOnMapItem.getAddress(), advertDetailsShowOnMapItem.getCoords(), advertDetailsShowOnMapItem.getTitle(), GeoFromBlock.MAP_PREVIEW);
    }

    @Override // com.avito.android.advert.item.similars_button.SimilarsButtonClickListener
    public void onSimilarsButtonClicked(@Nullable DeepLink deepLink) {
        if (deepLink != null) {
            AdvertDetailsRouter advertDetailsRouter = this.h;
            if (advertDetailsRouter != null) {
                advertDetailsRouter.followDeeplinkWithTreeParent(deepLink, this.R.getParent());
            }
            this.R.sendSimilarsButtonClick(this.C);
        }
    }

    @Override // com.avito.android.advert.item.consultation.AdvertDetailsConsultationView.Listener
    public void onSubmitConsultationRequestClick() {
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            advertDetailsView.showConsultationForm(this.C);
        }
        this.R.sendClickToConsultationItemButton(this.C);
    }

    @Override // com.avito.android.advert.item.verification.AdvertVerificationPresenter.OnHelpCenterClickedListener
    public void onVerificationHelpCenterClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "helpCenterLink");
        AdvertDetailsRouter advertDetailsRouter = this.h;
        if (advertDetailsRouter != null) {
            advertDetailsRouter.openHelpCenterScreen(str);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void refresh() {
        f(true);
        start();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void showLoadingIndicatorAfterOnActivityResult() {
        AdvertDetailsView advertDetailsView = this.q;
        if (advertDetailsView != null) {
            advertDetailsView.onLoadingStart();
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void start() {
        Observable<SectionResponse> observable;
        Observable<List<PositionedBannerContainer>> observable2;
        this.S.restart();
        g();
        if (this.e == null) {
            this.S.startComplementaryLoading();
            boolean isSimilarsLoaded = this.z.isSimilarsLoaded();
            if (isSimilarsLoaded) {
                observable = Observable.just(this.z.getSectionsData());
            } else if (!isSimilarsLoaded) {
                observable = this.t.getComplementaryItems().doOnNext(new a2.a.a.f.x.h(this)).doOnError(new a2.a.a.f.x.i(this));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            AdvertDetails c2 = c();
            if (c2 != null && c2.isMarketplace()) {
                observable2 = Observable.empty();
            } else if (this.z.isCommercialsLoaded()) {
                observable2 = Observable.just(this.z.getCommercials());
            } else {
                observable2 = this.t.getCommercials(c());
            }
            ReplayRelay<LoadingState<Object>> replayRelay = this.l;
            Intrinsics.checkNotNullExpressionValue(replayRelay, "loadingRelay");
            Intrinsics.checkNotNullExpressionValue(observable, "complementaryLoader");
            Observable zipWith = ObservablesKt.zipWith(replayRelay, observable);
            Intrinsics.checkNotNullExpressionValue(observable2, "commercialsLoader");
            Observable combineLatest = Observable.combineLatest(zipWith, observable2, new BiFunction<T1, T2, R>() { // from class: com.avito.android.advert.item.AdvertDetailsPresenterImpl$startComplementaryRequest$$inlined$combineLatestWith$1
                @Override // io.reactivex.rxjava3.functions.BiFunction
                public final R apply(T1 t1, T2 t2) {
                    Intrinsics.checkNotNullExpressionValue(t1, "t1");
                    Intrinsics.checkNotNullExpressionValue(t2, "t2");
                    T1 t12 = t1;
                    return (R) new Triple(t12.getFirst(), t12.getSecond(), t2);
                }
            });
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
            Observable<Set<FavoriteSeller>> observable3 = this.X.getSellers().toObservable();
            Intrinsics.checkNotNullExpressionValue(observable3, "sellerRepository.getSellers().toObservable()");
            Observable combineLatest2 = Observable.combineLatest(combineLatest, observable3, new BiFunction<T1, T2, R>() { // from class: com.avito.android.advert.item.AdvertDetailsPresenterImpl$startComplementaryRequest$$inlined$combineLatestWith$2
                /* JADX WARN: Type inference failed for: r3v1, types: [R, kotlin.Triple] */
                @Override // io.reactivex.rxjava3.functions.BiFunction
                public final R apply(T1 t1, T2 t2) {
                    Intrinsics.checkNotNullExpressionValue(t1, "t1");
                    Intrinsics.checkNotNullExpressionValue(t2, "t2");
                    T2 t22 = t2;
                    T1 t12 = t1;
                    AdvertDetailsPresenterImpl advertDetailsPresenterImpl = AdvertDetailsPresenterImpl.this;
                    Intrinsics.checkNotNullExpressionValue(t22, SellersTrackerModule.NAME);
                    AdvertDetailsPresenterImpl.access$updateFavoriteSellersState(advertDetailsPresenterImpl, t22, ((SectionResponse) t12.getSecond()).getSections());
                    return t12;
                }
            });
            Intrinsics.checkNotNullExpressionValue(combineLatest2, "Observable.combineLatest…ombineFunction(t1, t2) })");
            this.e = combineLatest2.observeOn(this.J.mainThread()).subscribe(new a2.a.a.f.x.g(this));
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void stop() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.f;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.b;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.g;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        this.S.stop();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void trackEnableNotificationClick() {
        this.R.sendClickToEnableNotifications(this.C);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsPresenter
    public void updateContacts() {
        this.j = true;
        f(false);
        this.S.restart();
        g();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsPresenterImpl(AdvertDetailsInteractor advertDetailsInteractor, AdvertContactsPresenter advertContactsPresenter, AdvertSafeDealPresenter advertSafeDealPresenter, AdvertSellerPresenter advertSellerPresenter, MarketplacePresenter marketplacePresenter, AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, AdvertComplementaryPresenter advertComplementaryPresenter, AdvertDetailsItemsPresenter advertDetailsItemsPresenter, AccountStateProvider accountStateProvider, String str, String str2, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, long j2, ProfileInfoStorage profileInfoStorage, ClipboardManager clipboardManager, ClipDataFactory clipDataFactory, SchedulersFactory3 schedulersFactory3, SellerStatusProvider sellerStatusProvider, FavoriteAdvertsPresenter favoriteAdvertsPresenter, AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter, AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter, AdvertDetailsNotePresenter advertDetailsNotePresenter, AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter, AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, AdvertDetailsTracker advertDetailsTracker, Analytics analytics, Preferences preferences, NotificationManagerProvider notificationManagerProvider, Observable observable, FavoriteSellersRepository favoriteSellersRepository, AbTestGroup abTestGroup, QuestionnairePresenter questionnairePresenter, MarketplaceDeliveryStorage marketplaceDeliveryStorage, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features, ManuallyExposedAbTestGroup manuallyExposedAbTestGroup, int i2, int i3, t6.r.a.j jVar) {
        this(advertDetailsInteractor, advertContactsPresenter, advertSafeDealPresenter, advertSellerPresenter, marketplacePresenter, advertDetailsToolbarPresenter, advertComplementaryPresenter, advertDetailsItemsPresenter, accountStateProvider, str, str2, advertDetailsFastOpenParams, (i2 & 4096) != 0 ? 0 : j2, profileInfoStorage, clipboardManager, clipDataFactory, schedulersFactory3, sellerStatusProvider, favoriteAdvertsPresenter, advertDetailsAutotekaPresenter, advertDetailsAutotekaTeaserPresenter, advertDetailsNotePresenter, advertDetailsShortTermRentPresenter, advertDetailsFavoriteInteractor, advertDetailsAnalyticsInteractor, advertDetailsTracker, analytics, preferences, notificationManagerProvider, observable, favoriteSellersRepository, abTestGroup, questionnairePresenter, marketplaceDeliveryStorage, compositeSnackbarPresenter, features, manuallyExposedAbTestGroup);
    }
}
