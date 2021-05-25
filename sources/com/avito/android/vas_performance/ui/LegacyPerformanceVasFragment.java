package com.avito.android.vas_performance.ui;

import a2.a.a.q3.f.c;
import a2.a.a.q3.f.d;
import a2.a.a.q3.f.e;
import a2.a.a.q3.f.f;
import a2.a.a.q3.f.g;
import a2.a.a.q3.f.h;
import a2.a.a.q3.f.i;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.R;
import com.avito.android.vas_performance.VasCompletionListener;
import com.avito.android.vas_performance.di.perfomance_legacy.DaggerPerformanceVasComponent;
import com.avito.android.vas_performance.di.perfomance_legacy.ListModule;
import com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.ui.recycler.PaddingDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\bX\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR5\u0010#\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030!¢\u0006\u0002\b\"0 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/avito/android/vas_performance/ui/LegacyPerformanceVasFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDetach", "()V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/vas_performance/VasCompletionListener;", "d", "Lcom/avito/android/vas_performance/VasCompletionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/lib/design/button/Button;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/button/Button;", "skipButton", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "getTracker", "()Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "setTracker", "(Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "viewModel", "Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "getViewModel", "()Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "setViewModel", "(Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;)V", "<init>", "Companion", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPerformanceVasFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_CAN_GO_BACK = "can_go_back";
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Button b;
    public ProgressOverlay c;
    public VasCompletionListener d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public PerformanceVasTracker tracker;
    @Inject
    public LegacyPerformanceVasViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/ui/LegacyPerformanceVasFragment$Companion;", "", "", "canGoBack", "Lcom/avito/android/vas_performance/ui/LegacyPerformanceVasFragment;", "newInstance", "(Z)Lcom/avito/android/vas_performance/ui/LegacyPerformanceVasFragment;", "", "KEY_CAN_GO_BACK", "Ljava/lang/String;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ LegacyPerformanceVasFragment newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.newInstance(z);
        }

        @NotNull
        public final LegacyPerformanceVasFragment newInstance(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(LegacyPerformanceVasFragment.KEY_CAN_GO_BACK, z);
            LegacyPerformanceVasFragment legacyPerformanceVasFragment = new LegacyPerformanceVasFragment();
            legacyPerformanceVasFragment.setArguments(bundle);
            return legacyPerformanceVasFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LegacyPerformanceVasFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
            super(0);
            this.a = legacyPerformanceVasFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LegacyPerformanceVasFragment a;

        public b(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
            this.a = legacyPerformanceVasFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onSkipButtonClick();
        }
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        ProgressOverlay progressOverlay = legacyPerformanceVasFragment.c;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        RecyclerView recyclerView = legacyPerformanceVasFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ Button access$getSkipButton$p(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        Button button = legacyPerformanceVasFragment.b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        return button;
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final PerformanceVasTracker getTracker() {
        PerformanceVasTracker performanceVasTracker = this.tracker;
        if (performanceVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return performanceVasTracker;
    }

    @NotNull
    public final LegacyPerformanceVasViewModel getViewModel() {
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel = this.viewModel;
        if (legacyPerformanceVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return legacyPerformanceVasViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.d = (VasCompletionListener) context;
        if (!(context instanceof ComponentProvider)) {
            context = null;
        }
        ComponentProvider componentProvider = (ComponentProvider) context;
        if (componentProvider != null) {
            Timer B1 = a2.b.a.a.a.B1();
            DaggerPerformanceVasComponent.builder().dependencies((PerformanceVasDependencies) componentProvider.getComponent()).module(new ListModule()).build().inject(this);
            PerformanceVasTracker performanceVasTracker = this.tracker;
            if (performanceVasTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            performanceVasTracker.trackDiInject(B1.elapsed());
            return;
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PerformanceVasTracker performanceVasTracker = this.tracker;
        if (performanceVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        performanceVasTracker.startInit();
        return layoutInflater.inflate(R.layout.performance_vas_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.placeholder)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int i = R.id.recycler_view;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        this.c = progressOverlay;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.setOnRefreshListener(new a(this));
        View findViewById2 = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        this.a = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.skip_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.skip_button)");
        Button button = (Button) findViewById3;
        this.b = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        button.setOnClickListener(new b(this));
        View findViewById4 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById4;
        Bundle arguments = getArguments();
        toolbar.setNavigationIcon(arguments != null ? arguments.getBoolean(KEY_CAN_GO_BACK) : true ? com.avito.android.ui_components.R.drawable.ic_back_24 : com.avito.android.ui_components.R.drawable.ic_close_24);
        toolbar.setNavigationOnClickListener(new a2.a.a.q3.f.j(this));
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
        RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Resources resources = requireContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "requireContext().resources");
        recyclerView2.addItemDecoration(new PaddingDecoration(resources));
        Button button2 = this.b;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        RxView.layoutChanges(button2).map(new f(this)).filter(g.a).firstElement().subscribe(new h(this), new i(this));
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel = this.viewModel;
        if (legacyPerformanceVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        legacyPerformanceVasViewModel.observeItemClicks(set);
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel2 = this.viewModel;
        if (legacyPerformanceVasViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyPerformanceVasViewModel2.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.q3.f.a(this));
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel3 = this.viewModel;
        if (legacyPerformanceVasViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyPerformanceVasViewModel3.getDataChanges().observe(getViewLifecycleOwner(), new a2.a.a.q3.f.b(this));
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel4 = this.viewModel;
        if (legacyPerformanceVasViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyPerformanceVasViewModel4.getButtonTextChanges().observe(getViewLifecycleOwner(), new c(this));
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel5 = this.viewModel;
        if (legacyPerformanceVasViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Unit> completionEvents = legacyPerformanceVasViewModel5.getCompletionEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        completionEvents.observe(viewLifecycleOwner, new d(this));
        LegacyPerformanceVasViewModel legacyPerformanceVasViewModel6 = this.viewModel;
        if (legacyPerformanceVasViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyPerformanceVasViewModel6.getOpenInfoPage().observe(getViewLifecycleOwner(), new e(this));
        PerformanceVasTracker performanceVasTracker = this.tracker;
        if (performanceVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        performanceVasTracker.trackInit();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setTracker(@NotNull PerformanceVasTracker performanceVasTracker) {
        Intrinsics.checkNotNullParameter(performanceVasTracker, "<set-?>");
        this.tracker = performanceVasTracker;
    }

    public final void setViewModel(@NotNull LegacyPerformanceVasViewModel legacyPerformanceVasViewModel) {
        Intrinsics.checkNotNullParameter(legacyPerformanceVasViewModel, "<set-?>");
        this.viewModel = legacyPerformanceVasViewModel;
    }
}
