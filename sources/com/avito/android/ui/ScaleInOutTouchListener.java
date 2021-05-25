package com.avito.android.ui;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0012¨\u0006'"}, d2 = {"Lcom/avito/android/ui/ScaleInOutTouchListener;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "invokeCallback", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Z)V", "Lkotlin/Function0;", g.a, "Lkotlin/jvm/functions/Function0;", "clickCallback", "c", "Z", "isCanceled", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "currentAnimator", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "viewRect", "", "f", "I", "clickPadding", "", "e", "J", "animationDuration", AuthSource.BOOKING_ORDER, "playBack", "<init>", "(JILkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ScaleInOutTouchListener implements View.OnTouchListener {
    public AnimatorSet a;
    public boolean b;
    public boolean c;
    public Rect d;
    public final long e;
    public final int f;
    public final Function0<Unit> g;

    public ScaleInOutTouchListener(long j, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "clickCallback");
        this.e = j;
        this.f = i;
        this.g = function0;
        this.d = new Rect();
    }

    public final void a(View view, boolean z) {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setInterpolator(new DecelerateInterpolator());
        animatorSet2.setDuration(this.e);
        animatorSet2.addListener(new AnimatorListenerAdapter(this, z, view) { // from class: com.avito.android.ui.ScaleInOutTouchListener$playScaleOutAnimation$$inlined$apply$lambda$1
            public final /* synthetic */ ScaleInOutTouchListener a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ View c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animator) {
                this.a.a = null;
                this.a.b = false;
                if (this.b && !(this.a.c)) {
                    this.a.g.invoke();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animator) {
                this.a.a = null;
                this.a.b = false;
                if (this.b && !(this.a.c)) {
                    this.a.g.invoke();
                }
            }
        });
        animatorSet2.play(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f)).with(ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        animatorSet2.start();
        Unit unit = Unit.INSTANCE;
        this.a = animatorSet2;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        view.getDrawingRect(this.d);
        Rect rect = this.d;
        int i = this.f;
        boolean contains = new Rect(rect.left - i, rect.top - i, rect.right + i, rect.bottom + i).contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!contains && !this.c) {
            this.c = true;
            AnimatorSet animatorSet = this.a;
            if (animatorSet == null || !animatorSet.isStarted()) {
                a(view, false);
            } else {
                this.b = true;
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            AnimatorSet animatorSet2 = this.a;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return true;
            }
            AnimatorSet animatorSet3 = this.a;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.setInterpolator(new DecelerateInterpolator());
            animatorSet4.setDuration(this.e);
            animatorSet4.addListener(new AnimatorListenerAdapter(view) { // from class: com.avito.android.ui.ScaleInOutTouchListener$playScaleInAnimation$$inlined$apply$lambda$1
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@Nullable Animator animator) {
                    ScaleInOutTouchListener.this.a = null;
                    if (ScaleInOutTouchListener.this.b) {
                        ScaleInOutTouchListener.this.a(this.b, true);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@Nullable Animator animator) {
                    ScaleInOutTouchListener.this.a = null;
                    if (ScaleInOutTouchListener.this.b) {
                        ScaleInOutTouchListener.this.a(this.b, true);
                    }
                }
            });
            animatorSet4.play(ObjectAnimator.ofFloat(view, View.SCALE_X, 0.8f)).with(ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.8f));
            animatorSet4.start();
            this.a = animatorSet4;
        } else if (action == 1) {
            if (this.c) {
                this.c = false;
                return true;
            }
            AnimatorSet animatorSet5 = this.a;
            if (animatorSet5 == null || !animatorSet5.isStarted()) {
                a(view, contains);
            } else {
                this.b = true;
            }
        }
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScaleInOutTouchListener(long j, int i, Function0 function0, int i2, j jVar) {
        this((i2 & 1) != 0 ? 200 : j, (i2 & 2) != 0 ? 10 : i, function0);
    }
}
