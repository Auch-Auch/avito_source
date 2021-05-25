package com.avito.android.webview.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/webview/models/WebViewInnerEventDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/webview/models/WebViewInnerEvent;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/webview/models/WebViewInnerEvent;", "<init>", "()V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewInnerEventDeserializer implements JsonDeserializer<WebViewInnerEvent> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public WebViewInnerEvent deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "json.asJsonObject");
        JsonElement jsonElement2 = asJsonObject.get("params");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"params\")");
        JsonObject asJsonObject2 = jsonElement2.getAsJsonObject();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : asJsonObject2.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            Object obj = null;
            try {
                NumberFormat instance = NumberFormat.getInstance();
                Intrinsics.checkNotNullExpressionValue(value, "value");
                JsonPrimitive asJsonPrimitive = value.getAsJsonPrimitive();
                Intrinsics.checkNotNullExpressionValue(asJsonPrimitive, "value.asJsonPrimitive");
                obj = instance.parse(asJsonPrimitive.getAsString());
            } catch (Exception unused) {
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (obj == null) {
                obj = jsonDeserializationContext.deserialize(jsonElement, Object.class);
                Intrinsics.checkNotNullExpressionValue(obj, "context.deserialize(json, Any::class.java)");
            }
            linkedHashMap.put(key, obj);
        }
        JsonElement jsonElement3 = asJsonObject.get("id");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject.get(\"id\")");
        int asInt = jsonElement3.getAsInt();
        JsonElement jsonElement4 = asJsonObject.get("version");
        Intrinsics.checkNotNullExpressionValue(jsonElement4, "jsonObject.get(\"version\")");
        return new WebViewInnerEvent(asInt, jsonElement4.getAsInt(), linkedHashMap);
    }
}
