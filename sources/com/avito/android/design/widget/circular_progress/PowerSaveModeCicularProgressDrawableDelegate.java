package com.avito.android.design.widget.circular_progress;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0018\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/PowerSaveModeCicularProgressDrawableDelegate;", "Lcom/avito/android/design/widget/circular_progress/CircularProgrssDrawableDelegate;", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V", Tracker.Events.CREATIVE_START, "()V", "stop", "Lkotlin/Function1;", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "endListener", "progressiveStop", "(Lkotlin/jvm/functions/Function1;)V", "c", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "parent", "", AuthSource.SEND_ABUSE, "I", "currentRotation", "com/avito/android/design/widget/circular_progress/PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/circular_progress/PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1;", "mRunnable", "<init>", "(Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PowerSaveModeCicularProgressDrawableDelegate implements CircularProgrssDrawableDelegate {
    public int a;
    public final PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1 b = new PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1(this);
    public final CircularProgressDrawable c;

    public PowerSaveModeCicularProgressDrawableDelegate(@NotNull CircularProgressDrawable circularProgressDrawable) {
        Intrinsics.checkNotNullParameter(circularProgressDrawable, "parent");
        this.c = circularProgressDrawable;
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawArc(this.c.getDrawableBounds(), (float) this.a, 300.0f, false, paint);
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void progressiveStop(@NotNull Function1<? super CircularProgressDrawable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "endListener");
        this.c.stop();
        function1.invoke(this.c);
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void start() {
        this.c.invalidate();
        this.c.scheduleSelf(this.b, SystemClock.uptimeMillis() + 1000);
    }

    @Override // com.avito.android.design.widget.circular_progress.CircularProgrssDrawableDelegate
    public void stop() {
        this.c.unscheduleSelf(this.b);
    }
}
