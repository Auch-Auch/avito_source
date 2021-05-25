package com.avito.android.remote.parse.adapter.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/LinkMessagePreviewTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class LinkMessagePreviewTypeAdapter implements JsonSerializer<MessageBody.Link.Preview>, JsonDeserializer<MessageBody.Link.Preview> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public MessageBody.Link.Preview deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        String str = null;
        if (jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("type");
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 3321850) {
                    if (hashCode == 100313435 && str.equals("image")) {
                        return (MessageBody.Link.Preview) jsonDeserializationContext.deserialize(jsonElement.getAsJsonObject().get("value"), MessageBody.Link.Preview.Image.class);
                    }
                } else if (str.equals("link")) {
                    return (MessageBody.Link.Preview) jsonDeserializationContext.deserialize(jsonElement.getAsJsonObject().get("value"), MessageBody.Link.Preview.Snippet.class);
                }
            }
            throw new IllegalArgumentException(a.c3("Unsupported type: ", str));
        } else if (jsonElement.isJsonNull()) {
            return null;
        } else {
            throw new IllegalArgumentException("Unexpected json: " + jsonElement);
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable MessageBody.Link.Preview preview, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (preview == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        if (preview instanceof MessageBody.Link.Preview.Snippet) {
            jsonObject.addProperty("type", "link");
            jsonObject.add("value", jsonSerializationContext.serialize(preview));
        } else if (preview instanceof MessageBody.Link.Preview.Image) {
            jsonObject.addProperty("type", "image");
            jsonObject.add("value", jsonSerializationContext.serialize(preview));
        }
        return jsonObject;
    }
}
