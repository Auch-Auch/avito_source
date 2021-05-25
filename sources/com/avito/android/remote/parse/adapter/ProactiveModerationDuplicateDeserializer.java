package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ProactiveModerationDuplicateDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Duplicate;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Duplicate;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ProactiveModerationDuplicateDeserializer implements JsonDeserializer<AdvertProactiveModerationResult.Duplicate> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AdvertProactiveModerationResult.Duplicate deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement, AdvertDuplicateResult.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        return new AdvertProactiveModerationResult.Duplicate((AdvertDuplicateResult) deserialize);
    }
}
