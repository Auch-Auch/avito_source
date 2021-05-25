package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.DropAnimationValue;
import java.util.Iterator;
import java.util.Objects;
public class DropAnimation extends BaseAnimation<AnimatorSet> {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public DropAnimationValue f = new DropAnimationValue();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropAnimation dropAnimation = DropAnimation.this;
            b bVar = this.a;
            Objects.requireNonNull(dropAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int ordinal = bVar.ordinal();
            if (ordinal == 0) {
                dropAnimation.f.setWidth(intValue);
            } else if (ordinal == 1) {
                dropAnimation.f.setHeight(intValue);
            } else if (ordinal == 2) {
                dropAnimation.f.setRadius(intValue);
            }
            ValueController.UpdateListener updateListener = dropAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(dropAnimation.f);
            }
        }
    }

    public enum b {
        Width,
        Height,
        Radius
    }

    public DropAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    public final ValueAnimator a(int i, int i2, long j, b bVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new a(bVar));
        return ofInt;
    }

    public DropAnimation with(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.a == i && this.b == i2 && this.c == i3 && this.d == i4 && this.e == i5) {
            z = false;
        }
        if (z) {
            this.animator = createAnimator();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            int i6 = (int) (((double) i5) / 1.5d);
            long j = this.animationDuration;
            long j2 = j / 2;
            ValueAnimator a3 = a(i, i2, j, b.Width);
            b bVar = b.Height;
            ValueAnimator a4 = a(i3, i4, j2, bVar);
            b bVar2 = b.Radius;
            ValueAnimator a5 = a(i5, i6, j2, bVar2);
            ValueAnimator a6 = a(i4, i3, j2, bVar);
            ((AnimatorSet) this.animator).play(a4).with(a5).with(a3).before(a6).before(a(i6, i5, j2, bVar2));
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public DropAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public DropAnimation progress(float f2) {
        T t = this.animator;
        if (t != null) {
            long j = (long) (f2 * ((float) this.animationDuration));
            boolean z = false;
            Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                long duration = valueAnimator.getDuration();
                long j2 = z ? j - duration : j;
                if (j2 >= 0) {
                    if (j2 >= duration) {
                        j2 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j2);
                    }
                    if (!z && duration >= this.animationDuration) {
                        z = true;
                    }
                }
            }
        }
        return this;
    }
}
