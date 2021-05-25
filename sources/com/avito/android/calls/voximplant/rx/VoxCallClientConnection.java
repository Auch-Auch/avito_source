package com.avito.android.calls.voximplant.rx;

import a2.a.a.z.a.g.e;
import a2.a.a.z.a.g.f;
import a2.a.a.z.a.g.g;
import a2.b.a.a.a;
import com.avito.android.calls.CallClientConnection;
import com.avito.android.calls.voximplant.rx.core.CallClientUtilsKt;
import com.avito.android.calls.voximplant.rx.core.ConnectionState;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.voximplant.sdk.client.ClientState;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.IClientSessionListener;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004RD\u0010\f\u001a0\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0017\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u0006¢\u0006\u0002\b\t0\u0006¢\u0006\u0002\b\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/VoxCallClientConnection;", "Lcom/avito/android/calls/CallClientConnection;", "Lio/reactivex/rxjava3/core/Completable;", "connect", "()Lio/reactivex/rxjava3/core/Completable;", "disconnect", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "Lcom/avito/android/calls/voximplant/rx/core/ConnectionState;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "connectionStateStream", "Lcom/voximplant/sdk/client/IClient;", AuthSource.BOOKING_ORDER, "Lcom/voximplant/sdk/client/IClient;", "client", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "c", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/voximplant/sdk/client/IClient;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClientConnection implements CallClientConnection {
    public final BehaviorRelay<ConnectionState> a = BehaviorRelay.createDefault(ConnectionState.Closed.INSTANCE);
    public final IClient b;
    public final ConnectivityProvider c;
    public final SchedulersFactory3 d;

    public static final class a<T, R> implements Function<ConnectionState, CompletableSource> {
        public final /* synthetic */ VoxCallClientConnection a;

        public a(VoxCallClientConnection voxCallClientConnection) {
            this.a = voxCallClientConnection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(ConnectionState connectionState) {
            ConnectionState connectionState2 = connectionState;
            StringBuilder L = a2.b.a.a.a.L("Trying to connect to vox. Connection state=[");
            L.append(connectionState2.getClass().getSimpleName());
            L.append("], clientState=[");
            L.append(this.a.b.getClientState());
            L.append(']');
            Logs.debug$default(LogTagsKt.TAG_IAC, L.toString(), null, 4, null);
            if (!Intrinsics.areEqual(connectionState2, ConnectionState.Established.INSTANCE)) {
                return VoxCallClientConnection.access$connectToVox(this.a);
            }
            Logs.debug$default(LogTagsKt.TAG_IAC, "Already connected", null, 4, null);
            return Completable.complete();
        }
    }

    public static final class b<T, R> implements Function<ConnectionState, CompletableSource> {
        public final /* synthetic */ VoxCallClientConnection a;

        public b(VoxCallClientConnection voxCallClientConnection) {
            this.a = voxCallClientConnection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(ConnectionState connectionState) {
            if (Intrinsics.areEqual(connectionState, ConnectionState.Closed.INSTANCE)) {
                return Completable.complete();
            }
            return Completable.fromCallable(new f(this));
        }
    }

    public static final class c<T, R> implements Function<Throwable, CompletableSource> {
        public final /* synthetic */ VoxCallClientConnection a;

        public c(VoxCallClientConnection voxCallClientConnection) {
            this.a = voxCallClientConnection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Throwable th) {
            return this.a.a.firstOrError().flatMapCompletable(new g(th));
        }
    }

    @Inject
    public VoxCallClientConnection(@NotNull IClient iClient, @NotNull ConnectivityProvider connectivityProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(iClient, "client");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.b = iClient;
        this.c = connectivityProvider;
        this.d = schedulersFactory3;
        iClient.setClientSessionListener(new IClientSessionListener(this) { // from class: com.avito.android.calls.voximplant.rx.VoxCallClientConnection$sessionListener$1
            public final /* synthetic */ VoxCallClientConnection a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.voximplant.sdk.client.IClientSessionListener
            public void onConnectionClosed() {
                Logs.debug$default(LogTagsKt.TAG_IAC, "Connection: closed", null, 4, null);
                this.a.a.accept(ConnectionState.Closed.INSTANCE);
            }

            @Override // com.voximplant.sdk.client.IClientSessionListener
            public void onConnectionEstablished() {
                Object obj;
                Logs.debug$default(LogTagsKt.TAG_IAC, "Connection: established", null, 4, null);
                if (this.a.b.getClientState() != ClientState.CONNECTED) {
                    StringBuilder L = a.L("Must be Published, but actual=[");
                    L.append(this.a.b.getClientState());
                    L.append(']');
                    obj = new ConnectionState.InternalError(L.toString());
                } else {
                    obj = ConnectionState.Established.INSTANCE;
                }
                this.a.a.accept(obj);
            }

            @Override // com.voximplant.sdk.client.IClientSessionListener
            public void onConnectionFailed(@Nullable String str) {
                Logs.debug$default(LogTagsKt.TAG_IAC, a.d3("Connection: failed, reason=[", str, ']'), null, 4, null);
                BehaviorRelay behaviorRelay = this.a.a;
                if (str == null) {
                    str = "";
                }
                behaviorRelay.accept(new ConnectionState.Failed(str));
            }
        });
    }

    public static final Completable access$connectToVox(VoxCallClientConnection voxCallClientConnection) {
        Completable onErrorResumeNext = InteropKt.toV3(voxCallClientConnection.c.getConnectionAvailability()).first(Boolean.TRUE).flatMapCompletable(a2.a.a.z.a.g.a.a).andThen(Completable.fromAction(new a2.a.a.z.a.g.b(voxCallClientConnection))).andThen(voxCallClientConnection.a.ofType(ConnectionState.Established.class).firstOrError().ignoreElement().timeout(5000, TimeUnit.MILLISECONDS)).doOnComplete(a2.a.a.z.a.g.c.a).onErrorResumeNext(new e(voxCallClientConnection));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "connectivityProvider.con…          }\n            }");
        return onErrorResumeNext;
    }

    @Override // com.avito.android.calls.CallClientConnection
    @NotNull
    public Completable connect() {
        Completable retryWhen = this.a.firstOrError().flatMapCompletable(new a(this)).retryWhen(CallClientUtilsKt.exponentialRetryCallRequest$default(this.d.computation(), null, 2, null));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "connectionStateStream\n  …putation())\n            )");
        return retryWhen;
    }

    @Override // com.avito.android.calls.CallClientConnection
    @NotNull
    public Completable disconnect() {
        Completable onErrorResumeNext = this.a.firstOrError().flatMapCompletable(new b(this)).andThen(this.a.ofType(ConnectionState.Closed.class).firstOrError().ignoreElement().timeout(5000, TimeUnit.MILLISECONDS)).onErrorResumeNext(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "connectionStateStream\n  …          }\n            }");
        return onErrorResumeNext;
    }
}
