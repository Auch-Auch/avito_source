package com.google.android.exoplayer2.ui;

import a2.j.b.b.c1.f0;
import a2.j.b.b.c1.l0;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class SubtitleView extends FrameLayout implements TextOutput {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;
    public List<Cue> a;
    public CaptionStyleCompat b;
    public int c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public int h;
    public a i;
    public View j;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public interface a {
        void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f && this.g) {
            return this.a;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            Cue cue = this.a.get(i2);
            CharSequence charSequence = cue.text;
            if (!this.f) {
                Cue.Builder clearWindowColor = cue.buildUpon().setTextSize(-3.4028235E38f, Integer.MIN_VALUE).clearWindowColor();
                if (charSequence != null) {
                    clearWindowColor.setText(charSequence.toString());
                }
                cue = clearWindowColor.build();
            } else if (!this.g && charSequence != null) {
                Cue.Builder textSize = cue.buildUpon().setTextSize(-3.4028235E38f, Integer.MIN_VALUE);
                if (charSequence instanceof Spanned) {
                    SpannableString valueOf = SpannableString.valueOf(charSequence);
                    for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) valueOf.getSpans(0, valueOf.length(), AbsoluteSizeSpan.class)) {
                        valueOf.removeSpan(absoluteSizeSpan);
                    }
                    for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) valueOf.getSpans(0, valueOf.length(), RelativeSizeSpan.class)) {
                        valueOf.removeSpan(relativeSizeSpan);
                    }
                    textSize.setText(valueOf);
                }
                cue = textSize.build();
            }
            arrayList.add(cue);
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util.SDK_INT < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (Util.SDK_INT < 19 || isInEditMode()) {
            return CaptionStyleCompat.DEFAULT;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return CaptionStyleCompat.DEFAULT;
        }
        return CaptionStyleCompat.createFromCaptionStyle(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.j);
        View view = this.j;
        if (view instanceof l0) {
            ((l0) view).b.destroy();
        }
        this.j = t;
        this.i = t;
        addView(t);
    }

    public final void a() {
        this.i.a(getCuesWithStylingPreferencesApplied(), this.b, this.d, this.c, this.e);
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public void onCues(List<Cue> list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.g = z;
        a();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.f = z;
        a();
    }

    public void setBottomPaddingFraction(float f2) {
        this.e = f2;
        a();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.a = list;
        a();
    }

    public void setFixedTextSize(@Dimension int i2, float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        this.c = 2;
        this.d = applyDimension;
        a();
    }

    public void setFractionalTextSize(float f2) {
        setFractionalTextSize(f2, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.b = captionStyleCompat;
        a();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i2) {
        if (this.h != i2) {
            if (i2 == 1) {
                setView(new f0(getContext(), null));
            } else if (i2 == 2) {
                setView(new l0(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.h = i2;
        }
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Collections.emptyList();
        this.b = CaptionStyleCompat.DEFAULT;
        this.c = 0;
        this.d = 0.0533f;
        this.e = 0.08f;
        this.f = true;
        this.g = true;
        f0 f0Var = new f0(context, attributeSet);
        this.i = f0Var;
        this.j = f0Var;
        addView(f0Var);
        this.h = 1;
    }

    public void setFractionalTextSize(float f2, boolean z) {
        this.c = z ? 1 : 0;
        this.d = f2;
        a();
    }
}
