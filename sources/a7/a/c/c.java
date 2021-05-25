package a7.a.c;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import ru.avito.websocket.LegacyRxWebSocketImpl;
import ru.avito.websocket.LegacyRxWebSocketImpl$createWebSocketListener$1;
import ru.avito.websocket.RxWebSocketState;
public final class c<T> implements SingleOnSubscribe<Unit> {
    public final /* synthetic */ LegacyRxWebSocketImpl a;
    public final /* synthetic */ String b;

    public static final class a<T> implements Consumer<Pair<? extends WebSocket, ? extends String>> {
        public final /* synthetic */ c a;
        public final /* synthetic */ SingleEmitter b;

        public a(c cVar, SingleEmitter singleEmitter) {
            this.a = cVar;
            this.b = singleEmitter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends WebSocket, ? extends String> pair) {
            Pair<? extends WebSocket, ? extends String> pair2 = pair;
            WebSocket webSocket = (WebSocket) pair2.component1();
            String str = (String) pair2.component2();
            synchronized (this.a.a.a) {
                this.a.a.e = webSocket;
                this.a.a.f = str;
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ c a;
        public final /* synthetic */ SingleEmitter b;

        public b(c cVar, SingleEmitter singleEmitter) {
            this.a = cVar;
            this.b = singleEmitter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.subjects.Subject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.a.d.onNext(new RxWebSocketState.Disconnected(0, th2.getMessage(), th2, 1, null));
            SingleEmitter singleEmitter = this.b;
            Intrinsics.checkNotNullExpressionValue(singleEmitter, "emitter");
            if (!singleEmitter.isDisposed()) {
                this.b.onError(th2);
            }
        }
    }

    public c(LegacyRxWebSocketImpl legacyRxWebSocketImpl, String str) {
        this.a = legacyRxWebSocketImpl;
        this.b = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: io.reactivex.subjects.Subject */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(@NotNull SingleEmitter<Unit> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        synchronized (this.a.a) {
            LegacyRxWebSocketImpl.access$cancelWebSocket(this.a);
            this.a.d.onNext(new RxWebSocketState.Connecting());
            LegacyRxWebSocketImpl$createWebSocketListener$1 access$createWebSocketListener = LegacyRxWebSocketImpl.access$createWebSocketListener(this.a, singleEmitter);
            LegacyRxWebSocketImpl legacyRxWebSocketImpl = this.a;
            legacyRxWebSocketImpl.g = legacyRxWebSocketImpl.i.create(access$createWebSocketListener, this.b).subscribe(new a(this, singleEmitter), new b(this, singleEmitter));
            Unit unit = Unit.INSTANCE;
        }
    }
}
