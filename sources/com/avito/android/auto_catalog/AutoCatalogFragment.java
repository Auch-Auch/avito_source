package com.avito.android.auto_catalog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.auto_catalog.di.AutoCatalogComponent;
import com.avito.android.auto_catalog.di.AutoCatalogDependencies;
import com.avito.android.auto_catalog.di.DaggerAutoCatalogComponent;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.tracker.AutoCatalogTracker;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectActivityKt;
import com.avito.android.select.SelectResult;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u0002:\u0002¾\u0001B\b¢\u0006\u0005\b½\u0001\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u0019\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&JG\u0010-\u001a\u00020\b2\u0006\u0010$\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0*0)2\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0*0)H\u0016¢\u0006\u0004\b-\u0010.J)\u00102\u001a\u00020\b2\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020#H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b;\u0010<R\"\u0010D\u001a\u00020=8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010[\u001a\u00020Z8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010i\u001a\u00020h8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010p\u001a\u00020o8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010w\u001a\u00020v8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R&\u0010~\u001a\u00020}8\u0006@\u0006X.¢\u0006\u0016\n\u0004\b~\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R*\u0010¢\u0001\u001a\u00030¡\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b­\u0001\u0010®\u0001R*\u0010°\u0001\u001a\u00030¯\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R*\u0010·\u0001\u001a\u00030¶\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001¨\u0006¿\u0001"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/auto_catalog/AutoCatalogFragmentDelegate;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "outState", "onSaveInstanceState", "closeScreen", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "", "requestId", "launchActivityForResult", "(Landroid/content/Intent;I)V", "", "title", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValue", ResidentialComplexModuleKt.VALUES, "launchSelectScreenForResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "stringId", "launchToast", "(I)V", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "l", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/android/recycler/base/SafeRecyclerAdapter;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "getSpanProvider", "()Lcom/avito/android/serp/adapter/SerpSpanProvider;", "setSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/auto_catalog/tracker/AutoCatalogTracker;", "tracker", "Lcom/avito/android/auto_catalog/tracker/AutoCatalogTracker;", "getTracker", "()Lcom/avito/android/auto_catalog/tracker/AutoCatalogTracker;", "setTracker", "(Lcom/avito/android/auto_catalog/tracker/AutoCatalogTracker;)V", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "k", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "autoCatalogRouter", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "j", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "autoCatalogView", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "resourceProvider", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "getResourceProvider", "()Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "setResourceProvider", "(Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;)V", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "presenter", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "getPresenter", "()Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "setPresenter", "(Lcom/avito/android/auto_catalog/AutoCatalogPresenter;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "<init>", "Companion", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogFragment extends TabBaseFragment implements AutoCatalogFragmentDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public Features features;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public AutoCatalogView j;
    public AutoCatalogRouter k;
    @NotNull
    public NavigationState l = new NavigationState(false);
    @Inject
    public AutoCatalogPresenter presenter;
    @Inject
    public SafeRecyclerAdapter recyclerAdapter;
    @Inject
    public AutoCatalogResourceProvider resourceProvider;
    @Inject
    public SerpSpanProvider spanProvider;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public AutoCatalogTracker tracker;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogFragment$Companion;", "", "Lcom/avito/android/auto_catalog/AutoCatalogArguments;", "arguments", "Lcom/avito/android/auto_catalog/AutoCatalogFragment;", "newInstance", "(Lcom/avito/android/auto_catalog/AutoCatalogArguments;)Lcom/avito/android/auto_catalog/AutoCatalogFragment;", "<init>", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ AutoCatalogArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AutoCatalogArguments autoCatalogArguments) {
                super(1);
                this.a = autoCatalogArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("auto_catalog_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final AutoCatalogFragment newInstance(@NotNull AutoCatalogArguments autoCatalogArguments) {
            Intrinsics.checkNotNullParameter(autoCatalogArguments, "arguments");
            return (AutoCatalogFragment) FragmentsKt.arguments$default(new AutoCatalogFragment(), 0, new a(autoCatalogArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentManagerDelegate
    @NotNull
    public FragmentManager childFragmentManager() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    public void closeScreen() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getAutoCatalogWithoutActivity().invoke().booleanValue() || (getActivity() instanceof AutoCatalogActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        finish();
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.l;
    }

    @NotNull
    public final AutoCatalogPresenter getPresenter() {
        AutoCatalogPresenter autoCatalogPresenter = this.presenter;
        if (autoCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return autoCatalogPresenter;
    }

    @NotNull
    public final SafeRecyclerAdapter getRecyclerAdapter() {
        SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return safeRecyclerAdapter;
    }

    @NotNull
    public final AutoCatalogResourceProvider getResourceProvider() {
        AutoCatalogResourceProvider autoCatalogResourceProvider = this.resourceProvider;
        if (autoCatalogResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return autoCatalogResourceProvider;
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
    public final AutoCatalogTracker getTracker() {
        AutoCatalogTracker autoCatalogTracker = this.tracker;
        if (autoCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return autoCatalogTracker;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    public void launchActivity(@Nullable Intent intent) {
        startActivity(intent);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    public void launchActivityForResult(@Nullable Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    public void launchSelectScreenForResult(@NotNull String str, @NotNull String str2, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull List<? extends ParcelableEntity<String>> list2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "selectedValue");
        Intrinsics.checkNotNullParameter(list2, ResidentialComplexModuleKt.VALUES);
        Context context = getContext();
        if (context != null) {
            startActivityForResult(SelectActivityKt.createSelectActivityIntent(context, new Arguments(str, list2, list, str2, false, false, false, false, true, false, null, false, false, null, 15872, null)), 2);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    public void launchToast(int i) {
        Context context = getContext();
        if (context != null) {
            ToastsKt.showToast(context, i, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        SelectResult extractSelectResult;
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            View view = getView();
            if (view != null) {
                Keyboards.hideKeyboardWithAttempt$default(view, 0, 0, 3, null);
            }
        } else if (i == 2 && (extractSelectResult = SelectActivityKt.extractSelectResult(intent)) != null) {
            AutoCatalogPresenter autoCatalogPresenter = this.presenter;
            if (autoCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoCatalogPresenter.onSelectSpecsResult((String) ((ParcelableEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) extractSelectResult.getSelectedItems())).getId());
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!features().getAutoCatalogWithoutActivity().invoke().booleanValue() && bundle != null) {
            AutoCatalogPresenter autoCatalogPresenter = this.presenter;
            if (autoCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoCatalogPresenter.restoreState(bundle.getBundle("developmentsCatalogPresenter"));
        }
        if (this.k == null) {
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
            if (implicitIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            this.k = new AutoCatalogRouterImpl(deepLinkIntentFactory2, activityIntentFactory2, implicitIntentFactory2, resources, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (features().getAutoCatalogWithoutActivity().invoke().booleanValue()) {
            AutoCatalogPresenter autoCatalogPresenter = this.presenter;
            if (autoCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Bundle retainStorage = retainStorage();
            autoCatalogPresenter.restoreState(retainStorage != null ? retainStorage.getBundle("developmentsCatalogPresenter") : null);
        }
        return layoutInflater.inflate(R.layout.fragment_auto_catalog, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AutoCatalogView autoCatalogView = this.j;
        if (autoCatalogView != null) {
            autoCatalogView.detach();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        AutoCatalogTracker autoCatalogTracker = this.tracker;
        if (autoCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        autoCatalogTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        AutoCatalogTracker autoCatalogTracker = this.tracker;
        if (autoCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        autoCatalogTracker.attach();
        super.onResume();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getAutoCatalogWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            AutoCatalogPresenter autoCatalogPresenter = this.presenter;
            if (autoCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            bundle2.putBundle("developmentsCatalogPresenter", autoCatalogPresenter.saveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        AutoCatalogPresenter autoCatalogPresenter2 = this.presenter;
        if (autoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("developmentsCatalogPresenter", autoCatalogPresenter2.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AutoCatalogView autoCatalogView = this.j;
        if (autoCatalogView != null) {
            AutoCatalogPresenter autoCatalogPresenter = this.presenter;
            if (autoCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoCatalogPresenter.attachView(autoCatalogView);
        }
        AutoCatalogPresenter autoCatalogPresenter2 = this.presenter;
        if (autoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autoCatalogPresenter2.attachRouter(this.k);
        AutoCatalogPresenter autoCatalogPresenter3 = this.presenter;
        if (autoCatalogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autoCatalogPresenter3.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AutoCatalogPresenter autoCatalogPresenter = this.presenter;
        if (autoCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autoCatalogPresenter.onStop();
        AutoCatalogPresenter autoCatalogPresenter2 = this.presenter;
        if (autoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autoCatalogPresenter2.detachRouter();
        AutoCatalogPresenter autoCatalogPresenter3 = this.presenter;
        if (autoCatalogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        autoCatalogPresenter3.detachView();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        SerpSpanProvider serpSpanProvider = this.spanProvider;
        if (serpSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        AutoCatalogResourceProvider autoCatalogResourceProvider = this.resourceProvider;
        if (autoCatalogResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        AutoCatalogPresenter autoCatalogPresenter = this.presenter;
        if (autoCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AutoCatalogPresenter autoCatalogPresenter2 = this.presenter;
        if (autoCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AutoCatalogViewImpl autoCatalogViewImpl = new AutoCatalogViewImpl(view, adapterPresenter2, safeRecyclerAdapter, serpSpanProvider, spannedGridPositionProvider, spanSizeLookup2, favoriteAdvertsPresenter2, viewedAdvertsPresenter2, autoCatalogResourceProvider, deviceMetrics2, autoCatalogPresenter, autoCatalogPresenter2);
        autoCatalogViewImpl.attach();
        Unit unit = Unit.INSTANCE;
        this.j = autoCatalogViewImpl;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.l = navigationState;
    }

    public final void setPresenter(@NotNull AutoCatalogPresenter autoCatalogPresenter) {
        Intrinsics.checkNotNullParameter(autoCatalogPresenter, "<set-?>");
        this.presenter = autoCatalogPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SafeRecyclerAdapter safeRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = safeRecyclerAdapter;
    }

    public final void setResourceProvider(@NotNull AutoCatalogResourceProvider autoCatalogResourceProvider) {
        Intrinsics.checkNotNullParameter(autoCatalogResourceProvider, "<set-?>");
        this.resourceProvider = autoCatalogResourceProvider;
    }

    public final void setSpanProvider(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, "<set-?>");
        this.spanProvider = serpSpanProvider;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setTracker(@NotNull AutoCatalogTracker autoCatalogTracker) {
        Intrinsics.checkNotNullParameter(autoCatalogTracker, "<set-?>");
        this.tracker = autoCatalogTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return false");
        AutoCatalogArguments autoCatalogArguments = (AutoCatalogArguments) arguments.getParcelable("auto_catalog_arguments");
        if (autoCatalogArguments != null) {
            AutoCatalogComponent.Builder withFromScreen = DaggerAutoCatalogComponent.builder().autoCatalogDependencies((AutoCatalogDependencies) ComponentDependenciesKt.getDependencies(AutoCatalogDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withAutoCatalogData(autoCatalogArguments.getAutoCatalogData()).withSearchContext(autoCatalogArguments.getSearchContext()).withFromScreen(autoCatalogArguments.getFrom());
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            withFromScreen.withResources(resources).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("AutoCatalogArguments must be specified");
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogFragmentDelegate
    @Nullable
    public NavigationTab tab() {
        return currentTab();
    }
}
