package com.avito.android.remote.parse.adapter.messenger;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/LinkMessageBodyTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class LinkMessageBodyTypeAdapter implements JsonSerializer<MessageBody.Link>, JsonDeserializer<MessageBody.Link> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MessageBody.Link deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("url");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[URL]");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
        String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, MessageBody.RANDOM_ID);
        JsonElement jsonElement3 = asJsonObject.get("preview");
        Boolean nullableBoolean = JsonObjectExtensionsKt.getNullableBoolean(asJsonObject, "urlsAreTrusted");
        boolean booleanValue = nullableBoolean != null ? nullableBoolean.booleanValue() : false;
        if (jsonElement3 != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(asString, "url");
                Object deserialize = jsonDeserializationContext.deserialize(jsonElement3, MessageBody.Link.Preview.class);
                Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
                return new MessageBody.Link(asString, (MessageBody.Link.Preview) deserialize, nullableString, booleanValue);
            } catch (Throwable th) {
                Logs.error("LinkMessageBodyTypeAdapter", "Failed to deserialize MessageBody.Link: " + jsonElement, th);
                Intrinsics.checkNotNullExpressionValue(asString, "url");
                return new MessageBody.Link(asString, null, nullableString, booleanValue);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(asString, "url");
            return new MessageBody.Link(asString, null, nullableString, booleanValue);
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable MessageBody.Link link, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (link == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("url", jsonSerializationContext.serialize(link.getUrl()));
        if (link.getRandomId() != null) {
            jsonObject.add(MessageBody.RANDOM_ID, jsonSerializationContext.serialize(link.getRandomId()));
        }
        if (link.getPreview() != null) {
            jsonObject.add("preview", jsonSerializationContext.serialize(link.getPreview(), MessageBody.Link.Preview.class));
        }
        jsonObject.add("urlsAreTrusted", jsonSerializationContext.serialize(Boolean.valueOf(link.getUrlsAreTrusted())));
        return jsonObject;
    }
}
