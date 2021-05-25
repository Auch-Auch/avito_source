package com.avito.android.vas_performance.ui.applied_services;

import a2.a.a.q3.f.q0.a;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.R;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Views;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServiceListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "showProgress", "()V", "hideProgress", "outState", "onSaveInstanceState", "closeWithError", "Lcom/google/android/material/snackbar/Snackbar;", "l", "Lcom/google/android/material/snackbar/Snackbar;", "snackbar", "Landroid/view/View;", "k", "Landroid/view/View;", "progressView", "<init>", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServicesActivity extends BaseActivity implements AppliedServiceListener {
    public View k;
    public Snackbar l;

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServiceListener
    public void closeWithError() {
        hideProgress();
        if (this.l == null) {
            View view = this.k;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
            }
            this.l = Views.showSnackBar$default(view, R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, new a(this), 0, 92, (Object) null);
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("dialog");
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServiceListener
    public void hideProgress() {
        View view = this.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.hide(view);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.avito.android.vas_performance.R.layout.applied_service_activity);
        View findViewById = findViewById(com.avito.android.vas_performance.R.id.progress_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.progress_view)");
        this.k = findViewById;
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("advert_id");
            AppliedServicesDialogFragment.Companion companion = AppliedServicesDialogFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(stringExtra, BookingInfoActivity.EXTRA_ITEM_ID);
            companion.newInstance(stringExtra).show(getSupportFragmentManager(), "dialog");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Snackbar snackbar = this.l;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServiceListener
    public void showProgress() {
        View view = this.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.show(view);
    }
}
