package com.sumsub.sns.presentation.screen.documents.submitting;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSSubmittingDocumentsFragment_ViewBinding implements Unbinder {
    public SNSSubmittingDocumentsFragment a;

    @UiThread
    public SNSSubmittingDocumentsFragment_ViewBinding(SNSSubmittingDocumentsFragment sNSSubmittingDocumentsFragment, View view) {
        this.a = sNSSubmittingDocumentsFragment;
        sNSSubmittingDocumentsFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSSubmittingDocumentsFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSSubmittingDocumentsFragment.tvFooter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_footer, "field 'tvFooter'", TextView.class);
        sNSSubmittingDocumentsFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
        sNSSubmittingDocumentsFragment.btnContinue = (Button) Utils.findRequiredViewAsType(view, R.id.btn_continue, "field 'btnContinue'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSSubmittingDocumentsFragment sNSSubmittingDocumentsFragment = this.a;
        if (sNSSubmittingDocumentsFragment != null) {
            this.a = null;
            sNSSubmittingDocumentsFragment.tvTitle = null;
            sNSSubmittingDocumentsFragment.tvSubtitle = null;
            sNSSubmittingDocumentsFragment.tvFooter = null;
            sNSSubmittingDocumentsFragment.rvList = null;
            sNSSubmittingDocumentsFragment.btnContinue = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
