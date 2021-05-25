package com.avito.android.connection_quality;

import android.content.IntentFilter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroid/content/IntentFilter;", "createNetworkInfoBroadcastReceiverIntentFilter", "()Landroid/content/IntentFilter;", "connection-quality_release"}, k = 2, mv = {1, 4, 2})
public final class NetworkInfoBroadcastReceiverKt {
    @NotNull
    public static final IntentFilter createNetworkInfoBroadcastReceiverIntentFilter() {
        return new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION);
    }
}
