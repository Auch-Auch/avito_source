package ru.avito.messenger.internal.entity.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.MessengerResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/UnknownResponse;", "Lru/avito/messenger/api/entity/MessengerResponse;", "Lcom/google/gson/JsonElement;", AuthSource.SEND_ABUSE, "Lcom/google/gson/JsonElement;", "getJsonElement", "()Lcom/google/gson/JsonElement;", "jsonElement", "", "id", "J", "getId", "()Ljava/lang/Long;", "<init>", "(Lcom/google/gson/JsonElement;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UnknownResponse implements MessengerResponse {
    @NotNull
    public final JsonElement a;

    public UnknownResponse(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        this.a = jsonElement;
    }

    @Override // ru.avito.messenger.api.entity.MessengerResponse
    @NotNull
    public Long getId() {
        return 0L;
    }

    @NotNull
    public final JsonElement getJsonElement() {
        return this.a;
    }
}
