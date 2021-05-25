package com.sumsub.sns.prooface.presentation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.otaliastudios.cameraview.CameraView;
import com.sumsub.idensic_mobile_sdk_liveness_3dface.R;
import com.sumsub.sns.prooface.presentation.view.SNSLivenessFaceView;
public final class SNSLiveness3dFaceActivity_ViewBinding implements Unbinder {
    public SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

    @UiThread
    public SNSLiveness3dFaceActivity_ViewBinding(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity, View view) {
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        sNSLiveness3dFaceActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        sNSLiveness3dFaceActivity.cameraView = (CameraView) Utils.findRequiredViewAsType(view, R.id.cameraView, "field 'cameraView'", CameraView.class);
        sNSLiveness3dFaceActivity.vgResult = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vgResult, "field 'vgResult'", ViewGroup.class);
        sNSLiveness3dFaceActivity.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        sNSLiveness3dFaceActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSLiveness3dFaceActivity.tvSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubTitle'", TextView.class);
        sNSLiveness3dFaceActivity.btnTryAgain = (Button) Utils.findRequiredViewAsType(view, R.id.btn_try_again, "field 'btnTryAgain'", Button.class);
        sNSLiveness3dFaceActivity.faceView = (SNSLivenessFaceView) Utils.findRequiredViewAsType(view, R.id.faceView, "field 'faceView'", SNSLivenessFaceView.class);
        sNSLiveness3dFaceActivity.tvHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_hint, "field 'tvHint'", TextView.class);
        sNSLiveness3dFaceActivity.tvPowered = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_powered, "field 'tvPowered'", TextView.class);
        sNSLiveness3dFaceActivity.tvDebug = (TextView) Utils.findRequiredViewAsType(view, R.id.debugInfo, "field 'tvDebug'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
        if (sNSLiveness3dFaceActivity != null) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = null;
            sNSLiveness3dFaceActivity.toolbar = null;
            sNSLiveness3dFaceActivity.cameraView = null;
            sNSLiveness3dFaceActivity.vgResult = null;
            sNSLiveness3dFaceActivity.ivIcon = null;
            sNSLiveness3dFaceActivity.tvTitle = null;
            sNSLiveness3dFaceActivity.tvSubTitle = null;
            sNSLiveness3dFaceActivity.btnTryAgain = null;
            sNSLiveness3dFaceActivity.faceView = null;
            sNSLiveness3dFaceActivity.tvHint = null;
            sNSLiveness3dFaceActivity.tvPowered = null;
            sNSLiveness3dFaceActivity.tvDebug = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
