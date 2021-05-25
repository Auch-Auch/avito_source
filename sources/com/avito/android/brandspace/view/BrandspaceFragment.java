package com.avito.android.brandspace.view;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.BrandspaceScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.di.BrandspaceFragmentComponent;
import com.avito.android.brandspace.di.BrandspaceFragmentDependencies;
import com.avito.android.brandspace.di.DaggerBrandspaceFragmentComponent;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.brandspace.router.BrandspaceArguments;
import com.avito.android.brandspace.router.BrandspaceRouter;
import com.avito.android.brandspace.router.BrandspaceRouterImpl;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedDestroyable;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR+\u0010]\u001a\u00020U2\u0006\u0010V\u001a\u00020U8B@BX\u0002¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010l\u001a\u00020e8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/brandspace/view/BrandspaceFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "", "c", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onBackPressed", "()Z", "onStart", "onStop", "onResume", "onPause", "onDestroyView", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "tracker", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "getTracker", "()Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "setTracker", "(Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;)V", "Lcom/avito/android/brandspace/view/FragmentDelegate;", "k", "Lcom/avito/android/brandspace/view/FragmentDelegate;", "fragmentDelegate", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "carouselPresenter", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "getCarouselPresenter", "()Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "setCarouselPresenter", "(Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/ListRecyclerAdapter;)V", "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "spanProvider", "Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "getSpanProvider", "()Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;", "setSpanProvider", "(Lcom/avito/android/brandspace/view/BrandpaceSpanProvider;)V", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResources", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "getBrandspaceResources", "()Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "setBrandspaceResources", "(Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)V", "Lcom/avito/android/brandspace/view/BrandspaceView;", "<set-?>", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedDestroyable;", "getBrandspaceView", "()Lcom/avito/android/brandspace/view/BrandspaceView;", "setBrandspaceView", "(Lcom/avito/android/brandspace/view/BrandspaceView;)V", "brandspaceView", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "presenter", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "getPresenter", "()Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "setPresenter", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "j", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "l", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "router", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "Companion", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceFragment extends TabBaseFragment implements OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "BrandspaceFragment";
    public static final /* synthetic */ KProperty[] n = {a.u0(BrandspaceFragment.class, "brandspaceView", "getBrandspaceView()Lcom/avito/android/brandspace/view/BrandspaceView;", 0)};
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public ListRecyclerAdapter adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public BrandspaceResourcesProvider brandspaceResources;
    @Inject
    public CarouselPresenter carouselPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public ItemVisibilityTracker itemVisibilityTracker;
    @NotNull
    public NavigationState j = new NavigationState(false);
    public FragmentDelegate k;
    public BrandspaceRouter l;
    public final AutoClearedDestroyable m = new AutoClearedDestroyable();
    @Inject
    public BrandspacePresenter presenter;
    @Inject
    public BrandpaceSpanProvider spanProvider;
    @Inject
    public BrandspaceTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/brandspace/view/BrandspaceFragment$Companion;", "", "Lcom/avito/android/brandspace/router/BrandspaceArguments;", "arguments", "Lcom/avito/android/brandspace/view/BrandspaceFragment;", "newInstance", "(Lcom/avito/android/brandspace/router/BrandspaceArguments;)Lcom/avito/android/brandspace/view/BrandspaceFragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ BrandspaceArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(BrandspaceArguments brandspaceArguments) {
                super(1);
                this.a = brandspaceArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("brandspace_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final BrandspaceFragment newInstance(@NotNull BrandspaceArguments brandspaceArguments) {
            Intrinsics.checkNotNullParameter(brandspaceArguments, "arguments");
            return (BrandspaceFragment) FragmentsKt.arguments$default(new BrandspaceFragment(), 0, new a(brandspaceArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public final void c() {
        Bundle bundle = new Bundle();
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter", brandspacePresenter.onSaveState());
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        bundle.putBundle("key_item_visibility_tracker_state", itemVisibilityTracker2.onSaveState());
        saveInRetainStorage(bundle);
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
    public final ListRecyclerAdapter getAdapter() {
        ListRecyclerAdapter listRecyclerAdapter = this.adapter;
        if (listRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return listRecyclerAdapter;
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
    public final BrandspaceResourcesProvider getBrandspaceResources() {
        BrandspaceResourcesProvider brandspaceResourcesProvider = this.brandspaceResources;
        if (brandspaceResourcesProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandspaceResources");
        }
        return brandspaceResourcesProvider;
    }

    @NotNull
    public final CarouselPresenter getCarouselPresenter() {
        CarouselPresenter carouselPresenter2 = this.carouselPresenter;
        if (carouselPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselPresenter");
        }
        return carouselPresenter2;
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
    public final ItemVisibilityTracker getItemVisibilityTracker() {
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        return itemVisibilityTracker2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.j;
    }

    @NotNull
    public final BrandspacePresenter getPresenter() {
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return brandspacePresenter;
    }

    @NotNull
    public final BrandpaceSpanProvider getSpanProvider() {
        BrandpaceSpanProvider brandpaceSpanProvider = this.spanProvider;
        if (brandpaceSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        return brandpaceSpanProvider;
    }

    @NotNull
    public final BrandspaceTracker getTracker() {
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return brandspaceTracker;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        this.l = new BrandspaceRouterImpl(this, activityIntentFactory2, deepLinkIntentFactory2);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        brandspaceTracker.startInit();
        return layoutInflater.inflate(R.layout.brandspace_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        brandspacePresenter.onViewDestroyed();
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        brandspaceTracker.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        brandspacePresenter.onViewPaused();
        c();
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        brandspaceTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        brandspaceTracker.attach();
        super.onResume();
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        brandspacePresenter.onViewResumed();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        BrandspaceRouter brandspaceRouter = this.l;
        if (brandspaceRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        brandspacePresenter.onViewStarted(brandspaceRouter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        BrandspacePresenter brandspacePresenter = this.presenter;
        if (brandspacePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        brandspacePresenter.onViewStopped();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle retainStorage = retainStorage();
        if (retainStorage != null) {
            BrandspacePresenter brandspacePresenter = this.presenter;
            if (brandspacePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            brandspacePresenter.onRestoreState(retainStorage.getBundle("presenter"));
        }
        BrandspacePresenter brandspacePresenter2 = this.presenter;
        if (brandspacePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ListRecyclerAdapter listRecyclerAdapter = this.adapter;
        if (listRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BrandpaceSpanProvider brandpaceSpanProvider = this.spanProvider;
        if (brandpaceSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        BrandspaceResourcesProvider brandspaceResourcesProvider = this.brandspaceResources;
        if (brandspaceResourcesProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandspaceResources");
        }
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        BrandspaceViewImpl brandspaceViewImpl = new BrandspaceViewImpl(view, brandspacePresenter2, analytics2, listRecyclerAdapter, brandpaceSpanProvider, destroyableViewHolderBuilder2, brandspaceResourcesProvider, deviceMetrics2, itemVisibilityTracker2);
        AutoClearedDestroyable autoClearedDestroyable = this.m;
        KProperty<?>[] kPropertyArr = n;
        autoClearedDestroyable.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) brandspaceViewImpl);
        BrandspacePresenter brandspacePresenter3 = this.presenter;
        if (brandspacePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        brandspacePresenter3.onViewCreated((BrandspaceView) this.m.getValue((Fragment) this, kPropertyArr[0]));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getWindow().setBackgroundDrawable(null);
        BrandspaceTracker brandspaceTracker = this.tracker;
        if (brandspaceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        brandspaceTracker.trackInit();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapter(@NotNull ListRecyclerAdapter listRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(listRecyclerAdapter, "<set-?>");
        this.adapter = listRecyclerAdapter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBrandspaceResources(@NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "<set-?>");
        this.brandspaceResources = brandspaceResourcesProvider;
    }

    public final void setCarouselPresenter(@NotNull CarouselPresenter carouselPresenter2) {
        Intrinsics.checkNotNullParameter(carouselPresenter2, "<set-?>");
        this.carouselPresenter = carouselPresenter2;
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

    public final void setItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker2) {
        Intrinsics.checkNotNullParameter(itemVisibilityTracker2, "<set-?>");
        this.itemVisibilityTracker = itemVisibilityTracker2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.j = navigationState;
    }

    public final void setPresenter(@NotNull BrandspacePresenter brandspacePresenter) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "<set-?>");
        this.presenter = brandspacePresenter;
    }

    public final void setSpanProvider(@NotNull BrandpaceSpanProvider brandpaceSpanProvider) {
        Intrinsics.checkNotNullParameter(brandpaceSpanProvider, "<set-?>");
        this.spanProvider = brandpaceSpanProvider;
    }

    public final void setTracker(@NotNull BrandspaceTracker brandspaceTracker) {
        Intrinsics.checkNotNullParameter(brandspaceTracker, "<set-?>");
        this.tracker = brandspaceTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle retainStorage = retainStorage();
        Bundle arguments = getArguments();
        Bundle bundle2 = null;
        BrandspaceArguments brandspaceArguments = arguments != null ? (BrandspaceArguments) arguments.getParcelable("brandspace_arguments") : null;
        if (!(brandspaceArguments instanceof BrandspaceArguments)) {
            brandspaceArguments = null;
        }
        if (brandspaceArguments != null) {
            this.k = new FragmentDelegateImpl(this);
            if (retainStorage != null) {
                bundle2 = retainStorage.getBundle("key_item_visibility_tracker_state");
            }
            Timer B1 = a.B1();
            BrandspaceFragmentComponent.Builder withScreenAnalyticsDependencies = DaggerBrandspaceFragmentComponent.builder().withBrandspaceDependencies((BrandspaceFragmentDependencies) ComponentDependenciesKt.getDependencies(BrandspaceFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withScreenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            BrandspaceFragmentComponent.Builder withViewContext = withScreenAnalyticsDependencies.withViewContext(requireContext);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            BrandspaceFragmentComponent.Builder withScreen = withViewContext.withResources(resources).withScreen(BrandspaceScreen.INSTANCE);
            FragmentDelegate fragmentDelegate = this.k;
            if (fragmentDelegate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentDelegate");
            }
            withScreen.withFragmentDelegate(fragmentDelegate).withBrandspaceId(brandspaceArguments.getId()).withInitialTreeParent(brandspaceArguments.getTreeParent()).withBrandspaceSource(brandspaceArguments.getBrandspaceSource()).withItemVisibilityTrackerState(bundle2).build().inject(this);
            BrandspaceTracker brandspaceTracker = this.tracker;
            if (brandspaceTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            brandspaceTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("BrandspaceArguments must be specified");
    }
}
