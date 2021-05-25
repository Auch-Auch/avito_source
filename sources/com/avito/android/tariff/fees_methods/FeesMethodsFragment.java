package com.avito.android.tariff.fees_methods;

import a2.a.a.e3.e.b;
import a2.a.a.e3.e.c;
import a2.a.a.e3.e.d;
import a2.a.a.e3.e.e;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.fees_methods.di.DaggerFeeMethodsComponent;
import com.avito.android.tariff.fees_methods.di.FeeMethodsComponent;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel;
import com.avito.android.tariff.fees_methods.viewmodel.HighDemandBottomSheetParams;
import com.avito.android.tariff.routing.NavigationIcon;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\bd\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR+\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010,\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020&8B@BX\u0002¢\u0006\u0012\n\u0004\b'\u0010 \u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR5\u0010W\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030U¢\u0006\u0002\bV0T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R+\u0010c\u001a\u00020]2\u0006\u0010\u001e\u001a\u00020]8B@BX\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b^\u0010`\"\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDetach", "()V", "", "d", "Z", "isClosable", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "e", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "<set-?>", "c", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "f", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheetDialog", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "viewModel", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "getViewModel", "()Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "setViewModel", "(Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeesMethodsFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.u0(FeesMethodsFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(FeesMethodsFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(FeesMethodsFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public boolean d;
    public PaidServicesRouter e;
    public BottomSheetDialog f;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public RecyclerView.ItemDecoration itemDecoration;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public FeeMethodsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment$Companion;", "", "", "checkoutContext", "", "closable", "Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment;", "newInstance", "(Ljava/lang/String;Z)Lcom/avito/android/tariff/fees_methods/FeesMethodsFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final FeesMethodsFragment newInstance(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            FeesMethodsFragment feesMethodsFragment = new FeesMethodsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            bundle.putBoolean("closable", z);
            feesMethodsFragment.setArguments(bundle);
            return feesMethodsFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NavigationIcon.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FeesMethodsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FeesMethodsFragment feesMethodsFragment) {
            super(0);
            this.a = feesMethodsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final ProgressOverlay access$getProgressOverlay$p(FeesMethodsFragment feesMethodsFragment) {
        return (ProgressOverlay) feesMethodsFragment.c.getValue((Fragment) feesMethodsFragment, g[2]);
    }

    public static final Toolbar access$getToolbar$p(FeesMethodsFragment feesMethodsFragment) {
        return (Toolbar) feesMethodsFragment.b.getValue((Fragment) feesMethodsFragment, g[1]);
    }

    public static final void access$setProgressOverlay$p(FeesMethodsFragment feesMethodsFragment, ProgressOverlay progressOverlay) {
        feesMethodsFragment.c.setValue((Fragment) feesMethodsFragment, g[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(FeesMethodsFragment feesMethodsFragment, RecyclerView recyclerView) {
        feesMethodsFragment.a.setValue((Fragment) feesMethodsFragment, g[0], (KProperty<?>) recyclerView);
    }

    public static final void access$setToolbar$p(FeesMethodsFragment feesMethodsFragment, Toolbar toolbar) {
        feesMethodsFragment.b.setValue((Fragment) feesMethodsFragment, g[1], (KProperty<?>) toolbar);
    }

    public static final void access$showBottomSheet(FeesMethodsFragment feesMethodsFragment, HighDemandBottomSheetParams highDemandBottomSheetParams) {
        Objects.requireNonNull(feesMethodsFragment);
        Context requireContext = feesMethodsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        View inflate = View.inflate(bottomSheetDialog.getContext(), R.layout.bottom_sheet_layout_info, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "contentView");
        bottomSheetDialog.setContentView(inflate, true);
        RightCrossHeaderKt.setRightCrossHeader(bottomSheetDialog, highDemandBottomSheetParams.getTitle(), true, true);
        TextView textView = (TextView) inflate.findViewById(R.id.description);
        Button button = (Button) inflate.findViewById(R.id.primary_button);
        Button button2 = (Button) inflate.findViewById(R.id.secondary_button);
        Intrinsics.checkNotNullExpressionValue(textView, "description");
        AttributedTextFormatter attributedTextFormatter2 = feesMethodsFragment.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        Context requireContext2 = feesMethodsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        textView.setText(attributedTextFormatter2.format(requireContext2, highDemandBottomSheetParams.getDescription()));
        Intrinsics.checkNotNullExpressionValue(button, "primaryButton");
        ButtonsKt.bindText$default(button, highDemandBottomSheetParams.getPrimaryButtonText(), false, 2, null);
        Intrinsics.checkNotNullExpressionValue(button2, "secondaryButton");
        ButtonsKt.bindText$default(button2, highDemandBottomSheetParams.getSecondaryButtonText(), false, 2, null);
        button.setOnClickListener(new d1(0, feesMethodsFragment, highDemandBottomSheetParams));
        button2.setOnClickListener(new d1(1, feesMethodsFragment, highDemandBottomSheetParams));
        bottomSheetDialog.show();
        feesMethodsFragment.f = bottomSheetDialog;
    }

    public final RecyclerView a() {
        return (RecyclerView) this.a.getValue((Fragment) this, g[0]);
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
    public final RecyclerView.ItemDecoration getItemDecoration() {
        RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
        if (itemDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
        }
        return itemDecoration2;
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
    public final FeeMethodsViewModel getViewModel() {
        FeeMethodsViewModel feeMethodsViewModel = this.viewModel;
        if (feeMethodsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return feeMethodsViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) (!(context instanceof PaidServicesRouter) ? null : context);
        if (paidServicesRouter != null) {
            this.e = paidServicesRouter;
            if (!(context instanceof ComponentProvider)) {
                context = null;
            }
            ComponentProvider componentProvider = (ComponentProvider) context;
            if (componentProvider != null) {
                TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider.getComponent();
                Bundle arguments = getArguments();
                if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                    throw new IllegalStateException("checkout context must be set");
                }
                Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…out context must be set\")");
                Bundle arguments2 = getArguments();
                this.d = arguments2 != null ? arguments2.getBoolean("closable") : this.d;
                FeeMethodsComponent.Builder fragment = DaggerFeeMethodsComponent.builder().dependencies(tariffStepDependencies).checkoutContext(string).isClosable(this.d).fragment(this);
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                fragment.resources(resources).build().inject(this);
                FeeMethodsViewModel feeMethodsViewModel = this.viewModel;
                if (feeMethodsViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                feeMethodsViewModel.observeItemClicks(set);
                return;
            }
            throw new IllegalStateException("Parent activity must implement ComponentProvider");
        }
        throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fees_methods_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        AutoClearedRecyclerView autoClearedRecyclerView = this.a;
        KProperty<?>[] kPropertyArr = g;
        autoClearedRecyclerView.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById));
        RecyclerView a3 = a();
        RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
        if (itemDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
        }
        a3.addItemDecoration(itemDecoration2);
        RecyclerView a4 = a();
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        a4.setAdapter(new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2));
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById2));
        View findViewById3 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.progress_placeholder)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById3, i, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new a(this));
        FeeMethodsViewModel feeMethodsViewModel = this.viewModel;
        if (feeMethodsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        feeMethodsViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.e.a(this));
        FeeMethodsViewModel feeMethodsViewModel2 = this.viewModel;
        if (feeMethodsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> routingEvents = feeMethodsViewModel2.getRoutingEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        routingEvents.observe(viewLifecycleOwner, new b(this));
        FeeMethodsViewModel feeMethodsViewModel3 = this.viewModel;
        if (feeMethodsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        feeMethodsViewModel3.getNavigationIconChanges().observe(getViewLifecycleOwner(), new c(this));
        FeeMethodsViewModel feeMethodsViewModel4 = this.viewModel;
        if (feeMethodsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<HighDemandBottomSheetParams> bottomSheetChanges = feeMethodsViewModel4.getBottomSheetChanges();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        bottomSheetChanges.observe(viewLifecycleOwner2, new d(this));
        FeeMethodsViewModel feeMethodsViewModel5 = this.viewModel;
        if (feeMethodsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Unit> closeBottomSheetChanges = feeMethodsViewModel5.getCloseBottomSheetChanges();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        closeBottomSheetChanges.observe(viewLifecycleOwner3, new e(this));
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

    public final void setItemDecoration(@NotNull RecyclerView.ItemDecoration itemDecoration2) {
        Intrinsics.checkNotNullParameter(itemDecoration2, "<set-?>");
        this.itemDecoration = itemDecoration2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setViewModel(@NotNull FeeMethodsViewModel feeMethodsViewModel) {
        Intrinsics.checkNotNullParameter(feeMethodsViewModel, "<set-?>");
        this.viewModel = feeMethodsViewModel;
    }
}
