package com.avito.android.serp;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialogEvent;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerConfirmedEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.event.SearchSubscriptionsClickEvent;
import com.avito.android.analytics.event.ShortcutBannerClickEvent;
import com.avito.android.analytics.event.ShortcutBannerShowEvent;
import com.avito.android.analytics.event.ShowSerpScreenEvent;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhoneRequestData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.search.SearchBar;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.deep_linking.links.SearchSubscriptionControlLink;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.di.module.InitialQuery;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.di.module.SnippetClose;
import com.avito.android.di.module.SnippetVisibility;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.appending_item.loader.AppendingLoaderItem;
import com.avito.android.home.appending_item.retry.AppendingRetryItem;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.search.Header;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.Result;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.SerpPresenter;
import com.avito.android.serp.SerpRouter;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpDataSource;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SerpItemSaturator;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerItem;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.promo_card.PromoCardItem;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.skeleton.SkeletonItem;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.diff_calculator.AddDiff;
import com.avito.android.serp.diff_calculator.ChangeDiff;
import com.avito.android.serp.diff_calculator.DiffCalculator;
import com.avito.android.serp.diff_calculator.RemoveDiff;
import com.avito.android.ui.view.retry.RetryView;
import com.avito.android.util.Formatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.adapter.ClarifyButtonItem;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemKt;
import ru.avito.messenger.api.AvitoMessengerApiKt;
import ru.avito.messenger.api.entity.Channel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B¿\u0004\b\u0007\u0012\n\u0010³\u0002\u001a\u0005\u0018\u00010±\u0002\u0012\b\u0010¥\u0002\u001a\u00030£\u0002\u0012\b\u0010Ð\u0002\u001a\u00030Î\u0002\u0012\b\u0010°\u0002\u001a\u00030®\u0002\u0012\b\u0010Þ\u0001\u001a\u00030Ü\u0001\u0012\u0015\u0010Ý\u0002\u001a\u0010\u0012\u000b\u0012\t0Û\u0002¢\u0006\u0003\bÜ\u00020Ê\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010Â\u0002\u001a\u00030¿\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010¶\u0001\u001a\u00030³\u0001\u0012\b\u0010ç\u0002\u001a\u00030ä\u0002\u0012\b\u0010â\u0001\u001a\u00030ß\u0001\u0012\b\u0010õ\u0002\u001a\u00030ò\u0002\u0012\b\u0010î\u0001\u001a\u00030ë\u0001\u0012\u000b\b\u0001\u0010Ù\u0001\u001a\u0004\u0018\u00010'\u0012\b\u0010Æ\u0002\u001a\u00030Ã\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010æ\u0001\u001a\u00030ã\u0001\u0012\b\u0010Ä\u0001\u001a\u00030Á\u0001\u0012\b\u0010Ô\u0002\u001a\u00030Ñ\u0002\u0012\b\u0010ê\u0001\u001a\u00030ç\u0001\u0012\n\b\u0001\u0010á\u0002\u001a\u00030Þ\u0002\u0012\u0010\b\u0001\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020'0Ê\u0001\u0012\b\u0010ª\u0002\u001a\u00030§\u0002\u0012\u001e\b\u0001\u0010­\u0002\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020/0¼\u00010»\u0001\u0012\u001e\b\u0001\u0010À\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020/0¼\u00010»\u0001\u0012\u001e\b\u0001\u0010Ï\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020\u00170¼\u00010»\u0001\u0012\u0011\b\u0001\u0010Ú\u0002\u001a\n\u0012\u0005\u0012\u00030×\u00020Ö\u0002\u0012\b\u0010»\u0002\u001a\u00030¸\u0002\u0012\b\u0010ò\u0001\u001a\u00030ï\u0001\u0012\b\u0010·\u0002\u001a\u00030´\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010º\u0001\u001a\u00030·\u0001\u0012\b\u0010ù\u0002\u001a\u00030ö\u0002\u0012\b\u0010ë\u0002\u001a\u00030è\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010ý\u0002\u001a\u00030ú\u0002\u0012\b\u0010\u0002\u001a\u00030þ\u0001\u0012\b\u0010Ê\u0002\u001a\u00030Ç\u0002\u0012\b\u0010û\u0001\u001a\u00030ø\u0001\u0012\b\u0010Ó\u0001\u001a\u00030Ð\u0001\u0012\b\u0010\u0003\u001a\u00030\u0003\u0012\b\u0010\u0003\u001a\u00030\u0003\u0012\t\u0010õ\u0001\u001a\u0004\u0018\u00010Y\u0012\b\u0010×\u0001\u001a\u00030Ô\u0001¢\u0006\u0006\b\u0003\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010$J'\u0010+\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020&2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J)\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J)\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u0002052\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00106J3\u00108\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00107\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b8\u00109J3\u0010:\u001a\u00020\u00072\u0006\u0010.\u001a\u0002052\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00107\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b@\u0010?J\u001f\u0010B\u001a\u00020\u00072\u0006\u0010.\u001a\u0002052\u0006\u0010A\u001a\u00020<H\u0016¢\u0006\u0004\bB\u0010CJ'\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020'2\u0006\u0010=\u001a\u00020<2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bB\u0010EJ'\u0010F\u001a\u00020\u00072\u0006\u0010D\u001a\u00020'2\u0006\u0010=\u001a\u00020<2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bF\u0010EJ\u0017\u0010G\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bG\u0010?J\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020'H\u0016¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020K2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bS\u0010?J\u001f\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020T2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bX\u0010?J\u000f\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\\\u0010\u000bJ\u000f\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b]\u0010\u000bJ\u000f\u0010^\u001a\u00020\u0007H\u0016¢\u0006\u0004\b^\u0010\u000bJ\u0017\u0010_\u001a\u00020\u00072\u0006\u0010A\u001a\u00020<H\u0016¢\u0006\u0004\b_\u0010?J\u0017\u0010`\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b`\u0010?J\u0017\u0010b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\u00072\u0006\u0010d\u001a\u00020/H\u0016¢\u0006\u0004\be\u0010fJ\u0018\u0010i\u001a\u00020\u00072\u0006\u0010h\u001a\u00020gH\u0001¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\u0007H\u0002¢\u0006\u0004\bk\u0010\u000bJ_\u0010p\u001a\u00020\u00072\u0006\u00100\u001a\u00020/2\u0006\u0010=\u001a\u00020<2\u0006\u0010l\u001a\u00020'2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010'2\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u00107\u001a\u0004\u0018\u00010/2\u0006\u0010o\u001a\u00020\u0017H\u0002¢\u0006\u0004\bp\u0010qJ'\u0010r\u001a\u00020\u00072\u0006\u0010D\u001a\u00020'2\u0006\u0010=\u001a\u00020<2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\br\u0010EJE\u0010{\u001a\u0014 z*\t\u0018\u00010x¢\u0006\u0002\by0x¢\u0006\u0002\by2\u0006\u0010s\u001a\u00020'2\u0006\u0010u\u001a\u00020t2\b\u0010v\u001a\u0004\u0018\u00010'2\b\u0010w\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b{\u0010|J#\u0010~\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b~\u0010J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ0\u0010\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020t2\b\u0010v\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u001d\u0010\u0001\u001a\u00020\u00072\n\b\u0002\u0010}\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0005\b\u0001\u0010JJ\u0011\u0010\u0001\u001a\u00020\u0017H\u0002¢\u0006\u0005\b\u0001\u0010\u0019J-\u0010\u0001\u001a\u00020\u00072\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0017H\u0002¢\u0006\u0005\b\u0001\u0010\u0019J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ\u001e\u0010\u0001\u001a\u00020\u0007*\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u0007*\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u000bJ5\u0010 \u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020'2\u0007\u0010\u0001\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b¢\u0001\u0010\u000bJ\u0014\u0010£\u0001\u001a\u0004\u0018\u00010tH\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J4\u0010¨\u0001\u001a\u00020\u00072\u000f\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010\u00012\u000f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0011\u0010ª\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bª\u0001\u0010\u000bJ\u0011\u0010«\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b«\u0001\u0010\u000bJ\u0019\u0010¬\u0001\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0005\b¬\u0001\u0010?J\u001d\u0010®\u0001\u001a\u00020\u00072\t\b\u0002\u0010­\u0001\u001a\u00020\u0017H\u0002¢\u0006\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R.\u0010À\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020/0¼\u00010»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001a\u0010Ä\u0001\u001a\u00030Á\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R(\u0010É\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ç\u00010Æ\u00010Å\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010È\u0001R \u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020'0Ê\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R.\u0010Ï\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020\u00170¼\u00010»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010¿\u0001R\u001a\u0010Ó\u0001\u001a\u00030Ð\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010×\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010Ù\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010±\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010Þ\u0001\u001a\u00030Ü\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Ý\u0001R\u001a\u0010â\u0001\u001a\u00030ß\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001a\u0010æ\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001a\u0010ê\u0001\u001a\u00030ç\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001a\u0010î\u0001\u001a\u00030ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001a\u0010ò\u0001\u001a\u00030ï\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001b\u0010õ\u0001\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\"\u0010÷\u0001\u001a\u000b\u0012\u0004\u0012\u00020'\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010ö\u0001R\u001a\u0010û\u0001\u001a\u00030ø\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u001a\u0010ý\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b{\u0010ü\u0001R\u001a\u0010\u0002\u001a\u00030þ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b~\u0010Ë\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bª\u0001\u0010¢\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010¡\u0002\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010 \u0002R\u0019\u0010¢\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0001R\u0019\u0010¥\u0002\u001a\u00030£\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bk\u0010¤\u0002R\u0019\u0010¦\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b«\u0001\u0010Ë\u0001R\u001a\u0010ª\u0002\u001a\u00030§\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bp\u0010«\u0002R.\u0010­\u0002\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030½\u0001\u0012\u0004\u0012\u00020/0¼\u00010»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0002\u0010¿\u0001R\u001a\u0010°\u0002\u001a\u00030®\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010¯\u0002R\u001c\u0010³\u0002\u001a\u0005\u0018\u00010±\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010²\u0002R\u001a\u0010·\u0002\u001a\u00030´\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001a\u0010»\u0002\u001a\u00030¸\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u0019\u0010¼\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0001R\u0019\u0010¾\u0002\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b½\u0002\u0010±\u0001R\u001a\u0010Â\u0002\u001a\u00030¿\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R\u001a\u0010Æ\u0002\u001a\u00030Ã\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u001a\u0010Ê\u0002\u001a\u00030Ç\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0002\u0010É\u0002R\u001b\u0010Ì\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0002R\u001a\u0010Í\u0002\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\br\u0010±\u0001R\u001a\u0010Ð\u0002\u001a\u00030Î\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010Ï\u0002R\u001a\u0010Ô\u0002\u001a\u00030Ñ\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Õ\u0002R!\u0010Ú\u0002\u001a\n\u0012\u0005\u0012\u00030×\u00020Ö\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bØ\u0002\u0010Ù\u0002R'\u0010Ý\u0002\u001a\u0010\u0012\u000b\u0012\t0Û\u0002¢\u0006\u0003\bÜ\u00020Ê\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Ì\u0001R\u001a\u0010á\u0002\u001a\u00030Þ\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bß\u0002\u0010à\u0002R\u001b\u0010ã\u0002\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010â\u0002R\u001a\u0010ç\u0002\u001a\u00030ä\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bå\u0002\u0010æ\u0002R\u001a\u0010ë\u0002\u001a\u00030è\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0002\u0010ê\u0002R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010ì\u0002R!\u0010í\u0002\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010ö\u0001R\u0019\u0010î\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0001R\u0019\u0010ï\u0002\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0001R!\u0010ñ\u0002\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010ð\u0002R\u001a\u0010õ\u0002\u001a\u00030ò\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bó\u0002\u0010ô\u0002R\u001a\u0010ù\u0002\u001a\u00030ö\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b÷\u0002\u0010ø\u0002R\u001a\u0010ý\u0002\u001a\u00030ú\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bû\u0002\u0010ü\u0002R\u001b\u0010þ\u0002\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010±\u0001R\u001c\u0010\u0003\u001a\u0005\u0018\u00010ÿ\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0003R\u001a\u0010\u0003\u001a\u00030\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0003R\u001b\u0010\u0003\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010ü\u0001R\u001c\u0010\u0003\u001a\u0005\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0003¨\u0006\u0003"}, d2 = {"Lcom/avito/android/serp/SerpPresenterImpl;", "Lcom/avito/android/serp/SerpPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/serp/SerpPresenterView;", "view", "Lcom/avito/android/ui/view/retry/RetryView;", "retryView", "", "attachView", "(Lcom/avito/android/serp/SerpPresenterView;Lcom/avito/android/ui/view/retry/RetryView;)V", "subscribeToLocationChanges", "()V", "Lcom/avito/android/serp/SerpRouter;", "router", "attachRouter", "(Lcom/avito/android/serp/SerpRouter;)V", "retryItemsLoading", "retryLoading", "detachView", "detachRouter", "onStop", "onResume", "onAppend", "", "canAppend", "()Z", "success", "Landroid/os/Parcelable;", "authResultData", "onUserAuthorized", "(ZLandroid/os/Parcelable;)V", "onSearchSubscriptionToggled", "onClarifyClicked", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "item", "onShortcutBannerItemShowed", "(Lcom/avito/android/serp/adapter/ShortcutBannerItem;)V", "onShortcutBannerItemClicked", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "", "src", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "showAuth", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;)V", "galleryPosition", "onRichAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "onRichAdvertXlClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onWitcherSearchButtonClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onAdditionalActionClicked", "deeplink", "onCallActionClicked", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;Lcom/avito/android/deep_linking/links/DeepLink;)V", BookingInfoActivity.EXTRA_ITEM_ID, "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "onWriteActionClicked", "onDeepLinkActionClicked", "itemId", "onItemClose", "(Ljava/lang/String;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "Lcom/avito/android/remote/model/Action;", "action", "onSerpWarningAction", "(Lcom/avito/android/remote/model/Action;)V", "onFollowDeeplinkFromEmpty", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "warning", "onSerpWarningClosed", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItem;I)V", "onSearchClarified", "Lcom/avito/android/serp/SerpPresenterState;", "onSaveState", "()Lcom/avito/android/serp/SerpPresenterState;", "onRefresh", "onBackPressed", "onUpPressed", "onSellerItemClick", "onSearchOnMapClicked", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "onBannerClicked", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;)V", "mostDepthVisibleItemPosition", "onVisibleItemChanged", "(I)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "D", "title", "price", "oldPrice", "isMarketplace", "c", "(ILcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Integer;Z)V", "p", "query", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "clearGeoFilters", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/annotations/NonNull;", "kotlin.jvm.PlatformType", "n", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/disposables/Disposable;", "fromSource", "t", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "e", "r", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/String;)V", "F", AuthSource.OPEN_CHANNEL_LIST, "k", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "newElements", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "l", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)V", "Lcom/avito/konveyor/data_source/DataSource;", "G", "()Lcom/avito/konveyor/data_source/DataSource;", "j", "x", "B", "C", "y", "w", VKApiConst.VERSION, "H", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", AuthSource.BOOKING_ORDER, "i", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "source", "z", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "I", "h", "()Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/serp/adapter/SpannedItem;", "spanDataSource", "itemDataSource", VKApiConst.Q, "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)V", "f", "s", a2.g.r.g.a, "withRefreshTracker", ExifInterface.LONGITUDE_EAST, "(Z)V", "o", "Ljava/lang/String;", "searchHint", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "L", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "advertMessengerInteractor", "Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "j0", "Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "diffCalculator", "Lcom/jakewharton/rxrelay3/Relay;", "Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "c0", "Lcom/jakewharton/rxrelay3/Relay;", "snippetCloseObservable", "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;", "closedItemInteractor", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/serp/Serp;", "Lio/reactivex/rxjava3/core/Observable;", "serpObservable", "Lcom/avito/android/util/Formatter;", "Z", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "d0", "snippetVisibilityObservable", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "r0", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "snippetScrollDepthAnalyticsInteractor", "Lcom/avito/android/location/SavedLocationInteractor;", "t0", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "Q", "initialQuery", "u", "Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/serp/SerpResourcesProvider;", "N", "Lcom/avito/android/serp/SerpResourcesProvider;", "resourcesProvider", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "U", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "closedItemPresenter", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "X", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "advertXlStateProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "P", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "g0", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "saturator", "s0", "Lcom/avito/android/serp/SerpPresenterState;", "state", "Ljava/util/List;", "showedShortcutBannerIds", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "q0", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "Ljava/lang/Integer;", "authRequestedFor", "Lcom/avito/android/util/preferences/Preferences;", "o0", "Lcom/avito/android/util/preferences/Preferences;", "defaultPreferences", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "K", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialBannersAnalyticsInteractor", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "i0", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "isRefreshed", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "T", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "m0", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "skeletonGenerator", "sortedItemCount", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/serp/SerpParameters;", "Lcom/avito/android/serp/SerpParameters;", "serpParameters", "searchSubscriptionsTapTargetWasShown", "Lcom/avito/android/serp/SerpInteractor;", "Lcom/avito/android/serp/SerpInteractor;", "interactor", "isLoading", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "a0", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "clickStreamLinkHandler", "Lcom/avito/android/serp/SerpRouter;", "b0", "snippetClickObservable", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "dfpDebugPresenter", "Lcom/avito/android/serp/analytics/SerpTracker;", "h0", "Lcom/avito/android/serp/analytics/SerpTracker;", "tracker", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "f0", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "isSubscribed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "serpAppearanceUuid", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "J", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "serpAnalyticsInteractor", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "R", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "connectionQualitySubscriber", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "p0", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/deep_linking/links/DeepLink;", "searchSubscriptionAction", "xHash", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "subscriptionInteractor", "Lcom/avito/android/Features;", ExifInterface.LONGITUDE_WEST, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ui/view/retry/RetryView;", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "e0", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "justDialSellerPhoneTestGroup", "", "Lkotlin/jvm/JvmSuppressWildcards;", "errorFormatter", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "Y", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "richSnippetStateProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", "searchSubscription", "Lcom/avito/android/util/SchedulersFactory3;", "M", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "l0", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "verticalFilterPresenter", "Lcom/avito/android/serp/SerpPresenterView;", "items", "hasMorePages", "hasFailureOnLoading", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "O", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "k0", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "n0", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "serpSkeletonTestGroup", "subscriptionId", "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "asyncPhoneRequestData", "Lcom/avito/android/serp/SerpPageParams;", "Lcom/avito/android/serp/SerpPageParams;", "pageParams", "currentPage", "Lcom/avito/android/serp/CallInfo;", "Lcom/avito/android/serp/CallInfo;", "callInfo", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;", "appendingRetryItemPresenter", "Lcom/avito/android/serp/SerpArguments;", "serpArguments", "<init>", "(Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;Lcom/avito/android/serp/SerpInteractor;Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/SerpResourcesProvider;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Ljava/lang/String;Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;Lcom/avito/android/serp/adapter/closable/ClosedItemInteractor;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/deep_linking/ClickStreamLinkHandler;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/inline_filters/InlineFiltersPresenter;Lcom/avito/android/serp/adapter/SerpItemSaturator;Lcom/avito/android/serp/analytics/SerpTracker;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/serp/diff_calculator/DiffCalculator;Lcom/avito/android/saved_searches/SavedSearchesPresenter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;Lcom/avito/android/serp/SerpArguments;Lcom/avito/android/serp/SerpPresenterState;Lcom/avito/android/location/SavedLocationInteractor;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpPresenterImpl implements SerpPresenter, FavoriteButtonClickListener {
    public String A;
    public AsyncPhoneRequestData B;
    public final DfpDebugPresenter C;
    public final SerpInteractor D;
    public final SubscribeSearchInteractor E;
    public final AdapterPresenter F;
    public final PersistableFloatingViewsPresenter G;
    public final Formatter<Throwable> H;
    public final Analytics I;
    public final SerpAnalyticsInteractor J;
    public final CommercialBannersAnalyticsInteractor K;
    public final AdvertMessengerInteractor L;
    public final SchedulersFactory3 M;
    public final SerpResourcesProvider N;
    public final SerpSpanProvider O;
    public final SpannedGridPositionProvider P;
    public final String Q;
    public final ConnectionQualitySubscriber R;
    public final FavoriteAdvertsPresenter S;
    public final ViewedAdvertsPresenter T;
    public final ClosedItemPresenter U;
    public final ClosedItemInteractor V;
    public final Features W;
    public final AdvertXlStateProvider X;
    public final RichSnippetStateProvider Y;
    public final Formatter<String> Z;
    public SerpPresenterView a;
    public final ClickStreamLinkHandler a0;
    public RetryView b;
    public final Relay<Pair<SnippetItem, Integer>> b0;
    public SerpRouter c;
    public final Relay<Pair<SnippetItem, Integer>> c0;
    public final CompositeDisposable d;
    public final Relay<Pair<SnippetItem, Boolean>> d0;
    public Disposable e;
    public final AbTestGroup<SimpleTestGroupWithControl2> e0;
    public int f;
    public final InlineFiltersPresenter f0;
    public List<String> g;
    public final SerpItemSaturator g0;
    public final List<ViewTypeSerpItem> h;
    public final SerpTracker h0;
    public boolean i;
    public final ItemVisibilityTracker i0;
    public SerpParameters j;
    public final DiffCalculator j0;
    public SerpPageParams k;
    public final SavedSearchesPresenter k0;
    public String l;
    public final VerticalFilterPresenter l0;
    public boolean m;
    public final SkeletonGenerator m0;
    public Integer n;
    public final SerpSkeletonTestGroup n0;
    public String o;
    public final Preferences o0;
    public String p;
    public final AsyncPhonePresenter p0;
    public Integer q;
    public final SnippetScrollDepthTracker q0;
    public boolean r;
    public final SnippetScrollDepthAnalyticsInteractor r0;
    public boolean s;
    public final SerpPresenterState s0;
    public boolean t;
    public final SavedLocationInteractor t0;
    public SerpDisplayType u;
    public DataSource<ViewTypeSerpItem> v;
    public CallInfo w;
    public boolean x;
    public DeepLink y;
    public final Observable<LoadingState<Serp>> z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SearchSubscribeReason.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.avito.android.util.Formatter */
        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            SerpPresenterView serpPresenterView;
            int i = this.a;
            if (i == 0) {
                Throwable th2 = th;
                SerpPresenterView serpPresenterView2 = ((SerpPresenterImpl) this.b).a;
                if (serpPresenterView2 != null) {
                    serpPresenterView2.showError(((SerpPresenterImpl) this.b).H.format(th2));
                }
                if (((SerpPresenterImpl) this.b).f0.getInlineFilters() == null && (serpPresenterView = ((SerpPresenterImpl) this.b).a) != null) {
                    serpPresenterView.hideShortcutsWithShift();
                }
            } else if (i == 1) {
                Throwable th3 = th;
                SerpPresenterView serpPresenterView3 = ((SerpPresenterImpl) this.b).a;
                if (serpPresenterView3 != null) {
                    serpPresenterView3.showError(((SerpPresenterImpl) this.b).H.format(th3));
                }
            } else {
                throw null;
            }
        }
    }

    public static final class a0<T> implements Consumer<SuggestAction> {
        public final /* synthetic */ SerpPresenterImpl a;

        public a0(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SuggestAction suggestAction) {
            SuggestAction suggestAction2 = suggestAction;
            if (suggestAction2 instanceof SuggestDeeplink) {
                this.a.e();
                SerpRouter serpRouter = this.a.c;
                if (serpRouter != null) {
                    serpRouter.followDeepLink(((SuggestDeeplink) suggestAction2).getDeepLink(), this.a.J.getParent());
                }
            } else if (suggestAction2 instanceof SuggestAnalyticsEvent) {
                this.a.J.sendClickSearchSuggest((SuggestAnalyticsEvent) suggestAction2);
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<DeepLink> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(DeepLink deepLink) {
            int i = this.a;
            if (i == 0) {
                DeepLink deepLink2 = deepLink;
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                ((SerpPresenterImpl) this.b).t(deepLink2, "inline_filters");
            } else if (i == 1) {
                DeepLink deepLink3 = deepLink;
                SerpRouter serpRouter = ((SerpPresenterImpl) this.b).c;
                if (serpRouter != null) {
                    Intrinsics.checkNotNullExpressionValue(deepLink3, "it");
                    serpRouter.followDeepLink(deepLink3);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b0<T> implements Consumer<ShortcutNavigationItem> {
        public final /* synthetic */ SerpPresenterImpl a;

        public b0(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ShortcutNavigationItem shortcutNavigationItem) {
            ShortcutNavigationItem shortcutNavigationItem2 = shortcutNavigationItem;
            SerpPresenterImpl serpPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(shortcutNavigationItem2, "it");
            SerpPresenterImpl.access$openShortcut(serpPresenterImpl, shortcutNavigationItem2);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<DeepLink> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(DeepLink deepLink) {
            int i = this.a;
            if (i == 0) {
                DeepLink deepLink2 = deepLink;
                SerpRouter serpRouter = ((SerpPresenterImpl) this.b).c;
                if (serpRouter != null) {
                    Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                    serpRouter.followDeepLink(deepLink2);
                }
            } else if (i == 1) {
                DeepLink deepLink3 = deepLink;
                ((SerpPresenterImpl) this.b).J.sendResetActionClick();
                Intrinsics.checkNotNullExpressionValue(deepLink3, "it");
                SerpPresenterImpl.u((SerpPresenterImpl) this.b, deepLink3, null, 2);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class d<T> implements Consumer<Pair<? extends SnippetItem, ? extends Integer>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public d(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Pair<? extends SnippetItem, ? extends Integer> pair) {
            int i = this.a;
            if (i == 0) {
                Pair<? extends SnippetItem, ? extends Integer> pair2 = pair;
                SnippetItem snippetItem = (SnippetItem) pair2.getFirst();
                if (snippetItem.getAction().getDeepLink() instanceof SearchSubscriptionControlLink) {
                    ((SerpPresenterImpl) this.b).onSearchSubscriptionToggled();
                } else {
                    SerpRouter serpRouter = ((SerpPresenterImpl) this.b).c;
                    if (serpRouter != null) {
                        serpRouter.followDeepLink(snippetItem.getAction().getDeepLink());
                    }
                }
                if (snippetItem.getAction().getClosesElement() == null || Intrinsics.areEqual(snippetItem.getAction().getClosesElement(), Boolean.TRUE)) {
                    SerpPresenterImpl.access$closeSnippetItem((SerpPresenterImpl) this.b, ((Number) pair2.getSecond()).intValue());
                }
                ((SerpPresenterImpl) this.b).D.sendSnippetActionClick(snippetItem.getStringId(), snippetItem.getAnalytics());
            } else if (i == 1) {
                Pair<? extends SnippetItem, ? extends Integer> pair3 = pair;
                SerpPresenterImpl.access$closeSnippetItem((SerpPresenterImpl) this.b, ((Number) pair3.getSecond()).intValue());
                SnippetItem snippetItem2 = (SnippetItem) pair3.getFirst();
                ((SerpPresenterImpl) this.b).D.sendSnippetActionClose(snippetItem2.getStringId(), snippetItem2.getAnalytics());
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class e<T> implements Consumer<Throwable> {
        public static final e b = new e(0);
        public static final e c = new e(1);
        public static final e d = new e(2);
        public static final e e = new e(3);
        public static final e f = new e(4);
        public static final e g = new e(5);
        public static final e h = new e(6);
        public static final e i = new e(7);
        public static final e j = new e(8);
        public final /* synthetic */ int a;

        public e(int i2) {
            this.a = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            switch (this.a) {
                case 0:
                    Logs.error("SerpPresenter", "Error resetActionClicks", th);
                    return;
                case 1:
                    Logs.error("SerpPresenter", "Error snippetClickObservable", th);
                    return;
                case 2:
                    Logs.error("SerpPresenter", "Error snippetCloseObservable", th);
                    return;
                case 3:
                    Logs.error("SerpPresenter", "Error snippetVisibilityObservable", th);
                    return;
                case 4:
                    Logs.error("SerpPresenter", "Error tooltipDetailsLinkClicks", th);
                    return;
                case 5:
                    Logs.error("SerpPresenter", "Error submitCallbacks", th);
                    return;
                case 6:
                    Logs.error("SerpPresenter", "Error openCallbacks", th);
                    return;
                case 7:
                    Logs.error("SerpPresenter", "Error searchSuggestsCallbacks", th);
                    return;
                case 8:
                    Logs.error("SerpPresenter", "Error shortcutClicks", th);
                    return;
                default:
                    throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class f<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public f(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((SerpPresenterImpl) this.b).s();
            } else if (i == 1) {
                SerpRouter serpRouter = ((SerpPresenterImpl) this.b).c;
                if (serpRouter != null) {
                    serpRouter.showNotificationSettingsScreen();
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class g<T> implements Consumer<Throwable> {
        public static final g b = new g(0);
        public static final g c = new g(1);
        public final /* synthetic */ int a;

        public g(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class h<T> implements Consumer<LoadingState<? super Serp>> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super Serp> loadingState) {
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpPresenter", "Error serpObservable", th);
        }
    }

    public static final class j<T> implements Consumer<ViewTypeSerpItem> {
        public final /* synthetic */ SerpPresenterImpl a;

        public j(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            int size = this.a.h.size();
            for (int i = 0; i < size; i++) {
                ViewTypeSerpItem viewTypeSerpItem3 = (ViewTypeSerpItem) this.a.h.get(i);
                if (viewTypeSerpItem3.getId() == viewTypeSerpItem2.getId() && (viewTypeSerpItem3 instanceof SerpCommercialBanner) && ((SerpCommercialBanner) viewTypeSerpItem3).getHasNotLoadedAd()) {
                    List list = this.a.h;
                    Intrinsics.checkNotNullExpressionValue(viewTypeSerpItem2, "ad");
                    list.set(i, viewTypeSerpItem2);
                    SerpPresenterImpl.access$updatePosition(this.a, i);
                    return;
                }
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public static final k a = new k();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpPresenter", "Ads load errors.", th);
        }
    }

    public static final class l<T> implements Consumer<LoadingState<? super DeepLink>> {
        public final /* synthetic */ SerpPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SearchParams c;

        public l(SerpPresenterImpl serpPresenterImpl, String str, SearchParams searchParams) {
            this.a = serpPresenterImpl;
            this.b = str;
            this.c = searchParams;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeepLink> loadingState) {
            LoadingState<? super DeepLink> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                SerpPresenterImpl.u(this.a, (DeepLink) ((LoadingState.Loaded) loadingState2).getData(), null, 2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                SerpPresenterImpl.access$searchByQuery(this.a, this.b, this.c);
            }
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpPresenter", "Error loadSearchDeeplink", th);
        }
    }

    public static final class n extends Lambda implements Function1<DeepLink, Unit> {
        public final /* synthetic */ SerpPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(SerpPresenterImpl serpPresenterImpl, String str, ContactSource contactSource) {
            super(1);
            this.a = serpPresenterImpl;
            this.b = str;
            this.c = contactSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullParameter(deepLink2, "link");
            this.a.w = new CallInfo(this.b, deepLink2, this.c);
            this.a.i();
            return Unit.INSTANCE;
        }
    }

    public static final class o<T> implements Consumer<LoadingState<? super DeepLink>> {
        public final /* synthetic */ SerpPresenterImpl a;

        public o(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeepLink> loadingState) {
            SearchPushSubscription subscription;
            LoadingState<? super DeepLink> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                SerpPresenterView serpPresenterView = this.a.a;
                if (serpPresenterView != null) {
                    serpPresenterView.setSubscriptionSwitchedLoading();
                    return;
                }
                return;
            }
            SaveSearchLink saveSearchLink = null;
            if (loadingState2 instanceof LoadingState.Loaded) {
                SerpPresenterImpl.access$setSubscriptionButtonFinalState(this.a);
                Object data = ((LoadingState.Loaded) loadingState2).getData();
                if (data instanceof SaveSearchLink) {
                    saveSearchLink = data;
                }
                SaveSearchLink saveSearchLink2 = saveSearchLink;
                if (saveSearchLink2 != null && (subscription = saveSearchLink2.getSubscription()) != null) {
                    SavedSearchesPresenter.DefaultImpls.openSubscriptionDialog$default(this.a.k0, subscription, "serp", null, 4, null);
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingState.Error error = (LoadingState.Error) loadingState2;
                SerpPresenterImpl.access$onSearchSubscriptionError(this.a, error.getError());
                SerpPresenterImpl.access$setSubscriptionButtonFinalState(this.a);
                Logs.error$default("SerpPresenter", error.getError().toString(), null, 4, null);
            }
        }
    }

    public static final class p<T> implements Consumer<Channel> {
        public static final p a = new p();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Channel channel) {
        }
    }

    public static final class q<T> implements Consumer<Throwable> {
        public static final q a = new q();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.debug("SerpPresenter", "Failed to send respond", th);
        }
    }

    public static final class r extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PhoneLink d;
        public final /* synthetic */ String e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(SerpPresenterImpl serpPresenterImpl, String str, String str2, PhoneLink phoneLink, String str3) {
            super(0);
            this.a = serpPresenterImpl;
            this.b = str;
            this.c = str2;
            this.d = phoneLink;
            this.e = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.w = null;
            this.a.I.track(new CallToSellerConfirmedEvent(this.b, this.c));
            SerpRouter serpRouter = this.a.c;
            if (serpRouter != null) {
                serpRouter.followPhoneLink(this.d, new m5(0, this), new m5(1, this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(SerpPresenterImpl serpPresenterImpl) {
            super(0);
            this.a = serpPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.w = null;
            return Unit.INSTANCE;
        }
    }

    public static final class t<T> implements Consumer<Boolean> {
        public final /* synthetic */ SerpPresenterImpl a;

        public t(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            if (!bool2.booleanValue()) {
                SerpPresenterView serpPresenterView = this.a.a;
                if (serpPresenterView != null) {
                    serpPresenterView.hideShortcutsWithShift();
                }
            } else if (!this.a.s) {
                this.a.y();
            }
        }
    }

    public static final class u<T> implements Consumer<Location> {
        public final /* synthetic */ SerpPresenterImpl a;

        public u(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            String locationId;
            SearchParams h;
            SearchParams copy$default;
            Location location2 = location;
            SearchParams h2 = this.a.h();
            if (h2 != null && (locationId = h2.getLocationId()) != null && this.a.t0.checkLocationForSearch(locationId) && (h = this.a.h()) != null && (copy$default = SearchParams.copy$default(h, null, null, location2.getId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null)) != null) {
                SerpPresenterView serpPresenterView = this.a.a;
                if (serpPresenterView != null) {
                    serpPresenterView.showProgress();
                }
                SerpPresenterView serpPresenterView2 = this.a.a;
                if (serpPresenterView2 != null) {
                    serpPresenterView2.setSearchHintSearch();
                }
                SerpPresenterState serpPresenterState = this.a.s0;
                if (serpPresenterState != null) {
                    serpPresenterState.setLoadDeepLinkForBackNavigation(true);
                }
                SerpPresenterImpl serpPresenterImpl = this.a;
                String query = copy$default.getQuery();
                if (query == null) {
                    query = "";
                }
                serpPresenterImpl.n(query, copy$default, SerpPresenterImpl.access$getContext(this.a), Boolean.TRUE);
            }
        }
    }

    public static final class v<T> implements Consumer<Throwable> {
        public static final v a = new v();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpPresenter", "Error back Navigation", th);
        }
    }

    public static final class w<T> implements Consumer<Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink>> {
        public final /* synthetic */ SerpPresenterImpl a;

        public w(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair) {
            Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair2 = pair;
            this.a.y = (DeepLink) pair2.getSecond();
            this.a.m = pair2.getSecond() instanceof SaveSearchLink.Edit;
            this.a.v();
            int ordinal = ((SearchSubscribeReason) pair2.getFirst()).ordinal();
            if (ordinal == 0) {
                this.a.l = ((SaveSearchLink) pair2.getSecond()).getSubscription().getFilterId();
            } else if (ordinal == 1) {
                this.a.l = null;
            }
        }
    }

    public static final class x<T> implements Consumer<Pair<? extends SnippetItem, ? extends Boolean>> {
        public final /* synthetic */ SerpPresenterImpl a;

        public x(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends SnippetItem, ? extends Boolean> pair) {
            Pair<? extends SnippetItem, ? extends Boolean> pair2 = pair;
            SnippetItem snippetItem = (SnippetItem) pair2.getFirst();
            if (((Boolean) pair2.getSecond()).booleanValue()) {
                this.a.D.sendSnippetActionShow(snippetItem.getStringId(), snippetItem.getAnalytics());
            } else {
                this.a.D.sendSnippetActionHide(snippetItem.getStringId(), snippetItem.getAnalytics());
            }
        }
    }

    public static final class y<T> implements Consumer<String> {
        public final /* synthetic */ SerpPresenterImpl a;

        public y(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            SerpPresenterImpl serpPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            SerpPresenterImpl.access$onQuerySubmitted(serpPresenterImpl, str2);
        }
    }

    public static final class z<T> implements Consumer<Boolean> {
        public final /* synthetic */ SerpPresenterImpl a;

        public z(SerpPresenterImpl serpPresenterImpl) {
            this.a = serpPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            SerpPresenterImpl serpPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            SerpPresenterImpl.access$onSearchStateChanged(serpPresenterImpl, bool2.booleanValue());
        }
    }

    @Inject
    public SerpPresenterImpl(@Nullable DfpDebugPresenter dfpDebugPresenter, @NotNull SerpInteractor serpInteractor, @NotNull SubscribeSearchInteractor subscribeSearchInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, @NotNull Formatter<Throwable> formatter, @NotNull Analytics analytics, @NotNull SerpAnalyticsInteractor serpAnalyticsInteractor, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @NotNull AdvertMessengerInteractor advertMessengerInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SerpResourcesProvider serpResourcesProvider, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @InitialQuery @Nullable String str, @NotNull ConnectionQualitySubscriber connectionQualitySubscriber, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull ClosedItemPresenter closedItemPresenter, @NotNull ClosedItemInteractor closedItemInteractor, @NotNull Features features, @NotNull AdvertXlStateProvider advertXlStateProvider, @RichStateProvider @NotNull RichSnippetStateProvider richSnippetStateProvider, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter2, @NotNull ClickStreamLinkHandler clickStreamLinkHandler, @SnippetClick @NotNull Relay<Pair<SnippetItem, Integer>> relay, @SnippetClose @NotNull Relay<Pair<SnippetItem, Integer>> relay2, @SnippetVisibility @NotNull Relay<Pair<SnippetItem, Boolean>> relay3, @JustDialSellerPhoneTestGroup @NotNull AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, @NotNull InlineFiltersPresenter inlineFiltersPresenter, @NotNull SerpItemSaturator serpItemSaturator, @NotNull SerpTracker serpTracker, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull DiffCalculator diffCalculator, @NotNull SavedSearchesPresenter savedSearchesPresenter, @NotNull VerticalFilterPresenter verticalFilterPresenter, @NotNull SkeletonGenerator skeletonGenerator, @NotNull SerpSkeletonTestGroup serpSkeletonTestGroup, @NotNull Preferences preferences, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull SnippetScrollDepthTracker snippetScrollDepthTracker, @NotNull SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor, @NotNull AppendingRetryItemPresenter appendingRetryItemPresenter, @NotNull SerpArguments serpArguments, @Nullable SerpPresenterState serpPresenterState, @NotNull SavedLocationInteractor savedLocationInteractor) {
        List<ViewTypeSerpItem> arrayList;
        SerpPageParams createFirstPage;
        String str2;
        SerpDisplayType serpDisplayType;
        Observable<LoadingState<Serp>> observable;
        Intrinsics.checkNotNullParameter(serpInteractor, "interactor");
        Intrinsics.checkNotNullParameter(subscribeSearchInteractor, "subscriptionInteractor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(persistableFloatingViewsPresenter, "floatingViewsPresenter");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(serpAnalyticsInteractor, "serpAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialBannersAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(advertMessengerInteractor, "advertMessengerInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(serpResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "serpSpanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(connectionQualitySubscriber, "connectionQualitySubscriber");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(closedItemPresenter, "closedItemPresenter");
        Intrinsics.checkNotNullParameter(closedItemInteractor, "closedItemInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(advertXlStateProvider, "advertXlStateProvider");
        Intrinsics.checkNotNullParameter(richSnippetStateProvider, "richSnippetStateProvider");
        Intrinsics.checkNotNullParameter(formatter2, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(clickStreamLinkHandler, "clickStreamLinkHandler");
        Intrinsics.checkNotNullParameter(relay, "snippetClickObservable");
        Intrinsics.checkNotNullParameter(relay2, "snippetCloseObservable");
        Intrinsics.checkNotNullParameter(relay3, "snippetVisibilityObservable");
        Intrinsics.checkNotNullParameter(abTestGroup, "justDialSellerPhoneTestGroup");
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter, "inlineFiltersPresenter");
        Intrinsics.checkNotNullParameter(serpItemSaturator, "saturator");
        Intrinsics.checkNotNullParameter(serpTracker, "tracker");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "savedSearchesPresenter");
        Intrinsics.checkNotNullParameter(verticalFilterPresenter, "verticalFilterPresenter");
        Intrinsics.checkNotNullParameter(skeletonGenerator, "skeletonGenerator");
        Intrinsics.checkNotNullParameter(serpSkeletonTestGroup, "serpSkeletonTestGroup");
        Intrinsics.checkNotNullParameter(preferences, "defaultPreferences");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker, "snippetScrollDepthTracker");
        Intrinsics.checkNotNullParameter(snippetScrollDepthAnalyticsInteractor, "snippetScrollDepthAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(appendingRetryItemPresenter, "appendingRetryItemPresenter");
        Intrinsics.checkNotNullParameter(serpArguments, "serpArguments");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        this.C = dfpDebugPresenter;
        this.D = serpInteractor;
        this.E = subscribeSearchInteractor;
        this.F = adapterPresenter;
        this.G = persistableFloatingViewsPresenter;
        this.H = formatter;
        this.I = analytics;
        this.J = serpAnalyticsInteractor;
        this.K = commercialBannersAnalyticsInteractor;
        this.L = advertMessengerInteractor;
        this.M = schedulersFactory3;
        this.N = serpResourcesProvider;
        this.O = serpSpanProvider;
        this.P = spannedGridPositionProvider;
        this.Q = str;
        this.R = connectionQualitySubscriber;
        this.S = favoriteAdvertsPresenter;
        this.T = viewedAdvertsPresenter;
        this.U = closedItemPresenter;
        this.V = closedItemInteractor;
        this.W = features;
        this.X = advertXlStateProvider;
        this.Y = richSnippetStateProvider;
        this.Z = formatter2;
        this.a0 = clickStreamLinkHandler;
        this.b0 = relay;
        this.c0 = relay2;
        this.d0 = relay3;
        this.e0 = abTestGroup;
        this.f0 = inlineFiltersPresenter;
        this.g0 = serpItemSaturator;
        this.h0 = serpTracker;
        this.i0 = itemVisibilityTracker;
        this.j0 = diffCalculator;
        this.k0 = savedSearchesPresenter;
        this.l0 = verticalFilterPresenter;
        this.m0 = skeletonGenerator;
        this.n0 = serpSkeletonTestGroup;
        this.o0 = preferences;
        this.p0 = asyncPhonePresenter;
        this.q0 = snippetScrollDepthTracker;
        this.r0 = snippetScrollDepthAnalyticsInteractor;
        this.s0 = serpPresenterState;
        this.t0 = savedLocationInteractor;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        this.h = (serpPresenterState == null || (arrayList = serpPresenterState.getItems()) == null) ? new ArrayList<>() : arrayList;
        this.i = serpPresenterState != null ? serpPresenterState.getHasMorePages() : true;
        this.j = serpPresenterState != null ? serpPresenterState.getSerpParameters() : null;
        this.k = (serpPresenterState == null || (createFirstPage = serpPresenterState.getPageParams()) == null) ? SerpPageParams.Companion.createFirstPage() : createFirstPage;
        this.l = serpPresenterState != null ? serpPresenterState.getSubscriptionId() : null;
        boolean z2 = false;
        this.m = serpPresenterState != null ? serpPresenterState.isSubscribed() : false;
        this.n = serpPresenterState != null ? serpPresenterState.getAuthRequestedFor() : null;
        this.o = serpPresenterState != null ? serpPresenterState.getSearchHint() : null;
        this.p = serpPresenterState != null ? serpPresenterState.getXHash() : null;
        this.q = serpPresenterState != null ? serpPresenterState.getCurrentPage() : null;
        this.r = serpPresenterState != null ? serpPresenterState.getHasFailureOnLoading() : false;
        this.t = serpPresenterState != null ? serpPresenterState.isRefreshed() : false;
        this.v = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
        this.w = serpPresenterState != null ? serpPresenterState.getCallInfo() : null;
        this.x = serpPresenterState != null ? serpPresenterState.getSearchSubscriptionsTapTargetWasShown() : z2;
        this.y = serpPresenterState != null ? serpPresenterState.getSubscriptionAction() : null;
        this.A = (serpPresenterState == null || (str2 = serpPresenterState.getSerpAppearanceUuid()) == null) ? "initial_appearance" : str2;
        appendingRetryItemPresenter.setRetryListener(this);
        List<String> showedShortcutBannerIds = serpPresenterState != null ? serpPresenterState.getShowedShortcutBannerIds() : null;
        if (showedShortcutBannerIds != null) {
            this.g = new ArrayList(showedShortcutBannerIds);
        }
        if (serpPresenterState == null || (serpDisplayType = serpPresenterState.getDisplayType()) == null) {
            SearchParams searchParams = serpArguments.getSearchParams();
            serpDisplayType = searchParams != null ? searchParams.getDisplayType() : null;
        }
        this.u = serpDisplayType;
        serpSpanProvider.setAppendingListener(this);
        if (serpPresenterState != null) {
            serpAnalyticsInteractor.restoreState(serpPresenterState.getAnalyticsState());
        }
        if (serpPresenterState != null) {
            snippetScrollDepthTracker.restoreState(serpPresenterState.getSnippetScrollDepthState());
        }
        if (this.j == null) {
            observable = serpInteractor.loadSerp(null, this.k, this.u, CollectionsKt__CollectionsKt.emptyList()).observeOn(schedulersFactory3.mainThread()).replay(1).autoConnect();
            Intrinsics.checkNotNullExpressionValue(observable, "interactor.loadSerp(\n   …           .autoConnect()");
        } else {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        }
        this.z = observable;
        Disposable subscribe = observable.subscribe(h.a, i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "serpObservable.subscribe…servable\", it)\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static Disposable A(SerpPresenterImpl serpPresenterImpl, Observable observable, String str, int i2) {
        int i3 = i2 & 2;
        Disposable subscribe = observable.subscribe(new a2.a.a.n2.u(serpPresenterImpl, null), new a2.a.a.n2.v(serpPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observable.subscribe({ l…rrorDraw(page)\n        })");
        return subscribe;
    }

    public static final void access$closeSnippetItem(SerpPresenterImpl serpPresenterImpl, int i2) {
        serpPresenterImpl.h.remove(i2);
        serpPresenterImpl.G();
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (serpPresenterView != null) {
            serpPresenterView.onRemoveItem(i2);
        }
    }

    public static final void access$fillSkeleton(SerpPresenterImpl serpPresenterImpl) {
        serpPresenterImpl.h.addAll(serpPresenterImpl.m0.generateSerpSkeleton(serpPresenterImpl.N.getColumnsCount(serpPresenterImpl.u)));
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (serpPresenterView != null) {
            ShortcutNavigationBar.DefaultImpls.setSkeleton$default(serpPresenterView, serpPresenterImpl.m0.generateSerpShortcutsSkeleton(), false, 2, null);
        }
        SerpPresenterView serpPresenterView2 = serpPresenterImpl.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.showShortcutsWithShift();
        }
        serpPresenterImpl.G();
        SerpPresenterView serpPresenterView3 = serpPresenterImpl.a;
        if (serpPresenterView3 != null) {
            serpPresenterView3.onDataChanged(serpPresenterImpl);
        }
    }

    public static final String access$getContext(SerpPresenterImpl serpPresenterImpl) {
        SerpParameters serpParameters = serpPresenterImpl.j;
        if (serpParameters != null) {
            return serpParameters.getContext();
        }
        return null;
    }

    public static final boolean access$loaderRequired(SerpPresenterImpl serpPresenterImpl) {
        return serpPresenterImpl.i;
    }

    public static final void access$onFatalErrorReceived(SerpPresenterImpl serpPresenterImpl, Throwable th) {
        Objects.requireNonNull(serpPresenterImpl);
        Logs.error("SerpPresenter", "onFatalErrorReceived", th);
        String format = serpPresenterImpl.H.format(th);
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (serpPresenterView != null) {
            serpPresenterView.showError(format);
        }
        SerpRouter serpRouter = serpPresenterImpl.c;
        if (serpRouter != null) {
            serpRouter.leaveScreen();
        }
    }

    public static final void access$onQuerySubmitted(SerpPresenterImpl serpPresenterImpl, String str) {
        SearchBar searchBar;
        serpPresenterImpl.J.sendSearchSubmit();
        serpPresenterImpl.e();
        SearchParams h2 = serpPresenterImpl.h();
        if (h2 != null) {
            if (t6.y.m.isBlank(str)) {
                str = "";
            }
            SerpParameters serpParameters = serpPresenterImpl.j;
            String context = serpParameters != null ? serpParameters.getContext() : null;
            SerpPresenterView serpPresenterView = serpPresenterImpl.a;
            if (!(serpPresenterView == null || (searchBar = serpPresenterView.getSearchBar()) == null)) {
                searchBar.showActionProgress();
            }
            serpPresenterImpl.e = serpPresenterImpl.n(str, h2, context, Boolean.FALSE);
        }
    }

    public static final void access$onSearchStateChanged(SerpPresenterImpl serpPresenterImpl, boolean z2) {
        serpPresenterImpl.e();
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (serpPresenterView != null) {
            serpPresenterView.setCartFabVisible(!z2);
        }
    }

    public static final void access$onSearchSubscriptionError(SerpPresenterImpl serpPresenterImpl, TypedError typedError) {
        SerpPresenterView serpPresenterView;
        Objects.requireNonNull(serpPresenterImpl);
        if (typedError instanceof TypedError.UnauthorizedError) {
            serpPresenterImpl.s();
        } else if (typedError instanceof TypedError.ErrorMap) {
            TypedError.ErrorMap errorMap = (TypedError.ErrorMap) typedError;
            if ((!errorMap.getMessages().isEmpty()) && (serpPresenterView = serpPresenterImpl.a) != null) {
                serpPresenterView.showError((String) ((Map.Entry) CollectionsKt___CollectionsKt.first(errorMap.getMessages().entrySet())).getValue());
            }
        } else {
            SerpPresenterView serpPresenterView2 = serpPresenterImpl.a;
            if (serpPresenterView2 != null) {
                serpPresenterView2.showError(serpPresenterImpl.N.getCommonErrorText());
            }
        }
    }

    public static final void access$onSerpPageLoaded(SerpPresenterImpl serpPresenterImpl, SerpPage serpPage, int i2, String str) {
        SerpPresenterView serpPresenterView;
        RetryView retryView;
        SerpPresenterView serpPresenterView2;
        Objects.requireNonNull(serpPresenterImpl);
        serpPresenterImpl.j = serpPage.getSerpParameters();
        serpPresenterImpl.r = false;
        serpPresenterImpl.s = false;
        serpPresenterImpl.q = Integer.valueOf(i2);
        if (i2 == 1) {
            serpPresenterImpl.l = serpPage.getSubscriptionId();
            serpPresenterImpl.m = serpPage.isSubscribed();
            String xHash = serpPage.getXHash();
            serpPresenterImpl.p = xHash;
            serpPresenterImpl.l0.setXHash(xHash);
        }
        serpPresenterImpl.o = serpPage.getSearchHint();
        ArrayList arrayList = new ArrayList(serpPresenterImpl.h);
        SerpDisplayType displayType = serpPage.getDisplayType();
        if (serpPresenterImpl.u != displayType) {
            serpPresenterImpl.u = displayType;
            serpPresenterImpl.F();
        }
        SerpDisplayType orDefault = SerpDisplayTypeKt.orDefault(serpPresenterImpl.u);
        t6.n.h.retainAll((List) serpPresenterImpl.h, (Function1) a2.a.a.n2.q.a);
        t6.n.h.retainAll((List) serpPresenterImpl.h, (Function1) a2.a.a.n2.r.a);
        if (serpPresenterImpl.k()) {
            serpPresenterImpl.h.clear();
        }
        List<ViewTypeSerpItem> elements = serpPage.getElements();
        int lastSortedIndex = serpPage.getLastSortedIndex();
        if (!elements.isEmpty()) {
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(serpPresenterImpl.h);
            int i3 = serpPresenterImpl.f;
            if (lastIndex >= i3) {
                while (true) {
                    serpPresenterImpl.h.remove(lastIndex);
                    if (lastIndex == i3) {
                        break;
                    }
                    lastIndex--;
                }
            }
            serpPresenterImpl.h.addAll(elements);
            serpPresenterImpl.f += lastSortedIndex;
        }
        serpPresenterImpl.l(serpPage.getElements(), orDefault);
        serpPresenterImpl.k = serpPage.getNextPageParams();
        serpPresenterImpl.i = serpPage.getHasMorePages();
        if (i2 == 1) {
            serpPresenterImpl.J.sendSerpLoad(serpPage.getSerpParameters().getSearchParams(), serpPage.getCount(), orDefault, str, serpPage.getXHash());
        }
        Map<String, String> firebaseParams = serpPage.getFirebaseParams();
        if (firebaseParams != null) {
            serpPresenterImpl.I.track(new ShowSerpScreenEvent(firebaseParams));
        }
        serpPresenterImpl.h0.trackAdvertsPrepare(i2);
        if (serpPage.getInlineFilters() != null) {
            serpPresenterImpl.f0.setInlineFilters(serpPage.getInlineFilters());
        }
        if (serpPresenterImpl.f0.getInlineFilters() != null) {
            serpPresenterImpl.y();
        } else {
            serpPresenterImpl.f0.loadInlineFilters(serpPage.getSerpParameters().getSearchParams());
        }
        if (serpPresenterImpl.i) {
            serpPresenterImpl.a(serpPresenterImpl.h);
        }
        int i4 = serpPresenterImpl.f;
        serpPresenterImpl.G();
        serpPresenterImpl.v();
        serpPresenterImpl.H();
        RetryView retryView2 = serpPresenterImpl.b;
        if (retryView2 != null) {
            retryView2.showContent();
        }
        SerpPresenterView serpPresenterView3 = serpPresenterImpl.a;
        if (serpPresenterView3 != null) {
            serpPresenterView3.setDisplayType(SerpDisplayTypeKt.orDefault(serpPresenterImpl.u));
        }
        int size = serpPresenterImpl.h.size();
        if (arrayList.isEmpty()) {
            SerpPresenterView serpPresenterView4 = serpPresenterImpl.a;
            if (serpPresenterView4 != null) {
                serpPresenterView4.onDataChanged(serpPresenterImpl);
            }
        } else {
            for (T t2 : serpPresenterImpl.j0.changes(arrayList.size(), size, i4)) {
                if (t2 instanceof ChangeDiff) {
                    SerpPresenterView serpPresenterView5 = serpPresenterImpl.a;
                    if (serpPresenterView5 != null) {
                        T t3 = t2;
                        serpPresenterView5.onDataRangeChanged(serpPresenterImpl, t3.getPosition(), t3.getCount());
                    }
                } else if (t2 instanceof AddDiff) {
                    SerpPresenterView serpPresenterView6 = serpPresenterImpl.a;
                    if (serpPresenterView6 != null) {
                        T t4 = t2;
                        serpPresenterView6.onDataAppended(serpPresenterImpl, t4.getPosition(), t4.getCount());
                    }
                } else if ((t2 instanceof RemoveDiff) && (serpPresenterView2 = serpPresenterImpl.a) != null) {
                    T t5 = t2;
                    serpPresenterView2.onRemoveItemRange(serpPresenterImpl, t5.getPosition(), t5.getCount());
                }
            }
        }
        if (serpPresenterImpl.D.isEmptySearch()) {
            SerpPresenterView serpPresenterView7 = serpPresenterImpl.a;
            if (serpPresenterView7 != null) {
                serpPresenterView7.hideEmptyView();
            }
            SerpPresenterView serpPresenterView8 = serpPresenterImpl.a;
            if (serpPresenterView8 != null) {
                serpPresenterView8.resetScrollingToTop();
            }
            serpPresenterImpl.x();
        } else if (!serpPresenterImpl.v.isEmpty()) {
            serpPresenterImpl.x();
        } else {
            serpPresenterImpl.w();
        }
        if (serpPresenterImpl.r && (retryView = serpPresenterImpl.b) != null) {
            retryView.showRetry();
        }
        serpPresenterImpl.t = false;
        if (serpPresenterImpl.j() && (serpPresenterView = serpPresenterImpl.a) != null) {
            serpPresenterView.enableScroll();
        }
        serpPresenterImpl.h0.trackAdvertsDraw(i2);
    }

    public static final void access$onSerpPageResultFailedToLoad(SerpPresenterImpl serpPresenterImpl, TypedError typedError, int i2) {
        SerpPresenterView serpPresenterView;
        SerpPresenterView serpPresenterView2;
        if (serpPresenterImpl.k()) {
            serpPresenterImpl.h.clear();
            serpPresenterImpl.G();
            SerpPresenterView serpPresenterView3 = serpPresenterImpl.a;
            if (serpPresenterView3 != null) {
                serpPresenterView3.onDataChanged(serpPresenterImpl);
            }
        }
        serpPresenterImpl.t = false;
        serpPresenterImpl.s = false;
        serpPresenterImpl.h0.trackAdvertsLoadError(i2);
        serpPresenterImpl.h0.trackAdvertsErrorPrepare(i2);
        serpPresenterImpl.r = true;
        if (i2 > 1) {
            List<ViewTypeSerpItem> list = serpPresenterImpl.h;
            t6.n.h.retainAll((List) list, (Function1) a2.a.a.n2.q.a);
            serpPresenterImpl.b(list);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            serpPresenterImpl.G();
            SerpPresenterView serpPresenterView4 = serpPresenterImpl.a;
            if (serpPresenterView4 != null) {
                serpPresenterView4.onItemChanged(lastIndex);
            }
        } else {
            if (serpPresenterImpl.j() && (serpPresenterView2 = serpPresenterImpl.a) != null) {
                serpPresenterView2.hideSkeleton();
            }
            RetryView retryView = serpPresenterImpl.b;
            if (retryView != null) {
                retryView.showRetry();
            }
            if (!(typedError instanceof ErrorWithMessage)) {
                typedError = null;
            }
            ErrorWithMessage errorWithMessage = (ErrorWithMessage) typedError;
            if (!(errorWithMessage == null || (serpPresenterView = serpPresenterImpl.a) == null)) {
                serpPresenterView.showError(errorWithMessage.getMessage());
            }
        }
        serpPresenterImpl.h0.trackAdvertsErrorDraw(i2);
    }

    public static final void access$openShortcut(SerpPresenterImpl serpPresenterImpl, ShortcutNavigationItem shortcutNavigationItem) {
        Objects.requireNonNull(serpPresenterImpl);
        if (shortcutNavigationItem instanceof ShortcutNavigationItemImpl) {
            DeepLink deepLink = shortcutNavigationItem.getDeepLink();
            if (deepLink == null) {
                deepLink = new NoMatchLink();
            }
            if (deepLink instanceof ItemsSearchLink) {
                ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
                if (!itemsSearchLink.getShowMap() && !itemsSearchLink.getShowSimpleMap()) {
                    SerpRouter serpRouter = serpPresenterImpl.c;
                    if (serpRouter != null) {
                        serpRouter.openSerpWithBackstack(itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), serpPresenterImpl.J.getParent(), itemsSearchLink.getShowJobNearbyBanner());
                    }
                    serpPresenterImpl.J.sendClickShortcut(shortcutNavigationItem.getText(), ShortcutNavigationItemKt.extractCategoryId(shortcutNavigationItem));
                }
            }
            SerpRouter serpRouter2 = serpPresenterImpl.c;
            if (serpRouter2 != null) {
                serpRouter2.followDeepLink(deepLink);
            }
            serpPresenterImpl.J.sendClickShortcut(shortcutNavigationItem.getText(), ShortcutNavigationItemKt.extractCategoryId(shortcutNavigationItem));
        } else if (shortcutNavigationItem instanceof ClarifyButtonItem) {
            SerpRouter serpRouter3 = serpPresenterImpl.c;
            if (serpRouter3 != null) {
                SearchParams h2 = serpPresenterImpl.h();
                if (h2 == null) {
                    h2 = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
                }
                serpRouter3.showClarifyScreen(h2);
            }
        } else if (shortcutNavigationItem instanceof InlineFilterNavigationItem) {
            InlineFiltersPresenter inlineFiltersPresenter = serpPresenterImpl.f0;
            InlineFilterNavigationItem inlineFilterNavigationItem = (InlineFilterNavigationItem) shortcutNavigationItem;
            SearchParams h3 = serpPresenterImpl.h();
            InlineFiltersPresenter.DefaultImpls.openInlineFilter$default(inlineFiltersPresenter, inlineFilterNavigationItem, h3 != null ? h3 : new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null), false, 4, null);
        }
    }

    public static final void access$restoreView(SerpPresenterImpl serpPresenterImpl) {
        if (serpPresenterImpl.f0.getInlineFilters() != null) {
            serpPresenterImpl.G.reset();
            serpPresenterImpl.y();
        } else {
            SerpPresenterView serpPresenterView = serpPresenterImpl.a;
            if (serpPresenterView != null) {
                serpPresenterView.hideShortcutsWithShift();
            }
        }
        serpPresenterImpl.h0.trackAdvertsPrepare(serpPresenterImpl.k.getPage());
        int count = serpPresenterImpl.G().getCount();
        serpPresenterImpl.v();
        serpPresenterImpl.H();
        RetryView retryView = serpPresenterImpl.b;
        if (retryView != null) {
            retryView.showContent();
        }
        SerpPresenterView serpPresenterView2 = serpPresenterImpl.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.onDataChanged(serpPresenterImpl);
        }
        boolean z2 = true;
        if (serpPresenterImpl.D.isEmptySearch()) {
            SerpPresenterView serpPresenterView3 = serpPresenterImpl.a;
            if (serpPresenterView3 != null) {
                serpPresenterView3.hideEmptyView();
            }
            if (!serpPresenterImpl.D.isEmptySearch() || count > 2) {
                z2 = false;
            }
            if (!z2) {
                SerpPresenterView serpPresenterView4 = serpPresenterImpl.a;
                if (serpPresenterView4 != null) {
                    serpPresenterView4.resetScrollingToTop();
                }
                serpPresenterImpl.x();
            }
        } else if (!serpPresenterImpl.v.isEmpty()) {
            serpPresenterImpl.x();
        } else {
            serpPresenterImpl.w();
        }
        serpPresenterImpl.t = false;
        serpPresenterImpl.h0.trackAdvertsDraw(serpPresenterImpl.k.getPage());
    }

    public static final void access$saveLocationForSearch(SerpPresenterImpl serpPresenterImpl, Location location) {
        SavedLocationInteractor.DefaultImpls.saveLocation$default(serpPresenterImpl.t0, location, LocationSource.LOCATION_FOR_SEARCH, false, 4, null);
    }

    public static final void access$searchByQuery(SerpPresenterImpl serpPresenterImpl, String str, SearchParams searchParams) {
        SearchBar searchBar;
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (!(serpPresenterView == null || (searchBar = serpPresenterView.getSearchBar()) == null)) {
            searchBar.close();
        }
        serpPresenterImpl.r(SearchParams.copy$default(searchParams, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388095, null), null, null);
    }

    public static final void access$setSubscriptionButtonFinalState(SerpPresenterImpl serpPresenterImpl) {
        if (serpPresenterImpl.m) {
            SerpPresenterView serpPresenterView = serpPresenterImpl.a;
            if (serpPresenterView != null) {
                serpPresenterView.setSubscriptionSwitchedOn();
                return;
            }
            return;
        }
        SerpPresenterView serpPresenterView2 = serpPresenterImpl.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.setSubscriptionSwitchedOff();
        }
    }

    public static final void access$updatePosition(SerpPresenterImpl serpPresenterImpl, int i2) {
        serpPresenterImpl.G();
        SerpPresenterView serpPresenterView = serpPresenterImpl.a;
        if (serpPresenterView != null) {
            serpPresenterView.onItemChanged(i2);
        }
    }

    public static /* synthetic */ void d(SerpPresenterImpl serpPresenterImpl, int i2, DeepLink deepLink, String str, String str2, String str3, Image image, Integer num, boolean z2, int i3) {
        int i4 = i3 & 64;
        serpPresenterImpl.c(deepLink, str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : image, null, z2);
    }

    public static void o(SerpPresenterImpl serpPresenterImpl, boolean z2, String str, int i2) {
        SerpPresenterView serpPresenterView;
        if ((i2 & 1) != 0) {
            z2 = true;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (z2) {
            serpPresenterImpl.m(str);
            return;
        }
        serpPresenterImpl.s = false;
        SerpDisplayType orDefault = SerpDisplayTypeKt.orDefault(serpPresenterImpl.u);
        SerpPresenterView serpPresenterView2 = serpPresenterImpl.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.setDisplayType(orDefault);
        }
        if (serpPresenterImpl.F.isEmpty() && (serpPresenterView = serpPresenterImpl.a) != null) {
            serpPresenterView.showProgress();
        }
        t6.n.h.retainAll((List) serpPresenterImpl.h, (Function1) a2.a.a.n2.q.a);
        t6.n.h.retainAll((List) serpPresenterImpl.h, (Function1) a2.a.a.n2.r.a);
        boolean k2 = serpPresenterImpl.k();
        if (k2) {
            SerpPresenterView serpPresenterView3 = serpPresenterImpl.a;
            if (serpPresenterView3 != null) {
                serpPresenterView3.showProgress();
            }
            serpPresenterImpl.h.clear();
        }
        CompositeDisposable compositeDisposable = serpPresenterImpl.d;
        Disposable subscribe = serpPresenterImpl.D.restoreSerp(orDefault, CollectionsKt___CollectionsKt.toList(serpPresenterImpl.h)).observeOn(serpPresenterImpl.M.mainThread()).subscribe(new a2.a.a.n2.s(serpPresenterImpl, k2, orDefault), new a2.a.a.n2.t(serpPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.restoreSerp(d…ceived(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static /* synthetic */ void u(SerpPresenterImpl serpPresenterImpl, DeepLink deepLink, String str, int i2) {
        int i3 = i2 & 2;
        serpPresenterImpl.t(deepLink, null);
    }

    public final void B() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.f0.inlineFilterSelected().observeOn(this.M.mainThread()).subscribe(new b(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "inlineFiltersPresenter\n …NE_FILTERS)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = this.f0.inlineFiltersLoaded().observeOn(this.M.mainThread()).subscribe(new t(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "inlineFiltersPresenter\n …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = this.f0.errors().observeOn(this.M.mainThread()).subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "inlineFiltersPresenter\n …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = this.l0.submitEvents().observeOn(this.M.mainThread()).subscribe(new b(1, this), g.b);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "verticalFilterPresenter\n….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.d;
        Disposable subscribe5 = this.l0.loadingErrors().observeOn(this.M.mainThread()).subscribe(new a(1, this), g.c);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "verticalFilterPresenter\n….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
    }

    public final void C() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.k0.subscribeAction().observeOn(this.M.mainThread()).subscribe(new w(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "savedSearchesPresenter\n …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = this.k0.requestAuthAction().observeOn(this.M.mainThread()).subscribe(new f(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "savedSearchesPresenter\n …scription()\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = this.k0.showSettingsAction().observeOn(this.M.mainThread()).subscribe(new f(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "savedSearchesPresenter\n …ngsScreen()\n            }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    public final void D() {
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = serpPresenterView.getSearchBar().submitCallbacks().observeOn(this.M.mainThread()).subscribe(new y(this), e.g);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view\n            .search…cks\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.d;
            Disposable subscribe2 = serpPresenterView.getSearchBar().openCallbacks().observeOn(this.M.mainThread()).subscribe(new z(this), e.h);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view\n            .search…cks\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.d;
            Disposable subscribe3 = serpPresenterView.getSearchBar().searchSuggestsCallbacks().observeOn(this.M.mainThread()).subscribe(new a0(this), e.i);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view\n            .search…cks\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.d;
            Disposable subscribe4 = serpPresenterView.shortcutClicks().observeOn(this.M.mainThread()).subscribe(new b0(this), e.j);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "view\n            .shortc…cks\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            CompositeDisposable compositeDisposable5 = this.d;
            Disposable subscribe5 = serpPresenterView.resetActionClicks().observeOn(this.M.mainThread()).subscribe(new c(1, this), e.b);
            Intrinsics.checkNotNullExpressionValue(subscribe5, "view\n            .resetA…cks\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            CompositeDisposable compositeDisposable6 = this.d;
            Disposable subscribe6 = this.b0.observeOn(this.M.mainThread()).subscribe(new d(0, this), e.c);
            Intrinsics.checkNotNullExpressionValue(subscribe6, "snippetClickObservable\n …ble\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            CompositeDisposable compositeDisposable7 = this.d;
            Disposable subscribe7 = this.c0.observeOn(this.M.mainThread()).subscribe(new d(1, this), e.d);
            Intrinsics.checkNotNullExpressionValue(subscribe7, "snippetCloseObservable\n …ble\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable7, subscribe7);
            CompositeDisposable compositeDisposable8 = this.d;
            Disposable subscribe8 = this.d0.observeOn(this.M.mainThread()).subscribe(new x(this), e.e);
            Intrinsics.checkNotNullExpressionValue(subscribe8, "snippetVisibilityObserva…ble\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable8, subscribe8);
            CompositeDisposable compositeDisposable9 = this.d;
            Disposable subscribe9 = serpPresenterView.tooltipDetailsLinkClicks().observeOn(this.M.mainThread()).subscribe(new c(0, this), e.f);
            Intrinsics.checkNotNullExpressionValue(subscribe9, "view\n            .toolti…etailsLinkClicks\", it) })");
            DisposableKt.plusAssign(compositeDisposable9, subscribe9);
        }
    }

    public final void E(boolean z2) {
        Integer num = this.q;
        String str = this.p;
        if (!(!this.q0.hasNewDataFromLastEventSent() || num == null || str == null)) {
            this.r0.sendUserScrolledToItemOnSerp(num.intValue(), this.q0.getAdvertItemsIds(), this.q0.getAdvertsItemCount(), str, this.q0.getTotalItemsCount());
            this.q0.onAnalyticsEventWasSent();
        }
        if (z2) {
            this.q0.resetValues();
        }
    }

    public final void F() {
        int columnsCount = this.N.getColumnsCount(this.u);
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            serpPresenterView.setColumnsCount(columnsCount);
        }
        this.O.setColumnsCount(columnsCount);
        this.P.setColumnsCount(columnsCount);
    }

    public final DataSource<ViewTypeSerpItem> G() {
        SerpDisplayType orDefault = SerpDisplayTypeKt.orDefault(this.u);
        ArrayList arrayList = new ArrayList(this.h);
        ListDataSource listDataSource = new ListDataSource(arrayList);
        SerpDataSource serpDataSource = new SerpDataSource(arrayList, this.g0, orDefault);
        q(listDataSource, serpDataSource);
        return serpDataSource;
    }

    public final void H() {
        Unit unit;
        String str = this.o;
        if (str != null) {
            SerpPresenterView serpPresenterView = this.a;
            if (serpPresenterView != null) {
                serpPresenterView.setSearchHint(str);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        SerpPresenterView serpPresenterView2 = this.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.setSearchHintSearch();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void I() {
        SearchBar searchBar;
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null && (searchBar = serpPresenterView.getSearchBar()) != null) {
            SearchParams h2 = h();
            String query = h2 == null ? this.Q : h2.getQuery();
            if (query == null) {
                query = "";
            }
            searchBar.setQuery(query);
        }
    }

    public final void a(List<ViewTypeSerpItem> list) {
        if (list.isEmpty() || ((!list.isEmpty()) && !(CollectionsKt___CollectionsKt.last((List<? extends Object>) list) instanceof AppendingLoaderItem))) {
            list.add(new AppendingLoaderItem(Long.MAX_VALUE, String.valueOf(Long.MAX_VALUE), this.O.getColumnsCount(), false, false, 24, null));
        }
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void attachRouter(@NotNull SerpRouter serpRouter) {
        Intrinsics.checkNotNullParameter(serpRouter, "router");
        this.c = serpRouter;
        DfpDebugPresenter dfpDebugPresenter = this.C;
        if (dfpDebugPresenter != null) {
            dfpDebugPresenter.attachRouter(serpRouter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    @Override // com.avito.android.serp.SerpPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachView(@org.jetbrains.annotations.NotNull com.avito.android.serp.SerpPresenterView r5, @org.jetbrains.annotations.NotNull com.avito.android.ui.view.retry.RetryView r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "retryView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r4.a = r5
            r4.b = r6
            r4.D()
            r4.B()
            r4.C()
            r4.v()
            r4.F()
            com.avito.android.connection_quality.ConnectionQualitySubscriber r6 = r4.R
            r6.subscribe()
            r5.showDefaultNavigationIcon()
            r4.I()
            r4.i()
            com.avito.android.serp.SerpParameters r5 = r4.j
            r6 = 2
            r0 = 0
            if (r5 != 0) goto L_0x0042
            com.avito.android.favorite.FavoriteAdvertsPresenter r5 = r4.S
            r5.wipeSynchronizedIds()
            io.reactivex.rxjava3.disposables.CompositeDisposable r5 = r4.d
            io.reactivex.rxjava3.core.Observable<com.avito.android.util.LoadingState<com.avito.android.serp.Serp>> r1 = r4.z
            io.reactivex.rxjava3.disposables.Disposable r6 = A(r4, r1, r0, r6)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r5, r6)
            goto L_0x007f
        L_0x0042:
            com.avito.konveyor.adapter.AdapterPresenter r5 = r4.F
            boolean r5 = r5.isEmpty()
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L_0x005b
            com.avito.android.serp.SerpInteractor r5 = r4.D
            int r5 = r5.getPage()
            if (r5 != 0) goto L_0x0056
            r5 = 1
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x005b
            r5 = 1
            goto L_0x005c
        L_0x005b:
            r5 = 0
        L_0x005c:
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0068
            com.avito.konveyor.adapter.AdapterPresenter r5 = r4.F
            com.avito.konveyor.data_source.DataSource r3 = com.avito.konveyor.util.DataSources.emptyDataSource()
            r5.onDataSourceChanged(r3)
        L_0x0068:
            java.util.List<com.avito.android.serp.adapter.ViewTypeSerpItem> r5 = r4.h
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x007c
            com.avito.android.serp.SerpPageParams$Companion r5 = com.avito.android.serp.SerpPageParams.Companion
            com.avito.android.serp.SerpPageParams r5 = r5.createFirstPage()
            r4.k = r5
            o(r4, r2, r0, r6)
            goto L_0x007f
        L_0x007c:
            o(r4, r1, r0, r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.SerpPresenterImpl.attachView(com.avito.android.serp.SerpPresenterView, com.avito.android.ui.view.retry.RetryView):void");
    }

    public final void b(List<ViewTypeSerpItem> list) {
        if ((!list.isEmpty()) && !(CollectionsKt___CollectionsKt.last((List<? extends Object>) list) instanceof AppendingRetryItem)) {
            list.add(new AppendingRetryItem((long) -1007190565, "retryItem", this.O.getColumnsCount(), false, false, 24, null));
        }
    }

    public final void c(DeepLink deepLink, String str, String str2, String str3, Image image, Integer num, boolean z2) {
        if (deepLink instanceof AdvertDetailsLink) {
            SerpRouter serpRouter = this.c;
            if (serpRouter != null) {
                AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                serpRouter.openAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), str, str2, str3, image, this.J.getParent(), num, z2);
                return;
            }
            return;
        }
        SerpRouter serpRouter2 = this.c;
        if (serpRouter2 != null) {
            serpRouter2.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.i;
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void detachRouter() {
        this.c = null;
        DfpDebugPresenter dfpDebugPresenter = this.C;
        if (dfpDebugPresenter != null) {
            dfpDebugPresenter.detachRouter();
        }
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void detachView() {
        this.R.unsubscribe();
        this.d.clear();
        f();
        e();
        this.h0.stop();
        this.a = null;
        this.b = null;
    }

    public final void e() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void f() {
        DataSource<ViewTypeSerpItem> dataSource = this.v;
        if (dataSource instanceof CloseableDataSource) {
            ((CloseableDataSource) dataSource).close();
        }
        this.v = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
    }

    public final void g(DeepLink deepLink) {
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
        SerpRouter serpRouter2 = this.c;
        if (serpRouter2 != null) {
            serpRouter2.leaveScreen();
        }
    }

    public final SearchParams h() {
        SerpParameters serpParameters = this.j;
        if (serpParameters != null) {
            return serpParameters.getSearchParams();
        }
        return null;
    }

    public final void i() {
        CallInfo callInfo = this.w;
        if (callInfo != null) {
            DeepLink callLink = callInfo.getCallLink();
            if (callLink instanceof PhoneLink) {
                PhoneLink phoneLink = (PhoneLink) callLink;
                String stringId = callInfo.getStringId();
                ContactSource contactSource = callInfo.getContactSource();
                if (this.e0.getTestGroup().isTest()) {
                    SerpRouter serpRouter = this.c;
                    if (serpRouter == null || !serpRouter.dialPhone(phoneLink)) {
                        this.I.track(new ShowPhoneDialerEvent(stringId, PhonePageSourceKt.PHONE_SOURCE_BUTTON, false, null, null, 24, null));
                        z(phoneLink, stringId, "error", contactSource);
                        return;
                    }
                    this.w = null;
                    this.I.track(new ShowPhoneDialerEvent(stringId, PhonePageSourceKt.PHONE_SOURCE_BUTTON, true, null, null, 24, null));
                    return;
                }
                z(phoneLink, stringId, PhonePageSourceKt.PHONE_SOURCE_BUTTON, contactSource);
            } else if (callLink instanceof CreateChannelLink) {
                CreateChannelLink createChannelLink = (CreateChannelLink) callLink;
                this.J.sendWriteToSellerClick(createChannelLink.getItemId(), callInfo.getContactSource(), createChannelLink.getContext());
                SerpRouter serpRouter2 = this.c;
                if (serpRouter2 != null) {
                    serpRouter2.followDeepLink(createChannelLink);
                }
            } else if (callLink instanceof AuthenticateLink) {
                this.n = 2;
                SerpRouter serpRouter3 = this.c;
                if (serpRouter3 != null) {
                    SerpRouter.DefaultImpls.showAuth$default(serpRouter3, AuthSource.OPEN_CHANNEL, null, 2, null);
                }
            }
        }
    }

    public final boolean j() {
        return this.n0.isTest();
    }

    public final boolean k() {
        return (this.h.isEmpty() ^ true) && (CollectionsKt___CollectionsKt.first(this.h) instanceof SkeletonItem);
    }

    public final void l(List<? extends ViewTypeSerpItem> list, SerpDisplayType serpDisplayType) {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.D.loadAds(list, serpDisplayType).subscribeOn(this.M.io()).observeOn(this.M.mainThread()).subscribe(new j(this), k.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadAds(newEl…ors.\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void m(String str) {
        SerpParameters serpParameters;
        if (!this.s && (serpParameters = this.j) != null) {
            this.s = true;
            List<ViewTypeSerpItem> list = this.h;
            List<? extends ViewTypeSerpItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt___CollectionsKt.takeLast(list, Math.max(list.size() - this.f, 0)));
            t6.n.h.retainAll((List) mutableList, (Function1) a2.a.a.n2.q.a);
            t6.n.h.retainAll((List) mutableList, (Function1) a2.a.a.n2.r.a);
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = a2.b.a.a.a.b2(this.M, this.D.loadSerp(serpParameters, this.k, this.u, mutableList), "interactor.loadSerp(\n   …(schedulers.mainThread())").subscribe(new a2.a.a.n2.u(this, str), new a2.a.a.n2.v(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "observable.subscribe({ l…rrorDraw(page)\n        })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final Disposable n(String str, SearchParams searchParams, String str2, Boolean bool) {
        return Observables.delayNotLess(this.D.loadSearchDeepLink(str, searchParams, str2, bool, false), 300, TimeUnit.MILLISECONDS, this.M.computation()).observeOn(this.M.mainThread()).subscribe(new l(this, str, searchParams), m.a);
    }

    @Override // com.avito.android.serp.adapter.AdBannerEventListener
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i2) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        SearchParams h2 = h();
        CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerOpened$default(this.K, bannerInfo, i2, h2 != null ? h2.getCategoryId() : null, h2 != null ? h2.getLocationId() : null, null, null, 48, null);
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        d(this, i2, advertItem.getDeepLink(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, null, advertItem.isMarketplace(), 64);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (!this.s && !this.r) {
            o(this, false, null, 3);
        }
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void onBackPressed() {
        String categoryId;
        SearchParams h2 = h();
        if (h2 != null && (categoryId = h2.getCategoryId()) != null) {
            this.J.sendBackClick(categoryId, false);
        }
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter.Router
    public void onBannerClicked(@NotNull PromoCardItem promoCardItem) {
        Intrinsics.checkNotNullParameter(promoCardItem, "item");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(promoCardItem.getAction());
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener
    public void onCallActionClicked(@NotNull AdvertXlItem advertXlItem, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        p(advertXlItem.getStringId(), deepLink, ContactSource.CONTACT_XL);
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void onClarifyClicked() {
        SerpRouter serpRouter;
        SearchParams h2 = h();
        if (h2 != null && (serpRouter = this.c) != null) {
            serpRouter.showClarifyScreen(h2);
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onDeepLinkActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.S.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemListener
    public void onFollowDeeplinkFromEmpty(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
        SerpRouter serpRouter2 = this.c;
        if (serpRouter2 != null) {
            serpRouter2.leaveScreen();
        }
    }

    @Override // com.avito.android.serp.adapter.OnCloseItemListener
    public void onItemClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.V.markAsClosed(str);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        SerpPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void onRefresh() {
        this.d.clear();
        D();
        B();
        C();
        this.h.clear();
        this.f = 0;
        this.k = SerpPageParams.Companion.createFirstPage();
        this.D.invalidate();
        this.X.invalidate();
        this.Y.invalidate();
        this.l0.invalidate();
        this.S.wipeSynchronizedIds();
        this.u = null;
        this.t = true;
        E(true);
        o(this, false, null, 3);
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void onResume() {
        this.J.sendSerpShownEvent(this.A);
        this.K.returnToScreen();
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        c(advertItem.getDeepLink(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, num, advertItem.isMarketplace());
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onRichAdvertXlClicked(@NotNull AdvertXlItem advertXlItem, int i2, @Nullable Image image, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        c(advertXlItem.getDeepLink(), advertXlItem.getTitle(), advertXlItem.getPrice(), advertXlItem.getPreviousPrice(), image, num, advertXlItem.isMarketplace());
    }

    @Override // com.avito.android.serp.SerpPresenter
    @NotNull
    public SerpPresenterState onSaveState() {
        List<ViewTypeSerpItem> list = this.h;
        boolean z2 = this.i;
        boolean z3 = this.r;
        SerpParameters serpParameters = this.j;
        SerpPageParams serpPageParams = this.k;
        String str = this.l;
        boolean z4 = this.t;
        return new SerpPresenterState(list, z2, z3, serpParameters, serpPageParams, str, this.m, z4, this.n, this.o, this.p, this.q, this.u, this.g, this.w, this.x, this.J.saveState(), this.y, this.A, false, this.q0.onSaveState(), 524288, null);
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void onSearchClarified(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        t(deepLink, null);
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemListener
    public void onSearchOnMapClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void onSearchSubscriptionToggled() {
        this.I.track(new SearchSubscriptionsClickEvent());
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            serpPresenterView.setSubscriptionSwitchedLoading();
        }
        SearchParams h2 = h();
        if (h2 != null) {
            this.E.getSearchSubscriptionControlDeeplink(this.l, h2).subscribeOn(this.M.io()).observeOn(this.M.mainThread()).subscribe(new o(this));
        }
    }

    @Override // com.avito.android.serp.adapter.SellerItemListener
    public void onSellerItemClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.serp.adapter.warning.SerpWarningItemListener
    public void onSerpWarningAction(@NotNull Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        g(action.getDeepLink());
    }

    @Override // com.avito.android.serp.adapter.warning.SerpWarningItemListener
    public void onSerpWarningClosed(@NotNull SerpWarningItem serpWarningItem, int i2) {
        Intrinsics.checkNotNullParameter(serpWarningItem, "warning");
        if (Intrinsics.areEqual(this.h.get(i2), serpWarningItem)) {
            this.h.remove(i2);
            G();
            SerpPresenterView serpPresenterView = this.a;
            if (serpPresenterView != null) {
                serpPresenterView.onRemoveItem(i2);
            }
            this.D.closeWarning(serpWarningItem);
        }
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemClicked(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
        this.I.track(new ShortcutBannerClickEvent(shortcutBannerItem.getStringId()));
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.followDeepLink(shortcutBannerItem.getDeepLink());
        }
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemShowed(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
        List list = this.g;
        if (list == null) {
            list = new ArrayList();
            this.g = list;
        }
        if (!list.contains(shortcutBannerItem.getStringId())) {
            list.add(shortcutBannerItem.getStringId());
            this.I.track(new ShortcutBannerShowEvent(shortcutBannerItem.getStringId()));
        }
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void onStop() {
        E(false);
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void onUpPressed() {
        String categoryId;
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.closeSearch();
        }
        SearchParams h2 = h();
        if (h2 != null && (categoryId = h2.getCategoryId()) != null) {
            this.J.sendBackClick(categoryId, true);
        }
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void onUserAuthorized(boolean z2, @Nullable Parcelable parcelable) {
        AsyncPhoneRequestData asyncPhoneRequestData;
        ContactSource contactSource;
        AsyncPhoneRequestData asyncPhoneRequestData2;
        AsyncPhoneItem item;
        SerpItem serpItem = null;
        if (!(parcelable instanceof AsyncPhoneRequestData)) {
            parcelable = null;
        }
        AsyncPhoneRequestData asyncPhoneRequestData3 = (AsyncPhoneRequestData) parcelable;
        this.B = asyncPhoneRequestData3;
        Integer num = this.n;
        if (num == null) {
            if (asyncPhoneRequestData3 != null) {
                num = 3;
            } else {
                return;
            }
        }
        this.n = null;
        if (!z2) {
            return;
        }
        if (num != null && num.intValue() == 0) {
            onSearchSubscriptionToggled();
        } else if (num != null && num.intValue() == 2) {
            onRefresh();
        } else if (num != null && num.intValue() == 3 && (asyncPhoneRequestData = this.B) != null && (contactSource = asyncPhoneRequestData.getContactSource()) != null && (asyncPhoneRequestData2 = this.B) != null && (item = asyncPhoneRequestData2.getItem()) != null) {
            if (item instanceof SerpItem) {
                serpItem = item;
            }
            SerpItem serpItem2 = serpItem;
            if (serpItem2 != null) {
                Integer itemPosition = DataSources.itemPosition(this.v, item.getStringId());
                DeepLink targetLink = AdvertRichItemPresenterKt.getTargetLink(serpItem2);
                if (targetLink == null) {
                    return;
                }
                if (targetLink instanceof PhoneRequestLink) {
                    this.p0.loadPhoneLink(item, null, targetLink, contactSource, new a2.a.a.n2.p(this, item, contactSource));
                    if (itemPosition != null) {
                        int intValue = itemPosition.intValue();
                        SerpPresenterView serpPresenterView = this.a;
                        if (serpPresenterView != null) {
                            serpPresenterView.onItemChanged(intValue);
                            return;
                        }
                        return;
                    }
                    return;
                }
                SerpRouter serpRouter = this.c;
                if (serpRouter != null) {
                    serpRouter.followDeepLink(targetLink);
                }
            }
        }
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler.Listener
    public void onVisibleItemChanged(int i2) {
        this.q0.onUserScrollToNewItem(i2);
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemListener
    public void onWitcherSearchButtonClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            if (!itemsSearchLink.getShowMap() && !itemsSearchLink.getShowSimpleMap()) {
                SerpRouter serpRouter = this.c;
                if (serpRouter != null) {
                    SerpRouter.DefaultImpls.openSerpWithBackstack$default(serpRouter, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), this.J.getParent(), false, 8, null);
                    return;
                }
                return;
            }
        }
        SerpRouter serpRouter2 = this.c;
        if (serpRouter2 != null) {
            serpRouter2.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onWriteActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        p(str, deepLink, contactSource);
    }

    public final void p(String str, DeepLink deepLink, ContactSource contactSource) {
        if (deepLink instanceof ClickStreamLink) {
            this.a0.handleDeepLink((ClickStreamLink) deepLink, new n(this, str, contactSource));
        } else if (deepLink instanceof PhoneLink) {
            this.w = new CallInfo(str, deepLink, contactSource);
            i();
        } else if (deepLink instanceof CreateChannelLink) {
            CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
            this.J.sendWriteToSellerClick(createChannelLink.getItemId(), contactSource, createChannelLink.getContext());
            SerpRouter serpRouter = this.c;
            if (serpRouter != null) {
                serpRouter.followDeepLink(createChannelLink);
            }
        } else if (deepLink instanceof AuthenticateLink) {
            this.n = 2;
            SerpRouter serpRouter2 = this.c;
            if (serpRouter2 != null) {
                SerpRouter.DefaultImpls.showAuth$default(serpRouter2, AuthSource.OPEN_CHANNEL, null, 2, null);
            }
        } else {
            SerpRouter serpRouter3 = this.c;
            if (serpRouter3 != null) {
                serpRouter3.followDeepLink(deepLink);
            }
        }
    }

    public final void q(DataSource<SpannedItem> dataSource, DataSource<ViewTypeSerpItem> dataSource2) {
        this.O.onDataSourceChanged(dataSource);
        this.F.onDataSourceChanged(dataSource2);
        this.P.onDataSourceChanged(dataSource);
        this.S.onDataSourceChanged(dataSource2);
        this.T.onDataSourceChanged(dataSource2);
        this.U.onDataSourceChanged(dataSource2);
        this.q0.onDataSourceChanged(dataSource2);
        if (this.W.getViewVisibilityTrackingInSerp().invoke().booleanValue()) {
            this.i0.onDataSourceChanged(dataSource2);
        }
        f();
        this.v = dataSource2;
    }

    public final void r(SearchParams searchParams, String str, String str2) {
        SerpParameters serpParameters;
        this.A = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
        SearchParams h2 = h();
        if (!Intrinsics.areEqual(h2 != null ? h2.getLocationId() : null, searchParams.getLocationId())) {
            this.o = null;
            H();
        }
        SerpParameters serpParameters2 = this.j;
        this.d.clear();
        D();
        B();
        C();
        this.s = false;
        this.i = true;
        this.j = null;
        this.o = null;
        this.m = false;
        this.l = null;
        this.r = false;
        this.h.clear();
        this.u = null;
        this.f = 0;
        this.k = SerpPageParams.Companion.createFirstPage();
        this.D.invalidate();
        this.f0.invalidate();
        f();
        this.S.wipeSynchronizedIds();
        this.f0.invalidate();
        q(new ListDataSource(CollectionsKt__CollectionsKt.emptyList()), new ListDataSource(CollectionsKt__CollectionsKt.emptyList()));
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            serpPresenterView.onDataChanged(this);
        }
        v();
        this.G.reset();
        this.u = searchParams.getDisplayType();
        F();
        if (serpParameters2 == null || (serpParameters = serpParameters2.copy(searchParams, str)) == null) {
            serpParameters = new SerpParameters(searchParams, str);
        }
        this.j = serpParameters;
        I();
        SerpPresenterView serpPresenterView2 = this.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.setDisplayType(SerpDisplayTypeKt.orDefault(this.u));
        }
        o(this, false, str2, 1);
    }

    @Override // com.avito.android.home.appending_item.retry.RetryItemsLoadingListener
    public void retryItemsLoading() {
        if (!this.s) {
            if (this.j == null) {
                Observable<LoadingState<Serp>> observeOn = this.D.loadSerp(null, this.k, this.u, CollectionsKt__CollectionsKt.emptyList()).observeOn(this.M.mainThread());
                Intrinsics.checkNotNullExpressionValue(observeOn, "interactor.loadSerp(\n   …(schedulers.mainThread())");
                A(this, observeOn, null, 2);
                return;
            }
            o(this, false, null, 3);
        }
    }

    @Override // com.avito.android.serp.SerpViewPresenter
    public void retryLoading() {
        if (k() || !j()) {
            SerpPresenterView serpPresenterView = this.a;
            if (serpPresenterView != null) {
                serpPresenterView.showProgress();
            }
        } else {
            RetryView retryView = this.b;
            if (retryView != null) {
                retryView.showContent();
            }
        }
        retryItemsLoading();
    }

    public final void s() {
        this.n = 0;
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            SerpRouter.DefaultImpls.showAuth$default(serpRouter, "s", null, 2, null);
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "src");
        SerpPresenter.DefaultImpls.showAuth(this, str);
    }

    @Override // com.avito.android.serp.SerpPresenter
    public void subscribeToLocationChanges() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = SavedLocationInteractor.DefaultImpls.savedLocation$default(this.t0, null, false, 3, null).observeOn(this.M.mainThread()).subscribe(new u(this), v.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "locationInteractor.saved…ion\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void t(DeepLink deepLink, String str) {
        SearchBar searchBar;
        SerpPresenterState serpPresenterState = this.s0;
        if (serpPresenterState != null) {
            serpPresenterState.setLoadDeepLinkForBackNavigation(false);
        }
        SerpPresenterView serpPresenterView = this.a;
        if (!(serpPresenterView == null || (searchBar = serpPresenterView.getSearchBar()) == null)) {
            searchBar.close();
        }
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            if (itemsSearchLink.getShowMap() || itemsSearchLink.getShowSimpleMap()) {
                SerpRouter serpRouter = this.c;
                if (serpRouter != null) {
                    serpRouter.followDeepLink(deepLink);
                }
                SerpRouter serpRouter2 = this.c;
                if (serpRouter2 != null) {
                    serpRouter2.leaveScreen();
                    return;
                }
                return;
            }
            r(itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), str);
            return;
        }
        SerpRouter serpRouter3 = this.c;
        if (serpRouter3 != null) {
            serpRouter3.followDeepLink(deepLink);
        }
    }

    public final void v() {
        if (this.m) {
            SerpPresenterView serpPresenterView = this.a;
            if (serpPresenterView != null) {
                serpPresenterView.setSubscriptionSwitchedOn();
                return;
            }
            return;
        }
        SerpPresenterView serpPresenterView2 = this.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.setSubscriptionSwitchedOff();
        }
    }

    public final void w() {
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            serpPresenterView.hideShortcutsWithShift();
        }
        if (this.m) {
            SerpPresenterView serpPresenterView2 = this.a;
            if (serpPresenterView2 != null) {
                serpPresenterView2.showSavedSearchEmptyView();
                return;
            }
            return;
        }
        SerpPresenterView serpPresenterView3 = this.a;
        if (serpPresenterView3 != null) {
            serpPresenterView3.showNewSearchEmptyView();
        }
    }

    public final void x() {
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            serpPresenterView.hideEmptyView();
        }
        boolean z2 = true;
        if (this.D.getPage() != 1) {
            z2 = false;
        }
        if (z2 && this.t) {
            this.G.reset();
            SerpPresenterView serpPresenterView2 = this.a;
            if (serpPresenterView2 != null) {
                serpPresenterView2.resetScrollingToTop();
            }
        }
    }

    public final void y() {
        SearchBar searchBar;
        Result result;
        Header header;
        Integer selectedFiltersCount;
        this.f0.showInlineFilters();
        if (!this.o0.contains("savedSearchesTooltipShowed")) {
            InlineFilters inlineFilters = this.f0.getInlineFilters();
            if (((inlineFilters == null || (result = inlineFilters.getResult()) == null || (header = result.getHeader()) == null || (selectedFiltersCount = header.getSelectedFiltersCount()) == null) ? 0 : selectedFiltersCount.intValue()) > 0) {
                SerpPresenterView serpPresenterView = this.a;
                if (!(serpPresenterView == null || (searchBar = serpPresenterView.getSearchBar()) == null)) {
                    searchBar.showSavedSearchesTooltipIfNeeded();
                }
                this.o0.putBoolean("savedSearchesTooltipShowed", true);
            }
        }
        SerpPresenterView serpPresenterView2 = this.a;
        if (serpPresenterView2 != null) {
            serpPresenterView2.showShortcutsWithShift();
        }
    }

    public final void z(PhoneLink phoneLink, String str, String str2, ContactSource contactSource) {
        Boolean bool = null;
        PhoneLink.Call call = (PhoneLink.Call) (!(phoneLink instanceof PhoneLink.Call) ? null : phoneLink);
        String context = call != null ? call.getContext() : null;
        this.J.sendCallToSellerClick(str, context, contactSource);
        SearchParams h2 = h();
        if (Intrinsics.areEqual(h2 != null ? h2.getCategoryId() : null, "111")) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.L.createChat(str, AvitoMessengerApiKt.CHAT_CREATE_SOURCE_SERP_ADVERT_XL).observeOn(this.M.mainThread()).subscribe(p.a, q.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "advertMessengerInteracto…      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        SerpPresenterView serpPresenterView = this.a;
        if (serpPresenterView != null) {
            bool = Boolean.valueOf(serpPresenterView.showCallDialog(this.Z.format(phoneLink.getPhone()), new r(this, str, context, phoneLink, str2), new s(this)));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            this.I.track(new ShowPhoneDialogEvent(str, str2));
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener
    public void onCallActionClicked(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        p(str, deepLink, contactSource);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull String str, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.n = 3;
        AsyncPhoneRequestData asyncPhoneRequestData = new AsyncPhoneRequestData(asyncPhoneItem, contactSource);
        SerpRouter serpRouter = this.c;
        if (serpRouter != null) {
            serpRouter.showAuth(str, asyncPhoneRequestData);
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener
    public void onAdvertClicked(@NotNull AdvertXlItem advertXlItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertXlItem, "advert");
        d(this, i2, advertXlItem.getDeepLink(), advertXlItem.getTitle(), advertXlItem.getPrice(), advertXlItem.getPreviousPrice(), image, null, advertXlItem.isMarketplace(), 64);
    }
}
