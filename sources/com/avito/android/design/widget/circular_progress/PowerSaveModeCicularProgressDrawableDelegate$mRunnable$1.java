package com.avito.android.design.widget.circular_progress;

import android.os.SystemClock;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/avito/android/design/widget/circular_progress/PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1", "Ljava/lang/Runnable;", "", "run", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1 implements Runnable {
    public final /* synthetic */ PowerSaveModeCicularProgressDrawableDelegate a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PowerSaveModeCicularProgressDrawableDelegate$mRunnable$1(PowerSaveModeCicularProgressDrawableDelegate powerSaveModeCicularProgressDrawableDelegate) {
        this.a = powerSaveModeCicularProgressDrawableDelegate;
    }

    @Override // java.lang.Runnable
    public void run() {
        PowerSaveModeCicularProgressDrawableDelegate powerSaveModeCicularProgressDrawableDelegate = this.a;
        powerSaveModeCicularProgressDrawableDelegate.a = powerSaveModeCicularProgressDrawableDelegate.a + 50;
        PowerSaveModeCicularProgressDrawableDelegate powerSaveModeCicularProgressDrawableDelegate2 = this.a;
        powerSaveModeCicularProgressDrawableDelegate2.a = powerSaveModeCicularProgressDrawableDelegate2.a % 360;
        if (this.a.c.isRunning()) {
            this.a.c.scheduleSelf(this, SystemClock.uptimeMillis() + 1000);
        }
        this.a.c.invalidate();
    }
}
