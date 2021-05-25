package com.avito.android.remote.parse.adapter.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/FileMessageBodyTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$File;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class FileMessageBodyTypeAdapter implements JsonSerializer<MessageBody.File>, JsonDeserializer<MessageBody.File> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MessageBody.File deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, MessageBody.File.FILE_ID, "jsonObject[FILE_ID]");
        String x22 = a.x2(I1, "name", "jsonObject[NAME]");
        JsonElement jsonElement2 = I1.get(MessageBody.File.SIZE_IN_BYTES);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[SIZE_IN_BYTES]");
        long asLong = jsonElement2.getAsLong();
        Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
        String nullableString = JsonObjectExtensionsKt.getNullableString(I1, MessageBody.File.MIME_TYPE);
        String nullableString2 = JsonObjectExtensionsKt.getNullableString(I1, MessageBody.RANDOM_ID);
        Intrinsics.checkNotNullExpressionValue(x2, MessageBody.File.FILE_ID);
        Intrinsics.checkNotNullExpressionValue(x22, "name");
        return new MessageBody.File(x2, x22, asLong, nullableString, nullableString2);
    }

    @NotNull
    public JsonElement serialize(@Nullable MessageBody.File file, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (file == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(MessageBody.File.FILE_ID, jsonSerializationContext.serialize(file.getFileId()));
        jsonObject.add("name", jsonSerializationContext.serialize(file.getName()));
        jsonObject.add(MessageBody.File.SIZE_IN_BYTES, jsonSerializationContext.serialize(Long.valueOf(file.getSizeBytes())));
        String mimeType = file.getMimeType();
        if (mimeType != null) {
            jsonObject.add(MessageBody.File.MIME_TYPE, jsonSerializationContext.serialize(mimeType));
        }
        String randomId = file.getRandomId();
        if (randomId != null) {
            jsonObject.add(MessageBody.RANDOM_ID, jsonSerializationContext.serialize(randomId));
        }
        return jsonObject;
    }
}
