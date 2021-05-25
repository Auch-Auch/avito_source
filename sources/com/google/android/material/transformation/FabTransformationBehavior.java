package com.google.android.material.transformation;

import a2.j.b.d.u.b;
import a2.j.b.d.u.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public static class FabTransformationSpec {
        public Positioning positioning;
        @Nullable
        public MotionSpec timings;
    }

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                this.b.setVisibility(4);
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @NonNull
    public final Pair<MotionTiming, MotionTiming> b(float f2, float f3, boolean z, @NonNull FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        int i;
        if (f2 == 0.0f || f3 == 0.0f) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || i <= 0)) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        return new Pair<>(motionTiming2, motionTiming);
    }

    public final float c(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f2;
        float f3;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        f(view, rectF);
        rectF.offset(this.g, this.h);
        f(view2, rectF2);
        float f4 = 0.0f;
        int i = positioning.gravity & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                f3 = rectF2.right;
                f2 = rectF.right;
            }
            return f4 + positioning.xAdjustment;
        } else {
            f3 = rectF2.left;
            f2 = rectF.left;
        }
        f4 = f3 - f2;
        return f4 + positioning.xAdjustment;
    }

    public final float d(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float f2;
        float f3;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        f(view, rectF);
        rectF.offset(this.g, this.h);
        f(view2, rectF2);
        float f4 = 0.0f;
        int i = positioning.gravity & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                f3 = rectF2.bottom;
                f2 = rectF.bottom;
            }
            return f4 + positioning.yAdjustment;
        } else {
            f3 = rectF2.top;
            f2 = rectF.top;
        }
        f4 = f3 - f2;
        return f4 + positioning.yAdjustment;
    }

    public final float e(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f2, float f3) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        long delay2 = timing.getDelay();
        return AnimationUtils.lerp(f2, f3, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDuration() + delay2) + 17) - delay)) / ((float) duration)));
    }

    public final void f(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void g(View view, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            if (!(view instanceof CircularRevealWidget) || CircularRevealHelper.STRATEGY != 0) {
                View findViewById = view.findViewById(R.id.mtrl_child_content_container);
                if (findViewById != null) {
                    viewGroup = k(findViewById);
                } else if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
                    viewGroup = k(((ViewGroup) view).getChildAt(0));
                } else {
                    viewGroup = k(view);
                }
                if (viewGroup != null) {
                    if (z) {
                        if (!z2) {
                            ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf(0.0f));
                        }
                        objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
                    } else {
                        objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
                    }
                    fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                    list.add(objectAnimator);
                }
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    public final void h(@NonNull View view, View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i);
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, colorForState);
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming("color").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;)V */
    @TargetApi(21)
    public final void i(View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List list) {
        ObjectAnimator objectAnimator;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/view/View;Landroid/view/View;ZZLcom/google/android/material/transformation/FabTransformationBehavior$FabTransformationSpec;Ljava/util/List<Landroid/animation/Animator;>;Ljava/util/List<Landroid/animation/Animator$AnimatorListener;>;Landroid/graphics/RectF;)V */
    public final void j(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List list, @NonNull RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float c2 = c(view, view2, fabTransformationSpec.positioning);
        float d2 = d(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> b = b(c2, d2, z, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) b.first;
        MotionTiming motionTiming2 = (MotionTiming) b.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-c2);
                view2.setTranslationY(-d2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float e2 = e(fabTransformationSpec, motionTiming, -c2, 0.0f);
            float e3 = e(fabTransformationSpec, motionTiming2, -d2, 0.0f);
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.d;
            rectF2.set(rect);
            RectF rectF3 = this.e;
            f(view2, rectF3);
            rectF3.offset(e2, e3);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -c2);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -d2);
        }
        motionTiming.apply(objectAnimator2);
        motionTiming2.apply(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    @Nullable
    public final ViewGroup k(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0075: APUT  (r15v1 float[]), (0 ??[int, short, byte, char]), (r0v5 float) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0084: APUT  (r15v2 float[]), (0 ??[int, short, byte, char]), (r1v4 float) */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        FabTransformationSpec fabTransformationSpec;
        MotionTiming motionTiming;
        Animator animator;
        ObjectAnimator objectAnimator;
        FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        i(view, view2, z, z2, onCreateMotionSpec, arrayList);
        RectF rectF = this.d;
        j(view, view2, z, z2, onCreateMotionSpec, arrayList, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float c2 = c(view, view2, onCreateMotionSpec.positioning);
        float d2 = d(view, view2, onCreateMotionSpec.positioning);
        Pair<MotionTiming, MotionTiming> b = b(c2, d2, z, onCreateMotionSpec);
        MotionTiming motionTiming2 = (MotionTiming) b.first;
        MotionTiming motionTiming3 = (MotionTiming) b.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            c2 = this.g;
        }
        fArr[0] = c2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            d2 = this.h;
        }
        fArr2[0] = d2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming2.apply(ofFloat);
        motionTiming3.apply(ofFloat2);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        boolean z3 = view2 instanceof CircularRevealWidget;
        if (z3 && (view instanceof ImageView)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
                }
                objectAnimator.addUpdateListener(new a2.j.b.d.u.a(this, view2));
                onCreateMotionSpec.timings.getTiming("iconFade").apply(objectAnimator);
                arrayList.add(objectAnimator);
                arrayList2.add(new b(this, circularRevealWidget, drawable));
            }
        }
        if (!z3) {
            fabTransformationSpec = onCreateMotionSpec;
        } else {
            CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view2;
            Positioning positioning = onCreateMotionSpec.positioning;
            RectF rectF2 = this.d;
            RectF rectF3 = this.e;
            f(view, rectF2);
            rectF2.offset(this.g, this.h);
            f(view2, rectF3);
            rectF3.offset(-c(view, view2, positioning), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            Positioning positioning2 = onCreateMotionSpec.positioning;
            RectF rectF4 = this.d;
            RectF rectF5 = this.e;
            f(view, rectF4);
            rectF4.offset(this.g, this.h);
            f(view2, rectF5);
            rectF5.offset(0.0f, -d(view, view2, positioning2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).getContentRect(this.c);
            float width2 = ((float) this.c.width()) / 2.0f;
            MotionTiming timing = onCreateMotionSpec.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget2.setRevealInfo(new CircularRevealWidget.RevealInfo(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = circularRevealWidget2.getRevealInfo().radius;
                }
                animator = CircularRevealCompat.createCircularReveal(circularRevealWidget2, centerX, centerY, MathUtils.distanceToFurthestCorner(centerX, centerY, 0.0f, 0.0f, width, height));
                animator.addListener(new c(this, circularRevealWidget2));
                long delay = timing.getDelay();
                int i = (int) centerX;
                int i2 = (int) centerY;
                if (delay > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i, i2, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(delay);
                    arrayList.add(createCircularReveal);
                }
                motionTiming = timing;
                fabTransformationSpec = onCreateMotionSpec;
            } else {
                float f2 = circularRevealWidget2.getRevealInfo().radius;
                Animator createCircularReveal2 = CircularRevealCompat.createCircularReveal(circularRevealWidget2, centerX, centerY, width2);
                long delay2 = timing.getDelay();
                int i3 = (int) centerX;
                int i4 = (int) centerY;
                if (delay2 > 0) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i3, i4, f2, f2);
                    createCircularReveal3.setStartDelay(0);
                    createCircularReveal3.setDuration(delay2);
                    arrayList.add(createCircularReveal3);
                }
                long delay3 = timing.getDelay();
                long duration = timing.getDuration();
                fabTransformationSpec = onCreateMotionSpec;
                long totalDuration = fabTransformationSpec.timings.getTotalDuration();
                long j = delay3 + duration;
                if (j < totalDuration) {
                    Animator createCircularReveal4 = ViewAnimationUtils.createCircularReveal(view2, i3, i4, width2, width2);
                    createCircularReveal4.setStartDelay(j);
                    createCircularReveal4.setDuration(totalDuration - j);
                    arrayList.add(createCircularReveal4);
                }
                animator = createCircularReveal2;
                motionTiming = timing;
            }
            motionTiming.apply(animator);
            arrayList.add(animator);
            arrayList2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget2));
        }
        h(view, view2, z, z2, fabTransformationSpec, arrayList);
        g(view2, z, z2, fabTransformationSpec, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i5 = 0; i5 < size; i5++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i5));
        }
        return animatorSet;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
