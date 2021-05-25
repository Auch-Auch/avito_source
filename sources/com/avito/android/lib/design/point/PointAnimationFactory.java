package com.avito.android.lib.design.point;

import a2.a.a.k1.a.g.a;
import a2.a.a.k1.a.g.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;
import com.avito.android.util.AnimationUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/point/PointAnimationFactory;", "", "", "duration", "delay", "", "repeatCount", "Lkotlin/Function1;", "", "", "updateListener", "Landroid/animation/Animator;", "createAnimator", "(JJILkotlin/jvm/functions/Function1;)Landroid/animation/Animator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PointAnimationFactory {
    @NotNull
    public final Animator createAnimator(long j, long j2, int i, @NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "updateListener");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            long j3 = j / ((long) 2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "this");
            ofFloat.setDuration(j3);
            ofFloat.setInterpolator(new PathInterpolator(0.71f, -0.46f, 0.88f, 0.6f));
            ofFloat.addUpdateListener(new a(j3, function1));
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(1f…)\n            }\n        }");
            ofFloat.setStartDelay(i2 > 0 ? j : 0);
            arrayList.add(ofFloat);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "this");
            ofFloat2.setDuration(j3);
            ofFloat2.setInterpolator(new PathInterpolator(0.12f, 0.4f, 0.29f, 1.46f));
            ofFloat2.addUpdateListener(new b(j3, function1));
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ValueAnimator.ofFloat(0f…)\n            }\n        }");
            arrayList.add(ofFloat2);
            i2++;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        animatorSet.addListener(new AnimationUtils.SimpleAnimatorListener(booleanRef, function1, arrayList, animatorSet, j, j2) { // from class: com.avito.android.lib.design.point.PointAnimationFactory$createAnimator$1
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ List c;
            public final /* synthetic */ AnimatorSet d;
            public final /* synthetic */ long e;
            public final /* synthetic */ long f;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r7;
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                this.a.element = true;
                this.b.invoke(Float.valueOf(0.0f));
                ((Animator) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.c)).setDuration(0);
                this.d.setStartDelay(0);
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                if (!this.a.element) {
                    ((Animator) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.c)).setDuration(this.e / ((long) 2));
                    this.d.setStartDelay(this.f);
                    this.d.start();
                }
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                this.a.element = false;
            }
        });
        return animatorSet;
    }
}
