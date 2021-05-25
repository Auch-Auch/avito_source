package ru.avito.websocket;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.avito.reporter.WebSocketReporter;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"ru/avito/websocket/RxWebSocketImpl$listener$1", "Lokhttp3/WebSocketListener;", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", CommonKt.EXTRA_RESPONSE, "", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "", "code", "reason", "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class RxWebSocketImpl$listener$1 extends WebSocketListener {
    public final /* synthetic */ RxWebSocketImpl a;

    public static final class a extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public final /* synthetic */ RxWebSocketImpl$listener$1 a;
        public final /* synthetic */ WebSocket b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RxWebSocketImpl$listener$1 rxWebSocketImpl$listener$1, WebSocket webSocket, int i, String str) {
            super(1);
            this.a = rxWebSocketImpl$listener$1;
            this.b = webSocket;
            this.c = i;
            this.d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "$receiver");
            if (this.b == RxWebSocketImplKt.access$getSocket$p(pair2)) {
                Function1 function1 = this.a.a.g;
                if (function1 != null) {
                    StringBuilder L = a2.b.a.a.a.L("WS: on closed: ");
                    L.append(this.c);
                    L.append(", ");
                    L.append(this.d);
                    Unit unit = (Unit) function1.invoke(L.toString());
                }
                WebSocketReporter webSocketReporter = this.a.a.h;
                if (webSocketReporter != null) {
                    webSocketReporter.onClose();
                }
                return TuplesKt.to(null, new RxWebSocketState.Disconnected(this.c, this.d, null, 4, null));
            }
            this.b.cancel();
            Function1 function12 = this.a.a.g;
            if (function12 == null) {
                return pair2;
            }
            Unit unit2 = (Unit) function12.invoke("onClose(): Canceled previously open websocket");
            return pair2;
        }
    }

    public static final class b extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public final /* synthetic */ RxWebSocketImpl$listener$1 a;
        public final /* synthetic */ WebSocket b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RxWebSocketImpl$listener$1 rxWebSocketImpl$listener$1, WebSocket webSocket, int i, String str) {
            super(1);
            this.a = rxWebSocketImpl$listener$1;
            this.b = webSocket;
            this.c = i;
            this.d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "$receiver");
            if (this.b == RxWebSocketImplKt.access$getSocket$p(pair2)) {
                Function1 function1 = this.a.a.g;
                if (function1 != null) {
                    StringBuilder L = a2.b.a.a.a.L("WS: on closing: ");
                    L.append(this.c);
                    L.append(", ");
                    L.append(this.d);
                    Unit unit = (Unit) function1.invoke(L.toString());
                }
                RxWebSocketImpl.access$closeInternal(this.a.a, this.c, this.d);
                return TuplesKt.to(RxWebSocketImplKt.access$getSocket$p(pair2), RxWebSocketImplKt.access$getState$p(pair2));
            }
            this.b.cancel();
            Function1 function12 = this.a.a.g;
            if (function12 == null) {
                return pair2;
            }
            Unit unit2 = (Unit) function12.invoke("onClose(): Canceled previously open websocket");
            return pair2;
        }
    }

    public static final class c extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public final /* synthetic */ RxWebSocketImpl$listener$1 a;
        public final /* synthetic */ WebSocket b;
        public final /* synthetic */ Response c;
        public final /* synthetic */ Throwable d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RxWebSocketImpl$listener$1 rxWebSocketImpl$listener$1, WebSocket webSocket, Response response, Throwable th) {
            super(1);
            this.a = rxWebSocketImpl$listener$1;
            this.b = webSocket;
            this.c = response;
            this.d = th;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            ResponseBody body;
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "$receiver");
            if (this.b == RxWebSocketImplKt.access$getSocket$p(pair2)) {
                Function2 function2 = this.a.a.i;
                if (function2 != null) {
                    StringBuilder L = a2.b.a.a.a.L("WS: on failure: response.body = ");
                    Response response = this.c;
                    L.append((response == null || (body = response.body()) == null) ? null : body.string());
                    Unit unit = (Unit) function2.invoke(L.toString(), this.d);
                }
                WebSocketReporter webSocketReporter = this.a.a.h;
                if (webSocketReporter != null) {
                    webSocketReporter.onError(this.d.toString());
                }
                Response response2 = this.c;
                int code = response2 != null ? response2.code() : -1;
                Response response3 = this.c;
                return TuplesKt.to(null, new RxWebSocketState.Disconnected(code, response3 != null ? response3.message() : null, this.d));
            }
            this.b.cancel();
            Function1 function1 = this.a.a.g;
            if (function1 == null) {
                return pair2;
            }
            Unit unit2 = (Unit) function1.invoke("onFailure(): Canceled previously open websocket");
            return pair2;
        }
    }

    public static final class d extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public final /* synthetic */ RxWebSocketImpl$listener$1 a;
        public final /* synthetic */ WebSocket b;
        public final /* synthetic */ Response c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RxWebSocketImpl$listener$1 rxWebSocketImpl$listener$1, WebSocket webSocket, Response response) {
            super(1);
            this.a = rxWebSocketImpl$listener$1;
            this.b = webSocket;
            this.c = response;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "$receiver");
            if (this.b == RxWebSocketImplKt.access$getSocket$p(pair2)) {
                Function1 function1 = this.a.a.g;
                if (function1 != null) {
                    StringBuilder L = a2.b.a.a.a.L("WS: on open: ");
                    L.append(this.c.message());
                    Unit unit = (Unit) function1.invoke(L.toString());
                }
                WebSocketReporter webSocketReporter = this.a.a.h;
                if (webSocketReporter != null) {
                    webSocketReporter.onConnect(this.b.request().url().toString());
                }
                return TuplesKt.to(RxWebSocketImplKt.access$getSocket$p(pair2), new RxWebSocketState.Connected());
            }
            this.b.cancel();
            Function1 function12 = this.a.a.g;
            if (function12 == null) {
                return pair2;
            }
            Unit unit2 = (Unit) function12.invoke("onOpen(): Canceled previously open websocket");
            return pair2;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public RxWebSocketImpl$listener$1(RxWebSocketImpl rxWebSocketImpl) {
        this.a = rxWebSocketImpl;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        this.a.c.accept(new a(this, webSocket, i, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        this.a.c.accept(new b(this, webSocket, i, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(th, "t");
        this.a.c.accept(new c(this, webSocket, response, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        Object blockingFirst = this.a.a.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "socketWithStateRelay.blockingFirst()");
        if (webSocket == RxWebSocketImplKt.access$getSocket$p((Pair) blockingFirst)) {
            Function1 function1 = this.a.g;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke("WS: <-- " + str);
            }
            WebSocketReporter webSocketReporter = this.a.h;
            if (webSocketReporter != null) {
                webSocketReporter.onReceive(str);
            }
            this.a.d.accept(str);
            return;
        }
        webSocket.cancel();
        Function1 function12 = this.a.g;
        if (function12 != null) {
            Unit unit2 = (Unit) function12.invoke("onMessage(): Canceled previously open websocket");
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
        this.a.c.accept(new d(this, webSocket, response));
    }
}
