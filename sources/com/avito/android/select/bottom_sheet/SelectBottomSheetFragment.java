package com.avito.android.select.bottom_sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.R;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogRouter;
import com.avito.android.select.SelectListener;
import com.avito.android.select.bottom_sheet.di.DaggerSelectBottomSheetComponent;
import com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent;
import com.avito.android.select.di.SelectDialogDependencies;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0019\u001a\u00020\u00052\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\fJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010!R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b.\u0010#R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010!R.\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0006@\u0006X.¢\u0006\u0018\n\u0004\b;\u0010<\u0012\u0004\bA\u0010\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/avito/android/select/bottom_sheet/SelectBottomSheetFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/select/SelectDialogRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onResume", "()V", "outState", "onSaveInstanceState", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "selectedVariants", "sectionTitle", "onSelected", "(Ljava/util/List;Ljava/lang/String;)V", "onCancel", "Lcom/avito/android/select/SelectListener;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/select/SelectListener;", "", "d", "Z", "isFinishedSuccessfully", "Ljava/lang/String;", "requestId", "Lcom/avito/android/select/SelectDialogPresenter;", "presenter", "Lcom/avito/android/select/SelectDialogPresenter;", "getPresenter", "()Lcom/avito/android/select/SelectDialogPresenter;", "setPresenter", "(Lcom/avito/android/select/SelectDialogPresenter;)V", "e", "shouldExposeImageFilterGroup", AuthSource.BOOKING_ORDER, "title", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "c", "footerNeeded", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "filterWithPhotosGroup", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getFilterWithPhotosGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "setFilterWithPhotosGroup", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "getFilterWithPhotosGroup$annotations", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectBottomSheetFragment extends DialogFragment implements SelectDialogRouter {
    public String a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Inject
    public SingleManuallyExposedAbTestGroup<SimpleTestGroup> filterWithPhotosGroup;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SelectDialogPresenter presenter;

    public static final class a implements DialogInterface.OnDismissListener {
        public static final a a = new a();

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    @AutoGenerationsFilterWithPhotos
    public static /* synthetic */ void getFilterWithPhotosGroup$annotations() {
    }

    public final SelectListener a() {
        Fragment targetFragment = getTargetFragment();
        SelectListener selectListener = null;
        if (!(targetFragment instanceof SelectListener)) {
            targetFragment = null;
        }
        SelectListener selectListener2 = (SelectListener) targetFragment;
        if (selectListener2 != null) {
            return selectListener2;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof SelectListener) {
            selectListener = activity;
        }
        return selectListener;
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
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> getFilterWithPhotosGroup() {
        SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup = this.filterWithPhotosGroup;
        if (singleManuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterWithPhotosGroup");
        }
        return singleManuallyExposedAbTestGroup;
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
    public final SelectDialogPresenter getPresenter() {
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectDialogPresenter;
    }

    @Override // com.avito.android.select.SelectDialogRouter
    public void onCancel() {
        dismissAllowingStateLoss();
        SelectListener a3 = a();
        if (a3 != null) {
            String str = this.a;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestId");
            }
            a3.onCancel(str);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = bundle != null ? bundle.getBundle("presenter_state") : null;
        Parcelable parcelable = requireArguments().getParcelable("arguments");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…guments>(KEY_ARGUMENTS)!!");
        Arguments arguments = (Arguments) parcelable;
        this.a = arguments.getRequestId();
        this.b = arguments.getTitle();
        this.c = arguments.getMultiSelect();
        this.e = arguments.getShouldExposeImageFilterGroup();
        SelectBottomSheetComponent.Builder withArguments = DaggerSelectBottomSheetComponent.builder().dependentOn((SelectDialogDependencies) ComponentDependenciesKt.getDependencies(SelectDialogDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withPresenterState(bundle2).withArguments(arguments);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withArguments.withResources(resources).build().inject(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.select_sheet_dialog, this.c ? R.layout.select_main_button : -1);
        String str = this.b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, str, null, true, true, 2, null);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnDismissListener(a.a);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        Views.hide(bottomSheetDialog.findViewById(com.avito.android.lib.design.R.id.header_divider));
        View findViewById = bottomSheetDialog.findViewById(com.avito.android.lib.design.R.id.bottom_sheet);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SelectBottomSheetViewImpl selectBottomSheetViewImpl = new SelectBottomSheetViewImpl(viewGroup, adapterPresenter2, itemBinder2, (Button) bottomSheetDialog.findViewById(R.id.main_button));
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter.attachView(selectBottomSheetViewImpl);
        SelectDialogPresenter selectDialogPresenter2 = this.presenter;
        if (selectDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter2.attachRouter(this);
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter.detachRouter();
        SelectDialogPresenter selectDialogPresenter2 = this.presenter;
        if (selectDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectDialogPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.d) {
            onCancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup = this.filterWithPhotosGroup;
            if (singleManuallyExposedAbTestGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterWithPhotosGroup");
            }
            singleManuallyExposedAbTestGroup.exposeIfNeeded();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectDialogPresenter selectDialogPresenter = this.presenter;
        if (selectDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", selectDialogPresenter.onSaveState());
    }

    @Override // com.avito.android.select.SelectDialogRouter
    public void onSelected(@NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "selectedVariants");
        this.d = true;
        SelectListener a3 = a();
        if (a3 != null) {
            String str2 = this.a;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestId");
            }
            a3.onSelected(str2, list, str);
            dismissAllowingStateLoss();
        }
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setFilterWithPhotosGroup(@NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "<set-?>");
        this.filterWithPhotosGroup = singleManuallyExposedAbTestGroup;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SelectDialogPresenter selectDialogPresenter) {
        Intrinsics.checkNotNullParameter(selectDialogPresenter, "<set-?>");
        this.presenter = selectDialogPresenter;
    }
}
