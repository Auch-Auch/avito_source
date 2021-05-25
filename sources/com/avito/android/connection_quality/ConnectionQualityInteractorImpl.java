package com.avito.android.connection_quality;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.facebook.network.connectionclass.ConnectionClassManager;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010#¨\u0006*"}, d2 = {"Lcom/avito/android/connection_quality/ConnectionQualityInteractorImpl;", "Lcom/avito/android/connection_quality/ConnectionQualityInteractor;", "Landroid/net/NetworkInfo;", "networkInfo", "", "onNetworkInfoChanged", "(Landroid/net/NetworkInfo;)V", "Lcom/facebook/network/connectionclass/ConnectionQuality;", "connectionQuality", "onBandwidthStateChange", "(Lcom/facebook/network/connectionclass/ConnectionQuality;)V", "c", "()V", "Lcom/avito/android/connection_quality/ConnectionQuality;", AuthSource.SEND_ABUSE, "(Landroid/net/NetworkInfo;)Lcom/avito/android/connection_quality/ConnectionQuality;", AuthSource.BOOKING_ORDER, "(Lcom/facebook/network/connectionclass/ConnectionQuality;)Lcom/avito/android/connection_quality/ConnectionQuality;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "relay", "Lcom/facebook/network/connectionclass/ConnectionClassManager;", "e", "Lcom/facebook/network/connectionclass/ConnectionClassManager;", "connectionManager", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getConnectionQualityStream", "()Lio/reactivex/Observable;", "connectionQualityStream", "getCurrentConnectionQuality", "()Lcom/avito/android/connection_quality/ConnectionQuality;", "currentConnectionQuality", "Lcom/avito/android/connection_quality/ConnectionQuality;", "coarseConnectionQuality", "accurateConnectionQuality", "Landroid/net/ConnectivityManager;", "connectivityManager", "<init>", "(Landroid/net/ConnectivityManager;Lcom/facebook/network/connectionclass/ConnectionClassManager;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public final class ConnectionQualityInteractorImpl implements ConnectionQualityInteractor {
    public final BehaviorRelay<ConnectionQuality> a;
    public ConnectionQuality b;
    public ConnectionQuality c;
    @NotNull
    public final Observable<ConnectionQuality> d;
    public final ConnectionClassManager e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ConnectionQuality.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[4] = 1;
            ConnectionQuality.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
            iArr2[3] = 4;
            iArr2[4] = 5;
        }
    }

    public ConnectionQualityInteractorImpl(@NotNull ConnectivityManager connectivityManager, @NotNull ConnectionClassManager connectionClassManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        Intrinsics.checkNotNullParameter(connectionClassManager, "connectionManager");
        this.e = connectionClassManager;
        BehaviorRelay<ConnectionQuality> create = BehaviorRelay.create();
        this.a = create;
        ConnectionQuality currentBandwidthQuality = connectionClassManager.getCurrentBandwidthQuality();
        Intrinsics.checkNotNullExpressionValue(currentBandwidthQuality, "connectionManager.currentBandwidthQuality");
        this.b = b(currentBandwidthQuality);
        this.c = a(connectivityManager.getActiveNetworkInfo());
        c();
        Intrinsics.checkNotNullExpressionValue(create, "relay");
        this.d = create;
    }

    public final ConnectionQuality a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return ConnectionQuality.UNKNOWN;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return ConnectionQuality.POOR;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return ConnectionQuality.GOOD;
                case 13:
                    return ConnectionQuality.EXCELLENT;
                default:
                    return ConnectionQuality.UNKNOWN;
            }
        } else if (type == 1 || type == 6) {
            return ConnectionQuality.EXCELLENT;
        } else {
            return ConnectionQuality.UNKNOWN;
        }
    }

    public final ConnectionQuality b(ConnectionQuality connectionQuality) {
        int ordinal = connectionQuality.ordinal();
        if (ordinal == 0) {
            return ConnectionQuality.POOR;
        }
        if (ordinal == 1) {
            return ConnectionQuality.MODERATE;
        }
        if (ordinal == 2) {
            return ConnectionQuality.GOOD;
        }
        if (ordinal == 3) {
            return ConnectionQuality.EXCELLENT;
        }
        if (ordinal == 4) {
            return ConnectionQuality.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void c() {
        ConnectionQuality connectionQuality;
        if (this.b.ordinal() != 4) {
            connectionQuality = this.b;
        } else {
            connectionQuality = this.c;
        }
        BehaviorRelay<ConnectionQuality> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "relay");
        if (connectionQuality != behaviorRelay.getValue()) {
            Logs.info$default("ConnectionQuality", "New quality = " + connectionQuality + ", " + this.e.getDownloadKBitsPerSecond() + " kbps", null, 4, null);
            this.a.accept(connectionQuality);
        }
    }

    @Override // com.avito.android.connection_quality.ConnectionQualityProvider
    @NotNull
    public Observable<ConnectionQuality> getConnectionQualityStream() {
        return this.d;
    }

    @Override // com.avito.android.connection_quality.ConnectionQualityProvider
    @NotNull
    public ConnectionQuality getCurrentConnectionQuality() {
        BehaviorRelay<ConnectionQuality> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "relay");
        ConnectionQuality value = behaviorRelay.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "relay.value");
        return value;
    }

    @Override // com.facebook.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
    public void onBandwidthStateChange(@NotNull ConnectionQuality connectionQuality) {
        Intrinsics.checkNotNullParameter(connectionQuality, "connectionQuality");
        this.b = b(connectionQuality);
        c();
    }

    @Override // com.avito.android.connection_quality.NetworkInfoChangeListener
    public void onNetworkInfoChanged(@Nullable NetworkInfo networkInfo) {
        ConnectionQuality a3 = a(networkInfo);
        if (this.c != a3) {
            this.c = a3;
            this.b = ConnectionQuality.UNKNOWN;
            this.e.reset();
            c();
        }
    }
}
