package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    public final ArrayList<b> a = new ArrayList<>();
    @Nullable
    public b b = null;
    @Nullable
    public ValueAnimator c = null;
    public final Animator.AnimatorListener d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.c == animator) {
                stateListAnimator.c = null;
            }
        }
    }

    public static class b {
        public final int[] a;
        public final ValueAnimator b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.a.add(bVar);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = null;
        }
    }

    public void setState(int[] iArr) {
        b bVar;
        ValueAnimator valueAnimator;
        int size = this.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.a.get(i);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            }
            i++;
        }
        b bVar2 = this.b;
        if (bVar != bVar2) {
            if (!(bVar2 == null || (valueAnimator = this.c) == null)) {
                valueAnimator.cancel();
                this.c = null;
            }
            this.b = bVar;
            if (bVar != null) {
                ValueAnimator valueAnimator2 = bVar.b;
                this.c = valueAnimator2;
                valueAnimator2.start();
            }
        }
    }
}
