package com.sumsub.sns.presentation.screen.documents.require;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSRequireDocumentsFragment_ViewBinding implements Unbinder {
    public SNSRequireDocumentsFragment a;

    @UiThread
    public SNSRequireDocumentsFragment_ViewBinding(SNSRequireDocumentsFragment sNSRequireDocumentsFragment, View view) {
        this.a = sNSRequireDocumentsFragment;
        sNSRequireDocumentsFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSRequireDocumentsFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSRequireDocumentsFragment.tvFooter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_footer, "field 'tvFooter'", TextView.class);
        sNSRequireDocumentsFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_required_docs, "field 'rvList'", RecyclerView.class);
        sNSRequireDocumentsFragment.btnContinue = (Button) Utils.findRequiredViewAsType(view, R.id.btn_continue, "field 'btnContinue'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSRequireDocumentsFragment sNSRequireDocumentsFragment = this.a;
        if (sNSRequireDocumentsFragment != null) {
            this.a = null;
            sNSRequireDocumentsFragment.tvTitle = null;
            sNSRequireDocumentsFragment.tvSubtitle = null;
            sNSRequireDocumentsFragment.tvFooter = null;
            sNSRequireDocumentsFragment.rvList = null;
            sNSRequireDocumentsFragment.btnContinue = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
