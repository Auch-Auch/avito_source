package com.sumsub.sns.camera.video.presentation;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.otaliastudios.cameraview.CameraView;
import com.sumsub.sns.camera.video.R;
import pl.droidsonroids.gif.GifImageView;
public final class SNSVideoSelfieActivity_ViewBinding implements Unbinder {
    public SNSVideoSelfieActivity a;

    @UiThread
    public SNSVideoSelfieActivity_ViewBinding(SNSVideoSelfieActivity sNSVideoSelfieActivity) {
        this(sNSVideoSelfieActivity, sNSVideoSelfieActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSVideoSelfieActivity sNSVideoSelfieActivity = this.a;
        if (sNSVideoSelfieActivity != null) {
            this.a = null;
            sNSVideoSelfieActivity.toolbar = null;
            sNSVideoSelfieActivity.cameraView = null;
            sNSVideoSelfieActivity.gifView = null;
            sNSVideoSelfieActivity.tvText = null;
            sNSVideoSelfieActivity.tvDescription1 = null;
            sNSVideoSelfieActivity.tvDescription2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public SNSVideoSelfieActivity_ViewBinding(SNSVideoSelfieActivity sNSVideoSelfieActivity, View view) {
        this.a = sNSVideoSelfieActivity;
        sNSVideoSelfieActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        sNSVideoSelfieActivity.cameraView = (CameraView) Utils.findRequiredViewAsType(view, R.id.camera_view, "field 'cameraView'", CameraView.class);
        sNSVideoSelfieActivity.gifView = (GifImageView) Utils.findRequiredViewAsType(view, R.id.video_gif, "field 'gifView'", GifImageView.class);
        sNSVideoSelfieActivity.tvText = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tvText'", TextView.class);
        sNSVideoSelfieActivity.tvDescription1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description_1, "field 'tvDescription1'", TextView.class);
        sNSVideoSelfieActivity.tvDescription2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description_2, "field 'tvDescription2'", TextView.class);
    }
}
