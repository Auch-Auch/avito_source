package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.change.CheckmarkTextBenefit;
import com.avito.android.remote.model.change.PlusTextBenefit;
import com.avito.android.remote.model.change.TariffBenefit;
import com.avito.android.remote.model.change.TextBenefit;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/TariffBenefitAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/change/TariffBenefit;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/change/TariffBenefit;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffBenefitAdapter implements JsonDeserializer<TariffBenefit> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public TariffBenefit deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        if (I1.has("text")) {
            Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
            JsonElement jsonElement2 = I1.getAsJsonObject().get("text");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "asJsonObject.get(tag)");
            String asString = jsonElement2.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.getString(\"text\")");
            return new TextBenefit(asString);
        } else if (I1.has("checkmarkText")) {
            Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
            JsonElement jsonElement3 = I1.getAsJsonObject().get("checkmarkText");
            Intrinsics.checkNotNullExpressionValue(jsonElement3, "asJsonObject.get(tag)");
            String asString2 = jsonElement3.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.getString(\"checkmarkText\")");
            return new CheckmarkTextBenefit(asString2);
        } else if (I1.has("plusText")) {
            Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
            JsonElement jsonElement4 = I1.getAsJsonObject().get("plusText");
            Intrinsics.checkNotNullExpressionValue(jsonElement4, "asJsonObject.get(tag)");
            String asString3 = jsonElement4.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject.getString(\"plusText\")");
            return new PlusTextBenefit(asString3);
        } else {
            throw new JsonParseException("unknown type of TariffBenefit");
        }
    }
}
