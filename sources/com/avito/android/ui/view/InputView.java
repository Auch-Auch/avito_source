package com.avito.android.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.avito.android.ui.view.FieldView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Keyboards;
public class InputView extends RelativeLayout implements TextWatcher, View.OnFocusChangeListener, FieldView<String>, TextView.OnEditorActionListener {
    public static final InputFilter[] i = new InputFilter[0];
    public int a;
    public int b;
    public FieldView.OnFieldValueChangeListener c;
    public boolean d = false;
    public TextView e;
    public TextView f;
    @Nullable
    public ImageView g;
    @FloatingLabelMode
    public int h = 0;
    public TextView mTextView;

    public @interface FloatingLabelMode {
        public static final int ALWAYS = 2;
        public static final int NONE = 0;
        public static final int NORMAL = 1;
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputView.this.requestFocus();
        }
    }

    public InputView(Context context) {
        super(context);
        c(context, null);
    }

    public final boolean a(boolean z) {
        return z || this.mTextView.getText().length() > 0;
    }

    public void addTextChangeListener(TextWatcher textWatcher) {
        this.mTextView.addTextChangedListener(textWatcher);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        clearError();
        FieldView.OnFieldValueChangeListener onFieldValueChangeListener = this.c;
        if (onFieldValueChangeListener != null) {
            onFieldValueChangeListener.onFieldValueChanged(this, editable.toString());
        }
    }

    public final void b() {
        int i2 = this.h;
        if (i2 == 0) {
            this.e.setVisibility(8);
        } else if (i2 != 1) {
            if (i2 == 2) {
                d();
            }
        } else if (a(hasFocus())) {
            d();
        } else {
            this.e.setVisibility(4);
            this.mTextView.setHint(this.e.getText());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InputView);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.InputView_android_layout, getDefaultLayoutId());
        CharSequence text = obtainStyledAttributes.getText(R.styleable.InputView_android_text);
        int i2 = obtainStyledAttributes.getInt(R.styleable.InputView_android_maxLength, -1);
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.InputView_android_hint);
        int i3 = obtainStyledAttributes.getInt(R.styleable.InputView_android_inputType, 0);
        int i4 = obtainStyledAttributes.getInt(R.styleable.InputView_android_imeOptions, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.InputView_android_drawableLeft);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.InputView_android_icon, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InputView_android_drawablePadding, 0);
        this.a = obtainStyledAttributes.getResourceId(R.styleable.InputView_valueBackground, 0);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.InputView_valueErrorBackground, 0);
        this.h = obtainStyledAttributes.getInt(R.styleable.InputView_floatingLabelMode, 0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(resourceId, (ViewGroup) this, true);
        this.e = (TextView) findViewById(R.id.floating_label);
        this.f = (TextView) findViewById(R.id.error_label);
        this.mTextView = (TextView) findViewById(R.id.input);
        this.g = (ImageView) findViewById(R.id.icon);
        this.mTextView.addTextChangedListener(this);
        this.mTextView.setOnFocusChangeListener(this);
        this.mTextView.setOnEditorActionListener(this);
        this.mTextView.setText(text);
        this.mTextView.setHint(text2);
        this.mTextView.setInputType(i3);
        this.mTextView.setImeOptions(i4);
        this.mTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.mTextView.setCompoundDrawablePadding(dimensionPixelSize);
        this.mTextView.setBackgroundResource(this.a);
        if (i2 >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        } else {
            setFilters(i);
        }
        this.e.setText(text2);
        if (resourceId2 != 0) {
            setIcon(resourceId2);
        }
        b();
    }

    @Override // com.avito.android.ui.view.FieldView
    public void clearError() {
        this.mTextView.setBackgroundResource(this.a);
        this.f.setVisibility(8);
        this.f.setText((CharSequence) null);
    }

    public void clearValue() {
        setValue((String) null);
    }

    public final void d() {
        this.mTextView.setHint((CharSequence) null);
        this.e.setVisibility(0);
    }

    @LayoutRes
    public int getDefaultLayoutId() {
        return R.layout.input_view;
    }

    public void highlightError(@StringRes int i2) {
        highlightError(getContext().getResources().getText(i2).toString());
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (textView != this.mTextView) {
            return false;
        }
        if (i2 != 6 && (textView.getImeOptions() != 6 || keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        Keyboards.hideKeyboard(this);
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        int i2 = this.h;
        if (i2 == 0) {
            this.e.setVisibility(8);
        } else if (i2 != 1) {
            if (i2 == 2) {
                d();
            }
        } else if (a(z)) {
            d();
        } else {
            this.e.setVisibility(4);
            this.mTextView.setHint(this.e.getText());
        }
        this.mTextView.removeTextChangedListener(this);
        this.mTextView.addTextChangedListener(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof b) {
            b bVar = (b) parcelable;
            super.onRestoreInstanceState(bVar.getSuperState());
            this.e.onRestoreInstanceState(bVar.a);
            this.mTextView.removeTextChangedListener(this);
            this.mTextView.onRestoreInstanceState(bVar.b);
            this.mTextView.addTextChangedListener(this);
            this.f.onRestoreInstanceState(bVar.c);
            if (bVar.d) {
                this.mTextView.post(new a());
            }
            int i2 = bVar.e;
            if (i2 != 0) {
                setIcon(i2);
            }
            FieldView.OnFieldValueChangeListener onFieldValueChangeListener = this.c;
            if (onFieldValueChangeListener != null && this.d) {
                onFieldValueChangeListener.onFieldValueChanged(this, getValue());
            }
        } else {
            super.onRestoreInstanceState(parcelable);
        }
        if (this.f.getVisibility() == 0 || !TextUtils.isEmpty(this.f.getText())) {
            highlightError(this.f.getText().toString());
        }
        b();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Object tag;
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = this.e.onSaveInstanceState();
        bVar.b = this.mTextView.onSaveInstanceState();
        bVar.c = this.f.onSaveInstanceState();
        bVar.d = this.mTextView.isFocused();
        ImageView imageView = this.g;
        if (!(imageView == null || (tag = imageView.getTag(R.id.res_id)) == null)) {
            bVar.e = ((Integer) tag).intValue();
        }
        return bVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void removeTextChangeListener(TextWatcher textWatcher) {
        this.mTextView.removeTextChangedListener(textWatcher);
    }

    @Override // android.view.View, com.avito.android.ui.view.FieldView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mTextView.setEnabled(z);
    }

    public void setFilters(@Nullable InputFilter[] inputFilterArr) {
        if (inputFilterArr == null || inputFilterArr.length == 0) {
            this.mTextView.setFilters(i);
        } else {
            this.mTextView.setFilters(inputFilterArr);
        }
    }

    public void setFloatingLabelMode(@FloatingLabelMode int i2) {
        this.h = i2;
        b();
    }

    public void setIcon(@DrawableRes int i2) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageResource(i2);
            this.g.setTag(R.id.res_id, Integer.valueOf(i2));
            this.g.setVisibility(i2 == 0 ? 8 : 0);
        }
    }

    public void setImeOptions(int i2) {
        this.mTextView.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.mTextView.setInputType(i2);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.mTextView.setOnEditorActionListener(onEditorActionListener);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.ui.view.FieldView$OnFieldValueChangeListener] */
    @Override // com.avito.android.ui.view.FieldView
    public void setOnFieldValueChangedListener(FieldView.OnFieldValueChangeListener<? extends String> onFieldValueChangeListener) {
        this.c = onFieldValueChangeListener;
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setTitle(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public void setValueBackground(@DrawableRes int i2) {
        this.a = i2;
        this.mTextView.setBackgroundResource(i2);
    }

    @Override // com.avito.android.ui.view.FieldView
    @NonNull
    public String getValue() {
        return this.mTextView.getText().toString();
    }

    @Override // com.avito.android.ui.view.FieldView
    public void highlightError(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
        this.mTextView.setBackgroundResource(this.b);
        this.f.setText(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.ui.view.FieldView$OnFieldValueChangeListener, boolean] */
    @Override // com.avito.android.ui.view.FieldView
    public void setOnFieldValueChangedListener(FieldView.OnFieldValueChangeListener<? extends String> onFieldValueChangeListener, boolean z) {
        setOnFieldValueChangedListener(onFieldValueChangeListener);
        this.d = z;
    }

    public void setTitle(@StringRes int i2) {
        this.e.setText(i2);
    }

    public void setValue(String str) {
        setValue(str, true);
    }

    public void setValue(String str, boolean z) {
        FieldView.OnFieldValueChangeListener onFieldValueChangeListener;
        if (z && (onFieldValueChangeListener = this.c) != null) {
            onFieldValueChangeListener.onFieldValueChanged(this, str);
        }
        this.mTextView.removeTextChangedListener(this);
        this.mTextView.setText(str);
        this.mTextView.addTextChangedListener(this);
        b();
    }

    public InputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public Parcelable a;
        public Parcelable b;
        public Parcelable c;
        public boolean d;
        @DrawableRes
        public int e;

        public class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(TextView.class.getClassLoader());
            this.b = parcel.readParcelable(TextView.class.getClassLoader());
            this.c = parcel.readParcelable(TextView.class.getClassLoader());
            this.d = parcel.readInt() != 1 ? false : true;
            this.e = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
            parcel.writeParcelable(this.b, 0);
            parcel.writeParcelable(this.c, 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public InputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }

    public InputView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        c(context, attributeSet);
    }
}
