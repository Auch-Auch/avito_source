package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {
            public final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();

            public static final class a {
                public final Handler a;
                public final EventListener b;
                public boolean c;

                public a(Handler handler, EventListener eventListener) {
                    this.a = handler;
                    this.b = eventListener;
                }
            }

            public void addListener(Handler handler, EventListener eventListener) {
                Assertions.checkNotNull(handler);
                Assertions.checkNotNull(eventListener);
                removeListener(eventListener);
                this.a.add(new a(handler, eventListener));
            }

            public void bandwidthSample(int i, long j, long j2) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (!next.c) {
                        next.a.post(new a2.j.b.b.d1.a(next, i, j, j2));
                    }
                }
            }

            public void removeListener(EventListener eventListener) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b == eventListener) {
                        next.c = true;
                        this.a.remove(next);
                    }
                }
            }
        }

        void onBandwidthSample(int i, long j, long j2);
    }

    void addEventListener(Handler handler, EventListener eventListener);

    long getBitrateEstimate();

    @Nullable
    TransferListener getTransferListener();

    void removeEventListener(EventListener eventListener);
}
