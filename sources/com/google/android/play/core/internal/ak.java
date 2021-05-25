package com.google.android.play.core.internal;

import a2.j.b.e.a.d.c;
import a2.j.b.e.a.d.d;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.af;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.tasks.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ak<T extends IInterface> {
    public static final Map<String, Handler> l = new HashMap();
    public final Context a;
    public final aa b;
    public final String c;
    public final List<ab> d = new ArrayList();
    public boolean e;
    public final Intent f;
    public final ag<T> g;
    public final WeakReference<af> h;
    public final IBinder.DeathRecipient i = new IBinder.DeathRecipient(this) { // from class: a2.j.b.e.a.d.b
        public final ak a;

        {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ak akVar = this.a;
            akVar.b.c("reportBinderDeath", new Object[0]);
            af afVar = akVar.h.get();
            if (afVar == null) {
                akVar.b.c("%s : Binder has died.", akVar.c);
                List<ab> list = akVar.d;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i<?> iVar = list.get(i2).a;
                    if (iVar != null) {
                        iVar.b((Exception) new RemoteException(String.valueOf(akVar.c).concat(" : Binder has died.")));
                    }
                }
                akVar.d.clear();
                return;
            }
            akVar.b.c("calling onBinderDied", new Object[0]);
            afVar.a();
        }
    };
    public ServiceConnection j;
    public T k;

    public ak(Context context, aa aaVar, String str, Intent intent, ag<T> agVar) {
        this.a = context;
        this.b = aaVar;
        this.c = str;
        this.f = intent;
        this.g = agVar;
        this.h = new WeakReference<>(null);
    }

    public final void a() {
        c(new d(this));
    }

    public final void a(ab abVar) {
        c(new c(this, abVar.a, abVar));
    }

    public final T b() {
        return this.k;
    }

    public final void c(ab abVar) {
        Handler handler;
        Map<String, Handler> map = l;
        synchronized (map) {
            if (!map.containsKey(this.c)) {
                HandlerThread handlerThread = new HandlerThread(this.c, 10);
                handlerThread.start();
                map.put(this.c, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.c);
        }
        handler.post(abVar);
    }
}
