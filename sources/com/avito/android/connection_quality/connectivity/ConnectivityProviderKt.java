package com.avito.android.connection_quality.connectivity;

import android.net.NetworkInfo;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"connection-quality_release"}, k = 2, mv = {1, 4, 2})
public final class ConnectivityProviderKt {
    public static final boolean access$isConnected$p(Connectivity connectivity) {
        return connectivity.state() == NetworkInfo.State.CONNECTED;
    }
}
