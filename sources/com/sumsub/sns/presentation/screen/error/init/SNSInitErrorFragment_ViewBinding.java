package com.sumsub.sns.presentation.screen.error.init;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSInitErrorFragment_ViewBinding implements Unbinder {
    public SNSInitErrorFragment a;

    @UiThread
    public SNSInitErrorFragment_ViewBinding(SNSInitErrorFragment sNSInitErrorFragment, View view) {
        this.a = sNSInitErrorFragment;
        sNSInitErrorFragment.btnRefresh = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_refresh, "field 'btnRefresh'", ImageButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSInitErrorFragment sNSInitErrorFragment = this.a;
        if (sNSInitErrorFragment != null) {
            this.a = null;
            sNSInitErrorFragment.btnRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
