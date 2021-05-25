package com.avito.android.dialog.advert_details;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/dialog/advert_details/IncompleteRegisterDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/dialog/advert_details/IncompleteRegisterRouter;", "router", "attachRouter", "(Lcom/avito/android/dialog/advert_details/IncompleteRegisterRouter;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/dialog/advert_details/IncompleteRegisterRouter;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class IncompleteRegisterDialog extends DialogFragment {
    public IncompleteRegisterRouter a;

    /* compiled from: java-style lambda group */
    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = this.a;
            if (i2 == 0) {
                LastClick.Updater.update();
                IncompleteRegisterRouter incompleteRegisterRouter = ((IncompleteRegisterDialog) this.b).a;
                if (incompleteRegisterRouter != null) {
                    incompleteRegisterRouter.onCancel();
                }
                IncompleteRegisterDialog.access$detach((IncompleteRegisterDialog) this.b);
            } else if (i2 == 1) {
                LastClick.Updater.update();
                IncompleteRegisterRouter incompleteRegisterRouter2 = ((IncompleteRegisterDialog) this.b).a;
                if (incompleteRegisterRouter2 != null) {
                    incompleteRegisterRouter2.onContinueSelected();
                }
                IncompleteRegisterDialog.access$detach((IncompleteRegisterDialog) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final void access$detach(IncompleteRegisterDialog incompleteRegisterDialog) {
        incompleteRegisterDialog.a = null;
    }

    public final void attachRouter(@NotNull IncompleteRegisterRouter incompleteRegisterRouter) {
        Intrinsics.checkNotNullParameter(incompleteRegisterRouter, "router");
        this.a = incompleteRegisterRouter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        LastClick.Updater.update();
        IncompleteRegisterRouter incompleteRegisterRouter = this.a;
        if (incompleteRegisterRouter != null) {
            incompleteRegisterRouter.onCancel();
        }
        this.a = null;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(requireContext()).setMessage(R.string.advert_incomplete_register_message).setNegativeButton(R.string.dismiss, new a(0, this)).setPositiveButton(R.string.continue_string, new a(1, this)).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…      }\n        .create()");
        return create;
    }
}
