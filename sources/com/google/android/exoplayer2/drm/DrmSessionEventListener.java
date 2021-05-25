package com.google.android.exoplayer2.drm;

import a2.j.b.b.t0.b;
import a2.j.b.b.t0.c;
import a2.j.b.b.t0.d;
import a2.j.b.b.t0.e;
import a2.j.b.b.t0.f;
import a2.j.b.b.t0.g;
import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public interface DrmSessionEventListener {
    void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    public static class EventDispatcher {
        public final CopyOnWriteArrayList<a> a;
        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public static final class a {
            public Handler a;
            public DrmSessionEventListener b;

            public a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.a = handler;
                this.b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this.a = new CopyOnWriteArrayList<>();
            this.windowIndex = 0;
            this.mediaPeriodId = null;
        }

        public void addEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(drmSessionEventListener);
            this.a.add(new a(handler, drmSessionEventListener));
        }

        public void drmKeysLoaded() {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new e(this, next.b));
            }
        }

        public void drmKeysRemoved() {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new d(this, next.b));
            }
        }

        public void drmKeysRestored() {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new f(this, next.b));
            }
        }

        public void drmSessionAcquired() {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new b(this, next.b));
            }
        }

        public void drmSessionManagerError(Exception exc) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new g(this, next.b, exc));
            }
        }

        public void drmSessionReleased() {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Util.postOrRun(next.a, new c(this, next.b));
            }
        }

        public void removeEventListener(DrmSessionEventListener drmSessionEventListener) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.b == drmSessionEventListener) {
                    this.a.remove(next);
                }
            }
        }

        @CheckResult
        public EventDispatcher withParameters(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId2) {
            return new EventDispatcher(this.a, i, mediaPeriodId2);
        }

        public EventDispatcher(CopyOnWriteArrayList<a> copyOnWriteArrayList, int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId2) {
            this.a = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId2;
        }
    }
}
