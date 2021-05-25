package com.avito.android.vas_performance.ui;

import a2.a.a.q3.f.k;
import a2.a.a.q3.f.l;
import a2.a.a.q3.f.m;
import a2.a.a.q3.f.n;
import a2.a.a.q3.f.o;
import a2.a.a.q3.f.p;
import a2.a.a.q3.f.q;
import a2.a.a.q3.f.r;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.VasCompletionListener;
import com.avito.android.vas_performance.di.visual_legacy.DaggerVisualVasComponent;
import com.avito.android.vas_performance.di.visual_legacy.VasListModule;
import com.avito.android.vas_performance.di.visual_legacy.VisualVasDependencies;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.recycler.PaddingDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\bQ\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R5\u00109\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000307¢\u0006\u0002\b8068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDetach", "()V", "Lcom/avito/android/lib/design/button/Button;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/button/Button;", "continueButton", "Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "viewModel", "Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "getViewModel", "()Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "setViewModel", "(Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "getTracker", "()Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "setTracker", "(Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/vas_performance/VasCompletionListener;", "d", "Lcom/avito/android/vas_performance/VasCompletionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "Companion", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyVisualVasFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Button b;
    public ProgressOverlay c;
    public VasCompletionListener d;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public VisualVasTracker tracker;
    @Inject
    public LegacyVisualVasViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment$Companion;", "", "Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment;", "newInstance", "()Lcom/avito/android/vas_performance/ui/LegacyVisualVasFragment;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LegacyVisualVasFragment newInstance() {
            return new LegacyVisualVasFragment();
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                FragmentActivity activity = ((LegacyVisualVasFragment) this.b).getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            } else if (i == 1) {
                ((LegacyVisualVasFragment) this.b).getViewModel().onContinueButtonClick();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LegacyVisualVasFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LegacyVisualVasFragment legacyVisualVasFragment) {
            super(0);
            this.a = legacyVisualVasFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ Button access$getContinueButton$p(LegacyVisualVasFragment legacyVisualVasFragment) {
        Button button = legacyVisualVasFragment.b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        return button;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(LegacyVisualVasFragment legacyVisualVasFragment) {
        ProgressOverlay progressOverlay = legacyVisualVasFragment.c;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(LegacyVisualVasFragment legacyVisualVasFragment) {
        RecyclerView recyclerView = legacyVisualVasFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final void access$updateButtonAppearance(LegacyVisualVasFragment legacyVisualVasFragment, boolean z) {
        int i;
        Objects.requireNonNull(legacyVisualVasFragment);
        if (z) {
            i = R.attr.buttonPrimaryMedium;
        } else if (!z) {
            i = R.attr.buttonSecondaryMedium;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Button button = legacyVisualVasFragment.b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        button.setAppearanceFromAttr(i);
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
    public final VisualVasTracker getTracker() {
        VisualVasTracker visualVasTracker = this.tracker;
        if (visualVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return visualVasTracker;
    }

    @NotNull
    public final LegacyVisualVasViewModel getViewModel() {
        LegacyVisualVasViewModel legacyVisualVasViewModel = this.viewModel;
        if (legacyVisualVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return legacyVisualVasViewModel;
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
            DaggerVisualVasComponent.builder().dependencies((VisualVasDependencies) componentProvider.getComponent()).module(new VasListModule()).build().inject(this);
            VisualVasTracker visualVasTracker = this.tracker;
            if (visualVasTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            visualVasTracker.trackDiInject(B1.elapsed());
            return;
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VisualVasTracker visualVasTracker = this.tracker;
        if (visualVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        visualVasTracker.startInit();
        return layoutInflater.inflate(com.avito.android.vas_performance.R.layout.performance_vas_fragment, viewGroup, false);
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
        View findViewById = view.findViewById(com.avito.android.vas_performance.R.id.placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.placeholder)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int i = com.avito.android.vas_performance.R.id.recycler_view;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        this.c = progressOverlay;
        progressOverlay.setOnRefreshListener(new b(this));
        View findViewById2 = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        this.a = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.vas_performance.R.id.skip_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.skip_button)");
        this.b = (Button) findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.vas_performance.R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById4;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new a(0, this));
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
        Button button = this.b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        RxView.layoutChanges(button).map(new o(this)).filter(p.a).firstElement().subscribe(new q(this), new r(this));
        LegacyVisualVasViewModel legacyVisualVasViewModel = this.viewModel;
        if (legacyVisualVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        legacyVisualVasViewModel.observeItemClicks(set);
        LegacyVisualVasViewModel legacyVisualVasViewModel2 = this.viewModel;
        if (legacyVisualVasViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyVisualVasViewModel2.getProgressChanges().observe(getViewLifecycleOwner(), new k(this));
        LegacyVisualVasViewModel legacyVisualVasViewModel3 = this.viewModel;
        if (legacyVisualVasViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyVisualVasViewModel3.getDataChanges().observe(getViewLifecycleOwner(), new l(this));
        LegacyVisualVasViewModel legacyVisualVasViewModel4 = this.viewModel;
        if (legacyVisualVasViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyVisualVasViewModel4.getButtonStateChanges().observe(getViewLifecycleOwner(), new m(this));
        LegacyVisualVasViewModel legacyVisualVasViewModel5 = this.viewModel;
        if (legacyVisualVasViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Unit> completionEvents = legacyVisualVasViewModel5.getCompletionEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        completionEvents.observe(viewLifecycleOwner, new n(this));
        Button button2 = this.b;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        button2.setOnClickListener(new a(1, this));
        VisualVasTracker visualVasTracker = this.tracker;
        if (visualVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        visualVasTracker.trackInit();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setTracker(@NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(visualVasTracker, "<set-?>");
        this.tracker = visualVasTracker;
    }

    public final void setViewModel(@NotNull LegacyVisualVasViewModel legacyVisualVasViewModel) {
        Intrinsics.checkNotNullParameter(legacyVisualVasViewModel, "<set-?>");
        this.viewModel = legacyVisualVasViewModel;
    }
}
