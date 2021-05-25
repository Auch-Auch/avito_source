package com.avito.android.tariff.tariff_package_info;

import a2.a.a.e3.i.c;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.tariff_package_info.di.DaggerTariffPackageInfoComponent;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\bV\u0010WJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R5\u0010\u001d\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b¢\u0006\u0002\b\u001c0\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u00102\u001a\u00020*2\u0006\u0010+\u001a\u00020*8B@BX\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010@\u001a\u00020:2\u0006\u0010+\u001a\u00020:8B@BX\u0002¢\u0006\u0012\n\u0004\b;\u0010-\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR+\u0010U\u001a\u00020O2\u0006\u0010+\u001a\u00020O8B@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "viewModel", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "getViewModel", "()Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "setViewModel", "(Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;)V", "Landroidx/appcompat/widget/Toolbar;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", AuthSource.SEND_ABUSE, "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "<init>", "()V", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageInfoFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] d = {a2.b.a.a.a.u0(TariffPackageInfoFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(TariffPackageInfoFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(TariffPackageInfoFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public TariffPackageInfoViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment$Companion;", "", "", "contractId", "packageId", "Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffPackageInfoFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "contractId");
            Intrinsics.checkNotNullParameter(str2, "packageId");
            Bundle bundle = new Bundle();
            bundle.putString("contract_id", str);
            bundle.putString("package_id", str2);
            TariffPackageInfoFragment tariffPackageInfoFragment = new TariffPackageInfoFragment();
            tariffPackageInfoFragment.setArguments(bundle);
            return tariffPackageInfoFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TariffPackageInfoFragment a;

        public a(TariffPackageInfoFragment tariffPackageInfoFragment) {
            this.a = tariffPackageInfoFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TariffPackageInfoFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TariffPackageInfoFragment tariffPackageInfoFragment) {
            super(0);
            this.a = tariffPackageInfoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final ProgressOverlay access$getProgressOverlay$p(TariffPackageInfoFragment tariffPackageInfoFragment) {
        return (ProgressOverlay) tariffPackageInfoFragment.c.getValue((Fragment) tariffPackageInfoFragment, d[2]);
    }

    public static final void access$setProgressOverlay$p(TariffPackageInfoFragment tariffPackageInfoFragment, ProgressOverlay progressOverlay) {
        tariffPackageInfoFragment.c.setValue((Fragment) tariffPackageInfoFragment, d[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setToolbar$p(TariffPackageInfoFragment tariffPackageInfoFragment, Toolbar toolbar) {
        tariffPackageInfoFragment.b.setValue((Fragment) tariffPackageInfoFragment, d[1], (KProperty<?>) toolbar);
    }

    public final Toolbar a() {
        return (Toolbar) this.b.getValue((Fragment) this, d[1]);
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
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
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
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final TariffPackageInfoViewModel getViewModel() {
        TariffPackageInfoViewModel tariffPackageInfoViewModel = this.viewModel;
        if (tariffPackageInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return tariffPackageInfoViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof ComponentProvider)) {
            context = null;
        }
        ComponentProvider componentProvider = (ComponentProvider) context;
        if (componentProvider != null) {
            TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider.getComponent();
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("contract_id")) == null) {
                throw new IllegalStateException("contractId must be set");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…\"contractId must be set\")");
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string2 = arguments2.getString("package_id")) == null) {
                throw new IllegalStateException("packageId must be set");
            }
            Intrinsics.checkNotNullExpressionValue(string2, "arguments?.getString(KEY…(\"packageId must be set\")");
            DaggerTariffPackageInfoComponent.factory().create(this, string, string2, tariffStepDependencies).inject(this);
            return;
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.package_info_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        AutoClearedRecyclerView autoClearedRecyclerView = this.a;
        KProperty<?>[] kPropertyArr = d;
        autoClearedRecyclerView.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById));
        RecyclerView recyclerView = (RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0]);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.standard_padding);
        ((RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0])).addItemDecoration(new PaddingListDecoration(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById2));
        a().setNavigationOnClickListener(new a(this));
        a().setTextAlignment(4);
        View findViewById3 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.progress_placeholder)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById3, i, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new b(this));
        TariffPackageInfoViewModel tariffPackageInfoViewModel = this.viewModel;
        if (tariffPackageInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffPackageInfoViewModel.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.i.a(this));
        TariffPackageInfoViewModel tariffPackageInfoViewModel2 = this.viewModel;
        if (tariffPackageInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffPackageInfoViewModel2.getTitleChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.i.b(this));
        TariffPackageInfoViewModel tariffPackageInfoViewModel3 = this.viewModel;
        if (tariffPackageInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffPackageInfoViewModel3.getProgressChanges().observe(getViewLifecycleOwner(), new c(this));
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull TariffPackageInfoViewModel tariffPackageInfoViewModel) {
        Intrinsics.checkNotNullParameter(tariffPackageInfoViewModel, "<set-?>");
        this.viewModel = tariffPackageInfoViewModel;
    }
}
