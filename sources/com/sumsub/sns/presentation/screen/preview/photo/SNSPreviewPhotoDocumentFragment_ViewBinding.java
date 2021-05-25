package com.sumsub.sns.presentation.screen.preview.photo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSRotationImageView;
public class SNSPreviewPhotoDocumentFragment_ViewBinding implements Unbinder {
    public SNSPreviewPhotoDocumentFragment a;

    @UiThread
    public SNSPreviewPhotoDocumentFragment_ViewBinding(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment, View view) {
        this.a = sNSPreviewPhotoDocumentFragment;
        sNSPreviewPhotoDocumentFragment.gContent = (Group) Utils.findRequiredViewAsType(view, R.id.g_content, "field 'gContent'", Group.class);
        sNSPreviewPhotoDocumentFragment.ivPhoto = (SNSRotationImageView) Utils.findRequiredViewAsType(view, R.id.iv_photo, "field 'ivPhoto'", SNSRotationImageView.class);
        sNSPreviewPhotoDocumentFragment.btnReadableDocument = (Button) Utils.findRequiredViewAsType(view, R.id.btn_readable_document, "field 'btnReadableDocument'", Button.class);
        sNSPreviewPhotoDocumentFragment.btnTakeAnotherPhoto = (Button) Utils.findRequiredViewAsType(view, R.id.btn_take_another_photo, "field 'btnTakeAnotherPhoto'", Button.class);
        sNSPreviewPhotoDocumentFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSPreviewPhotoDocumentFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment = this.a;
        if (sNSPreviewPhotoDocumentFragment != null) {
            this.a = null;
            sNSPreviewPhotoDocumentFragment.gContent = null;
            sNSPreviewPhotoDocumentFragment.ivPhoto = null;
            sNSPreviewPhotoDocumentFragment.btnReadableDocument = null;
            sNSPreviewPhotoDocumentFragment.btnTakeAnotherPhoto = null;
            sNSPreviewPhotoDocumentFragment.tvTitle = null;
            sNSPreviewPhotoDocumentFragment.tvSubtitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
