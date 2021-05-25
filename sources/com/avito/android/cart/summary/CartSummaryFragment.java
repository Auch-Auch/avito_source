package com.avito.android.cart.summary;

import a2.a.a.a0.a.b;
import a2.a.a.a0.a.d;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.cart.R;
import com.avito.android.cart.di.component.CartSummaryComponent;
import com.avito.android.cart.di.component.DaggerCartSummaryComponent;
import com.avito.android.cart.di.deps.CartSummaryDependencies;
import com.avito.android.cart.summary.CartSummaryFragment;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\\\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR-\u0010V\u001a\r\u0012\t\u0012\u00070T¢\u0006\u0002\bU0S8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006^"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "viewModel", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "getViewModel", "()Lcom/avito/android/cart/summary/CartSummaryViewModel;", "setViewModel", "(Lcom/avito/android/cart/summary/CartSummaryViewModel;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "getAnalyticsTracker", "()Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "setAnalyticsTracker", "(Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lkotlin/jvm/JvmSuppressWildcards;", "decorations", "Ljava/util/Set;", "getDecorations", "()Ljava/util/Set;", "setDecorations", "(Ljava/util/Set;)V", "<init>", "Companion", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public CartSummaryAnalyticsTracker analyticsTracker;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    @Inject
    public Set<RecyclerView.ItemDecoration> decorations;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public CartSummaryViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryFragment$Companion;", "", "Lcom/avito/android/cart/summary/CartSummaryFragment;", "create", "()Lcom/avito/android/cart/summary/CartSummaryFragment;", "<init>", "()V", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CartSummaryFragment create() {
            return new CartSummaryFragment();
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CartSummaryFragment a;

        public a(CartSummaryFragment cartSummaryFragment) {
            this.a = cartSummaryFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
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
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final CartSummaryAnalyticsTracker getAnalyticsTracker() {
        CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker = this.analyticsTracker;
        if (cartSummaryAnalyticsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
        }
        return cartSummaryAnalyticsTracker;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final Set<RecyclerView.ItemDecoration> getDecorations() {
        Set<RecyclerView.ItemDecoration> set = this.decorations;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorations");
        }
        return set;
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
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final BaseScreenPerformanceTracker getTracker() {
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return baseScreenPerformanceTracker;
    }

    @NotNull
    public final CartSummaryViewModel getViewModel() {
        CartSummaryViewModel cartSummaryViewModel = this.viewModel;
        if (cartSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cartSummaryViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 11 && i2 != -1) {
            requireActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.fragment_cart_summary, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ummary, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CartSummaryViewModel cartSummaryViewModel = this.viewModel;
        if (cartSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartSummaryViewModel.onRefresh(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup viewGroup = (ViewGroup) view;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        CartSummaryViewModel cartSummaryViewModel = this.viewModel;
        if (cartSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<RecyclerView.ItemDecoration> set = this.decorations;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorations");
        }
        CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker = this.analyticsTracker;
        if (cartSummaryAnalyticsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
        }
        CartSummaryViewImpl cartSummaryViewImpl = new CartSummaryViewImpl(viewGroup, viewLifecycleOwner, simpleRecyclerAdapter, dataAwareAdapterPresenter, attributedTextFormatter2, cartSummaryViewModel, set, cartSummaryAnalyticsTracker);
        CartSummaryViewModel cartSummaryViewModel2 = this.viewModel;
        if (cartSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartSummaryViewImpl.bindTo(cartSummaryViewModel2);
        cartSummaryViewImpl.getToolbarNavigationClicks().subscribe(new a(this));
        CartSummaryViewModel cartSummaryViewModel3 = this.viewModel;
        if (cartSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartSummaryViewModel3.getRequestAuth().observe(getViewLifecycleOwner(), new a2.a.a.a0.a.a(this));
        CartSummaryViewModel cartSummaryViewModel4 = this.viewModel;
        if (cartSummaryViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartSummaryViewModel4.getDeepLinks().observe(getViewLifecycleOwner(), new b(this));
        CartSummaryViewModel cartSummaryViewModel5 = this.viewModel;
        if (cartSummaryViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cartSummaryViewModel5.getIntents().observe(getViewLifecycleOwner(), new d(new Function1<Intent, Unit>(this) { // from class: a2.a.a.a0.a.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Intent intent) {
                ((CartSummaryFragment) this.receiver).startActivity(intent);
                return Unit.INSTANCE;
            }
        }));
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackInit();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAnalyticsTracker(@NotNull CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(cartSummaryAnalyticsTracker, "<set-?>");
        this.analyticsTracker = cartSummaryAnalyticsTracker;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDecorations(@NotNull Set<RecyclerView.ItemDecoration> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.decorations = set;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Timer B1 = a2.b.a.a.a.B1();
        CartSummaryComponent.Factory factory = DaggerCartSummaryComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        PublishRelay<Pair<ProductItem, Integer>> access$getProductQuantityRelay$p = CartSummaryFragmentKt.access$getProductQuantityRelay$p();
        PublishRelay<ProductItem> access$getDeleteItemRelay$p = CartSummaryFragmentKt.access$getDeleteItemRelay$p();
        PublishRelay<String> access$getOpenAdvertDetailsRelay$p = CartSummaryFragmentKt.access$getOpenAdvertDetailsRelay$p();
        PublishRelay<Integer> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        factory.create(this, resources, access$getProductQuantityRelay$p, access$getDeleteItemRelay$p, access$getOpenAdvertDetailsRelay$p, create, CartSummaryFragmentKt.access$getStepperUsageRelay$p(), (CartSummaryDependencies) ComponentDependenciesKt.getDependencies(CartSummaryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
        return true;
    }

    public final void setViewModel(@NotNull CartSummaryViewModel cartSummaryViewModel) {
        Intrinsics.checkNotNullParameter(cartSummaryViewModel, "<set-?>");
        this.viewModel = cartSummaryViewModel;
    }
}
