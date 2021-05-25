package com.avito.android.advert.item;

import a2.a.a.f.x.c;
import a2.a.a.f.x.d;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsActivity;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.AdvertDetailsToolbarView;
import com.avito.android.advert.AdvertDetailsToolbarViewImpl;
import com.avito.android.advert.di.AdvertFragmentComponent;
import com.avito.android.advert.di.AdvertFragmentDependencies;
import com.avito.android.advert.di.DaggerAdvertFragmentComponent;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerPresenter;
import com.avito.android.advert.item.address.AdvertDetailsAddressPresenter;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenter;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.booking.AdvertBookingPresenter;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationPresenter;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionPresenter;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactory;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionPresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule;
import com.avito.android.advert.notes.EditAdvertNoteActivityKt;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.contactbar.AddToCartData;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.screens.AdvertScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.delivery.DeliveryActivityInteractionConstants;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.express_cv.ExpressCvConstants;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.WeakConsumer;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedDestroyable;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 á\u00042\u00020\u00012\u00020\u00022\u00020\u0003:\u0002á\u0004B\b¢\u0006\u0005\bà\u0004\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0014R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R+\u0010H\u001a\u00020@2\u0006\u0010A\u001a\u00020@8B@BX\u0002¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R*\u0010»\u0001\u001a\u00030º\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R*\u0010Â\u0001\u001a\u00030Á\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R*\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R7\u0010Ö\u0001\u001a\u0005\u0018\u00010Ï\u00012\t\u0010A\u001a\u0005\u0018\u00010Ï\u00018\u0006@GX\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R\u001c\u0010Ú\u0001\u001a\u0005\u0018\u00010×\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R*\u0010Ü\u0001\u001a\u00030Û\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÜ\u0001\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R*\u0010ã\u0001\u001a\u00030â\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R*\u0010ê\u0001\u001a\u00030é\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bê\u0001\u0010ë\u0001\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R*\u0010ñ\u0001\u001a\u00030ð\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bñ\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010ú\u0001\u001a\u00030÷\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R*\u0010ü\u0001\u001a\u00030û\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bü\u0001\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\u001c\u0010¦\u0002\u001a\u0005\u0018\u00010£\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R*\u0010¨\u0002\u001a\u00030§\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¨\u0002\u0010©\u0002\u001a\u0006\bª\u0002\u0010«\u0002\"\u0006\b¬\u0002\u0010­\u0002R*\u0010¯\u0002\u001a\u00030®\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¯\u0002\u0010°\u0002\u001a\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R*\u0010¶\u0002\u001a\u00030µ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R*\u0010½\u0002\u001a\u00030¼\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b½\u0002\u0010¾\u0002\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0006\bÁ\u0002\u0010Â\u0002R*\u0010Ä\u0002\u001a\u00030Ã\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÄ\u0002\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002\"\u0006\bÈ\u0002\u0010É\u0002R*\u0010Ë\u0002\u001a\u00030Ê\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bË\u0002\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002\"\u0006\bÏ\u0002\u0010Ð\u0002R*\u0010Ò\u0002\u001a\u00030Ñ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÒ\u0002\u0010Ó\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002\"\u0006\bÖ\u0002\u0010×\u0002R*\u0010Ù\u0002\u001a\u00030Ø\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÙ\u0002\u0010Ú\u0002\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R*\u0010à\u0002\u001a\u00030ß\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bà\u0002\u0010á\u0002\u001a\u0006\bâ\u0002\u0010ã\u0002\"\u0006\bä\u0002\u0010å\u0002R*\u0010ç\u0002\u001a\u00030æ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bç\u0002\u0010è\u0002\u001a\u0006\bé\u0002\u0010ê\u0002\"\u0006\bë\u0002\u0010ì\u0002R\u001a\u0010ð\u0002\u001a\u00030í\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bî\u0002\u0010ï\u0002R*\u0010ò\u0002\u001a\u00030ñ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bò\u0002\u0010ó\u0002\u001a\u0006\bô\u0002\u0010õ\u0002\"\u0006\bö\u0002\u0010÷\u0002R*\u0010ù\u0002\u001a\u00030ø\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bù\u0002\u0010ú\u0002\u001a\u0006\bû\u0002\u0010ü\u0002\"\u0006\bý\u0002\u0010þ\u0002R*\u0010\u0003\u001a\u00030ÿ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0003\u0010\u0003\u001a\u0006\b\u0003\u0010\u0003\"\u0006\b\u0003\u0010\u0003R*\u0010\u0003\u001a\u00030\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0003\u0010\u0003\u001a\u0006\b\u0003\u0010\u0003\"\u0006\b\u0003\u0010\u0003R\u001a\u0010\u0003\u001a\u00030×\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0003\u0010Ù\u0001R*\u0010\u0003\u001a\u00030\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0003\u0010\u0003\u001a\u0006\b\u0003\u0010\u0003\"\u0006\b\u0003\u0010\u0003R*\u0010\u0003\u001a\u00030\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0003\u0010\u0003\u001a\u0006\b\u0003\u0010\u0003\"\u0006\b\u0003\u0010\u0003R*\u0010\u0003\u001a\u00030\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0003\u0010\u0003\u001a\u0006\b \u0003\u0010¡\u0003\"\u0006\b¢\u0003\u0010£\u0003R*\u0010¥\u0003\u001a\u00030¤\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0003\u0010¦\u0003\u001a\u0006\b§\u0003\u0010¨\u0003\"\u0006\b©\u0003\u0010ª\u0003R\u0019\u0010¬\u0003\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b«\u0003\u0010\u0002R*\u0010®\u0003\u001a\u00030­\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b®\u0003\u0010¯\u0003\u001a\u0006\b°\u0003\u0010±\u0003\"\u0006\b²\u0003\u0010³\u0003R*\u0010µ\u0003\u001a\u00030´\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bµ\u0003\u0010¶\u0003\u001a\u0006\b·\u0003\u0010¸\u0003\"\u0006\b¹\u0003\u0010º\u0003R*\u0010¼\u0003\u001a\u00030»\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¼\u0003\u0010½\u0003\u001a\u0006\b¾\u0003\u0010¿\u0003\"\u0006\bÀ\u0003\u0010Á\u0003R*\u0010Ã\u0003\u001a\u00030Â\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÃ\u0003\u0010Ä\u0003\u001a\u0006\bÅ\u0003\u0010Æ\u0003\"\u0006\bÇ\u0003\u0010È\u0003R*\u0010Ê\u0003\u001a\u00030É\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÊ\u0003\u0010Ë\u0003\u001a\u0006\bÌ\u0003\u0010Í\u0003\"\u0006\bÎ\u0003\u0010Ï\u0003R*\u0010Ñ\u0003\u001a\u00030Ð\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÑ\u0003\u0010Ò\u0003\u001a\u0006\bÓ\u0003\u0010Ô\u0003\"\u0006\bÕ\u0003\u0010Ö\u0003R*\u0010Þ\u0003\u001a\u00030×\u00038\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\bØ\u0003\u0010Ù\u0003\u001a\u0006\bÚ\u0003\u0010Û\u0003\"\u0006\bÜ\u0003\u0010Ý\u0003R\u001c\u0010â\u0003\u001a\u0005\u0018\u00010ß\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bà\u0003\u0010á\u0003R*\u0010ä\u0003\u001a\u00030ã\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bä\u0003\u0010å\u0003\u001a\u0006\bæ\u0003\u0010ç\u0003\"\u0006\bè\u0003\u0010é\u0003R*\u0010ë\u0003\u001a\u00030ê\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bë\u0003\u0010ì\u0003\u001a\u0006\bí\u0003\u0010î\u0003\"\u0006\bï\u0003\u0010ð\u0003R*\u0010ò\u0003\u001a\u00030ñ\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bò\u0003\u0010ó\u0003\u001a\u0006\bô\u0003\u0010õ\u0003\"\u0006\bö\u0003\u0010÷\u0003R*\u0010ù\u0003\u001a\u00030ø\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\bù\u0003\u0010ú\u0003\u001a\u0006\bû\u0003\u0010ü\u0003\"\u0006\bý\u0003\u0010þ\u0003R*\u0010\u0004\u001a\u00030ÿ\u00038\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0004\u0010\u0004\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b\u0004\u0010\u0004R*\u0010\u0004\u001a\u00030\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0004\u0010\u0004\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b\u0004\u0010\u0004R*\u0010\u0004\u001a\u00030\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0004\u0010\u0004\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b\u0004\u0010\u0004R*\u0010\u0004\u001a\u00030\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0004\u0010\u0004\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b\u0004\u0010\u0004R*\u0010\u0004\u001a\u00030\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0004\u0010\u0004\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b \u0004\u0010¡\u0004R*\u0010£\u0004\u001a\u00030¢\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b£\u0004\u0010¤\u0004\u001a\u0006\b¥\u0004\u0010¦\u0004\"\u0006\b§\u0004\u0010¨\u0004R1\u0010ª\u0004\u001a\u00030©\u00048\u0006@\u0006X.¢\u0006\u001f\n\u0006\bª\u0004\u0010«\u0004\u0012\u0005\b°\u0004\u0010\u0014\u001a\u0006\b¬\u0004\u0010­\u0004\"\u0006\b®\u0004\u0010¯\u0004R1\u0010²\u0004\u001a\n\u0012\u0005\u0012\u00030×\u00010±\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b²\u0004\u0010³\u0004\u001a\u0006\b´\u0004\u0010µ\u0004\"\u0006\b¶\u0004\u0010·\u0004R*\u0010¹\u0004\u001a\u00030¸\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¹\u0004\u0010º\u0004\u001a\u0006\b»\u0004\u0010¼\u0004\"\u0006\b½\u0004\u0010¾\u0004R1\u0010¿\u0004\u001a\u00030©\u00048\u0006@\u0006X.¢\u0006\u001f\n\u0006\b¿\u0004\u0010«\u0004\u0012\u0005\bÂ\u0004\u0010\u0014\u001a\u0006\bÀ\u0004\u0010­\u0004\"\u0006\bÁ\u0004\u0010¯\u0004R\u001a\u0010Æ\u0004\u001a\u00030Ã\u00048\u0002@\u0002X.¢\u0006\b\n\u0006\bÄ\u0004\u0010Å\u0004R\u001a\u0010Ê\u0004\u001a\u00030Ç\u00048\u0002@\u0002X.¢\u0006\b\n\u0006\bÈ\u0004\u0010É\u0004R*\u0010Ì\u0004\u001a\u00030Ë\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÌ\u0004\u0010Í\u0004\u001a\u0006\bÎ\u0004\u0010Ï\u0004\"\u0006\bÐ\u0004\u0010Ñ\u0004R*\u0010Ó\u0004\u001a\u00030Ò\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÓ\u0004\u0010Ô\u0004\u001a\u0006\bÕ\u0004\u0010Ö\u0004\"\u0006\b×\u0004\u0010Ø\u0004R*\u0010Ú\u0004\u001a\u00030Ù\u00048\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÚ\u0004\u0010Û\u0004\u001a\u0006\bÜ\u0004\u0010Ý\u0004\"\u0006\bÞ\u0004\u0010ß\u0004¨\u0006â\u0004"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/advert/item/AdvertDetailsCallbacks;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "outState", "onSaveInstanceState", "onStart", "onStop", "onResume", "onPause", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "()Z", "intent", "startForResultProxy", "(Landroid/content/Intent;I)V", "onLoadFailed", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "getSpanProvider", "()Lcom/avito/android/serp/adapter/SerpSpanProvider;", "setSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "itemsSafeRecyclerAdapter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "getItemsSafeRecyclerAdapter", "()Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "setItemsSafeRecyclerAdapter", "(Lcom/avito/android/recycler/base/SafeRecyclerAdapter;)V", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safedealPresenter", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "getSafedealPresenter", "()Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "setSafedealPresenter", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;)V", "Lcom/avito/android/advert/item/AdvertDetailsView;", "<set-?>", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedDestroyable;", "c", "()Lcom/avito/android/advert/item/AdvertDetailsView;", "setItemDetailsView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "itemDetailsView", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "s", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "fastOpenData", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "tracker", "Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "getTracker", "()Lcom/avito/android/advert/tracker/AdvertDetailsTracker;", "setTracker", "(Lcom/avito/android/advert/tracker/AdvertDetailsTracker;)V", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenter;", "advertDetailsAutoCatalogPresenter", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenter;", "getAdvertDetailsAutoCatalogPresenter", "()Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenter;", "setAdvertDetailsAutoCatalogPresenter", "(Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogPresenter;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenter;", "advertDetailsShowOnMapPresenter", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenter;", "getAdvertDetailsShowOnMapPresenter", "()Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenter;", "setAdvertDetailsShowOnMapPresenter", "(Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapPresenter;)V", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;", "badgeBarPresenter", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;", "getBadgeBarPresenter", "()Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;", "setBadgeBarPresenter", "(Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;)V", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter;", "creGeoReportPresenter", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter;", "getCreGeoReportPresenter", "()Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter;", "setCreGeoReportPresenter", "(Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", VKApiConst.VERSION, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartFabQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartFabQuantityHandler", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartFabQuantityHandler", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "safeDealServicesPresenter", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "getSafeDealServicesPresenter", "()Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "setSafeDealServicesPresenter", "(Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;)V", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "sellerSubscriptionPresenter", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "getSellerSubscriptionPresenter", "()Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "setSellerSubscriptionPresenter", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;)V", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "domotekaTeaserInteractor", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "getDomotekaTeaserInteractor", "()Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "setDomotekaTeaserInteractor", "(Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;)V", "Lcom/avito/android/section/SectionItemPresenter;", "sectionItemPresenter", "Lcom/avito/android/section/SectionItemPresenter;", "getSectionItemPresenter", "()Lcom/avito/android/section/SectionItemPresenter;", "setSectionItemPresenter", "(Lcom/avito/android/section/SectionItemPresenter;)V", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "autotekaPresenter", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "getAutotekaPresenter", "()Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "setAutotekaPresenter", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;)V", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "creditBrokerAnalyticsInteractor", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "getCreditBrokerAnalyticsInteractor", "()Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "setCreditBrokerAnalyticsInteractor", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;)V", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "j", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "getMarketplacePresenter", "()Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "setMarketplacePresenter", "(Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;)V", "marketplacePresenter", "", "r", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableComplementaryViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableComplementaryViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableComplementaryViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "promoCardPresenter", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "getPromoCardPresenter", "()Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "setPromoCardPresenter", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;)V", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "deliveryPresenter", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "getDeliveryPresenter", "()Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "setDeliveryPresenter", "(Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;)V", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "o", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "advertDetailsRouter", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "u", "Z", "isNecessaryToShowLoadingIndicatorAfterOnActivityResult", "t", "isMarketplace", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "marketplaceDeliveryPresenter", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "getMarketplaceDeliveryPresenter", "()Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "setMarketplaceDeliveryPresenter", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "advertDetailsCreditInfoPresenter", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "getAdvertDetailsCreditInfoPresenter", "()Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "setAdvertDetailsCreditInfoPresenter", "(Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;)V", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "autotekaTeaserPresenter", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "getAutotekaTeaserPresenter", "()Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "setAutotekaTeaserPresenter", "(Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;)V", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenter;", "descriptionPresenter", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenter;", "getDescriptionPresenter", "()Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenter;", "setDescriptionPresenter", "(Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenter;)V", "Lio/reactivex/disposables/Disposable;", "x", "Lio/reactivex/disposables/Disposable;", "keyboardVisibilitySubscription", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "autotekaDetailsInteractor", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "getAutotekaDetailsInteractor", "()Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "setAutotekaDetailsInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;)V", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "questionnairePresenter", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "getQuestionnairePresenter", "()Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "setQuestionnairePresenter", "(Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;)V", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationPresenter;", "advertDetailsConsultationPresenter", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationPresenter;", "getAdvertDetailsConsultationPresenter", "()Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationPresenter;", "setAdvertDetailsConsultationPresenter", "(Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationPresenter;)V", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressPresenter;", "addressPresenter", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressPresenter;", "getAddressPresenter", "()Lcom/avito/android/advert/item/address/AdvertDetailsAddressPresenter;", "setAddressPresenter", "(Lcom/avito/android/advert/item/address/AdvertDetailsAddressPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;", "geoReferencePresenter", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;", "getGeoReferencePresenter", "()Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;", "setGeoReferencePresenter", "(Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "creditViewModelFactory", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "getCreditViewModelFactory", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;", "setCreditViewModelFactory", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModelFactory;)V", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "shortTermRentPresenter", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "getShortTermRentPresenter", "()Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "setShortTermRentPresenter", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;)V", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;", "advertDetailsRatingPublishPresenter", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;", "getAdvertDetailsRatingPublishPresenter", "()Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;", "setAdvertDetailsRatingPublishPresenter", "(Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Landroid/os/Handler;", "y", "Landroid/os/Handler;", "handler", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/account/AccountStateProvider;", "getAccountStatus", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountStatus", "(Lcom/avito/android/account/AccountStateProvider;)V", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "sellerPresenter", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "getSellerPresenter", "()Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "setSellerPresenter", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;)V", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "recommendationPresenter", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "getRecommendationPresenter", "()Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "setRecommendationPresenter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;)V", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "similarAdvertResources", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "getSimilarAdvertResources", "()Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "setSimilarAdvertResources", "(Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;)V", "k", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "presenter", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "setPresenter", "(Lcom/avito/android/advert/item/AdvertDetailsPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/section/action/SectionActionPresenter;", "sectionActionPresenter", "Lcom/avito/android/section/action/SectionActionPresenter;", "getSectionActionPresenter", "()Lcom/avito/android/section/action/SectionActionPresenter;", "setSectionActionPresenter", "(Lcom/avito/android/section/action/SectionActionPresenter;)V", "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter;", "bookingPresenter", "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter;", "getBookingPresenter", "()Lcom/avito/android/advert/item/booking/AdvertBookingPresenter;", "setBookingPresenter", "(Lcom/avito/android/advert/item/booking/AdvertBookingPresenter;)V", "p", "isPresentersStarted", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;", "iceBreakersPresenter", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;", "getIceBreakersPresenter", "()Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;", "setIceBreakersPresenter", "(Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactsPresenter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "getContactsPresenter", "()Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "setContactsPresenter", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;)V", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "imvChartPresenter", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "getImvChartPresenter", "()Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "setImvChartPresenter", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;)V", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "w", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/advert/AdvertDetailsToolbarView;", VKApiConst.Q, "Lcom/avito/android/advert/AdvertDetailsToolbarView;", "advertDetailsToolbarView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "sectionsAdapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getSectionsAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setSectionsAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "imvBadgePresenter", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "getImvBadgePresenter", "()Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "setImvBadgePresenter", "(Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;)V", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "advertDetailsDeliveryInfoPresenter", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "getAdvertDetailsDeliveryInfoPresenter", "()Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "setAdvertDetailsDeliveryInfoPresenter", "(Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "advertDetailsToolbarPresenter", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "getAdvertDetailsToolbarPresenter", "()Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "setAdvertDetailsToolbarPresenter", "(Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;)V", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", "additionalSellerPresenter", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", "getAdditionalSellerPresenter", "()Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", "setAdditionalSellerPresenter", "(Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;)V", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "autotekaTeaserInteractor", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "getAutotekaTeaserInteractor", "()Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "setAutotekaTeaserInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;)V", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionPresenter;", "advertDetailsPriceSubscriptionPresenter", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionPresenter;", "getAdvertDetailsPriceSubscriptionPresenter", "()Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionPresenter;", "setAdvertDetailsPriceSubscriptionPresenter", "(Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionPresenter;)V", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;", "domotekaTeaserPresenter", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;", "getDomotekaTeaserPresenter", "()Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;", "setDomotekaTeaserPresenter", "(Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;)V", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "replacementsPresenter", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "getReplacementsPresenter", "()Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "setReplacementsPresenter", "(Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;)V", "getReplacementsPresenter$annotations", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "getPhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "setPhoneNumberFormatter", "(Lcom/avito/android/util/Formatter;)V", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "notePresenter", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "getNotePresenter", "()Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "setNotePresenter", "(Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;)V", "compatibilitiesPresenter", "getCompatibilitiesPresenter", "setCompatibilitiesPresenter", "getCompatibilitiesPresenter$annotations", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "l", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "dfpCreditViewModel", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "n", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "advertDetailsFragmentDelegate", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "advertDetailsItemsPresenter", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "getAdvertDetailsItemsPresenter", "()Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "setAdvertDetailsItemsPresenter", "(Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;)V", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "advertDetailsGuidePresenter", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "getAdvertDetailsGuidePresenter", "()Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "setAdvertDetailsGuidePresenter", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;)V", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "advertComplementaryPresenter", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "getAdvertComplementaryPresenter", "()Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "setAdvertComplementaryPresenter", "(Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;)V", "<init>", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFragment extends TabBaseFragment implements AdvertDetailsCallbacks, OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "AdvertDetailsFragment";
    public static final /* synthetic */ KProperty[] z = {a2.b.a.a.a.u0(AdvertDetailsFragment.class, "itemDetailsView", "getItemDetailsView()Lcom/avito/android/advert/item/AdvertDetailsView;", 0)};
    @Inject
    public AccountStateProvider accountStatus;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdditionalSellerPresenter additionalSellerPresenter;
    @Inject
    public AdvertDetailsAddressPresenter addressPresenter;
    @Inject
    public AdvertComplementaryPresenter advertComplementaryPresenter;
    @Inject
    public AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter;
    @Inject
    public AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter;
    @Inject
    public AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter;
    @Inject
    public AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter;
    @Inject
    public AdvertDetailsGuidePresenter advertDetailsGuidePresenter;
    @Inject
    public AdvertDetailsItemsPresenter advertDetailsItemsPresenter;
    @Inject
    public AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter;
    @Inject
    public AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter;
    @Inject
    public AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter;
    @Inject
    public AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public AdvertDetailsAnalyticsInteractor analyticsInteractor;
    @Inject
    public AutotekaDetailsInteractor autotekaDetailsInteractor;
    @Inject
    public AdvertDetailsAutotekaPresenter autotekaPresenter;
    @Inject
    public AutotekaTeaserInteractor autotekaTeaserInteractor;
    @Inject
    public AdvertDetailsAutotekaTeaserPresenter autotekaTeaserPresenter;
    @Inject
    public AdvertBadgeBarPresenter badgeBarPresenter;
    @Inject
    public AdvertBookingPresenter bookingPresenter;
    @Inject
    public CartQuantityChangesHandler cartFabQuantityHandler;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public SparePartsPresenter compatibilitiesPresenter;
    @Inject
    public AdvertContactsPresenter contactsPresenter;
    @Inject
    public AdvertDetailsGeoReportTeaserPresenter creGeoReportPresenter;
    @Inject
    public CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor;
    @Inject
    public DfpCreditViewModelFactory creditViewModelFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public AdvertDeliveryPresenter deliveryPresenter;
    @Inject
    public AdvertDetailsDescriptionPresenter descriptionPresenter;
    @Inject
    public DestroyableViewHolderBuilder destroyableComplementaryViewHolderBuilder;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public DomotekaTeaserInteractor domotekaTeaserInteractor;
    @Inject
    public AdvertDetailsDomotekaTeaserPresenter domotekaTeaserPresenter;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public Features features;
    @Inject
    public AdvertDetailsGeoReferencePresenter geoReferencePresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public AdvertDetailsIceBreakersPresenter iceBreakersPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public AdvertDetailsImvBadgePresenter imvBadgePresenter;
    @Inject
    public CarMarketPriceChartPresenter imvChartPresenter;
    @Inject
    public ItemVisibilityTracker itemVisibilityTracker;
    @Inject
    public SafeRecyclerAdapter itemsSafeRecyclerAdapter;
    @Nullable
    public MarketplacePresenter j;
    public String k;
    public DfpCreditViewModel l;
    public final AutoClearedDestroyable m = new AutoClearedDestroyable();
    @Inject
    public MarketplaceDeliveryPresenter marketplaceDeliveryPresenter;
    public AdvertDetailsFragmentDelegate n;
    @Inject
    public AdvertDetailsNotePresenter notePresenter;
    public AdvertDetailsRouter o;
    public boolean p;
    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    @Inject
    public Formatter<String> phoneNumberFormatter;
    @Inject
    public AdvertDetailsPresenter presenter;
    @Inject
    public PromoCardItemPresenter promoCardPresenter;
    public AdvertDetailsToolbarView q;
    @Inject
    public QuestionnairePresenter questionnairePresenter;
    public String r;
    @Inject
    public RecommendationItemPresenter recommendationPresenter;
    @Inject
    public SparePartsPresenter replacementsPresenter;
    public AdvertDetailsFastOpenParams s;
    @Inject
    public AdvertDetailsSafeDealServicesPresenter safeDealServicesPresenter;
    @Inject
    public AdvertSafeDealPresenter safedealPresenter;
    @Inject
    public SectionActionPresenter sectionActionPresenter;
    @Inject
    public SectionItemPresenter sectionItemPresenter;
    @Inject
    public AdapterPresenter sectionsAdapterPresenter;
    @Inject
    public AdvertSellerPresenter sellerPresenter;
    @Inject
    public SellerSubscriptionPresenter sellerSubscriptionPresenter;
    @Inject
    public AdvertDetailsShortTermRentPresenter shortTermRentPresenter;
    @Inject
    public AdvertSimilarPresenterResourceProvider similarAdvertResources;
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;
    @Inject
    public SerpSpanProvider spanProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public FpsStateSupplier supplier;
    public boolean t;
    @Inject
    public AdvertDetailsTracker tracker;
    public boolean u;
    public final CompositeDisposable v = new CompositeDisposable();
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;
    @NotNull
    public NavigationState w = new NavigationState(false);
    public Disposable x;
    public final Handler y = new Handler();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsFragment$Companion;", "", "Lcom/avito/android/advert/item/AdvertDetailsArguments;", "arguments", "Lcom/avito/android/advert/item/AdvertDetailsFragment;", "newInstance", "(Lcom/avito/android/advert/item/AdvertDetailsArguments;)Lcom/avito/android/advert/item/AdvertDetailsFragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ AdvertDetailsArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AdvertDetailsArguments advertDetailsArguments) {
                super(1);
                this.a = advertDetailsArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("advert_details_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final AdvertDetailsFragment newInstance(@NotNull AdvertDetailsArguments advertDetailsArguments) {
            Intrinsics.checkNotNullParameter(advertDetailsArguments, "arguments");
            return (AdvertDetailsFragment) FragmentsKt.arguments$default(new AdvertDetailsFragment(), 0, new a(advertDetailsArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsFragment advertDetailsFragment) {
            super(0);
            this.a = advertDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getPresenter().updateContacts();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<Integer> {
        public final /* synthetic */ AdvertDetailsFragment a;

        public b(AdvertDetailsFragment advertDetailsFragment) {
            this.a = advertDetailsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.getRecommendationPresenter().resetAutoScroll();
        }
    }

    public static final /* synthetic */ AdvertDetailsRouter access$getAdvertDetailsRouter$p(AdvertDetailsFragment advertDetailsFragment) {
        AdvertDetailsRouter advertDetailsRouter = advertDetailsFragment.o;
        if (advertDetailsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        return advertDetailsRouter;
    }

    public static final void access$openUri(AdvertDetailsFragment advertDetailsFragment, Context context, Uri uri) {
        Objects.requireNonNull(advertDetailsFragment);
        Intent data = new CustomTabsIntent.Builder().setToolbarColor(Contexts.getColorCompat(context, R.color.avito_white)).setShowTitle(false).build().intent.setData(uri);
        Intrinsics.checkNotNullExpressionValue(data, "CustomTabsIntent.Builder…            .setData(uri)");
        advertDetailsFragment.startActivity(data);
    }

    public static final void access$setItemDetailsView$p(AdvertDetailsFragment advertDetailsFragment, AdvertDetailsView advertDetailsView) {
        advertDetailsFragment.m.setValue((Fragment) advertDetailsFragment, z[0], (KProperty<?>) advertDetailsView);
    }

    @SparePartsModule.CompatibilitiesPresenter
    public static /* synthetic */ void getCompatibilitiesPresenter$annotations() {
    }

    @SparePartsModule.ReplacementsPresenter
    public static /* synthetic */ void getReplacementsPresenter$annotations() {
    }

    public final AdvertDetailsView c() {
        return (AdvertDetailsView) this.m.getValue((Fragment) this, z[0]);
    }

    @NotNull
    public final AccountStateProvider getAccountStatus() {
        AccountStateProvider accountStateProvider = this.accountStatus;
        if (accountStateProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountStatus");
        }
        return accountStateProvider;
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final AdditionalSellerPresenter getAdditionalSellerPresenter() {
        AdditionalSellerPresenter additionalSellerPresenter2 = this.additionalSellerPresenter;
        if (additionalSellerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("additionalSellerPresenter");
        }
        return additionalSellerPresenter2;
    }

    @NotNull
    public final AdvertDetailsAddressPresenter getAddressPresenter() {
        AdvertDetailsAddressPresenter advertDetailsAddressPresenter = this.addressPresenter;
        if (advertDetailsAddressPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressPresenter");
        }
        return advertDetailsAddressPresenter;
    }

    @NotNull
    public final AdvertComplementaryPresenter getAdvertComplementaryPresenter() {
        AdvertComplementaryPresenter advertComplementaryPresenter2 = this.advertComplementaryPresenter;
        if (advertComplementaryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertComplementaryPresenter");
        }
        return advertComplementaryPresenter2;
    }

    @NotNull
    public final AdvertDetailsAutoCatalogPresenter getAdvertDetailsAutoCatalogPresenter() {
        AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter2 = this.advertDetailsAutoCatalogPresenter;
        if (advertDetailsAutoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsAutoCatalogPresenter");
        }
        return advertDetailsAutoCatalogPresenter2;
    }

    @NotNull
    public final AdvertDetailsConsultationPresenter getAdvertDetailsConsultationPresenter() {
        AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter2 = this.advertDetailsConsultationPresenter;
        if (advertDetailsConsultationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsConsultationPresenter");
        }
        return advertDetailsConsultationPresenter2;
    }

    @NotNull
    public final AdvertDetailsCreditInfoPresenter getAdvertDetailsCreditInfoPresenter() {
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter2 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        return advertDetailsCreditInfoPresenter2;
    }

    @NotNull
    public final AdvertDetailsDeliveryInfoPresenter getAdvertDetailsDeliveryInfoPresenter() {
        AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter2 = this.advertDetailsDeliveryInfoPresenter;
        if (advertDetailsDeliveryInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsDeliveryInfoPresenter");
        }
        return advertDetailsDeliveryInfoPresenter2;
    }

    @NotNull
    public final AdvertDetailsGuidePresenter getAdvertDetailsGuidePresenter() {
        AdvertDetailsGuidePresenter advertDetailsGuidePresenter2 = this.advertDetailsGuidePresenter;
        if (advertDetailsGuidePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsGuidePresenter");
        }
        return advertDetailsGuidePresenter2;
    }

    @NotNull
    public final AdvertDetailsItemsPresenter getAdvertDetailsItemsPresenter() {
        AdvertDetailsItemsPresenter advertDetailsItemsPresenter2 = this.advertDetailsItemsPresenter;
        if (advertDetailsItemsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsItemsPresenter");
        }
        return advertDetailsItemsPresenter2;
    }

    @NotNull
    public final AdvertDetailsPriceSubscriptionPresenter getAdvertDetailsPriceSubscriptionPresenter() {
        AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter2 = this.advertDetailsPriceSubscriptionPresenter;
        if (advertDetailsPriceSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsPriceSubscriptionPresenter");
        }
        return advertDetailsPriceSubscriptionPresenter2;
    }

    @NotNull
    public final AdvertDetailsRatingPublishPresenter getAdvertDetailsRatingPublishPresenter() {
        AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter2 = this.advertDetailsRatingPublishPresenter;
        if (advertDetailsRatingPublishPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRatingPublishPresenter");
        }
        return advertDetailsRatingPublishPresenter2;
    }

    @NotNull
    public final AdvertDetailsShowOnMapPresenter getAdvertDetailsShowOnMapPresenter() {
        AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter2 = this.advertDetailsShowOnMapPresenter;
        if (advertDetailsShowOnMapPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsShowOnMapPresenter");
        }
        return advertDetailsShowOnMapPresenter2;
    }

    @NotNull
    public final AdvertDetailsToolbarPresenter getAdvertDetailsToolbarPresenter() {
        AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
        if (advertDetailsToolbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
        }
        return advertDetailsToolbarPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AdvertDetailsAnalyticsInteractor getAnalyticsInteractor() {
        AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.analyticsInteractor;
        if (advertDetailsAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return advertDetailsAnalyticsInteractor;
    }

    @NotNull
    public final AutotekaDetailsInteractor getAutotekaDetailsInteractor() {
        AutotekaDetailsInteractor autotekaDetailsInteractor2 = this.autotekaDetailsInteractor;
        if (autotekaDetailsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaDetailsInteractor");
        }
        return autotekaDetailsInteractor2;
    }

    @NotNull
    public final AdvertDetailsAutotekaPresenter getAutotekaPresenter() {
        AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter = this.autotekaPresenter;
        if (advertDetailsAutotekaPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaPresenter");
        }
        return advertDetailsAutotekaPresenter;
    }

    @NotNull
    public final AutotekaTeaserInteractor getAutotekaTeaserInteractor() {
        AutotekaTeaserInteractor autotekaTeaserInteractor2 = this.autotekaTeaserInteractor;
        if (autotekaTeaserInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserInteractor");
        }
        return autotekaTeaserInteractor2;
    }

    @NotNull
    public final AdvertDetailsAutotekaTeaserPresenter getAutotekaTeaserPresenter() {
        AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter = this.autotekaTeaserPresenter;
        if (advertDetailsAutotekaTeaserPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserPresenter");
        }
        return advertDetailsAutotekaTeaserPresenter;
    }

    @NotNull
    public final AdvertBadgeBarPresenter getBadgeBarPresenter() {
        AdvertBadgeBarPresenter advertBadgeBarPresenter = this.badgeBarPresenter;
        if (advertBadgeBarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgeBarPresenter");
        }
        return advertBadgeBarPresenter;
    }

    @NotNull
    public final AdvertBookingPresenter getBookingPresenter() {
        AdvertBookingPresenter advertBookingPresenter = this.bookingPresenter;
        if (advertBookingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingPresenter");
        }
        return advertBookingPresenter;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartFabQuantityHandler() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartFabQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final SparePartsPresenter getCompatibilitiesPresenter() {
        SparePartsPresenter sparePartsPresenter = this.compatibilitiesPresenter;
        if (sparePartsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compatibilitiesPresenter");
        }
        return sparePartsPresenter;
    }

    @NotNull
    public final AdvertContactsPresenter getContactsPresenter() {
        AdvertContactsPresenter advertContactsPresenter = this.contactsPresenter;
        if (advertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        return advertContactsPresenter;
    }

    @NotNull
    public final AdvertDetailsGeoReportTeaserPresenter getCreGeoReportPresenter() {
        AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter = this.creGeoReportPresenter;
        if (advertDetailsGeoReportTeaserPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creGeoReportPresenter");
        }
        return advertDetailsGeoReportTeaserPresenter;
    }

    @NotNull
    public final CreditBrokerAnalyticsInteractor getCreditBrokerAnalyticsInteractor() {
        CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor2 = this.creditBrokerAnalyticsInteractor;
        if (creditBrokerAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditBrokerAnalyticsInteractor");
        }
        return creditBrokerAnalyticsInteractor2;
    }

    @NotNull
    public final DfpCreditViewModelFactory getCreditViewModelFactory() {
        DfpCreditViewModelFactory dfpCreditViewModelFactory = this.creditViewModelFactory;
        if (dfpCreditViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditViewModelFactory");
        }
        return dfpCreditViewModelFactory;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final AdvertDeliveryPresenter getDeliveryPresenter() {
        AdvertDeliveryPresenter advertDeliveryPresenter = this.deliveryPresenter;
        if (advertDeliveryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryPresenter");
        }
        return advertDeliveryPresenter;
    }

    @NotNull
    public final AdvertDetailsDescriptionPresenter getDescriptionPresenter() {
        AdvertDetailsDescriptionPresenter advertDetailsDescriptionPresenter = this.descriptionPresenter;
        if (advertDetailsDescriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionPresenter");
        }
        return advertDetailsDescriptionPresenter;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getDestroyableComplementaryViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.destroyableComplementaryViewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableComplementaryViewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @NotNull
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final DomotekaTeaserInteractor getDomotekaTeaserInteractor() {
        DomotekaTeaserInteractor domotekaTeaserInteractor2 = this.domotekaTeaserInteractor;
        if (domotekaTeaserInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserInteractor");
        }
        return domotekaTeaserInteractor2;
    }

    @NotNull
    public final AdvertDetailsDomotekaTeaserPresenter getDomotekaTeaserPresenter() {
        AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter = this.domotekaTeaserPresenter;
        if (advertDetailsDomotekaTeaserPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserPresenter");
        }
        return advertDetailsDomotekaTeaserPresenter;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final AdvertDetailsGeoReferencePresenter getGeoReferencePresenter() {
        AdvertDetailsGeoReferencePresenter advertDetailsGeoReferencePresenter = this.geoReferencePresenter;
        if (advertDetailsGeoReferencePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("geoReferencePresenter");
        }
        return advertDetailsGeoReferencePresenter;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
    }

    @NotNull
    public final AdvertDetailsIceBreakersPresenter getIceBreakersPresenter() {
        AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter = this.iceBreakersPresenter;
        if (advertDetailsIceBreakersPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iceBreakersPresenter");
        }
        return advertDetailsIceBreakersPresenter;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final AdvertDetailsImvBadgePresenter getImvBadgePresenter() {
        AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
        if (advertDetailsImvBadgePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
        }
        return advertDetailsImvBadgePresenter;
    }

    @NotNull
    public final CarMarketPriceChartPresenter getImvChartPresenter() {
        CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
        if (carMarketPriceChartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
        }
        return carMarketPriceChartPresenter;
    }

    @NotNull
    public final ItemVisibilityTracker getItemVisibilityTracker() {
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        return itemVisibilityTracker2;
    }

    @NotNull
    public final SafeRecyclerAdapter getItemsSafeRecyclerAdapter() {
        SafeRecyclerAdapter safeRecyclerAdapter = this.itemsSafeRecyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsSafeRecyclerAdapter");
        }
        return safeRecyclerAdapter;
    }

    @NotNull
    public final MarketplaceDeliveryPresenter getMarketplaceDeliveryPresenter() {
        MarketplaceDeliveryPresenter marketplaceDeliveryPresenter2 = this.marketplaceDeliveryPresenter;
        if (marketplaceDeliveryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketplaceDeliveryPresenter");
        }
        return marketplaceDeliveryPresenter2;
    }

    @Nullable
    public final MarketplacePresenter getMarketplacePresenter() {
        return this.j;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.w;
    }

    @NotNull
    public final AdvertDetailsNotePresenter getNotePresenter() {
        AdvertDetailsNotePresenter advertDetailsNotePresenter = this.notePresenter;
        if (advertDetailsNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notePresenter");
        }
        return advertDetailsNotePresenter;
    }

    @NotNull
    public final Formatter<String> getPhoneNumberFormatter() {
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        return formatter;
    }

    @NotNull
    public final AdvertDetailsPresenter getPresenter() {
        AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
        if (advertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return advertDetailsPresenter;
    }

    @NotNull
    public final PromoCardItemPresenter getPromoCardPresenter() {
        PromoCardItemPresenter promoCardItemPresenter = this.promoCardPresenter;
        if (promoCardItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promoCardPresenter");
        }
        return promoCardItemPresenter;
    }

    @NotNull
    public final QuestionnairePresenter getQuestionnairePresenter() {
        QuestionnairePresenter questionnairePresenter2 = this.questionnairePresenter;
        if (questionnairePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionnairePresenter");
        }
        return questionnairePresenter2;
    }

    @NotNull
    public final RecommendationItemPresenter getRecommendationPresenter() {
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        return recommendationItemPresenter;
    }

    @NotNull
    public final SparePartsPresenter getReplacementsPresenter() {
        SparePartsPresenter sparePartsPresenter = this.replacementsPresenter;
        if (sparePartsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replacementsPresenter");
        }
        return sparePartsPresenter;
    }

    @NotNull
    public final AdvertDetailsSafeDealServicesPresenter getSafeDealServicesPresenter() {
        AdvertDetailsSafeDealServicesPresenter advertDetailsSafeDealServicesPresenter = this.safeDealServicesPresenter;
        if (advertDetailsSafeDealServicesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeDealServicesPresenter");
        }
        return advertDetailsSafeDealServicesPresenter;
    }

    @NotNull
    public final AdvertSafeDealPresenter getSafedealPresenter() {
        AdvertSafeDealPresenter advertSafeDealPresenter = this.safedealPresenter;
        if (advertSafeDealPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safedealPresenter");
        }
        return advertSafeDealPresenter;
    }

    @NotNull
    public final SectionActionPresenter getSectionActionPresenter() {
        SectionActionPresenter sectionActionPresenter2 = this.sectionActionPresenter;
        if (sectionActionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionActionPresenter");
        }
        return sectionActionPresenter2;
    }

    @NotNull
    public final SectionItemPresenter getSectionItemPresenter() {
        SectionItemPresenter sectionItemPresenter2 = this.sectionItemPresenter;
        if (sectionItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionItemPresenter");
        }
        return sectionItemPresenter2;
    }

    @NotNull
    public final AdapterPresenter getSectionsAdapterPresenter() {
        AdapterPresenter adapterPresenter = this.sectionsAdapterPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionsAdapterPresenter");
        }
        return adapterPresenter;
    }

    @NotNull
    public final AdvertSellerPresenter getSellerPresenter() {
        AdvertSellerPresenter advertSellerPresenter = this.sellerPresenter;
        if (advertSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerPresenter");
        }
        return advertSellerPresenter;
    }

    @NotNull
    public final SellerSubscriptionPresenter getSellerSubscriptionPresenter() {
        SellerSubscriptionPresenter sellerSubscriptionPresenter2 = this.sellerSubscriptionPresenter;
        if (sellerSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
        }
        return sellerSubscriptionPresenter2;
    }

    @NotNull
    public final AdvertDetailsShortTermRentPresenter getShortTermRentPresenter() {
        AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter = this.shortTermRentPresenter;
        if (advertDetailsShortTermRentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTermRentPresenter");
        }
        return advertDetailsShortTermRentPresenter;
    }

    @NotNull
    public final AdvertSimilarPresenterResourceProvider getSimilarAdvertResources() {
        AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider = this.similarAdvertResources;
        if (advertSimilarPresenterResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarAdvertResources");
        }
        return advertSimilarPresenterResourceProvider;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    @NotNull
    public final SerpSpanProvider getSpanProvider() {
        SerpSpanProvider serpSpanProvider = this.spanProvider;
        if (serpSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        return serpSpanProvider;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        return spanSizeLookup2;
    }

    @NotNull
    public final FpsStateSupplier getSupplier() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        return fpsStateSupplier;
    }

    @NotNull
    public final AdvertDetailsTracker getTracker() {
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return advertDetailsTracker;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Location location;
        String stringExtra;
        String stringExtra2;
        super.onActivityResult(i, i2, intent);
        boolean z2 = true;
        String str = null;
        String str2 = null;
        String str3 = null;
        PhoneLink phoneLink = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Parcelable successAuthResultData = AuthIntentFactoryKt.getSuccessAuthResultData(intent);
                    SellerSubscriptionPresenter sellerSubscriptionPresenter2 = this.sellerSubscriptionPresenter;
                    if (sellerSubscriptionPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
                    }
                    sellerSubscriptionPresenter2.onAuthSuccess();
                    AdvertContactsPresenter advertContactsPresenter = this.contactsPresenter;
                    if (advertContactsPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
                    }
                    advertContactsPresenter.onAuthSuccess(successAuthResultData);
                    if (successAuthResultData instanceof AddToCartData) {
                        AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
                        if (advertDetailsPresenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        advertDetailsPresenter.handleOnCartActionAuthSuccess((AddToCartData) successAuthResultData);
                    }
                    AdvertDetailsPresenter advertDetailsPresenter2 = this.presenter;
                    if (advertDetailsPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter2.updateContacts();
                    return;
                }
                SellerSubscriptionPresenter sellerSubscriptionPresenter3 = this.sellerSubscriptionPresenter;
                if (sellerSubscriptionPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
                }
                sellerSubscriptionPresenter3.onAuthFailed();
                return;
            case 2:
                if (i2 == -1) {
                    this.u = true;
                    AdvertDetailsPresenter advertDetailsPresenter3 = this.presenter;
                    if (advertDetailsPresenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter3.updateContacts();
                    return;
                }
                return;
            case 3:
                if (intent != null && (location = (Location) intent.getParcelableExtra("location")) != null) {
                    AdvertDetailsPresenter advertDetailsPresenter4 = this.presenter;
                    if (advertDetailsPresenter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter4.handleLocationUpdate(location);
                    MarketplaceDeliveryPresenter marketplaceDeliveryPresenter2 = this.marketplaceDeliveryPresenter;
                    if (marketplaceDeliveryPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("marketplaceDeliveryPresenter");
                    }
                    marketplaceDeliveryPresenter2.onLocationChanged(location);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    int intExtra = intent.getIntExtra(Constants.IMAGE_POSITION, 0);
                    long longExtra = intent.getLongExtra(Constants.PHOTO_GALLERY_STATE_ID, -1);
                    if (longExtra > -1) {
                        AdvertDetailsItemsPresenter advertDetailsItemsPresenter2 = this.advertDetailsItemsPresenter;
                        if (advertDetailsItemsPresenter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsItemsPresenter");
                        }
                        advertDetailsItemsPresenter2.onPageSelected(intExtra, longExtra);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (intent != null) {
                    DeliveryFlowResult deliveryFlowResult = (DeliveryFlowResult) intent.getParcelableExtra(DeliveryActivityInteractionConstants.DELIVERY_KEY_FLOW_RESULT);
                    AdvertDetailsPresenter advertDetailsPresenter5 = this.presenter;
                    if (advertDetailsPresenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter5.handleDeliveryResults(deliveryFlowResult);
                    return;
                }
                return;
            case 6:
            default:
                return;
            case 7:
                if (i2 == -1) {
                    AdvertDetailsPresenter advertDetailsPresenter6 = this.presenter;
                    if (advertDetailsPresenter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter6.handleUpdateAuthAddNoteResult();
                    return;
                }
                return;
            case 8:
                if (i2 == -1) {
                    if (intent != null) {
                        str = intent.getStringExtra(EditAdvertNoteActivityKt.ADVERT_RESULT_NOTE);
                    }
                    AdvertDetailsNotePresenter advertDetailsNotePresenter = this.notePresenter;
                    if (advertDetailsNotePresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notePresenter");
                    }
                    advertDetailsNotePresenter.updateNote(str);
                    return;
                }
                return;
            case 9:
                if (i2 == -1) {
                    if (intent != null) {
                        phoneLink = (PhoneLink) intent.getParcelableExtra(ExpressCvConstants.EXPRESS_CV_LINK_EXTRA);
                    }
                    AdvertDetailsPresenter advertDetailsPresenter7 = this.presenter;
                    if (advertDetailsPresenter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter7.handleExpressCvOkResult();
                    AdvertContactsPresenter advertContactsPresenter2 = this.contactsPresenter;
                    if (advertContactsPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
                    }
                    advertContactsPresenter2.showPhoneCallConfirmationAfterOnActivityResult(phoneLink);
                    return;
                }
                return;
            case 10:
                View view = getView();
                if (view != null) {
                    Keyboards.hideKeyboardWithAttempt$default(view, 0, 0, 3, null);
                    return;
                }
                return;
            case 11:
                if (i2 == 1 || i2 == 43) {
                    AdvertDetailsPresenter advertDetailsPresenter8 = this.presenter;
                    if (advertDetailsPresenter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    advertDetailsPresenter8.updateContacts();
                    return;
                }
                return;
            case 12:
                if (i2 == -1 && intent != null && (stringExtra = intent.getStringExtra("message")) != null) {
                    if (stringExtra.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        str3 = stringExtra;
                    }
                    if (str3 != null) {
                        AdvertDetailsPresenter advertDetailsPresenter9 = this.presenter;
                        if (advertDetailsPresenter9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        advertDetailsPresenter9.handleMessageResult(str3);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (i2 == -1) {
                    AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter = this.domotekaTeaserPresenter;
                    if (advertDetailsDomotekaTeaserPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserPresenter");
                    }
                    advertDetailsDomotekaTeaserPresenter.showFlatNumberRequestDialog();
                    return;
                }
                return;
            case 14:
                if (i2 == -1 && intent != null && (stringExtra2 = intent.getStringExtra("message")) != null) {
                    if (stringExtra2.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        str2 = stringExtra2;
                    }
                    if (str2 != null) {
                        AdvertDetailsPresenter advertDetailsPresenter10 = this.presenter;
                        if (advertDetailsPresenter10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        advertDetailsPresenter10.handleMessageResult(str2);
                        return;
                    }
                    return;
                }
                return;
            case 15:
                if (i2 == -1) {
                    SellerSubscriptionPresenter sellerSubscriptionPresenter4 = this.sellerSubscriptionPresenter;
                    if (sellerSubscriptionPresenter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
                    }
                    sellerSubscriptionPresenter4.onSubscriptionDeepLinkReturned();
                    return;
                }
                return;
            case 16:
                if (i2 == -1) {
                    RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
                    if (recommendationItemPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
                    }
                    recommendationItemPresenter.onSubscriptionDeepLinkReturned();
                    return;
                }
                return;
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
        if (advertDetailsToolbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
        }
        advertDetailsToolbarPresenter2.handleBackPressed(false);
        return false;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.startInit();
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        AccountStateProvider accountStateProvider = this.accountStatus;
        if (accountStateProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountStatus");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.o = new AdvertDetailsRouterImpl(str, this, activityIntentFactory2, deepLinkIntentFactory2, implicitIntentFactory2, accountStateProvider, analytics2, new a(this));
        DfpCreditViewModelFactory dfpCreditViewModelFactory = this.creditViewModelFactory;
        if (dfpCreditViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditViewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, dfpCreditViewModelFactory).get(DfpCreditViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ditViewModel::class.java)");
        this.l = (DfpCreditViewModel) viewModel;
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter2 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        DfpCreditViewModel dfpCreditViewModel = this.l;
        if (dfpCreditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        advertDetailsCreditInfoPresenter2.setListener(dfpCreditViewModel);
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter3 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        DfpCreditViewModel dfpCreditViewModel2 = this.l;
        if (dfpCreditViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        advertDetailsCreditInfoPresenter3.setPhoneChooserListener(dfpCreditViewModel2);
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter4 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter = this.o;
        if (advertDetailsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertDetailsCreditInfoPresenter4.setRouter(advertDetailsRouter);
        AdvertContactsPresenter advertContactsPresenter = this.contactsPresenter;
        if (advertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter2 = this.o;
        if (advertDetailsRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertContactsPresenter.setRouter(advertDetailsRouter2);
        AdvertContactsPresenter advertContactsPresenter2 = this.contactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        advertContactsPresenter2.setContext(this.r);
        AdvertDetailsDescriptionPresenter advertDetailsDescriptionPresenter = this.descriptionPresenter;
        if (advertDetailsDescriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
        if (advertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsDescriptionPresenter.setDescriptionListener(advertDetailsPresenter);
        AdvertDetailsAddressPresenter advertDetailsAddressPresenter = this.addressPresenter;
        if (advertDetailsAddressPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter2 = this.presenter;
        if (advertDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsAddressPresenter.setAddressListener(advertDetailsPresenter2);
        AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter2 = this.advertDetailsShowOnMapPresenter;
        if (advertDetailsShowOnMapPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsShowOnMapPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter3 = this.presenter;
        if (advertDetailsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsShowOnMapPresenter2.setShowOnMapListener(advertDetailsPresenter3);
        AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter2 = this.advertDetailsPriceSubscriptionPresenter;
        if (advertDetailsPriceSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsPriceSubscriptionPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter4 = this.presenter;
        if (advertDetailsPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsPriceSubscriptionPresenter2.setPriceSubscriptionListener(advertDetailsPresenter4);
        AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter2 = this.advertDetailsConsultationPresenter;
        if (advertDetailsConsultationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsConsultationPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter5 = this.presenter;
        if (advertDetailsPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsConsultationPresenter2.setSubmitConsultationListener(advertDetailsPresenter5);
        AdvertDetailsGeoReferencePresenter advertDetailsGeoReferencePresenter = this.geoReferencePresenter;
        if (advertDetailsGeoReferencePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("geoReferencePresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter6 = this.presenter;
        if (advertDetailsPresenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsGeoReferencePresenter.setListener(advertDetailsPresenter6);
        AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter2 = this.advertDetailsAutoCatalogPresenter;
        if (advertDetailsAutoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsAutoCatalogPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter3 = this.o;
        if (advertDetailsRouter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertDetailsAutoCatalogPresenter2.setRouter(advertDetailsRouter3);
        AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter2 = this.advertDetailsDeliveryInfoPresenter;
        if (advertDetailsDeliveryInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsDeliveryInfoPresenter");
        }
        advertDetailsDeliveryInfoPresenter2.setFragmentDelegate(this);
        AdvertDetailsSafeDealServicesPresenter advertDetailsSafeDealServicesPresenter = this.safeDealServicesPresenter;
        if (advertDetailsSafeDealServicesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeDealServicesPresenter");
        }
        advertDetailsSafeDealServicesPresenter.setLifecycleOwner(this);
        AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter = this.shortTermRentPresenter;
        if (advertDetailsShortTermRentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shortTermRentPresenter");
        }
        AdvertDetailsPresenter advertDetailsPresenter7 = this.presenter;
        if (advertDetailsPresenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsShortTermRentPresenter.setListener(advertDetailsPresenter7);
        AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter = this.domotekaTeaserPresenter;
        if (advertDetailsDomotekaTeaserPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter4 = this.o;
        if (advertDetailsRouter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertDetailsDomotekaTeaserPresenter.setRouter(advertDetailsRouter4);
        AdvertBookingPresenter advertBookingPresenter = this.bookingPresenter;
        if (advertBookingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter5 = this.o;
        if (advertDetailsRouter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertBookingPresenter.setRouter(advertDetailsRouter5);
        AdvertBadgeBarPresenter advertBadgeBarPresenter = this.badgeBarPresenter;
        if (advertBadgeBarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgeBarPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter6 = this.o;
        if (advertDetailsRouter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        advertBadgeBarPresenter.setRouter(advertDetailsRouter6);
        PromoCardItemPresenter promoCardItemPresenter = this.promoCardPresenter;
        if (promoCardItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promoCardPresenter");
        }
        AdvertDetailsRouter advertDetailsRouter7 = this.o;
        if (advertDetailsRouter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        promoCardItemPresenter.bindRouter(advertDetailsRouter7);
        MarketplacePresenter marketplacePresenter = this.j;
        if (marketplacePresenter != null) {
            marketplacePresenter.setSearchContext(this.r);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.startInit();
        return layoutInflater.inflate(com.avito.android.advert_core.R.layout.ac_advert_details_main, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter2 = this.advertDetailsDeliveryInfoPresenter;
        if (advertDetailsDeliveryInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsDeliveryInfoPresenter");
        }
        advertDetailsDeliveryInfoPresenter2.detachListener();
        AdvertContactsPresenter advertContactsPresenter = this.contactsPresenter;
        if (advertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        advertContactsPresenter.detachView();
        AdvertSafeDealPresenter advertSafeDealPresenter = this.safedealPresenter;
        if (advertSafeDealPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safedealPresenter");
        }
        advertSafeDealPresenter.detachView();
        AdvertDetailsToolbarView advertDetailsToolbarView = this.q;
        if (advertDetailsToolbarView != null) {
            advertDetailsToolbarView.detach();
        }
        this.q = null;
        SellerSubscriptionPresenter sellerSubscriptionPresenter2 = this.sellerSubscriptionPresenter;
        if (sellerSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
        }
        sellerSubscriptionPresenter2.detachSubscriptionSettingsView();
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.detachView();
        this.v.clear();
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.destroy();
        this.y.removeCallbacksAndMessages(null);
        Disposable disposable = this.x;
        if (disposable != null) {
            disposable.dispose();
        }
        this.x = null;
        super.onDestroyView();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsCallbacks
    public void onLoadFailed() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            if (!(activity instanceof AdvertDetailsActivity)) {
                finish();
                return;
            }
            activity.overridePendingTransition(0, 0);
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onPause();
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onResume();
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.attach();
        super.onResume();
        AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
        if (advertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        advertDetailsPresenter.onResume();
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter2 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        advertDetailsCreditInfoPresenter2.onResume();
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = new Bundle();
        SectionItemPresenter sectionItemPresenter2 = this.sectionItemPresenter;
        if (sectionItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionItemPresenter");
        }
        bundle2.putBundle("section_presenter_state", sectionItemPresenter2.onSaveState());
        DomotekaTeaserInteractor domotekaTeaserInteractor2 = this.domotekaTeaserInteractor;
        if (domotekaTeaserInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserInteractor");
        }
        Bundles.putKundle(bundle2, "domoteka_teaser_interactor_state", domotekaTeaserInteractor2.onSaveState());
        AutotekaDetailsInteractor autotekaDetailsInteractor2 = this.autotekaDetailsInteractor;
        if (autotekaDetailsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaDetailsInteractor");
        }
        Bundles.putKundle(bundle2, "autoteka_interactor_state", autotekaDetailsInteractor2.onSaveState());
        AutotekaTeaserInteractor autotekaTeaserInteractor2 = this.autotekaTeaserInteractor;
        if (autotekaTeaserInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserInteractor");
        }
        Bundles.putKundle(bundle2, "autoteka_teaser_interactor_state", autotekaTeaserInteractor2.onSaveState());
        AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
        if (advertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle2.putBundle("presenter", advertDetailsPresenter.onSaveState());
        AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
        if (advertDetailsToolbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
        }
        Bundles.putKundle(bundle2, "toolbar_presenter", advertDetailsToolbarPresenter2.onSaveState());
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        Bundles.putKundle(bundle2, "recommendation_presenter_state", recommendationItemPresenter.onSaveState());
        CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor2 = this.creditBrokerAnalyticsInteractor;
        if (creditBrokerAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditBrokerAnalyticsInteractor");
        }
        Bundles.putKundle(bundle2, "broker_analytics_state", creditBrokerAnalyticsInteractor2.onSaveState());
        SparePartsPresenter sparePartsPresenter = this.replacementsPresenter;
        if (sparePartsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replacementsPresenter");
        }
        Bundles.putKundle(bundle2, "replacements_saved_state", sparePartsPresenter.onSaveState());
        SparePartsPresenter sparePartsPresenter2 = this.compatibilitiesPresenter;
        if (sparePartsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compatibilitiesPresenter");
        }
        Bundles.putKundle(bundle2, "compatibilities_saved_state", sparePartsPresenter2.onSaveState());
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getQuestionnaireInAdvertisement().invoke().booleanValue()) {
            QuestionnairePresenter questionnairePresenter2 = this.questionnairePresenter;
            if (questionnairePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questionnairePresenter");
            }
            bundle2.putBundle("questionnaire_state", questionnairePresenter2.onSaveState());
        }
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features3.getViewVisibilityTracking().invoke().booleanValue()) {
            ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
            if (itemVisibilityTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
            }
            bundle2.putBundle("key_item_visibility_tracker_state", itemVisibilityTracker2.onSaveState());
        }
        saveInRetainStorage(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.p) {
            View view = getView();
            if (view != null) {
                Features features2 = this.features;
                if (features2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("features");
                }
                if (features2.getQuestionnaireInAdvertisement().invoke().booleanValue()) {
                    QuestionnairePresenter questionnairePresenter2 = this.questionnairePresenter;
                    if (questionnairePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("questionnairePresenter");
                    }
                    Intrinsics.checkNotNullExpressionValue(view, "it");
                    questionnairePresenter2.attachView(view);
                }
                AdvertDetailsToolbarView advertDetailsToolbarView = this.q;
                if (advertDetailsToolbarView == null) {
                    Intrinsics.checkNotNullExpressionValue(view, "it");
                    AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.analyticsInteractor;
                    if (advertDetailsAnalyticsInteractor == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
                    }
                    String str = this.k;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
                    }
                    advertDetailsToolbarView = new AdvertDetailsToolbarViewImpl(view, advertDetailsAnalyticsInteractor, str);
                    this.q = advertDetailsToolbarView;
                }
                AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
                if (advertDetailsToolbarPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
                }
                advertDetailsToolbarPresenter2.attachView(advertDetailsToolbarView);
            }
            AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter3 = this.advertDetailsToolbarPresenter;
            if (advertDetailsToolbarPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter = this.o;
            if (advertDetailsRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsToolbarPresenter3.attachRouter(advertDetailsRouter);
            AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
            if (advertDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter.attachView(c());
            Features features3 = this.features;
            if (features3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features3.getSafeDealCourierDeliveryJsonScheme().invoke().booleanValue()) {
                AdvertSafeDealPresenter advertSafeDealPresenter = this.safedealPresenter;
                if (advertSafeDealPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("safedealPresenter");
                }
                AdvertDetailsRouter advertDetailsRouter2 = this.o;
                if (advertDetailsRouter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
                }
                advertSafeDealPresenter.attachRouter(advertDetailsRouter2);
            } else {
                AdvertDeliveryPresenter advertDeliveryPresenter = this.deliveryPresenter;
                if (advertDeliveryPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deliveryPresenter");
                }
                AdvertDetailsRouter advertDetailsRouter3 = this.o;
                if (advertDetailsRouter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
                }
                advertDeliveryPresenter.attachRouter(advertDetailsRouter3);
            }
            AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter = this.shortTermRentPresenter;
            if (advertDetailsShortTermRentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shortTermRentPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter4 = this.o;
            if (advertDetailsRouter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsShortTermRentPresenter.attachRouter(advertDetailsRouter4);
            AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter2 = this.advertDetailsRatingPublishPresenter;
            if (advertDetailsRatingPublishPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRatingPublishPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter5 = this.o;
            if (advertDetailsRouter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsRatingPublishPresenter2.attachRouter(advertDetailsRouter5);
            RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
            if (recommendationItemPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter6 = this.o;
            if (advertDetailsRouter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            recommendationItemPresenter.attachRouter(advertDetailsRouter6);
            AdvertDetailsGuidePresenter advertDetailsGuidePresenter2 = this.advertDetailsGuidePresenter;
            if (advertDetailsGuidePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsGuidePresenter");
            }
            AdvertDetailsRouter advertDetailsRouter7 = this.o;
            if (advertDetailsRouter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsGuidePresenter2.attachRouter(advertDetailsRouter7);
            AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter = this.iceBreakersPresenter;
            if (advertDetailsIceBreakersPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iceBreakersPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter8 = this.o;
            if (advertDetailsRouter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsIceBreakersPresenter.attachRouter(advertDetailsRouter8);
            AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter = this.creGeoReportPresenter;
            if (advertDetailsGeoReportTeaserPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creGeoReportPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter9 = this.o;
            if (advertDetailsRouter9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsGeoReportTeaserPresenter.setRouter(advertDetailsRouter9);
            SparePartsPresenter sparePartsPresenter = this.replacementsPresenter;
            if (sparePartsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("replacementsPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter10 = this.o;
            if (advertDetailsRouter10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            sparePartsPresenter.attachRouter(advertDetailsRouter10);
            SparePartsPresenter sparePartsPresenter2 = this.compatibilitiesPresenter;
            if (sparePartsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compatibilitiesPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter11 = this.o;
            if (advertDetailsRouter11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            sparePartsPresenter2.attachRouter(advertDetailsRouter11);
            AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
            if (advertDetailsImvBadgePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
            }
            AdvertDetailsRouter advertDetailsRouter12 = this.o;
            if (advertDetailsRouter12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            advertDetailsImvBadgePresenter.attachRouter(advertDetailsRouter12);
            CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
            if (carMarketPriceChartPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
            }
            AdvertDetailsRouter advertDetailsRouter13 = this.o;
            if (advertDetailsRouter13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
            }
            carMarketPriceChartPresenter.attachRouter(advertDetailsRouter13);
            AdvertDetailsPresenter advertDetailsPresenter2 = this.presenter;
            if (advertDetailsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter2.start();
            this.p = true;
        }
        if (this.u) {
            AdvertDetailsPresenter advertDetailsPresenter3 = this.presenter;
            if (advertDetailsPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter3.showLoadingIndicatorAfterOnActivityResult();
            this.u = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (this.p) {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getQuestionnaireInAdvertisement().invoke().booleanValue()) {
                QuestionnairePresenter questionnairePresenter2 = this.questionnairePresenter;
                if (questionnairePresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questionnairePresenter");
                }
                questionnairePresenter2.detachView();
            }
            AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
            if (advertDetailsToolbarPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
            }
            advertDetailsToolbarPresenter2.detachView();
            AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter3 = this.advertDetailsToolbarPresenter;
            if (advertDetailsToolbarPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
            }
            advertDetailsToolbarPresenter3.detachRouter();
            Features features3 = this.features;
            if (features3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features3.getSafeDealCourierDeliveryJsonScheme().invoke().booleanValue()) {
                AdvertSafeDealPresenter advertSafeDealPresenter = this.safedealPresenter;
                if (advertSafeDealPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("safedealPresenter");
                }
                advertSafeDealPresenter.detachRouter();
            } else {
                AdvertDeliveryPresenter advertDeliveryPresenter = this.deliveryPresenter;
                if (advertDeliveryPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deliveryPresenter");
                }
                advertDeliveryPresenter.detachRouter();
            }
            AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter = this.shortTermRentPresenter;
            if (advertDetailsShortTermRentPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shortTermRentPresenter");
            }
            advertDetailsShortTermRentPresenter.detachRouter();
            AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter2 = this.advertDetailsRatingPublishPresenter;
            if (advertDetailsRatingPublishPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRatingPublishPresenter");
            }
            advertDetailsRatingPublishPresenter2.detachRouter();
            AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter = this.domotekaTeaserPresenter;
            if (advertDetailsDomotekaTeaserPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("domotekaTeaserPresenter");
            }
            advertDetailsDomotekaTeaserPresenter.detachView();
            RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
            if (recommendationItemPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
            }
            recommendationItemPresenter.detachRouter();
            AdvertDetailsGuidePresenter advertDetailsGuidePresenter2 = this.advertDetailsGuidePresenter;
            if (advertDetailsGuidePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsGuidePresenter");
            }
            advertDetailsGuidePresenter2.detachRouter();
            AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter = this.iceBreakersPresenter;
            if (advertDetailsIceBreakersPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iceBreakersPresenter");
            }
            advertDetailsIceBreakersPresenter.detachRouter();
            AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter = this.creGeoReportPresenter;
            if (advertDetailsGeoReportTeaserPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creGeoReportPresenter");
            }
            advertDetailsGeoReportTeaserPresenter.setRouter(null);
            SparePartsPresenter sparePartsPresenter = this.replacementsPresenter;
            if (sparePartsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("replacementsPresenter");
            }
            sparePartsPresenter.detach();
            SparePartsPresenter sparePartsPresenter2 = this.compatibilitiesPresenter;
            if (sparePartsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compatibilitiesPresenter");
            }
            sparePartsPresenter2.detach();
            AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
            if (advertDetailsImvBadgePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
            }
            advertDetailsImvBadgePresenter.detachRouter();
            CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
            if (carMarketPriceChartPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
            }
            carMarketPriceChartPresenter.detachRouter();
            AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
            if (advertDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter.detachView();
            AdvertDetailsPresenter advertDetailsPresenter2 = this.presenter;
            if (advertDetailsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter2.stop();
            this.p = false;
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        CartFabView cartFabView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle retainStorage = retainStorage();
        if (retainStorage != null) {
            AdvertDetailsPresenter advertDetailsPresenter = this.presenter;
            if (advertDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            advertDetailsPresenter.onRestoreState(retainStorage.getBundle("presenter"));
            retainStorage.getInt("SCROLL_POS_COMPLEMENTARY_ITEMS", 0);
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            View inflate = ((ViewStub) view.findViewById(com.avito.android.advert_core.R.id.cart_fab_stub)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
            CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
            if (cartFabViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
            }
            CartQuantityChangesHandler cartQuantityChangesHandler = this.cartFabQuantityHandler;
            if (cartQuantityChangesHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabQuantityHandler");
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            cartFabView = new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
        } else {
            cartFabView = null;
        }
        AdvertDetailsRouter advertDetailsRouter = this.o;
        if (advertDetailsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsRouter");
        }
        AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate = this.n;
        if (advertDetailsFragmentDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsFragmentDelegate");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        AdvertComplementaryPresenter advertComplementaryPresenter2 = this.advertComplementaryPresenter;
        if (advertComplementaryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertComplementaryPresenter");
        }
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        SectionActionPresenter sectionActionPresenter2 = this.sectionActionPresenter;
        if (sectionActionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionActionPresenter");
        }
        AdvertDetailsItemsPresenter advertDetailsItemsPresenter2 = this.advertDetailsItemsPresenter;
        if (advertDetailsItemsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsItemsPresenter");
        }
        SellerSubscriptionPresenter sellerSubscriptionPresenter2 = this.sellerSubscriptionPresenter;
        if (sellerSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
        }
        MarketplacePresenter marketplacePresenter = this.j;
        AdvertDetailsPresenter advertDetailsPresenter2 = this.presenter;
        if (advertDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        AdvertContactsPresenter advertContactsPresenter = this.contactsPresenter;
        if (advertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        AdvertSellerPresenter advertSellerPresenter = this.sellerPresenter;
        if (advertSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerPresenter");
        }
        AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2 = this.advertDetailsToolbarPresenter;
        if (advertDetailsToolbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsToolbarPresenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.destroyableComplementaryViewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableComplementaryViewHolderBuilder");
        }
        AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter = this.autotekaPresenter;
        if (advertDetailsAutotekaPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaPresenter");
        }
        AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter = this.autotekaTeaserPresenter;
        if (advertDetailsAutotekaTeaserPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserPresenter");
        }
        AdvertDetailsNotePresenter advertDetailsNotePresenter = this.notePresenter;
        if (advertDetailsNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notePresenter");
        }
        DfpCreditViewModel dfpCreditViewModel = this.l;
        if (dfpCreditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        SerpSpanProvider serpSpanProvider = this.spanProvider;
        if (serpSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        AdapterPresenter adapterPresenter = this.sectionsAdapterPresenter;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionsAdapterPresenter");
        }
        SafeRecyclerAdapter safeRecyclerAdapter = this.itemsSafeRecyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsSafeRecyclerAdapter");
        }
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider = this.similarAdvertResources;
        if (advertSimilarPresenterResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarAdvertResources");
        }
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        AdvertDetailsViewImpl advertDetailsViewImpl = new AdvertDetailsViewImpl(view, advertDetailsFragmentDelegate, advertDetailsRouter, dialogRouter2, this, advertComplementaryPresenter2, favoriteAdvertsPresenter2, viewedAdvertsPresenter2, sectionActionPresenter2, advertDetailsItemsPresenter2, sellerSubscriptionPresenter2, marketplacePresenter, advertDetailsPresenter2, formatter, advertSellerPresenter, advertContactsPresenter, advertDetailsToolbarPresenter2, destroyableViewHolderBuilder, advertDetailsAutotekaPresenter, advertDetailsAutotekaTeaserPresenter, advertDetailsNotePresenter, dfpCreditViewModel, viewLifecycleOwner2, spannedGridPositionProvider, spanSizeLookup2, serpSpanProvider, adapterPresenter, safeRecyclerAdapter, deviceMetrics2, advertSimilarPresenterResourceProvider, features3, itemVisibilityTracker2, fpsStateSupplier, cartFabView);
        advertDetailsViewImpl.attach();
        this.m.setValue((Fragment) this, z[0], (KProperty<?>) advertDetailsViewImpl);
        AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter2 = this.advertDetailsDeliveryInfoPresenter;
        if (advertDetailsDeliveryInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsDeliveryInfoPresenter");
        }
        advertDetailsDeliveryInfoPresenter2.setDeliveryBlockListener(c());
        AdvertContactsPresenter advertContactsPresenter2 = this.contactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        advertContactsPresenter2.attachCoreView(c());
        AdvertSafeDealPresenter advertSafeDealPresenter = this.safedealPresenter;
        if (advertSafeDealPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safedealPresenter");
        }
        advertSafeDealPresenter.attachCoreView(c());
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.setDefaultElement(c());
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        SubscriptionSettingsViewImpl subscriptionSettingsViewImpl = new SubscriptionSettingsViewImpl(requireActivity);
        SellerSubscriptionPresenter sellerSubscriptionPresenter3 = this.sellerSubscriptionPresenter;
        if (sellerSubscriptionPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerSubscriptionPresenter");
        }
        sellerSubscriptionPresenter3.attachSubscriptionSettingsView(subscriptionSettingsViewImpl);
        CompositeSnackbarPresenter compositeSnackbarPresenter2 = this.snackbarPresenter;
        if (compositeSnackbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter2.addOptionalElement(subscriptionSettingsViewImpl);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        SubscriptionSettingsViewImpl subscriptionSettingsViewImpl2 = new SubscriptionSettingsViewImpl(requireActivity2);
        RecommendationItemPresenter recommendationItemPresenter = this.recommendationPresenter;
        if (recommendationItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendationPresenter");
        }
        recommendationItemPresenter.attachView(subscriptionSettingsViewImpl2);
        CompositeSnackbarPresenter compositeSnackbarPresenter3 = this.snackbarPresenter;
        if (compositeSnackbarPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter3.addOptionalElement(subscriptionSettingsViewImpl2);
        CompositeDisposable compositeDisposable = this.v;
        io.reactivex.rxjava3.disposables.Disposable subscribe = c().scrollStateChanges().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemDetailsView.scrollSt…setAutoScroll()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        DfpCreditViewModel dfpCreditViewModel2 = this.l;
        if (dfpCreditViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel2.creditData().observe(getViewLifecycleOwner(), new a2.a.a.f.x.a(this));
        DfpCreditViewModel dfpCreditViewModel3 = this.l;
        if (dfpCreditViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel3.legalInfoText().observe(getViewLifecycleOwner(), new i0(0, this));
        DfpCreditViewModel dfpCreditViewModel4 = this.l;
        if (dfpCreditViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel4.privacyUri().observe(getViewLifecycleOwner(), new d(0, this));
        DfpCreditViewModel dfpCreditViewModel5 = this.l;
        if (dfpCreditViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel5.phoneChooser().observe(getViewLifecycleOwner(), new a2.a.a.f.x.b(this));
        DfpCreditViewModel dfpCreditViewModel6 = this.l;
        if (dfpCreditViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel6.sravniPhone().observe(getViewLifecycleOwner(), new i0(1, this));
        DfpCreditViewModel dfpCreditViewModel7 = this.l;
        if (dfpCreditViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel7.sravniFormUri().observe(getViewLifecycleOwner(), new d(1, this));
        DfpCreditViewModel dfpCreditViewModel8 = this.l;
        if (dfpCreditViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        dfpCreditViewModel8.tinkoffFormUri().observe(getViewLifecycleOwner(), new d(2, this));
        int integer = getResources().getInteger(17694720);
        DfpCreditViewModel dfpCreditViewModel9 = this.l;
        if (dfpCreditViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter2 = this.advertDetailsCreditInfoPresenter;
        if (advertDetailsCreditInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertDetailsCreditInfoPresenter");
        }
        Disposable disposable = this.x;
        if (disposable != null) {
            disposable.dispose();
        }
        FragmentActivity requireActivity3 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
        this.x = Keyboards.keyboardVisibilityChanges(requireActivity3, false).debounce((long) integer, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new WeakConsumer(new c(this, dfpCreditViewModel9, advertDetailsCreditInfoPresenter2)), new WeakConsumer(d.a));
        AdvertDetailsPresenter advertDetailsPresenter3 = this.presenter;
        if (advertDetailsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DfpCreditViewModel dfpCreditViewModel10 = this.l;
        if (dfpCreditViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfpCreditViewModel");
        }
        advertDetailsPresenter3.attachDfpCreditViewModel(dfpCreditViewModel10);
        AdvertDetailsTracker advertDetailsTracker = this.tracker;
        if (advertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        advertDetailsTracker.trackInit();
    }

    public final void setAccountStatus(@NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "<set-?>");
        this.accountStatus = accountStateProvider;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdditionalSellerPresenter(@NotNull AdditionalSellerPresenter additionalSellerPresenter2) {
        Intrinsics.checkNotNullParameter(additionalSellerPresenter2, "<set-?>");
        this.additionalSellerPresenter = additionalSellerPresenter2;
    }

    public final void setAddressPresenter(@NotNull AdvertDetailsAddressPresenter advertDetailsAddressPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsAddressPresenter, "<set-?>");
        this.addressPresenter = advertDetailsAddressPresenter;
    }

    public final void setAdvertComplementaryPresenter(@NotNull AdvertComplementaryPresenter advertComplementaryPresenter2) {
        Intrinsics.checkNotNullParameter(advertComplementaryPresenter2, "<set-?>");
        this.advertComplementaryPresenter = advertComplementaryPresenter2;
    }

    public final void setAdvertDetailsAutoCatalogPresenter(@NotNull AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsAutoCatalogPresenter2, "<set-?>");
        this.advertDetailsAutoCatalogPresenter = advertDetailsAutoCatalogPresenter2;
    }

    public final void setAdvertDetailsConsultationPresenter(@NotNull AdvertDetailsConsultationPresenter advertDetailsConsultationPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsConsultationPresenter2, "<set-?>");
        this.advertDetailsConsultationPresenter = advertDetailsConsultationPresenter2;
    }

    public final void setAdvertDetailsCreditInfoPresenter(@NotNull AdvertDetailsCreditInfoPresenter advertDetailsCreditInfoPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsCreditInfoPresenter2, "<set-?>");
        this.advertDetailsCreditInfoPresenter = advertDetailsCreditInfoPresenter2;
    }

    public final void setAdvertDetailsDeliveryInfoPresenter(@NotNull AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsDeliveryInfoPresenter2, "<set-?>");
        this.advertDetailsDeliveryInfoPresenter = advertDetailsDeliveryInfoPresenter2;
    }

    public final void setAdvertDetailsGuidePresenter(@NotNull AdvertDetailsGuidePresenter advertDetailsGuidePresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsGuidePresenter2, "<set-?>");
        this.advertDetailsGuidePresenter = advertDetailsGuidePresenter2;
    }

    public final void setAdvertDetailsItemsPresenter(@NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsItemsPresenter2, "<set-?>");
        this.advertDetailsItemsPresenter = advertDetailsItemsPresenter2;
    }

    public final void setAdvertDetailsPriceSubscriptionPresenter(@NotNull AdvertDetailsPriceSubscriptionPresenter advertDetailsPriceSubscriptionPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsPriceSubscriptionPresenter2, "<set-?>");
        this.advertDetailsPriceSubscriptionPresenter = advertDetailsPriceSubscriptionPresenter2;
    }

    public final void setAdvertDetailsRatingPublishPresenter(@NotNull AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsRatingPublishPresenter2, "<set-?>");
        this.advertDetailsRatingPublishPresenter = advertDetailsRatingPublishPresenter2;
    }

    public final void setAdvertDetailsShowOnMapPresenter(@NotNull AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsShowOnMapPresenter2, "<set-?>");
        this.advertDetailsShowOnMapPresenter = advertDetailsShowOnMapPresenter2;
    }

    public final void setAdvertDetailsToolbarPresenter(@NotNull AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter2) {
        Intrinsics.checkNotNullParameter(advertDetailsToolbarPresenter2, "<set-?>");
        this.advertDetailsToolbarPresenter = advertDetailsToolbarPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsInteractor(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = advertDetailsAnalyticsInteractor;
    }

    public final void setAutotekaDetailsInteractor(@NotNull AutotekaDetailsInteractor autotekaDetailsInteractor2) {
        Intrinsics.checkNotNullParameter(autotekaDetailsInteractor2, "<set-?>");
        this.autotekaDetailsInteractor = autotekaDetailsInteractor2;
    }

    public final void setAutotekaPresenter(@NotNull AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaPresenter, "<set-?>");
        this.autotekaPresenter = advertDetailsAutotekaPresenter;
    }

    public final void setAutotekaTeaserInteractor(@NotNull AutotekaTeaserInteractor autotekaTeaserInteractor2) {
        Intrinsics.checkNotNullParameter(autotekaTeaserInteractor2, "<set-?>");
        this.autotekaTeaserInteractor = autotekaTeaserInteractor2;
    }

    public final void setAutotekaTeaserPresenter(@NotNull AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserPresenter, "<set-?>");
        this.autotekaTeaserPresenter = advertDetailsAutotekaTeaserPresenter;
    }

    public final void setBadgeBarPresenter(@NotNull AdvertBadgeBarPresenter advertBadgeBarPresenter) {
        Intrinsics.checkNotNullParameter(advertBadgeBarPresenter, "<set-?>");
        this.badgeBarPresenter = advertBadgeBarPresenter;
    }

    public final void setBookingPresenter(@NotNull AdvertBookingPresenter advertBookingPresenter) {
        Intrinsics.checkNotNullParameter(advertBookingPresenter, "<set-?>");
        this.bookingPresenter = advertBookingPresenter;
    }

    public final void setCartFabQuantityHandler(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setCartFabViewModel(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCompatibilitiesPresenter(@NotNull SparePartsPresenter sparePartsPresenter) {
        Intrinsics.checkNotNullParameter(sparePartsPresenter, "<set-?>");
        this.compatibilitiesPresenter = sparePartsPresenter;
    }

    public final void setContactsPresenter(@NotNull AdvertContactsPresenter advertContactsPresenter) {
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "<set-?>");
        this.contactsPresenter = advertContactsPresenter;
    }

    public final void setCreGeoReportPresenter(@NotNull AdvertDetailsGeoReportTeaserPresenter advertDetailsGeoReportTeaserPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsGeoReportTeaserPresenter, "<set-?>");
        this.creGeoReportPresenter = advertDetailsGeoReportTeaserPresenter;
    }

    public final void setCreditBrokerAnalyticsInteractor(@NotNull CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor2) {
        Intrinsics.checkNotNullParameter(creditBrokerAnalyticsInteractor2, "<set-?>");
        this.creditBrokerAnalyticsInteractor = creditBrokerAnalyticsInteractor2;
    }

    public final void setCreditViewModelFactory(@NotNull DfpCreditViewModelFactory dfpCreditViewModelFactory) {
        Intrinsics.checkNotNullParameter(dfpCreditViewModelFactory, "<set-?>");
        this.creditViewModelFactory = dfpCreditViewModelFactory;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDeliveryPresenter(@NotNull AdvertDeliveryPresenter advertDeliveryPresenter) {
        Intrinsics.checkNotNullParameter(advertDeliveryPresenter, "<set-?>");
        this.deliveryPresenter = advertDeliveryPresenter;
    }

    public final void setDescriptionPresenter(@NotNull AdvertDetailsDescriptionPresenter advertDetailsDescriptionPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsDescriptionPresenter, "<set-?>");
        this.descriptionPresenter = advertDetailsDescriptionPresenter;
    }

    public final void setDestroyableComplementaryViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.destroyableComplementaryViewHolderBuilder = destroyableViewHolderBuilder;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setDomotekaTeaserInteractor(@NotNull DomotekaTeaserInteractor domotekaTeaserInteractor2) {
        Intrinsics.checkNotNullParameter(domotekaTeaserInteractor2, "<set-?>");
        this.domotekaTeaserInteractor = domotekaTeaserInteractor2;
    }

    public final void setDomotekaTeaserPresenter(@NotNull AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsDomotekaTeaserPresenter, "<set-?>");
        this.domotekaTeaserPresenter = advertDetailsDomotekaTeaserPresenter;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGeoReferencePresenter(@NotNull AdvertDetailsGeoReferencePresenter advertDetailsGeoReferencePresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsGeoReferencePresenter, "<set-?>");
        this.geoReferencePresenter = advertDetailsGeoReferencePresenter;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setIceBreakersPresenter(@NotNull AdvertDetailsIceBreakersPresenter advertDetailsIceBreakersPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsIceBreakersPresenter, "<set-?>");
        this.iceBreakersPresenter = advertDetailsIceBreakersPresenter;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setImvBadgePresenter(@NotNull AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgePresenter, "<set-?>");
        this.imvBadgePresenter = advertDetailsImvBadgePresenter;
    }

    public final void setImvChartPresenter(@NotNull CarMarketPriceChartPresenter carMarketPriceChartPresenter) {
        Intrinsics.checkNotNullParameter(carMarketPriceChartPresenter, "<set-?>");
        this.imvChartPresenter = carMarketPriceChartPresenter;
    }

    public final void setItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker2) {
        Intrinsics.checkNotNullParameter(itemVisibilityTracker2, "<set-?>");
        this.itemVisibilityTracker = itemVisibilityTracker2;
    }

    public final void setItemsSafeRecyclerAdapter(@NotNull SafeRecyclerAdapter safeRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "<set-?>");
        this.itemsSafeRecyclerAdapter = safeRecyclerAdapter;
    }

    public final void setMarketplaceDeliveryPresenter(@NotNull MarketplaceDeliveryPresenter marketplaceDeliveryPresenter2) {
        Intrinsics.checkNotNullParameter(marketplaceDeliveryPresenter2, "<set-?>");
        this.marketplaceDeliveryPresenter = marketplaceDeliveryPresenter2;
    }

    @Inject
    public final void setMarketplacePresenter(@Nullable MarketplacePresenter marketplacePresenter) {
        this.j = marketplacePresenter;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.w = navigationState;
    }

    public final void setNotePresenter(@NotNull AdvertDetailsNotePresenter advertDetailsNotePresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsNotePresenter, "<set-?>");
        this.notePresenter = advertDetailsNotePresenter;
    }

    public final void setPhoneNumberFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneNumberFormatter = formatter;
    }

    public final void setPresenter(@NotNull AdvertDetailsPresenter advertDetailsPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsPresenter, "<set-?>");
        this.presenter = advertDetailsPresenter;
    }

    public final void setPromoCardPresenter(@NotNull PromoCardItemPresenter promoCardItemPresenter) {
        Intrinsics.checkNotNullParameter(promoCardItemPresenter, "<set-?>");
        this.promoCardPresenter = promoCardItemPresenter;
    }

    public final void setQuestionnairePresenter(@NotNull QuestionnairePresenter questionnairePresenter2) {
        Intrinsics.checkNotNullParameter(questionnairePresenter2, "<set-?>");
        this.questionnairePresenter = questionnairePresenter2;
    }

    public final void setRecommendationPresenter(@NotNull RecommendationItemPresenter recommendationItemPresenter) {
        Intrinsics.checkNotNullParameter(recommendationItemPresenter, "<set-?>");
        this.recommendationPresenter = recommendationItemPresenter;
    }

    public final void setReplacementsPresenter(@NotNull SparePartsPresenter sparePartsPresenter) {
        Intrinsics.checkNotNullParameter(sparePartsPresenter, "<set-?>");
        this.replacementsPresenter = sparePartsPresenter;
    }

    public final void setSafeDealServicesPresenter(@NotNull AdvertDetailsSafeDealServicesPresenter advertDetailsSafeDealServicesPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealServicesPresenter, "<set-?>");
        this.safeDealServicesPresenter = advertDetailsSafeDealServicesPresenter;
    }

    public final void setSafedealPresenter(@NotNull AdvertSafeDealPresenter advertSafeDealPresenter) {
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "<set-?>");
        this.safedealPresenter = advertSafeDealPresenter;
    }

    public final void setSectionActionPresenter(@NotNull SectionActionPresenter sectionActionPresenter2) {
        Intrinsics.checkNotNullParameter(sectionActionPresenter2, "<set-?>");
        this.sectionActionPresenter = sectionActionPresenter2;
    }

    public final void setSectionItemPresenter(@NotNull SectionItemPresenter sectionItemPresenter2) {
        Intrinsics.checkNotNullParameter(sectionItemPresenter2, "<set-?>");
        this.sectionItemPresenter = sectionItemPresenter2;
    }

    public final void setSectionsAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "<set-?>");
        this.sectionsAdapterPresenter = adapterPresenter;
    }

    public final void setSellerPresenter(@NotNull AdvertSellerPresenter advertSellerPresenter) {
        Intrinsics.checkNotNullParameter(advertSellerPresenter, "<set-?>");
        this.sellerPresenter = advertSellerPresenter;
    }

    public final void setSellerSubscriptionPresenter(@NotNull SellerSubscriptionPresenter sellerSubscriptionPresenter2) {
        Intrinsics.checkNotNullParameter(sellerSubscriptionPresenter2, "<set-?>");
        this.sellerSubscriptionPresenter = sellerSubscriptionPresenter2;
    }

    public final void setShortTermRentPresenter(@NotNull AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsShortTermRentPresenter, "<set-?>");
        this.shortTermRentPresenter = advertDetailsShortTermRentPresenter;
    }

    public final void setSimilarAdvertResources(@NotNull AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider) {
        Intrinsics.checkNotNullParameter(advertSimilarPresenterResourceProvider, "<set-?>");
        this.similarAdvertResources = advertSimilarPresenterResourceProvider;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    public final void setSpanProvider(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, "<set-?>");
        this.spanProvider = serpSpanProvider;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
        this.supplier = fpsStateSupplier;
    }

    public final void setTracker(@NotNull AdvertDetailsTracker advertDetailsTracker) {
        Intrinsics.checkNotNullParameter(advertDetailsTracker, "<set-?>");
        this.tracker = advertDetailsTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle retainStorage = retainStorage();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return false");
        AdvertDetailsArguments advertDetailsArguments = (AdvertDetailsArguments) arguments.getParcelable("advert_details_arguments");
        if (advertDetailsArguments != null) {
            this.k = advertDetailsArguments.getItemId();
            this.r = advertDetailsArguments.getContext();
            this.s = advertDetailsArguments.getFastOpenParams();
            this.t = advertDetailsArguments.isMarketplace();
            Kundle kundle = retainStorage != null ? Bundles.getKundle(retainStorage, "autoteka_interactor_state") : null;
            Kundle kundle2 = retainStorage != null ? Bundles.getKundle(retainStorage, "autoteka_teaser_interactor_state") : null;
            Bundle bundle2 = retainStorage != null ? retainStorage.getBundle("section_presenter_state") : null;
            Kundle kundle3 = retainStorage != null ? Bundles.getKundle(retainStorage, "domoteka_teaser_interactor_state") : null;
            Kundle kundle4 = retainStorage != null ? Bundles.getKundle(retainStorage, "toolbar_presenter") : null;
            Kundle kundle5 = retainStorage != null ? Bundles.getKundle(retainStorage, "recommendation_presenter_state") : null;
            Bundle bundle3 = retainStorage != null ? retainStorage.getBundle("questionnaire_state") : null;
            Bundle bundle4 = retainStorage != null ? retainStorage.getBundle("key_item_visibility_tracker_state") : null;
            Kundle kundle6 = retainStorage != null ? Bundles.getKundle(retainStorage, "broker_analytics_state") : null;
            Kundle kundle7 = retainStorage != null ? Bundles.getKundle(retainStorage, "replacements_saved_state") : null;
            Kundle kundle8 = retainStorage != null ? Bundles.getKundle(retainStorage, "compatibilities_saved_state") : null;
            this.n = new AdvertDetailsFragmentDelegateImpl(this);
            Timer B1 = a2.b.a.a.a.B1();
            AdvertFragmentComponent.Builder screen = DaggerAdvertFragmentComponent.builder().advertDependencies((AdvertFragmentDependencies) ComponentDependenciesKt.getDependencies(AdvertFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screen(AdvertScreen.INSTANCE);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            AdvertFragmentComponent.Builder withActivity = screen.withActivity(requireActivity);
            String str = this.k;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
            }
            AdvertFragmentComponent.Builder withStartingGalleryPosition = withActivity.withAdvertId(str).withSearchContext(this.r).withFastOpenParams(this.s).withMarketplaceFlag(this.t).withScreenSource(advertDetailsArguments.getScreenSource()).withClickTime(advertDetailsArguments.getClickTime()).withStartingGalleryPosition(advertDetailsArguments.getGalleryPosition());
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            AdvertFragmentComponent.Builder withResources = withStartingGalleryPosition.withResources(resources);
            AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate = this.n;
            if (advertDetailsFragmentDelegate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertDetailsFragmentDelegate");
            }
            AdvertFragmentComponent.Builder withTreeParent = withResources.withFragmentDelegate(advertDetailsFragmentDelegate).withLifecycleOwner(this).withViewModelStoreOwner(this).withSectionSavedState(bundle2).withAutotekaInteractorState(kundle).withAutotekaDetailsResponse(null).withAutotekaTeaserInteractorState(kundle2).withDomotekaTeaserInteractorState(kundle3).withItemVisibilityTrackerState(bundle4).withToolbarPresenterState(kundle4).withQuestionnaireState(bundle3).witReplacementsPresenterState(kundle7).withCompatibilitiesPresenterState(kundle8).withTreeParent(advertDetailsArguments.getTreeParent());
            PublishRelay<FavoriteSellersItemAction> create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            withTreeParent.withRelay(create).withRecommendationPresenterState(kundle5).withBrokerAnalyticsState(kundle6).withAnalyticsRecommendationSource(SubscriptionSource.ADVERT_DETAILS_REC).withBannerPageSource(BannerPageSource.ADVERT).build().inject(this);
            AdvertDetailsTracker advertDetailsTracker = this.tracker;
            if (advertDetailsTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            advertDetailsTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("AdvertDetailsArguments must be specified");
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    public final void startForResultProxy(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        startForResult(intent, i);
    }
}
