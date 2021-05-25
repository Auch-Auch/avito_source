package com.avito.android.util;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ListAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.ui_components.R;
@Deprecated
public final class DialogUtils {
    public static void dismissDialog(@Nullable Dialog dialog) {
        if (isShowing(dialog)) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static boolean isShowing(@Nullable Dialog dialog) {
        return dialog != null && dialog.isShowing();
    }

    @NonNull
    public static Dialog showCancelableNotifyingDialog(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        return new AlertDialog.Builder(context).setMessage(str).setNegativeButton(str2, new DialogInterface.OnClickListener(onClickListener) { // from class: a2.a.a.n3.c
            public final /* synthetic */ DialogInterface.OnClickListener a;

            {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface.OnClickListener onClickListener3 = this.a;
                LastClick.Updater.update();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i);
                }
            }
        }).setPositiveButton(str3, new DialogInterface.OnClickListener(onClickListener2) { // from class: a2.a.a.n3.d
            public final /* synthetic */ DialogInterface.OnClickListener a;

            {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface.OnClickListener onClickListener3 = this.a;
                LastClick.Updater.update();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i);
                }
            }
        }).setCancelable(false).show();
    }

    @NonNull
    public static Dialog showMultiChoiceDialog(@NonNull Context context, @NonNull CharSequence[] charSequenceArr, @NonNull boolean[] zArr, @NonNull DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, @NonNull DialogInterface.OnClickListener onClickListener, @NonNull DialogInterface.OnClickListener onClickListener2) {
        return new AlertDialog.Builder(context).setCancelable(true).setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener).setPositiveButton(R.string.button_ready, new DialogInterface.OnClickListener(onClickListener) { // from class: a2.a.a.n3.e
            public final /* synthetic */ DialogInterface.OnClickListener a;

            {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface.OnClickListener onClickListener3 = this.a;
                LastClick.Updater.update();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i);
                }
            }
        }).setNegativeButton(R.string.button_dismiss, new DialogInterface.OnClickListener(onClickListener2) { // from class: a2.a.a.n3.b
            public final /* synthetic */ DialogInterface.OnClickListener a;

            {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface.OnClickListener onClickListener3 = this.a;
                LastClick.Updater.update();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i);
                }
            }
        }).show();
    }

    @NonNull
    public static Dialog showSimpleWaitingDialog(Context context) {
        return ProgressDialog.show(context, null, context.getString(R.string.wait), true, true);
    }

    @NonNull
    public static Dialog showSimpleWaitingDialogWithMessage(Context context, @StringRes int i) {
        return ProgressDialog.show(context, null, context.getString(i), true, true);
    }

    @NonNull
    public static Dialog showSingleChoiceDialog(Context context, ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return new AlertDialog.Builder(context).setCancelable(true).setSingleChoiceItems(listAdapter, i, new DialogInterface.OnClickListener(onClickListener) { // from class: a2.a.a.n3.a
            public final /* synthetic */ DialogInterface.OnClickListener a;

            {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DialogInterface.OnClickListener onClickListener2 = this.a;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i2);
                }
                LastClick.Updater.update();
                dialogInterface.dismiss();
            }
        }).show();
    }

    public static boolean isShowing(@Nullable Toast toast) {
        return toast != null && toast.getView().isShown();
    }
}
