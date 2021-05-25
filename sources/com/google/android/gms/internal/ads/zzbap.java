package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
public final class zzbap {
    private Context zzaai;
    @GuardedBy("this")
    private final BroadcastReceiver zzecs = new zzbao(this);
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> zzect = new WeakHashMap();
    private boolean zzecu;
    private boolean zzzh = false;

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzect.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }

    public final synchronized void initialize(Context context) {
        if (!this.zzzh) {
            Context applicationContext = context.getApplicationContext();
            this.zzaai = applicationContext;
            if (applicationContext == null) {
                this.zzaai = context;
            }
            zzaat.initialize(this.zzaai);
            this.zzecu = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcrt)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzaai.registerReceiver(this.zzecs, intentFilter);
            this.zzzh = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzecu) {
            this.zzect.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzecu) {
            this.zzect.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
