package com.avito.android.component.timer;

import android.os.CountDownTimer;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/component/timer/Counter;", "", "Lcom/avito/android/component/timer/TimeWidget;", "widget", "", Tracker.Events.CREATIVE_START, "(Lcom/avito/android/component/timer/TimeWidget;)V", "stop", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/component/timer/TimeWidget;", "", "c", "J", "endDate", "Landroid/os/CountDownTimer;", AuthSource.BOOKING_ORDER, "Landroid/os/CountDownTimer;", "timer", "<init>", "(J)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class Counter {
    public TimeWidget a;
    public CountDownTimer b;
    public final long c;

    public Counter(long j) {
        this.c = j;
    }

    public static final void access$showCurrentTime(Counter counter, long j, TimeWidget timeWidget) {
        Objects.requireNonNull(counter);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j);
        long millis = j - TimeUnit.HOURS.toMillis(hours);
        long minutes = timeUnit.toMinutes(millis);
        long seconds = timeUnit.toSeconds(millis - TimeUnit.MINUTES.toMillis(minutes));
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        timeWidget.setHours(format);
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(this, *args)");
        timeWidget.setMinutes(format2);
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(seconds)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(this, *args)");
        timeWidget.setSeconds(format3);
    }

    public final void start(@NotNull TimeWidget timeWidget) {
        Intrinsics.checkNotNullParameter(timeWidget, "widget");
        this.a = timeWidget;
        if (this.b == null) {
            long time = this.c - new Date().getTime();
            Counter$createTimer$1 counter$createTimer$1 = new CountDownTimer(time, time, 1000) { // from class: com.avito.android.component.timer.Counter$createTimer$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TimeWidget timeWidget2 = Counter.this.a;
                    if (timeWidget2 != null) {
                        Counter.access$showCurrentTime(Counter.this, 0, timeWidget2);
                        timeWidget2.onFinish();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    TimeWidget timeWidget2 = Counter.this.a;
                    if (timeWidget2 != null) {
                        Counter.access$showCurrentTime(Counter.this, j, timeWidget2);
                    }
                }
            };
            counter$createTimer$1.start();
            this.b = counter$createTimer$1;
        }
    }

    public final void stop() {
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.b = null;
        this.a = null;
    }
}
