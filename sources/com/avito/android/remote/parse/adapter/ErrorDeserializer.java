package com.avito.android.remote.parse.adapter;

import androidx.collection.ArrayMap;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Error;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ErrorDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/Error;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/Error;", "Lcom/google/gson/JsonObject;", "jsonObject", "", "", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonObject;)Ljava/util/Map;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorDeserializer implements JsonDeserializer<Error> {
    public final Map<String, String> a(JsonObject jsonObject) {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            arrayMap.put(key, value.getAsString());
        }
        return arrayMap;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public Error deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String str;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Error error = new Error();
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("code");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"code\"]");
        error.code = jsonElement2.getAsInt();
        JsonElement jsonElement3 = asJsonObject.get("messages");
        JsonObject jsonObject = null;
        JsonObject asJsonObject2 = jsonElement3 != null ? jsonElement3.getAsJsonObject() : null;
        if (asJsonObject2 == null) {
            JsonElement jsonElement4 = asJsonObject.get("message");
            if (jsonElement4 == null || (str = jsonElement4.getAsString()) == null) {
                str = "";
            }
            error.simpleMessage = str;
        } else {
            JsonElement jsonElement5 = asJsonObject2.get("params");
            if (jsonElement5 != null) {
                jsonObject = jsonElement5.getAsJsonObject();
            }
            if (jsonObject == null) {
                error.paramsMessages = a(asJsonObject2);
            } else {
                error.paramsMessages = a(jsonObject);
            }
        }
        return error;
    }
}
