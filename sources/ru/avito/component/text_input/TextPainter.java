package ru.avito.component.text_input;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020%¢\u0006\u0004\b[\u0010\\J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R+\u00100\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020+8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010#R+\u00107\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028F@FX\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001cR\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010#\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010\u001cR\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010\u001cR\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010\u001cR\u001e\u0010M\u001a\n J*\u0004\u0018\u00010I0I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010\u001cR\u0016\u0010Q\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010#R\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010\u001cR\u0016\u0010U\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010\u001cR\u0016\u0010W\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010#R+\u0010Z\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020+8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/¨\u0006]"}, d2 = {"Lru/avito/component/text_input/TextPainter;", "", "", AuthSource.SEND_ABUSE, "()F", "", AuthSource.BOOKING_ORDER, "()V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "updateSize", "(III)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "n", "F", "currentTextSize", "p", "currentX", "u", "collapsedY", "l", "I", "errorColor", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus", "o", "currentColor", "c", "getFraction", "setFraction", "(F)V", "fraction", "i", "collapsedTextSize", "Landroid/graphics/Paint;", g.a, "Landroid/graphics/Paint;", "paint", "d", "getHeight", "()I", "setHeight", "(I)V", VKApiConst.Q, "currentY", "h", "expandedTextSize", "t", "expandedY", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Landroid/content/Context;", "context", "s", "collapsedTextHeight", "k", "focusedColor", "r", "expandedTextHeight", "j", "collapsedTopPadding", AuthSource.OPEN_CHANNEL_LIST, "unFocusedColor", "getHasError", "setHasError", "hasError", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextPainter {
    public static final /* synthetic */ KProperty[] w = {a.u0(TextPainter.class, "hasFocus", "getHasFocus()Z", 0), a.u0(TextPainter.class, "hasError", "getHasError()Z", 0), a.u0(TextPainter.class, "fraction", "getFraction()F", 0), a.u0(TextPainter.class, "text", "getText()Ljava/lang/CharSequence;", 0)};
    @NotNull
    public final ReadWriteProperty a;
    @NotNull
    public final ReadWriteProperty b;
    @NotNull
    public final ReadWriteProperty c;
    public int d;
    @NotNull
    public final ReadWriteProperty e = new ObservableProperty<CharSequence>("", "", this) { // from class: ru.avito.component.text_input.TextPainter$$special$$inlined$observable$4
        public final /* synthetic */ Object b;
        public final /* synthetic */ TextPainter c;

        {
            this.b = r1;
            this.c = r3;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(@NotNull KProperty<?> kProperty, CharSequence charSequence, CharSequence charSequence2) {
            Intrinsics.checkNotNullParameter(kProperty, "property");
            TextPainter textPainter = this.c;
            textPainter.r = TextPainter.access$calculateTextSize(textPainter, textPainter.h);
            TextPainter textPainter2 = this.c;
            textPainter2.s = TextPainter.access$calculateTextSize(textPainter2, textPainter2.i);
            TextPainter textPainter3 = this.c;
            textPainter3.t = textPainter3.a();
            TextPainter textPainter4 = this.c;
            textPainter4.u = TextPainter.access$calculateCollapsedY(textPainter4);
        }
    };
    public final Context f;
    public final Paint g;
    public final float h;
    public final float i;
    public final float j;
    public final int k;
    public final int l;
    public final int m;
    public float n;
    public int o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    @NotNull
    public final View v;

    public TextPainter(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        Boolean bool = Boolean.FALSE;
        this.a = new ObservableProperty<Boolean>(bool, bool, this) { // from class: ru.avito.component.text_input.TextPainter$$special$$inlined$observable$1
            public final /* synthetic */ Object b;
            public final /* synthetic */ TextPainter c;

            {
                this.b = r1;
                this.c = r3;
            }

            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> kProperty, Boolean bool2, Boolean bool3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                bool3.booleanValue();
                bool2.booleanValue();
                this.c.b();
            }
        };
        this.b = new ObservableProperty<Boolean>(bool, bool, this) { // from class: ru.avito.component.text_input.TextPainter$$special$$inlined$observable$2
            public final /* synthetic */ Object b;
            public final /* synthetic */ TextPainter c;

            {
                this.b = r1;
                this.c = r3;
            }

            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> kProperty, Boolean bool2, Boolean bool3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                bool3.booleanValue();
                bool2.booleanValue();
                this.c.b();
            }
        };
        Float valueOf = Float.valueOf(1.0f);
        this.c = new ObservableProperty<Float>(valueOf, valueOf, this) { // from class: ru.avito.component.text_input.TextPainter$$special$$inlined$observable$3
            public final /* synthetic */ Object b;
            public final /* synthetic */ TextPainter c;

            {
                this.b = r1;
                this.c = r3;
            }

            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> kProperty, Float f2, Float f3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                f3.floatValue();
                f2.floatValue();
                this.c.b();
            }
        };
        Context context = view.getContext();
        this.f = context;
        Paint paint = new Paint();
        this.g = paint;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(R.dimen.text_input_hint_expanded_size);
        this.h = dimensionPixelSize;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.i = (float) context.getResources().getDimensionPixelSize(R.dimen.text_input_hint_collapsed_size);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.j = (float) context.getResources().getDimensionPixelSize(R.dimen.text_input_small_padding);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.k = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.l = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28);
        this.m = colorByAttr;
        this.n = dimensionPixelSize;
        this.o = colorByAttr;
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        paint.setTypeface(Typefaces.getTypeface(context, TypefaceType.Regular));
    }

    public static final float access$calculateCollapsedY(TextPainter textPainter) {
        if (textPainter.d != 0) {
            return textPainter.j + textPainter.s;
        }
        return 0.0f;
    }

    public static final float access$calculateTextSize(TextPainter textPainter, float f2) {
        float textSize = textPainter.g.getTextSize();
        textPainter.g.setTextSize(f2);
        Paint.FontMetrics fontMetrics = textPainter.g.getFontMetrics();
        float f3 = fontMetrics.descent - fontMetrics.ascent;
        textPainter.g.setTextSize(textSize);
        return f3;
    }

    public final float a() {
        int i2 = this.d;
        if (i2 == 0) {
            return 0.0f;
        }
        return (this.h / 4.0f) + (((float) i2) / 2.0f);
    }

    public final void b() {
        int i2;
        float f2 = this.i;
        this.n = a.b(this.h, f2, getFraction(), f2);
        if (getHasError()) {
            i2 = this.l;
        } else if ((getFraction() == 0.0f || getFraction() == 1.0f) && !getHasFocus()) {
            i2 = this.m;
        } else {
            int i3 = this.k;
            int i4 = this.m;
            float fraction = getFraction();
            float f3 = 1.0f - fraction;
            i2 = Color.argb((int) ((((float) Color.alpha(i4)) * fraction) + (((float) Color.alpha(i3)) * f3)), (int) ((((float) Color.red(i4)) * fraction) + (((float) Color.red(i3)) * f3)), (int) ((((float) Color.green(i4)) * fraction) + (((float) Color.green(i3)) * f3)), (int) ((((float) Color.blue(i4)) * fraction) + (((float) Color.blue(i3)) * f3)));
        }
        this.o = i2;
        float f4 = this.u;
        this.q = a.b(this.t, f4, getFraction(), f4);
        this.g.setTextSize(this.n);
        this.g.setColor(this.o);
        ViewCompat.postInvalidateOnAnimation(this.v);
    }

    public final void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawText(getText(), 0, getText().length(), this.p, this.q, this.g);
    }

    public final float getFraction() {
        return ((Number) this.c.getValue(this, w[2])).floatValue();
    }

    public final boolean getHasError() {
        return ((Boolean) this.b.getValue(this, w[1])).booleanValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.a.getValue(this, w[0])).booleanValue();
    }

    public final int getHeight() {
        return this.d;
    }

    @NotNull
    public final CharSequence getText() {
        return (CharSequence) this.e.getValue(this, w[3]);
    }

    @NotNull
    public final View getView() {
        return this.v;
    }

    public final void setFraction(float f2) {
        this.c.setValue(this, w[2], Float.valueOf(f2));
    }

    public final void setHasError(boolean z) {
        this.b.setValue(this, w[1], Boolean.valueOf(z));
    }

    public final void setHasFocus(boolean z) {
        this.a.setValue(this, w[0], Boolean.valueOf(z));
    }

    public final void setHeight(int i2) {
        this.d = i2;
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.e.setValue(this, w[3], charSequence);
    }

    public final void updateSize(int i2, int i3, int i4) {
        this.d = i4;
        this.p = (float) i2;
        this.t = a();
        this.u = this.d != 0 ? this.j + this.s : 0.0f;
        b();
    }
}
