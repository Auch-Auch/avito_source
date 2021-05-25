package com.sumsub.sns.presentation.screen.documents.reviewed;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSReviewedDocumentsFragment_ViewBinding implements Unbinder {
    public SNSReviewedDocumentsFragment a;

    @UiThread
    public SNSReviewedDocumentsFragment_ViewBinding(SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment, View view) {
        this.a = sNSReviewedDocumentsFragment;
        sNSReviewedDocumentsFragment.ivResult = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_result, "field 'ivResult'", ImageView.class);
        sNSReviewedDocumentsFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
        sNSReviewedDocumentsFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSReviewedDocumentsFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSReviewedDocumentsFragment.tvFooter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_footer, "field 'tvFooter'", TextView.class);
        sNSReviewedDocumentsFragment.tvModerationComment = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_moderationComment, "field 'tvModerationComment'", TextView.class);
        sNSReviewedDocumentsFragment.svModerationComment = (ScrollView) Utils.findRequiredViewAsType(view, R.id.sv_moderationComment, "field 'svModerationComment'", ScrollView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment = this.a;
        if (sNSReviewedDocumentsFragment != null) {
            this.a = null;
            sNSReviewedDocumentsFragment.ivResult = null;
            sNSReviewedDocumentsFragment.rvList = null;
            sNSReviewedDocumentsFragment.tvTitle = null;
            sNSReviewedDocumentsFragment.tvSubtitle = null;
            sNSReviewedDocumentsFragment.tvFooter = null;
            sNSReviewedDocumentsFragment.tvModerationComment = null;
            sNSReviewedDocumentsFragment.svModerationComment = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
