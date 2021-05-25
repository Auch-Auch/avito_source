package com.avito.android.safedeal.delivery_courier.time_interval_select;

import a2.a.a.i2.a.c.a;
import a2.a.a.i2.a.c.b;
import a2.a.a.i2.a.c.c;
import a2.a.a.i2.a.c.d;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.di.component.DaggerDeliveryCourierTimeIntervalSelectComponent;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.ItemBinder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "", "Lkotlin/Pair;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectView;", "c", "Ljava/util/List;", "dialogs", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "getViewModel", "()Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "setViewModel", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;)V", "<init>", "()V", "Factory", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectFragment extends BaseFragment {
    public final List<Pair<BottomSheetDialog, DeliveryCourierTimeIntervalSelectView>> c = new ArrayList();
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public DeliveryCourierTimeIntervalSelectViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment$Factory;", "", "", "orderID", "source", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selected", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectFragment;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final DeliveryCourierTimeIntervalSelectFragment createInstance(@NotNull String str, @NotNull String str2, @Nullable TimeInterval timeInterval) {
            Intrinsics.checkNotNullParameter(str, "orderID");
            Intrinsics.checkNotNullParameter(str2, "source");
            Bundle bundle = new Bundle(3);
            bundle.putString("EXTRA_ORDER_ID", str);
            bundle.putString("EXTRA_SOURCE", str2);
            bundle.putParcelable(DeliveryCourierTimeIntervalSelectActivityKt.EXTRA_SELECTED, timeInterval);
            DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment = new DeliveryCourierTimeIntervalSelectFragment();
            deliveryCourierTimeIntervalSelectFragment.setArguments(bundle);
            return deliveryCourierTimeIntervalSelectFragment;
        }
    }

    public static final void access$showDialog(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment, DialogData dialogData) {
        Objects.requireNonNull(deliveryCourierTimeIntervalSelectFragment);
        Context requireContext = deliveryCourierTimeIntervalSelectFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, R.style.Theme_Avito_BottomSheetDialog_TimeInterval);
        bottomSheetDialog.setContentView(R.layout.delivery_courier_bottom_sheet_time_interval_select, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, true, false, 10, null);
        bottomSheetDialog.setPeekHeight(deliveryCourierTimeIntervalSelectFragment.getResources().getDimensionPixelOffset(R.dimen.dialog_peek_height));
        bottomSheetDialog.setOnDismissListener(new d(bottomSheetDialog, deliveryCourierTimeIntervalSelectFragment, dialogData));
        ItemBinder itemBinder2 = deliveryCourierTimeIntervalSelectFragment.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        DeliveryCourierTimeIntervalSelectViewImpl deliveryCourierTimeIntervalSelectViewImpl = new DeliveryCourierTimeIntervalSelectViewImpl(bottomSheetDialog, itemBinder2);
        deliveryCourierTimeIntervalSelectViewImpl.bindData(dialogData);
        deliveryCourierTimeIntervalSelectFragment.c.add(new Pair<>(bottomSheetDialog, deliveryCourierTimeIntervalSelectViewImpl));
        bottomSheetDialog.show();
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
    public final DeliveryCourierTimeIntervalSelectViewModel getViewModel() {
        DeliveryCourierTimeIntervalSelectViewModel deliveryCourierTimeIntervalSelectViewModel = this.viewModel;
        if (deliveryCourierTimeIntervalSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryCourierTimeIntervalSelectViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_delivery_courier_time_interval_select, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DeliveryCourierTimeIntervalSelectViewModel deliveryCourierTimeIntervalSelectViewModel = this.viewModel;
        if (deliveryCourierTimeIntervalSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryCourierTimeIntervalSelectViewModel.getTimeIntervalSelectedChanges().observe(getViewLifecycleOwner(), new a(this));
        deliveryCourierTimeIntervalSelectViewModel.getTimeIntervalSelectErrorChanges().observe(getViewLifecycleOwner(), new b(this));
        deliveryCourierTimeIntervalSelectViewModel.getShowDialogChanges().observe(getViewLifecycleOwner(), new c(this));
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString("EXTRA_ORDER_ID");
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(EXTR…eption(\"orderID not set\")");
                String string2 = arguments.getString("EXTRA_SOURCE");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(EXTR…ception(\"source not set\")");
                    DeliveryCourierTimeIntervalSelectComponent.Builder deliveryTimeIntervalSuggestDependencies = DaggerDeliveryCourierTimeIntervalSelectComponent.builder().deliveryTimeIntervalSuggestDependencies((DeliveryCourierCommonDependencies) ComponentDependenciesKt.getDependencies(DeliveryCourierCommonDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                    FragmentActivity activity = getActivity();
                    Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
                    DeliveryCourierTimeIntervalSelectComponent.Builder activity2 = deliveryTimeIntervalSuggestDependencies.activity(activity);
                    Resources resources = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    activity2.resources(resources).viewModelFragment(this).orderID(string).source(string2).selectedTimeInterval((TimeInterval) arguments.getParcelable(DeliveryCourierTimeIntervalSelectActivityKt.EXTRA_SELECTED)).build().inject(this);
                    return true;
                }
                throw new IllegalStateException("source not set");
            }
            throw new IllegalStateException("orderID not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull DeliveryCourierTimeIntervalSelectViewModel deliveryCourierTimeIntervalSelectViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectViewModel, "<set-?>");
        this.viewModel = deliveryCourierTimeIntervalSelectViewModel;
    }
}
