package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AttributeNodeDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AttributeNodeDeserializer implements JsonDeserializer<AttributeNode> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AttributeNode deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.getAsJsonObject().get("value") instanceof JsonArray) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "json.asJsonObject");
            Object deserialize = jsonDeserializationContext.deserialize(asJsonObject, AttributeNode.ListNode.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
            return (AttributeNode) deserialize;
        }
        JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject2, "json.asJsonObject");
        Object deserialize2 = jsonDeserializationContext.deserialize(asJsonObject2, AttributeNode.StringNode.class);
        Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
        return (AttributeNode) deserialize2;
    }
}
