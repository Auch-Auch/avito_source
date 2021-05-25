package com.facebook.drawee.components;

import a2.g.m.a.a;
import javax.annotation.Nullable;
public abstract class DeferredReleaser {
    @Nullable
    public static DeferredReleaser a;

    public interface Releasable {
        void release();
    }

    public static synchronized DeferredReleaser getInstance() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (a == null) {
                a = new a();
            }
            deferredReleaser = a;
        }
        return deferredReleaser;
    }

    public abstract void cancelDeferredRelease(Releasable releasable);

    public abstract void scheduleDeferredRelease(Releasable releasable);
}
