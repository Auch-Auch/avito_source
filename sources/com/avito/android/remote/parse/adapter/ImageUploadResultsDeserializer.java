package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageUploadResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ImageUploadResultsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/ImageUploadResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/ImageUploadResult;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadResultsDeserializer implements JsonDeserializer<ImageUploadResult> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public ImageUploadResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Set<Map.Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "json.asJsonObject\n            .entrySet()");
        Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.first(entrySet);
        if (entry == null) {
            return null;
        }
        Object key = entry.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "it.key");
        Object value = entry.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "it.value");
        Object deserialize = jsonDeserializationContext.deserialize((JsonElement) value, Image.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        return new ImageUploadResult((String) key, (Image) deserialize);
    }
}
