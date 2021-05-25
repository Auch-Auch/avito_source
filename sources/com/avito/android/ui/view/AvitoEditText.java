package com.avito.android.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatEditText;
import com.avito.android.ui_components.R;
import com.avito.android.util.Keyboards;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.TextViews;
public class AvitoEditText extends AppCompatEditText implements TextView.OnEditorActionListener {

    @Deprecated
    public static class InputField {
        public final EditText a;
        public final TextView b;

        public class a extends SimpleTextWatcher {
            public a() {
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InputField.this.setError((String) null);
            }
        }

        public InputField(EditText editText, TextView textView) {
            this.a = editText;
            this.b = textView;
            editText.addTextChangedListener(new a());
            setError((String) null);
        }

        public EditText getEditText() {
            return this.a;
        }

        public String getText() {
            return this.a.getText().toString();
        }

        public void hideError() {
            setError((String) null);
        }

        public void highlight() {
            this.a.setBackgroundResource(R.drawable.bg_edittext_red_states);
        }

        public void setError(@StringRes int i) {
            this.a.setBackgroundResource(R.drawable.bg_edittext_red_states);
            this.b.setText(i);
            this.b.setVisibility(0);
        }

        public void setText(CharSequence charSequence) {
            this.a.setText(charSequence);
        }

        public void setText(@StringRes int i) {
            this.a.setText(i);
        }

        public void setError(String str) {
            if (TextUtils.isEmpty(str)) {
                this.a.setBackgroundResource(R.drawable.bg_edittext_states);
                this.b.setVisibility(8);
                return;
            }
            this.a.setBackgroundResource(R.drawable.bg_edittext_red_states);
            this.b.setText(str);
            this.b.setVisibility(0);
        }
    }

    public AvitoEditText(Context context) {
        super(context);
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setOnEditorActionListener(this);
        if (!isInEditMode() && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AvitoEditText);
            String string = obtainStyledAttributes.getString(R.styleable.AvitoEditText_typeface);
            obtainStyledAttributes.recycle();
            if (!TextUtils.isEmpty(string)) {
                TextViews.applyTypeface(this, string);
            }
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && (getImeOptions() != 6 || keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        Keyboards.hideKeyboard(this);
        return false;
    }

    public AvitoEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public AvitoEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
