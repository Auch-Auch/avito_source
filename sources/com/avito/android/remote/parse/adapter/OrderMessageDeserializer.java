package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.OrderMessage;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/OrderMessageDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/OrderMessage;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/OrderMessage;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OrderMessageDeserializer implements JsonDeserializer<OrderMessage> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public OrderMessage deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Action action;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.getAsJsonArray("actions").get(0);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject\n            .…ons\")\n            .get(0)");
        JsonObject asJsonObject = jsonElement2.getAsJsonObject();
        JsonElement jsonElement3 = I1.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject[\"title\"]");
        String asString = jsonElement3.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "jsonObject[\"title\"].asString");
        JsonElement jsonElement4 = I1.get("description");
        Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObject[\"description\"]");
        String asString2 = jsonElement4.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject[\"description\"].asString");
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "actionObject");
        String x2 = a.x2(asJsonObject, "title", "jsonObject[\"title\"]");
        JsonElement jsonElement5 = asJsonObject.get(ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullExpressionValue(jsonElement5, "jsonObject[\"uri\"]");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement5, DeepLink.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        DeepLink deepLink = (DeepLink) deserialize;
        if (asJsonObject.has("type")) {
            Intrinsics.checkNotNullExpressionValue(x2, "title");
            action = new Action(x2, deepLink, null, x2, null, null, 48, null);
        } else {
            Intrinsics.checkNotNullExpressionValue(x2, "title");
            action = new Action(x2, deepLink, null, deepLink.getPath(), null, null, 48, null);
        }
        return new OrderMessage(asString, asString2, action);
    }
}
