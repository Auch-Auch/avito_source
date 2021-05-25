package ru.avito.messenger.internal.gson.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.internal.util.JsonObjectsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/MessageTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lru/avito/messenger/api/entity/ChatMessage;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lru/avito/messenger/api/entity/ChatMessage;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageTypeAdapter implements JsonDeserializer<ChatMessage> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ChatMessage deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "id", "js.get(\"id\")");
        String x22 = a.x2(I1, "uid", "js.get(\"uid\")");
        String x23 = a.x2(I1, "channelId", "js.get(\"channelId\")");
        String x24 = a.x2(I1, "fromUid", "js.get(\"fromUid\")");
        JsonElement jsonElement2 = I1.get("created");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "js.get(\"created\")");
        long asLong = jsonElement2.getAsLong();
        JsonElement jsonElement3 = I1.get("isRead");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "js.get(\"isRead\")");
        boolean asBoolean = jsonElement3.getAsBoolean();
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        Long nullableLong = JsonObjectsKt.getNullableLong(I1, "read");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement, MessageBody.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        JsonElement jsonElement4 = I1.get("channel");
        JsonElement jsonElement5 = I1.get("preview");
        JsonElement jsonElement6 = I1.get(PlatformActions.PLATFORM_SUPPORT);
        Intrinsics.checkNotNullExpressionValue(x2, "id");
        Intrinsics.checkNotNullExpressionValue(x22, "uid");
        Intrinsics.checkNotNullExpressionValue(x23, "channelId");
        Intrinsics.checkNotNullExpressionValue(x24, "fromId");
        return new ChatMessage(x2, x22, x23, (MessageBody) deserialize, x24, asLong, asBoolean, nullableLong, (ChatMessage.PartialChannel) jsonDeserializationContext.deserialize(jsonElement4, ChatMessage.PartialChannel.class), (ChatMessage.Preview) jsonDeserializationContext.deserialize(jsonElement5, ChatMessage.Preview.class), (PlatformSupport) jsonDeserializationContext.deserialize(jsonElement6, PlatformSupport.class));
    }
}
