package a2.d.a.e;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public final class c implements ConnectivityMonitor {
    public final Context a;
    public final ConnectivityMonitor.ConnectivityListener b;
    public boolean c;
    public boolean d;
    public final BroadcastReceiver e = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            c cVar = c.this;
            boolean z = cVar.c;
            cVar.c = cVar.a(context);
            if (z != c.this.c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    boolean z2 = c.this.c;
                }
                c cVar2 = c.this;
                cVar2.b.onConnectivityChanged(cVar2.c);
            }
        }
    }

    public c(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.a = context.getApplicationContext();
        this.b = connectivityListener;
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        if (!this.d) {
            this.c = a(this.a);
            try {
                this.a.registerReceiver(this.e, new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION));
                this.d = true;
            } catch (SecurityException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        if (this.d) {
            this.a.unregisterReceiver(this.e);
            this.d = false;
        }
    }
}
