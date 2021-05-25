package com.sumsub.sns.camera.photo.presentation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.otaliastudios.cameraview.CameraView;
import com.sumsub.sns.camera.photo.R;
public final class SNSPhotoDocumentPickerActivity_ViewBinding implements Unbinder {
    public SNSPhotoDocumentPickerActivity a;

    @UiThread
    public SNSPhotoDocumentPickerActivity_ViewBinding(SNSPhotoDocumentPickerActivity sNSPhotoDocumentPickerActivity) {
        this(sNSPhotoDocumentPickerActivity, sNSPhotoDocumentPickerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSPhotoDocumentPickerActivity sNSPhotoDocumentPickerActivity = this.a;
        if (sNSPhotoDocumentPickerActivity != null) {
            this.a = null;
            sNSPhotoDocumentPickerActivity.vgRoot = null;
            sNSPhotoDocumentPickerActivity.vgToolbar = null;
            sNSPhotoDocumentPickerActivity.vgHelper = null;
            sNSPhotoDocumentPickerActivity.pbProgress = null;
            sNSPhotoDocumentPickerActivity.cvCamera = null;
            sNSPhotoDocumentPickerActivity.vgFrameLayout = null;
            sNSPhotoDocumentPickerActivity.ivFrameImage = null;
            sNSPhotoDocumentPickerActivity.btnTakePicture = null;
            sNSPhotoDocumentPickerActivity.btnTakeGallery = null;
            sNSPhotoDocumentPickerActivity.btnClose = null;
            sNSPhotoDocumentPickerActivity.btnTorchToggle = null;
            sNSPhotoDocumentPickerActivity.tvHelperTitle = null;
            sNSPhotoDocumentPickerActivity.vgHelperDetailsFrame = null;
            sNSPhotoDocumentPickerActivity.tvHelperBrief = null;
            sNSPhotoDocumentPickerActivity.tvHelperDetails = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public SNSPhotoDocumentPickerActivity_ViewBinding(SNSPhotoDocumentPickerActivity sNSPhotoDocumentPickerActivity, View view) {
        this.a = sNSPhotoDocumentPickerActivity;
        sNSPhotoDocumentPickerActivity.vgRoot = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_root, "field 'vgRoot'", ViewGroup.class);
        sNSPhotoDocumentPickerActivity.vgToolbar = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_toolbar, "field 'vgToolbar'", ViewGroup.class);
        sNSPhotoDocumentPickerActivity.vgHelper = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_helper, "field 'vgHelper'", ViewGroup.class);
        sNSPhotoDocumentPickerActivity.pbProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'pbProgress'", ProgressBar.class);
        sNSPhotoDocumentPickerActivity.cvCamera = (CameraView) Utils.findRequiredViewAsType(view, R.id.camera_view, "field 'cvCamera'", CameraView.class);
        sNSPhotoDocumentPickerActivity.vgFrameLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_frame_layout, "field 'vgFrameLayout'", ViewGroup.class);
        sNSPhotoDocumentPickerActivity.ivFrameImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_frame_image, "field 'ivFrameImage'", ImageView.class);
        sNSPhotoDocumentPickerActivity.btnTakePicture = Utils.findRequiredView(view, R.id.btn_take_photo, "field 'btnTakePicture'");
        sNSPhotoDocumentPickerActivity.btnTakeGallery = Utils.findRequiredView(view, R.id.btn_take_gallery, "field 'btnTakeGallery'");
        sNSPhotoDocumentPickerActivity.btnClose = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btnClose'", ImageButton.class);
        sNSPhotoDocumentPickerActivity.btnTorchToggle = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_torch_toggle, "field 'btnTorchToggle'", ImageButton.class);
        sNSPhotoDocumentPickerActivity.tvHelperTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_title, "field 'tvHelperTitle'", TextView.class);
        sNSPhotoDocumentPickerActivity.vgHelperDetailsFrame = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_helper_details_frame, "field 'vgHelperDetailsFrame'", ViewGroup.class);
        sNSPhotoDocumentPickerActivity.tvHelperBrief = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_brief, "field 'tvHelperBrief'", TextView.class);
        sNSPhotoDocumentPickerActivity.tvHelperDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_details, "field 'tvHelperDetails'", TextView.class);
    }
}
