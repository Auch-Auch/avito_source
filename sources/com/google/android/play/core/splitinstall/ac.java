package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.listener.b;
public final class ac extends b<SplitInstallSessionState> {
    public static ac i;
    public final Handler g = new Handler(Looper.getMainLooper());
    public final c h;

    public ac(Context context, c cVar) {
        super(new aa("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.h = cVar;
    }

    public static synchronized ac a(Context context) {
        ac acVar;
        synchronized (ac.class) {
            if (i == null) {
                i = new ac(context, w.a);
            }
            acVar = i;
        }
        return acVar;
    }

    @Override // com.google.android.play.core.listener.b
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a = SplitInstallSessionState.a(bundleExtra);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            d a3 = this.h.a();
            if (a.status() == 3 && a3 != null) {
                a3.a(a.d(), new a2.j.b.e.a.i.b(this, a, intent, context));
            } else {
                a((ac) a);
            }
        }
    }
}
