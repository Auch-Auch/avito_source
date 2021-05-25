package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchSubscription;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SearchSubscriptionDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/SearchSubscription;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/SearchSubscription;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionDeserializer implements JsonDeserializer<SearchSubscription> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public SearchSubscription deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("id");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"id\"]");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "jsonObject[\"id\"].asString");
        JsonElement jsonElement3 = I1.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject[\"title\"]");
        String asString2 = jsonElement3.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject[\"title\"].asString");
        JsonElement jsonElement4 = I1.get("description");
        Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObject[\"description\"]");
        String asString3 = jsonElement4.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject[\"description\"].asString");
        JsonElement jsonElement5 = I1.get("lastUpdateTime");
        long asInt = ((long) (jsonElement5 != null ? jsonElement5.getAsInt() : 0)) * 1000;
        JsonElement jsonElement6 = I1.get("count");
        Intrinsics.checkNotNullExpressionValue(jsonElement6, "jsonObject[\"count\"]");
        int asInt2 = jsonElement6.getAsInt();
        JsonElement jsonElement7 = I1.get("filter");
        Intrinsics.checkNotNullExpressionValue(jsonElement7, "jsonObject[\"filter\"]");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement7, SearchParams.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        SearchParams searchParams = (SearchParams) deserialize;
        JsonElement jsonElement8 = I1.get(SearchSubscriptionsContract.Columns.SSID);
        Object obj = null;
        String asString4 = jsonElement8 != null ? jsonElement8.getAsString() : null;
        JsonElement jsonElement9 = I1.get("pushFrequency");
        Integer valueOf = jsonElement9 != null ? Integer.valueOf(jsonElement9.getAsInt()) : null;
        JsonElement jsonElement10 = I1.get("editAction");
        Intrinsics.checkNotNullExpressionValue(jsonElement10, "jsonObject[\"editAction\"]");
        Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement10, DeepLink.class);
        Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
        DeepLink deepLink = (DeepLink) deserialize2;
        JsonElement jsonElement11 = I1.get("deeplink");
        if (jsonElement11 != null) {
            obj = jsonDeserializationContext.deserialize(jsonElement11, DeepLink.class);
        }
        return new SearchSubscription(asString, asString2, asString3, asInt, asInt2, searchParams, asString4, valueOf, deepLink, (DeepLink) obj);
    }
}
