package com.yandex.mobile.ads.impl;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import java.util.WeakHashMap;
public final class ah extends BroadcastReceiver {
    private static volatile ah d;
    private static final Object e = new Object();
    private boolean a = false;
    private int b = a.c;
    private WeakHashMap<b, Object> c = new WeakHashMap<>();

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};
    }

    public interface b {
        void a(@NonNull Intent intent);
    }

    private ah() {
    }

    public static ah a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new ah();
                }
            }
        }
        return d;
    }

    private synchronized boolean c(Context context) {
        return ((PowerManager) context.getSystemService("power")).isInteractive();
    }

    public final synchronized void b(b bVar, Context context) {
        if (context != null) {
            this.c.remove(bVar);
            try {
                if (this.a && this.c.isEmpty()) {
                    context.getApplicationContext().unregisterReceiver(this);
                    this.a = false;
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        if (intent != null) {
            intent.getAction();
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.b = a.b;
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.b = a.c;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.b = a.a;
            }
            a(intent);
        }
    }

    private synchronized boolean b(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
    }

    public final synchronized void a(b bVar, Context context) {
        if (context != null) {
            try {
                this.c.put(bVar, null);
                if (!this.a) {
                    Context applicationContext = context.getApplicationContext();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                    applicationContext.registerReceiver(this, intentFilter);
                    this.a = true;
                }
                return;
            } catch (Exception unused) {
                b(bVar, context);
            }
        }
        return;
    }

    private synchronized void a(@NonNull Intent intent) {
        for (b bVar : this.c.keySet()) {
            bVar.a(intent);
        }
    }

    public final synchronized boolean a(Context context) {
        boolean c2 = c(context);
        fz a3 = fy.a().a(context);
        if (a3 != null && a3.k()) {
            return c2;
        }
        return c2 && !b(context);
    }
}
