package com.avito.android.connection_quality;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.network.connectionclass.ConnectionClassManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/connection_quality/ConnectionQualitySubscriberImpl;", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "", "subscribe", "()V", "unsubscribe", "Lcom/avito/android/connection_quality/ConnectionManager;", AuthSource.SEND_ABUSE, "Lcom/avito/android/connection_quality/ConnectionManager;", "connectionClassManager", "Lcom/facebook/network/connectionclass/ConnectionClassManager$ConnectionClassStateChangeListener;", AuthSource.BOOKING_ORDER, "Lcom/facebook/network/connectionclass/ConnectionClassManager$ConnectionClassStateChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/connection_quality/ConnectionManager;Lcom/facebook/network/connectionclass/ConnectionClassManager$ConnectionClassStateChangeListener;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class ConnectionQualitySubscriberImpl implements ConnectionQualitySubscriber {
    public final ConnectionManager a;
    public final ConnectionClassManager.ConnectionClassStateChangeListener b;

    public ConnectionQualitySubscriberImpl(@NotNull ConnectionManager connectionManager, @NotNull ConnectionClassManager.ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        Intrinsics.checkNotNullParameter(connectionManager, "connectionClassManager");
        Intrinsics.checkNotNullParameter(connectionClassStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = connectionManager;
        this.b = connectionClassStateChangeListener;
    }

    @Override // com.avito.android.connection_quality.ConnectionQualitySubscriber
    public void subscribe() {
        this.a.register(this.b);
    }

    @Override // com.avito.android.connection_quality.ConnectionQualitySubscriber
    public void unsubscribe() {
        this.a.remove(this.b);
    }
}
