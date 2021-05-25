package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    public int a;
    @Px
    public int b = -1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        public a(View view, float f) {
            this.a = view;
            this.b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setTranslationX(this.b);
        }
    }

    public static class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        public b(View view, float f) {
            this.a = view;
            this.b = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setTranslationY(this.b);
        }
    }

    public SlideDistanceProvider(int i) {
        this.a = i;
    }

    public static Animator a(View view, float f, float f2, float f3) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f, f2));
        ofPropertyValuesHolder.addListener(new a(view, f3));
        return ofPropertyValuesHolder;
    }

    public static Animator b(View view, float f, float f2, float f3) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f, f2));
        ofPropertyValuesHolder.addListener(new b(view, f3));
        return ofPropertyValuesHolder;
    }

    public static boolean c(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        int i = this.a;
        Context context = view.getContext();
        int i2 = this.b;
        if (i2 == -1) {
            i2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
        }
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (i == 3) {
            return a(view, ((float) i2) + translationX, translationX, translationX);
        }
        if (i == 5) {
            return a(view, translationX - ((float) i2), translationX, translationX);
        }
        if (i == 48) {
            return b(view, translationY - ((float) i2), translationY, translationY);
        }
        if (i == 80) {
            return b(view, ((float) i2) + translationY, translationY, translationY);
        }
        if (i == 8388611) {
            return a(view, c(viewGroup) ? ((float) i2) + translationX : translationX - ((float) i2), translationX, translationX);
        } else if (i == 8388613) {
            return a(view, c(viewGroup) ? translationX - ((float) i2) : ((float) i2) + translationX, translationX, translationX);
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Invalid slide direction: ", i));
        }
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        int i = this.a;
        Context context = view.getContext();
        int i2 = this.b;
        if (i2 == -1) {
            i2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
        }
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (i == 3) {
            return a(view, translationX, translationX - ((float) i2), translationX);
        }
        if (i == 5) {
            return a(view, translationX, ((float) i2) + translationX, translationX);
        }
        if (i == 48) {
            return b(view, translationY, ((float) i2) + translationY, translationY);
        }
        if (i == 80) {
            return b(view, translationY, translationY - ((float) i2), translationY);
        }
        if (i == 8388611) {
            return a(view, translationX, c(viewGroup) ? translationX - ((float) i2) : ((float) i2) + translationX, translationX);
        } else if (i == 8388613) {
            return a(view, translationX, c(viewGroup) ? ((float) i2) + translationX : translationX - ((float) i2), translationX);
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Invalid slide direction: ", i));
        }
    }

    @Px
    public int getSlideDistance() {
        return this.b;
    }

    public int getSlideEdge() {
        return this.a;
    }

    public void setSlideDistance(@Px int i) {
        if (i >= 0) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i) {
        this.a = i;
    }
}
