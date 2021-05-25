package com.avito.android.vas_performance.ui;

import a2.a.a.q3.f.h0;
import a2.a.a.q3.f.i0;
import a2.a.a.q3.f.j0;
import a2.a.a.q3.f.k0;
import a2.a.a.q3.f.l0;
import a2.a.a.q3.f.m0;
import a2.a.a.q3.f.n0;
import a2.a.a.q3.f.o0;
import a2.a.a.q3.f.p0;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.vas_performance.di.visual.DaggerVisualVasComponentNew;
import com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew;
import com.avito.android.vas_performance.di.visual.VisualVasModuleNew;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.recycler.PaddingDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\bV\u0010WJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R5\u00103\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000301¢\u0006\u0002\b2008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/avito/android/vas_performance/ui/VisualVasFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "d", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "viewModel", "Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "getViewModel", "()Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "setViewModel", "(Lcom/avito/android/vas_performance/ui/VisualVasViewModel;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "getTracker", "()Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "setTracker", "(Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)V", "Lcom/avito/android/lib/design/button/Button;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/button/Button;", "continueButton", "<init>", "()V", "Companion", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVasFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Button b;
    public ProgressOverlay c;
    public PaidServicesRouter d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public VisualVasTracker tracker;
    @Inject
    public VisualVasViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/ui/VisualVasFragment$Companion;", "", "", "closable", "", BookingInfoActivity.EXTRA_ITEM_ID, "checkoutContext", "Lcom/avito/android/vas_performance/ui/VisualVasFragment;", "newInstance", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/vas_performance/ui/VisualVasFragment;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ VisualVasFragment newInstance$default(Companion companion, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.newInstance(z, str, str2);
        }

        @NotNull
        public final VisualVasFragment newInstance(boolean z, @NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Bundle bundle = new Bundle();
            bundle.putBoolean("closable", z);
            bundle.putString("checkout_context", str2);
            bundle.putString("advert_id", str);
            VisualVasFragment visualVasFragment = new VisualVasFragment();
            visualVasFragment.setArguments(bundle);
            return visualVasFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VisualVasFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VisualVasFragment visualVasFragment) {
            super(0);
            this.a = visualVasFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VisualVasFragment a;

        public b(VisualVasFragment visualVasFragment) {
            this.a = visualVasFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onContinueButtonClick();
        }
    }

    public static final /* synthetic */ Button access$getContinueButton$p(VisualVasFragment visualVasFragment) {
        Button button = visualVasFragment.b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        return button;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(VisualVasFragment visualVasFragment) {
        ProgressOverlay progressOverlay = visualVasFragment.c;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(VisualVasFragment visualVasFragment) {
        RecyclerView recyclerView = visualVasFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ PaidServicesRouter access$getRouter$p(VisualVasFragment visualVasFragment) {
        PaidServicesRouter paidServicesRouter = visualVasFragment.d;
        if (paidServicesRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return paidServicesRouter;
    }

    public static final void access$updateButtonAppearance(VisualVasFragment visualVasFragment, boolean z) {
        int i;
        Objects.requireNonNull(visualVasFragment);
        if (z) {
            i = R.attr.buttonPrimaryMedium;
        } else if (!z) {
            i = R.attr.buttonSecondaryMedium;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Button button = visualVasFragment.b;
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
    public final VisualVasTracker getTracker() {
        VisualVasTracker visualVasTracker = this.tracker;
        if (visualVasTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return visualVasTracker;
    }

    @NotNull
    public final VisualVasViewModel getViewModel() {
        VisualVasViewModel visualVasViewModel = this.viewModel;
        if (visualVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return visualVasViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ComponentProvider componentProvider = (ComponentProvider) (!(context instanceof ComponentProvider) ? null : context);
        if (componentProvider != null) {
            VisualVasDependenciesNew visualVasDependenciesNew = (VisualVasDependenciesNew) componentProvider.getComponent();
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                throw new IllegalStateException("checkoutContext must not be null");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…ontext must not be null\")");
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string2 = arguments2.getString("advert_id")) == null) {
                throw new IllegalStateException("advertId must not be null");
            }
            Intrinsics.checkNotNullExpressionValue(string2, "arguments?.getString(KEY…vertId must not be null\")");
            if (!(context instanceof PaidServicesRouter)) {
                context = null;
            }
            PaidServicesRouter paidServicesRouter = (PaidServicesRouter) context;
            if (paidServicesRouter != null) {
                this.d = paidServicesRouter;
                VisualVasModuleNew visualVasModuleNew = new VisualVasModuleNew(string2, string);
                Timer B1 = a2.b.a.a.a.B1();
                DaggerVisualVasComponentNew.factory().create(visualVasDependenciesNew, visualVasModuleNew, this).inject(this);
                VisualVasTracker visualVasTracker = this.tracker;
                if (visualVasTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tracker");
                }
                visualVasTracker.trackDiInject(B1.elapsed());
                return;
            }
            throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
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
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.setOnRefreshListener(new a(this));
        View findViewById2 = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        this.a = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.vas_performance.R.id.skip_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.skip_button)");
        Button button = (Button) findViewById3;
        this.b = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        button.setOnClickListener(new b(this));
        View findViewById4 = view.findViewById(com.avito.android.vas_performance.R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById4;
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean("closable") : true;
        toolbar.setNavigationIcon(z ? com.avito.android.ui_components.R.drawable.ic_close_24 : com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new p0(this, z));
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
            Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        }
        RxView.layoutChanges(button2).map(new l0(this)).filter(m0.a).firstElement().subscribe(new n0(this), new o0(this));
        VisualVasViewModel visualVasViewModel = this.viewModel;
        if (visualVasViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        visualVasViewModel.observeItemClicks(set);
        VisualVasViewModel visualVasViewModel2 = this.viewModel;
        if (visualVasViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        visualVasViewModel2.getDataChanges().observe(getViewLifecycleOwner(), new h0(this));
        VisualVasViewModel visualVasViewModel3 = this.viewModel;
        if (visualVasViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        visualVasViewModel3.getProgressChanges().observe(getViewLifecycleOwner(), new i0(this));
        VisualVasViewModel visualVasViewModel4 = this.viewModel;
        if (visualVasViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        visualVasViewModel4.getButtonStateChanges().observe(getViewLifecycleOwner(), new j0(this));
        VisualVasViewModel visualVasViewModel5 = this.viewModel;
        if (visualVasViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        visualVasViewModel5.getContinueButtonNavigate().observe(getViewLifecycleOwner(), new k0(this));
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

    public final void setTracker(@NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(visualVasTracker, "<set-?>");
        this.tracker = visualVasTracker;
    }

    public final void setViewModel(@NotNull VisualVasViewModel visualVasViewModel) {
        Intrinsics.checkNotNullParameter(visualVasViewModel, "<set-?>");
        this.viewModel = visualVasViewModel;
    }
}
