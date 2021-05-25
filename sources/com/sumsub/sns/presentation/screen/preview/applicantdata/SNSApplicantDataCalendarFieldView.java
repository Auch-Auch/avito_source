package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.sumsub.sns.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataCalendarFieldView;", "Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataFieldView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSApplicantDataCalendarFieldView extends SNSApplicantDataFieldView {

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ SNSApplicantDataCalendarFieldView a;

        public a(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
            this.a = sNSApplicantDataCalendarFieldView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                SNSApplicantDataCalendarFieldView.access$showCalendar(this.a);
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SNSApplicantDataCalendarFieldView a;

        public b(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
            this.a = sNSApplicantDataCalendarFieldView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SNSApplicantDataCalendarFieldView.access$showCalendar(this.a);
        }
    }

    @JvmOverloads
    public SNSApplicantDataCalendarFieldView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SNSApplicantDataCalendarFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SNSApplicantDataCalendarFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataCalendarFieldView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i, (i3 & 8) != 0 ? R.style.SNSApplicantFieldStyle : i2);
    }

    public static final void access$showCalendar(SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView) {
        Objects.requireNonNull(sNSApplicantDataCalendarFieldView);
        Calendar instance = Calendar.getInstance();
        try {
            Intrinsics.checkNotNullExpressionValue(instance, "cal");
            Date parse = SimpleDateFormat.getDateInstance().parse(sNSApplicantDataCalendarFieldView.getValue());
            Intrinsics.checkNotNull(parse);
            instance.setTime(parse);
        } catch (Exception unused) {
        }
        MaterialDatePicker.Builder<Long> datePicker = MaterialDatePicker.Builder.datePicker();
        Intrinsics.checkNotNullExpressionValue(instance, "cal");
        MaterialDatePicker<Long> build = datePicker.setSelection(Long.valueOf(instance.getTimeInMillis())).build();
        build.addOnPositiveButtonClickListener(new a2.q.a.d.a.d.a.a(sNSApplicantDataCalendarFieldView));
        Context context = sNSApplicantDataCalendarFieldView.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        build.show(((FragmentActivity) context).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSApplicantDataCalendarFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
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
