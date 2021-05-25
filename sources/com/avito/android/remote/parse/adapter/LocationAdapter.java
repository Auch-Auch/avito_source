package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SimpleLocation;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/LocationAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/Location;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/Location;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LocationAdapter implements JsonDeserializer<Location> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Location deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String asString;
        JsonElement jsonElement2;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement3 = I1.get("id");
        SimpleLocation simpleLocation = null;
        if (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null || (jsonElement2 = I1.get("names")) == null) {
            return null;
        }
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, CaseText.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        CaseText caseText = (CaseText) deserialize;
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        JsonElement jsonElement4 = I1.get("parent");
        if (jsonElement4 == null) {
            JsonElement jsonElement5 = I1.get("parentId");
            String asString2 = jsonElement5 != null ? jsonElement5.getAsString() : null;
            if (asString2 != null) {
                simpleLocation = new SimpleLocation(asString2, new CaseText());
            }
        } else {
            Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement4, SimpleLocation.class);
            Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
            simpleLocation = (SimpleLocation) deserialize2;
        }
        JsonElement jsonElement6 = I1.get("hasMetro");
        boolean asBoolean = jsonElement6 != null ? jsonElement6.getAsBoolean() : false;
        JsonElement jsonElement7 = I1.get("hasChildren");
        boolean asBoolean2 = jsonElement7 != null ? jsonElement7.getAsBoolean() : false;
        JsonElement jsonElement8 = I1.get("hasDirections");
        boolean asBoolean3 = jsonElement8 != null ? jsonElement8.getAsBoolean() : false;
        JsonElement jsonElement9 = I1.get("hasDistricts");
        return new Location(asString, caseText, asBoolean, asBoolean2, asBoolean3, jsonElement9 != null ? jsonElement9.getAsBoolean() : false, simpleLocation, false, null, null, 896, null);
    }
}
