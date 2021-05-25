package com.avito.android.spare_parts.bottom_sheet;

import a2.a.a.z2.b.a;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.R;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter;
import com.avito.android.spare_parts.bottom_sheet.di.DaggerSparePartsBottomSheetComponent;
import com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter$Router;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "presenter", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "getPresenter", "()Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "setPresenter", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;)V", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "k", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsBottomSheetActivity extends BaseActivity implements SparePartsBottomSheetPresenter.Router {
    @Inject
    public SimpleRecyclerAdapter adapter;
    public BottomSheetDialog k;
    @Inject
    public SparePartsBottomSheetPresenter presenter;

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_spare_parts_bottom_sheet;
    }

    @NotNull
    public final SparePartsBottomSheetPresenter getPresenter() {
        SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter = this.presenter;
        if (sparePartsBottomSheetPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sparePartsBottomSheetPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this).inflate(R.layout.spare_parts_bottom_sheet_view, (ViewGroup) null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, 0, 2, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        bottomSheetDialog.setContentView(inflate, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnDismissListener(new a(this, inflate));
        bottomSheetDialog.setPeekHeight(Views.dpToPx(this, 420));
        this.k = bottomSheetDialog;
        Intrinsics.checkNotNull(bottomSheetDialog);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl = new SparePartsBottomSheetViewImpl(inflate, bottomSheetDialog, simpleRecyclerAdapter);
        SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter = this.presenter;
        if (sparePartsBottomSheetPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sparePartsBottomSheetPresenter.attachView(sparePartsBottomSheetViewImpl);
        SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter2 = this.presenter;
        if (sparePartsBottomSheetPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sparePartsBottomSheetPresenter2.attachRouter(this);
        BottomSheetDialog bottomSheetDialog2 = this.k;
        if (bottomSheetDialog2 != null) {
            bottomSheetDialog2.show();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter = this.presenter;
        if (sparePartsBottomSheetPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sparePartsBottomSheetPresenter.detachRouter();
        SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter2 = this.presenter;
        if (sparePartsBottomSheetPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sparePartsBottomSheetPresenter2.detachView();
        BottomSheetDialog bottomSheetDialog = this.k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.setOnDismissListener(null);
            boolean z = true;
            if (!bottomSheetDialog.isShowing()) {
                z = false;
            }
            if (z) {
                bottomSheetDialog.dismiss();
            }
        }
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setPresenter(@NotNull SparePartsBottomSheetPresenter sparePartsBottomSheetPresenter) {
        Intrinsics.checkNotNullParameter(sparePartsBottomSheetPresenter, "<set-?>");
        this.presenter = sparePartsBottomSheetPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_spare_parts_group");
        Intrinsics.checkNotNull(parcelableExtra);
        SparePartsBottomSheetComponent.Builder withRootGroup = DaggerSparePartsBottomSheetComponent.builder().withRootGroup((SparePartsResponse.SparePartsGroup) parcelableExtra);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withRootGroup.withResources(resources).build().inject(this);
        return true;
    }
}
