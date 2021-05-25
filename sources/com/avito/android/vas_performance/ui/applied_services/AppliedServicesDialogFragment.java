package com.avito.android.vas_performance.ui.applied_services;

import a2.a.a.q3.f.q0.c;
import a2.a.a.q3.f.q0.d;
import a2.b.a.a.a;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.vas_performance.R;
import com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies;
import com.avito.android.vas_performance.di.applied_services.AppliedServicesModule;
import com.avito.android.vas_performance.di.applied_services.DaggerAppliedServicesComponent;
import com.avito.android.vas_performance.ui.recycler.AppliedServicesDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b8\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R5\u0010'\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030%¢\u0006\u0002\b&0$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServiceListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServiceListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "viewModel", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "getViewModel", "()Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "setViewModel", "(Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "Companion", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServicesDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public RecyclerView a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public AppliedServiceListener b;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public AppliedServicesViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment;", "KEY_ADVERT_ID", "Ljava/lang/String;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AppliedServicesDialogFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            AppliedServicesDialogFragment appliedServicesDialogFragment = new AppliedServicesDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("advert_id", str);
            appliedServicesDialogFragment.setArguments(bundle);
            return appliedServicesDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final void access$showList(AppliedServicesDialogFragment appliedServicesDialogFragment, List list) {
        AppliedServiceListener appliedServiceListener = appliedServicesDialogFragment.b;
        if (appliedServiceListener != null) {
            appliedServiceListener.hideProgress();
        }
        AdapterPresenter adapterPresenter2 = appliedServicesDialogFragment.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        a.s1(list, adapterPresenter2);
        RecyclerView recyclerView = appliedServicesDialogFragment.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        Dialog dialog = appliedServicesDialogFragment.getDialog();
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.avito.android.lib.design.bottom_sheet.BottomSheetDialog");
        ((BottomSheetDialog) dialog).showBottomSheet();
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
    public final AppliedServicesViewModel getViewModel() {
        AppliedServicesViewModel appliedServicesViewModel = this.viewModel;
        if (appliedServicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return appliedServicesViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof AppliedServiceListener)) {
            context = null;
        }
        AppliedServiceListener appliedServiceListener = (AppliedServiceListener) context;
        if (appliedServiceListener != null) {
            this.b = appliedServiceListener;
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("advert_id")) == null) {
                throw new IllegalStateException("advert id must be set");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…(\"advert id must be set\")");
            DaggerAppliedServicesComponent.builder().module(new AppliedServicesModule(this, string)).dependencies((AppliedServicesDependencies) ComponentDependenciesKt.getDependencies(AppliedServicesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
            return;
        }
        throw new IllegalStateException("context must implement AppliedServiceListener");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.applied_services_fragment, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        bottomSheetDialog.setPeekHeight(displayMetrics.heightPixels);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, true, false, 10, null);
        View findViewById = bottomSheetDialog.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.a = (RecyclerView) findViewById;
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
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        Resources resources = requireContext2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "requireContext().resources");
        recyclerView2.addItemDecoration(new AppliedServicesDecoration(resources));
        AppliedServicesViewModel appliedServicesViewModel = this.viewModel;
        if (appliedServicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        appliedServicesViewModel.subscribeToItemClicks(set);
        AppliedServicesViewModel appliedServicesViewModel2 = this.viewModel;
        if (appliedServicesViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appliedServicesViewModel2.getRoutingEvents().observe(requireActivity(), new c(this));
        AppliedServicesViewModel appliedServicesViewModel3 = this.viewModel;
        if (appliedServicesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appliedServicesViewModel3.getProgressChanges().observe(requireActivity(), new d(this));
        bottomSheetDialog.setShowOnStart(false);
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.b = null;
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

    public final void setViewModel(@NotNull AppliedServicesViewModel appliedServicesViewModel) {
        Intrinsics.checkNotNullParameter(appliedServicesViewModel, "<set-?>");
        this.viewModel = appliedServicesViewModel;
    }
}
