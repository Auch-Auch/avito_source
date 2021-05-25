package com.avito.android.util.drawable;

import a2.g.r.g;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.util.UriUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0016¢\u0006\u0004\b)\u0010*B\u0011\b\u0012\u0012\u0006\u0010(\u001a\u00020&¢\u0006\u0004\b)\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/util/drawable/StatefulGradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/content/res/ColorStateList;", "color", "", "setColorStateList", "(Landroid/content/res/ColorStateList;)V", "", "stateSet", "setIgnoreStates", "([I)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setStatefulStroke", "(ILandroid/content/res/ColorStateList;)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setSize", "(II)V", "", "radius", "setCornerRadius", "(F)V", "", "isStateful", "()Z", "onStateChange", "([I)Z", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "I", "currentStrokeColor", "currentColor", "d", "currentStrokeWidth", "Lcom/avito/android/util/drawable/StatefulGradientDrawable$State;", "Lcom/avito/android/util/drawable/StatefulGradientDrawable$State;", "state", "<init>", "()V", "(Lcom/avito/android/util/drawable/StatefulGradientDrawable$State;)V", "State", "android_release"}, k = 1, mv = {1, 4, 2})
public final class StatefulGradientDrawable extends GradientDrawable {
    public final State a;
    public int b;
    public int c;
    public int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ'\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0018\u00010\u000bR\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010%R$\u0010*\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\"\u0010.\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010%R\"\u00106\u001a\u00020/8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u0010\"\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010%R$\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006E"}, d2 = {"Lcom/avito/android/util/drawable/StatefulGradientDrawable$State;", "Landroid/graphics/drawable/Drawable$ConstantState;", "", "canApplyTheme", "()Z", "Landroid/graphics/drawable/Drawable;", "newDrawable", "()Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", UriUtil.LOCAL_RESOURCE_SCHEME, "(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources$Theme;", "theme", "(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;", "", "getChangingConfigurations", "()I", "", "c", "[I", "getIgnoreStates", "()[I", "setIgnoreStates", "([I)V", "ignoreStates", "Landroid/content/res/ColorStateList;", "e", "Landroid/content/res/ColorStateList;", "getStrokeColor", "()Landroid/content/res/ColorStateList;", "setStrokeColor", "(Landroid/content/res/ColorStateList;)V", "strokeColor", "d", "I", "getStrokeWidth", "setStrokeWidth", "(I)V", "strokeWidth", AuthSource.BOOKING_ORDER, "getColor", "setColor", "color", g.a, "getWidth", "setWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "f", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "h", "getHeight", "setHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable$ConstantState;", "getSuperState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "setSuperState", "(Landroid/graphics/drawable/Drawable$ConstantState;)V", "superState", "orig", "<init>", "(Lcom/avito/android/util/drawable/StatefulGradientDrawable$State;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class State extends Drawable.ConstantState {
        @Nullable
        public Drawable.ConstantState a;
        @Nullable
        public ColorStateList b;
        @Nullable
        public int[] c;
        public int d;
        @Nullable
        public ColorStateList e;
        public float f;
        public int g;
        public int h;

        public State() {
            this(null, 1, null);
        }

        public State(@Nullable State state) {
            int i = -1;
            this.g = -1;
            this.h = -1;
            int[] iArr = null;
            this.b = state != null ? state.b : null;
            this.d = state != null ? state.d : 0;
            this.e = state != null ? state.e : null;
            this.c = state != null ? state.c : iArr;
            this.f = state != null ? state.f : 0.0f;
            this.g = state != null ? state.g : -1;
            this.h = state != null ? state.h : i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            Drawable.ConstantState constantState = this.a;
            if (constantState != null) {
                return constantState.canApplyTheme();
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.a;
            if (constantState != null) {
                return constantState.getChangingConfigurations();
            }
            return 0;
        }

        @Nullable
        public final ColorStateList getColor() {
            return this.b;
        }

        public final float getCornerRadius() {
            return this.f;
        }

        public final int getHeight() {
            return this.h;
        }

        @Nullable
        public final int[] getIgnoreStates() {
            return this.c;
        }

        @Nullable
        public final ColorStateList getStrokeColor() {
            return this.e;
        }

        public final int getStrokeWidth() {
            return this.d;
        }

        @Nullable
        public final Drawable.ConstantState getSuperState() {
            return this.a;
        }

        public final int getWidth() {
            return this.g;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable() {
            return new StatefulGradientDrawable(new State(this), null);
        }

        public final void setColor(@Nullable ColorStateList colorStateList) {
            this.b = colorStateList;
        }

        public final void setCornerRadius(float f2) {
            this.f = f2;
        }

        public final void setHeight(int i) {
            this.h = i;
        }

        public final void setIgnoreStates(@Nullable int[] iArr) {
            this.c = iArr;
        }

        public final void setStrokeColor(@Nullable ColorStateList colorStateList) {
            this.e = colorStateList;
        }

        public final void setStrokeWidth(int i) {
            this.d = i;
        }

        public final void setSuperState(@Nullable Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public final void setWidth(int i) {
            this.g = i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources resources) {
            return new StatefulGradientDrawable(new State(this), null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources resources, @Nullable Resources.Theme theme) {
            return new StatefulGradientDrawable(new State(this), null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(State state, int i, j jVar) {
            this((i & 1) != 0 ? null : state);
        }
    }

    public /* synthetic */ StatefulGradientDrawable(State state, j jVar) {
        this(state);
    }

    public final boolean a() {
        int[] state = getState();
        Intrinsics.checkNotNullExpressionValue(state, "(getState())");
        List<Integer> mutableList = ArraysKt___ArraysKt.toMutableList(state);
        int[] ignoreStates = this.a.getIgnoreStates();
        if (ignoreStates != null) {
            for (int i : ignoreStates) {
                mutableList.remove(Integer.valueOf(i));
            }
        }
        ColorStateList color = this.a.getColor();
        int colorForState = color != null ? color.getColorForState(CollectionsKt___CollectionsKt.toIntArray(mutableList), 0) : 0;
        if (this.b == colorForState) {
            return false;
        }
        this.b = colorForState;
        setColor(colorForState);
        return true;
    }

    public final boolean b() {
        int[] state = getState();
        Intrinsics.checkNotNullExpressionValue(state, "(getState())");
        List<Integer> mutableList = ArraysKt___ArraysKt.toMutableList(state);
        int[] ignoreStates = this.a.getIgnoreStates();
        if (ignoreStates != null) {
            for (int i : ignoreStates) {
                mutableList.remove(Integer.valueOf(i));
            }
        }
        ColorStateList strokeColor = this.a.getStrokeColor();
        int colorForState = strokeColor != null ? strokeColor.getColorForState(CollectionsKt___CollectionsKt.toIntArray(mutableList), 0) : 0;
        if (this.c == colorForState && this.d == this.a.getStrokeWidth()) {
            return false;
        }
        this.c = colorForState;
        int strokeWidth = this.a.getStrokeWidth();
        this.d = strokeWidth;
        setStroke(strokeWidth, this.c);
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    @NotNull
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.a.getColor() != null;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(@Nullable int[] iArr) {
        return super.onStateChange(iArr) || a() || b();
    }

    public final void setColorStateList(@Nullable ColorStateList colorStateList) {
        this.a.setColor(colorStateList);
        a();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public void setCornerRadius(float f) {
        super.setCornerRadius(f);
        this.a.setCornerRadius(f);
    }

    public final void setIgnoreStates(@Nullable int[] iArr) {
        this.a.setIgnoreStates(iArr);
        a();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public void setSize(int i, int i2) {
        super.setSize(i, i2);
        this.a.setWidth(i);
        this.a.setHeight(i2);
    }

    public final void setStatefulStroke(int i, @Nullable ColorStateList colorStateList) {
        this.a.setStrokeWidth(i);
        this.a.setStrokeColor(colorStateList);
        b();
    }

    public StatefulGradientDrawable() {
        this(new State(null, 1, null));
    }

    public StatefulGradientDrawable(State state) {
        this.a = state;
        setColor(this.b);
        setStroke(this.d, this.c);
        state.setSuperState(super.getConstantState());
        b();
        a();
        setCornerRadius(state.getCornerRadius());
        setSize(state.getWidth(), state.getHeight());
    }
}
