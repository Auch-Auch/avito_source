package com.sumsub.sns.presentation.screen.error.common;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSCommonErrorFragment_ViewBinding implements Unbinder {
    public SNSCommonErrorFragment a;

    @UiThread
    public SNSCommonErrorFragment_ViewBinding(SNSCommonErrorFragment sNSCommonErrorFragment, View view) {
        this.a = sNSCommonErrorFragment;
        sNSCommonErrorFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSCommonErrorFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSCommonErrorFragment.btnGoBack = (Button) Utils.findRequiredViewAsType(view, R.id.btn_go_back, "field 'btnGoBack'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSCommonErrorFragment sNSCommonErrorFragment = this.a;
        if (sNSCommonErrorFragment != null) {
            this.a = null;
            sNSCommonErrorFragment.tvTitle = null;
            sNSCommonErrorFragment.tvSubtitle = null;
            sNSCommonErrorFragment.btnGoBack = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
