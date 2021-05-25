package com.sumsub.sns.presentation.screen.documents.reviewing;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSReviewingDocumentsFragment_ViewBinding implements Unbinder {
    public SNSReviewingDocumentsFragment a;

    @UiThread
    public SNSReviewingDocumentsFragment_ViewBinding(SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment, View view) {
        this.a = sNSReviewingDocumentsFragment;
        sNSReviewingDocumentsFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSReviewingDocumentsFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSReviewingDocumentsFragment.tvFooter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_footer, "field 'tvFooter'", TextView.class);
        sNSReviewingDocumentsFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment = this.a;
        if (sNSReviewingDocumentsFragment != null) {
            this.a = null;
            sNSReviewingDocumentsFragment.tvTitle = null;
            sNSReviewingDocumentsFragment.tvSubtitle = null;
            sNSReviewingDocumentsFragment.tvFooter = null;
            sNSReviewingDocumentsFragment.rvList = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
