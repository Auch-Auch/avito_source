package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.context.ChannelContext;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ItemMessageBodyTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMessageBodyTypeAdapter implements JsonDeserializer<MessageBody.Item> {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0068: APUT  (r6v0 com.google.gson.JsonElement[]), (0 ??[int, short, byte, char]), (r9v2 com.google.gson.JsonElement) */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MessageBody.Item deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("id");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "js.get(\"id\")");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        String nullableString = JsonObjectExtensionsKt.getNullableString(I1, ChannelContext.Item.USER_ID);
        String x2 = a.x2(I1, "title", "js.get(\"title\")");
        JsonElement jsonElement3 = I1.get("price");
        Object obj = null;
        String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        JsonElement jsonElement4 = I1.get("location");
        String asString3 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        JsonElement[] jsonElementArr = new JsonElement[2];
        JsonElement jsonElement5 = I1.get("images");
        int i = 0;
        jsonElementArr[0] = (jsonElement5 == null || (asJsonObject = jsonElement5.getAsJsonObject()) == null) ? null : asJsonObject.get("main");
        jsonElementArr[1] = I1.get("image");
        while (true) {
            if (i >= 2) {
                break;
            }
            JsonElement jsonElement6 = jsonElementArr[i];
            if (jsonElement6 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement6, Image.class);
                Intrinsics.checkNotNullExpressionValue(obj, "deserialize(json, T::class.java)");
                break;
            }
            i++;
        }
        Intrinsics.checkNotNullExpressionValue(asString, "id");
        Intrinsics.checkNotNullExpressionValue(x2, "title");
        return new MessageBody.Item(asString, nullableString, x2, (Image) obj, asString2, asString3);
    }
}
