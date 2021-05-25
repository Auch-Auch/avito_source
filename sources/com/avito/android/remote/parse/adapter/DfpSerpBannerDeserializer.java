package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.DfpBannerItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/DfpSerpBannerDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/DfpBannerItem;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/DfpBannerItem;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DfpSerpBannerDeserializer implements JsonDeserializer<DfpBannerItem> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public DfpBannerItem deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "id", "jsonObject[\"id\"]");
        JsonElement jsonElement2 = I1.get("alid");
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        JsonElement jsonElement3 = I1.get("bannerCode");
        String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (I1.has("networkExtras")) {
            JsonElement jsonElement4 = I1.get("networkExtras");
            Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObject[\"networkExtras\"]");
            JsonObject asJsonObject = jsonElement4.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(x2, "id");
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "networkExtras");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : asJsonObject.keySet()) {
                JsonElement jsonElement5 = asJsonObject.get(str);
                if (!(jsonElement5 instanceof JsonNull)) {
                    if (jsonElement5 instanceof JsonArray) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        ArrayList arrayList = new ArrayList();
                        Iterator<JsonElement> it = ((JsonArray) jsonElement5).iterator();
                        while (it.hasNext()) {
                            JsonElement next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "elem");
                            String asString3 = next.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString3, "elem.asString");
                            arrayList.add(asString3);
                        }
                        linkedHashMap.put(str, arrayList);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        Intrinsics.checkNotNullExpressionValue(jsonElement5, "value");
                        String asString4 = jsonElement5.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString4, "value.asString");
                        linkedHashMap.put(str, asString4);
                    }
                }
            }
            return new DfpBannerItem(x2, asString, asString2, linkedHashMap);
        }
        Intrinsics.checkNotNullExpressionValue(x2, "id");
        return new DfpBannerItem(x2, asString, asString2, null);
    }
}
