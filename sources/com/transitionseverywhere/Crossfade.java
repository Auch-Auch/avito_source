package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;
@TargetApi(18)
public class Crossfade extends Transition {
    public static final int FADE_BEHAVIOR_CROSSFADE = 0;
    public static final int FADE_BEHAVIOR_OUT_IN = 2;
    public static final int FADE_BEHAVIOR_REVEAL = 1;
    public static RectEvaluator L = null;
    public static final int RESIZE_BEHAVIOR_NONE = 0;
    public static final int RESIZE_BEHAVIOR_SCALE = 1;
    public int J = 1;
    public int K = 1;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ BitmapDrawable b;

        public a(Crossfade crossfade, View view, BitmapDrawable bitmapDrawable) {
            this.a = view;
            this.b = bitmapDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate(this.b.getBounds());
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BitmapDrawable c;
        public final /* synthetic */ BitmapDrawable d;

        public b(boolean z, View view, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
            this.a = z;
            this.b = view;
            this.c = bitmapDrawable;
            this.d = bitmapDrawable2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewOverlay overlay = this.a ? ((ViewGroup) this.b.getParent()).getOverlay() : this.b.getOverlay();
            overlay.remove(this.c);
            if (Crossfade.this.J == 1) {
                overlay.remove(this.d);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (!(transitionValues == null || transitionValues2 == null)) {
            if (L == null) {
                L = new RectEvaluator();
            }
            boolean z = this.J != 1;
            View view = transitionValues2.view;
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            Rect rect = (Rect) map.get("android:crossfade:bounds");
            Rect rect2 = (Rect) map2.get("android:crossfade:bounds");
            if (!(rect == null || rect2 == null)) {
                Bitmap bitmap = (Bitmap) map.get("android:crossfade:bitmap");
                Bitmap bitmap2 = (Bitmap) map2.get("android:crossfade:bitmap");
                BitmapDrawable bitmapDrawable = (BitmapDrawable) map.get("android:crossfade:drawable");
                BitmapDrawable bitmapDrawable2 = (BitmapDrawable) map2.get("android:crossfade:drawable");
                if (!(bitmapDrawable == null || bitmapDrawable2 == null || bitmap.sameAs(bitmap2))) {
                    ViewOverlay overlay = z ? ((ViewGroup) view.getParent()).getOverlay() : view.getOverlay();
                    if (this.J == 1) {
                        overlay.add(bitmapDrawable2);
                    }
                    overlay.add(bitmapDrawable);
                    if (this.J == 2) {
                        objectAnimator = ObjectAnimator.ofInt(bitmapDrawable, "alpha", 255, 0, 0);
                    } else {
                        objectAnimator = ObjectAnimator.ofInt(bitmapDrawable, "alpha", 0);
                    }
                    objectAnimator.addUpdateListener(new a(this, view, bitmapDrawable));
                    int i = this.J;
                    if (i == 2) {
                        objectAnimator2 = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 0.0f, 1.0f);
                    } else if (i == 0) {
                        objectAnimator2 = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
                    }
                    objectAnimator.addListener(new b(z, view, bitmapDrawable, bitmapDrawable2));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimator);
                    if (objectAnimator2 != null) {
                        animatorSet.playTogether(objectAnimator2);
                    }
                    if (this.K == 1 && !rect.equals(rect2)) {
                        animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable, "bounds", L, rect, rect2));
                        if (this.K == 1) {
                            animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable2, "bounds", L, rect, rect2));
                        }
                    }
                    return animatorSet;
                }
            }
        }
        return null;
    }

    public int getFadeBehavior() {
        return this.J;
    }

    public int getResizeBehavior() {
        return this.K;
    }

    public final void o(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
            if (this.J != 1) {
                rect.offset(view.getLeft(), view.getTop());
            }
            transitionValues.values.put("android:crossfade:bounds", rect);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            if (view instanceof TextureView) {
                createBitmap = ((TextureView) view).getBitmap();
            } else {
                view.draw(new Canvas(createBitmap));
            }
            transitionValues.values.put("android:crossfade:bitmap", createBitmap);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), createBitmap);
            bitmapDrawable.setBounds(rect);
            transitionValues.values.put("android:crossfade:drawable", bitmapDrawable);
        }
    }

    @NonNull
    public Crossfade setFadeBehavior(int i) {
        if (i >= 0 && i <= 2) {
            this.J = i;
        }
        return this;
    }

    @NonNull
    public Crossfade setResizeBehavior(int i) {
        if (i >= 0 && i <= 1) {
            this.K = i;
        }
        return this;
    }
}
