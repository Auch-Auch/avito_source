package com.avito.android.connection_quality;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.network.connectionclass.ConnectionClassManager;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/connection_quality/SafeConnectionManager;", "Lcom/avito/android/connection_quality/ConnectionManager;", "Lcom/facebook/network/connectionclass/ConnectionClassManager$ConnectionClassStateChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "register", "(Lcom/facebook/network/connectionclass/ConnectionClassManager$ConnectionClassStateChangeListener;)V", ProductAction.ACTION_REMOVE, "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "listeners", "Lcom/facebook/network/connectionclass/ConnectionClassManager;", "connectionClassManager", "<init>", "(Lcom/facebook/network/connectionclass/ConnectionClassManager;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class SafeConnectionManager implements ConnectionManager {
    public final List<ConnectionClassManager.ConnectionClassStateChangeListener> a = new CopyOnWriteArrayList();

    public static final class a implements ConnectionClassManager.ConnectionClassStateChangeListener {
        public final /* synthetic */ SafeConnectionManager a;

        public a(SafeConnectionManager safeConnectionManager) {
            this.a = safeConnectionManager;
        }

        @Override // com.facebook.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
        public final void onBandwidthStateChange(ConnectionQuality connectionQuality) {
            for (ConnectionClassManager.ConnectionClassStateChangeListener connectionClassStateChangeListener : this.a.a) {
                connectionClassStateChangeListener.onBandwidthStateChange(connectionQuality);
            }
        }
    }

    public SafeConnectionManager(@NotNull ConnectionClassManager connectionClassManager) {
        Intrinsics.checkNotNullParameter(connectionClassManager, "connectionClassManager");
        connectionClassManager.register(new a(this));
    }

    @Override // com.avito.android.connection_quality.ConnectionManager
    public void register(@NotNull ConnectionClassManager.ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        Intrinsics.checkNotNullParameter(connectionClassStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.add(connectionClassStateChangeListener);
    }

    @Override // com.avito.android.connection_quality.ConnectionManager
    public void remove(@NotNull ConnectionClassManager.ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        Intrinsics.checkNotNullParameter(connectionClassStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.remove(connectionClassStateChangeListener);
    }
}
