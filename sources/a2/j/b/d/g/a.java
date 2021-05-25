package a2.j.b.d.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public final MaterialButton a;
    @NonNull
    public ShapeAppearanceModel b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    @Nullable
    public PorterDuff.Mode i;
    @Nullable
    public ColorStateList j;
    @Nullable
    public ColorStateList k;
    @Nullable
    public ColorStateList l;
    @Nullable
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    public a(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.a = materialButton;
        this.b = shapeAppearanceModel;
    }

    @Nullable
    public Shapeable a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (Shapeable) this.r.getDrawable(2);
        }
        return (Shapeable) this.r.getDrawable(1);
    }

    @Nullable
    public MaterialShapeDrawable b() {
        return c(false);
    }

    @Nullable
    public final MaterialShapeDrawable c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    @Nullable
    public final MaterialShapeDrawable d() {
        return c(true);
    }

    public void e(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.b = shapeAppearanceModel;
        if (b() != null) {
            b().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (d() != null) {
            d().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final void f(@Dimension int i2, @Dimension int i3) {
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.e;
        int i5 = this.f;
        this.f = i3;
        this.e = i2;
        if (!this.o) {
            g();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void g() {
        MaterialButton materialButton = this.a;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.b);
        materialShapeDrawable.initializeElevationOverlay(this.a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke((float) this.h, this.k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke((float) this.h, this.n ? MaterialColors.getColor(this.a, R.attr.colorSurface) : 0);
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.b);
        this.m = materialShapeDrawable3;
        DrawableCompat.setTint(materialShapeDrawable3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.c, this.e, this.d, this.f), this.m);
        this.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable b2 = b();
        if (b2 != null) {
            b2.setElevation((float) this.s);
        }
    }

    public final void h() {
        MaterialShapeDrawable b2 = b();
        MaterialShapeDrawable d2 = d();
        if (b2 != null) {
            b2.setStroke((float) this.h, this.k);
            if (d2 != null) {
                d2.setStroke((float) this.h, this.n ? MaterialColors.getColor(this.a, R.attr.colorSurface) : 0);
            }
        }
    }
}
