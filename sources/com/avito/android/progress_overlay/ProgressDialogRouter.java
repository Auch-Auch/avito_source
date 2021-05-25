package com.avito.android.progress_overlay;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.dialog.ProgressDialogFragment;
import com.avito.android.ui.view.dialog.ProgressDialogFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "", "", "removeDialog", "()Z", "", "showDialog", "()V", "Landroidx/fragment/app/FragmentActivity;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroidx/fragment/app/DialogFragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressDialogRouter {
    public DialogFragment a;
    public final FragmentActivity b;

    public ProgressDialogRouter(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.b = fragmentActivity;
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("progress_dialog");
        this.a = (DialogFragment) (!(findFragmentByTag instanceof DialogFragment) ? null : findFragmentByTag);
    }

    public final boolean removeDialog() {
        DialogFragment dialogFragment = this.a;
        if (dialogFragment == null) {
            return false;
        }
        Intrinsics.checkNotNull(dialogFragment);
        dialogFragment.dismiss();
        FragmentTransaction beginTransaction = this.b.getSupportFragmentManager().beginTransaction();
        DialogFragment dialogFragment2 = this.a;
        Intrinsics.checkNotNull(dialogFragment2);
        beginTransaction.remove(dialogFragment2).commit();
        return true;
    }

    public final void showDialog() {
        ProgressDialogFragment createProgressDialogFragment = ProgressDialogFragmentKt.createProgressDialogFragment();
        this.a = createProgressDialogFragment;
        if (createProgressDialogFragment != null) {
            createProgressDialogFragment.show(this.b.getSupportFragmentManager(), "progress_dialog");
        }
    }
}
