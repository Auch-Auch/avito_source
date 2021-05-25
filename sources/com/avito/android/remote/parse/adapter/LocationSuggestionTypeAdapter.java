package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.delivery.LocationSuggestion;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/LocationSuggestionTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/delivery/LocationSuggestion;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/delivery/LocationSuggestion;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class LocationSuggestionTypeAdapter implements JsonDeserializer<LocationSuggestion> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public LocationSuggestion deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String asString;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement4 = I1.get("title");
        String str = null;
        if (jsonElement4 == null || (asString = jsonElement4.getAsString()) == null) {
            return null;
        }
        JsonElement jsonElement5 = I1.get("fiasId");
        String asString2 = jsonElement5 != null ? jsonElement5.getAsString() : null;
        JsonElement jsonElement6 = I1.get("suggestionText");
        String asString3 = jsonElement6 != null ? jsonElement6.getAsString() : null;
        JsonObject asJsonObject = I1.getAsJsonObject("approveAction");
        String asString4 = (asJsonObject == null || (jsonElement3 = asJsonObject.get("title")) == null) ? null : jsonElement3.getAsString();
        JsonObject asJsonObject2 = I1.getAsJsonObject("editAction");
        if (!(asJsonObject2 == null || (jsonElement2 = asJsonObject2.get("title")) == null)) {
            str = jsonElement2.getAsString();
        }
        return new LocationSuggestion(asString, asString2, asString3, asString4, str);
    }
}
