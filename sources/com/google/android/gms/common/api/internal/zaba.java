package com.google.android.gms.common.api.internal;
public abstract class zaba {
    private final zaay zaa;

    public zaba(zaay zaay) {
        this.zaa = zaay;
    }

    public abstract void zaa();

    public final void zaa(zaax zaax) {
        zaax.zaf.lock();
        try {
            if (zaax.zan == this.zaa) {
                zaa();
                zaax.zaf.unlock();
            }
        } finally {
            zaax.zaf.unlock();
        }
    }
}
