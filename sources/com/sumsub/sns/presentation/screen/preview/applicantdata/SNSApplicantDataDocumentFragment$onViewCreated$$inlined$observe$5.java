package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/sumsub/sns/core/common/ExtensionsKt$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5<T> implements Observer<T> {
    public final /* synthetic */ SNSApplicantDataDocumentFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5 a;

        public a(int i, int i2, SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5 sNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5) {
            this.a = sNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SNSApplicantDataDocumentFragment.access$submitValues(this.a.a);
        }
    }

    public SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
        this.a = sNSApplicantDataDocumentFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        EditText editText;
        if (t != null) {
            T t2 = t;
            this.a.getVgContent().removeAllViews();
            int size = t2.size() - 1;
            int i = 0;
            for (T t3 : t2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t4 = t3;
                ViewGroup vgContent = this.a.getVgContent();
                SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment = this.a;
                ApplicantDataField field = t4.getField();
                Context requireContext = this.a.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                SNSApplicantDataFieldView access$asView = SNSApplicantDataDocumentFragment.access$asView(sNSApplicantDataDocumentFragment, field, requireContext, t4.getValue());
                if (i == 0 && (editText = access$asView.getEditText()) != null) {
                    editText.requestFocus();
                }
                if (i == size) {
                    EditText editText2 = access$asView.getEditText();
                    if (editText2 != null) {
                        editText2.setImeOptions(6);
                    }
                    access$asView.setOnSubmitForm(new a(i, size, this));
                }
                Unit unit = Unit.INSTANCE;
                vgContent.addView(access$asView);
                i = i2;
            }
            FragmentActivity requireActivity = this.a.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            View currentFocus = requireActivity.getCurrentFocus();
            if (currentFocus != null) {
                ExtensionsKt.showKeyboard(currentFocus);
            }
        }
    }
}
