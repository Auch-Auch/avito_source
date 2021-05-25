package com.avito.android.blocked_ip;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.HelpCenterIntentFactory;
import com.avito.android.blocked_ip.BlockedIpDialogPresenter;
import com.avito.android.blocked_ip.di.BlockedIpDependencies;
import com.avito.android.blocked_ip.di.DaggerBlockedIpDialogComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b2\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nJS\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\nR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/avito/android/blocked_ip/BlockedIpDialogActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/blocked_ip/BlockedIpDialogView;", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "image", "title", "message", "negativeButtonText", "positiveButtonText", "Lkotlin/Function0;", "cancelListener", "agreeListener", "showDialog", "(IIIIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "openHelpCenterRequest", "closeDialog", "Landroid/app/Dialog;", "k", "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory$blocked_ip_release", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory$blocked_ip_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "presenter", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "getPresenter", "()Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "setPresenter", "(Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;)V", "<init>", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedIpDialogActivity extends BaseActivity implements BlockedIpDialogView, BlockedIpDialogPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    public Dialog k;
    @Inject
    public BlockedIpDialogPresenter presenter;

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter.Router
    public void closeDialog() {
        Dialog dialog = this.k;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        }
        dialog.dismiss();
        finish();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory$blocked_ip_release() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final BlockedIpDialogPresenter getPresenter() {
        BlockedIpDialogPresenter blockedIpDialogPresenter = this.presenter;
        if (blockedIpDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return blockedIpDialogPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerBlockedIpDialogComponent.builder().blockedIpDependencies((BlockedIpDependencies) ComponentDependenciesKt.getDependencies(BlockedIpDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).build().inject(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        BlockedIpDialogPresenter blockedIpDialogPresenter = this.presenter;
        if (blockedIpDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blockedIpDialogPresenter.attachView(this);
        BlockedIpDialogPresenter blockedIpDialogPresenter2 = this.presenter;
        if (blockedIpDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blockedIpDialogPresenter2.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        BlockedIpDialogPresenter blockedIpDialogPresenter = this.presenter;
        if (blockedIpDialogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blockedIpDialogPresenter.detachView();
        BlockedIpDialogPresenter blockedIpDialogPresenter2 = this.presenter;
        if (blockedIpDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        blockedIpDialogPresenter2.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.blocked_ip.BlockedIpDialogPresenter.Router
    public void openHelpCenterRequest() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(HelpCenterIntentFactory.DefaultImpls.helpCenterRequestIntent$default(activityIntentFactory2, "34", null, "12", 2, null)));
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
        closeDialog();
    }

    public final void setActivityIntentFactory$blocked_ip_release(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setPresenter(@NotNull BlockedIpDialogPresenter blockedIpDialogPresenter) {
        Intrinsics.checkNotNullParameter(blockedIpDialogPresenter, "<set-?>");
        this.presenter = blockedIpDialogPresenter;
    }

    @Override // com.avito.android.blocked_ip.BlockedIpDialogView
    public void showDialog(int i, int i2, int i3, int i4, int i5, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "cancelListener");
        Intrinsics.checkNotNullParameter(function02, "agreeListener");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        this.k = dialogRouter2.showNotifyingDialogWithImage(i, i2, i3, i4, i5, function0, function02, false);
    }
}
