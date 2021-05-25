package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumsub.sns.R;
public final class SNSApplicantDataDocumentFragment_ViewBinding implements Unbinder {
    public SNSApplicantDataDocumentFragment a;

    @UiThread
    public SNSApplicantDataDocumentFragment_ViewBinding(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment, View view) {
        this.a = sNSApplicantDataDocumentFragment;
        sNSApplicantDataDocumentFragment.btnContinue = (Button) Utils.findRequiredViewAsType(view, R.id.btn_continue, "field 'btnContinue'", Button.class);
        sNSApplicantDataDocumentFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sNSApplicantDataDocumentFragment.tvSubtitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'tvSubtitle'", TextView.class);
        sNSApplicantDataDocumentFragment.vgContent = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.vg_content, "field 'vgContent'", ViewGroup.class);
        sNSApplicantDataDocumentFragment.btnPrev = (Button) Utils.findRequiredViewAsType(view, R.id.btn_prev, "field 'btnPrev'", Button.class);
        sNSApplicantDataDocumentFragment.btnNext = (Button) Utils.findRequiredViewAsType(view, R.id.btn_next, "field 'btnNext'", Button.class);
        sNSApplicantDataDocumentFragment.btnDone = (Button) Utils.findRequiredViewAsType(view, R.id.btn_done, "field 'btnDone'", Button.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment = this.a;
        if (sNSApplicantDataDocumentFragment != null) {
            this.a = null;
            sNSApplicantDataDocumentFragment.btnContinue = null;
            sNSApplicantDataDocumentFragment.tvTitle = null;
            sNSApplicantDataDocumentFragment.tvSubtitle = null;
            sNSApplicantDataDocumentFragment.vgContent = null;
            sNSApplicantDataDocumentFragment.btnPrev = null;
            sNSApplicantDataDocumentFragment.btnNext = null;
            sNSApplicantDataDocumentFragment.btnDone = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
