package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.JsonElementsKt;
import com.avito.android.remote.model.ContactAccessService;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ContactAccessServiceServiceDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/ContactAccessService$Service;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/ContactAccessService$Service;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServiceServiceDeserializer implements JsonDeserializer<ContactAccessService.Service> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ContactAccessService.Service deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("value");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"value\"]");
        JsonObject asJsonObject = jsonElement2.getAsJsonObject();
        JsonElement jsonElement3 = asJsonObject.get("id");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "valueObject[\"id\"]");
        String asString = jsonElement3.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "valueObject[\"id\"].asString");
        JsonElement jsonElement4 = asJsonObject.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement4, "valueObject[\"title\"]");
        String asString2 = jsonElement4.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "valueObject[\"title\"].asString");
        JsonElement jsonElement5 = asJsonObject.get("price");
        Intrinsics.checkNotNullExpressionValue(jsonElement5, "valueObject[\"price\"]");
        String asString3 = jsonElement5.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString3, "valueObject[\"price\"].asString");
        JsonElement jsonElement6 = asJsonObject.get("priceValue");
        Intrinsics.checkNotNullExpressionValue(jsonElement6, "valueObject[\"priceValue\"]");
        int asInt = jsonElement6.getAsInt();
        JsonElement jsonElement7 = I1.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement7, "jsonObject[\"title\"]");
        String asString4 = jsonElement7.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString4, "jsonObject[\"title\"].asString");
        JsonElement jsonElement8 = I1.get(MessengerShareContentUtility.SUBTITLE);
        return new ContactAccessService.Service(asString, asString2, asString3, asInt, asString4, jsonElement8 != null ? JsonElementsKt.getAsStringOrNull(jsonElement8) : null);
    }
}
