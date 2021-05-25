package eu.davidea.fastscroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
public class ScrollbarAnimator {
    public boolean a;
    public View bar;
    public long delayInMillis;
    public long durationInMillis;
    public View handle;
    public AnimatorSet scrollbarAnimatorSet;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            ScrollbarAnimator scrollbarAnimator = ScrollbarAnimator.this;
            scrollbarAnimator.onShowAnimationStop(scrollbarAnimator.bar, scrollbarAnimator.handle);
            ScrollbarAnimator.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ScrollbarAnimator scrollbarAnimator = ScrollbarAnimator.this;
            scrollbarAnimator.onShowAnimationStop(scrollbarAnimator.bar, scrollbarAnimator.handle);
            ScrollbarAnimator.this.a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            ScrollbarAnimator scrollbarAnimator = ScrollbarAnimator.this;
            scrollbarAnimator.onHideAnimationStop(scrollbarAnimator.bar, scrollbarAnimator.handle);
            ScrollbarAnimator.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ScrollbarAnimator scrollbarAnimator = ScrollbarAnimator.this;
            scrollbarAnimator.onHideAnimationStop(scrollbarAnimator.bar, scrollbarAnimator.handle);
            ScrollbarAnimator.this.a = false;
        }
    }

    public ScrollbarAnimator(View view, View view2, long j, long j2) {
        this.bar = view;
        this.handle = view2;
        this.delayInMillis = j;
        this.durationInMillis = j2;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000e: APUT  (r1v0 float[]), (0 ??[int, short, byte, char]), (r3v0 float) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0020: APUT  (r1v1 float[]), (0 ??[int, short, byte, char]), (r2v1 float) */
    public AnimatorSet createAnimator(View view, View view2, boolean z) {
        float[] fArr = new float[1];
        float f = 0.0f;
        fArr[0] = z ? 0.0f : (float) view.getWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", fArr);
        float[] fArr2 = new float[1];
        if (!z) {
            f = (float) view2.getWidth();
        }
        fArr2[0] = f;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationX", fArr2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(this.durationInMillis);
        if (!z) {
            animatorSet.setStartDelay(this.delayInMillis);
        }
        return animatorSet;
    }

    public void hideScrollbar() {
        if (this.bar != null && this.handle != null) {
            if (this.a) {
                this.scrollbarAnimatorSet.cancel();
            }
            AnimatorSet createAnimator = createAnimator(this.bar, this.handle, false);
            this.scrollbarAnimatorSet = createAnimator;
            createAnimator.addListener(new b());
            this.scrollbarAnimatorSet.start();
            this.a = true;
        }
    }

    public boolean isAnimating() {
        return this.a;
    }

    public void onHideAnimationStop(View view, View view2) {
        view.setVisibility(4);
        view2.setVisibility(4);
        view.setTranslationX(0.0f);
        view2.setTranslationX(0.0f);
    }

    public void onShowAnimationStop(View view, View view2) {
    }

    public void setDelayInMillis(long j) {
        this.delayInMillis = j;
    }

    public void showScrollbar() {
        if (this.bar != null && this.handle != null) {
            if (this.a) {
                this.scrollbarAnimatorSet.cancel();
            }
            if (this.bar.getVisibility() == 4 || this.handle.getVisibility() == 4) {
                this.bar.setVisibility(0);
                this.handle.setVisibility(0);
                AnimatorSet createAnimator = createAnimator(this.bar, this.handle, true);
                this.scrollbarAnimatorSet = createAnimator;
                createAnimator.addListener(new a());
                this.scrollbarAnimatorSet.start();
                this.a = true;
            }
        }
    }
}
