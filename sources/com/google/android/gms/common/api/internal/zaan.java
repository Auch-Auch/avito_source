package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
public abstract class zaan implements Runnable {
    private final /* synthetic */ zaad zaa;

    private zaan(zaad zaad) {
        this.zaa = zaad;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        this.zaa.zab.lock();
        try {
            if (!Thread.interrupted()) {
                zaa();
                this.zaa.zab.unlock();
            }
        } catch (RuntimeException e) {
            this.zaa.zaa.zaa(e);
        } finally {
            this.zaa.zab.unlock();
        }
    }

    @WorkerThread
    public abstract void zaa();

    public /* synthetic */ zaan(zaad zaad, zaag zaag) {
        this(zaad);
    }
}
