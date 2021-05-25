package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/PretendTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/PretendResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/PretendResult;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PretendTypeAdapter implements JsonDeserializer<PretendResult> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public PretendResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Map map;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("success");
        boolean asBoolean = jsonElement2 != null ? jsonElement2.getAsBoolean() : false;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JsonElement jsonElement3 = I1.get("params");
        if (!(jsonElement3 == null || !jsonElement3.isJsonObject() || (map = (Map) jsonDeserializationContext.deserialize(jsonElement3, PretendTypeAdapterKt.access$getMAP_TYPE_TOKEN$p().getType())) == null)) {
            linkedHashMap.putAll(map);
        }
        JsonElement jsonElement4 = I1.get("slots");
        if (jsonElement4 != null && jsonElement4.isJsonObject()) {
            Map map2 = (Map) jsonDeserializationContext.deserialize(jsonElement4, PretendTypeAdapterKt.access$getSLOTS_MAP_TYPE_TOKEN$p().getType());
            for (String str : map2.keySet()) {
                Map map3 = (Map) map2.get(str);
                if (map3 != null) {
                    linkedHashMap.putAll(map3);
                }
            }
        }
        I1.remove("success");
        I1.remove("params");
        I1.remove("slots");
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        for (Map.Entry<String, JsonElement> entry : I1.entrySet()) {
            JsonElement value = entry.getValue();
            if (value instanceof JsonPrimitive) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                linkedHashMap.put(key, new PretendErrorValue.Message(((JsonPrimitive) value).getAsString()));
            }
        }
        return new PretendResult(asBoolean, linkedHashMap);
    }
}
