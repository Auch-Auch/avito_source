package a2.q.a.d.a.d.a;

import android.content.DialogInterface;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataSelectionFieldView;
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ SNSApplicantDataSelectionFieldView a;

    public c(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
        this.a = sNSApplicantDataSelectionFieldView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView = this.a;
        sNSApplicantDataSelectionFieldView.setValue(sNSApplicantDataSelectionFieldView.getItems()[i]);
    }
}
