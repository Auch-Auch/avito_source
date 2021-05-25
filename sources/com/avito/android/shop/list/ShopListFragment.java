package com.avito.android.shop.list;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.DisplayShopsScreenEvent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.UpNavigationHandler;
import com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.shop.list.di.DaggerShopListComponent;
import com.avito.android.shop.list.di.ShopListComponent;
import com.avito.android.shop.list.presentation.ShopListDataChangeListener;
import com.avito.android.shop.list.presentation.ShopListPresenter;
import com.avito.android.shop.list.presentation.ShopListRouter;
import com.avito.android.shop.list.presentation.ShopListView;
import com.avito.android.shop.list.presentation.ShopListViewImpl;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004Â\u0001Ã\u0001B\b¢\u0006\u0005\bÁ\u0001\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0014J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J!\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b=\u0010\bR\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010`\u001a\u00020_8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R*\u0010»\u0001\u001a\u00030º\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001¨\u0006Ä\u0001"}, d2 = {"Lcom/avito/android/shop/list/ShopListFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/shop/list/presentation/ShopListRouter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onStart", "onStop", "outState", "onSaveInstanceState", "onResume", "onDestroy", "", "onBackPressed", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "shopId", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "openShopDetailsScreen", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)V", "close", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "showClarifyScreen", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)V", Constants.LOCATION_NAME, "openShortcut", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;)V", "Landroid/net/Uri;", "link", "openLink", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onViewStateRestored", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "getSpanProvider", "()Lcom/avito/android/serp/adapter/SerpSpanProvider;", "setSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/shop/list/di/ShopListComponent;", "k", "Lcom/avito/android/shop/list/di/ShopListComponent;", "component", "Lcom/avito/android/shop/list/presentation/ShopListView;", "j", "Lcom/avito/android/shop/list/presentation/ShopListView;", "shopsListView", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "l", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "currentTab", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "interactor", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "getInteractor", "()Lcom/avito/android/shop/list/business/ShopListInteractor;", "setInteractor", "(Lcom/avito/android/shop/list/business/ShopListInteractor;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "shopListDataChangeListener", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "getShopListDataChangeListener", "()Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "setShopListDataChangeListener", "(Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "getFloatingViewsPresenter", "()Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "setFloatingViewsPresenter", "(Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/shop/list/analytic/ShopListTracker;", "shopListTracker", "Lcom/avito/android/shop/list/analytic/ShopListTracker;", "getShopListTracker", "()Lcom/avito/android/shop/list/analytic/ShopListTracker;", "setShopListTracker", "(Lcom/avito/android/shop/list/analytic/ShopListTracker;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "presenter", "Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "getPresenter", "()Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "setPresenter", "(Lcom/avito/android/shop/list/presentation/ShopListPresenter;)V", "<init>", "ActivityCallback", "Factory", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListFragment extends TabBaseFragment implements ShopListRouter, OnBackPressedListener {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public BuildInfo buildInfo;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public PersistableFloatingViewsPresenter floatingViewsPresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ShopListInteractor interactor;
    public ShopListView j;
    public ShopListComponent k;
    public NavigationTabSetItem l;
    @Inject
    public ShopListPresenter presenter;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public ShopListDataChangeListener shopListDataChangeListener;
    @Inject
    public ShopListTracker shopListTracker;
    @Inject
    public SerpSpanProvider spanProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public DestroyableViewHolderBuilder viewHolderBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/shop/list/ShopListFragment$ActivityCallback;", "", "", "onShopsListClose", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public interface ActivityCallback {
        void onShopsListClose();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/shop/list/ShopListFragment$Factory;", "", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "params", "", Constants.LOCATION_NAME, "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/shop/list/ShopListFragment;", "createFragment", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/shop/list/ShopListFragment;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ ShopListFragment createFragment$default(Factory factory, ShopsSearchParameters shopsSearchParameters, String str, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
            if ((i & 4) != 0) {
                navigationTabSetItem = null;
            }
            return factory.createFragment(shopsSearchParameters, str, navigationTabSetItem);
        }

        @NotNull
        public final ShopListFragment createFragment(@NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str, @Nullable NavigationTabSetItem navigationTabSetItem) {
            Intrinsics.checkNotNullParameter(shopsSearchParameters, "params");
            ShopListFragment shopListFragment = new ShopListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_arguments", shopsSearchParameters);
            bundle.putString("key_location_name", str);
            bundle.putParcelable("shops_key_current_tab", navigationTabSetItem);
            Unit unit = Unit.INSTANCE;
            shopListFragment.setArguments(bundle);
            return shopListFragment;
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void close() {
        Context context = getContext();
        if (context instanceof ActivityCallback) {
            ((ActivityCallback) context).onShopsListClose();
        } else if (context instanceof UpNavigationHandler) {
            ((UpNavigationHandler) context).handleUpNavigation();
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
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
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ShopListInteractor getInteractor() {
        ShopListInteractor shopListInteractor = this.interactor;
        if (shopListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return shopListInteractor;
    }

    @NotNull
    public final ShopListPresenter getPresenter() {
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return shopListPresenter;
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
    public final ShopListDataChangeListener getShopListDataChangeListener() {
        ShopListDataChangeListener shopListDataChangeListener2 = this.shopListDataChangeListener;
        if (shopListDataChangeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListDataChangeListener");
        }
        return shopListDataChangeListener2;
    }

    @NotNull
    public final ShopListTracker getShopListTracker() {
        ShopListTracker shopListTracker2 = this.shopListTracker;
        if (shopListTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListTracker");
        }
        return shopListTracker2;
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
    public final DestroyableViewHolderBuilder getViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            ShopsSearchParameters shopsSearchParameters = (ShopsSearchParameters) intent.getParcelableExtra("search_params");
            CaseText caseText = (CaseText) intent.getParcelableExtra(Constants.LOCATION_NAMES);
            if (shopsSearchParameters != null && caseText != null) {
                ShopListPresenter shopListPresenter = this.presenter;
                if (shopListPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                shopListPresenter.onSearchParametersChanged(shopsSearchParameters, caseText);
            }
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopListTracker shopListTracker2 = this.shopListTracker;
        if (shopListTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListTracker");
        }
        shopListTracker2.startInit();
        View inflate = layoutInflater.inflate(R.layout.shop_list_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(layoutId, container, false)");
        return inflate;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopListPresenter.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ShopListDataChangeListener shopListDataChangeListener2 = this.shopListDataChangeListener;
        if (shopListDataChangeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListDataChangeListener");
        }
        shopListDataChangeListener2.detachAdapterPresenter();
        shopListDataChangeListener2.detachPositionsProvider();
        shopListDataChangeListener2.detachSpanProvider();
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter.detachAll();
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopListPresenter.detachView();
        ShopListView shopListView = this.j;
        if (shopListView != null) {
            shopListView.dispose();
        }
        this.j = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new DisplayShopsScreenEvent());
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "key_presenter_state", shopListPresenter.onSaveState());
        ShopListInteractor shopListInteractor = this.interactor;
        if (shopListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        Bundles.putKundle(bundle, "key_interactor_state", shopListInteractor.saveState());
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        bundle.putBundle("key_floating_views_state", persistableFloatingViewsPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopListPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopListPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view;
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
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
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        ShopListDataChangeListener shopListDataChangeListener2 = this.shopListDataChangeListener;
        if (shopListDataChangeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListDataChangeListener");
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        ShopListViewImpl shopListViewImpl = new ShopListViewImpl(viewGroup, destroyableViewHolderBuilder, adapterPresenter2, analytics2, buildInfo2, spannedGridPositionProvider, spanSizeLookup2, serpSpanProvider, persistableFloatingViewsPresenter, schedulersFactory3, shopListDataChangeListener2, features2.getLoadFontsFromAssets().invoke().booleanValue());
        this.j = shopListViewImpl;
        ShopListPresenter shopListPresenter = this.presenter;
        if (shopListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopListPresenter.attachView(shopListViewImpl);
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter2 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter2.attachSubscriber(shopListViewImpl);
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter3 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        ShopListPresenter shopListPresenter2 = this.presenter;
        if (shopListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        persistableFloatingViewsPresenter3.attachAppendingListener(shopListPresenter2);
        ShopListTracker shopListTracker2 = this.shopListTracker;
        if (shopListTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListTracker");
        }
        shopListTracker2.trackInit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        NavigationTabSetItem navigationTabSetItem = this.l;
        if (navigationTabSetItem != null) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof OnAddButtonStateChangeListener)) {
                activity = null;
            }
            OnAddButtonStateChangeListener onAddButtonStateChangeListener = (OnAddButtonStateChangeListener) activity;
            if (onAddButtonStateChangeListener != null) {
                onAddButtonStateChangeListener.onAddButtonStateChange(navigationTabSetItem, AddButtonState.SMALL);
            }
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void openLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "link");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Intent uriIntent = implicitIntentFactory2.uriIntent(uri);
        IntentsKt.replaceTargetTabIfRequired(uriIntent, this.l);
        FragmentsKt.startActivitySafely(this, uriIntent);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void openShopDetailsScreen(@NotNull String str, @NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.shopDetailedIntent(str, null, null, searchParams));
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void openShortcut(@NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        getParentFragmentManager().beginTransaction().addToBackStack(null).replace(com.avito.android.ui_components.R.id.fragment_container, new Factory().createFragment(shopsSearchParameters, str, this.l)).commitAllowingStateLoss();
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.executePendingTransactions();
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
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

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setInteractor(@NotNull ShopListInteractor shopListInteractor) {
        Intrinsics.checkNotNullParameter(shopListInteractor, "<set-?>");
        this.interactor = shopListInteractor;
    }

    public final void setPresenter(@NotNull ShopListPresenter shopListPresenter) {
        Intrinsics.checkNotNullParameter(shopListPresenter, "<set-?>");
        this.presenter = shopListPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setShopListDataChangeListener(@NotNull ShopListDataChangeListener shopListDataChangeListener2) {
        Intrinsics.checkNotNullParameter(shopListDataChangeListener2, "<set-?>");
        this.shopListDataChangeListener = shopListDataChangeListener2;
    }

    public final void setShopListTracker(@NotNull ShopListTracker shopListTracker2) {
        Intrinsics.checkNotNullParameter(shopListTracker2, "<set-?>");
        this.shopListTracker = shopListTracker2;
    }

    public final void setSpanProvider(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, "<set-?>");
        this.spanProvider = serpSpanProvider;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Parcelable parcelable = requireArguments().getParcelable("key_arguments");
        Intrinsics.checkNotNull(parcelable);
        ShopsSearchParameters shopsSearchParameters = (ShopsSearchParameters) parcelable;
        String string = requireArguments().getString("key_location_name");
        NavigationTab navigationTab = null;
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "key_presenter_state") : null;
        Kundle kundle2 = bundle != null ? Bundles.getKundle(bundle, "key_interactor_state") : null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("key_floating_views_state") : null;
        Bundle arguments = getArguments();
        NavigationTab navigationTab2 = arguments != null ? (NavigationTab) arguments.getParcelable("shops_key_current_tab") : null;
        if (navigationTab2 instanceof NavigationTab) {
            navigationTab = navigationTab2;
        }
        this.l = navigationTab;
        Timer B1 = a.B1();
        ShopListComponent.Builder locationDependencies = DaggerShopListComponent.builder().shopDetailedDependencies((ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        ShopListComponent build = locationDependencies.withResources(resources).withSearchParams(shopsSearchParameters).withLocationName(string).withPresenterState(kundle).withInteractorState(kundle2).withFloatingViewState(bundle2).withSpanCount(1).build();
        this.k = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        build.inject(this);
        ShopListTracker shopListTracker2 = this.shopListTracker;
        if (shopListTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopListTracker");
        }
        shopListTracker2.trackDiInject(B1.elapsed());
        return true;
    }

    public final void setViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListRouter
    public void showClarifyScreen(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.shopsFilterIntent(shopsSearchParameters), 1);
    }
}
