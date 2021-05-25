package com.avito.android.calls.voximplant;

import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.voximplant.sdk.client.IClientSessionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"com/avito/android/calls/voximplant/VoxCallClient$sessionListener$1", "Lcom/voximplant/sdk/client/IClientSessionListener;", "", "onConnectionEstablished", "()V", "", "error", "onConnectionFailed", "(Ljava/lang/String;)V", "onConnectionClosed", AuthSource.SEND_ABUSE, "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClient$sessionListener$1 implements IClientSessionListener {
    public final /* synthetic */ VoxCallClient a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VoxCallClient$sessionListener$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VoxCallClient$sessionListener$1 voxCallClient$sessionListener$1) {
            super(0);
            this.a = voxCallClient$sessionListener$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.a.c > 0) {
                VoxCallClient voxCallClient = this.a.a;
                voxCallClient.c = voxCallClient.c - 1;
                try {
                    this.a.a.i.connect();
                } catch (Exception e) {
                    VoxCallClient voxCallClient2 = this.a.a;
                    Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Reconnect request failed", e);
                    this.a.a.disconnect(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public VoxCallClient$sessionListener$1(VoxCallClient voxCallClient) {
        this.a = voxCallClient;
    }

    public final void a() {
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Reconnecting...", null, 4, null);
        VoxCallClient.access$scheduleWithDelay(this.a, 3, new a(this));
    }

    @Override // com.voximplant.sdk.client.IClientSessionListener
    public void onConnectionClosed() {
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Connection closed"), null);
        ConnectionListener connectionListener = this.a.g;
        if (connectionListener != null) {
            connectionListener.onClientDisconnected(ConnectionListener.DisconnectReason.CONNECTION_CLOSED);
        }
        if (this.a.c > 0) {
            a();
        } else {
            VoxCallClient.access$setCurrentCommand$p(this.a, VoxCallClient.Command.DISCONNECT);
        }
    }

    @Override // com.voximplant.sdk.client.IClientSessionListener
    public void onConnectionEstablished() {
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Connection established"), null);
        VoxCallClient.access$performLogin(this.a);
    }

    @Override // com.voximplant.sdk.client.IClientSessionListener
    public void onConnectionFailed(@Nullable String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a2.b.a.a.a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" Connection failed: ");
        sb.append(str);
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, sb.toString(), null);
        ConnectionListener connectionListener = this.a.g;
        if (connectionListener != null) {
            connectionListener.onClientDisconnected(ConnectionListener.DisconnectReason.CONNECTION_FAILED);
        }
        if (this.a.c > 0) {
            a();
        } else {
            VoxCallClient.access$setCurrentCommand$p(this.a, VoxCallClient.Command.DISCONNECT);
        }
    }
}
