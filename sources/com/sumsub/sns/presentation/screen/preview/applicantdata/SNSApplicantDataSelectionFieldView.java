package com.sumsub.sns.presentation.screen.preview.applicantdata;

import a2.q.a.d.a.d.a.c;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sumsub.sns.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataSelectionFieldView;", "Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataFieldView;", "", "", "d", "[Ljava/lang/String;", "getItems", "()[Ljava/lang/String;", "setItems", "([Ljava/lang/String;)V", "items", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSApplicantDataSelectionFieldView extends SNSApplicantDataFieldView {
    @NotNull
    public String[] d;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ SNSApplicantDataSelectionFieldView a;

        public a(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
            this.a = sNSApplicantDataSelectionFieldView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                SNSApplicantDataSelectionFieldView.access$showDialog(this.a);
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SNSApplicantDataSelectionFieldView a;

        public b(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
            this.a = sNSApplicantDataSelectionFieldView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SNSApplicantDataSelectionFieldView.access$showDialog(this.a);
        }
    }

    @JvmOverloads
    public SNSApplicantDataSelectionFieldView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SNSApplicantDataSelectionFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SNSApplicantDataSelectionFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataSelectionFieldView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i, (i3 & 8) != 0 ? R.style.SNSApplicantFieldStyle : i2);
    }

    public static final void access$showDialog(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
        Objects.requireNonNull(sNSApplicantDataSelectionFieldView);
        new MaterialAlertDialogBuilder(sNSApplicantDataSelectionFieldView.getContext()).setItems((CharSequence[]) sNSApplicantDataSelectionFieldView.d, (DialogInterface.OnClickListener) new c(sNSApplicantDataSelectionFieldView)).create().show();
    }

    @NotNull
    public final String[] getItems() {
        return this.d;
    }

    public final void setItems(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.d = strArr;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSApplicantDataSelectionFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = new String[0];
        EditText editText = getInputLayout().getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(new a(this));
        }
        EditText editText2 = getInputLayout().getEditText();
        if (editText2 != null) {
            editText2.setOnClickListener(new b(this));
        }
    }
}
