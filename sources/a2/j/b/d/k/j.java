package a2.j.b.d.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
@RequiresApi(21)
public class j extends g {

    public static class a extends MaterialShapeDrawable {
        public a(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public j(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // a2.j.b.d.k.g
    public float d() {
        return this.y.getElevation();
    }

    @Override // a2.j.b.d.k.g
    public void e(@NonNull Rect rect) {
        if (this.z.isCompatPaddingEnabled()) {
            super.e(rect);
        } else if (!u()) {
            int sizeDimension = (this.k - this.y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // a2.j.b.d.k.g
    public void f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        a aVar = new a((ShapeAppearanceModel) Preconditions.checkNotNull(this.a));
        this.b = aVar;
        aVar.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.initializeElevationOverlay(this.y.getContext());
        if (i > 0) {
            Context context = this.y.getContext();
            c cVar = new c((ShapeAppearanceModel) Preconditions.checkNotNull(this.a));
            int color = ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color);
            cVar.i = color;
            cVar.j = color2;
            cVar.k = color3;
            cVar.l = color4;
            float f = (float) i;
            if (cVar.h != f) {
                cVar.h = f;
                cVar.b.setStrokeWidth(f * 1.3333f);
                cVar.n = true;
                cVar.invalidateSelf();
            }
            cVar.b(colorStateList);
            this.d = cVar;
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.d), (Drawable) Preconditions.checkNotNull(this.b)});
        } else {
            this.d = null;
            drawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.c = rippleDrawable;
        this.e = rippleDrawable;
    }

    @Override // a2.j.b.d.k.g
    public void i() {
    }

    @Override // a2.j.b.d.k.g
    public void j() {
        w();
    }

    @Override // a2.j.b.d.k.g
    public void k(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.y.isEnabled()) {
            this.y.setElevation(this.h);
            if (this.y.isPressed()) {
                this.y.setTranslationZ(this.j);
            } else if (this.y.isFocused() || this.y.isHovered()) {
                this.y.setTranslationZ(this.i);
            } else {
                this.y.setTranslationZ(0.0f);
            }
        } else {
            this.y.setElevation(0.0f);
            this.y.setTranslationZ(0.0f);
        }
    }

    @Override // a2.j.b.d.k.g
    public void l(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(g.G, y(f, f3));
            stateListAnimator.addState(g.H, y(f, f2));
            stateListAnimator.addState(g.I, y(f, f2));
            stateListAnimator.addState(g.J, y(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(g.F);
            stateListAnimator.addState(g.K, animatorSet);
            stateListAnimator.addState(g.L, y(0.0f, 0.0f));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (s()) {
            w();
        }
    }

    @Override // a2.j.b.d.k.g
    public boolean o() {
        return false;
    }

    @Override // a2.j.b.d.k.g
    public void q(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    @Override // a2.j.b.d.k.g
    public boolean s() {
        return this.z.isCompatPaddingEnabled() || !u();
    }

    @Override // a2.j.b.d.k.g
    public void v() {
    }

    @NonNull
    public final Animator y(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(g.F);
        return animatorSet;
    }
}
