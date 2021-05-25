package com.avito.android.calls;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/ConnectionListener;", "", "", "onClientConnected", "()V", "Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "reason", "onClientDisconnected", "(Lcom/avito/android/calls/ConnectionListener$DisconnectReason;)V", "DisconnectReason", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface ConnectionListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/calls/ConnectionListener$DisconnectReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION_FAILED", "CONNECTION_CLOSED", "LOGIN_FAILED", "calls_release"}, k = 1, mv = {1, 4, 2})
    public enum DisconnectReason {
        CONNECTION_FAILED,
        CONNECTION_CLOSED,
        LOGIN_FAILED
    }

    void onClientConnected();

    void onClientDisconnected(@NotNull DisconnectReason disconnectReason);
}
