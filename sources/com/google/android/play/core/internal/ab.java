package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.i;
public abstract class ab implements Runnable {
    public final i<?> a;

    public ab() {
        this.a = null;
    }

    public ab(i<?> iVar) {
        this.a = iVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            i<?> iVar = this.a;
            if (iVar != null) {
                iVar.b(e);
            }
        }
    }
}
