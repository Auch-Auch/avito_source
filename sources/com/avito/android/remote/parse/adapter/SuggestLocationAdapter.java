package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.SuggestLocation;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SuggestLocationAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/SuggestLocation;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/SuggestLocation;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationAdapter implements JsonDeserializer<SuggestLocation> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public SuggestLocation deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        CaseText caseText;
        SuggestLocation.From from;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
        String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, "id");
        SuggestLocation.Parent parent = null;
        if (nullableString == null) {
            return null;
        }
        JsonElement jsonElement2 = asJsonObject.get("names");
        if (jsonElement2 != null) {
            Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, CaseText.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
            caseText = (CaseText) deserialize;
        } else {
            caseText = null;
        }
        JsonElement jsonElement3 = asJsonObject.get("from");
        if (jsonElement3 != null) {
            Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement3, SuggestLocation.From.class);
            Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
            from = (SuggestLocation.From) deserialize2;
        } else {
            from = null;
        }
        JsonElement jsonElement4 = asJsonObject.get("parent");
        if (jsonElement4 != null) {
            Object deserialize3 = jsonDeserializationContext.deserialize(jsonElement4, SuggestLocation.Parent.class);
            Intrinsics.checkNotNullExpressionValue(deserialize3, "deserialize(json, T::class.java)");
            parent = (SuggestLocation.Parent) deserialize3;
        }
        return new SuggestLocation(nullableString, caseText, from, parent, JsonObjectExtensionsKt.getNullableString(asJsonObject, "suggestType"));
    }
}
