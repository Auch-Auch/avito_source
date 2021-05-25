package com.avito.android.home;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.Features;
import com.avito.android.FiltersIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShowHomeScreenEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.HomeScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.analytics.sideload.SideloadDelegate;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiverKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerHomeComponent;
import com.avito.android.di.component.HomeComponent;
import com.avito.android.di.component.HomeDependencies;
import com.avito.android.di.component.SerpDependencies;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.filter.FilterCommons;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.HomePresenter;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.default_search_location.DefaultSearchLocationInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.rec.ScreenSource;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.R;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.stories.StoriesActivityKt;
import com.avito.android.suggest_locations.OpenEventFromBlock;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Constants;
import com.avito.android.util.IntentHandler;
import com.avito.android.util.Intents;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedDestroyable;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002µ\u0002B\b¢\u0006\u0005\b´\u0002\u0010$J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010$J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0015H\u0016¢\u0006\u0004\b(\u0010\u0018J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010$J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010$J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J!\u00102\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00104\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b4\u0010\rJ_\u0010@\u001a\u00020\u000b2\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u00010/2\u0006\u00109\u001a\u00020/2\b\u0010:\u001a\u0004\u0018\u00010/2\b\u0010;\u001a\u0004\u0018\u00010/2\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ#\u0010D\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bF\u0010GJ-\u0010L\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020/2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020/0I2\u0006\u0010K\u001a\u00020/H\u0016¢\u0006\u0004\bL\u0010MJ)\u0010N\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\bN\u0010\u0014J\u0019\u0010O\u001a\u00020>2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u0011H\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u000bH\u0016¢\u0006\u0004\bT\u0010$J\u0017\u0010W\u001a\u00020>2\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0000@\u0000X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR+\u0010v\u001a\u00020n2\u0006\u0010o\u001a\u00020n8B@BX\u0002¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R*\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R*\u0010¬\u0001\u001a\u00030«\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R*\u0010³\u0001\u001a\u00030²\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R*\u0010º\u0001\u001a\u00030¹\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R*\u0010Á\u0001\u001a\u00030À\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R*\u0010È\u0001\u001a\u00030Ç\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R*\u0010Ï\u0001\u001a\u00030Î\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R*\u0010Ö\u0001\u001a\u00030Õ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R*\u0010Ý\u0001\u001a\u00030Ü\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R*\u0010ä\u0001\u001a\u00030ã\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R*\u0010ë\u0001\u001a\u00030ê\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R*\u0010ò\u0001\u001a\u00030ñ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R*\u0010ù\u0001\u001a\u00030ø\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R*\u0010\u0002\u001a\u00030ÿ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010 \u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b \u0002\u0010¡\u0002\u001a\u0006\b¢\u0002\u0010£\u0002\"\u0006\b¤\u0002\u0010¥\u0002R*\u0010§\u0002\u001a\u00030¦\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b§\u0002\u0010¨\u0002\u001a\u0006\b©\u0002\u0010ª\u0002\"\u0006\b«\u0002\u0010¬\u0002R*\u0010®\u0002\u001a\u00030­\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b®\u0002\u0010¯\u0002\u001a\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002¨\u0006¶\u0002"}, d2 = {"Lcom/avito/android/home/HomeFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/home/HomePresenter$Router;", "Lcom/avito/android/util/IntentHandler;", "Lcom/avito/android/ui/ActivityInteractor;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "c", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "d", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onStart", "outState", "onSaveInstanceState", "onStop", "onDestroyView", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "showClarifyScreen", "(Lcom/avito/android/remote/model/SearchParams;)V", "", "locationId", "geoSessionId", "showLocationsListScreen", "(Ljava/lang/String;Ljava/lang/String;)V", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "itemId", "feedId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "Lcom/avito/android/remote/model/Location;", "location", "showAllCategories", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "showSearchScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "url", "", "stories", "storyId", "openStory", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "onActivityResult", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "intent", "handleIntent", "(Landroid/content/Intent;)V", "scrollToUp", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "Lcom/avito/android/home/HomePresenter;", "presenter", "Lcom/avito/android/home/HomePresenter;", "getPresenter", "()Lcom/avito/android/home/HomePresenter;", "setPresenter", "(Lcom/avito/android/home/HomePresenter;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartFabQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartFabQuantityHandler$serp_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartFabQuantityHandler$serp_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/home/HomeView;", "<set-?>", "j", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedDestroyable;", "getHomeView", "()Lcom/avito/android/home/HomeView;", "setHomeView", "(Lcom/avito/android/home/HomeView;)V", "homeView", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$serp_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$serp_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "l", "Z", "isStarted", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "advertItemActionsPresenter", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "getAdvertItemActionsPresenter", "()Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "setAdvertItemActionsPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;)V", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;)V", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "homeSkeletonTestGroup", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "getHomeSkeletonTestGroup", "()Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "setHomeSkeletonTestGroup", "(Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;)V", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "witcherItemPresenter", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "getWitcherItemPresenter", "()Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "setWitcherItemPresenter", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;)V", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "defaultSearchLocationInteractor", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "getDefaultSearchLocationInteractor", "()Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;", "setDefaultSearchLocationInteractor", "(Lcom/avito/android/home/default_search_location/DefaultSearchLocationInteractor;)V", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "getFloatingViewsPresenter", "()Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "setFloatingViewsPresenter", "(Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;)V", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "resourceProvider", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "getResourceProvider", "()Lcom/avito/android/home/HomePresenterResourcesProvider;", "setResourceProvider", "(Lcom/avito/android/home/HomePresenterResourcesProvider;)V", "Lcom/avito/android/home/HomeInteractor;", "interactor", "Lcom/avito/android/home/HomeInteractor;", "getInteractor", "()Lcom/avito/android/home/HomeInteractor;", "setInteractor", "(Lcom/avito/android/home/HomeInteractor;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "defaultLocationPresenter", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "getDefaultLocationPresenter", "()Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "setDefaultLocationPresenter", "(Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Lcom/avito/android/home/analytics/HomeTracker;", "tracker", "Lcom/avito/android/home/analytics/HomeTracker;", "getTracker", "()Lcom/avito/android/home/analytics/HomeTracker;", "setTracker", "(Lcom/avito/android/home/analytics/HomeTracker;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "networkInfoBroadcastReceiver", "Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "getNetworkInfoBroadcastReceiver", "()Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "setNetworkInfoBroadcastReceiver", "(Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "getDefaultLocationInteractor", "()Lcom/avito/android/location/find/DefaultLocationInteractor;", "setDefaultLocationInteractor", "(Lcom/avito/android/location/find/DefaultLocationInteractor;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "homeNewRubricatorTestGroup", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "getHomeNewRubricatorTestGroup", "()Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "setHomeNewRubricatorTestGroup", "(Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "StoreFragment", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeFragment extends TabBaseFragment implements HomePresenter.Router, IntentHandler, ActivityInteractor, ScrollToUpHandler, TabRootFragment {
    public static final /* synthetic */ KProperty[] m = {a2.b.a.a.a.u0(HomeFragment.class, "homeView", "getHomeView()Lcom/avito/android/home/HomeView;", 0)};
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public AdvertItemActionsPresenter advertItemActionsPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public HomeAnalyticsInteractor analyticsInteractor;
    @Inject
    public CartQuantityChangesHandler cartFabQuantityHandler;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DefaultLocationInteractor defaultLocationInteractor;
    @Inject
    public DefaultSearchLocationPresenter defaultLocationPresenter;
    @Inject
    public DefaultSearchLocationInteractor defaultSearchLocationInteractor;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public Features features;
    @Inject
    public PersistableFloatingViewsPresenter floatingViewsPresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public HomeNewRubricatorTestGroup homeNewRubricatorTestGroup;
    @Inject
    public HomeSkeletonTestGroup homeSkeletonTestGroup;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public HomeInteractor interactor;
    @Inject
    public ItemVisibilityTracker itemVisibilityTracker;
    public final AutoClearedDestroyable j = new AutoClearedDestroyable();
    public final Handler k = new Handler();
    public boolean l;
    @Inject
    public NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver;
    @Inject
    public HomePresenter presenter;
    @Inject
    public HomePresenterResourcesProvider resourceProvider;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public FpsStateSupplier supplier;
    @Inject
    public HomeTracker tracker;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;
    @Inject
    public WitcherItemPresenter witcherItemPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/home/HomeFragment$StoreFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/home/HomePresenterState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/home/HomePresenterState;", "getState$serp_release", "()Lcom/avito/android/home/HomePresenterState;", "setState$serp_release", "(Lcom/avito/android/home/HomePresenterState;)V", "state", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class StoreFragment extends Fragment {
        @Nullable
        public HomePresenterState a;

        @Nullable
        public final HomePresenterState getState$serp_release() {
            return this.a;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public final void setState$serp_release(@Nullable HomePresenterState homePresenterState) {
            this.a = homePresenterState;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ HomeFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public a(HomeFragment homeFragment, int i, int i2, Intent intent) {
            this.a = homeFragment;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d(this.b, this.c, this.d);
        }
    }

    public final void c(DeepLink deepLink, TreeClickStreamParent treeClickStreamParent) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            Intents.putCalledFromExtra(intent, "search");
            IntentsKt.replaceCalledFromIfRequired(intent, "search");
            if (treeClickStreamParent != null) {
                Intents.putTreeAnalyticsParent(intent, treeClickStreamParent);
            }
            startActivity(intent);
        }
    }

    public final void d(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z = i2 == -1;
        if (i != 2) {
            if (i == 3) {
                Location location = intent != null ? (Location) intent.getParcelableExtra("location") : null;
                if (z) {
                    DefaultSearchLocationPresenter defaultSearchLocationPresenter = this.defaultLocationPresenter;
                    if (defaultSearchLocationPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("defaultLocationPresenter");
                    }
                    defaultSearchLocationPresenter.onDefaultLocationChanged(location);
                }
            } else if (i != 4) {
                super.onActivityResult(i, i2, intent);
            } else if (intent != null && (stringExtra = intent.getStringExtra(StoriesActivityKt.KEY_LAST_VIEWED_STORY_ID)) != null) {
                HomePresenter homePresenter = this.presenter;
                if (homePresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                homePresenter.updateCurrentStoryId(stringExtra);
            }
        } else if (z && intent != null) {
            DeepLink result = new FilterCommons().getResult(intent);
            HomePresenter homePresenter2 = this.presenter;
            if (homePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            homePresenter2.onSearchClarified(result);
        }
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        c(deepLink, null);
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
    }

    @NotNull
    public final AdvertItemActionsPresenter getAdvertItemActionsPresenter() {
        AdvertItemActionsPresenter advertItemActionsPresenter2 = this.advertItemActionsPresenter;
        if (advertItemActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertItemActionsPresenter");
        }
        return advertItemActionsPresenter2;
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
    public final HomeAnalyticsInteractor getAnalyticsInteractor() {
        HomeAnalyticsInteractor homeAnalyticsInteractor = this.analyticsInteractor;
        if (homeAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return homeAnalyticsInteractor;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartFabQuantityHandler$serp_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartFabQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$serp_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
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
    public final DefaultLocationInteractor getDefaultLocationInteractor() {
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        return defaultLocationInteractor2;
    }

    @NotNull
    public final DefaultSearchLocationPresenter getDefaultLocationPresenter() {
        DefaultSearchLocationPresenter defaultSearchLocationPresenter = this.defaultLocationPresenter;
        if (defaultSearchLocationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationPresenter");
        }
        return defaultSearchLocationPresenter;
    }

    @NotNull
    public final DefaultSearchLocationInteractor getDefaultSearchLocationInteractor() {
        DefaultSearchLocationInteractor defaultSearchLocationInteractor2 = this.defaultSearchLocationInteractor;
        if (defaultSearchLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultSearchLocationInteractor");
        }
        return defaultSearchLocationInteractor2;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getDestroyableViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        return destroyableViewHolderBuilder2;
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
    public final PersistableFloatingViewsPresenter getFloatingViewsPresenter() {
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        return persistableFloatingViewsPresenter;
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
    public final HomeNewRubricatorTestGroup getHomeNewRubricatorTestGroup() {
        HomeNewRubricatorTestGroup homeNewRubricatorTestGroup2 = this.homeNewRubricatorTestGroup;
        if (homeNewRubricatorTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeNewRubricatorTestGroup");
        }
        return homeNewRubricatorTestGroup2;
    }

    @NotNull
    public final HomeSkeletonTestGroup getHomeSkeletonTestGroup() {
        HomeSkeletonTestGroup homeSkeletonTestGroup2 = this.homeSkeletonTestGroup;
        if (homeSkeletonTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSkeletonTestGroup");
        }
        return homeSkeletonTestGroup2;
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
    public final HomeInteractor getInteractor() {
        HomeInteractor homeInteractor = this.interactor;
        if (homeInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return homeInteractor;
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
    public final NetworkInfoBroadcastReceiver getNetworkInfoBroadcastReceiver() {
        NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
        if (networkInfoBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
        }
        return networkInfoBroadcastReceiver2;
    }

    @NotNull
    public final HomePresenter getPresenter() {
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return homePresenter;
    }

    @NotNull
    public final HomePresenterResourcesProvider getResourceProvider() {
        HomePresenterResourcesProvider homePresenterResourcesProvider = this.resourceProvider;
        if (homePresenterResourcesProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return homePresenterResourcesProvider;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
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
    public final HomeTracker getTracker() {
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return homeTracker;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @NotNull
    public final WitcherItemPresenter getWitcherItemPresenter() {
        WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
        if (witcherItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
        }
        return witcherItemPresenter2;
    }

    @Override // com.avito.android.util.IntentHandler
    public void handleIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(Constants.ACTION_RESULT_MESSAGE);
        if (stringExtra != null) {
            HomePresenter homePresenter = this.presenter;
            if (homePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            homePresenter.onActionResultReceived(stringExtra);
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return Intrinsics.areEqual(navigationTabSetItem, NavigationTab.SEARCH.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.l) {
            d(i, i2, intent);
        } else {
            this.k.post(new a(this, i, i2, intent));
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new ShowHomeScreenEvent());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        homeTracker.startInit();
        try {
            HomeNewRubricatorTestGroup homeNewRubricatorTestGroup2 = this.homeNewRubricatorTestGroup;
            if (homeNewRubricatorTestGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeNewRubricatorTestGroup");
            }
            if (homeNewRubricatorTestGroup2.isTest()) {
                i = R.layout.home_fragment_with_rubricator;
            } else {
                i = R.layout.home_fragment;
            }
            View inflate = layoutInflater.inflate(i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(layoutId, container, false)");
            return inflate;
        } catch (Exception e) {
            Context context = getContext();
            Context applicationContext = context != null ? context.getApplicationContext() : null;
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            Application application = (Application) applicationContext;
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            SideloadDelegate.catchException$default(new SideloadDelegate(application, analytics2), this, "onCreateView", null, e, 4, null);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter.detachView();
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter.detachAll();
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        AdvertItemActionsPresenter advertItemActionsPresenter2 = this.advertItemActionsPresenter;
        if (advertItemActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertItemActionsPresenter");
        }
        advertItemActionsPresenter2.detachView();
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        homeTracker.destroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        defaultLocationInteractor2.unregisterLocationReceiver(requireContext);
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter.onPause();
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onPause();
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        homeTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        defaultLocationInteractor2.registerLocationReceiver(requireContext);
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onResume();
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        homeTracker.attach();
        super.onResume();
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter.onResume();
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
        HomeInteractor homeInteractor = this.interactor;
        if (homeInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("interactor_state", homeInteractor.onSaveState());
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        bundle.putBundle("floating_views_presenter_state", persistableFloatingViewsPresenter.onSaveState());
        bundle.putBundle("screen_tracker_state", Bundle.EMPTY);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getViewVisibilityTracking().invoke().booleanValue()) {
            ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
            if (itemVisibilityTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
            }
            bundle.putBundle("key_item_visibility_tracker_state", itemVisibilityTracker2.onSaveState());
        }
        AdvertItemActionsPresenter advertItemActionsPresenter2 = this.advertItemActionsPresenter;
        if (advertItemActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertItemActionsPresenter");
        }
        bundle.putParcelable("key_actions_menu_state", advertItemActionsPresenter2.saveState());
        WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
        if (witcherItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
        }
        bundle.putParcelable("state_witcher", witcherItemPresenter2.onSaveState());
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
        if (storeFragment != null) {
            HomePresenter homePresenter = this.presenter;
            if (homePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            storeFragment.setState$serp_release(homePresenter.onSaveState());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter.attachRouter(this);
        Context context = getContext();
        if (context != null) {
            NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
            if (networkInfoBroadcastReceiver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
            }
            context.registerReceiver(networkInfoBroadcastReceiver2, NetworkInfoBroadcastReceiverKt.createNetworkInfoBroadcastReceiverIntentFilter());
        }
        this.l = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.l = false;
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter.onStop();
        HomePresenter homePresenter2 = this.presenter;
        if (homePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter2.detachRouter();
        FragmentActivity requireActivity = requireActivity();
        NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
        if (networkInfoBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
        }
        requireActivity.unregisterReceiver(networkInfoBroadcastReceiver2);
        this.k.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        CartFabView cartFabView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            View inflate = ((ViewStub) view.findViewById(R.id.cart_fab_stub)).inflate();
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
        HomePresenter homePresenter = this.presenter;
        if (homePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        HomeInteractor homeInteractor = this.interactor;
        if (homeInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        HomeSkeletonTestGroup homeSkeletonTestGroup2 = this.homeSkeletonTestGroup;
        if (homeSkeletonTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSkeletonTestGroup");
        }
        boolean isTest = homeSkeletonTestGroup2.isTest();
        HomeNewRubricatorTestGroup homeNewRubricatorTestGroup2 = this.homeNewRubricatorTestGroup;
        if (homeNewRubricatorTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeNewRubricatorTestGroup");
        }
        HomeViewImpl homeViewImpl = new HomeViewImpl(view, homePresenter, destroyableViewHolderBuilder2, responsiveAdapterPresenter, itemVisibilityTracker2, features3, spannedGridPositionProvider, schedulersFactory3, spanSizeLookup2, persistableFloatingViewsPresenter, homeInteractor, analytics2, fpsStateSupplier, isTest, homeNewRubricatorTestGroup2, cartFabView);
        this.j.setValue((Fragment) this, m[0], (KProperty<?>) homeViewImpl);
        HomePresenter homePresenter2 = this.presenter;
        if (homePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        homePresenter2.attachView(homeViewImpl, homeViewImpl.getRetryView());
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.attachView(homeViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter3.attachErrorMessageView(homeViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(homeViewImpl);
        AdvertItemActionsPresenter advertItemActionsPresenter2 = this.advertItemActionsPresenter;
        if (advertItemActionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertItemActionsPresenter");
        }
        advertItemActionsPresenter2.attachView(homeViewImpl, bundle != null ? bundle.getParcelable("key_actions_menu_state") : null);
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter2 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter2.attachSubscriber(homeViewImpl);
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter3 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        HomePresenter homePresenter3 = this.presenter;
        if (homePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        persistableFloatingViewsPresenter3.attachAppendingListener(homePresenter3);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getWindow().setBackgroundDrawable(null);
        HomeTracker homeTracker = this.tracker;
        if (homeTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        homeTracker.trackInit();
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void openAdvertDetails(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "feedId");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory, str, str3, str4, str5, str6, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), new ScreenSource.MAIN(str2), 512, null));
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void openStory(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        a2.b.a.a.a.d1(str, "url", list, "stories", str2, "storyId");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.storiesIntent(str, list, str2), 4);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        if (isVisible()) {
            AutoClearedDestroyable autoClearedDestroyable = this.j;
            KProperty<?>[] kPropertyArr = m;
            ((HomeView) autoClearedDestroyable.getValue((Fragment) this, kPropertyArr[0])).scrollToStart();
            ((HomeView) this.j.getValue((Fragment) this, kPropertyArr[0])).showFloatingViews(false);
        }
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAdvertItemActionsPresenter(@NotNull AdvertItemActionsPresenter advertItemActionsPresenter2) {
        Intrinsics.checkNotNullParameter(advertItemActionsPresenter2, "<set-?>");
        this.advertItemActionsPresenter = advertItemActionsPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsInteractor(@NotNull HomeAnalyticsInteractor homeAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(homeAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = homeAnalyticsInteractor;
    }

    public final void setCartFabQuantityHandler$serp_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setCartFabViewModel$serp_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDefaultLocationInteractor(@NotNull DefaultLocationInteractor defaultLocationInteractor2) {
        Intrinsics.checkNotNullParameter(defaultLocationInteractor2, "<set-?>");
        this.defaultLocationInteractor = defaultLocationInteractor2;
    }

    public final void setDefaultLocationPresenter(@NotNull DefaultSearchLocationPresenter defaultSearchLocationPresenter) {
        Intrinsics.checkNotNullParameter(defaultSearchLocationPresenter, "<set-?>");
        this.defaultLocationPresenter = defaultSearchLocationPresenter;
    }

    public final void setDefaultSearchLocationInteractor(@NotNull DefaultSearchLocationInteractor defaultSearchLocationInteractor2) {
        Intrinsics.checkNotNullParameter(defaultSearchLocationInteractor2, "<set-?>");
        this.defaultSearchLocationInteractor = defaultSearchLocationInteractor2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFloatingViewsPresenter(@NotNull PersistableFloatingViewsPresenter persistableFloatingViewsPresenter) {
        Intrinsics.checkNotNullParameter(persistableFloatingViewsPresenter, "<set-?>");
        this.floatingViewsPresenter = persistableFloatingViewsPresenter;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setHomeNewRubricatorTestGroup(@NotNull HomeNewRubricatorTestGroup homeNewRubricatorTestGroup2) {
        Intrinsics.checkNotNullParameter(homeNewRubricatorTestGroup2, "<set-?>");
        this.homeNewRubricatorTestGroup = homeNewRubricatorTestGroup2;
    }

    public final void setHomeSkeletonTestGroup(@NotNull HomeSkeletonTestGroup homeSkeletonTestGroup2) {
        Intrinsics.checkNotNullParameter(homeSkeletonTestGroup2, "<set-?>");
        this.homeSkeletonTestGroup = homeSkeletonTestGroup2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull HomeInteractor homeInteractor) {
        Intrinsics.checkNotNullParameter(homeInteractor, "<set-?>");
        this.interactor = homeInteractor;
    }

    public final void setItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker2) {
        Intrinsics.checkNotNullParameter(itemVisibilityTracker2, "<set-?>");
        this.itemVisibilityTracker = itemVisibilityTracker2;
    }

    public final void setNetworkInfoBroadcastReceiver(@NotNull NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2) {
        Intrinsics.checkNotNullParameter(networkInfoBroadcastReceiver2, "<set-?>");
        this.networkInfoBroadcastReceiver = networkInfoBroadcastReceiver2;
    }

    public final void setPresenter(@NotNull HomePresenter homePresenter) {
        Intrinsics.checkNotNullParameter(homePresenter, "<set-?>");
        this.presenter = homePresenter;
    }

    public final void setResourceProvider(@NotNull HomePresenterResourcesProvider homePresenterResourcesProvider) {
        Intrinsics.checkNotNullParameter(homePresenterResourcesProvider, "<set-?>");
        this.resourceProvider = homePresenterResourcesProvider;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
        this.supplier = fpsStateSupplier;
    }

    public final void setTracker(@NotNull HomeTracker homeTracker) {
        Intrinsics.checkNotNullParameter(homeTracker, "<set-?>");
        this.tracker = homeTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        HomePresenterState homePresenterState;
        if (getContext() != null) {
            HomeInteractorState homeInteractorState = bundle != null ? (HomeInteractorState) bundle.getParcelable("interactor_state") : null;
            Bundle bundle2 = bundle != null ? bundle.getBundle("floating_views_presenter_state") : null;
            Bundle bundle3 = bundle != null ? bundle.getBundle("default_location_interactor_state") : null;
            Bundle bundle4 = bundle != null ? bundle.getBundle("screen_tracker_state") : null;
            Bundle bundle5 = bundle != null ? bundle.getBundle("key_item_visibility_tracker_state") : null;
            Kundle kundle = bundle != null ? (Kundle) bundle.getParcelable("state_witcher") : null;
            StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
            if (storeFragment != null) {
                homePresenterState = storeFragment.getState$serp_release();
            } else {
                getChildFragmentManager().beginTransaction().add(new StoreFragment(), "store_fragment").commitNow();
                homePresenterState = null;
            }
            Timer B1 = a2.b.a.a.a.B1();
            HomeComponent.Builder homeDependencies = DaggerHomeComponent.builder().locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).serpDependencies((SerpDependencies) ComponentDependenciesKt.getDependencies(SerpDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).homeDependencies((HomeDependencies) ComponentDependenciesKt.getDependencies(HomeDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            HomeComponent.Builder screenTrackerState = homeDependencies.resources(resources).homePresenterState(homePresenterState).floatingViewsPresenterState(bundle2).homeInteractorState(homeInteractorState).screenTrackerState(bundle4);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "this.requireActivity()");
            HomeComponent.Builder itemVisibilityTrackerState = screenTrackerState.activity(requireActivity).fragment(this).activityInteractor(this).screen(HomeScreen.INSTANCE).bannerPageSource(BannerPageSource.HOME).defaultLocationInteractorState(bundle3).itemVisibilityTrackerState(bundle5);
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            HomeComponent.Builder snippetClick = itemVisibilityTrackerState.snippetClick(create);
            PublishRelay create2 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
            HomeComponent.Builder snippetClose = snippetClick.snippetClose(create2);
            PublishRelay create3 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
            HomeComponent.Builder snippetVisibility = snippetClose.snippetVisibility(create3);
            PublishRelay create4 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
            HomeComponent.Builder locationNotificationClick = snippetVisibility.locationNotificationClick(create4);
            PublishRelay create5 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
            locationNotificationClick.locationNotificationVisibility(create5).withSerpOnboardingHandler(null).withWitcherSavedState(kundle).build().inject(this);
            HomeTracker homeTracker = this.tracker;
            if (homeTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            homeTracker.trackDiInject(B1.elapsed());
            if (homePresenterState != null || bundle == null) {
                return true;
            }
            HomeAnalyticsInteractor homeAnalyticsInteractor = this.analyticsInteractor;
            if (homeAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            homeAnalyticsInteractor.sendNotRestoreState();
            return true;
        }
        throw new IllegalArgumentException("context is null".toString());
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    public final void setWitcherItemPresenter(@NotNull WitcherItemPresenter witcherItemPresenter2) {
        Intrinsics.checkNotNullParameter(witcherItemPresenter2, "<set-?>");
        this.witcherItemPresenter = witcherItemPresenter2;
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void showAllCategories(@Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.createCategoriesListIntent(location, treeClickStreamParent));
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void showClarifyScreen(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent searchIntent$default = FiltersIntentFactory.DefaultImpls.searchIntent$default(activityIntentFactory, searchParams, null, null, false, null, currentTab(), false, 94, null);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getFiltersWithoutActivity().invoke().booleanValue()) {
            startForResult(searchIntent$default, 2);
        } else {
            startActivityForResult(searchIntent$default, 2);
        }
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void showLocationsListScreen(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent suggestLocationsIntent$default = SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(activityIntentFactory, str, null, Integer.valueOf(OpenEventFromBlock.HOME.getValue()), null, null, currentTab(), false, str2, null, false, false, 1856, null);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getLocationSelectWithoutActivity().invoke().booleanValue() || currentTab() == null) {
            startActivityForResult(suggestLocationsIntent$default, 3);
        } else {
            startForResult(suggestLocationsIntent$default, 3);
        }
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void showSearchScreen(@NotNull SearchParams searchParams, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(SerpIntentFactory.DefaultImpls.itemsListIntent$default(activityIntentFactory, searchParams, null, treeClickStreamParent, null, false, false, 58, null));
    }

    @Override // com.avito.android.home.HomePresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        c(deepLink, treeClickStreamParent);
    }
}
