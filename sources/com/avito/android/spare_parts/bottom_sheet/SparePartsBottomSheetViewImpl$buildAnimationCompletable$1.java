package com.avito.android.spare_parts.bottom_sheet;

import android.animation.Animator;
import android.animation.ValueAnimator;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
public final class SparePartsBottomSheetViewImpl$buildAnimationCompletable$1 implements CompletableOnSubscribe {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Function1 d;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SparePartsBottomSheetViewImpl$buildAnimationCompletable$1 a;
        public final /* synthetic */ CompletableEmitter b;

        public a(SparePartsBottomSheetViewImpl$buildAnimationCompletable$1 sparePartsBottomSheetViewImpl$buildAnimationCompletable$1, CompletableEmitter completableEmitter) {
            this.a = sparePartsBottomSheetViewImpl$buildAnimationCompletable$1;
            this.b = completableEmitter;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.d.invoke((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float"));
        }
    }

    public SparePartsBottomSheetViewImpl$buildAnimationCompletable$1(float f, float f2, long j, Function1 function1) {
        this.a = f;
        this.b = f2;
        this.c = j;
        this.d = function1;
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter completableEmitter) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.a, this.b);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "this");
        ofFloat.setDuration(this.c);
        ofFloat.addUpdateListener(new a(this, completableEmitter));
        ofFloat.addListener(new Animator.AnimatorListener(this, completableEmitter) { // from class: com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetViewImpl$buildAnimationCompletable$1$$special$$inlined$apply$lambda$2
            public final /* synthetic */ CompletableEmitter a;

            {
                this.a = r2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animator) {
                this.a.onComplete();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
            }
        });
        ofFloat.start();
    }
}
