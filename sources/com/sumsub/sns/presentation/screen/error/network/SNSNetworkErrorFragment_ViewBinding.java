package com.sumsub.sns.presentation.screen.error.network;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSNetworkErrorFragment_ViewBinding implements Unbinder {
    public SNSNetworkErrorFragment a;

    @UiThread
    public SNSNetworkErrorFragment_ViewBinding(SNSNetworkErrorFragment sNSNetworkErrorFragment, View view) {
        this.a = sNSNetworkErrorFragment;
        sNSNetworkErrorFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSNetworkErrorFragment.tvSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubTitle'", TextView.class);
        sNSNetworkErrorFragment.btnTryAgain = (Button) Utils.findRequiredViewAsType(view, R.id.btn_try_again, "field 'btnTryAgain'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSNetworkErrorFragment sNSNetworkErrorFragment = this.a;
        if (sNSNetworkErrorFragment != null) {
            this.a = null;
            sNSNetworkErrorFragment.tvTitle = null;
            sNSNetworkErrorFragment.tvSubTitle = null;
            sNSNetworkErrorFragment.btnTryAgain = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
