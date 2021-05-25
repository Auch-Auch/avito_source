package com.sumsub.sns.presentation.screen.preview.selfie;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.exoplayer2.ui.PlayerView;
import com.sumsub.sns.R;
public final class SNSPreviewSelfieFragment_ViewBinding implements Unbinder {
    public SNSPreviewSelfieFragment a;

    @UiThread
    public SNSPreviewSelfieFragment_ViewBinding(SNSPreviewSelfieFragment sNSPreviewSelfieFragment, View view) {
        this.a = sNSPreviewSelfieFragment;
        sNSPreviewSelfieFragment.gContent = (Group) Utils.findRequiredViewAsType(view, R.id.g_content, "field 'gContent'", Group.class);
        sNSPreviewSelfieFragment.playerView = (PlayerView) Utils.findRequiredViewAsType(view, R.id.player_view, "field 'playerView'", PlayerView.class);
        sNSPreviewSelfieFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSPreviewSelfieFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSPreviewSelfieFragment.btnReadableVideo = (Button) Utils.findRequiredViewAsType(view, R.id.btn_readable_video, "field 'btnReadableVideo'", Button.class);
        sNSPreviewSelfieFragment.btnTakeAnotherVideo = (Button) Utils.findRequiredViewAsType(view, R.id.btn_take_another_video, "field 'btnTakeAnotherVideo'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSPreviewSelfieFragment sNSPreviewSelfieFragment = this.a;
        if (sNSPreviewSelfieFragment != null) {
            this.a = null;
            sNSPreviewSelfieFragment.gContent = null;
            sNSPreviewSelfieFragment.playerView = null;
            sNSPreviewSelfieFragment.tvTitle = null;
            sNSPreviewSelfieFragment.tvSubtitle = null;
            sNSPreviewSelfieFragment.btnReadableVideo = null;
            sNSPreviewSelfieFragment.btnTakeAnotherVideo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
