package ru.avito.reporter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lru/avito/reporter/StubWebSocketReporter;", "Lru/avito/reporter/WebSocketReporter;", "", "host", "", "onConnect", "(Ljava/lang/String;)V", "message", "", "enqueued", "onSend", "(Ljava/lang/String;Z)V", "onReceive", "onError", "onClose", "()V", "<init>", "websocket-reporter"}, k = 1, mv = {1, 4, 2})
public final class StubWebSocketReporter implements WebSocketReporter {
    @Override // ru.avito.reporter.WebSocketReporter
    public void onClose() {
    }

    @Override // ru.avito.reporter.WebSocketReporter
    public void onConnect(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "host");
    }

    @Override // ru.avito.reporter.WebSocketReporter
    public void onError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
    }

    @Override // ru.avito.reporter.WebSocketReporter
    public void onReceive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
    }

    @Override // ru.avito.reporter.WebSocketReporter
    public void onSend(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
