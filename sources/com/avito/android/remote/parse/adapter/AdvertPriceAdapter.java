package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertPrice;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertPriceAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertPrice;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertPrice;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertPriceAdapter implements JsonDeserializer<AdvertPrice> {
    public final Features a;

    public AdvertPriceAdapter(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AdvertPrice deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String str;
        String str2;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String str3 = null;
        if (I1.has("title")) {
            JsonElement jsonElement4 = I1.get("title");
            Intrinsics.checkNotNullExpressionValue(jsonElement4, "priceObject.get(\"title\")");
            if (jsonElement4.isJsonObject()) {
                JsonObject asJsonObject = I1.getAsJsonObject("title");
                JsonElement jsonElement5 = asJsonObject.get("short");
                String asString = jsonElement5 != null ? jsonElement5.getAsString() : null;
                JsonElement jsonElement6 = asJsonObject.get(MessengerShareContentUtility.WEBVIEW_RATIO_FULL);
                str = jsonElement6 != null ? jsonElement6.getAsString() : null;
                str2 = asString;
            } else {
                str2 = a.x2(I1, "title", "priceObject.get(\"title\")");
                str = null;
            }
        } else {
            str2 = null;
            str = null;
        }
        String asString2 = (!this.a.getAdvertPriceWithDiscount().invoke().booleanValue() || (jsonElement3 = I1.get("value_signed")) == null) ? null : jsonElement3.getAsString();
        String asString3 = (!this.a.getAdvertPriceWithDiscount().invoke().booleanValue() || (jsonElement2 = I1.get("value_without_discount_signed")) == null) ? null : jsonElement2.getAsString();
        JsonElement jsonElement7 = I1.get("value");
        Intrinsics.checkNotNullExpressionValue(jsonElement7, "priceObject.get(\"value\")");
        String asString4 = jsonElement7.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString4, "priceObject.get(\"value\").asString");
        JsonElement jsonElement8 = I1.get("metric");
        String asString5 = jsonElement8 != null ? jsonElement8.getAsString() : null;
        JsonElement jsonElement9 = I1.get("value_old");
        String asString6 = jsonElement9 != null ? jsonElement9.getAsString() : null;
        JsonElement jsonElement10 = I1.get("discount_percent");
        if (jsonElement10 != null) {
            str3 = jsonElement10.getAsString();
        }
        return new AdvertPrice(str2, str, asString4, asString6, asString5, asString2, asString3, str3);
    }
}
