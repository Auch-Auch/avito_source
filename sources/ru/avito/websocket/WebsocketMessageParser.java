package ru.avito.websocket;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/websocket/WebsocketMessageParser;", "T", "", "", "message", "parseMessage", "(Ljava/lang/String;)Ljava/lang/Object;", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public interface WebsocketMessageParser<T> {
    T parseMessage(@NotNull String str);
}
