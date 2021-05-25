package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
public class VKShareDialog extends DialogFragment implements VKShareDialogDelegate.DialogFragmentI {
    public VKShareDialogDelegate a;

    public interface VKShareDialogListener extends VKShareDialogBuilder.VKShareDialogListener {
    }

    @Deprecated
    public VKShareDialog() {
        this.a = new VKShareDialogDelegate(this);
    }

    @Override // androidx.fragment.app.Fragment, com.vk.sdk.dialogs.VKShareDialogDelegate.DialogFragmentI
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = this.a.j;
        if (vKShareDialogListener != null) {
            vKShareDialogListener.onVkShareCancel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return this.a.e(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.f(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @SuppressLint({"NewApi"})
    public void onStart() {
        super.onStart();
        this.a.g();
    }

    public VKShareDialog setAttachmentImages(VKUploadImage[] vKUploadImageArr) {
        this.a.g = vKUploadImageArr;
        return this;
    }

    public VKShareDialog setAttachmentLink(String str, String str2) {
        this.a.f = new VKShareDialogDelegate.b(str, str2);
        return this;
    }

    public VKShareDialog setShareDialogListener(VKShareDialogListener vKShareDialogListener) {
        this.a.j = vKShareDialogListener;
        return this;
    }

    public VKShareDialog setText(CharSequence charSequence) {
        this.a.i = charSequence;
        return this;
    }

    public VKShareDialog setUploadedPhotos(VKPhotoArray vKPhotoArray) {
        this.a.h = vKPhotoArray;
        return this;
    }

    @SuppressLint({"ValidFragment"})
    public VKShareDialog(VKShareDialogBuilder vKShareDialogBuilder) {
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
