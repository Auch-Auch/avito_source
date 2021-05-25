package com.avito.android.version_conflict;

import a2.a.a.s3.a;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.version_conflict.di.DaggerResolveAppVersionConflictComponent;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/avito/android/version_conflict/ResolveAppVersionConflictActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "", AuthSource.BOOKING_ORDER, "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AlertDialog;", "k", "Landroidx/appcompat/app/AlertDialog;", "dialog", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public final class ResolveAppVersionConflictActivity extends BaseActivity {
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public AlertDialog k;

    public static final void access$closeDialog(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity, DialogInterface dialogInterface) {
        Objects.requireNonNull(resolveAppVersionConflictActivity);
        dialogInterface.dismiss();
        resolveAppVersionConflictActivity.finish();
    }

    public static final void access$openMarket(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity) {
        ImplicitIntentFactory implicitIntentFactory2 = resolveAppVersionConflictActivity.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Contexts.startActivitySafely(resolveAppVersionConflictActivity, implicitIntentFactory2.marketIntent());
        resolveAppVersionConflictActivity.finishAffinity();
    }

    public static final void access$openMobileVersion(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity) {
        Objects.requireNonNull(resolveAppVersionConflictActivity);
        Contexts.startActivitySafely(resolveAppVersionConflictActivity, new Intent("android.intent.action.VIEW", Uri.parse(Constants.AVITO_MOBILE_URL)));
        resolveAppVersionConflictActivity.finishAffinity();
        System.exit(0);
    }

    public final String a() {
        String string = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.cancel)");
        return string;
    }

    public final String b() {
        String string = getString(R.string.update);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.update)");
        return string;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        AlertDialog alertDialog;
        super.onCreate(bundle);
        DaggerResolveAppVersionConflictComponent.builder().dependentOn((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        int intExtra = getIntent().getIntExtra("EXTRA_VALIDATE_VERSION_STATUS", 0);
        if (intExtra == 1) {
            alertDialog = new AlertDialog.Builder(this).setMessage(getString(R.string.config_update_proposal)).setPositiveButton(b(), new k1(0, this)).setNegativeButton(a(), new k1(1, this)).setCancelable(true).create();
            Intrinsics.checkNotNullExpressionValue(alertDialog, "AlertDialog.Builder(this…ue)\n            .create()");
        } else if (intExtra == 2) {
            alertDialog = new AlertDialog.Builder(this).setMessage(getString(R.string.config_update_required)).setPositiveButton(b(), new n1(0, this)).setNegativeButton(a(), new n1(1, this)).setCancelable(false).create();
            Intrinsics.checkNotNullExpressionValue(alertDialog, "AlertDialog.Builder(this…se)\n            .create()");
        } else if (intExtra == 3) {
            alertDialog = new AlertDialog.Builder(this).setMessage(getString(R.string.config_update_device_warning)).setPositiveButton(b(), new b0(0, this)).setNegativeButton(a(), new b0(1, this)).setCancelable(true).create();
            Intrinsics.checkNotNullExpressionValue(alertDialog, "AlertDialog.Builder(this…ue)\n            .create()");
        } else if (intExtra != 4) {
            alertDialog = null;
        } else {
            AlertDialog.Builder message = new AlertDialog.Builder(this).setMessage(getString(R.string.config_device_not_supported));
            String string = getString(R.string.proceed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.proceed)");
            alertDialog = message.setPositiveButton(string, new a(this)).setCancelable(false).create();
        }
        this.k = alertDialog;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = this.k;
        if (alertDialog != null) {
            alertDialog.show();
        } else {
            finish();
        }
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }
}
