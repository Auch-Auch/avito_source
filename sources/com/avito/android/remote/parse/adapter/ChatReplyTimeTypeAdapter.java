package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ChatReplyTimeTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChatReplyTimeTypeAdapter implements JsonSerializer<ChatReplyTime>, JsonDeserializer<ChatReplyTime> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ChatReplyTime.ActionType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            ChatReplyTime.ActionType actionType = ChatReplyTime.ActionType.CALL;
            iArr[0] = 1;
            ChatReplyTime.ActionType actionType2 = ChatReplyTime.ActionType.DEFAULT;
            iArr[1] = 2;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public ChatReplyTime deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("text");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(TEXT)");
            String asString = jsonElement2.getAsString();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
            Long nullableLong = JsonObjectExtensionsKt.getNullableLong(asJsonObject, "time");
            String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, "type");
            Intrinsics.checkNotNullExpressionValue(asString, "text");
            ChatReplyTime.ActionType actionType = ChatReplyTime.ActionType.CALL;
            if (!Intrinsics.areEqual(nullableString, actionType.getKey())) {
                actionType = ChatReplyTime.ActionType.DEFAULT;
            }
            return new ChatReplyTime(actionType, asString, nullableLong);
        }
        throw new IllegalArgumentException("Expected object or null. but got: " + jsonElement);
    }

    @NotNull
    public JsonElement serialize(@Nullable ChatReplyTime chatReplyTime, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        String str;
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (chatReplyTime != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("text", jsonSerializationContext.serialize(chatReplyTime.getText()));
            if (chatReplyTime.getTime() != null) {
                jsonObject.add("time", jsonSerializationContext.serialize(chatReplyTime.getTime()));
            }
            int ordinal = chatReplyTime.getActionType().ordinal();
            if (ordinal == 0) {
                str = ChatReplyTime.ActionType.CALL.getKey();
            } else if (ordinal == 1) {
                str = ChatReplyTime.ActionType.DEFAULT.getKey();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            jsonObject.addProperty("type", str);
            return jsonObject;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }
}
