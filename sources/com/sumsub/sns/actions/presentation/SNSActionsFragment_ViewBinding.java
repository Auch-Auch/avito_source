package com.sumsub.sns.actions.presentation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.sumsub.sns.actions.R;
public final class SNSActionsFragment_ViewBinding implements Unbinder {
    public SNSActionsFragment a;

    @UiThread
    public SNSActionsFragment_ViewBinding(SNSActionsFragment sNSActionsFragment, View view) {
        this.a = sNSActionsFragment;
        sNSActionsFragment.vgError = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_error, "field 'vgError'", ViewGroup.class);
        sNSActionsFragment.tvErrorTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_error_title, "field 'tvErrorTitle'", TextView.class);
        sNSActionsFragment.tvErrorSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_error_subtitle, "field 'tvErrorSubtitle'", TextView.class);
        sNSActionsFragment.btnTryAgain = (MaterialButton) Utils.findRequiredViewAsType(view, R.id.btn_try_again, "field 'btnTryAgain'", MaterialButton.class);
        sNSActionsFragment.vgResult = Utils.findRequiredView(view, R.id.vg_result, "field 'vgResult'");
        sNSActionsFragment.ivResultIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_result_icon, "field 'ivResultIcon'", ImageView.class);
        sNSActionsFragment.tvResultMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_result_message, "field 'tvResultMessage'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSActionsFragment sNSActionsFragment = this.a;
        if (sNSActionsFragment != null) {
            this.a = null;
            sNSActionsFragment.vgError = null;
            sNSActionsFragment.tvErrorTitle = null;
            sNSActionsFragment.tvErrorSubtitle = null;
            sNSActionsFragment.btnTryAgain = null;
            sNSActionsFragment.vgResult = null;
            sNSActionsFragment.ivResultIcon = null;
            sNSActionsFragment.tvResultMessage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
