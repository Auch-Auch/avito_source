package eu.davidea.fastscroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
public class BubbleAnimator {
    public boolean a;
    public ObjectAnimator animator;
    public View bubble;
    public long durationInMillis;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            BubbleAnimator bubbleAnimator = BubbleAnimator.this;
            bubbleAnimator.onShowAnimationStop(bubbleAnimator.bubble);
            BubbleAnimator.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BubbleAnimator bubbleAnimator = BubbleAnimator.this;
            bubbleAnimator.onShowAnimationStop(bubbleAnimator.bubble);
            BubbleAnimator.this.a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            BubbleAnimator bubbleAnimator = BubbleAnimator.this;
            bubbleAnimator.onHideAnimationStop(bubbleAnimator.bubble);
            BubbleAnimator.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BubbleAnimator bubbleAnimator = BubbleAnimator.this;
            bubbleAnimator.onHideAnimationStop(bubbleAnimator.bubble);
            BubbleAnimator.this.a = false;
        }
    }

    public BubbleAnimator(View view, long j) {
        this.bubble = view;
        this.durationInMillis = j;
    }

    public ObjectAnimator createHideAnimator(View view) {
        return ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(this.durationInMillis);
    }

    public ObjectAnimator createShowAnimator(View view) {
        return ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(this.durationInMillis);
    }

    public void hideBubble() {
        if (this.bubble != null) {
            if (this.a) {
                this.animator.cancel();
            }
            ObjectAnimator createHideAnimator = createHideAnimator(this.bubble);
            this.animator = createHideAnimator;
            createHideAnimator.addListener(new b());
            this.animator.start();
            this.a = true;
        }
    }

    public void onHideAnimationStop(View view) {
        view.setVisibility(4);
    }

    public void onShowAnimationStop(View view) {
    }

    public void showBubble() {
        if (this.bubble != null) {
            if (this.a) {
                this.animator.cancel();
            }
            if (this.bubble.getVisibility() != 0) {
                this.bubble.setVisibility(0);
                if (this.a) {
                    this.animator.cancel();
                }
                ObjectAnimator createShowAnimator = createShowAnimator(this.bubble);
                this.animator = createShowAnimator;
                createShowAnimator.addListener(new a());
                this.animator.start();
                this.a = true;
            }
        }
    }
}
