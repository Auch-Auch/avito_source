package com.avito.android.cart.summary;

import a2.g.r.g;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0#¢\u0006\u0004\b1\u00102J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/avito/android/cart/summary/ScaleOnHoldTouchListener;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;)V", "Landroid/view/ViewPropertyAnimator;", "c", "Landroid/view/ViewPropertyAnimator;", "animator", "Lkotlin/Pair;", "", "e", "Lkotlin/Pair;", "downCoords", "", g.a, "J", "animationDuration", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "Landroid/view/ViewConfiguration;", "vc", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "view", "h", "scaleDelay", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "onLongClick", "Landroid/os/Handler;", AuthSource.BOOKING_ORDER, "Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "runnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;JJLkotlin/jvm/functions/Function0;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ScaleOnHoldTouchListener implements View.OnTouchListener {
    public final ViewConfiguration a;
    public final Handler b;
    public ViewPropertyAnimator c;
    public WeakReference<View> d;
    public Pair<Float, Float> e;
    public final Runnable f;
    public final long g;
    public final long h;
    public final Function0<Unit> i;

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ScaleOnHoldTouchListener a;

        public b(ScaleOnHoldTouchListener scaleOnHoldTouchListener) {
            this.a = scaleOnHoldTouchListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = (View) ScaleOnHoldTouchListener.access$getView$p(this.a).get();
            if (view != null) {
                ScaleOnHoldTouchListener scaleOnHoldTouchListener = this.a;
                Intrinsics.checkNotNullExpressionValue(view, "it");
                scaleOnHoldTouchListener.a(view);
                this.a.i.invoke();
                view.performHapticFeedback(0);
            }
        }
    }

    public ScaleOnHoldTouchListener(@NotNull Context context, long j, long j2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onLongClick");
        this.g = j;
        this.h = j2;
        this.i = function0;
        this.a = ViewConfiguration.get(context);
        this.b = new Handler();
        this.f = new b(this);
    }

    public static final /* synthetic */ WeakReference access$getView$p(ScaleOnHoldTouchListener scaleOnHoldTouchListener) {
        WeakReference<View> weakReference = scaleOnHoldTouchListener.d;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        return weakReference;
    }

    public final void a(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.c = view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(this.g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r0 != 3) goto L_0x00cc;
     */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(@org.jetbrains.annotations.NotNull android.view.View r8, @org.jetbrains.annotations.NotNull android.view.MotionEvent r9) {
        /*
            r7 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r0 = r9.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x007c
            if (r0 == r1) goto L_0x0071
            r2 = 2
            if (r0 == r2) goto L_0x001b
            r9 = 3
            if (r0 == r9) goto L_0x0071
            goto L_0x00cc
        L_0x001b:
            kotlin.Pair<java.lang.Float, java.lang.Float> r0 = r7.e
            if (r0 != 0) goto L_0x0024
            java.lang.String r3 = "downCoords"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0024:
            java.lang.Object r3 = r0.component1()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r4 = r9.getRawX()
            float r4 = r4 - r3
            double r3 = (double) r4
            double r5 = (double) r2
            double r2 = java.lang.Math.pow(r3, r5)
            float r2 = (float) r2
            float r9 = r9.getRawY()
            float r9 = r9 - r0
            double r3 = (double) r9
            double r3 = java.lang.Math.pow(r3, r5)
            float r9 = (float) r3
            float r2 = r2 + r9
            double r2 = (double) r2
            double r2 = java.lang.Math.sqrt(r2)
            float r9 = (float) r2
            android.view.ViewConfiguration r0 = r7.a
            java.lang.String r2 = "vc"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 < 0) goto L_0x00cc
            android.os.Handler r9 = r7.b
            java.lang.Runnable r0 = r7.f
            r9.removeCallbacks(r0)
            r7.a(r8)
            goto L_0x00cc
        L_0x0071:
            android.os.Handler r9 = r7.b
            java.lang.Runnable r0 = r7.f
            r9.removeCallbacks(r0)
            r7.a(r8)
            goto L_0x00cc
        L_0x007c:
            float r0 = r9.getRawX()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            float r9 = r9.getRawY()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            kotlin.Pair r9 = kotlin.TuplesKt.to(r0, r9)
            r7.e = r9
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r8)
            r7.d = r9
            android.view.ViewPropertyAnimator r9 = r7.c
            if (r9 == 0) goto L_0x00a0
            r9.cancel()
        L_0x00a0:
            android.view.ViewPropertyAnimator r8 = r8.animate()
            r9 = 1064514355(0x3f733333, float:0.95)
            android.view.ViewPropertyAnimator r8 = r8.scaleX(r9)
            android.view.ViewPropertyAnimator r8 = r8.scaleY(r9)
            long r2 = r7.g
            android.view.ViewPropertyAnimator r8 = r8.setDuration(r2)
            long r2 = r7.h
            android.view.ViewPropertyAnimator r8 = r8.setStartDelay(r2)
            r7.c = r8
            android.os.Handler r8 = r7.b
            java.lang.Runnable r9 = r7.f
            int r0 = android.view.ViewConfiguration.getLongPressTimeout()
            long r2 = (long) r0
            long r4 = r7.h
            long r2 = r2 + r4
            r8.postDelayed(r9, r2)
        L_0x00cc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.cart.summary.ScaleOnHoldTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScaleOnHoldTouchListener(Context context, long j, long j2, Function0 function0, int i2, j jVar) {
        this(context, j, (i2 & 4) != 0 ? 250 : j2, (i2 & 8) != 0 ? a.a : function0);
    }
}
