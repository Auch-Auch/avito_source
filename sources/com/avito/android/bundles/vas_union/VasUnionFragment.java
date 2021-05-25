package com.avito.android.bundles.vas_union;

import a2.g.r.g;
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
import com.avito.android.bundles.R;
import com.avito.android.bundles.vas_union.di.DaggerVasUnionComponent;
import com.avito.android.bundles.vas_union.di.VasUnionDependencies;
import com.avito.android.bundles.vas_union.item.PaddingDecoration;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\bb\u0010cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR+\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8B@BX\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0000@\u0000X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bB\u0010CR5\u0010H\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030F¢\u0006\u0002\bG0E8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001d\u0010S\u001a\u00020N8B@\u0002X\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u00020[8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/avito/android/bundles/vas_union/VasUnionFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder$vas_bundles_release", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder$vas_bundles_release", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "skipButton", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", "f", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", AuthSource.SEND_ABUSE, "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModel;", "viewModel", "Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModel;", "getViewModel$vas_bundles_release", "()Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModel;", "setViewModel$vas_bundles_release", "(Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter$vas_bundles_release", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter$vas_bundles_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter$vas_bundles_release", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter$vas_bundles_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/appcompat/widget/Toolbar;", "h", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", g.a, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet$vas_bundles_release", "()Ljava/util/Set;", "setItemPresenterSet$vas_bundles_release", "(Ljava/util/Set;)V", "Lcom/avito/android/vas_performance/ui/recycler/LastItemDecoration;", "e", "Lkotlin/Lazy;", "getLastItemDecoration", "()Lcom/avito/android/vas_performance/ui/recycler/LastItemDecoration;", "lastItemDecoration", "i", "Z", "closable", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "d", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$vas_bundles_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$vas_bundles_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "()V", "Companion", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.u0(VasUnionFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0)};
    @Inject
    public AdapterPresenter adapterPresenter;
    public Button c;
    public PaidServicesRouter d;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public final Lazy e = t6.c.lazy(new b(this));
    public final AutoClearedRecyclerView f = new AutoClearedRecyclerView();
    public ProgressOverlay g;
    public Toolbar h;
    public boolean i;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public VasUnionViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/bundles/vas_union/VasUnionFragment$Companion;", "", "", "closable", "", "checkoutContext", "currentFlow", "Lcom/avito/android/bundles/vas_union/VasUnionFragment;", "newInstance", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/bundles/vas_union/VasUnionFragment;", "KEY_CHECKOUT_CONTEXT", "Ljava/lang/String;", "KEY_CLOSABLE", "KEY_CURRENT_FLOW", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VasUnionFragment newInstance(boolean z, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            Intrinsics.checkNotNullParameter(str2, "currentFlow");
            VasUnionFragment vasUnionFragment = new VasUnionFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("closable", z);
            bundle.putString("checkoutContext", str);
            bundle.putString("currentFlow", str2);
            vasUnionFragment.setArguments(bundle);
            return vasUnionFragment;
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
                ((VasUnionFragment) this.b).getViewModel$vas_bundles_release().onNextButtonClick();
            } else if (i == 1) {
                PaidServicesRouter paidServicesRouter = ((VasUnionFragment) this.b).d;
                if (paidServicesRouter != null) {
                    PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter, null, 1, null);
                }
            } else if (i == 2) {
                ((VasUnionFragment) this.b).requireActivity().onBackPressed();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<LastItemDecoration> {
        public final /* synthetic */ VasUnionFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VasUnionFragment vasUnionFragment) {
            super(0);
            this.a = vasUnionFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LastItemDecoration invoke() {
            return new LastItemDecoration(Views.heightWithMargins(VasUnionFragment.access$getSkipButton$p(this.a)));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VasUnionFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(VasUnionFragment vasUnionFragment) {
            super(0);
            this.a = vasUnionFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel$vas_bundles_release().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final void access$bindList(VasUnionFragment vasUnionFragment, List list) {
        AdapterPresenter adapterPresenter2 = vasUnionFragment.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        a2.b.a.a.a.s1(list, adapterPresenter2);
        SimpleRecyclerAdapter simpleRecyclerAdapter = vasUnionFragment.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        simpleRecyclerAdapter.notifyDataSetChanged();
    }

    public static final void access$bindProgressOverlay(VasUnionFragment vasUnionFragment, LoadingState loadingState) {
        Objects.requireNonNull(vasUnionFragment);
        if (loadingState instanceof LoadingState.Loading) {
            ProgressOverlay progressOverlay = vasUnionFragment.g;
            if (progressOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay.showLoading();
        } else if (loadingState instanceof LoadingState.Loaded) {
            ProgressOverlay progressOverlay2 = vasUnionFragment.g;
            if (progressOverlay2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay2.showContent();
        } else if (loadingState instanceof LoadingState.Error) {
            ProgressOverlay progressOverlay3 = vasUnionFragment.g;
            if (progressOverlay3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay3, null, 1, null);
        }
    }

    public static final LastItemDecoration access$getLastItemDecoration$p(VasUnionFragment vasUnionFragment) {
        return (LastItemDecoration) vasUnionFragment.e.getValue();
    }

    public static final /* synthetic */ Button access$getSkipButton$p(VasUnionFragment vasUnionFragment) {
        Button button = vasUnionFragment.c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        return button;
    }

    public static final void access$setRecyclerView$p(VasUnionFragment vasUnionFragment, RecyclerView recyclerView) {
        vasUnionFragment.f.setValue((Fragment) vasUnionFragment, j[0], (KProperty<?>) recyclerView);
    }

    public final RecyclerView a() {
        return (RecyclerView) this.f.getValue((Fragment) this, j[0]);
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter$vas_bundles_release() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$vas_bundles_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final ItemBinder getItemBinder$vas_bundles_release() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet$vas_bundles_release() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter$vas_bundles_release() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final VasUnionViewModel getViewModel$vas_bundles_release() {
        VasUnionViewModel vasUnionViewModel = this.viewModel;
        if (vasUnionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return vasUnionViewModel;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        if (!(context instanceof PaidServicesRouter)) {
            context = null;
        }
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) context;
        if (paidServicesRouter != null) {
            this.d = paidServicesRouter;
            VasUnionViewModel vasUnionViewModel = this.viewModel;
            if (vasUnionViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
            }
            vasUnionViewModel.observeItemClicks(set);
            return;
        }
        throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.vas_union_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.placeholder)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById, R.id.recycler_view, null, false, 0, 28, null);
        this.g = progressOverlay;
        progressOverlay.setOnRefreshListener(new c(this));
        View findViewById2 = view.findViewById(R.id.skip_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.skip_button)");
        Button button = (Button) findViewById2;
        this.c = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        button.setOnClickListener(new a(0, this));
        View findViewById3 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.h = toolbar;
        if (this.i) {
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
            Toolbar toolbar2 = this.h;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar2.setNavigationOnClickListener(new a(1, this));
        } else {
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
            Toolbar toolbar3 = this.h;
            if (toolbar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar3.setNavigationOnClickListener(new a(2, this));
        }
        View findViewById4 = view.findViewById(R.id.tabs_content_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.tabs_content_recycler_view)");
        this.f.setValue((Fragment) this, j[0], (KProperty<?>) ((RecyclerView) findViewById4));
        RecyclerView a3 = a();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        a3.setAdapter(simpleRecyclerAdapter);
        RecyclerView a4 = a();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        a4.addItemDecoration(new PaddingDecoration(resources));
        VasUnionViewModel vasUnionViewModel = this.viewModel;
        if (vasUnionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        vasUnionViewModel.getViewState().observe(getViewLifecycleOwner(), new a2.a.a.x.b.a(this));
        VasUnionViewModel vasUnionViewModel2 = this.viewModel;
        if (vasUnionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        vasUnionViewModel2.getNextButtonTextChanges().observe(getViewLifecycleOwner(), new a2.a.a.x.b.b(this));
        VasUnionViewModel vasUnionViewModel3 = this.viewModel;
        if (vasUnionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> deeplinkNavigateEvent = vasUnionViewModel3.getDeeplinkNavigateEvent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        deeplinkNavigateEvent.observe(viewLifecycleOwner, new w1(0, this));
        VasUnionViewModel vasUnionViewModel4 = this.viewModel;
        if (vasUnionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> infoPerformanceClickEvent = vasUnionViewModel4.getInfoPerformanceClickEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        infoPerformanceClickEvent.observe(viewLifecycleOwner2, new w1(1, this));
        VasUnionViewModel vasUnionViewModel5 = this.viewModel;
        if (vasUnionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> skipButtonClickEvent = vasUnionViewModel5.getSkipButtonClickEvent();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        skipButtonClickEvent.observe(viewLifecycleOwner3, new w1(2, this));
    }

    public final void setAdapterPresenter$vas_bundles_release(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory$vas_bundles_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemBinder$vas_bundles_release(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet$vas_bundles_release(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter$vas_bundles_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        Boolean bool = null;
        String string = arguments != null ? arguments.getString("checkoutContext") : null;
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.String");
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("currentFlow") : null;
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.String");
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            bool = Boolean.valueOf(arguments3.getBoolean("closable"));
        }
        Objects.requireNonNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        this.i = bool.booleanValue();
        DaggerVasUnionComponent.factory().create(string, this.i, string2, this, (VasUnionDependencies) ComponentDependenciesKt.getDependencies(VasUnionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }

    public final void setViewModel$vas_bundles_release(@NotNull VasUnionViewModel vasUnionViewModel) {
        Intrinsics.checkNotNullParameter(vasUnionViewModel, "<set-?>");
        this.viewModel = vasUnionViewModel;
    }
}
