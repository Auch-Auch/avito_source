package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    public static final String h = Logger.tagWithPrefix("NetworkStateTracker");
    public final ConnectivityManager e = ((ConnectivityManager) this.mAppContext.getSystemService("connectivity"));
    @RequiresApi(24)
    public b f;
    public a g;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals(NetworkChangeReceiver.CONNECTIVITY_ACTION)) {
                Logger.get().debug(NetworkStateTracker.h, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.setState(networkStateTracker.a());
            }
        }
    }

    @RequiresApi(24)
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            Logger.get().debug(NetworkStateTracker.h, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.a());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            Logger.get().debug(NetworkStateTracker.h, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.a());
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (b()) {
            this.f = new b();
        } else {
            this.g = new a();
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public NetworkState a() {
        NetworkCapabilities networkCapabilities;
        NetworkInfo activeNetworkInfo = this.e.getActiveNetworkInfo();
        boolean z = true;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean z3 = Build.VERSION.SDK_INT >= 23 && (networkCapabilities = this.e.getNetworkCapabilities(this.e.getActiveNetwork())) != null && networkCapabilities.hasCapability(16);
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.e);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z = false;
        }
        return new NetworkState(z2, z3, isActiveNetworkMetered, z);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        if (b()) {
            try {
                Logger.get().debug(h, "Registering network callback", new Throwable[0]);
                this.e.registerDefaultNetworkCallback(this.f);
            } catch (IllegalArgumentException | SecurityException e2) {
                Logger.get().error(h, "Received exception while registering network callback", e2);
            }
        } else {
            Logger.get().debug(h, "Registering broadcast receiver", new Throwable[0]);
            this.mAppContext.registerReceiver(this.g, new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION));
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        if (b()) {
            try {
                Logger.get().debug(h, "Unregistering network callback", new Throwable[0]);
                this.e.unregisterNetworkCallback(this.f);
            } catch (IllegalArgumentException | SecurityException e2) {
                Logger.get().error(h, "Received exception while unregistering network callback", e2);
            }
        } else {
            Logger.get().debug(h, "Unregistering broadcast receiver", new Throwable[0]);
            this.mAppContext.unregisterReceiver(this.g);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return a();
    }
}
