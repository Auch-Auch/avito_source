package com.avito.android.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
public class AvitoTextView extends AppCompatTextView {
    public boolean e;
    public boolean f;

    @SuppressLint({"ParcelCreator"})
    public static class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String str) {
            super(str);
        }

        @Override // android.text.style.CharacterStyle, android.text.style.ClickableSpan
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public AvitoTextView(Context context) {
        super(context);
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setIncludeFontPadding(false);
        if (!isInEditMode() && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AvitoTextView);
            String string = obtainStyledAttributes.getString(R.styleable.AvitoTextView_typeface);
            this.e = obtainStyledAttributes.getBoolean(R.styleable.AvitoTextView_hasLinks, false);
            this.f = obtainStyledAttributes.getBoolean(R.styleable.AvitoTextView_hasHtml, false);
            obtainStyledAttributes.recycle();
            if (!TextUtils.isEmpty(string)) {
                TextViews.applyTypeface(this, string);
            }
            if (this.e) {
                setSaveEnabled(false);
                setMovementMethod(LinkMovementMethod.getInstance());
                this.f = true;
            }
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence) || !this.f || isInEditMode()) {
            super.setText(charSequence, bufferType);
            return;
        }
        CharSequence fromHtml = Html.fromHtml(charSequence.toString(), null, new TypefaceTagHandler(getContext()));
        if (this.e) {
            Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(fromHtml);
            URLSpan[] uRLSpanArr = (URLSpan[]) newSpannable.getSpans(0, newSpannable.length(), URLSpan.class);
            for (URLSpan uRLSpan : uRLSpanArr) {
                int spanStart = newSpannable.getSpanStart(uRLSpan);
                int spanEnd = newSpannable.getSpanEnd(uRLSpan);
                newSpannable.removeSpan(uRLSpan);
                newSpannable.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
            }
            super.setText(newSpannable, bufferType);
            return;
        }
        super.setText(fromHtml, bufferType);
    }

    public AvitoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public AvitoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
