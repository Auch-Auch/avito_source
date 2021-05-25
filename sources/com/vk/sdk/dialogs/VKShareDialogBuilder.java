package com.vk.sdk.dialogs;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;
public class VKShareDialogBuilder {
    public String a;
    public String b;
    public VKUploadImage[] c;
    public VKPhotoArray d;
    public CharSequence e;
    public VKShareDialogListener f;

    public interface VKShareDialogListener {
        void onVkShareCancel();

        void onVkShareComplete(int i);

        void onVkShareError(VKError vKError);
    }

    public VKShareDialogBuilder setAttachmentImages(VKUploadImage[] vKUploadImageArr) {
        this.c = vKUploadImageArr;
        return this;
    }

    public VKShareDialogBuilder setAttachmentLink(String str, String str2) {
        this.a = str;
        this.b = str2;
        return this;
    }

    public VKShareDialogBuilder setShareDialogListener(VKShareDialogListener vKShareDialogListener) {
        this.f = vKShareDialogListener;
        return this;
    }

    public VKShareDialogBuilder setText(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public VKShareDialogBuilder setUploadedPhotos(VKPhotoArray vKPhotoArray) {
        this.d = vKPhotoArray;
        return this;
    }

    @TargetApi(11)
    public void show(FragmentManager fragmentManager, String str) {
        new VKShareDialogNative(this).show(fragmentManager, str);
    }

    public void show(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        new VKShareDialog(this).show(fragmentManager, str);
    }
}
