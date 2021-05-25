package a2.q.a.d.a.d.a;

import android.view.View;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataFieldView;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<View, SNSApplicantDataDocumentViewModel.ApplicantData> {
    public final /* synthetic */ SNSApplicantDataDocumentFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
        super(1);
        this.a = sNSApplicantDataDocumentFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SNSApplicantDataDocumentViewModel.ApplicantData invoke(View view) {
        String str;
        String str2;
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "it");
        SNSApplicantDataFieldView sNSApplicantDataFieldView = (SNSApplicantDataFieldView) view2;
        Object tag = sNSApplicantDataFieldView.getTag();
        Object obj = null;
        if (tag instanceof ApplicantDataField.Field) {
            int ordinal = ((ApplicantDataField.Field) tag).getName().ordinal();
            if (ordinal != 5) {
                switch (ordinal) {
                    case 10:
                        Iterator it = this.a.c.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                if (Intrinsics.areEqual((String) ((Map.Entry) next).getValue(), sNSApplicantDataFieldView.getValue())) {
                                    obj = next;
                                }
                            }
                        }
                        Map.Entry entry = (Map.Entry) obj;
                        if (entry == null || (str2 = (String) entry.getKey()) == null) {
                            return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, "");
                        }
                        return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, str2);
                    case 11:
                    case 12:
                        break;
                    default:
                        return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, sNSApplicantDataFieldView.getValue());
                }
            }
            Iterator it2 = this.a.d.entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (Intrinsics.areEqual((String) ((Map.Entry) next2).getValue(), sNSApplicantDataFieldView.getValue())) {
                        obj = next2;
                    }
                }
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 == null || (str = (String) entry2.getKey()) == null) {
                return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, "");
            }
            return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, str);
        } else if (tag instanceof ApplicantDataField.CustomField) {
            return new SNSApplicantDataDocumentViewModel.ApplicantData((ApplicantDataField) tag, sNSApplicantDataFieldView.getValue());
        } else {
            return null;
        }
    }
}
