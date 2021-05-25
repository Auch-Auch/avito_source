package com.avito.android.bundles.ui;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.bundles.R;
import com.avito.android.bundles.di.DaggerVasBundlesComponent;
import com.avito.android.bundles.di.VasBundlesDependencies;
import com.avito.android.bundles.ui.recycler.PaddingDecoration;
import com.avito.android.bundles.viewmodel.VasBundlesViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bM\u0010NJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R5\u0010)\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030'¢\u0006\u0002\b(0&8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/avito/android/bundles/ui/VasBundlesFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder$vas_bundles_release", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder$vas_bundles_release", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "viewModel", "Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "getViewModel$vas_bundles_release", "()Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "setViewModel$vas_bundles_release", "(Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;)V", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet$vas_bundles_release", "()Ljava/util/Set;", "setItemPresenterSet$vas_bundles_release", "(Ljava/util/Set;)V", "Landroidx/appcompat/widget/Toolbar;", "f", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", g.a, "Z", "closable", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter$vas_bundles_release", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter$vas_bundles_release", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getRecyclerAdapter$vas_bundles_release", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setRecyclerAdapter$vas_bundles_release", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "c", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "<init>", "()V", "Companion", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundlesFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public PaidServicesRouter c;
    public RecyclerView d;
    public ProgressOverlay e;
    public Toolbar f;
    public boolean g;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public RecyclerView.Adapter<BaseViewHolder> recyclerAdapter;
    @Inject
    public VasBundlesViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/bundles/ui/VasBundlesFragment$Companion;", "", "", "closable", "", "checkoutContext", "currentFlow", "Lcom/avito/android/bundles/ui/VasBundlesFragment;", "newInstance", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/bundles/ui/VasBundlesFragment;", "KEY_CHECKOUT_CONTEXT", "Ljava/lang/String;", "KEY_CLOSABLE", "KEY_CURRENT_FLOW", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VasBundlesFragment newInstance(boolean z, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            Intrinsics.checkNotNullParameter(str2, "currentFlow");
            VasBundlesFragment vasBundlesFragment = new VasBundlesFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("closable", z);
            bundle.putString("checkoutContext", str);
            bundle.putString("currentFlow", str2);
            Unit unit = Unit.INSTANCE;
            vasBundlesFragment.setArguments(bundle);
            return vasBundlesFragment;
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
                PaidServicesRouter paidServicesRouter = ((VasBundlesFragment) this.b).c;
                if (paidServicesRouter != null) {
                    PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter, null, 1, null);
                }
            } else if (i == 1) {
                ((VasBundlesFragment) this.b).requireActivity().onBackPressed();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VasBundlesFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VasBundlesFragment vasBundlesFragment) {
            super(0);
            this.a = vasBundlesFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel$vas_bundles_release().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final void access$bindList(VasBundlesFragment vasBundlesFragment, List list) {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = vasBundlesFragment.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        dataAwareAdapterPresenter.onDataSourceChanged(new ListDataSource(list));
    }

    public static final void access$bindProgressOverlay(VasBundlesFragment vasBundlesFragment, LoadingState loadingState) {
        Objects.requireNonNull(vasBundlesFragment);
        if (loadingState instanceof LoadingState.Loading) {
            ProgressOverlay progressOverlay = vasBundlesFragment.e;
            if (progressOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay.showLoading();
        } else if (loadingState instanceof LoadingState.Loaded) {
            ProgressOverlay progressOverlay2 = vasBundlesFragment.e;
            if (progressOverlay2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay2.showContent();
        } else if (loadingState instanceof LoadingState.Error) {
            ProgressOverlay progressOverlay3 = vasBundlesFragment.e;
            if (progressOverlay3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay3, null, 1, null);
        }
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter$vas_bundles_release() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
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
    public final RecyclerView.Adapter<BaseViewHolder> getRecyclerAdapter$vas_bundles_release() {
        RecyclerView.Adapter<BaseViewHolder> adapter = this.recyclerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return adapter;
    }

    @NotNull
    public final VasBundlesViewModel getViewModel$vas_bundles_release() {
        VasBundlesViewModel vasBundlesViewModel = this.viewModel;
        if (vasBundlesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return vasBundlesViewModel;
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
            this.c = paidServicesRouter;
            VasBundlesViewModel vasBundlesViewModel = this.viewModel;
            if (vasBundlesViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
            }
            vasBundlesViewModel.observeItemClicks(set);
            return;
        }
        throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.vas_bundle_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.placeholder)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int i = R.id.recycler_view;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, null, false, 0, 28, null);
        this.e = progressOverlay;
        progressOverlay.setOnRefreshListener(new b(this));
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.f = toolbar;
        if (this.g) {
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
            Toolbar toolbar2 = this.f;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar2.setNavigationOnClickListener(new a(0, this));
        } else {
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
            Toolbar toolbar3 = this.f;
            if (toolbar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            toolbar3.setNavigationOnClickListener(new a(1, this));
        }
        View findViewById3 = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.d = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter<BaseViewHolder> adapter = this.recyclerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(adapter);
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        recyclerView2.addItemDecoration(new PaddingDecoration(resources));
        VasBundlesViewModel vasBundlesViewModel = this.viewModel;
        if (vasBundlesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        vasBundlesViewModel.getViewState().observe(getViewLifecycleOwner(), new a2.a.a.x.a.a(this));
        VasBundlesViewModel vasBundlesViewModel2 = this.viewModel;
        if (vasBundlesViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> chooseBundleButtonClickEvent = vasBundlesViewModel2.getChooseBundleButtonClickEvent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        chooseBundleButtonClickEvent.observe(viewLifecycleOwner, new d3(0, this));
        VasBundlesViewModel vasBundlesViewModel3 = this.viewModel;
        if (vasBundlesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> benefitClickEvent = vasBundlesViewModel3.getBenefitClickEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        benefitClickEvent.observe(viewLifecycleOwner2, new d3(1, this));
        VasBundlesViewModel vasBundlesViewModel4 = this.viewModel;
        if (vasBundlesViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> skipButtonClickEvent = vasBundlesViewModel4.getSkipButtonClickEvent();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        skipButtonClickEvent.observe(viewLifecycleOwner3, new d3(2, this));
    }

    public final void setAdapterPresenter$vas_bundles_release(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setItemBinder$vas_bundles_release(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet$vas_bundles_release(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter$vas_bundles_release(@NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.recyclerAdapter = adapter;
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
        this.g = bool.booleanValue();
        DaggerVasBundlesComponent.factory().create(string, this.g, string2, this, (VasBundlesDependencies) ComponentDependenciesKt.getDependencies(VasBundlesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }

    public final void setViewModel$vas_bundles_release(@NotNull VasBundlesViewModel vasBundlesViewModel) {
        Intrinsics.checkNotNullParameter(vasBundlesViewModel, "<set-?>");
        this.viewModel = vasBundlesViewModel;
    }
}
