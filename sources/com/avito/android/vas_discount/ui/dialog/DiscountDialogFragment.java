package com.avito.android.vas_discount.ui.dialog;

import a2.a.a.p3.a.a.b;
import a2.a.a.p3.a.a.d;
import a2.a.a.p3.a.a.e;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.vas_discount.DiscountListener;
import com.avito.android.vas_discount.R;
import com.avito.android.vas_discount.di.DaggerPickerComponent;
import com.avito.android.vas_discount.di.PickerDependencies;
import com.avito.android.vas_discount.di.PickerModule;
import com.avito.android.vas_discount.ui.items.PaddingDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR5\u0010#\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030!¢\u0006\u0002\b\"0 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onDestroyView", "()V", "Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "viewModel", "Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "getViewModel", "()Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "setViewModel", "(Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/vas_discount/DiscountListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/vas_discount/DiscountListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "d", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "bottomSheetDialog", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "<init>", "Companion", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public DiscountListener b;
    public LinearLayoutManager c;
    public BottomSheetDialog d;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public DiscountPickerViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment$Companion;", "", "Lcom/avito/android/remote/model/DiscountResponse;", "discountResponse", "Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment;", "newInstance", "(Lcom/avito/android/remote/model/DiscountResponse;)Lcom/avito/android/vas_discount/ui/dialog/DiscountDialogFragment;", "", "KEY_DISCOUNT_DATA", "Ljava/lang/String;", "<init>", "()V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final DiscountDialogFragment newInstance(@NotNull DiscountResponse discountResponse) {
            Intrinsics.checkNotNullParameter(discountResponse, "discountResponse");
            DiscountDialogFragment discountDialogFragment = new DiscountDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("discount_data", discountResponse);
            discountDialogFragment.setArguments(bundle);
            return discountDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final /* synthetic */ LinearLayoutManager access$getLayoutManager$p(DiscountDialogFragment discountDialogFragment) {
        LinearLayoutManager linearLayoutManager = discountDialogFragment.c;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return linearLayoutManager;
    }

    public static final /* synthetic */ DiscountListener access$getListener$p(DiscountDialogFragment discountDialogFragment) {
        DiscountListener discountListener = discountDialogFragment.b;
        if (discountListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        return discountListener;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(DiscountDialogFragment discountDialogFragment) {
        RecyclerView recyclerView = discountDialogFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
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
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final DiscountPickerViewModel getViewModel() {
        DiscountPickerViewModel discountPickerViewModel = this.viewModel;
        if (discountPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return discountPickerViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        DiscountResponse discountResponse;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DiscountListener discountListener = (DiscountListener) (!(context instanceof DiscountListener) ? null : context);
        if (discountListener != null) {
            this.b = discountListener;
            if (!(context instanceof ComponentProvider)) {
                context = null;
            }
            ComponentProvider componentProvider = (ComponentProvider) context;
            if (componentProvider != null) {
                Bundle arguments = getArguments();
                if (arguments == null || (discountResponse = (DiscountResponse) arguments.getParcelable("discount_data")) == null) {
                    throw new IllegalStateException("DiscountResponse must be set");
                }
                DaggerPickerComponent.builder().dependencies((PickerDependencies) componentProvider.getComponent()).discountModule(new PickerModule(this, discountResponse)).build().inject(this);
                DiscountPickerViewModel discountPickerViewModel = this.viewModel;
                if (discountPickerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                discountPickerViewModel.subscribeToItemClicks(set);
                return;
            }
            throw new IllegalStateException("Parent activity must implement ComponentProvider");
        }
        throw new IllegalStateException("context must implement DiscountListener");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        this.d = bottomSheetDialog;
        bottomSheetDialog.setContentView(R.layout.vas_discount_dialog, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setPeekHeight(getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, true, false, 10, null);
        View findViewById = bottomSheetDialog.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.a = (RecyclerView) findViewById;
        this.c = new LinearLayoutManager(requireContext());
        RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        LinearLayoutManager linearLayoutManager = this.c;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setAdapter(simpleRecyclerAdapter);
        RecyclerView recyclerView3 = this.a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        recyclerView3.addItemDecoration(new PaddingDecoration(resources));
        DiscountPickerViewModel discountPickerViewModel = this.viewModel;
        if (discountPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        discountPickerViewModel.getDataChanges().observe(requireActivity(), new b(this));
        DiscountPickerViewModel discountPickerViewModel2 = this.viewModel;
        if (discountPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        discountPickerViewModel2.getRoutingEvents().observe(requireActivity(), new d(this));
        DiscountPickerViewModel discountPickerViewModel3 = this.viewModel;
        if (discountPickerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        discountPickerViewModel3.getErrorEvents().observe(requireActivity(), new e(this));
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "it");
            if (!activity.isFinishing() && !activity.isChangingConfigurations()) {
                activity.finish();
            }
        }
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setViewModel(@NotNull DiscountPickerViewModel discountPickerViewModel) {
        Intrinsics.checkNotNullParameter(discountPickerViewModel, "<set-?>");
        this.viewModel = discountPickerViewModel;
    }
}
