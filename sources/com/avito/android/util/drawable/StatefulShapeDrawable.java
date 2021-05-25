package com.avito.android.util.drawable;

import a2.g.r.g;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00012B\t\b\u0016¢\u0006\u0004\b0\u0010)B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b0\u0010\tB\u0011\b\u0012\u0012\u0006\u0010-\u001a\u00020+¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u001bJ5\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0016H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0016H\u0016¢\u0006\u0004\b$\u0010\"J/\u0010%\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b%\u0010\u001bJ\u0019\u0010&\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001dH\u0002¢\u0006\u0004\b*\u0010\u001fR\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010,R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/util/drawable/StatefulShapeDrawable;", "Landroid/graphics/drawable/ShapeDrawable;", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/graphics/drawable/shapes/Shape;", "s", "", "setShape", "(Landroid/graphics/drawable/shapes/Shape;)V", "Landroid/content/res/ColorStateList;", "color", "setColor", "(Landroid/content/res/ColorStateList;)V", "", "stateSet", "setIgnoreStates", "([I)V", "Landroid/graphics/Rect;", "padding", "setPadding", "(Landroid/graphics/Rect;)V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "(IIII)V", "changePadding", "", "isStateful", "()Z", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setIntrinsicHeight", "(I)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setIntrinsicWidth", "setBounds", "onStateChange", "([I)Z", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/drawable/StatefulShapeDrawable$State;", "Lcom/avito/android/util/drawable/StatefulShapeDrawable$State;", "state", "I", "currentColor", "<init>", "(Lcom/avito/android/util/drawable/StatefulShapeDrawable$State;)V", "State", "android_release"}, k = 1, mv = {1, 4, 2})
public final class StatefulShapeDrawable extends ShapeDrawable {
    public final State a;
    public int b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ'\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0018\u00010\u000bR\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0015R\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0015R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0015R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0012\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0015R$\u0010I\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/avito/android/util/drawable/StatefulShapeDrawable$State;", "Landroid/graphics/drawable/Drawable$ConstantState;", "", "canApplyTheme", "()Z", "Landroid/graphics/drawable/Drawable;", "newDrawable", "()Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", UriUtil.LOCAL_RESOURCE_SCHEME, "(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources$Theme;", "theme", "(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;", "", "getChangingConfigurations", "()I", "f", "I", "getHeight", "setHeight", "(I)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "e", "getWidth", "setWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "h", "getPaddingTop", "setPaddingTop", "paddingTop", "i", "getPaddingRight", "setPaddingRight", "paddingRight", "Landroid/graphics/drawable/shapes/Shape;", AuthSource.BOOKING_ORDER, "Landroid/graphics/drawable/shapes/Shape;", "getShape", "()Landroid/graphics/drawable/shapes/Shape;", "setShape", "(Landroid/graphics/drawable/shapes/Shape;)V", "shape", "", "d", "[I", "getIgnoreStates", "()[I", "setIgnoreStates", "([I)V", "ignoreStates", "j", "getPaddingBottom", "setPaddingBottom", "paddingBottom", "Landroid/content/res/ColorStateList;", "c", "Landroid/content/res/ColorStateList;", "getColor", "()Landroid/content/res/ColorStateList;", "setColor", "(Landroid/content/res/ColorStateList;)V", "color", g.a, "getPaddingLeft", "setPaddingLeft", "paddingLeft", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable$ConstantState;", "getSuperState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "setSuperState", "(Landroid/graphics/drawable/Drawable$ConstantState;)V", "superState", "orig", "<init>", "(Lcom/avito/android/util/drawable/StatefulShapeDrawable$State;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class State extends Drawable.ConstantState {
        @Nullable
        public Drawable.ConstantState a;
        @Nullable
        public Shape b;
        @Nullable
        public ColorStateList c;
        @Nullable
        public int[] d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;

        public State() {
            this(null, 1, null);
        }

        public State(@Nullable State state) {
            int i2 = -1;
            this.e = -1;
            this.f = -1;
            int[] iArr = null;
            this.b = state != null ? state.b : null;
            this.c = state != null ? state.c : null;
            this.d = state != null ? state.d : iArr;
            this.e = state != null ? state.e : -1;
            this.f = state != null ? state.f : i2;
            int i3 = 0;
            this.g = state != null ? state.g : 0;
            this.h = state != null ? state.h : 0;
            this.i = state != null ? state.i : 0;
            this.j = state != null ? state.j : i3;
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
            return this.c;
        }

        public final int getHeight() {
            return this.f;
        }

        @Nullable
        public final int[] getIgnoreStates() {
            return this.d;
        }

        public final int getPaddingBottom() {
            return this.j;
        }

        public final int getPaddingLeft() {
            return this.g;
        }

        public final int getPaddingRight() {
            return this.i;
        }

        public final int getPaddingTop() {
            return this.h;
        }

        @Nullable
        public final Shape getShape() {
            return this.b;
        }

        @Nullable
        public final Drawable.ConstantState getSuperState() {
            return this.a;
        }

        public final int getWidth() {
            return this.e;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable() {
            return new StatefulShapeDrawable(new State(this), null);
        }

        public final void setColor(@Nullable ColorStateList colorStateList) {
            this.c = colorStateList;
        }

        public final void setHeight(int i2) {
            this.f = i2;
        }

        public final void setIgnoreStates(@Nullable int[] iArr) {
            this.d = iArr;
        }

        public final void setPaddingBottom(int i2) {
            this.j = i2;
        }

        public final void setPaddingLeft(int i2) {
            this.g = i2;
        }

        public final void setPaddingRight(int i2) {
            this.i = i2;
        }

        public final void setPaddingTop(int i2) {
            this.h = i2;
        }

        public final void setShape(@Nullable Shape shape) {
            this.b = shape;
        }

        public final void setSuperState(@Nullable Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public final void setWidth(int i2) {
            this.e = i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources resources) {
            return new StatefulShapeDrawable(new State(this), null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources resources, @Nullable Resources.Theme theme) {
            return new StatefulShapeDrawable(new State(this), null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(State state, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : state);
        }
    }

    public /* synthetic */ StatefulShapeDrawable(State state, j jVar) {
        this(state);
    }

    public static /* synthetic */ void changePadding$default(StatefulShapeDrawable statefulShapeDrawable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = statefulShapeDrawable.a.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = statefulShapeDrawable.a.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = statefulShapeDrawable.a.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = statefulShapeDrawable.a.getPaddingBottom();
        }
        statefulShapeDrawable.changePadding(i, i2, i3, i4);
    }

    public final boolean a() {
        int[] state = getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState()");
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
        Paint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(colorForState);
        return true;
    }

    public final void b() {
        super.setShape(this.a.getShape());
        super.setIntrinsicHeight(this.a.getHeight());
        super.setIntrinsicWidth(this.a.getWidth());
        a();
    }

    public final void changePadding(int i, int i2, int i3, int i4) {
        State state = this.a;
        state.setPaddingLeft(i);
        state.setPaddingTop(i2);
        state.setPaddingRight(i3);
        state.setPaddingBottom(i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    @NotNull
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.a.getColor() != null;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(@Nullable int[] iArr) {
        return super.onStateChange(iArr) || a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(this.a.getPaddingLeft() + i, this.a.getPaddingTop() + i2, i3 - this.a.getPaddingRight(), i4 - this.a.getPaddingBottom());
    }

    public final void setColor(@Nullable ColorStateList colorStateList) {
        this.a.setColor(colorStateList);
        a();
    }

    public final void setIgnoreStates(@Nullable int[] iArr) {
        this.a.setIgnoreStates(iArr);
        a();
    }

    @Override // android.graphics.drawable.ShapeDrawable
    public void setIntrinsicHeight(int i) {
        super.setIntrinsicHeight(i);
        this.a.setHeight(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    public void setIntrinsicWidth(int i) {
        super.setIntrinsicWidth(i);
        this.a.setWidth(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    public void setPadding(@Nullable Rect rect) {
        if (rect != null) {
            changePadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable
    public void setShape(@Nullable Shape shape) {
        super.setShape(shape);
        this.a.setShape(shape);
    }

    public StatefulShapeDrawable() {
        this((Shape) null);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    public void setPadding(int i, int i2, int i3, int i4) {
        changePadding(i, i2, i3, i4);
    }

    public StatefulShapeDrawable(@Nullable Shape shape) {
        this(new State(null, 1, null));
        this.a.setShape(shape);
        b();
    }

    public StatefulShapeDrawable(State state) {
        this.a = state;
        Paint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(this.b);
        state.setSuperState(super.getConstantState());
        b();
    }
}
