package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.avito.android.util.Logs;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AppCallMessageBodyTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AppCallMessageBodyTypeAdapter implements JsonSerializer<MessageBody.AppCall>, JsonDeserializer<MessageBody.AppCall> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MessageBody.AppCall deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.get("call") != null) {
            try {
                JsonElement jsonElement2 = asJsonObject.get("call");
                Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[MessageBody.AppCall.CALL]");
                Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, Action.class);
                Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
                JsonElement jsonElement3 = asJsonObject.get("text");
                Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject[MessageBody.AppCall.TEXT]");
                String asString = jsonElement3.getAsString();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
                String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, MessageBody.RANDOM_ID);
                Intrinsics.checkNotNullExpressionValue(asString, "text");
                return new MessageBody.AppCall(asString, (Action) deserialize, nullableString);
            } catch (Throwable th) {
                Logs.error("AppCallMessageBodyTypeAdapter", "Failed to deserialize MessageBody.AppCall: " + jsonElement, th);
                throw th;
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to deserialize MessageBody.AppCall - call is null: " + jsonElement);
            Logs.error("AppCallMessageBodyTypeAdapter", illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable MessageBody.AppCall appCall, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (appCall == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(MessageBody.RANDOM_ID, appCall.getRandomId());
        jsonObject.add("text", jsonSerializationContext.serialize(appCall.getText()));
        jsonObject.add("call", jsonSerializationContext.serialize(appCall.getCall()));
        return jsonObject;
    }
}
