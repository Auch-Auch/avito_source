package a2.j.b.d.h;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final int[] t = {16842912};
    public static final double u = Math.cos(Math.toRadians(45.0d));
    @NonNull
    public final MaterialCardView a;
    @NonNull
    public final Rect b = new Rect();
    @NonNull
    public final MaterialShapeDrawable c;
    @NonNull
    public final MaterialShapeDrawable d;
    @Dimension
    public int e;
    @Dimension
    public int f;
    @Dimension
    public int g;
    @Nullable
    public Drawable h;
    @Nullable
    public Drawable i;
    @Nullable
    public ColorStateList j;
    @Nullable
    public ColorStateList k;
    @Nullable
    public ShapeAppearanceModel l;
    @Nullable
    public ColorStateList m;
    @Nullable
    public Drawable n;
    @Nullable
    public LayerDrawable o;
    @Nullable
    public MaterialShapeDrawable p;
    @Nullable
    public MaterialShapeDrawable q;
    public boolean r = false;
    public boolean s;

    /* renamed from: a2.j.b.d.h.a$a  reason: collision with other inner class name */
    public class C0041a extends InsetDrawable {
        public C0041a(a aVar, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.Drawable, android.graphics.drawable.DrawableWrapper
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i2, i3);
        this.c = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        int i4 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.d = new MaterialShapeDrawable();
        h(builder.build());
        obtainStyledAttributes.recycle();
    }

    public final float a() {
        return Math.max(Math.max(b(this.l.getTopLeftCorner(), this.c.getTopLeftCornerResolvedSize()), b(this.l.getTopRightCorner(), this.c.getTopRightCornerResolvedSize())), Math.max(b(this.l.getBottomRightCorner(), this.c.getBottomRightCornerResolvedSize()), b(this.l.getBottomLeftCorner(), this.c.getBottomLeftCornerResolvedSize())));
    }

    public final float b(CornerTreatment cornerTreatment, float f2) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - u) * ((double) f2));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.a.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.a.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    @NonNull
    public final Drawable e() {
        RippleDrawable rippleDrawable;
        if (this.n == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.q = new MaterialShapeDrawable(this.l);
                rippleDrawable = new RippleDrawable(this.j, null, this.q);
            } else {
                StateListDrawable stateListDrawable = new StateListDrawable();
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.l);
                this.p = materialShapeDrawable;
                materialShapeDrawable.setFillColor(this.j);
                stateListDrawable.addState(new int[]{16842919}, this.p);
                rippleDrawable = stateListDrawable;
            }
            this.n = rippleDrawable;
        }
        if (this.o == null) {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            Drawable drawable = this.i;
            if (drawable != null) {
                stateListDrawable2.addState(t, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.d, stateListDrawable2});
            this.o = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    @NonNull
    public final Drawable f(Drawable drawable) {
        int i2;
        int i3;
        if (this.a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) d());
            i3 = (int) Math.ceil((double) c());
            i2 = ceil;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new C0041a(this, drawable, i3, i2, i3, i2);
    }

    public void g(@Nullable Drawable drawable) {
        this.i = drawable;
        if (drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.i = wrap;
            DrawableCompat.setTintList(wrap, this.k);
        }
        if (this.o != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.i;
            if (drawable2 != null) {
                stateListDrawable.addState(t, drawable2);
            }
            this.o.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.l = shapeAppearanceModel;
        this.c.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.c;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.q;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.p;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final boolean i() {
        return this.a.getPreventCornerOverlap() && !this.c.isRoundRect();
    }

    public final boolean j() {
        return this.a.getPreventCornerOverlap() && this.c.isRoundRect() && this.a.getUseCompatPadding();
    }

    public void k() {
        float f2 = 0.0f;
        float a3 = i() || j() ? a() : 0.0f;
        if (this.a.getPreventCornerOverlap() && this.a.getUseCompatPadding()) {
            f2 = (float) ((1.0d - u) * ((double) this.a.getCardViewRadius()));
        }
        int i2 = (int) (a3 - f2);
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.c(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
    }

    public void l() {
        if (!this.r) {
            this.a.setBackgroundInternal(f(this.c));
        }
        this.a.setForeground(f(this.h));
    }

    public final void m() {
        Drawable drawable;
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE || (drawable = this.n) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.p;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setFillColor(this.j);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.j);
    }

    public void n() {
        this.d.setStroke((float) this.g, this.m);
    }
}
