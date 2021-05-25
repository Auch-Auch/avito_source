package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public final class RequirementsWatcher {
    public final Context a;
    public final Listener b;
    public final Requirements c;
    public final Handler d = Util.createHandlerForCurrentOrMainLooper();
    @Nullable
    public b e;
    public int f;
    @Nullable
    public c g;

    public interface Listener {
        void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i);
    }

    public class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher requirementsWatcher = RequirementsWatcher.this;
                int notMetRequirements = requirementsWatcher.c.getNotMetRequirements(requirementsWatcher.a);
                if (requirementsWatcher.f != notMetRequirements) {
                    requirementsWatcher.f = notMetRequirements;
                    requirementsWatcher.b.onRequirementsStateChanged(requirementsWatcher, notMetRequirements);
                }
            }
        }
    }

    @RequiresApi(24)
    public final class c extends ConnectivityManager.NetworkCallback {
        public boolean a;
        public boolean b;

        public c(a aVar) {
        }

        public final void a() {
            RequirementsWatcher.this.d.post(new a2.j.b.b.y0.a(this));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            if (!z) {
                RequirementsWatcher.this.d.post(new a2.j.b.b.y0.b(this));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.a || this.b != hasCapability) {
                this.a = true;
                this.b = hasCapability;
                a();
            } else if (hasCapability) {
                RequirementsWatcher.this.d.post(new a2.j.b.b.y0.b(this));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            a();
        }
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.a = context.getApplicationContext();
        this.b = listener;
        this.c = requirements;
    }

    public Requirements getRequirements() {
        return this.c;
    }

    public int start() {
        this.f = this.c.getNotMetRequirements(this.a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.c.isNetworkRequired()) {
            if (Util.SDK_INT >= 24) {
                c cVar = new c(null);
                this.g = cVar;
                ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) this.a.getSystemService("connectivity"))).registerDefaultNetworkCallback(cVar);
            } else {
                intentFilter.addAction(NetworkChangeReceiver.CONNECTIVITY_ACTION);
            }
        }
        if (this.c.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.c.isIdleRequired()) {
            if (Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.c.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b(null);
        this.e = bVar;
        this.a.registerReceiver(bVar, intentFilter, null, this.d);
        return this.f;
    }

    public void stop() {
        this.a.unregisterReceiver((BroadcastReceiver) Assertions.checkNotNull(this.e));
        this.e = null;
        if (Util.SDK_INT >= 24 && this.g != null) {
            ((ConnectivityManager) Assertions.checkNotNull((ConnectivityManager) this.a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.checkNotNull(this.g));
            this.g = null;
        }
    }
}
