package com.avito.android.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0012\u001aA\u0010\u0018\u001a\u00020\u0005*\u00020\u00002\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019\u001a9\u0010\u001a\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0014\u001a\u00020\f2\b\b\u0003\u0010\u0015\u001a\u00020\f2\b\b\u0003\u0010\u0016\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001b\u001aA\u0010\u001a\u001a\u00020\u0005*\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0012\u001a!\u0010\"\u001a\u00020\u0005*\u00020\u00002\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 ¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroid/widget/TextView;", "", "text", "", "concealWhenEmpty", "", "bindText", "(Landroid/widget/TextView;Ljava/lang/CharSequence;Z)V", "", "fontPath", "applyTypeface", "(Landroid/widget/TextView;Ljava/lang/String;)V", "", "maxLines", "setTextAndEllipsizeEnd", "(Landroid/widget/TextView;Ljava/lang/String;I)V", "color", "tintLeftDrawable", "(Landroid/widget/TextView;I)V", "tintRightDrawable", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "tintDrawable", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCompoundDrawables", "(Landroid/widget/TextView;IIII)V", "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "resId", "setTextAppearanceCompat", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function0;)V", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "TextViews")
public final class TextViews {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final void applyTypeface(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(textView, "$this$applyTypeface");
        Intrinsics.checkNotNullParameter(str, "fontPath");
        TypefaceType fromString = TypefaceType.Companion.fromString(str);
        if (fromString != null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTypeface(Typefaces.getTypeface(context, fromString));
        }
    }

    @JvmOverloads
    public static final void bindText(@NotNull TextView textView, @Nullable CharSequence charSequence) {
        bindText$default(textView, charSequence, false, 2, null);
    }

    @JvmOverloads
    public static final void bindText(@NotNull TextView textView, @Nullable CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "$this$bindText");
        if (!(charSequence == null || charSequence.length() == 0)) {
            Views.show(textView);
            textView.setText(charSequence);
        } else if (z) {
            Views.conceal(textView);
        } else {
            Views.hide(textView);
        }
    }

    public static /* synthetic */ void bindText$default(TextView textView, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bindText(textView, charSequence, z);
    }

    public static final void setClickListener(@NotNull TextView textView, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(textView, "$this$setClickListener");
        if (function0 == null) {
            textView.setOnClickListener(null);
            textView.setClickable(false);
            return;
        }
        textView.setOnClickListener(new a(function0));
    }

    public static final void setCompoundDrawables(@NotNull TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        Intrinsics.checkNotNullParameter(textView, "$this$setCompoundDrawables");
        textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void setCompoundDrawables$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawables(textView, i, i2, i3, i4);
    }

    public static final void setTextAndEllipsizeEnd(@NotNull TextView textView, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$setTextAndEllipsizeEnd");
        Intrinsics.checkNotNullParameter(str, "text");
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(textView, textView, i, str) { // from class: com.avito.android.util.TextViews$setTextAndEllipsizeEnd$1
            public final /* synthetic */ TextView a;
            public final /* synthetic */ TextView b;
            public final /* synthetic */ int c;
            public final /* synthetic */ String d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
                ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                this.b.setMaxLines(this.c + 1);
                this.b.setText(this.d);
                if (this.a.getLineCount() > this.c) {
                    String obj = this.b.getText().subSequence(0, this.a.getLayout().getLineEnd(this.c)).toString();
                    do {
                        obj = StringsKt___StringsKt.dropLast(obj, 1);
                        TextView textView2 = this.b;
                        textView2.setText(obj + "…");
                    } while (this.a.getLineCount() > this.c);
                }
                this.b.setMaxLines(this.c);
            }
        });
    }

    public static final void setTextAppearanceCompat(@NotNull TextView textView, @StyleRes int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$setTextAppearanceCompat");
        if (Build.VERSION.SDK_INT < 23) {
            textView.setTextAppearance(textView.getContext(), i);
        } else {
            textView.setTextAppearance(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r5 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r6 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r1 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r4 != null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void tintDrawable(@org.jetbrains.annotations.NotNull android.widget.TextView r3, @androidx.annotation.ColorInt @org.jetbrains.annotations.Nullable java.lang.Integer r4, @androidx.annotation.ColorInt @org.jetbrains.annotations.Nullable java.lang.Integer r5, @androidx.annotation.ColorInt @org.jetbrains.annotations.Nullable java.lang.Integer r6, @androidx.annotation.ColorInt @org.jetbrains.annotations.Nullable java.lang.Integer r7) {
        /*
            java.lang.String r0 = "$this$tintDrawable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x001e
            int r4 = r4.intValue()
            android.graphics.drawable.Drawable[] r2 = r3.getCompoundDrawables()
            r2 = r2[r0]
            if (r2 == 0) goto L_0x001a
            android.graphics.drawable.Drawable r4 = com.avito.android.util.DrawablesKt.wrapForTinting(r2, r4)
            goto L_0x001b
        L_0x001a:
            r4 = r1
        L_0x001b:
            if (r4 == 0) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            android.graphics.drawable.Drawable[] r4 = r3.getCompoundDrawables()
            r4 = r4[r0]
        L_0x0024:
            r0 = 1
            if (r5 == 0) goto L_0x003c
            int r5 = r5.intValue()
            android.graphics.drawable.Drawable[] r2 = r3.getCompoundDrawables()
            r2 = r2[r0]
            if (r2 == 0) goto L_0x0038
            android.graphics.drawable.Drawable r5 = com.avito.android.util.DrawablesKt.wrapForTinting(r2, r5)
            goto L_0x0039
        L_0x0038:
            r5 = r1
        L_0x0039:
            if (r5 == 0) goto L_0x003c
            goto L_0x0042
        L_0x003c:
            android.graphics.drawable.Drawable[] r5 = r3.getCompoundDrawables()
            r5 = r5[r0]
        L_0x0042:
            r0 = 2
            if (r6 == 0) goto L_0x005a
            int r6 = r6.intValue()
            android.graphics.drawable.Drawable[] r2 = r3.getCompoundDrawables()
            r2 = r2[r0]
            if (r2 == 0) goto L_0x0056
            android.graphics.drawable.Drawable r6 = com.avito.android.util.DrawablesKt.wrapForTinting(r2, r6)
            goto L_0x0057
        L_0x0056:
            r6 = r1
        L_0x0057:
            if (r6 == 0) goto L_0x005a
            goto L_0x0060
        L_0x005a:
            android.graphics.drawable.Drawable[] r6 = r3.getCompoundDrawables()
            r6 = r6[r0]
        L_0x0060:
            r0 = 3
            if (r7 == 0) goto L_0x0076
            int r7 = r7.intValue()
            android.graphics.drawable.Drawable[] r2 = r3.getCompoundDrawables()
            r2 = r2[r0]
            if (r2 == 0) goto L_0x0073
            android.graphics.drawable.Drawable r1 = com.avito.android.util.DrawablesKt.wrapForTinting(r2, r7)
        L_0x0073:
            if (r1 == 0) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            android.graphics.drawable.Drawable[] r7 = r3.getCompoundDrawables()
            r1 = r7[r0]
        L_0x007c:
            r3.setCompoundDrawablesWithIntrinsicBounds(r4, r5, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.TextViews.tintDrawable(android.widget.TextView, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    public static /* synthetic */ void tintDrawable$default(TextView textView, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        tintDrawable(textView, num, num2, num3, num4);
    }

    public static final void tintLeftDrawable(@NotNull TextView textView, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$tintLeftDrawable");
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorCompat = Contexts.getColorCompat(context, i);
        Drawable drawable = textView.getCompoundDrawables()[0];
        Intrinsics.checkNotNullExpressionValue(drawable, "compoundDrawables[0]");
        DrawablesKt.wrapForTinting(drawable, colorCompat);
    }

    public static final void tintRightDrawable(@NotNull TextView textView, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$tintRightDrawable");
        tintDrawable$default(textView, null, null, Integer.valueOf(ContextCompat.getColor(textView.getContext(), i)), null, 11, null);
    }

    public static final void setCompoundDrawables(@NotNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Intrinsics.checkNotNullParameter(textView, "$this$setCompoundDrawables");
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static /* synthetic */ void setCompoundDrawables$default(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        if ((i & 2) != 0) {
            drawable2 = null;
        }
        if ((i & 4) != 0) {
            drawable3 = null;
        }
        if ((i & 8) != 0) {
            drawable4 = null;
        }
        setCompoundDrawables(textView, drawable, drawable2, drawable3, drawable4);
    }
}
