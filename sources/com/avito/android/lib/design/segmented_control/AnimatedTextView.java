package com.avito.android.lib.design.segmented_control;

import a2.g.r.g;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0015¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/avito/android/lib/design/segmented_control/AnimatedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "drawableStateChanged", "()V", "", g.a, "Z", "isAnimated", "()Z", "setAnimated", "(Z)V", "Landroid/content/res/ColorStateList;", "f", "Landroid/content/res/ColorStateList;", "getTextColorStateList", "()Landroid/content/res/ColorStateList;", "setTextColorStateList", "(Landroid/content/res/ColorStateList;)V", "textColorStateList", "", "e", "J", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationDuration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AnimatedTextView extends AppCompatTextView {
    public long e;
    @NotNull
    public ColorStateList f;
    public boolean g;

    @JvmOverloads
    public AnimatedTextView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public AnimatedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public AnimatedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnimatedTextView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int colorForState = this.f.getColorForState(getDrawableState(), this.f.getDefaultColor());
        if (this.g) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "textColor", getCurrentTextColor(), colorForState);
            ofInt.setEvaluator(new ArgbEvaluator());
            Intrinsics.checkNotNullExpressionValue(ofInt, "colorAnim");
            ofInt.setDuration(this.e);
            ofInt.start();
            return;
        }
        setTextColor(colorForState);
    }

    public final long getAnimationDuration() {
        return this.e;
    }

    @NotNull
    public final ColorStateList getTextColorStateList() {
        return this.f;
    }

    public final boolean isAnimated() {
        return this.g;
    }

    public final void setAnimated(boolean z) {
        this.g = z;
    }

    public final void setAnimationDuration(long j) {
        this.e = j;
    }

    public final void setTextColorStateList(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
        this.f = colorStateList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(getCurrentTextColor());
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(this.currentTextColor)");
        this.f = valueOf;
        this.g = true;
    }
}
