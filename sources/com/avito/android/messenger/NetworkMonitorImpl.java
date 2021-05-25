package com.avito.android.messenger;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.NetworkMonitor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/NetworkMonitorImpl;", "Lru/avito/messenger/NetworkMonitor;", "", "isNetworkAvailable", "()Z", "Lio/reactivex/Observable;", "networkAvailability", "()Lio/reactivex/Observable;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkMonitorImpl implements NetworkMonitor {
    public final ConnectivityProvider a;

    public NetworkMonitorImpl(@NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.a = connectivityProvider;
    }

    @Override // ru.avito.messenger.NetworkMonitor
    public boolean isNetworkAvailable() {
        return this.a.isConnectionAvailable();
    }

    @Override // ru.avito.messenger.NetworkMonitor
    @NotNull
    public Observable<Boolean> networkAvailability() {
        return this.a.getConnectionAvailability();
    }
}
