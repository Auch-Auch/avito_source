package com.avito.android.search.map;

import a2.g.r.g;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.Features;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.RealtyNewBackNavigation;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.app.task.InitializeYandexMapsTask;
import com.avito.android.app.task.RegisterGeoPositionCheckingCallbacksTask;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhoneViewImpl;
import com.avito.android.avito_map.AvitoMapZoomLevel;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.UpNavigationHandler;
import com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.filter.FilterCommons;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lastclick.LastClick;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.rec.ScreenSource;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.saved_searches.SavedSearchViewImpl;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.CheckZoomButtonsStateAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.PhoneDialogAction;
import com.avito.android.search.map.action.ScreenExit;
import com.avito.android.search.map.action.SearchParamsChangedAction;
import com.avito.android.search.map.action.UpdateViewedPinsAction;
import com.avito.android.search.map.di.DaggerSearchMapComponent;
import com.avito.android.search.map.di.SearchMapComponent;
import com.avito.android.search.map.di.SearchMapDependencies;
import com.avito.android.search.map.di.SerpList;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.search.map.interactor.SerpKey;
import com.avito.android.search.map.metric.SearchMapScreen;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.search.map.utils.LatLngBoundsKt;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.PinAdvertsView;
import com.avito.android.search.map.view.adapter.AppendingState;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Intents;
import com.avito.android.util.Kundle;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.UrlParams;
import com.google.android.gms.maps.model.LatLngBounds;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004Ä\u0002Å\u0002B\b¢\u0006\u0005\bÃ\u0002\u0010\u001fJ/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010\u001fJ\u000f\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b%\u0010\u001fJ1\u0010,\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010-J!\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b4\u00105JY\u0010>\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010;2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u0010=\u001a\u00020\tH\u0016¢\u0006\u0004\b>\u0010?J\u0017\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b2\u00105J!\u0010D\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u000bH\u0016¢\u0006\u0004\bF\u0010\u001fJ'\u0010G\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bG\u0010HJ3\u0010L\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0I2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0IH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0004H\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XJ)\u0010]\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020Q2\u0006\u0010Z\u001a\u00020Q2\b\u0010\\\u001a\u0004\u0018\u00010[H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0010H\u0016¢\u0006\u0004\b`\u0010\u0013J\u000f\u0010a\u001a\u00020\tH\u0016¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bc\u0010\u0013J\u000f\u0010d\u001a\u00020\u000bH\u0016¢\u0006\u0004\bd\u0010\u001fR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R1\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010³\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R*\u0010Ã\u0001\u001a\u00030Â\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R*\u0010Ê\u0001\u001a\u00030É\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R*\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001RD\u0010Û\u0001\u001a\u001d\u0012\u000b\u0012\t0Ø\u0001¢\u0006\u0003\bÙ\u0001\u0012\u000b\u0012\t0Ú\u0001¢\u0006\u0003\bÙ\u00010×\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R0\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060á\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R*\u0010é\u0001\u001a\u00030è\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R*\u0010ð\u0001\u001a\u00030ï\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R6\u0010÷\u0001\u001a\u000f\u0012\n\u0012\b0U¢\u0006\u0003\bö\u00010á\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b÷\u0001\u0010ã\u0001\u001a\u0006\bø\u0001\u0010å\u0001\"\u0006\bù\u0001\u0010ç\u0001R*\u0010û\u0001\u001a\u00030ú\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bû\u0001\u0010ü\u0001\u001a\u0006\bý\u0001\u0010þ\u0001\"\u0006\bÿ\u0001\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R8\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u00028\u0006@\u0006X.¢\u0006\u001f\n\u0006\b\u0002\u0010\u0002\u0012\u0005\b\u0002\u0010\u001f\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010 \u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b \u0002\u0010¡\u0002\u001a\u0006\b¢\u0002\u0010£\u0002\"\u0006\b¤\u0002\u0010¥\u0002R*\u0010§\u0002\u001a\u00030¦\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b§\u0002\u0010¨\u0002\u001a\u0006\b©\u0002\u0010ª\u0002\"\u0006\b«\u0002\u0010¬\u0002R1\u0010®\u0002\u001a\u00030­\u00028\u0006@\u0006X.¢\u0006\u001f\n\u0006\b®\u0002\u0010¯\u0002\u0012\u0005\b´\u0002\u0010\u001f\u001a\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002R*\u0010¶\u0002\u001a\u00030µ\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R*\u0010½\u0002\u001a\u00030¼\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b½\u0002\u0010¾\u0002\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0006\bÁ\u0002\u0010Â\u0002¨\u0006Æ\u0002"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "", "fromXl", "", "d", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Ljava/lang/String;Z)V", "c", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onStart", "onStop", "onDestroyView", "close", "leaveScreen", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "area", "mapSerpState", UrlParams.SIMPLE_MAP, "showFiltersScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "clarifySearchByDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router$Reason;", "reason", "Landroid/os/Parcelable;", "successAuthResultData", "showAuth", "(Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router$Reason;Landroid/os/Parcelable;)V", "showApplicationPermissionsSettings", "showCallDialog", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Z)V", "Lkotlin/Function0;", "successHandler", "failureHandler", "followPhoneLink", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "phoneLink", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;)Z", "", "message", "showToastMessage", "(I)V", "", "error", "showErrorMessage", "(Ljava/lang/Throwable;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "onBackPressed", "()Z", "onViewStateRestored", "showNotificationSettingsScreen", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "serpCacheInteractor", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "getSerpCacheInteractor", "()Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "setSerpCacheInteractor", "(Lcom/avito/android/search/map/interactor/SerpCacheInteractor;)V", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "witcherItemPresenter", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "getWitcherItemPresenter", "()Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "setWitcherItemPresenter", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;)V", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "k", "Lcom/jakewharton/rxrelay3/PublishRelay;", "systemBackClickRelay", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "getSavedSearchesPresenter", "()Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "setSavedSearchesPresenter", "(Lcom/avito/android/saved_searches/SavedSearchesPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "getFindLocationPresenter", "()Lcom/avito/android/location/find/FindLocationPresenter;", "setFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenter;)V", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "richSnippetStateProvider", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "getRichSnippetStateProvider", "()Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "setRichSnippetStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;)V", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "getAsyncPhonePresenter", "()Lcom/avito/android/async_phone/AsyncPhonePresenter;", "setAsyncPhonePresenter", "(Lcom/avito/android/async_phone/AsyncPhonePresenter;)V", "Landroidx/appcompat/app/AlertDialog;", "j", "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhoneTestGroup", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "getJustDialSellerPhoneTestGroup", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "setJustDialSellerPhoneTestGroup", "(Lcom/avito/android/ab_tests/models/AbTestGroup;)V", "Lcom/avito/android/search/map/ViewBinder;", "viewBinder", "Lcom/avito/android/search/map/ViewBinder;", "getViewBinder", "()Lcom/avito/android/search/map/ViewBinder;", "setViewBinder", "(Lcom/avito/android/search/map/ViewBinder;)V", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "getNotificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "setNotificationManagerProvider", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "Lcom/avito/android/location/SavedLocationInteractor;", "getLocationInteractor", "()Lcom/avito/android/location/SavedLocationInteractor;", "setLocationInteractor", "(Lcom/avito/android/location/SavedLocationInteractor;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/redux/SubscribableStore;", "Lcom/avito/android/search/map/SearchMapState;", "Lkotlin/jvm/JvmWildcard;", "Lcom/avito/android/search/map/action/MapAction;", "store", "Lcom/avito/android/redux/SubscribableStore;", "getStore", "()Lcom/avito/android/redux/SubscribableStore;", "setStore", "(Lcom/avito/android/redux/SubscribableStore;)V", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "getPhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "setPhoneNumberFormatter", "(Lcom/avito/android/util/Formatter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/search/map/SearchMapViewFactory;", "viewFactory", "Lcom/avito/android/search/map/SearchMapViewFactory;", "getViewFactory", "()Lcom/avito/android/search/map/SearchMapViewFactory;", "setViewFactory", "(Lcom/avito/android/search/map/SearchMapViewFactory;)V", "Lkotlin/jvm/JvmSuppressWildcards;", "errorFormatter", "getErrorFormatter", "setErrorFormatter", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "snippetScrollDepthTracker", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "getSnippetScrollDepthTracker", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "setSnippetScrollDepthTracker", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;)V", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "advertXlStateProvider", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "getAdvertXlStateProvider", "()Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "setAdvertXlStateProvider", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;)V", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialBannersAnalyticsInteractor", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "getCommercialBannersAnalyticsInteractor", "()Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "setCommercialBannersAnalyticsInteractor", "(Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;)V", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "snippetScrollDepthAnalyticsInteractor", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "getSnippetScrollDepthAnalyticsInteractor", "()Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "setSnippetScrollDepthAnalyticsInteractor", "(Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;)V", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "backNavigationTestGroup", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "getBackNavigationTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "setBackNavigationTestGroup", "(Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "getBackNavigationTestGroup$annotations", "Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "navigationMiddleware", "Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "getNavigationMiddleware", "()Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "setNavigationMiddleware", "(Lcom/avito/android/search/map/middleware/NavigationMiddleware;)V", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "tasksRegistry", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "getTasksRegistry", "()Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "setTasksRegistry", "(Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "listItemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getListItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setListItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "getListItemVisibilityTracker$annotations", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "searchMapTracker", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "getSearchMapTracker", "()Lcom/avito/android/search/map/metric/SearchMapTracker;", "setSearchMapTracker", "(Lcom/avito/android/search/map/metric/SearchMapTracker;)V", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "getInlineFiltersPresenter", "()Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "setInlineFiltersPresenter", "(Lcom/avito/android/inline_filters/InlineFiltersPresenter;)V", "<init>", "Factory", "StoreFragment", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapFragment extends TabBaseFragment implements NavigationMiddleware.Router, OnBackPressedListener {
    @Inject
    public AdvertXlStateProvider advertXlStateProvider;
    @Inject
    public SearchMapAnalyticsInteractor analyticsInteractor;
    @Inject
    public AsyncPhonePresenter asyncPhonePresenter;
    @Inject
    public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> backNavigationTestGroup;
    @Inject
    public CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Formatter<Throwable> errorFormatter;
    @Inject
    public Features features;
    @Inject
    public FindLocationPresenter findLocationPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public InlineFiltersPresenter inlineFiltersPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    public AlertDialog j;
    @Inject
    @JustDialSellerPhoneTestGroup
    public AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhoneTestGroup;
    public final PublishRelay<Unit> k;
    @Inject
    public ItemVisibilityTracker listItemVisibilityTracker;
    @Inject
    public SavedLocationInteractor locationInteractor;
    @Inject
    public NavigationMiddleware navigationMiddleware;
    @Inject
    public NotificationManagerProvider notificationManagerProvider;
    @Inject
    public Formatter<String> phoneNumberFormatter;
    @Inject
    @RichStateProvider
    public RichSnippetStateProvider richSnippetStateProvider;
    @Inject
    public SavedSearchesPresenter savedSearchesPresenter;
    @Inject
    public SearchMapTracker searchMapTracker;
    @Inject
    public SerpCacheInteractor serpCacheInteractor;
    @Inject
    public SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor;
    @Inject
    public SnippetScrollDepthTracker snippetScrollDepthTracker;
    @Inject
    public SubscribableStore<SearchMapState, ? super MapAction> store;
    @Inject
    public FpsStateSupplier supplier;
    @Inject
    public ApplicationStartupTasksRegistry tasksRegistry;
    @Inject
    public ViewBinder viewBinder;
    @Inject
    public SearchMapViewFactory viewFactory;
    @Inject
    public WitcherItemPresenter witcherItemPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment$Factory;", "", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "arguments", "Lcom/avito/android/search/map/SearchMapFragment;", "create", "(Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;)Lcom/avito/android/search/map/SearchMapFragment;", "<init>", "()V", "Arguments", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u001d\b\b\u0018\u0000 G2\u00020\u0001:\u0001GBU\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u001c¢\u0006\u0004\bE\u0010FJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJl\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010&\u001a\u00020\u001cHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010\u0010J\u0010\u0010*\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b*\u0010\nJ\u001a\u0010-\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001b\u0010%\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\rR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0013R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0010R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u00109\u001a\u0004\b<\u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u0010\u0013R\u0019\u0010&\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u001eR\u001b\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u0018¨\u0006H"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SearchParams;", "component1", "()Lcom/avito/android/remote/model/SearchParams;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/map/Area;", "component3", "()Lcom/avito/android/remote/model/search/map/Area;", "component4", "component5", "", "component6", "()Ljava/lang/Float;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component7", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "", "component8", "()Z", "searchParams", "context", "searchArea", "mapArea", "mapSerpState", "mapZoomLevel", "treeParent", UrlParams.SIMPLE_MAP, "copy", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/Float;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", g.a, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "d", "Lcom/avito/android/remote/model/search/map/Area;", "getMapArea", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContext", "e", "getMapSerpState", "c", "getSearchArea", "h", "Z", "getShowSimpleMap", "f", "Ljava/lang/Float;", "getMapZoomLevel", "<init>", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/Float;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "CREATOR", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class Arguments implements Parcelable {
            @NotNull
            public static final CREATOR CREATOR = new CREATOR(null);
            @NotNull
            public final SearchParams a;
            @Nullable
            public final String b;
            @Nullable
            public final Area c;
            @Nullable
            public final Area d;
            @Nullable
            public final String e;
            @Nullable
            public final Float f;
            @Nullable
            public final TreeClickStreamParent g;
            public final boolean h;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "", "size", "", "newArray", "(I)[Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
            public static final class CREATOR implements Parcelable.Creator<Arguments> {
                public CREATOR() {
                }

                public CREATOR(j jVar) {
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public Arguments createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    SearchParams searchParams = (SearchParams) a2.b.a.a.a.z1(SearchParams.class, parcel);
                    String readString = parcel.readString();
                    Area area = (Area) parcel.readParcelable(Area.class.getClassLoader());
                    Area area2 = (Area) parcel.readParcelable(Area.class.getClassLoader());
                    String readString2 = parcel.readString();
                    Object readValue = parcel.readValue(Float.class.getClassLoader());
                    if (!(readValue instanceof Float)) {
                        readValue = null;
                    }
                    return new Arguments(searchParams, readString, area, area2, readString2, (Float) readValue, (TreeClickStreamParent) parcel.readParcelable(TreeClickStreamParent.class.getClassLoader()), ParcelsKt.readBool(parcel));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public Arguments[] newArray(int i) {
                    return new Arguments[i];
                }
            }

            public Arguments(@NotNull SearchParams searchParams, @Nullable String str, @Nullable Area area, @Nullable Area area2, @Nullable String str2, @Nullable Float f2, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
                Intrinsics.checkNotNullParameter(searchParams, "searchParams");
                this.a = searchParams;
                this.b = str;
                this.c = area;
                this.d = area2;
                this.e = str2;
                this.f = f2;
                this.g = treeClickStreamParent;
                this.h = z;
            }

            public static /* synthetic */ Arguments copy$default(Arguments arguments, SearchParams searchParams, String str, Area area, Area area2, String str2, Float f2, TreeClickStreamParent treeClickStreamParent, boolean z, int i, Object obj) {
                return arguments.copy((i & 1) != 0 ? arguments.a : searchParams, (i & 2) != 0 ? arguments.b : str, (i & 4) != 0 ? arguments.c : area, (i & 8) != 0 ? arguments.d : area2, (i & 16) != 0 ? arguments.e : str2, (i & 32) != 0 ? arguments.f : f2, (i & 64) != 0 ? arguments.g : treeClickStreamParent, (i & 128) != 0 ? arguments.h : z);
            }

            @NotNull
            public final SearchParams component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final Area component3() {
                return this.c;
            }

            @Nullable
            public final Area component4() {
                return this.d;
            }

            @Nullable
            public final String component5() {
                return this.e;
            }

            @Nullable
            public final Float component6() {
                return this.f;
            }

            @Nullable
            public final TreeClickStreamParent component7() {
                return this.g;
            }

            public final boolean component8() {
                return this.h;
            }

            @NotNull
            public final Arguments copy(@NotNull SearchParams searchParams, @Nullable String str, @Nullable Area area, @Nullable Area area2, @Nullable String str2, @Nullable Float f2, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
                Intrinsics.checkNotNullParameter(searchParams, "searchParams");
                return new Arguments(searchParams, str, area, area2, str2, f2, treeClickStreamParent, z);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Arguments)) {
                    return false;
                }
                Arguments arguments = (Arguments) obj;
                return Intrinsics.areEqual(this.a, arguments.a) && Intrinsics.areEqual(this.b, arguments.b) && Intrinsics.areEqual(this.c, arguments.c) && Intrinsics.areEqual(this.d, arguments.d) && Intrinsics.areEqual(this.e, arguments.e) && Intrinsics.areEqual(this.f, arguments.f) && Intrinsics.areEqual(this.g, arguments.g) && this.h == arguments.h;
            }

            @Nullable
            public final String getContext() {
                return this.b;
            }

            @Nullable
            public final Area getMapArea() {
                return this.d;
            }

            @Nullable
            public final String getMapSerpState() {
                return this.e;
            }

            @Nullable
            public final Float getMapZoomLevel() {
                return this.f;
            }

            @Nullable
            public final Area getSearchArea() {
                return this.c;
            }

            @NotNull
            public final SearchParams getSearchParams() {
                return this.a;
            }

            public final boolean getShowSimpleMap() {
                return this.h;
            }

            @Nullable
            public final TreeClickStreamParent getTreeParent() {
                return this.g;
            }

            @Override // java.lang.Object
            public int hashCode() {
                SearchParams searchParams = this.a;
                int i = 0;
                int hashCode = (searchParams != null ? searchParams.hashCode() : 0) * 31;
                String str = this.b;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                Area area = this.c;
                int hashCode3 = (hashCode2 + (area != null ? area.hashCode() : 0)) * 31;
                Area area2 = this.d;
                int hashCode4 = (hashCode3 + (area2 != null ? area2.hashCode() : 0)) * 31;
                String str2 = this.e;
                int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
                Float f2 = this.f;
                int hashCode6 = (hashCode5 + (f2 != null ? f2.hashCode() : 0)) * 31;
                TreeClickStreamParent treeClickStreamParent = this.g;
                if (treeClickStreamParent != null) {
                    i = treeClickStreamParent.hashCode();
                }
                int i2 = (hashCode6 + i) * 31;
                boolean z = this.h;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Arguments(searchParams=");
                L.append(this.a);
                L.append(", context=");
                L.append(this.b);
                L.append(", searchArea=");
                L.append(this.c);
                L.append(", mapArea=");
                L.append(this.d);
                L.append(", mapSerpState=");
                L.append(this.e);
                L.append(", mapZoomLevel=");
                L.append(this.f);
                L.append(", treeParent=");
                L.append(this.g);
                L.append(", showSimpleMap=");
                return a2.b.a.a.a.B(L, this.h, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.a, i);
                parcel.writeString(this.b);
                parcel.writeParcelable(this.c, i);
                parcel.writeParcelable(this.d, i);
                parcel.writeString(this.e);
                ParcelsKt.writeNullableValue(parcel, this.f);
                parcel.writeParcelable(this.g, i);
                ParcelsKt.writeBool(parcel, this.h);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Arguments(SearchParams searchParams, String str, Area area, Area area2, String str2, Float f2, TreeClickStreamParent treeClickStreamParent, boolean z, int i, j jVar) {
                this(searchParams, str, area, area2, str2, f2, treeClickStreamParent, (i & 128) != 0 ? false : z);
            }
        }

        @NotNull
        public final SearchMapFragment create(@NotNull Arguments arguments) {
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            SearchMapFragment searchMapFragment = new SearchMapFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arguments", arguments);
            Unit unit = Unit.INSTANCE;
            searchMapFragment.setArguments(bundle);
            return searchMapFragment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment$StoreFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/search/map/SearchMapFragment$StoreFragment$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/SearchMapFragment$StoreFragment$State;", "getState$map_release", "()Lcom/avito/android/search/map/SearchMapFragment$StoreFragment$State;", "setState$map_release", "(Lcom/avito/android/search/map/SearchMapFragment$StoreFragment$State;)V", "state", "<init>", "()V", "State", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class StoreFragment extends Fragment {
        @Nullable
        public State a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001e\u0010+\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012¨\u0006."}, d2 = {"Lcom/avito/android/search/map/SearchMapFragment$StoreFragment$State;", "", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "i", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "getSnippetScrollDepthTrackerState$map_release", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "snippetScrollDepthTrackerState", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeClickStreamParent$map_release", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeClickStreamParent", "Lcom/avito/android/util/Kundle;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Kundle;", "getAdvertXlState$map_release", "()Lcom/avito/android/util/Kundle;", "advertXlState", "h", "getSavedSearchesPresenterState$map_release", "savedSearchesPresenterState", "e", "getInlineFiltersState$map_release", "inlineFiltersState", "Landroid/os/Bundle;", g.a, "Landroid/os/Bundle;", "getListItemVisibilityTrackerState$map_release", "()Landroid/os/Bundle;", "listItemVisibilityTrackerState", "Lcom/avito/android/search/map/SearchMapState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/SearchMapState;", "getSearchMapState$map_release", "()Lcom/avito/android/search/map/SearchMapState;", "searchMapState", "c", "getAdvertRichState$map_release", "advertRichState", "f", "getWitcherState$map_release", "witcherState", "<init>", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Landroid/os/Bundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;)V", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class State {
            @NotNull
            public final SearchMapState a;
            @NotNull
            public final Kundle b;
            @NotNull
            public final Kundle c;
            @Nullable
            public final TreeClickStreamParent d;
            @Nullable
            public final Kundle e;
            @Nullable
            public final Kundle f;
            @Nullable
            public final Bundle g;
            @Nullable
            public final Kundle h;
            @Nullable
            public final SnippetScrollDepthTracker.State i;

            public State(@NotNull SearchMapState searchMapState, @NotNull Kundle kundle, @NotNull Kundle kundle2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable Kundle kundle3, @Nullable Kundle kundle4, @Nullable Bundle bundle, @Nullable Kundle kundle5, @Nullable SnippetScrollDepthTracker.State state) {
                Intrinsics.checkNotNullParameter(searchMapState, "searchMapState");
                Intrinsics.checkNotNullParameter(kundle, "advertXlState");
                Intrinsics.checkNotNullParameter(kundle2, "advertRichState");
                this.a = searchMapState;
                this.b = kundle;
                this.c = kundle2;
                this.d = treeClickStreamParent;
                this.e = kundle3;
                this.f = kundle4;
                this.g = bundle;
                this.h = kundle5;
                this.i = state;
            }

            @NotNull
            public final Kundle getAdvertRichState$map_release() {
                return this.c;
            }

            @NotNull
            public final Kundle getAdvertXlState$map_release() {
                return this.b;
            }

            @Nullable
            public final Kundle getInlineFiltersState$map_release() {
                return this.e;
            }

            @Nullable
            public final Bundle getListItemVisibilityTrackerState$map_release() {
                return this.g;
            }

            @Nullable
            public final Kundle getSavedSearchesPresenterState$map_release() {
                return this.h;
            }

            @NotNull
            public final SearchMapState getSearchMapState$map_release() {
                return this.a;
            }

            @Nullable
            public final SnippetScrollDepthTracker.State getSnippetScrollDepthTrackerState$map_release() {
                return this.i;
            }

            @Nullable
            public final TreeClickStreamParent getTreeClickStreamParent$map_release() {
                return this.d;
            }

            @Nullable
            public final Kundle getWitcherState$map_release() {
                return this.f;
            }
        }

        @Nullable
        public final State getState$map_release() {
            return this.a;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public final void setState$map_release(@Nullable State state) {
            this.a = state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NavigationMiddleware.Router.Reason.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ SearchMapFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PhoneLink c;
        public final /* synthetic */ String d;

        /* compiled from: kotlin-style lambda group */
        /* renamed from: com.avito.android.search.map.SearchMapFragment$a$a  reason: collision with other inner class name */
        public static final class C0157a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0157a(int i, Object obj) {
                super(0);
                this.a = i;
                this.b = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    SearchMapAnalyticsInteractor analyticsInteractor = ((a) this.b).a.getAnalyticsInteractor();
                    a aVar = (a) this.b;
                    analyticsInteractor.sendShowPhoneDialer(aVar.b, aVar.d, true);
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    ((a) this.b).a.showToastMessage(R.string.cant_do_call);
                    ((a) this.b).a.getViewBinder().getStore().dispatch(new PhoneDialogAction.CallUnavailable());
                    SearchMapAnalyticsInteractor analyticsInteractor2 = ((a) this.b).a.getAnalyticsInteractor();
                    a aVar2 = (a) this.b;
                    analyticsInteractor2.sendShowPhoneDialer(aVar2.b, aVar2.d, false);
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            }
        }

        public a(SearchMapFragment searchMapFragment, String str, PhoneLink phoneLink, String str2) {
            this.a = searchMapFragment;
            this.b = str;
            this.c = phoneLink;
            this.d = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            this.a.getViewBinder().getStore().dispatch(new PhoneDialogAction.UserMakeCall(this.b));
            this.a.followPhoneLink(this.c, new C0157a(0, this), new C0157a(1, this));
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ SearchMapFragment a;

        public b(SearchMapFragment searchMapFragment) {
            this.a = searchMapFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.getViewBinder().getStore().dispatch(new PhoneDialogAction.UserCancelCall());
        }
    }

    public SearchMapFragment() {
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.k = create;
    }

    @RealtyNewBackNavigation
    public static /* synthetic */ void getBackNavigationTestGroup$annotations() {
    }

    @SerpList
    public static /* synthetic */ void getListItemVisibilityTracker$annotations() {
    }

    public final String c() {
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        return viewBinder2.getStore().getState().getSearchParams().getLocationId();
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void clarifySearchByDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder2.getStore().dispatch(new SearchParamsChangedAction(deepLink));
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void close() {
        FragmentActivity activity = getActivity();
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder2.stop();
        if (activity instanceof UpNavigationHandler) {
            ((UpNavigationHandler) activity).handleUpNavigation();
        } else if (activity != null) {
            activity.finish();
        }
    }

    public final void d(PhoneLink phoneLink, String str, String str2, boolean z) {
        if (!DialogUtils.isShowing(this.j)) {
            Formatter<String> formatter = this.phoneNumberFormatter;
            if (formatter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
            }
            String format = formatter.format(phoneLink.getPhone());
            Context context = getContext();
            if (context != null) {
                AlertDialog create = new AlertDialog.Builder(context).setTitle(com.avito.android.advert_core.R.string.phone).setMessage(format).setPositiveButton(R.string.call, new a(this, str, phoneLink, str2)).setOnCancelListener(new b(this)).create();
                this.j = create;
                Intrinsics.checkNotNull(create);
                create.show();
                SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
                if (searchMapAnalyticsInteractor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
                }
                searchMapAnalyticsInteractor.sendShowPhoneDialog(str, str2);
                String str3 = null;
                if (!(phoneLink instanceof PhoneLink.Call)) {
                    phoneLink = null;
                }
                PhoneLink.Call call = (PhoneLink.Call) phoneLink;
                if (call != null) {
                    str3 = call.getContext();
                }
                SearchMapAnalyticsInteractor searchMapAnalyticsInteractor2 = this.analyticsInteractor;
                if (searchMapAnalyticsInteractor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
                }
                searchMapAnalyticsInteractor2.sendCallToSeller(str, str3, z);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public boolean dialPhone(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent == null) {
            return false;
        }
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void followDeepLink(@NotNull DeepLink deepLink, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            if (treeClickStreamParent != null) {
                Intents.putTreeAnalyticsParent(intent, treeClickStreamParent);
            }
            IntentsKt.replaceTargetTabIfRequired(intent, currentTab());
            startActivity(intent);
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public void followPhoneLink(@NotNull PhoneLink phoneLink, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(phoneLink, "link");
        Intrinsics.checkNotNullParameter(function0, "successHandler");
        Intrinsics.checkNotNullParameter(function02, "failureHandler");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent != null) {
            try {
                startActivity(com.avito.android.util.IntentsKt.makeSafeForExternalApps(intent));
                function0.invoke();
            } catch (Exception unused) {
                function02.invoke();
            }
        }
    }

    @NotNull
    public final AdvertXlStateProvider getAdvertXlStateProvider() {
        AdvertXlStateProvider advertXlStateProvider2 = this.advertXlStateProvider;
        if (advertXlStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertXlStateProvider");
        }
        return advertXlStateProvider2;
    }

    @NotNull
    public final SearchMapAnalyticsInteractor getAnalyticsInteractor() {
        SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
        if (searchMapAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return searchMapAnalyticsInteractor;
    }

    @NotNull
    public final AsyncPhonePresenter getAsyncPhonePresenter() {
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        return asyncPhonePresenter2;
    }

    @NotNull
    public final ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> getBackNavigationTestGroup() {
        ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup = this.backNavigationTestGroup;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backNavigationTestGroup");
        }
        return manuallyExposedAbTestGroup;
    }

    @NotNull
    public final CommercialBannersAnalyticsInteractor getCommercialBannersAnalyticsInteractor() {
        CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor2 = this.commercialBannersAnalyticsInteractor;
        if (commercialBannersAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commercialBannersAnalyticsInteractor");
        }
        return commercialBannersAnalyticsInteractor2;
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
    public final Formatter<Throwable> getErrorFormatter() {
        Formatter<Throwable> formatter = this.errorFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
        }
        return formatter;
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
    public final FindLocationPresenter getFindLocationPresenter() {
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        return findLocationPresenter2;
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
    public final InlineFiltersPresenter getInlineFiltersPresenter() {
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        return inlineFiltersPresenter2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final AbTestGroup<SimpleTestGroupWithControl2> getJustDialSellerPhoneTestGroup() {
        AbTestGroup<SimpleTestGroupWithControl2> abTestGroup = this.justDialSellerPhoneTestGroup;
        if (abTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("justDialSellerPhoneTestGroup");
        }
        return abTestGroup;
    }

    @NotNull
    public final ItemVisibilityTracker getListItemVisibilityTracker() {
        ItemVisibilityTracker itemVisibilityTracker = this.listItemVisibilityTracker;
        if (itemVisibilityTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listItemVisibilityTracker");
        }
        return itemVisibilityTracker;
    }

    @NotNull
    public final SavedLocationInteractor getLocationInteractor() {
        SavedLocationInteractor savedLocationInteractor = this.locationInteractor;
        if (savedLocationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
        }
        return savedLocationInteractor;
    }

    @NotNull
    public final NavigationMiddleware getNavigationMiddleware() {
        NavigationMiddleware navigationMiddleware2 = this.navigationMiddleware;
        if (navigationMiddleware2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationMiddleware");
        }
        return navigationMiddleware2;
    }

    @NotNull
    public final NotificationManagerProvider getNotificationManagerProvider() {
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        return notificationManagerProvider2;
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
    public final RichSnippetStateProvider getRichSnippetStateProvider() {
        RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
        if (richSnippetStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
        }
        return richSnippetStateProvider2;
    }

    @NotNull
    public final SavedSearchesPresenter getSavedSearchesPresenter() {
        SavedSearchesPresenter savedSearchesPresenter2 = this.savedSearchesPresenter;
        if (savedSearchesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchesPresenter");
        }
        return savedSearchesPresenter2;
    }

    @NotNull
    public final SearchMapTracker getSearchMapTracker() {
        SearchMapTracker searchMapTracker2 = this.searchMapTracker;
        if (searchMapTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
        }
        return searchMapTracker2;
    }

    @NotNull
    public final SerpCacheInteractor getSerpCacheInteractor() {
        SerpCacheInteractor serpCacheInteractor2 = this.serpCacheInteractor;
        if (serpCacheInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpCacheInteractor");
        }
        return serpCacheInteractor2;
    }

    @NotNull
    public final SnippetScrollDepthAnalyticsInteractor getSnippetScrollDepthAnalyticsInteractor() {
        SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor2 = this.snippetScrollDepthAnalyticsInteractor;
        if (snippetScrollDepthAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthAnalyticsInteractor");
        }
        return snippetScrollDepthAnalyticsInteractor2;
    }

    @NotNull
    public final SnippetScrollDepthTracker getSnippetScrollDepthTracker() {
        SnippetScrollDepthTracker snippetScrollDepthTracker2 = this.snippetScrollDepthTracker;
        if (snippetScrollDepthTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
        }
        return snippetScrollDepthTracker2;
    }

    @NotNull
    public final SubscribableStore<SearchMapState, ? super MapAction> getStore() {
        SubscribableStore<SearchMapState, ? super MapAction> subscribableStore = this.store;
        if (subscribableStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        }
        return subscribableStore;
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
    public final ApplicationStartupTasksRegistry getTasksRegistry() {
        ApplicationStartupTasksRegistry applicationStartupTasksRegistry = this.tasksRegistry;
        if (applicationStartupTasksRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tasksRegistry");
        }
        return applicationStartupTasksRegistry;
    }

    @NotNull
    public final ViewBinder getViewBinder() {
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        return viewBinder2;
    }

    @NotNull
    public final SearchMapViewFactory getViewFactory() {
        SearchMapViewFactory searchMapViewFactory = this.viewFactory;
        if (searchMapViewFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewFactory");
        }
        return searchMapViewFactory;
    }

    @NotNull
    public final WitcherItemPresenter getWitcherItemPresenter() {
        WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
        if (witcherItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
        }
        return witcherItemPresenter2;
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void leaveScreen() {
        FragmentManager fragmentManager = getFragmentManager();
        if ((fragmentManager != null ? fragmentManager.getBackStackEntryCount() : 0) >= 1) {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getFiltersWithoutActivity().invoke().booleanValue()) {
                Features features3 = this.features;
                if (features3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("features");
                }
                if (features3.getFiltersWithoutActivityForSearchMap().invoke().booleanValue()) {
                    finish();
                    return;
                }
            }
            FragmentManager fragmentManager2 = getFragmentManager();
            if (fragmentManager2 != null) {
                fragmentManager2.popBackStackImmediate();
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof UpNavigationHandler) {
            ((UpNavigationHandler) activity).handleUpNavigation();
        } else if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Parcelable successAuthResultData;
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && i2 == -1 && (successAuthResultData = AuthIntentFactoryKt.getSuccessAuthResultData(intent)) != null) {
                    ViewBinder viewBinder2 = this.viewBinder;
                    if (viewBinder2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
                    }
                    viewBinder2.getStore().dispatch(new MapViewAction.SuccessAuthForPhoneRequest(successAuthResultData));
                }
            } else if (i2 == -1 && intent != null) {
                NavigationMiddleware navigationMiddleware2 = this.navigationMiddleware;
                if (navigationMiddleware2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationMiddleware");
                }
                navigationMiddleware2.attachRouter(this);
                clarifySearchByDeeplink(new FilterCommons().getResult(intent));
                ViewBinder viewBinder3 = this.viewBinder;
                if (viewBinder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
                }
                viewBinder3.getStore().dispatch(MapViewAction.MapSettledFirstTime.INSTANCE);
            }
        } else if (i2 == -1) {
            NavigationMiddleware navigationMiddleware3 = this.navigationMiddleware;
            if (navigationMiddleware3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationMiddleware");
            }
            navigationMiddleware3.attachRouter(this);
            ViewBinder viewBinder4 = this.viewBinder;
            if (viewBinder4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
            }
            viewBinder4.getStore().dispatch(MapViewAction.SearchSubscriptionButtonClicked.INSTANCE);
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        String categoryId = viewBinder2.getStore().getState().getSearchParams().getCategoryId();
        SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
        if (searchMapAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        searchMapAnalyticsInteractor.sendClickBack(categoryId, false);
        ViewBinder viewBinder3 = this.viewBinder;
        if (viewBinder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        SearchMapState state = viewBinder3.getStore().getState();
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getNewMapBackNavigation().invoke().booleanValue()) {
            return false;
        }
        ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup = this.backNavigationTestGroup;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backNavigationTestGroup");
        }
        manuallyExposedAbTestGroup.expose();
        ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup2 = this.backNavigationTestGroup;
        if (manuallyExposedAbTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backNavigationTestGroup");
        }
        if (!manuallyExposedAbTestGroup2.getTestGroup().isTest()) {
            return false;
        }
        if (!Intrinsics.areEqual(state.getSerpState().getPanelState(), PanelStateKt.PANEL_EXPANDED) && !CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{PanelStateKt.PANEL_EXPANDED, PanelStateKt.PANEL_COLLAPSED}).contains(state.getPinAdvertsState().getPanelState())) {
            return false;
        }
        this.k.accept(Unit.INSTANCE);
        return true;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        SearchMapState searchMapState;
        TreeClickStreamParent treeClickStreamParent;
        Kundle kundle;
        super.onCreate(bundle);
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
        if (storeFragment == null) {
            getChildFragmentManager().beginTransaction().add(new StoreFragment(), "store_fragment").commit();
        }
        Bundle arguments = getArguments();
        Factory.Arguments arguments2 = arguments != null ? (Factory.Arguments) arguments.getParcelable("arguments") : null;
        if (arguments2 != null) {
            Factory.Arguments arguments3 = (bundle == null || (kundle = Bundles.getKundle(bundle, "state")) == null) ? null : (Factory.Arguments) kundle.getParcelable("state_value");
            if (arguments3 != null) {
                arguments2 = arguments3;
            }
            StoreFragment.State state$map_release = storeFragment != null ? storeFragment.getState$map_release() : null;
            Kundle advertXlState$map_release = state$map_release != null ? state$map_release.getAdvertXlState$map_release() : null;
            Kundle advertRichState$map_release = state$map_release != null ? state$map_release.getAdvertRichState$map_release() : null;
            Kundle inlineFiltersState$map_release = state$map_release != null ? state$map_release.getInlineFiltersState$map_release() : null;
            Kundle witcherState$map_release = state$map_release != null ? state$map_release.getWitcherState$map_release() : null;
            Kundle savedSearchesPresenterState$map_release = state$map_release != null ? state$map_release.getSavedSearchesPresenterState$map_release() : null;
            SnippetScrollDepthTracker.State snippetScrollDepthTrackerState$map_release = state$map_release != null ? state$map_release.getSnippetScrollDepthTrackerState$map_release() : null;
            Timer B1 = a2.b.a.a.a.B1();
            SearchMapComponent.Builder searchMapDependencies = DaggerSearchMapComponent.builder().searchMapDependencies((SearchMapDependencies) ComponentDependenciesKt.getDependencies(SearchMapDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SearchMapComponent.Builder screen = searchMapDependencies.withActivity(requireActivity).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screen(SearchMapScreen.INSTANCE);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            SearchMapComponent.Builder withWitcherSavedState = screen.withResources(resources).withFragment(this).withArguments(arguments2).withWitcherSavedState(witcherState$map_release);
            SearchMapState searchMapState$map_release = state$map_release != null ? state$map_release.getSearchMapState$map_release() : null;
            if (searchMapState$map_release != null) {
                SearchMapState.SerpState serpState = searchMapState$map_release.getSerpState();
                LoadState loadState = searchMapState$map_release.getSerpState().getLoadState();
                LoadState loadState2 = LoadState.LOADING;
                if (loadState == loadState2) {
                    loadState = LoadState.NONE;
                }
                AppendingState appendingState = searchMapState$map_release.getSerpState().getAppendingState();
                if (appendingState == AppendingState.LOADING) {
                    appendingState = AppendingState.NONE;
                }
                LoadState subscribeLoadState = searchMapState$map_release.getSerpState().getSubscribeLoadState();
                if (subscribeLoadState == loadState2) {
                    subscribeLoadState = LoadState.NONE;
                }
                searchMapState = SearchMapState.copy$default(searchMapState$map_release, null, null, null, null, null, SearchMapState.SerpState.copy$default(serpState, loadState, appendingState, false, null, null, null, null, 0, null, null, false, subscribeLoadState, false, 0, 0, false, null, null, null, 522236, null), null, false, false, 479, null);
            } else {
                searchMapState = null;
            }
            SearchMapComponent.Builder withSavedSearchMapState = withWitcherSavedState.withSavedSearchMapState(searchMapState);
            if (state$map_release == null || (treeClickStreamParent = state$map_release.getTreeClickStreamParent$map_release()) == null) {
                treeClickStreamParent = arguments2.getTreeParent();
            }
            SearchMapComponent.Builder withItemVisibilityTrackerState = withSavedSearchMapState.withInitTreeClickStreamParent(treeClickStreamParent).withViewProvider(getView()).withMapZoomLevelBounds(new AvitoMapZoomLevel(1.0f, 19.0f)).withAdvertXlState(advertXlState$map_release).withRichGalleryState(advertRichState$map_release).withRichSnippetRecycledViewPool(new RecyclerView.RecycledViewPool()).withInlineFiltersState(inlineFiltersState$map_release).withSavedSearchesPresenterState(savedSearchesPresenterState$map_release).withItemVisibilityTrackerState(state$map_release != null ? state$map_release.getListItemVisibilityTrackerState$map_release() : null);
            FragmentManager requireFragmentManager = requireFragmentManager();
            Intrinsics.checkNotNullExpressionValue(requireFragmentManager, "requireFragmentManager()");
            SearchMapComponent.Builder bannerPageSource = withItemVisibilityTrackerState.withFragmentManager(requireFragmentManager).bannerPageSource(BannerPageSource.SERP);
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            SearchMapComponent.Builder snippetClick = bannerPageSource.snippetClick(create);
            PublishRelay create2 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
            SearchMapComponent.Builder snippetClose = snippetClick.snippetClose(create2);
            PublishRelay create3 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
            snippetClose.snippetVisibility(create3).withSerpOnboardingHandler(null).build().inject(this);
            SearchMapTracker searchMapTracker2 = this.searchMapTracker;
            if (searchMapTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
            }
            searchMapTracker2.trackDiInject(B1.elapsed());
            if (state$map_release == null && bundle != null) {
                SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
                if (searchMapAnalyticsInteractor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
                }
                searchMapAnalyticsInteractor.sendNotRestoreState();
            }
            if (snippetScrollDepthTrackerState$map_release != null) {
                SnippetScrollDepthTracker snippetScrollDepthTracker2 = this.snippetScrollDepthTracker;
                if (snippetScrollDepthTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
                }
                snippetScrollDepthTracker2.restoreState(snippetScrollDepthTrackerState$map_release);
            }
            ApplicationStartupTasksRegistry applicationStartupTasksRegistry = this.tasksRegistry;
            if (applicationStartupTasksRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tasksRegistry");
            }
            applicationStartupTasksRegistry.requireAtLeast(InitializeYandexMapsTask.class, ApplicationStartupTask.State.Scheduled.class);
            ApplicationStartupTasksRegistry applicationStartupTasksRegistry2 = this.tasksRegistry;
            if (applicationStartupTasksRegistry2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tasksRegistry");
            }
            applicationStartupTasksRegistry2.requireAtLeast(RegisterGeoPositionCheckingCallbacksTask.class, ApplicationStartupTask.State.Scheduled.class);
            return;
        }
        throw new IllegalArgumentException(("arguments should be provided to " + this).toString());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.search_map_view, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder2.unbind();
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        inlineFiltersPresenter2.detachViews();
        SavedSearchesPresenter savedSearchesPresenter2 = this.savedSearchesPresenter;
        if (savedSearchesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchesPresenter");
        }
        savedSearchesPresenter2.detachView();
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.detachView();
        SearchMapTracker searchMapTracker2 = this.searchMapTracker;
        if (searchMapTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
        }
        searchMapTracker2.destroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder2.getStore().dispatch(new ScreenExit());
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onPause();
        SearchMapTracker searchMapTracker2 = this.searchMapTracker;
        if (searchMapTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
        }
        searchMapTracker2.detach();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.unregisterLocationReceiver(requireContext);
        String c = c();
        if (c != null) {
            Location location = new Location(c, new CaseText(), false, false, false, false, null, false, null, null, 1020, null);
            SavedLocationInteractor savedLocationInteractor = this.locationInteractor;
            if (savedLocationInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
            }
            SavedLocationInteractor.DefaultImpls.saveLocation$default(savedLocationInteractor, location, LocationSource.LOCATION_FOR_SEARCH, false, 4, null);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String c = c();
        if (c != null) {
            SavedLocationInteractor savedLocationInteractor = this.locationInteractor;
            if (savedLocationInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
            }
            if (savedLocationInteractor.checkLocationForSearch(c)) {
                SavedLocationInteractor savedLocationInteractor2 = this.locationInteractor;
                if (savedLocationInteractor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
                }
                Location locationForSearch = savedLocationInteractor2.getLocationForSearch();
                if (locationForSearch != null) {
                    ViewBinder viewBinder2 = this.viewBinder;
                    if (viewBinder2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
                    }
                    viewBinder2.getStore().dispatch(new MapViewAction.UpdateSearchLocation(locationForSearch));
                }
            }
        }
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onResume();
        SearchMapTracker searchMapTracker2 = this.searchMapTracker;
        if (searchMapTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
        }
        searchMapTracker2.attach();
        super.onResume();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.registerLocationReceiver(requireContext);
        SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
        if (searchMapAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        searchMapAnalyticsInteractor.sendShowScreenEvent();
        SavedSearchesPresenter savedSearchesPresenter2 = this.savedSearchesPresenter;
        if (savedSearchesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchesPresenter");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter2.setPushEnabled(notificationManagerProvider2.getAreNotificationsEnabled());
        CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor2 = this.commercialBannersAnalyticsInteractor;
        if (commercialBannersAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commercialBannersAnalyticsInteractor");
        }
        commercialBannersAnalyticsInteractor2.returnToScreen();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
        if (storeFragment != null) {
            SubscribableStore<SearchMapState, ? super MapAction> subscribableStore = this.store;
            if (subscribableStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            }
            SearchMapState state = subscribableStore.getState();
            AdvertXlStateProvider advertXlStateProvider2 = this.advertXlStateProvider;
            if (advertXlStateProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertXlStateProvider");
            }
            Kundle onSaveState = advertXlStateProvider2.onSaveState();
            RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
            if (richSnippetStateProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
            }
            Kundle onSaveState2 = richSnippetStateProvider2.onSaveState();
            SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
            if (searchMapAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            TreeClickStreamParent savedParent = searchMapAnalyticsInteractor.getSavedParent();
            InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
            if (inlineFiltersPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
            }
            Kundle onSaveState3 = inlineFiltersPresenter2.onSaveState();
            WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
            if (witcherItemPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
            }
            Kundle onSaveState4 = witcherItemPresenter2.onSaveState();
            ItemVisibilityTracker itemVisibilityTracker = this.listItemVisibilityTracker;
            if (itemVisibilityTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listItemVisibilityTracker");
            }
            Bundle onSaveState5 = itemVisibilityTracker.onSaveState();
            SavedSearchesPresenter savedSearchesPresenter2 = this.savedSearchesPresenter;
            if (savedSearchesPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchesPresenter");
            }
            Kundle onSaveState6 = savedSearchesPresenter2.onSaveState();
            SnippetScrollDepthTracker snippetScrollDepthTracker2 = this.snippetScrollDepthTracker;
            if (snippetScrollDepthTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
            }
            storeFragment.setState$map_release(new StoreFragment.State(state, onSaveState, onSaveState2, savedParent, onSaveState3, onSaveState4, onSaveState5, onSaveState6, snippetScrollDepthTracker2.onSaveState()));
        }
        SubscribableStore<SearchMapState, ? super MapAction> subscribableStore2 = this.store;
        if (subscribableStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        }
        SearchMapState state2 = subscribableStore2.getState();
        SearchParams searchParams = state2.getSearchParams();
        Area area = state2.getSerpState().getArea();
        LatLngBounds initialMapBounds = state2.getMapState().getInitialMapBounds();
        Area area2 = initialMapBounds != null ? LatLngBoundsKt.toArea(initialMapBounds) : null;
        String panelState = state2.getSerpState().getPanelState();
        Float zoom = state2.getMapState().getZoom();
        SearchMapAnalyticsInteractor searchMapAnalyticsInteractor2 = this.analyticsInteractor;
        if (searchMapAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        Bundles.putKundle(bundle, "state", new Kundle().putParcelable("state_value", new Factory.Arguments(searchParams, null, area, area2, panelState, zoom, searchMapAnalyticsInteractor2.getSavedParent(), state2.getShowSimpleMap())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NavigationMiddleware navigationMiddleware2 = this.navigationMiddleware;
        if (navigationMiddleware2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationMiddleware");
        }
        navigationMiddleware2.attachRouter(this);
        ViewBinder viewBinder2 = this.viewBinder;
        if (viewBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder2.getStore().dispatch(new UpdateViewedPinsAction());
        ViewBinder viewBinder3 = this.viewBinder;
        if (viewBinder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        }
        viewBinder3.getStore().dispatch(new CheckZoomButtonsStateAction());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        PageParams pageParams;
        NavigationMiddleware navigationMiddleware2 = this.navigationMiddleware;
        if (navigationMiddleware2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationMiddleware");
        }
        navigationMiddleware2.detachRouter();
        SubscribableStore<SearchMapState, ? super MapAction> subscribableStore = this.store;
        if (subscribableStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        }
        String xHash = subscribableStore.getState().getSerpState().getXHash();
        SubscribableStore<SearchMapState, ? super MapAction> subscribableStore2 = this.store;
        if (subscribableStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        }
        SerpKey key = subscribableStore2.getState().getSerpState().getKey();
        Integer valueOf = (key == null || (pageParams = key.getPageParams()) == null) ? null : Integer.valueOf(pageParams.getPage());
        SnippetScrollDepthTracker snippetScrollDepthTracker2 = this.snippetScrollDepthTracker;
        if (snippetScrollDepthTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
        }
        if (!(!snippetScrollDepthTracker2.hasNewDataFromLastEventSent() || xHash == null || valueOf == null)) {
            SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor2 = this.snippetScrollDepthAnalyticsInteractor;
            if (snippetScrollDepthAnalyticsInteractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthAnalyticsInteractor");
            }
            int intValue = valueOf.intValue();
            SnippetScrollDepthTracker snippetScrollDepthTracker3 = this.snippetScrollDepthTracker;
            if (snippetScrollDepthTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
            }
            List<String> advertItemsIds = snippetScrollDepthTracker3.getAdvertItemsIds();
            SnippetScrollDepthTracker snippetScrollDepthTracker4 = this.snippetScrollDepthTracker;
            if (snippetScrollDepthTracker4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
            }
            int advertsItemCount = snippetScrollDepthTracker4.getAdvertsItemCount();
            SnippetScrollDepthTracker snippetScrollDepthTracker5 = this.snippetScrollDepthTracker;
            if (snippetScrollDepthTracker5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
            }
            snippetScrollDepthAnalyticsInteractor2.sendUserScrolledToItemOnSerp(intValue, advertItemsIds, advertsItemCount, xHash, snippetScrollDepthTracker5.getTotalItemsCount());
            SnippetScrollDepthTracker snippetScrollDepthTracker6 = this.snippetScrollDepthTracker;
            if (snippetScrollDepthTracker6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snippetScrollDepthTracker");
            }
            snippetScrollDepthTracker6.onAnalyticsEventWasSent();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.attachView(new AsyncPhoneViewImpl(view));
        SavedSearchesPresenter savedSearchesPresenter2 = this.savedSearchesPresenter;
        if (savedSearchesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchesPresenter");
        }
        SavedSearchViewImpl savedSearchViewImpl = new SavedSearchViewImpl(view);
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter2.attachView(savedSearchViewImpl, notificationManagerProvider2.getAreNotificationsEnabled());
        if (getContext() != null) {
            SearchMapTracker searchMapTracker2 = this.searchMapTracker;
            if (searchMapTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
            }
            searchMapTracker2.startInit();
            ViewBinder viewBinder2 = this.viewBinder;
            if (viewBinder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
            }
            SearchMapViewFactory searchMapViewFactory = this.viewFactory;
            if (searchMapViewFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewFactory");
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            PublishRelay<Unit> publishRelay = this.k;
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            SearchMapView createView = searchMapViewFactory.createView(view, childFragmentManager, publishRelay, features2);
            SearchMapViewFactory searchMapViewFactory2 = this.viewFactory;
            if (searchMapViewFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewFactory");
            }
            PinAdvertsView createPinAdvertsView = searchMapViewFactory2.createPinAdvertsView(view);
            SearchMapViewFactory searchMapViewFactory3 = this.viewFactory;
            if (searchMapViewFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewFactory");
            }
            FpsStateSupplier fpsStateSupplier = this.supplier;
            if (fpsStateSupplier == null) {
                Intrinsics.throwUninitializedPropertyAccessException("supplier");
            }
            viewBinder2.bind(createView, createPinAdvertsView, searchMapViewFactory3.createSerpListView(view, fpsStateSupplier));
            SearchMapTracker searchMapTracker3 = this.searchMapTracker;
            if (searchMapTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchMapTracker");
            }
            searchMapTracker3.trackInit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        NavigationTab currentTab = currentTab();
        if (currentTab != null) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof OnAddButtonStateChangeListener)) {
                activity = null;
            }
            OnAddButtonStateChangeListener onAddButtonStateChangeListener = (OnAddButtonStateChangeListener) activity;
            if (onAddButtonStateChangeListener != null) {
                onAddButtonStateChangeListener.onAddButtonStateChange(currentTab, AddButtonState.SMALL);
            }
        }
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), ScreenSource.SERP.INSTANCE, 512, null));
    }

    public final void setAdvertXlStateProvider(@NotNull AdvertXlStateProvider advertXlStateProvider2) {
        Intrinsics.checkNotNullParameter(advertXlStateProvider2, "<set-?>");
        this.advertXlStateProvider = advertXlStateProvider2;
    }

    public final void setAnalyticsInteractor(@NotNull SearchMapAnalyticsInteractor searchMapAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(searchMapAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = searchMapAnalyticsInteractor;
    }

    public final void setAsyncPhonePresenter(@NotNull AsyncPhonePresenter asyncPhonePresenter2) {
        Intrinsics.checkNotNullParameter(asyncPhonePresenter2, "<set-?>");
        this.asyncPhonePresenter = asyncPhonePresenter2;
    }

    public final void setBackNavigationTestGroup(@NotNull ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "<set-?>");
        this.backNavigationTestGroup = manuallyExposedAbTestGroup;
    }

    public final void setCommercialBannersAnalyticsInteractor(@NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor2) {
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor2, "<set-?>");
        this.commercialBannersAnalyticsInteractor = commercialBannersAnalyticsInteractor2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setErrorFormatter(@NotNull Formatter<Throwable> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.errorFormatter = formatter;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFindLocationPresenter(@NotNull FindLocationPresenter findLocationPresenter2) {
        Intrinsics.checkNotNullParameter(findLocationPresenter2, "<set-?>");
        this.findLocationPresenter = findLocationPresenter2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setInlineFiltersPresenter(@NotNull InlineFiltersPresenter inlineFiltersPresenter2) {
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter2, "<set-?>");
        this.inlineFiltersPresenter = inlineFiltersPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setJustDialSellerPhoneTestGroup(@NotNull AbTestGroup<SimpleTestGroupWithControl2> abTestGroup) {
        Intrinsics.checkNotNullParameter(abTestGroup, "<set-?>");
        this.justDialSellerPhoneTestGroup = abTestGroup;
    }

    public final void setListItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker) {
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "<set-?>");
        this.listItemVisibilityTracker = itemVisibilityTracker;
    }

    public final void setLocationInteractor(@NotNull SavedLocationInteractor savedLocationInteractor) {
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "<set-?>");
        this.locationInteractor = savedLocationInteractor;
    }

    public final void setNavigationMiddleware(@NotNull NavigationMiddleware navigationMiddleware2) {
        Intrinsics.checkNotNullParameter(navigationMiddleware2, "<set-?>");
        this.navigationMiddleware = navigationMiddleware2;
    }

    public final void setNotificationManagerProvider(@NotNull NotificationManagerProvider notificationManagerProvider2) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider2, "<set-?>");
        this.notificationManagerProvider = notificationManagerProvider2;
    }

    public final void setPhoneNumberFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneNumberFormatter = formatter;
    }

    public final void setRichSnippetStateProvider(@NotNull RichSnippetStateProvider richSnippetStateProvider2) {
        Intrinsics.checkNotNullParameter(richSnippetStateProvider2, "<set-?>");
        this.richSnippetStateProvider = richSnippetStateProvider2;
    }

    public final void setSavedSearchesPresenter(@NotNull SavedSearchesPresenter savedSearchesPresenter2) {
        Intrinsics.checkNotNullParameter(savedSearchesPresenter2, "<set-?>");
        this.savedSearchesPresenter = savedSearchesPresenter2;
    }

    public final void setSearchMapTracker(@NotNull SearchMapTracker searchMapTracker2) {
        Intrinsics.checkNotNullParameter(searchMapTracker2, "<set-?>");
        this.searchMapTracker = searchMapTracker2;
    }

    public final void setSerpCacheInteractor(@NotNull SerpCacheInteractor serpCacheInteractor2) {
        Intrinsics.checkNotNullParameter(serpCacheInteractor2, "<set-?>");
        this.serpCacheInteractor = serpCacheInteractor2;
    }

    public final void setSnippetScrollDepthAnalyticsInteractor(@NotNull SnippetScrollDepthAnalyticsInteractor snippetScrollDepthAnalyticsInteractor2) {
        Intrinsics.checkNotNullParameter(snippetScrollDepthAnalyticsInteractor2, "<set-?>");
        this.snippetScrollDepthAnalyticsInteractor = snippetScrollDepthAnalyticsInteractor2;
    }

    public final void setSnippetScrollDepthTracker(@NotNull SnippetScrollDepthTracker snippetScrollDepthTracker2) {
        Intrinsics.checkNotNullParameter(snippetScrollDepthTracker2, "<set-?>");
        this.snippetScrollDepthTracker = snippetScrollDepthTracker2;
    }

    public final void setStore(@NotNull SubscribableStore<SearchMapState, ? super MapAction> subscribableStore) {
        Intrinsics.checkNotNullParameter(subscribableStore, "<set-?>");
        this.store = subscribableStore;
    }

    public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
        this.supplier = fpsStateSupplier;
    }

    public final void setTasksRegistry(@NotNull ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "<set-?>");
        this.tasksRegistry = applicationStartupTasksRegistry;
    }

    public final void setViewBinder(@NotNull ViewBinder viewBinder2) {
        Intrinsics.checkNotNullParameter(viewBinder2, "<set-?>");
        this.viewBinder = viewBinder2;
    }

    public final void setViewFactory(@NotNull SearchMapViewFactory searchMapViewFactory) {
        Intrinsics.checkNotNullParameter(searchMapViewFactory, "<set-?>");
        this.viewFactory = searchMapViewFactory;
    }

    public final void setWitcherItemPresenter(@NotNull WitcherItemPresenter witcherItemPresenter2) {
        Intrinsics.checkNotNullParameter(witcherItemPresenter2, "<set-?>");
        this.witcherItemPresenter = witcherItemPresenter2;
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showApplicationPermissionsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showAuth(@NotNull NavigationMiddleware.Router.Reason reason, @Nullable Parcelable parcelable) {
        Pair pair;
        Intrinsics.checkNotNullParameter(reason, "reason");
        int ordinal = reason.ordinal();
        if (ordinal == 0) {
            pair = TuplesKt.to(1, "s");
        } else if (ordinal != 1) {
            throw new NoWhenBranchMatchedException();
        } else if (parcelable != null) {
            pair = TuplesKt.to(3, AuthSource.PHONE_REQUEST);
        } else {
            return;
        }
        int intValue = ((Number) pair.component1()).intValue();
        String str = (String) pair.component2();
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, str, parcelable, 1, null), intValue);
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showCallDialog(@NotNull PhoneLink phoneLink, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(phoneLink, "link");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        AbTestGroup<SimpleTestGroupWithControl2> abTestGroup = this.justDialSellerPhoneTestGroup;
        if (abTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("justDialSellerPhoneTestGroup");
        }
        if (!abTestGroup.getTestGroup().isTest()) {
            d(phoneLink, str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, z);
        } else if (dialPhone(phoneLink)) {
            SearchMapAnalyticsInteractor searchMapAnalyticsInteractor = this.analyticsInteractor;
            if (searchMapAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            searchMapAnalyticsInteractor.sendShowPhoneDialer(str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, true);
        } else {
            SearchMapAnalyticsInteractor searchMapAnalyticsInteractor2 = this.analyticsInteractor;
            if (searchMapAnalyticsInteractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            searchMapAnalyticsInteractor2.sendShowPhoneDialer(str, PhonePageSourceKt.PHONE_SOURCE_BUTTON, false);
            d(phoneLink, str, "error", z);
        }
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showErrorMessage(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Context context = getContext();
        if (context != null) {
            Formatter<Throwable> formatter = this.errorFormatter;
            if (formatter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
            }
            ToastsKt.showToast$default(context, formatter.format(th), 0, 2, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showFiltersScreen(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.SearchParams r14, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.search.map.Area r15, @org.jetbrains.annotations.NotNull java.lang.String r16, boolean r17) {
        /*
            r13 = this;
            r0 = r13
            java.lang.String r1 = "searchParams"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "mapSerpState"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            com.avito.android.Features r1 = r0.features
            java.lang.String r12 = "features"
            if (r1 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
        L_0x0017:
            com.avito.android.toggle.Feature r1 = r1.getFiltersWithoutActivity()
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0043
            com.avito.android.Features r1 = r0.features
            if (r1 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
        L_0x002e:
            com.avito.android.toggle.Feature r1 = r1.getFiltersWithoutActivityForSearchMap()
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0043
            com.avito.android.bottom_navigation.NavigationTab r1 = r13.currentTab()
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            r8 = r1
            com.avito.android.ActivityIntentFactory r2 = r0.intentFactory
            if (r2 != 0) goto L_0x004e
            java.lang.String r1 = "intentFactory"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x004e:
            r6 = 0
            r7 = 0
            r10 = 24
            r11 = 0
            r3 = r14
            r4 = r15
            r5 = r16
            r9 = r17
            android.content.Intent r1 = com.avito.android.FiltersIntentFactory.DefaultImpls.searchIntent$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.avito.android.Features r2 = r0.features
            if (r2 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
        L_0x0064:
            com.avito.android.toggle.Feature r2 = r2.getFiltersWithoutActivity()
            java.lang.Object r2 = r2.invoke()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 2
            if (r2 == 0) goto L_0x0090
            com.avito.android.Features r2 = r0.features
            if (r2 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
        L_0x007c:
            com.avito.android.toggle.Feature r2 = r2.getFiltersWithoutActivityForSearchMap()
            java.lang.Object r2 = r2.invoke()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0090
            r13.startForResult(r1, r3)
            goto L_0x0093
        L_0x0090:
            r13.startActivityForResult(r1, r3)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.SearchMapFragment.showFiltersScreen(com.avito.android.remote.model.SearchParams, com.avito.android.remote.model.search.map.Area, java.lang.String, boolean):void");
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showNotificationSettingsScreen() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void showToastMessage(int i) {
        CharSequence text = getText(i);
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(text, "it");
            ToastsKt.showToast$default(context, text, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink, null);
    }
}
