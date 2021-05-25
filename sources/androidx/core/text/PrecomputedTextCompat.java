package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
public class PrecomputedTextCompat implements Spannable {
    public static final Object e = new Object();
    @NonNull
    @GuardedBy("sLock")
    public static Executor f;
    @NonNull
    public final Spannable a;
    @NonNull
    public final Params b;
    @NonNull
    public final int[] c;
    @Nullable
    public final PrecomputedText d;

    public static class a extends FutureTask<PrecomputedTextCompat> {

        /* renamed from: androidx.core.text.PrecomputedTextCompat$a$a  reason: collision with other inner class name */
        public static class CallableC0111a implements Callable<PrecomputedTextCompat> {
            public Params a;
            public CharSequence b;

            public CallableC0111a(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.a = params;
                this.b = charSequence;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.b, this.a);
            }
        }

        public a(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new CallableC0111a(params, charSequence));
        }
    }

    public PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.a = new SpannableString(charSequence);
        this.b = params;
        this.c = iArr;
        this.d = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            } else {
                new StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, params, iArr);
            TraceCompat.endSection();
            return precomputedTextCompat;
        } finally {
            TraceCompat.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        a aVar = new a(params, charSequence);
        if (executor == null) {
            synchronized (e) {
                if (f == null) {
                    f = Executors.newFixedThreadPool(1);
                }
                executor = f;
            }
        }
        executor.execute(aVar);
        return aVar;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.a.charAt(i);
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.d.getParagraphCount();
        }
        return this.c.length;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphEnd(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.d.getParagraphEnd(i);
        }
        return this.c[i];
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphStart(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.d.getParagraphStart(i);
        }
        if (i == 0) {
            return 0;
        }
        return this.c[i - 1];
    }

    @NonNull
    public Params getParams() {
        return this.b;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.d.getSpans(i, i2, cls) : (T[]) this.a.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.a.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.d.removeSpan(obj);
        } else {
            this.a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.d.setSpan(obj, i, i2, i3);
        } else {
            this.a.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence, java.lang.Object
    @NonNull
    public String toString() {
        return this.a.toString();
    }

    @RequiresApi(28)
    public PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.a = precomputedText;
        this.b = params;
        this.c = null;
        this.d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class Params {
        @NonNull
        public final TextPaint a;
        @Nullable
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;
        public final PrecomputedText.Params e;

        public static class Builder {
            @NonNull
            public final TextPaint a;
            public TextDirectionHeuristic b;
            public int c;
            public int d;

            public Builder(@NonNull TextPaint textPaint) {
                this.a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params build() {
                return new Params(this.a, this.b, this.c, this.d);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i) {
                this.c = i;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i) {
                this.d = i;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        public Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return equalsWithoutTextDirection(params) && this.b == params.getTextDirection();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.c != params.getBreakStrategy() || this.d != params.getHyphenationFrequency())) || this.a.getTextSize() != params.getTextPaint().getTextSize() || this.a.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.a.getTextSkewX() != params.getTextPaint().getTextSkewX() || this.a.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()) || this.a.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.a.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (!this.a.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            if (this.a.getTypeface() == null) {
                if (params.getTextPaint().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.a.getTypeface().equals(params.getTextPaint().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.c;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.d;
        }

        @Nullable
        @RequiresApi(18)
        public TextDirectionHeuristic getTextDirection() {
            return this.b;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.a;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.hash(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return ObjectsCompat.hash(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder L = a2.b.a.a.a.L("textSize=");
            L.append(this.a.getTextSize());
            sb.append(L.toString());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            StringBuilder L2 = a2.b.a.a.a.L(", letterSpacing=");
            L2.append(this.a.getLetterSpacing());
            sb.append(L2.toString());
            sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            if (i >= 24) {
                StringBuilder L3 = a2.b.a.a.a.L(", textLocale=");
                L3.append(this.a.getTextLocales());
                sb.append(L3.toString());
            } else {
                StringBuilder L4 = a2.b.a.a.a.L(", textLocale=");
                L4.append(this.a.getTextLocale());
                sb.append(L4.toString());
            }
            StringBuilder L5 = a2.b.a.a.a.L(", typeface=");
            L5.append(this.a.getTypeface());
            sb.append(L5.toString());
            if (i >= 26) {
                StringBuilder L6 = a2.b.a.a.a.L(", variationSettings=");
                L6.append(this.a.getFontVariationSettings());
                sb.append(L6.toString());
            }
            StringBuilder L7 = a2.b.a.a.a.L(", textDir=");
            L7.append(this.b);
            sb.append(L7.toString());
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            this.e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
