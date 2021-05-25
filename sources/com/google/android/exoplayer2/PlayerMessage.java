package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import java.util.concurrent.TimeoutException;
public final class PlayerMessage {
    public final Target a;
    public final Sender b;
    public final Timeline c;
    public int d;
    @Nullable
    public Object e;
    public Handler f;
    public int g;
    public long h = C.TIME_UNSET;
    public boolean i = true;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i2, Handler handler) {
        this.b = sender;
        this.a = target;
        this.c = timeline;
        this.f = handler;
        this.g = i2;
    }

    @VisibleForTesting
    public synchronized boolean a(long j2, Clock clock) throws InterruptedException, TimeoutException {
        boolean z;
        Assertions.checkState(this.j);
        Assertions.checkState(this.f.getLooper().getThread() != Thread.currentThread());
        long elapsedRealtime = clock.elapsedRealtime() + j2;
        while (true) {
            z = this.l;
            if (z || j2 <= 0) {
                break;
            }
            wait(j2);
            j2 = elapsedRealtime - clock.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.k;
    }

    public synchronized boolean blockUntilDelivered() throws InterruptedException {
        Assertions.checkState(this.j);
        Assertions.checkState(this.f.getLooper().getThread() != Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.k;
    }

    public synchronized PlayerMessage cancel() {
        Assertions.checkState(this.j);
        this.m = true;
        markAsProcessed(false);
        return this;
    }

    public synchronized boolean experimentalBlockUntilDelivered(long j2) throws InterruptedException, TimeoutException {
        return a(j2, Clock.DEFAULT);
    }

    public boolean getDeleteAfterDelivery() {
        return this.i;
    }

    public Handler getHandler() {
        return this.f;
    }

    @Nullable
    public Object getPayload() {
        return this.e;
    }

    public long getPositionMs() {
        return this.h;
    }

    public Target getTarget() {
        return this.a;
    }

    public Timeline getTimeline() {
        return this.c;
    }

    public int getType() {
        return this.d;
    }

    public int getWindowIndex() {
        return this.g;
    }

    public synchronized boolean isCanceled() {
        return this.m;
    }

    public synchronized void markAsProcessed(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.j);
        if (this.h == C.TIME_UNSET) {
            Assertions.checkArgument(this.i);
        }
        this.j = true;
        this.b.sendMessage(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.j);
        this.i = z;
        return this;
    }

    public PlayerMessage setHandler(Handler handler) {
        Assertions.checkState(!this.j);
        this.f = handler;
        return this;
    }

    public PlayerMessage setPayload(@Nullable Object obj) {
        Assertions.checkState(!this.j);
        this.e = obj;
        return this;
    }

    public PlayerMessage setPosition(long j2) {
        Assertions.checkState(!this.j);
        this.h = j2;
        return this;
    }

    public PlayerMessage setType(int i2) {
        Assertions.checkState(!this.j);
        this.d = i2;
        return this;
    }

    public PlayerMessage setPosition(int i2, long j2) {
        boolean z = true;
        Assertions.checkState(!this.j);
        if (j2 == C.TIME_UNSET) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (i2 < 0 || (!this.c.isEmpty() && i2 >= this.c.getWindowCount())) {
            throw new IllegalSeekPositionException(this.c, i2, j2);
        }
        this.g = i2;
        this.h = j2;
        return this;
    }
}
