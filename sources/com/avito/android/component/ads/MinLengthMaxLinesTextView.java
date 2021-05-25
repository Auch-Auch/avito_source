package com.avito.android.component.ads;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00029\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b5\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00107\u001a\u00020\u0002¢\u0006\u0004\b5\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J#\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u0006:"}, d2 = {"Lcom/avito/android/component/ads/MinLengthMaxLinesTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "maxLines", "", "setMaxLines", "(I)V", "minLength", "setMinLength", "", "text", "Landroid/widget/TextView$BufferType;", "type", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getText", "()Ljava/lang/CharSequence;", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "viewedText", AuthSource.BOOKING_ORDER, "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/component/ads/MinLengthMaxLinesTextView$a;", "i", "Lcom/avito/android/component/ads/MinLengthMaxLinesTextView$a;", "textContainer", "k", "I", g.a, "previewWidthMeasureSpec", "e", "Ljava/lang/CharSequence;", "originalText", "j", "maxLinesValue", "h", "previewHeightMeasureSpec", "", "f", "Z", "textChanged", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MinLengthMaxLinesTextView extends AppCompatTextView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public CharSequence e;
    public boolean f;
    public int g = Integer.MIN_VALUE;
    public int h = Integer.MIN_VALUE;
    public final a i = new a("");
    public int j = 3;
    public int k = 33;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/component/ads/MinLengthMaxLinesTextView$Companion;", "", "", "DEFAULT_MAX_LINES", "I", "DEFAULT_MIN_LENGTH", "", "ELLIPSIS", "Ljava/lang/String;", "NOT_MEASURE_SPEC", "", "SPACE", "C", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements CharSequence {
        public final int a;
        @NotNull
        public CharSequence b;

        public a(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "text");
            this.b = charSequence;
            this.a = charSequence.length();
        }

        @Override // java.lang.CharSequence
        public final char charAt(int i) {
            return this.b.charAt(i);
        }

        @Override // java.lang.CharSequence
        public final int length() {
            return this.a;
        }

        @Override // java.lang.CharSequence
        @NotNull
        public CharSequence subSequence(int i, int i2) {
            return this.b.subSequence(i, i2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinLengthMaxLinesTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MinLengthMaxLinesTextView);
            setMaxLines(obtainStyledAttributes.getInt(R.styleable.MinLengthMaxLinesTextView_android_maxLines, this.j));
            setMinLength(obtainStyledAttributes.getInt(R.styleable.MinLengthMaxLinesTextView_minLength, this.k));
            obtainStyledAttributes.recycle();
        }
    }

    public final void b(CharSequence charSequence) {
        a aVar = this.i;
        Objects.requireNonNull(aVar);
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        aVar.b = charSequence;
        setText(this.i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    @Nullable
    public CharSequence getText() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int lineEnd;
        StaticLayout staticLayout;
        super.onMeasure(i2, i3);
        boolean z = this.f;
        if (!(!z && this.g == i2 && this.h == i3)) {
            this.g = i2;
            this.g = i3;
            CharSequence charSequence = this.e;
            if (charSequence != null) {
                if (!z && (!Intrinsics.areEqual(charSequence, super.getText()))) {
                    b(charSequence);
                    super.onMeasure(i2, i3);
                }
                this.f = false;
                Layout layout = getLayout();
                Intrinsics.checkNotNullExpressionValue(layout, "layout");
                int lineCount = layout.getLineCount();
                if (charSequence.length() > this.k && lineCount > this.j && (lineEnd = getLayout().getLineEnd(this.j - 1)) <= StringsKt__StringsKt.getLastIndex(charSequence)) {
                    for (lineEnd = getLayout().getLineEnd(this.j - 1); lineEnd > this.k; lineEnd--) {
                        if (charSequence.charAt(lineEnd) == ' ' && charSequence.charAt(lineEnd - 1) != ' ') {
                            CharSequence concat = TextUtils.concat(charSequence.subSequence(0, lineEnd), "…");
                            Intrinsics.checkNotNullExpressionValue(concat, "TextUtils.concat(viewedText, ELLIPSIS)");
                            Layout layout2 = getLayout();
                            Intrinsics.checkNotNullExpressionValue(layout2, "layout");
                            if (Build.VERSION.SDK_INT >= 23) {
                                staticLayout = StaticLayout.Builder.obtain(concat, 0, concat.length(), getPaint(), layout2.getWidth()).setAlignment(layout2.getAlignment()).setLineSpacing(layout2.getSpacingAdd(), layout2.getSpacingMultiplier()).build();
                                Intrinsics.checkNotNullExpressionValue(staticLayout, "StaticLayout.Builder.obt…\n                .build()");
                            } else {
                                staticLayout = new StaticLayout(concat, getPaint(), layout2.getWidth(), layout2.getAlignment(), layout2.getSpacingMultiplier(), layout2.getSpacingAdd(), false);
                            }
                            if (staticLayout.getLineCount() <= this.j) {
                                b(concat);
                                super.onMeasure(i2, i3);
                                return;
                            }
                        }
                    }
                    for (int lineEnd2 = getLayout().getLineEnd(this.j - 1); lineEnd2 < StringsKt__StringsKt.getLastIndex(charSequence); lineEnd2++) {
                        if (charSequence.charAt(lineEnd2) != ' ') {
                            int i4 = lineEnd2 + 1;
                            if (charSequence.charAt(i4) == ' ') {
                                CharSequence concat2 = TextUtils.concat(charSequence.subSequence(0, i4), "…");
                                Intrinsics.checkNotNullExpressionValue(concat2, "TextUtils.concat(viewedText, ELLIPSIS)");
                                b(concat2);
                                super.onMeasure(i2, i3);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 0) {
            this.j = i2;
            this.g = Integer.MIN_VALUE;
            this.h = Integer.MIN_VALUE;
            requestLayout();
            invalidate();
            return;
        }
        super.setMaxLines(i2);
    }

    public final void setMinLength(int i2) {
        if (i2 > 0) {
            this.k = i2;
        } else {
            this.k = 0;
        }
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence charSequence, @Nullable TextView.BufferType bufferType) {
        a aVar = this.i;
        if (charSequence == aVar) {
            super.setText(aVar.b, bufferType);
            return;
        }
        this.e = charSequence;
        this.f = true;
        super.setText(charSequence, bufferType);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinLengthMaxLinesTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinLengthMaxLinesTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }
}
