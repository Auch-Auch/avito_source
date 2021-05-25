package com.avito.android.home;

import a2.a.a.a1.a0;
import a2.a.a.a1.b0;
import a2.a.a.a1.n;
import a2.a.a.a1.o;
import a2.a.a.a1.p;
import a2.a.a.a1.q;
import a2.a.a.a1.r;
import a2.a.a.a1.s;
import a2.a.a.a1.t;
import a2.a.a.a1.u;
import a2.a.a.a1.v;
import a2.a.a.a1.w;
import a2.a.a.a1.y;
import a2.a.a.a1.z;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.advert.actions.HiddenAdvertItemPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.MainScreenLink;
import com.avito.android.deep_linking.links.ShopsLink;
import com.avito.android.di.module.LocationNotificationClick;
import com.avito.android.di.module.LocationNotificationVisibility;
import com.avito.android.di.module.SnippetClick;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.geo.GeoStorage;
import com.avito.android.home.DataChangesHolder;
import com.avito.android.home.HomeInteractor;
import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.home.State;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider;
import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.preferences.UpdateStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertItemActions;
import com.avito.android.remote.model.HomeTabItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ItemAction;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.Story;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.location_notification.LocationNotificationActionData;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItem;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.skeleton.SkeletonItem;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.stories.StoriesItem;
import com.avito.android.ui.view.retry.RetryView;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.android.util.rx3.Singles;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0003\b\u0007\u0012\b\u0010Ì\u0001\u001a\u00030Ê\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010û\u0001\u001a\u00030ù\u0001\u0012\b\u0010ÿ\u0001\u001a\u00030þ\u0001\u0012\b\u0010º\u0001\u001a\u00030¸\u0001\u0012\b\u0010ì\u0001\u001a\u00030ê\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010·\u0001\u001a\u00030´\u0001\u0012\b\u0010Û\u0001\u001a\u00030Ù\u0001\u0012\b\u0010Ñ\u0001\u001a\u00030Ï\u0001\u0012\b\u0010Þ\u0001\u001a\u00030Ü\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¬\u0001\u001a\u00030©\u0001\u0012\u0006\u0010~\u001a\u00020{\u0012\b\u0010Â\u0001\u001a\u00030¿\u0001\u0012\b\u0010ô\u0001\u001a\u00030ñ\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\u001e\b\u0001\u0010Ô\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030Ã\u0001\u0012\u0004\u0012\u00020\u00160Ò\u00010\u0001\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0011\b\u0001\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\b\u0010¾\u0001\u001a\u00030»\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\u0006\u0010v\u001a\u00020s\u0012\b\u0010Ø\u0001\u001a\u00030Õ\u0001\u0012\b\u0010æ\u0001\u001a\u00030ã\u0001\u0012\b\u0010ø\u0001\u001a\u00030õ\u0001\u0012\b\u0010ð\u0001\u001a\u00030í\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010²\u0001\u001a\u00030¯\u0001\u0012\u0006\u0010z\u001a\u00020w\u0012\b\u0010É\u0001\u001a\u00030Æ\u0001\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010/¢\u0006\u0006\b\u0002\u0010\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ)\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020+H\u0016¢\u0006\u0004\b3\u0010.J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010\u000fJ\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010\u000fJ\u000f\u00106\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u0010\u000fJ\u0017\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;2\u0006\u0010!\u001a\u00020\u0016H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020+H\u0016¢\u0006\u0004\b@\u0010.J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bA\u0010)J\u0017\u0010B\u001a\u00020\u00072\u0006\u0010?\u001a\u00020+H\u0016¢\u0006\u0004\bB\u0010.J\u001f\u0010D\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u0010C\u001a\u00020+H\u0016¢\u0006\u0004\bD\u0010EJ\u0018\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0001¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bJ\u0010\u000fJ\u000f\u0010K\u001a\u00020\u0007H\u0002¢\u0006\u0004\bK\u0010\u000fJ\u0019\u0010M\u001a\u00020\u001b2\b\b\u0002\u0010L\u001a\u000207H\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0007H\u0002¢\u0006\u0004\bO\u0010\u000fJ\u000f\u0010P\u001a\u00020\u0007H\u0002¢\u0006\u0004\bP\u0010\u000fJ\u000f\u0010Q\u001a\u00020\u0007H\u0002¢\u0006\u0004\bQ\u0010\u000fJ\u000f\u0010R\u001a\u00020\u0007H\u0002¢\u0006\u0004\bR\u0010\u000fJ%\u0010W\u001a\u00020\u00072\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S2\u0006\u0010V\u001a\u000207H\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u00072\u0006\u0010L\u001a\u000207H\u0002¢\u0006\u0004\bY\u0010:J#\u0010\\\u001a\u00020\u00072\b\b\u0002\u0010[\u001a\u00020Z2\b\b\u0002\u0010V\u001a\u000207H\u0002¢\u0006\u0004\b\\\u0010]J\u0017\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020^H\u0002¢\u0006\u0004\b`\u0010aJ\u0019\u0010c\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bc\u0010.J\u000f\u0010d\u001a\u00020\u0007H\u0002¢\u0006\u0004\bd\u0010\u000fJ\u000f\u0010e\u001a\u00020\u0007H\u0002¢\u0006\u0004\be\u0010\u000fJ\u000f\u0010f\u001a\u00020\u0007H\u0002¢\u0006\u0004\bf\u0010\u000fJ\u0017\u0010h\u001a\u00020\u00072\u0006\u0010g\u001a\u00020+H\u0002¢\u0006\u0004\bh\u0010.J5\u0010m\u001a\u00020\u00072\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i2\u0016\b\u0002\u0010l\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i\u0018\u00010SH\u0002¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\u001bH\u0002¢\u0006\u0004\bo\u0010\u001dJ\u0019\u0010q\u001a\u00020\u00072\b\b\u0002\u0010p\u001a\u00020\u001bH\u0002¢\u0006\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010\u0001\u001a\u000208\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bM\u0010\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bq\u0010\u0001R!\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bo\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bh\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\\\u0010\u0001R \u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bJ\u0010 \u0001R\u001a\u0010¥\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010¨\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\be\u0010§\u0001R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R!\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bK\u0010³\u0001R\u001a\u0010·\u0001\u001a\u00030´\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0019\u0010º\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bf\u0010¹\u0001R\u001a\u0010¾\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010Â\u0001\u001a\u00030¿\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Å\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bW\u0010Ä\u0001R\u001a\u0010É\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010Ì\u0001\u001a\u00030Ê\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bm\u0010Ë\u0001R\u0018\u0010Î\u0001\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bQ\u0010Í\u0001R\u0019\u0010Ñ\u0001\u001a\u00030Ï\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bc\u0010Ð\u0001R.\u0010Ô\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030Ã\u0001\u0012\u0004\u0012\u00020\u00160Ò\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010\u0001R\u001a\u0010Ø\u0001\u001a\u00030Õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Û\u0001\u001a\u00030Ù\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bd\u0010Ú\u0001R\u0019\u0010Þ\u0001\u001a\u00030Ü\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b`\u0010Ý\u0001R\u0018\u0010à\u0001\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bP\u0010ß\u0001R\u0019\u0010â\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bá\u0001\u0010\u0001R\u001a\u0010æ\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u0019\u0010è\u0001\u001a\u00020+8B@\u0002X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010ç\u0001R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bR\u0010é\u0001R\u0019\u0010ì\u0001\u001a\u00030ê\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bO\u0010ë\u0001R\u001a\u0010ð\u0001\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001a\u0010ô\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u0019\u0010û\u0001\u001a\u00030ù\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bY\u0010ú\u0001R\u0019\u0010ý\u0001\u001a\u00020\u00168B@\u0002X\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010ü\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/home/HomePresenterImpl;", "Lcom/avito/android/home/HomePresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/home/HomeView;", "view", "Lcom/avito/android/ui/view/retry/RetryView;", "retryView", "", "attachView", "(Lcom/avito/android/home/HomeView;Lcom/avito/android/ui/view/retry/RetryView;)V", "Lcom/avito/android/home/HomePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/home/HomePresenter$Router;)V", "onResume", "()V", "onStop", "onPause", "detachView", "detachRouter", "retryLoading", "retryItemsLoading", "", "mostDepthVisibleItemPosition", "onVisibleItemChanged", "(I)V", "onAppend", "", "canAppend", "()Z", "onClarifyClicked", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onSearchClarified", "", "storyId", "updateCurrentStoryId", "(Ljava/lang/String;)V", "Lcom/avito/android/home/HomePresenterState;", "onSaveState", "()Lcom/avito/android/home/HomePresenterState;", "message", "onActionResultReceived", "onRefresh", "onResetPageState", "showAllCategories", "Lcom/avito/android/remote/model/HomeTabItem;", "selectedTab", "onTabSelectionChanged", "(Lcom/avito/android/remote/model/HomeTabItem;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "onAdBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "itemId", "onItemClose", "onWitcherSearchButtonClicked", "onMoreActionsClicked", "url", "onStoryClicked", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "l", AuthSource.BOOKING_ORDER, "tab", "f", "(Lcom/avito/android/remote/model/HomeTabItem;)Z", VKApiConst.Q, "j", "k", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", MessengerShareContentUtility.ELEMENTS, "targetTab", "i", "(Ljava/util/List;Lcom/avito/android/remote/model/HomeTabItem;)V", "o", "Lcom/avito/android/home/DataChangesHolder;", "changesHolder", "s", "(Lcom/avito/android/home/DataChangesHolder;Lcom/avito/android/remote/model/HomeTabItem;)V", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "w", "(Lcom/avito/android/remote/model/Shortcuts;)V", "searchHint", VKApiConst.VERSION, "u", "e", "p", "error", "n", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "secondaryDataSources", AuthSource.OPEN_CHANNEL_LIST, "(Lcom/avito/konveyor/data_source/DataSource;Ljava/util/List;)V", "h", "withRefreshTracker", "r", "(Z)V", "Lcom/avito/android/IdProvider;", "H", "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "O", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "homeSkeletonTestGroup", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "itemsSubscriptions", "c", "Lcom/avito/android/home/HomePresenter$Router;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "y", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "snippetScrollDepthAnalyticsInteractor", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationActionData;", ExifInterface.LONGITUDE_EAST, "Lcom/jakewharton/rxrelay3/Relay;", "locationNotificationClickObservable", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "x", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "shortcutNavigationConverter", "Lcom/avito/android/geo/GeoStorage;", "M", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "Ljava/lang/Boolean;", "changeHomePageLocation", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "Lcom/avito/konveyor/data_source/DataSource;", "savedDataSource", "Lcom/avito/android/home/State;", a2.g.r.g.a, "Lcom/avito/android/home/State;", "state", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "searchSubscription", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "z", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "connectionQualitySubscriber", "F", "locationNotificationVisibilityObservable", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "N", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "skeletonGenerator", "Lcom/avito/android/ui/view/retry/RetryView;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "t", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialBannersAnalyticsInteractor", "Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/Features;", "G", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;", "B", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;", "defaultSearchLocationPermissionProvider", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "warningItem", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "P", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "homeNewRubricatorTestGroup", "Lcom/avito/android/home/HomeInteractor;", "Lcom/avito/android/home/HomeInteractor;", "interactor", "Ljava/lang/String;", "mainAppearanceUuid", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "resourcesProvider", "Lkotlin/Pair;", "D", "snippetClickObservable", "Lcom/avito/android/home/analytics/HomeTracker;", "I", "Lcom/avito/android/home/analytics/HomeTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Z", "isWentToSerp", "d", "subscriptions", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "J", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "()Ljava/lang/String;", "locality", "Lcom/avito/android/home/HomeView;", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "homeAnalyticsInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "L", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "C", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "K", "Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "hiddenAdvertItemPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "serpAdapterPresenter", "()I", "page", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;", "appendingRetryItemPresenter", "Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;", "sectionTabsItemPresenter", "Lcom/avito/android/preferences/UpdateStorage;", "updateStorage", "initState", "<init>", "(Lcom/avito/android/home/HomeInteractor;Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/home/HomePresenterResourcesProvider;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/Features;Lcom/avito/android/preferences/UpdateStorage;Lcom/avito/android/IdProvider;Lcom/avito/android/home/analytics/HomeTracker;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lcom/avito/android/geo/GeoStorage;Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;Lcom/avito/android/home/HomePresenterState;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomePresenterImpl implements HomePresenter, FavoriteButtonClickListener {
    public final FavoriteAdvertsPresenter A;
    public final DefaultSearchLocationPermissionProvider B;
    public final ViewedAdvertsPresenter C;
    public final Relay<Pair<SnippetItem, Integer>> D;
    public final Relay<LocationNotificationActionData> E;
    public final Relay<LocationNotificationActionData> F;
    public final Features G;
    public final IdProvider H;
    public final HomeTracker I;
    public final ItemVisibilityTracker J;
    public final HiddenAdvertItemPresenter K;
    public final LocationAnalyticsInteractor L;
    public final GeoStorage M;
    public final SkeletonGenerator N;
    public final HomeSkeletonTestGroup O;
    public final HomeNewRubricatorTestGroup P;
    public HomeView a;
    public RetryView b;
    public HomePresenter.Router c;
    public final CompositeDisposable d = new CompositeDisposable();
    public Disposable e;
    public CompositeDisposable f = new CompositeDisposable();
    public State g = State.Companion.createNewState$default(State.Companion, null, 1, null);
    public Boolean h;
    public SnippetItem i;
    public boolean j;
    public String k;
    public DataSource<SpannedItem> l;
    public final HomeInteractor m;
    public final PersistableFloatingViewsPresenter n;
    public final AdapterPresenter o;
    public final ErrorFormatter p;
    public final HomeAnalyticsInteractor q;
    public final SnippetScrollDepthAnalyticsInteractor r;
    public final SnippetScrollDepthTracker s;
    public final CommercialBannersAnalyticsInteractor t;
    public final SchedulersFactory3 u;
    public final HomePresenterResourcesProvider v;
    public final SerpSpanProvider w;
    public final ShortcutNavigationItemConverter x;
    public final SpannedGridPositionProvider y;
    public final ConnectionQualitySubscriber z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            LoadState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
            HomeNewRubricatorTestGroup.values();
            int[] iArr2 = new int[6];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[4] = 2;
            iArr2[5] = 3;
            iArr2[3] = 4;
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super HomePageResult>> {
        public final /* synthetic */ HomePresenterImpl a;
        public final /* synthetic */ HomeTabItem b;

        public a(HomePresenterImpl homePresenterImpl, HomeTabItem homeTabItem) {
            this.a = homePresenterImpl;
            this.b = homeTabItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super HomePageResult> loadingState) {
            LoadingState<? super HomePageResult> loadingState2 = loadingState;
            HomePresenterImpl homePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            HomePresenterImpl.access$onHomePageAppendingElementsStateChanged(homePresenterImpl, loadingState2, this.b);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ HomePresenterImpl a;

        public b(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("HomePresenter", "appendHomePageAdverts", th);
            this.a.I.stop();
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ HomePresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HomePresenterImpl homePresenterImpl) {
            super(1);
            this.a = homePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                this.a.p();
            } else {
                HomePresenterImpl.access$restoreData(this.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<ViewTypeSerpItem> {
        public final /* synthetic */ HomePresenterImpl a;
        public final /* synthetic */ HomeTabItem b;

        public d(HomePresenterImpl homePresenterImpl, HomeTabItem homeTabItem) {
            this.a = homePresenterImpl;
            this.b = homeTabItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            List<ViewTypeSerpItem> elements = this.a.g.get(this.b).getElements();
            int size = elements.size();
            for (int i = 0; i < size; i++) {
                ViewTypeSerpItem viewTypeSerpItem3 = elements.get(i);
                if (viewTypeSerpItem3.getId() == viewTypeSerpItem2.getId() && (viewTypeSerpItem3 instanceof SerpCommercialBanner) && ((SerpCommercialBanner) viewTypeSerpItem3).getHasNotLoadedAd()) {
                    Intrinsics.checkNotNullExpressionValue(viewTypeSerpItem2, "ad");
                    elements.set(i, viewTypeSerpItem2);
                    if (Intrinsics.areEqual(this.a.g.getCurrentTab(), this.b)) {
                        this.a.s(new DataChangesHolder.Changed(i, 0, null, 6, null), this.b);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("HomePresenter", "Ads load errors.", th);
        }
    }

    public static final class f<T> implements Consumer<Location> {
        public final /* synthetic */ HomePresenterImpl a;

        public f(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            Location location2 = location;
            HomePresenterImpl homePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(location2, "location");
            HomePresenterImpl.access$locationLoaded(homePresenterImpl, location2);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ HomePresenterImpl a;

        public g(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            CompositeDisposable compositeDisposable = this.a.d;
            Disposable subscribe = Singles.toSingle(OptionKt.toOption(th)).observeOn(this.a.u.mainThread()).subscribe(new a2.a.a.a1.j(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "it.toOption().toSingle()…nError(option.orNull()) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final class h<T> implements Consumer<SnippetItem> {
        public final /* synthetic */ HomePresenterImpl a;

        public h(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SnippetItem snippetItem) {
            SnippetItem snippetItem2 = snippetItem;
            HomePresenterImpl homePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(snippetItem2, "warning");
            HomePresenterImpl.access$onWarningLoaded(homePresenterImpl, snippetItem2);
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class j<T> implements Consumer<Shortcuts> {
        public final /* synthetic */ HomePresenterImpl a;

        public j(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Shortcuts shortcuts) {
            Shortcuts shortcuts2 = shortcuts;
            this.a.I.trackShortcutsLoaded();
            List<Action> list = shortcuts2.getList();
            if (list == null || !(!list.isEmpty())) {
                HomeView homeView = this.a.a;
                if (homeView != null) {
                    homeView.hideShortcutsBlock();
                }
                this.a.I.stopShortcutsLoad();
                return;
            }
            HomePresenterImpl homePresenterImpl = this.a;
            State state = homePresenterImpl.g;
            Intrinsics.checkNotNullExpressionValue(shortcuts2, "it");
            homePresenterImpl.g = state.loadShortcuts(shortcuts2);
            this.a.w(shortcuts2);
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ HomePresenterImpl a;

        public k(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            HomeView homeView = this.a.a;
            if (homeView != null) {
                homeView.hideShortcutsBlock();
            }
            this.a.I.trackShortcutsLoadError();
            Logs.error("HomePresenter", "Error loadMainShortcuts", th2);
        }
    }

    public static final class l<T> implements Consumer<LoadingState<? super StoriesItem>> {
        public final /* synthetic */ HomePresenterImpl a;

        public l(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super StoriesItem> loadingState) {
            DataChangesHolder dataChangesHolder;
            LoadingState<? super StoriesItem> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                HomePresenterImpl homePresenterImpl = this.a;
                homePresenterImpl.g = homePresenterImpl.g.loadingStories();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                boolean storiesLoaded = this.a.g.storiesLoaded();
                HomePresenterImpl homePresenterImpl2 = this.a;
                homePresenterImpl2.g = homePresenterImpl2.g.loadStories((StoriesItem) ((LoadingState.Loaded) loadingState2).getData());
                if (storiesLoaded) {
                    dataChangesHolder = new DataChangesHolder.Changed(0, 0, this.a.g.getStories(), 3, null);
                } else {
                    dataChangesHolder = new DataChangesHolder.Invalidated();
                }
                HomePresenterImpl.t(this.a, dataChangesHolder, null, 2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                HomePresenterImpl.access$onLoadErrorStories(this.a);
                Logs.error$default("HomePresenter: loadStories", ((LoadingState.Error) loadingState2).getError().toString(), null, 4, null);
            }
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public final /* synthetic */ HomePresenterImpl a;

        public m(HomePresenterImpl homePresenterImpl) {
            this.a = homePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            HomePresenterImpl.access$onLoadErrorStories(this.a);
            Logs.error("HomePresenter", "Error loadStories", th);
        }
    }

    @Inject
    public HomePresenterImpl(@NotNull HomeInteractor homeInteractor, @NotNull PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull AppendingRetryItemPresenter appendingRetryItemPresenter, @NotNull ErrorFormatter errorFormatter, @NotNull HomeAnalyticsInteractor homeAnalyticsInteractor, @NotNull SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor, @NotNull SnippetScrollDepthTracker snippetScrollDepthTracker, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull HomePresenterResourcesProvider homePresenterResourcesProvider, @NotNull SerpSpanProvider serpSpanProvider, @NotNull ShortcutNavigationItemConverter shortcutNavigationItemConverter, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull ConnectionQualitySubscriber connectionQualitySubscriber, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull DefaultSearchLocationPermissionProvider defaultSearchLocationPermissionProvider, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull SectionTabsItemPresenter sectionTabsItemPresenter, @SnippetClick @NotNull Relay<Pair<SnippetItem, Integer>> relay, @LocationNotificationClick @NotNull Relay<LocationNotificationActionData> relay2, @LocationNotificationVisibility @NotNull Relay<LocationNotificationActionData> relay3, @NotNull Features features, @NotNull UpdateStorage updateStorage, @NotNull IdProvider idProvider, @NotNull HomeTracker homeTracker, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull HiddenAdvertItemPresenter hiddenAdvertItemPresenter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @NotNull GeoStorage geoStorage, @NotNull SkeletonGenerator skeletonGenerator, @NotNull HomeSkeletonTestGroup homeSkeletonTestGroup, @NotNull HomeNewRubricatorTestGroup homeNewRubricatorTestGroup, @Nullable HomePresenterState homePresenterState) {
        String str;
        Intrinsics.checkNotNullParameter(homeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(persistableFloatingViewsPresenter, "floatingViewsPresenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "serpAdapterPresenter");
        Intrinsics.checkNotNullParameter(appendingRetryItemPresenter, "appendingRetryItemPresenter");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(homeAnalyticsInteractor, "homeAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(snippetScrollDepthAnalyticsInteractor, "snippetScrollDepthAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker, "snippetScrollDepthTracker");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialBannersAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(homePresenterResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "serpSpanProvider");
        Intrinsics.checkNotNullParameter(shortcutNavigationItemConverter, "shortcutNavigationConverter");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(connectionQualitySubscriber, "connectionQualitySubscriber");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(defaultSearchLocationPermissionProvider, "defaultSearchLocationPermissionProvider");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(sectionTabsItemPresenter, "sectionTabsItemPresenter");
        Intrinsics.checkNotNullParameter(relay, "snippetClickObservable");
        Intrinsics.checkNotNullParameter(relay2, "locationNotificationClickObservable");
        Intrinsics.checkNotNullParameter(relay3, "locationNotificationVisibilityObservable");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(updateStorage, "updateStorage");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(homeTracker, "tracker");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(hiddenAdvertItemPresenter, "hiddenAdvertItemPresenter");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        Intrinsics.checkNotNullParameter(skeletonGenerator, "skeletonGenerator");
        Intrinsics.checkNotNullParameter(homeSkeletonTestGroup, "homeSkeletonTestGroup");
        Intrinsics.checkNotNullParameter(homeNewRubricatorTestGroup, "homeNewRubricatorTestGroup");
        this.m = homeInteractor;
        this.n = persistableFloatingViewsPresenter;
        this.o = adapterPresenter;
        this.p = errorFormatter;
        this.q = homeAnalyticsInteractor;
        this.r = snippetScrollDepthAnalyticsInteractor;
        this.s = snippetScrollDepthTracker;
        this.t = commercialBannersAnalyticsInteractor;
        this.u = schedulersFactory3;
        this.v = homePresenterResourcesProvider;
        this.w = serpSpanProvider;
        this.x = shortcutNavigationItemConverter;
        this.y = spannedGridPositionProvider;
        this.z = connectionQualitySubscriber;
        this.A = favoriteAdvertsPresenter;
        this.B = defaultSearchLocationPermissionProvider;
        this.C = viewedAdvertsPresenter;
        this.D = relay;
        this.E = relay2;
        this.F = relay3;
        this.G = features;
        this.H = idProvider;
        this.I = homeTracker;
        this.J = itemVisibilityTracker;
        this.K = hiddenAdvertItemPresenter;
        this.L = locationAnalyticsInteractor;
        this.M = geoStorage;
        this.N = skeletonGenerator;
        this.O = homeSkeletonTestGroup;
        this.P = homeNewRubricatorTestGroup;
        this.k = (homePresenterState == null || (str = homePresenterState.getMainAppearanceUuid()) == null) ? "initial_appearance" : str;
        if (homePresenterState != null) {
            this.g = homePresenterState.getState();
            idProvider.restore(homePresenterState.getIdProviderState());
            homeAnalyticsInteractor.restoreState(homePresenterState.getAnalyticsState());
            snippetScrollDepthTracker.restoreState(homePresenterState.getSnippetScrollDepthState());
        }
        serpSpanProvider.setAppendingListener(this);
        updateStorage.setRunUi();
        appendingRetryItemPresenter.setRetryListener(this);
        sectionTabsItemPresenter.setSectionTabsPresenter(this);
    }

    public static final void access$loadLocationError(HomePresenterImpl homePresenterImpl, Throwable th) {
        homePresenterImpl.g = homePresenterImpl.g.loadLocationError();
        homePresenterImpl.I.trackLocationLoadError();
        homePresenterImpl.n(homePresenterImpl.p.format(th));
        Logs.error("HomePresenter", "loadLocationError", th);
    }

    public static final void access$locationLoaded(HomePresenterImpl homePresenterImpl, Location location) {
        homePresenterImpl.I.trackLocationLoaded();
        homePresenterImpl.g = homePresenterImpl.g.loadLocation(location).locationForcedByUserUpdated(location.getForcedByUser());
        homePresenterImpl.k();
        homePresenterImpl.l();
        HomeTabItem currentTab = homePresenterImpl.g.getCurrentTab();
        State loadingElements = homePresenterImpl.g.loadingElements(currentTab);
        homePresenterImpl.g = loadingElements;
        CompositeDisposable compositeDisposable = homePresenterImpl.f;
        HomeInteractor homeInteractor = homePresenterImpl.m;
        int offset = loadingElements.getOffset();
        int page = homePresenterImpl.g.getPage() + 1;
        int columnsCount = homePresenterImpl.w.getColumnsCount();
        String feedId = currentTab.getFeedId();
        if (feedId.length() == 0) {
            feedId = null;
        }
        Disposable subscribe = HomeInteractor.DefaultImpls.loadAdverts$default(homeInteractor, location, offset, page, columnsCount, feedId, homePresenterImpl.g.getCurrentTab().getHideSeenBadges(), null, 64, null).observeOn(homePresenterImpl.u.mainThread()).doOnNext(new j3(0, homePresenterImpl, location)).subscribe(new j3(1, homePresenterImpl, currentTab), new a2.a.a.a1.i(homePresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadAdverts(\n…erts\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = homePresenterImpl.d;
        Disposable subscribe2 = homePresenterImpl.B.permissionStream().subscribeOn(homePresenterImpl.u.mainThread()).observeOn(homePresenterImpl.u.mainThread()).subscribe(new o(homePresenterImpl), p.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "defaultSearchLocationPer…tion\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public static final void access$onFatalErrorPrepareAdverts(HomePresenterImpl homePresenterImpl, String str) {
        homePresenterImpl.I.trackAdvertsErrorPrepare(homePresenterImpl.d());
        homePresenterImpl.n(str);
        homePresenterImpl.I.trackAdvertsErrorDraw(homePresenterImpl.d());
    }

    public static final void access$onHomePageAppendingElementsStateChanged(HomePresenterImpl homePresenterImpl, LoadingState loadingState, HomeTabItem homeTabItem) {
        DataChangesHolder dataChangesHolder;
        HomeTabItem homeTabItem2 = homeTabItem;
        Objects.requireNonNull(homePresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            homePresenterImpl.g = homePresenterImpl.g.loadingElements(homeTabItem2);
            if (homePresenterImpl.O.isTest()) {
                if (homePresenterImpl.g.get(homeTabItem2).getElements().isEmpty()) {
                    homePresenterImpl.g.get(homeTabItem2).getElements().addAll(homePresenterImpl.N.generateSerpSkeleton(homePresenterImpl.v.getColumnsCount()));
                    t(homePresenterImpl, null, null, 3);
                    HomeView homeView = homePresenterImpl.a;
                    if (homeView != null) {
                        homeView.showShortcutsBlock();
                    }
                    HomeView homeView2 = homePresenterImpl.a;
                    if (homeView2 != null) {
                        homeView2.setSkeleton(homePresenterImpl.N.generateHomeShortcutsSkeleton(), false);
                    }
                    homePresenterImpl.q();
                }
            } else if (homePresenterImpl.o.isEmpty()) {
                homePresenterImpl.q();
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            HomePageResult homePageResult = (HomePageResult) ((LoadingState.Loaded) loadingState).getData();
            List<HomeTabItem> tabs = homePageResult.getTabs();
            if (tabs != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator<T> it = tabs.iterator();
                while (it.hasNext()) {
                    linkedHashMap.put(it.next(), TabState.Companion.createNewState());
                }
                if (!tabs.contains(homeTabItem2)) {
                    homeTabItem2 = tabs.get(0);
                }
                homePresenterImpl.g = homePresenterImpl.g.tabsUpdated(linkedHashMap, homeTabItem2);
            }
            if (homePresenterImpl.f(homeTabItem2)) {
                homePresenterImpl.g.get(homeTabItem2).getElements().clear();
            }
            State appendElements = homePresenterImpl.g.appendElements(homeTabItem2, homePageResult.getElements(), homePageResult.getDisplayType());
            homePresenterImpl.g = appendElements;
            List<ViewTypeSerpItem> elements = appendElements.get(homeTabItem2).getElements();
            if (homePresenterImpl.g.getPage() == 1) {
                Location location = homePageResult.getLocation();
                if (location != null) {
                    Location location2 = homePresenterImpl.g.getLocation();
                    if (!Intrinsics.areEqual(location2 != null ? location2.getId() : null, location.getId())) {
                        homePresenterImpl.g = homePresenterImpl.g.locationUpdated(location.getId());
                        homePresenterImpl.m.updateStoredLocationId(location);
                    }
                }
                homePresenterImpl.g = State.copy$default(homePresenterImpl.g, null, null, null, null, null, null, null, null, null, homePageResult.getXHash(), null, null, 3583, null);
                android.location.Location location3 = homePresenterImpl.M.getLocation();
                if (location3 != null) {
                    LocationAnalyticsInteractor locationAnalyticsInteractor = homePresenterImpl.L;
                    Location location4 = homePresenterImpl.g.getLocation();
                    locationAnalyticsInteractor.trackHomeRequestWithUserCoordinates(location3, location4 != null ? location4.getId() : null, null, null);
                }
            }
            homePresenterImpl.i(homePageResult.getElements(), homeTabItem2);
            if (homePresenterImpl.d() == 1 || g(homePresenterImpl, null, 1)) {
                dataChangesHolder = new DataChangesHolder.Invalidated();
            } else {
                dataChangesHolder = new DataChangesHolder.Inserted(0, homePageResult.getElements().size(), elements, 1, null);
            }
            homePresenterImpl.I.trackAdvertsPrepare(homePresenterImpl.d());
            HomeView homeView3 = homePresenterImpl.a;
            if (homeView3 != null) {
                homeView3.enableScroll();
            }
            homePresenterImpl.s(dataChangesHolder, homeTabItem2);
            homePresenterImpl.v(homePresenterImpl.g.getSearchHint());
        } else if (loadingState instanceof LoadingState.Error) {
            HomeView homeView4 = homePresenterImpl.a;
            if (homeView4 != null) {
                homeView4.hideSkeleton();
            }
            if (homePresenterImpl.f(homeTabItem2)) {
                homePresenterImpl.g.get(homeTabItem2).getElements().clear();
            }
            homePresenterImpl.g = homePresenterImpl.g.loadElementsError(homeTabItem2);
            homePresenterImpl.I.trackAdvertsLoadError(homePresenterImpl.d());
            t(homePresenterImpl, null, homeTabItem2, 1);
        }
    }

    public static final void access$onLoadErrorStories(HomePresenterImpl homePresenterImpl) {
        boolean storiesLoaded = homePresenterImpl.g.storiesLoaded();
        homePresenterImpl.g = homePresenterImpl.g.loadErrorStories();
        if (storiesLoaded) {
            t(homePresenterImpl, new DataChangesHolder.Invalidated(), null, 2);
        }
    }

    public static final void access$onLocationNotificationRemoved(HomePresenterImpl homePresenterImpl, LocationNotificationActionData locationNotificationActionData) {
        T t2;
        Objects.requireNonNull(homePresenterImpl);
        int position = locationNotificationActionData.getPosition();
        HomeTabItem currentTab = homePresenterImpl.g.getCurrentTab();
        Iterator<T> it = homePresenterImpl.g.getElements().iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof LocationNotificationItem) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null) {
            homePresenterImpl.g.getElements().remove(t3);
            homePresenterImpl.s(new DataChangesHolder.Removed(position, 0, null, 6, null), currentTab);
        }
    }

    public static final void access$onNotificationDefaultLocationChanged(HomePresenterImpl homePresenterImpl, Option option) {
        DataChangesHolder dataChangesHolder;
        boolean z2 = homePresenterImpl.h != null;
        Boolean bool = (Boolean) OptionKt.getOrElse(option, a2.a.a.a1.k.a);
        homePresenterImpl.h = bool;
        if (bool != null && bool.booleanValue()) {
            if (!z2) {
                dataChangesHolder = new DataChangesHolder.Invalidated();
            } else if (z2) {
                dataChangesHolder = new DataChangesHolder.Removed(0, 0, null, 7, null);
            } else {
                return;
            }
            t(homePresenterImpl, dataChangesHolder, null, 2);
        }
    }

    public static final void access$onQuerySubmitted(HomePresenterImpl homePresenterImpl, String str) {
        homePresenterImpl.q.sendSearchSubmit();
        homePresenterImpl.b();
        SearchParams searchParams = homePresenterImpl.g.getSearchParams();
        if (searchParams != null) {
            if (t6.y.m.isBlank(str)) {
                str = "";
            }
            HomeView homeView = homePresenterImpl.a;
            if (homeView != null) {
                homeView.showActionProgress();
            }
            homePresenterImpl.e = Observables.delayNotLess(homePresenterImpl.m.loadSearchDeepLink(str, searchParams, null, Boolean.FALSE, false), 300, TimeUnit.MILLISECONDS, homePresenterImpl.u.computation()).observeOn(homePresenterImpl.u.mainThread()).subscribe(new a2.a.a.a1.l(homePresenterImpl, str, searchParams));
        }
    }

    public static final void access$onSearchStateChanged(HomePresenterImpl homePresenterImpl, boolean z2) {
        homePresenterImpl.b();
        HomeView homeView = homePresenterImpl.a;
        if (homeView != null) {
            homeView.setCartFabVisible(!z2);
        }
    }

    public static final void access$onWarningLoaded(HomePresenterImpl homePresenterImpl, SnippetItem snippetItem) {
        DataChangesHolder dataChangesHolder;
        boolean z2 = homePresenterImpl.i != null;
        homePresenterImpl.i = snippetItem;
        if (snippetItem != null && !z2) {
            dataChangesHolder = new DataChangesHolder.Invalidated();
        } else if (z2) {
            dataChangesHolder = new DataChangesHolder.Removed(0, 0, null, 7, null);
        } else {
            return;
        }
        t(homePresenterImpl, dataChangesHolder, null, 2);
    }

    public static final void access$openShortcut(HomePresenterImpl homePresenterImpl, ShortcutNavigationItem shortcutNavigationItem) {
        SearchParams searchParams;
        Objects.requireNonNull(homePresenterImpl);
        DeepLink deepLink = shortcutNavigationItem.getDeepLink();
        if (deepLink == null) {
            return;
        }
        if (deepLink instanceof MainScreenLink) {
            homePresenterImpl.showAllCategories();
            return;
        }
        DeepLink deepLink2 = shortcutNavigationItem.getDeepLink();
        Boolean bool = null;
        if (!(deepLink2 instanceof ItemsSearchLink)) {
            deepLink2 = null;
        }
        ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink2;
        if (!(itemsSearchLink == null || (searchParams = itemsSearchLink.getSearchParams()) == null)) {
            Location location = homePresenterImpl.g.getLocation();
            if (location != null) {
                bool = location.getForcedLocationForRecommendation();
            }
            searchParams.setForcedLocationForRecommendation(bool);
        }
        homePresenterImpl.g.ignoreForcedLocationForRecommendation();
        HomePresenter.Router router = homePresenterImpl.c;
        if (router != null) {
            router.followDeepLink(deepLink, homePresenterImpl.q.getParent());
        }
        homePresenterImpl.q.sendClickShortcut(shortcutNavigationItem.getText(), ShortcutNavigationItemKt.extractCategoryId(shortcutNavigationItem));
        if (deepLink instanceof ShopsLink) {
            homePresenterImpl.q.sendClickShopShortcut();
        }
    }

    public static final void access$restoreData(HomePresenterImpl homePresenterImpl) {
        if (homePresenterImpl.g.hasTabs() || (homePresenterImpl.g.getElementsState() == LoadState.LOAD && homePresenterImpl.g.getPage() >= 1)) {
            for (T t2 : homePresenterImpl.g.getTabStates().entrySet()) {
                List<ViewTypeSerpItem> elements = ((TabState) t2.getValue()).getElements();
                homePresenterImpl.m.resolveItems(elements, ((HomeTabItem) t2.getKey()).getHideSeenBadges());
                homePresenterImpl.i(elements, (HomeTabItem) t2.getKey());
            }
            t(homePresenterImpl, null, null, 3);
            if (homePresenterImpl.g.hasTabs() && homePresenterImpl.g.getElementsState() != LoadState.LOAD && homePresenterImpl.d() == 1 && homePresenterImpl.g.getHasMorePages()) {
                homePresenterImpl.a();
            }
            HomeView homeView = homePresenterImpl.a;
            if (homeView != null) {
                homeView.enableScroll();
            }
        } else {
            homePresenterImpl.e();
        }
        String searchHint = homePresenterImpl.g.getSearchHint();
        if (searchHint != null) {
            homePresenterImpl.v(searchHint);
        }
        Shortcuts shortcuts = homePresenterImpl.g.getShortcuts();
        if (shortcuts != null) {
            homePresenterImpl.w(shortcuts);
            return;
        }
        HomeView homeView2 = homePresenterImpl.a;
        if (homeView2 != null) {
            homeView2.hideShortcutsBlock();
        }
        homePresenterImpl.k();
    }

    public static final void access$searchByDeeplink(HomePresenterImpl homePresenterImpl, DeepLink deepLink) {
        HomePresenter.Router router = homePresenterImpl.c;
        if (router != null) {
            router.followDeepLink(deepLink, homePresenterImpl.q.getParent());
            homePresenterImpl.j = true;
        }
    }

    public static final void access$searchByQuery(HomePresenterImpl homePresenterImpl, String str, SearchParams searchParams) {
        HomeView homeView = homePresenterImpl.a;
        if (homeView != null) {
            homeView.close();
        }
        SearchParams copy$default = SearchParams.copy$default(searchParams, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388095, null);
        HomePresenter.Router router = homePresenterImpl.c;
        if (router != null) {
            router.showSearchScreen(copy$default, homePresenterImpl.q.getParent());
            homePresenterImpl.j = true;
        }
    }

    public static /* synthetic */ boolean g(HomePresenterImpl homePresenterImpl, HomeTabItem homeTabItem, int i2) {
        return homePresenterImpl.f((i2 & 1) != 0 ? homePresenterImpl.g.getCurrentTab() : null);
    }

    public static /* synthetic */ void t(HomePresenterImpl homePresenterImpl, DataChangesHolder dataChangesHolder, HomeTabItem homeTabItem, int i2) {
        if ((i2 & 1) != 0) {
            dataChangesHolder = new DataChangesHolder.Invalidated();
        }
        if ((i2 & 2) != 0) {
            homeTabItem = homePresenterImpl.g.getCurrentTab();
        }
        homePresenterImpl.s(dataChangesHolder, homeTabItem);
    }

    public final void a() {
        Location location = this.g.getLocation();
        if (location != null) {
            HomeTabItem currentTab = this.g.getCurrentTab();
            Shortcuts shortcuts = this.g.getShortcuts();
            List<Action> list = shortcuts != null ? shortcuts.getList() : null;
            boolean z2 = false;
            if (list == null || list.isEmpty()) {
                k();
            }
            if (this.g.getOffset() != 0) {
                location.setForcedByUser(false);
            } else {
                Boolean locationForcedByUser = this.g.getLocationForcedByUser();
                location.setForcedByUser(locationForcedByUser != null ? locationForcedByUser.booleanValue() : false);
            }
            State loadingElements = this.g.loadingElements(currentTab);
            this.g = loadingElements;
            CompositeDisposable compositeDisposable = this.f;
            HomeInteractor homeInteractor = this.m;
            int offset = loadingElements.getOffset();
            int page = this.g.getPage() + 1;
            int columnsCount = this.w.getColumnsCount();
            String feedId = currentTab.getFeedId();
            if (feedId.length() == 0) {
                z2 = true;
            }
            Disposable subscribe = homeInteractor.loadAdverts(location, offset, page, columnsCount, z2 ? null : feedId, this.g.getCurrentTab().getHideSeenBadges(), this.g.getCurrentTabState().getRefreshElements() ^ true ? this.g.getCurrentTabState().getDisplayType() : null).observeOn(this.u.mainThread()).subscribe(new a(this, currentTab), new b(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…ker.stop()\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void attachRouter(@NotNull HomePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.m.startupBanner().subscribe(new a2.a.a.a1.m(this), n.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.startupBanner…nner\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.home.HomePresenter
    public void attachView(@NotNull HomeView homeView, @NotNull RetryView retryView) {
        Intrinsics.checkNotNullParameter(homeView, "view");
        Intrinsics.checkNotNullParameter(retryView, "retryView");
        this.a = homeView;
        this.b = retryView;
        if (homeView != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = homeView.submitCallbacks().observeOn(this.u.mainThread()).subscribe(new w(this), z3.d);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.submitCallbacks()\n … submitCallbacks\", it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.d;
            Disposable subscribe2 = homeView.openCallbacks().observeOn(this.u.mainThread()).subscribe(new b0(new Function1<Boolean, Unit>(this) { // from class: a2.a.a.a1.x
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Boolean bool) {
                    HomePresenterImpl.access$onSearchStateChanged((HomePresenterImpl) this.receiver, bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }), z3.e);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view\n            .openCa…ror openCallbacks\", it) }");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.d;
            Disposable subscribe3 = homeView.searchSuggestsCallbacks().observeOn(this.u.mainThread()).subscribe(new y(this), z3.f);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view\n            .search…uggestsCallbacks\", it) })");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.d;
            Disposable subscribe4 = homeView.shortcutClicks().observeOn(this.u.mainThread()).subscribe(new z(this), z3.g);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "view\n            .shortc…r shortcutClicks\", it) })");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            CompositeDisposable compositeDisposable5 = this.d;
            Disposable subscribe5 = homeView.allCategoriesClicks().observeOn(this.u.mainThread()).subscribe(new a0(this), z3.b);
            Intrinsics.checkNotNullExpressionValue(subscribe5, "view\n            .allCat…CategoriesClicks\", it) })");
            DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            CompositeDisposable compositeDisposable6 = this.d;
            Disposable subscribe6 = this.D.observeOn(this.u.mainThread()).subscribe(new v(this), z3.c);
            Intrinsics.checkNotNullExpressionValue(subscribe6, "snippetClickObservable\n …ble\", it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            CompositeDisposable compositeDisposable7 = this.d;
            Disposable subscribe7 = this.E.observeOn(this.u.mainThread()).subscribe(new y0(0, this), q2.b);
            Intrinsics.checkNotNullExpressionValue(subscribe7, "locationNotificationClic…able\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable7, subscribe7);
            CompositeDisposable compositeDisposable8 = this.d;
            Disposable subscribe8 = this.F.observeOn(this.u.mainThread()).subscribe(new y0(1, this), q2.c);
            Intrinsics.checkNotNullExpressionValue(subscribe8, "locationNotificationVisi…able\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        }
        this.z.subscribe();
        homeView.initToolbar();
        homeView.setAppendingListener(this);
        State restoreStateAfterAttach = this.g.restoreStateAfterAttach();
        this.g = restoreStateAfterAttach;
        if (restoreStateAfterAttach.locationLoaded()) {
            c cVar = new c(this);
            q();
            CompositeDisposable compositeDisposable9 = this.d;
            Disposable subscribe9 = this.m.isLocationChanged().observeOn(this.u.mainThread()).subscribe(new b0(cVar), a2.a.a.a1.h.a);
            Intrinsics.checkNotNullExpressionValue(subscribe9, "interactor\n            .…sLocationChanged\", it) })");
            DisposableKt.plusAssign(compositeDisposable9, subscribe9);
        } else {
            homeView.hideShortcutsBlock();
            e();
        }
        CompositeDisposable compositeDisposable10 = this.d;
        Disposable subscribe10 = this.m.onLogin().subscribeOn(this.u.io()).observeOn(this.u.mainThread()).subscribe(new t(this), u.a);
        Intrinsics.checkNotNullExpressionValue(subscribe10, "interactor.onLogin()\n   …ogin\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable10, subscribe10);
        CompositeDisposable compositeDisposable11 = this.d;
        Disposable subscribe11 = Observables.filterNot(this.m.onLocationChanged(), new q(this)).subscribeOn(this.u.io()).observeOn(this.u.mainThread()).subscribe(new r(this), s.a);
        Intrinsics.checkNotNullExpressionValue(subscribe11, "interactor.onLocationCha…nLocationChanged\", it) })");
        DisposableKt.plusAssign(compositeDisposable11, subscribe11);
    }

    public final void b() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final String c() {
        Location location = this.g.getLocation();
        String name = location != null ? location.getName(6) : null;
        return name != null ? name : "";
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.g.getHasMorePages();
    }

    public final int d() {
        if (this.g.getPage() > 0) {
            return this.g.getPage();
        }
        return 1;
    }

    @Override // com.avito.android.home.HomePresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.home.HomePresenter
    public void detachView() {
        this.z.unsubscribe();
        b();
        this.d.clear();
        this.f.clear();
        this.I.stop();
        this.a = null;
        this.b = null;
    }

    public final void e() {
        this.g = State.Companion.createNewState$default(State.Companion, null, 1, null);
        this.f.clear();
        this.n.reset();
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.scrollToStart();
        }
        j();
    }

    public final boolean f(HomeTabItem homeTabItem) {
        List<ViewTypeSerpItem> elements = this.g.get(homeTabItem).getElements();
        return (elements.isEmpty() ^ true) && (CollectionsKt___CollectionsKt.first(elements) instanceof SkeletonItem);
    }

    public final boolean h() {
        return this.G.getStoriesOnHome().invoke().booleanValue() && !this.v.isTablet();
    }

    public final void i(List<? extends ViewTypeSerpItem> list, HomeTabItem homeTabItem) {
        CompositeDisposable compositeDisposable = this.f;
        HomeInteractor homeInteractor = this.m;
        Location location = this.g.getLocation();
        Disposable subscribe = homeInteractor.loadAds(list, location != null ? location.getId() : null, this.g.get(homeTabItem).getDisplayType()).subscribeOn(this.u.io()).observeOn(this.u.mainThread()).subscribe(new d(this, homeTabItem), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadAds(eleme…ors.\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void j() {
        this.I.startLoadingLocation();
        this.g = this.g.loadingLocation();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.m.loadLocation().subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadLocation(…rNull()) }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        if (!h()) {
            CompositeDisposable compositeDisposable2 = this.d;
            Disposable subscribe2 = this.m.loadWarning().observeOn(this.u.mainThread()).subscribe(new h(this), i.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.loadWarning()…othing\n                })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    public final void k() {
        Location location = this.g.getLocation();
        if (location != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.m.loadMainShortcuts(location).observeOn(this.u.mainThread()).subscribe(new j(this), new k(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadMainShort…cuts\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void l() {
        Location location;
        if (h() && !this.g.storiesLoading() && (location = this.g.getLocation()) != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.m.loadStories(location).observeOn(this.u.mainThread()).subscribe(new l(this), new m(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadStories(l…ries\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void m(DataSource<SpannedItem> dataSource, List<? extends DataSource<SpannedItem>> list) {
        this.l = dataSource;
        this.w.onDataSourceChanged(dataSource);
        this.o.onDataSourceChanged(dataSource);
        this.s.onDataSourceChanged(dataSource);
        this.y.onDataSourceChanged(dataSource);
        this.A.onDataSourceChanged(dataSource);
        this.C.onDataSourceChanged(dataSource);
        this.K.onDataSourceChanged(dataSource);
        this.A.onSecondaryDataSourcesChanged(list);
        this.C.onSecondaryDataSourcesChanged(list);
        this.K.onSecondaryDataSourcesChanged(list);
        if (this.G.getViewVisibilityTracking().invoke().booleanValue()) {
            this.J.onDataSourceChanged(dataSource);
        }
    }

    public final void n(String str) {
        HomeView homeView;
        if ((str.length() > 0) && (homeView = this.a) != null) {
            homeView.showError(str);
        }
        RetryView retryView = this.b;
        if (retryView != null) {
            retryView.showRetry();
        }
    }

    public final void o(HomeTabItem homeTabItem) {
        this.g = this.g.loadingElements(homeTabItem);
        t(this, null, homeTabItem, 1);
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.showFloatingViews(true);
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void onActionResultReceived(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.showMessage(str);
        }
    }

    @Override // com.avito.android.serp.adapter.AdBannerEventListener
    public void onAdBannerOpened(@NotNull BannerInfo bannerInfo, int i2) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor = this.t;
        Location location = this.g.getLocation();
        CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerOpened$default(commercialBannersAnalyticsInteractor, bannerInfo, i2, null, location != null ? location.getId() : null, null, null, 48, null);
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        DeepLink deepLink = advertItem.getDeepLink();
        DataSource<SpannedItem> dataSource = this.l;
        if (dataSource != null) {
            SpannedItem item = dataSource.getItem(i2);
            AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) (!(deepLink instanceof AdvertDetailsLink) ? null : deepLink);
            if (advertDetailsLink == null) {
                return;
            }
            if (item instanceof AdvertItem) {
                HomePresenter.Router router = this.c;
                if (router != null) {
                    AdvertItem advertItem2 = (AdvertItem) item;
                    router.openAdvertDetails(advertDetailsLink.getItemId(), this.g.getCurrentTab().getFeedId(), advertDetailsLink.getContext(), advertItem2.getTitle(), advertItem2.getPrice(), advertItem2.getPreviousPrice(), image, this.q.getParent(), advertItem2.isMarketplace());
                    return;
                }
                return;
            }
            HomePresenter.Router router2 = this.c;
            if (router2 != null) {
                router2.followDeepLink(deepLink, this.q.getParent());
                return;
            }
            return;
        }
        HomePresenter.Router router3 = this.c;
        if (router3 != null) {
            router3.followDeepLink(deepLink, this.q.getParent());
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (this.g.getElementsState() == LoadState.LOAD && this.g.getHasMorePages()) {
            a();
        }
    }

    @Override // com.avito.android.home.HomeViewPresenter
    public void onClarifyClicked() {
        HomePresenter.Router router;
        SearchParams searchParams = this.g.getSearchParams();
        if (searchParams != null && (router = this.c) != null) {
            router.showClarifyScreen(searchParams);
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.A.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.serp.adapter.OnCloseItemListener
    public void onItemClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        String str2;
        T t2;
        AdvertItemActions moreActions;
        List<ItemAction> actions;
        Intrinsics.checkNotNullParameter(str, "itemId");
        List<ViewTypeSerpItem> elements = this.g.getElements();
        Iterator<T> it = elements.iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(t2.getStringId(), str)) {
                break;
            }
        }
        if (!(t2 instanceof AdvertItem)) {
            t2 = null;
        }
        T t3 = t2;
        if (t3 != null && (moreActions = t3.getMoreActions()) != null && (actions = moreActions.getActions()) != null) {
            AdvertItemActions moreActions2 = t3.getMoreActions();
            if (moreActions2 != null) {
                str2 = moreActions2.getTitle();
            }
            String categoryId = t3.getCategoryId();
            String feedId = this.g.getCurrentTab().getFeedId();
            Integer locationId = t3.getLocationId();
            int indexOf = elements.indexOf(t3);
            HomeView homeView = this.a;
            if (homeView != null) {
                homeView.showBottomActionsMenu(str2, actions, str, categoryId, locationId, feedId, indexOf);
            }
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void onPause() {
        if (!this.B.getSendingUserCoordinates() && Intrinsics.areEqual(this.h, Boolean.TRUE)) {
            this.B.sendEventFromFirstRun();
        }
        this.B.sendScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.home.HomeViewPresenter
    public void onRefresh() {
        LoadState locationState = this.g.getLocationState();
        LoadState loadState = LoadState.LOADING;
        if (locationState != loadState) {
            r(true);
            if (this.g.hasTabs()) {
                if (this.g.getElementsState() != loadState || (true ^ this.g.getElements().isEmpty())) {
                    State state = this.g;
                    this.g = state.postRefreshTab(state.getCurrentTab());
                    a();
                }
                l();
                return;
            }
            e();
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void onResetPageState() {
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.resetShortcutBarPosition();
        }
        p();
    }

    @Override // com.avito.android.home.HomePresenter
    public void onResume() {
        this.q.sendHomeShownEvent(this.k);
        this.t.returnToScreen();
    }

    @Override // com.avito.android.home.HomePresenter
    @NotNull
    public HomePresenterState onSaveState() {
        return new HomePresenterState(this.g, this.H.generateId(), this.q.saveState(), this.k, this.s.onSaveState());
    }

    @Override // com.avito.android.home.HomePresenter
    public void onSearchClarified(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        HomePresenter.Router router = this.c;
        if (router != null) {
            router.followDeepLink(deepLink, this.q.getParent());
            this.j = true;
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void onStop() {
        if (this.j) {
            HomeView homeView = this.a;
            if (homeView != null) {
                homeView.setQuery("");
            }
            HomeView homeView2 = this.a;
            if (homeView2 != null) {
                homeView2.close();
            }
            this.j = false;
        }
        r(false);
    }

    @Override // com.avito.android.stories.adapter.StoriesItemListener
    public void onStoryClicked(@NotNull String str, @NotNull String str2) {
        List<Story> stories;
        HomePresenter.Router router;
        Intrinsics.checkNotNullParameter(str, "storyId");
        Intrinsics.checkNotNullParameter(str2, "url");
        StoriesItem stories2 = this.g.getStories();
        if (stories2 != null && (stories = stories2.getStories()) != null && (router = this.c) != null) {
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(stories, 10));
            Iterator<T> it = stories.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getId());
            }
            router.openStory(str2, arrayList, str);
        }
    }

    @Override // com.avito.android.home.SectionTabsViewPresenter
    public void onTabSelectionChanged(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "selectedTab");
        HomeTabItem currentTab = this.g.getCurrentTab();
        State selectTab = this.g.selectTab(homeTabItem);
        this.g = selectTab;
        if (selectTab.getTabStates().containsKey(homeTabItem)) {
            this.q.sendTabSelected(currentTab.getTitle(), homeTabItem.getTitle());
            if (this.g.getCurrentTab().getNeedsRefresh()) {
                onRefresh();
            }
            if (this.g.getElementsState() == LoadState.LOAD) {
                t(this, null, null, 3);
            } else if (this.g.getElementsState() == LoadState.LOADING) {
                o(homeTabItem);
            } else if (this.g.getHasMorePages()) {
                o(homeTabItem);
                a();
            }
        }
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler.Listener
    public void onVisibleItemChanged(int i2) {
        this.s.onUserScrollToNewItem(i2);
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemListener
    public void onWitcherSearchButtonClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        HomePresenter.Router router = this.c;
        if (router != null) {
            router.followDeepLink(deepLink, this.q.getParent());
        }
    }

    public final void p() {
        m(new ListDataSource(CollectionsKt__CollectionsKt.emptyList()), null);
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.onDataChanged();
        }
        HomeView homeView2 = this.a;
        if (homeView2 != null) {
            homeView2.setQuery("");
        }
        HomeView homeView3 = this.a;
        if (homeView3 != null) {
            homeView3.close();
        }
        e();
    }

    public final void q() {
        HomeView homeView = this.a;
        if (homeView != null) {
            homeView.showProgress();
        }
    }

    public final void r(boolean z2) {
        if (this.s.hasNewDataFromLastEventSent()) {
            SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor = this.r;
            int d2 = d();
            List<String> advertItemsIds = this.s.getAdvertItemsIds();
            int advertsItemCount = this.s.getAdvertsItemCount();
            String xHash = this.g.getXHash();
            if (xHash == null) {
                xHash = "";
            }
            snippetScrollDepthAnalyticsInteractor.sendUserScrolledToItemOnHome(d2, advertItemsIds, advertsItemCount, xHash, this.s.getTotalItemsCount());
            this.s.onAnalyticsEventWasSent();
        }
        if (z2) {
            this.s.resetValues();
        }
    }

    @Override // com.avito.android.home.appending_item.retry.RetryItemsLoadingListener
    public void retryItemsLoading() {
        if (this.g.hasTabs() && this.g.getElements().isEmpty()) {
            o(this.g.getCurrentTab());
        }
        a();
    }

    @Override // com.avito.android.home.HomeViewPresenter
    public void retryLoading() {
        q();
        if (this.g.getElements().isEmpty()) {
            j();
        } else {
            a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x030a A[EDGE_INSN: B:159:0x030a->B:127:0x030a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x023d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(com.avito.android.home.DataChangesHolder r20, com.avito.android.remote.model.HomeTabItem r21) {
        /*
        // Method dump skipped, instructions count: 878
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.home.HomePresenterImpl.s(com.avito.android.home.DataChangesHolder, com.avito.android.remote.model.HomeTabItem):void");
    }

    @Override // com.avito.android.home.HomeViewPresenter
    public void showAllCategories() {
        HomePresenter.Router router = this.c;
        if (router != null) {
            router.showAllCategories(this.g.getLocation(), this.q.getParent());
        }
        this.q.sendShowAllCategories();
    }

    public final void u() {
        Location location = this.g.getLocation();
        String name = location != null ? location.getName(6) : null;
        if (name == null || name.length() == 0) {
            HomeView homeView = this.a;
            if (homeView != null) {
                homeView.setSearchHintSearch();
                return;
            }
            return;
        }
        HomeView homeView2 = this.a;
        if (homeView2 != null) {
            if (name == null) {
                name = "";
            }
            homeView2.setSearchHintSearchInLocation(name);
        }
    }

    @Override // com.avito.android.home.HomePresenter
    public void updateCurrentStoryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "storyId");
        StoriesItem stories = this.g.getStories();
        if (stories != null) {
            this.m.updateStoriesViewedStatus(stories.getStories());
            stories.setCurrentStoryId(str);
            t(this, new DataChangesHolder.Changed(0, 0, stories, 3, null), null, 2);
        }
    }

    public final void v(String str) {
        if (str != null) {
            if (str.length() > 0) {
                HomeView homeView = this.a;
                if (homeView != null) {
                    homeView.setSearchHintFromApi(str);
                    return;
                }
                return;
            }
            u();
            return;
        }
        u();
    }

    public final void w(Shortcuts shortcuts) {
        String str;
        this.I.startShortcutsPrepare();
        List<ShortcutNavigationItem> convert = this.x.convert(shortcuts);
        if (!convert.isEmpty()) {
            if (this.P.isTest()) {
                ArrayList arrayList = new ArrayList();
                for (T t2 : convert) {
                    if (RubricatorItemPresenter.Companion.getRUBRICATOR_CATEGORIES_MAP().keySet().contains(ShortcutNavigationItemKt.extractCategoryId(t2))) {
                        arrayList.add(t2);
                    }
                }
                convert = arrayList;
            }
            List<? extends ShortcutNavigationItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) convert);
            int ordinal = this.P.ordinal();
            if (ordinal != 2) {
                if (ordinal == 3) {
                    str = this.v.getAllCategoriesLarge();
                } else if (ordinal == 4 || ordinal == 5) {
                    str = this.v.getAllCategories();
                } else {
                    str = this.v.getSelectCategory();
                }
                mutableList.add(this.P.isAllCategoriesInEnd() ? mutableList.size() : 0, new ShortcutNavigationItemImpl("all_categories_shortcut", str, new MainScreenLink(), true));
            }
            this.I.trackShortcutsPrepare();
            HomeView homeView = this.a;
            if (homeView != null) {
                homeView.showShortcutsBlock();
            }
            HomeView homeView2 = this.a;
            if (homeView2 != null) {
                homeView2.setShortcutItems(shortcuts.getHeader(), mutableList);
            }
        } else {
            this.I.trackShortcutsPrepare();
            HomeView homeView3 = this.a;
            if (homeView3 != null) {
                homeView3.hideShortcutsBlock();
            }
        }
        this.n.updateVisibility();
        this.I.trackShortcutsDraw();
    }
}
