package com.avito.android.connection_quality;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "Lcom/avito/android/connection_quality/NetworkInfoChangeListener;", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "listeners", "Landroid/net/ConnectivityManager;", AuthSource.SEND_ABUSE, "Landroid/net/ConnectivityManager;", "connectivityManager", "<init>", "(Ljava/util/Set;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkInfoBroadcastReceiver extends BroadcastReceiver {
    public ConnectivityManager a;
    public final Set<NetworkInfoChangeListener> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends com.avito.android.connection_quality.NetworkInfoChangeListener> */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkInfoBroadcastReceiver(@NotNull Set<? extends NetworkInfoChangeListener> set) {
        Intrinsics.checkNotNullParameter(set, "listeners");
        this.b = set;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), NetworkChangeReceiver.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = this.a;
            if (connectivityManager == null) {
                Object systemService = context.getSystemService("connectivity");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                connectivityManager = (ConnectivityManager) systemService;
                this.a = connectivityManager;
            }
            for (NetworkInfoChangeListener networkInfoChangeListener : this.b) {
                networkInfoChangeListener.onNetworkInfoChanged(connectivityManager.getActiveNetworkInfo());
            }
        }
    }
}
