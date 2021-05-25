package com.avito.android.basket_legacy.ui;

import a2.a.a.r.a.d;
import a2.a.a.r.a.e;
import a2.a.a.r.a.f;
import a2.a.a.r.a.g;
import a2.a.a.r.a.h;
import a2.a.a.r.a.i;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.basket.R;
import com.avito.android.basket_legacy.di.checkout.DaggerLegacyCheckoutComponent;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutUiModule;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutViewModelModule;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDetach", "()V", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/basket_legacy/ui/Router;", "f", "Lcom/avito/android/basket_legacy/ui/Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;", "e", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;", "dependencies", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "viewModel", "Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "getViewModel", "()Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "setViewModel", "(Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;)V", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "proceedButton", "Landroidx/constraintlayout/widget/Group;", "d", "Landroidx/constraintlayout/widget/Group;", "emptyCartViews", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyCheckoutFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public Toolbar b;
    public Button c;
    public Group d;
    public LegacyCheckoutDependencies e;
    public Router f;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public LegacyCheckoutViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment$Companion;", "", "", "openedFrom", "Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment;", "KEY_OPENED_FROM", "Ljava/lang/String;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LegacyCheckoutFragment newInstance(@Nullable String str) {
            Bundle y1 = a2.b.a.a.a.y1("KEY_OPENED_FROM", str);
            LegacyCheckoutFragment legacyCheckoutFragment = new LegacyCheckoutFragment();
            legacyCheckoutFragment.setArguments(y1);
            return legacyCheckoutFragment;
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
                ((LegacyCheckoutFragment) this.b).requireActivity().onBackPressed();
            } else if (i == 1) {
                Router router = ((LegacyCheckoutFragment) this.b).f;
                if (router != null) {
                    router.startVasSelection();
                }
            } else {
                throw null;
            }
        }
    }

    public static final /* synthetic */ Group access$getEmptyCartViews$p(LegacyCheckoutFragment legacyCheckoutFragment) {
        Group group = legacyCheckoutFragment.d;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyCartViews");
        }
        return group;
    }

    public static final /* synthetic */ Button access$getProceedButton$p(LegacyCheckoutFragment legacyCheckoutFragment) {
        Button button = legacyCheckoutFragment.c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proceedButton");
        }
        return button;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(LegacyCheckoutFragment legacyCheckoutFragment) {
        RecyclerView recyclerView = legacyCheckoutFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ Toolbar access$getToolbar$p(LegacyCheckoutFragment legacyCheckoutFragment) {
        Toolbar toolbar = legacyCheckoutFragment.b;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final LegacyCheckoutViewModel getViewModel() {
        LegacyCheckoutViewModel legacyCheckoutViewModel = this.viewModel;
        if (legacyCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return legacyCheckoutViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        LegacyCheckoutViewModel legacyCheckoutViewModel = this.viewModel;
        if (legacyCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.f = (Router) context;
        String str = null;
        if (!(context instanceof ComponentProvider)) {
            context = null;
        }
        ComponentProvider componentProvider = (ComponentProvider) context;
        if (componentProvider != null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString("KEY_OPENED_FROM");
            }
            this.e = (LegacyCheckoutDependencies) componentProvider.getComponent();
            LegacyCheckoutComponent.Builder builder = DaggerLegacyCheckoutComponent.builder();
            LegacyCheckoutDependencies legacyCheckoutDependencies = this.e;
            if (legacyCheckoutDependencies == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dependencies");
            }
            builder.dependencies(legacyCheckoutDependencies).checkoutModule(new LegacyCheckoutUiModule()).basketViewModelModule(new LegacyCheckoutViewModelModule(this, str)).build().inject(this);
            return;
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.legacy_checkout_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.continue_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.continue_button)");
        this.c = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.basket_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.basket_recycler_view)");
        this.a = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.group_empty_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.group_empty_cart)");
        this.d = (Group) findViewById3;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Views.conceal(recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
        RecyclerView recyclerView3 = this.a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setAdapter(simpleRecyclerAdapter);
        Button button = this.c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proceedButton");
        }
        button.post(new a2.a.a.r.a.j(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel = this.viewModel;
        if (legacyCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel.getListUpdates().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.basket_legacy.ui.LegacyCheckoutFragment$observeViewModel$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    LegacyCheckoutFragment.access$getEmptyCartViews$p(LegacyCheckoutFragment.this).setVisibility(t2.getList().isEmpty() ? 0 : 8);
                    LegacyCheckoutFragment.this.getAdapterPresenter().onDataSourceChanged(new ListDataSource(t2.getList()));
                    RecyclerView.Adapter adapter = LegacyCheckoutFragment.access$getRecyclerView$p(LegacyCheckoutFragment.this).getAdapter();
                    if (adapter != null) {
                        t2.getDiffResult().dispatchUpdatesTo(adapter);
                    }
                }
            }
        });
        LegacyCheckoutViewModel legacyCheckoutViewModel2 = this.viewModel;
        if (legacyCheckoutViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel2.getButtonTextChanges().observe(getViewLifecycleOwner(), new d(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel3 = this.viewModel;
        if (legacyCheckoutViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel3.getStartActivityEvents().observe(getViewLifecycleOwner(), new e(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel4 = this.viewModel;
        if (legacyCheckoutViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel4.getStartActivityForResultEvents().observe(getViewLifecycleOwner(), new f(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel5 = this.viewModel;
        if (legacyCheckoutViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel5.getCloseEvents().observe(getViewLifecycleOwner(), new g(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel6 = this.viewModel;
        if (legacyCheckoutViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel6.getMessageEvents().observe(getViewLifecycleOwner(), new h(this));
        LegacyCheckoutViewModel legacyCheckoutViewModel7 = this.viewModel;
        if (legacyCheckoutViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        legacyCheckoutViewModel7.getNavigationChanges().observe(getViewLifecycleOwner(), new i(this));
        View findViewById4 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById4;
        this.b = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        Toolbar toolbar2 = this.b;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar2.setNavigationOnClickListener(new a(0, this));
        LegacyCheckoutViewModel legacyCheckoutViewModel8 = this.viewModel;
        if (legacyCheckoutViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Button button2 = this.c;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proceedButton");
        }
        legacyCheckoutViewModel8.observeButtonClicks(RxView.clicks(button2));
        view.findViewById(R.id.select_button).setOnClickListener(new a(1, this));
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setViewModel(@NotNull LegacyCheckoutViewModel legacyCheckoutViewModel) {
        Intrinsics.checkNotNullParameter(legacyCheckoutViewModel, "<set-?>");
        this.viewModel = legacyCheckoutViewModel;
    }
}
