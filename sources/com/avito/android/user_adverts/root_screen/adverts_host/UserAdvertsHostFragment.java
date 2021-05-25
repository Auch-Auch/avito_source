package com.avito.android.user_adverts.root_screen.adverts_host;

import a2.a.a.i3.c.a.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.NavigationProvider;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.bottom_navigation.ui.fragment.UpdatableTabFragment;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CompositeComponentDependenciesProvider;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_advert.UserAdvertConstantsKt;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.SoaProgressState;
import com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies;
import com.avito.android.user_adverts.di.host_fragment.DaggerUserAdvertsHostFragmentComponent;
import com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent;
import com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragmentData;
import com.avito.android.user_adverts.root_screen.UserAdvertsFragmentData;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostViewModel;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardState;
import com.avito.android.user_adverts.root_screen.adverts_host.header.OnboardingData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModelFactory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardViewImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersViewImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelViewImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.publish_button.PublishFab;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoBottomSheet;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoDialogData;
import com.avito.android.user_adverts.tracker.UserAdvertsTracker;
import com.avito.android.user_adverts_common.safety.UserAdvertConstants;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.android.vas.list.VasConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Å\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0003zÇ\u0001\u0018\u0000 Ì\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004Ì\u0001Í\u0001B\b¢\u0006\u0005\bË\u0001\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\rJ+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\rJ)\u0010$\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\rJ\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010\rJ\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010\rJ\u0017\u00100\u001a\u00020+2\u0006\u0010#\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0000@\u0000X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u0010\u0001R1\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R*\u0010¤\u0001\u001a\u00030£\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R#\u0010·\u0001\u001a\u00030²\u00018V@\u0016X\u0002¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R*\u0010½\u0001\u001a\u00030¼\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u001a\u0010Æ\u0001\u001a\u00030Ã\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001¨\u0006Î\u0001"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/di/HasComponentDependencies;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Lcom/avito/android/bottom_navigation/ui/fragment/UpdatableTabFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onStop", "onDestroyView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onPause", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "showLoginScreen", "onAuthentificationFailed", "showAddAdvert", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "scrollToUp", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "updateWithNewData", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Z", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "getUserAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "setUserAdvertsInfoUpdateRunner", "(Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModelFactory;", "viewModelFactory", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModelFactory;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "presenter", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "getPresenter", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "setPresenter", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$user_adverts_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$user_adverts_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "l", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "headerViewModel", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModelFactory;", "profileHeaderViewModelFactory", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModelFactory;", "getProfileHeaderViewModelFactory", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModelFactory;", "setProfileHeaderViewModelFactory", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModelFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartQuantityHandler$user_adverts_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartQuantityHandler$user_adverts_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "n", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "advertsHostView", "Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;", "p", "Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;", "publishFabView", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "handler", "com/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$vasBroadcastReceiver$1", "t", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$vasBroadcastReceiver$1;", "vasBroadcastReceiver", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel;", "userAdvertsViewModel", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabItem;", "tabsDataProvider", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "getTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "setTabsDataProvider", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "interactor", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "getInteractor", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "setInteractor", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "navigationDisposable", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "getTabTestGroup", "()Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "setTabTestGroup", "(Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$user_adverts_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$user_adverts_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lio/reactivex/disposables/CompositeDisposable;", "j", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoBottomSheet;", "r", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoBottomSheet;", "soaInfoDialog", "Lcom/avito/android/di/CompositeComponentDependenciesProvider;", VKApiConst.VERSION, "Lkotlin/Lazy;", "getDependencies", "()Lcom/avito/android/di/CompositeComponentDependenciesProvider;", "dependencies", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView;", "o", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView;", "profileHeaderView", "Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;", "tracker", "Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;", "getTracker$user_adverts_release", "()Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;", "setTracker$user_adverts_release", "(Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;)V", "Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent;", VKApiConst.Q, "Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent;", "component", "com/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$userAdvertStatusReceiver$1", "u", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$userAdvertStatusReceiver$1;", "userAdvertStatusReceiver", "<init>", "Companion", "Router", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsHostFragment extends TabBaseFragment implements HasComponentDependencies, UserAdvertsHostPresenter.Router, TabRootFragment, ScrollToUpHandler, UpdatableTabFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public CartQuantityChangesHandler cartQuantityHandler;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public UserAdvertsInteractor interactor;
    public final CompositeDisposable j = new CompositeDisposable();
    public Disposable k;
    public ProfileHeaderViewModel l;
    public UserAdvertsHostViewModel m;
    public UserAdvertsHostView n;
    public ProfileHeaderView o;
    public PublishFab p;
    @Inject
    public UserAdvertsHostPresenter presenter;
    @Inject
    public ProfileHeaderViewModelFactory profileHeaderViewModelFactory;
    public UserAdvertsHostFragmentComponent q;
    public SoaInfoBottomSheet r;
    public final Handler s;
    public final UserAdvertsHostFragment$vasBroadcastReceiver$1 t;
    @Inject
    public UserAdvertsTabTestGroup tabTestGroup;
    @Inject
    public TabsDataProvider<TabItem> tabsDataProvider;
    @Inject
    public UserAdvertsTracker tracker;
    public final UserAdvertsHostFragment$userAdvertStatusReceiver$1 u;
    @Inject
    public UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner;
    @NotNull
    public final Lazy v;
    @Inject
    public UserAdvertsHostViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$Companion;", "", "", "shortcut", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "advertAction", "", "openPublish", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment;", "newInstance", "(Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;Z)Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ UserAdvertsHostFragment newInstance$default(Companion companion, String str, AdvertActionTransferData advertActionTransferData, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                advertActionTransferData = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(str, advertActionTransferData, z);
        }

        @JvmStatic
        @NotNull
        public final UserAdvertsHostFragment newInstance(@Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData, boolean z) {
            UserAdvertsHostFragment userAdvertsHostFragment = new UserAdvertsHostFragment();
            Bundle bundle = new Bundle();
            bundle.putString(UserAdvertsHostFragmentKt.KEY_SELECTED_SHORTCUT, str);
            bundle.putParcelable(UserAdvertConstants.KEY_ADVERT_ACTION, advertActionTransferData);
            bundle.putBoolean(UserAdvertsHostFragmentKt.KEY_OPEN_PUBLISH, z);
            Unit unit = Unit.INSTANCE;
            userAdvertsHostFragment.setArguments(bundle);
            return userAdvertsHostFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$Router;", "", "", "closeScreen", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeScreen();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SoaProgressState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function0<CompositeComponentDependenciesProvider> {
        public final /* synthetic */ UserAdvertsHostFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserAdvertsHostFragment userAdvertsHostFragment) {
            super(0);
            this.a = userAdvertsHostFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CompositeComponentDependenciesProvider invoke() {
            FragmentActivity requireActivity = this.a.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return new CompositeComponentDependenciesProvider(ComponentDependenciesKt.findComponentDependenciesProvider((Activity) requireActivity), q.mapOf(TuplesKt.to(UserAdvertsListComponentDependencies.class, UserAdvertsHostFragment.access$getComponent$p(this.a))));
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ UserAdvertsHostFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public b(UserAdvertsHostFragment userAdvertsHostFragment, int i, int i2, Intent intent) {
            this.a = userAdvertsHostFragment;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i != 2) {
                if (i == 3) {
                    this.a.getPresenter().onAdvertDetailsResult(this.c, this.d);
                }
            } else if (this.c != -1) {
                this.a.getPresenter().onAuthenticationCancelled();
            }
        }
    }

    public static final class c<T> implements Consumer<NavigationTabSetItem> {
        public final /* synthetic */ UserAdvertsHostFragment a;

        public c(UserAdvertsHostFragment userAdvertsHostFragment) {
            this.a = userAdvertsHostFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(NavigationTabSetItem navigationTabSetItem) {
            if (Intrinsics.areEqual(navigationTabSetItem, NavigationTab.ADD.INSTANCE)) {
                this.a.getPresenter().onAddNewAdvertTabClicked();
            }
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserAdvertsHostFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(UserAdvertsHostFragment userAdvertsHostFragment) {
            super(0);
            this.a = userAdvertsHostFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getPresenter().onAddAdvertClicked();
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Observer<UserAdvertsHostViewModel.State> {
        public final /* synthetic */ UserAdvertsHostFragment a;

        public e(UserAdvertsHostFragment userAdvertsHostFragment) {
            this.a = userAdvertsHostFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(UserAdvertsHostViewModel.State state) {
            UserAdvertsHostViewModel.State state2 = state;
            if (state2.getData() != null) {
                UserAdvertsHostFragment.access$showSoaInfoDialog(this.a, state2.getData());
            } else {
                UserAdvertsHostFragment.access$hideSoaInfoDialog(this.a);
            }
        }
    }

    public static final class f<T> implements Observer<Integer> {
        public final /* synthetic */ UserAdvertsHostFragment a;

        public f(UserAdvertsHostFragment userAdvertsHostFragment) {
            this.a = userAdvertsHostFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            Integer num2 = num;
            UserAdvertsHostView access$getAdvertsHostView$p = UserAdvertsHostFragment.access$getAdvertsHostView$p(this.a);
            UserAdvertsHostFragment userAdvertsHostFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            String string = userAdvertsHostFragment.getString(num2.intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(it)");
            access$getAdvertsHostView$p.showSnackBar(string);
        }
    }

    public UserAdvertsHostFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.k = empty;
        this.s = new Handler();
        this.t = new UserAdvertsHostFragment$vasBroadcastReceiver$1(this);
        this.u = new UserAdvertsHostFragment$userAdvertStatusReceiver$1(this);
        this.v = t6.c.lazy(new a(this));
    }

    public static final /* synthetic */ UserAdvertsHostView access$getAdvertsHostView$p(UserAdvertsHostFragment userAdvertsHostFragment) {
        UserAdvertsHostView userAdvertsHostView = userAdvertsHostFragment.n;
        if (userAdvertsHostView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsHostView");
        }
        return userAdvertsHostView;
    }

    public static final /* synthetic */ UserAdvertsHostFragmentComponent access$getComponent$p(UserAdvertsHostFragment userAdvertsHostFragment) {
        UserAdvertsHostFragmentComponent userAdvertsHostFragmentComponent = userAdvertsHostFragment.q;
        if (userAdvertsHostFragmentComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return userAdvertsHostFragmentComponent;
    }

    public static final /* synthetic */ ProfileHeaderViewModel access$getHeaderViewModel$p(UserAdvertsHostFragment userAdvertsHostFragment) {
        ProfileHeaderViewModel profileHeaderViewModel = userAdvertsHostFragment.l;
        if (profileHeaderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        return profileHeaderViewModel;
    }

    public static final /* synthetic */ ProfileHeaderView access$getProfileHeaderView$p(UserAdvertsHostFragment userAdvertsHostFragment) {
        ProfileHeaderView profileHeaderView = userAdvertsHostFragment.o;
        if (profileHeaderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
        }
        return profileHeaderView;
    }

    public static final /* synthetic */ UserAdvertsHostViewModel access$getUserAdvertsViewModel$p(UserAdvertsHostFragment userAdvertsHostFragment) {
        UserAdvertsHostViewModel userAdvertsHostViewModel = userAdvertsHostFragment.m;
        if (userAdvertsHostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsViewModel");
        }
        return userAdvertsHostViewModel;
    }

    public static final void access$hideSoaInfoDialog(UserAdvertsHostFragment userAdvertsHostFragment) {
        SoaInfoBottomSheet soaInfoBottomSheet = userAdvertsHostFragment.r;
        if (soaInfoBottomSheet != null) {
            soaInfoBottomSheet.dismiss();
        }
        userAdvertsHostFragment.r = null;
    }

    public static final void access$openDeeplink(UserAdvertsHostFragment userAdvertsHostFragment, DeepLink deepLink) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = userAdvertsHostFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            userAdvertsHostFragment.startActivity(intent);
        }
    }

    public static final void access$setLeftCardState(UserAdvertsHostFragment userAdvertsHostFragment, CardState cardState) {
        Objects.requireNonNull(userAdvertsHostFragment);
        if (cardState instanceof CardState.Loading) {
            ProfileHeaderView profileHeaderView = userAdvertsHostFragment.o;
            if (profileHeaderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            profileHeaderView.setLeftCardLoading();
        } else if (cardState instanceof CardState.Loaded) {
            ProfileHeaderView profileHeaderView2 = userAdvertsHostFragment.o;
            if (profileHeaderView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            CardState.Loaded loaded = (CardState.Loaded) cardState;
            profileHeaderView2.setLeftCardContent(loaded.getCardData());
            OnboardingData onboarding = loaded.getOnboarding();
            if (onboarding != null) {
                ProfileHeaderView profileHeaderView3 = userAdvertsHostFragment.o;
                if (profileHeaderView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
                }
                profileHeaderView3.showLeftCardTooltip(onboarding.getText(), onboarding.getCloseClickTarget());
            }
        } else if (cardState instanceof CardState.UpdateAnimation) {
            CardState.UpdateAnimation updateAnimation = (CardState.UpdateAnimation) cardState;
            int ordinal = updateAnimation.getUpdateInfo().getProgressState().ordinal();
            if (ordinal == 0) {
                ProfileHeaderView profileHeaderView4 = userAdvertsHostFragment.o;
                if (profileHeaderView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
                }
                profileHeaderView4.showSoaUpdateProgress(updateAnimation.getUpdateInfo().getUpdateText());
                UserAdvertsHostView userAdvertsHostView = userAdvertsHostFragment.n;
                if (userAdvertsHostView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advertsHostView");
                }
                userAdvertsHostView.scrollToHeader();
            } else if (ordinal == 1) {
                ProfileHeaderView profileHeaderView5 = userAdvertsHostFragment.o;
                if (profileHeaderView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
                }
                profileHeaderView5.collapseSoaUpdateProgress();
            }
        }
    }

    public static final void access$setRightCardState(UserAdvertsHostFragment userAdvertsHostFragment, CardState cardState) {
        Objects.requireNonNull(userAdvertsHostFragment);
        if (cardState instanceof CardState.Loading) {
            ProfileHeaderView profileHeaderView = userAdvertsHostFragment.o;
            if (profileHeaderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            profileHeaderView.setOrdersLoading();
        } else if (cardState instanceof CardState.Loaded) {
            ProfileHeaderView profileHeaderView2 = userAdvertsHostFragment.o;
            if (profileHeaderView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            profileHeaderView2.setOrdersInfo(((CardState.Loaded) cardState).getCardData());
        }
    }

    public static final void access$setTopCardState(UserAdvertsHostFragment userAdvertsHostFragment, CardState.Loaded loaded) {
        ProfileHeaderView profileHeaderView = userAdvertsHostFragment.o;
        if (profileHeaderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
        }
        profileHeaderView.setTopCardData(loaded.getCardData());
        OnboardingData onboarding = loaded.getOnboarding();
        if (onboarding != null) {
            ProfileHeaderView profileHeaderView2 = userAdvertsHostFragment.o;
            if (profileHeaderView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            profileHeaderView2.showTopCardTooltip(onboarding.getText(), onboarding.getCloseClickTarget());
        }
    }

    public static final void access$showAdvertSearch(UserAdvertsHostFragment userAdvertsHostFragment) {
        ActivityIntentFactory activityIntentFactory2 = userAdvertsHostFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        UserAdvertsHostPresenter userAdvertsHostPresenter = userAdvertsHostFragment.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostFragment.startForResult(activityIntentFactory2.mainScreenWithTab(new ProfileItemsSearchFragmentData(userAdvertsHostPresenter.getActiveTabShortcut())), 3);
    }

    public static final void access$showSoaInfoDialog(UserAdvertsHostFragment userAdvertsHostFragment, SoaInfoDialogData soaInfoDialogData) {
        SoaInfoBottomSheet soaInfoBottomSheet;
        SoaInfoBottomSheet soaInfoBottomSheet2 = userAdvertsHostFragment.r;
        if ((soaInfoBottomSheet2 != null ? Boolean.valueOf(soaInfoBottomSheet2.isShowing()) : null) == null || ((soaInfoBottomSheet = userAdvertsHostFragment.r) != null && !soaInfoBottomSheet.isShowing())) {
            Context requireContext = userAdvertsHostFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String titleText = soaInfoDialogData.getTitleText();
            CharSequence bodyText = soaInfoDialogData.getBodyText();
            String confirmButtonText = soaInfoDialogData.getConfirmButtonText();
            Image image = soaInfoDialogData.getImage();
            UserAdvertsHostViewModel userAdvertsHostViewModel = userAdvertsHostFragment.m;
            if (userAdvertsHostViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAdvertsViewModel");
            }
            SoaInfoBottomSheet soaInfoBottomSheet3 = new SoaInfoBottomSheet(requireContext, titleText, bodyText, confirmButtonText, image, new Function0<Unit>(userAdvertsHostViewModel) { // from class: a2.a.a.i3.c.a.h
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    ((UserAdvertsHostViewModel) this.receiver).closeSoaInfoDialog();
                    return Unit.INSTANCE;
                }
            });
            soaInfoBottomSheet3.show();
            soaInfoBottomSheet3.expand();
            userAdvertsHostFragment.r = soaInfoBottomSheet3;
        }
    }

    public static final void access$startNotificationCenterScreen(UserAdvertsHostFragment userAdvertsHostFragment) {
        ActivityIntentFactory activityIntentFactory2 = userAdvertsHostFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        userAdvertsHostFragment.startActivity(activityIntentFactory2.notificationCenterIntent());
    }

    public static final void access$startSettingsScreen(UserAdvertsHostFragment userAdvertsHostFragment) {
        ActivityIntentFactory activityIntentFactory2 = userAdvertsHostFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        userAdvertsHostFragment.startActivity(activityIntentFactory2.settingsIntent(userAdvertsHostFragment.currentTab()));
    }

    public static final void access$startUserProfileScreen(UserAdvertsHostFragment userAdvertsHostFragment) {
        ActivityIntentFactory activityIntentFactory2 = userAdvertsHostFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        userAdvertsHostFragment.startActivity(activityIntentFactory2.profilePreviewIntent());
    }

    @JvmStatic
    @NotNull
    public static final UserAdvertsHostFragment newInstance(@Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData, boolean z) {
        return Companion.newInstance(str, advertActionTransferData, z);
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
    public final Analytics getAnalytics$user_adverts_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$user_adverts_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartQuantityHandler$user_adverts_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @Override // com.avito.android.di.HasComponentDependencies
    @NotNull
    public CompositeComponentDependenciesProvider getDependencies() {
        return (CompositeComponentDependenciesProvider) this.v.getValue();
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
    public final UserAdvertsInteractor getInteractor() {
        UserAdvertsInteractor userAdvertsInteractor = this.interactor;
        if (userAdvertsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return userAdvertsInteractor;
    }

    @NotNull
    public final UserAdvertsHostPresenter getPresenter() {
        UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userAdvertsHostPresenter;
    }

    @NotNull
    public final ProfileHeaderViewModelFactory getProfileHeaderViewModelFactory() {
        ProfileHeaderViewModelFactory profileHeaderViewModelFactory2 = this.profileHeaderViewModelFactory;
        if (profileHeaderViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderViewModelFactory");
        }
        return profileHeaderViewModelFactory2;
    }

    @NotNull
    public final UserAdvertsTabTestGroup getTabTestGroup() {
        UserAdvertsTabTestGroup userAdvertsTabTestGroup = this.tabTestGroup;
        if (userAdvertsTabTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        return userAdvertsTabTestGroup;
    }

    @NotNull
    public final TabsDataProvider<TabItem> getTabsDataProvider() {
        TabsDataProvider<TabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        return tabsDataProvider2;
    }

    @NotNull
    public final UserAdvertsTracker getTracker$user_adverts_release() {
        UserAdvertsTracker userAdvertsTracker = this.tracker;
        if (userAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return userAdvertsTracker;
    }

    @NotNull
    public final UserAdvertsInfoUpdateRunner getUserAdvertsInfoUpdateRunner() {
        UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner2 = this.userAdvertsInfoUpdateRunner;
        if (userAdvertsInfoUpdateRunner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsInfoUpdateRunner");
        }
        return userAdvertsInfoUpdateRunner2;
    }

    @NotNull
    public final UserAdvertsHostViewModelFactory getViewModelFactory() {
        UserAdvertsHostViewModelFactory userAdvertsHostViewModelFactory = this.viewModelFactory;
        if (userAdvertsHostViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return userAdvertsHostViewModelFactory;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return Intrinsics.areEqual(navigationTabSetItem, NavigationTab.PROFILE.INSTANCE) || Intrinsics.areEqual(navigationTabSetItem, NavigationTab.USER_ADVERTS.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.s.post(new b(this, i, i2, intent));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Observable<NavigationTabSetItem> tabObservable;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof NavigationProvider)) {
            context = null;
        }
        NavigationProvider navigationProvider = (NavigationProvider) context;
        if (navigationProvider != null && (tabObservable = navigationProvider.getTabObservable()) != null) {
            Disposable subscribe = InteropKt.toV2(tabObservable).subscribe(new c(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "it.toV2().subscribe {\n  …          }\n            }");
            this.k = subscribe;
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter.Router
    public void onAuthentificationFailed() {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof Router)) {
            ((Router) activity).closeScreen();
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle != null ? bundle.getBundle("presenter_state") : null;
        Timer B1 = a2.b.a.a.a.B1();
        UserAdvertsHostFragmentComponent.Builder userAdvertsHostFragmentDependencies = DaggerUserAdvertsHostFragmentComponent.builder().userAdvertsHostFragmentDependencies((UserAdvertsHostFragmentDependencies) ComponentDependenciesKt.getDependencies(UserAdvertsHostFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        UserAdvertsHostFragmentComponent.Builder fragmentManager = userAdvertsHostFragmentDependencies.fragmentManager(childFragmentManager);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        UserAdvertsHostFragmentComponent build = fragmentManager.resources(resources).withFormatter(new AttributedTextFormatterImpl()).withViewModelStoreOwner(this).state(bundle2).defaultShortcut(null).build();
        this.q = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        build.inject(this);
        UserAdvertsTracker userAdvertsTracker = this.tracker;
        if (userAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userAdvertsTracker.trackDiInject(B1.elapsed());
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        String string;
        AdvertActionTransferData advertActionTransferData;
        String categoryId;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserAdvertsTracker userAdvertsTracker = this.tracker;
        if (userAdvertsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userAdvertsTracker.startInit();
        setHasOptionsMenu(true);
        View inflate = layoutInflater.inflate(R.layout.user_adverts_content_tab_fragment, viewGroup, false);
        TabsDataProvider<TabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(tabsDataProvider2, requireActivity, com.avito.android.ui_components.R.layout.tab_shortcut_with_static_counter);
        UserAdvertsTabTestGroup userAdvertsTabTestGroup = this.tabTestGroup;
        if (userAdvertsTabTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        if (userAdvertsTabTestGroup.isFloatingAddAdvertButton()) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            View findViewById = inflate.findViewById(R.id.publish_fab_stub);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            View inflate2 = ((ViewStub) findViewById).inflate();
            Intrinsics.checkNotNullExpressionValue(inflate2, "view.findView<ViewStub>(…blish_fab_stub).inflate()");
            this.p = new PublishFab(inflate2, new d(this));
        }
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        TabsDataProvider<TabItem> tabsDataProvider3 = this.tabsDataProvider;
        if (tabsDataProvider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        UserAdvertsTabTestGroup userAdvertsTabTestGroup2 = this.tabTestGroup;
        if (userAdvertsTabTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        PublishFab publishFab = this.p;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.n = new UserAdvertsHostViewImpl(viewGroup2, childFragmentManager, userAdvertsHostPresenter, tabLayoutAdapter, tabsDataProvider3, deepLinkIntentFactory2, userAdvertsTabTestGroup2, publishFab, analytics2);
        UserAdvertsHostPresenter userAdvertsHostPresenter2 = this.presenter;
        if (userAdvertsHostPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter2.setUserCanBeLogout(true);
        UserAdvertsHostPresenter userAdvertsHostPresenter3 = this.presenter;
        if (userAdvertsHostPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        UserAdvertsHostView userAdvertsHostView = this.n;
        if (userAdvertsHostView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsHostView");
        }
        userAdvertsHostPresenter3.attachView(userAdvertsHostView);
        UserAdvertsHostPresenter userAdvertsHostPresenter4 = this.presenter;
        if (userAdvertsHostPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter4.attachRouter(this);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            UserAdvertsTabTestGroup userAdvertsTabTestGroup3 = this.tabTestGroup;
            if (userAdvertsTabTestGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
            }
            if (!userAdvertsTabTestGroup3.isTest()) {
                View findViewById2 = inflate.findViewById(R.id.cart_fab_stub);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewStub");
                View inflate3 = ((ViewStub) findViewById2).inflate();
                Objects.requireNonNull(inflate3, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
                CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate3;
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
                DeepLinkIntentFactory deepLinkIntentFactory3 = this.deepLinkIntentFactory;
                if (deepLinkIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
                }
                new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory3);
            }
        }
        UserAdvertsHostViewModelFactory userAdvertsHostViewModelFactory = this.viewModelFactory;
        if (userAdvertsHostViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, userAdvertsHostViewModelFactory).get(UserAdvertsHostViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(\n …ostViewModel::class.java)");
        UserAdvertsHostViewModel userAdvertsHostViewModel = (UserAdvertsHostViewModel) viewModel;
        this.m = userAdvertsHostViewModel;
        if (userAdvertsHostViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsViewModel");
        }
        userAdvertsHostViewModel.init();
        UserAdvertsHostViewModel userAdvertsHostViewModel2 = this.m;
        if (userAdvertsHostViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsViewModel");
        }
        userAdvertsHostViewModel2.getState().observe(getViewLifecycleOwner(), new e(this));
        UserAdvertsHostViewModel userAdvertsHostViewModel3 = this.m;
        if (userAdvertsHostViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsViewModel");
        }
        userAdvertsHostViewModel3.getMessage().observe(getViewLifecycleOwner(), new f(this));
        ProfileHeaderViewModelFactory profileHeaderViewModelFactory2 = this.profileHeaderViewModelFactory;
        if (profileHeaderViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderViewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.of(this, profileHeaderViewModelFactory2).get(ProfileHeaderViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.l = (ProfileHeaderViewModel) viewModel2;
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        UserAdvertsTabTestGroup userAdvertsTabTestGroup4 = this.tabTestGroup;
        if (userAdvertsTabTestGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.stub_soa_statistics_and_orders_panel);
        Intrinsics.checkNotNullExpressionValue(viewStub, "headerViewStub");
        if (userAdvertsTabTestGroup4.isTest()) {
            i = R.layout.user_adverts_root_header_menu_panel;
        } else {
            i = R.layout.user_adverts_header_menu_panel;
        }
        viewStub.setLayoutResource(i);
        View inflate4 = viewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate4, "soaAndOrdersView");
        ProfileHeaderMenuPanelViewImpl profileHeaderMenuPanelViewImpl = new ProfileHeaderMenuPanelViewImpl(inflate, new LeftCardViewImpl(inflate4), new OrdersViewImpl(inflate4));
        UserAdvertsTabTestGroup userAdvertsTabTestGroup5 = this.tabTestGroup;
        if (userAdvertsTabTestGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        this.o = new ProfileHeaderViewImpl(inflate, features3, profileHeaderMenuPanelViewImpl, userAdvertsTabTestGroup5);
        ProfileHeaderViewModel profileHeaderViewModel = this.l;
        if (profileHeaderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel.getNotificationCounter().observe(getViewLifecycleOwner(), new a2.a.a.i3.c.a.b(this));
        ProfileHeaderViewModel profileHeaderViewModel2 = this.l;
        if (profileHeaderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        LiveData<Boolean> profileItemsSearch = profileHeaderViewModel2.getProfileItemsSearch();
        Boolean value = profileItemsSearch.getValue();
        if (value != null) {
            ProfileHeaderView profileHeaderView = this.o;
            if (profileHeaderView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
            }
            Intrinsics.checkNotNullExpressionValue(value, "it");
            profileHeaderView.showItemsSearch(value.booleanValue());
        }
        profileItemsSearch.observe(getViewLifecycleOwner(), new a2.a.a.i3.c.a.a(this));
        ProfileHeaderViewModel profileHeaderViewModel3 = this.l;
        if (profileHeaderViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel3.getProfileInfo().observe(getViewLifecycleOwner(), new a2.a.a.i3.c.a.c(this));
        ProfileHeaderViewModel profileHeaderViewModel4 = this.l;
        if (profileHeaderViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel4.getRouter().observe(getViewLifecycleOwner(), new a2.a.a.i3.c.a.d(this));
        ProfileHeaderViewModel profileHeaderViewModel5 = this.l;
        if (profileHeaderViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel5.getMenuPanelState().observe(getViewLifecycleOwner(), new a2.a.a.i3.c.a.e(this));
        CompositeDisposable compositeDisposable = this.j;
        ProfileHeaderView profileHeaderView2 = this.o;
        if (profileHeaderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
        }
        Disposable subscribe = profileHeaderView2.getSoaProgressCollapsedEvents().subscribe(new a2.a.a.i3.c.a.f(this), i2.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "profileHeaderView.soaPro…apse\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.j;
        ProfileHeaderView profileHeaderView3 = this.o;
        if (profileHeaderView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileHeaderView");
        }
        Disposable subscribe2 = profileHeaderView3.getClicks().subscribe(new g(this), i2.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "profileHeaderView.clicks…er click\", it)\n        })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        UserAdvertsHostPresenter userAdvertsHostPresenter5 = this.presenter;
        if (userAdvertsHostPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ProfileHeaderViewModel profileHeaderViewModel6 = this.l;
        if (profileHeaderViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        userAdvertsHostPresenter5.setHeaderViewModel(profileHeaderViewModel6);
        Bundle arguments = getArguments();
        if (!(arguments == null || (advertActionTransferData = (AdvertActionTransferData) arguments.getParcelable(UserAdvertConstants.KEY_ADVERT_ACTION)) == null)) {
            UserAdvertsHostPresenter userAdvertsHostPresenter6 = this.presenter;
            if (userAdvertsHostPresenter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            UserAdvertsHostPresenter.DefaultImpls.onAdvertStatusChanged$default(userAdvertsHostPresenter6, advertActionTransferData.getMessage(), false, null, null, 12, null);
            if (advertActionTransferData.getActionType() == AdvertActionTransferData.Type.ACTIVATE && (categoryId = advertActionTransferData.getCategoryId()) != null) {
                UserAdvertsHostPresenter userAdvertsHostPresenter7 = this.presenter;
                if (userAdvertsHostPresenter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                userAdvertsHostPresenter7.loadSafetyInfo(categoryId);
            }
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string = arguments2.getString(UserAdvertsHostFragmentKt.KEY_SELECTED_SHORTCUT)) == null)) {
            UserAdvertsHostPresenter userAdvertsHostPresenter8 = this.presenter;
            if (userAdvertsHostPresenter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Intrinsics.checkNotNullExpressionValue(string, "it");
            userAdvertsHostPresenter8.openTabWithShortcut(string);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.t, new IntentFilter(VasConstants.VAS_PAYMENT_OK_INTENT));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.registerReceiver(this.u, new IntentFilter(UserAdvertConstantsKt.USER_ADVERT_STATUS_CHANGE_INTENT));
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner2 = this.userAdvertsInfoUpdateRunner;
            if (userAdvertsInfoUpdateRunner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAdvertsInfoUpdateRunner");
            }
            Intrinsics.checkNotNullExpressionValue(activity3, "it");
            Context applicationContext = activity3.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            userAdvertsInfoUpdateRunner2.requestUpdate(applicationContext);
        }
        UserAdvertsTracker userAdvertsTracker2 = this.tracker;
        if (userAdvertsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userAdvertsTracker2.trackInit();
        Bundle arguments3 = getArguments();
        if (arguments3 != null && arguments3.getBoolean(UserAdvertsHostFragmentKt.KEY_OPEN_PUBLISH, false)) {
            UserAdvertsHostPresenter userAdvertsHostPresenter9 = this.presenter;
            if (userAdvertsHostPresenter9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userAdvertsHostPresenter9.onAddAdvertClicked();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter.detachRouter();
        UserAdvertsHostPresenter userAdvertsHostPresenter2 = this.presenter;
        if (userAdvertsHostPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter2.detachView();
        this.j.clear();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.t);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.unregisterReceiver(this.u);
        }
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.k.dispose();
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ProfileHeaderViewModel profileHeaderViewModel = this.l;
        if (profileHeaderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel.dispose();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter.onResume();
        ProfileHeaderViewModel profileHeaderViewModel = this.l;
        if (profileHeaderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel.onUpdateNotifications();
        ProfileHeaderViewModel profileHeaderViewModel2 = this.l;
        if (profileHeaderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewModel");
        }
        profileHeaderViewModel2.updateSoaIfNecessary();
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
        UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
        if (userAdvertsHostPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", userAdvertsHostPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.s.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        UserAdvertsHostView userAdvertsHostView = this.n;
        if (userAdvertsHostView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsHostView");
        }
        userAdvertsHostView.scrollToUp();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics$user_adverts_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCartFabViewModel$user_adverts_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCartQuantityHandler$user_adverts_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setInteractor(@NotNull UserAdvertsInteractor userAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(userAdvertsInteractor, "<set-?>");
        this.interactor = userAdvertsInteractor;
    }

    public final void setPresenter(@NotNull UserAdvertsHostPresenter userAdvertsHostPresenter) {
        Intrinsics.checkNotNullParameter(userAdvertsHostPresenter, "<set-?>");
        this.presenter = userAdvertsHostPresenter;
    }

    public final void setProfileHeaderViewModelFactory(@NotNull ProfileHeaderViewModelFactory profileHeaderViewModelFactory2) {
        Intrinsics.checkNotNullParameter(profileHeaderViewModelFactory2, "<set-?>");
        this.profileHeaderViewModelFactory = profileHeaderViewModelFactory2;
    }

    public final void setTabTestGroup(@NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "<set-?>");
        this.tabTestGroup = userAdvertsTabTestGroup;
    }

    public final void setTabsDataProvider(@NotNull TabsDataProvider<TabItem> tabsDataProvider2) {
        Intrinsics.checkNotNullParameter(tabsDataProvider2, "<set-?>");
        this.tabsDataProvider = tabsDataProvider2;
    }

    public final void setTracker$user_adverts_release(@NotNull UserAdvertsTracker userAdvertsTracker) {
        Intrinsics.checkNotNullParameter(userAdvertsTracker, "<set-?>");
        this.tracker = userAdvertsTracker;
    }

    public final void setUserAdvertsInfoUpdateRunner(@NotNull UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner2) {
        Intrinsics.checkNotNullParameter(userAdvertsInfoUpdateRunner2, "<set-?>");
        this.userAdvertsInfoUpdateRunner = userAdvertsInfoUpdateRunner2;
    }

    public final void setViewModelFactory(@NotNull UserAdvertsHostViewModelFactory userAdvertsHostViewModelFactory) {
        Intrinsics.checkNotNullParameter(userAdvertsHostViewModelFactory, "<set-?>");
        this.viewModelFactory = userAdvertsHostViewModelFactory;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter.Router
    public void showAddAdvert() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.newAdvert());
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter.Router
    public void showLoginScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent authIntent$default = AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.OPEN_USER_ADVERTS, null, 5, null);
        authIntent$default.setFlags(603979776);
        startActivityForResult(authIntent$default, 2);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.UpdatableTabFragment
    public boolean updateWithNewData(@NotNull TabFragmentFactory.Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof UserAdvertsFragmentData)) {
            return false;
        }
        UserAdvertsFragmentData userAdvertsFragmentData = (UserAdvertsFragmentData) data;
        if (userAdvertsFragmentData.getShortcut() != null) {
            UserAdvertsHostPresenter userAdvertsHostPresenter = this.presenter;
            if (userAdvertsHostPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userAdvertsHostPresenter.openTabWithShortcut(userAdvertsFragmentData.getShortcut());
        } else {
            UserAdvertsHostPresenter userAdvertsHostPresenter2 = this.presenter;
            if (userAdvertsHostPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userAdvertsHostPresenter2.onNewAdvertCreated();
        }
        if (!userAdvertsFragmentData.getOpenPublish()) {
            return true;
        }
        UserAdvertsHostPresenter userAdvertsHostPresenter3 = this.presenter;
        if (userAdvertsHostPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsHostPresenter3.onAddAdvertClicked();
        return true;
    }
}
