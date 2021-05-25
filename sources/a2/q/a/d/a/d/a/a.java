package a2.q.a.d.a.d.a;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataCalendarFieldView;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;
public final class a<S> implements MaterialPickerOnPositiveButtonClickListener<Long> {
    public final /* synthetic */ SNSApplicantDataCalendarFieldView a;

    public a(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
        this.a = sNSApplicantDataCalendarFieldView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
    public void onPositiveButtonClick(Long l) {
        SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView = this.a;
        String format = SimpleDateFormat.getDateInstance().format(l);
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat.getDateInstance().format(it)");
        sNSApplicantDataCalendarFieldView.setValue(format);
    }
}
