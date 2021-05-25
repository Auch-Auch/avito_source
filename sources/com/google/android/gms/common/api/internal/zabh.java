package com.google.android.gms.common.api.internal;
public final class zabh implements Runnable {
    private final /* synthetic */ zabf zaa;

    public zabh(zabf zabf) {
        this.zaa = zabf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zaa.zac.disconnect(this.zaa.zaa.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
