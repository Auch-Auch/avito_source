package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
@TargetApi(11)
public class VKShareDialogNative extends DialogFragment implements VKShareDialogDelegate.DialogFragmentI {
    public VKShareDialogDelegate a;

    public VKShareDialogNative() {
        this.a = new VKShareDialogDelegate(this);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = this.a.j;
        if (vKShareDialogListener != null) {
            vKShareDialogListener.onVkShareCancel();
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return this.a.e(bundle);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.f(bundle);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onStart() {
        super.onStart();
        this.a.g();
    }

    @SuppressLint({"ValidFragment"})
    public VKShareDialogNative(VKShareDialogBuilder vKShareDialogBuilder) {
        String str;
        VKShareDialogDelegate vKShareDialogDelegate = new VKShareDialogDelegate(this);
        this.a = vKShareDialogDelegate;
        vKShareDialogDelegate.g = vKShareDialogBuilder.c;
        vKShareDialogDelegate.i = vKShareDialogBuilder.e;
        String str2 = vKShareDialogBuilder.a;
        if (!(str2 == null || (str = vKShareDialogBuilder.b) == null)) {
            vKShareDialogDelegate.f = new VKShareDialogDelegate.b(str2, str);
        }
        vKShareDialogDelegate.h = vKShareDialogBuilder.d;
        vKShareDialogDelegate.j = vKShareDialogBuilder.f;
    }
}
