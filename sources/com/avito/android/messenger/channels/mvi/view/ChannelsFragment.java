package com.avito.android.messenger.channels.mvi.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.MessengerSearchIconTest;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ChannelsScreen;
import com.avito.android.app.di.HasComponent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.SupportChatFormLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.lib.design.input.ComponentType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.ClickChannelsSearchEvent;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.channels.ChannelsRouter;
import com.avito.android.messenger.channels.ChannelsRouterImpl;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.black_list_popup.BlacklistPopup;
import com.avito.android.messenger.channels.mvi.di.ChannelsComponent;
import com.avito.android.messenger.channels.mvi.di.ChannelsDependencies;
import com.avito.android.messenger.channels.mvi.di.DaggerChannelsComponent;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState;
import com.avito.android.messenger.conversation.mvi.data.MessengerDbException;
import com.avito.android.messenger.di.RelativeDateFormatterModule;
import com.avito.android.messenger.folders.Folder;
import com.avito.android.messenger.folders.Folders;
import com.avito.android.messenger.map.viewing.PlatformMapActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcParsingException;
import t6.n.d;
import t6.n.e;
import t6.n.q;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ¼\u00012\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0004¼\u0001½\u0001B\b¢\u0006\u0005\b»\u0001\u0010\u001dJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010\u001dJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010'\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0016@\u0016X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010[\u001a\u00020Z8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010j\u001a\u00020i8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010 \u0001\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R1\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¤\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R1\u0010´\u0001\u001a\u00030³\u00018\u0000@\u0000X.¢\u0006\u001f\n\u0006\b´\u0001\u0010µ\u0001\u0012\u0005\bº\u0001\u0010\u001d\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Lcom/avito/android/app/di/HasComponent;", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", "Lcom/avito/android/messenger/channels/ChannelsRouter$Provider;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler$Host;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onStop", "onDestroyView", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "scrollToUp", "handler", "setScrollToUpHandler", "(Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;)V", "getComponent", "()Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", VKApiConst.Q, "Landroid/view/View;", "screenTitle", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsHeaderView;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/messenger/channels/mvi/view/ChannelsHeaderView;", "channelsHeaderView", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "perfTracker", "Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "getPerfTracker", "()Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;", "setPerfTracker", "(Lcom/avito/android/messenger/channels/analytics/ChannelsTracker;)V", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "r", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$messenger_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$messenger_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Landroidx/appcompat/widget/Toolbar;", "p", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/messenger/channels/ChannelsRouter;", "router", "Lcom/avito/android/messenger/channels/ChannelsRouter;", "getRouter", "()Lcom/avito/android/messenger/channels/ChannelsRouter;", "setRouter", "(Lcom/avito/android/messenger/channels/ChannelsRouter;)V", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "foldersPresenter", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "getFoldersPresenter", "()Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "setFoldersPresenter", "(Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;)V", "Lio/reactivex/disposables/CompositeDisposable;", "s", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory$messenger_release", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory$messenger_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "Landroidx/viewpager2/widget/ViewPager2;", "k", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/TabLayout;", "l", "Lcom/google/android/material/tabs/TabLayout;", "tabsLayout", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "database", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "getDatabase$messenger_release", "()Lru/avito/android/persistence/messenger/MessengerDatabase;", "setDatabase$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartQuantityHandler$messenger_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartQuantityHandler$messenger_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "channelsHeaderPresenter", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "getChannelsHeaderPresenter", "()Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "setChannelsHeaderPresenter", "(Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;)V", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "o", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "folderSelectionListener", "j", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory$messenger_release", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory$messenger_release", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/messenger/channels/mvi/view/FoldersView;", "n", "Lcom/avito/android/messenger/channels/mvi/view/FoldersView;", "foldersView", "t", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", "component", "u", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "scrollToUpHandler", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "getMessengerFolderTabsTestGroup$messenger_release", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "setMessengerFolderTabsTestGroup$messenger_release", "(Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$messenger_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$messenger_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "searchIconTest", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "getSearchIconTest$messenger_release", "()Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "setSearchIconTest$messenger_release", "(Lcom/avito/android/ab_tests/groups/SimpleTestGroup;)V", "getSearchIconTest$messenger_release$annotations", "<init>", "Companion", "Renderer", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsFragment extends TabBaseFragment implements TabRootFragment, ScrollToUpHandler, HasComponent<ChannelsComponent>, ChannelsRouter.Provider, ScrollToUpHandler.Host {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "ChannelsFragment";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public CartQuantityChangesHandler cartQuantityHandler;
    @Inject
    public ChannelsHeaderPresenter channelsHeaderPresenter;
    @Inject
    public MessengerDatabase database;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public FoldersPresenter foldersPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public ViewGroup j;
    public ViewPager2 k;
    public TabLayout l;
    public ChannelsHeaderView m;
    @Inject
    public ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabsTestGroup;
    public FoldersView n;
    public TabLayout.OnTabSelectedListener o;
    public Toolbar p;
    @Inject
    public ChannelsTracker perfTracker;
    public View q;
    public ErrorTracker r;
    public ChannelsRouter router;
    public final CompositeDisposable s = new CompositeDisposable();
    @Inject
    public SimpleTestGroup searchIconTest;
    public ChannelsComponent t;
    public ScrollToUpHandler u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007RH\u0010\t\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00050\b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsFragment$Renderer;", "", "Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;", "oldState", "newState", "Lkotlin/Pair;", "render", "(Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;Lcom/avito/android/messenger/channels/mvi/viewstate/ChannelsListState;)Lkotlin/Pair;", "Lkotlin/Function2;", "renderFunction", "Lkotlin/jvm/functions/Function2;", "getRenderFunction", "()Lkotlin/jvm/functions/Function2;", "setRenderFunction", "(Lkotlin/jvm/functions/Function2;)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static class Renderer {
        public Function2<? super ChannelsListState, ? super ChannelsListState, Pair<ChannelsListState, ChannelsListState>> renderFunction;

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, ? super com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, kotlin.Pair<com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState>>, kotlin.jvm.functions.Function2<com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, kotlin.Pair<com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState, com.avito.android.messenger.channels.mvi.viewstate.ChannelsListState>> */
        @NotNull
        public final Function2<ChannelsListState, ChannelsListState, Pair<ChannelsListState, ChannelsListState>> getRenderFunction() {
            Function2 function2 = this.renderFunction;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderFunction");
            }
            return function2;
        }

        @NotNull
        public Pair<ChannelsListState, ChannelsListState> render(@Nullable ChannelsListState channelsListState, @Nullable ChannelsListState channelsListState2) {
            Function2<? super ChannelsListState, ? super ChannelsListState, Pair<ChannelsListState, ChannelsListState>> function2 = this.renderFunction;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderFunction");
            }
            return function2.invoke(channelsListState, channelsListState2);
        }

        public final void setRenderFunction(@NotNull Function2<? super ChannelsListState, ? super ChannelsListState, Pair<ChannelsListState, ChannelsListState>> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.renderFunction = function2;
        }
    }

    public static final /* synthetic */ ChannelsHeaderView access$getChannelsHeaderView$p(ChannelsFragment channelsFragment) {
        ChannelsHeaderView channelsHeaderView = channelsFragment.m;
        if (channelsHeaderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsHeaderView");
        }
        return channelsHeaderView;
    }

    public static final /* synthetic */ TabLayout.OnTabSelectedListener access$getFolderSelectionListener$p(ChannelsFragment channelsFragment) {
        TabLayout.OnTabSelectedListener onTabSelectedListener = channelsFragment.o;
        if (onTabSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("folderSelectionListener");
        }
        return onTabSelectedListener;
    }

    public static final /* synthetic */ FoldersView access$getFoldersView$p(ChannelsFragment channelsFragment) {
        FoldersView foldersView = channelsFragment.n;
        if (foldersView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersView");
        }
        return foldersView;
    }

    public static final /* synthetic */ View access$getScreenTitle$p(ChannelsFragment channelsFragment) {
        View view = channelsFragment.q;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTitle");
        }
        return view;
    }

    public static final /* synthetic */ TabLayout access$getTabsLayout$p(ChannelsFragment channelsFragment) {
        TabLayout tabLayout = channelsFragment.l;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsLayout");
        }
        return tabLayout;
    }

    public static final /* synthetic */ Toolbar access$getToolbar$p(ChannelsFragment channelsFragment) {
        Toolbar toolbar = channelsFragment.p;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar;
    }

    public static final /* synthetic */ ViewPager2 access$getViewPager$p(ChannelsFragment channelsFragment) {
        ViewPager2 viewPager2 = channelsFragment.k;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00e4: APUT  
      (r9v2 com.avito.android.remote.model.messenger.geo.GeoMarker[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.remote.model.messenger.geo.GeoMarker : 0x00e1: CONSTRUCTOR  (r1v14 com.avito.android.remote.model.messenger.geo.GeoMarker) = 
      (55.7558d double)
      (37.6173d double)
      ("Адрес №1 с очень длинным заголовком, который не помещается в шторку!")
      (r5v3 java.util.ArrayList)
     call: com.avito.android.remote.model.messenger.geo.GeoMarker.<init>(double, double, java.lang.String, java.util.List):void type: CONSTRUCTOR)
     */
    public static final boolean access$onMenuClick(ChannelsFragment channelsFragment, MenuItem menuItem) {
        FragmentActivity activity;
        Throwable th;
        Objects.requireNonNull(channelsFragment);
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            FragmentActivity activity2 = channelsFragment.getActivity();
            if (activity2 == null) {
                return true;
            }
            activity2.onBackPressed();
            return true;
        } else if (itemId == R.id.menu_blacklist) {
            channelsFragment.getRouter().showBlacklistScreen();
            return true;
        } else if (itemId == R.id.menu_search) {
            Analytics analytics2 = channelsFragment.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new ClickChannelsSearchEvent());
            channelsFragment.getRouter().showSearchScreen(null);
            return true;
        } else if (itemId == R.id.menu_clear_database) {
            Disposable subscribe = Completable.fromAction(new b3(0, channelsFragment)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b3(1, channelsFragment));
            Intrinsics.checkNotNullExpressionValue(subscribe, "Completable.fromAction {…nger database cleared\") }");
            DisposableKt.addTo(subscribe, channelsFragment.s);
            return true;
        } else if (itemId == R.id.menu_map) {
            Context context = channelsFragment.getContext();
            if (context == null) {
                return true;
            }
            PlatformMapActivity.Companion companion = PlatformMapActivity.Companion;
            GeoMarker[] geoMarkerArr = new GeoMarker[3];
            List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\n                                ").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(new AttributedText(str, CollectionsKt__CollectionsKt.emptyList()));
            }
            geoMarkerArr[0] = new GeoMarker(55.7558d, 37.6173d, "Адрес №1 с очень длинным заголовком, который не помещается в шторку!", arrayList);
            List<String> split$default2 = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж.\n").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(split$default2, 10));
            for (String str2 : split$default2) {
                arrayList2.add(new AttributedText(str2, CollectionsKt__CollectionsKt.emptyList()));
            }
            geoMarkerArr[1] = new GeoMarker(55.78d, 37.64d, "Адрес №2", arrayList2);
            List<String> split$default3 = StringsKt__StringsKt.split$default((CharSequence) f.trimIndent(StringsKt__StringsKt.trim("\n                                    Адрес: 140090, Дзержинский г, Лесная ул, д.21\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n\nТелефон: +7(499)391-56-22\nРежим работы: пн-вс:10.00-20.00\nТип оплаты: выдача заказов с оплатой по факту получения и предоплаченных\nОстановка: Профилакторий, Угрешская 30. Вход в Фотостудию со стороны улицы. Большая вывеска \"Фотостудия\" Жилой 12-ти этажный дом. 1 этаж. От остановки \"Профилакторий\" необходимо повернуть направо и пройти 50 метров до вывески \"Фотостудия\", главный вход. От остановки \"Угрешская 30\" необходимо перейти дорогу пройти 50 метров налево до вывески \"Фотостудия\".\n                                ").toString()), new char[]{'\n'}, false, 0, 6, (Object) null);
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(split$default3, 10));
            for (String str3 : split$default3) {
                arrayList3.add(new AttributedText(str3, CollectionsKt__CollectionsKt.emptyList()));
            }
            geoMarkerArr[2] = new GeoMarker(55.765d, 37.625d, null, arrayList3);
            Intent createIntent$default = PlatformMapActivity.Companion.createIntent$default(companion, context, "Platform Map Title", geoMarkerArr, null, false, 16, null);
            FragmentActivity activity3 = channelsFragment.getActivity();
            if (activity3 == null) {
                return true;
            }
            activity3.startActivity(createIntent$default);
            return true;
        } else if (itemId == R.id.menu_error_tracking_test) {
            ErrorTracker errorTracker = channelsFragment.r;
            if (errorTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorTracker");
            }
            Random.Default r1 = Random.Default;
            int nextInt = r1.nextInt(3);
            if (nextInt == 0) {
                th = new MessengerJsonRpcCallException(-1, "test", null, null, null, null, 60, null);
            } else if (nextInt != 1) {
                th = new MessengerDbException(r1.nextBoolean(), "test", null, 4, null);
            } else {
                th = new MessengerJsonRpcParsingException("test", null, null, null, null, 30, null);
            }
            errorTracker.track(th, "Test Event", q.mapOf(TuplesKt.to("test_extra", new GeoMarker(55.7558d, 37.6173d, "1", null))));
            return true;
        } else if (itemId == R.id.menu_support_chat_form_test) {
            SupportChatFormLink supportChatFormLink = new SupportChatFormLink(123);
            DeepLinkIntentFactory deepLinkIntentFactory2 = channelsFragment.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(supportChatFormLink);
            if (intent == null || (activity = channelsFragment.getActivity()) == null) {
                return true;
            }
            activity.startActivity(intent);
            return true;
        } else if (itemId != R.id.menu_crashlytics_crash_test) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            throw new RuntimeException();
        }
    }

    public static final void access$showBlacklistPopup(ChannelsFragment channelsFragment) {
        Objects.requireNonNull(channelsFragment);
        ArrayList<View> arrayList = new ArrayList<>();
        String string = channelsFragment.getResources().getString(com.avito.android.ui_components.R.string.action_overflow_menu_content_description);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…menu_content_description)");
        access$getToolbar$p(channelsFragment).findViewsWithText(arrayList, string, 2);
        View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        String string2 = channelsFragment.getResources().getString(R.string.messenger_blacklist_popup_message);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_blacklist_popup_message)");
        if (view != null) {
            Context context = access$getToolbar$p(channelsFragment).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
            new BlacklistPopup(context).setText(string2).show(view, false);
            return;
        }
        Context context2 = channelsFragment.getContext();
        if (context2 != null) {
            ToastsKt.showToast(context2, string2, 0);
        }
    }

    @MessengerSearchIconTest
    public static /* synthetic */ void getSearchIconTest$messenger_release$annotations() {
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory$messenger_release() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final CartFabViewModel getCartFabViewModel$messenger_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartQuantityHandler$messenger_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final ChannelsHeaderPresenter getChannelsHeaderPresenter() {
        ChannelsHeaderPresenter channelsHeaderPresenter2 = this.channelsHeaderPresenter;
        if (channelsHeaderPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsHeaderPresenter");
        }
        return channelsHeaderPresenter2;
    }

    @NotNull
    public final MessengerDatabase getDatabase$messenger_release() {
        MessengerDatabase messengerDatabase = this.database;
        if (messengerDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return messengerDatabase;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$messenger_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final FoldersPresenter getFoldersPresenter() {
        FoldersPresenter foldersPresenter2 = this.foldersPresenter;
        if (foldersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPresenter");
        }
        return foldersPresenter2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory$messenger_release() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> getMessengerFolderTabsTestGroup$messenger_release() {
        ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup = this.messengerFolderTabsTestGroup;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messengerFolderTabsTestGroup");
        }
        return manuallyExposedAbTestGroup;
    }

    @NotNull
    public final ChannelsTracker getPerfTracker() {
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        return channelsTracker;
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter.Provider
    @NotNull
    public ChannelsRouter getRouter() {
        ChannelsRouter channelsRouter = this.router;
        if (channelsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return channelsRouter;
    }

    @NotNull
    public final SimpleTestGroup getSearchIconTest$messenger_release() {
        SimpleTestGroup simpleTestGroup = this.searchIconTest;
        if (simpleTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIconTest");
        }
        return simpleTestGroup;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return Intrinsics.areEqual(navigationTabSetItem, NavigationTab.MESSAGE.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Context applicationContext = requireContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "requireContext().applicationContext");
        Resources resources = applicationContext.getResources();
        ChannelsComponent.Builder fragment = DaggerChannelsComponent.builder().channelsMviDependencies((ChannelsDependencies) ComponentDependenciesKt.getDependencies(ChannelsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screen(ChannelsScreen.INSTANCE).adBannerPageSource(BannerPageSource.MESSENGER).relativeDateFormatterModule(RelativeDateFormatterModule.INSTANCE).fragment(this);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        ChannelsComponent build = fragment.resources(resources).build();
        this.t = build;
        build.inject(this);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.r = new MessengerErrorTracker(analytics2);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        setRouter(new ChannelsRouterImpl(TAG, this, activityIntentFactory2, implicitIntentFactory2));
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        List<Folder> list;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelsTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.messenger_channels, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        this.j = viewGroup2;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById = viewGroup2.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.p = (Toolbar) findViewById;
        SimpleTestGroup simpleTestGroup = this.searchIconTest;
        if (simpleTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIconTest");
        }
        if (!simpleTestGroup.isTest()) {
            i = R.layout.messenger_channels_toolbar_content_tab;
        } else {
            i = R.layout.messenger_channels_toolbar_content_tab_legacy;
        }
        Toolbar toolbar = this.p;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        layoutInflater.inflate(i, (ViewGroup) toolbar, true);
        ViewGroup viewGroup3 = this.j;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById2 = viewGroup3.findViewById(R.id.screen_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.q = findViewById2;
        Toolbar toolbar2 = this.p;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        int i2 = com.avito.android.app.core.R.string.my_messages;
        toolbar2.setTitle(i2);
        View view = this.q;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTitle");
        }
        if (view instanceof Input) {
            ((Input) view).setComponentType(ComponentType.SELECT);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(i2);
        }
        Toolbar toolbar3 = this.p;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar3.setElevation(0.0f);
        ViewGroup viewGroup4 = this.j;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById3 = viewGroup4.findViewById(R.id.folders_tabs);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        this.l = (TabLayout) findViewById3;
        ViewGroup viewGroup5 = this.j;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View findViewById4 = viewGroup5.findViewById(R.id.channels_view_pager);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        ViewPager2 viewPager2 = (ViewPager2) findViewById4;
        this.k = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setUserInputEnabled(false);
        this.o = new SimpleOnTabSelectedListener(this) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$onCreateView$1
            public final /* synthetic */ ChannelsFragment a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                this.a.getFoldersPresenter().tabSelected(tab.getPosition());
            }
        };
        ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup = this.messengerFolderTabsTestGroup;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messengerFolderTabsTestGroup");
        }
        if (manuallyExposedAbTestGroup.getTestGroup().isTest()) {
            list = Folders.INSTANCE.getAll();
        } else {
            list = d.listOf(Folders.INSTANCE.getDEFAULT());
        }
        ViewPager2 viewPager22 = this.k;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager22.setAdapter(new FragmentStateAdapter(this, list, this) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$createViewPagerAdapter$1
            public final /* synthetic */ List k;

            {
                this.k = r2;
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int i3) {
                return ChannelsListFragment.Companion.create(((Folder) this.k.get(i3)).getMainTags(), ((Folder) this.k.get(i3)).getPinnedTags(), ((Folder) this.k.get(i3)).getMergedTags());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.k.size();
            }
        });
        ViewGroup viewGroup6 = this.j;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        return viewGroup6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        TabLayout tabLayout = this.l;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsLayout");
        }
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.o;
        if (onTabSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("folderSelectionListener");
        }
        tabLayout.removeOnTabSelectedListener(onTabSelectedListener);
        super.onDestroyView();
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelsTracker.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.s.clear();
        ChannelsHeaderPresenter channelsHeaderPresenter2 = this.channelsHeaderPresenter;
        if (channelsHeaderPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsHeaderPresenter");
        }
        channelsHeaderPresenter2.getUserBlockedStream().removeObservers(getViewLifecycleOwner());
        ChannelsHeaderPresenter channelsHeaderPresenter3 = this.channelsHeaderPresenter;
        if (channelsHeaderPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelsHeaderPresenter");
        }
        channelsHeaderPresenter3.getShowLoginScreenStream().removeObservers(getViewLifecycleOwner());
        FoldersPresenter foldersPresenter2 = this.foldersPresenter;
        if (foldersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPresenter");
        }
        foldersPresenter2.getShowOnboardingStream().removeObservers(getViewLifecycleOwner());
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getChannelsHeaderPresenter().getShowLoginScreenStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$bindChannelsHeader$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelsFragment.this.getRouter().showLoginScreen();
                }
            }
        });
        getChannelsHeaderPresenter().getUserBlockedStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$bindChannelsHeader$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelsFragment channelsFragment = ChannelsFragment.this;
                    ArrayList<View> arrayList = new ArrayList<>();
                    String string = channelsFragment.getResources().getString(com.avito.android.ui_components.R.string.action_overflow_menu_content_description);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…menu_content_description)");
                    ChannelsFragment.access$getToolbar$p(channelsFragment).findViewsWithText(arrayList, string, 2);
                    View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                    String string2 = channelsFragment.getResources().getString(R.string.messenger_blacklist_popup_message);
                    Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_blacklist_popup_message)");
                    if (view != null) {
                        Context context = ChannelsFragment.access$getToolbar$p(channelsFragment).getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
                        new BlacklistPopup(context).setText(string2).show(view, false);
                        return;
                    }
                    Context context2 = channelsFragment.getContext();
                    if (context2 != null) {
                        ToastsKt.showToast(context2, string2, 0);
                    }
                }
            }
        });
        Disposable subscribe = getChannelsHeaderPresenter().getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ChannelsHeaderPresenter.State>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$bindChannelsHeader$3
            public final void accept(ChannelsHeaderPresenter.State state) {
                ChannelsHeaderView access$getChannelsHeaderView$p = ChannelsFragment.access$getChannelsHeaderView$p(ChannelsFragment.this);
                Intrinsics.checkNotNullExpressionValue(state, "state");
                access$getChannelsHeaderView$p.render(state);
                Logs.verbose$default(ChannelsFragment.TAG, "Rendered state: " + state, null, 4, null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "channelsHeaderPresenter.…e: $state\")\n            }");
        DisposableKt.addTo(subscribe, this.s);
        access$getScreenTitle$p(this).setOnClickListener(new View.OnClickListener() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$bindChannelsHeader$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityOptionsCompat activityOptionsCompat;
                ChannelsFragment.this.getAnalytics().track(new ClickChannelsSearchEvent());
                FragmentActivity activity = ChannelsFragment.this.getActivity();
                Bundle bundle = null;
                if (activity != null) {
                    String string = ChannelsFragment.this.getString(R.string.messenger_transition_search_field);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.messe…_transition_search_field)");
                    activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, ChannelsFragment.access$getScreenTitle$p(ChannelsFragment.this), string);
                } else {
                    activityOptionsCompat = null;
                }
                ChannelsRouter router2 = ChannelsFragment.this.getRouter();
                if (activityOptionsCompat != null) {
                    bundle = activityOptionsCompat.toBundle();
                }
                router2.showSearchScreen(bundle);
            }
        });
        FoldersPresenter foldersPresenter2 = this.foldersPresenter;
        if (foldersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPresenter");
        }
        Disposable subscribe2 = foldersPresenter2.getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new a2.a.a.o1.b.b.e.d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "foldersPresenter.stateOb…onListener)\n            }");
        DisposableKt.addTo(subscribe2, this.s);
        FoldersPresenter foldersPresenter3 = this.foldersPresenter;
        if (foldersPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPresenter");
        }
        foldersPresenter3.getShowOnboardingStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsFragment$bindFolders$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                if (t2 != null) {
                    ChannelsFragment.access$getFoldersView$p(ChannelsFragment.this).requestOnboarding();
                }
            }
        });
        FoldersPresenter foldersPresenter4 = this.foldersPresenter;
        if (foldersPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldersPresenter");
        }
        foldersPresenter4.processScreenOpened();
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ChannelsTracker channelsTracker = this.perfTracker;
        if (channelsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfTracker");
        }
        channelsTracker.stopAllSessions();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        MenuInflater menuInflater;
        Intrinsics.checkNotNullParameter(view, "view");
        Toolbar toolbar = this.p;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.inflateMenu(R.menu.messenger_channels);
        Toolbar toolbar2 = this.p;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        MenuItem findItem = toolbar2.getMenu().findItem(R.id.menu_search);
        if (findItem != null) {
            SimpleTestGroup simpleTestGroup = this.searchIconTest;
            if (simpleTestGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchIconTest");
            }
            findItem.setVisible(simpleTestGroup.isTest());
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getMessengerDebugMenu().invoke().booleanValue()) {
            Toolbar toolbar3 = this.p;
            if (toolbar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            Menu menu = toolbar3.getMenu();
            SubMenu addSubMenu = menu != null ? menu.addSubMenu(R.string.messenger_channels_debug_menu) : null;
            FragmentActivity activity = getActivity();
            if (!(activity == null || (menuInflater = activity.getMenuInflater()) == null)) {
                menuInflater.inflate(R.menu.messenger_channels_debug, addSubMenu);
            }
        }
        Toolbar toolbar4 = this.p;
        if (toolbar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar4.setOnMenuItemClickListener(new a2.a.a.o1.b.b.e.e(this));
        this.m = new ChannelsHeaderViewImpl(view);
        this.n = new FoldersViewImpl(view);
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features3.getCartFloatingActionButton().invoke().booleanValue()) {
            View findViewById = view.findViewById(R.id.cart_fab_stub);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            View inflate = ((ViewStub) findViewById).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
            CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
            if (cartFabViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
            }
            CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
            if (cartQuantityChangesHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
        }
        super.onViewCreated(view, bundle);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        ScrollToUpHandler scrollToUpHandler = this.u;
        if (scrollToUpHandler != null) {
            scrollToUpHandler.scrollToUp();
        }
    }

    public final void setActivityIntentFactory$messenger_release(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCartFabViewModel$messenger_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCartQuantityHandler$messenger_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setChannelsHeaderPresenter(@NotNull ChannelsHeaderPresenter channelsHeaderPresenter2) {
        Intrinsics.checkNotNullParameter(channelsHeaderPresenter2, "<set-?>");
        this.channelsHeaderPresenter = channelsHeaderPresenter2;
    }

    public final void setDatabase$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "<set-?>");
        this.database = messengerDatabase;
    }

    public final void setDeepLinkIntentFactory$messenger_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFoldersPresenter(@NotNull FoldersPresenter foldersPresenter2) {
        Intrinsics.checkNotNullParameter(foldersPresenter2, "<set-?>");
        this.foldersPresenter = foldersPresenter2;
    }

    public final void setImplicitIntentFactory$messenger_release(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setMessengerFolderTabsTestGroup$messenger_release(@NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "<set-?>");
        this.messengerFolderTabsTestGroup = manuallyExposedAbTestGroup;
    }

    public final void setPerfTracker(@NotNull ChannelsTracker channelsTracker) {
        Intrinsics.checkNotNullParameter(channelsTracker, "<set-?>");
        this.perfTracker = channelsTracker;
    }

    public void setRouter(@NotNull ChannelsRouter channelsRouter) {
        Intrinsics.checkNotNullParameter(channelsRouter, "<set-?>");
        this.router = channelsRouter;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler.Host
    public void setScrollToUpHandler(@Nullable ScrollToUpHandler scrollToUpHandler) {
        this.u = scrollToUpHandler;
    }

    public final void setSearchIconTest$messenger_release(@NotNull SimpleTestGroup simpleTestGroup) {
        Intrinsics.checkNotNullParameter(simpleTestGroup, "<set-?>");
        this.searchIconTest = simpleTestGroup;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        return false;
    }

    @Override // com.avito.android.app.di.HasComponent
    @NotNull
    public ChannelsComponent getComponent() {
        ChannelsComponent channelsComponent = this.t;
        if (channelsComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return channelsComponent;
    }
}
