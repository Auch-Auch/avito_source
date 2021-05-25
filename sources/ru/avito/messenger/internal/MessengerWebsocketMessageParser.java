package ru.avito.messenger.internal;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.entity.messenger.SystemMessage;
import ru.avito.messenger.internal.entity.messenger.UnknownResponse;
import ru.avito.websocket.WebsocketMessageParser;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/messenger/internal/MessengerWebsocketMessageParser;", "Lru/avito/websocket/WebsocketMessageParser;", "Lru/avito/messenger/api/entity/MessengerResponse;", "", "message", "parseMessage", "(Ljava/lang/String;)Lru/avito/messenger/api/entity/MessengerResponse;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerWebsocketMessageParser implements WebsocketMessageParser<MessengerResponse> {
    public final Gson a;
    public final ErrorTracker b;

    public MessengerWebsocketMessageParser(@NotNull Gson gson, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = gson;
        this.b = errorTracker;
    }

    @Override // ru.avito.websocket.WebsocketMessageParser
    @NotNull
    public MessengerResponse parseMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            JsonElement jsonElement = (JsonElement) this.a.fromJson(str, (Class<Object>) JsonElement.class);
            Intrinsics.checkNotNullExpressionValue(jsonElement, "json");
            if (!jsonElement.isJsonObject()) {
                return new UnknownResponse(jsonElement);
            }
            if (jsonElement.getAsJsonObject().has("jsonrpc")) {
                Object fromJson = this.a.fromJson(jsonElement, (Class<Object>) JsonRpcResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson<T>(jsonElement, T::class.java)");
                return (MessengerResponse) fromJson;
            }
            Object fromJson2 = this.a.fromJson(jsonElement, (Class<Object>) SystemMessage.class);
            Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson<T>(jsonElement, T::class.java)");
            return (MessengerResponse) fromJson2;
        } catch (Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.b, new MessengerResponseBodyConverterException(null, th, 1, null), null, q.mapOf(TuplesKt.to("textToConvert", str)), 2, null);
            throw th;
        }
    }
}
