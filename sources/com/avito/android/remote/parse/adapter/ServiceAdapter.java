package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.vas.Service;
import com.avito.android.remote.model.vas.ServiceDiscount;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ServiceAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/vas/Service;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/vas/Service;", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceAdapter implements JsonDeserializer<Service> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Service deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String x2 = a.x2(asJsonObject, "id", "jsonBlock.get(\"id\")");
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("name");
        String x22 = a.x2(asJsonObject2, "short", "nameObject.get(\"short\")");
        String x23 = a.x2(asJsonObject2, MessengerShareContentUtility.WEBVIEW_RATIO_FULL, "nameObject.get(\"full\")");
        String x24 = a.x2(asJsonObject, "description", "jsonBlock.get(\"description\")");
        JsonElement jsonElement2 = asJsonObject.get("price");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonBlock.get(\"price\")");
        int asInt = jsonElement2.getAsInt();
        JsonElement jsonElement3 = asJsonObject.get("priceMetric");
        Integer num = null;
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        JsonElement jsonElement4 = asJsonObject.get("fullPrice");
        if (jsonElement4 != null) {
            num = Integer.valueOf(jsonElement4.getAsInt());
        }
        Intrinsics.checkNotNullExpressionValue(x2, "id");
        Intrinsics.checkNotNullExpressionValue(x22, "shortName");
        Intrinsics.checkNotNullExpressionValue(x23, "fullName");
        Intrinsics.checkNotNullExpressionValue(x24, "description");
        return new Service(x2, x22, x23, x24, asInt, num, (ServiceDiscount) jsonDeserializationContext.deserialize(asJsonObject.get(FirebaseAnalytics.Param.DISCOUNT), ServiceDiscount.class), asString);
    }
}
