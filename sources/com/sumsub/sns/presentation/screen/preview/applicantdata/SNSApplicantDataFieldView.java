package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u00100\u001a\u00020.¢\u0006\u0004\b1\u00102R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007¨\u00063"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataFieldView;", "Landroid/widget/LinearLayout;", "", "value", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "title", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "tvTitle", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText", "getHint", "setHint", "hint", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "getOnSubmitForm", "()Ljava/lang/Runnable;", "setOnSubmitForm", "(Ljava/lang/Runnable;)V", "onSubmitForm", "Lcom/google/android/material/textfield/TextInputLayout;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/textfield/TextInputLayout;", "getInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "inputLayout", "getError", "setError", "error", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public class SNSApplicantDataFieldView extends LinearLayout {
    public final TextView a;
    @NotNull
    public final TextInputLayout b;
    @Nullable
    public Runnable c;

    public static final class a implements TextView.OnEditorActionListener {
        public final /* synthetic */ SNSApplicantDataFieldView a;

        public a(SNSApplicantDataFieldView sNSApplicantDataFieldView, Context context, AttributeSet attributeSet) {
            this.a = sNSApplicantDataFieldView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            EditText editText;
            if (i == 5) {
                View focusSearch = textView.focusSearch(130);
                TextInputLayout textInputLayout = (TextInputLayout) (!(focusSearch instanceof TextInputLayout) ? null : focusSearch);
                if (!(textInputLayout == null || (editText = textInputLayout.getEditText()) == null)) {
                    focusSearch = editText;
                }
                if (focusSearch != null) {
                    return focusSearch.requestFocus();
                }
                return false;
            } else if (i != 6) {
                return false;
            } else {
                Runnable onSubmitForm = this.a.getOnSubmitForm();
                if (onSubmitForm != null) {
                    onSubmitForm.run();
                }
                return true;
            }
        }
    }

    @JvmOverloads
    public SNSApplicantDataFieldView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SNSApplicantDataFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SNSApplicantDataFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataFieldView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i, (i3 & 8) != 0 ? R.style.SNSApplicantFieldStyle : i2);
    }

    @Nullable
    public final EditText getEditText() {
        return this.b.getEditText();
    }

    @Nullable
    public final CharSequence getError() {
        return this.b.getError();
    }

    @Nullable
    public final CharSequence getHint() {
        EditText editText = this.b.getEditText();
        if (editText != null) {
            return editText.getHint();
        }
        return null;
    }

    @NotNull
    public final TextInputLayout getInputLayout() {
        return this.b;
    }

    @Nullable
    public final Runnable getOnSubmitForm() {
        return this.c;
    }

    @NotNull
    public final CharSequence getTitle() {
        CharSequence text = this.a.getText();
        Intrinsics.checkNotNullExpressionValue(text, "tvTitle.text");
        return text;
    }

    @NotNull
    public final String getValue() {
        EditText editText = this.b.getEditText();
        return String.valueOf(editText != null ? editText.getText() : null);
    }

    public final void setError(@Nullable CharSequence charSequence) {
        this.b.setError(charSequence);
    }

    public final void setHint(@Nullable CharSequence charSequence) {
        EditText editText = this.b.getEditText();
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }

    public final void setOnSubmitForm(@Nullable Runnable runnable) {
        this.c = runnable;
    }

    public final void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        EditText editText = this.b.getEditText();
        if (editText != null) {
            editText.setText(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSApplicantDataFieldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialTextView materialTextView = new MaterialTextView(context, attributeSet, R.attr.sns_applicantDataFieldLabelStyle, R.style.Widget_SNSScreen_General_EditLabel);
        addView(materialTextView, new LinearLayout.LayoutParams(0, -2, 0.37f));
        Unit unit = Unit.INSTANCE;
        this.a = materialTextView;
        TextInputLayout textInputLayout = new TextInputLayout(context, attributeSet, R.attr.sns_applicantDataFieldEditStyle);
        textInputLayout.setHintEnabled(false);
        TextInputEditText textInputEditText = new TextInputEditText(context, attributeSet);
        textInputEditText.setInputType(1);
        textInputEditText.setMaxLines(1);
        textInputEditText.setImeOptions(5);
        textInputEditText.setOnEditorActionListener(new a(this, context, attributeSet));
        textInputLayout.addView(textInputEditText);
        addView(textInputLayout, new LinearLayout.LayoutParams(0, -2, 0.63f));
        this.b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataFieldView$$special$$inlined$doAfterTextChanged$1
                public final /* synthetic */ SNSApplicantDataFieldView a;

                {
                    this.a = r1;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                    this.a.getInputLayout().setError(null);
                    this.a.getInputLayout().setErrorEnabled(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i3, int i4, int i5) {
                }
            });
        }
    }
}
