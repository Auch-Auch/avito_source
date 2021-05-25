package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/MessageBodySystemDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class MessageBodySystemDeserializer implements JsonDeserializer<MessageBody.SystemMessageBody> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MessageBody.SystemMessageBody deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
        String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, "text");
        if (nullableString != null) {
            return new MessageBody.SystemMessageBody.Text(nullableString);
        }
        return new MessageBody.SystemMessageBody.Unknown();
    }
}
