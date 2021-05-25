package ru.avito.websocket;

import a2.b.a.a.a;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.avito.reporter.WebSocketReporter;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"ru/avito/websocket/LegacyRxWebSocketImpl$createWebSocketListener$1", "Lokhttp3/WebSocketListener;", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", CommonKt.EXTRA_RESPONSE, "", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "", "code", "reason", "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class LegacyRxWebSocketImpl$createWebSocketListener$1 extends WebSocketListener {
    public final /* synthetic */ LegacyRxWebSocketImpl a;
    public final /* synthetic */ SingleEmitter b;

    public LegacyRxWebSocketImpl$createWebSocketListener$1(LegacyRxWebSocketImpl legacyRxWebSocketImpl, SingleEmitter singleEmitter) {
        this.a = legacyRxWebSocketImpl;
        this.b = singleEmitter;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        if (this.a.e == webSocket) {
            Function1 function1 = this.a.j;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke("WS: on closed: " + i + ", " + str);
            }
            WebSocketReporter webSocketReporter = this.a.k;
            if (webSocketReporter != null) {
                webSocketReporter.onClose();
                return;
            }
            return;
        }
        webSocket.cancel();
        Function1 function12 = this.a.j;
        if (function12 != null) {
            Unit unit2 = (Unit) function12.invoke("WS: on closed event ignored");
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        if (this.a.e == null || this.a.e == webSocket) {
            Function1 function1 = this.a.j;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke("WS: on closing: " + i + ", " + str);
            }
            synchronized (this.a.a) {
                WebSocket webSocket2 = this.a.e;
                if (webSocket2 != null) {
                    webSocket2.cancel();
                }
                this.a.e = null;
                this.a.d.onNext(new RxWebSocketState.Disconnected(i, str, null, 4, null));
                Disposable disposable = this.a.g;
                if (disposable != null) {
                    disposable.dispose();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            return;
        }
        webSocket.cancel();
        Function1 function12 = this.a.j;
        if (function12 != null) {
            Unit unit3 = (Unit) function12.invoke("WS: on closing event ignored");
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
        ResponseBody body;
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(th, "t");
        if (this.a.e == null || this.a.e == webSocket) {
            Function2 function2 = this.a.l;
            String str = null;
            if (function2 != null) {
                StringBuilder L = a.L("WS: on failure: response.body = ");
                L.append((response == null || (body = response.body()) == null) ? null : body.string());
                Unit unit = (Unit) function2.invoke(L.toString(), th);
            }
            WebSocketReporter webSocketReporter = this.a.k;
            if (webSocketReporter != null) {
                webSocketReporter.onError(th.toString());
            }
            synchronized (this.a.a) {
                this.a.e = null;
                if (!(this.a.c.getValue() instanceof RxWebSocketState.Disconnected)) {
                    Subject subject = this.a.d;
                    int code = response != null ? response.code() : -1;
                    if (response != null) {
                        str = response.message();
                    }
                    subject.onNext(new RxWebSocketState.Disconnected(code, str, th));
                }
                if (!this.b.isDisposed()) {
                    this.b.onError(th);
                }
                Disposable disposable = this.a.g;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
            return;
        }
        webSocket.cancel();
        Function1 function1 = this.a.j;
        if (function1 != null) {
            Unit unit2 = (Unit) function1.invoke("WS: on failure event ignored");
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        if (webSocket == this.a.e) {
            Function1 function1 = this.a.j;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke("WS: <-- " + str);
            }
            WebSocketReporter webSocketReporter = this.a.k;
            if (webSocketReporter != null) {
                webSocketReporter.onReceive(str);
            }
            this.a.b.accept(str);
            return;
        }
        webSocket.cancel();
        Function1 function12 = this.a.j;
        if (function12 != null) {
            Unit unit2 = (Unit) function12.invoke("WS: ignored <-- " + str);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
        Function1 function1 = this.a.j;
        if (function1 != null) {
            StringBuilder L = a.L("WS: on open: ");
            L.append(response.message());
            Unit unit = (Unit) function1.invoke(L.toString());
        }
        WebSocketReporter webSocketReporter = this.a.k;
        if (webSocketReporter != null) {
            webSocketReporter.onConnect(webSocket.request().url().toString());
        }
        if (!this.b.isDisposed()) {
            this.a.d.onNext(new RxWebSocketState.Connected());
            this.b.onSuccess(Unit.INSTANCE);
            return;
        }
        LegacyRxWebSocketImpl.access$cancelWebSocket(this.a);
    }
}
