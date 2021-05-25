package com.sumsub.camera.selfie.with.document.presentation;

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
import com.sumsub.camera.selfie.with.document.R;
public final class SNSSelfieWithDocumentPickerActivity_ViewBinding implements Unbinder {
    public SNSSelfieWithDocumentPickerActivity a;

    @UiThread
    public SNSSelfieWithDocumentPickerActivity_ViewBinding(SNSSelfieWithDocumentPickerActivity sNSSelfieWithDocumentPickerActivity) {
        this(sNSSelfieWithDocumentPickerActivity, sNSSelfieWithDocumentPickerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSSelfieWithDocumentPickerActivity sNSSelfieWithDocumentPickerActivity = this.a;
        if (sNSSelfieWithDocumentPickerActivity != null) {
            this.a = null;
            sNSSelfieWithDocumentPickerActivity.vgRoot = null;
            sNSSelfieWithDocumentPickerActivity.vgToolbar = null;
            sNSSelfieWithDocumentPickerActivity.vgHelper = null;
            sNSSelfieWithDocumentPickerActivity.pbProgress = null;
            sNSSelfieWithDocumentPickerActivity.cvCamera = null;
            sNSSelfieWithDocumentPickerActivity.vgFrameLayout = null;
            sNSSelfieWithDocumentPickerActivity.ivFrameImage = null;
            sNSSelfieWithDocumentPickerActivity.btnTakePicture = null;
            sNSSelfieWithDocumentPickerActivity.btnTakeGallery = null;
            sNSSelfieWithDocumentPickerActivity.btnClose = null;
            sNSSelfieWithDocumentPickerActivity.btnTorchToggle = null;
            sNSSelfieWithDocumentPickerActivity.tvHelperTitle = null;
            sNSSelfieWithDocumentPickerActivity.vgHelperDetailsFrame = null;
            sNSSelfieWithDocumentPickerActivity.tvHelperBrief = null;
            sNSSelfieWithDocumentPickerActivity.tvHelperDetails = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public SNSSelfieWithDocumentPickerActivity_ViewBinding(SNSSelfieWithDocumentPickerActivity sNSSelfieWithDocumentPickerActivity, View view) {
        this.a = sNSSelfieWithDocumentPickerActivity;
        sNSSelfieWithDocumentPickerActivity.vgRoot = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_root, "field 'vgRoot'", ViewGroup.class);
        sNSSelfieWithDocumentPickerActivity.vgToolbar = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_toolbar, "field 'vgToolbar'", ViewGroup.class);
        sNSSelfieWithDocumentPickerActivity.vgHelper = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_helper, "field 'vgHelper'", ViewGroup.class);
        sNSSelfieWithDocumentPickerActivity.pbProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'pbProgress'", ProgressBar.class);
        sNSSelfieWithDocumentPickerActivity.cvCamera = (CameraView) Utils.findRequiredViewAsType(view, R.id.camera_view, "field 'cvCamera'", CameraView.class);
        sNSSelfieWithDocumentPickerActivity.vgFrameLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_frame_layout, "field 'vgFrameLayout'", ViewGroup.class);
        sNSSelfieWithDocumentPickerActivity.ivFrameImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_frame_image, "field 'ivFrameImage'", ImageView.class);
        sNSSelfieWithDocumentPickerActivity.btnTakePicture = Utils.findRequiredView(view, R.id.btn_take_photo, "field 'btnTakePicture'");
        sNSSelfieWithDocumentPickerActivity.btnTakeGallery = Utils.findRequiredView(view, R.id.btn_take_gallery, "field 'btnTakeGallery'");
        sNSSelfieWithDocumentPickerActivity.btnClose = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btnClose'", ImageButton.class);
        sNSSelfieWithDocumentPickerActivity.btnTorchToggle = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_torch_toggle, "field 'btnTorchToggle'", ImageButton.class);
        sNSSelfieWithDocumentPickerActivity.tvHelperTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_title, "field 'tvHelperTitle'", TextView.class);
        sNSSelfieWithDocumentPickerActivity.vgHelperDetailsFrame = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_helper_details_frame, "field 'vgHelperDetailsFrame'", ViewGroup.class);
        sNSSelfieWithDocumentPickerActivity.tvHelperBrief = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_brief, "field 'tvHelperBrief'", TextView.class);
        sNSSelfieWithDocumentPickerActivity.tvHelperDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_helper_details, "field 'tvHelperDetails'", TextView.class);
    }
}
